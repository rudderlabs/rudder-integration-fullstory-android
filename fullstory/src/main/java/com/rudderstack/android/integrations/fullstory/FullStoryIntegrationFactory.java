package com.rudderstack.android.integrations.fullstory;

import android.text.TextUtils;

import androidx.annotation.Nullable;

import com.fullstory.FS;
import com.rudderstack.android.sdk.core.MessageType;
import com.rudderstack.android.sdk.core.RudderClient;
import com.rudderstack.android.sdk.core.RudderConfig;
import com.rudderstack.android.sdk.core.RudderIntegration;
import com.rudderstack.android.sdk.core.RudderLogger;
import com.rudderstack.android.sdk.core.RudderMessage;

import java.util.HashMap;
import java.util.Map;


public class FullStoryIntegrationFactory extends RudderIntegration<RudderClient> {
    private static final String FULLSTORY_KEY = "Fullstory";
    
    public static Factory FACTORY = new Factory() {
        @Override
        public RudderIntegration<?> create(Object settings, RudderClient client, RudderConfig rudderConfig) {
            return new FullStoryIntegrationFactory();
        }

        @Override
        public String key() {
            return FULLSTORY_KEY;
        }
    };

    private FullStoryIntegrationFactory() {
    }

    @Override
    public void dump(@Nullable RudderMessage element) {
        try {
            if (element != null) {
                processRudderEvent(element);
            }
        } catch (Exception e) {
            RudderLogger.logError(e);
        }
    }

    private void processRudderEvent(RudderMessage element) {
        String type = element.getType();
        if (type != null) {
            switch (type) {
                case MessageType.IDENTIFY:
                    String userId = !TextUtils.isEmpty(element.getUserId()) ? element.getUserId() : element.getAnonymousId();
                    Map<String, Object> traits = new HashMap<>(element.getTraits());
                    if (!isEmpty(traits)){
                        traits.remove("userId");
                    }
                    FS.identify(userId, traits);
                    break;
                case MessageType.TRACK:
                    if (!TextUtils.isEmpty(element.getEventName())) {
                        FS.event(getTrimKey(element.getEventName()), element.getProperties());
                        return;
                    }
                    RudderLogger.logDebug("Event name is not present in the Track call. Hence, event not sent");
                    break;
                case MessageType.SCREEN:
                    if (!TextUtils.isEmpty(element.getEventName())) {
                        FS.event(getTrimKey("screen view " + element.getEventName()), element.getProperties());
                        return;
                    }
                    RudderLogger.logDebug("Event name is not present in the Screen call. Hence, event not sent");
                    break;
                default:
                    RudderLogger.logWarn("MessageType is not specified or supported");
                    break;
            }
        }
    }

    @Override
    public void reset() {
        FS.anonymize();
        RudderLogger.logVerbose("FS.anonymize();");
    }

    static String getTrimKey(String key) {
        // FullStory event names can be no longer than 250 characters.
        if (key.length() > 250) {
            key = key.substring(0, 250);
        }
        return key;
    }

    private boolean isEmpty(Map<String, Object> value) {
        return value == null || value.size() == 0;
    }

    @Override
    public RudderClient getUnderlyingInstance() {
        return null;
    }
}
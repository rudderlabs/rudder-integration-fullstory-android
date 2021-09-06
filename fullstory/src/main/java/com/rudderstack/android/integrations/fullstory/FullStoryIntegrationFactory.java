package com.rudderstack.android.integrations.fullstory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.rudderstack.android.sdk.core.MessageType;
import com.rudderstack.android.sdk.core.RudderClient;
import com.rudderstack.android.sdk.core.RudderConfig;
import com.rudderstack.android.sdk.core.RudderIntegration;
import com.rudderstack.android.sdk.core.RudderLogger;
import com.rudderstack.android.sdk.core.RudderMessage;


public class FullStoryIntegrationFactory extends RudderIntegration<RudderClient> {
    private static final String FULLSTORY_KEY = "Fullstory";
    
    public static Factory FACTORY = new Factory() {
        @Override
        public RudderIntegration<?> create(Object settings, RudderClient client, RudderConfig rudderConfig) {
            return new FullStoryIntegrationFactory(settings);
        }

        @Override
        public String key() {
            return FULLSTORY_KEY;
        }
    };

    private FullStoryIntegrationFactory(@NonNull Object config) {
        if (RudderClient.getApplication() == null) {
            RudderLogger.logError("Application is null. Aborting FullStory initialization.");
            return;
        }
    }

    private void processRudderEvent(RudderMessage element) {
        String type = element.getType();
        if (type != null) {
            switch (type) {
                case MessageType.IDENTIFY:
                    break;
                case MessageType.TRACK:
                    break;
                case MessageType.SCREEN:
                    break;
                case MessageType.GROUP:
                    break;
                case MessageType.ALIAS:
                    break;
                default:
                    RudderLogger.logWarn("MessageType is not specified or supported");
                    break;
            }
        }
    }

    @Override
    public void reset() {
        
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

    @Override
    public RudderClient getUnderlyingInstance() {
        return null;
    }
}
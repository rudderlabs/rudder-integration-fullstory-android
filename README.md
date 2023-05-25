# What is RudderStack?

[RudderStack](https://rudderstack.com/) is a **customer data pipeline** tool for collecting, routing and processing data from your websites, apps, cloud tools, and data warehouse.

More information on RudderStack can be found [here](https://github.com/rudderlabs/rudder-server).

## Integrating Fullstory for RudderStack's Android SDK

1. Add [Fullstory](https://www.fullstory.com/) as a destination in the [RudderStack dashboard](https://app.rudderstack.com/) and define the app secret key.

2. Add the following `dependencies` to your `app/build.gradle` file as shown:

```groovy
implementation 'com.rudderstack.android.sdk:core:[1.0,2.0)'
implementation 'com.rudderstack.android.integration:fullstory:1.0.1'
```

3. Add the following `dependencies` to your `app/build.gradle` file as shown:

```groovy
// FullStory
repositories {
    maven { url "https://maven.fullstory.com" }
}
implementation 'com.fullstory:instrumentation-full:1.37.1@aar'
```

4. Add the following `dependencies` to your `project/build.gradle` file as shown:

```groovy
buildscript {
    repositories {
        maven { url "https://maven.fullstory.com" }
    }
    dependencies {
        classpath 'com.fullstory:gradle-plugin-local:1.37.1'
    }
}
```

5. Finally change the initialization of your `RudderClient` in your `Application` class:

```groovy
val rudderClient = RudderClient.getInstance(
    this,
    "<YOUR_WRITE_KEY>",
    RudderConfig.Builder()
        .withDataPlaneUrl("<YOUR_DATA_PLANE_URL>")
        .withFactory(FullstoryIntegrationFactory.FACTORY)
        .build()
)
```

## Send Events

Follow the steps from the [RudderStack Android SDK](https://github.com/rudderlabs/rudder-sdk-android).

## Contact Us

If you come across any issues while configuring or using this integration, please feel free to start a conversation on our [Slack](https://resources.rudderstack.com/join-rudderstack-slack) channel. We will be happy to help you.

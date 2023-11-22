package io.split.android.client;

import com.google.common.base.Preconditions;

/* loaded from: classes6.dex */
public class ServiceEndpoints {
    private static final String AUTH_SERVICE_ENDPOINT = "https://auth.split.io/api/v2";
    private static final String EVENTS_ENDPOINT = "https://events.split.io/api";
    private static final String SDK_ENDPOINT = "https://sdk.split.io/api";
    private static final String STREAMING_SERVICE_ENDPOINT = "https://streaming.split.io/sse";
    private static final String TELEMETRY_SERVICE_ENDPOINT = "https://telemetry.split.io/api/v1";
    private String mAuthServiceEndpoint;
    private String mEventsEndpoint;
    private String mSdkEndpoint;
    private String mStreamingServiceEndpoint;
    private String mTelemetryServiceEndpoint;

    private ServiceEndpoints() {
        this.mSdkEndpoint = SDK_ENDPOINT;
        this.mEventsEndpoint = EVENTS_ENDPOINT;
        this.mAuthServiceEndpoint = AUTH_SERVICE_ENDPOINT;
        this.mStreamingServiceEndpoint = STREAMING_SERVICE_ENDPOINT;
        this.mTelemetryServiceEndpoint = TELEMETRY_SERVICE_ENDPOINT;
    }

    public String getSdkEndpoint() {
        return this.mSdkEndpoint;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSdkEndpoint(String str) {
        this.mSdkEndpoint = str;
    }

    public String getEventsEndpoint() {
        return this.mEventsEndpoint;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEventsEndpoint(String str) {
        this.mEventsEndpoint = str;
    }

    public String getAuthServiceEndpoint() {
        return this.mAuthServiceEndpoint;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthServiceEndpoint(String str) {
        this.mAuthServiceEndpoint = str;
    }

    public String getStreamingServiceEndpoint() {
        return this.mStreamingServiceEndpoint;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStreamingServiceEndpoint(String str) {
        this.mStreamingServiceEndpoint = str;
    }

    public void setTelemetryServiceEndpoint(String str) {
        this.mTelemetryServiceEndpoint = str;
    }

    public String getTelemetryEndpoint() {
        return this.mTelemetryServiceEndpoint;
    }

    public static Builder builder() {
        return new Builder();
    }

    /* loaded from: classes6.dex */
    public static class Builder {
        ServiceEndpoints mServiceEndpoints = new ServiceEndpoints();

        protected Builder() {
        }

        public Builder apiEndpoint(String str) {
            this.mServiceEndpoints.setSdkEndpoint((String) Preconditions.checkNotNull(str));
            return this;
        }

        public Builder eventsEndpoint(String str) {
            this.mServiceEndpoints.setEventsEndpoint((String) Preconditions.checkNotNull(str));
            return this;
        }

        public Builder sseAuthServiceEndpoint(String str) {
            this.mServiceEndpoints.setAuthServiceEndpoint((String) Preconditions.checkNotNull(str));
            return this;
        }

        public Builder streamingServiceEndpoint(String str) {
            this.mServiceEndpoints.setStreamingServiceEndpoint((String) Preconditions.checkNotNull(str));
            return this;
        }

        public Builder telemetryServiceEndpoint(String str) {
            this.mServiceEndpoints.setTelemetryServiceEndpoint((String) Preconditions.checkNotNull(str));
            return this;
        }

        public ServiceEndpoints build() {
            return this.mServiceEndpoints;
        }
    }

    /* loaded from: classes6.dex */
    public static class EndpointValidator {
        public static boolean sdkEndpointIsOverridden(String str) {
            return !ServiceEndpoints.SDK_ENDPOINT.equals(str);
        }

        public static boolean eventsEndpointIsOverridden(String str) {
            return !ServiceEndpoints.EVENTS_ENDPOINT.equals(str);
        }

        public static boolean streamingEndpointIsOverridden(String str) {
            return !ServiceEndpoints.STREAMING_SERVICE_ENDPOINT.equals(str);
        }

        public static boolean authEndpointIsOverridden(String str) {
            return !ServiceEndpoints.AUTH_SERVICE_ENDPOINT.equals(str);
        }

        public static boolean telemetryEndpointIsOverridden(String str) {
            return !ServiceEndpoints.TELEMETRY_SERVICE_ENDPOINT.equals(str);
        }
    }
}

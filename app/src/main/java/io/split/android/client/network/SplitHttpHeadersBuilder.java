package io.split.android.client.network;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class SplitHttpHeadersBuilder {
    private static final String ABLY_CLIENT_KEY = "SplitSDKClientKey";
    private static final int ABLY_CLIENT_KEY_LENGTH = 4;
    private static final String ACCEPT_TYPE_HEADER = "Accept";
    private static final String AUTHORIZATION = "Authorization";
    public static final String CACHE_CONTROL_HEADER = "Cache-Control";
    public static final String CACHE_CONTROL_NO_CACHE = "no-cache";
    private static final String CLIENT_MACHINE_IP_HEADER = "SplitSDKMachineIP";
    private static final String CLIENT_MACHINE_NAME_HEADER = "SplitSDKMachineName";
    private static final String CLIENT_VERSION = "SplitSDKVersion";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String CONTENT_TYPE_JSON = "application/json";
    private static final String CONTENT_TYPE_STREAM = "text/event-stream";
    private static final Map<String, String> noCacheHeaders;
    Map<String, String> mHeaders = new HashMap();

    static {
        HashMap hashMap = new HashMap();
        noCacheHeaders = hashMap;
        hashMap.put("Cache-Control", CACHE_CONTROL_NO_CACHE);
    }

    public SplitHttpHeadersBuilder addJsonTypeHeaders() {
        this.mHeaders.put("Content-Type", "application/json");
        this.mHeaders.put("Accept", "application/json");
        return this;
    }

    public SplitHttpHeadersBuilder addStreamingTypeHeaders() {
        this.mHeaders.put("Content-Type", CONTENT_TYPE_STREAM);
        return this;
    }

    public SplitHttpHeadersBuilder setApiToken(String str) {
        Map<String, String> map = this.mHeaders;
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        sb.append(str);
        map.put("Authorization", sb.toString());
        return this;
    }

    public SplitHttpHeadersBuilder setAblyApiToken(String str) {
        this.mHeaders.put(ABLY_CLIENT_KEY, str.substring(str.length() - 4));
        return this;
    }

    public SplitHttpHeadersBuilder setHostname(String str) {
        if (str != null) {
            this.mHeaders.put(CLIENT_MACHINE_NAME_HEADER, str);
        }
        return this;
    }

    public SplitHttpHeadersBuilder setHostIp(String str) {
        if (str != null) {
            this.mHeaders.put(CLIENT_MACHINE_IP_HEADER, str);
        }
        return this;
    }

    public SplitHttpHeadersBuilder setClientVersion(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Client Version Http Header cannot be null!");
        }
        this.mHeaders.put(CLIENT_VERSION, str);
        return this;
    }

    public Map<String, String> build() {
        if (this.mHeaders.get("Content-Type") == null) {
            throw new IllegalArgumentException("Missing CONTENT TYPE header!");
        }
        if (this.mHeaders.get("Content-Type").equals("application/json")) {
            if (this.mHeaders.get("Authorization") == null) {
                throw new IllegalArgumentException("Missing authorization header!");
            }
            if (this.mHeaders.get(CLIENT_VERSION) == null) {
                throw new IllegalArgumentException("Missing client version header!");
            }
        } else if (this.mHeaders.get("Content-Type").equals(CONTENT_TYPE_STREAM)) {
            if (this.mHeaders.get(ABLY_CLIENT_KEY) == null) {
                throw new IllegalArgumentException("Missing ably key header!");
            }
        } else {
            throw new IllegalArgumentException("Invalid CONTENT TYPE header!");
        }
        return this.mHeaders;
    }

    public static Map<String, String> noCacheHeaders() {
        return noCacheHeaders;
    }
}

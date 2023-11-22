package com.iap.ac.android.gol.google.model;

import java.io.Serializable;

/* loaded from: classes8.dex */
public class DecryptedMessage implements Serializable {
    public String associationId;
    public RequestHeader requestHeader;

    /* loaded from: classes8.dex */
    public static class ProtocolVersion {
    }

    /* loaded from: classes8.dex */
    public static class RequestHeader {
        public ProtocolVersion protocolVersion;
        public String requestId;
        public String requestTimestamp;
    }

    public String getRequestId() {
        RequestHeader requestHeader = this.requestHeader;
        return requestHeader != null ? requestHeader.requestId : "";
    }
}

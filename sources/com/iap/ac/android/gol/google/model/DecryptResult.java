package com.iap.ac.android.gol.google.model;

import com.iap.ac.android.gol.google.model.DecryptedMessage;

/* loaded from: classes8.dex */
public class DecryptResult extends BaseResult {
    public String associationId;
    public DecryptedMessage.RequestHeader requestHeader;

    /* loaded from: classes8.dex */
    public static class ProtocolVersion {
    }

    /* loaded from: classes8.dex */
    public static class RequestHeader {
        public DecryptedMessage.ProtocolVersion protocolVersion;
        public String requestId;
        public String requestTimestamp;
    }

    public String getRequestId() {
        DecryptedMessage.RequestHeader requestHeader = this.requestHeader;
        return requestHeader != null ? requestHeader.requestId : "";
    }
}

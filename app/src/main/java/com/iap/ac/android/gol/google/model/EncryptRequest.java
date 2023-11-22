package com.iap.ac.android.gol.google.model;

import java.io.Serializable;

/* loaded from: classes8.dex */
public class EncryptRequest implements Serializable {
    public Abandoned abandoned;
    public ErrorResponse errorResponse;
    public String redirectRequestId;
    public String referenceMerchantId = "3200000A50000001";
    public Success success;

    /* loaded from: classes8.dex */
    public static class Abandoned {
    }

    /* loaded from: classes8.dex */
    public static class ErrorResponse {
        public String errorDescription;
        public String errorResponseCode;
    }

    /* loaded from: classes8.dex */
    public static class Success {
    }
}

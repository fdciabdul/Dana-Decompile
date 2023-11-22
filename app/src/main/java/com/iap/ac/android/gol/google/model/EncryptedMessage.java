package com.iap.ac.android.gol.google.model;

import java.io.Serializable;

/* loaded from: classes8.dex */
public class EncryptedMessage implements Serializable {
    public Abandoned abandoned;
    public ErrorResponse errorResponse;
    public String redirectRequestId;
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

package com.alipay.android.phone.mobilesdk.socketcraft.exceptions;

/* loaded from: classes6.dex */
public class IncompleteHandshakeException extends RuntimeException {
    private static final long serialVersionUID = 7906596804233893092L;
    private int newsize;

    public IncompleteHandshakeException(int i) {
        this.newsize = i;
    }

    public IncompleteHandshakeException() {
        this.newsize = 0;
    }

    public int getPreferedSize() {
        return this.newsize;
    }
}

package com.bumptech.glide.load;

import java.io.IOException;

/* loaded from: classes3.dex */
public final class HttpException extends IOException {
    public static final int UNKNOWN = -1;
    private static final long serialVersionUID = 1;
    private final int statusCode;

    public HttpException(int i) {
        this("Http request failed", i);
    }

    @Deprecated
    public HttpException(String str) {
        this(str, -1);
    }

    public HttpException(String str, int i) {
        this(str, i, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HttpException(java.lang.String r2, int r3, java.lang.Throwable r4) {
        /*
            r1 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            java.lang.String r2 = ", status code: "
            r0.append(r2)
            r0.append(r3)
            java.lang.String r2 = r0.toString()
            r1.<init>(r2, r4)
            r1.statusCode = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.HttpException.<init>(java.lang.String, int, java.lang.Throwable):void");
    }

    public final int getStatusCode() {
        return this.statusCode;
    }
}

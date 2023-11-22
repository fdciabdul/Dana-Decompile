package okhttp3.internal.http2;

import java.io.IOException;

/* loaded from: classes6.dex */
public final class StreamResetException extends IOException {
    public final ErrorCode errorCode;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public StreamResetException(okhttp3.internal.http2.ErrorCode r3) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "stream was reset: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            r2.errorCode = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.StreamResetException.<init>(okhttp3.internal.http2.ErrorCode):void");
    }
}

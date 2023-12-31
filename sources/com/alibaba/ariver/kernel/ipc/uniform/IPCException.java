package com.alibaba.ariver.kernel.ipc.uniform;

import java.io.IOException;

/* loaded from: classes6.dex */
public class IPCException extends IOException {
    public int errorCode;
    public String errorMsg;

    public IPCException() {
    }

    public IPCException(String str) {
        super(str);
    }

    public IPCException(String str, Throwable th) {
        super(str, th);
    }

    public IPCException(Throwable th) {
        super(th);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public IPCException(int r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "errorCode:"
            r0.append(r1)
            r0.append(r3)
            java.lang.String r1 = " errorMsg:"
            r0.append(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            r2.errorCode = r3
            r2.errorMsg = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.ipc.uniform.IPCException.<init>(int, java.lang.String):void");
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IPCException{errorCode=");
        sb.append(this.errorCode);
        sb.append(", errorMsg='");
        sb.append(this.errorMsg);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}

package com.alipay.plus.security.lite;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: classes3.dex */
public class SecLiteException extends Exception {
    public static final int ERROR_API_KEY_OR_SIGN = -101;
    public static final int ERROR_NULL_CONTEXT = -100;
    public int errorCode;
    public static SecLiteException ENCRYPT_PARAMS_ERROR = new SecLiteException("Params error", 201);
    public static SecLiteException ENCRYPT_INTERNAL_ERROR = new SecLiteException("Internal encrypt error", 202);
    public static SecLiteException DECRYPT_INTERNAL_ERROR = new SecLiteException("Internal decrypt error", 203);
    public static SecLiteException UNKNOWN_ERROR = new SecLiteException("Unknown error", 204);

    public SecLiteException(int i) {
        this.errorCode = i;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        StringBuilder sb = new StringBuilder();
        sb.append("ErrorCode = ");
        sb.append(getErrorCode());
        printStream.println(sb.toString());
        super.printStackTrace(printStream);
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public SecLiteException(String str, int i) {
        super(str);
        this.errorCode = i;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        StringBuilder sb = new StringBuilder();
        sb.append("ErrorCode = ");
        sb.append(getErrorCode());
        printWriter.println(sb.toString());
        super.printStackTrace(printWriter);
    }

    public SecLiteException(Throwable th, int i) {
        super(th);
        this.errorCode = i;
    }

    public SecLiteException(String str, Throwable th, int i) {
        super(str, th);
        this.errorCode = i;
    }
}

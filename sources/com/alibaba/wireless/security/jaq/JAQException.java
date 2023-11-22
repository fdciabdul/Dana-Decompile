package com.alibaba.wireless.security.jaq;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: classes6.dex */
public class JAQException extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private int f6804a;

    public JAQException(int i) {
        this.f6804a = i;
    }

    public JAQException(String str, int i) {
        super(str);
        this.f6804a = i;
    }

    public JAQException(String str, Throwable th, int i) {
        super(str, th);
        this.f6804a = i;
    }

    public JAQException(Throwable th, int i) {
        super(th);
        this.f6804a = i;
    }

    public int getErrorCode() {
        return this.f6804a;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        StringBuilder sb = new StringBuilder();
        sb.append("ErrorCode = ");
        sb.append(getErrorCode());
        printStream.println(sb.toString());
        super.printStackTrace(printStream);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        StringBuilder sb = new StringBuilder();
        sb.append("ErrorCode = ");
        sb.append(getErrorCode());
        printWriter.println(sb.toString());
        super.printStackTrace(printWriter);
    }

    public void setErrorCode(int i) {
        this.f6804a = i;
    }
}

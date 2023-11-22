package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: classes8.dex */
public class cd extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private cm f7744a;

    /* renamed from: a  reason: collision with other field name */
    private cn f84a;

    /* renamed from: a  reason: collision with other field name */
    private Throwable f85a;

    public cd() {
        this.f7744a = null;
        this.f84a = null;
        this.f85a = null;
    }

    public cd(cm cmVar) {
        this.f84a = null;
        this.f85a = null;
        this.f7744a = cmVar;
    }

    public cd(String str) {
        super(str);
        this.f7744a = null;
        this.f84a = null;
        this.f85a = null;
    }

    public cd(String str, Throwable th) {
        super(str);
        this.f7744a = null;
        this.f84a = null;
        this.f85a = th;
    }

    public cd(Throwable th) {
        this.f7744a = null;
        this.f84a = null;
        this.f85a = th;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        cm cmVar;
        cn cnVar;
        String message = super.getMessage();
        return (message != null || (cnVar = this.f84a) == null) ? (message != null || (cmVar = this.f7744a) == null) ? message : cmVar.toString() : cnVar.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f85a != null) {
            printStream.println("Nested Exception: ");
            this.f85a.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f85a != null) {
            printWriter.println("Nested Exception: ");
            this.f85a.printStackTrace(printWriter);
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(": ");
        }
        cn cnVar = this.f84a;
        if (cnVar != null) {
            sb.append(cnVar);
        }
        cm cmVar = this.f7744a;
        if (cmVar != null) {
            sb.append(cmVar);
        }
        if (this.f85a != null) {
            sb.append("\n  -- caused by: ");
            sb.append(this.f85a);
        }
        return sb.toString();
    }
}

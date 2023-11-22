package com.alipay.mobile.jsengine.v8;

import id.dana.cashier.view.InputCardNumberView;

/* loaded from: classes6.dex */
public abstract class V8ScriptException extends V8RuntimeException {
    private final int endColumn;
    private final String fileName;
    private final String jsMessage;
    private final String jsStackTrace;
    private final int lineNumber;
    private final String sourceLine;
    private final int startColumn;

    /* JADX INFO: Access modifiers changed from: protected */
    public V8ScriptException(String str, int i, String str2, String str3, int i2, int i3, String str4, Throwable th) {
        this.fileName = str;
        this.lineNumber = i;
        this.jsMessage = str2;
        this.sourceLine = str3;
        this.startColumn = i2;
        this.endColumn = i3;
        this.jsStackTrace = str4;
        if (th != null) {
            initCause(th);
        }
    }

    public String getJSStackTrace() {
        return this.jsStackTrace;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public int getStartColumn() {
        return this.startColumn;
    }

    public int getEndColumn() {
        return this.endColumn;
    }

    public String getSourceLine() {
        return this.sourceLine;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(createMessageLine());
        sb.append(createMessageDetails());
        sb.append(createJSStackDetails());
        sb.append("\n");
        sb.append(getClass().getName());
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return createMessageLine();
    }

    public String getJSMessage() {
        return this.jsMessage;
    }

    private String createMessageLine() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.fileName);
        sb.append(":");
        sb.append(this.lineNumber);
        sb.append("[");
        sb.append(this.startColumn);
        sb.append(",");
        sb.append(this.endColumn);
        sb.append("]: ");
        sb.append(this.jsMessage);
        return sb.toString();
    }

    private String createJSStackDetails() {
        if (this.jsStackTrace != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            sb.append(this.jsStackTrace);
            return sb.toString();
        }
        return "";
    }

    private String createMessageDetails() {
        StringBuilder sb = new StringBuilder();
        String str = this.sourceLine;
        if (str != null && !str.isEmpty()) {
            sb.append('\n');
            sb.append(this.sourceLine);
            sb.append('\n');
            int i = this.startColumn;
            if (i >= 0) {
                sb.append(createCharSequence(i, InputCardNumberView.DIVIDER));
                sb.append(createCharSequence(this.endColumn - this.startColumn, '^'));
            }
        }
        return sb.toString();
    }

    private char[] createCharSequence(int i, char c) {
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = c;
        }
        return cArr;
    }
}

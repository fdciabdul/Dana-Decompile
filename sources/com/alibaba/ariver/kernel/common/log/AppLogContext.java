package com.alibaba.ariver.kernel.common.log;

/* loaded from: classes3.dex */
public class AppLogContext {

    /* renamed from: a  reason: collision with root package name */
    private final PageSource f6131a = new PageSource();
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private String h;

    public String getPageLogToken() {
        return this.h;
    }

    public PageSource getPageSource() {
        return this.f6131a;
    }

    public void setPageLogToken(String str) {
        this.h = str;
    }

    public boolean hasResourceError() {
        return this.b;
    }

    public void setHasResourceError(boolean z) {
        this.b = z;
    }

    public boolean hasJSAPIError() {
        return this.c;
    }

    public void setHasJSAPIError(boolean z) {
        this.c = z;
    }

    public boolean hasJSError() {
        return this.d;
    }

    public void setHasJSError(boolean z) {
        this.d = z;
    }

    public boolean hasWhiteScreen() {
        return this.e;
    }

    public void setHasWhiteScreen(boolean z) {
        this.e = z;
    }

    public boolean hasScreenShot() {
        return this.f;
    }

    public void setHasScreenShot(boolean z) {
        this.f = z;
    }

    public boolean isAlreadyRecordTagLog() {
        return this.g;
    }

    public void setAlreadyRecordTagLog(boolean z) {
        this.g = z;
    }
}

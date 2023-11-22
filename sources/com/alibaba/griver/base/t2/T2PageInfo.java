package com.alibaba.griver.base.t2;

import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class T2PageInfo {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6383a;
    private boolean b;
    private Map<String, SendToRenderCallback> c = new HashMap();
    private List<String> d = new ArrayList();
    private List<String> e = new ArrayList();
    private boolean f = false;

    public T2PageInfo(boolean z, boolean z2) {
        this.f6383a = z;
        this.b = z2;
    }

    public boolean isPageT2Switch() {
        return this.f6383a;
    }

    public void setPageT2Switch(boolean z) {
        this.f6383a = z;
    }

    public boolean isWaiting() {
        return this.b;
    }

    public void setWaiting(boolean z) {
        this.b = z;
    }

    public void putRenderCallback(String str, SendToRenderCallback sendToRenderCallback) {
        if (this.c.size() > 10) {
            this.c.clear();
        }
        this.c.put(str, sendToRenderCallback);
    }

    public SendToRenderCallback takeRenderCallback(String str) {
        return this.c.remove(str);
    }

    public List<String> getInjectUrls() {
        return this.e;
    }

    public List<String> getPreInjectUrls() {
        return this.d;
    }

    public void clearCallbacks() {
        this.c.clear();
    }

    public void setHasInjectPreload(boolean z) {
        this.f = z;
    }

    public boolean hasInjectPreload() {
        return this.f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("T2PageInfo{mPageT2Switch=");
        sb.append(this.f6383a);
        sb.append(", mWaiting=");
        sb.append(this.b);
        sb.append(", mCallbacks=");
        sb.append(this.c);
        sb.append(", preInjectUrlsSize=");
        sb.append(this.d.size());
        sb.append(", injectUrlsSize");
        sb.append(this.e.size());
        sb.append(", hasInjectPreload=");
        sb.append(this.f);
        sb.append('}');
        return sb.toString();
    }
}

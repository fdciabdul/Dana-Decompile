package com.alibaba.ariver.kernel.common.network.download;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class RVDownloadRequest {

    /* renamed from: a  reason: collision with root package name */
    private String f6146a;
    private String b;
    private String c;
    private boolean d;
    private Map<String, String> e;

    public String getDownloadDir() {
        return this.b;
    }

    public void setDownloadDir(String str) {
        this.b = str;
    }

    public String getDownloadFileName() {
        return this.c;
    }

    public void setDownloadFileName(String str) {
        this.c = str;
    }

    public Map<String, String> getTags() {
        if (this.e == null) {
            this.e = new ConcurrentHashMap();
        }
        return this.e;
    }

    public String getDownloadUrl() {
        return this.f6146a;
    }

    public void setDownloadUrl(String str) {
        this.f6146a = str;
    }

    public boolean isUrgentResource() {
        return this.d;
    }

    public void setIsUrgentResource(boolean z) {
        this.d = z;
    }
}

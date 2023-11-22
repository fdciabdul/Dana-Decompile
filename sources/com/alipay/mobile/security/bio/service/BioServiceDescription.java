package com.alipay.mobile.security.bio.service;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class BioServiceDescription {
    Class<?> clazz = null;
    String interfaceName = "";
    boolean isLazy = false;
    boolean autoDownloadRes = false;
    protected Map<String, String> extMetaInfo = new HashMap();

    public Class<?> getClazz() {
        return this.clazz;
    }

    public void setClazz(Class<?> cls) {
        this.clazz = cls;
    }

    public String getInterfaceName() {
        return this.interfaceName;
    }

    public void setInterfaceName(String str) {
        this.interfaceName = str;
    }

    public boolean isLazy() {
        return this.isLazy;
    }

    public void setLazy(boolean z) {
        this.isLazy = z;
    }

    public boolean isAutoDownloadRes() {
        return this.autoDownloadRes;
    }

    public void setAutoDownloadRes(boolean z) {
        this.autoDownloadRes = z;
    }

    public Map<String, String> getExtMetaInfo() {
        return this.extMetaInfo;
    }

    public void setExtMetaInfo(Map<String, String> map) {
        this.extMetaInfo = map;
    }
}

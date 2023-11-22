package com.alibaba.griver.api.model;

import java.io.Serializable;
import java.util.Map;

/* loaded from: classes6.dex */
public class APIContext implements Serializable {
    public Map<String, String> extendedInfo;
    public MiniProgramMetaData miniProgramInfo;
    public String source;

    public APIContext(String str, MiniProgramMetaData miniProgramMetaData, Map<String, String> map) {
        this.source = str;
        this.miniProgramInfo = miniProgramMetaData;
        this.extendedInfo = map;
    }

    public APIContext(String str, Map<String, String> map) {
        this(str, null, map);
    }

    public APIContext(String str) {
        this(str, null, null);
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public MiniProgramMetaData getMiniProgramInfo() {
        return this.miniProgramInfo;
    }

    public void setMiniProgramInfo(MiniProgramMetaData miniProgramMetaData) {
        this.miniProgramInfo = miniProgramMetaData;
    }

    public Map<String, String> getExtendedInfo() {
        return this.extendedInfo;
    }

    public void setExtendedInfo(Map<String, String> map) {
        this.extendedInfo = map;
    }
}

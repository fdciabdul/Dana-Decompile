package com.iap.ac.android.acs.plugin.downgrade.jsapi;

import java.util.List;

/* loaded from: classes3.dex */
public class JSAPIRegisterBean {
    public static final String BLACK_LIST = "BLACK_LIST";
    public static final String NOT_CONFIG = "NOT_CONFIG";
    public static final String WHITE_LIST = "WHITE_LIST";
    public List<String> registerList;
    public String tag;

    public JSAPIRegisterBean(String str, List<String> list) {
        this.tag = str;
        this.registerList = list;
    }
}

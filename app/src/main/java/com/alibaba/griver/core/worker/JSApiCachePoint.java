package com.alibaba.griver.core.worker;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public interface JSApiCachePoint extends Extension {
    public static final String GET_LOCAL_STORAGE = "getTinyLocalStorage";
    public static final String GET_SYSTEM_INFO = "getSystemInfo";
    public static final String GET_USER_INFO = "getUserInfo";

    JSONObject getJsapiCacheData(String str, String str2, App app);
}

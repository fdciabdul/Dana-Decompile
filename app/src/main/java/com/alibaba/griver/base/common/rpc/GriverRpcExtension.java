package com.alibaba.griver.base.common.rpc;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.GriverExtension;
import java.util.Map;

/* loaded from: classes3.dex */
public interface GriverRpcExtension extends GriverExtension {
    <T> T getFacade(Class<T> cls);

    JSONObject invokeACRpc(String str, String str2, String str3, Map<String, String> map);

    JSONObject invokeRpc(String str, String str2, String str3, Map<String, String> map);
}

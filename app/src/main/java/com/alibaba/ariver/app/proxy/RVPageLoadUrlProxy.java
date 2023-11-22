package com.alibaba.ariver.app.proxy;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public interface RVPageLoadUrlProxy extends Proxiable {
    public static final int LOAD_TYPE_SYNC_MAIN_DOC_IFRAME = 1;

    String loadUrlDirectly(Page page, JSONObject jSONObject, String str, int i);
}

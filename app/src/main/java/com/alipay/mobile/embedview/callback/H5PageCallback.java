package com.alipay.mobile.embedview.callback;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public class H5PageCallback extends H5JsCallback<Page> {
    public H5PageCallback() {
    }

    public H5PageCallback(Page page) {
        super(page);
    }

    @Override // com.alipay.mobile.embedview.callback.H5JsCallback
    public boolean sendToWeb(String str, JSONObject jSONObject) {
        if (this.mProxy != 0) {
            EngineUtils.sendToRender(((Page) this.mProxy).getRender(), str, jSONObject, null);
        }
        return super.sendToWeb(str, jSONObject);
    }
}

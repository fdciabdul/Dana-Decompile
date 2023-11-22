package com.alibaba.griver.core.h5;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.core.ui.GriverPage;
import com.alibaba.griver.h5.api.GriverSessionDataPoint;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class GriverSessionDataExtension implements NodeAware<Page>, GriverSessionDataPoint {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Page> f6410a;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<Page> weakReference) {
        this.f6410a = weakReference;
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<Page> getNodeType() {
        return Page.class;
    }

    @Override // com.alibaba.griver.h5.api.GriverSessionDataPoint
    public void setData(JSONObject jSONObject) {
        WeakReference<Page> weakReference = this.f6410a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        Page page = this.f6410a.get();
        if (!(page instanceof GriverPage) || jSONObject == null) {
            return;
        }
        for (String str : jSONObject.keySet()) {
            ((GriverPage) page).getData().set(str, jSONObject.getString(str));
        }
    }

    @Override // com.alibaba.griver.h5.api.GriverSessionDataPoint
    public JSONObject getData(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        WeakReference<Page> weakReference = this.f6410a;
        if (weakReference != null && weakReference.get() != null) {
            Page page = this.f6410a.get();
            if (page instanceof GriverPage) {
                for (int i = 0; i < jSONArray.size(); i++) {
                    String string = jSONArray.getString(i);
                    jSONObject.put(string, (Object) ((GriverPage) page).getData().get(string));
                }
            }
        }
        return jSONObject;
    }
}

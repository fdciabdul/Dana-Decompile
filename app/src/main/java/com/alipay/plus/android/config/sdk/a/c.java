package com.alipay.plus.android.config.sdk.a;

import com.alibaba.fastjson.JSONObject;
import com.alipay.plus.android.config.sdk.listener.sectionconfig.ChangedDetails;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public abstract class c<Listener> {

    /* renamed from: a  reason: collision with root package name */
    protected Map<String, List<Listener>> f7361a = new HashMap();

    public void a() {
        synchronized (this) {
            this.f7361a.clear();
        }
    }

    public void a(Listener listener) {
        synchronized (this) {
            if (listener == null) {
                return;
            }
            Iterator<List<Listener>> it = this.f7361a.values().iterator();
            while (it.hasNext()) {
                it.next().remove(listener);
            }
        }
    }

    public abstract void a(String str, JSONObject jSONObject, ChangedDetails changedDetails);

    public void a(String str, Listener listener) {
        synchronized (this) {
            if (listener == null) {
                return;
            }
            List<Listener> list = this.f7361a.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.f7361a.put(str, list);
            }
            list.add(listener);
        }
    }
}

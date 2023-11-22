package com.iap.ac.config.lite.d;

import com.iap.ac.config.lite.listener.sectionconfig.ChangedDetails;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class c<Listener> {

    /* renamed from: a  reason: collision with root package name */
    protected volatile Map<String, List<Listener>> f7630a = new HashMap();

    public void a(String str, Listener listener) {
        synchronized (this) {
            if (listener == null) {
                return;
            }
            List<Listener> list = this.f7630a.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.f7630a.put(str, list);
            }
            list.add(listener);
        }
    }

    public abstract void a(String str, JSONObject jSONObject, ChangedDetails changedDetails);

    public void a(Listener listener) {
        synchronized (this) {
            if (listener == null) {
                return;
            }
            Iterator<List<Listener>> it = this.f7630a.values().iterator();
            while (it.hasNext()) {
                it.next().remove(listener);
            }
        }
    }

    public void a() {
        synchronized (this) {
            this.f7630a.clear();
        }
    }
}

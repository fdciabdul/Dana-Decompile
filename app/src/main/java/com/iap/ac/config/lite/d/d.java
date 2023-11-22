package com.iap.ac.config.lite.d;

import android.text.TextUtils;
import com.iap.ac.config.lite.ConfigOverwriteInterceptor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private List<ConfigOverwriteInterceptor> f7631a = new LinkedList();
    private Map<String, List<ConfigOverwriteInterceptor>> b = new HashMap();

    private boolean b(String str) {
        return TextUtils.isEmpty(str) || TextUtils.equals(str, "config");
    }

    public void a(String str, ConfigOverwriteInterceptor configOverwriteInterceptor) {
        synchronized (this) {
            if (configOverwriteInterceptor == null) {
                return;
            }
            if (b(str)) {
                this.f7631a.add(configOverwriteInterceptor);
                return;
            }
            List<ConfigOverwriteInterceptor> list = this.b.get(str);
            if (list == null) {
                list = new LinkedList<>();
                this.b.put(str, list);
            }
            list.add(configOverwriteInterceptor);
        }
    }

    public void a(ConfigOverwriteInterceptor configOverwriteInterceptor) {
        synchronized (this) {
            this.f7631a.remove(configOverwriteInterceptor);
            Iterator<List<ConfigOverwriteInterceptor>> it = this.b.values().iterator();
            while (it.hasNext()) {
                it.next().remove(configOverwriteInterceptor);
            }
        }
    }

    public void a() {
        synchronized (this) {
            this.f7631a.clear();
            this.b.clear();
        }
    }

    public boolean a(String str) {
        synchronized (this) {
            if (b(str)) {
                return !this.f7631a.isEmpty();
            }
            List<ConfigOverwriteInterceptor> list = this.b.get(str);
            return (list == null || list.isEmpty()) ? false : true;
        }
    }

    public boolean a(String str, String str2, Object obj, Object obj2) {
        List<ConfigOverwriteInterceptor> list;
        synchronized (this) {
            if (b(str)) {
                str = null;
                list = this.f7631a;
            } else {
                list = this.b.get(str);
            }
            if (list == null) {
                return true;
            }
            Iterator<ConfigOverwriteInterceptor> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().shouldUpdateConfig(str, str2, obj, obj2)) {
                    return false;
                }
            }
            return true;
        }
    }
}

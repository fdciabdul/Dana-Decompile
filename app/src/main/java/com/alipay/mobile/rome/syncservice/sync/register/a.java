package com.alipay.mobile.rome.syncservice.sync.register;

import com.alipay.mobile.rome.syncservice.sync.register.Biz;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    static final String f7305a = "a";
    private static a k;
    public ConcurrentHashMap<String, Biz> b = new ConcurrentHashMap<>();
    public ConcurrentHashMap<Integer, Biz> c = new ConcurrentHashMap<>();
    public List<String> d = new ArrayList();
    public List<String> e = new ArrayList();
    public List<Integer> f = new ArrayList();
    public List<Integer> g = new ArrayList();
    public List<Integer> h = new ArrayList();
    public List<Integer> i = new ArrayList();
    public b j;

    private a() {
        b a2 = b.a();
        this.j = a2;
        Map<String, Biz> b = a2.b();
        if (b == null) {
            com.alipay.mobile.rome.syncsdk.util.c.a(f7305a, "initBizInfo xml is empty or something error!");
        } else {
            try {
                a(b);
            } catch (Exception e) {
                String str = f7305a;
                StringBuilder sb = new StringBuilder("initBizInfo map transfer error: ");
                sb.append(e);
                com.alipay.mobile.rome.syncsdk.util.c.d(str, sb.toString());
            }
        }
        b();
    }

    public static a a() {
        if (k == null) {
            synchronized (a.class) {
                if (k == null) {
                    k = new a();
                }
            }
        }
        return k;
    }

    public final Biz a(Integer num) {
        return this.c.get(num);
    }

    public final String b(Integer num) {
        ConcurrentHashMap<Integer, Biz> concurrentHashMap = this.c;
        if (concurrentHashMap == null) {
            return null;
        }
        Biz biz = concurrentHashMap.get(num);
        if (biz == null) {
            String str = f7305a;
            StringBuilder sb = new StringBuilder("getBizName index[");
            sb.append(num);
            sb.append("] no relevant bizName found.");
            com.alipay.mobile.rome.syncsdk.util.c.d(str, sb.toString());
            return "";
        }
        return biz.f7304a;
    }

    public final Integer a(String str) {
        ConcurrentHashMap<String, Biz> concurrentHashMap = this.b;
        if (concurrentHashMap == null) {
            return null;
        }
        Biz biz = concurrentHashMap.get(str);
        if (biz == null) {
            String str2 = f7305a;
            StringBuilder sb = new StringBuilder("getBizIndex name[");
            sb.append(str);
            sb.append("] no relevant bizIndex found.");
            com.alipay.mobile.rome.syncsdk.util.c.d(str2, sb.toString());
            return -1;
        }
        return biz.b;
    }

    public final Biz.BizDimeEnum b(String str) {
        ConcurrentHashMap<String, Biz> concurrentHashMap = this.b;
        if (concurrentHashMap == null) {
            return Biz.BizDimeEnum.NULL;
        }
        Biz biz = concurrentHashMap.get(str);
        if (biz == null) {
            String str2 = f7305a;
            StringBuilder sb = new StringBuilder("getBizDime name[");
            sb.append(str);
            sb.append("] no relevant bizDime found.");
            com.alipay.mobile.rome.syncsdk.util.c.d(str2, sb.toString());
            return Biz.BizDimeEnum.NULL;
        }
        return biz.f;
    }

    private void b() {
        Iterator<Biz> it = this.c.values().iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    private void a(Map<String, Biz> map) {
        Biz value;
        if (map == null) {
            return;
        }
        String str = f7305a;
        StringBuilder sb = new StringBuilder("initBizMap: count = ");
        sb.append(map.size());
        com.alipay.mobile.rome.syncsdk.util.c.a(str, sb.toString());
        this.b.putAll(map);
        for (Map.Entry<String, Biz> entry : map.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                String str2 = f7305a;
                StringBuilder sb2 = new StringBuilder("    initBizMap: item = ");
                sb2.append(value);
                com.alipay.mobile.rome.syncsdk.util.c.a(str2, sb2.toString());
                this.c.put(value.b, value);
            }
        }
    }

    public final void a(Integer num, String str, Boolean bool, Integer num2, Boolean bool2) {
        synchronized (this) {
            this.j.a(num, str, bool, num2, false, bool2);
        }
    }

    public final void a(Integer num, String str) {
        synchronized (this) {
            this.j.a(num, str, Boolean.FALSE, 1, true, Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Biz biz) {
        if (biz == null) {
            return;
        }
        if (!biz.c && biz.e) {
            if (biz.f == Biz.BizDimeEnum.DEVICE) {
                this.i.add(biz.b);
                this.d.add(biz.f7304a);
                if (biz.d) {
                    this.h.add(biz.b);
                }
            } else if (biz.f == Biz.BizDimeEnum.USER) {
                this.g.add(biz.b);
                this.e.add(biz.f7304a);
                if (biz.d) {
                    this.f.add(biz.b);
                }
            }
        }
    }
}

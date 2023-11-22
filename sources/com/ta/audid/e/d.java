package com.ta.audid.e;

import com.ta.audid.g.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f7676a;

    private d() {
    }

    public static d a() {
        d dVar;
        synchronized (d.class) {
            if (f7676a == null) {
                f7676a = new d();
            }
            dVar = f7676a;
        }
        return dVar;
    }

    public void a(List<String> list) {
        synchronized (this) {
            m.d();
            if (list != null && list.size() > 0) {
                m.d("", "logs", Integer.valueOf(list.size()));
                if (count() > 4) {
                    clearOldLogByCount(2);
                }
                ArrayList arrayList = new ArrayList();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new b(it.next()));
                }
                com.ta.audid.a.a().m234a().insert(arrayList);
                return;
            }
            m.d("", "logs is empty");
        }
    }

    private int count() {
        return com.ta.audid.a.a().m234a().count(b.class);
    }

    private int clearOldLogByCount(int i) {
        String tablename = com.ta.audid.a.a().m234a().getTablename(b.class);
        com.ta.audid.b.a m234a = com.ta.audid.a.a().m234a();
        StringBuilder sb = new StringBuilder();
        sb.append(" _id in ( select _id from ");
        sb.append(tablename);
        sb.append(" ORDER BY _id ASC LIMIT ");
        sb.append(i);
        sb.append(" )");
        return m234a.delete(b.class, sb.toString(), null);
    }

    public int delete(List<b> list) {
        int delete;
        synchronized (this) {
            delete = com.ta.audid.a.a().m234a().delete(list);
        }
        return delete;
    }

    public List<b> get(int i) {
        List find;
        synchronized (this) {
            find = com.ta.audid.a.a().m234a().find(b.class, null, "priority DESC , time DESC ", i);
        }
        return find;
    }
}

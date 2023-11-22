package fsimpl;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class aA {

    /* renamed from: a  reason: collision with root package name */
    private WeakHashMap f7819a = new WeakHashMap();
    private C0311dh b;
    private Map c;

    public aA(Map map) {
        this.c = map;
    }

    private void a(View view, boolean z) {
        if (z) {
            d(view);
        }
    }

    private List b(View view) {
        String str = (String) this.c.get(Integer.valueOf(view.getId()));
        if (str == null) {
            return null;
        }
        String[] split = str.split(",");
        ArrayList arrayList = new ArrayList(split.length);
        for (String str2 : split) {
            arrayList.add(str2.trim());
        }
        return arrayList;
    }

    private aC c(View view) {
        aC aCVar = (aC) this.f7819a.get(view);
        if (aCVar == null) {
            aC aCVar2 = new aC();
            this.f7819a.put(view, aCVar2);
            return aCVar2;
        }
        return aCVar;
    }

    private void d(View view) {
        synchronized (this) {
            if (this.b != null) {
                this.b.a(view);
            }
        }
    }

    private boolean e(View view, String str) {
        aC c = c(view);
        if (c.f7820a == null) {
            c.f7820a = new ArrayList();
        }
        if (c.f7820a.contains(str)) {
            return false;
        }
        c.f7820a.add(str);
        return true;
    }

    private boolean f(View view, String str) {
        aC aCVar = (aC) this.f7819a.get(view);
        if (aCVar == null || aCVar.f7820a == null) {
            return false;
        }
        return aCVar.f7820a.remove(str);
    }

    public C0311dh a() {
        C0311dh c0311dh;
        synchronized (this) {
            c0311dh = this.b;
        }
        return c0311dh;
    }

    public void a(View view) {
        aC aCVar = (aC) this.f7819a.get(view);
        if (aCVar == null || aCVar.f7820a == null || aCVar.f7820a.isEmpty()) {
            return;
        }
        aCVar.f7820a.clear();
        d(view);
    }

    public void a(View view, C0248az c0248az) {
        synchronized (this) {
            aC aCVar = (aC) this.f7819a.get(view);
            List b = b(view);
            if (b != null && b.size() > 0) {
                c0248az.b();
                c0248az.c.addAll(b);
            }
            if (aCVar != null) {
                if (!fa.a(aCVar.c)) {
                    c0248az.f7865a = aCVar.c.toLowerCase();
                }
                if (aCVar.f7820a != null) {
                    c0248az.b();
                    c0248az.c.addAll(aCVar.f7820a);
                }
                if (aCVar.b != null) {
                    c0248az.a();
                    c0248az.d.putAll(aCVar.b);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
    
        if (r0.c != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0021, code lost:
    
        r5 = true ^ r1.equals(r0.c);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.view.View r4, java.lang.String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            fsimpl.aC r0 = r3.c(r4)     // Catch: java.lang.Throwable -> L2d
            java.lang.String r1 = r0.c     // Catch: java.lang.Throwable -> L2d
            boolean r2 = fsimpl.fa.a(r5)     // Catch: java.lang.Throwable -> L2d
            if (r2 == 0) goto Le
            r5 = 0
        Le:
            r0.c = r5     // Catch: java.lang.Throwable -> L2d
            r5 = 1
            if (r1 != 0) goto L1a
            java.lang.String r2 = r0.c     // Catch: java.lang.Throwable -> L2d
            if (r2 == 0) goto L18
            goto L1a
        L18:
            r5 = 0
            goto L28
        L1a:
            if (r1 == 0) goto L28
            java.lang.String r2 = r0.c     // Catch: java.lang.Throwable -> L2d
            if (r2 != 0) goto L21
            goto L28
        L21:
            java.lang.String r0 = r0.c     // Catch: java.lang.Throwable -> L2d
            boolean r0 = r1.equals(r0)     // Catch: java.lang.Throwable -> L2d
            r5 = r5 ^ r0
        L28:
            r3.a(r4, r5)     // Catch: java.lang.Throwable -> L2d
            monitor-exit(r3)
            return
        L2d:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: fsimpl.aA.a(android.view.View, java.lang.String):void");
    }

    public void a(View view, String str, String str2) {
        synchronized (this) {
            aC c = c(view);
            if (c.b == null) {
                c.b = new HashMap();
            }
            a(view, !fa.a(str2, (String) c.b.put(str.toLowerCase(), str2)));
        }
    }

    public void a(View view, Collection collection) {
        boolean z;
        synchronized (this) {
            Iterator it = collection.iterator();
            while (true) {
                while (it.hasNext()) {
                    z = e(view, (String) it.next()) || z;
                }
                a(view, z);
            }
        }
    }

    public void a(C0311dh c0311dh) {
        synchronized (this) {
            this.b = c0311dh;
        }
    }

    public void b(View view, String str) {
        synchronized (this) {
            String lowerCase = str.toLowerCase();
            aC aCVar = (aC) this.f7819a.get(view);
            boolean z = false;
            if (aCVar != null && aCVar.b != null) {
                z = aCVar.b.containsKey(lowerCase);
                aCVar.b.remove(lowerCase);
            }
            a(view, z);
        }
    }

    public void b(View view, Collection collection) {
        boolean z;
        synchronized (this) {
            Iterator it = collection.iterator();
            while (true) {
                while (it.hasNext()) {
                    z = f(view, (String) it.next()) || z;
                }
                a(view, z);
            }
        }
    }

    public void c(View view, String str) {
        synchronized (this) {
            a(view, e(view, str));
        }
    }

    public void d(View view, String str) {
        synchronized (this) {
            a(view, f(view, str));
        }
    }
}

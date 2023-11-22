package com.alipay.iap.android.f2fpay.paymentcode;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Object f6968a = new Object();
    private int b = 2;
    private Queue<C0057a> c = new LinkedList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alipay.iap.android.f2fpay.paymentcode.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0057a extends F2FPaymentCodeInfo {

        /* renamed from: a  reason: collision with root package name */
        private long f6969a;

        C0057a(String str, String str2) {
            super(str, str2);
            this.f6969a = System.currentTimeMillis();
        }
    }

    private boolean c() {
        return this.c.size() >= this.b;
    }

    public long a(String str) {
        C0057a c0057a;
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        synchronized (this.f6968a) {
            Iterator<C0057a> it = this.c.iterator();
            do {
                c0057a = null;
                if (!it.hasNext()) {
                    break;
                }
                c0057a = it.next();
                if (str.equals(c0057a.paymentCode)) {
                    break;
                }
            } while (!str.equals(c0057a.totp));
            if (c0057a != null) {
                return c0057a.f6969a;
            }
            return -1L;
        }
    }

    public void a() {
        synchronized (this.f6968a) {
            this.c.clear();
        }
    }

    public void a(int i) {
        synchronized (this.f6968a) {
            this.b = i;
            while (c()) {
                this.c.poll();
            }
        }
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        synchronized (this.f6968a) {
            for (C0057a c0057a : this.c) {
                if (TextUtils.equals(str, c0057a.paymentCode) && TextUtils.equals(str2, c0057a.totp)) {
                    return;
                }
            }
            while (c()) {
                this.c.poll();
            }
            this.c.offer(new C0057a(str, str2));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:
    
        if (r5 != (r2 - 1)) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003e, code lost:
    
        r4 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
    
        r3.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int b(java.lang.String r9) {
        /*
            r8 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            r1 = -1
            if (r0 == 0) goto L8
            return r1
        L8:
            java.lang.Object r0 = r8.f6968a
            monitor-enter(r0)
            java.util.Queue<com.alipay.iap.android.f2fpay.paymentcode.a$a> r2 = r8.c     // Catch: java.lang.Throwable -> L47
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L47
            java.util.Queue<com.alipay.iap.android.f2fpay.paymentcode.a$a> r3 = r8.c     // Catch: java.lang.Throwable -> L47
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L47
            r4 = 0
            r5 = 0
        L19:
            r6 = 0
            boolean r7 = r3.hasNext()     // Catch: java.lang.Throwable -> L47
            if (r7 == 0) goto L42
            java.lang.Object r6 = r3.next()     // Catch: java.lang.Throwable -> L47
            com.alipay.iap.android.f2fpay.paymentcode.a$a r6 = (com.alipay.iap.android.f2fpay.paymentcode.a.C0057a) r6     // Catch: java.lang.Throwable -> L47
            java.lang.String r7 = r6.paymentCode     // Catch: java.lang.Throwable -> L47
            boolean r7 = r9.equals(r7)     // Catch: java.lang.Throwable -> L47
            if (r7 != 0) goto L3a
            java.lang.String r7 = r6.totp     // Catch: java.lang.Throwable -> L47
            boolean r7 = r9.equals(r7)     // Catch: java.lang.Throwable -> L47
            if (r7 == 0) goto L37
            goto L3a
        L37:
            int r5 = r5 + 1
            goto L19
        L3a:
            r9 = 1
            int r2 = r2 - r9
            if (r5 != r2) goto L3f
            r4 = 1
        L3f:
            r3.remove()     // Catch: java.lang.Throwable -> L47
        L42:
            monitor-exit(r0)
            if (r6 == 0) goto L46
            return r4
        L46:
            return r1
        L47:
            r9 = move-exception
            monitor-exit(r0)
            goto L4b
        L4a:
            throw r9
        L4b:
            goto L4a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.f2fpay.paymentcode.a.b(java.lang.String):int");
    }

    public List<String> b() {
        ArrayList arrayList;
        synchronized (this.f6968a) {
            arrayList = new ArrayList();
            for (C0057a c0057a : this.c) {
                if (!TextUtils.isEmpty(c0057a.paymentCode)) {
                    arrayList.add(c0057a.paymentCode);
                }
                if (!TextUtils.isEmpty(c0057a.totp)) {
                    arrayList.add(c0057a.totp);
                }
            }
        }
        return arrayList;
    }
}

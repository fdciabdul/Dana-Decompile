package com.ta.audid.c;

import android.content.Context;
import android.text.TextUtils;
import com.ta.audid.e.d;
import com.ta.audid.g.f;
import com.ta.audid.g.j;
import com.ta.audid.g.m;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final a f7673a = new a();
    private String d = "";
    private String e = "";

    private a() {
    }

    public static a a() {
        return f7673a;
    }

    public String getUtdid() {
        synchronized (this) {
            if (!TextUtils.isEmpty(this.e)) {
                return this.e;
            } else if (TextUtils.isEmpty(C())) {
                return "ffffffffffffffffffffffff";
            } else {
                m245a();
                return this.e;
            }
        }
    }

    public String C() {
        String D;
        try {
            f.g();
            D = D();
        } finally {
            try {
                return "";
            } finally {
            }
        }
        if (!TextUtils.isEmpty(D)) {
            StringBuilder sb = new StringBuilder();
            sb.append("read from NewFile:");
            sb.append(D);
            m.d("", sb.toString());
            this.e = D;
            this.d = D;
            return D;
        }
        String ad = com.ta.utdid2.device.c.a(com.ta.audid.a.a().getContext()).ad();
        if (!TextUtils.isEmpty(ad)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("read from OldFile:");
            sb2.append(ad);
            m.d("", sb2.toString());
            this.e = ad;
            this.d = ad;
            return ad;
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String D() {
        /*
            r11 = this;
            com.ta.audid.a r0 = com.ta.audid.a.a()
            android.content.Context r0 = r0.getContext()
            java.lang.String r1 = ""
            if (r0 != 0) goto Ld
            return r1
        Ld:
            java.lang.Boolean r2 = com.ta.audid.g.a.a()
            boolean r2 = r2.booleanValue()
            r3 = 5
            if (r2 == 0) goto L39
            java.lang.String r2 = com.ta.audid.f.e.r(r0)
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto L39
            com.ta.audid.c.c r4 = com.ta.audid.c.b.a(r2)
            boolean r5 = r4.isValid()
            if (r5 == 0) goto L39
            int r4 = r4.getVersion()
            if (r4 != r3) goto L39
            com.ta.audid.f.e.g(r2)
            com.ta.audid.f.e.e(r2)
            return r2
        L39:
            java.lang.String r2 = com.ta.audid.f.e.L()
            java.lang.String r4 = com.ta.audid.f.e.S()
            r5 = 0
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            r7 = 0
            if (r6 != 0) goto L60
            com.ta.audid.c.c r5 = com.ta.audid.c.b.a(r2)
            if (r5 == 0) goto L60
            int r6 = r5.getVersion()
            if (r6 == r3) goto L5b
            com.ta.audid.f.e.e(r1)
            r2 = r1
            goto L60
        L5b:
            long r9 = r5.getTimestamp()
            goto L61
        L60:
            r9 = r7
        L61:
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 != 0) goto L82
            boolean r6 = r4.equals(r2)
            if (r6 != 0) goto L71
            com.ta.audid.c.c r5 = com.ta.audid.c.b.a(r4)
        L71:
            if (r5 == 0) goto L82
            int r6 = r5.getVersion()
            if (r6 == r3) goto L7e
            com.ta.audid.f.e.g(r1)
            r4 = r1
            goto L82
        L7e:
            long r7 = r5.getTimestamp()
        L82:
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto La7
            boolean r3 = android.text.TextUtils.isEmpty(r4)
            if (r3 != 0) goto La7
            boolean r1 = r2.equals(r4)
            if (r1 == 0) goto L95
            return r2
        L95:
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 < 0) goto La0
            com.ta.audid.f.e.g(r2)
            com.ta.audid.f.e.a(r0, r2)
            return r2
        La0:
            com.ta.audid.f.e.e(r4)
            com.ta.audid.f.e.a(r0, r4)
            return r4
        La7:
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto Lba
            boolean r3 = android.text.TextUtils.isEmpty(r4)
            if (r3 == 0) goto Lba
            com.ta.audid.f.e.g(r2)
            com.ta.audid.f.e.a(r0, r2)
            return r2
        Lba:
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto Lcd
            boolean r2 = android.text.TextUtils.isEmpty(r4)
            if (r2 != 0) goto Lcd
            com.ta.audid.f.e.e(r4)
            com.ta.audid.f.e.a(r0, r4)
            return r4
        Lcd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.audid.c.a.D():java.lang.String");
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m245a() {
        m.d();
        if (TextUtils.isEmpty(this.d)) {
            return;
        }
        try {
            j.a().submit(new Runnable() { // from class: com.ta.audid.c.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Thread.sleep(30000L);
                        com.ta.audid.filesync.a.a().c(a.this.d);
                        a.this.b();
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(com.ta.audid.e.c.c(a.this.d));
                        d.a().a(arrayList);
                    } catch (Throwable th) {
                        m.d("", th);
                    }
                }
            });
        } catch (Throwable th) {
            m.d("", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Context context = com.ta.audid.a.a().getContext();
        if (context == null) {
            return;
        }
        com.ta.audid.e.a.a(com.ta.audid.a.c.m237a(context), com.ta.audid.a.c.b(context));
    }

    public void b(String str) {
        synchronized (this) {
            this.d = str;
        }
    }

    public String E() {
        String str;
        synchronized (this) {
            str = this.d;
        }
        return str;
    }
}

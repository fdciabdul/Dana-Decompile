package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* loaded from: classes7.dex */
public class a {
    public String b;

    /* renamed from: a  reason: collision with root package name */
    public int f7464a = 4;
    public b c = new e();

    public void a(Context context, int i, String str) {
        this.f7464a = i;
        this.b = str;
        this.c.a(context, "HMSCore");
    }

    public void b(int i, String str, String str2, Throwable th) {
        if (a(i)) {
            c a2 = a(i, str, str2, th);
            StringBuilder sb = new StringBuilder();
            sb.append(a2.c());
            sb.append(a2.a());
            String obj = sb.toString();
            b bVar = this.c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append('\n');
            sb2.append(Log.getStackTraceString(th));
            bVar.a(obj, i, str, sb2.toString());
        }
    }

    public b a() {
        return this.c;
    }

    public void a(b bVar) {
        this.c = bVar;
    }

    public boolean a(int i) {
        return i >= this.f7464a;
    }

    public void a(int i, String str, String str2) {
        if (a(i)) {
            c a2 = a(i, str, str2, null);
            StringBuilder sb = new StringBuilder();
            sb.append(a2.c());
            sb.append(a2.a());
            this.c.a(sb.toString(), i, str, str2);
        }
    }

    public void a(String str, String str2) {
        c a2 = a(4, str, str2, null);
        StringBuilder sb = new StringBuilder();
        sb.append(a2.c());
        sb.append('\n');
        sb.append(a2.a());
        this.c.a(sb.toString(), 4, str, str2);
    }

    public final c a(int i, String str, String str2, Throwable th) {
        c cVar = new c(8, this.b, i, str);
        cVar.a((c) str2);
        cVar.a(th);
        return cVar;
    }
}

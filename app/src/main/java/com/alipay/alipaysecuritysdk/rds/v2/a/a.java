package com.alipay.alipaysecuritysdk.rds.v2.a;

import android.content.Context;
import com.alipay.alipaysecuritysdk.rds.v2.b.c;
import com.alipay.alipaysecuritysdk.rds.v2.b.d;
import com.alipay.alipaysecuritysdk.rds.v2.b.e;
import com.alipay.alipaysecuritysdk.rds.v2.b.f;
import com.alipay.alipaysecuritysdk.rds.v2.b.g;
import com.alipay.alipaysecuritysdk.rds.v2.b.h;
import com.alipay.alipaysecuritysdk.rds.v2.b.i;
import com.alipay.alipaysecuritysdk.rds.v2.b.j;
import com.alipay.alipaysecuritysdk.rds.v2.b.k;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public c f6874a;
    public d b;
    public e c;
    public k g;
    private boolean k;
    private com.alipay.alipaysecuritysdk.rds.v2.b.a h = new com.alipay.alipaysecuritysdk.rds.v2.b.a();
    private f i = new f();
    public g d = new g();
    public h e = new h();
    private i j = new i();
    public j f = new j();

    public a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z) {
        this.f6874a = new c(context, str, str2, str3, str4, str5);
        this.b = new d(context);
        this.c = new e(context);
        this.g = new k(context, str6, str7, str8, str9, str10);
        this.k = z;
        if (z) {
            this.e.a(context);
        }
    }

    public final void a(String str, String str2, boolean z) {
        this.f.a(str, str2, z);
    }
}

package com.huawei.hms.base.log;

import android.content.Context;

/* loaded from: classes7.dex */
public class e implements b {

    /* renamed from: a  reason: collision with root package name */
    public b f7467a;

    @Override // com.huawei.hms.base.log.b
    public void a(Context context, String str) {
        b bVar = this.f7467a;
        if (bVar != null) {
            bVar.a(context, str);
        }
    }

    @Override // com.huawei.hms.base.log.b
    public void a(b bVar) {
        this.f7467a = bVar;
    }

    @Override // com.huawei.hms.base.log.b
    public void a(String str, int i, String str2, String str3) {
        b bVar = this.f7467a;
        if (bVar != null) {
            bVar.a(str, i, str2, str3);
        }
    }
}

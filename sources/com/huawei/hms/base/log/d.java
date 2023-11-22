package com.huawei.hms.base.log;

import android.content.Context;
import com.huawei.hms.support.log.HMSExtLogger;

/* loaded from: classes7.dex */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public final HMSExtLogger f7466a;
    public b b;

    public d(HMSExtLogger hMSExtLogger) {
        this.f7466a = hMSExtLogger;
    }

    @Override // com.huawei.hms.base.log.b
    public void a(Context context, String str) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(context, str);
        }
    }

    @Override // com.huawei.hms.base.log.b
    public void a(b bVar) {
        this.b = bVar;
    }

    @Override // com.huawei.hms.base.log.b
    public void a(String str, int i, String str2, String str3) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(str, i, str2, str3);
        }
    }
}

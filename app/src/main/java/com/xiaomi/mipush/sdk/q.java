package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.fullstory.instrumentation.InstrumentInjector;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class q implements Runnable {
    final /* synthetic */ Context MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Context context) {
        this.MyBillsEntityDataFactory = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            PackageInfo packageInfo = this.MyBillsEntityDataFactory.getPackageManager().getPackageInfo(this.MyBillsEntityDataFactory.getPackageName(), 4612);
            p.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory);
            p.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, packageInfo);
            p.getAuthRequestContext(this.MyBillsEntityDataFactory, packageInfo);
        } catch (Throwable th) {
            InstrumentInjector.log_e("ManifestChecker", "", th);
        }
    }
}

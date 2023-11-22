package com.xiaomi.push.service.receivers;

import android.content.Context;

/* loaded from: classes8.dex */
class a implements Runnable {
    final /* synthetic */ NetworkStatusReceiver KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ Context PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(NetworkStatusReceiver networkStatusReceiver, Context context) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = networkStatusReceiver;
        this.PlaceComponentResult = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.a(this.PlaceComponentResult);
    }
}

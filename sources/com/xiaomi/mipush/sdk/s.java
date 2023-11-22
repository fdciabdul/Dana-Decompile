package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes8.dex */
final class s implements Runnable {
    final /* synthetic */ Intent KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ Context PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(Context context, Intent intent) {
        this.PlaceComponentResult = context;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.PlaceComponentResult.startService(this.KClassImpl$Data$declaredNonStaticMembers$2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e.getMessage());
        }
    }
}

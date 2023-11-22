package com.xiaomi.mipush.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes8.dex */
class v extends BroadcastReceiver {
    final /* synthetic */ NotificationClickedActivity PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(NotificationClickedActivity notificationClickedActivity) {
        this.PlaceComponentResult = notificationClickedActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory("clicked activity finish by normal.");
        this.PlaceComponentResult.finish();
    }
}

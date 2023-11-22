package com.xiaomi.push;

import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.Map;

/* loaded from: classes8.dex */
public class ay extends Notification.Builder {
    private Context KClassImpl$Data$declaredNonStaticMembers$2;

    public ay(Context context) {
        super(context);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
    }

    public final ay MyBillsEntityDataFactory(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 20) {
            super.addExtras(bundle);
        }
        return this;
    }

    public final ay MyBillsEntityDataFactory(RemoteViews remoteViews) {
        if (Build.VERSION.SDK_INT >= 24) {
            super.setCustomContentView(remoteViews);
        } else {
            super.setContent(remoteViews);
        }
        return this;
    }

    public final ay MyBillsEntityDataFactory(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                z.getAuthRequestContext(this, "setColor", Integer.valueOf(Color.parseColor(str)));
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("fail to set color. ");
                sb.append(e);
                com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString());
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Context PlaceComponentResult() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public ay PlaceComponentResult(Map<String, String> map) {
        return this;
    }

    @Override // android.app.Notification.Builder
    public Notification build() {
        getAuthRequestContext();
        return super.build();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getAuthRequestContext() {
    }

    public final int getAuthRequestContext(String str) {
        Resources resources = this.KClassImpl$Data$declaredNonStaticMembers$2.getResources();
        String packageName = this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName();
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return resources.getIdentifier(str, "id", packageName);
    }

    @Override // android.app.Notification.Builder
    public /* synthetic */ Notification.Builder addExtras(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 20) {
            super.addExtras(bundle);
        }
        return this;
    }

    @Override // android.app.Notification.Builder
    public /* synthetic */ Notification.Builder setCustomContentView(RemoteViews remoteViews) {
        if (Build.VERSION.SDK_INT >= 24) {
            super.setCustomContentView(remoteViews);
        } else {
            super.setContent(remoteViews);
        }
        return this;
    }
}

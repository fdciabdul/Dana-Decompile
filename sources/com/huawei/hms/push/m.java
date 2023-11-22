package com.huawei.hms.push;

import android.app.Notification;
import android.text.TextUtils;

/* loaded from: classes8.dex */
public class m {
    public static n getAuthRequestContext(k kVar) {
        n nVar = n.STYLE_DEFAULT;
        return (kVar.getSupportButtonTintMode < 0 || kVar.getSupportButtonTintMode >= n.values().length) ? nVar : n.values()[kVar.getSupportButtonTintMode];
    }

    public static void BuiltInFictitiousFunctionClassFactory(Notification.Builder builder, String str, k kVar) {
        Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
        if (!TextUtils.isEmpty(kVar.whenAvailable)) {
            bigTextStyle.setBigContentTitle(kVar.whenAvailable);
        }
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            bigTextStyle.bigText(str);
        }
        builder.setStyle(bigTextStyle);
    }
}

package com.alipay.mobile.verifyidentity.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes3.dex */
public class DefaultOnClickUrl implements OnClickUrl {
    @Override // com.alipay.mobile.verifyidentity.base.OnClickUrl
    public void onClickHttpUrl(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        if (!(context instanceof Activity)) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        context.startActivity(intent);
    }
}

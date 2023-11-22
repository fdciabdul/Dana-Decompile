package com.yellowmessenger.ymchat;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.google.android.material.snackbar.Snackbar;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes8.dex */
public class YmHelper {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void MyBillsEntityDataFactory() {
    }

    public static void getAuthRequestContext(final Context context, View view, String str) {
        Snackbar.make(view, str, 0).setAction(context.getString(R.string.ym_text_settings), new View.OnClickListener() { // from class: com.yellowmessenger.ymchat.YmHelper$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YmHelper.getAuthRequestContext(context);
            }
        }).show();
    }

    public static void BuiltInFictitiousFunctionClassFactory(View view, String str) {
        Snackbar.make(view, str, 0).setAction("", new View.OnClickListener() { // from class: com.yellowmessenger.ymchat.YmHelper$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YmHelper.MyBillsEntityDataFactory();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void getAuthRequestContext(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.addCategory("android.intent.category.DEFAULT");
        StringBuilder sb = new StringBuilder();
        sb.append("package:");
        sb.append(context.getPackageName());
        intent.setData(Uri.parse(sb.toString()));
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        context.startActivity(intent);
    }
}

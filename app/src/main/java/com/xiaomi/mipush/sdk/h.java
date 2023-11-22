package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class h implements Runnable {
    final /* synthetic */ c BuiltInFictitiousFunctionClassFactory;
    final /* synthetic */ String MyBillsEntityDataFactory;
    final /* synthetic */ Context getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str, Context context, c cVar) {
        this.MyBillsEntityDataFactory = str;
        this.getAuthRequestContext = context;
        this.BuiltInFictitiousFunctionClassFactory = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        if (TextUtils.isEmpty(this.MyBillsEntityDataFactory)) {
            return;
        }
        String[] split = this.MyBillsEntityDataFactory.split("~");
        int length = split.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                str = "";
                break;
            }
            String str2 = split[i];
            if (!TextUtils.isEmpty(str2) && str2.startsWith("token:")) {
                str = str2.substring(str2.indexOf(":") + 1);
                break;
            }
            i++;
        }
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("ASSEMBLE_PUSH : receive incorrect token");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("ASSEMBLE_PUSH : receive correct token");
        g.PlaceComponentResult(this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory, str);
        g.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext);
    }
}

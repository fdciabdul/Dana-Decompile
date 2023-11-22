package com.huawei.hms.hatool;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;

/* loaded from: classes8.dex */
public class w0 {
    public static w0 MyBillsEntityDataFactory = new w0();
    public boolean getAuthRequestContext = false;
    public Context KClassImpl$Data$declaredNonStaticMembers$2 = b.lookAheadTest();

    public static w0 BuiltInFictitiousFunctionClassFactory() {
        return MyBillsEntityDataFactory;
    }

    public final boolean PlaceComponentResult() {
        boolean z;
        if (!this.getAuthRequestContext) {
            Context context = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (context == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                UserManager userManager = (UserManager) context.getSystemService("user");
                if (userManager != null) {
                    z = userManager.isUserUnlocked();
                } else {
                    this.getAuthRequestContext = false;
                }
            } else {
                z = true;
            }
            this.getAuthRequestContext = z;
        }
        return this.getAuthRequestContext;
    }
}

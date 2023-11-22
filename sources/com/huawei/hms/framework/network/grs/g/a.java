package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.net.Uri;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;

/* loaded from: classes7.dex */
public class a {
    final c BuiltInFictitiousFunctionClassFactory;
    protected d KClassImpl$Data$declaredNonStaticMembers$2;
    final int MyBillsEntityDataFactory;
    final com.huawei.hms.framework.network.grs.e.c NetworkUserEntityData$$ExternalSyntheticLambda0;
    final Context PlaceComponentResult;
    final String getAuthRequestContext;
    final GrsBaseInfo getErrorConfigVersion;
    final String moveToNextValue;

    /* renamed from: com.huawei.hms.framework.network.grs.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    enum EnumC0118a {
        GRSPOST,
        GRSGET,
        GRSDEFAULT
    }

    public a(String str, int i, c cVar, Context context, String str2, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.c cVar2) {
        this.getAuthRequestContext = str;
        this.BuiltInFictitiousFunctionClassFactory = cVar;
        this.MyBillsEntityDataFactory = i;
        this.PlaceComponentResult = context;
        this.moveToNextValue = str2;
        this.getErrorConfigVersion = grsBaseInfo;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = cVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final EnumC0118a KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.getAuthRequestContext.isEmpty()) {
            return EnumC0118a.GRSDEFAULT;
        }
        String path = Uri.parse(this.getAuthRequestContext).getPath();
        return path.contains("1.0") ? EnumC0118a.GRSGET : path.contains("2.0") ? EnumC0118a.GRSPOST : EnumC0118a.GRSDEFAULT;
    }
}

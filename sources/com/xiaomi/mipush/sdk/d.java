package com.xiaomi.mipush.sdk;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class d implements AbstractPushManager {
    private static volatile d getAuthRequestContext;
    private PushConfiguration BuiltInFictitiousFunctionClassFactory;
    private Context PlaceComponentResult;
    private boolean MyBillsEntityDataFactory = false;
    Map<c, AbstractPushManager> KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap();

    private d(Context context) {
        this.PlaceComponentResult = context.getApplicationContext();
    }

    public static d MyBillsEntityDataFactory(Context context) {
        if (getAuthRequestContext == null) {
            synchronized (d.class) {
                if (getAuthRequestContext == null) {
                    getAuthRequestContext = new d(context);
                }
            }
        }
        return getAuthRequestContext;
    }

    private boolean MyBillsEntityDataFactory(c cVar) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.containsKey(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean PlaceComponentResult(d dVar) {
        dVar.MyBillsEntityDataFactory = true;
        return true;
    }

    private void getAuthRequestContext(c cVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.containsKey(cVar)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.remove(cVar);
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.put(cVar, abstractPushManager);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public final void BuiltInFictitiousFunctionClassFactory() {
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.KClassImpl$Data$declaredNonStaticMembers$2.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.BuiltInFictitiousFunctionClassFactory();
            }
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }

    public final boolean PlaceComponentResult(c cVar) {
        int i = f.PlaceComponentResult[cVar.ordinal()];
        boolean z = false;
        if (i == 1) {
            PushConfiguration pushConfiguration = this.BuiltInFictitiousFunctionClassFactory;
            if (pushConfiguration != null) {
                return pushConfiguration.PlaceComponentResult();
            }
            return false;
        } else if (i == 2) {
            PushConfiguration pushConfiguration2 = this.BuiltInFictitiousFunctionClassFactory;
            if (pushConfiguration2 != null) {
                return pushConfiguration2.BuiltInFictitiousFunctionClassFactory();
            }
            return false;
        } else {
            if (i == 3) {
                PushConfiguration pushConfiguration3 = this.BuiltInFictitiousFunctionClassFactory;
                if (pushConfiguration3 != null) {
                    z = pushConfiguration3.MyBillsEntityDataFactory();
                }
            } else if (i != 4) {
                return false;
            }
            PushConfiguration pushConfiguration4 = this.BuiltInFictitiousFunctionClassFactory;
            return pushConfiguration4 != null ? pushConfiguration4.getAuthRequestContext() : z;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0211  */
    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void PlaceComponentResult() {
        /*
            Method dump skipped, instructions count: 593
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.d.PlaceComponentResult():void");
    }
}

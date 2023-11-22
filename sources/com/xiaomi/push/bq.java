package com.xiaomi.push;

import java.io.IOException;

/* loaded from: classes8.dex */
class bq extends Thread {
    final /* synthetic */ bp BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bq(bp bpVar, String str) {
        super(str);
        this.BuiltInFictitiousFunctionClassFactory = bpVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        bk bkVar;
        try {
            bkVar = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda6;
            try {
                bkVar.MyBillsEntityDataFactory();
            } catch (IOException e) {
                if (bkVar.KClassImpl$Data$declaredNonStaticMembers$2) {
                    return;
                }
                throw e;
            }
        } catch (Exception e2) {
            this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(9, e2);
        }
    }
}

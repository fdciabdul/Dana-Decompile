package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class am extends ag {
    final /* synthetic */ ak DatabaseTableConfigUtil;
    final /* synthetic */ ag GetContactSyncConfig;
    ag NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(ak akVar, String str, ag agVar) {
        super(str);
        this.DatabaseTableConfigUtil = akVar;
        this.GetContactSyncConfig = agVar;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = agVar;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (agVar != null) {
            this.moveToNextValue = agVar.moveToNextValue;
        }
    }

    @Override // com.xiaomi.push.ag
    public final void MyBillsEntityDataFactory(String str, af afVar) {
        synchronized (this) {
            ag agVar = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (agVar != null) {
                agVar.MyBillsEntityDataFactory(str, afVar);
            }
        }
    }

    @Override // com.xiaomi.push.ag
    public final ArrayList<String> PlaceComponentResult(boolean z) {
        ArrayList<String> arrayList;
        synchronized (this) {
            arrayList = new ArrayList<>();
            ag agVar = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (agVar != null) {
                arrayList.addAll(agVar.PlaceComponentResult(true));
            }
            synchronized (ak.BuiltInFictitiousFunctionClassFactory) {
                ag agVar2 = ak.BuiltInFictitiousFunctionClassFactory.get(this.KClassImpl$Data$declaredNonStaticMembers$2);
                if (agVar2 != null) {
                    Iterator<String> it = agVar2.PlaceComponentResult(true).iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (arrayList.indexOf(next) == -1) {
                            arrayList.add(next);
                        }
                    }
                    arrayList.remove(this.KClassImpl$Data$declaredNonStaticMembers$2);
                    arrayList.add(this.KClassImpl$Data$declaredNonStaticMembers$2);
                }
            }
        }
        return arrayList;
    }

    @Override // com.xiaomi.push.ag
    public final boolean getAuthRequestContext() {
        return false;
    }
}

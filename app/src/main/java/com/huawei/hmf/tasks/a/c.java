package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.CancellationToken;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public final class c extends CancellationToken {
    public final List<Runnable> PlaceComponentResult = new ArrayList();
    public final Object MyBillsEntityDataFactory = new Object();
    public boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;

    @Override // com.huawei.hmf.tasks.CancellationToken
    public final CancellationToken BuiltInFictitiousFunctionClassFactory(Runnable runnable) {
        synchronized (this.MyBillsEntityDataFactory) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                runnable.run();
            } else {
                this.PlaceComponentResult.add(runnable);
            }
        }
        return this;
    }

    @Override // com.huawei.hmf.tasks.CancellationToken
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}

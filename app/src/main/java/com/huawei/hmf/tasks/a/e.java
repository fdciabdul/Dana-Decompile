package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import java.util.concurrent.ExecutionException;

/* loaded from: classes7.dex */
final class e<TResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult> {
    private Exception BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private final int MyBillsEntityDataFactory;
    private final i<Void> PlaceComponentResult;
    private final Object getAuthRequestContext;
    private boolean scheduleImpl;

    private void MyBillsEntityDataFactory() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 >= this.MyBillsEntityDataFactory) {
            if (this.BuiltInFictitiousFunctionClassFactory != null) {
                this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(new ExecutionException("a task failed", this.BuiltInFictitiousFunctionClassFactory));
            } else if (this.scheduleImpl) {
                this.PlaceComponentResult.scheduleImpl();
            } else {
                this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2((i<Void>) null);
            }
        }
    }

    @Override // com.huawei.hmf.tasks.OnCanceledListener
    public final void BuiltInFictitiousFunctionClassFactory() {
        synchronized (this.getAuthRequestContext) {
            this.KClassImpl$Data$declaredNonStaticMembers$2++;
            this.scheduleImpl = true;
            MyBillsEntityDataFactory();
        }
    }

    @Override // com.huawei.hmf.tasks.OnFailureListener
    public final void BuiltInFictitiousFunctionClassFactory(Exception exc) {
        synchronized (this.getAuthRequestContext) {
            this.KClassImpl$Data$declaredNonStaticMembers$2++;
            this.BuiltInFictitiousFunctionClassFactory = exc;
            MyBillsEntityDataFactory();
        }
    }

    @Override // com.huawei.hmf.tasks.OnSuccessListener
    public final void PlaceComponentResult() {
        synchronized (this.getAuthRequestContext) {
            this.KClassImpl$Data$declaredNonStaticMembers$2++;
            MyBillsEntityDataFactory();
        }
    }
}

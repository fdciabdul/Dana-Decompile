package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* loaded from: classes7.dex */
public final class f<TResult> implements ExecuteResult<TResult> {
    private OnFailureListener KClassImpl$Data$declaredNonStaticMembers$2;
    private final Object MyBillsEntityDataFactory = new Object();
    private Executor PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Executor executor, OnFailureListener onFailureListener) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = onFailureListener;
        this.PlaceComponentResult = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void MyBillsEntityDataFactory(final Task<TResult> task) {
        if (task.MyBillsEntityDataFactory() || task.KClassImpl$Data$declaredNonStaticMembers$2()) {
            return;
        }
        this.PlaceComponentResult.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.f.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (f.this.MyBillsEntityDataFactory) {
                    if (f.this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                        f.this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(task.BuiltInFictitiousFunctionClassFactory());
                    }
                }
            }
        });
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void getAuthRequestContext() {
        synchronized (this.MyBillsEntityDataFactory) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
    }
}

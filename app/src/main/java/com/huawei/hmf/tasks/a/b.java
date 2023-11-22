package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* loaded from: classes7.dex */
public final class b<TResult> implements ExecuteResult<TResult> {
    private Executor BuiltInFictitiousFunctionClassFactory;
    private OnCanceledListener KClassImpl$Data$declaredNonStaticMembers$2;
    private final Object MyBillsEntityDataFactory;

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void MyBillsEntityDataFactory(Task<TResult> task) {
        if (task.KClassImpl$Data$declaredNonStaticMembers$2()) {
            this.BuiltInFictitiousFunctionClassFactory.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (b.this.MyBillsEntityDataFactory) {
                        if (b.this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                            b.this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
                        }
                    }
                }
            });
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void getAuthRequestContext() {
        synchronized (this.MyBillsEntityDataFactory) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
    }
}

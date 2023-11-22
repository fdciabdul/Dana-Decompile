package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* loaded from: classes7.dex */
public final class h<TResult> implements ExecuteResult<TResult> {
    private final Object BuiltInFictitiousFunctionClassFactory = new Object();
    private Executor PlaceComponentResult;
    private OnSuccessListener<TResult> getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Executor executor, OnSuccessListener<TResult> onSuccessListener) {
        this.getAuthRequestContext = onSuccessListener;
        this.PlaceComponentResult = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void MyBillsEntityDataFactory(final Task<TResult> task) {
        if (!task.MyBillsEntityDataFactory() || task.KClassImpl$Data$declaredNonStaticMembers$2()) {
            return;
        }
        this.PlaceComponentResult.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.h.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (h.this.BuiltInFictitiousFunctionClassFactory) {
                    if (h.this.getAuthRequestContext != null) {
                        OnSuccessListener onSuccessListener = h.this.getAuthRequestContext;
                        task.getAuthRequestContext();
                        onSuccessListener.PlaceComponentResult();
                    }
                }
            }
        });
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void getAuthRequestContext() {
        synchronized (this.BuiltInFictitiousFunctionClassFactory) {
            this.getAuthRequestContext = null;
        }
    }
}

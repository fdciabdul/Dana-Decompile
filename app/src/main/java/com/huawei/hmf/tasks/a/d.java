package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* loaded from: classes7.dex */
public final class d<TResult> implements ExecuteResult<TResult> {
    Executor BuiltInFictitiousFunctionClassFactory;
    private final Object MyBillsEntityDataFactory = new Object();
    private OnCompleteListener<TResult> PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.PlaceComponentResult = onCompleteListener;
        this.BuiltInFictitiousFunctionClassFactory = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void MyBillsEntityDataFactory(final Task<TResult> task) {
        this.BuiltInFictitiousFunctionClassFactory.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.d.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (d.this.MyBillsEntityDataFactory) {
                    if (d.this.PlaceComponentResult != null) {
                        d.this.PlaceComponentResult.MyBillsEntityDataFactory(task);
                    }
                }
            }
        });
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void getAuthRequestContext() {
        synchronized (this.MyBillsEntityDataFactory) {
            this.PlaceComponentResult = null;
        }
    }
}

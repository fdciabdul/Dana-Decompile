package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.i;

/* loaded from: classes7.dex */
public class TaskCompletionSource<TResult> {
    public final i<TResult> MyBillsEntityDataFactory = new i<>();

    public TaskCompletionSource() {
    }

    public TaskCompletionSource(CancellationToken cancellationToken) {
        cancellationToken.BuiltInFictitiousFunctionClassFactory(new Runnable() { // from class: com.huawei.hmf.tasks.TaskCompletionSource.1
            @Override // java.lang.Runnable
            public void run() {
                TaskCompletionSource.this.MyBillsEntityDataFactory.scheduleImpl();
            }
        });
    }

    public final void getAuthRequestContext(TResult tresult) {
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2((i<TResult>) tresult);
    }
}

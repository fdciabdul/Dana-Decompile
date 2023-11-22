package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.j;
import java.util.concurrent.ExecutionException;

/* loaded from: classes7.dex */
public class Tasks {
    private static j getAuthRequestContext = new j();

    public static <TResult> TResult KClassImpl$Data$declaredNonStaticMembers$2(Task<TResult> task) throws ExecutionException, InterruptedException {
        j.PlaceComponentResult("await must not be called on the UI thread");
        if (task.PlaceComponentResult()) {
            return (TResult) j.PlaceComponentResult(task);
        }
        j.a aVar = new j.a();
        task.getAuthRequestContext(aVar).MyBillsEntityDataFactory(aVar);
        aVar.getAuthRequestContext.await();
        return (TResult) j.PlaceComponentResult(task);
    }
}

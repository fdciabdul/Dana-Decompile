package com.huawei.hmf.tasks.a;

import android.os.Looper;
import com.huawei.hmf.tasks.Continuation;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

/* loaded from: classes7.dex */
public final class j {

    /* renamed from: com.huawei.hmf.tasks.a.j$2  reason: invalid class name */
    /* loaded from: classes7.dex */
    static final class AnonymousClass2 implements Continuation<Void, List<Task<?>>> {
        final /* synthetic */ Collection PlaceComponentResult;

        @Override // com.huawei.hmf.tasks.Continuation
        public final /* synthetic */ List<Task<?>> getAuthRequestContext() throws Exception {
            ArrayList arrayList = new ArrayList(this.PlaceComponentResult.size());
            arrayList.addAll(this.PlaceComponentResult);
            return arrayList;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [TResult] */
    /* renamed from: com.huawei.hmf.tasks.a.j$3  reason: invalid class name */
    /* loaded from: classes7.dex */
    static final class AnonymousClass3<TResult> implements Continuation<Void, List<TResult>> {
        final /* synthetic */ Collection MyBillsEntityDataFactory;

        @Override // com.huawei.hmf.tasks.Continuation
        public final /* synthetic */ Object getAuthRequestContext() throws Exception {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.MyBillsEntityDataFactory.iterator();
            while (it.hasNext()) {
                arrayList.add(((Task) it.next()).getAuthRequestContext());
            }
            return arrayList;
        }
    }

    /* loaded from: classes7.dex */
    public static final class a<TResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult> {
        public final CountDownLatch getAuthRequestContext = new CountDownLatch(1);

        @Override // com.huawei.hmf.tasks.OnCanceledListener
        public final void BuiltInFictitiousFunctionClassFactory() {
            this.getAuthRequestContext.countDown();
        }

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public final void BuiltInFictitiousFunctionClassFactory(Exception exc) {
            this.getAuthRequestContext.countDown();
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        public final void PlaceComponentResult() {
            this.getAuthRequestContext.countDown();
        }
    }

    public static <TResult> TResult PlaceComponentResult(Task<TResult> task) throws ExecutionException {
        if (task.MyBillsEntityDataFactory()) {
            return task.getAuthRequestContext();
        }
        throw new ExecutionException(task.BuiltInFictitiousFunctionClassFactory());
    }

    public static void PlaceComponentResult(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(str);
        }
    }

    /* renamed from: com.huawei.hmf.tasks.a.j$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ Callable BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ TaskCompletionSource getAuthRequestContext;

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.getAuthRequestContext.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.call());
            } catch (Exception e) {
                this.getAuthRequestContext.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(e);
            }
        }
    }
}

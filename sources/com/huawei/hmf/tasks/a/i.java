package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.Continuation;
import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.SuccessContinuation;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskExecutors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public final class i<TResult> extends Task<TResult> {
    private Exception BuiltInFictitiousFunctionClassFactory;
    private TResult KClassImpl$Data$declaredNonStaticMembers$2;
    private volatile boolean MyBillsEntityDataFactory;
    private boolean PlaceComponentResult;
    private final Object getAuthRequestContext = new Object();
    private List<ExecuteResult<TResult>> scheduleImpl = new ArrayList();

    /* renamed from: com.huawei.hmf.tasks.a.i$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    final class AnonymousClass1 implements OnSuccessListener<TResult> {
        final /* synthetic */ i MyBillsEntityDataFactory;
        final /* synthetic */ SuccessContinuation getAuthRequestContext;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.huawei.hmf.tasks.OnSuccessListener
        public final void PlaceComponentResult() {
            try {
                Task KClassImpl$Data$declaredNonStaticMembers$2 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
                if (KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
                    this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2((Exception) new NullPointerException("SuccessContinuation returned null"));
                } else {
                    KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory((OnCompleteListener) new OnCompleteListener<TContinuationResult>() { // from class: com.huawei.hmf.tasks.a.i.1.1
                        @Override // com.huawei.hmf.tasks.OnCompleteListener
                        public final void MyBillsEntityDataFactory(Task<TContinuationResult> task) {
                            if (task.MyBillsEntityDataFactory()) {
                                AnonymousClass1.this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2((i) task.getAuthRequestContext());
                            } else if (task.KClassImpl$Data$declaredNonStaticMembers$2()) {
                                AnonymousClass1.this.MyBillsEntityDataFactory.scheduleImpl();
                            } else {
                                AnonymousClass1.this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(task.BuiltInFictitiousFunctionClassFactory());
                            }
                        }
                    });
                }
            } catch (Exception e) {
                this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(e);
            }
        }
    }

    /* renamed from: com.huawei.hmf.tasks.a.i$2  reason: invalid class name */
    /* loaded from: classes7.dex */
    final class AnonymousClass2 implements OnFailureListener {
        final /* synthetic */ i KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public final void BuiltInFictitiousFunctionClassFactory(Exception exc) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(exc);
        }
    }

    /* renamed from: com.huawei.hmf.tasks.a.i$3  reason: invalid class name */
    /* loaded from: classes7.dex */
    final class AnonymousClass3 implements OnCanceledListener {
        final /* synthetic */ i MyBillsEntityDataFactory;

        @Override // com.huawei.hmf.tasks.OnCanceledListener
        public final void BuiltInFictitiousFunctionClassFactory() {
            this.MyBillsEntityDataFactory.scheduleImpl();
        }
    }

    /* renamed from: com.huawei.hmf.tasks.a.i$4  reason: invalid class name */
    /* loaded from: classes7.dex */
    final class AnonymousClass4 implements OnCompleteListener<TResult> {
        final /* synthetic */ Continuation MyBillsEntityDataFactory;
        final /* synthetic */ i PlaceComponentResult;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.huawei.hmf.tasks.OnCompleteListener
        public final void MyBillsEntityDataFactory(Task<TResult> task) {
            try {
                ((Task) this.MyBillsEntityDataFactory.getAuthRequestContext()).MyBillsEntityDataFactory((OnCompleteListener) new OnCompleteListener<TContinuationResult>() { // from class: com.huawei.hmf.tasks.a.i.4.1
                    @Override // com.huawei.hmf.tasks.OnCompleteListener
                    public final void MyBillsEntityDataFactory(Task<TContinuationResult> task2) {
                        if (task2.MyBillsEntityDataFactory()) {
                            AnonymousClass4.this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2((i) task2.getAuthRequestContext());
                        } else if (task2.KClassImpl$Data$declaredNonStaticMembers$2()) {
                            AnonymousClass4.this.PlaceComponentResult.scheduleImpl();
                        } else {
                            AnonymousClass4.this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(task2.BuiltInFictitiousFunctionClassFactory());
                        }
                    }
                });
            } catch (Exception e) {
                this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(e);
            }
        }
    }

    /* renamed from: com.huawei.hmf.tasks.a.i$5  reason: invalid class name */
    /* loaded from: classes7.dex */
    final class AnonymousClass5 implements OnCompleteListener<TResult> {
        final /* synthetic */ Continuation PlaceComponentResult;
        final /* synthetic */ i getAuthRequestContext;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.huawei.hmf.tasks.OnCompleteListener
        public final void MyBillsEntityDataFactory(Task<TResult> task) {
            if (task.KClassImpl$Data$declaredNonStaticMembers$2()) {
                this.getAuthRequestContext.scheduleImpl();
                return;
            }
            try {
                this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2((i) this.PlaceComponentResult.getAuthRequestContext());
            } catch (Exception e) {
                this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(e);
            }
        }
    }

    private Task<TResult> MyBillsEntityDataFactory(ExecuteResult<TResult> executeResult) {
        boolean PlaceComponentResult;
        synchronized (this.getAuthRequestContext) {
            PlaceComponentResult = PlaceComponentResult();
            if (!PlaceComponentResult) {
                this.scheduleImpl.add(executeResult);
            }
        }
        if (PlaceComponentResult) {
            executeResult.MyBillsEntityDataFactory(this);
        }
        return this;
    }

    private void lookAheadTest() {
        synchronized (this.getAuthRequestContext) {
            Iterator<ExecuteResult<TResult>> it = this.scheduleImpl.iterator();
            while (it.hasNext()) {
                try {
                    it.next().MyBillsEntityDataFactory(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.scheduleImpl = null;
        }
    }

    @Override // com.huawei.hmf.tasks.Task
    public final Exception BuiltInFictitiousFunctionClassFactory() {
        Exception exc;
        synchronized (this.getAuthRequestContext) {
            exc = this.BuiltInFictitiousFunctionClassFactory;
        }
        return exc;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Exception exc) {
        synchronized (this.getAuthRequestContext) {
            if (this.PlaceComponentResult) {
                return;
            }
            this.PlaceComponentResult = true;
            this.BuiltInFictitiousFunctionClassFactory = exc;
            this.getAuthRequestContext.notifyAll();
            lookAheadTest();
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(TResult tresult) {
        synchronized (this.getAuthRequestContext) {
            if (this.PlaceComponentResult) {
                return;
            }
            this.PlaceComponentResult = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = tresult;
            this.getAuthRequestContext.notifyAll();
            lookAheadTest();
        }
    }

    @Override // com.huawei.hmf.tasks.Task
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // com.huawei.hmf.tasks.Task
    public final boolean MyBillsEntityDataFactory() {
        boolean z;
        synchronized (this.getAuthRequestContext) {
            if (this.PlaceComponentResult && !KClassImpl$Data$declaredNonStaticMembers$2()) {
                z = this.BuiltInFictitiousFunctionClassFactory == null;
            }
        }
        return z;
    }

    @Override // com.huawei.hmf.tasks.Task
    public final boolean PlaceComponentResult() {
        boolean z;
        synchronized (this.getAuthRequestContext) {
            z = this.PlaceComponentResult;
        }
        return z;
    }

    @Override // com.huawei.hmf.tasks.Task
    public final TResult getAuthRequestContext() {
        TResult tresult;
        synchronized (this.getAuthRequestContext) {
            if (this.BuiltInFictitiousFunctionClassFactory != null) {
                throw new RuntimeException(this.BuiltInFictitiousFunctionClassFactory);
            }
            tresult = this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return tresult;
    }

    public final boolean scheduleImpl() {
        synchronized (this.getAuthRequestContext) {
            if (this.PlaceComponentResult) {
                return false;
            }
            this.PlaceComponentResult = true;
            this.MyBillsEntityDataFactory = true;
            this.getAuthRequestContext.notifyAll();
            lookAheadTest();
            return true;
        }
    }

    @Override // com.huawei.hmf.tasks.Task
    public final Task<TResult> MyBillsEntityDataFactory(OnCompleteListener<TResult> onCompleteListener) {
        return MyBillsEntityDataFactory(new d(TaskExecutors.MyBillsEntityDataFactory(), onCompleteListener));
    }

    @Override // com.huawei.hmf.tasks.Task
    public final Task<TResult> MyBillsEntityDataFactory(OnFailureListener onFailureListener) {
        return MyBillsEntityDataFactory(new f(TaskExecutors.MyBillsEntityDataFactory(), onFailureListener));
    }

    @Override // com.huawei.hmf.tasks.Task
    public final Task<TResult> getAuthRequestContext(OnSuccessListener<TResult> onSuccessListener) {
        return MyBillsEntityDataFactory(new h(TaskExecutors.MyBillsEntityDataFactory(), onSuccessListener));
    }
}

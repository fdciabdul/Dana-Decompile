package com.otaliastudios.cameraview.engine.orchestrator;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.internal.utils.WorkerHandler;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;

/* loaded from: classes8.dex */
public class CameraOrchestrator {
    protected static final CameraLogger PlaceComponentResult = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("CameraOrchestrator");
    protected final Callback KClassImpl$Data$declaredNonStaticMembers$2;
    protected final ArrayDeque<Token> BuiltInFictitiousFunctionClassFactory = new ArrayDeque<>();
    protected final Object getAuthRequestContext = new Object();
    private final Map<String, Runnable> MyBillsEntityDataFactory = new HashMap();

    /* loaded from: classes8.dex */
    public interface Callback {
        WorkerHandler BuiltInFictitiousFunctionClassFactory();

        void PlaceComponentResult(Exception exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes8.dex */
    public static class Token {
        public final Task<?> KClassImpl$Data$declaredNonStaticMembers$2;
        public final String getAuthRequestContext;

        /* synthetic */ Token(String str, Task task, byte b) {
            this(str, task);
        }

        private Token(String str, Task<?> task) {
            this.getAuthRequestContext = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = task;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Token) && ((Token) obj).getAuthRequestContext.equals(this.getAuthRequestContext);
        }
    }

    public CameraOrchestrator(Callback callback) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = callback;
        getAuthRequestContext();
    }

    /* renamed from: com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass1 implements Callable<Task<Void>> {
        final /* synthetic */ Runnable BuiltInFictitiousFunctionClassFactory;

        public AnonymousClass1(Runnable runnable) {
            this.BuiltInFictitiousFunctionClassFactory = runnable;
        }

        @Override // java.util.concurrent.Callable
        public /* synthetic */ Task<Void> call() throws Exception {
            this.BuiltInFictitiousFunctionClassFactory.run();
            return Tasks.forResult(null);
        }
    }

    public final <T> Task<T> PlaceComponentResult(final String str, final boolean z, final Callable<Task<T>> callable) {
        byte b = 0;
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(1, str.toUpperCase(), "- Scheduling.");
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        final WorkerHandler BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
        synchronized (this.getAuthRequestContext) {
            Task<?> task = this.BuiltInFictitiousFunctionClassFactory.getLast().KClassImpl$Data$declaredNonStaticMembers$2;
            OnCompleteListener<?> onCompleteListener = new OnCompleteListener() { // from class: com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.2
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public void onComplete(Task task2) {
                    synchronized (CameraOrchestrator.this.getAuthRequestContext) {
                        CameraOrchestrator.this.BuiltInFictitiousFunctionClassFactory.removeFirst();
                        CameraOrchestrator.this.getAuthRequestContext();
                    }
                    try {
                        CameraOrchestrator.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(1, str.toUpperCase(), "- Executing.");
                        CameraOrchestrator.KClassImpl$Data$declaredNonStaticMembers$2((Task) callable.call(), BuiltInFictitiousFunctionClassFactory, new OnCompleteListener<T>() { // from class: com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.2.1
                            @Override // com.google.android.gms.tasks.OnCompleteListener
                            public void onComplete(Task<T> task3) {
                                Exception exception = task3.getException();
                                if (exception == null) {
                                    if (task3.isCanceled()) {
                                        CameraOrchestrator.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(1, str.toUpperCase(), "- Finished because ABORTED.");
                                        taskCompletionSource.trySetException(new CancellationException());
                                        return;
                                    }
                                    CameraOrchestrator.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(1, str.toUpperCase(), "- Finished.");
                                    taskCompletionSource.trySetResult(task3.getResult());
                                    return;
                                }
                                CameraOrchestrator.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(2, str.toUpperCase(), "- Finished with ERROR.", exception);
                                if (z) {
                                    Callback callback = CameraOrchestrator.this.KClassImpl$Data$declaredNonStaticMembers$2;
                                    String str2 = str;
                                    callback.PlaceComponentResult(exception);
                                }
                                taskCompletionSource.trySetException(exception);
                            }
                        });
                    } catch (Exception e) {
                        CameraOrchestrator.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(1, str.toUpperCase(), "- Finished.", e);
                        if (z) {
                            CameraOrchestrator.this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(e);
                        }
                        taskCompletionSource.trySetException(e);
                    }
                }
            };
            if (task.isComplete()) {
                BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(new AnonymousClass4(onCompleteListener, task));
            } else {
                task.addOnCompleteListener(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, onCompleteListener);
            }
            this.BuiltInFictitiousFunctionClassFactory.addLast(new Token(str, taskCompletionSource.getTask(), b));
        }
        return taskCompletionSource.getTask();
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(final String str, long j, final Runnable runnable) {
        Runnable runnable2 = new Runnable() { // from class: com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.3
            @Override // java.lang.Runnable
            public void run() {
                CameraOrchestrator cameraOrchestrator = CameraOrchestrator.this;
                cameraOrchestrator.PlaceComponentResult(str, true, new AnonymousClass1(runnable));
                synchronized (CameraOrchestrator.this.getAuthRequestContext) {
                    if (CameraOrchestrator.this.MyBillsEntityDataFactory.containsValue(this)) {
                        CameraOrchestrator.this.MyBillsEntityDataFactory.remove(str);
                    }
                }
            }
        };
        synchronized (this.getAuthRequestContext) {
            this.MyBillsEntityDataFactory.put(str, runnable2);
            this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory.postDelayed(runnable2, j);
        }
    }

    public final void getAuthRequestContext(String str) {
        synchronized (this.getAuthRequestContext) {
            if (this.MyBillsEntityDataFactory.get(str) != null) {
                WorkerHandler BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
                BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.removeCallbacks(this.MyBillsEntityDataFactory.get(str));
                this.MyBillsEntityDataFactory.remove(str);
            }
            do {
            } while (this.BuiltInFictitiousFunctionClassFactory.remove(new Token(str, Tasks.forResult(null), (byte) 0)));
            getAuthRequestContext();
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        synchronized (this.getAuthRequestContext) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.MyBillsEntityDataFactory.keySet());
            Iterator<Token> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getAuthRequestContext);
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                getAuthRequestContext((String) it2.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAuthRequestContext() {
        synchronized (this.getAuthRequestContext) {
            if (this.BuiltInFictitiousFunctionClassFactory.isEmpty()) {
                this.BuiltInFictitiousFunctionClassFactory.add(new Token("BASE", Tasks.forResult(null), (byte) 0));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator$4  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static final class AnonymousClass4 implements Runnable {
        final /* synthetic */ Task BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ OnCompleteListener KClassImpl$Data$declaredNonStaticMembers$2;

        AnonymousClass4(OnCompleteListener onCompleteListener, Task task) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = onCompleteListener;
            this.BuiltInFictitiousFunctionClassFactory = task;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete(this.BuiltInFictitiousFunctionClassFactory);
        }
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Task task, WorkerHandler workerHandler, OnCompleteListener onCompleteListener) {
        if (task.isComplete()) {
            workerHandler.MyBillsEntityDataFactory(new AnonymousClass4(onCompleteListener, task));
        } else {
            task.addOnCompleteListener(workerHandler.getAuthRequestContext, onCompleteListener);
        }
    }
}

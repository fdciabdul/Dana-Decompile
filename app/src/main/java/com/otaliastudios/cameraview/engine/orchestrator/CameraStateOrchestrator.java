package com.otaliastudios.cameraview.engine.orchestrator;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator;
import java.util.Iterator;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class CameraStateOrchestrator extends CameraOrchestrator {
    public CameraState MyBillsEntityDataFactory;
    public CameraState getErrorConfigVersion;
    private int scheduleImpl;

    public CameraStateOrchestrator(CameraOrchestrator.Callback callback) {
        super(callback);
        this.MyBillsEntityDataFactory = CameraState.OFF;
        this.getErrorConfigVersion = CameraState.OFF;
        this.scheduleImpl = 0;
    }

    public final boolean getAuthRequestContext() {
        synchronized (this.getAuthRequestContext) {
            Iterator<CameraOrchestrator.Token> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
            while (it.hasNext()) {
                CameraOrchestrator.Token next = it.next();
                if (next.getAuthRequestContext.contains(" >> ") || next.getAuthRequestContext.contains(" << ")) {
                    if (!next.KClassImpl$Data$declaredNonStaticMembers$2.isComplete()) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public final <T> Task<T> PlaceComponentResult(final CameraState cameraState, final CameraState cameraState2, boolean z, final Callable<Task<T>> callable) {
        String obj;
        final int i = this.scheduleImpl + 1;
        this.scheduleImpl = i;
        this.getErrorConfigVersion = cameraState2;
        final boolean z2 = !cameraState2.isAtLeast(cameraState);
        if (z2) {
            StringBuilder sb = new StringBuilder();
            sb.append(cameraState.name());
            sb.append(" << ");
            sb.append(cameraState2.name());
            obj = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cameraState.name());
            sb2.append(" >> ");
            sb2.append(cameraState2.name());
            obj = sb2.toString();
        }
        final String str = obj;
        return PlaceComponentResult(obj, z, new Callable<Task<T>>() { // from class: com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator.2
            @Override // java.util.concurrent.Callable
            public /* synthetic */ Object call() throws Exception {
                if (CameraStateOrchestrator.this.MyBillsEntityDataFactory == cameraState) {
                    return ((Task) callable.call()).continueWithTask(CameraStateOrchestrator.this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory().getAuthRequestContext, new Continuation<T, Task<T>>() { // from class: com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator.2.1
                        @Override // com.google.android.gms.tasks.Continuation
                        public /* synthetic */ Object then(Task task) throws Exception {
                            if (task.isSuccessful() || z2) {
                                CameraStateOrchestrator.this.MyBillsEntityDataFactory = cameraState2;
                            }
                            return task;
                        }
                    });
                }
                CameraOrchestrator.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(2, str.toUpperCase(), "- State mismatch, aborting. current:", CameraStateOrchestrator.this.MyBillsEntityDataFactory, "from:", cameraState, "to:", cameraState2);
                return Tasks.forCanceled();
            }
        }).addOnCompleteListener(new OnCompleteListener<T>() { // from class: com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator.1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task<T> task) {
                if (i == CameraStateOrchestrator.this.scheduleImpl) {
                    CameraStateOrchestrator cameraStateOrchestrator = CameraStateOrchestrator.this;
                    cameraStateOrchestrator.getErrorConfigVersion = cameraStateOrchestrator.MyBillsEntityDataFactory;
                }
            }
        });
    }

    /* renamed from: com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ CameraState PlaceComponentResult;
        final /* synthetic */ Runnable getAuthRequestContext;

        public AnonymousClass3(CameraState cameraState, Runnable runnable) {
            this.PlaceComponentResult = cameraState;
            this.getAuthRequestContext = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CameraStateOrchestrator.this.MyBillsEntityDataFactory.isAtLeast(this.PlaceComponentResult)) {
                this.getAuthRequestContext.run();
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator$4  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass4 implements Runnable {
        final /* synthetic */ CameraState KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ Runnable PlaceComponentResult;

        public AnonymousClass4(CameraState cameraState, Runnable runnable) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = cameraState;
            this.PlaceComponentResult = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CameraStateOrchestrator.this.MyBillsEntityDataFactory.isAtLeast(this.KClassImpl$Data$declaredNonStaticMembers$2)) {
                this.PlaceComponentResult.run();
            }
        }
    }
}

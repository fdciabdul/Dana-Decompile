package androidx.view;

import android.os.Handler;
import androidx.view.Lifecycle;

/* loaded from: classes3.dex */
public class ServiceLifecycleDispatcher {
    final LifecycleRegistry KClassImpl$Data$declaredNonStaticMembers$2;
    private DispatchRunnable MyBillsEntityDataFactory;
    private final Handler getAuthRequestContext = new Handler();

    public ServiceLifecycleDispatcher(LifecycleOwner lifecycleOwner) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LifecycleRegistry(lifecycleOwner);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void PlaceComponentResult(Lifecycle.Event event) {
        DispatchRunnable dispatchRunnable = this.MyBillsEntityDataFactory;
        if (dispatchRunnable != null) {
            dispatchRunnable.run();
        }
        DispatchRunnable dispatchRunnable2 = new DispatchRunnable(this.KClassImpl$Data$declaredNonStaticMembers$2, event);
        this.MyBillsEntityDataFactory = dispatchRunnable2;
        this.getAuthRequestContext.postAtFrontOfQueue(dispatchRunnable2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class DispatchRunnable implements Runnable {
        final Lifecycle.Event BuiltInFictitiousFunctionClassFactory;
        private boolean MyBillsEntityDataFactory = false;
        private final LifecycleRegistry PlaceComponentResult;

        DispatchRunnable(LifecycleRegistry lifecycleRegistry, Lifecycle.Event event) {
            this.PlaceComponentResult = lifecycleRegistry;
            this.BuiltInFictitiousFunctionClassFactory = event;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.MyBillsEntityDataFactory) {
                return;
            }
            LifecycleRegistry lifecycleRegistry = this.PlaceComponentResult;
            Lifecycle.Event event = this.BuiltInFictitiousFunctionClassFactory;
            lifecycleRegistry.PlaceComponentResult("handleLifecycleEvent");
            lifecycleRegistry.getAuthRequestContext(event.getTargetState());
            this.MyBillsEntityDataFactory = true;
        }
    }
}

package androidx.view;

import androidx.view.Lifecycle;
import androidx.view.SavedStateRegistry;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class SavedStateHandleController implements LifecycleEventObserver {
    private boolean MyBillsEntityDataFactory = false;
    final SavedStateHandle PlaceComponentResult;
    private final String getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SavedStateHandleController(String str, SavedStateHandle savedStateHandle) {
        this.getAuthRequestContext = str;
        this.PlaceComponentResult = savedStateHandle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.MyBillsEntityDataFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        if (this.MyBillsEntityDataFactory) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.MyBillsEntityDataFactory = true;
        lifecycle.BuiltInFictitiousFunctionClassFactory(this);
        savedStateRegistry.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, this.PlaceComponentResult.PlaceComponentResult);
    }

    @Override // androidx.view.LifecycleEventObserver
    public final void BuiltInFictitiousFunctionClassFactory(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.MyBillsEntityDataFactory = false;
            lifecycleOwner.getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2(this);
        }
    }
}

package androidx.view;

import android.os.Bundle;
import androidx.view.Lifecycle;
import androidx.view.SavedStateHandle;
import androidx.view.SavedStateRegistry;
import androidx.view.SavedStateRegistryOwner;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
class LegacySavedStateHandleController {
    private LegacySavedStateHandleController() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SavedStateHandleController MyBillsEntityDataFactory(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle, String str, Bundle bundle) {
        SavedStateHandle MyBillsEntityDataFactory;
        MyBillsEntityDataFactory = SavedStateHandle.Companion.MyBillsEntityDataFactory(savedStateRegistry.PlaceComponentResult(str), bundle);
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, MyBillsEntityDataFactory);
        savedStateHandleController.MyBillsEntityDataFactory(savedStateRegistry, lifecycle);
        KClassImpl$Data$declaredNonStaticMembers$2(savedStateRegistry, lifecycle);
        return savedStateHandleController;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class OnRecreation implements SavedStateRegistry.AutoRecreated {
        OnRecreation() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.AutoRecreated
        public final void MyBillsEntityDataFactory(SavedStateRegistryOwner savedStateRegistryOwner) {
            if (!(savedStateRegistryOwner instanceof ViewModelStoreOwner)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
            }
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) savedStateRegistryOwner).getViewModelStore();
            SavedStateRegistry savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
            Iterator it = new HashSet(viewModelStore.BuiltInFictitiousFunctionClassFactory.keySet()).iterator();
            while (it.hasNext()) {
                LegacySavedStateHandleController.BuiltInFictitiousFunctionClassFactory(viewModelStore.BuiltInFictitiousFunctionClassFactory.get((String) it.next()), savedStateRegistry, savedStateRegistryOwner.getLifecycle());
            }
            if (new HashSet(viewModelStore.BuiltInFictitiousFunctionClassFactory.keySet()).isEmpty()) {
                return;
            }
            savedStateRegistry.BuiltInFictitiousFunctionClassFactory(OnRecreation.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void BuiltInFictitiousFunctionClassFactory(ViewModel viewModel, SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) viewModel.getTag("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.BuiltInFictitiousFunctionClassFactory()) {
            return;
        }
        savedStateHandleController.MyBillsEntityDataFactory(savedStateRegistry, lifecycle);
        KClassImpl$Data$declaredNonStaticMembers$2(savedStateRegistry, lifecycle);
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(final SavedStateRegistry savedStateRegistry, final Lifecycle lifecycle) {
        Lifecycle.State PlaceComponentResult = lifecycle.PlaceComponentResult();
        if (PlaceComponentResult == Lifecycle.State.INITIALIZED || PlaceComponentResult.isAtLeast(Lifecycle.State.STARTED)) {
            savedStateRegistry.BuiltInFictitiousFunctionClassFactory(OnRecreation.class);
        } else {
            lifecycle.BuiltInFictitiousFunctionClassFactory(new LifecycleEventObserver() { // from class: androidx.lifecycle.LegacySavedStateHandleController.1
                @Override // androidx.view.LifecycleEventObserver
                public void BuiltInFictitiousFunctionClassFactory(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_START) {
                        Lifecycle.this.KClassImpl$Data$declaredNonStaticMembers$2(this);
                        savedStateRegistry.BuiltInFictitiousFunctionClassFactory(OnRecreation.class);
                    }
                }
            });
        }
    }
}

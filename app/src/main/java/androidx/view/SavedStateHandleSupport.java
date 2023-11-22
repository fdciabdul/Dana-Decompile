package androidx.view;

import android.os.Bundle;
import androidx.view.Lifecycle;
import androidx.view.SavedStateHandle;
import androidx.view.SavedStateRegistry;
import androidx.view.SavedStateRegistryOwner;
import androidx.view.ViewModelProvider;
import androidx.view.viewmodel.CreationExtras;
import androidx.view.viewmodel.InitializerViewModelFactoryBuilder;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001f\u0010\b\u001a\u00020\u0007\"\f\b\u0000\u0010\u0006*\u00020\u0004*\u00020\u0005*\u00028\u0000¢\u0006\u0004\b\b\u0010\t\"\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\u0006\n\u0004\b\f\u0010\r\"\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\r\"\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\n8\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\r\"\u0018\u0010\u0002\u001a\u00020\u0010*\u00020\u00058AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0011"}, d2 = {"Landroidx/lifecycle/viewmodel/CreationExtras;", "Landroidx/lifecycle/SavedStateHandle;", "MyBillsEntityDataFactory", "(Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/SavedStateHandle;", "Landroidx/savedstate/SavedStateRegistryOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "T", "", "PlaceComponentResult", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "Landroid/os/Bundle;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "Landroidx/lifecycle/SavedStateHandlesVM;", "(Landroidx/lifecycle/ViewModelStoreOwner;)Landroidx/lifecycle/SavedStateHandlesVM;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SavedStateHandleSupport {
    public static final CreationExtras.Key<SavedStateRegistryOwner> BuiltInFictitiousFunctionClassFactory = new CreationExtras.Key<SavedStateRegistryOwner>() { // from class: androidx.lifecycle.SavedStateHandleSupport$SAVED_STATE_REGISTRY_OWNER_KEY$1
    };
    public static final CreationExtras.Key<ViewModelStoreOwner> getAuthRequestContext = new CreationExtras.Key<ViewModelStoreOwner>() { // from class: androidx.lifecycle.SavedStateHandleSupport$VIEW_MODEL_STORE_OWNER_KEY$1
    };
    public static final CreationExtras.Key<Bundle> KClassImpl$Data$declaredNonStaticMembers$2 = new CreationExtras.Key<Bundle>() { // from class: androidx.lifecycle.SavedStateHandleSupport$DEFAULT_ARGS_KEY$1
    };

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends SavedStateRegistryOwner & ViewModelStoreOwner> void PlaceComponentResult(T t) {
        Intrinsics.checkNotNullParameter(t, "");
        Lifecycle.State PlaceComponentResult = t.getLifecycle().PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        if (!(PlaceComponentResult == Lifecycle.State.INITIALIZED || PlaceComponentResult == Lifecycle.State.CREATED)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (t.getSavedStateRegistry().getAuthRequestContext("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            SavedStateHandlesProvider savedStateHandlesProvider = new SavedStateHandlesProvider(t.getSavedStateRegistry(), t);
            t.getSavedStateRegistry().KClassImpl$Data$declaredNonStaticMembers$2("androidx.lifecycle.internal.SavedStateHandlesProvider", savedStateHandlesProvider);
            t.getLifecycle().BuiltInFictitiousFunctionClassFactory(new SavedStateHandleAttacher(savedStateHandlesProvider));
        }
    }

    public static final SavedStateHandle MyBillsEntityDataFactory(CreationExtras creationExtras) {
        Intrinsics.checkNotNullParameter(creationExtras, "");
        SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) creationExtras.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory);
        if (savedStateRegistryOwner == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) creationExtras.PlaceComponentResult(getAuthRequestContext);
        if (viewModelStoreOwner == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) creationExtras.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
        String str = (String) creationExtras.PlaceComponentResult(ViewModelProvider.NewInstanceFactory.BuiltInFictitiousFunctionClassFactory);
        if (str == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
        }
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "");
        SavedStateRegistry.SavedStateProvider authRequestContext = savedStateRegistryOwner.getSavedStateRegistry().getAuthRequestContext("androidx.lifecycle.internal.SavedStateHandlesProvider");
        SavedStateHandlesProvider savedStateHandlesProvider = authRequestContext instanceof SavedStateHandlesProvider ? (SavedStateHandlesProvider) authRequestContext : null;
        if (savedStateHandlesProvider != null) {
            SavedStateHandlesVM KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(viewModelStoreOwner);
            SavedStateHandle savedStateHandle = KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult.get(str);
            if (savedStateHandle == null) {
                SavedStateHandle.Companion companion = SavedStateHandle.INSTANCE;
                Intrinsics.checkNotNullParameter(str, "");
                if (!savedStateHandlesProvider.getAuthRequestContext) {
                    savedStateHandlesProvider.MyBillsEntityDataFactory = savedStateHandlesProvider.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult("androidx.lifecycle.internal.SavedStateHandlesProvider");
                    savedStateHandlesProvider.getAuthRequestContext = true;
                    SavedStateHandlesVM savedStateHandlesVM = (SavedStateHandlesVM) savedStateHandlesProvider.BuiltInFictitiousFunctionClassFactory.getValue();
                }
                Bundle bundle2 = savedStateHandlesProvider.MyBillsEntityDataFactory;
                Bundle bundle3 = bundle2 != null ? bundle2.getBundle(str) : null;
                Bundle bundle4 = savedStateHandlesProvider.MyBillsEntityDataFactory;
                if (bundle4 != null) {
                    bundle4.remove(str);
                }
                Bundle bundle5 = savedStateHandlesProvider.MyBillsEntityDataFactory;
                if (bundle5 != null && bundle5.isEmpty()) {
                    savedStateHandlesProvider.MyBillsEntityDataFactory = null;
                }
                SavedStateHandle MyBillsEntityDataFactory = SavedStateHandle.Companion.MyBillsEntityDataFactory(bundle3, bundle);
                KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult.put(str, MyBillsEntityDataFactory);
                return MyBillsEntityDataFactory;
            }
            return savedStateHandle;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    public static final SavedStateHandlesVM KClassImpl$Data$declaredNonStaticMembers$2(ViewModelStoreOwner viewModelStoreOwner) {
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "");
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.BuiltInFictitiousFunctionClassFactory(Reflection.getOrCreateKotlinClass(SavedStateHandlesVM.class), new Function1<CreationExtras, SavedStateHandlesVM>() { // from class: androidx.lifecycle.SavedStateHandleSupport$savedStateHandlesVM$1$1
            @Override // kotlin.jvm.functions.Function1
            public final SavedStateHandlesVM invoke(CreationExtras creationExtras) {
                Intrinsics.checkNotNullParameter(creationExtras, "");
                return new SavedStateHandlesVM();
            }
        });
        return (SavedStateHandlesVM) new ViewModelProvider(viewModelStoreOwner, initializerViewModelFactoryBuilder.BuiltInFictitiousFunctionClassFactory()).getAuthRequestContext("androidx.lifecycle.internal.SavedStateHandlesVM", SavedStateHandlesVM.class);
    }
}

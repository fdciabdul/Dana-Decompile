package androidx.view;

import android.app.Application;
import android.os.Bundle;
import androidx.view.SavedStateRegistry;
import androidx.view.SavedStateRegistryOwner;
import androidx.view.ViewModelProvider;
import androidx.view.viewmodel.CreationExtras;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0016¢\u0006\u0004\b\u001e\u0010\u001fB%\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\n\u001a\u00020 \u0012\b\u0010!\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001e\u0010\"J'\u0010\u0007\u001a\u00028\u0000\"\b\b\u0000\u0010\u0004*\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u000b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0004*\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u000e\u001a\u00028\u0000\"\b\b\u0000\u0010\u0004*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0007\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d"}, d2 = {"Landroidx/lifecycle/SavedStateViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$OnRequeryFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "p1", "MyBillsEntityDataFactory", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "", "(Landroidx/lifecycle/ViewModel;)V", "Landroid/app/Application;", "PlaceComponentResult", "Landroid/app/Application;", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/Lifecycle;", "Landroidx/savedstate/SavedStateRegistry;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroidx/savedstate/SavedStateRegistry;", "<init>", "()V", "Landroidx/savedstate/SavedStateRegistryOwner;", "p2", "(Landroid/app/Application;Landroidx/savedstate/SavedStateRegistryOwner;Landroid/os/Bundle;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private Lifecycle getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final ViewModelProvider.Factory BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private SavedStateRegistry MyBillsEntityDataFactory;
    private Application PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private Bundle KClassImpl$Data$declaredNonStaticMembers$2;

    public SavedStateViewModelFactory() {
        this.BuiltInFictitiousFunctionClassFactory = new ViewModelProvider.AndroidViewModelFactory();
    }

    public SavedStateViewModelFactory(Application application, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
        ViewModelProvider.AndroidViewModelFactory androidViewModelFactory;
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "");
        this.MyBillsEntityDataFactory = savedStateRegistryOwner.getSavedStateRegistry();
        this.getAuthRequestContext = savedStateRegistryOwner.getLifecycle();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bundle;
        this.PlaceComponentResult = application;
        if (application != null) {
            ViewModelProvider.AndroidViewModelFactory.Companion companion = ViewModelProvider.AndroidViewModelFactory.INSTANCE;
            androidViewModelFactory = ViewModelProvider.AndroidViewModelFactory.Companion.getAuthRequestContext(application);
        } else {
            androidViewModelFactory = new ViewModelProvider.AndroidViewModelFactory();
        }
        this.BuiltInFictitiousFunctionClassFactory = androidViewModelFactory;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final <T extends ViewModel> T MyBillsEntityDataFactory(Class<T> p0, CreationExtras p1) {
        List list;
        Constructor KClassImpl$Data$declaredNonStaticMembers$2;
        List list2;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        String str = (String) p1.PlaceComponentResult(ViewModelProvider.NewInstanceFactory.BuiltInFictitiousFunctionClassFactory);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (p1.PlaceComponentResult(SavedStateHandleSupport.BuiltInFictitiousFunctionClassFactory) != null && p1.PlaceComponentResult(SavedStateHandleSupport.getAuthRequestContext) != null) {
            Application application = (Application) p1.PlaceComponentResult(ViewModelProvider.AndroidViewModelFactory.KClassImpl$Data$declaredNonStaticMembers$2);
            boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(p0);
            if (!isAssignableFrom || application == null) {
                list = SavedStateViewModelFactoryKt.getAuthRequestContext;
                KClassImpl$Data$declaredNonStaticMembers$2 = SavedStateViewModelFactoryKt.KClassImpl$Data$declaredNonStaticMembers$2(p0, list);
            } else {
                list2 = SavedStateViewModelFactoryKt.KClassImpl$Data$declaredNonStaticMembers$2;
                KClassImpl$Data$declaredNonStaticMembers$2 = SavedStateViewModelFactoryKt.KClassImpl$Data$declaredNonStaticMembers$2(p0, list2);
            }
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                return (T) this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(p0, p1);
            }
            return (!isAssignableFrom || application == null) ? (T) SavedStateViewModelFactoryKt.getAuthRequestContext(p0, KClassImpl$Data$declaredNonStaticMembers$2, SavedStateHandleSupport.MyBillsEntityDataFactory(p1)) : (T) SavedStateViewModelFactoryKt.getAuthRequestContext(p0, KClassImpl$Data$declaredNonStaticMembers$2, application, SavedStateHandleSupport.MyBillsEntityDataFactory(p1));
        } else if (this.getAuthRequestContext != null) {
            return (T) getAuthRequestContext(str, p0);
        } else {
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
    }

    private <T extends ViewModel> T getAuthRequestContext(String p0, Class<T> p1) {
        List list;
        Constructor KClassImpl$Data$declaredNonStaticMembers$2;
        T t;
        Application application;
        List list2;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (this.getAuthRequestContext == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(p1);
        if (!isAssignableFrom || this.PlaceComponentResult == null) {
            list = SavedStateViewModelFactoryKt.getAuthRequestContext;
            KClassImpl$Data$declaredNonStaticMembers$2 = SavedStateViewModelFactoryKt.KClassImpl$Data$declaredNonStaticMembers$2(p1, list);
        } else {
            list2 = SavedStateViewModelFactoryKt.KClassImpl$Data$declaredNonStaticMembers$2;
            KClassImpl$Data$declaredNonStaticMembers$2 = SavedStateViewModelFactoryKt.KClassImpl$Data$declaredNonStaticMembers$2(p1, list2);
        }
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            if (this.PlaceComponentResult != null) {
                return (T) this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(p1);
            }
            ViewModelProvider.NewInstanceFactory.Companion companion = ViewModelProvider.NewInstanceFactory.INSTANCE;
            return (T) ViewModelProvider.NewInstanceFactory.Companion.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory(p1);
        }
        SavedStateHandleController MyBillsEntityDataFactory = LegacySavedStateHandleController.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory, this.getAuthRequestContext, p0, this.KClassImpl$Data$declaredNonStaticMembers$2);
        if (isAssignableFrom && (application = this.PlaceComponentResult) != null) {
            Intrinsics.checkNotNull(application);
            SavedStateHandle savedStateHandle = MyBillsEntityDataFactory.PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(savedStateHandle, "");
            t = (T) SavedStateViewModelFactoryKt.getAuthRequestContext(p1, KClassImpl$Data$declaredNonStaticMembers$2, application, savedStateHandle);
        } else {
            SavedStateHandle savedStateHandle2 = MyBillsEntityDataFactory.PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(savedStateHandle2, "");
            t = (T) SavedStateViewModelFactoryKt.getAuthRequestContext(p1, KClassImpl$Data$declaredNonStaticMembers$2, savedStateHandle2);
        }
        t.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", MyBillsEntityDataFactory);
        return t;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final <T extends ViewModel> T BuiltInFictitiousFunctionClassFactory(Class<T> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String canonicalName = p0.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) getAuthRequestContext(canonicalName, p0);
    }

    @Override // androidx.lifecycle.ViewModelProvider.OnRequeryFactory
    public final void BuiltInFictitiousFunctionClassFactory(ViewModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Lifecycle lifecycle = this.getAuthRequestContext;
        if (lifecycle != null) {
            LegacySavedStateHandleController.BuiltInFictitiousFunctionClassFactory(p0, this.MyBillsEntityDataFactory, lifecycle);
        }
    }
}

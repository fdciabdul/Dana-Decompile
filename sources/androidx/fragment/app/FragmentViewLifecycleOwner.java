package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.view.HasDefaultViewModelProviderFactory;
import androidx.view.Lifecycle;
import androidx.view.LifecycleRegistry;
import androidx.view.SavedStateHandleSupport;
import androidx.view.SavedStateRegistry;
import androidx.view.SavedStateRegistryController;
import androidx.view.SavedStateRegistryOwner;
import androidx.view.SavedStateViewModelFactory;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import androidx.view.viewmodel.CreationExtras;
import androidx.view.viewmodel.MutableCreationExtras;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class FragmentViewLifecycleOwner implements HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, ViewModelStoreOwner {
    private final ViewModelStore BuiltInFictitiousFunctionClassFactory;
    private ViewModelProvider.Factory PlaceComponentResult;
    private final Fragment getAuthRequestContext;
    LifecycleRegistry MyBillsEntityDataFactory = null;
    SavedStateRegistryController KClassImpl$Data$declaredNonStaticMembers$2 = null;

    public FragmentViewLifecycleOwner(Fragment fragment, ViewModelStore viewModelStore) {
        this.getAuthRequestContext = fragment;
        this.BuiltInFictitiousFunctionClassFactory = viewModelStore;
    }

    @Override // androidx.view.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        KClassImpl$Data$declaredNonStaticMembers$2();
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.MyBillsEntityDataFactory == null) {
            this.MyBillsEntityDataFactory = new LifecycleRegistry(this);
            SavedStateRegistryController BuiltInFictitiousFunctionClassFactory = SavedStateRegistryController.BuiltInFictitiousFunctionClassFactory(this);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
        }
    }

    public final boolean PlaceComponentResult() {
        return this.MyBillsEntityDataFactory != null;
    }

    @Override // androidx.view.LifecycleOwner
    public Lifecycle getLifecycle() {
        KClassImpl$Data$declaredNonStaticMembers$2();
        return this.MyBillsEntityDataFactory;
    }

    public final void MyBillsEntityDataFactory(Lifecycle.Event event) {
        LifecycleRegistry lifecycleRegistry = this.MyBillsEntityDataFactory;
        lifecycleRegistry.PlaceComponentResult("handleLifecycleEvent");
        lifecycleRegistry.getAuthRequestContext(event.getTargetState());
    }

    @Override // androidx.view.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        Application application;
        ViewModelProvider.Factory defaultViewModelProviderFactory = this.getAuthRequestContext.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(this.getAuthRequestContext.mDefaultFactory)) {
            this.PlaceComponentResult = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.PlaceComponentResult == null) {
            Context applicationContext = this.getAuthRequestContext.requireContext().getApplicationContext();
            while (true) {
                application = null;
                if (!(applicationContext instanceof ContextWrapper)) {
                    break;
                } else if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                } else {
                    applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
                }
            }
            Fragment fragment = this.getAuthRequestContext;
            this.PlaceComponentResult = new SavedStateViewModelFactory(application, fragment, fragment.getArguments());
        }
        return this.PlaceComponentResult;
    }

    @Override // androidx.view.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = this.getAuthRequestContext.requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            } else if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            } else {
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras();
        if (application != null) {
            CreationExtras.Key<Application> key = ViewModelProvider.AndroidViewModelFactory.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullParameter(key, "");
            mutableCreationExtras.MyBillsEntityDataFactory.put(key, application);
        }
        CreationExtras.Key<SavedStateRegistryOwner> key2 = SavedStateHandleSupport.BuiltInFictitiousFunctionClassFactory;
        Fragment fragment = this.getAuthRequestContext;
        Intrinsics.checkNotNullParameter(key2, "");
        mutableCreationExtras.MyBillsEntityDataFactory.put(key2, fragment);
        CreationExtras.Key<ViewModelStoreOwner> key3 = SavedStateHandleSupport.getAuthRequestContext;
        Intrinsics.checkNotNullParameter(key3, "");
        mutableCreationExtras.MyBillsEntityDataFactory.put(key3, this);
        if (this.getAuthRequestContext.getArguments() != null) {
            CreationExtras.Key<Bundle> key4 = SavedStateHandleSupport.KClassImpl$Data$declaredNonStaticMembers$2;
            Bundle arguments = this.getAuthRequestContext.getArguments();
            Intrinsics.checkNotNullParameter(key4, "");
            mutableCreationExtras.MyBillsEntityDataFactory.put(key4, arguments);
        }
        return mutableCreationExtras;
    }

    @Override // androidx.view.SavedStateRegistryOwner
    public SavedStateRegistry getSavedStateRegistry() {
        KClassImpl$Data$declaredNonStaticMembers$2();
        return this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Bundle bundle) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(bundle);
    }
}

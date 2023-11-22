package androidx.view;

import android.os.Bundle;
import androidx.view.SavedStateRegistry;
import androidx.view.SavedStateRegistryOwner;
import androidx.view.ViewModelProvider;
import androidx.view.viewmodel.CreationExtras;

/* loaded from: classes3.dex */
public abstract class AbstractSavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {
    private Bundle BuiltInFictitiousFunctionClassFactory;
    private Lifecycle KClassImpl$Data$declaredNonStaticMembers$2;
    private SavedStateRegistry getAuthRequestContext;

    protected abstract <T extends ViewModel> T MyBillsEntityDataFactory(String str, Class<T> cls, SavedStateHandle savedStateHandle);

    public AbstractSavedStateViewModelFactory() {
    }

    public AbstractSavedStateViewModelFactory(SavedStateRegistryOwner savedStateRegistryOwner) {
        this.getAuthRequestContext = savedStateRegistryOwner.getSavedStateRegistry();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = savedStateRegistryOwner.getLifecycle();
        this.BuiltInFictitiousFunctionClassFactory = null;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final <T extends ViewModel> T MyBillsEntityDataFactory(Class<T> cls, CreationExtras creationExtras) {
        String str = (String) creationExtras.PlaceComponentResult(ViewModelProvider.NewInstanceFactory.BuiltInFictitiousFunctionClassFactory);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (this.getAuthRequestContext != null) {
            return (T) MyBillsEntityDataFactory(str, cls);
        }
        return (T) MyBillsEntityDataFactory(str, cls, SavedStateHandleSupport.MyBillsEntityDataFactory(creationExtras));
    }

    private <T extends ViewModel> T MyBillsEntityDataFactory(String str, Class<T> cls) {
        SavedStateHandleController MyBillsEntityDataFactory = LegacySavedStateHandleController.MyBillsEntityDataFactory(this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, str, this.BuiltInFictitiousFunctionClassFactory);
        T t = (T) MyBillsEntityDataFactory(str, cls, MyBillsEntityDataFactory.PlaceComponentResult);
        t.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", MyBillsEntityDataFactory);
        return t;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final <T extends ViewModel> T BuiltInFictitiousFunctionClassFactory(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            throw new UnsupportedOperationException("AbstractSavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        return (T) MyBillsEntityDataFactory(canonicalName, cls);
    }

    @Override // androidx.lifecycle.ViewModelProvider.OnRequeryFactory
    public final void BuiltInFictitiousFunctionClassFactory(ViewModel viewModel) {
        SavedStateRegistry savedStateRegistry = this.getAuthRequestContext;
        if (savedStateRegistry != null) {
            LegacySavedStateHandleController.BuiltInFictitiousFunctionClassFactory(viewModel, savedStateRegistry, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }
}

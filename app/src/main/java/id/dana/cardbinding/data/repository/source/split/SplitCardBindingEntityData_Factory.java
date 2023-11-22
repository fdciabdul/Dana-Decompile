package id.dana.cardbinding.data.repository.source.split;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SplitCardBindingEntityData_Factory implements Factory<SplitCardBindingEntityData> {
    private final Provider<SplitFacade> BuiltInFictitiousFunctionClassFactory;

    private SplitCardBindingEntityData_Factory(Provider<SplitFacade> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static SplitCardBindingEntityData_Factory PlaceComponentResult(Provider<SplitFacade> provider) {
        return new SplitCardBindingEntityData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitCardBindingEntityData(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

package id.dana.kyb.data.repository.source.split;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitKybConfigEntityData_Factory implements Factory<SplitKybConfigEntityData> {
    private final Provider<SplitFacade> BuiltInFictitiousFunctionClassFactory;

    private SplitKybConfigEntityData_Factory(Provider<SplitFacade> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static SplitKybConfigEntityData_Factory MyBillsEntityDataFactory(Provider<SplitFacade> provider) {
        return new SplitKybConfigEntityData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitKybConfigEntityData(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

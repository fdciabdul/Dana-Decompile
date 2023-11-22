package id.dana.mybills.data.repository.source.split;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SplitMyBillsEntityData_Factory implements Factory<SplitMyBillsEntityData> {
    private final Provider<SplitFacade> PlaceComponentResult;

    private SplitMyBillsEntityData_Factory(Provider<SplitFacade> provider) {
        this.PlaceComponentResult = provider;
    }

    public static SplitMyBillsEntityData_Factory BuiltInFictitiousFunctionClassFactory(Provider<SplitFacade> provider) {
        return new SplitMyBillsEntityData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitMyBillsEntityData(this.PlaceComponentResult.get());
    }
}

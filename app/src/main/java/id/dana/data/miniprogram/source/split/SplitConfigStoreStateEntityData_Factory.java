package id.dana.data.miniprogram.source.split;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitConfigStoreStateEntityData_Factory implements Factory<SplitConfigStoreStateEntityData> {
    private final Provider<SplitFacade> BuiltInFictitiousFunctionClassFactory;

    private SplitConfigStoreStateEntityData_Factory(Provider<SplitFacade> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static SplitConfigStoreStateEntityData_Factory PlaceComponentResult(Provider<SplitFacade> provider) {
        return new SplitConfigStoreStateEntityData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitConfigStoreStateEntityData(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

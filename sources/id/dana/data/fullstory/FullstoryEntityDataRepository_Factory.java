package id.dana.data.fullstory;

import dagger.internal.Factory;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.data.storage.PreferenceFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FullstoryEntityDataRepository_Factory implements Factory<FullstoryEntityDataRepository> {
    private final Provider<SplitConfigEntityData> BuiltInFictitiousFunctionClassFactory;
    private final Provider<PreferenceFacade> getAuthRequestContext;

    private FullstoryEntityDataRepository_Factory(Provider<SplitConfigEntityData> provider, Provider<PreferenceFacade> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.getAuthRequestContext = provider2;
    }

    public static FullstoryEntityDataRepository_Factory PlaceComponentResult(Provider<SplitConfigEntityData> provider, Provider<PreferenceFacade> provider2) {
        return new FullstoryEntityDataRepository_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FullstoryEntityDataRepository(this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get());
    }
}

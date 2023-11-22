package id.dana.sync_engine.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SyncEngineModule_ProvideSecureSharePreferenceFactory implements Factory<PreferenceFacade> {
    private final Provider<Serializer> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> getAuthRequestContext;

    private SyncEngineModule_ProvideSecureSharePreferenceFactory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.getAuthRequestContext = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
    }

    public static SyncEngineModule_ProvideSecureSharePreferenceFactory getAuthRequestContext(Provider<Context> provider, Provider<Serializer> provider2) {
        return new SyncEngineModule_ProvideSecureSharePreferenceFactory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PreferenceFacade) Preconditions.BuiltInFictitiousFunctionClassFactory(SyncEngineModule.MyBillsEntityDataFactory(this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}

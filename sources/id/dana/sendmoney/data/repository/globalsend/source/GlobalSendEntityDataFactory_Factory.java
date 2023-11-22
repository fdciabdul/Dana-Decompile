package id.dana.sendmoney.data.repository.globalsend.source;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GlobalSendEntityDataFactory_Factory implements Factory<GlobalSendEntityDataFactory> {
    private final Provider<GlobalSendEntityData> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GlobalSendEntityData> MyBillsEntityDataFactory;
    private final Provider<GlobalSendEntityData> PlaceComponentResult;
    private final Provider<GlobalSendEntityData> getAuthRequestContext;

    private GlobalSendEntityDataFactory_Factory(Provider<GlobalSendEntityData> provider, Provider<GlobalSendEntityData> provider2, Provider<GlobalSendEntityData> provider3, Provider<GlobalSendEntityData> provider4) {
        this.PlaceComponentResult = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.getAuthRequestContext = provider4;
    }

    public static GlobalSendEntityDataFactory_Factory BuiltInFictitiousFunctionClassFactory(Provider<GlobalSendEntityData> provider, Provider<GlobalSendEntityData> provider2, Provider<GlobalSendEntityData> provider3, Provider<GlobalSendEntityData> provider4) {
        return new GlobalSendEntityDataFactory_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GlobalSendEntityDataFactory(this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get());
    }
}

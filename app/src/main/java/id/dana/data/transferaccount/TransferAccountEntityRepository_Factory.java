package id.dana.data.transferaccount;

import dagger.internal.Factory;
import id.dana.data.transferaccount.source.local.TransferAccountPreference;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class TransferAccountEntityRepository_Factory implements Factory<TransferAccountEntityRepository> {
    private final Provider<TransferAccountPreference> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<TransferAccountEntityDataFactory> getAuthRequestContext;

    private TransferAccountEntityRepository_Factory(Provider<TransferAccountEntityDataFactory> provider, Provider<TransferAccountPreference> provider2) {
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static TransferAccountEntityRepository_Factory BuiltInFictitiousFunctionClassFactory(Provider<TransferAccountEntityDataFactory> provider, Provider<TransferAccountPreference> provider2) {
        return new TransferAccountEntityRepository_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TransferAccountEntityRepository(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}

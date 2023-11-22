package id.dana.explore.data.userpersonalization.source;

import dagger.internal.Factory;
import id.dana.explore.data.userpersonalization.source.local.LocalUserPersonalizationEntityData;
import id.dana.explore.data.userpersonalization.source.network.NetworkUserPersonalizationEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserPersonalizationEntityDataFactory_Factory implements Factory<UserPersonalizationEntityDataFactory> {
    private final Provider<LocalUserPersonalizationEntityData> BuiltInFictitiousFunctionClassFactory;
    private final Provider<NetworkUserPersonalizationEntityData> MyBillsEntityDataFactory;

    private UserPersonalizationEntityDataFactory_Factory(Provider<NetworkUserPersonalizationEntityData> provider, Provider<LocalUserPersonalizationEntityData> provider2) {
        this.MyBillsEntityDataFactory = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
    }

    public static UserPersonalizationEntityDataFactory_Factory MyBillsEntityDataFactory(Provider<NetworkUserPersonalizationEntityData> provider, Provider<LocalUserPersonalizationEntityData> provider2) {
        return new UserPersonalizationEntityDataFactory_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UserPersonalizationEntityDataFactory(this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

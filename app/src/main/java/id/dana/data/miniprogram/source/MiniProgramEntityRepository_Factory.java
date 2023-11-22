package id.dana.data.miniprogram.source;

import dagger.internal.Factory;
import id.dana.data.miniprogram.source.local.PreferenceStoreMiniProgramsEntityData;
import id.dana.data.miniprogram.source.network.NetworkMiniPrograms;
import id.dana.data.miniprogram.source.split.SplitConfigStoreStateEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MiniProgramEntityRepository_Factory implements Factory<MiniProgramEntityRepository> {
    private final Provider<SplitConfigStoreStateEntityData> BuiltInFictitiousFunctionClassFactory;
    private final Provider<PreferenceStoreMiniProgramsEntityData> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<NetworkMiniPrograms> getAuthRequestContext;

    private MiniProgramEntityRepository_Factory(Provider<PreferenceStoreMiniProgramsEntityData> provider, Provider<SplitConfigStoreStateEntityData> provider2, Provider<NetworkMiniPrograms> provider3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.getAuthRequestContext = provider3;
    }

    public static MiniProgramEntityRepository_Factory MyBillsEntityDataFactory(Provider<PreferenceStoreMiniProgramsEntityData> provider, Provider<SplitConfigStoreStateEntityData> provider2, Provider<NetworkMiniPrograms> provider3) {
        return new MiniProgramEntityRepository_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MiniProgramEntityRepository(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get());
    }
}

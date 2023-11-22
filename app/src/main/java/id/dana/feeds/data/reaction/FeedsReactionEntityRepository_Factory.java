package id.dana.feeds.data.reaction;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.feeds.data.config.source.FeedsConfigDataFactory;
import id.dana.feeds.data.mapper.ContactDeviceNameMapper;
import id.dana.feeds.data.reaction.source.FeedsReactionDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FeedsReactionEntityRepository_Factory implements Factory<FeedsReactionEntityRepository> {
    private final Provider<HoldLoginV1EntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<FeedsReactionDataFactory> MyBillsEntityDataFactory;
    private final Provider<FeedsConfigDataFactory> PlaceComponentResult;
    private final Provider<ContactDeviceNameMapper> getAuthRequestContext;

    private FeedsReactionEntityRepository_Factory(Provider<FeedsConfigDataFactory> provider, Provider<FeedsReactionDataFactory> provider2, Provider<HoldLoginV1EntityRepository> provider3, Provider<ContactDeviceNameMapper> provider4) {
        this.PlaceComponentResult = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.getAuthRequestContext = provider4;
    }

    public static FeedsReactionEntityRepository_Factory PlaceComponentResult(Provider<FeedsConfigDataFactory> provider, Provider<FeedsReactionDataFactory> provider2, Provider<HoldLoginV1EntityRepository> provider3, Provider<ContactDeviceNameMapper> provider4) {
        return new FeedsReactionEntityRepository_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedsReactionEntityRepository(this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get());
    }
}

package id.dana.feeds.domain.share.interactor;

import dagger.internal.Factory;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.share.FeedsShareRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class CreateFeedActivity_Factory implements Factory<CreateFeedActivity> {
    private final Provider<FeedsShareRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<MixpanelRepository> MyBillsEntityDataFactory;

    private CreateFeedActivity_Factory(Provider<FeedsShareRepository> provider, Provider<MixpanelRepository> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static CreateFeedActivity_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<FeedsShareRepository> provider, Provider<MixpanelRepository> provider2) {
        return new CreateFeedActivity_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CreateFeedActivity(this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get());
    }
}

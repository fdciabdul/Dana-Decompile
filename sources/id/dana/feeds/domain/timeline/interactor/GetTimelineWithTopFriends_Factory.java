package id.dana.feeds.domain.timeline.interactor;

import dagger.internal.Factory;
import id.dana.domain.account.AccountRepository;
import id.dana.feeds.domain.timeline.FeedsTimelineRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetTimelineWithTopFriends_Factory implements Factory<GetTimelineWithTopFriends> {
    private final Provider<FeedsTimelineRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<AccountRepository> MyBillsEntityDataFactory;

    private GetTimelineWithTopFriends_Factory(Provider<FeedsTimelineRepository> provider, Provider<AccountRepository> provider2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static GetTimelineWithTopFriends_Factory BuiltInFictitiousFunctionClassFactory(Provider<FeedsTimelineRepository> provider, Provider<AccountRepository> provider2) {
        return new GetTimelineWithTopFriends_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetTimelineWithTopFriends(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}

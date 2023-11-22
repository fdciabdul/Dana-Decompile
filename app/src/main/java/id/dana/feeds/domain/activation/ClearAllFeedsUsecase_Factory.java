package id.dana.feeds.domain.activation;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ClearAllFeedsUsecase_Factory implements Factory<ClearAllFeedsUsecase> {
    private final Provider<FeedInitRepository> MyBillsEntityDataFactory;

    private ClearAllFeedsUsecase_Factory(Provider<FeedInitRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static ClearAllFeedsUsecase_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<FeedInitRepository> provider) {
        return new ClearAllFeedsUsecase_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ClearAllFeedsUsecase(this.MyBillsEntityDataFactory.get());
    }
}

package id.dana.playstorereview;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.playstorereview.interactor.IsNeedToShowPlayStoreReview;
import id.dana.domain.playstorereview.interactor.SaveLastPlayStoreReviewShow;
import id.dana.playstorereview.PlayStoreReviewContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class PlayStoreReviewPresenter_Factory implements Factory<PlayStoreReviewPresenter> {
    private final Provider<IsNeedToShowPlayStoreReview> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<PlayStoreReviewContract.View> PlaceComponentResult;
    private final Provider<SaveLastPlayStoreReviewShow> getAuthRequestContext;

    private PlayStoreReviewPresenter_Factory(Provider<IsNeedToShowPlayStoreReview> provider, Provider<SaveLastPlayStoreReviewShow> provider2, Provider<PlayStoreReviewContract.View> provider3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.getAuthRequestContext = provider2;
        this.PlaceComponentResult = provider3;
    }

    public static PlayStoreReviewPresenter_Factory MyBillsEntityDataFactory(Provider<IsNeedToShowPlayStoreReview> provider, Provider<SaveLastPlayStoreReviewShow> provider2, Provider<PlayStoreReviewContract.View> provider3) {
        return new PlayStoreReviewPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PlayStoreReviewPresenter(DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
    }
}

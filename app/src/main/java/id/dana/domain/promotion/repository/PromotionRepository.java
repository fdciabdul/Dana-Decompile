package id.dana.domain.promotion.repository;

import id.dana.domain.promotion.Space;
import id.dana.domain.promotion.model.BannerCollection;
import io.reactivex.Completable;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface PromotionRepository {
    Completable decrementFreeTransferCount(String str);

    Observable<Integer> getFreeTransferCount(String str);

    Observable<BannerCollection> getHomePromotionBanner();

    Observable<Space> getHomeReferralEntryBanner();

    Observable<Space> getHomeReferralP2PEntryBanner();

    Observable<Space> getHomeShoppingBanner();

    Observable<BannerCollection> getInterstitialPromotionBanner();

    Observable<Space> getLeaderboardEntryBanner();

    Observable<Space> getPromoClaimBannerConfiguration();

    Observable<Space> getReferralTrackerEmptyPlaceholder();

    Observable<Boolean> readInterstitialPromotionBanner(String str);

    Observable<Boolean> saveInterstitialBannerGapTime(Long l);

    Observable<Boolean> saveInterstitialBannerResetTime(Long l);
}

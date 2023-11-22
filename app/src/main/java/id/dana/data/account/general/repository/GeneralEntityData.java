package id.dana.data.account.general.repository;

import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0012\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\f\u001a\u00020\bH&¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\u0013\u0010\u0012J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\u0014\u0010\u0012J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\u0015\u0010\u0012J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0016\u001a\u00020\bH&¢\u0006\u0004\b\u0017\u0010\u000bJ\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0018\u001a\u00020\bH&¢\u0006\u0004\b\u0019\u0010\u000bJ\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u0005H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u0005H&¢\u0006\u0004\b\u001d\u0010\u001cJ\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u0005H&¢\u0006\u0004\b\u001e\u0010\u001cJ\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u001a\u001a\u00020\u0005H&¢\u0006\u0004\b\u001f\u0010\u001cJ\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b \u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/account/general/repository/GeneralEntityData;", "", "", "contentId", "Lio/reactivex/Observable;", "", "checkReadInterstitialBanner", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "resetTimeSettings", "checkResetInterstitialBannerReadList", "(J)Lio/reactivex/Observable;", "gapTimeSettings", "checkShouldShowInterstitialBanner", "", "clearAll", "()V", "getBalanceVisibility", "()Lio/reactivex/Observable;", "getEmasBalanceVisibility", "getGoalsBalanceVisibility", "getInvestmentBalanceVisibility", "gapTimeInUnix", "saveInterstitialBannerNextGapTime", "resetTimeInUnix", "saveInterstitialBannerNextResetTime", "newState", "setBalanceVisibility", "(Z)Lio/reactivex/Observable;", "setEmasBalanceVisibility", "setGoalsBalanceVisibility", "setInvestmentBalanceVisibility", "setReadInterstitialBanner"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface GeneralEntityData {
    Observable<Boolean> checkReadInterstitialBanner(String contentId);

    Observable<Boolean> checkResetInterstitialBannerReadList(long resetTimeSettings);

    Observable<Boolean> checkShouldShowInterstitialBanner(long gapTimeSettings);

    void clearAll();

    Observable<Boolean> getBalanceVisibility();

    Observable<Boolean> getEmasBalanceVisibility();

    Observable<Boolean> getGoalsBalanceVisibility();

    Observable<Boolean> getInvestmentBalanceVisibility();

    Observable<Boolean> saveInterstitialBannerNextGapTime(long gapTimeInUnix);

    Observable<Boolean> saveInterstitialBannerNextResetTime(long resetTimeInUnix);

    Observable<Boolean> setBalanceVisibility(boolean newState);

    Observable<Boolean> setEmasBalanceVisibility(boolean newState);

    Observable<Boolean> setGoalsBalanceVisibility(boolean newState);

    Observable<Boolean> setInvestmentBalanceVisibility(boolean newState);

    Observable<String> setReadInterstitialBanner(String contentId);
}

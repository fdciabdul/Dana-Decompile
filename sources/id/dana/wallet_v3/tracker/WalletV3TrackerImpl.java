package id.dana.wallet_v3.tracker;

import id.dana.analytics.tracker.AnalyticsTracker;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeTabActivity;
import id.dana.data.auth.face.repository.source.network.NetworkFaceAuthenticationEntityData;
import id.dana.tracker.constant.TrackerType;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0011\b\u0007\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u000bJ9\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u000bJ\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u0011J1\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\u001fJ'\u0010\"\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b$\u0010\u001fJ\u001f\u0010%\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\fH\u0016¢\u0006\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)"}, d2 = {"Lid/dana/wallet_v3/tracker/WalletV3TrackerImpl;", "Lid/dana/wallet_v3/tracker/WalletV3Tracker;", "Lid/dana/analytics/tracker/AnalyticsTracker;", "createMixpanelAnalytic", "()Lid/dana/analytics/tracker/AnalyticsTracker;", "", "source", "", "Lkotlin/Pair;", "", "getAddAssetProperty", "(Ljava/lang/String;)[Lkotlin/Pair;", "", "dealsVersion", "getDealsUIBasedOnVersion", "(I)Ljava/lang/String;", "getPageSource", "(Ljava/lang/String;)Ljava/lang/String;", "getSearchBarOpenEventProperty", "keyword", NetworkFaceAuthenticationEntityData.PAGE_SOURCE, "getSearchBarSubmitEventProperty", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)[Lkotlin/Pair;", HomeTabActivity.WALLET_SECTION, "getSectionExpandedProperty", "getSectionName", "danaDealsVersion", "getWalletOpenProperty", "(Ljava/lang/String;I)[Lkotlin/Pair;", "", "trackOpenAddAsset", "(Ljava/lang/String;)V", "trackOpenSearchBar", "triggerSource", "trackSearchBarSubmit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "trackSectionExpanded", "trackWalletV3Open", "(Ljava/lang/String;I)V", "Lid/dana/analytics/tracker/AnalyticsTrackerFactory;", "anyAnalyticsFactory", "Lid/dana/analytics/tracker/AnalyticsTrackerFactory;", "<init>", "(Lid/dana/analytics/tracker/AnalyticsTrackerFactory;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WalletV3TrackerImpl implements WalletV3Tracker {
    private static final int DEALS_OLD_UI_VERSION = 1;
    private final AnalyticsTrackerFactory anyAnalyticsFactory;

    private final String getDealsUIBasedOnVersion(int dealsVersion) {
        return dealsVersion > 1 ? "New UI" : TrackerKey.WalletDanaDealsVersion.DANA_DEALS_OLD_UI;
    }

    @Inject
    public WalletV3TrackerImpl(AnalyticsTrackerFactory analyticsTrackerFactory) {
        Intrinsics.checkNotNullParameter(analyticsTrackerFactory, "");
        this.anyAnalyticsFactory = analyticsTrackerFactory;
    }

    @Override // id.dana.wallet_v3.tracker.WalletV3Tracker
    public final void trackOpenSearchBar(String source) {
        Intrinsics.checkNotNullParameter(source, "");
        createMixpanelAnalytic().KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.DANA_WALLET_SEARCH_BAR_OPEN, getSearchBarOpenEventProperty(source));
    }

    @Override // id.dana.wallet_v3.tracker.WalletV3Tracker
    public final void trackSearchBarSubmit(String triggerSource, String keyword, String pageSource) {
        Intrinsics.checkNotNullParameter(triggerSource, "");
        Intrinsics.checkNotNullParameter(keyword, "");
        Intrinsics.checkNotNullParameter(pageSource, "");
        createMixpanelAnalytic().KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.DANA_WALLET_SEARCH_BAR_SUBMIT, getSearchBarSubmitEventProperty(triggerSource, keyword, pageSource));
    }

    @Override // id.dana.wallet_v3.tracker.WalletV3Tracker
    public final void trackSectionExpanded(String section) {
        Intrinsics.checkNotNullParameter(section, "");
        createMixpanelAnalytic().KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.DANA_WALLET_SECTION_OPEN, getSectionExpandedProperty(section));
    }

    @Override // id.dana.wallet_v3.tracker.WalletV3Tracker
    public final void trackOpenAddAsset(String source) {
        Intrinsics.checkNotNullParameter(source, "");
        createMixpanelAnalytic().KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.DANA_WALLET_ADD_ASSET_OPEN, getAddAssetProperty(source));
    }

    @Override // id.dana.wallet_v3.tracker.WalletV3Tracker
    public final void trackWalletV3Open(String source, int danaDealsVersion) {
        Intrinsics.checkNotNullParameter(source, "");
        createMixpanelAnalytic().KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.DANA_WALLET_V3_OPEN, getWalletOpenProperty(source, danaDealsVersion));
    }

    private final Pair<String, Object>[] getSearchBarOpenEventProperty(String source) {
        return new Pair[]{TuplesKt.to(TrackerKey.DanaWalletProperties.SEARCH_OPEN_PAGE, getPageSource(source))};
    }

    private final Pair<String, Object>[] getSearchBarSubmitEventProperty(String source, String keyword, String pageSource) {
        return new Pair[]{TuplesKt.to(TrackerKey.DanaWalletProperties.SEARCH_SUBMIT_TRIGGER_SOURCE, source), TuplesKt.to(TrackerKey.DanaWalletProperties.KEYWORD_SEARCHED, keyword), TuplesKt.to(TrackerKey.DanaWalletProperties.SEARCH_SUBMIT_PAGE, getPageSource(pageSource))};
    }

    private final Pair<String, Object>[] getSectionExpandedProperty(String section) {
        return new Pair[]{TuplesKt.to(TrackerKey.DanaWalletProperties.SECTION_NAME, getSectionName(section))};
    }

    private final Pair<String, Object>[] getAddAssetProperty(String source) {
        return new Pair[]{TuplesKt.to(TrackerKey.DanaWalletProperties.ADD_SOURCE, source)};
    }

    private final Pair<String, Object>[] getWalletOpenProperty(String source, int danaDealsVersion) {
        return new Pair[]{TuplesKt.to("Source", source), TuplesKt.to(TrackerKey.DanaWalletProperties.DEALS_VERSION, getDealsUIBasedOnVersion(danaDealsVersion))};
    }

    private final String getPageSource(String source) {
        switch (source.hashCode()) {
            case -786681338:
                if (source.equals("payment")) {
                    return TrackerKey.DanaWalletSearchPageSource.SECTION_PAYMENT_SEARCH;
                }
                break;
            case -135761730:
                if (source.equals("identity")) {
                    return TrackerKey.DanaWalletSearchPageSource.SECTION_IDENTITY_SEARCH;
                }
                break;
            case -80148248:
                if (source.equals("general")) {
                    return "Global Search";
                }
                break;
            case 357555337:
                if (source.equals("financial")) {
                    return TrackerKey.DanaWalletSearchPageSource.SECTION_FINANCIALS_SEARCH;
                }
                break;
            case 358728774:
                if (source.equals("loyalty")) {
                    return TrackerKey.DanaWalletSearchPageSource.SECTION_LOYALTY_SEARCH;
                }
                break;
            case 1018752165:
                if (source.equals("voucher_and_ticket")) {
                    return TrackerKey.DanaWalletSearchPageSource.SECTION_VOUCHERS_SEARCH;
                }
                break;
        }
        return "";
    }

    private final String getSectionName(String section) {
        switch (section.hashCode()) {
            case -1150817175:
                if (section.equals("FINANCIAL")) {
                    return TrackerKey.DanaWalletSectionName.WALLET_FINANCIAL;
                }
                break;
            case -554006299:
                if (section.equals("VOUCHER_AND_TICKET")) {
                    return "Voucher";
                }
                break;
            case -68698650:
                if (section.equals("PAYMENT")) {
                    return TrackerKey.DanaWalletSectionName.WALLET_PAYMENT;
                }
                break;
            case 646865086:
                if (section.equals("IDENTITY")) {
                    return TrackerKey.DanaWalletSectionName.WALLET_IDENTITY;
                }
                break;
            case 1076711462:
                if (section.equals("LOYALTY")) {
                    return "Loyalty";
                }
                break;
        }
        return "";
    }

    private final AnalyticsTracker createMixpanelAnalytic() {
        return this.anyAnalyticsFactory.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL);
    }
}

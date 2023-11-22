package id.dana.wallet_v3.tracker;

import id.dana.animation.HomeTabActivity;
import id.dana.data.auth.face.repository.source.network.NetworkFaceAuthenticationEntityData;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J'\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0006J\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/tracker/WalletV3Tracker;", "", "", "source", "", "trackOpenAddAsset", "(Ljava/lang/String;)V", "trackOpenSearchBar", "triggerSource", "keyword", NetworkFaceAuthenticationEntityData.PAGE_SOURCE, "trackSearchBarSubmit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", HomeTabActivity.WALLET_SECTION, "trackSectionExpanded", "", "danaDealsVersion", "trackWalletV3Open", "(Ljava/lang/String;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface WalletV3Tracker {
    void trackOpenAddAsset(String source);

    void trackOpenSearchBar(String source);

    void trackSearchBarSubmit(String triggerSource, String keyword, String pageSource);

    void trackSectionExpanded(String section);

    void trackWalletV3Open(String source, int danaDealsVersion);
}

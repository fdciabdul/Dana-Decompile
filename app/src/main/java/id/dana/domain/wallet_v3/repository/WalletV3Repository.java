package id.dana.domain.wallet_v3.repository;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.animation.HomeTabActivity;
import id.dana.domain.pocket.model.AssetStatus;
import id.dana.domain.pocket.model.PocketQueryList;
import id.dana.domain.wallet_v3.model.AssetRecommendation;
import id.dana.domain.wallet_v3.model.KtpInfo;
import id.dana.domain.wallet_v3.model.PocketUpdateModel;
import id.dana.domain.wallet_v3.model.UserAssetsWrapperModel;
import id.dana.domain.wallet_v3.model.UserPocketAssetListModel;
import id.dana.domain.wallet_v3.model.UserPocketAssetModel;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J@\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rH&J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\u0006\u0010\u0013\u001a\u00020\u0010H&J\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\u0003H&J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\u0003H&J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rH&JH\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010H&J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u001b\u001a\u00020\nH&J\u001c\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\u00032\u0006\u0010\u001d\u001a\u00020\u0010H&J\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00032\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rH&J(\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u00032\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010H&J\u001c\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\u00032\u0006\u0010\u001d\u001a\u00020\u0010H&JN\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\b\u0010#\u001a\u0004\u0018\u00010\u0010H&JN\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010H&J\u001c\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\u00032\u0006\u0010\u001d\u001a\u00020\u0010H&J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003H&J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00032\u0006\u0010\u001b\u001a\u00020\nH&J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u00032\u0006\u0010\u001b\u001a\u00020\nH&J\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020(0\u00032\u0006\u0010#\u001a\u00020\u0010H&J\u001c\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0019\u001a\u00020\u0010H&J$\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00032\u0006\u0010\u0019\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\rH&J*\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00032\u0006\u0010\u0019\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\rH&J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00032\u0006\u00100\u001a\u00020\u0010H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00061À\u0006\u0001"}, d2 = {"Lid/dana/domain/wallet_v3/repository/WalletV3Repository;", "", "getKtpInfoFromLocal", "Lio/reactivex/Observable;", "Lid/dana/domain/pocket/model/PocketQueryList;", "Lid/dana/domain/wallet_v3/model/KtpInfo;", "getPocketRedDotAsset", "Lid/dana/domain/wallet_v3/model/UserPocketAssetListModel;", "Lid/dana/domain/wallet_v3/model/UserPocketAssetModel;", "pageNum", "", SecurityConstants.KEY_PAGE_SIZE, "statuses", "", "Lid/dana/domain/pocket/model/AssetStatus;", "assetTypes", "", "getRecommendationConfig", "Lid/dana/domain/wallet_v3/model/AssetRecommendation;", "key", "getRecommendationConfigKey", "getSavedAssetTypes", "getTotalSavedPaymentAssets", "assetType", "getTotalSavedPocketAssets", "cardTitle", "getTotalSectionQuery", HomeTabActivity.WALLET_SECTION, "getUserIdentityViaQuery", "query", "getUserPaymentAssets", "Lid/dana/domain/wallet_v3/model/UserAssetsWrapperModel;", "getUserPaymentAssetsFromLocal", "getUserPaymentViaQuery", "getUserPocketAssets", "order", "getUserPocketAssetsFromLocal", "getUserPocketViaQuery", "getVoucherAndTicketOrder", "resetWalletSectionOpen", "", "saveIWalletSectionQuery", "saveVoucherAndTicketOrder", "searchUserIdentityAssets", "searchUserPaymentAssets", "searchUserPocketAssets", "updateUserPocketAssets", "Lid/dana/domain/wallet_v3/model/PocketUpdateModel;", "pocketId", "domain_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface WalletV3Repository {
    Observable<PocketQueryList<KtpInfo>> getKtpInfoFromLocal();

    Observable<UserPocketAssetListModel<UserPocketAssetModel>> getPocketRedDotAsset(int pageNum, int pageSize, List<? extends AssetStatus> statuses, List<String> assetTypes);

    Observable<AssetRecommendation> getRecommendationConfig(String key);

    Observable<List<String>> getRecommendationConfigKey();

    Observable<List<String>> getSavedAssetTypes();

    Observable<Integer> getTotalSavedPaymentAssets(List<String> assetType);

    Observable<Integer> getTotalSavedPocketAssets(int pageNum, int pageSize, List<? extends AssetStatus> statuses, List<String> assetTypes, String cardTitle);

    Observable<Integer> getTotalSectionQuery(int section);

    Observable<List<String>> getUserIdentityViaQuery(String query);

    Observable<UserAssetsWrapperModel> getUserPaymentAssets(List<String> assetType);

    Observable<UserAssetsWrapperModel> getUserPaymentAssetsFromLocal(List<String> assetType, String cardTitle);

    Observable<List<String>> getUserPaymentViaQuery(String query);

    Observable<UserPocketAssetListModel<UserPocketAssetModel>> getUserPocketAssets(int pageNum, int pageSize, List<? extends AssetStatus> statuses, List<String> assetTypes, String order);

    Observable<UserPocketAssetListModel<UserPocketAssetModel>> getUserPocketAssetsFromLocal(int pageNum, int pageSize, List<? extends AssetStatus> statuses, List<String> assetTypes, String cardTitle);

    Observable<List<String>> getUserPocketViaQuery(String query);

    Observable<String> getVoucherAndTicketOrder();

    Observable<Unit> resetWalletSectionOpen(int section);

    Observable<Unit> saveIWalletSectionQuery(int section);

    Observable<Unit> saveVoucherAndTicketOrder(String order);

    Observable<PocketQueryList<KtpInfo>> searchUserIdentityAssets(String cardTitle);

    Observable<UserAssetsWrapperModel> searchUserPaymentAssets(String cardTitle, List<String> assetType);

    Observable<UserPocketAssetListModel<UserPocketAssetModel>> searchUserPocketAssets(String cardTitle, List<String> assetType);

    Observable<PocketUpdateModel> updateUserPocketAssets(String pocketId);

    /* renamed from: id.dana.domain.wallet_v3.repository.WalletV3Repository$-CC  reason: invalid class name */
    /* loaded from: classes8.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Observable getUserPocketAssets$default(WalletV3Repository walletV3Repository, int i, int i2, List list, List list2, String str, int i3, Object obj) {
            if (obj == null) {
                return walletV3Repository.getUserPocketAssets((i3 & 1) != 0 ? 1 : i, (i3 & 2) != 0 ? 10 : i2, list, list2, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserPocketAssets");
        }

        public static /* synthetic */ Observable getUserPocketAssetsFromLocal$default(WalletV3Repository walletV3Repository, int i, int i2, List list, List list2, String str, int i3, Object obj) {
            if (obj == null) {
                return walletV3Repository.getUserPocketAssetsFromLocal((i3 & 1) != 0 ? 1 : i, (i3 & 2) != 0 ? 10 : i2, list, list2, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserPocketAssetsFromLocal");
        }

        public static /* synthetic */ Observable getTotalSavedPocketAssets$default(WalletV3Repository walletV3Repository, int i, int i2, List list, List list2, String str, int i3, Object obj) {
            if (obj == null) {
                return walletV3Repository.getTotalSavedPocketAssets((i3 & 1) != 0 ? 1 : i, (i3 & 2) != 0 ? 10 : i2, list, list2, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTotalSavedPocketAssets");
        }
    }
}

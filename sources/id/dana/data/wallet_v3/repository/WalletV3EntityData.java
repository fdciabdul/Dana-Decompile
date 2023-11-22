package id.dana.data.wallet_v3.repository;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.data.pocket.model.KtpAssetResult;
import id.dana.data.pocket.model.UserStatus;
import id.dana.data.wallet_v3.model.PocketUpdateResult;
import id.dana.data.wallet_v3.model.UserPocketAssetEntity;
import id.dana.data.wallet_v3.model.UserPocketAssetResult;
import id.dana.data.wallet_v3.repository.source.network.result.KtpResult;
import id.dana.data.wallet_v3.repository.source.network.result.UserAssetInfosResult;
import id.dana.data.wallet_v3.repository.source.network.result.UserAssetsWrapperResult;
import id.dana.domain.pocket.model.AssetStatus;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007H&JJ\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\nH&J\u0014\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007H&J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u00072\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH&JV\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000bH&J\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00072\u0006\u0010\u001f\u001a\u00020\u000bH&J*\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00072\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000bH&J\u001c\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00072\u0006\u0010\u001f\u001a\u00020\u000bH&JV\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000bH&J\u001c\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00072\u0006\u0010\u001f\u001a\u00020\u000bH&J\u0016\u0010%\u001a\u00020\u00052\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\nH&J\u0016\u0010(\u001a\u00020\u00052\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\nH&J\u0016\u0010+\u001a\u00020\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\nH&J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u001c\u001a\u00020\u000bH&J$\u0010/\u001a\b\u0012\u0004\u0012\u00020!0\u00072\u0006\u0010\u001c\u001a\u00020\u000b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J$\u00100\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\u001c\u001a\u00020\u000b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\u001e\u00101\u001a\b\u0012\u0004\u0012\u0002020\u00072\u0006\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00065À\u0006\u0001"}, d2 = {"Lid/dana/data/wallet_v3/repository/WalletV3EntityData;", "", "clearAll", "", "deleteKtpDetailInfo", "Lio/reactivex/Completable;", "deleteUserPaymentAssets", "Lio/reactivex/Observable;", "", "uniqueId", "", "", "getKtpDetailInfo", "Lid/dana/data/pocket/model/KtpAssetResult;", "getPocketRedDotAsset", "Lid/dana/data/wallet_v3/model/UserPocketAssetResult;", "pageNum", "", SecurityConstants.KEY_PAGE_SIZE, "statuses", "Lid/dana/domain/pocket/model/AssetStatus;", "assetTypes", "userStatus", "Lid/dana/data/pocket/model/UserStatus;", "getSavedAssetTypes", "getTotalUserPaymentAssets", "assetType", "getTotalUserPocketAssets", "cardTitle", "order", "getUserIdentityViaQuery", "query", "getUserPaymentAssets", "Lid/dana/data/wallet_v3/repository/source/network/result/UserAssetsWrapperResult;", "getUserPaymentViaQuery", "getUserPocketAssets", "getUserPocketViaQuery", "saveKtpDetailInfo", "ktpResult", "Lid/dana/data/wallet_v3/repository/source/network/result/KtpResult;", "saveUserPaymentAssets", "assetInfos", "Lid/dana/data/wallet_v3/repository/source/network/result/UserAssetInfosResult;", "saveUserPocketAssets", "pocketAssets", "Lid/dana/data/wallet_v3/model/UserPocketAssetEntity;", "searchUserIdentityAssets", "searchUserPaymentAssets", "searchUserPocketAssets", "updateUserPocketAssets", "Lid/dana/data/wallet_v3/model/PocketUpdateResult;", "userId", "pocketId", "data_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface WalletV3EntityData {
    void clearAll();

    Completable deleteKtpDetailInfo();

    Observable<Boolean> deleteUserPaymentAssets(List<String> uniqueId);

    Observable<KtpAssetResult> getKtpDetailInfo();

    Observable<UserPocketAssetResult> getPocketRedDotAsset(int pageNum, int r2, List<? extends AssetStatus> statuses, List<String> assetTypes, List<? extends UserStatus> userStatus);

    Observable<List<String>> getSavedAssetTypes();

    Observable<Integer> getTotalUserPaymentAssets(List<String> assetType);

    Observable<Integer> getTotalUserPocketAssets(int pageNum, int r2, List<? extends AssetStatus> statuses, List<String> assetTypes, String cardTitle, String order);

    Observable<List<String>> getUserIdentityViaQuery(String query);

    Observable<UserAssetsWrapperResult> getUserPaymentAssets(List<String> assetType, String cardTitle);

    Observable<List<String>> getUserPaymentViaQuery(String query);

    Observable<UserPocketAssetResult> getUserPocketAssets(int pageNum, int r2, List<? extends AssetStatus> statuses, List<String> assetTypes, String cardTitle, String order);

    Observable<List<String>> getUserPocketViaQuery(String query);

    Completable saveKtpDetailInfo(List<KtpResult> ktpResult);

    Completable saveUserPaymentAssets(List<UserAssetInfosResult> assetInfos);

    Completable saveUserPocketAssets(List<UserPocketAssetEntity> pocketAssets);

    Observable<KtpAssetResult> searchUserIdentityAssets(String cardTitle);

    Observable<UserAssetsWrapperResult> searchUserPaymentAssets(String cardTitle, List<String> assetType);

    Observable<UserPocketAssetResult> searchUserPocketAssets(String cardTitle, List<String> assetType);

    Observable<PocketUpdateResult> updateUserPocketAssets(String userId, String pocketId);

    /* renamed from: id.dana.data.wallet_v3.repository.WalletV3EntityData$-CC */
    /* loaded from: classes4.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Observable getUserPaymentAssets$default(WalletV3EntityData walletV3EntityData, List list, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = null;
                }
                return walletV3EntityData.getUserPaymentAssets(list, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserPaymentAssets");
        }

        public static /* synthetic */ Observable getPocketRedDotAsset$default(WalletV3EntityData walletV3EntityData, int i, int i2, List list, List list2, List list3, int i3, Object obj) {
            if (obj == null) {
                List list4 = list3;
                if ((i3 & 16) != 0) {
                    list4 = CollectionsKt.listOf(UserStatus.UNREAD);
                }
                return walletV3EntityData.getPocketRedDotAsset(i, i2, list, list2, list4);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPocketRedDotAsset");
        }

        public static /* synthetic */ Observable getUserPocketAssets$default(WalletV3EntityData walletV3EntityData, int i, int i2, List list, List list2, String str, String str2, int i3, Object obj) {
            if (obj == null) {
                return walletV3EntityData.getUserPocketAssets((i3 & 1) != 0 ? 1 : i, (i3 & 2) != 0 ? 10 : i2, list, list2, (i3 & 16) != 0 ? null : str, (i3 & 32) != 0 ? null : str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserPocketAssets");
        }

        public static /* synthetic */ Observable getTotalUserPocketAssets$default(WalletV3EntityData walletV3EntityData, int i, int i2, List list, List list2, String str, String str2, int i3, Object obj) {
            if (obj == null) {
                return walletV3EntityData.getTotalUserPocketAssets((i3 & 1) != 0 ? 1 : i, (i3 & 2) != 0 ? 10 : i2, list, list2, (i3 & 16) != 0 ? null : str, (i3 & 32) != 0 ? null : str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTotalUserPocketAssets");
        }
    }
}

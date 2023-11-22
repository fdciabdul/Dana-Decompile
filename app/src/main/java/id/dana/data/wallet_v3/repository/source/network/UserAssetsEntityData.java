package id.dana.data.wallet_v3.repository.source.network;

import id.dana.animation.HomeTabActivity;
import id.dana.data.wallet_v3.repository.source.network.result.UserAssetInfosResult;
import id.dana.data.wallet_v3.repository.source.network.result.UserAssetsWrapperResult;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JY\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H&¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006H&¢\u0006\u0004\b\u0010\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/network/UserAssetsEntityData;", "", "", "ipRoleId", "", "enableOnly", "", HomeTabActivity.WALLET_SECTION, "assetBizType", "assetType", "Lio/reactivex/Observable;", "Lid/dana/data/wallet_v3/repository/source/network/result/UserAssetsWrapperResult;", "getUserAssets", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lio/reactivex/Observable;", "Lid/dana/data/wallet_v3/repository/source/network/result/UserAssetInfosResult;", "cards", "saveRecentUserAssets", "(Ljava/util/List;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public interface UserAssetsEntityData {
    Observable<UserAssetsWrapperResult> getUserAssets(String ipRoleId, Boolean enableOnly, List<String> section, List<String> assetBizType, List<String> assetType);

    Observable<Boolean> saveRecentUserAssets(List<UserAssetInfosResult> cards);
}

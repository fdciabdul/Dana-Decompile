package id.dana.data.wallet_v3.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.pocket.model.PocketQueryListRequest;
import id.dana.data.wallet_v3.model.PocketUpdateRequest;
import id.dana.data.wallet_v3.model.PocketUpdateResult;
import id.dana.data.wallet_v3.model.UserPocketAssetResult;
import id.dana.data.wallet_v3.repository.source.network.request.UserAssetsRequest;
import id.dana.data.wallet_v3.repository.source.network.result.UserAssetsWrapperResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/network/WalletV3Facade;", "", "Lid/dana/data/wallet_v3/repository/source/network/request/UserAssetsRequest;", "request", "Lid/dana/data/wallet_v3/repository/source/network/result/UserAssetsWrapperResult;", "queryUserPaymentAssets", "(Lid/dana/data/wallet_v3/repository/source/network/request/UserAssetsRequest;)Lid/dana/data/wallet_v3/repository/source/network/result/UserAssetsWrapperResult;", "Lid/dana/data/pocket/model/PocketQueryListRequest;", "Lid/dana/data/wallet_v3/model/UserPocketAssetResult;", "queryUserPocketAsset", "(Lid/dana/data/pocket/model/PocketQueryListRequest;)Lid/dana/data/wallet_v3/model/UserPocketAssetResult;", "Lid/dana/data/wallet_v3/model/PocketUpdateRequest;", "Lid/dana/data/wallet_v3/model/PocketUpdateResult;", "updateUserPocketAsset", "(Lid/dana/data/wallet_v3/model/PocketUpdateRequest;)Lid/dana/data/wallet_v3/model/PocketUpdateResult;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface WalletV3Facade {
    @OperationType("id.dana.omniprod.user.asset.query")
    @SignCheck
    UserAssetsWrapperResult queryUserPaymentAssets(UserAssetsRequest request);

    @OperationType("id.dana.omniprod.user.pocket.list")
    @SignCheck
    UserPocketAssetResult queryUserPocketAsset(PocketQueryListRequest request);

    @OperationType("id.dana.omniprod.user.pocket.update.pocket")
    @SignCheck
    PocketUpdateResult updateUserPocketAsset(PocketUpdateRequest request);
}

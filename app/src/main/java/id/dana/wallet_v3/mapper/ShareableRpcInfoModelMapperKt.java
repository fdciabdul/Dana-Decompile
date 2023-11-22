package id.dana.wallet_v3.mapper;

import id.dana.domain.pocket.model.ShareableRpcInfo;
import id.dana.wallet_v3.model.ShareableRpcInfoModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/pocket/model/ShareableRpcInfo;", "Lid/dana/wallet_v3/model/ShareableRpcInfoModel;", "toShareableRpcInfoModel", "(Lid/dana/domain/pocket/model/ShareableRpcInfo;)Lid/dana/wallet_v3/model/ShareableRpcInfoModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShareableRpcInfoModelMapperKt {
    public static final ShareableRpcInfoModel toShareableRpcInfoModel(ShareableRpcInfo shareableRpcInfo) {
        Intrinsics.checkNotNullParameter(shareableRpcInfo, "");
        return new ShareableRpcInfoModel(shareableRpcInfo.getReceiverInfo(), shareableRpcInfo.getReceiverUserId(), shareableRpcInfo.getSharedDate());
    }
}

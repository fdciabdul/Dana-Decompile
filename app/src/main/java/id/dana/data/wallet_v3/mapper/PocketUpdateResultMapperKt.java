package id.dana.data.wallet_v3.mapper;

import id.dana.data.wallet_v3.model.PocketUpdateResult;
import id.dana.domain.wallet_v3.model.PocketUpdateModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/wallet_v3/model/PocketUpdateResult;", "Lid/dana/domain/wallet_v3/model/PocketUpdateModel;", "toPocketUpdateModel", "(Lid/dana/data/wallet_v3/model/PocketUpdateResult;)Lid/dana/domain/wallet_v3/model/PocketUpdateModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PocketUpdateResultMapperKt {
    public static final PocketUpdateModel toPocketUpdateModel(PocketUpdateResult pocketUpdateResult) {
        Intrinsics.checkNotNullParameter(pocketUpdateResult, "");
        PocketUpdateModel pocketUpdateModel = new PocketUpdateModel(pocketUpdateResult.getPocketId());
        pocketUpdateModel.setSuccess(pocketUpdateResult.success);
        return pocketUpdateModel;
    }
}

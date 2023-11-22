package id.dana.data.pocket.mapper;

import id.dana.data.pocket.model.PocketInfoEntity;
import id.dana.domain.pocket.model.PocketInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/pocket/model/PocketInfoEntity;", "Lid/dana/domain/pocket/model/PocketInfo;", "toPocketInfo", "(Lid/dana/data/pocket/model/PocketInfoEntity;)Lid/dana/domain/pocket/model/PocketInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class PocketQueryListMapperKt {
    public static final PocketInfo toPocketInfo(PocketInfoEntity pocketInfoEntity) {
        Intrinsics.checkNotNullParameter(pocketInfoEntity, "");
        return new PocketInfo(pocketInfoEntity.getPocketId(), pocketInfoEntity.getPocketStatus(), pocketInfoEntity.getUserPocketStatus(), pocketInfoEntity.getPocketType(), pocketInfoEntity.getGoodsId(), pocketInfoEntity.getMerchantId(), pocketInfoEntity.getLabel(), pocketInfoEntity.getSubLabel(), pocketInfoEntity.getIconUrl(), pocketInfoEntity.getLogoUrl(), pocketInfoEntity.getBackgroundUrl(), pocketInfoEntity.getPoints(), pocketInfoEntity.getNumber(), pocketInfoEntity.getUsable(), pocketInfoEntity.getShareable(), pocketInfoEntity.getExpirationDate(), pocketInfoEntity.getExtendInfo());
    }
}

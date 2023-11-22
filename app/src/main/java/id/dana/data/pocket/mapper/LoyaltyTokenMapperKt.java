package id.dana.data.pocket.mapper;

import id.dana.data.pocket.model.LoyaltyTokenEntity;
import id.dana.domain.pocket.model.LoyaltyToken;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/pocket/model/LoyaltyTokenEntity;", "Lid/dana/domain/pocket/model/LoyaltyToken;", "toLoyaltyToken", "(Lid/dana/data/pocket/model/LoyaltyTokenEntity;)Lid/dana/domain/pocket/model/LoyaltyToken;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoyaltyTokenMapperKt {
    public static final LoyaltyToken toLoyaltyToken(LoyaltyTokenEntity loyaltyTokenEntity) {
        Intrinsics.checkNotNullParameter(loyaltyTokenEntity, "");
        return new LoyaltyToken(loyaltyTokenEntity.getAccessToken(), loyaltyTokenEntity.getExpiresIn(), loyaltyTokenEntity.getRefreshToken());
    }
}

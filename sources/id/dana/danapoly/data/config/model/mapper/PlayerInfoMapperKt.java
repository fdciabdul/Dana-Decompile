package id.dana.danapoly.data.config.model.mapper;

import id.dana.danapoly.data.config.model.response.PlayerInfoResponse;
import id.dana.danapoly.domain.config.model.PlayerInfo;
import id.dana.data.account.repository.AccountEntityRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/danapoly/data/config/model/response/PlayerInfoResponse;", "", "currencyValue", "", AccountEntityRepository.UpdateType.AVATAR, "Lid/dana/danapoly/domain/config/model/PlayerInfo;", "toPlayerInfo", "(Lid/dana/danapoly/data/config/model/response/PlayerInfoResponse;ILjava/lang/String;)Lid/dana/danapoly/domain/config/model/PlayerInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PlayerInfoMapperKt {
    public static /* synthetic */ PlayerInfo toPlayerInfo$default(PlayerInfoResponse playerInfoResponse, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "";
        }
        return toPlayerInfo(playerInfoResponse, i, str);
    }

    public static final PlayerInfo toPlayerInfo(PlayerInfoResponse playerInfoResponse, int i, String str) {
        Intrinsics.checkNotNullParameter(playerInfoResponse, "");
        Intrinsics.checkNotNullParameter(str, "");
        Integer danaPoints = playerInfoResponse.getDanaPoints();
        int intValue = danaPoints != null ? danaPoints.intValue() : 0;
        Integer position = playerInfoResponse.getPosition();
        return new PlayerInfo(intValue, position != null ? position.intValue() : 0, i, str);
    }
}

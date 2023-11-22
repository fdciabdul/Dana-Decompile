package id.dana.danapoly.ui.model.mapper;

import id.dana.danapoly.domain.config.model.PlayerInfo;
import id.dana.danapoly.ui.model.PlayerInfoModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danapoly/domain/config/model/PlayerInfo;", "Lid/dana/danapoly/ui/model/PlayerInfoModel;", "toPlayerInfoModel", "(Lid/dana/danapoly/domain/config/model/PlayerInfo;)Lid/dana/danapoly/ui/model/PlayerInfoModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PlayerInfoModelMapperKt {
    public static final PlayerInfoModel toPlayerInfoModel(PlayerInfo playerInfo) {
        Intrinsics.checkNotNullParameter(playerInfo, "");
        return new PlayerInfoModel(playerInfo.getDanaPoint(), playerInfo.getPosition(), playerInfo.getCurrencyValue(), playerInfo.getAvatarUrl());
    }
}

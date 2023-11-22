package id.dana.danapoly.data.config.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.danapoly.data.config.model.request.GetConfigurationRequest;
import id.dana.danapoly.data.config.model.request.GetPlayerRequest;
import id.dana.danapoly.data.config.model.request.PlayBoardRequest;
import id.dana.danapoly.data.config.model.response.GetConfigurationResponse;
import id.dana.danapoly.data.config.model.response.PlayBoardResponse;
import id.dana.danapoly.data.config.model.response.PlayerInfoResponse;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/danapoly/data/config/repository/source/network/DanapolyConfigFacade;", "", "Lid/dana/danapoly/data/config/model/request/GetConfigurationRequest;", "request", "Lid/dana/danapoly/data/config/model/response/GetConfigurationResponse;", "getConfig", "(Lid/dana/danapoly/data/config/model/request/GetConfigurationRequest;)Lid/dana/danapoly/data/config/model/response/GetConfigurationResponse;", "Lid/dana/danapoly/data/config/model/request/PlayBoardRequest;", "Lid/dana/danapoly/data/config/model/response/PlayBoardResponse;", "getPlayBoard", "(Lid/dana/danapoly/data/config/model/request/PlayBoardRequest;)Lid/dana/danapoly/data/config/model/response/PlayBoardResponse;", "Lid/dana/danapoly/data/config/model/request/GetPlayerRequest;", "Lid/dana/danapoly/data/config/model/response/PlayerInfoResponse;", "getPlayerInfo", "(Lid/dana/danapoly/data/config/model/request/GetPlayerRequest;)Lid/dana/danapoly/data/config/model/response/PlayerInfoResponse;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface DanapolyConfigFacade {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.BuiltInFictitiousFunctionClassFactory;

    @OperationType("id.dana.danapolyprod.config.get")
    @SignCheck
    GetConfigurationResponse getConfig(GetConfigurationRequest request);

    @OperationType("id.dana.danapolyprod.board.get")
    @SignCheck
    PlayBoardResponse getPlayBoard(PlayBoardRequest request);

    @OperationType("id.dana.danapolyprod.playerInfo.get")
    @SignCheck
    PlayerInfoResponse getPlayerInfo(GetPlayerRequest request);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danapoly/data/config/repository/source/network/DanapolyConfigFacade$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion BuiltInFictitiousFunctionClassFactory = new Companion();

        private Companion() {
        }
    }
}

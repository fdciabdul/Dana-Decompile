package id.dana.danapoly.data.play.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.danapoly.data.play.model.request.GetLeaderboardRequest;
import id.dana.danapoly.data.play.model.request.RollDiceRequest;
import id.dana.danapoly.data.play.model.response.GetLeaderboardResponse;
import id.dana.danapoly.data.play.model.response.RollDiceResponse;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/danapoly/data/play/repository/source/network/DanapolyPlayFacade;", "", "Lid/dana/danapoly/data/play/model/request/GetLeaderboardRequest;", "request", "Lid/dana/danapoly/data/play/model/response/GetLeaderboardResponse;", "getLeaderboard", "(Lid/dana/danapoly/data/play/model/request/GetLeaderboardRequest;)Lid/dana/danapoly/data/play/model/response/GetLeaderboardResponse;", "Lid/dana/danapoly/data/play/model/request/RollDiceRequest;", "Lid/dana/danapoly/data/play/model/response/RollDiceResponse;", "rollDice", "(Lid/dana/danapoly/data/play/model/request/RollDiceRequest;)Lid/dana/danapoly/data/play/model/response/RollDiceResponse;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface DanapolyPlayFacade {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.getAuthRequestContext;

    @OperationType("id.dana.danapolyprod.leaderboard.getLeaderboard")
    @SignCheck
    GetLeaderboardResponse getLeaderboard(GetLeaderboardRequest request);

    @OperationType("id.dana.danapolyprod.play")
    @SignCheck
    RollDiceResponse rollDice(RollDiceRequest request);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danapoly/data/play/repository/source/network/DanapolyPlayFacade$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion getAuthRequestContext = new Companion();

        private Companion() {
        }
    }
}

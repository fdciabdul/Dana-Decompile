package id.dana.danapoly.data.play.repository.source;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import id.dana.danapoly.data.play.model.response.GetLeaderboardResponse;
import id.dana.danapoly.data.play.model.response.RollDiceResponse;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH&J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lid/dana/danapoly/data/play/repository/source/DanapolyPlayData;", "", "getLeaderboard", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/danapoly/data/play/model/response/GetLeaderboardResponse;", "eventId", "", "page", "", GriverMonitorConstants.KEY_SIZE, "rollDice", "Lid/dana/danapoly/data/play/model/response/RollDiceResponse;", "feature-danapoly_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface DanapolyPlayData {
    Flow<GetLeaderboardResponse> BuiltInFictitiousFunctionClassFactory(String str);

    Flow<RollDiceResponse> PlaceComponentResult(String str);

    /* renamed from: id.dana.danapoly.data.play.repository.source.DanapolyPlayData$-CC  reason: invalid class name */
    /* loaded from: classes4.dex */
    public final /* synthetic */ class CC {
    }
}

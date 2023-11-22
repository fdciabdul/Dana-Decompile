package id.dana.data.promoquest.repository.source;

import id.dana.data.promoquest.repository.source.network.result.ListOfMissionResult;
import id.dana.data.promoquest.repository.source.network.result.ListOfMissionSummaryResult;
import id.dana.data.promoquest.repository.source.network.result.MissionDetailResult;
import id.dana.data.promoquest.repository.source.network.result.QuestTrackResult;
import id.dana.data.promoquest.repository.source.network.result.RedeemQuestEntityResult;
import id.dana.data.promoquest.repository.source.network.result.RedeemUserMissionResult;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes4.dex */
public interface PromoQuestEntityData {
    Observable<MissionDetailResult> getMissionDetail(String str, boolean z);

    Observable<ListOfMissionSummaryResult> getMissionSummaryResult(String str);

    Observable<ListOfMissionResult> queryActiveMissions(int i, int i2);

    Observable<ListOfMissionResult> queryMissionListByStatus(int i, int i2, List<String> list);

    Observable<RedeemUserMissionResult> redeemMission(String str);

    Observable<RedeemQuestEntityResult> redeemQuest(String str, String str2);

    Observable<QuestTrackResult> trackUserQuest(String str, String str2, boolean z, String str3, String str4);
}

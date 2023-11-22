package id.dana.data.promoquest.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.promoquest.repository.source.network.request.MissionDetailRequest;
import id.dana.data.promoquest.repository.source.network.request.MissionRequest;
import id.dana.data.promoquest.repository.source.network.request.MissionRequestWithStatus;
import id.dana.data.promoquest.repository.source.network.request.MissionSummaryRequest;
import id.dana.data.promoquest.repository.source.network.request.QuestTrackRequest;
import id.dana.data.promoquest.repository.source.network.request.RedeemQuestRequest;
import id.dana.data.promoquest.repository.source.network.request.RedeemUserMissionRequest;
import id.dana.data.promoquest.repository.source.network.result.ListOfMissionResult;
import id.dana.data.promoquest.repository.source.network.result.ListOfMissionSummaryResult;
import id.dana.data.promoquest.repository.source.network.result.MissionDetailResult;
import id.dana.data.promoquest.repository.source.network.result.QuestTrackResult;
import id.dana.data.promoquest.repository.source.network.result.RedeemQuestEntityResult;
import id.dana.data.promoquest.repository.source.network.result.RedeemUserMissionResult;

/* loaded from: classes4.dex */
public interface PromoQuestFacade {
    @OperationType("alipayplus.mobilewallet.promogames.user.queryMissionDetail")
    @SignCheck
    MissionDetailResult queryMissionDetail(MissionDetailRequest missionDetailRequest);

    @OperationType("alipayplus.mobilewallet.promogames.user.queryMissionList")
    @SignCheck
    ListOfMissionResult queryMissionList(MissionRequest missionRequest);

    @OperationType("alipayplus.mobilewallet.promogames.user.queryMissionListByStatus")
    @SignCheck
    ListOfMissionResult queryMissionListByStatus(MissionRequestWithStatus missionRequestWithStatus);

    @OperationType("alipayplus.mobilewallet.promogames.user.queryMissionSummary")
    @SignCheck
    ListOfMissionSummaryResult queryMissionSummary(MissionSummaryRequest missionSummaryRequest);

    @OperationType("alipayplus.mobilewallet.promogames.user.redeemMission")
    @SignCheck
    RedeemUserMissionResult redeemMission(RedeemUserMissionRequest redeemUserMissionRequest);

    @OperationType("alipayplus.mobilewallet.promogames.user.redeemQuest")
    @SignCheck
    RedeemQuestEntityResult redeemQuest(RedeemQuestRequest redeemQuestRequest);

    @OperationType("alipayplus.mobilewallet.promogames.user.updateQuest")
    @SignCheck
    QuestTrackResult updateQuest(QuestTrackRequest questTrackRequest);
}

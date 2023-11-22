package id.dana.data.promoquest.repository.source.network;

import android.content.Context;
import com.alipay.iap.android.common.product.delegate.UserInfoManager;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.promoquest.repository.source.PromoQuestEntityData;
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
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes4.dex */
public class NetworkPromoQuestEntityData extends SecureBaseNetwork<PromoQuestFacade> implements PromoQuestEntityData {
    public NetworkPromoQuestEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<PromoQuestFacade> getFacadeClass() {
        return PromoQuestFacade.class;
    }

    @Override // id.dana.data.promoquest.repository.source.PromoQuestEntityData
    public Observable<ListOfMissionResult> queryActiveMissions(int i, int i2) {
        final MissionRequest missionRequest = new MissionRequest();
        missionRequest.envInfo = generateMobileEnvInfo();
        missionRequest.pageSize = i;
        missionRequest.pageNumber = i2;
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.promoquest.repository.source.network.NetworkPromoQuestEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                ListOfMissionResult queryMissionList;
                queryMissionList = ((PromoQuestFacade) obj).queryMissionList(MissionRequest.this);
                return queryMissionList;
            }
        });
    }

    @Override // id.dana.data.promoquest.repository.source.PromoQuestEntityData
    public Observable<MissionDetailResult> getMissionDetail(String str, boolean z) {
        final MissionDetailRequest missionDetailRequest = new MissionDetailRequest(str, UserInfoManager.instance().getUserId(), z);
        missionDetailRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.promoquest.repository.source.network.NetworkPromoQuestEntityData$$ExternalSyntheticLambda4
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                MissionDetailResult queryMissionDetail;
                queryMissionDetail = ((PromoQuestFacade) obj).queryMissionDetail(MissionDetailRequest.this);
                return queryMissionDetail;
            }
        });
    }

    @Override // id.dana.data.promoquest.repository.source.PromoQuestEntityData
    public Observable<ListOfMissionSummaryResult> getMissionSummaryResult(String str) {
        final MissionSummaryRequest missionSummaryRequest = new MissionSummaryRequest();
        missionSummaryRequest.setUserId(str);
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.promoquest.repository.source.network.NetworkPromoQuestEntityData$$ExternalSyntheticLambda3
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                ListOfMissionSummaryResult queryMissionSummary;
                queryMissionSummary = ((PromoQuestFacade) obj).queryMissionSummary(MissionSummaryRequest.this);
                return queryMissionSummary;
            }
        });
    }

    @Override // id.dana.data.promoquest.repository.source.PromoQuestEntityData
    public Observable<QuestTrackResult> trackUserQuest(String str, String str2, boolean z, String str3, String str4) {
        final QuestTrackRequest questTrackRequest = new QuestTrackRequest(z, str, str2, "", "");
        questTrackRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.promoquest.repository.source.network.NetworkPromoQuestEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                QuestTrackResult updateQuest;
                updateQuest = ((PromoQuestFacade) obj).updateQuest(QuestTrackRequest.this);
                return updateQuest;
            }
        });
    }

    @Override // id.dana.data.promoquest.repository.source.PromoQuestEntityData
    public Observable<RedeemQuestEntityResult> redeemQuest(String str, String str2) {
        final RedeemQuestRequest redeemQuestRequest = new RedeemQuestRequest(str, str2, UserInfoManager.instance().getUserId());
        redeemQuestRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.promoquest.repository.source.network.NetworkPromoQuestEntityData$$ExternalSyntheticLambda5
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                RedeemQuestEntityResult redeemQuest;
                redeemQuest = ((PromoQuestFacade) obj).redeemQuest(RedeemQuestRequest.this);
                return redeemQuest;
            }
        });
    }

    @Override // id.dana.data.promoquest.repository.source.PromoQuestEntityData
    public Observable<RedeemUserMissionResult> redeemMission(String str) {
        final RedeemUserMissionRequest redeemUserMissionRequest = new RedeemUserMissionRequest(str);
        redeemUserMissionRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.promoquest.repository.source.network.NetworkPromoQuestEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                RedeemUserMissionResult redeemMission;
                redeemMission = ((PromoQuestFacade) obj).redeemMission(RedeemUserMissionRequest.this);
                return redeemMission;
            }
        });
    }

    @Override // id.dana.data.promoquest.repository.source.PromoQuestEntityData
    public Observable<ListOfMissionResult> queryMissionListByStatus(int i, int i2, final List<String> list) {
        final MissionRequest missionRequest = new MissionRequest();
        missionRequest.envInfo = generateMobileEnvInfo();
        missionRequest.pageSize = i;
        missionRequest.pageNumber = i2;
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.promoquest.repository.source.network.NetworkPromoQuestEntityData$$ExternalSyntheticLambda6
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                ListOfMissionResult queryMissionListByStatus;
                queryMissionListByStatus = ((PromoQuestFacade) obj).queryMissionListByStatus(new MissionRequestWithStatus(list, missionRequest));
                return queryMissionListByStatus;
            }
        });
    }
}

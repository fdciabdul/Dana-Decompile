package id.dana.domain.promoquest.respository;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.domain.promoquest.model.Mission;
import id.dana.domain.promoquest.model.MissionRedeem;
import id.dana.domain.promoquest.model.MissionSummary;
import id.dana.domain.promoquest.model.QuestRedeem;
import id.dana.domain.promoquest.model.QuestTrack;
import id.dana.domain.social.ExtendInfoUtilKt;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J'\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0006H&¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n0\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012J9\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n0\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\nH&¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n0\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH&¢\u0006\u0004\b\u0016\u0010\u0012J\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H&¢\u0006\u0004\b\u001c\u0010\u001dJ=\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0002H&¢\u0006\u0004\b\"\u0010#ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/promoquest/respository/PromoQuestRepository;", "", "", BranchLinkConstant.Params.MISSION_ID, "", "withMissionInfo", "Lio/reactivex/Observable;", "Lid/dana/domain/promoquest/model/Mission;", "getMissionDetail", "(Ljava/lang/String;Z)Lio/reactivex/Observable;", "", "Lid/dana/domain/promoquest/model/MissionSummary;", "getMissionSummary", "()Lio/reactivex/Observable;", "", SecurityConstants.KEY_PAGE_SIZE, ZdocRecordService.PAGE_NUMBER, "getMissions", "(II)Lio/reactivex/Observable;", "listOfStatus", "getMissionsByStatus", "(IILjava/util/List;)Lio/reactivex/Observable;", "getMissionsWithQuest", "Lid/dana/domain/promoquest/model/MissionRedeem;", "redeemMission", "(Ljava/lang/String;)Lio/reactivex/Observable;", "questId", "Lid/dana/domain/promoquest/model/QuestRedeem;", "redeemQuest", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "autoRedeem", "bizType", ExtendInfoUtilKt.EXTEND_INFO_ACTIVITY_ID, "Lid/dana/domain/promoquest/model/QuestTrack;", "trackQuestUser", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface PromoQuestRepository {
    Observable<Mission> getMissionDetail(String missionId, boolean withMissionInfo);

    Observable<List<MissionSummary>> getMissionSummary();

    Observable<List<Mission>> getMissions(int pageSize, int pageNumber);

    Observable<List<Mission>> getMissionsByStatus(int pageSize, int pageNumber, List<String> listOfStatus);

    Observable<List<Mission>> getMissionsWithQuest(int pageSize, int pageNumber);

    Observable<MissionRedeem> redeemMission(String missionId);

    Observable<QuestRedeem> redeemQuest(String missionId, String questId);

    Observable<QuestTrack> trackQuestUser(String missionId, String questId, boolean autoRedeem, String bizType, String activityId);
}

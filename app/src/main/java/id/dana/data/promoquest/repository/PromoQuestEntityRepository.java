package id.dana.data.promoquest.repository;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.errorconfig.ErrorConfigEntityData;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.login.source.LoginEntityData;
import id.dana.data.promoquest.RedeemQuestEntityMapper;
import id.dana.data.promoquest.mapper.MissionDetailEntityMapper;
import id.dana.data.promoquest.mapper.PromoQuestEntityMapper;
import id.dana.data.promoquest.mapper.PromoQuestMapper;
import id.dana.data.promoquest.repository.source.PromoQuestEntityData;
import id.dana.data.promoquest.repository.source.PromoQuestEntityDataFactory;
import id.dana.data.promoquest.repository.source.network.result.ListOfMissionResult;
import id.dana.data.promoquest.repository.source.network.result.ListOfMissionSummaryResult;
import id.dana.data.promoquest.repository.source.network.result.MissionDetailResult;
import id.dana.data.promoquest.repository.source.network.result.QuestTrackResult;
import id.dana.data.promoquest.repository.source.network.result.RedeemQuestEntityResult;
import id.dana.data.promoquest.repository.source.network.result.RedeemUserMissionResult;
import id.dana.domain.promoquest.model.Mission;
import id.dana.domain.promoquest.model.MissionRedeem;
import id.dana.domain.promoquest.model.MissionSummary;
import id.dana.domain.promoquest.model.QuestRedeem;
import id.dana.domain.promoquest.model.QuestTrack;
import id.dana.domain.promoquest.respository.PromoQuestRepository;
import id.dana.domain.social.ExtendInfoUtilKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002BA\b\u0007\u0012\u0006\u0010A\u001a\u00020@\u0012\u0006\u0010M\u001a\u00020L\u0012\u0006\u0010P\u001a\u00020O\u0012\u0006\u0010G\u001a\u00020F\u0012\u0006\u0010S\u001a\u00020R\u0012\u0006\u0010V\u001a\u00020U\u0012\u0006\u0010D\u001a\u00020C¢\u0006\u0004\bX\u0010YJ*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096\u0001¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0001¢\u0006\u0004\b\u0006\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0011J\u0010\u0010\u0014\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u0004H\u0016¢\u0006\u0004\b\"\u0010#J+\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0 0\u00042\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$H\u0016¢\u0006\u0004\b'\u0010(J9\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0 0\u00042\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00190 H\u0016¢\u0006\u0004\b*\u0010+J+\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0 0\u00042\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$H\u0016¢\u0006\u0004\b,\u0010(J)\u00101\u001a\u0014\u0012\u0004\u0012\u00020/\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d000.2\u0006\u0010-\u001a\u00020\u001dH\u0002¢\u0006\u0004\b1\u00102J\u001d\u00104\u001a\b\u0012\u0004\u0012\u0002030\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b4\u00105J%\u00108\u001a\b\u0012\u0004\u0012\u0002070\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u00106\u001a\u00020\u0019H\u0016¢\u0006\u0004\b8\u00109J=\u0010>\u001a\b\u0012\u0004\u0012\u00020=0\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u00106\u001a\u00020\u00192\u0006\u0010:\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u00192\u0006\u0010<\u001a\u00020\u0019H\u0016¢\u0006\u0004\b>\u0010?R\u0014\u0010A\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010D\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010G\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR,\u0010K\u001a\u001a\u0012\u0004\u0012\u00020\u0019\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 000.8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0014\u0010M\u001a\u00020L8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010P\u001a\u00020O8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010S\u001a\u00020R8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010V\u001a\u00020U8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bV\u0010W"}, d2 = {"Lid/dana/data/promoquest/repository/PromoQuestEntityRepository;", "Lid/dana/domain/promoquest/respository/PromoQuestRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "T", "Lio/reactivex/Observable;", "observable", "authenticatedRequest", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Lkotlinx/coroutines/flow/Flow;", "flow", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountEntityData", "Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createLocalErrorConfigData", "()Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createNetworkErrorConfigData", "Lid/dana/data/login/source/LoginEntityData;", "createNetworkLogin", "()Lid/dana/data/login/source/LoginEntityData;", "Lid/dana/data/promoquest/repository/source/PromoQuestEntityData;", "createPromoQuestEntityData", "()Lid/dana/data/promoquest/repository/source/PromoQuestEntityData;", "", BranchLinkConstant.Params.MISSION_ID, "", "withMissionInfo", "Lid/dana/domain/promoquest/model/Mission;", "getMissionDetail", "(Ljava/lang/String;Z)Lio/reactivex/Observable;", "", "Lid/dana/domain/promoquest/model/MissionSummary;", "getMissionSummary", "()Lio/reactivex/Observable;", "", SecurityConstants.KEY_PAGE_SIZE, ZdocRecordService.PAGE_NUMBER, "getMissions", "(II)Lio/reactivex/Observable;", "listOfStatus", "getMissionsByStatus", "(IILjava/util/List;)Lio/reactivex/Observable;", "getMissionsWithQuest", "mission", "Lio/reactivex/functions/Function;", "", "Lio/reactivex/ObservableSource;", "getOriginalMission", "(Lid/dana/domain/promoquest/model/Mission;)Lio/reactivex/functions/Function;", "Lid/dana/domain/promoquest/model/MissionRedeem;", "redeemMission", "(Ljava/lang/String;)Lio/reactivex/Observable;", "questId", "Lid/dana/domain/promoquest/model/QuestRedeem;", "redeemQuest", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "autoRedeem", "bizType", ExtendInfoUtilKt.EXTEND_INFO_ACTIVITY_ID, "Lid/dana/domain/promoquest/model/QuestTrack;", "trackQuestUser", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "accountEntityDataFactory", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "holdLoginV1EntityRepository", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/promoquest/mapper/MissionDetailEntityMapper;", "missionDetailEntityMapper", "Lid/dana/data/promoquest/mapper/MissionDetailEntityMapper;", "getMissionSummaries", "()Lio/reactivex/functions/Function;", "missionSummaries", "Lid/dana/data/promoquest/repository/source/PromoQuestEntityDataFactory;", "promoQuestEntityDataFactory", "Lid/dana/data/promoquest/repository/source/PromoQuestEntityDataFactory;", "Lid/dana/data/promoquest/mapper/PromoQuestEntityMapper;", "promoQuestEntityMapper", "Lid/dana/data/promoquest/mapper/PromoQuestEntityMapper;", "Lid/dana/data/promoquest/mapper/PromoQuestMapper;", "promoQuestMapper", "Lid/dana/data/promoquest/mapper/PromoQuestMapper;", "Lid/dana/data/promoquest/RedeemQuestEntityMapper;", "redeemQuestEntityMapper", "Lid/dana/data/promoquest/RedeemQuestEntityMapper;", "<init>", "(Lid/dana/data/account/repository/source/AccountEntityDataFactory;Lid/dana/data/promoquest/repository/source/PromoQuestEntityDataFactory;Lid/dana/data/promoquest/mapper/PromoQuestEntityMapper;Lid/dana/data/promoquest/mapper/MissionDetailEntityMapper;Lid/dana/data/promoquest/mapper/PromoQuestMapper;Lid/dana/data/promoquest/RedeemQuestEntityMapper;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PromoQuestEntityRepository implements PromoQuestRepository, HoldLoginV1Repository {
    private final AccountEntityDataFactory accountEntityDataFactory;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final MissionDetailEntityMapper missionDetailEntityMapper;
    private final PromoQuestEntityDataFactory promoQuestEntityDataFactory;
    private final PromoQuestEntityMapper promoQuestEntityMapper;
    private final PromoQuestMapper promoQuestMapper;
    private final RedeemQuestEntityMapper redeemQuestEntityMapper;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getMissionsWithQuest$lambda-3$lambda-2  reason: not valid java name */
    public static final List m1654getMissionsWithQuest$lambda3$lambda2(List list, Object[] objArr) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(objArr, "");
        return list;
    }

    public final <T> Observable<T> authenticatedRequest(Observable<T> observable) {
        Intrinsics.checkNotNullParameter(observable, "");
        Observable<T> authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(observable);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        return authenticatedRequest;
    }

    public final <T> Flow<T> authenticatedRequest(Flow<? extends T> flow) {
        Intrinsics.checkNotNullParameter(flow, "");
        return this.holdLoginV1EntityRepository.PlaceComponentResult(flow);
    }

    public final AccountEntityData createAccountData() {
        AccountEntityData createAccountData = this.holdLoginV1EntityRepository.createAccountData();
        Intrinsics.checkNotNullExpressionValue(createAccountData, "");
        return createAccountData;
    }

    public final ErrorConfigEntityData createLocalErrorConfigData() {
        ErrorConfigEntityData createLocalErrorConfigData = this.holdLoginV1EntityRepository.createLocalErrorConfigData();
        Intrinsics.checkNotNullExpressionValue(createLocalErrorConfigData, "");
        return createLocalErrorConfigData;
    }

    public final ErrorConfigEntityData createNetworkErrorConfigData() {
        ErrorConfigEntityData createNetworkErrorConfigData = this.holdLoginV1EntityRepository.createNetworkErrorConfigData();
        Intrinsics.checkNotNullExpressionValue(createNetworkErrorConfigData, "");
        return createNetworkErrorConfigData;
    }

    public final LoginEntityData createNetworkLogin() {
        LoginEntityData createNetworkLogin = this.holdLoginV1EntityRepository.createNetworkLogin();
        Intrinsics.checkNotNullExpressionValue(createNetworkLogin, "");
        return createNetworkLogin;
    }

    @Inject
    public PromoQuestEntityRepository(AccountEntityDataFactory accountEntityDataFactory, PromoQuestEntityDataFactory promoQuestEntityDataFactory, PromoQuestEntityMapper promoQuestEntityMapper, MissionDetailEntityMapper missionDetailEntityMapper, PromoQuestMapper promoQuestMapper, RedeemQuestEntityMapper redeemQuestEntityMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(accountEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(promoQuestEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(promoQuestEntityMapper, "");
        Intrinsics.checkNotNullParameter(missionDetailEntityMapper, "");
        Intrinsics.checkNotNullParameter(promoQuestMapper, "");
        Intrinsics.checkNotNullParameter(redeemQuestEntityMapper, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.accountEntityDataFactory = accountEntityDataFactory;
        this.promoQuestEntityDataFactory = promoQuestEntityDataFactory;
        this.promoQuestEntityMapper = promoQuestEntityMapper;
        this.missionDetailEntityMapper = missionDetailEntityMapper;
        this.promoQuestMapper = promoQuestMapper;
        this.redeemQuestEntityMapper = redeemQuestEntityMapper;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.promoquest.respository.PromoQuestRepository
    public final Observable<List<Mission>> getMissionsWithQuest(int pageSize, int pageNumber) {
        Observable flatMap = createPromoQuestEntityData().queryActiveMissions(pageSize, pageNumber).map(new Function() { // from class: id.dana.data.promoquest.repository.PromoQuestEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m1651getMissionsWithQuest$lambda0;
                m1651getMissionsWithQuest$lambda0 = PromoQuestEntityRepository.m1651getMissionsWithQuest$lambda0(PromoQuestEntityRepository.this, (ListOfMissionResult) obj);
                return m1651getMissionsWithQuest$lambda0;
            }
        }).flatMap(new Function() { // from class: id.dana.data.promoquest.repository.PromoQuestEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1652getMissionsWithQuest$lambda3;
                m1652getMissionsWithQuest$lambda3 = PromoQuestEntityRepository.m1652getMissionsWithQuest$lambda3(PromoQuestEntityRepository.this, (List) obj);
                return m1652getMissionsWithQuest$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return authenticatedRequest(flatMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getMissionsWithQuest$lambda-0  reason: not valid java name */
    public static final List m1651getMissionsWithQuest$lambda0(PromoQuestEntityRepository promoQuestEntityRepository, ListOfMissionResult listOfMissionResult) {
        Intrinsics.checkNotNullParameter(promoQuestEntityRepository, "");
        return promoQuestEntityRepository.promoQuestEntityMapper.transform(listOfMissionResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getMissionsWithQuest$lambda-3  reason: not valid java name */
    public static final ObservableSource m1652getMissionsWithQuest$lambda3(PromoQuestEntityRepository promoQuestEntityRepository, final List list) {
        Intrinsics.checkNotNullParameter(promoQuestEntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final Mission mission = (Mission) it.next();
            Observable onErrorResumeNext = promoQuestEntityRepository.getMissionDetail(mission.getMissionId(), false).map(new Function() { // from class: id.dana.data.promoquest.repository.PromoQuestEntityRepository$$ExternalSyntheticLambda6
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Mission m1653getMissionsWithQuest$lambda3$lambda1;
                    m1653getMissionsWithQuest$lambda3$lambda1 = PromoQuestEntityRepository.m1653getMissionsWithQuest$lambda3$lambda1(Mission.this, (Mission) obj);
                    return m1653getMissionsWithQuest$lambda3$lambda1;
                }
            }).onErrorResumeNext(promoQuestEntityRepository.getOriginalMission(mission));
            Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
            arrayList.add(onErrorResumeNext);
        }
        return Observable.zip(arrayList, new Function() { // from class: id.dana.data.promoquest.repository.PromoQuestEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m1654getMissionsWithQuest$lambda3$lambda2;
                m1654getMissionsWithQuest$lambda3$lambda2 = PromoQuestEntityRepository.m1654getMissionsWithQuest$lambda3$lambda2(list, (Object[]) obj);
                return m1654getMissionsWithQuest$lambda3$lambda2;
            }
        }).startWith((ObservableSource) Observable.just(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getMissionsWithQuest$lambda-3$lambda-1  reason: not valid java name */
    public static final Mission m1653getMissionsWithQuest$lambda3$lambda1(Mission mission, Mission mission2) {
        Intrinsics.checkNotNullParameter(mission, "");
        Intrinsics.checkNotNullParameter(mission2, "");
        mission.setQuestList(mission2.getQuestList());
        return mission;
    }

    @Override // id.dana.domain.promoquest.respository.PromoQuestRepository
    public final Observable<List<Mission>> getMissions(int pageSize, int pageNumber) {
        Observable<ListOfMissionResult> queryActiveMissions = createPromoQuestEntityData().queryActiveMissions(pageSize, pageNumber);
        Intrinsics.checkNotNullExpressionValue(queryActiveMissions, "");
        Observable<List<Mission>> map = authenticatedRequest(queryActiveMissions).map(new Function() { // from class: id.dana.data.promoquest.repository.PromoQuestEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m1649getMissions$lambda4;
                m1649getMissions$lambda4 = PromoQuestEntityRepository.m1649getMissions$lambda4(PromoQuestEntityRepository.this, (ListOfMissionResult) obj);
                return m1649getMissions$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getMissions$lambda-4  reason: not valid java name */
    public static final List m1649getMissions$lambda4(PromoQuestEntityRepository promoQuestEntityRepository, ListOfMissionResult listOfMissionResult) {
        Intrinsics.checkNotNullParameter(promoQuestEntityRepository, "");
        Intrinsics.checkNotNullParameter(listOfMissionResult, "");
        return promoQuestEntityRepository.promoQuestEntityMapper.transform(listOfMissionResult);
    }

    @Override // id.dana.domain.promoquest.respository.PromoQuestRepository
    public final Observable<List<Mission>> getMissionsByStatus(int pageSize, int pageNumber, List<String> listOfStatus) {
        Intrinsics.checkNotNullParameter(listOfStatus, "");
        Observable<ListOfMissionResult> queryMissionListByStatus = createPromoQuestEntityData().queryMissionListByStatus(pageSize, pageNumber, listOfStatus);
        Intrinsics.checkNotNullExpressionValue(queryMissionListByStatus, "");
        Observable<List<Mission>> map = authenticatedRequest(queryMissionListByStatus).map(new Function() { // from class: id.dana.data.promoquest.repository.PromoQuestEntityRepository$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m1650getMissionsByStatus$lambda5;
                m1650getMissionsByStatus$lambda5 = PromoQuestEntityRepository.m1650getMissionsByStatus$lambda5(PromoQuestEntityRepository.this, (ListOfMissionResult) obj);
                return m1650getMissionsByStatus$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getMissionsByStatus$lambda-5  reason: not valid java name */
    public static final List m1650getMissionsByStatus$lambda5(PromoQuestEntityRepository promoQuestEntityRepository, ListOfMissionResult listOfMissionResult) {
        Intrinsics.checkNotNullParameter(promoQuestEntityRepository, "");
        Intrinsics.checkNotNullParameter(listOfMissionResult, "");
        return promoQuestEntityRepository.promoQuestEntityMapper.transform(listOfMissionResult);
    }

    @Override // id.dana.domain.promoquest.respository.PromoQuestRepository
    public final Observable<Mission> getMissionDetail(String missionId, boolean withMissionInfo) {
        ObservableSource flatMap = createPromoQuestEntityData().getMissionDetail(missionId, withMissionInfo).flatMap(new Function() { // from class: id.dana.data.promoquest.repository.PromoQuestEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1648getMissionDetail$lambda7;
                m1648getMissionDetail$lambda7 = PromoQuestEntityRepository.m1648getMissionDetail$lambda7(PromoQuestEntityRepository.this, (MissionDetailResult) obj);
                return m1648getMissionDetail$lambda7;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return authenticatedRequest((Observable) flatMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getMissionDetail$lambda-7  reason: not valid java name */
    public static final ObservableSource m1648getMissionDetail$lambda7(PromoQuestEntityRepository promoQuestEntityRepository, MissionDetailResult missionDetailResult) {
        Observable error;
        Intrinsics.checkNotNullParameter(promoQuestEntityRepository, "");
        Intrinsics.checkNotNullParameter(missionDetailResult, "");
        Mission transform = missionDetailResult.success ? promoQuestEntityRepository.missionDetailEntityMapper.transform(missionDetailResult) : null;
        if (transform == null || (error = Observable.just(transform)) == null) {
            error = Observable.error(new NullPointerException());
        }
        return error;
    }

    @Override // id.dana.domain.promoquest.respository.PromoQuestRepository
    public final Observable<List<MissionSummary>> getMissionSummary() {
        Observable flatMap = createAccountEntityData().getUserId().flatMap(getMissionSummaries());
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.domain.promoquest.respository.PromoQuestRepository
    public final Observable<QuestTrack> trackQuestUser(String missionId, String questId, boolean autoRedeem, String bizType, String activityId) {
        Intrinsics.checkNotNullParameter(missionId, "");
        Intrinsics.checkNotNullParameter(questId, "");
        Intrinsics.checkNotNullParameter(bizType, "");
        Intrinsics.checkNotNullParameter(activityId, "");
        ObservableSource flatMap = createPromoQuestEntityData().trackUserQuest(missionId, questId, autoRedeem, bizType, activityId).flatMap(new Function() { // from class: id.dana.data.promoquest.repository.PromoQuestEntityRepository$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1658trackQuestUser$lambda9;
                m1658trackQuestUser$lambda9 = PromoQuestEntityRepository.m1658trackQuestUser$lambda9(PromoQuestEntityRepository.this, (QuestTrackResult) obj);
                return m1658trackQuestUser$lambda9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return authenticatedRequest((Observable) flatMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: trackQuestUser$lambda-9  reason: not valid java name */
    public static final ObservableSource m1658trackQuestUser$lambda9(PromoQuestEntityRepository promoQuestEntityRepository, QuestTrackResult questTrackResult) {
        Observable error;
        Intrinsics.checkNotNullParameter(promoQuestEntityRepository, "");
        Intrinsics.checkNotNullParameter(questTrackResult, "");
        QuestTrack transform = questTrackResult.success ? promoQuestEntityRepository.promoQuestMapper.transform(questTrackResult) : null;
        if (transform == null || (error = Observable.just(transform)) == null) {
            error = Observable.error(new NullPointerException());
        }
        return error;
    }

    @Override // id.dana.domain.promoquest.respository.PromoQuestRepository
    public final Observable<QuestRedeem> redeemQuest(String missionId, String questId) {
        Intrinsics.checkNotNullParameter(missionId, "");
        Intrinsics.checkNotNullParameter(questId, "");
        ObservableSource flatMap = createPromoQuestEntityData().redeemQuest(missionId, questId).flatMap(new Function() { // from class: id.dana.data.promoquest.repository.PromoQuestEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1657redeemQuest$lambda11;
                m1657redeemQuest$lambda11 = PromoQuestEntityRepository.m1657redeemQuest$lambda11(PromoQuestEntityRepository.this, (RedeemQuestEntityResult) obj);
                return m1657redeemQuest$lambda11;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return authenticatedRequest((Observable) flatMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: redeemQuest$lambda-11  reason: not valid java name */
    public static final ObservableSource m1657redeemQuest$lambda11(PromoQuestEntityRepository promoQuestEntityRepository, RedeemQuestEntityResult redeemQuestEntityResult) {
        Observable error;
        Intrinsics.checkNotNullParameter(promoQuestEntityRepository, "");
        Intrinsics.checkNotNullParameter(redeemQuestEntityResult, "");
        QuestRedeem transform = redeemQuestEntityResult.success ? promoQuestEntityRepository.redeemQuestEntityMapper.transform(redeemQuestEntityResult) : null;
        if (transform == null || (error = Observable.just(transform)) == null) {
            error = Observable.error(new NullPointerException());
        }
        return error;
    }

    @Override // id.dana.domain.promoquest.respository.PromoQuestRepository
    public final Observable<MissionRedeem> redeemMission(String missionId) {
        Intrinsics.checkNotNullParameter(missionId, "");
        ObservableSource map = createPromoQuestEntityData().redeemMission(missionId).map(new Function() { // from class: id.dana.data.promoquest.repository.PromoQuestEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                MissionRedeem m1656redeemMission$lambda12;
                m1656redeemMission$lambda12 = PromoQuestEntityRepository.m1656redeemMission$lambda12(PromoQuestEntityRepository.this, (RedeemUserMissionResult) obj);
                return m1656redeemMission$lambda12;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return authenticatedRequest((Observable) map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: redeemMission$lambda-12  reason: not valid java name */
    public static final MissionRedeem m1656redeemMission$lambda12(PromoQuestEntityRepository promoQuestEntityRepository, RedeemUserMissionResult redeemUserMissionResult) {
        Intrinsics.checkNotNullParameter(promoQuestEntityRepository, "");
        Intrinsics.checkNotNullParameter(redeemUserMissionResult, "");
        return promoQuestEntityRepository.redeemQuestEntityMapper.transformMission(redeemUserMissionResult);
    }

    @JvmName(name = "getMissionSummaries")
    private final Function<String, ObservableSource<List<MissionSummary>>> getMissionSummaries() {
        return new Function() { // from class: id.dana.data.promoquest.repository.PromoQuestEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1646_get_missionSummaries_$lambda14;
                m1646_get_missionSummaries_$lambda14 = PromoQuestEntityRepository.m1646_get_missionSummaries_$lambda14(PromoQuestEntityRepository.this, (String) obj);
                return m1646_get_missionSummaries_$lambda14;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _get_missionSummaries_$lambda-14  reason: not valid java name */
    public static final ObservableSource m1646_get_missionSummaries_$lambda14(final PromoQuestEntityRepository promoQuestEntityRepository, String str) {
        Intrinsics.checkNotNullParameter(promoQuestEntityRepository, "");
        ObservableSource map = promoQuestEntityRepository.createPromoQuestEntityData().getMissionSummaryResult(str).map(new Function() { // from class: id.dana.data.promoquest.repository.PromoQuestEntityRepository$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m1647_get_missionSummaries_$lambda14$lambda13;
                m1647_get_missionSummaries_$lambda14$lambda13 = PromoQuestEntityRepository.m1647_get_missionSummaries_$lambda14$lambda13(PromoQuestEntityRepository.this, (ListOfMissionSummaryResult) obj);
                return m1647_get_missionSummaries_$lambda14$lambda13;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return promoQuestEntityRepository.authenticatedRequest((Observable) map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _get_missionSummaries_$lambda-14$lambda-13  reason: not valid java name */
    public static final List m1647_get_missionSummaries_$lambda14$lambda13(PromoQuestEntityRepository promoQuestEntityRepository, ListOfMissionSummaryResult listOfMissionSummaryResult) {
        Intrinsics.checkNotNullParameter(promoQuestEntityRepository, "");
        Intrinsics.checkNotNullParameter(listOfMissionSummaryResult, "");
        return promoQuestEntityRepository.promoQuestMapper.transform(listOfMissionSummaryResult.missionSummaries);
    }

    private final AccountEntityData createAccountEntityData() {
        AccountEntityData createData2 = this.accountEntityDataFactory.createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        return createData2;
    }

    private final Function<Throwable, ObservableSource<Mission>> getOriginalMission(final Mission mission) {
        return new Function() { // from class: id.dana.data.promoquest.repository.PromoQuestEntityRepository$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1655getOriginalMission$lambda15;
                m1655getOriginalMission$lambda15 = PromoQuestEntityRepository.m1655getOriginalMission$lambda15(Mission.this, (Throwable) obj);
                return m1655getOriginalMission$lambda15;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getOriginalMission$lambda-15  reason: not valid java name */
    public static final ObservableSource m1655getOriginalMission$lambda15(Mission mission, Throwable th) {
        Intrinsics.checkNotNullParameter(mission, "");
        Intrinsics.checkNotNullParameter(th, "");
        return Observable.just(mission);
    }

    private final PromoQuestEntityData createPromoQuestEntityData() {
        PromoQuestEntityData createData2 = this.promoQuestEntityDataFactory.createData2("network");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        return createData2;
    }
}

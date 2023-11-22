package id.dana.contract.promoquest.mission;

import id.dana.base.BasePresenter;
import id.dana.contract.promoquest.mission.MissionListContract;
import id.dana.domain.promoquest.interactor.GetMissionsWithQuestByStatus;
import id.dana.domain.promoquest.model.Mission;
import id.dana.promoquest.mapper.PromoQuestMapper;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB)\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\u0006\u0010\u0016\u001a\u00020\r\u0012\u0006\u0010\u0017\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u000f¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0005R\u0016\u0010\n\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\fR\u0014\u0010\u0006\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000eR\u0016\u0010\t\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\fR\u0014\u0010\u0007\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/contract/promoquest/mission/MissionListPresenter;", "Lid/dana/base/BasePresenter;", "Lid/dana/contract/promoquest/mission/MissionListContract$Presenter;", "", "PlaceComponentResult", "()V", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "onDestroy", "MyBillsEntityDataFactory", "getAuthRequestContext", "", "I", "Lid/dana/domain/promoquest/interactor/GetMissionsWithQuestByStatus;", "Lid/dana/domain/promoquest/interactor/GetMissionsWithQuestByStatus;", "Lid/dana/promoquest/mapper/PromoQuestMapper;", "Lid/dana/promoquest/mapper/PromoQuestMapper;", "Lid/dana/contract/promoquest/mission/MissionListContract$View;", "lookAheadTest", "Lid/dana/contract/promoquest/mission/MissionListContract$View;", "scheduleImpl", "p0", "p1", "p2", "p3", "<init>", "(Lid/dana/domain/promoquest/interactor/GetMissionsWithQuestByStatus;Lid/dana/domain/promoquest/interactor/GetMissionsWithQuestByStatus;Lid/dana/contract/promoquest/mission/MissionListContract$View;Lid/dana/promoquest/mapper/PromoQuestMapper;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MissionListPresenter extends BasePresenter implements MissionListContract.Presenter {
    private final GetMissionsWithQuestByStatus BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GetMissionsWithQuestByStatus PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final PromoQuestMapper KClassImpl$Data$declaredNonStaticMembers$2;
    private int getAuthRequestContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final MissionListContract.View scheduleImpl;

    @Inject
    public MissionListPresenter(GetMissionsWithQuestByStatus getMissionsWithQuestByStatus, GetMissionsWithQuestByStatus getMissionsWithQuestByStatus2, MissionListContract.View view, PromoQuestMapper promoQuestMapper) {
        Intrinsics.checkNotNullParameter(getMissionsWithQuestByStatus, "");
        Intrinsics.checkNotNullParameter(getMissionsWithQuestByStatus2, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(promoQuestMapper, "");
        this.BuiltInFictitiousFunctionClassFactory = getMissionsWithQuestByStatus;
        this.PlaceComponentResult = getMissionsWithQuestByStatus2;
        this.scheduleImpl = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = promoQuestMapper;
        this.getAuthRequestContext = 1;
        this.MyBillsEntityDataFactory = 1;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.PlaceComponentResult.dispose();
    }

    @Override // id.dana.contract.promoquest.mission.MissionListContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        PlaceComponentResult();
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.contract.promoquest.mission.MissionListContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.getAuthRequestContext = 1;
        PlaceComponentResult();
    }

    @Override // id.dana.contract.promoquest.mission.MissionListContract.Presenter
    public final void getAuthRequestContext() {
        this.MyBillsEntityDataFactory = 1;
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private final void PlaceComponentResult() {
        this.scheduleImpl.showActiveMissionProgress();
        this.BuiltInFictitiousFunctionClassFactory.execute(GetMissionsWithQuestByStatus.Params.INSTANCE.activeMissions(10, this.getAuthRequestContext), new Function1<List<? extends Mission>, Unit>() { // from class: id.dana.contract.promoquest.mission.MissionListPresenter$fetchActiveMissions$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends Mission> list) {
                invoke2((List<Mission>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<Mission> list) {
                MissionListContract.View view;
                MissionListContract.View view2;
                PromoQuestMapper promoQuestMapper;
                Intrinsics.checkNotNullParameter(list, "");
                view = MissionListPresenter.this.scheduleImpl;
                view.dismisssActiveMissionProgress();
                view2 = MissionListPresenter.this.scheduleImpl;
                promoQuestMapper = MissionListPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view2.onFetchActiveMissionSucceeded(promoQuestMapper.MyBillsEntityDataFactory(list));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.promoquest.mission.MissionListPresenter$fetchActiveMissions$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                MissionListContract.View view;
                MissionListContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = MissionListPresenter.this.scheduleImpl;
                view.dismisssActiveMissionProgress();
                view2 = MissionListPresenter.this.scheduleImpl;
                view2.onFetchActiveMissionFailed(null);
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.GET_ACTIVE_MISSIONS, DanaLogConstants.ExceptionType.PROMO_QUEST_EXCEPTION, th);
            }
        });
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.scheduleImpl.showPastMissionProgress();
        this.PlaceComponentResult.execute(GetMissionsWithQuestByStatus.Params.INSTANCE.pastMissions(10, this.MyBillsEntityDataFactory), new Function1<List<? extends Mission>, Unit>() { // from class: id.dana.contract.promoquest.mission.MissionListPresenter$fetchPastMissions$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends Mission> list) {
                invoke2((List<Mission>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<Mission> list) {
                MissionListContract.View view;
                MissionListContract.View view2;
                PromoQuestMapper promoQuestMapper;
                Intrinsics.checkNotNullParameter(list, "");
                view = MissionListPresenter.this.scheduleImpl;
                view.dismisssPastMissionProgress();
                view2 = MissionListPresenter.this.scheduleImpl;
                promoQuestMapper = MissionListPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view2.onFetchPastMissionSucceeded(promoQuestMapper.MyBillsEntityDataFactory(list));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.promoquest.mission.MissionListPresenter$fetchPastMissions$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                MissionListContract.View view;
                MissionListContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = MissionListPresenter.this.scheduleImpl;
                view.dismisssPastMissionProgress();
                view2 = MissionListPresenter.this.scheduleImpl;
                view2.onFetchPastMissionFailed(null);
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.GET_PAST_MISSIONS, DanaLogConstants.ExceptionType.PROMO_QUEST_EXCEPTION, th);
            }
        });
    }
}

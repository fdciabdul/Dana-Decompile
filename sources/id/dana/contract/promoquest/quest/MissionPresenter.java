package id.dana.contract.promoquest.quest;

import id.dana.contract.promoquest.quest.MissionContract;
import id.dana.di.PerActivity;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.GetTnCReferralMissionConfig;
import id.dana.domain.promoquest.interactor.GetMissionDetail;
import id.dana.domain.promoquest.model.Mission;
import id.dana.promoquest.mapper.PromoQuestMapper;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\u0006\u0010\u0016\u001a\u00020\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0013"}, d2 = {"Lid/dana/contract/promoquest/quest/MissionPresenter;", "Lid/dana/contract/promoquest/quest/MissionContract$Presenter;", "", "p0", "", "getAuthRequestContext", "(Ljava/lang/String;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "onDestroy", "Lid/dana/domain/promoquest/interactor/GetMissionDetail;", "Lid/dana/domain/promoquest/interactor/GetMissionDetail;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/featureconfig/interactor/GetTnCReferralMissionConfig;", "Lid/dana/domain/featureconfig/interactor/GetTnCReferralMissionConfig;", "MyBillsEntityDataFactory", "Lid/dana/promoquest/mapper/PromoQuestMapper;", "Lid/dana/promoquest/mapper/PromoQuestMapper;", "Lid/dana/contract/promoquest/quest/MissionContract$View;", "Lid/dana/contract/promoquest/quest/MissionContract$View;", "p1", "p2", "p3", "<init>", "(Lid/dana/contract/promoquest/quest/MissionContract$View;Lid/dana/domain/promoquest/interactor/GetMissionDetail;Lid/dana/domain/featureconfig/interactor/GetTnCReferralMissionConfig;Lid/dana/promoquest/mapper/PromoQuestMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes4.dex */
public final class MissionPresenter implements MissionContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GetTnCReferralMissionConfig MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final MissionContract.View getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final PromoQuestMapper KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GetMissionDetail BuiltInFictitiousFunctionClassFactory;

    @Inject
    public MissionPresenter(MissionContract.View view, GetMissionDetail getMissionDetail, GetTnCReferralMissionConfig getTnCReferralMissionConfig, PromoQuestMapper promoQuestMapper) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getMissionDetail, "");
        Intrinsics.checkNotNullParameter(getTnCReferralMissionConfig, "");
        Intrinsics.checkNotNullParameter(promoQuestMapper, "");
        this.getAuthRequestContext = view;
        this.BuiltInFictitiousFunctionClassFactory = getMissionDetail;
        this.MyBillsEntityDataFactory = getTnCReferralMissionConfig;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = promoQuestMapper;
    }

    @Override // id.dana.contract.promoquest.quest.MissionContract.Presenter
    public final void getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.showProgress();
        this.BuiltInFictitiousFunctionClassFactory.execute(GetMissionDetail.Params.INSTANCE.create(p0, true), new Function1<Mission, Unit>() { // from class: id.dana.contract.promoquest.quest.MissionPresenter$getMission$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Mission mission) {
                invoke2(mission);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Mission mission) {
                MissionContract.View view;
                MissionContract.View view2;
                PromoQuestMapper unused;
                Intrinsics.checkNotNullParameter(mission, "");
                view = MissionPresenter.this.getAuthRequestContext;
                view.dismissProgress();
                MissionPresenter missionPresenter = MissionPresenter.this;
                view2 = missionPresenter.getAuthRequestContext;
                unused = missionPresenter.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullParameter(mission, "");
                view2.getAuthRequestContext(PromoQuestMapper.MyBillsEntityDataFactory(mission));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.promoquest.quest.MissionPresenter$getMission$2
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
                MissionContract.View view;
                MissionContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.scheduleImpl(DanaLogConstants.TAG.MISSION_DETAIL_TAG, th.getMessage());
                view = MissionPresenter.this.getAuthRequestContext;
                view.dismissProgress();
                view2 = MissionPresenter.this.getAuthRequestContext;
                view2.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
    }

    @Override // id.dana.contract.promoquest.quest.MissionContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.MyBillsEntityDataFactory.execute(NoParams.INSTANCE, new Function1<String, Unit>() { // from class: id.dana.contract.promoquest.quest.MissionPresenter$getTnC$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                MissionContract.View view;
                Intrinsics.checkNotNullParameter(str, "");
                view = MissionPresenter.this.getAuthRequestContext;
                view.getAuthRequestContext(str);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.promoquest.quest.MissionPresenter$getTnC$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }
}

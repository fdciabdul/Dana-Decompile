package id.dana.contract.promoquest.quest;

import id.dana.contract.promoquest.quest.MissionSummaryContract;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.CheckPromoQuestFeature;
import id.dana.domain.promoquest.interactor.GetMissions;
import id.dana.domain.promoquest.model.Mission;
import id.dana.promoquest.mapper.PromoQuestMapper;
import id.dana.promoquest.model.MissionModel;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB)\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\r\u0012\u0006\u0010\u0017\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0014R\u0014\u0010\u0010\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016"}, d2 = {"Lid/dana/contract/promoquest/quest/MissionSummaryPresenter;", "Lid/dana/contract/promoquest/quest/MissionSummaryContract$Presenter;", "", "MyBillsEntityDataFactory", "()V", "", "Lid/dana/promoquest/model/MissionModel;", "p0", "", "PlaceComponentResult", "(Ljava/util/List;)Z", "BuiltInFictitiousFunctionClassFactory", "onDestroy", "Lid/dana/domain/featureconfig/interactor/CheckPromoQuestFeature;", "Lid/dana/domain/featureconfig/interactor/CheckPromoQuestFeature;", "Lid/dana/domain/promoquest/interactor/GetMissions;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/promoquest/interactor/GetMissions;", "getAuthRequestContext", "Lid/dana/promoquest/mapper/PromoQuestMapper;", "Lid/dana/promoquest/mapper/PromoQuestMapper;", "Lid/dana/contract/promoquest/quest/MissionSummaryContract$View;", "Lid/dana/contract/promoquest/quest/MissionSummaryContract$View;", "p1", "p2", "p3", "<init>", "(Lid/dana/domain/featureconfig/interactor/CheckPromoQuestFeature;Lid/dana/domain/promoquest/interactor/GetMissions;Lid/dana/promoquest/mapper/PromoQuestMapper;Lid/dana/contract/promoquest/quest/MissionSummaryContract$View;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class MissionSummaryPresenter implements MissionSummaryContract.Presenter {
    private final CheckPromoQuestFeature BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final GetMissions getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final PromoQuestMapper MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final MissionSummaryContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public MissionSummaryPresenter(CheckPromoQuestFeature checkPromoQuestFeature, GetMissions getMissions, PromoQuestMapper promoQuestMapper, MissionSummaryContract.View view) {
        Intrinsics.checkNotNullParameter(checkPromoQuestFeature, "");
        Intrinsics.checkNotNullParameter(getMissions, "");
        Intrinsics.checkNotNullParameter(promoQuestMapper, "");
        Intrinsics.checkNotNullParameter(view, "");
        this.BuiltInFictitiousFunctionClassFactory = checkPromoQuestFeature;
        this.getAuthRequestContext = getMissions;
        this.MyBillsEntityDataFactory = promoQuestMapper;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    @Override // id.dana.contract.promoquest.quest.MissionSummaryContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.showProgress();
        this.getAuthRequestContext.execute(GetMissions.Params.INSTANCE.create(10, 1), new Function1<List<? extends Mission>, Unit>() { // from class: id.dana.contract.promoquest.quest.MissionSummaryPresenter$getMissionSummaries$1
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
                MissionSummaryContract.View view;
                PromoQuestMapper promoQuestMapper;
                MissionSummaryContract.View view2;
                Intrinsics.checkNotNullParameter(list, "");
                view = MissionSummaryPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.dismissProgress();
                promoQuestMapper = MissionSummaryPresenter.this.MyBillsEntityDataFactory;
                List<MissionModel> MyBillsEntityDataFactory = promoQuestMapper.MyBillsEntityDataFactory(list);
                if (MyBillsEntityDataFactory.isEmpty()) {
                    view2 = MissionSummaryPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    view2.getAuthRequestContext();
                    return;
                }
                MissionSummaryPresenter.MyBillsEntityDataFactory(MissionSummaryPresenter.this, MyBillsEntityDataFactory);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.promoquest.quest.MissionSummaryPresenter$getMissionSummaries$2
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
                MissionSummaryContract.View view;
                MissionSummaryContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = MissionSummaryPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.dismissProgress();
                view2 = MissionSummaryPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view2.getAuthRequestContext();
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.GET_MISSION_SUMMARIES, DanaLogConstants.ExceptionType.PROMO_QUEST_EXCEPTION, th);
            }
        });
    }

    private static boolean PlaceComponentResult(List<MissionModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ArrayList arrayList = new ArrayList();
        for (Object obj : p0) {
            if (Intrinsics.areEqual(((MissionModel) obj).initRecordTimeStamp, "REFERRAL_MISSION_ID")) {
                arrayList.add(obj);
            }
        }
        return !arrayList.isEmpty();
    }

    @Override // id.dana.contract.promoquest.quest.MissionSummaryContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.BuiltInFictitiousFunctionClassFactory.execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.contract.promoquest.quest.MissionSummaryPresenter$checkPromoQuestFeature$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                MissionSummaryContract.View view;
                view = MissionSummaryPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.MyBillsEntityDataFactory(z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.promoquest.quest.MissionSummaryPresenter$checkPromoQuestFeature$2
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
                MissionSummaryContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = MissionSummaryPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.MyBillsEntityDataFactory(false);
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PROMO_QUEST, sb.toString());
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.getAuthRequestContext.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(MissionSummaryPresenter missionSummaryPresenter, List list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((MissionModel) obj).MyBillsEntityDataFactory()) {
                arrayList.add(obj);
            }
        }
        List sortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: id.dana.contract.promoquest.quest.MissionSummaryPresenter$filterMissionSummariesAndSetData$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Date date = ((MissionModel) t).lookAheadTest;
                Long valueOf = Long.valueOf(date != null ? date.getTime() : 0L);
                Date date2 = ((MissionModel) t2).lookAheadTest;
                return ComparisonsKt.compareValues(valueOf, Long.valueOf(date2 != null ? date2.getTime() : 0L));
            }
        });
        if ((!sortedWith.isEmpty()) != false) {
            missionSummaryPresenter.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(CollectionsKt.take(sortedWith, 5), PlaceComponentResult(sortedWith));
        } else {
            missionSummaryPresenter.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
        }
    }
}

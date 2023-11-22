package id.dana.domain.promoquest.interactor;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.promoquest.model.Mission;
import id.dana.domain.promoquest.model.Quest;
import id.dana.domain.promoquest.respository.PromoQuestRepository;
import id.dana.promoquest.activity.MissionListActivity;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u0017B\u0011\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006*\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0006*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/domain/promoquest/interactor/GetMissionsWithQuestByStatus;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/promoquest/model/Mission;", "Lid/dana/domain/promoquest/interactor/GetMissionsWithQuestByStatus$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/promoquest/interactor/GetMissionsWithQuestByStatus$Params;)Lio/reactivex/Observable;", "", BranchLinkConstant.Params.MISSION_ID, "Lid/dana/domain/promoquest/model/Quest;", "getMissionDetail", "(Ljava/lang/String;)Lio/reactivex/Observable;", "addQuest", "(Lid/dana/domain/promoquest/model/Mission;)Lio/reactivex/Observable;", "withQuest", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Lid/dana/domain/promoquest/respository/PromoQuestRepository;", "promoQuestRepository", "Lid/dana/domain/promoquest/respository/PromoQuestRepository;", "<init>", "(Lid/dana/domain/promoquest/respository/PromoQuestRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetMissionsWithQuestByStatus extends BaseUseCase<List<? extends Mission>, Params> {
    private final PromoQuestRepository promoQuestRepository;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: withQuest$lambda-2$lambda-1  reason: not valid java name */
    public static final List m2423withQuest$lambda2$lambda1(List list, Object[] objArr) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(objArr, "");
        return list;
    }

    @Inject
    public GetMissionsWithQuestByStatus(PromoQuestRepository promoQuestRepository) {
        Intrinsics.checkNotNullParameter(promoQuestRepository, "");
        this.promoQuestRepository = promoQuestRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<List<Mission>> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return withQuest(this.promoQuestRepository.getMissionsByStatus(params.getPageSize(), params.getPageNumber(), params.getListOfStatus$domain_productionRelease()));
    }

    private final Observable<List<Mission>> withQuest(Observable<List<Mission>> observable) {
        Observable flatMap = observable.flatMap(new Function() { // from class: id.dana.domain.promoquest.interactor.GetMissionsWithQuestByStatus$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2422withQuest$lambda2;
                m2422withQuest$lambda2 = GetMissionsWithQuestByStatus.m2422withQuest$lambda2(GetMissionsWithQuestByStatus.this, (List) obj);
                return m2422withQuest$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: withQuest$lambda-2  reason: not valid java name */
    public static final ObservableSource m2422withQuest$lambda2(GetMissionsWithQuestByStatus getMissionsWithQuestByStatus, final List list) {
        Intrinsics.checkNotNullParameter(getMissionsWithQuestByStatus, "");
        Intrinsics.checkNotNullParameter(list, "");
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(getMissionsWithQuestByStatus.addQuest((Mission) it.next()));
        }
        return Observable.zip(arrayList, new Function() { // from class: id.dana.domain.promoquest.interactor.GetMissionsWithQuestByStatus$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m2423withQuest$lambda2$lambda1;
                m2423withQuest$lambda2$lambda1 = GetMissionsWithQuestByStatus.m2423withQuest$lambda2$lambda1(list, (Object[]) obj);
                return m2423withQuest$lambda2$lambda1;
            }
        }).startWith((ObservableSource) Observable.just(list));
    }

    private final Observable<Mission> addQuest(final Mission mission) {
        String missionId = mission.getMissionId();
        Observable<Mission> onErrorResumeNext = missionId != null ? getMissionDetail(missionId).map(new Function() { // from class: id.dana.domain.promoquest.interactor.GetMissionsWithQuestByStatus$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Mission m2420addQuest$lambda4$lambda3;
                m2420addQuest$lambda4$lambda3 = GetMissionsWithQuestByStatus.m2420addQuest$lambda4$lambda3(Mission.this, (List) obj);
                return m2420addQuest$lambda4$lambda3;
            }
        }).onErrorResumeNext(Observable.just(mission)) : null;
        if (onErrorResumeNext == null) {
            Observable<Mission> just = Observable.just(mission);
            Intrinsics.checkNotNullExpressionValue(just, "");
            return just;
        }
        return onErrorResumeNext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addQuest$lambda-4$lambda-3  reason: not valid java name */
    public static final Mission m2420addQuest$lambda4$lambda3(Mission mission, List list) {
        Intrinsics.checkNotNullParameter(mission, "");
        Intrinsics.checkNotNullParameter(list, "");
        mission.setQuestList(list);
        return mission;
    }

    private final Observable<List<Quest>> getMissionDetail(String missionId) {
        Observable map = this.promoQuestRepository.getMissionDetail(missionId, false).map(new Function() { // from class: id.dana.domain.promoquest.interactor.GetMissionsWithQuestByStatus$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m2421getMissionDetail$lambda6;
                m2421getMissionDetail$lambda6 = GetMissionsWithQuestByStatus.m2421getMissionDetail$lambda6((Mission) obj);
                return m2421getMissionDetail$lambda6;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getMissionDetail$lambda-6  reason: not valid java name */
    public static final List m2421getMissionDetail$lambda6(Mission mission) {
        Intrinsics.checkNotNullParameter(mission, "");
        return mission.getQuestList();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B'\b\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\b8\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f"}, d2 = {"Lid/dana/domain/promoquest/interactor/GetMissionsWithQuestByStatus$Params;", "", "", "", "listOfStatus", "Ljava/util/List;", "getListOfStatus$domain_productionRelease", "()Ljava/util/List;", "", ZdocRecordService.PAGE_NUMBER, "I", "getPageNumber$domain_productionRelease", "()I", SecurityConstants.KEY_PAGE_SIZE, "getPageSize$domain_productionRelease", "<init>", "(IILjava/util/List;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final List<String> listOfStatus;
        private final int pageNumber;
        private final int pageSize;

        public /* synthetic */ Params(int i, int i2, List list, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, list);
        }

        private Params(int i, int i2, List<String> list) {
            this.pageSize = i;
            this.pageNumber = i2;
            this.listOfStatus = list;
        }

        @JvmName(name = "getPageSize$domain_productionRelease")
        /* renamed from: getPageSize$domain_productionRelease  reason: from getter */
        public final int getPageSize() {
            return this.pageSize;
        }

        @JvmName(name = "getPageNumber$domain_productionRelease")
        /* renamed from: getPageNumber$domain_productionRelease  reason: from getter */
        public final int getPageNumber() {
            return this.pageNumber;
        }

        @JvmName(name = "getListOfStatus$domain_productionRelease")
        public final List<String> getListOfStatus$domain_productionRelease() {
            return this.listOfStatus;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0007"}, d2 = {"Lid/dana/domain/promoquest/interactor/GetMissionsWithQuestByStatus$Params$Companion;", "", "", SecurityConstants.KEY_PAGE_SIZE, ZdocRecordService.PAGE_NUMBER, "Lid/dana/domain/promoquest/interactor/GetMissionsWithQuestByStatus$Params;", MissionListActivity.ACTIVE_MISSIONS_KEY, "(II)Lid/dana/domain/promoquest/interactor/GetMissionsWithQuestByStatus$Params;", MissionListActivity.PAST_MISSIONS_KEY, "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Params activeMissions(int pageSize, int pageNumber) {
                return new Params(pageSize, pageNumber, CollectionsKt.listOf((Object[]) new String[]{"ACTIVE", "COMPLETE"}), null);
            }

            public final Params pastMissions(int pageSize, int pageNumber) {
                return new Params(pageSize, pageNumber, CollectionsKt.listOf((Object[]) new String[]{"FINISH", "CLOSE"}), null);
            }
        }
    }
}

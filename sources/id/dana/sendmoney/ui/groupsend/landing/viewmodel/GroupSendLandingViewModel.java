package id.dana.sendmoney.ui.groupsend.landing.viewmodel;

import androidx.view.ViewModel;
import androidx.view.ViewModelKt;
import id.dana.domain.core.usecase.NoParams;
import id.dana.sendmoney.domain.groupsend.GroupSendOperationType;
import id.dana.sendmoney.domain.groupsend.interactor.GetBottomSheetOnBoardingFlow;
import id.dana.sendmoney.domain.groupsend.interactor.GetGroupSendMaxGroup;
import id.dana.sendmoney.domain.groupsend.interactor.GetGroupSendQuery;
import id.dana.sendmoney.domain.groupsend.interactor.GetGroupSendScenarios;
import id.dana.sendmoney.domain.groupsend.interactor.SaveDisplayBottomSheetOnBoardingFlow;
import id.dana.sendmoney.domain.groupsend.model.query.BizGroupQueryResult;
import id.dana.sendmoney.domain.groupsend.model.query.Group;
import id.dana.sendmoney.ui.groupsend.landing.mapper.GroupSendQueryModelMapperKt;
import id.dana.sendmoney.ui.groupsend.landing.viewmodel.GroupSendLandingUiState;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0014\u0012\u0006\u0010\u001c\u001a\u00020\n\u0012\u0006\u0010\u001d\u001a\u00020\u0016\u0012\u0006\u0010\u001e\u001a\u00020\r\u0012\u0006\u0010\u001f\u001a\u00020\u0010¢\u0006\u0004\b \u0010!J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0011\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0017R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0019"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingViewModel;", "Landroidx/lifecycle/ViewModel;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingUiState;", "scheduleImpl", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getAuthRequestContext", "Lid/dana/sendmoney/domain/groupsend/interactor/GetBottomSheetOnBoardingFlow;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/domain/groupsend/interactor/GetBottomSheetOnBoardingFlow;", "Lid/dana/sendmoney/domain/groupsend/interactor/GetGroupSendMaxGroup;", "Lid/dana/sendmoney/domain/groupsend/interactor/GetGroupSendMaxGroup;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/domain/groupsend/interactor/GetGroupSendQuery;", "moveToNextValue", "Lid/dana/sendmoney/domain/groupsend/interactor/GetGroupSendQuery;", "PlaceComponentResult", "Lid/dana/sendmoney/domain/groupsend/interactor/GetGroupSendScenarios;", "Lid/dana/sendmoney/domain/groupsend/interactor/GetGroupSendScenarios;", "Lid/dana/sendmoney/domain/groupsend/interactor/SaveDisplayBottomSheetOnBoardingFlow;", "Lid/dana/sendmoney/domain/groupsend/interactor/SaveDisplayBottomSheetOnBoardingFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "getErrorConfigVersion", "p0", "p1", "p2", "p3", "p4", "<init>", "(Lid/dana/sendmoney/domain/groupsend/interactor/GetGroupSendScenarios;Lid/dana/sendmoney/domain/groupsend/interactor/GetBottomSheetOnBoardingFlow;Lid/dana/sendmoney/domain/groupsend/interactor/SaveDisplayBottomSheetOnBoardingFlow;Lid/dana/sendmoney/domain/groupsend/interactor/GetGroupSendMaxGroup;Lid/dana/sendmoney/domain/groupsend/interactor/GetGroupSendQuery;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupSendLandingViewModel extends ViewModel {
    public final GetBottomSheetOnBoardingFlow BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final GetGroupSendMaxGroup MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final StateFlow<GroupSendLandingUiState> getErrorConfigVersion;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final GetGroupSendScenarios KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final SaveDisplayBottomSheetOnBoardingFlow moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final GetGroupSendQuery PlaceComponentResult;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final MutableStateFlow<GroupSendLandingUiState> getAuthRequestContext;

    @Inject
    public GroupSendLandingViewModel(GetGroupSendScenarios getGroupSendScenarios, GetBottomSheetOnBoardingFlow getBottomSheetOnBoardingFlow, SaveDisplayBottomSheetOnBoardingFlow saveDisplayBottomSheetOnBoardingFlow, GetGroupSendMaxGroup getGroupSendMaxGroup, GetGroupSendQuery getGroupSendQuery) {
        Intrinsics.checkNotNullParameter(getGroupSendScenarios, "");
        Intrinsics.checkNotNullParameter(getBottomSheetOnBoardingFlow, "");
        Intrinsics.checkNotNullParameter(saveDisplayBottomSheetOnBoardingFlow, "");
        Intrinsics.checkNotNullParameter(getGroupSendMaxGroup, "");
        Intrinsics.checkNotNullParameter(getGroupSendQuery, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getGroupSendScenarios;
        this.BuiltInFictitiousFunctionClassFactory = getBottomSheetOnBoardingFlow;
        this.moveToNextValue = saveDisplayBottomSheetOnBoardingFlow;
        this.MyBillsEntityDataFactory = getGroupSendMaxGroup;
        this.PlaceComponentResult = getGroupSendQuery;
        MutableStateFlow<GroupSendLandingUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(GroupSendLandingUiState.None.INSTANCE);
        this.getAuthRequestContext = MutableStateFlow;
        this.getErrorConfigVersion = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.PlaceComponentResult.execute(NoParams.INSTANCE, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.landing.viewmodel.GroupSendLandingViewModel$getGroupSendQuery$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = GroupSendLandingViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    GroupSendLandingUiState groupSendLandingUiState = (GroupSendLandingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupSendLandingUiState.ShimmerLoading(true)));
            }
        }, new Function1<BizGroupQueryResult, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.landing.viewmodel.GroupSendLandingViewModel$getGroupSendQuery$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(BizGroupQueryResult bizGroupQueryResult) {
                invoke2(bizGroupQueryResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(BizGroupQueryResult bizGroupQueryResult) {
                MutableStateFlow mutableStateFlow;
                Object value;
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(bizGroupQueryResult, "");
                mutableStateFlow = GroupSendLandingViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    GroupSendLandingUiState groupSendLandingUiState = (GroupSendLandingUiState) value;
                    List<Group> list = bizGroupQueryResult.PlaceComponentResult;
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(GroupSendQueryModelMapperKt.getAuthRequestContext((Group) it.next()));
                    }
                } while (!mutableStateFlow.compareAndSet(value, new GroupSendLandingUiState.OnSuccessGetGroupSendQuery(arrayList)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.landing.viewmodel.GroupSendLandingViewModel$getGroupSendQuery$3
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
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.GROUP_SEND_EXCEPTION, th.getMessage(), th);
                mutableStateFlow = GroupSendLandingViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    GroupSendLandingUiState groupSendLandingUiState = (GroupSendLandingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupSendLandingUiState.Error(0, th, GroupSendOperationType.GROUP_QUERY, 1, null)));
            }
        }, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.landing.viewmodel.GroupSendLandingViewModel$getGroupSendQuery$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = GroupSendLandingViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    GroupSendLandingUiState groupSendLandingUiState = (GroupSendLandingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupSendLandingUiState.ShimmerLoading(false)));
            }
        }, ViewModelKt.PlaceComponentResult(this));
    }
}

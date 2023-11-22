package id.dana.sendmoney.ui.groupsend.summary.viewmodel;

import androidx.view.ViewModel;
import androidx.view.ViewModelKt;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.domain.recentrecipient.interactor.GetGroupFavoriteValue;
import id.dana.domain.recentrecipient.interactor.SaveRecentGroup;
import id.dana.sendmoney.domain.groupsend.GroupSendOperationType;
import id.dana.sendmoney.domain.groupsend.interactor.ConfirmSendMoneyGroup;
import id.dana.sendmoney.domain.groupsend.interactor.GetDefaultAvatarGroup;
import id.dana.sendmoney.domain.groupsend.interactor.GetEditMemberSwitch;
import id.dana.sendmoney.domain.groupsend.interactor.GetGroupSendDetail;
import id.dana.sendmoney.domain.groupsend.interactor.InitSendMoneyGroup;
import id.dana.sendmoney.domain.groupsend.interactor.SaveDefaultAvatarGroup;
import id.dana.sendmoney.domain.groupsend.model.detail.BizGroupDetailResult;
import id.dana.sendmoney.domain.groupsend.model.init.SendMoneyGroupInit;
import id.dana.sendmoney.ui.groupsend.groupdetail.mapper.GroupSendDetailModelMapperKt;
import id.dana.sendmoney.ui.groupsend.summary.mapper.GroupSendSummaryModelMapperKt;
import id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryUIState;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001BI\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0013\u0012\u0006\u0010\b\u001a\u00020\"\u0012\u0006\u0010*\u001a\u00020\u0010\u0012\u0006\u0010+\u001a\u00020\u001f\u0012\u0006\u0010,\u001a\u00020\u0017\u0012\u0006\u0010-\u001a\u00020\u001c\u0012\u0006\u0010.\u001a\u00020$\u0012\u0006\u0010/\u001a\u00020\u001a¢\u0006\u0004\b0\u00101J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0014\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001bR\u0014\u0010\u000e\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\u001d\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\r0'X\u0006¢\u0006\u0006\n\u0004\b(\u0010)"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryViewModel;", "Landroidx/lifecycle/ViewModel;", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "", "p1", "(Ljava/lang/String;Ljava/util/List;)V", "onCleared", "()V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryUIState;", "scheduleImpl", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/sendmoney/domain/groupsend/interactor/ConfirmSendMoneyGroup;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/domain/groupsend/interactor/ConfirmSendMoneyGroup;", "Lid/dana/sendmoney/domain/groupsend/interactor/GetDefaultAvatarGroup;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/domain/groupsend/interactor/GetDefaultAvatarGroup;", "PlaceComponentResult", "Lid/dana/sendmoney/domain/groupsend/interactor/GetEditMemberSwitch;", "getAuthRequestContext", "Lid/dana/sendmoney/domain/groupsend/interactor/GetEditMemberSwitch;", "Lid/dana/domain/recentrecipient/interactor/GetGroupFavoriteValue;", "Lid/dana/domain/recentrecipient/interactor/GetGroupFavoriteValue;", "Lid/dana/sendmoney/domain/groupsend/interactor/GetGroupSendDetail;", "moveToNextValue", "Lid/dana/sendmoney/domain/groupsend/interactor/GetGroupSendDetail;", "Lid/dana/sendmoney/domain/groupsend/interactor/InitSendMoneyGroup;", "lookAheadTest", "Lid/dana/sendmoney/domain/groupsend/interactor/InitSendMoneyGroup;", "Lid/dana/sendmoney/domain/groupsend/interactor/SaveDefaultAvatarGroup;", "Lid/dana/sendmoney/domain/groupsend/interactor/SaveDefaultAvatarGroup;", "Lid/dana/domain/recentrecipient/interactor/SaveRecentGroup;", "getErrorConfigVersion", "Lid/dana/domain/recentrecipient/interactor/SaveRecentGroup;", "Lkotlinx/coroutines/flow/StateFlow;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlinx/coroutines/flow/StateFlow;", "p2", "p3", "p4", "p5", "p6", "p7", "<init>", "(Lid/dana/sendmoney/domain/groupsend/interactor/GetDefaultAvatarGroup;Lid/dana/sendmoney/domain/groupsend/interactor/SaveDefaultAvatarGroup;Lid/dana/sendmoney/domain/groupsend/interactor/ConfirmSendMoneyGroup;Lid/dana/sendmoney/domain/groupsend/interactor/InitSendMoneyGroup;Lid/dana/sendmoney/domain/groupsend/interactor/GetEditMemberSwitch;Lid/dana/sendmoney/domain/groupsend/interactor/GetGroupSendDetail;Lid/dana/domain/recentrecipient/interactor/SaveRecentGroup;Lid/dana/domain/recentrecipient/interactor/GetGroupFavoriteValue;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GroupSendSummaryViewModel extends ViewModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final GetDefaultAvatarGroup PlaceComponentResult;
    public final ConfirmSendMoneyGroup KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final SaveDefaultAvatarGroup moveToNextValue;
    public final StateFlow<GroupSendSummaryUIState> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final GetGroupFavoriteValue BuiltInFictitiousFunctionClassFactory;
    public final GetEditMemberSwitch getAuthRequestContext;
    private final SaveRecentGroup getErrorConfigVersion;
    private final InitSendMoneyGroup lookAheadTest;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final GetGroupSendDetail scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final MutableStateFlow<GroupSendSummaryUIState> MyBillsEntityDataFactory;

    @Inject
    public GroupSendSummaryViewModel(GetDefaultAvatarGroup getDefaultAvatarGroup, SaveDefaultAvatarGroup saveDefaultAvatarGroup, ConfirmSendMoneyGroup confirmSendMoneyGroup, InitSendMoneyGroup initSendMoneyGroup, GetEditMemberSwitch getEditMemberSwitch, GetGroupSendDetail getGroupSendDetail, SaveRecentGroup saveRecentGroup, GetGroupFavoriteValue getGroupFavoriteValue) {
        Intrinsics.checkNotNullParameter(getDefaultAvatarGroup, "");
        Intrinsics.checkNotNullParameter(saveDefaultAvatarGroup, "");
        Intrinsics.checkNotNullParameter(confirmSendMoneyGroup, "");
        Intrinsics.checkNotNullParameter(initSendMoneyGroup, "");
        Intrinsics.checkNotNullParameter(getEditMemberSwitch, "");
        Intrinsics.checkNotNullParameter(getGroupSendDetail, "");
        Intrinsics.checkNotNullParameter(saveRecentGroup, "");
        Intrinsics.checkNotNullParameter(getGroupFavoriteValue, "");
        this.PlaceComponentResult = getDefaultAvatarGroup;
        this.moveToNextValue = saveDefaultAvatarGroup;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = confirmSendMoneyGroup;
        this.lookAheadTest = initSendMoneyGroup;
        this.getAuthRequestContext = getEditMemberSwitch;
        this.scheduleImpl = getGroupSendDetail;
        this.getErrorConfigVersion = saveRecentGroup;
        this.BuiltInFictitiousFunctionClassFactory = getGroupFavoriteValue;
        MutableStateFlow<GroupSendSummaryUIState> MutableStateFlow = StateFlowKt.MutableStateFlow(GroupSendSummaryUIState.None.INSTANCE);
        this.MyBillsEntityDataFactory = MutableStateFlow;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final void MyBillsEntityDataFactory(String p0, List<String> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        BaseFlowUseCase.execute$default(this.lookAheadTest, new InitSendMoneyGroup.Param(null, p0, p1, 1, null), new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$initSendMoneyGroup$1
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
                mutableStateFlow = GroupSendSummaryViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    GroupSendSummaryUIState groupSendSummaryUIState = (GroupSendSummaryUIState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupSendSummaryUIState.ShimmerLoading(true)));
            }
        }, new Function1<SendMoneyGroupInit, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$initSendMoneyGroup$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SendMoneyGroupInit sendMoneyGroupInit) {
                invoke2(sendMoneyGroupInit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SendMoneyGroupInit sendMoneyGroupInit) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(sendMoneyGroupInit, "");
                mutableStateFlow = GroupSendSummaryViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    GroupSendSummaryUIState groupSendSummaryUIState = (GroupSendSummaryUIState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupSendSummaryUIState.OnGetSendMoneyGroupInit(GroupSendSummaryModelMapperKt.BuiltInFictitiousFunctionClassFactory(sendMoneyGroupInit))));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$initSendMoneyGroup$3
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
                mutableStateFlow = GroupSendSummaryViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    GroupSendSummaryUIState groupSendSummaryUIState = (GroupSendSummaryUIState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupSendSummaryUIState.Error(0, th, GroupSendOperationType.GROUP_INIT, 1, null)));
            }
        }, null, ViewModelKt.PlaceComponentResult(this), 16, null);
    }

    public final void MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        BaseFlowUseCase.execute$default(this.scheduleImpl, new GetGroupSendDetail.Param(p0), new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$getGroupDetail$1
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
                mutableStateFlow = GroupSendSummaryViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    GroupSendSummaryUIState groupSendSummaryUIState = (GroupSendSummaryUIState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupSendSummaryUIState.ShimmerLoading(true)));
            }
        }, new Function1<BizGroupDetailResult, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$getGroupDetail$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(BizGroupDetailResult bizGroupDetailResult) {
                invoke2(bizGroupDetailResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(BizGroupDetailResult bizGroupDetailResult) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(bizGroupDetailResult, "");
                mutableStateFlow = GroupSendSummaryViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    GroupSendSummaryUIState groupSendSummaryUIState = (GroupSendSummaryUIState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupSendSummaryUIState.OnSuccessGetGroupDetail(GroupSendDetailModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(bizGroupDetailResult))));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$getGroupDetail$3
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
                mutableStateFlow = GroupSendSummaryViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    GroupSendSummaryUIState groupSendSummaryUIState = (GroupSendSummaryUIState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupSendSummaryUIState.Error(0, th, GroupSendOperationType.GROUP_DETAIL, 1, null)));
            }
        }, null, ViewModelKt.PlaceComponentResult(this), 16, null);
    }

    @Override // androidx.view.ViewModel
    public final void onCleared() {
        this.getErrorConfigVersion.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }
}

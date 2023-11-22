package id.dana.sendmoney.ui.groupsend.summary.activity;

import androidx.view.Lifecycle;
import androidx.view.RepeatOnLifecycleKt;
import androidx.view.ViewModelKt;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.sendmoney.R;
import id.dana.sendmoney.constants.GroupSendRecipientType;
import id.dana.sendmoney.domain.groupsend.GroupSendOperationType;
import id.dana.sendmoney.ui.groupsend.groupdetail.model.BizGroupDetailResultModel;
import id.dana.sendmoney.ui.groupsend.landing.model.GroupModel;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import id.dana.sendmoney.ui.groupsend.summary.model.GroupSendIntentModel;
import id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryUIState;
import id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel;
import id.dana.sendmoney.util.CashierUtilKt;
import id.dana.sendmoney.util.GroupSendTrackerHelper;
import id.dana.sendmoney.util.SourceTypeProperty;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity$initLifecycleActivity$1", f = "GroupSendSummaryActivity.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class GroupSendSummaryActivity$initLifecycleActivity$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GroupSendSummaryActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupSendSummaryActivity$initLifecycleActivity$1(GroupSendSummaryActivity groupSendSummaryActivity, Continuation<? super GroupSendSummaryActivity$initLifecycleActivity$1> continuation) {
        super(2, continuation);
        this.this$0 = groupSendSummaryActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GroupSendSummaryActivity$initLifecycleActivity$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GroupSendSummaryActivity$initLifecycleActivity$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity$initLifecycleActivity$1$1", f = "GroupSendSummaryActivity.kt", i = {}, l = {250}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity$initLifecycleActivity$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GroupSendSummaryActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(GroupSendSummaryActivity groupSendSummaryActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = groupSendSummaryActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<GroupSendSummaryUIState> stateFlow = GroupSendSummaryActivity.access$getVm(this.this$0).NetworkUserEntityData$$ExternalSyntheticLambda0;
                final GroupSendSummaryActivity groupSendSummaryActivity = this.this$0;
                this.label = 1;
                if (stateFlow.collect(new FlowCollector() { // from class: id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity.initLifecycleActivity.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
                    public final Object emit(GroupSendSummaryUIState groupSendSummaryUIState, Continuation<? super Unit> continuation) {
                        if (!(groupSendSummaryUIState instanceof GroupSendSummaryUIState.None)) {
                            if (groupSendSummaryUIState instanceof GroupSendSummaryUIState.ShimmerLoading) {
                                GroupSendSummaryActivity.access$setShimmerLoadingVisibility(GroupSendSummaryActivity.this, ((GroupSendSummaryUIState.ShimmerLoading) groupSendSummaryUIState).getGetAuthRequestContext());
                            } else if (groupSendSummaryUIState instanceof GroupSendSummaryUIState.DanaLogoLoading) {
                                GroupSendSummaryActivity.access$setDanaLoadingVisibility(GroupSendSummaryActivity.this, ((GroupSendSummaryUIState.DanaLogoLoading) groupSendSummaryUIState).getPlaceComponentResult());
                            } else {
                                if (groupSendSummaryUIState instanceof GroupSendSummaryUIState.Error) {
                                    GroupSendSummaryActivity.this.PlaceComponentResult(true);
                                    GroupSendTrackerHelper groupSendTrackerHelper = GroupSendSummaryActivity.this.getGroupSendTrackerHelper();
                                    GroupSendSummaryUIState.Error error = (GroupSendSummaryUIState.Error) groupSendSummaryUIState;
                                    Throwable th = error.MyBillsEntityDataFactory;
                                    String str = error.PlaceComponentResult;
                                    String string = GroupSendSummaryActivity.this.getString(R.string.general_error_desc_failed_load);
                                    Intrinsics.checkNotNullExpressionValue(string, "");
                                    groupSendTrackerHelper.MyBillsEntityDataFactory(th, str, string, SourceTypeProperty.GROUP_SEND_SUMMARY);
                                } else if (!(groupSendSummaryUIState instanceof GroupSendSummaryUIState.OnSuccessGetGroupDetail)) {
                                    if (!(groupSendSummaryUIState instanceof GroupSendSummaryUIState.OnSuccessGetGroupFavoriteValue)) {
                                        if (groupSendSummaryUIState instanceof GroupSendSummaryUIState.OnGetSendMoneyGroupInit) {
                                            GroupSendSummaryUIState.OnGetSendMoneyGroupInit onGetSendMoneyGroupInit = (GroupSendSummaryUIState.OnGetSendMoneyGroupInit) groupSendSummaryUIState;
                                            GroupSendSummaryActivity.this.setGroupSendInitResponse(onGetSendMoneyGroupInit.PlaceComponentResult);
                                            GroupSendSummaryActivity.this.setRemainingLimit(onGetSendMoneyGroupInit.PlaceComponentResult.PlaceComponentResult);
                                            GroupSendSummaryActivity.access$checkIsThereNonDanaUser(GroupSendSummaryActivity.this);
                                            GroupSendSummaryActivity.access$updateParticipantAdapterList(GroupSendSummaryActivity.this);
                                            GroupSendSummaryActivity.access$updatePreviousTransactionAvatarList(GroupSendSummaryActivity.this);
                                            GroupSendSummaryActivity.this.getErrorConfigVersion();
                                            final GroupSendSummaryViewModel access$getVm = GroupSendSummaryActivity.access$getVm(GroupSendSummaryActivity.this);
                                            BaseFlowUseCase.execute$default(access$getVm.getAuthRequestContext, NoParams.INSTANCE, null, new Function1<Boolean, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$getEditMemberSwitch$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final /* synthetic */ Unit invoke(Boolean bool) {
                                                    invoke(bool.booleanValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(boolean z) {
                                                    MutableStateFlow mutableStateFlow;
                                                    Object value;
                                                    mutableStateFlow = GroupSendSummaryViewModel.this.MyBillsEntityDataFactory;
                                                    do {
                                                        value = mutableStateFlow.getValue();
                                                        GroupSendSummaryUIState groupSendSummaryUIState2 = (GroupSendSummaryUIState) value;
                                                    } while (!mutableStateFlow.compareAndSet(value, new GroupSendSummaryUIState.OnSuccessGetEditMemberSwitch(z)));
                                                }
                                            }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$getEditMemberSwitch$2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                                                    invoke2(th2);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                public final void invoke2(Throwable th2) {
                                                    MutableStateFlow mutableStateFlow;
                                                    Object value;
                                                    Intrinsics.checkNotNullParameter(th2, "");
                                                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.GROUP_SEND_EXCEPTION, th2.getMessage(), th2);
                                                    mutableStateFlow = GroupSendSummaryViewModel.this.MyBillsEntityDataFactory;
                                                    do {
                                                        value = mutableStateFlow.getValue();
                                                        GroupSendSummaryUIState groupSendSummaryUIState2 = (GroupSendSummaryUIState) value;
                                                    } while (!mutableStateFlow.compareAndSet(value, new GroupSendSummaryUIState.Error(0, th2, GroupSendOperationType.GROUP_GET_EDIT_MEMBER_SWITCH, 1, null)));
                                                }
                                            }, null, ViewModelKt.PlaceComponentResult(access$getVm), 18, null);
                                        } else if (groupSendSummaryUIState instanceof GroupSendSummaryUIState.OnSuccessGetEditMemberSwitch) {
                                            GroupSendSummaryActivity.access$setEditMemberButtonVisibility(GroupSendSummaryActivity.this, ((GroupSendSummaryUIState.OnSuccessGetEditMemberSwitch) groupSendSummaryUIState).getPlaceComponentResult());
                                            final GroupSendSummaryViewModel access$getVm2 = GroupSendSummaryActivity.access$getVm(GroupSendSummaryActivity.this);
                                            BaseFlowUseCase.execute$default(access$getVm2.PlaceComponentResult, NoParams.INSTANCE, null, new Function1<Integer, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$getDefaultAvatarGroup$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final /* synthetic */ Unit invoke(Integer num) {
                                                    invoke(num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(int i2) {
                                                    MutableStateFlow mutableStateFlow;
                                                    Object value;
                                                    mutableStateFlow = GroupSendSummaryViewModel.this.MyBillsEntityDataFactory;
                                                    do {
                                                        value = mutableStateFlow.getValue();
                                                        GroupSendSummaryUIState groupSendSummaryUIState2 = (GroupSendSummaryUIState) value;
                                                    } while (!mutableStateFlow.compareAndSet(value, new GroupSendSummaryUIState.OnSuccessGetAvatars(i2)));
                                                }
                                            }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$getDefaultAvatarGroup$2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                                                    invoke2(th2);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                public final void invoke2(Throwable th2) {
                                                    MutableStateFlow mutableStateFlow;
                                                    Object value;
                                                    Intrinsics.checkNotNullParameter(th2, "");
                                                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.GROUP_SEND_EXCEPTION, th2.getMessage(), th2);
                                                    mutableStateFlow = GroupSendSummaryViewModel.this.MyBillsEntityDataFactory;
                                                    do {
                                                        value = mutableStateFlow.getValue();
                                                        GroupSendSummaryUIState groupSendSummaryUIState2 = (GroupSendSummaryUIState) value;
                                                    } while (!mutableStateFlow.compareAndSet(value, new GroupSendSummaryUIState.Error(0, th2, GroupSendOperationType.GROUP_GET_DEFAULT_AVATAR_GROUP, 1, null)));
                                                }
                                            }, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel$getDefaultAvatarGroup$3
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
                                                        GroupSendSummaryUIState groupSendSummaryUIState2 = (GroupSendSummaryUIState) value;
                                                    } while (!mutableStateFlow.compareAndSet(value, new GroupSendSummaryUIState.ShimmerLoading(false)));
                                                }
                                            }, ViewModelKt.PlaceComponentResult(access$getVm2), 2, null);
                                        } else if (groupSendSummaryUIState instanceof GroupSendSummaryUIState.OnSuccessGetAvatars) {
                                            GroupSendSummaryActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = ((GroupSendSummaryUIState.OnSuccessGetAvatars) groupSendSummaryUIState).KClassImpl$Data$declaredNonStaticMembers$2;
                                            GroupSendSummaryActivity.access$initGroupImage(GroupSendSummaryActivity.this);
                                        } else if (groupSendSummaryUIState instanceof GroupSendSummaryUIState.OnSuccessConfirmSendMoneyGroup) {
                                            GroupSendSummaryActivity groupSendSummaryActivity2 = GroupSendSummaryActivity.this;
                                            GroupSendSummaryUIState.OnSuccessConfirmSendMoneyGroup onSuccessConfirmSendMoneyGroup = (GroupSendSummaryUIState.OnSuccessConfirmSendMoneyGroup) groupSendSummaryUIState;
                                            String str2 = onSuccessConfirmSendMoneyGroup.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
                                            GroupSendSummaryActivity.access$updateGroupSendGroupId(groupSendSummaryActivity2, str2 != null ? str2 : "");
                                            CashierUtilKt.getAuthRequestContext(GroupSendSummaryActivity.this, onSuccessConfirmSendMoneyGroup.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0, "Send Money", null, 20);
                                            GroupSendSummaryActivity.this.scheduleImpl = false;
                                            GroupSendSummaryActivity.access$setGroupModifiedResult(GroupSendSummaryActivity.this);
                                        }
                                    } else {
                                        GroupSendSummaryActivity.this.getSummaryIntentModel().KClassImpl$Data$declaredNonStaticMembers$2 = ((GroupSendSummaryUIState.OnSuccessGetGroupFavoriteValue) groupSendSummaryUIState).getMyBillsEntityDataFactory();
                                    }
                                } else {
                                    BizGroupDetailResultModel bizGroupDetailResultModel = ((GroupSendSummaryUIState.OnSuccessGetGroupDetail) groupSendSummaryUIState).PlaceComponentResult;
                                    GroupModel groupModel = bizGroupDetailResultModel.MyBillsEntityDataFactory;
                                    GroupSendIntentModel summaryIntentModel = GroupSendSummaryActivity.this.getSummaryIntentModel();
                                    GroupSendSummaryActivity groupSendSummaryActivity3 = GroupSendSummaryActivity.this;
                                    String str3 = groupModel.BuiltInFictitiousFunctionClassFactory;
                                    Intrinsics.checkNotNullParameter(str3, "");
                                    summaryIntentModel.BuiltInFictitiousFunctionClassFactory = str3;
                                    String str4 = groupModel.getAuthRequestContext;
                                    Intrinsics.checkNotNullParameter(str4, "");
                                    summaryIntentModel.getAuthRequestContext = str4;
                                    String str5 = groupModel.MyBillsEntityDataFactory;
                                    Intrinsics.checkNotNullParameter(str5, "");
                                    summaryIntentModel.MyBillsEntityDataFactory = str5;
                                    String str6 = groupModel.PlaceComponentResult;
                                    Intrinsics.checkNotNullParameter(str6, "");
                                    summaryIntentModel.PlaceComponentResult = str6;
                                    String KClassImpl$Data$declaredNonStaticMembers$2 = bizGroupDetailResultModel.KClassImpl$Data$declaredNonStaticMembers$2();
                                    Intrinsics.checkNotNullParameter(KClassImpl$Data$declaredNonStaticMembers$2, "");
                                    summaryIntentModel.moveToNextValue = KClassImpl$Data$declaredNonStaticMembers$2;
                                    List<RecipientViewModel> PlaceComponentResult = bizGroupDetailResultModel.PlaceComponentResult(groupSendSummaryActivity3);
                                    Intrinsics.checkNotNullParameter(PlaceComponentResult, "");
                                    summaryIntentModel.scheduleImpl = PlaceComponentResult;
                                    GroupSendSummaryActivity.this.BuiltInFictitiousFunctionClassFactory();
                                    ((GroupSendSummaryViewModel) r10.moveToNextValue.getValue()).MyBillsEntityDataFactory(Intrinsics.areEqual(r3.getSummaryIntentModel().moveToNextValue, GroupSendRecipientType.CONTACT) ? "BALANCE" : "BANK_TRANSFER", GroupSendSummaryActivity.this.getSummaryIntentModel().getAuthRequestContext());
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (RepeatOnLifecycleKt.KClassImpl$Data$declaredNonStaticMembers$2(this.this$0, Lifecycle.State.STARTED, new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}

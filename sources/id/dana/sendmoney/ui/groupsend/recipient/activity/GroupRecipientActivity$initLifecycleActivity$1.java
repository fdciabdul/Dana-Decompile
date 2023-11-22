package id.dana.sendmoney.ui.groupsend.recipient.activity;

import androidx.view.Lifecycle;
import androidx.view.RepeatOnLifecycleKt;
import androidx.view.ViewModelKt;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import id.dana.core.ui.dialog.DanaLogoLoadingDialog;
import id.dana.core.ui.util.DANAToast;
import id.dana.sendmoney.R;
import id.dana.sendmoney.domain.groupsend.GroupSendOperationType;
import id.dana.sendmoney.domain.groupsend.interactor.ModifyGroupParticipants;
import id.dana.sendmoney.domain.groupsend.model.modify.BizGroupModifyResult;
import id.dana.sendmoney.ui.groupsend.recipient.util.GroupRecipientPermissionHelper;
import id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientUiState;
import id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientViewModel;
import id.dana.sendmoney.util.GroupSendTrackerHelper;
import id.dana.sendmoney.util.SourceTypeProperty;
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
@DebugMetadata(c = "id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$initLifecycleActivity$1", f = "GroupRecipientActivity.kt", i = {}, l = {431}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class GroupRecipientActivity$initLifecycleActivity$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GroupRecipientActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupRecipientActivity$initLifecycleActivity$1(GroupRecipientActivity groupRecipientActivity, Continuation<? super GroupRecipientActivity$initLifecycleActivity$1> continuation) {
        super(2, continuation);
        this.this$0 = groupRecipientActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GroupRecipientActivity$initLifecycleActivity$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GroupRecipientActivity$initLifecycleActivity$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$initLifecycleActivity$1$1", f = "GroupRecipientActivity.kt", i = {}, l = {432}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity$initLifecycleActivity$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GroupRecipientActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(GroupRecipientActivity groupRecipientActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = groupRecipientActivity;
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
                StateFlow<GroupRecipientUiState> stateFlow = GroupRecipientActivity.access$getVm(this.this$0).NetworkUserEntityData$$ExternalSyntheticLambda1;
                final GroupRecipientActivity groupRecipientActivity = this.this$0;
                this.label = 1;
                if (stateFlow.collect(new FlowCollector() { // from class: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity.initLifecycleActivity.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* renamed from: PlaceComponentResult  reason: merged with bridge method [inline-methods] */
                    public final Object emit(GroupRecipientUiState groupRecipientUiState, Continuation<? super Unit> continuation) {
                        String str;
                        boolean z;
                        List list;
                        if (groupRecipientUiState instanceof GroupRecipientUiState.Loading) {
                            GroupRecipientActivity.this.KClassImpl$Data$declaredNonStaticMembers$2(((GroupRecipientUiState.Loading) groupRecipientUiState).getPlaceComponentResult());
                        } else if (groupRecipientUiState instanceof GroupRecipientUiState.Error) {
                            GroupRecipientActivity.access$turnOffLoadingAndReObserve(GroupRecipientActivity.this);
                        } else if (groupRecipientUiState instanceof GroupRecipientUiState.OnSuccessGetMaxGroupParticipant) {
                            GroupRecipientActivity.this.DatabaseTableConfigUtil = ((GroupRecipientUiState.OnSuccessGetMaxGroupParticipant) groupRecipientUiState).KClassImpl$Data$declaredNonStaticMembers$2;
                        } else if (groupRecipientUiState instanceof GroupRecipientUiState.OnSuccessGetRecipientSyncContacts) {
                            GroupRecipientActivity.this.KClassImpl$Data$declaredNonStaticMembers$2 = ((GroupRecipientUiState.OnSuccessGetRecipientSyncContacts) groupRecipientUiState).KClassImpl$Data$declaredNonStaticMembers$2;
                            GroupRecipientActivity.this.getErrorConfigVersion();
                            GroupRecipientActivity groupRecipientActivity2 = GroupRecipientActivity.this;
                            list = groupRecipientActivity2.KClassImpl$Data$declaredNonStaticMembers$2;
                            groupRecipientActivity2.PlaceComponentResult(list, true);
                            GroupRecipientActivity.access$observePagedContactList(GroupRecipientActivity.this);
                        } else if (groupRecipientUiState instanceof GroupRecipientUiState.OnSuccessGetIsNeedToShowBottomSheet) {
                            GroupRecipientActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda2 = ((GroupRecipientUiState.OnSuccessGetIsNeedToShowBottomSheet) groupRecipientUiState).getGetAuthRequestContext();
                            GroupRecipientPermissionHelper groupRecipientPermissionHelper = GroupRecipientPermissionHelper.INSTANCE;
                            GroupRecipientActivity groupRecipientActivity3 = GroupRecipientActivity.this;
                            GroupRecipientActivity groupRecipientActivity4 = groupRecipientActivity3;
                            z = groupRecipientActivity3.NetworkUserEntityData$$ExternalSyntheticLambda2;
                            final GroupRecipientActivity groupRecipientActivity5 = GroupRecipientActivity.this;
                            Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity.initLifecycleActivity.1.1.1.1
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
                                    GroupRecipientActivity.access$showBottomSheetPermissionDialog(GroupRecipientActivity.this);
                                }
                            };
                            final GroupRecipientActivity groupRecipientActivity6 = GroupRecipientActivity.this;
                            Function0<Unit> function02 = new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity.initLifecycleActivity.1.1.1.2
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
                                    ActivityPermissionRequest activityPermissionRequest;
                                    activityPermissionRequest = GroupRecipientActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                                    activityPermissionRequest.check();
                                }
                            };
                            Intrinsics.checkNotNullParameter(groupRecipientActivity4, "");
                            Intrinsics.checkNotNullParameter(function0, "");
                            Intrinsics.checkNotNullParameter(function02, "");
                            if (!GroupRecipientPermissionHelper.getAuthRequestContext(groupRecipientActivity4)) {
                                function02.invoke();
                            } else if (z) {
                                function0.invoke();
                            } else {
                                function02.invoke();
                            }
                        } else if (groupRecipientUiState instanceof GroupRecipientUiState.OnSuccessGetPhoneNumber) {
                            GroupRecipientActivity.this.newProxyInstance = ((GroupRecipientUiState.OnSuccessGetPhoneNumber) groupRecipientUiState).KClassImpl$Data$declaredNonStaticMembers$2;
                        } else if (groupRecipientUiState instanceof GroupRecipientUiState.DanaLoadingDialog) {
                            if (((GroupRecipientUiState.DanaLoadingDialog) groupRecipientUiState).getKClassImpl$Data$declaredNonStaticMembers$2()) {
                                DanaLogoLoadingDialog access$getDanaLogoLoadingDialog = GroupRecipientActivity.access$getDanaLogoLoadingDialog(GroupRecipientActivity.this);
                                if (!access$getDanaLogoLoadingDialog.KClassImpl$Data$declaredNonStaticMembers$2.isShowing()) {
                                    access$getDanaLogoLoadingDialog.KClassImpl$Data$declaredNonStaticMembers$2.show();
                                    access$getDanaLogoLoadingDialog.MyBillsEntityDataFactory.startRefresh();
                                }
                            } else {
                                GroupRecipientActivity.access$getDanaLogoLoadingDialog(GroupRecipientActivity.this).PlaceComponentResult();
                            }
                        } else if (groupRecipientUiState instanceof GroupRecipientUiState.OnGetSendMoneyGroupInit) {
                            GroupRecipientActivity groupRecipientActivity7 = GroupRecipientActivity.this;
                            List access$syncContactNameWithResultFromInit = GroupRecipientActivity.access$syncContactNameWithResultFromInit(groupRecipientActivity7, GroupRecipientActivity.access$generateModifiedList(groupRecipientActivity7), ((GroupRecipientUiState.OnGetSendMoneyGroupInit) groupRecipientUiState).BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2);
                            final GroupRecipientViewModel access$getVm = GroupRecipientActivity.access$getVm(GroupRecipientActivity.this);
                            str = GroupRecipientActivity.this.moveToNextValue;
                            Intrinsics.checkNotNullParameter(str, "");
                            Intrinsics.checkNotNullParameter(access$syncContactNameWithResultFromInit, "");
                            access$getVm.getErrorConfigVersion.execute(new ModifyGroupParticipants.Param(str, access$syncContactNameWithResultFromInit), new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientViewModel$modifyGroupParticipants$1
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
                                    mutableStateFlow = GroupRecipientViewModel.this.getAuthRequestContext;
                                    do {
                                        value = mutableStateFlow.getValue();
                                        GroupRecipientUiState groupRecipientUiState2 = (GroupRecipientUiState) value;
                                    } while (!mutableStateFlow.compareAndSet(value, new GroupRecipientUiState.DanaLoadingDialog(true)));
                                }
                            }, new Function1<BizGroupModifyResult, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientViewModel$modifyGroupParticipants$2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final /* bridge */ /* synthetic */ Unit invoke(BizGroupModifyResult bizGroupModifyResult) {
                                    invoke2(bizGroupModifyResult);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(BizGroupModifyResult bizGroupModifyResult) {
                                    MutableStateFlow mutableStateFlow;
                                    Object value;
                                    Intrinsics.checkNotNullParameter(bizGroupModifyResult, "");
                                    mutableStateFlow = GroupRecipientViewModel.this.getAuthRequestContext;
                                    do {
                                        value = mutableStateFlow.getValue();
                                        GroupRecipientUiState groupRecipientUiState2 = (GroupRecipientUiState) value;
                                    } while (!mutableStateFlow.compareAndSet(value, new GroupRecipientUiState.OnSuccessModifyGroup(bizGroupModifyResult.PlaceComponentResult)));
                                }
                            }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientViewModel$modifyGroupParticipants$3
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
                                    mutableStateFlow = GroupRecipientViewModel.this.getAuthRequestContext;
                                    do {
                                        value = mutableStateFlow.getValue();
                                        GroupRecipientUiState groupRecipientUiState2 = (GroupRecipientUiState) value;
                                    } while (!mutableStateFlow.compareAndSet(value, new GroupRecipientUiState.OnErrorModifyGroup(th, GroupSendOperationType.GROUP_MODIFY)));
                                }
                            }, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientViewModel$modifyGroupParticipants$4
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
                                    mutableStateFlow = GroupRecipientViewModel.this.getAuthRequestContext;
                                    do {
                                        value = mutableStateFlow.getValue();
                                        GroupRecipientUiState groupRecipientUiState2 = (GroupRecipientUiState) value;
                                    } while (!mutableStateFlow.compareAndSet(value, new GroupRecipientUiState.DanaLoadingDialog(false)));
                                }
                            }, ViewModelKt.PlaceComponentResult(access$getVm));
                        } else if (groupRecipientUiState instanceof GroupRecipientUiState.OnSuccessModifyGroup) {
                            GroupRecipientActivity.access$setResultAndNavigateBackToDetailActivity(GroupRecipientActivity.this, ((GroupRecipientUiState.OnSuccessModifyGroup) groupRecipientUiState).BuiltInFictitiousFunctionClassFactory);
                        } else if (groupRecipientUiState instanceof GroupRecipientUiState.OnErrorModifyGroup) {
                            GroupRecipientActivity.access$setResultAndNavigateBackToDetailActivity(GroupRecipientActivity.this, "");
                            GroupSendTrackerHelper groupSendTrackerHelper = GroupRecipientActivity.this.getGroupSendTrackerHelper();
                            GroupRecipientUiState.OnErrorModifyGroup onErrorModifyGroup = (GroupRecipientUiState.OnErrorModifyGroup) groupRecipientUiState;
                            Throwable th = onErrorModifyGroup.MyBillsEntityDataFactory;
                            String str2 = onErrorModifyGroup.PlaceComponentResult;
                            String string = GroupRecipientActivity.this.getString(R.string.res_0x7f13171b_getwalletv3recommendationconfig_lambda_193);
                            Intrinsics.checkNotNullExpressionValue(string, "");
                            groupSendTrackerHelper.MyBillsEntityDataFactory(th, str2, string, SourceTypeProperty.GROUP_SEND_SELECT_CONTACT);
                            DANAToast dANAToast = DANAToast.BuiltInFictitiousFunctionClassFactory;
                            GroupRecipientActivity groupRecipientActivity8 = GroupRecipientActivity.this;
                            GroupRecipientActivity groupRecipientActivity9 = groupRecipientActivity8;
                            String string2 = groupRecipientActivity8.getString(R.string.res_0x7f13171b_getwalletv3recommendationconfig_lambda_193);
                            Intrinsics.checkNotNullExpressionValue(string2, "");
                            DANAToast.MyBillsEntityDataFactory(groupRecipientActivity9, string2, "");
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

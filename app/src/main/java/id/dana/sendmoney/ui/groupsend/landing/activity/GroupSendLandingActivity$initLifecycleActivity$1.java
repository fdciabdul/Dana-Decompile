package id.dana.sendmoney.ui.groupsend.landing.activity;

import androidx.view.Lifecycle;
import androidx.view.RepeatOnLifecycleKt;
import id.dana.core.ui.util.DANAToast;
import id.dana.sendmoney.R;
import id.dana.sendmoney.ui.groupsend.landing.viewmodel.GroupSendLandingUiState;
import id.dana.sendmoney.util.GroupSendTrackerHelper;
import id.dana.sendmoney.util.SourceTypeProperty;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity$initLifecycleActivity$1", f = "GroupSendLandingActivity.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class GroupSendLandingActivity$initLifecycleActivity$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GroupSendLandingActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupSendLandingActivity$initLifecycleActivity$1(GroupSendLandingActivity groupSendLandingActivity, Continuation<? super GroupSendLandingActivity$initLifecycleActivity$1> continuation) {
        super(2, continuation);
        this.this$0 = groupSendLandingActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GroupSendLandingActivity$initLifecycleActivity$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GroupSendLandingActivity$initLifecycleActivity$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity$initLifecycleActivity$1$1", f = "GroupSendLandingActivity.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity$initLifecycleActivity$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GroupSendLandingActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(GroupSendLandingActivity groupSendLandingActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = groupSendLandingActivity;
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
                StateFlow<GroupSendLandingUiState> stateFlow = GroupSendLandingActivity.access$getVm(this.this$0).getErrorConfigVersion;
                final GroupSendLandingActivity groupSendLandingActivity = this.this$0;
                this.label = 1;
                if (stateFlow.collect(new FlowCollector() { // from class: id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity.initLifecycleActivity.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* renamed from: PlaceComponentResult  reason: merged with bridge method [inline-methods] */
                    public final Object emit(GroupSendLandingUiState groupSendLandingUiState, Continuation<? super Unit> continuation) {
                        if (groupSendLandingUiState instanceof GroupSendLandingUiState.Error) {
                            GroupSendTrackerHelper groupSendTrackerHelper = GroupSendLandingActivity.this.getGroupSendTrackerHelper();
                            GroupSendLandingUiState.Error error = (GroupSendLandingUiState.Error) groupSendLandingUiState;
                            Throwable th = error.MyBillsEntityDataFactory;
                            String str = error.getAuthRequestContext;
                            String string = GroupSendLandingActivity.this.getString(R.string.general_error_desc_failed_load);
                            Intrinsics.checkNotNullExpressionValue(string, "");
                            groupSendTrackerHelper.MyBillsEntityDataFactory(th, str, string, SourceTypeProperty.GROUP_SEND_LANDING);
                            GroupSendLandingActivity.this.PlaceComponentResult(true);
                        } else if (groupSendLandingUiState instanceof GroupSendLandingUiState.ErrorToast) {
                            DANAToast dANAToast = DANAToast.BuiltInFictitiousFunctionClassFactory;
                            GroupSendLandingActivity groupSendLandingActivity2 = GroupSendLandingActivity.this;
                            String string2 = groupSendLandingActivity2.getString(((GroupSendLandingUiState.ErrorToast) groupSendLandingUiState).KClassImpl$Data$declaredNonStaticMembers$2);
                            Intrinsics.checkNotNullExpressionValue(string2, "");
                            DANAToast.MyBillsEntityDataFactory(groupSendLandingActivity2, string2, "");
                        } else if (groupSendLandingUiState instanceof GroupSendLandingUiState.ShimmerLoading) {
                            GroupSendLandingActivity.access$updateViewOnLoading(GroupSendLandingActivity.this, ((GroupSendLandingUiState.ShimmerLoading) groupSendLandingUiState).getBuiltInFictitiousFunctionClassFactory());
                        } else if (groupSendLandingUiState instanceof GroupSendLandingUiState.DanaLoadingDialog) {
                            GroupSendLandingActivity.access$setDanaLoadingState(GroupSendLandingActivity.this, ((GroupSendLandingUiState.DanaLoadingDialog) groupSendLandingUiState).getPlaceComponentResult());
                        } else if (groupSendLandingUiState instanceof GroupSendLandingUiState.OnSuccessGetIsNeedToShowBottomSheet) {
                            GroupSendLandingActivity.access$handleOnSuccessIsNeedToShowBottomSheet(GroupSendLandingActivity.this, ((GroupSendLandingUiState.OnSuccessGetIsNeedToShowBottomSheet) groupSendLandingUiState).getPlaceComponentResult());
                        } else if (groupSendLandingUiState instanceof GroupSendLandingUiState.OnSuccessGetGroupSendQuery) {
                            GroupSendLandingActivity.access$handleOnSuccessGetGroupSendQuery(GroupSendLandingActivity.this, ((GroupSendLandingUiState.OnSuccessGetGroupSendQuery) groupSendLandingUiState).KClassImpl$Data$declaredNonStaticMembers$2);
                        } else if (groupSendLandingUiState instanceof GroupSendLandingUiState.OnSuccessGetGroupSendScenario) {
                            GroupSendLandingActivity.access$handleOnSuccessGetGroupSendScenario(GroupSendLandingActivity.this, ((GroupSendLandingUiState.OnSuccessGetGroupSendScenario) groupSendLandingUiState).BuiltInFictitiousFunctionClassFactory);
                        } else if (groupSendLandingUiState instanceof GroupSendLandingUiState.OnSuccessGetGroupSendMaxGroup) {
                            GroupSendLandingActivity.access$setSendBtnState(GroupSendLandingActivity.this, ((GroupSendLandingUiState.OnSuccessGetGroupSendMaxGroup) groupSendLandingUiState).KClassImpl$Data$declaredNonStaticMembers$2);
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

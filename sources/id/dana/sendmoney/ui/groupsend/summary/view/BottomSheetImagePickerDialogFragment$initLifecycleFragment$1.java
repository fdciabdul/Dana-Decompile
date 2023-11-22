package id.dana.sendmoney.ui.groupsend.summary.view;

import androidx.fragment.app.FragmentActivity;
import androidx.view.Lifecycle;
import androidx.view.RepeatOnLifecycleKt;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import id.dana.core.ui.dialog.DanaLogoLoadingDialog;
import id.dana.core.ui.util.DANAToast;
import id.dana.sendmoney.R;
import id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendImagePickerUIState;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.ui.groupsend.summary.view.BottomSheetImagePickerDialogFragment$initLifecycleFragment$1", f = "BottomSheetImagePickerDialogFragment.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class BottomSheetImagePickerDialogFragment$initLifecycleFragment$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BottomSheetImagePickerDialogFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetImagePickerDialogFragment$initLifecycleFragment$1(BottomSheetImagePickerDialogFragment bottomSheetImagePickerDialogFragment, Continuation<? super BottomSheetImagePickerDialogFragment$initLifecycleFragment$1> continuation) {
        super(2, continuation);
        this.this$0 = bottomSheetImagePickerDialogFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BottomSheetImagePickerDialogFragment$initLifecycleFragment$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BottomSheetImagePickerDialogFragment$initLifecycleFragment$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.sendmoney.ui.groupsend.summary.view.BottomSheetImagePickerDialogFragment$initLifecycleFragment$1$1", f = "BottomSheetImagePickerDialogFragment.kt", i = {}, l = {TarHeader.USTAR_FILENAME_PREFIX}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.sendmoney.ui.groupsend.summary.view.BottomSheetImagePickerDialogFragment$initLifecycleFragment$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BottomSheetImagePickerDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BottomSheetImagePickerDialogFragment bottomSheetImagePickerDialogFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = bottomSheetImagePickerDialogFragment;
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
                StateFlow<GroupSendImagePickerUIState> stateFlow = BottomSheetImagePickerDialogFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(this.this$0).getAuthRequestContext;
                final BottomSheetImagePickerDialogFragment bottomSheetImagePickerDialogFragment = this.this$0;
                this.label = 1;
                if (stateFlow.collect(new FlowCollector() { // from class: id.dana.sendmoney.ui.groupsend.summary.view.BottomSheetImagePickerDialogFragment.initLifecycleFragment.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
                    public final Object emit(GroupSendImagePickerUIState groupSendImagePickerUIState, Continuation<? super Unit> continuation) {
                        Function1 function1;
                        if (groupSendImagePickerUIState instanceof GroupSendImagePickerUIState.OnUploadSuccess) {
                            function1 = BottomSheetImagePickerDialogFragment.this.lookAheadTest;
                            Object invoke = function1.invoke(((GroupSendImagePickerUIState.OnUploadSuccess) groupSendImagePickerUIState).PlaceComponentResult);
                            if (invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                return invoke;
                            }
                        } else if (groupSendImagePickerUIState instanceof GroupSendImagePickerUIState.Error) {
                            GroupSendImagePickerUIState.Error error = (GroupSendImagePickerUIState.Error) groupSendImagePickerUIState;
                            String str = error.PlaceComponentResult;
                            if (str == null) {
                                str = BottomSheetImagePickerDialogFragment.this.getString(R.string.SchedulerPoolFactory);
                                Intrinsics.checkNotNullExpressionValue(str, "");
                            }
                            DANAToast dANAToast = DANAToast.BuiltInFictitiousFunctionClassFactory;
                            FragmentActivity requireActivity = BottomSheetImagePickerDialogFragment.this.requireActivity();
                            Intrinsics.checkNotNullExpressionValue(requireActivity, "");
                            DANAToast.MyBillsEntityDataFactory(requireActivity, str, "");
                            GroupSendTrackerHelper groupSendTrackerHelper = BottomSheetImagePickerDialogFragment.this.groupSendTrackerHelper;
                            if (groupSendTrackerHelper == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                                groupSendTrackerHelper = null;
                            }
                            groupSendTrackerHelper.MyBillsEntityDataFactory(error.BuiltInFictitiousFunctionClassFactory, error.getAuthRequestContext, str, SourceTypeProperty.GROUP_SEND_UPLOAD_IMAGE);
                        } else if (groupSendImagePickerUIState instanceof GroupSendImagePickerUIState.OnFileSizeLimitExceeded) {
                            DANAToast dANAToast2 = DANAToast.BuiltInFictitiousFunctionClassFactory;
                            FragmentActivity requireActivity2 = BottomSheetImagePickerDialogFragment.this.requireActivity();
                            Intrinsics.checkNotNullExpressionValue(requireActivity2, "");
                            String string = BottomSheetImagePickerDialogFragment.this.getString(R.string.error_group_image_size_max_limit);
                            Intrinsics.checkNotNullExpressionValue(string, "");
                            String string2 = BottomSheetImagePickerDialogFragment.this.requireActivity().getString(R.string.toast_error_edit_icon);
                            Intrinsics.checkNotNullExpressionValue(string2, "");
                            DANAToast.MyBillsEntityDataFactory(requireActivity2, string, string2);
                        } else if (groupSendImagePickerUIState instanceof GroupSendImagePickerUIState.DanaLogoLoading) {
                            if (((GroupSendImagePickerUIState.DanaLogoLoading) groupSendImagePickerUIState).getMyBillsEntityDataFactory()) {
                                DanaLogoLoadingDialog authRequestContext = BottomSheetImagePickerDialogFragment.getAuthRequestContext(BottomSheetImagePickerDialogFragment.this);
                                if (!authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.isShowing()) {
                                    authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.show();
                                    authRequestContext.MyBillsEntityDataFactory.startRefresh();
                                }
                            } else {
                                BottomSheetImagePickerDialogFragment.getAuthRequestContext(BottomSheetImagePickerDialogFragment.this).PlaceComponentResult();
                                BottomSheetImagePickerDialogFragment.this.dismiss();
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

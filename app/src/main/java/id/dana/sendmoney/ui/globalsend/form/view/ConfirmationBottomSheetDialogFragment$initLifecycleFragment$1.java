package id.dana.sendmoney.ui.globalsend.form.view;

import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.view.Lifecycle;
import androidx.view.RepeatOnLifecycleKt;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.BottomSheetGlobalSendConfirmationBinding;
import id.dana.sendmoney.ui.globalsend.form.GlobalSendFormActivity;
import id.dana.sendmoney.ui.globalsend.form.model.SenderDetailModel;
import id.dana.sendmoney.ui.globalsend.form.view.ConfirmationBottomSheetDialogFragment;
import id.dana.sendmoney.ui.globalsend.form.viewmodel.ConfirmationBottomSheetDialogUiState;
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
@DebugMetadata(c = "id.dana.sendmoney.ui.globalsend.form.view.ConfirmationBottomSheetDialogFragment$initLifecycleFragment$1", f = "ConfirmationBottomSheetDialogFragment.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes9.dex */
final class ConfirmationBottomSheetDialogFragment$initLifecycleFragment$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ConfirmationBottomSheetDialogFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfirmationBottomSheetDialogFragment$initLifecycleFragment$1(ConfirmationBottomSheetDialogFragment confirmationBottomSheetDialogFragment, Continuation<? super ConfirmationBottomSheetDialogFragment$initLifecycleFragment$1> continuation) {
        super(2, continuation);
        this.this$0 = confirmationBottomSheetDialogFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConfirmationBottomSheetDialogFragment$initLifecycleFragment$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ConfirmationBottomSheetDialogFragment$initLifecycleFragment$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.sendmoney.ui.globalsend.form.view.ConfirmationBottomSheetDialogFragment$initLifecycleFragment$1$1", f = "ConfirmationBottomSheetDialogFragment.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.sendmoney.ui.globalsend.form.view.ConfirmationBottomSheetDialogFragment$initLifecycleFragment$1$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ConfirmationBottomSheetDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ConfirmationBottomSheetDialogFragment confirmationBottomSheetDialogFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = confirmationBottomSheetDialogFragment;
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
                StateFlow<ConfirmationBottomSheetDialogUiState> stateFlow = ConfirmationBottomSheetDialogFragment.getErrorConfigVersion(this.this$0).KClassImpl$Data$declaredNonStaticMembers$2;
                final ConfirmationBottomSheetDialogFragment confirmationBottomSheetDialogFragment = this.this$0;
                this.label = 1;
                if (stateFlow.collect(new FlowCollector() { // from class: id.dana.sendmoney.ui.globalsend.form.view.ConfirmationBottomSheetDialogFragment.initLifecycleFragment.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
                    public final Object emit(ConfirmationBottomSheetDialogUiState confirmationBottomSheetDialogUiState, Continuation<? super Unit> continuation) {
                        SenderDetailModel senderDetailModel;
                        SenderDetailModel senderDetailModel2;
                        ConfirmationBottomSheetDialogFragment.OnSuccessSaveSenderDetailListener onSuccessSaveSenderDetailListener;
                        ConfirmationBottomSheetDialogFragment.OnSuccessSaveSenderDetailListener onSuccessSaveSenderDetailListener2;
                        SenderDetailModel senderDetailModel3;
                        if (confirmationBottomSheetDialogUiState instanceof ConfirmationBottomSheetDialogUiState.OnSuccessSaveSenderDetail) {
                            onSuccessSaveSenderDetailListener = ConfirmationBottomSheetDialogFragment.this.getAuthRequestContext;
                            if (onSuccessSaveSenderDetailListener != null) {
                                onSuccessSaveSenderDetailListener2 = ConfirmationBottomSheetDialogFragment.this.getAuthRequestContext;
                                if (onSuccessSaveSenderDetailListener2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("");
                                }
                                senderDetailModel3 = ConfirmationBottomSheetDialogFragment.this.MyBillsEntityDataFactory;
                                if (senderDetailModel3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("");
                                }
                            }
                            ConfirmationBottomSheetDialogFragment.this.dismissAllowingStateLoss();
                        } else if (confirmationBottomSheetDialogUiState instanceof ConfirmationBottomSheetDialogUiState.OnSuccessGetUserInfo) {
                            ConfirmationBottomSheetDialogFragment.this.MyBillsEntityDataFactory = ((ConfirmationBottomSheetDialogUiState.OnSuccessGetUserInfo) confirmationBottomSheetDialogUiState).KClassImpl$Data$declaredNonStaticMembers$2;
                            VB vb = ConfirmationBottomSheetDialogFragment.this.MyBillsEntityDataFactory;
                            if (vb != 0) {
                                TextView textView = ((BottomSheetGlobalSendConfirmationBinding) vb).GetContactSyncConfig;
                                senderDetailModel = ConfirmationBottomSheetDialogFragment.this.MyBillsEntityDataFactory;
                                SenderDetailModel senderDetailModel4 = null;
                                if (senderDetailModel == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("");
                                    senderDetailModel = null;
                                }
                                textView.setText(senderDetailModel.getAuthRequestContext);
                                VB vb2 = ConfirmationBottomSheetDialogFragment.this.MyBillsEntityDataFactory;
                                if (vb2 != 0) {
                                    TextView textView2 = ((BottomSheetGlobalSendConfirmationBinding) vb2).NetworkUserEntityData$$ExternalSyntheticLambda1;
                                    senderDetailModel2 = ConfirmationBottomSheetDialogFragment.this.MyBillsEntityDataFactory;
                                    if (senderDetailModel2 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("");
                                    } else {
                                        senderDetailModel4 = senderDetailModel2;
                                    }
                                    textView2.setText(senderDetailModel4.MyBillsEntityDataFactory);
                                } else {
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                            } else {
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        } else if (confirmationBottomSheetDialogUiState instanceof ConfirmationBottomSheetDialogUiState.ShimmerLoading) {
                            ConfirmationBottomSheetShimmerExt confirmationBottomSheetShimmerExt = ConfirmationBottomSheetShimmerExt.INSTANCE;
                            boolean builtInFictitiousFunctionClassFactory = ((ConfirmationBottomSheetDialogUiState.ShimmerLoading) confirmationBottomSheetDialogUiState).getBuiltInFictitiousFunctionClassFactory();
                            VB vb3 = ConfirmationBottomSheetDialogFragment.this.MyBillsEntityDataFactory;
                            if (vb3 != 0) {
                                BottomSheetGlobalSendConfirmationBinding bottomSheetGlobalSendConfirmationBinding = (BottomSheetGlobalSendConfirmationBinding) vb3;
                                Intrinsics.checkNotNullParameter(bottomSheetGlobalSendConfirmationBinding, "");
                                if (builtInFictitiousFunctionClassFactory) {
                                    ConfirmationBottomSheetShimmerExt.PlaceComponentResult(bottomSheetGlobalSendConfirmationBinding);
                                } else {
                                    ConfirmationBottomSheetShimmerExt.PlaceComponentResult();
                                }
                            } else {
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        } else if (confirmationBottomSheetDialogUiState instanceof ConfirmationBottomSheetDialogUiState.OnErrorGetUserInfo) {
                            CustomToast customToast = CustomToast.MyBillsEntityDataFactory;
                            FragmentActivity activity = ConfirmationBottomSheetDialogFragment.this.getActivity();
                            if (activity == null) {
                                throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney.ui.globalsend.form.GlobalSendFormActivity");
                            }
                            int i2 = R.drawable.NetworkUserEntityData$$ExternalSyntheticLambda8;
                            int i3 = R.drawable.moveToNextValue;
                            String string = ConfirmationBottomSheetDialogFragment.this.getString(((ConfirmationBottomSheetDialogUiState.OnErrorGetUserInfo) confirmationBottomSheetDialogUiState).getAuthRequestContext);
                            Intrinsics.checkNotNullExpressionValue(string, "");
                            CustomToast.MyBillsEntityDataFactory((GlobalSendFormActivity) activity, i2, i3, string);
                            ConfirmationBottomSheetDialogFragment.this.dismissAllowingStateLoss();
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

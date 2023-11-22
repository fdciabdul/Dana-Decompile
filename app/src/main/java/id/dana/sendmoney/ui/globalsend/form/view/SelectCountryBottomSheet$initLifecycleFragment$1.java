package id.dana.sendmoney.ui.globalsend.form.view;

import androidx.fragment.app.FragmentActivity;
import androidx.view.Lifecycle;
import androidx.view.RepeatOnLifecycleKt;
import id.dana.core.ui.util.DANAToast;
import id.dana.sendmoney.R;
import id.dana.sendmoney.ui.globalsend.form.adapter.SelectCountryAdapter;
import id.dana.sendmoney.ui.globalsend.form.viewmodel.SelectCountryDestinationUiState;
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
@DebugMetadata(c = "id.dana.sendmoney.ui.globalsend.form.view.SelectCountryBottomSheet$initLifecycleFragment$1", f = "SelectCountryBottomSheet.kt", i = {}, l = {120}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class SelectCountryBottomSheet$initLifecycleFragment$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SelectCountryBottomSheet this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectCountryBottomSheet$initLifecycleFragment$1(SelectCountryBottomSheet selectCountryBottomSheet, Continuation<? super SelectCountryBottomSheet$initLifecycleFragment$1> continuation) {
        super(2, continuation);
        this.this$0 = selectCountryBottomSheet;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SelectCountryBottomSheet$initLifecycleFragment$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SelectCountryBottomSheet$initLifecycleFragment$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.sendmoney.ui.globalsend.form.view.SelectCountryBottomSheet$initLifecycleFragment$1$1", f = "SelectCountryBottomSheet.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.sendmoney.ui.globalsend.form.view.SelectCountryBottomSheet$initLifecycleFragment$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SelectCountryBottomSheet this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SelectCountryBottomSheet selectCountryBottomSheet, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = selectCountryBottomSheet;
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
                StateFlow<SelectCountryDestinationUiState> stateFlow = SelectCountryBottomSheet.NetworkUserEntityData$$ExternalSyntheticLambda0(this.this$0).BuiltInFictitiousFunctionClassFactory;
                final SelectCountryBottomSheet selectCountryBottomSheet = this.this$0;
                this.label = 1;
                if (stateFlow.collect(new FlowCollector() { // from class: id.dana.sendmoney.ui.globalsend.form.view.SelectCountryBottomSheet.initLifecycleFragment.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
                    public final Object emit(SelectCountryDestinationUiState selectCountryDestinationUiState, Continuation<? super Unit> continuation) {
                        Function1 function1;
                        SelectCountryAdapter selectCountryAdapter;
                        if (selectCountryDestinationUiState instanceof SelectCountryDestinationUiState.Error) {
                            DANAToast dANAToast = DANAToast.BuiltInFictitiousFunctionClassFactory;
                            FragmentActivity requireActivity = SelectCountryBottomSheet.this.requireActivity();
                            Intrinsics.checkNotNullExpressionValue(requireActivity, "");
                            String string = SelectCountryBottomSheet.this.getString(R.string.res_0x7f13087d_daggeruserbankcardcomponent_userbankcardcomponentimpl_postexecutionthreadprovider);
                            Intrinsics.checkNotNullExpressionValue(string, "");
                            DANAToast.MyBillsEntityDataFactory(requireActivity, string, "");
                            SelectCountryBottomSheet.this.dismiss();
                        } else if (selectCountryDestinationUiState instanceof SelectCountryDestinationUiState.ShimmerLoading) {
                            SelectCountryBottomSheet.MyBillsEntityDataFactory(SelectCountryBottomSheet.this, ((SelectCountryDestinationUiState.ShimmerLoading) selectCountryDestinationUiState).getBuiltInFictitiousFunctionClassFactory());
                        } else if (selectCountryDestinationUiState instanceof SelectCountryDestinationUiState.OnSuccessGetCountryList) {
                            SelectCountryDestinationUiState.OnSuccessGetCountryList onSuccessGetCountryList = (SelectCountryDestinationUiState.OnSuccessGetCountryList) selectCountryDestinationUiState;
                            SelectCountryBottomSheet.this.MyBillsEntityDataFactory = onSuccessGetCountryList.getAuthRequestContext;
                            function1 = SelectCountryBottomSheet.this.BuiltInFictitiousFunctionClassFactory;
                            function1.invoke(onSuccessGetCountryList.getAuthRequestContext);
                            selectCountryAdapter = SelectCountryBottomSheet.this.KClassImpl$Data$declaredNonStaticMembers$2;
                            if (selectCountryAdapter == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                                selectCountryAdapter = null;
                            }
                            selectCountryAdapter.MyBillsEntityDataFactory(onSuccessGetCountryList.getAuthRequestContext);
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

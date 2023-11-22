package id.dana.sendmoney.ui.globalsend.form.fragment;

import android.content.Context;
import androidx.view.Lifecycle;
import androidx.view.RepeatOnLifecycleKt;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.sendmoney.ui.globalsend.form.model.CurrencyRateModel;
import id.dana.sendmoney.ui.globalsend.form.model.SubTransferMethodInfoModel;
import id.dana.sendmoney.ui.globalsend.form.viewmodel.AmountFormUiState;
import id.dana.sendmoney.util.CashierUtilKt;
import id.dana.sendmoney.util.GlobalSendErrorHelper;
import java.util.Collection;
import java.util.Iterator;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment$initLifecycleFragment$1", f = "AmountFormFragment.kt", i = {}, l = {197}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class AmountFormFragment$initLifecycleFragment$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AmountFormFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmountFormFragment$initLifecycleFragment$1(AmountFormFragment amountFormFragment, Continuation<? super AmountFormFragment$initLifecycleFragment$1> continuation) {
        super(2, continuation);
        this.this$0 = amountFormFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AmountFormFragment$initLifecycleFragment$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AmountFormFragment$initLifecycleFragment$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment$initLifecycleFragment$1$1", f = "AmountFormFragment.kt", i = {}, l = {198}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment$initLifecycleFragment$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AmountFormFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AmountFormFragment amountFormFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = amountFormFragment;
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
                StateFlow<AmountFormUiState> stateFlow = AmountFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(this.this$0).MyBillsEntityDataFactory;
                final AmountFormFragment amountFormFragment = this.this$0;
                this.label = 1;
                if (stateFlow.collect(new FlowCollector() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment.initLifecycleFragment.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
                    public final Object emit(AmountFormUiState amountFormUiState, Continuation<? super Unit> continuation) {
                        CurrencyRateModel currencyRateModel;
                        if (amountFormUiState instanceof AmountFormUiState.ShimmerLoading) {
                            if (((AmountFormUiState.ShimmerLoading) amountFormUiState).getPlaceComponentResult()) {
                                AmountFormFragment.newProxyInstance(AmountFormFragment.this);
                            } else {
                                AmountFormFragment.moveToNextValue(AmountFormFragment.this);
                            }
                        } else {
                            if (amountFormUiState instanceof AmountFormUiState.OnErrorFetchInit) {
                                AmountFormFragment.moveToNextValue(AmountFormFragment.this);
                                AmountFormFragment.this.getAuthRequestContext(true);
                                AmountFormFragment.DatabaseTableConfigUtil(AmountFormFragment.this);
                            } else if (amountFormUiState instanceof AmountFormUiState.OnErrorCode) {
                                AmountFormUiState.OnErrorCode onErrorCode = (AmountFormUiState.OnErrorCode) amountFormUiState;
                                AmountFormFragment.MyBillsEntityDataFactory(AmountFormFragment.this, onErrorCode.BuiltInFictitiousFunctionClassFactory, onErrorCode.KClassImpl$Data$declaredNonStaticMembers$2);
                            } else if (amountFormUiState instanceof AmountFormUiState.OnSuccessInitGlobalTransfer) {
                                AmountFormUiState.OnSuccessInitGlobalTransfer onSuccessInitGlobalTransfer = (AmountFormUiState.OnSuccessInitGlobalTransfer) amountFormUiState;
                                if (!onSuccessInitGlobalTransfer.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0.isEmpty()) {
                                    List<SubTransferMethodInfoModel> list = onSuccessInitGlobalTransfer.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0;
                                    if (!(list instanceof Collection) || !list.isEmpty()) {
                                        Iterator<T> it = list.iterator();
                                        while (it.hasNext()) {
                                            if (((SubTransferMethodInfoModel) it.next()).getBuiltInFictitiousFunctionClassFactory()) {
                                                break;
                                            }
                                        }
                                    }
                                    r0 = false;
                                    if (!r0) {
                                        AmountFormFragment.this.GetContactSyncConfig = onSuccessInitGlobalTransfer.getAuthRequestContext;
                                        AmountFormFragment.this.BuiltInFictitiousFunctionClassFactory();
                                    }
                                }
                                GlobalSendErrorHelper globalSendErrorHelper = GlobalSendErrorHelper.getAuthRequestContext;
                                Context requireContext = AmountFormFragment.this.requireContext();
                                Intrinsics.checkNotNullExpressionValue(requireContext, "");
                                final AmountFormFragment amountFormFragment2 = AmountFormFragment.this;
                                GlobalSendErrorHelper.getAuthRequestContext(requireContext, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment.initLifecycleFragment.1.1.1.2
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
                                        new AmountFormFragment$onBackPressedCallback$1(AmountFormFragment.this).handleOnBackPressed();
                                    }
                                });
                            } else if (amountFormUiState instanceof AmountFormUiState.OnSuccessTransferSubmit) {
                                AmountFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda8(AmountFormFragment.this);
                                AmountFormUiState.OnSuccessTransferSubmit onSuccessTransferSubmit = (AmountFormUiState.OnSuccessTransferSubmit) amountFormUiState;
                                if (onSuccessTransferSubmit.MyBillsEntityDataFactory.length() > 0) {
                                    Context requireContext2 = AmountFormFragment.this.requireContext();
                                    Intrinsics.checkNotNullExpressionValue(requireContext2, "");
                                    String str = onSuccessTransferSubmit.MyBillsEntityDataFactory;
                                    currencyRateModel = AmountFormFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                                    if (currencyRateModel == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("");
                                        currencyRateModel = null;
                                    }
                                    CashierUtilKt.getAuthRequestContext(requireContext2, str, TrackerKey.SourceType.TRANSFER_OVERSEAS, currencyRateModel, 4);
                                }
                            } else if (amountFormUiState instanceof AmountFormUiState.OnErrorTransferSubmit) {
                                GlobalSendErrorHelper globalSendErrorHelper2 = GlobalSendErrorHelper.getAuthRequestContext;
                                Context requireContext3 = AmountFormFragment.this.requireContext();
                                Intrinsics.checkNotNullExpressionValue(requireContext3, "");
                                GlobalSendErrorHelper.PlaceComponentResult(requireContext3);
                            } else if (amountFormUiState instanceof AmountFormUiState.DanaLoading) {
                                AmountFormFragment.PlaceComponentResult(AmountFormFragment.this, ((AmountFormUiState.DanaLoading) amountFormUiState).getMyBillsEntityDataFactory());
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

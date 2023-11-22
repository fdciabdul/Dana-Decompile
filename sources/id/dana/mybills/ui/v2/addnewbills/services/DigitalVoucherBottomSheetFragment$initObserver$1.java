package id.dana.mybills.ui.v2.addnewbills.services;

import android.content.Context;
import androidx.view.fragment.FragmentKt;
import id.dana.mybills.R;
import id.dana.mybills.databinding.FragmentDigitalVoucherBottomSheetBinding;
import id.dana.mybills.ui.constant.MyBillsPurposeAction;
import id.dana.mybills.ui.customview.BodySaveToBillsView;
import id.dana.mybills.ui.model.HighlightTransactionPayRequestModel;
import id.dana.mybills.ui.model.MoneyViewModel;
import id.dana.mybills.ui.v2.addnewbills.AddNewBillsUiState;
import id.dana.mybills.ui.v2.addnewbills.services.DigitalVoucherBottomSheetFragmentDirections;
import id.dana.mybills.utils.MyBillsCashierExtKt;
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
import kotlin.ranges.IntRange;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "state", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.mybills.ui.v2.addnewbills.services.DigitalVoucherBottomSheetFragment$initObserver$1", f = "DigitalVoucherBottomSheetFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes9.dex */
final class DigitalVoucherBottomSheetFragment$initObserver$1 extends SuspendLambda implements Function2<AddNewBillsUiState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DigitalVoucherBottomSheetFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DigitalVoucherBottomSheetFragment$initObserver$1(DigitalVoucherBottomSheetFragment digitalVoucherBottomSheetFragment, Continuation<? super DigitalVoucherBottomSheetFragment$initObserver$1> continuation) {
        super(2, continuation);
        this.this$0 = digitalVoucherBottomSheetFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DigitalVoucherBottomSheetFragment$initObserver$1 digitalVoucherBottomSheetFragment$initObserver$1 = new DigitalVoucherBottomSheetFragment$initObserver$1(this.this$0, continuation);
        digitalVoucherBottomSheetFragment$initObserver$1.L$0 = obj;
        return digitalVoucherBottomSheetFragment$initObserver$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AddNewBillsUiState addNewBillsUiState, Continuation<? super Unit> continuation) {
        return ((DigitalVoucherBottomSheetFragment$initObserver$1) create(addNewBillsUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        boolean z2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            AddNewBillsUiState addNewBillsUiState = (AddNewBillsUiState) this.L$0;
            if (addNewBillsUiState instanceof AddNewBillsUiState.None) {
                DigitalVoucherBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(this.this$0);
            } else if (!(addNewBillsUiState instanceof AddNewBillsUiState.OnSuccessGetCurrentBalance)) {
                if (addNewBillsUiState instanceof AddNewBillsUiState.OnBillHasActiveBills) {
                    HighlightTransactionPayRequestModel KClassImpl$Data$declaredNonStaticMembers$2 = DigitalVoucherBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(this.this$0);
                    AddNewBillsUiState.OnBillHasActiveBills onBillHasActiveBills = (AddNewBillsUiState.OnBillHasActiveBills) addNewBillsUiState;
                    String str = onBillHasActiveBills.BuiltInFictitiousFunctionClassFactory;
                    KClassImpl$Data$declaredNonStaticMembers$2.setSubscriptionId(str != null ? str : "");
                    VB vb = this.this$0.MyBillsEntityDataFactory;
                    if (vb != 0) {
                        ((FragmentDigitalVoucherBottomSheetBinding) vb).PlaceComponentResult.setErrorMessage(onBillHasActiveBills.getKClassImpl$Data$declaredNonStaticMembers$2(), this.this$0.getString(R.string.my_bills_error_already_added_in_mybills));
                        this.this$0.KClassImpl$Data$declaredNonStaticMembers$2 = onBillHasActiveBills.getKClassImpl$Data$declaredNonStaticMembers$2();
                        VB vb2 = this.this$0.MyBillsEntityDataFactory;
                        if (vb2 != 0) {
                            BodySaveToBillsView bodySaveToBillsView = ((FragmentDigitalVoucherBottomSheetBinding) vb2).lookAheadTest;
                            DigitalVoucherBottomSheetFragment digitalVoucherBottomSheetFragment = this.this$0;
                            z = digitalVoucherBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2;
                            bodySaveToBillsView.setIsSaveToMyBillsActive(!z);
                            z2 = digitalVoucherBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2;
                            bodySaveToBillsView.setSwitchAddToMyBillsChecked(!z2);
                            DigitalVoucherBottomSheetFragment.MyBillsEntityDataFactory(this.this$0);
                            DigitalVoucherBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(this.this$0, onBillHasActiveBills.getKClassImpl$Data$declaredNonStaticMembers$2());
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                } else if (addNewBillsUiState instanceof AddNewBillsUiState.OnSuccessSaveMyBills) {
                    AddNewBillsUiState.OnSuccessSaveMyBills onSuccessSaveMyBills = (AddNewBillsUiState.OnSuccessSaveMyBills) addNewBillsUiState;
                    DigitalVoucherBottomSheetFragment.MyBillsEntityDataFactory(this.this$0, onSuccessSaveMyBills);
                    if (onSuccessSaveMyBills.getKClassImpl$Data$declaredNonStaticMembers$2()) {
                        this.this$0.MyBillsEntityDataFactory(MyBillsPurposeAction.SAVE_BILL_AND_PAY);
                        DigitalVoucherBottomSheetFragment.MyBillsEntityDataFactory(this.this$0, onSuccessSaveMyBills.MyBillsEntityDataFactory);
                    } else {
                        this.this$0.MyBillsEntityDataFactory(MyBillsPurposeAction.SAVE);
                        DigitalVoucherBottomSheetFragment digitalVoucherBottomSheetFragment2 = this.this$0;
                        String recurringType = onSuccessSaveMyBills.MyBillsEntityDataFactory.getRecurringType();
                        DigitalVoucherBottomSheetFragmentDirections.Companion companion = DigitalVoucherBottomSheetFragmentDirections.INSTANCE;
                        digitalVoucherBottomSheetFragment2.getAuthRequestContext(recurringType, DigitalVoucherBottomSheetFragmentDirections.Companion.KClassImpl$Data$declaredNonStaticMembers$2());
                        FragmentKt.getAuthRequestContext(this.this$0).KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                } else if (addNewBillsUiState instanceof AddNewBillsUiState.OnSuccessGetPayTransaction) {
                    String checkoutUrl = ((AddNewBillsUiState.OnSuccessGetPayTransaction) addNewBillsUiState).MyBillsEntityDataFactory.getCheckoutUrl();
                    if (checkoutUrl != null) {
                        Context requireContext = this.this$0.requireContext();
                        Intrinsics.checkNotNullExpressionValue(requireContext, "");
                        MyBillsCashierExtKt.KClassImpl$Data$declaredNonStaticMembers$2(requireContext, checkoutUrl);
                    }
                    FragmentKt.getAuthRequestContext(this.this$0).KClassImpl$Data$declaredNonStaticMembers$2();
                } else if (addNewBillsUiState instanceof AddNewBillsUiState.OnErrorGetPayTransaction) {
                    this.this$0.BuiltInFictitiousFunctionClassFactory(((AddNewBillsUiState.OnErrorGetPayTransaction) addNewBillsUiState).BuiltInFictitiousFunctionClassFactory);
                } else if (!(addNewBillsUiState instanceof AddNewBillsUiState.OnErrorSaveMyBills)) {
                    if (addNewBillsUiState instanceof AddNewBillsUiState.Loading) {
                        DigitalVoucherBottomSheetFragment.moveToNextValue(this.this$0);
                    } else if (addNewBillsUiState instanceof AddNewBillsUiState.OnSuccessGetMyBillsDateRange) {
                        VB vb3 = this.this$0.MyBillsEntityDataFactory;
                        if (vb3 != 0) {
                            BodySaveToBillsView bodySaveToBillsView2 = ((FragmentDigitalVoucherBottomSheetBinding) vb3).lookAheadTest;
                            final DigitalVoucherBottomSheetFragment digitalVoucherBottomSheetFragment3 = this.this$0;
                            bodySaveToBillsView2.setDatePickerRange(((AddNewBillsUiState.OnSuccessGetMyBillsDateRange) addNewBillsUiState).KClassImpl$Data$declaredNonStaticMembers$2);
                            bodySaveToBillsView2.setDatePickerRangeListener(new Function1<IntRange, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.DigitalVoucherBottomSheetFragment$initObserver$1$6$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final /* bridge */ /* synthetic */ Unit invoke(IntRange intRange) {
                                    invoke2(intRange);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(IntRange intRange) {
                                    Intrinsics.checkNotNullParameter(intRange, "");
                                    DigitalVoucherBottomSheetFragment digitalVoucherBottomSheetFragment4 = DigitalVoucherBottomSheetFragment.this;
                                    String string = digitalVoucherBottomSheetFragment4.getString(R.string.res_0x7f130f2f_networkuserentitydata_externalsyntheticlambda4, String.valueOf(intRange.getFirst()), String.valueOf(intRange.getLast()));
                                    Intrinsics.checkNotNullExpressionValue(string, "");
                                    digitalVoucherBottomSheetFragment4.BuiltInFictitiousFunctionClassFactory(string);
                                }
                            });
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    }
                } else {
                    String str2 = ((AddNewBillsUiState.OnErrorSaveMyBills) addNewBillsUiState).BuiltInFictitiousFunctionClassFactory;
                    DigitalVoucherBottomSheetFragment digitalVoucherBottomSheetFragment4 = this.this$0;
                    if (str2.length() == 0) {
                        Context context = digitalVoucherBottomSheetFragment4.getContext();
                        str2 = context != null ? context.getString(R.string.mybills_failed_pay_transaction) : null;
                    }
                    String str3 = str2;
                    if (str3 != null) {
                        this.this$0.BuiltInFictitiousFunctionClassFactory(str3);
                    }
                }
            } else {
                VB vb4 = this.this$0.MyBillsEntityDataFactory;
                if (vb4 != 0) {
                    ((FragmentDigitalVoucherBottomSheetBinding) vb4).moveToNextValue.PlaceComponentResult.setBalance(MoneyViewModel.INSTANCE.fromCurrencyAmountModel(((AddNewBillsUiState.OnSuccessGetCurrentBalance) addNewBillsUiState).getAuthRequestContext));
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

package id.dana.mybills.ui.v2.addnewbills.services;

import android.content.Context;
import androidx.view.fragment.FragmentKt;
import id.dana.mybills.R;
import id.dana.mybills.databinding.FragmentMobileRechargeBottomSheetBinding;
import id.dana.mybills.databinding.ViewBodyMobileRechargeBillsBinding;
import id.dana.mybills.ui.constant.MyBillsPurposeAction;
import id.dana.mybills.ui.customview.BodySaveToBillsView;
import id.dana.mybills.ui.customview.CustomDropdownView;
import id.dana.mybills.ui.v2.addnewbills.AddNewBillsUiState;
import id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragmentDirections;
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
@DebugMetadata(c = "id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$initLifecycleActivity$1", f = "MobileRechargeBottomSheetFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes9.dex */
final class MobileRechargeBottomSheetFragment$initLifecycleActivity$1 extends SuspendLambda implements Function2<AddNewBillsUiState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MobileRechargeBottomSheetFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileRechargeBottomSheetFragment$initLifecycleActivity$1(MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment, Continuation<? super MobileRechargeBottomSheetFragment$initLifecycleActivity$1> continuation) {
        super(2, continuation);
        this.this$0 = mobileRechargeBottomSheetFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MobileRechargeBottomSheetFragment$initLifecycleActivity$1 mobileRechargeBottomSheetFragment$initLifecycleActivity$1 = new MobileRechargeBottomSheetFragment$initLifecycleActivity$1(this.this$0, continuation);
        mobileRechargeBottomSheetFragment$initLifecycleActivity$1.L$0 = obj;
        return mobileRechargeBottomSheetFragment$initLifecycleActivity$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AddNewBillsUiState addNewBillsUiState, Continuation<? super Unit> continuation) {
        return ((MobileRechargeBottomSheetFragment$initLifecycleActivity$1) create(addNewBillsUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            AddNewBillsUiState addNewBillsUiState = (AddNewBillsUiState) this.L$0;
            if (addNewBillsUiState instanceof AddNewBillsUiState.None) {
                MobileRechargeBottomSheetFragment.getErrorConfigVersion(this.this$0);
                VB vb = this.this$0.MyBillsEntityDataFactory;
                if (vb != 0) {
                    ViewBodyMobileRechargeBillsBinding viewBodyMobileRechargeBillsBinding = ((FragmentMobileRechargeBottomSheetBinding) vb).moveToNextValue;
                    viewBodyMobileRechargeBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.setLoadingVisibility(false);
                    viewBodyMobileRechargeBillsBinding.getAuthRequestContext.setLoadingVisibility(false);
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else if (addNewBillsUiState instanceof AddNewBillsUiState.OnSuccessSaveMyBills) {
                AddNewBillsUiState.OnSuccessSaveMyBills onSuccessSaveMyBills = (AddNewBillsUiState.OnSuccessSaveMyBills) addNewBillsUiState;
                MobileRechargeBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(this.this$0, onSuccessSaveMyBills.MyBillsEntityDataFactory.getRecurringType());
                if (onSuccessSaveMyBills.getKClassImpl$Data$declaredNonStaticMembers$2()) {
                    this.this$0.PlaceComponentResult(MyBillsPurposeAction.SAVE_BILL_AND_PAY);
                    MobileRechargeBottomSheetFragment.PlaceComponentResult(this.this$0, onSuccessSaveMyBills.MyBillsEntityDataFactory);
                } else {
                    this.this$0.PlaceComponentResult(MyBillsPurposeAction.SAVE_BILL);
                    MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment = this.this$0;
                    String recurringType = onSuccessSaveMyBills.MyBillsEntityDataFactory.getRecurringType();
                    MobileRechargeBottomSheetFragmentDirections.Companion companion = MobileRechargeBottomSheetFragmentDirections.INSTANCE;
                    mobileRechargeBottomSheetFragment.getAuthRequestContext(recurringType, MobileRechargeBottomSheetFragmentDirections.Companion.getAuthRequestContext());
                    FragmentKt.getAuthRequestContext(this.this$0).KClassImpl$Data$declaredNonStaticMembers$2();
                }
            } else if (addNewBillsUiState instanceof AddNewBillsUiState.OnBillHasActiveBills) {
                AddNewBillsUiState.OnBillHasActiveBills onBillHasActiveBills = (AddNewBillsUiState.OnBillHasActiveBills) addNewBillsUiState;
                String str = onBillHasActiveBills.BuiltInFictitiousFunctionClassFactory;
                if (str != null) {
                    MobileRechargeBottomSheetFragment.BuiltInFictitiousFunctionClassFactory(this.this$0).setSubscriptionId(str);
                }
                VB vb2 = this.this$0.MyBillsEntityDataFactory;
                if (vb2 != 0) {
                    ((FragmentMobileRechargeBottomSheetBinding) vb2).moveToNextValue.BuiltInFictitiousFunctionClassFactory.setErrorMessage(onBillHasActiveBills.getKClassImpl$Data$declaredNonStaticMembers$2(), this.this$0.getString(R.string.res_0x7f130f43_verifypinstatemanager_executeriskchallenge_2_1));
                    MobileRechargeBottomSheetFragment.getAuthRequestContext(this.this$0, onBillHasActiveBills.getKClassImpl$Data$declaredNonStaticMembers$2());
                    MobileRechargeBottomSheetFragment.PlaceComponentResult(this.this$0, onBillHasActiveBills.getKClassImpl$Data$declaredNonStaticMembers$2());
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else if (addNewBillsUiState instanceof AddNewBillsUiState.OnSuccessGetPayTransaction) {
                String checkoutUrl = ((AddNewBillsUiState.OnSuccessGetPayTransaction) addNewBillsUiState).MyBillsEntityDataFactory.getCheckoutUrl();
                if (checkoutUrl != null) {
                    Context requireContext = this.this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "");
                    MyBillsCashierExtKt.KClassImpl$Data$declaredNonStaticMembers$2(requireContext, checkoutUrl);
                }
                FragmentKt.getAuthRequestContext(this.this$0).KClassImpl$Data$declaredNonStaticMembers$2();
            } else if (addNewBillsUiState instanceof AddNewBillsUiState.OnSuccessGetMobileRechargeProduct) {
                AddNewBillsUiState.OnSuccessGetMobileRechargeProduct onSuccessGetMobileRechargeProduct = (AddNewBillsUiState.OnSuccessGetMobileRechargeProduct) addNewBillsUiState;
                if (onSuccessGetMobileRechargeProduct.BuiltInFictitiousFunctionClassFactory.getPackages() != null && (!r0.isEmpty()) == true) {
                    r2 = true;
                }
                if (r2) {
                    MobileRechargeBottomSheetFragment.PlaceComponentResult(this.this$0, onSuccessGetMobileRechargeProduct.BuiltInFictitiousFunctionClassFactory);
                }
            } else {
                if (!(addNewBillsUiState instanceof AddNewBillsUiState.OnErrorSaveMyBills)) {
                    if (addNewBillsUiState instanceof AddNewBillsUiState.OnSuccessGetCurrentBalance) {
                        MobileRechargeBottomSheetFragment.MyBillsEntityDataFactory(this.this$0, ((AddNewBillsUiState.OnSuccessGetCurrentBalance) addNewBillsUiState).getAuthRequestContext);
                    } else if (!(addNewBillsUiState instanceof AddNewBillsUiState.OnLoadingGetProduct)) {
                        if (!(addNewBillsUiState instanceof AddNewBillsUiState.OnErrorGetProduct)) {
                            if (addNewBillsUiState instanceof AddNewBillsUiState.OnErrorGetPayTransaction) {
                                this.this$0.BuiltInFictitiousFunctionClassFactory(((AddNewBillsUiState.OnErrorGetPayTransaction) addNewBillsUiState).BuiltInFictitiousFunctionClassFactory);
                            } else if (addNewBillsUiState instanceof AddNewBillsUiState.Loading) {
                                MobileRechargeBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda2(this.this$0);
                            } else if (addNewBillsUiState instanceof AddNewBillsUiState.OnSuccessGetMyBillsDateRange) {
                                VB vb3 = this.this$0.MyBillsEntityDataFactory;
                                if (vb3 != 0) {
                                    BodySaveToBillsView bodySaveToBillsView = ((FragmentMobileRechargeBottomSheetBinding) vb3).KClassImpl$Data$declaredNonStaticMembers$2;
                                    final MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment2 = this.this$0;
                                    bodySaveToBillsView.setDatePickerRange(((AddNewBillsUiState.OnSuccessGetMyBillsDateRange) addNewBillsUiState).KClassImpl$Data$declaredNonStaticMembers$2);
                                    bodySaveToBillsView.setDatePickerRangeListener(new Function1<IntRange, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment$initLifecycleActivity$1$8$1
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
                                            MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment3 = MobileRechargeBottomSheetFragment.this;
                                            String string = mobileRechargeBottomSheetFragment3.getString(R.string.res_0x7f130f2f_networkuserentitydata_externalsyntheticlambda4, String.valueOf(intRange.getFirst()), String.valueOf(intRange.getLast()));
                                            Intrinsics.checkNotNullExpressionValue(string, "");
                                            mobileRechargeBottomSheetFragment3.BuiltInFictitiousFunctionClassFactory(string);
                                        }
                                    });
                                } else {
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                            }
                        } else {
                            VB vb4 = this.this$0.MyBillsEntityDataFactory;
                            if (vb4 != 0) {
                                ViewBodyMobileRechargeBillsBinding viewBodyMobileRechargeBillsBinding2 = ((FragmentMobileRechargeBottomSheetBinding) vb4).moveToNextValue;
                                MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment3 = this.this$0;
                                CustomDropdownView customDropdownView = viewBodyMobileRechargeBillsBinding2.KClassImpl$Data$declaredNonStaticMembers$2;
                                Context context = mobileRechargeBottomSheetFragment3.getContext();
                                customDropdownView.setErrorMessage(true, context != null ? context.getString(R.string.my_bills_error_failed_loading_product) : null);
                            } else {
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        }
                    } else {
                        VB vb5 = this.this$0.MyBillsEntityDataFactory;
                        if (vb5 != 0) {
                            ViewBodyMobileRechargeBillsBinding viewBodyMobileRechargeBillsBinding3 = ((FragmentMobileRechargeBottomSheetBinding) vb5).moveToNextValue;
                            CustomDropdownView customDropdownView2 = viewBodyMobileRechargeBillsBinding3.getAuthRequestContext;
                            Intrinsics.checkNotNullExpressionValue(customDropdownView2, "");
                            CustomDropdownView.setErrorMessage$default(customDropdownView2, false, null, 2, null);
                            viewBodyMobileRechargeBillsBinding3.getAuthRequestContext.setLoadingVisibility(true);
                            viewBodyMobileRechargeBillsBinding3.KClassImpl$Data$declaredNonStaticMembers$2.setLoadingVisibility(true);
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    }
                } else {
                    String str2 = ((AddNewBillsUiState.OnErrorSaveMyBills) addNewBillsUiState).BuiltInFictitiousFunctionClassFactory;
                    MobileRechargeBottomSheetFragment mobileRechargeBottomSheetFragment4 = this.this$0;
                    if (str2.length() == 0) {
                        Context context2 = mobileRechargeBottomSheetFragment4.getContext();
                        if (context2 != null) {
                            r5 = context2.getString(R.string.mybills_failed_pay_transaction);
                        }
                    } else {
                        r5 = str2;
                    }
                    String str3 = r5;
                    if (str3 != null) {
                        this.this$0.BuiltInFictitiousFunctionClassFactory(str3);
                    }
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

package id.dana.mybills.ui.v2.dashboard;

import id.dana.mybills.R;
import id.dana.mybills.databinding.FragmentSinglePayBillBottomSheetBinding;
import id.dana.mybills.ui.customview.BodySinglePayView;
import id.dana.mybills.ui.v2.addnewbills.AddNewBillsUiState;
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
@DebugMetadata(c = "id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment$observeAddNewBillsViewModel$1", f = "SinglePayBillBottomSheetFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes9.dex */
final class SinglePayBillBottomSheetFragment$observeAddNewBillsViewModel$1 extends SuspendLambda implements Function2<AddNewBillsUiState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SinglePayBillBottomSheetFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SinglePayBillBottomSheetFragment$observeAddNewBillsViewModel$1(SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment, Continuation<? super SinglePayBillBottomSheetFragment$observeAddNewBillsViewModel$1> continuation) {
        super(2, continuation);
        this.this$0 = singlePayBillBottomSheetFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SinglePayBillBottomSheetFragment$observeAddNewBillsViewModel$1 singlePayBillBottomSheetFragment$observeAddNewBillsViewModel$1 = new SinglePayBillBottomSheetFragment$observeAddNewBillsViewModel$1(this.this$0, continuation);
        singlePayBillBottomSheetFragment$observeAddNewBillsViewModel$1.L$0 = obj;
        return singlePayBillBottomSheetFragment$observeAddNewBillsViewModel$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AddNewBillsUiState addNewBillsUiState, Continuation<? super Unit> continuation) {
        return ((SinglePayBillBottomSheetFragment$observeAddNewBillsViewModel$1) create(addNewBillsUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            AddNewBillsUiState addNewBillsUiState = (AddNewBillsUiState) this.L$0;
            if (addNewBillsUiState instanceof AddNewBillsUiState.OnSuccessGetMobileRechargeProduct) {
                SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment = this.this$0;
                singlePayBillBottomSheetFragment.BuiltInFictitiousFunctionClassFactory = SinglePayBillBottomSheetFragment.getAuthRequestContext(singlePayBillBottomSheetFragment, ((AddNewBillsUiState.OnSuccessGetMobileRechargeProduct) addNewBillsUiState).BuiltInFictitiousFunctionClassFactory);
                SinglePayBillBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda2(this.this$0);
            } else if (addNewBillsUiState instanceof AddNewBillsUiState.OnSuccessGetMyBillsDateRange) {
                VB vb = this.this$0.MyBillsEntityDataFactory;
                if (vb != 0) {
                    BodySinglePayView bodySinglePayView = ((FragmentSinglePayBillBottomSheetBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda1;
                    final SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment2 = this.this$0;
                    bodySinglePayView.setDatePickerRange(((AddNewBillsUiState.OnSuccessGetMyBillsDateRange) addNewBillsUiState).KClassImpl$Data$declaredNonStaticMembers$2);
                    bodySinglePayView.setDatePickerRangeListener(new Function1<IntRange, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment$observeAddNewBillsViewModel$1$1$1
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
                            SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment3 = SinglePayBillBottomSheetFragment.this;
                            String string = singlePayBillBottomSheetFragment3.getString(R.string.res_0x7f130f2f_networkuserentitydata_externalsyntheticlambda4, String.valueOf(intRange.getFirst()), String.valueOf(intRange.getLast()));
                            Intrinsics.checkNotNullExpressionValue(string, "");
                            singlePayBillBottomSheetFragment3.BuiltInFictitiousFunctionClassFactory(string);
                        }
                    });
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

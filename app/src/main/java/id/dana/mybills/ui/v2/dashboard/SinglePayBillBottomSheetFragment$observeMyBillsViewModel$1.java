package id.dana.mybills.ui.v2.dashboard;

import android.content.Context;
import androidx.view.fragment.FragmentKt;
import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import id.dana.mybills.R;
import id.dana.mybills.domain.model.ProductGoodsInfo;
import id.dana.mybills.ui.model.DropdownOptionsModelKt;
import id.dana.mybills.ui.v2.MyBillsUiState;
import id.dana.mybills.utils.MyBillsCashierExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lid/dana/mybills/ui/v2/MyBillsUiState;", "state", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment$observeMyBillsViewModel$1", f = "SinglePayBillBottomSheetFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class SinglePayBillBottomSheetFragment$observeMyBillsViewModel$1 extends SuspendLambda implements Function2<MyBillsUiState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SinglePayBillBottomSheetFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SinglePayBillBottomSheetFragment$observeMyBillsViewModel$1(SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment, Continuation<? super SinglePayBillBottomSheetFragment$observeMyBillsViewModel$1> continuation) {
        super(2, continuation);
        this.this$0 = singlePayBillBottomSheetFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SinglePayBillBottomSheetFragment$observeMyBillsViewModel$1 singlePayBillBottomSheetFragment$observeMyBillsViewModel$1 = new SinglePayBillBottomSheetFragment$observeMyBillsViewModel$1(this.this$0, continuation);
        singlePayBillBottomSheetFragment$observeMyBillsViewModel$1.L$0 = obj;
        return singlePayBillBottomSheetFragment$observeMyBillsViewModel$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(MyBillsUiState myBillsUiState, Continuation<? super Unit> continuation) {
        return ((SinglePayBillBottomSheetFragment$observeMyBillsViewModel$1) create(myBillsUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            MyBillsUiState myBillsUiState = (MyBillsUiState) this.L$0;
            if (myBillsUiState instanceof MyBillsUiState.None) {
                SinglePayBillBottomSheetFragment.getErrorConfigVersion(this.this$0);
            } else if (myBillsUiState instanceof MyBillsUiState.OnSuccessGetPayTransaction) {
                String checkoutUrl = ((MyBillsUiState.OnSuccessGetPayTransaction) myBillsUiState).KClassImpl$Data$declaredNonStaticMembers$2.getCheckoutUrl();
                if (checkoutUrl != null) {
                    Context requireContext = this.this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "");
                    MyBillsCashierExtKt.KClassImpl$Data$declaredNonStaticMembers$2(requireContext, checkoutUrl);
                }
                FragmentKt.getAuthRequestContext(this.this$0).KClassImpl$Data$declaredNonStaticMembers$2();
            } else if (myBillsUiState instanceof MyBillsUiState.OnErrorGetPayTransaction) {
                SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment = this.this$0;
                String string = singlePayBillBottomSheetFragment.getString(R.string.mybills_failed_pay_transaction);
                Intrinsics.checkNotNullExpressionValue(string, "");
                singlePayBillBottomSheetFragment.BuiltInFictitiousFunctionClassFactory(string);
            } else if (myBillsUiState instanceof MyBillsUiState.OnSuccessGetGeneralProduct) {
                SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment2 = this.this$0;
                List<ProductGoodsInfo> list = ((MyBillsUiState.OnSuccessGetGeneralProduct) myBillsUiState).KClassImpl$Data$declaredNonStaticMembers$2;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(DropdownOptionsModelKt.toDropdownOptionsModel((ProductGoodsInfo) it.next()));
                }
                singlePayBillBottomSheetFragment2.BuiltInFictitiousFunctionClassFactory = arrayList;
                SinglePayBillBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda2(this.this$0);
            } else if (myBillsUiState instanceof MyBillsUiState.OnSuccessDeleteSubscriptionBill) {
                SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment3 = this.this$0;
                String string2 = singlePayBillBottomSheetFragment3.getString(R.string.my_bills_success_delete);
                Intrinsics.checkNotNullExpressionValue(string2, "");
                SinglePayBillBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(singlePayBillBottomSheetFragment3, string2);
                SinglePayBillBottomSheetFragment.PlaceComponentResult(this.this$0, RecordError.ERROR_INITIALIZE_NO_WORKSPACE_ID);
            } else if (myBillsUiState instanceof MyBillsUiState.OnSuccessUpdateSubscriptionBill) {
                SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment4 = this.this$0;
                String string3 = singlePayBillBottomSheetFragment4.getString(R.string.my_bills_success_update);
                Intrinsics.checkNotNullExpressionValue(string3, "");
                SinglePayBillBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(singlePayBillBottomSheetFragment4, string3);
                SinglePayBillBottomSheetFragment.PlaceComponentResult(this.this$0, RecordError.ERROR_INITIALIZE_NO_WORKSPACE_ID);
            } else if (myBillsUiState instanceof MyBillsUiState.Loading) {
                SinglePayBillBottomSheetFragment.initRecordTimeStamp(this.this$0);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

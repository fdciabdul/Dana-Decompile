package id.dana.mybills.ui.v2.managebills;

import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter;
import id.dana.core.ui.util.DANAToast;
import id.dana.mybills.R;
import id.dana.mybills.databinding.FragmentManageBillsBinding;
import id.dana.mybills.ui.model.BillPaymentAdapterModelKt;
import id.dana.mybills.ui.model.BillSubscriptionHighlightModel;
import id.dana.mybills.ui.model.generalize.BillPaginationModel;
import id.dana.mybills.ui.v2.MyBillsUiState;
import id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lid/dana/mybills/ui/v2/MyBillsUiState;", "state", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.mybills.ui.v2.managebills.ManageBillsFragment$initLifecycle$1", f = "ManageBillsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes9.dex */
final class ManageBillsFragment$initLifecycle$1 extends SuspendLambda implements Function2<MyBillsUiState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ManageBillsFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageBillsFragment$initLifecycle$1(ManageBillsFragment manageBillsFragment, Continuation<? super ManageBillsFragment$initLifecycle$1> continuation) {
        super(2, continuation);
        this.this$0 = manageBillsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ManageBillsFragment$initLifecycle$1 manageBillsFragment$initLifecycle$1 = new ManageBillsFragment$initLifecycle$1(this.this$0, continuation);
        manageBillsFragment$initLifecycle$1.L$0 = obj;
        return manageBillsFragment$initLifecycle$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(MyBillsUiState myBillsUiState, Continuation<? super Unit> continuation) {
        return ((ManageBillsFragment$initLifecycle$1) create(myBillsUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BillPaginationModel billPaginationModel;
        BillPaginationModel billPaginationModel2;
        BillPaginationModel billPaginationModel3;
        BillPaginationModel billPaginationModel4;
        BillPaginationModel billPaginationModel5;
        BillPaginationModel billPaginationModel6;
        boolean z;
        BillPaginationModel billPaginationModel7;
        BillPaginationModel billPaginationModel8;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            MyBillsUiState myBillsUiState = (MyBillsUiState) this.L$0;
            if (myBillsUiState instanceof MyBillsUiState.OnSuccessGetInquirySubscriptionPaylaterWithDestination) {
                MyBillsUiState.OnSuccessGetInquirySubscriptionPaylaterWithDestination onSuccessGetInquirySubscriptionPaylaterWithDestination = (MyBillsUiState.OnSuccessGetInquirySubscriptionPaylaterWithDestination) myBillsUiState;
                List<BillSubscriptionHighlightModel> list = onSuccessGetInquirySubscriptionPaylaterWithDestination.MyBillsEntityDataFactory;
                ManageBillsFragment manageBillsFragment = this.this$0;
                billPaginationModel4 = manageBillsFragment.getAuthRequestContext;
                billPaginationModel4.setHasMore(onSuccessGetInquirySubscriptionPaylaterWithDestination.getBuiltInFictitiousFunctionClassFactory());
                billPaginationModel5 = manageBillsFragment.getAuthRequestContext;
                billPaginationModel5.setLoading(false);
                billPaginationModel6 = manageBillsFragment.getAuthRequestContext;
                billPaginationModel6.getBills().addAll(BillPaymentAdapterModelKt.toListBillPaymentStatusModel(list, 1));
                z = manageBillsFragment.KClassImpl$Data$declaredNonStaticMembers$2;
                if (z) {
                    ((BillsAdapter) manageBillsFragment.MyBillsEntityDataFactory.getValue()).BuiltInFictitiousFunctionClassFactory();
                    manageBillsFragment.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                }
                BillsAdapter MyBillsEntityDataFactory = ManageBillsFragment.MyBillsEntityDataFactory(manageBillsFragment);
                billPaginationModel7 = manageBillsFragment.getAuthRequestContext;
                BaseRecyclerViewDiffUtilAdapter.getAuthRequestContext(MyBillsEntityDataFactory, billPaginationModel7.getBills());
                billPaginationModel8 = manageBillsFragment.getAuthRequestContext;
                ManageBillsFragment.MyBillsEntityDataFactory(manageBillsFragment, billPaginationModel8);
                VB vb = this.this$0.PlaceComponentResult;
                if (vb != 0) {
                    FragmentManageBillsBinding fragmentManageBillsBinding = (FragmentManageBillsBinding) vb;
                    LinearLayout linearLayout = fragmentManageBillsBinding.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "");
                    linearLayout.setVisibility(8);
                    NestedScrollView nestedScrollView = fragmentManageBillsBinding.PlaceComponentResult;
                    Intrinsics.checkNotNullExpressionValue(nestedScrollView, "");
                    nestedScrollView.setVisibility(0);
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else if (myBillsUiState instanceof MyBillsUiState.OnFailedGetConsultView) {
                billPaginationModel = this.this$0.getAuthRequestContext;
                billPaginationModel.setLoading(false);
                billPaginationModel2 = this.this$0.getAuthRequestContext;
                if (billPaginationModel2.getPageNum() != 1) {
                    billPaginationModel3 = this.this$0.getAuthRequestContext;
                    billPaginationModel3.setPageNum(billPaginationModel3.getPageNum() - 1);
                    billPaginationModel3.getPageNum();
                    DANAToast dANAToast = DANAToast.BuiltInFictitiousFunctionClassFactory;
                    FragmentActivity requireActivity = this.this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "");
                    String string = this.this$0.getString(R.string.mybills_error_toast);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    DANAToast.MyBillsEntityDataFactory(requireActivity, string, "");
                    try {
                        VB vb2 = this.this$0.PlaceComponentResult;
                        if (vb2 != 0) {
                            NestedScrollView nestedScrollView2 = ((FragmentManageBillsBinding) vb2).PlaceComponentResult;
                            VB vb3 = this.this$0.PlaceComponentResult;
                            if (vb3 != 0) {
                                nestedScrollView2.smoothScrollTo(0, ((FragmentManageBillsBinding) vb3).BuiltInFictitiousFunctionClassFactory.getBottom() / 2);
                            } else {
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    } catch (Exception e) {
                        DanaLog.BuiltInFictitiousFunctionClassFactory(this.this$0.getClass().getSimpleName(), e.getMessage());
                    }
                } else {
                    VB vb4 = this.this$0.PlaceComponentResult;
                    if (vb4 != 0) {
                        FragmentManageBillsBinding fragmentManageBillsBinding2 = (FragmentManageBillsBinding) vb4;
                        LinearLayout linearLayout2 = fragmentManageBillsBinding2.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                        Intrinsics.checkNotNullExpressionValue(linearLayout2, "");
                        linearLayout2.setVisibility(0);
                        NestedScrollView nestedScrollView3 = fragmentManageBillsBinding2.PlaceComponentResult;
                        Intrinsics.checkNotNullExpressionValue(nestedScrollView3, "");
                        nestedScrollView3.setVisibility(8);
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

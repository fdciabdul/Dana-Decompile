package id.dana.mybills.ui.v2.addnewbills;

import id.dana.mybills.ui.adapter.ServicesAdapter;
import id.dana.mybills.ui.mapper.MyBillsServiceMapperKt;
import id.dana.mybills.ui.model.MyBillsServiceModel;
import id.dana.mybills.ui.model.service.ThirdPartyService;
import id.dana.mybills.ui.v2.addnewbills.AddNewBillsUiState;
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

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "state", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment$initLifecycleActivity$1", f = "AddNewBillsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class AddNewBillsFragment$initLifecycleActivity$1 extends SuspendLambda implements Function2<AddNewBillsUiState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AddNewBillsFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddNewBillsFragment$initLifecycleActivity$1(AddNewBillsFragment addNewBillsFragment, Continuation<? super AddNewBillsFragment$initLifecycleActivity$1> continuation) {
        super(2, continuation);
        this.this$0 = addNewBillsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AddNewBillsFragment$initLifecycleActivity$1 addNewBillsFragment$initLifecycleActivity$1 = new AddNewBillsFragment$initLifecycleActivity$1(this.this$0, continuation);
        addNewBillsFragment$initLifecycleActivity$1.L$0 = obj;
        return addNewBillsFragment$initLifecycleActivity$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AddNewBillsUiState addNewBillsUiState, Continuation<? super Unit> continuation) {
        return ((AddNewBillsFragment$initLifecycleActivity$1) create(addNewBillsUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ServicesAdapter servicesAdapter;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            AddNewBillsUiState addNewBillsUiState = (AddNewBillsUiState) this.L$0;
            if (!(addNewBillsUiState instanceof AddNewBillsUiState.None)) {
                if (!(addNewBillsUiState instanceof AddNewBillsUiState.OnSuccessGetServiceMyBills)) {
                    if (addNewBillsUiState instanceof AddNewBillsUiState.OnSuccessGetIsNeedToShowBottomSheetOnBoarding) {
                        if (((AddNewBillsUiState.OnSuccessGetIsNeedToShowBottomSheetOnBoarding) addNewBillsUiState).getPlaceComponentResult()) {
                            AddNewBillsFragment.BuiltInFictitiousFunctionClassFactory(this.this$0);
                        }
                    } else if (addNewBillsUiState instanceof AddNewBillsUiState.OnSuccessGetQuickBuyBills) {
                        AddNewBillsFragment.getAuthRequestContext(this.this$0, ((AddNewBillsUiState.OnSuccessGetQuickBuyBills) addNewBillsUiState).MyBillsEntityDataFactory);
                    } else if (addNewBillsUiState instanceof AddNewBillsUiState.OnGetBizProductOrder) {
                        AddNewBillsFragment.BuiltInFictitiousFunctionClassFactory(this.this$0, ((AddNewBillsUiState.OnGetBizProductOrder) addNewBillsUiState).PlaceComponentResult);
                    } else if (addNewBillsUiState instanceof AddNewBillsUiState.OnQuickBuyShimmerLoading) {
                        AddNewBillsFragment.getAuthRequestContext(this.this$0, ((AddNewBillsUiState.OnQuickBuyShimmerLoading) addNewBillsUiState).getBuiltInFictitiousFunctionClassFactory());
                    }
                } else {
                    List<ThirdPartyService> list = ((AddNewBillsUiState.OnSuccessGetServiceMyBills) addNewBillsUiState).getAuthRequestContext;
                    AddNewBillsFragment addNewBillsFragment = this.this$0;
                    servicesAdapter = addNewBillsFragment.getAuthRequestContext;
                    List<MyBillsServiceModel> KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsServiceMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(list);
                    Intrinsics.checkNotNullParameter(KClassImpl$Data$declaredNonStaticMembers$2, "");
                    servicesAdapter.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, null);
                    AddNewBillsFragment.getAuthRequestContext(addNewBillsFragment);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

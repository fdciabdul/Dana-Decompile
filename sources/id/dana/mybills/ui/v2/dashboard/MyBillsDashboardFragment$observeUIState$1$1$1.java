package id.dana.mybills.ui.v2.dashboard;

import id.dana.core.ui.extension.StringExtKt;
import id.dana.mybills.databinding.FragmentMyBillsDashboardBinding;
import id.dana.mybills.ui.customview.FooterDashboardView;
import id.dana.mybills.ui.model.BillPaymentStatusModel;
import id.dana.mybills.ui.model.MoneyViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$observeUIState$1$1$1", f = "MyBillsDashboardFragment.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class MyBillsDashboardFragment$observeUIState$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MyBillsDashboardFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyBillsDashboardFragment$observeUIState$1$1$1(MyBillsDashboardFragment myBillsDashboardFragment, Continuation<? super MyBillsDashboardFragment$observeUIState$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = myBillsDashboardFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MyBillsDashboardFragment$observeUIState$1$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MyBillsDashboardFragment$observeUIState$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateFlow<List<BillPaymentStatusModel>> stateFlow = MyBillsDashboardFragment.GetContactSyncConfig(this.this$0).moveToNextValue;
            final MyBillsDashboardFragment myBillsDashboardFragment = this.this$0;
            this.label = 1;
            if (stateFlow.collect(new FlowCollector() { // from class: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment$observeUIState$1$1$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                /* renamed from: PlaceComponentResult  reason: merged with bridge method [inline-methods] */
                public final Object emit(List<BillPaymentStatusModel> list, Continuation<? super Unit> continuation) {
                    AtomicLong atomicLong;
                    String amount;
                    AtomicLong atomicLong2;
                    AtomicLong atomicLong3;
                    if (list.isEmpty()) {
                        atomicLong3 = MyBillsDashboardFragment.this.BuiltInFictitiousFunctionClassFactory;
                        atomicLong3.set(0L);
                    } else {
                        atomicLong = MyBillsDashboardFragment.this.BuiltInFictitiousFunctionClassFactory;
                        List<BillPaymentStatusModel> list2 = list;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                        Iterator<T> it = list2.iterator();
                        while (it.hasNext()) {
                            MoneyViewModel totalAmount = ((BillPaymentStatusModel) it.next()).getTotalAmount();
                            arrayList.add(Boxing.boxLong((totalAmount == null || (amount = totalAmount.getAmount()) == null) ? 0L : StringExtKt.BuiltInFictitiousFunctionClassFactory(amount)));
                        }
                        Iterator<T> it2 = arrayList.iterator();
                        if (!it2.hasNext()) {
                            throw new UnsupportedOperationException("Empty collection can't be reduced.");
                        }
                        T next = it2.next();
                        while (it2.hasNext()) {
                            next = (T) Boxing.boxLong(((Number) next).longValue() + ((Number) it2.next()).longValue());
                        }
                        atomicLong.set(((Number) next).longValue());
                    }
                    VB vb = MyBillsDashboardFragment.this.PlaceComponentResult;
                    if (vb != 0) {
                        FooterDashboardView footerDashboardView = ((FragmentMyBillsDashboardBinding) vb).initRecordTimeStamp;
                        int size = list.size();
                        atomicLong2 = MyBillsDashboardFragment.this.BuiltInFictitiousFunctionClassFactory;
                        String obj2 = atomicLong2.toString();
                        Intrinsics.checkNotNullExpressionValue(obj2, "");
                        footerDashboardView.setTotalItems(size, new MoneyViewModel(obj2, "Rp", null, 4, null));
                        VB vb2 = MyBillsDashboardFragment.this.PlaceComponentResult;
                        if (vb2 != 0) {
                            FooterDashboardView footerDashboardView2 = ((FragmentMyBillsDashboardBinding) vb2).initRecordTimeStamp;
                            Intrinsics.checkNotNullExpressionValue(footerDashboardView2, "");
                            footerDashboardView2.setVisibility(list.isEmpty() ^ true ? 0 : 8);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
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

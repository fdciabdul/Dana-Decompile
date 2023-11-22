package id.dana.mybills.ui.v2.addnewbills;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.mybills.domain.model.BizProductOrder;
import id.dana.mybills.ui.mapper.BizProductOrderModelMapperKt;
import id.dana.mybills.ui.v2.addnewbills.AddNewBillsUiState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/mybills/domain/model/BizProductOrder;", "bizProductOrder", "", BridgeDSL.INVOKE, "(Lid/dana/mybills/domain/model/BizProductOrder;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
final class AddNewBillsViewModel$getBizProductOrder$1 extends Lambda implements Function1<BizProductOrder, Unit> {
    final /* synthetic */ AddNewBillsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AddNewBillsViewModel$getBizProductOrder$1(AddNewBillsViewModel addNewBillsViewModel) {
        super(1);
        this.this$0 = addNewBillsViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(BizProductOrder bizProductOrder) {
        invoke2(bizProductOrder);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(BizProductOrder bizProductOrder) {
        MutableStateFlow mutableStateFlow;
        Object value;
        Intrinsics.checkNotNullParameter(bizProductOrder, "");
        mutableStateFlow = this.this$0.getAuthRequestContext;
        do {
            value = mutableStateFlow.getValue();
            AddNewBillsUiState addNewBillsUiState = (AddNewBillsUiState) value;
        } while (!mutableStateFlow.compareAndSet(value, new AddNewBillsUiState.OnGetBizProductOrder(BizProductOrderModelMapperKt.getAuthRequestContext(bizProductOrder))));
    }
}

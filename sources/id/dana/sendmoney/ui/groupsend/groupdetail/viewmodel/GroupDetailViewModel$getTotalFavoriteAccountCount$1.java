package id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailUiState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "totalFavoriteAccount", "", BridgeDSL.INVOKE, "(I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupDetailViewModel$getTotalFavoriteAccountCount$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ GroupDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupDetailViewModel$getTotalFavoriteAccountCount$1(GroupDetailViewModel groupDetailViewModel) {
        super(1);
        this.this$0 = groupDetailViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        MutableStateFlow mutableStateFlow;
        Object value;
        mutableStateFlow = this.this$0.getAuthRequestContext;
        do {
            value = mutableStateFlow.getValue();
            GroupDetailUiState groupDetailUiState = (GroupDetailUiState) value;
        } while (!mutableStateFlow.compareAndSet(value, new GroupDetailUiState.OnSuccessGetTotalFavoriteAccount(i)));
    }
}

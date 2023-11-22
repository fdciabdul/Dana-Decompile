package id.dana.riskChallenges.ui.resetpin.newpin.viewmodel;

import androidx.view.ViewModel;
import id.dana.riskChallenges.ui.resetpin.newpin.viewmodel.InputNewPinUiState;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0010\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/newpin/viewmodel/InputNewPinViewModel;", "Landroidx/lifecycle/ViewModel;", "", "PlaceComponentResult", "()V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/riskChallenges/ui/resetpin/newpin/viewmodel/InputNewPinUiState;", "getAuthRequestContext", "Lkotlinx/coroutines/flow/MutableStateFlow;", "BuiltInFictitiousFunctionClassFactory", "", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Lkotlinx/coroutines/flow/StateFlow;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlinx/coroutines/flow/StateFlow;", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InputNewPinViewModel extends ViewModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final StateFlow<InputNewPinUiState> getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final MutableStateFlow<InputNewPinUiState> BuiltInFictitiousFunctionClassFactory;

    @Inject
    public InputNewPinViewModel() {
        MutableStateFlow<InputNewPinUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(InputNewPinUiState.None.INSTANCE);
        this.BuiltInFictitiousFunctionClassFactory = MutableStateFlow;
        this.getAuthRequestContext = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final void PlaceComponentResult() {
        MutableStateFlow<InputNewPinUiState> mutableStateFlow = this.BuiltInFictitiousFunctionClassFactory;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), InputNewPinUiState.None.INSTANCE));
    }
}

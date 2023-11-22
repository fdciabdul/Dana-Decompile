package id.dana.danapoly.ui.splash.viewmodel;

import androidx.view.ViewModel;
import id.dana.danapoly.domain.config.interactor.GetPlayBoard;
import id.dana.danapoly.ui.splash.viewmodel.DanapolyConfigUiState;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\nX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/danapoly/ui/splash/viewmodel/DanapolyConfigViewModel;", "Landroidx/lifecycle/ViewModel;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/danapoly/ui/splash/viewmodel/DanapolyConfigUiState;", "BuiltInFictitiousFunctionClassFactory", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getAuthRequestContext", "Lid/dana/danapoly/domain/config/interactor/GetPlayBoard;", "Lid/dana/danapoly/domain/config/interactor/GetPlayBoard;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlinx/coroutines/flow/StateFlow;", "MyBillsEntityDataFactory", "Lkotlinx/coroutines/flow/StateFlow;", "p0", "<init>", "(Lid/dana/danapoly/domain/config/interactor/GetPlayBoard;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyConfigViewModel extends ViewModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final MutableStateFlow<DanapolyConfigUiState> getAuthRequestContext;
    public final StateFlow<DanapolyConfigUiState> MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final GetPlayBoard KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public DanapolyConfigViewModel(GetPlayBoard getPlayBoard) {
        Intrinsics.checkNotNullParameter(getPlayBoard, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getPlayBoard;
        MutableStateFlow<DanapolyConfigUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(DanapolyConfigUiState.None.INSTANCE);
        this.getAuthRequestContext = MutableStateFlow;
        this.MyBillsEntityDataFactory = FlowKt.asStateFlow(MutableStateFlow);
    }
}

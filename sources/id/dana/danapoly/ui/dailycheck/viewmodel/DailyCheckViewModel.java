package id.dana.danapoly.ui.dailycheck.viewmodel;

import androidx.view.ViewModel;
import id.dana.danapoly.domain.dailycheck.interactor.DoCheckIn;
import id.dana.danapoly.domain.dailycheck.interactor.FetchCheckInHistory;
import id.dana.danapoly.ui.dailycheck.viewmodel.DailyCheckUiState;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0004\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\rX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\u000e"}, d2 = {"Lid/dana/danapoly/ui/dailycheck/viewmodel/DailyCheckViewModel;", "Landroidx/lifecycle/ViewModel;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/danapoly/ui/dailycheck/viewmodel/DailyCheckUiState;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlinx/coroutines/flow/MutableStateFlow;", "MyBillsEntityDataFactory", "Lid/dana/danapoly/domain/dailycheck/interactor/DoCheckIn;", "Lid/dana/danapoly/domain/dailycheck/interactor/DoCheckIn;", "Lid/dana/danapoly/domain/dailycheck/interactor/FetchCheckInHistory;", "getAuthRequestContext", "Lid/dana/danapoly/domain/dailycheck/interactor/FetchCheckInHistory;", "PlaceComponentResult", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "<init>", "(Lid/dana/danapoly/domain/dailycheck/interactor/FetchCheckInHistory;Lid/dana/danapoly/domain/dailycheck/interactor/DoCheckIn;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DailyCheckViewModel extends ViewModel {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final MutableStateFlow<DailyCheckUiState> MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final DoCheckIn KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final StateFlow<DailyCheckUiState> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final FetchCheckInHistory PlaceComponentResult;

    @Inject
    public DailyCheckViewModel(FetchCheckInHistory fetchCheckInHistory, DoCheckIn doCheckIn) {
        Intrinsics.checkNotNullParameter(fetchCheckInHistory, "");
        Intrinsics.checkNotNullParameter(doCheckIn, "");
        this.PlaceComponentResult = fetchCheckInHistory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = doCheckIn;
        MutableStateFlow<DailyCheckUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(DailyCheckUiState.None.INSTANCE);
        this.MyBillsEntityDataFactory = MutableStateFlow;
        this.BuiltInFictitiousFunctionClassFactory = FlowKt.asStateFlow(MutableStateFlow);
    }
}

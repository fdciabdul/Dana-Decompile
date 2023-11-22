package id.dana.sendmoney.ui.globalsend.form.viewmodel;

import androidx.view.ViewModel;
import id.dana.sendmoney.domain.globalsend.interactor.GetCountryList;
import id.dana.sendmoney.ui.globalsend.form.viewmodel.SelectCountryDestinationUiState;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/SelectCountryDestinationViewModel;", "Landroidx/lifecycle/ViewModel;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/SelectCountryDestinationUiState;", "getAuthRequestContext", "Lkotlinx/coroutines/flow/MutableStateFlow;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/domain/globalsend/interactor/GetCountryList;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/domain/globalsend/interactor/GetCountryList;", "PlaceComponentResult", "Lkotlinx/coroutines/flow/StateFlow;", "BuiltInFictitiousFunctionClassFactory", "Lkotlinx/coroutines/flow/StateFlow;", "p0", "<init>", "(Lid/dana/sendmoney/domain/globalsend/interactor/GetCountryList;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectCountryDestinationViewModel extends ViewModel {
    public final StateFlow<SelectCountryDestinationUiState> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final GetCountryList PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final MutableStateFlow<SelectCountryDestinationUiState> KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public SelectCountryDestinationViewModel(GetCountryList getCountryList) {
        Intrinsics.checkNotNullParameter(getCountryList, "");
        this.PlaceComponentResult = getCountryList;
        MutableStateFlow<SelectCountryDestinationUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(SelectCountryDestinationUiState.None.INSTANCE);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = MutableStateFlow;
        this.BuiltInFictitiousFunctionClassFactory = FlowKt.asStateFlow(MutableStateFlow);
    }
}

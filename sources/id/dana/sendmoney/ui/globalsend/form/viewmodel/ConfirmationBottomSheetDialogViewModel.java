package id.dana.sendmoney.ui.globalsend.form.viewmodel;

import androidx.view.ViewModel;
import id.dana.sendmoney.domain.globalsend.interactor.SaveSenderDetail;
import id.dana.sendmoney.domain.groupsend.interactor.GetUserInfo;
import id.dana.sendmoney.ui.globalsend.form.viewmodel.ConfirmationBottomSheetDialogUiState;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0004\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\rX\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u000e"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ConfirmationBottomSheetDialogViewModel;", "Landroidx/lifecycle/ViewModel;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ConfirmationBottomSheetDialogUiState;", "PlaceComponentResult", "Lkotlinx/coroutines/flow/MutableStateFlow;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/domain/groupsend/interactor/GetUserInfo;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/domain/groupsend/interactor/GetUserInfo;", "Lid/dana/sendmoney/domain/globalsend/interactor/SaveSenderDetail;", "getAuthRequestContext", "Lid/dana/sendmoney/domain/globalsend/interactor/SaveSenderDetail;", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "<init>", "(Lid/dana/sendmoney/domain/globalsend/interactor/SaveSenderDetail;Lid/dana/sendmoney/domain/groupsend/interactor/GetUserInfo;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConfirmationBottomSheetDialogViewModel extends ViewModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final StateFlow<ConfirmationBottomSheetDialogUiState> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final GetUserInfo PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final MutableStateFlow<ConfirmationBottomSheetDialogUiState> BuiltInFictitiousFunctionClassFactory;
    public final SaveSenderDetail getAuthRequestContext;

    @Inject
    public ConfirmationBottomSheetDialogViewModel(SaveSenderDetail saveSenderDetail, GetUserInfo getUserInfo) {
        Intrinsics.checkNotNullParameter(saveSenderDetail, "");
        Intrinsics.checkNotNullParameter(getUserInfo, "");
        this.getAuthRequestContext = saveSenderDetail;
        this.PlaceComponentResult = getUserInfo;
        MutableStateFlow<ConfirmationBottomSheetDialogUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(ConfirmationBottomSheetDialogUiState.None.INSTANCE);
        this.BuiltInFictitiousFunctionClassFactory = MutableStateFlow;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = FlowKt.asStateFlow(MutableStateFlow);
    }
}

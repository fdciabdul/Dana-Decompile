package id.dana.sendmoney.ui.globalsend.form.viewmodel;

import androidx.view.ViewModel;
import androidx.view.ViewModelKt;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.network.exception.NetworkException;
import id.dana.sendmoney.domain.globalsend.interactor.InitGlobalTransfer;
import id.dana.sendmoney.domain.globalsend.interactor.TransferSubmit;
import id.dana.sendmoney.domain.globalsend.model.init.GlobalTransferInitResult;
import id.dana.sendmoney.ui.globalsend.form.mapper.GlobalTransferInitModelMapperKt;
import id.dana.sendmoney.ui.globalsend.form.viewmodel.AmountFormUiState;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\f\u0012\u0006\u0010\u0004\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\n\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0012X\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormViewModel;", "Landroidx/lifecycle/ViewModel;", "", "p0", "p1", "", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;)V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormUiState;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/sendmoney/domain/globalsend/interactor/InitGlobalTransfer;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/domain/globalsend/interactor/InitGlobalTransfer;", "Lid/dana/sendmoney/domain/globalsend/interactor/TransferSubmit;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/domain/globalsend/interactor/TransferSubmit;", "Lkotlinx/coroutines/flow/StateFlow;", "PlaceComponentResult", "Lkotlinx/coroutines/flow/StateFlow;", "<init>", "(Lid/dana/sendmoney/domain/globalsend/interactor/InitGlobalTransfer;Lid/dana/sendmoney/domain/globalsend/interactor/TransferSubmit;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AmountFormViewModel extends ViewModel {
    public final TransferSubmit BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final MutableStateFlow<AmountFormUiState> getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final InitGlobalTransfer KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final StateFlow<AmountFormUiState> MyBillsEntityDataFactory;

    @Inject
    public AmountFormViewModel(InitGlobalTransfer initGlobalTransfer, TransferSubmit transferSubmit) {
        Intrinsics.checkNotNullParameter(initGlobalTransfer, "");
        Intrinsics.checkNotNullParameter(transferSubmit, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = initGlobalTransfer;
        this.BuiltInFictitiousFunctionClassFactory = transferSubmit;
        MutableStateFlow<AmountFormUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(AmountFormUiState.None.INSTANCE);
        this.getAuthRequestContext = MutableStateFlow;
        this.MyBillsEntityDataFactory = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final void getAuthRequestContext(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        BaseFlowUseCase.execute$default(this.KClassImpl$Data$declaredNonStaticMembers$2, new InitGlobalTransfer.Param(p0, p1), new Function0<Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.AmountFormViewModel$initGlobalTransfer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = AmountFormViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    AmountFormUiState amountFormUiState = (AmountFormUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new AmountFormUiState.ShimmerLoading(true)));
            }
        }, new Function1<GlobalTransferInitResult, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.AmountFormViewModel$initGlobalTransfer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(GlobalTransferInitResult globalTransferInitResult) {
                invoke2(globalTransferInitResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(GlobalTransferInitResult globalTransferInitResult) {
                MutableStateFlow mutableStateFlow;
                Object value;
                MutableStateFlow mutableStateFlow2;
                Object value2;
                Intrinsics.checkNotNullParameter(globalTransferInitResult, "");
                mutableStateFlow = AmountFormViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    AmountFormUiState amountFormUiState = (AmountFormUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new AmountFormUiState.OnSuccessInitGlobalTransfer(GlobalTransferInitModelMapperKt.getAuthRequestContext(globalTransferInitResult))));
                mutableStateFlow2 = AmountFormViewModel.this.getAuthRequestContext;
                do {
                    value2 = mutableStateFlow2.getValue();
                    AmountFormUiState amountFormUiState2 = (AmountFormUiState) value2;
                } while (!mutableStateFlow2.compareAndSet(value2, new AmountFormUiState.ShimmerLoading(false)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.AmountFormViewModel$initGlobalTransfer$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Object obj;
                Intrinsics.checkNotNullParameter(th, "");
                mutableStateFlow = AmountFormViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    AmountFormUiState amountFormUiState = (AmountFormUiState) value;
                    if (th instanceof NetworkException) {
                        NetworkException networkException = (NetworkException) th;
                        String errorCode = networkException.getErrorCode();
                        if (errorCode == null) {
                            errorCode = "";
                        }
                        String localizedMessage = networkException.getLocalizedMessage();
                        if (localizedMessage == null) {
                            localizedMessage = "";
                        }
                        obj = (AmountFormUiState) new AmountFormUiState.OnErrorCode(errorCode, localizedMessage);
                    } else {
                        obj = (AmountFormUiState) AmountFormUiState.OnErrorFetchInit.INSTANCE;
                    }
                } while (!mutableStateFlow.compareAndSet(value, obj));
            }
        }, null, ViewModelKt.PlaceComponentResult(this), 16, null);
    }
}

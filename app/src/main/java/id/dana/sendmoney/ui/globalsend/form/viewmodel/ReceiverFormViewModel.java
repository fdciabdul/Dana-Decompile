package id.dana.sendmoney.ui.globalsend.form.viewmodel;

import androidx.view.ViewModel;
import androidx.view.ViewModelKt;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.network.exception.NetworkException;
import id.dana.sendmoney.domain.common.interactor.ValidateFormUseCase;
import id.dana.sendmoney.domain.globalsend.interactor.GetProvinceList;
import id.dana.sendmoney.domain.globalsend.interactor.InitGlobalTransfer;
import id.dana.sendmoney.domain.globalsend.interactor.ValidateNewTransaction;
import id.dana.sendmoney.domain.globalsend.model.init.GlobalTransferInitResult;
import id.dana.sendmoney.ui.globalsend.form.mapper.GlobalTransferInitModelMapperKt;
import id.dana.sendmoney.ui.globalsend.form.model.common.FormValidatorModel;
import id.dana.sendmoney.ui.globalsend.form.viewmodel.ReceiverFormUiState;
import java.util.Map;
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

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0018\u0012\u0006\u0010\b\u001a\u00020\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u000f¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\rR\u0014\u0010\t\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\f0\u0016X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0017R\u0014\u0010\u0010\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u0014\u0010\u0013\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u001b"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormViewModel;", "Landroidx/lifecycle/ViewModel;", "Lid/dana/sendmoney/ui/globalsend/form/model/common/FormValidatorModel;", "p0", "", "getAuthRequestContext", "(Lid/dana/sendmoney/ui/globalsend/form/model/common/FormValidatorModel;)V", "", "p1", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;)V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormUiState;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/domain/globalsend/interactor/GetProvinceList;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/domain/globalsend/interactor/GetProvinceList;", "Lid/dana/sendmoney/domain/globalsend/interactor/InitGlobalTransfer;", "moveToNextValue", "Lid/dana/sendmoney/domain/globalsend/interactor/InitGlobalTransfer;", "MyBillsEntityDataFactory", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "Lid/dana/sendmoney/domain/common/interactor/ValidateFormUseCase;", "Lid/dana/sendmoney/domain/common/interactor/ValidateFormUseCase;", "Lid/dana/sendmoney/domain/globalsend/interactor/ValidateNewTransaction;", "Lid/dana/sendmoney/domain/globalsend/interactor/ValidateNewTransaction;", "p2", "p3", "<init>", "(Lid/dana/sendmoney/domain/common/interactor/ValidateFormUseCase;Lid/dana/sendmoney/domain/globalsend/interactor/ValidateNewTransaction;Lid/dana/sendmoney/domain/globalsend/interactor/InitGlobalTransfer;Lid/dana/sendmoney/domain/globalsend/interactor/GetProvinceList;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReceiverFormViewModel extends ViewModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final GetProvinceList PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final StateFlow<ReceiverFormUiState> getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final ValidateNewTransaction moveToNextValue;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final MutableStateFlow<ReceiverFormUiState> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final ValidateFormUseCase BuiltInFictitiousFunctionClassFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final InitGlobalTransfer MyBillsEntityDataFactory;

    @Inject
    public ReceiverFormViewModel(ValidateFormUseCase validateFormUseCase, ValidateNewTransaction validateNewTransaction, InitGlobalTransfer initGlobalTransfer, GetProvinceList getProvinceList) {
        Intrinsics.checkNotNullParameter(validateFormUseCase, "");
        Intrinsics.checkNotNullParameter(validateNewTransaction, "");
        Intrinsics.checkNotNullParameter(initGlobalTransfer, "");
        Intrinsics.checkNotNullParameter(getProvinceList, "");
        this.BuiltInFictitiousFunctionClassFactory = validateFormUseCase;
        this.moveToNextValue = validateNewTransaction;
        this.MyBillsEntityDataFactory = initGlobalTransfer;
        this.PlaceComponentResult = getProvinceList;
        MutableStateFlow<ReceiverFormUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(ReceiverFormUiState.None.INSTANCE);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = MutableStateFlow;
        this.getAuthRequestContext = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final void getAuthRequestContext(FormValidatorModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        BaseFlowUseCase.execute$default(this.BuiltInFictitiousFunctionClassFactory, new ValidateFormUseCase.Params(p0), null, new Function1<Map<String, ? extends String>, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.ReceiverFormViewModel$checkFormValidity$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends String> map) {
                invoke2((Map<String, String>) map);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Map<String, String> map) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(map, "");
                boolean isEmpty = map.isEmpty();
                mutableStateFlow = ReceiverFormViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                do {
                    value = mutableStateFlow.getValue();
                    ReceiverFormUiState receiverFormUiState = (ReceiverFormUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new ReceiverFormUiState.OnFormValid(isEmpty)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.ReceiverFormViewModel$checkFormValidity$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        }, null, ViewModelKt.PlaceComponentResult(this), 18, null);
    }

    public final void PlaceComponentResult(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        BaseFlowUseCase.execute$default(this.MyBillsEntityDataFactory, new InitGlobalTransfer.Param(p0, p1), new Function0<Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.ReceiverFormViewModel$initGlobalTransfer$1
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
                mutableStateFlow = ReceiverFormViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                do {
                    value = mutableStateFlow.getValue();
                    ReceiverFormUiState receiverFormUiState = (ReceiverFormUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new ReceiverFormUiState.ShimmerLoading(true)));
            }
        }, new Function1<GlobalTransferInitResult, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.ReceiverFormViewModel$initGlobalTransfer$2
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
                Intrinsics.checkNotNullParameter(globalTransferInitResult, "");
                mutableStateFlow = ReceiverFormViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                do {
                    value = mutableStateFlow.getValue();
                    ReceiverFormUiState receiverFormUiState = (ReceiverFormUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new ReceiverFormUiState.OnSuccessInitGlobalTransfer(GlobalTransferInitModelMapperKt.getAuthRequestContext(globalTransferInitResult))));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.ReceiverFormViewModel$initGlobalTransfer$3
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
                ReceiverFormUiState onErrorFetchInit;
                Intrinsics.checkNotNullParameter(th, "");
                mutableStateFlow = ReceiverFormViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                do {
                    value = mutableStateFlow.getValue();
                    ReceiverFormUiState receiverFormUiState = (ReceiverFormUiState) value;
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
                        onErrorFetchInit = new ReceiverFormUiState.OnErrorCodeInit(errorCode, localizedMessage);
                    } else {
                        onErrorFetchInit = new ReceiverFormUiState.OnErrorFetchInit(th.getMessage());
                    }
                } while (!mutableStateFlow.compareAndSet(value, onErrorFetchInit));
            }
        }, null, ViewModelKt.PlaceComponentResult(this), 16, null);
    }
}

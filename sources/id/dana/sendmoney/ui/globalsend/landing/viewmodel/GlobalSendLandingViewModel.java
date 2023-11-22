package id.dana.sendmoney.ui.globalsend.landing.viewmodel;

import androidx.view.ViewModel;
import androidx.view.ViewModelKt;
import id.dana.sendmoney.domain.globalsend.interactor.DeleteBeneficiaryList;
import id.dana.sendmoney.domain.globalsend.interactor.GetMaxBeneficiaryPageSize;
import id.dana.sendmoney.domain.globalsend.interactor.GetQueryBeneficiaryList;
import id.dana.sendmoney.domain.globalsend.interactor.GetSortBeneficiaryList;
import id.dana.sendmoney.domain.globalsend.interactor.SaveSortBeneficiaryList;
import id.dana.sendmoney.domain.globalsend.interactor.ValidateRecurringTransaction;
import id.dana.sendmoney.domain.globalsend.model.beneficiary.response.QueryBeneficiaryResult;
import id.dana.sendmoney.ui.globalsend.landing.QueryBeneficiaryResultMapperKt;
import id.dana.sendmoney.ui.globalsend.landing.viewmodel.GlobalSendLandingUiState;
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

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u000f\u0012\u0006\u0010!\u001a\u00020\u0013\u0012\u0006\u0010\"\u001a\u00020\u001d\u0012\u0006\u0010#\u001a\u00020\f\u0012\u0006\u0010$\u001a\u00020\u0018\u0012\u0006\u0010%\u001a\u00020\u0016¢\u0006\u0004\b&\u0010'J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0010\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0019R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u001bX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u001cR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingViewModel;", "Landroidx/lifecycle/ViewModel;", "", "p0", "", "PlaceComponentResult", "(I)V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState;", "getErrorConfigVersion", "Lkotlinx/coroutines/flow/MutableStateFlow;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/domain/globalsend/interactor/DeleteBeneficiaryList;", "Lid/dana/sendmoney/domain/globalsend/interactor/DeleteBeneficiaryList;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/domain/globalsend/interactor/GetMaxBeneficiaryPageSize;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/domain/globalsend/interactor/GetMaxBeneficiaryPageSize;", "getAuthRequestContext", "Lid/dana/sendmoney/domain/globalsend/interactor/GetQueryBeneficiaryList;", "scheduleImpl", "Lid/dana/sendmoney/domain/globalsend/interactor/GetQueryBeneficiaryList;", "Lid/dana/sendmoney/domain/globalsend/interactor/GetSortBeneficiaryList;", "Lid/dana/sendmoney/domain/globalsend/interactor/GetSortBeneficiaryList;", "Lid/dana/sendmoney/domain/globalsend/interactor/SaveSortBeneficiaryList;", "Lid/dana/sendmoney/domain/globalsend/interactor/SaveSortBeneficiaryList;", "lookAheadTest", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "Lid/dana/sendmoney/domain/globalsend/interactor/ValidateRecurringTransaction;", "moveToNextValue", "Lid/dana/sendmoney/domain/globalsend/interactor/ValidateRecurringTransaction;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "p1", "p2", "p3", "p4", "p5", "<init>", "(Lid/dana/sendmoney/domain/globalsend/interactor/GetMaxBeneficiaryPageSize;Lid/dana/sendmoney/domain/globalsend/interactor/GetQueryBeneficiaryList;Lid/dana/sendmoney/domain/globalsend/interactor/ValidateRecurringTransaction;Lid/dana/sendmoney/domain/globalsend/interactor/DeleteBeneficiaryList;Lid/dana/sendmoney/domain/globalsend/interactor/SaveSortBeneficiaryList;Lid/dana/sendmoney/domain/globalsend/interactor/GetSortBeneficiaryList;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalSendLandingViewModel extends ViewModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final GetMaxBeneficiaryPageSize getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final StateFlow<GlobalSendLandingUiState> scheduleImpl;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final SaveSortBeneficiaryList lookAheadTest;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final DeleteBeneficiaryList KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final GetSortBeneficiaryList BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final MutableStateFlow<GlobalSendLandingUiState> MyBillsEntityDataFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final ValidateRecurringTransaction NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final GetQueryBeneficiaryList PlaceComponentResult;

    @Inject
    public GlobalSendLandingViewModel(GetMaxBeneficiaryPageSize getMaxBeneficiaryPageSize, GetQueryBeneficiaryList getQueryBeneficiaryList, ValidateRecurringTransaction validateRecurringTransaction, DeleteBeneficiaryList deleteBeneficiaryList, SaveSortBeneficiaryList saveSortBeneficiaryList, GetSortBeneficiaryList getSortBeneficiaryList) {
        Intrinsics.checkNotNullParameter(getMaxBeneficiaryPageSize, "");
        Intrinsics.checkNotNullParameter(getQueryBeneficiaryList, "");
        Intrinsics.checkNotNullParameter(validateRecurringTransaction, "");
        Intrinsics.checkNotNullParameter(deleteBeneficiaryList, "");
        Intrinsics.checkNotNullParameter(saveSortBeneficiaryList, "");
        Intrinsics.checkNotNullParameter(getSortBeneficiaryList, "");
        this.getAuthRequestContext = getMaxBeneficiaryPageSize;
        this.PlaceComponentResult = getQueryBeneficiaryList;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = validateRecurringTransaction;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = deleteBeneficiaryList;
        this.lookAheadTest = saveSortBeneficiaryList;
        this.BuiltInFictitiousFunctionClassFactory = getSortBeneficiaryList;
        MutableStateFlow<GlobalSendLandingUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(GlobalSendLandingUiState.None.INSTANCE);
        this.MyBillsEntityDataFactory = MutableStateFlow;
        this.scheduleImpl = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final void PlaceComponentResult(int p0) {
        this.PlaceComponentResult.execute(new GetQueryBeneficiaryList.Param(p0), new Function0<Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.viewmodel.GlobalSendLandingViewModel$getQueryBeneficiaryList$1
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
                mutableStateFlow = GlobalSendLandingViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    GlobalSendLandingUiState globalSendLandingUiState = (GlobalSendLandingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GlobalSendLandingUiState.ShimmerLoading(true)));
            }
        }, new Function1<QueryBeneficiaryResult, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.viewmodel.GlobalSendLandingViewModel$getQueryBeneficiaryList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(QueryBeneficiaryResult queryBeneficiaryResult) {
                invoke2(queryBeneficiaryResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(QueryBeneficiaryResult queryBeneficiaryResult) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(queryBeneficiaryResult, "");
                mutableStateFlow = GlobalSendLandingViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    GlobalSendLandingUiState globalSendLandingUiState = (GlobalSendLandingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GlobalSendLandingUiState.OnSuccessGetBeneficiaryList(QueryBeneficiaryResultMapperKt.MyBillsEntityDataFactory(queryBeneficiaryResult))));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.viewmodel.GlobalSendLandingViewModel$getQueryBeneficiaryList$3
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
                Intrinsics.checkNotNullParameter(th, "");
                mutableStateFlow = GlobalSendLandingViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    GlobalSendLandingUiState globalSendLandingUiState = (GlobalSendLandingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GlobalSendLandingUiState.OnErrorGetBeneficiary(0, 1, null)));
            }
        }, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.globalsend.landing.viewmodel.GlobalSendLandingViewModel$getQueryBeneficiaryList$4
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
                mutableStateFlow = GlobalSendLandingViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    GlobalSendLandingUiState globalSendLandingUiState = (GlobalSendLandingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GlobalSendLandingUiState.ShimmerLoading(false)));
            }
        }, ViewModelKt.PlaceComponentResult(this));
    }
}

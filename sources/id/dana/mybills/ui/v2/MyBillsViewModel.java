package id.dana.mybills.ui.v2;

import androidx.view.ViewModel;
import androidx.view.ViewModelKt;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.domain.mybills.interactor.CheckMyBillsVersionConfig;
import id.dana.mybills.data.model.request.UpdateSubscriptionRequest;
import id.dana.mybills.data.model.response.UpdateSubscriptionResult;
import id.dana.mybills.domain.interactor.DeleteSubscriptionBill;
import id.dana.mybills.domain.interactor.GetGeneralProducts;
import id.dana.mybills.domain.interactor.GetHighlightPayTransaction;
import id.dana.mybills.domain.interactor.GetInquirySubscriptionPaylaterWithDestination;
import id.dana.mybills.domain.interactor.GetListHighlightMyBills;
import id.dana.mybills.domain.interactor.GetMonthlyWithConsultView;
import id.dana.mybills.domain.interactor.GetUserCurrentBalance;
import id.dana.mybills.domain.interactor.UpdateSubscriptionBill;
import id.dana.mybills.domain.model.BizProductDestination;
import id.dana.mybills.domain.model.BizProductDestinationKt;
import id.dana.mybills.domain.model.MonthlyAmountAndHighlightRequest;
import id.dana.mybills.domain.model.MyBillsHighlight;
import id.dana.mybills.domain.model.MyBillsHighlightRequestModel;
import id.dana.mybills.ui.model.BillPaymentAdapterModelKt;
import id.dana.mybills.ui.model.BillPaymentStatusModel;
import id.dana.mybills.ui.model.BillSubscriptionHighlightModel;
import id.dana.mybills.ui.model.MoneyViewModel;
import id.dana.mybills.ui.model.MonthlyHighlightBillModelKt;
import id.dana.mybills.ui.model.generalize.BillPaginationModel;
import id.dana.mybills.ui.v2.MyBillsUiState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 M2\u00020\u0001:\u0001MBQ\b\u0007\u0012\u0006\u0010\u0003\u001a\u000207\u0012\u0006\u0010\u000b\u001a\u000204\u0012\u0006\u0010D\u001a\u00020:\u0012\u0006\u0010E\u001a\u00020*\u0012\u0006\u0010F\u001a\u000201\u0012\u0006\u0010G\u001a\u00020.\u0012\u0006\u0010H\u001a\u00020@\u0012\u0006\u0010I\u001a\u00020!\u0012\u0006\u0010J\u001a\u00020'¢\u0006\u0004\bK\u0010LJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0007J#\u0010\f\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00120\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00150\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0014R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00150\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0014R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00120\u001eX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\"R\u0012\u0010&\u001a\u00020$X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010/R\u0014\u00103\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u00102R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u00105R\u0014\u00109\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u00108R\u0014\u0010<\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010;R\u0012\u0010=\u001a\u00020$X\u0086\u0002¢\u0006\u0006\n\u0004\b0\u0010%R\u0012\u0010>\u001a\u00020$X\u0086\u0002¢\u0006\u0006\n\u0004\b6\u0010%R\u0012\u0010?\u001a\u00020$X\u0086\u0002¢\u0006\u0006\n\u0004\b-\u0010%R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u001eX\u0006¢\u0006\u0006\n\u0004\b3\u0010\u001fR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u001eX\u0006¢\u0006\u0006\n\u0004\b=\u0010\u001fR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u001eX\u0006¢\u0006\u0006\n\u0004\b<\u0010\u001fR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u001eX\u0006¢\u0006\u0006\n\u0004\b?\u0010\u001fR\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u001eX\u0006¢\u0006\u0006\n\u0004\b9\u0010\u001fR\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00150\u001eX\u0006¢\u0006\u0006\n\u0004\b>\u0010\u001fR\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010B"}, d2 = {"Lid/dana/mybills/ui/v2/MyBillsViewModel;", "Landroidx/lifecycle/ViewModel;", "Lid/dana/mybills/domain/model/MonthlyAmountAndHighlightRequest;", "p0", "", "MyBillsEntityDataFactory", "(Lid/dana/mybills/domain/model/MonthlyAmountAndHighlightRequest;)V", "()V", "", "Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "", "p1", "getAuthRequestContext", "(Ljava/util/List;Z)V", "Lid/dana/mybills/data/model/request/UpdateSubscriptionRequest;", "PlaceComponentResult", "(Lid/dana/mybills/data/model/request/UpdateSubscriptionRequest;)V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "NetworkUserEntityData$$ExternalSyntheticLambda6", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/mybills/ui/v2/MyBillsUiState;", "NetworkUserEntityData$$ExternalSyntheticLambda4", "BuiltInFictitiousFunctionClassFactory", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda5", "KClassImpl$Data$declaredNonStaticMembers$2", "FragmentBottomSheetPaymentSettingBinding", "NetworkUserEntityData$$ExternalSyntheticLambda0", "scheduleImpl", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "moveToNextValue", "Lid/dana/mybills/domain/interactor/DeleteSubscriptionBill;", "Lid/dana/mybills/domain/interactor/DeleteSubscriptionBill;", "lookAheadTest", "Lid/dana/mybills/ui/model/generalize/BillPaginationModel;", "Lid/dana/mybills/ui/model/generalize/BillPaginationModel;", "getErrorConfigVersion", "Lid/dana/domain/mybills/interactor/CheckMyBillsVersionConfig;", "Lid/dana/domain/mybills/interactor/CheckMyBillsVersionConfig;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/mybills/domain/interactor/GetListHighlightMyBills;", "readMicros", "Lid/dana/mybills/domain/interactor/GetListHighlightMyBills;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/mybills/domain/interactor/GetGeneralProducts;", "Lid/dana/mybills/domain/interactor/GetGeneralProducts;", "DatabaseTableConfigUtil", "Lid/dana/mybills/domain/interactor/GetHighlightPayTransaction;", "Lid/dana/mybills/domain/interactor/GetHighlightPayTransaction;", "GetContactSyncConfig", "Lid/dana/mybills/domain/interactor/GetInquirySubscriptionPaylaterWithDestination;", "Lid/dana/mybills/domain/interactor/GetInquirySubscriptionPaylaterWithDestination;", "initRecordTimeStamp", "Lid/dana/mybills/domain/interactor/GetMonthlyWithConsultView;", "Lid/dana/mybills/domain/interactor/GetMonthlyWithConsultView;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/mybills/domain/interactor/GetUserCurrentBalance;", "Lid/dana/mybills/domain/interactor/GetUserCurrentBalance;", "newProxyInstance", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda7", "PrepareContext", "Lid/dana/mybills/domain/interactor/UpdateSubscriptionBill;", "getCallingPid", "Lid/dana/mybills/domain/interactor/UpdateSubscriptionBill;", "SubSequence", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "<init>", "(Lid/dana/mybills/domain/interactor/GetMonthlyWithConsultView;Lid/dana/mybills/domain/interactor/GetInquirySubscriptionPaylaterWithDestination;Lid/dana/mybills/domain/interactor/GetUserCurrentBalance;Lid/dana/mybills/domain/interactor/GetListHighlightMyBills;Lid/dana/mybills/domain/interactor/GetHighlightPayTransaction;Lid/dana/mybills/domain/interactor/GetGeneralProducts;Lid/dana/mybills/domain/interactor/UpdateSubscriptionBill;Lid/dana/mybills/domain/interactor/DeleteSubscriptionBill;Lid/dana/domain/mybills/interactor/CheckMyBillsVersionConfig;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MyBillsViewModel extends ViewModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final DeleteSubscriptionBill lookAheadTest;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public BillPaginationModel isLayoutRequested;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private final MutableStateFlow<MyBillsUiState> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public final StateFlow<MyBillsUiState> NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final MutableStateFlow<MyBillsUiState> scheduleImpl;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public BillPaginationModel getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final GetHighlightPayTransaction GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public BillPaginationModel PrepareContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public final GetUserCurrentBalance newProxyInstance;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private final MutableStateFlow<MyBillsUiState> getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private final MutableStateFlow<MyBillsUiState> PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private final MutableStateFlow<MyBillsUiState> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private final MutableStateFlow<List<BillPaymentStatusModel>> MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    public final StateFlow<MyBillsUiState> readMicros;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    public final StateFlow<MyBillsUiState> NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final MutableStateFlow<MyBillsUiState> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    public final StateFlow<MyBillsUiState> NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final StateFlow<List<BillPaymentStatusModel>> moveToNextValue;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private final UpdateSubscriptionBill SubSequence;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final CheckMyBillsVersionConfig NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public BillPaginationModel NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    public final StateFlow<MyBillsUiState> FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final GetGeneralProducts DatabaseTableConfigUtil;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    final GetInquirySubscriptionPaylaterWithDestination initRecordTimeStamp;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    public final StateFlow<MyBillsUiState> NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: readMicros  reason: from kotlin metadata */
    private final GetListHighlightMyBills NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final GetMonthlyWithConsultView NetworkUserEntityData$$ExternalSyntheticLambda8;

    @Inject
    public MyBillsViewModel(GetMonthlyWithConsultView getMonthlyWithConsultView, GetInquirySubscriptionPaylaterWithDestination getInquirySubscriptionPaylaterWithDestination, GetUserCurrentBalance getUserCurrentBalance, GetListHighlightMyBills getListHighlightMyBills, GetHighlightPayTransaction getHighlightPayTransaction, GetGeneralProducts getGeneralProducts, UpdateSubscriptionBill updateSubscriptionBill, DeleteSubscriptionBill deleteSubscriptionBill, CheckMyBillsVersionConfig checkMyBillsVersionConfig) {
        Intrinsics.checkNotNullParameter(getMonthlyWithConsultView, "");
        Intrinsics.checkNotNullParameter(getInquirySubscriptionPaylaterWithDestination, "");
        Intrinsics.checkNotNullParameter(getUserCurrentBalance, "");
        Intrinsics.checkNotNullParameter(getListHighlightMyBills, "");
        Intrinsics.checkNotNullParameter(getHighlightPayTransaction, "");
        Intrinsics.checkNotNullParameter(getGeneralProducts, "");
        Intrinsics.checkNotNullParameter(updateSubscriptionBill, "");
        Intrinsics.checkNotNullParameter(deleteSubscriptionBill, "");
        Intrinsics.checkNotNullParameter(checkMyBillsVersionConfig, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = getMonthlyWithConsultView;
        this.initRecordTimeStamp = getInquirySubscriptionPaylaterWithDestination;
        this.newProxyInstance = getUserCurrentBalance;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = getListHighlightMyBills;
        this.GetContactSyncConfig = getHighlightPayTransaction;
        this.DatabaseTableConfigUtil = getGeneralProducts;
        this.SubSequence = updateSubscriptionBill;
        this.lookAheadTest = deleteSubscriptionBill;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = checkMyBillsVersionConfig;
        MutableStateFlow<MyBillsUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(MyBillsUiState.None.INSTANCE);
        this.scheduleImpl = MutableStateFlow;
        this.readMicros = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<MyBillsUiState> MutableStateFlow2 = StateFlowKt.MutableStateFlow(MyBillsUiState.None.INSTANCE);
        this.BuiltInFictitiousFunctionClassFactory = MutableStateFlow2;
        this.FragmentBottomSheetPaymentSettingBinding = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<MyBillsUiState> MutableStateFlow3 = StateFlowKt.MutableStateFlow(MyBillsUiState.None.INSTANCE);
        this.PlaceComponentResult = MutableStateFlow3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = FlowKt.asStateFlow(MutableStateFlow3);
        this.getErrorConfigVersion = new BillPaginationModel();
        MutableStateFlow<MyBillsUiState> MutableStateFlow4 = StateFlowKt.MutableStateFlow(MyBillsUiState.None.INSTANCE);
        this.getAuthRequestContext = MutableStateFlow4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = FlowKt.asStateFlow(MutableStateFlow4);
        this.isLayoutRequested = new BillPaginationModel();
        MutableStateFlow<MyBillsUiState> MutableStateFlow5 = StateFlowKt.MutableStateFlow(MyBillsUiState.None.INSTANCE);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = MutableStateFlow5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = FlowKt.asStateFlow(MutableStateFlow5);
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new BillPaginationModel();
        MutableStateFlow<MyBillsUiState> MutableStateFlow6 = StateFlowKt.MutableStateFlow(MyBillsUiState.None.INSTANCE);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = MutableStateFlow6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = FlowKt.asStateFlow(MutableStateFlow6);
        this.PrepareContext = new BillPaginationModel();
        MutableStateFlow<List<BillPaymentStatusModel>> MutableStateFlow7 = StateFlowKt.MutableStateFlow(new ArrayList());
        this.MyBillsEntityDataFactory = MutableStateFlow7;
        this.moveToNextValue = FlowKt.asStateFlow(MutableStateFlow7);
    }

    public final void getAuthRequestContext(List<BillPaymentStatusModel> p0, boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        List<BillPaymentStatusModel> value = this.MyBillsEntityDataFactory.getValue();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(value);
        for (BillPaymentStatusModel billPaymentStatusModel : p0) {
            if (!arrayList.contains(billPaymentStatusModel) && p1) {
                arrayList.add(billPaymentStatusModel);
            } else if (arrayList.contains(billPaymentStatusModel) && !p1) {
                arrayList.remove(billPaymentStatusModel);
            }
        }
        MutableStateFlow<List<BillPaymentStatusModel>> mutableStateFlow = this.MyBillsEntityDataFactory;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), arrayList));
    }

    public final void MyBillsEntityDataFactory(final MonthlyAmountAndHighlightRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String dueType = p0.getDueType();
        switch (dueType.hashCode()) {
            case -1553882938:
                if (dueType.equals("DUE_SOON")) {
                    this.getErrorConfigVersion.setLoading(true);
                    MutableStateFlow<MyBillsUiState> mutableStateFlow = this.PlaceComponentResult;
                    do {
                    } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), MyBillsUiState.Loading.INSTANCE));
                }
                break;
            case 72206956:
                if (dueType.equals("LATER")) {
                    this.isLayoutRequested.setLoading(true);
                    MutableStateFlow<MyBillsUiState> mutableStateFlow2 = this.getAuthRequestContext;
                    do {
                    } while (!mutableStateFlow2.compareAndSet(mutableStateFlow2.getValue(), MyBillsUiState.Loading.INSTANCE));
                }
                break;
            case 474205716:
                if (dueType.equals("NEXT_MONTH")) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda7.setLoading(true);
                    MutableStateFlow<MyBillsUiState> mutableStateFlow3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    do {
                    } while (!mutableStateFlow3.compareAndSet(mutableStateFlow3.getValue(), MyBillsUiState.Loading.INSTANCE));
                }
                break;
            case 2000763943:
                if (dueType.equals("PAST_DUE")) {
                    this.PrepareContext.setLoading(true);
                    MutableStateFlow<MyBillsUiState> mutableStateFlow4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    do {
                    } while (!mutableStateFlow4.compareAndSet(mutableStateFlow4.getValue(), MyBillsUiState.Loading.INSTANCE));
                }
                break;
        }
        BaseFlowUseCase.execute$default(this.NetworkUserEntityData$$ExternalSyntheticLambda1, new MyBillsHighlightRequestModel(p0.getDivisionId(), p0.getGoodsType(), p0.getIpRoleId(), p0.getMerchantId(), p0.getNeedScheduleInfo(), p0.getRecurringType(), false, p0.getPageNum(), p0.getPageSize(), p0.getDueType(), 64, null), null, new Function1<MyBillsHighlight, Unit>() { // from class: id.dana.mybills.ui.v2.MyBillsViewModel$getConsultView$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MyBillsHighlight myBillsHighlight) {
                invoke2(myBillsHighlight);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MyBillsHighlight myBillsHighlight) {
                Intrinsics.checkNotNullParameter(myBillsHighlight, "");
                final List<BillSubscriptionHighlightModel> subscriptionHighlightViews = MonthlyHighlightBillModelKt.toMonthlyHighlightBillModel(myBillsHighlight).getSubscriptionHighlightViews();
                final MyBillsViewModel myBillsViewModel = MyBillsViewModel.this;
                MonthlyAmountAndHighlightRequest monthlyAmountAndHighlightRequest = p0;
                final boolean hasMore = myBillsHighlight.getHasMore();
                final String dueType2 = monthlyAmountAndHighlightRequest.getDueType();
                Intrinsics.checkNotNullParameter(subscriptionHighlightViews, "");
                Intrinsics.checkNotNullParameter(dueType2, "");
                GetInquirySubscriptionPaylaterWithDestination getInquirySubscriptionPaylaterWithDestination = myBillsViewModel.initRecordTimeStamp;
                List<BillSubscriptionHighlightModel> list = subscriptionHighlightViews;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (BillSubscriptionHighlightModel billSubscriptionHighlightModel : list) {
                    String goodsId = billSubscriptionHighlightModel.getGoodsId();
                    if (goodsId == null) {
                        goodsId = "";
                    }
                    String billId = billSubscriptionHighlightModel.getBillId();
                    if (billId == null) {
                        billId = "";
                    }
                    String goodsType = billSubscriptionHighlightModel.getGoodsType();
                    if (goodsType == null) {
                        goodsType = "";
                    }
                    arrayList.add(new GetInquirySubscriptionPaylaterWithDestination.Params(goodsId, billId, goodsType, billSubscriptionHighlightModel.getCanInquiry(), dueType2));
                }
                BaseFlowUseCase.execute$default(getInquirySubscriptionPaylaterWithDestination, arrayList, null, new Function1<List<? extends BizProductDestination>, Unit>() { // from class: id.dana.mybills.ui.v2.MyBillsViewModel$getInquiryCheckListSubscription$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(List<? extends BizProductDestination> list2) {
                        invoke2((List<BizProductDestination>) list2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(List<BizProductDestination> list2) {
                        MutableStateFlow mutableStateFlow5;
                        Object value;
                        MutableStateFlow mutableStateFlow6;
                        Object value2;
                        MutableStateFlow mutableStateFlow7;
                        Object value3;
                        MutableStateFlow mutableStateFlow8;
                        Object value4;
                        MutableStateFlow mutableStateFlow9;
                        Object value5;
                        BillSubscriptionHighlightModel copy;
                        Intrinsics.checkNotNullParameter(list2, "");
                        List<BillSubscriptionHighlightModel> list3 = subscriptionHighlightViews;
                        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                        for (BillSubscriptionHighlightModel billSubscriptionHighlightModel2 : list3) {
                            copy = billSubscriptionHighlightModel2.copy((r41 & 1) != 0 ? billSubscriptionHighlightModel2.subscriptionId : null, (r41 & 2) != 0 ? billSubscriptionHighlightModel2.actionRedirectUrl : null, (r41 & 4) != 0 ? billSubscriptionHighlightModel2.billId : null, (r41 & 8) != 0 ? billSubscriptionHighlightModel2.canBePaid : null, (r41 & 16) != 0 ? billSubscriptionHighlightModel2.goodsType : null, (r41 & 32) != 0 ? billSubscriptionHighlightModel2.iconUrl : null, (r41 & 64) != 0 ? billSubscriptionHighlightModel2.nextScheduleTime : null, (r41 & 128) != 0 ? billSubscriptionHighlightModel2.nextScheduleDaysCount : 0L, (r41 & 256) != 0 ? billSubscriptionHighlightModel2.subscriptionTitle : null, (r41 & 512) != 0 ? billSubscriptionHighlightModel2.totalAmount : MoneyViewModel.copy$default(billSubscriptionHighlightModel2.getTotalAmount(), BizProductDestinationKt.findItemAndReturnAmount(list2, billSubscriptionHighlightModel2.getBillId(), billSubscriptionHighlightModel2.getTotalAmount().getAmount()), billSubscriptionHighlightModel2.getTotalAmount().getCurrency(), null, 4, null), (r41 & 1024) != 0 ? billSubscriptionHighlightModel2.paidAmount : null, (r41 & 2048) != 0 ? billSubscriptionHighlightModel2.recurringType : null, (r41 & 4096) != 0 ? billSubscriptionHighlightModel2.goodsId : null, (r41 & 8192) != 0 ? billSubscriptionHighlightModel2.canInquiry : false, (r41 & 16384) != 0 ? billSubscriptionHighlightModel2.payStatus : null, (r41 & 32768) != 0 ? billSubscriptionHighlightModel2.section : null, (r41 & 65536) != 0 ? billSubscriptionHighlightModel2.bizProductDestination : BizProductDestinationKt.findBizProductDestination(list2, billSubscriptionHighlightModel2.getBillId()), (r41 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? billSubscriptionHighlightModel2.gmtDueDate : null, (r41 & 262144) != 0 ? billSubscriptionHighlightModel2.status : null, (r41 & 524288) != 0 ? billSubscriptionHighlightModel2.extInfo : null, (r41 & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? billSubscriptionHighlightModel2.paymentMethod : null, (r41 & 2097152) != 0 ? billSubscriptionHighlightModel2.lastPayStatus : null);
                            arrayList2.add(copy);
                        }
                        ArrayList arrayList3 = arrayList2;
                        String str = dueType2;
                        switch (str.hashCode()) {
                            case -1553882938:
                                if (str.equals("DUE_SOON")) {
                                    List<BillPaymentStatusModel> listBillPaymentStatusModel = BillPaymentAdapterModelKt.toListBillPaymentStatusModel(arrayList3, 0);
                                    myBillsViewModel.getErrorConfigVersion.getBills().addAll(listBillPaymentStatusModel);
                                    myBillsViewModel.getErrorConfigVersion.setHasMore(hasMore);
                                    myBillsViewModel.getErrorConfigVersion.setLoading(false);
                                    BillPaginationModel billPaginationModel = listBillPaymentStatusModel.isEmpty() ? new BillPaginationModel() : myBillsViewModel.getErrorConfigVersion;
                                    mutableStateFlow6 = myBillsViewModel.PlaceComponentResult;
                                    do {
                                        value2 = mutableStateFlow6.getValue();
                                        MyBillsUiState myBillsUiState = (MyBillsUiState) value2;
                                    } while (!mutableStateFlow6.compareAndSet(value2, new MyBillsUiState.Success(billPaginationModel)));
                                }
                                break;
                            case 72206956:
                                if (str.equals("LATER")) {
                                    List<BillPaymentStatusModel> listBillPaymentStatusModel2 = BillPaymentAdapterModelKt.toListBillPaymentStatusModel(arrayList3, 0);
                                    List<BillPaymentStatusModel> list4 = listBillPaymentStatusModel2;
                                    ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                                    Iterator<T> it = list4.iterator();
                                    while (it.hasNext()) {
                                        ((BillPaymentStatusModel) it.next()).setSelected(false);
                                        arrayList4.add(Unit.INSTANCE);
                                    }
                                    myBillsViewModel.isLayoutRequested.getBills().addAll(listBillPaymentStatusModel2);
                                    myBillsViewModel.isLayoutRequested.setHasMore(hasMore);
                                    myBillsViewModel.isLayoutRequested.setLoading(false);
                                    BillPaginationModel billPaginationModel2 = listBillPaymentStatusModel2.isEmpty() ? new BillPaginationModel() : myBillsViewModel.isLayoutRequested;
                                    mutableStateFlow7 = myBillsViewModel.getAuthRequestContext;
                                    do {
                                        value3 = mutableStateFlow7.getValue();
                                        MyBillsUiState myBillsUiState2 = (MyBillsUiState) value3;
                                    } while (!mutableStateFlow7.compareAndSet(value3, new MyBillsUiState.Success(billPaginationModel2)));
                                }
                                break;
                            case 474205716:
                                if (str.equals("NEXT_MONTH")) {
                                    List<BillPaymentStatusModel> listBillPaymentStatusModel3 = BillPaymentAdapterModelKt.toListBillPaymentStatusModel(arrayList3, 0);
                                    myBillsViewModel.NetworkUserEntityData$$ExternalSyntheticLambda7.getBills().addAll(listBillPaymentStatusModel3);
                                    myBillsViewModel.NetworkUserEntityData$$ExternalSyntheticLambda7.setHasMore(hasMore);
                                    myBillsViewModel.NetworkUserEntityData$$ExternalSyntheticLambda7.setLoading(false);
                                    BillPaginationModel billPaginationModel3 = listBillPaymentStatusModel3.isEmpty() ? new BillPaginationModel() : myBillsViewModel.NetworkUserEntityData$$ExternalSyntheticLambda7;
                                    mutableStateFlow8 = myBillsViewModel.KClassImpl$Data$declaredNonStaticMembers$2;
                                    do {
                                        value4 = mutableStateFlow8.getValue();
                                        MyBillsUiState myBillsUiState3 = (MyBillsUiState) value4;
                                    } while (!mutableStateFlow8.compareAndSet(value4, new MyBillsUiState.Success(billPaginationModel3)));
                                }
                                break;
                            case 2000763943:
                                if (str.equals("PAST_DUE")) {
                                    List<BillPaymentStatusModel> listBillPaymentStatusModel4 = BillPaymentAdapterModelKt.toListBillPaymentStatusModel(arrayList3, 0);
                                    myBillsViewModel.PrepareContext.getBills().addAll(listBillPaymentStatusModel4);
                                    myBillsViewModel.PrepareContext.setHasMore(hasMore);
                                    myBillsViewModel.PrepareContext.setLoading(false);
                                    BillPaginationModel billPaginationModel4 = listBillPaymentStatusModel4.isEmpty() ? new BillPaginationModel() : myBillsViewModel.PrepareContext;
                                    mutableStateFlow9 = myBillsViewModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
                                    do {
                                        value5 = mutableStateFlow9.getValue();
                                        MyBillsUiState myBillsUiState4 = (MyBillsUiState) value5;
                                    } while (!mutableStateFlow9.compareAndSet(value5, new MyBillsUiState.Success(billPaginationModel4)));
                                }
                                break;
                        }
                        mutableStateFlow5 = myBillsViewModel.scheduleImpl;
                        boolean z = hasMore;
                        do {
                            value = mutableStateFlow5.getValue();
                            MyBillsUiState myBillsUiState5 = (MyBillsUiState) value;
                        } while (!mutableStateFlow5.compareAndSet(value, new MyBillsUiState.OnSuccessGetInquirySubscriptionPaylaterWithDestination(arrayList3, z)));
                    }
                }, null, null, ViewModelKt.PlaceComponentResult(myBillsViewModel), 26, null);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.ui.v2.MyBillsViewModel$getConsultView$6
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                MutableStateFlow mutableStateFlow5;
                Object value;
                Intrinsics.checkNotNullParameter(th, "");
                String dueType2 = MonthlyAmountAndHighlightRequest.this.getDueType();
                switch (dueType2.hashCode()) {
                    case -1553882938:
                        if (dueType2.equals("DUE_SOON")) {
                            this.getErrorConfigVersion.setPageNum(r3.getPageNum() - 1);
                            this.getErrorConfigVersion.setLoading(false);
                            break;
                        }
                        break;
                    case 72206956:
                        if (dueType2.equals("LATER")) {
                            this.isLayoutRequested.setPageNum(r3.getPageNum() - 1);
                            this.isLayoutRequested.setLoading(false);
                            break;
                        }
                        break;
                    case 474205716:
                        if (dueType2.equals("NEXT_MONTH")) {
                            this.NetworkUserEntityData$$ExternalSyntheticLambda7.setPageNum(r3.getPageNum() - 1);
                            this.NetworkUserEntityData$$ExternalSyntheticLambda7.setLoading(false);
                            break;
                        }
                        break;
                    case 2000763943:
                        if (dueType2.equals("PAST_DUE")) {
                            this.PrepareContext.setPageNum(r3.getPageNum() - 1);
                            this.PrepareContext.setLoading(false);
                            break;
                        }
                        break;
                }
                mutableStateFlow5 = this.scheduleImpl;
                do {
                    value = mutableStateFlow5.getValue();
                    MyBillsUiState myBillsUiState = (MyBillsUiState) value;
                } while (!mutableStateFlow5.compareAndSet(value, MyBillsUiState.OnFailedGetConsultView.INSTANCE));
            }
        }, null, ViewModelKt.PlaceComponentResult(this), 18, null);
    }

    public final void PlaceComponentResult(UpdateSubscriptionRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MutableStateFlow<MyBillsUiState> mutableStateFlow = this.scheduleImpl;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), MyBillsUiState.Loading.INSTANCE));
        BaseFlowUseCase.execute$default(this.SubSequence, new UpdateSubscriptionBill.Params(p0), null, new Function1<UpdateSubscriptionResult, Unit>() { // from class: id.dana.mybills.ui.v2.MyBillsViewModel$updateSubscriptionBill$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UpdateSubscriptionResult updateSubscriptionResult) {
                invoke2(updateSubscriptionResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UpdateSubscriptionResult updateSubscriptionResult) {
                MutableStateFlow mutableStateFlow2;
                Object value;
                MutableStateFlow mutableStateFlow3;
                Object value2;
                Intrinsics.checkNotNullParameter(updateSubscriptionResult, "");
                mutableStateFlow2 = MyBillsViewModel.this.scheduleImpl;
                do {
                    value = mutableStateFlow2.getValue();
                    MyBillsUiState myBillsUiState = (MyBillsUiState) value;
                } while (!mutableStateFlow2.compareAndSet(value, MyBillsUiState.None.INSTANCE));
                mutableStateFlow3 = MyBillsViewModel.this.scheduleImpl;
                do {
                    value2 = mutableStateFlow3.getValue();
                    MyBillsUiState myBillsUiState2 = (MyBillsUiState) value2;
                } while (!mutableStateFlow3.compareAndSet(value2, new MyBillsUiState.OnSuccessUpdateSubscriptionBill(updateSubscriptionResult)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.ui.v2.MyBillsViewModel$updateSubscriptionBill$3
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
                MutableStateFlow mutableStateFlow2;
                Object value;
                Intrinsics.checkNotNullParameter(th, "");
                mutableStateFlow2 = MyBillsViewModel.this.scheduleImpl;
                do {
                    value = mutableStateFlow2.getValue();
                    MyBillsUiState myBillsUiState = (MyBillsUiState) value;
                } while (!mutableStateFlow2.compareAndSet(value, MyBillsUiState.None.INSTANCE));
            }
        }, null, ViewModelKt.PlaceComponentResult(this), 18, null);
    }

    public final void MyBillsEntityDataFactory() {
        this.MyBillsEntityDataFactory.setValue(new ArrayList());
        this.PlaceComponentResult.setValue(MyBillsUiState.None.INSTANCE);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setValue(MyBillsUiState.None.INSTANCE);
        this.KClassImpl$Data$declaredNonStaticMembers$2.setValue(MyBillsUiState.None.INSTANCE);
        this.getAuthRequestContext.setValue(MyBillsUiState.None.INSTANCE);
        this.getErrorConfigVersion = new BillPaginationModel();
        this.isLayoutRequested = new BillPaginationModel();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new BillPaginationModel();
        this.PrepareContext = new BillPaginationModel();
    }
}

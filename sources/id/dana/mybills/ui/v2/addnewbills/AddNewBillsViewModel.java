package id.dana.mybills.ui.v2.addnewbills;

import androidx.view.ViewModel;
import androidx.view.ViewModelKt;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.services.interactor.GetServicesWithCategory;
import id.dana.domain.services.model.ThirdPartyCategoryService;
import id.dana.domain.user.CurrencyAmount;
import id.dana.domain.usereducation.interactor.GetBottomSheetOnBoardingFlow;
import id.dana.domain.usereducation.interactor.SaveDisplayBottomSheetOnBoardingFlow;
import id.dana.mybills.data.model.request.UniqueValueRequest;
import id.dana.mybills.domain.interactor.CheckBillsUniqueValue;
import id.dana.mybills.domain.interactor.CheckUniqueValueAndInquiry;
import id.dana.mybills.domain.interactor.GetBizProductOrder;
import id.dana.mybills.domain.interactor.GetGeneralProducts;
import id.dana.mybills.domain.interactor.GetHighlightPayTransaction;
import id.dana.mybills.domain.interactor.GetProductMobileRecharge;
import id.dana.mybills.domain.interactor.GetQuickBuyMyBills;
import id.dana.mybills.domain.interactor.GetUserCurrentBalance;
import id.dana.mybills.domain.interactor.MyBillsDateRange;
import id.dana.mybills.domain.interactor.SaveSubscription;
import id.dana.mybills.domain.interactor.SubscriptionQueryById;
import id.dana.mybills.domain.interactor.ValidateFormUseCase;
import id.dana.mybills.domain.model.BizProductDestination;
import id.dana.mybills.domain.model.CheckUniqueValue;
import id.dana.mybills.domain.model.CheckUniqueValueAndInquiryResult;
import id.dana.mybills.domain.model.ConfigInfoRangeDate;
import id.dana.mybills.domain.model.CreateSubscription;
import id.dana.mybills.domain.model.CreateSubscriptionKt;
import id.dana.mybills.domain.model.FormModel;
import id.dana.mybills.domain.model.HighlightTransactionPay;
import id.dana.mybills.domain.model.HighlightTransactionPayKt;
import id.dana.mybills.domain.model.ProductGoodsInfo;
import id.dana.mybills.domain.model.ProductProviderInfo;
import id.dana.mybills.domain.model.ProductProviderInfoKt;
import id.dana.mybills.domain.model.ProductQueryRequest;
import id.dana.mybills.domain.model.QuerySubscription;
import id.dana.mybills.domain.model.RangeDateConfig;
import id.dana.mybills.ui.constant.BizProductCode;
import id.dana.mybills.ui.mapper.MoneyModelMapperKt;
import id.dana.mybills.ui.mapper.ServiceItemMapper;
import id.dana.mybills.ui.model.HighlightTransactionPayRequestModel;
import id.dana.mybills.ui.model.HighlightTransactionPayRequestModelKt;
import id.dana.mybills.ui.model.SaveMyBillsSubscriptionModel;
import id.dana.mybills.ui.model.SaveSubscriptionRequestModel;
import id.dana.mybills.ui.model.SaveSubscriptionRequestModelKt;
import id.dana.mybills.ui.model.service.ThirdPartyService;
import id.dana.mybills.ui.v2.addnewbills.AddNewBillsUiState;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 ^2\u00020\u0001:\u0001^B\u0089\u0001\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020>\u0012\u0006\u0010\u0004\u001a\u000209\u0012\u0006\u0010\u0005\u001a\u00020D\u0012\u0006\u0010O\u001a\u00020+\u0012\u0006\u0010P\u001a\u00020G\u0012\u0006\u0010Q\u001a\u00020\"\u0012\u0006\u0010R\u001a\u000200\u0012\u0006\u0010S\u001a\u000203\u0012\u0006\u0010T\u001a\u000207\u0012\u0006\u0010U\u001a\u00020(\u0012\u0006\u0010V\u001a\u00020;\u0012\u0006\u0010W\u001a\u00020-\u0012\u0006\u0010X\u001a\u00020L\u0012\u0006\u0010Y\u001a\u00020%\u0012\u0006\u0010Z\u001a\u00020J\u0012\u0006\u0010[\u001a\u00020A¢\u0006\u0004\b\\\u0010]J%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\fJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\fJ\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0002¢\u0006\u0004\b\t\u0010\u000eJ\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\u000fJ\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0010¢\u0006\u0004\b\u0007\u0010\u0011J\u001d\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0013¢\u0006\u0004\b\t\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\fJ\u0015\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0016¢\u0006\u0004\b\u0015\u0010\u0017J\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0018¢\u0006\u0004\b\t\u0010\u0019R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00160\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00160 X\u0006¢\u0006\u0006\n\u0004\b\t\u0010!R\u0014\u0010\u0015\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010\u000b\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010&\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010\u001e\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010,R\u0014\u0010#\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u0010\u001b\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010)\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u00108R\u0014\u00101\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010:R\u0014\u00104\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010.\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010<\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010F\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010ER\u0014\u0010B\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010?\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010KR\u0017\u0010H\u001a\b\u0012\u0004\u0012\u00020\u001d0 X\u0006¢\u0006\u0006\n\u0004\b6\u0010!R\u0014\u0010M\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010N"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsViewModel;", "Landroidx/lifecycle/ViewModel;", "", "p0", "p1", "p2", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "PlaceComponentResult", "(Ljava/lang/String;)V", "", "()Ljava/util/List;", "()V", "Lid/dana/mybills/ui/model/HighlightTransactionPayRequestModel;", "(Lid/dana/mybills/ui/model/HighlightTransactionPayRequestModel;)V", "Lid/dana/mybills/ui/model/SaveSubscriptionRequestModel;", "", "(Lid/dana/mybills/ui/model/SaveSubscriptionRequestModel;Z)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/mybills/ui/v2/addnewbills/AddToMyBillsState;", "(Lid/dana/mybills/ui/v2/addnewbills/AddToMyBillsState;)V", "Lid/dana/mybills/domain/model/FormModel;", "(Lid/dana/mybills/domain/model/FormModel;)V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "lookAheadTest", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getAuthRequestContext", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "Lid/dana/mybills/domain/interactor/CheckBillsUniqueValue;", "getErrorConfigVersion", "Lid/dana/mybills/domain/interactor/CheckBillsUniqueValue;", "Lid/dana/mybills/domain/interactor/CheckUniqueValueAndInquiry;", "scheduleImpl", "Lid/dana/mybills/domain/interactor/CheckUniqueValueAndInquiry;", "Lid/dana/mybills/domain/interactor/GetBizProductOrder;", "initRecordTimeStamp", "Lid/dana/mybills/domain/interactor/GetBizProductOrder;", "Lid/dana/domain/usereducation/interactor/GetBottomSheetOnBoardingFlow;", "Lid/dana/domain/usereducation/interactor/GetBottomSheetOnBoardingFlow;", "Lid/dana/mybills/domain/interactor/GetGeneralProducts;", "DatabaseTableConfigUtil", "Lid/dana/mybills/domain/interactor/GetGeneralProducts;", "Lid/dana/mybills/domain/interactor/GetHighlightPayTransaction;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/mybills/domain/interactor/GetHighlightPayTransaction;", "Lid/dana/mybills/domain/interactor/GetProductMobileRecharge;", "GetContactSyncConfig", "Lid/dana/mybills/domain/interactor/GetProductMobileRecharge;", "moveToNextValue", "Lid/dana/mybills/domain/interactor/GetQuickBuyMyBills;", "Lid/dana/mybills/domain/interactor/GetQuickBuyMyBills;", "Lid/dana/domain/services/interactor/GetServicesWithCategory;", "Lid/dana/domain/services/interactor/GetServicesWithCategory;", "Lid/dana/mybills/domain/interactor/GetUserCurrentBalance;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/mybills/domain/interactor/GetUserCurrentBalance;", "Lid/dana/mybills/ui/mapper/ServiceItemMapper;", "isLayoutRequested", "Lid/dana/mybills/ui/mapper/ServiceItemMapper;", "Lid/dana/mybills/domain/interactor/MyBillsDateRange;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/mybills/domain/interactor/MyBillsDateRange;", "Lid/dana/domain/usereducation/interactor/SaveDisplayBottomSheetOnBoardingFlow;", "Lid/dana/domain/usereducation/interactor/SaveDisplayBottomSheetOnBoardingFlow;", "PrepareContext", "Lid/dana/mybills/domain/interactor/SaveSubscription;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/mybills/domain/interactor/SaveSubscription;", "Lid/dana/mybills/domain/interactor/SubscriptionQueryById;", "Lid/dana/mybills/domain/interactor/SubscriptionQueryById;", "Lid/dana/mybills/domain/interactor/ValidateFormUseCase;", "newProxyInstance", "Lid/dana/mybills/domain/interactor/ValidateFormUseCase;", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "<init>", "(Lid/dana/mybills/ui/mapper/ServiceItemMapper;Lid/dana/domain/services/interactor/GetServicesWithCategory;Lid/dana/domain/usereducation/interactor/SaveDisplayBottomSheetOnBoardingFlow;Lid/dana/domain/usereducation/interactor/GetBottomSheetOnBoardingFlow;Lid/dana/mybills/domain/interactor/SaveSubscription;Lid/dana/mybills/domain/interactor/CheckBillsUniqueValue;Lid/dana/mybills/domain/interactor/GetHighlightPayTransaction;Lid/dana/mybills/domain/interactor/GetProductMobileRecharge;Lid/dana/mybills/domain/interactor/GetQuickBuyMyBills;Lid/dana/mybills/domain/interactor/GetBizProductOrder;Lid/dana/mybills/domain/interactor/GetUserCurrentBalance;Lid/dana/mybills/domain/interactor/GetGeneralProducts;Lid/dana/mybills/domain/interactor/ValidateFormUseCase;Lid/dana/mybills/domain/interactor/CheckUniqueValueAndInquiry;Lid/dana/mybills/domain/interactor/SubscriptionQueryById;Lid/dana/mybills/domain/interactor/MyBillsDateRange;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AddNewBillsViewModel extends ViewModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final StateFlow<AddToMyBillsState> MyBillsEntityDataFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final GetGeneralProducts getErrorConfigVersion;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final GetProductMobileRecharge moveToNextValue;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final GetBottomSheetOnBoardingFlow NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final SaveDisplayBottomSheetOnBoardingFlow PrepareContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final MutableStateFlow<AddNewBillsUiState> getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final GetUserCurrentBalance GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final GetHighlightPayTransaction lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final MyBillsDateRange NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private final SaveSubscription NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final GetQuickBuyMyBills initRecordTimeStamp;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final SubscriptionQueryById isLayoutRequested;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final GetServicesWithCategory NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final CheckBillsUniqueValue KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final GetBizProductOrder scheduleImpl;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private final ServiceItemMapper DatabaseTableConfigUtil;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final MutableStateFlow<AddToMyBillsState> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final StateFlow<AddNewBillsUiState> NetworkUserEntityData$$ExternalSyntheticLambda8;
    private final ValidateFormUseCase newProxyInstance;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final CheckUniqueValueAndInquiry PlaceComponentResult;

    @Inject
    public AddNewBillsViewModel(ServiceItemMapper serviceItemMapper, GetServicesWithCategory getServicesWithCategory, SaveDisplayBottomSheetOnBoardingFlow saveDisplayBottomSheetOnBoardingFlow, GetBottomSheetOnBoardingFlow getBottomSheetOnBoardingFlow, SaveSubscription saveSubscription, CheckBillsUniqueValue checkBillsUniqueValue, GetHighlightPayTransaction getHighlightPayTransaction, GetProductMobileRecharge getProductMobileRecharge, GetQuickBuyMyBills getQuickBuyMyBills, GetBizProductOrder getBizProductOrder, GetUserCurrentBalance getUserCurrentBalance, GetGeneralProducts getGeneralProducts, ValidateFormUseCase validateFormUseCase, CheckUniqueValueAndInquiry checkUniqueValueAndInquiry, SubscriptionQueryById subscriptionQueryById, MyBillsDateRange myBillsDateRange) {
        Intrinsics.checkNotNullParameter(serviceItemMapper, "");
        Intrinsics.checkNotNullParameter(getServicesWithCategory, "");
        Intrinsics.checkNotNullParameter(saveDisplayBottomSheetOnBoardingFlow, "");
        Intrinsics.checkNotNullParameter(getBottomSheetOnBoardingFlow, "");
        Intrinsics.checkNotNullParameter(saveSubscription, "");
        Intrinsics.checkNotNullParameter(checkBillsUniqueValue, "");
        Intrinsics.checkNotNullParameter(getHighlightPayTransaction, "");
        Intrinsics.checkNotNullParameter(getProductMobileRecharge, "");
        Intrinsics.checkNotNullParameter(getQuickBuyMyBills, "");
        Intrinsics.checkNotNullParameter(getBizProductOrder, "");
        Intrinsics.checkNotNullParameter(getUserCurrentBalance, "");
        Intrinsics.checkNotNullParameter(getGeneralProducts, "");
        Intrinsics.checkNotNullParameter(validateFormUseCase, "");
        Intrinsics.checkNotNullParameter(checkUniqueValueAndInquiry, "");
        Intrinsics.checkNotNullParameter(subscriptionQueryById, "");
        Intrinsics.checkNotNullParameter(myBillsDateRange, "");
        this.DatabaseTableConfigUtil = serviceItemMapper;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = getServicesWithCategory;
        this.PrepareContext = saveDisplayBottomSheetOnBoardingFlow;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = getBottomSheetOnBoardingFlow;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = saveSubscription;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = checkBillsUniqueValue;
        this.lookAheadTest = getHighlightPayTransaction;
        this.moveToNextValue = getProductMobileRecharge;
        this.initRecordTimeStamp = getQuickBuyMyBills;
        this.scheduleImpl = getBizProductOrder;
        this.GetContactSyncConfig = getUserCurrentBalance;
        this.getErrorConfigVersion = getGeneralProducts;
        this.newProxyInstance = validateFormUseCase;
        this.PlaceComponentResult = checkUniqueValueAndInquiry;
        this.isLayoutRequested = subscriptionQueryById;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = myBillsDateRange;
        MutableStateFlow<AddNewBillsUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(AddNewBillsUiState.None.INSTANCE);
        this.getAuthRequestContext = MutableStateFlow;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<AddToMyBillsState> MutableStateFlow2 = StateFlowKt.MutableStateFlow(new AddToMyBillsState(false, null, null, null, 15, null));
        this.BuiltInFictitiousFunctionClassFactory = MutableStateFlow2;
        this.MyBillsEntityDataFactory = FlowKt.asStateFlow(MutableStateFlow2);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(AddToMyBillsState p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MutableStateFlow<AddToMyBillsState> mutableStateFlow = this.BuiltInFictitiousFunctionClassFactory;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), p0));
    }

    public final void BuiltInFictitiousFunctionClassFactory(final SaveSubscriptionRequestModel p0, final boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        MutableStateFlow<AddNewBillsUiState> mutableStateFlow = this.getAuthRequestContext;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), AddNewBillsUiState.Loading.INSTANCE));
        BaseFlowUseCase.execute$default(this.NetworkUserEntityData$$ExternalSyntheticLambda7, new SaveSubscription.Params(SaveSubscriptionRequestModelKt.toCreateSubscriptionRequest(p0)), null, new Function1<CreateSubscription, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$saveMyBillsSubscription$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CreateSubscription createSubscription) {
                invoke2(createSubscription);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CreateSubscription createSubscription) {
                MutableStateFlow mutableStateFlow2;
                Object value;
                MutableStateFlow mutableStateFlow3;
                Object value2;
                Intrinsics.checkNotNullParameter(createSubscription, "");
                SaveMyBillsSubscriptionModel saveMyBillsSubscriptionModel = CreateSubscriptionKt.toSaveMyBillsSubscriptionModel(createSubscription);
                mutableStateFlow2 = AddNewBillsViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow2.getValue();
                    AddNewBillsUiState addNewBillsUiState = (AddNewBillsUiState) value;
                } while (!mutableStateFlow2.compareAndSet(value, AddNewBillsUiState.None.INSTANCE));
                String recurringType = p0.getRecurringType();
                saveMyBillsSubscriptionModel.setRecurringType(recurringType != null ? recurringType : "");
                mutableStateFlow3 = AddNewBillsViewModel.this.getAuthRequestContext;
                boolean z = p1;
                do {
                    value2 = mutableStateFlow3.getValue();
                    AddNewBillsUiState addNewBillsUiState2 = (AddNewBillsUiState) value2;
                } while (!mutableStateFlow3.compareAndSet(value2, new AddNewBillsUiState.OnSuccessSaveMyBills(saveMyBillsSubscriptionModel, z)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$saveMyBillsSubscription$3
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
                MutableStateFlow mutableStateFlow3;
                Object value2;
                String message;
                Intrinsics.checkNotNullParameter(th, "");
                mutableStateFlow2 = AddNewBillsViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow2.getValue();
                    AddNewBillsUiState addNewBillsUiState = (AddNewBillsUiState) value;
                } while (!mutableStateFlow2.compareAndSet(value, AddNewBillsUiState.None.INSTANCE));
                mutableStateFlow3 = AddNewBillsViewModel.this.getAuthRequestContext;
                do {
                    value2 = mutableStateFlow3.getValue();
                    AddNewBillsUiState addNewBillsUiState2 = (AddNewBillsUiState) value2;
                    message = th.getMessage();
                    if (message == null) {
                        message = "";
                    }
                } while (!mutableStateFlow3.compareAndSet(value2, new AddNewBillsUiState.OnErrorSaveMyBills(message)));
            }
        }, null, ViewModelKt.PlaceComponentResult(this), 18, null);
    }

    public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        BaseFlowUseCase.execute$default(this.KClassImpl$Data$declaredNonStaticMembers$2, new CheckBillsUniqueValue.Params(new UniqueValueRequest(null, p0, p1, 1, null)), null, new Function1<CheckUniqueValue, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$checkUniqueValues$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CheckUniqueValue checkUniqueValue) {
                invoke2(checkUniqueValue);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CheckUniqueValue checkUniqueValue) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(checkUniqueValue, "");
                boolean z = checkUniqueValue.getAutodeductionCount() > 0 || checkUniqueValue.getReminderCount() > 0;
                CheckUniqueValue.SubscriptionItem subscriptionItem = (CheckUniqueValue.SubscriptionItem) CollectionsKt.firstOrNull((List) checkUniqueValue.getSubscriptionItem());
                String subscriptionId = subscriptionItem != null ? subscriptionItem.getSubscriptionId() : null;
                mutableStateFlow = AddNewBillsViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    AddNewBillsUiState addNewBillsUiState = (AddNewBillsUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new AddNewBillsUiState.OnBillHasActiveBills(z, subscriptionId)));
            }
        }, null, null, ViewModelKt.PlaceComponentResult(this), 26, null);
    }

    public final void MyBillsEntityDataFactory(HighlightTransactionPayRequestModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        BaseFlowUseCase.execute$default(this.lookAheadTest, new GetHighlightPayTransaction.Params(CollectionsKt.listOf(HighlightTransactionPayRequestModelKt.toHighlightTransactionPayRequest(p0)), true), null, new Function1<List<? extends HighlightTransactionPay>, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$paySingleMyBillSubscription$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends HighlightTransactionPay> list) {
                invoke2((List<HighlightTransactionPay>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<HighlightTransactionPay> list) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(list, "");
                mutableStateFlow = AddNewBillsViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    AddNewBillsUiState addNewBillsUiState = (AddNewBillsUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new AddNewBillsUiState.OnSuccessGetPayTransaction(HighlightTransactionPayKt.toHighlighTransactionPayModel((HighlightTransactionPay) CollectionsKt.first((List) list)))));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$paySingleMyBillSubscription$2
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
                String message = th.getMessage();
                if (message != null) {
                    mutableStateFlow = AddNewBillsViewModel.this.getAuthRequestContext;
                    do {
                        value = mutableStateFlow.getValue();
                        AddNewBillsUiState addNewBillsUiState = (AddNewBillsUiState) value;
                    } while (!mutableStateFlow.compareAndSet(value, new AddNewBillsUiState.OnErrorGetPayTransaction(message)));
                }
            }
        }, null, ViewModelKt.PlaceComponentResult(this), 18, null);
    }

    public final void MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MutableStateFlow<AddNewBillsUiState> mutableStateFlow = this.getAuthRequestContext;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), AddNewBillsUiState.OnLoadingGetProduct.INSTANCE));
        BaseFlowUseCase.execute$default(this.moveToNextValue, new GetProductMobileRecharge.Params(new ProductQueryRequest("PULSA_PREPAID", p0)), null, new Function1<ProductProviderInfo, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$getMobileRechargeProduct$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ProductProviderInfo productProviderInfo) {
                invoke2(productProviderInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ProductProviderInfo productProviderInfo) {
                MutableStateFlow mutableStateFlow2;
                Object value;
                MutableStateFlow mutableStateFlow3;
                Object value2;
                Intrinsics.checkNotNullParameter(productProviderInfo, "");
                mutableStateFlow2 = AddNewBillsViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow2.getValue();
                    AddNewBillsUiState addNewBillsUiState = (AddNewBillsUiState) value;
                } while (!mutableStateFlow2.compareAndSet(value, AddNewBillsUiState.None.INSTANCE));
                mutableStateFlow3 = AddNewBillsViewModel.this.getAuthRequestContext;
                do {
                    value2 = mutableStateFlow3.getValue();
                    AddNewBillsUiState addNewBillsUiState2 = (AddNewBillsUiState) value2;
                } while (!mutableStateFlow3.compareAndSet(value2, new AddNewBillsUiState.OnSuccessGetMobileRechargeProduct(ProductProviderInfoKt.toMobileRechargeProductModel(productProviderInfo))));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$getMobileRechargeProduct$3
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
                MutableStateFlow mutableStateFlow3;
                Object value2;
                String message;
                Intrinsics.checkNotNullParameter(th, "");
                mutableStateFlow2 = AddNewBillsViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow2.getValue();
                    AddNewBillsUiState addNewBillsUiState = (AddNewBillsUiState) value;
                } while (!mutableStateFlow2.compareAndSet(value, AddNewBillsUiState.None.INSTANCE));
                mutableStateFlow3 = AddNewBillsViewModel.this.getAuthRequestContext;
                do {
                    value2 = mutableStateFlow3.getValue();
                    AddNewBillsUiState addNewBillsUiState2 = (AddNewBillsUiState) value2;
                    message = th.getMessage();
                    if (message == null) {
                        message = "";
                    }
                } while (!mutableStateFlow3.compareAndSet(value2, new AddNewBillsUiState.OnErrorGetProduct(message)));
            }
        }, null, ViewModelKt.PlaceComponentResult(this), 18, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> BuiltInFictitiousFunctionClassFactory() {
        return CollectionsKt.listOf((Object[]) new String[]{"MOBILE_RECHARGE_PHONE_NUMBER_LIST", "TELCO_POST_LAST_RECHARGE_ID", "INTERNET_LAST_RECHARGE_ID", "INSTALLMENT_LAST_RECHARGE_ID", "PHONE_LAST_RECHARGE_ID", "PGN_LAST_RECHARGE_ID", "TELCO_ROAMING_LAST_RECHARGE_ID", "ELECTRICITY_PLN_LAST_RECHARGE_ID", "ELECTRICITY_POST_PLN_LAST_RECHARGE_ID", "WATER_PDAM_PALYJA_LAST_RECHARGE_ID", "WATER_PDAM_KOTA_BOGOR_LAST_RECHARGE_ID", "WATER_PDAM_AETRA_LAST_RECHARGE_ID"});
    }

    public final void MyBillsEntityDataFactory() {
        BaseFlowUseCase.execute$default(this.GetContactSyncConfig, NoParams.INSTANCE, null, new Function1<CurrencyAmount, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$getUserCurrentBalance$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CurrencyAmount currencyAmount) {
                invoke2(currencyAmount);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CurrencyAmount currencyAmount) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(currencyAmount, "");
                mutableStateFlow = AddNewBillsViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    AddNewBillsUiState addNewBillsUiState = (AddNewBillsUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new AddNewBillsUiState.OnSuccessGetCurrentBalance(MoneyModelMapperKt.MyBillsEntityDataFactory(currencyAmount))));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$getUserCurrentBalance$2
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

    /* JADX WARN: Type inference failed for: r2v4, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    public final void PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MutableStateFlow<AddNewBillsUiState> mutableStateFlow = this.getAuthRequestContext;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), AddNewBillsUiState.OnLoadingGetProduct.INSTANCE));
        ?? r2 = 0;
        BaseFlowUseCase.execute$default(this.getErrorConfigVersion, new GetGeneralProducts.Params(new ProductQueryRequest(p0, r2, 2, r2)), null, new Function1<List<? extends ProductGoodsInfo>, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$getGeneralProducts$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends ProductGoodsInfo> list) {
                invoke2((List<ProductGoodsInfo>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<ProductGoodsInfo> list) {
                MutableStateFlow mutableStateFlow2;
                Object value;
                MutableStateFlow mutableStateFlow3;
                Object value2;
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(list, "");
                mutableStateFlow2 = AddNewBillsViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow2.getValue();
                    AddNewBillsUiState addNewBillsUiState = (AddNewBillsUiState) value;
                } while (!mutableStateFlow2.compareAndSet(value, AddNewBillsUiState.None.INSTANCE));
                mutableStateFlow3 = AddNewBillsViewModel.this.getAuthRequestContext;
                do {
                    value2 = mutableStateFlow3.getValue();
                    AddNewBillsUiState addNewBillsUiState2 = (AddNewBillsUiState) value2;
                    arrayList = new ArrayList();
                    for (Object obj : list) {
                        if (Intrinsics.areEqual(((ProductGoodsInfo) obj).getAvailable(), Boolean.TRUE)) {
                            arrayList.add(obj);
                        }
                    }
                } while (!mutableStateFlow3.compareAndSet(value2, new AddNewBillsUiState.OnSuccessGetGeneralProduct(arrayList)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$getGeneralProducts$3
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
                MutableStateFlow mutableStateFlow3;
                Object value2;
                String message;
                Intrinsics.checkNotNullParameter(th, "");
                mutableStateFlow2 = AddNewBillsViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow2.getValue();
                    AddNewBillsUiState addNewBillsUiState = (AddNewBillsUiState) value;
                } while (!mutableStateFlow2.compareAndSet(value, AddNewBillsUiState.None.INSTANCE));
                mutableStateFlow3 = AddNewBillsViewModel.this.getAuthRequestContext;
                do {
                    value2 = mutableStateFlow3.getValue();
                    AddNewBillsUiState addNewBillsUiState2 = (AddNewBillsUiState) value2;
                    message = th.getMessage();
                    if (message == null) {
                        message = "";
                    }
                } while (!mutableStateFlow3.compareAndSet(value2, new AddNewBillsUiState.OnErrorGetProduct(message)));
            }
        }, null, ViewModelKt.PlaceComponentResult(this), 18, null);
    }

    public final void BuiltInFictitiousFunctionClassFactory(FormModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        BaseFlowUseCase.execute$default(this.newProxyInstance, new ValidateFormUseCase.Params(p0), null, new Function1<Map<String, ? extends String>, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$validateForm$1
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
                mutableStateFlow = AddNewBillsViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    AddNewBillsUiState addNewBillsUiState = (AddNewBillsUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new AddNewBillsUiState.OnValidationFormResult(map)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$validateForm$2
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

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        BaseFlowUseCase.execute$default(this.isLayoutRequested, new SubscriptionQueryById.Params(p0), null, new Function1<QuerySubscription, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$subscriptionQueryById$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(QuerySubscription querySubscription) {
                invoke2(querySubscription);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(QuerySubscription querySubscription) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(querySubscription, "");
                mutableStateFlow = AddNewBillsViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    AddNewBillsUiState addNewBillsUiState = (AddNewBillsUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new AddNewBillsUiState.OnSuccessGetSubscriptionQueryById(querySubscription)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$subscriptionQueryById$2
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

    public final void MyBillsEntityDataFactory(String p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        CheckUniqueValueAndInquiry checkUniqueValueAndInquiry = this.PlaceComponentResult;
        int hashCode = p2.hashCode();
        if (hashCode != 79159) {
            if (hashCode != 2045463) {
                if (hashCode == 197254559 && p2.equals(BizProductCode.TELKOM)) {
                    p0 = "dana_telkom_phone_1";
                }
            } else if (p2.equals("BPJS")) {
                p0 = "dana_bpjs_kesehatan_1";
            }
        } else if (p2.equals("PGN")) {
            p0 = "dana_pgn_2";
        }
        BaseFlowUseCase.execute$default(checkUniqueValueAndInquiry, new CheckUniqueValueAndInquiry.Params(p1, p2, p0), null, new Function1<CheckUniqueValueAndInquiryResult, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$checkUniqueValueAndCheckInquiry$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CheckUniqueValueAndInquiryResult checkUniqueValueAndInquiryResult) {
                invoke2(checkUniqueValueAndInquiryResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CheckUniqueValueAndInquiryResult checkUniqueValueAndInquiryResult) {
                MutableStateFlow mutableStateFlow;
                Object value;
                String subscriptionId;
                boolean isInquirySuccess;
                boolean isEmpty;
                BizProductDestination product;
                String inquiryCode;
                MutableStateFlow mutableStateFlow2;
                Object value2;
                String inquiryMessage;
                Object m3179constructorimpl;
                Intrinsics.checkNotNullParameter(checkUniqueValueAndInquiryResult, "");
                if (!checkUniqueValueAndInquiryResult.getProduct().isInquirySuccess()) {
                    String inquiryMessage2 = checkUniqueValueAndInquiryResult.getProduct().getInquiryMessage();
                    if (!(inquiryMessage2 == null || StringsKt.isBlank(inquiryMessage2))) {
                        mutableStateFlow2 = AddNewBillsViewModel.this.getAuthRequestContext;
                        do {
                            value2 = mutableStateFlow2.getValue();
                            AddNewBillsUiState addNewBillsUiState = (AddNewBillsUiState) value2;
                            inquiryMessage = checkUniqueValueAndInquiryResult.getProduct().getInquiryMessage();
                            if (inquiryMessage == null) {
                                inquiryMessage = "";
                            }
                            try {
                                Result.Companion companion = Result.INSTANCE;
                                String inquiryCode2 = checkUniqueValueAndInquiryResult.getProduct().getInquiryCode();
                                m3179constructorimpl = Result.m3179constructorimpl(Integer.valueOf(inquiryCode2 != null ? Integer.parseInt(inquiryCode2) : -1));
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.INSTANCE;
                                m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th));
                            }
                            if (Result.m3185isFailureimpl(m3179constructorimpl)) {
                                m3179constructorimpl = -1;
                            }
                        } while (!mutableStateFlow2.compareAndSet(value2, new AddNewBillsUiState.OnErrorGetInquiry(inquiryMessage, ((Number) m3179constructorimpl).intValue())));
                    }
                }
                mutableStateFlow = AddNewBillsViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    AddNewBillsUiState addNewBillsUiState2 = (AddNewBillsUiState) value;
                    CheckUniqueValue.SubscriptionItem subscriptionItem = (CheckUniqueValue.SubscriptionItem) CollectionsKt.firstOrNull((List) checkUniqueValueAndInquiryResult.getQueryUniqueValue().getSubscriptionItem());
                    subscriptionId = subscriptionItem != null ? subscriptionItem.getSubscriptionId() : null;
                    isInquirySuccess = checkUniqueValueAndInquiryResult.getProduct().isInquirySuccess();
                    isEmpty = checkUniqueValueAndInquiryResult.getQueryUniqueValue().getSubscriptionItem().isEmpty();
                    product = checkUniqueValueAndInquiryResult.getProduct();
                    inquiryCode = checkUniqueValueAndInquiryResult.getProduct().getInquiryCode();
                } while (!mutableStateFlow.compareAndSet(value, new AddNewBillsUiState.OnSuccessCheckUniqueValueAndCheckInquiry(subscriptionId, !isEmpty, isInquirySuccess, product, inquiryCode == null ? "" : inquiryCode)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$checkUniqueValueAndCheckInquiry$2
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
                String message = th.getMessage();
                if (message != null) {
                    mutableStateFlow = AddNewBillsViewModel.this.getAuthRequestContext;
                    do {
                        value = mutableStateFlow.getValue();
                        AddNewBillsUiState addNewBillsUiState = (AddNewBillsUiState) value;
                    } while (!mutableStateFlow.compareAndSet(value, new AddNewBillsUiState.OnErrorGetInquiry(message, 0, 2, null)));
                }
            }
        }, null, ViewModelKt.PlaceComponentResult(this), 18, null);
    }

    public final void BuiltInFictitiousFunctionClassFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        BaseFlowUseCase.execute$default(this.NetworkUserEntityData$$ExternalSyntheticLambda1, NoParams.INSTANCE, null, new Function1<ConfigInfoRangeDate, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$getMyBillsDateRange$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ConfigInfoRangeDate configInfoRangeDate) {
                invoke2(configInfoRangeDate);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ConfigInfoRangeDate configInfoRangeDate) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(configInfoRangeDate, "");
                mutableStateFlow = AddNewBillsViewModel.this.getAuthRequestContext;
                String str = p0;
                do {
                    value = mutableStateFlow.getValue();
                    AddNewBillsUiState addNewBillsUiState = (AddNewBillsUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new AddNewBillsUiState.OnSuccessGetMyBillsDateRange(AddNewBillsViewModel.BuiltInFictitiousFunctionClassFactory(configInfoRangeDate, str))));
            }
        }, null, null, ViewModelKt.PlaceComponentResult(this), 26, null);
    }

    public static final /* synthetic */ IntRange BuiltInFictitiousFunctionClassFactory(ConfigInfoRangeDate configInfoRangeDate, String str) {
        Object obj;
        Iterator<T> it = configInfoRangeDate.getListRangeDateConfig().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((RangeDateConfig) obj).getGoodsType(), str)) {
                break;
            }
        }
        RangeDateConfig rangeDateConfig = (RangeDateConfig) obj;
        if (rangeDateConfig != null) {
            return new IntRange(Integer.parseInt(rangeDateConfig.getDatePickerStart()), Integer.parseInt(rangeDateConfig.getDatePickerEnd()));
        }
        return null;
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(AddNewBillsViewModel addNewBillsViewModel, List list) {
        ServiceItemMapper serviceItemMapper = addNewBillsViewModel.DatabaseTableConfigUtil;
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List<ThirdPartyCategoryService> filterNotNull = CollectionsKt.filterNotNull(list);
        for (ThirdPartyCategoryService thirdPartyCategoryService : filterNotNull) {
            String key = thirdPartyCategoryService.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "");
            boolean PlaceComponentResult = ServiceItemMapper.PlaceComponentResult(key);
            List<ThirdPartyServiceResponse> thirdPartyServices = thirdPartyCategoryService.getThirdPartyServices();
            String key2 = thirdPartyCategoryService.getKey();
            if (thirdPartyServices == null) {
                thirdPartyServices = CollectionsKt.emptyList();
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = thirdPartyServices.iterator();
            while (it.hasNext()) {
                ThirdPartyService PlaceComponentResult2 = ServiceItemMapper.PlaceComponentResult((ThirdPartyServiceResponse) it.next());
                if (PlaceComponentResult2 != null) {
                    PlaceComponentResult2.setKeyCategory(key2);
                } else {
                    PlaceComponentResult2 = null;
                }
                if (PlaceComponentResult2 != null) {
                    arrayList2.add(PlaceComponentResult2);
                }
            }
            arrayList.addAll(arrayList2);
            if (PlaceComponentResult) {
                if (serviceItemMapper.PlaceComponentResult) {
                    if (arrayList.size() > 1) {
                        arrayList.remove(1);
                    }
                    arrayList.add(new ThirdPartyService.Builder().type(5).key(SemanticAttributes.FaasDocumentOperationValues.EDIT).featured(true).build());
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((ThirdPartyService) it2.next()).setFeatured(true);
                }
            }
        }
        if (filterNotNull.size() > 1) {
            arrayList.add(new ThirdPartyService.Builder().type(4).keywords(new ArrayList()).build());
        }
        MutableStateFlow<AddNewBillsUiState> mutableStateFlow = addNewBillsViewModel.getAuthRequestContext;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), new AddNewBillsUiState.OnSuccessGetServiceMyBills(CollectionsKt.toMutableList((Collection) arrayList))));
    }
}

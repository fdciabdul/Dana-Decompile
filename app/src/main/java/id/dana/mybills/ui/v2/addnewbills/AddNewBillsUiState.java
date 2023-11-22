package id.dana.mybills.ui.v2.addnewbills;

import id.dana.core.ui.model.CurrencyAmountModel;
import id.dana.mybills.domain.model.BizProductDestination;
import id.dana.mybills.domain.model.ProductGoodsInfo;
import id.dana.mybills.domain.model.QuerySubscription;
import id.dana.mybills.ui.model.BizProductModel;
import id.dana.mybills.ui.model.BizProductOrderModel;
import id.dana.mybills.ui.model.HighlighTransactionPayModel;
import id.dana.mybills.ui.model.MobileRechargeProductModel;
import id.dana.mybills.ui.model.SaveMyBillsSubscriptionModel;
import id.dana.mybills.ui.model.service.ThirdPartyService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0016\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0016\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "", "<init>", "()V", "Loading", "None", "OnBillHasActiveBills", "OnErrorGetInquiry", "OnErrorGetPayTransaction", "OnErrorGetProduct", "OnErrorSaveMyBills", "OnGetBizProductOrder", "OnLoadingGetProduct", "OnQuickBuyShimmerLoading", "OnSuccessCheckUniqueValueAndCheckInquiry", "OnSuccessGetCurrentBalance", "OnSuccessGetGeneralProduct", "OnSuccessGetIsNeedToShowBottomSheetOnBoarding", "OnSuccessGetMobileRechargeProduct", "OnSuccessGetMyBillsDateRange", "OnSuccessGetPayTransaction", "OnSuccessGetQuickBuyBills", "OnSuccessGetServiceMyBills", "OnSuccessGetSubscriptionQueryById", "OnSuccessSaveMyBills", "OnValidationFormResult", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$None;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnSuccessGetServiceMyBills;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnSuccessGetIsNeedToShowBottomSheetOnBoarding;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnSuccessSaveMyBills;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnErrorSaveMyBills;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnBillHasActiveBills;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnSuccessGetPayTransaction;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnErrorGetPayTransaction;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnSuccessGetMobileRechargeProduct;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnLoadingGetProduct;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnErrorGetProduct;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnSuccessGetQuickBuyBills;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnGetBizProductOrder;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnSuccessGetCurrentBalance;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnSuccessGetGeneralProduct;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnValidationFormResult;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnErrorGetInquiry;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnSuccessGetSubscriptionQueryById;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnQuickBuyShimmerLoading;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$Loading;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnSuccessCheckUniqueValueAndCheckInquiry;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnSuccessGetMyBillsDateRange;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class AddNewBillsUiState {
    public /* synthetic */ AddNewBillsUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AddNewBillsUiState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$None;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class None extends AddNewBillsUiState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnSuccessGetServiceMyBills;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "", "Lid/dana/mybills/ui/model/service/ThirdPartyService;", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/List;", "getAuthRequestContext", "p0", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OnSuccessGetServiceMyBills extends AddNewBillsUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final List<ThirdPartyService> getAuthRequestContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetServiceMyBills(List<ThirdPartyService> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "");
            this.getAuthRequestContext = list;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnSuccessGetIsNeedToShowBottomSheetOnBoarding;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "", "BuiltInFictitiousFunctionClassFactory", "Z", "MyBillsEntityDataFactory", "()Z", "PlaceComponentResult", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OnSuccessGetIsNeedToShowBottomSheetOnBoarding extends AddNewBillsUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final boolean PlaceComponentResult;

        @JvmName(name = "MyBillsEntityDataFactory")
        /* renamed from: MyBillsEntityDataFactory  reason: from getter */
        public final boolean getPlaceComponentResult() {
            return this.PlaceComponentResult;
        }

        public OnSuccessGetIsNeedToShowBottomSheetOnBoarding(boolean z) {
            super(null);
            this.PlaceComponentResult = z;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\u0007X\u0007¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnSuccessSaveMyBills;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "MyBillsEntityDataFactory", "()Z", "Lid/dana/mybills/ui/model/SaveMyBillsSubscriptionModel;", "getAuthRequestContext", "Lid/dana/mybills/ui/model/SaveMyBillsSubscriptionModel;", "p0", "p1", "<init>", "(Lid/dana/mybills/ui/model/SaveMyBillsSubscriptionModel;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OnSuccessSaveMyBills extends AddNewBillsUiState {
        private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final SaveMyBillsSubscriptionModel MyBillsEntityDataFactory;

        @JvmName(name = "MyBillsEntityDataFactory")
        /* renamed from: MyBillsEntityDataFactory  reason: from getter */
        public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessSaveMyBills(SaveMyBillsSubscriptionModel saveMyBillsSubscriptionModel, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(saveMyBillsSubscriptionModel, "");
            this.MyBillsEntityDataFactory = saveMyBillsSubscriptionModel;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnErrorSaveMyBills;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "", "getAuthRequestContext", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OnErrorSaveMyBills extends AddNewBillsUiState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnErrorSaveMyBills(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.BuiltInFictitiousFunctionClassFactory = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\bX\u0007¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnBillHasActiveBills;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "", "getAuthRequestContext", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "", "PlaceComponentResult", "Ljava/lang/String;", "p0", "p1", "<init>", "(ZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OnBillHasActiveBills extends AddNewBillsUiState {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
        public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        public OnBillHasActiveBills(boolean z, String str) {
            super(null);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
            this.BuiltInFictitiousFunctionClassFactory = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnSuccessGetPayTransaction;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "Lid/dana/mybills/ui/model/HighlighTransactionPayModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/mybills/ui/model/HighlighTransactionPayModel;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lid/dana/mybills/ui/model/HighlighTransactionPayModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OnSuccessGetPayTransaction extends AddNewBillsUiState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final HighlighTransactionPayModel MyBillsEntityDataFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetPayTransaction(HighlighTransactionPayModel highlighTransactionPayModel) {
            super(null);
            Intrinsics.checkNotNullParameter(highlighTransactionPayModel, "");
            this.MyBillsEntityDataFactory = highlighTransactionPayModel;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnErrorGetPayTransaction;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OnErrorGetPayTransaction extends AddNewBillsUiState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnErrorGetPayTransaction(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.BuiltInFictitiousFunctionClassFactory = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnSuccessGetMobileRechargeProduct;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "Lid/dana/mybills/ui/model/MobileRechargeProductModel;", "getAuthRequestContext", "Lid/dana/mybills/ui/model/MobileRechargeProductModel;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Lid/dana/mybills/ui/model/MobileRechargeProductModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OnSuccessGetMobileRechargeProduct extends AddNewBillsUiState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final MobileRechargeProductModel BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetMobileRechargeProduct(MobileRechargeProductModel mobileRechargeProductModel) {
            super(null);
            Intrinsics.checkNotNullParameter(mobileRechargeProductModel, "");
            this.BuiltInFictitiousFunctionClassFactory = mobileRechargeProductModel;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnLoadingGetProduct;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OnLoadingGetProduct extends AddNewBillsUiState {
        public static final OnLoadingGetProduct INSTANCE = new OnLoadingGetProduct();

        private OnLoadingGetProduct() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnErrorGetProduct;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "", "getAuthRequestContext", "Ljava/lang/String;", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OnErrorGetProduct extends AddNewBillsUiState {
        public final String getAuthRequestContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnErrorGetProduct(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.getAuthRequestContext = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnSuccessGetQuickBuyBills;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "", "Lid/dana/mybills/ui/model/BizProductModel;", "MyBillsEntityDataFactory", "Ljava/util/List;", "p0", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OnSuccessGetQuickBuyBills extends AddNewBillsUiState {
        final List<BizProductModel> MyBillsEntityDataFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetQuickBuyBills(List<BizProductModel> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "");
            this.MyBillsEntityDataFactory = list;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnGetBizProductOrder;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "Lid/dana/mybills/ui/model/BizProductOrderModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/mybills/ui/model/BizProductOrderModel;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/mybills/ui/model/BizProductOrderModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OnGetBizProductOrder extends AddNewBillsUiState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final BizProductOrderModel PlaceComponentResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnGetBizProductOrder(BizProductOrderModel bizProductOrderModel) {
            super(null);
            Intrinsics.checkNotNullParameter(bizProductOrderModel, "");
            this.PlaceComponentResult = bizProductOrderModel;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnSuccessGetCurrentBalance;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "Lid/dana/core/ui/model/CurrencyAmountModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/core/ui/model/CurrencyAmountModel;", "getAuthRequestContext", "p0", "<init>", "(Lid/dana/core/ui/model/CurrencyAmountModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OnSuccessGetCurrentBalance extends AddNewBillsUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final CurrencyAmountModel getAuthRequestContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetCurrentBalance(CurrencyAmountModel currencyAmountModel) {
            super(null);
            Intrinsics.checkNotNullParameter(currencyAmountModel, "");
            this.getAuthRequestContext = currencyAmountModel;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnSuccessGetGeneralProduct;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "", "Lid/dana/mybills/domain/model/ProductGoodsInfo;", "MyBillsEntityDataFactory", "Ljava/util/List;", "p0", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OnSuccessGetGeneralProduct extends AddNewBillsUiState {
        public final List<ProductGoodsInfo> MyBillsEntityDataFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetGeneralProduct(List<ProductGoodsInfo> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "");
            this.MyBillsEntityDataFactory = list;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnValidationFormResult;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "", "", "PlaceComponentResult", "Ljava/util/Map;", "MyBillsEntityDataFactory", "p0", "<init>", "(Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OnValidationFormResult extends AddNewBillsUiState {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final Map<String, String> MyBillsEntityDataFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnValidationFormResult(Map<String, String> map) {
            super(null);
            Intrinsics.checkNotNullParameter(map, "");
            this.MyBillsEntityDataFactory = map;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\t\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnErrorGetInquiry;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "", "PlaceComponentResult", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "MyBillsEntityDataFactory", "I", "getAuthRequestContext", "p0", "p1", "<init>", "(Ljava/lang/String;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OnErrorGetInquiry extends AddNewBillsUiState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final int getAuthRequestContext;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final String KClassImpl$Data$declaredNonStaticMembers$2;

        public /* synthetic */ OnErrorGetInquiry(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i2 & 2) != 0 ? -1 : i);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnErrorGetInquiry(String str, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.getAuthRequestContext = i;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnSuccessGetSubscriptionQueryById;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "Lid/dana/mybills/domain/model/QuerySubscription;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/mybills/domain/model/QuerySubscription;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/mybills/domain/model/QuerySubscription;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OnSuccessGetSubscriptionQueryById extends AddNewBillsUiState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final QuerySubscription PlaceComponentResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetSubscriptionQueryById(QuerySubscription querySubscription) {
            super(null);
            Intrinsics.checkNotNullParameter(querySubscription, "");
            this.PlaceComponentResult = querySubscription;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnQuickBuyShimmerLoading;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "", "getAuthRequestContext", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OnQuickBuyShimmerLoading extends AddNewBillsUiState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        private final boolean BuiltInFictitiousFunctionClassFactory;

        public OnQuickBuyShimmerLoading(boolean z) {
            super(null);
            this.BuiltInFictitiousFunctionClassFactory = z;
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
        public final boolean getBuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$Loading;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Loading extends AddNewBillsUiState {
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0005R\u0011\u0010\t\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0011\u0010\r\u001a\u00020\u000bX\u0007¢\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\bX\u0007¢\u0006\u0006\n\u0004\b\r\u0010\n"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnSuccessCheckUniqueValueAndCheckInquiry;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "", "getAuthRequestContext", "Z", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "Lid/dana/mybills/domain/model/BizProductDestination;", "Lid/dana/mybills/domain/model/BizProductDestination;", "PlaceComponentResult", "p0", "p1", "p2", "p3", "p4", "<init>", "(Ljava/lang/String;ZZLid/dana/mybills/domain/model/BizProductDestination;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OnSuccessCheckUniqueValueAndCheckInquiry extends AddNewBillsUiState {
        private final boolean BuiltInFictitiousFunctionClassFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final BizProductDestination PlaceComponentResult;
        public final String MyBillsEntityDataFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final String getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext  reason: from getter */
        public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
        public final boolean getBuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessCheckUniqueValueAndCheckInquiry(String str, boolean z, boolean z2, BizProductDestination bizProductDestination, String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(bizProductDestination, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.getAuthRequestContext = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
            this.BuiltInFictitiousFunctionClassFactory = z2;
            this.PlaceComponentResult = bizProductDestination;
            this.MyBillsEntityDataFactory = str2;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState$OnSuccessGetMyBillsDateRange;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsUiState;", "Lkotlin/ranges/IntRange;", "getAuthRequestContext", "Lkotlin/ranges/IntRange;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lkotlin/ranges/IntRange;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OnSuccessGetMyBillsDateRange extends AddNewBillsUiState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final IntRange KClassImpl$Data$declaredNonStaticMembers$2;

        public OnSuccessGetMyBillsDateRange(IntRange intRange) {
            super(null);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = intRange;
        }
    }
}

package id.dana.cardbinding.viewmodel;

import id.dana.cardbinding.model.BankCardInfoModel;
import id.dana.cardbinding.model.SupportedCardsConfigModel;
import id.dana.cashier.model.CashierCheckoutModel;
import id.dana.cashier.model.CashierPayModel;
import id.dana.cashier.model.QueryCardPolicyInfoModel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0014\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0014\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+"}, d2 = {"Lid/dana/cardbinding/viewmodel/CardBindingUiState;", "", "<init>", "()V", "DismissProgress", "None", "OnError", "OnErrorBindingCardAdd", "OnErrorCardNotSupported", "OnErrorCashierPay", "OnErrorGetCashierMain", "OnErrorQueryCardPolicy", "OnErrorScanCard", "OnGetCardInfoSuccess", "OnGetOneklikRedirectUrlError", "OnGetOneklikRedirectUrlSuccess", "OnIsFirstTimeOpenCardBinding", "OnSuccessBindingCardAdd", "OnSuccessCashierPay", "OnSuccessGetCashierMain", "OnSuccessGetSupportedCardsConfig", "OnSuccessPayQuery", "OnSuccessQueryCardPolicy", "ShowProgress", "Lid/dana/cardbinding/viewmodel/CardBindingUiState$None;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnGetCardInfoSuccess;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnIsFirstTimeOpenCardBinding;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnSuccessQueryCardPolicy;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnErrorCardNotSupported;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnErrorQueryCardPolicy;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnSuccessBindingCardAdd;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnErrorGetCashierMain;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnSuccessGetCashierMain;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnSuccessGetSupportedCardsConfig;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnSuccessCashierPay;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnSuccessPayQuery;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnErrorCashierPay;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnGetOneklikRedirectUrlSuccess;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnGetOneklikRedirectUrlError;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnErrorScanCard;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnError;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnErrorBindingCardAdd;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState$ShowProgress;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState$DismissProgress;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class CardBindingUiState {
    public /* synthetic */ CardBindingUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CardBindingUiState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cardbinding/viewmodel/CardBindingUiState$None;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class None extends CardBindingUiState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnGetCardInfoSuccess;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState;", "Lid/dana/cardbinding/model/BankCardInfoModel;", "MyBillsEntityDataFactory", "Lid/dana/cardbinding/model/BankCardInfoModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lid/dana/cardbinding/model/BankCardInfoModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class OnGetCardInfoSuccess extends CardBindingUiState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final BankCardInfoModel KClassImpl$Data$declaredNonStaticMembers$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnGetCardInfoSuccess(BankCardInfoModel bankCardInfoModel) {
            super(null);
            Intrinsics.checkNotNullParameter(bankCardInfoModel, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = bankCardInfoModel;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\u0005\u0010\t"}, d2 = {"Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnIsFirstTimeOpenCardBinding;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "getAuthRequestContext", "", "Ljava/lang/String;", "p0", "p1", "<init>", "(ZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnIsFirstTimeOpenCardBinding extends CardBindingUiState {
        public final String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private final boolean getAuthRequestContext;

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
        public final boolean getGetAuthRequestContext() {
            return this.getAuthRequestContext;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnIsFirstTimeOpenCardBinding(boolean z, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.getAuthRequestContext = z;
            this.BuiltInFictitiousFunctionClassFactory = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\t\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnSuccessQueryCardPolicy;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState;", "", "getAuthRequestContext", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/cashier/model/QueryCardPolicyInfoModel;", "PlaceComponentResult", "Lid/dana/cashier/model/QueryCardPolicyInfoModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "<init>", "(Lid/dana/cashier/model/QueryCardPolicyInfoModel;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnSuccessQueryCardPolicy extends CardBindingUiState {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final QueryCardPolicyInfoModel KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessQueryCardPolicy(QueryCardPolicyInfoModel queryCardPolicyInfoModel, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(queryCardPolicyInfoModel, "");
            Intrinsics.checkNotNullParameter(str, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = queryCardPolicyInfoModel;
            this.BuiltInFictitiousFunctionClassFactory = str;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnErrorCardNotSupported;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class OnErrorCardNotSupported extends CardBindingUiState {
        public static final OnErrorCardNotSupported INSTANCE = new OnErrorCardNotSupported();

        private OnErrorCardNotSupported() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnErrorQueryCardPolicy;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState;", "", "getAuthRequestContext", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnErrorQueryCardPolicy extends CardBindingUiState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final String KClassImpl$Data$declaredNonStaticMembers$2;

        public OnErrorQueryCardPolicy(String str) {
            super(null);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnSuccessBindingCardAdd;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState;", "", "PlaceComponentResult", "Ljava/lang/String;", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnSuccessBindingCardAdd extends CardBindingUiState {
        public final String PlaceComponentResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessBindingCardAdd(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.PlaceComponentResult = str;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnErrorGetCashierMain;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnErrorGetCashierMain extends CardBindingUiState {
        public static final OnErrorGetCashierMain INSTANCE = new OnErrorGetCashierMain();

        private OnErrorGetCashierMain() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnSuccessGetCashierMain;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState;", "Lid/dana/cashier/model/CashierCheckoutModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cashier/model/CashierCheckoutModel;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Lid/dana/cashier/model/CashierCheckoutModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnSuccessGetCashierMain extends CardBindingUiState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final CashierCheckoutModel BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetCashierMain(CashierCheckoutModel cashierCheckoutModel) {
            super(null);
            Intrinsics.checkNotNullParameter(cashierCheckoutModel, "");
            this.BuiltInFictitiousFunctionClassFactory = cashierCheckoutModel;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnSuccessGetSupportedCardsConfig;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState;", "Lid/dana/cardbinding/model/SupportedCardsConfigModel;", "getAuthRequestContext", "Lid/dana/cardbinding/model/SupportedCardsConfigModel;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/cardbinding/model/SupportedCardsConfigModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnSuccessGetSupportedCardsConfig extends CardBindingUiState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final SupportedCardsConfigModel PlaceComponentResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetSupportedCardsConfig(SupportedCardsConfigModel supportedCardsConfigModel) {
            super(null);
            Intrinsics.checkNotNullParameter(supportedCardsConfigModel, "");
            this.PlaceComponentResult = supportedCardsConfigModel;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnSuccessCashierPay;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState;", "Lid/dana/cashier/model/CashierPayModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cashier/model/CashierPayModel;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Lid/dana/cashier/model/CashierPayModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnSuccessCashierPay extends CardBindingUiState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final CashierPayModel BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessCashierPay(CashierPayModel cashierPayModel) {
            super(null);
            Intrinsics.checkNotNullParameter(cashierPayModel, "");
            this.BuiltInFictitiousFunctionClassFactory = cashierPayModel;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnSuccessPayQuery;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState;", "Lid/dana/cashier/model/CashierPayModel;", "MyBillsEntityDataFactory", "Lid/dana/cashier/model/CashierPayModel;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Lid/dana/cashier/model/CashierPayModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnSuccessPayQuery extends CardBindingUiState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final CashierPayModel BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessPayQuery(CashierPayModel cashierPayModel) {
            super(null);
            Intrinsics.checkNotNullParameter(cashierPayModel, "");
            this.BuiltInFictitiousFunctionClassFactory = cashierPayModel;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004"}, d2 = {"Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnErrorCashierPay;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState;", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "MyBillsEntityDataFactory", "getAuthRequestContext", "p0", "p1", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnErrorCashierPay extends CardBindingUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final String MyBillsEntityDataFactory;
        public final String getAuthRequestContext;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public OnErrorCashierPay() {
            /*
                r2 = this;
                r0 = 0
                r1 = 3
                r2.<init>(r0, r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.cardbinding.viewmodel.CardBindingUiState.OnErrorCashierPay.<init>():void");
        }

        public OnErrorCashierPay(String str, String str2) {
            super(null);
            this.MyBillsEntityDataFactory = str;
            this.getAuthRequestContext = str2;
        }

        public /* synthetic */ OnErrorCashierPay(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnGetOneklikRedirectUrlSuccess;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState;", "", "PlaceComponentResult", "Ljava/lang/String;", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnGetOneklikRedirectUrlSuccess extends CardBindingUiState {
        public final String PlaceComponentResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnGetOneklikRedirectUrlSuccess(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.PlaceComponentResult = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnGetOneklikRedirectUrlError;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/Throwable;", "MyBillsEntityDataFactory", "p0", "<init>", "(Ljava/lang/Throwable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnGetOneklikRedirectUrlError extends CardBindingUiState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final Throwable MyBillsEntityDataFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnGetOneklikRedirectUrlError(Throwable th) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "");
            this.MyBillsEntityDataFactory = th;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnErrorScanCard;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class OnErrorScanCard extends CardBindingUiState {
        public static final OnErrorScanCard INSTANCE = new OnErrorScanCard();

        private OnErrorScanCard() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnError;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState;", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnError extends CardBindingUiState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public OnError() {
            /*
                r2 = this;
                r0 = 0
                r1 = 1
                r2.<init>(r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.cardbinding.viewmodel.CardBindingUiState.OnError.<init>():void");
        }

        private OnError(String str) {
            super(null);
            this.BuiltInFictitiousFunctionClassFactory = str;
        }

        public /* synthetic */ OnError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cardbinding/viewmodel/CardBindingUiState$OnErrorBindingCardAdd;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnErrorBindingCardAdd extends CardBindingUiState {
        public static final OnErrorBindingCardAdd INSTANCE = new OnErrorBindingCardAdd();

        private OnErrorBindingCardAdd() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cardbinding/viewmodel/CardBindingUiState$ShowProgress;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class ShowProgress extends CardBindingUiState {
        public static final ShowProgress INSTANCE = new ShowProgress();

        private ShowProgress() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cardbinding/viewmodel/CardBindingUiState$DismissProgress;", "Lid/dana/cardbinding/viewmodel/CardBindingUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DismissProgress extends CardBindingUiState {
        public static final DismissProgress INSTANCE = new DismissProgress();

        private DismissProgress() {
            super(null);
        }
    }
}

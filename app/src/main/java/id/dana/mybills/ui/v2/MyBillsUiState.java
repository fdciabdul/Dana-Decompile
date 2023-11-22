package id.dana.mybills.ui.v2;

import id.dana.core.ui.model.CurrencyAmountModel;
import id.dana.mybills.data.model.response.DeleteSubscriptionResult;
import id.dana.mybills.data.model.response.UpdateSubscriptionResult;
import id.dana.mybills.domain.model.MyBillsMonthlyAmount;
import id.dana.mybills.domain.model.ProductGoodsInfo;
import id.dana.mybills.ui.model.BillSubscriptionHighlightModel;
import id.dana.mybills.ui.model.HighlighTransactionPayModel;
import id.dana.mybills.ui.model.MonthlyHighlightBillModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0010\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0010\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#"}, d2 = {"Lid/dana/mybills/ui/v2/MyBillsUiState;", "", "<init>", "()V", "Error", "Loading", "None", "OnErrorGetPayTransaction", "OnFailedGetConsultView", "OnResultBulkPayAction", "OnSuccessDeleteSubscriptionBill", "OnSuccessGetConsultView", "OnSuccessGetCurrentBalance", "OnSuccessGetDanaCicilLink", "OnSuccessGetGeneralProduct", "OnSuccessGetInquirySubscriptionPaylaterWithDestination", "OnSuccessGetMonthlyWithConsultView", "OnSuccessGetPayTransaction", "OnSuccessUpdateSubscriptionBill", "Success", "Lid/dana/mybills/ui/v2/MyBillsUiState$None;", "Lid/dana/mybills/ui/v2/MyBillsUiState$Loading;", "Lid/dana/mybills/ui/v2/MyBillsUiState$Success;", "Lid/dana/mybills/ui/v2/MyBillsUiState$Error;", "Lid/dana/mybills/ui/v2/MyBillsUiState$OnSuccessGetMonthlyWithConsultView;", "Lid/dana/mybills/ui/v2/MyBillsUiState$OnSuccessGetInquirySubscriptionPaylaterWithDestination;", "Lid/dana/mybills/ui/v2/MyBillsUiState$OnFailedGetConsultView;", "Lid/dana/mybills/ui/v2/MyBillsUiState$OnSuccessGetCurrentBalance;", "Lid/dana/mybills/ui/v2/MyBillsUiState$OnSuccessGetConsultView;", "Lid/dana/mybills/ui/v2/MyBillsUiState$OnSuccessGetPayTransaction;", "Lid/dana/mybills/ui/v2/MyBillsUiState$OnSuccessGetGeneralProduct;", "Lid/dana/mybills/ui/v2/MyBillsUiState$OnSuccessUpdateSubscriptionBill;", "Lid/dana/mybills/ui/v2/MyBillsUiState$OnSuccessDeleteSubscriptionBill;", "Lid/dana/mybills/ui/v2/MyBillsUiState$OnErrorGetPayTransaction;", "Lid/dana/mybills/ui/v2/MyBillsUiState$OnSuccessGetDanaCicilLink;", "Lid/dana/mybills/ui/v2/MyBillsUiState$OnResultBulkPayAction;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class MyBillsUiState {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/mybills/ui/v2/MyBillsUiState$OnSuccessGetConsultView;", "Lid/dana/mybills/ui/v2/MyBillsUiState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/mybills/ui/model/MonthlyHighlightBillModel;", "PlaceComponentResult", "Lid/dana/mybills/ui/model/MonthlyHighlightBillModel;", "getAuthRequestContext"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final /* data */ class OnSuccessGetConsultView extends MyBillsUiState {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final MonthlyHighlightBillModel getAuthRequestContext;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof OnSuccessGetConsultView) && Intrinsics.areEqual(this.getAuthRequestContext, ((OnSuccessGetConsultView) p0).getAuthRequestContext);
        }

        public final int hashCode() {
            return this.getAuthRequestContext.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("OnSuccessGetConsultView(getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(')');
            return sb.toString();
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\u0011X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/mybills/ui/v2/MyBillsUiState$OnSuccessGetMonthlyWithConsultView;", "Lid/dana/mybills/ui/v2/MyBillsUiState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/mybills/ui/model/MonthlyHighlightBillModel;", "MyBillsEntityDataFactory", "Lid/dana/mybills/ui/model/MonthlyHighlightBillModel;", "getAuthRequestContext", "Lid/dana/mybills/domain/model/MyBillsMonthlyAmount;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/mybills/domain/model/MyBillsMonthlyAmount;", "KClassImpl$Data$declaredNonStaticMembers$2"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final /* data */ class OnSuccessGetMonthlyWithConsultView extends MyBillsUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final MyBillsMonthlyAmount KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final MonthlyHighlightBillModel getAuthRequestContext;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof OnSuccessGetMonthlyWithConsultView) {
                OnSuccessGetMonthlyWithConsultView onSuccessGetMonthlyWithConsultView = (OnSuccessGetMonthlyWithConsultView) p0;
                return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, onSuccessGetMonthlyWithConsultView.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.getAuthRequestContext, onSuccessGetMonthlyWithConsultView.getAuthRequestContext);
            }
            return false;
        }

        public final int hashCode() {
            return (this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode() * 31) + this.getAuthRequestContext.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("OnSuccessGetMonthlyWithConsultView(KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(')');
            return sb.toString();
        }
    }

    public /* synthetic */ MyBillsUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private MyBillsUiState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/ui/v2/MyBillsUiState$None;", "Lid/dana/mybills/ui/v2/MyBillsUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class None extends MyBillsUiState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/ui/v2/MyBillsUiState$Loading;", "Lid/dana/mybills/ui/v2/MyBillsUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Loading extends MyBillsUiState {
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0010\u001a\u00028\u0000X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/mybills/ui/v2/MyBillsUiState$Success;", "T", "Lid/dana/mybills/ui/v2/MyBillsUiState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "Ljava/lang/Object;", "getAuthRequestContext", "<init>", "(Ljava/lang/Object;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Success<T> extends MyBillsUiState {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final T getAuthRequestContext;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof Success) && Intrinsics.areEqual(this.getAuthRequestContext, ((Success) p0).getAuthRequestContext);
        }

        public final int hashCode() {
            T t = this.getAuthRequestContext;
            if (t == null) {
                return 0;
            }
            return t.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Success(getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(')');
            return sb.toString();
        }

        public Success(T t) {
            super(null);
            this.getAuthRequestContext = t;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0010\u001a\u00028\u0000X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0011\u0010\u000e\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/mybills/ui/v2/MyBillsUiState$Error;", "T", "Lid/dana/mybills/ui/v2/MyBillsUiState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/Object;", "PlaceComponentResult", "MyBillsEntityDataFactory", "Ljava/lang/String;", "p1", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Error<T> extends MyBillsUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final T PlaceComponentResult;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Error) {
                Error error = (Error) p0;
                return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, error.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.PlaceComponentResult, error.PlaceComponentResult);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = this.BuiltInFictitiousFunctionClassFactory.hashCode();
            T t = this.PlaceComponentResult;
            return (hashCode * 31) + (t == null ? 0 : t.hashCode());
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Error(BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(String str, T t) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.PlaceComponentResult = t;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0007¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/mybills/ui/v2/MyBillsUiState$OnSuccessGetInquirySubscriptionPaylaterWithDestination;", "Lid/dana/mybills/ui/v2/MyBillsUiState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "", "Lid/dana/mybills/ui/model/BillSubscriptionHighlightModel;", "PlaceComponentResult", "Ljava/util/List;", "MyBillsEntityDataFactory", "p1", "<init>", "(Ljava/util/List;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class OnSuccessGetInquirySubscriptionPaylaterWithDestination extends MyBillsUiState {
        private final boolean BuiltInFictitiousFunctionClassFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final List<BillSubscriptionHighlightModel> MyBillsEntityDataFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof OnSuccessGetInquirySubscriptionPaylaterWithDestination) {
                OnSuccessGetInquirySubscriptionPaylaterWithDestination onSuccessGetInquirySubscriptionPaylaterWithDestination = (OnSuccessGetInquirySubscriptionPaylaterWithDestination) p0;
                return Intrinsics.areEqual(this.MyBillsEntityDataFactory, onSuccessGetInquirySubscriptionPaylaterWithDestination.MyBillsEntityDataFactory) && this.BuiltInFictitiousFunctionClassFactory == onSuccessGetInquirySubscriptionPaylaterWithDestination.BuiltInFictitiousFunctionClassFactory;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode = this.MyBillsEntityDataFactory.hashCode();
            boolean z = this.BuiltInFictitiousFunctionClassFactory;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return (hashCode * 31) + i;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("OnSuccessGetInquirySubscriptionPaylaterWithDestination(MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(')');
            return sb.toString();
        }

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
        public final boolean getBuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetInquirySubscriptionPaylaterWithDestination(List<BillSubscriptionHighlightModel> list, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "");
            this.MyBillsEntityDataFactory = list;
            this.BuiltInFictitiousFunctionClassFactory = z;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/ui/v2/MyBillsUiState$OnFailedGetConsultView;", "Lid/dana/mybills/ui/v2/MyBillsUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnFailedGetConsultView extends MyBillsUiState {
        public static final OnFailedGetConsultView INSTANCE = new OnFailedGetConsultView();

        private OnFailedGetConsultView() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/mybills/ui/v2/MyBillsUiState$OnSuccessGetCurrentBalance;", "Lid/dana/mybills/ui/v2/MyBillsUiState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/core/ui/model/CurrencyAmountModel;", "getAuthRequestContext", "Lid/dana/core/ui/model/CurrencyAmountModel;", "MyBillsEntityDataFactory", "<init>", "(Lid/dana/core/ui/model/CurrencyAmountModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class OnSuccessGetCurrentBalance extends MyBillsUiState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final CurrencyAmountModel MyBillsEntityDataFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof OnSuccessGetCurrentBalance) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, ((OnSuccessGetCurrentBalance) p0).MyBillsEntityDataFactory);
        }

        public final int hashCode() {
            return this.MyBillsEntityDataFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("OnSuccessGetCurrentBalance(MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetCurrentBalance(CurrencyAmountModel currencyAmountModel) {
            super(null);
            Intrinsics.checkNotNullParameter(currencyAmountModel, "");
            this.MyBillsEntityDataFactory = currencyAmountModel;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/mybills/ui/v2/MyBillsUiState$OnSuccessGetPayTransaction;", "Lid/dana/mybills/ui/v2/MyBillsUiState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/mybills/ui/model/HighlighTransactionPayModel;", "PlaceComponentResult", "Lid/dana/mybills/ui/model/HighlighTransactionPayModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Lid/dana/mybills/ui/model/HighlighTransactionPayModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final /* data */ class OnSuccessGetPayTransaction extends MyBillsUiState {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final HighlighTransactionPayModel KClassImpl$Data$declaredNonStaticMembers$2;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof OnSuccessGetPayTransaction) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, ((OnSuccessGetPayTransaction) p0).KClassImpl$Data$declaredNonStaticMembers$2);
        }

        public final int hashCode() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("OnSuccessGetPayTransaction(KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetPayTransaction(HighlighTransactionPayModel highlighTransactionPayModel) {
            super(null);
            Intrinsics.checkNotNullParameter(highlighTransactionPayModel, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = highlighTransactionPayModel;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/mybills/ui/v2/MyBillsUiState$OnSuccessGetGeneralProduct;", "Lid/dana/mybills/ui/v2/MyBillsUiState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "Lid/dana/mybills/domain/model/ProductGoodsInfo;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/List;", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final /* data */ class OnSuccessGetGeneralProduct extends MyBillsUiState {
        public final List<ProductGoodsInfo> KClassImpl$Data$declaredNonStaticMembers$2;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof OnSuccessGetGeneralProduct) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, ((OnSuccessGetGeneralProduct) p0).KClassImpl$Data$declaredNonStaticMembers$2);
        }

        public final int hashCode() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("OnSuccessGetGeneralProduct(KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetGeneralProduct(List<ProductGoodsInfo> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000e\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/mybills/ui/v2/MyBillsUiState$OnSuccessUpdateSubscriptionBill;", "Lid/dana/mybills/ui/v2/MyBillsUiState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/mybills/data/model/response/UpdateSubscriptionResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/mybills/data/model/response/UpdateSubscriptionResult;", "<init>", "(Lid/dana/mybills/data/model/response/UpdateSubscriptionResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final /* data */ class OnSuccessUpdateSubscriptionBill extends MyBillsUiState {
        public final UpdateSubscriptionResult KClassImpl$Data$declaredNonStaticMembers$2;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof OnSuccessUpdateSubscriptionBill) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, ((OnSuccessUpdateSubscriptionBill) p0).KClassImpl$Data$declaredNonStaticMembers$2);
        }

        public final int hashCode() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("OnSuccessUpdateSubscriptionBill(KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessUpdateSubscriptionBill(UpdateSubscriptionResult updateSubscriptionResult) {
            super(null);
            Intrinsics.checkNotNullParameter(updateSubscriptionResult, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = updateSubscriptionResult;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/mybills/ui/v2/MyBillsUiState$OnSuccessDeleteSubscriptionBill;", "Lid/dana/mybills/ui/v2/MyBillsUiState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/mybills/data/model/response/DeleteSubscriptionResult;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/mybills/data/model/response/DeleteSubscriptionResult;", "getAuthRequestContext", "<init>", "(Lid/dana/mybills/data/model/response/DeleteSubscriptionResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final /* data */ class OnSuccessDeleteSubscriptionBill extends MyBillsUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final DeleteSubscriptionResult getAuthRequestContext;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof OnSuccessDeleteSubscriptionBill) && Intrinsics.areEqual(this.getAuthRequestContext, ((OnSuccessDeleteSubscriptionBill) p0).getAuthRequestContext);
        }

        public final int hashCode() {
            return this.getAuthRequestContext.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("OnSuccessDeleteSubscriptionBill(getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessDeleteSubscriptionBill(DeleteSubscriptionResult deleteSubscriptionResult) {
            super(null);
            Intrinsics.checkNotNullParameter(deleteSubscriptionResult, "");
            this.getAuthRequestContext = deleteSubscriptionResult;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/ui/v2/MyBillsUiState$OnErrorGetPayTransaction;", "Lid/dana/mybills/ui/v2/MyBillsUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class OnErrorGetPayTransaction extends MyBillsUiState {
        public static final OnErrorGetPayTransaction INSTANCE = new OnErrorGetPayTransaction();

        private OnErrorGetPayTransaction() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/mybills/ui/v2/MyBillsUiState$OnSuccessGetDanaCicilLink;", "Lid/dana/mybills/ui/v2/MyBillsUiState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class OnSuccessGetDanaCicilLink extends MyBillsUiState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final String KClassImpl$Data$declaredNonStaticMembers$2;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof OnSuccessGetDanaCicilLink) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, ((OnSuccessGetDanaCicilLink) p0).KClassImpl$Data$declaredNonStaticMembers$2);
        }

        public final int hashCode() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("OnSuccessGetDanaCicilLink(KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetDanaCicilLink(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/mybills/ui/v2/MyBillsUiState$OnResultBulkPayAction;", "Lid/dana/mybills/ui/v2/MyBillsUiState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "Lid/dana/mybills/ui/model/HighlighTransactionPayModel;", "MyBillsEntityDataFactory", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final /* data */ class OnResultBulkPayAction extends MyBillsUiState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final List<HighlighTransactionPayModel> KClassImpl$Data$declaredNonStaticMembers$2;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof OnResultBulkPayAction) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, ((OnResultBulkPayAction) p0).KClassImpl$Data$declaredNonStaticMembers$2);
        }

        public final int hashCode() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("OnResultBulkPayAction(KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnResultBulkPayAction(List<HighlighTransactionPayModel> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        }
    }
}

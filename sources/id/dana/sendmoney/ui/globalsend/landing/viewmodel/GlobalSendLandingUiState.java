package id.dana.sendmoney.ui.globalsend.landing.viewmodel;

import id.dana.sendmoney.R;
import id.dana.sendmoney.ui.globalsend.form.model.TransferValidateResultModel;
import id.dana.sendmoney.ui.globalsend.landing.model.QueryBeneficiaryResultModel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\f\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState;", "", "<init>", "()V", "DanaLoading", "Error", "None", "OnErrorCode", "OnErrorDeleteBeneficiary", "OnErrorGetBeneficiary", "OnSuccessDeleteBeneficiary", "OnSuccessGetBeneficiaryList", "OnSuccessGetMaxBeneficiaryPageSize", "OnSuccessGetSort", "OnSuccessValidateRecurringTransaction", "ShimmerLoading", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState$None;", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState$ShimmerLoading;", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState$DanaLoading;", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState$OnSuccessGetBeneficiaryList;", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState$OnErrorGetBeneficiary;", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState$OnSuccessGetMaxBeneficiaryPageSize;", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState$OnSuccessValidateRecurringTransaction;", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState$OnSuccessDeleteBeneficiary;", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState$OnSuccessGetSort;", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState$OnErrorDeleteBeneficiary;", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState$OnErrorCode;", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState$Error;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class GlobalSendLandingUiState {
    public /* synthetic */ GlobalSendLandingUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private GlobalSendLandingUiState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState$None;", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class None extends GlobalSendLandingUiState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState$ShimmerLoading;", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "PlaceComponentResult", "()Z", "getAuthRequestContext", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ShimmerLoading extends GlobalSendLandingUiState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private final boolean getAuthRequestContext;

        public ShimmerLoading(boolean z) {
            super(null);
            this.getAuthRequestContext = z;
        }

        @JvmName(name = "PlaceComponentResult")
        /* renamed from: PlaceComponentResult  reason: from getter */
        public final boolean getGetAuthRequestContext() {
            return this.getAuthRequestContext;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState$DanaLoading;", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState;", "", "getAuthRequestContext", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DanaLoading extends GlobalSendLandingUiState {
        private final boolean getAuthRequestContext;

        public DanaLoading(boolean z) {
            super(null);
            this.getAuthRequestContext = z;
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
        public final boolean getGetAuthRequestContext() {
            return this.getAuthRequestContext;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState$OnSuccessGetBeneficiaryList;", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState;", "Lid/dana/sendmoney/ui/globalsend/landing/model/QueryBeneficiaryResultModel;", "getAuthRequestContext", "Lid/dana/sendmoney/ui/globalsend/landing/model/QueryBeneficiaryResultModel;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lid/dana/sendmoney/ui/globalsend/landing/model/QueryBeneficiaryResultModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessGetBeneficiaryList extends GlobalSendLandingUiState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final QueryBeneficiaryResultModel MyBillsEntityDataFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetBeneficiaryList(QueryBeneficiaryResultModel queryBeneficiaryResultModel) {
            super(null);
            Intrinsics.checkNotNullParameter(queryBeneficiaryResultModel, "");
            this.MyBillsEntityDataFactory = queryBeneficiaryResultModel;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState$OnErrorGetBeneficiary;", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState;", "", "BuiltInFictitiousFunctionClassFactory", "I", "PlaceComponentResult", "p0", "<init>", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnErrorGetBeneficiary extends GlobalSendLandingUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final int PlaceComponentResult;

        public OnErrorGetBeneficiary() {
            this(0, 1, null);
        }

        private OnErrorGetBeneficiary(int i) {
            super(null);
            this.PlaceComponentResult = i;
        }

        public /* synthetic */ OnErrorGetBeneficiary(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? R.string.SchedulerPoolFactory : i);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState$OnSuccessGetMaxBeneficiaryPageSize;", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState;", "", "getAuthRequestContext", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessGetMaxBeneficiaryPageSize extends GlobalSendLandingUiState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final int KClassImpl$Data$declaredNonStaticMembers$2;

        public OnSuccessGetMaxBeneficiaryPageSize(int i) {
            super(null);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState$OnSuccessValidateRecurringTransaction;", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState;", "Lid/dana/sendmoney/ui/globalsend/form/model/TransferValidateResultModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/ui/globalsend/form/model/TransferValidateResultModel;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Lid/dana/sendmoney/ui/globalsend/form/model/TransferValidateResultModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessValidateRecurringTransaction extends GlobalSendLandingUiState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final TransferValidateResultModel BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessValidateRecurringTransaction(TransferValidateResultModel transferValidateResultModel) {
            super(null);
            Intrinsics.checkNotNullParameter(transferValidateResultModel, "");
            this.BuiltInFictitiousFunctionClassFactory = transferValidateResultModel;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState$OnSuccessDeleteBeneficiary;", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessDeleteBeneficiary extends GlobalSendLandingUiState {
        public final String KClassImpl$Data$declaredNonStaticMembers$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessDeleteBeneficiary(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState$OnSuccessGetSort;", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnSuccessGetSort extends GlobalSendLandingUiState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessGetSort(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.BuiltInFictitiousFunctionClassFactory = str;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState$OnErrorDeleteBeneficiary;", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnErrorDeleteBeneficiary extends GlobalSendLandingUiState {
        public static final OnErrorDeleteBeneficiary INSTANCE = new OnErrorDeleteBeneficiary();

        private OnErrorDeleteBeneficiary() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState$OnErrorCode;", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState;", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "PlaceComponentResult", "getAuthRequestContext", "p0", "p1", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnErrorCode extends GlobalSendLandingUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final String PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnErrorCode(String str, String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.PlaceComponentResult = str;
            this.BuiltInFictitiousFunctionClassFactory = str2;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState$Error;", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingUiState;", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getAuthRequestContext", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Error extends GlobalSendLandingUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final String getAuthRequestContext;

        public Error(String str) {
            super(null);
            this.getAuthRequestContext = str;
        }
    }
}

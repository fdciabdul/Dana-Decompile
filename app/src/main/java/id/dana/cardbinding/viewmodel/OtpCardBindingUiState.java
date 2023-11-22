package id.dana.cardbinding.viewmodel;

import android.os.Bundle;
import id.dana.cashier.model.CashierAgreementModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\r\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\r\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d"}, d2 = {"Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState;", "", "<init>", "()V", "DismissProgress", "None", "OnCreateAgreementError", "OnError", "OnErrorSendOtp", "OnSmsReceived", "OnSuccessCashierAgreement", "OnSuccessSendOtp", "OnVerifyBankPhoneOtp", "OnVerifyOneklikError", "OnVerifyOneklikSuccess", "ShowProgress", "ShowSkeletonLoading", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState$None;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState$OnSuccessCashierAgreement;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState$OnSuccessSendOtp;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState$OnErrorSendOtp;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState$OnSmsReceived;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState$OnVerifyBankPhoneOtp;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState$OnVerifyOneklikSuccess;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState$OnVerifyOneklikError;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState$OnCreateAgreementError;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState$ShowSkeletonLoading;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState$ShowProgress;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState$DismissProgress;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState$OnError;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class OtpCardBindingUiState {
    public /* synthetic */ OtpCardBindingUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private OtpCardBindingUiState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState$None;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class None extends OtpCardBindingUiState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState$OnSuccessCashierAgreement;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState;", "Lid/dana/cashier/model/CashierAgreementModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cashier/model/CashierAgreementModel;", "getAuthRequestContext", "p0", "<init>", "(Lid/dana/cashier/model/CashierAgreementModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnSuccessCashierAgreement extends OtpCardBindingUiState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final CashierAgreementModel getAuthRequestContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessCashierAgreement(CashierAgreementModel cashierAgreementModel) {
            super(null);
            Intrinsics.checkNotNullParameter(cashierAgreementModel, "");
            this.getAuthRequestContext = cashierAgreementModel;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004"}, d2 = {"Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState$OnSuccessSendOtp;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState;", "", "getAuthRequestContext", "I", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "p2", "<init>", "(III)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnSuccessSendOtp extends OtpCardBindingUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final int PlaceComponentResult;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final int KClassImpl$Data$declaredNonStaticMembers$2;
        public final int getAuthRequestContext;

        public OnSuccessSendOtp(int i, int i2, int i3) {
            super(null);
            this.getAuthRequestContext = i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
            this.PlaceComponentResult = i3;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState$OnErrorSendOtp;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState;", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "getAuthRequestContext", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnErrorSendOtp extends OtpCardBindingUiState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final String getAuthRequestContext;

        public OnErrorSendOtp(String str) {
            super(null);
            this.getAuthRequestContext = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState$OnSmsReceived;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState;", "Landroid/os/Bundle;", "BuiltInFictitiousFunctionClassFactory", "Landroid/os/Bundle;", "MyBillsEntityDataFactory", "p0", "<init>", "(Landroid/os/Bundle;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnSmsReceived extends OtpCardBindingUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final Bundle MyBillsEntityDataFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSmsReceived(Bundle bundle) {
            super(null);
            Intrinsics.checkNotNullParameter(bundle, "");
            this.MyBillsEntityDataFactory = bundle;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\u0004"}, d2 = {"Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState$OnVerifyBankPhoneOtp;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState;", "", "MyBillsEntityDataFactory", "I", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "p2", "<init>", "(III)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnVerifyBankPhoneOtp extends OtpCardBindingUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final int PlaceComponentResult;
        public final int KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final int getAuthRequestContext;

        public OnVerifyBankPhoneOtp(int i, int i2, int i3) {
            super(null);
            this.getAuthRequestContext = i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
            this.PlaceComponentResult = i3;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState$OnVerifyOneklikSuccess;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class OnVerifyOneklikSuccess extends OtpCardBindingUiState {
        public static final OnVerifyOneklikSuccess INSTANCE = new OnVerifyOneklikSuccess();

        private OnVerifyOneklikSuccess() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState$OnVerifyOneklikError;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class OnVerifyOneklikError extends OtpCardBindingUiState {
        public static final OnVerifyOneklikError INSTANCE = new OnVerifyOneklikError();

        private OnVerifyOneklikError() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState$OnCreateAgreementError;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState;", "", "getAuthRequestContext", "Ljava/lang/String;", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnCreateAgreementError extends OtpCardBindingUiState {
        public final String getAuthRequestContext;

        public OnCreateAgreementError(String str) {
            super(null);
            this.getAuthRequestContext = str;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState$ShowSkeletonLoading;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class ShowSkeletonLoading extends OtpCardBindingUiState {
        public static final ShowSkeletonLoading INSTANCE = new ShowSkeletonLoading();

        private ShowSkeletonLoading() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState$ShowProgress;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class ShowProgress extends OtpCardBindingUiState {
        public static final ShowProgress INSTANCE = new ShowProgress();

        private ShowProgress() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState$DismissProgress;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DismissProgress extends OtpCardBindingUiState {
        public static final DismissProgress INSTANCE = new DismissProgress();

        private DismissProgress() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState$OnError;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState;", "", "PlaceComponentResult", "Ljava/lang/String;", "MyBillsEntityDataFactory", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnError extends OtpCardBindingUiState {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final String MyBillsEntityDataFactory;

        public OnError(String str) {
            super(null);
            this.MyBillsEntityDataFactory = str;
        }
    }
}

package id.dana.riskChallenges.ui.resetpin.confirm.viewmodel;

import id.dana.utils.StringWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinUiState;", "", "<init>", "()V", "DismissLoading", "FailedResetPin", "FailedSelfUnfreeze", "None", "PinNotMatched", "ShowLoading", "SuccessResetPin", "Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinUiState$None;", "Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinUiState$ShowLoading;", "Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinUiState$DismissLoading;", "Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinUiState$SuccessResetPin;", "Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinUiState$FailedResetPin;", "Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinUiState$PinNotMatched;", "Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinUiState$FailedSelfUnfreeze;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class InputConfirmPinUiState {
    public /* synthetic */ InputConfirmPinUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private InputConfirmPinUiState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinUiState$None;", "Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class None extends InputConfirmPinUiState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinUiState$ShowLoading;", "Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ShowLoading extends InputConfirmPinUiState {
        public static final ShowLoading INSTANCE = new ShowLoading();

        private ShowLoading() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinUiState$DismissLoading;", "Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DismissLoading extends InputConfirmPinUiState {
        public static final DismissLoading INSTANCE = new DismissLoading();

        private DismissLoading() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinUiState$SuccessResetPin;", "Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class SuccessResetPin extends InputConfirmPinUiState {
        public static final SuccessResetPin INSTANCE = new SuccessResetPin();

        private SuccessResetPin() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u0010X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinUiState$FailedResetPin;", "Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinUiState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/utils/StringWrapper;", "Lid/dana/utils/StringWrapper;", "MyBillsEntityDataFactory", "p1", "<init>", "(Ljava/lang/String;Lid/dana/utils/StringWrapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class FailedResetPin extends InputConfirmPinUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final StringWrapper MyBillsEntityDataFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof FailedResetPin) {
                FailedResetPin failedResetPin = (FailedResetPin) p0;
                return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, failedResetPin.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, failedResetPin.MyBillsEntityDataFactory);
            }
            return false;
        }

        public final int hashCode() {
            return (this.BuiltInFictitiousFunctionClassFactory.hashCode() * 31) + this.MyBillsEntityDataFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("FailedResetPin(BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FailedResetPin(String str, StringWrapper stringWrapper) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(stringWrapper, "");
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.MyBillsEntityDataFactory = stringWrapper;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinUiState$PinNotMatched;", "Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class PinNotMatched extends InputConfirmPinUiState {
        public static final PinNotMatched INSTANCE = new PinNotMatched();

        private PinNotMatched() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinUiState$FailedSelfUnfreeze;", "Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinUiState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/utils/StringWrapper;", "getAuthRequestContext", "Lid/dana/utils/StringWrapper;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Lid/dana/utils/StringWrapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class FailedSelfUnfreeze extends InputConfirmPinUiState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final StringWrapper KClassImpl$Data$declaredNonStaticMembers$2;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof FailedSelfUnfreeze) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, ((FailedSelfUnfreeze) p0).KClassImpl$Data$declaredNonStaticMembers$2);
        }

        public final int hashCode() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("FailedSelfUnfreeze(KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FailedSelfUnfreeze(StringWrapper stringWrapper) {
            super(null);
            Intrinsics.checkNotNullParameter(stringWrapper, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = stringWrapper;
        }
    }
}

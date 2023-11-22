package id.dana.riskChallenges.ui.missedCallOtp;

import id.dana.domain.citcall.model.MiscallResponse;
import id.dana.utils.StringWrapper;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0010\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0010\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#"}, d2 = {"Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState;", "", "<init>", "()V", "DismissProgress", "DismissResendProgress", "Failed", "FailedFirstTime", "MaxAttemptsReached", "MissedCallOtpPermission", "None", "ResendOTPSuccess", "ShowProgress", "ShowResendProgress", "Success", "TimeOut", "VerifyExpired", "VerifyFailed", "VerifyInvalidOtp", "VerifySuccess", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$None;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$ShowResendProgress;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$DismissResendProgress;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$ShowProgress;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$DismissProgress;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$Success;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$Failed;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$FailedFirstTime;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$TimeOut;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$MaxAttemptsReached;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$ResendOTPSuccess;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$MissedCallOtpPermission;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$VerifyFailed;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$VerifyInvalidOtp;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$VerifyExpired;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$VerifySuccess;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class MissedCallOtpUIState {
    public /* synthetic */ MissedCallOtpUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private MissedCallOtpUIState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$None;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class None extends MissedCallOtpUIState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$ShowResendProgress;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ShowResendProgress extends MissedCallOtpUIState {
        public static final ShowResendProgress INSTANCE = new ShowResendProgress();

        private ShowResendProgress() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$DismissResendProgress;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DismissResendProgress extends MissedCallOtpUIState {
        public static final DismissResendProgress INSTANCE = new DismissResendProgress();

        private DismissResendProgress() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$ShowProgress;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ShowProgress extends MissedCallOtpUIState {
        public static final ShowProgress INSTANCE = new ShowProgress();

        private ShowProgress() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$DismissProgress;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DismissProgress extends MissedCallOtpUIState {
        public static final DismissProgress INSTANCE = new DismissProgress();

        private DismissProgress() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$Success;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/domain/citcall/model/MiscallResponse;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/citcall/model/MiscallResponse;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Lid/dana/domain/citcall/model/MiscallResponse;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Success extends MissedCallOtpUIState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final MiscallResponse BuiltInFictitiousFunctionClassFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof Success) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, ((Success) p0).BuiltInFictitiousFunctionClassFactory);
        }

        public final int hashCode() {
            return this.BuiltInFictitiousFunctionClassFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Success(BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(MiscallResponse miscallResponse) {
            super(null);
            Intrinsics.checkNotNullParameter(miscallResponse, "");
            this.BuiltInFictitiousFunctionClassFactory = miscallResponse;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u0010X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011"}, d2 = {"Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$Failed;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/utils/StringWrapper;", "Lid/dana/utils/StringWrapper;", "MyBillsEntityDataFactory", "p1", "<init>", "(Ljava/lang/String;Lid/dana/utils/StringWrapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Failed extends MissedCallOtpUIState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final StringWrapper MyBillsEntityDataFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Failed) {
                Failed failed = (Failed) p0;
                return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, failed.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, failed.MyBillsEntityDataFactory);
            }
            return false;
        }

        public final int hashCode() {
            return (this.BuiltInFictitiousFunctionClassFactory.hashCode() * 31) + this.MyBillsEntityDataFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed(BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failed(String str, StringWrapper stringWrapper) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(stringWrapper, "");
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.MyBillsEntityDataFactory = stringWrapper;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$FailedFirstTime;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "Ljava/lang/String;", "Lid/dana/utils/StringWrapper;", "MyBillsEntityDataFactory", "Lid/dana/utils/StringWrapper;", "getAuthRequestContext", "p1", "<init>", "(Ljava/lang/String;Lid/dana/utils/StringWrapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class FailedFirstTime extends MissedCallOtpUIState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final StringWrapper getAuthRequestContext;
        public final String PlaceComponentResult;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof FailedFirstTime) {
                FailedFirstTime failedFirstTime = (FailedFirstTime) p0;
                return Intrinsics.areEqual(this.PlaceComponentResult, failedFirstTime.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, failedFirstTime.getAuthRequestContext);
            }
            return false;
        }

        public final int hashCode() {
            return (this.PlaceComponentResult.hashCode() * 31) + this.getAuthRequestContext.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("FailedFirstTime(PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FailedFirstTime(String str, StringWrapper stringWrapper) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(stringWrapper, "");
            this.PlaceComponentResult = str;
            this.getAuthRequestContext = stringWrapper;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$TimeOut;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class TimeOut extends MissedCallOtpUIState {
        public static final TimeOut INSTANCE = new TimeOut();

        private TimeOut() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$MaxAttemptsReached;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MaxAttemptsReached extends MissedCallOtpUIState {
        public static final MaxAttemptsReached INSTANCE = new MaxAttemptsReached();

        private MaxAttemptsReached() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$ResendOTPSuccess;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ResendOTPSuccess extends MissedCallOtpUIState {
        public static final ResendOTPSuccess INSTANCE = new ResendOTPSuccess();

        private ResendOTPSuccess() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00048\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010"}, d2 = {"Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$MissedCallOtpPermission;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "PlaceComponentResult", "()Z", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "p1", "<init>", "(ZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class MissedCallOtpPermission extends MissedCallOtpUIState {
        private final boolean BuiltInFictitiousFunctionClassFactory;
        private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof MissedCallOtpPermission) {
                MissedCallOtpPermission missedCallOtpPermission = (MissedCallOtpPermission) p0;
                return this.BuiltInFictitiousFunctionClassFactory == missedCallOtpPermission.BuiltInFictitiousFunctionClassFactory && this.KClassImpl$Data$declaredNonStaticMembers$2 == missedCallOtpPermission.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public final int hashCode() {
            boolean z = this.BuiltInFictitiousFunctionClassFactory;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            boolean z2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            return (r0 * 31) + (z2 ? 1 : z2 ? 1 : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("MissedCallOtpPermission(BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(')');
            return sb.toString();
        }

        public MissedCallOtpPermission(boolean z, boolean z2) {
            super(null);
            this.BuiltInFictitiousFunctionClassFactory = z;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z2;
        }

        @JvmName(name = "MyBillsEntityDataFactory")
        /* renamed from: MyBillsEntityDataFactory  reason: from getter */
        public final boolean getBuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        @JvmName(name = "PlaceComponentResult")
        /* renamed from: PlaceComponentResult  reason: from getter */
        public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$VerifyFailed;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "PlaceComponentResult", "Lid/dana/utils/StringWrapper;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/utils/StringWrapper;", "p1", "<init>", "(Ljava/lang/String;Lid/dana/utils/StringWrapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class VerifyFailed extends MissedCallOtpUIState {
        final StringWrapper BuiltInFictitiousFunctionClassFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final String PlaceComponentResult;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof VerifyFailed) {
                VerifyFailed verifyFailed = (VerifyFailed) p0;
                return Intrinsics.areEqual(this.PlaceComponentResult, verifyFailed.PlaceComponentResult) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, verifyFailed.BuiltInFictitiousFunctionClassFactory);
            }
            return false;
        }

        public final int hashCode() {
            return (this.PlaceComponentResult.hashCode() * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("VerifyFailed(PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VerifyFailed(String str, StringWrapper stringWrapper) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(stringWrapper, "");
            this.PlaceComponentResult = str;
            this.BuiltInFictitiousFunctionClassFactory = stringWrapper;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$VerifyInvalidOtp;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "Ljava/lang/String;", "Lid/dana/utils/StringWrapper;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/utils/StringWrapper;", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "<init>", "(Ljava/lang/String;Lid/dana/utils/StringWrapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class VerifyInvalidOtp extends MissedCallOtpUIState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final StringWrapper KClassImpl$Data$declaredNonStaticMembers$2;
        public final String PlaceComponentResult;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof VerifyInvalidOtp) {
                VerifyInvalidOtp verifyInvalidOtp = (VerifyInvalidOtp) p0;
                return Intrinsics.areEqual(this.PlaceComponentResult, verifyInvalidOtp.PlaceComponentResult) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, verifyInvalidOtp.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            return false;
        }

        public final int hashCode() {
            return (this.PlaceComponentResult.hashCode() * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("VerifyInvalidOtp(PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VerifyInvalidOtp(String str, StringWrapper stringWrapper) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(stringWrapper, "");
            this.PlaceComponentResult = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = stringWrapper;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$VerifyExpired;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "Lid/dana/utils/StringWrapper;", "PlaceComponentResult", "Lid/dana/utils/StringWrapper;", "MyBillsEntityDataFactory", "p1", "<init>", "(Ljava/lang/String;Lid/dana/utils/StringWrapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class VerifyExpired extends MissedCallOtpUIState {
        public final String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final StringWrapper MyBillsEntityDataFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof VerifyExpired) {
                VerifyExpired verifyExpired = (VerifyExpired) p0;
                return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, verifyExpired.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, verifyExpired.MyBillsEntityDataFactory);
            }
            return false;
        }

        public final int hashCode() {
            return (this.BuiltInFictitiousFunctionClassFactory.hashCode() * 31) + this.MyBillsEntityDataFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("VerifyExpired(BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VerifyExpired(String str, StringWrapper stringWrapper) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(stringWrapper, "");
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.MyBillsEntityDataFactory = stringWrapper;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState$VerifySuccess;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpUIState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class VerifySuccess extends MissedCallOtpUIState {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final String KClassImpl$Data$declaredNonStaticMembers$2;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof VerifySuccess) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, ((VerifySuccess) p0).KClassImpl$Data$declaredNonStaticMembers$2);
        }

        public final int hashCode() {
            String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("VerifySuccess(KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(')');
            return sb.toString();
        }

        public VerifySuccess(String str) {
            super(null);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        }
    }
}

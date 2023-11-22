package id.dana.riskChallenges.ui.otp;

import id.dana.riskChallenges.domain.model.RequestOtpModel;
import id.dana.utils.StringWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u000f\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u000f\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !"}, d2 = {"Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState;", "", "<init>", "()V", "AccountFreeze", "DismissProgress", "None", "OnAutoFillSmsOtp", "OnErrorDailyLimit", "OnErrorFirstTimeRequestOtp", "OnErrorRequestOtp", "OnSuccessRequestOtp", "ShowProgress", "TooManyVerifyOtp", "VerifyExpired", "VerifyFailed", "VerifyInvalidOtp", "VerifyProgress", "VerifySuccess", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$None;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$ShowProgress;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$DismissProgress;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$OnSuccessRequestOtp;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$OnErrorRequestOtp;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$OnErrorFirstTimeRequestOtp;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$OnErrorDailyLimit;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$OnAutoFillSmsOtp;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$VerifyProgress;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$VerifyFailed;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$VerifyInvalidOtp;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$AccountFreeze;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$VerifyExpired;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$VerifySuccess;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$TooManyVerifyOtp;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class OtpChallengeUIState {
    public /* synthetic */ OtpChallengeUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private OtpChallengeUIState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$None;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class None extends OtpChallengeUIState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$ShowProgress;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ShowProgress extends OtpChallengeUIState {
        public static final ShowProgress INSTANCE = new ShowProgress();

        private ShowProgress() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$DismissProgress;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DismissProgress extends OtpChallengeUIState {
        public static final DismissProgress INSTANCE = new DismissProgress();

        private DismissProgress() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$OnSuccessRequestOtp;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/riskChallenges/domain/model/RequestOtpModel;", "PlaceComponentResult", "Lid/dana/riskChallenges/domain/model/RequestOtpModel;", "MyBillsEntityDataFactory", "<init>", "(Lid/dana/riskChallenges/domain/model/RequestOtpModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class OnSuccessRequestOtp extends OtpChallengeUIState {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final RequestOtpModel MyBillsEntityDataFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof OnSuccessRequestOtp) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, ((OnSuccessRequestOtp) p0).MyBillsEntityDataFactory);
        }

        public final int hashCode() {
            return this.MyBillsEntityDataFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("OnSuccessRequestOtp(MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSuccessRequestOtp(RequestOtpModel requestOtpModel) {
            super(null);
            Intrinsics.checkNotNullParameter(requestOtpModel, "");
            this.MyBillsEntityDataFactory = requestOtpModel;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\r\u001a\u00020\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$OnErrorRequestOtp;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/String;", "PlaceComponentResult", "Lid/dana/utils/StringWrapper;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/utils/StringWrapper;", "p1", "<init>", "(Ljava/lang/String;Lid/dana/utils/StringWrapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class OnErrorRequestOtp extends OtpChallengeUIState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final StringWrapper getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final String PlaceComponentResult;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof OnErrorRequestOtp) {
                OnErrorRequestOtp onErrorRequestOtp = (OnErrorRequestOtp) p0;
                return Intrinsics.areEqual(this.PlaceComponentResult, onErrorRequestOtp.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, onErrorRequestOtp.getAuthRequestContext);
            }
            return false;
        }

        public final int hashCode() {
            return (this.PlaceComponentResult.hashCode() * 31) + this.getAuthRequestContext.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("OnErrorRequestOtp(PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnErrorRequestOtp(String str, StringWrapper stringWrapper) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(stringWrapper, "");
            this.PlaceComponentResult = str;
            this.getAuthRequestContext = stringWrapper;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\r\u001a\u00020\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$OnErrorFirstTimeRequestOtp;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/utils/StringWrapper;", "PlaceComponentResult", "Lid/dana/utils/StringWrapper;", "p1", "<init>", "(Ljava/lang/String;Lid/dana/utils/StringWrapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class OnErrorFirstTimeRequestOtp extends OtpChallengeUIState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final StringWrapper MyBillsEntityDataFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof OnErrorFirstTimeRequestOtp) {
                OnErrorFirstTimeRequestOtp onErrorFirstTimeRequestOtp = (OnErrorFirstTimeRequestOtp) p0;
                return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, onErrorFirstTimeRequestOtp.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, onErrorFirstTimeRequestOtp.MyBillsEntityDataFactory);
            }
            return false;
        }

        public final int hashCode() {
            return (this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode() * 31) + this.MyBillsEntityDataFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("OnErrorFirstTimeRequestOtp(KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnErrorFirstTimeRequestOtp(String str, StringWrapper stringWrapper) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(stringWrapper, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.MyBillsEntityDataFactory = stringWrapper;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e"}, d2 = {"Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$OnErrorDailyLimit;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/String;", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "p1", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class OnErrorDailyLimit extends OtpChallengeUIState {
        public final String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final String PlaceComponentResult;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof OnErrorDailyLimit) {
                OnErrorDailyLimit onErrorDailyLimit = (OnErrorDailyLimit) p0;
                return Intrinsics.areEqual(this.PlaceComponentResult, onErrorDailyLimit.PlaceComponentResult) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, onErrorDailyLimit.BuiltInFictitiousFunctionClassFactory);
            }
            return false;
        }

        public final int hashCode() {
            return (this.PlaceComponentResult.hashCode() * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("OnErrorDailyLimit(PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnErrorDailyLimit(String str, String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.PlaceComponentResult = str;
            this.BuiltInFictitiousFunctionClassFactory = str2;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$OnAutoFillSmsOtp;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "getAuthRequestContext", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class OnAutoFillSmsOtp extends OtpChallengeUIState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final String getAuthRequestContext;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof OnAutoFillSmsOtp) && Intrinsics.areEqual(this.getAuthRequestContext, ((OnAutoFillSmsOtp) p0).getAuthRequestContext);
        }

        public final int hashCode() {
            return this.getAuthRequestContext.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("OnAutoFillSmsOtp(getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnAutoFillSmsOtp(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.getAuthRequestContext = str;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$VerifyProgress;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class VerifyProgress extends OtpChallengeUIState {
        public static final VerifyProgress INSTANCE = new VerifyProgress();

        private VerifyProgress() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\r\u001a\u00020\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$VerifyFailed;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Lid/dana/utils/StringWrapper;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/utils/StringWrapper;", "p1", "<init>", "(Ljava/lang/String;Lid/dana/utils/StringWrapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class VerifyFailed extends OtpChallengeUIState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final String MyBillsEntityDataFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final StringWrapper BuiltInFictitiousFunctionClassFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof VerifyFailed) {
                VerifyFailed verifyFailed = (VerifyFailed) p0;
                return Intrinsics.areEqual(this.MyBillsEntityDataFactory, verifyFailed.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, verifyFailed.BuiltInFictitiousFunctionClassFactory);
            }
            return false;
        }

        public final int hashCode() {
            return (this.MyBillsEntityDataFactory.hashCode() * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("VerifyFailed(MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
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
            this.MyBillsEntityDataFactory = str;
            this.BuiltInFictitiousFunctionClassFactory = stringWrapper;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\u0013\u001a\u00020\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$VerifyInvalidOtp;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "getAuthRequestContext", "Lid/dana/utils/StringWrapper;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/utils/StringWrapper;", "PlaceComponentResult", "p1", "<init>", "(Ljava/lang/String;Lid/dana/utils/StringWrapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class VerifyInvalidOtp extends OtpChallengeUIState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final StringWrapper PlaceComponentResult;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final String getAuthRequestContext;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof VerifyInvalidOtp) {
                VerifyInvalidOtp verifyInvalidOtp = (VerifyInvalidOtp) p0;
                return Intrinsics.areEqual(this.getAuthRequestContext, verifyInvalidOtp.getAuthRequestContext) && Intrinsics.areEqual(this.PlaceComponentResult, verifyInvalidOtp.PlaceComponentResult);
            }
            return false;
        }

        public final int hashCode() {
            return (this.getAuthRequestContext.hashCode() * 31) + this.PlaceComponentResult.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("VerifyInvalidOtp(getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VerifyInvalidOtp(String str, StringWrapper stringWrapper) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(stringWrapper, "");
            this.getAuthRequestContext = str;
            this.PlaceComponentResult = stringWrapper;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\r\u001a\u00020\u0004X\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$AccountFreeze;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "MyBillsEntityDataFactory", "getAuthRequestContext", "Z", "p1", "<init>", "(Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class AccountFreeze extends OtpChallengeUIState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final String MyBillsEntityDataFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final boolean BuiltInFictitiousFunctionClassFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof AccountFreeze) {
                AccountFreeze accountFreeze = (AccountFreeze) p0;
                return Intrinsics.areEqual(this.MyBillsEntityDataFactory, accountFreeze.MyBillsEntityDataFactory) && this.BuiltInFictitiousFunctionClassFactory == accountFreeze.BuiltInFictitiousFunctionClassFactory;
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
            sb.append("AccountFreeze(MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AccountFreeze(String str, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.MyBillsEntityDataFactory = str;
            this.BuiltInFictitiousFunctionClassFactory = z;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$VerifyExpired;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class VerifyExpired extends OtpChallengeUIState {
        public static final VerifyExpired INSTANCE = new VerifyExpired();

        private VerifyExpired() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$VerifySuccess;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "Ljava/lang/String;", "getAuthRequestContext", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class VerifySuccess extends OtpChallengeUIState {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final String getAuthRequestContext;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof VerifySuccess) && Intrinsics.areEqual(this.getAuthRequestContext, ((VerifySuccess) p0).getAuthRequestContext);
        }

        public final int hashCode() {
            String str = this.getAuthRequestContext;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("VerifySuccess(getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(')');
            return sb.toString();
        }

        public VerifySuccess(String str) {
            super(null);
            this.getAuthRequestContext = str;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState$TooManyVerifyOtp;", "Lid/dana/riskChallenges/ui/otp/OtpChallengeUIState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class TooManyVerifyOtp extends OtpChallengeUIState {
        public static final TooManyVerifyOtp INSTANCE = new TooManyVerifyOtp();

        private TooManyVerifyOtp() {
            super(null);
        }
    }
}

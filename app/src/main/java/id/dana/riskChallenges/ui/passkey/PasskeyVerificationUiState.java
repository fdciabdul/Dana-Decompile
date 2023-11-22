package id.dana.riskChallenges.ui.passkey;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationUiState;", "", "<init>", "()V", "LoginPasskeyFailed", "LoginPasskeySucceed", "None", "OnPasskeyAuthStartFailed", "OnPasskeyAuthStartFailedRisk", "OnPasskeyPromptOpen", "Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationUiState$None;", "Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationUiState$OnPasskeyPromptOpen;", "Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationUiState$LoginPasskeySucceed;", "Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationUiState$OnPasskeyAuthStartFailed;", "Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationUiState$OnPasskeyAuthStartFailedRisk;", "Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationUiState$LoginPasskeyFailed;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class PasskeyVerificationUiState {
    public /* synthetic */ PasskeyVerificationUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationUiState$None;", "Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class None extends PasskeyVerificationUiState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    private PasskeyVerificationUiState() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationUiState$OnPasskeyPromptOpen;", "Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationUiState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class OnPasskeyPromptOpen extends PasskeyVerificationUiState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final String KClassImpl$Data$declaredNonStaticMembers$2;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof OnPasskeyPromptOpen) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, ((OnPasskeyPromptOpen) p0).KClassImpl$Data$declaredNonStaticMembers$2);
        }

        public final int hashCode() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("OnPasskeyPromptOpen(KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnPasskeyPromptOpen(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationUiState$LoginPasskeySucceed;", "Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationUiState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "Ljava/lang/String;", "MyBillsEntityDataFactory", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class LoginPasskeySucceed extends PasskeyVerificationUiState {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final String MyBillsEntityDataFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof LoginPasskeySucceed) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, ((LoginPasskeySucceed) p0).MyBillsEntityDataFactory);
        }

        public final int hashCode() {
            return this.MyBillsEntityDataFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LoginPasskeySucceed(MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoginPasskeySucceed(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.MyBillsEntityDataFactory = str;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationUiState$OnPasskeyAuthStartFailed;", "Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationUiState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "MyBillsEntityDataFactory", "Ljava/lang/Throwable;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Ljava/lang/Throwable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class OnPasskeyAuthStartFailed extends PasskeyVerificationUiState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final Throwable KClassImpl$Data$declaredNonStaticMembers$2;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof OnPasskeyAuthStartFailed) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, ((OnPasskeyAuthStartFailed) p0).KClassImpl$Data$declaredNonStaticMembers$2);
        }

        public final int hashCode() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("OnPasskeyAuthStartFailed(KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnPasskeyAuthStartFailed(Throwable th) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = th;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationUiState$OnPasskeyAuthStartFailedRisk;", "Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationUiState;", "", "PlaceComponentResult", "Ljava/lang/Throwable;", "p0", "<init>", "(Ljava/lang/Throwable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnPasskeyAuthStartFailedRisk extends PasskeyVerificationUiState {
        final Throwable PlaceComponentResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnPasskeyAuthStartFailedRisk(Throwable th) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "");
            this.PlaceComponentResult = th;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationUiState$LoginPasskeyFailed;", "Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationUiState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/Throwable;", "MyBillsEntityDataFactory", "<init>", "(Ljava/lang/Throwable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class LoginPasskeyFailed extends PasskeyVerificationUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final Throwable MyBillsEntityDataFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof LoginPasskeyFailed) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, ((LoginPasskeyFailed) p0).MyBillsEntityDataFactory);
        }

        public final int hashCode() {
            return this.MyBillsEntityDataFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LoginPasskeyFailed(MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoginPasskeyFailed(Throwable th) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "");
            this.MyBillsEntityDataFactory = th;
        }
    }
}

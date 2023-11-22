package id.dana.riskChallenges.ui.passkey.main;

import id.dana.riskChallenges.domain.passkey.model.PasskeyEnrollmentWithRiskChallenges;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainUiState;", "", "<init>", "()V", "GotoEnrollmentSuccess", "None", "OnPasskeyEnrollmentFinishFailed", "OnPasskeyEnrollmentStartFailed", "OnPasskeyEnrollmentStartFailedRisk", "OnPasskeyPromptNeedVerificationMethods", "OnPasskeyPromptOpen", "Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainUiState$None;", "Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainUiState$GotoEnrollmentSuccess;", "Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainUiState$OnPasskeyEnrollmentStartFailed;", "Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainUiState$OnPasskeyEnrollmentStartFailedRisk;", "Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainUiState$OnPasskeyEnrollmentFinishFailed;", "Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainUiState$OnPasskeyPromptOpen;", "Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainUiState$OnPasskeyPromptNeedVerificationMethods;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class EnrollmentMainUiState {
    public /* synthetic */ EnrollmentMainUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainUiState$None;", "Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class None extends EnrollmentMainUiState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    private EnrollmentMainUiState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainUiState$GotoEnrollmentSuccess;", "Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class GotoEnrollmentSuccess extends EnrollmentMainUiState {
        public static final GotoEnrollmentSuccess INSTANCE = new GotoEnrollmentSuccess();

        private GotoEnrollmentSuccess() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainUiState$OnPasskeyEnrollmentStartFailed;", "Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnPasskeyEnrollmentStartFailed extends EnrollmentMainUiState {
        public OnPasskeyEnrollmentStartFailed() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainUiState$OnPasskeyEnrollmentStartFailedRisk;", "Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainUiState;", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "getAuthRequestContext", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnPasskeyEnrollmentStartFailedRisk extends EnrollmentMainUiState {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final String getAuthRequestContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnPasskeyEnrollmentStartFailedRisk(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.getAuthRequestContext = str;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainUiState$OnPasskeyEnrollmentFinishFailed;", "Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnPasskeyEnrollmentFinishFailed extends EnrollmentMainUiState {
        public OnPasskeyEnrollmentFinishFailed() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainUiState$OnPasskeyPromptOpen;", "Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainUiState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class OnPasskeyPromptOpen extends EnrollmentMainUiState {
        final String BuiltInFictitiousFunctionClassFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof OnPasskeyPromptOpen) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, ((OnPasskeyPromptOpen) p0).BuiltInFictitiousFunctionClassFactory);
        }

        public final int hashCode() {
            return this.BuiltInFictitiousFunctionClassFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("OnPasskeyPromptOpen(BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnPasskeyPromptOpen(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.BuiltInFictitiousFunctionClassFactory = str;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainUiState$OnPasskeyPromptNeedVerificationMethods;", "Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainUiState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/riskChallenges/domain/passkey/model/PasskeyEnrollmentWithRiskChallenges;", "getAuthRequestContext", "Lid/dana/riskChallenges/domain/passkey/model/PasskeyEnrollmentWithRiskChallenges;", "MyBillsEntityDataFactory", "<init>", "(Lid/dana/riskChallenges/domain/passkey/model/PasskeyEnrollmentWithRiskChallenges;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class OnPasskeyPromptNeedVerificationMethods extends EnrollmentMainUiState {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final PasskeyEnrollmentWithRiskChallenges MyBillsEntityDataFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof OnPasskeyPromptNeedVerificationMethods) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, ((OnPasskeyPromptNeedVerificationMethods) p0).MyBillsEntityDataFactory);
        }

        public final int hashCode() {
            return this.MyBillsEntityDataFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("OnPasskeyPromptNeedVerificationMethods(MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnPasskeyPromptNeedVerificationMethods(PasskeyEnrollmentWithRiskChallenges passkeyEnrollmentWithRiskChallenges) {
            super(null);
            Intrinsics.checkNotNullParameter(passkeyEnrollmentWithRiskChallenges, "");
            this.MyBillsEntityDataFactory = passkeyEnrollmentWithRiskChallenges;
        }
    }
}

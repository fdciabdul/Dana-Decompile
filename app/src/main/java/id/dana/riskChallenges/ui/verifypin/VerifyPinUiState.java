package id.dana.riskChallenges.ui.verifypin;

import id.dana.riskChallenges.ui.verifypin.model.VerifyPinModel;
import id.dana.utils.StringWrapper;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011"}, d2 = {"Lid/dana/riskChallenges/ui/verifypin/VerifyPinUiState;", "", "<init>", "()V", "None", "OnCheckKnowledgeBasedAuthFeatureSuccess", "VerifyFailed", "VerifyLoading", "VerifyPINIncorrect", "VerifyPINOneHourLoginFreeze", "VerifySuccess", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinUiState$None;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinUiState$VerifyLoading;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinUiState$VerifySuccess;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinUiState$VerifyPINIncorrect;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinUiState$VerifyPINOneHourLoginFreeze;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinUiState$VerifyFailed;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinUiState$OnCheckKnowledgeBasedAuthFeatureSuccess;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class VerifyPinUiState {
    public /* synthetic */ VerifyPinUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private VerifyPinUiState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/verifypin/VerifyPinUiState$None;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class None extends VerifyPinUiState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/verifypin/VerifyPinUiState$VerifyLoading;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class VerifyLoading extends VerifyPinUiState {
        public static final VerifyLoading INSTANCE = new VerifyLoading();

        private VerifyLoading() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/riskChallenges/ui/verifypin/VerifyPinUiState$VerifySuccess;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinUiState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/riskChallenges/ui/verifypin/model/VerifyPinModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/riskChallenges/ui/verifypin/model/VerifyPinModel;", "PlaceComponentResult", "getAuthRequestContext", "Ljava/lang/String;", "MyBillsEntityDataFactory", "p1", "<init>", "(Lid/dana/riskChallenges/ui/verifypin/model/VerifyPinModel;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class VerifySuccess extends VerifyPinUiState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final VerifyPinModel PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final String MyBillsEntityDataFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof VerifySuccess) {
                VerifySuccess verifySuccess = (VerifySuccess) p0;
                return Intrinsics.areEqual(this.PlaceComponentResult, verifySuccess.PlaceComponentResult) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, verifySuccess.MyBillsEntityDataFactory);
            }
            return false;
        }

        public final int hashCode() {
            return (this.PlaceComponentResult.hashCode() * 31) + this.MyBillsEntityDataFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("VerifySuccess(PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VerifySuccess(VerifyPinModel verifyPinModel, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(verifyPinModel, "");
            Intrinsics.checkNotNullParameter(str, "");
            this.PlaceComponentResult = verifyPinModel;
            this.MyBillsEntityDataFactory = str;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/riskChallenges/ui/verifypin/VerifyPinUiState$VerifyPINIncorrect;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinUiState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/utils/StringWrapper;", "PlaceComponentResult", "Lid/dana/utils/StringWrapper;", "p1", "<init>", "(Ljava/lang/String;Lid/dana/utils/StringWrapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class VerifyPINIncorrect extends VerifyPinUiState {
        public final StringWrapper PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof VerifyPINIncorrect) {
                VerifyPINIncorrect verifyPINIncorrect = (VerifyPINIncorrect) p0;
                return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, verifyPINIncorrect.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.PlaceComponentResult, verifyPINIncorrect.PlaceComponentResult);
            }
            return false;
        }

        public final int hashCode() {
            return (this.BuiltInFictitiousFunctionClassFactory.hashCode() * 31) + this.PlaceComponentResult.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("VerifyPINIncorrect(BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VerifyPINIncorrect(String str, StringWrapper stringWrapper) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(stringWrapper, "");
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.PlaceComponentResult = stringWrapper;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/verifypin/VerifyPinUiState$VerifyPINOneHourLoginFreeze;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class VerifyPINOneHourLoginFreeze extends VerifyPinUiState {
        public static final VerifyPINOneHourLoginFreeze INSTANCE = new VerifyPINOneHourLoginFreeze();

        private VerifyPINOneHourLoginFreeze() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/riskChallenges/ui/verifypin/VerifyPinUiState$VerifyFailed;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinUiState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "Lid/dana/utils/StringWrapper;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/utils/StringWrapper;", "p1", "<init>", "(Ljava/lang/String;Lid/dana/utils/StringWrapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class VerifyFailed extends VerifyPinUiState {
        public final StringWrapper BuiltInFictitiousFunctionClassFactory;
        public final String MyBillsEntityDataFactory;

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

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/verifypin/VerifyPinUiState$OnCheckKnowledgeBasedAuthFeatureSuccess;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinUiState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "()Z", "getAuthRequestContext", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class OnCheckKnowledgeBasedAuthFeatureSuccess extends VerifyPinUiState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private final boolean getAuthRequestContext;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof OnCheckKnowledgeBasedAuthFeatureSuccess) && this.getAuthRequestContext == ((OnCheckKnowledgeBasedAuthFeatureSuccess) p0).getAuthRequestContext;
        }

        public final int hashCode() {
            boolean z = this.getAuthRequestContext;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("OnCheckKnowledgeBasedAuthFeatureSuccess(getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(')');
            return sb.toString();
        }

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
        public final boolean getGetAuthRequestContext() {
            return this.getAuthRequestContext;
        }

        public OnCheckKnowledgeBasedAuthFeatureSuccess(boolean z) {
            super(null);
            this.getAuthRequestContext = z;
        }
    }
}

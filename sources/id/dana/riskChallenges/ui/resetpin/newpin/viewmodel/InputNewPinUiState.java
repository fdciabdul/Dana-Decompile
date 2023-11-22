package id.dana.riskChallenges.ui.resetpin.newpin.viewmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/newpin/viewmodel/InputNewPinUiState;", "", "<init>", "()V", "None", "PinRepetitive", "PinSequential", "PinValid", "Lid/dana/riskChallenges/ui/resetpin/newpin/viewmodel/InputNewPinUiState$None;", "Lid/dana/riskChallenges/ui/resetpin/newpin/viewmodel/InputNewPinUiState$PinSequential;", "Lid/dana/riskChallenges/ui/resetpin/newpin/viewmodel/InputNewPinUiState$PinRepetitive;", "Lid/dana/riskChallenges/ui/resetpin/newpin/viewmodel/InputNewPinUiState$PinValid;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class InputNewPinUiState {
    public /* synthetic */ InputNewPinUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private InputNewPinUiState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/newpin/viewmodel/InputNewPinUiState$None;", "Lid/dana/riskChallenges/ui/resetpin/newpin/viewmodel/InputNewPinUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class None extends InputNewPinUiState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/newpin/viewmodel/InputNewPinUiState$PinSequential;", "Lid/dana/riskChallenges/ui/resetpin/newpin/viewmodel/InputNewPinUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class PinSequential extends InputNewPinUiState {
        public static final PinSequential INSTANCE = new PinSequential();

        private PinSequential() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/newpin/viewmodel/InputNewPinUiState$PinRepetitive;", "Lid/dana/riskChallenges/ui/resetpin/newpin/viewmodel/InputNewPinUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class PinRepetitive extends InputNewPinUiState {
        public static final PinRepetitive INSTANCE = new PinRepetitive();

        private PinRepetitive() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/newpin/viewmodel/InputNewPinUiState$PinValid;", "Lid/dana/riskChallenges/ui/resetpin/newpin/viewmodel/InputNewPinUiState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "PlaceComponentResult", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class PinValid extends InputNewPinUiState {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final String PlaceComponentResult;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof PinValid) && Intrinsics.areEqual(this.PlaceComponentResult, ((PinValid) p0).PlaceComponentResult);
        }

        public final int hashCode() {
            return this.PlaceComponentResult.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PinValid(PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PinValid(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.PlaceComponentResult = str;
        }
    }
}

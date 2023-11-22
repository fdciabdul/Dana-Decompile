package id.dana.riskChallenges.ui.callcsordiana.viewmodel;

import id.dana.domain.featureconfig.model.HelpButtonConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t"}, d2 = {"Lid/dana/riskChallenges/ui/callcsordiana/viewmodel/CallCsOrDianaUiState;", "", "<init>", "()V", "None", "OnErrorGetHelpButtonChatBotFeature", "OnGetHelpButtonChatBotFeature", "Lid/dana/riskChallenges/ui/callcsordiana/viewmodel/CallCsOrDianaUiState$None;", "Lid/dana/riskChallenges/ui/callcsordiana/viewmodel/CallCsOrDianaUiState$OnGetHelpButtonChatBotFeature;", "Lid/dana/riskChallenges/ui/callcsordiana/viewmodel/CallCsOrDianaUiState$OnErrorGetHelpButtonChatBotFeature;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class CallCsOrDianaUiState {
    public /* synthetic */ CallCsOrDianaUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CallCsOrDianaUiState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/callcsordiana/viewmodel/CallCsOrDianaUiState$None;", "Lid/dana/riskChallenges/ui/callcsordiana/viewmodel/CallCsOrDianaUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class None extends CallCsOrDianaUiState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000e\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/callcsordiana/viewmodel/CallCsOrDianaUiState$OnGetHelpButtonChatBotFeature;", "Lid/dana/riskChallenges/ui/callcsordiana/viewmodel/CallCsOrDianaUiState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/domain/featureconfig/model/HelpButtonConfig;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/featureconfig/model/HelpButtonConfig;", "<init>", "(Lid/dana/domain/featureconfig/model/HelpButtonConfig;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class OnGetHelpButtonChatBotFeature extends CallCsOrDianaUiState {
        public final HelpButtonConfig BuiltInFictitiousFunctionClassFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof OnGetHelpButtonChatBotFeature) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, ((OnGetHelpButtonChatBotFeature) p0).BuiltInFictitiousFunctionClassFactory);
        }

        public final int hashCode() {
            return this.BuiltInFictitiousFunctionClassFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("OnGetHelpButtonChatBotFeature(BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnGetHelpButtonChatBotFeature(HelpButtonConfig helpButtonConfig) {
            super(null);
            Intrinsics.checkNotNullParameter(helpButtonConfig, "");
            this.BuiltInFictitiousFunctionClassFactory = helpButtonConfig;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/callcsordiana/viewmodel/CallCsOrDianaUiState$OnErrorGetHelpButtonChatBotFeature;", "Lid/dana/riskChallenges/ui/callcsordiana/viewmodel/CallCsOrDianaUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnErrorGetHelpButtonChatBotFeature extends CallCsOrDianaUiState {
        public static final OnErrorGetHelpButtonChatBotFeature INSTANCE = new OnErrorGetHelpButtonChatBotFeature();

        private OnErrorGetHelpButtonChatBotFeature() {
            super(null);
        }
    }
}

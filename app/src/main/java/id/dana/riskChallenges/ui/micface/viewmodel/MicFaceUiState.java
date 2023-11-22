package id.dana.riskChallenges.ui.micface.viewmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b"}, d2 = {"Lid/dana/riskChallenges/ui/micface/viewmodel/MicFaceUiState;", "", "<init>", "()V", "None", "OnVerifyFaceAuthCancel", "OnVerifyFaceAuthFailed", "OnVerifyFaceAuthSuccess", "Lid/dana/riskChallenges/ui/micface/viewmodel/MicFaceUiState$None;", "Lid/dana/riskChallenges/ui/micface/viewmodel/MicFaceUiState$OnVerifyFaceAuthCancel;", "Lid/dana/riskChallenges/ui/micface/viewmodel/MicFaceUiState$OnVerifyFaceAuthSuccess;", "Lid/dana/riskChallenges/ui/micface/viewmodel/MicFaceUiState$OnVerifyFaceAuthFailed;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class MicFaceUiState {
    public /* synthetic */ MicFaceUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private MicFaceUiState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/micface/viewmodel/MicFaceUiState$None;", "Lid/dana/riskChallenges/ui/micface/viewmodel/MicFaceUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class None extends MicFaceUiState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/micface/viewmodel/MicFaceUiState$OnVerifyFaceAuthCancel;", "Lid/dana/riskChallenges/ui/micface/viewmodel/MicFaceUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnVerifyFaceAuthCancel extends MicFaceUiState {
        public static final OnVerifyFaceAuthCancel INSTANCE = new OnVerifyFaceAuthCancel();

        private OnVerifyFaceAuthCancel() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/micface/viewmodel/MicFaceUiState$OnVerifyFaceAuthSuccess;", "Lid/dana/riskChallenges/ui/micface/viewmodel/MicFaceUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnVerifyFaceAuthSuccess extends MicFaceUiState {
        public static final OnVerifyFaceAuthSuccess INSTANCE = new OnVerifyFaceAuthSuccess();

        private OnVerifyFaceAuthSuccess() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/ui/micface/viewmodel/MicFaceUiState$OnVerifyFaceAuthFailed;", "Lid/dana/riskChallenges/ui/micface/viewmodel/MicFaceUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnVerifyFaceAuthFailed extends MicFaceUiState {
        public static final OnVerifyFaceAuthFailed INSTANCE = new OnVerifyFaceAuthFailed();

        private OnVerifyFaceAuthFailed() {
            super(null);
        }
    }
}

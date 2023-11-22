package id.dana.riskChallenges.ui.passkey;

import androidx.view.ViewModel;
import id.dana.analytics.tracker.passkey.PasskeyTracker;
import id.dana.analytics.tracker.passkey.PasskeyTrackerImpl;
import id.dana.riskChallenges.domain.otp.interactor.VerifyOtp;
import id.dana.riskChallenges.domain.passkey.interactor.PasskeyCeremonyStart;
import id.dana.riskChallenges.ui.passkey.PasskeyVerificationUiState;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationViewModel;", "Landroidx/lifecycle/ViewModel;", "Lid/dana/analytics/tracker/passkey/PasskeyTracker;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationUiState;", "MyBillsEntityDataFactory", "Lkotlinx/coroutines/flow/MutableStateFlow;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/riskChallenges/domain/otp/interactor/VerifyOtp;", "getAuthRequestContext", "Lid/dana/riskChallenges/domain/otp/interactor/VerifyOtp;", "Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyCeremonyStart;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyCeremonyStart;", "Lid/dana/analytics/tracker/passkey/PasskeyTrackerImpl;", "PlaceComponentResult", "Lid/dana/analytics/tracker/passkey/PasskeyTrackerImpl;", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "p0", "p1", "p2", "<init>", "(Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyCeremonyStart;Lid/dana/riskChallenges/domain/otp/interactor/VerifyOtp;Lid/dana/analytics/tracker/passkey/PasskeyTrackerImpl;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PasskeyVerificationViewModel extends ViewModel implements PasskeyTracker {
    final PasskeyCeremonyStart BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final StateFlow<PasskeyVerificationUiState> PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final MutableStateFlow<PasskeyVerificationUiState> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final PasskeyTrackerImpl MyBillsEntityDataFactory;
    final VerifyOtp getAuthRequestContext;

    @Inject
    public PasskeyVerificationViewModel(PasskeyCeremonyStart passkeyCeremonyStart, VerifyOtp verifyOtp, PasskeyTrackerImpl passkeyTrackerImpl) {
        Intrinsics.checkNotNullParameter(passkeyCeremonyStart, "");
        Intrinsics.checkNotNullParameter(verifyOtp, "");
        Intrinsics.checkNotNullParameter(passkeyTrackerImpl, "");
        this.BuiltInFictitiousFunctionClassFactory = passkeyCeremonyStart;
        this.getAuthRequestContext = verifyOtp;
        this.MyBillsEntityDataFactory = passkeyTrackerImpl;
        MutableStateFlow<PasskeyVerificationUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(PasskeyVerificationUiState.None.INSTANCE);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = MutableStateFlow;
        this.PlaceComponentResult = FlowKt.asStateFlow(MutableStateFlow);
    }
}

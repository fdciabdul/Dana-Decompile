package id.dana.riskChallenges.di.module;

import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.di.module.ViewModelKey;
import id.dana.riskChallenges.di.RiskChallengesScope;
import id.dana.riskChallenges.ui.callcsordiana.viewmodel.CallCsOrDianaViewModel;
import id.dana.riskChallenges.ui.micface.viewmodel.MicFaceViewModel;
import id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpViewModel;
import id.dana.riskChallenges.ui.otp.viewmodel.OtpChallengeViewModel;
import id.dana.riskChallenges.ui.passkey.PasskeyVerificationViewModel;
import id.dana.riskChallenges.ui.passkey.main.EnrollmentMainViewModel;
import id.dana.riskChallenges.ui.resetpin.SelfUnfreezeViewModel;
import id.dana.riskChallenges.ui.resetpin.confirm.viewmodel.InputConfirmPinViewModel;
import id.dana.riskChallenges.ui.resetpin.newpin.viewmodel.InputNewPinViewModel;
import id.dana.riskChallenges.ui.verifypin.VerifyPinViewModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\rH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0010H'¢\u0006\u0004\b\u0005\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0012H'¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0015H'¢\u0006\u0004\b\u0013\u0010\u0016J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0017H'¢\u0006\u0004\b\u0013\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0019H'¢\u0006\u0004\b\u0005\u0010\u001aJ\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001bH'¢\u0006\u0004\b\u0013\u0010\u001cJ\u0017\u0010\u0013\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u001dH'¢\u0006\u0004\b\u0013\u0010\u001f"}, d2 = {"Lid/dana/riskChallenges/di/module/RiskChallengesViewModelModule;", "", "Lid/dana/riskChallenges/ui/callcsordiana/viewmodel/CallCsOrDianaViewModel;", "p0", "Landroidx/lifecycle/ViewModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/riskChallenges/ui/callcsordiana/viewmodel/CallCsOrDianaViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpViewModel;", "MyBillsEntityDataFactory", "(Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinViewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/riskChallenges/ui/resetpin/newpin/viewmodel/InputNewPinViewModel;", "PlaceComponentResult", "(Lid/dana/riskChallenges/ui/resetpin/newpin/viewmodel/InputNewPinViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/riskChallenges/ui/micface/viewmodel/MicFaceViewModel;", "(Lid/dana/riskChallenges/ui/micface/viewmodel/MicFaceViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/riskChallenges/ui/otp/viewmodel/OtpChallengeViewModel;", "getAuthRequestContext", "(Lid/dana/riskChallenges/ui/otp/viewmodel/OtpChallengeViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainViewModel;", "(Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationViewModel;", "(Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/riskChallenges/ui/resetpin/SelfUnfreezeViewModel;", "(Lid/dana/riskChallenges/ui/resetpin/SelfUnfreezeViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinViewModel;", "(Lid/dana/riskChallenges/ui/verifypin/VerifyPinViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/core/ui/di/module/ViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Lid/dana/core/ui/di/module/ViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes9.dex */
public abstract class RiskChallengesViewModelModule {
    @RiskChallengesScope
    @Binds
    @IntoMap
    @ViewModelKey(CallCsOrDianaViewModel.class)
    public abstract ViewModel BuiltInFictitiousFunctionClassFactory(CallCsOrDianaViewModel p0);

    @RiskChallengesScope
    @Binds
    @IntoMap
    @ViewModelKey(MicFaceViewModel.class)
    public abstract ViewModel BuiltInFictitiousFunctionClassFactory(MicFaceViewModel p0);

    @RiskChallengesScope
    @Binds
    @IntoMap
    @ViewModelKey(SelfUnfreezeViewModel.class)
    public abstract ViewModel BuiltInFictitiousFunctionClassFactory(SelfUnfreezeViewModel p0);

    @RiskChallengesScope
    @Binds
    @IntoMap
    @ViewModelKey(InputConfirmPinViewModel.class)
    public abstract ViewModel KClassImpl$Data$declaredNonStaticMembers$2(InputConfirmPinViewModel p0);

    @RiskChallengesScope
    @Binds
    @IntoMap
    @ViewModelKey(MissedCallOtpViewModel.class)
    public abstract ViewModel MyBillsEntityDataFactory(MissedCallOtpViewModel p0);

    @RiskChallengesScope
    @Binds
    @IntoMap
    @ViewModelKey(InputNewPinViewModel.class)
    public abstract ViewModel PlaceComponentResult(InputNewPinViewModel p0);

    @RiskChallengesScope
    @Binds
    @IntoMap
    @ViewModelKey(OtpChallengeViewModel.class)
    public abstract ViewModel getAuthRequestContext(OtpChallengeViewModel p0);

    @RiskChallengesScope
    @Binds
    @IntoMap
    @ViewModelKey(PasskeyVerificationViewModel.class)
    public abstract ViewModel getAuthRequestContext(PasskeyVerificationViewModel p0);

    @RiskChallengesScope
    @Binds
    @IntoMap
    @ViewModelKey(EnrollmentMainViewModel.class)
    public abstract ViewModel getAuthRequestContext(EnrollmentMainViewModel p0);

    @RiskChallengesScope
    @Binds
    @IntoMap
    @ViewModelKey(VerifyPinViewModel.class)
    public abstract ViewModel getAuthRequestContext(VerifyPinViewModel p0);

    @RiskChallengesScope
    @Binds
    public abstract ViewModelProvider.Factory getAuthRequestContext(ViewModelFactory p0);
}

package id.dana.onboarding.welcome;

import dagger.Lazy;
import id.dana.analytics.tracker.register.RegistrationTracker;
import id.dana.base.AbstractContractKt;
import id.dana.onboarding.welcome.WelcomeContract;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/onboarding/welcome/WelcomePresenter;", "Lid/dana/onboarding/welcome/WelcomeContract$Presenter;", "", "PlaceComponentResult", "()V", "Ldagger/Lazy;", "Lid/dana/analytics/tracker/register/RegistrationTracker;", "getAuthRequestContext", "Ldagger/Lazy;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WelcomePresenter implements WelcomeContract.Presenter {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy<RegistrationTracker> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final /* synthetic */ void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Inject
    public WelcomePresenter(Lazy<RegistrationTracker> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy;
    }

    @Override // id.dana.onboarding.welcome.WelcomeContract.Presenter
    public final void PlaceComponentResult() {
        RegistrationTracker registrationTracker = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
        Intrinsics.checkNotNullExpressionValue(registrationTracker, "");
        registrationTracker.BuiltInFictitiousFunctionClassFactory();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().getAuthRequestContext();
    }
}

package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.onboarding.welcome.WelcomeContract;
import id.dana.onboarding.welcome.WelcomePresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/di/modules/WelcomeModule;", "", "Lid/dana/onboarding/welcome/WelcomePresenter;", "p0", "Lid/dana/onboarding/welcome/WelcomeContract$Presenter;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/onboarding/welcome/WelcomePresenter;)Lid/dana/onboarding/welcome/WelcomeContract$Presenter;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class WelcomeModule {
    @Provides
    public final WelcomeContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(WelcomePresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
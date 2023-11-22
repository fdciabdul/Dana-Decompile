package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.challenge.verifypush.VerifyPushContract;
import id.dana.challenge.verifypush.VerifyPushLoginPresenter;
import id.dana.di.PerActivity;
import id.dana.di.PerModule;
import id.dana.twilio.tracker.TwilioAnalyticTracker;
import id.dana.twilio.tracker.TwilioMixpanelTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\t\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\t\u0010\fR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/di/modules/VerifyPushChallengeModule;", "", "Lid/dana/twilio/tracker/TwilioMixpanelTracker;", "p0", "Lid/dana/twilio/tracker/TwilioAnalyticTracker;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/twilio/tracker/TwilioMixpanelTracker;)Lid/dana/twilio/tracker/TwilioAnalyticTracker;", "Lid/dana/challenge/verifypush/VerifyPushLoginPresenter;", "Lid/dana/challenge/verifypush/VerifyPushContract$Presenter;", "MyBillsEntityDataFactory", "(Lid/dana/challenge/verifypush/VerifyPushLoginPresenter;)Lid/dana/challenge/verifypush/VerifyPushContract$Presenter;", "Lid/dana/challenge/verifypush/VerifyPushContract$View;", "()Lid/dana/challenge/verifypush/VerifyPushContract$View;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/challenge/verifypush/VerifyPushContract$View;", "<init>", "(Lid/dana/challenge/verifypush/VerifyPushContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class VerifyPushChallengeModule {
    private final VerifyPushContract.View BuiltInFictitiousFunctionClassFactory;

    public VerifyPushChallengeModule(VerifyPushContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    @Provides
    @PerActivity
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final VerifyPushContract.View getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Provides
    @PerActivity
    public final VerifyPushContract.Presenter MyBillsEntityDataFactory(VerifyPushLoginPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    @PerModule
    public final TwilioAnalyticTracker KClassImpl$Data$declaredNonStaticMembers$2(TwilioMixpanelTracker p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}

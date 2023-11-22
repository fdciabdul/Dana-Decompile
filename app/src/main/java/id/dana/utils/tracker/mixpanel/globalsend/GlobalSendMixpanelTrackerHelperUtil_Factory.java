package id.dana.utils.tracker.mixpanel.globalsend;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class GlobalSendMixpanelTrackerHelperUtil_Factory implements Factory<GlobalSendMixpanelTrackerHelperUtil> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GlobalSendMixpanelTrackerHelperUtil(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}

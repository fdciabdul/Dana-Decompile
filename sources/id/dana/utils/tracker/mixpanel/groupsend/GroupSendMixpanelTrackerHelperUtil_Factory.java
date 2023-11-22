package id.dana.utils.tracker.mixpanel.groupsend;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class GroupSendMixpanelTrackerHelperUtil_Factory implements Factory<GroupSendMixpanelTrackerHelperUtil> {
    private final Provider<Context> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GroupSendMixpanelTrackerHelperUtil(this.getAuthRequestContext.get());
    }
}

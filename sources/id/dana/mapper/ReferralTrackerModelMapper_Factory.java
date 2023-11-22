package id.dana.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class ReferralTrackerModelMapper_Factory implements Factory<ReferralTrackerModelMapper> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class InstanceHolder {
        private static final ReferralTrackerModelMapper_Factory getAuthRequestContext = new ReferralTrackerModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ReferralTrackerModelMapper();
    }
}

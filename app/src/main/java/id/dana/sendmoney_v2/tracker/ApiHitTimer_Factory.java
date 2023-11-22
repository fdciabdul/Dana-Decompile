package id.dana.sendmoney_v2.tracker;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class ApiHitTimer_Factory implements Factory<ApiHitTimer> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class InstanceHolder {
        private static final ApiHitTimer_Factory getAuthRequestContext = new ApiHitTimer_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ApiHitTimer();
    }
}

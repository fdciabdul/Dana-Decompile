package id.dana.analytics.fullstory;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class FullStoryAnalytics_Factory implements Factory<FullStoryAnalytics> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class InstanceHolder {
        private static final FullStoryAnalytics_Factory MyBillsEntityDataFactory = new FullStoryAnalytics_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FullStoryAnalytics();
    }
}

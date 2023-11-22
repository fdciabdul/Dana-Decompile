package id.dana.mapper;

import dagger.internal.Factory;

/* loaded from: classes9.dex */
public final class LeaderboardMapper_Factory implements Factory<LeaderboardMapper> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class InstanceHolder {
        private static final LeaderboardMapper_Factory MyBillsEntityDataFactory = new LeaderboardMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new LeaderboardMapper();
    }
}

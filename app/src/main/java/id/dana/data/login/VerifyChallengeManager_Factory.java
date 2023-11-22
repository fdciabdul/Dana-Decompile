package id.dana.data.login;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class VerifyChallengeManager_Factory implements Factory<VerifyChallengeManager> {
    @Override // javax.inject.Provider
    public final VerifyChallengeManager get() {
        return newInstance();
    }

    public static VerifyChallengeManager_Factory create() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static VerifyChallengeManager newInstance() {
        return new VerifyChallengeManager();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final VerifyChallengeManager_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new VerifyChallengeManager_Factory();

        private InstanceHolder() {
        }
    }
}

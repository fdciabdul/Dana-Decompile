package id.dana.data.otp;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class OtpRetryManager_Factory implements Factory<OtpRetryManager> {
    @Override // javax.inject.Provider
    public final OtpRetryManager get() {
        return newInstance();
    }

    public static OtpRetryManager_Factory create() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static OtpRetryManager newInstance() {
        return new OtpRetryManager();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final OtpRetryManager_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new OtpRetryManager_Factory();

        private InstanceHolder() {
        }
    }
}

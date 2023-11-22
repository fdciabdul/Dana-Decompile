package id.dana.data.otp.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class OtpMapper_Factory implements Factory<OtpMapper> {
    @Override // javax.inject.Provider
    public final OtpMapper get() {
        return newInstance();
    }

    public static OtpMapper_Factory create() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    public static OtpMapper newInstance() {
        return new OtpMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final OtpMapper_Factory BuiltInFictitiousFunctionClassFactory = new OtpMapper_Factory();

        private InstanceHolder() {
        }
    }
}

package id.dana.data.otp.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class OtpBankMapper_Factory implements Factory<OtpBankMapper> {
    @Override // javax.inject.Provider
    public final OtpBankMapper get() {
        return newInstance();
    }

    public static OtpBankMapper_Factory create() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    public static OtpBankMapper newInstance() {
        return new OtpBankMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final OtpBankMapper_Factory BuiltInFictitiousFunctionClassFactory = new OtpBankMapper_Factory();

        private InstanceHolder() {
        }
    }
}

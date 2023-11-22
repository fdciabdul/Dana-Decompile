package id.dana.data.auth.face.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class FaceAuthenticationEntityMapper_Factory implements Factory<FaceAuthenticationEntityMapper> {
    @Override // javax.inject.Provider
    public final FaceAuthenticationEntityMapper get() {
        return newInstance();
    }

    public static FaceAuthenticationEntityMapper_Factory create() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static FaceAuthenticationEntityMapper newInstance() {
        return new FaceAuthenticationEntityMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final FaceAuthenticationEntityMapper_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new FaceAuthenticationEntityMapper_Factory();

        private InstanceHolder() {
        }
    }
}

package id.dana.data.oauth.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class OauthConfirmResultMapper_Factory implements Factory<OauthConfirmResultMapper> {
    @Override // javax.inject.Provider
    public final OauthConfirmResultMapper get() {
        return newInstance();
    }

    public static OauthConfirmResultMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static OauthConfirmResultMapper newInstance() {
        return new OauthConfirmResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final OauthConfirmResultMapper_Factory PlaceComponentResult = new OauthConfirmResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}

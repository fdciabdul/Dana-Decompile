package id.dana.base;

import dagger.internal.Factory;

/* loaded from: classes4.dex */
public final class BaseResponseMapper_Factory implements Factory<BaseResponseMapper> {
    public static BaseResponseMapper_Factory MyBillsEntityDataFactory() {
        return InstanceHolder.getAuthRequestContext;
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final BaseResponseMapper_Factory getAuthRequestContext = new BaseResponseMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new BaseResponseMapper();
    }
}

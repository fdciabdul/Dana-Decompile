package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class NameCheckParamMapper_Factory implements Factory<NameCheckParamMapper> {
    @Override // javax.inject.Provider
    public final NameCheckParamMapper get() {
        return newInstance();
    }

    public static NameCheckParamMapper_Factory create() {
        return InstanceHolder.getAuthRequestContext;
    }

    public static NameCheckParamMapper newInstance() {
        return new NameCheckParamMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final NameCheckParamMapper_Factory getAuthRequestContext = new NameCheckParamMapper_Factory();

        private InstanceHolder() {
        }
    }
}

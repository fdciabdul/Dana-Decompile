package id.dana.data.profilemenu.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class SettingsMapper_Factory implements Factory<SettingsMapper> {
    @Override // javax.inject.Provider
    public final SettingsMapper get() {
        return newInstance();
    }

    public static SettingsMapper_Factory create() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    public static SettingsMapper newInstance() {
        return new SettingsMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final SettingsMapper_Factory BuiltInFictitiousFunctionClassFactory = new SettingsMapper_Factory();

        private InstanceHolder() {
        }
    }
}

package id.dana.danah5.extension;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class DanaGriverAppLanguageExtension_Factory implements Factory<DanaGriverAppLanguageExtension> {
    @Override // javax.inject.Provider
    public final DanaGriverAppLanguageExtension get() {
        return newInstance();
    }

    public static DanaGriverAppLanguageExtension_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DanaGriverAppLanguageExtension newInstance() {
        return new DanaGriverAppLanguageExtension();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final DanaGriverAppLanguageExtension_Factory INSTANCE = new DanaGriverAppLanguageExtension_Factory();

        private InstanceHolder() {
        }
    }
}

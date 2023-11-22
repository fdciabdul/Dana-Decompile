package id.dana.danah5.extension;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class DanaGriverShareURLCreatorExtension_Factory implements Factory<DanaGriverShareURLCreatorExtension> {
    @Override // javax.inject.Provider
    public final DanaGriverShareURLCreatorExtension get() {
        return newInstance();
    }

    public static DanaGriverShareURLCreatorExtension_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DanaGriverShareURLCreatorExtension newInstance() {
        return new DanaGriverShareURLCreatorExtension();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final DanaGriverShareURLCreatorExtension_Factory INSTANCE = new DanaGriverShareURLCreatorExtension_Factory();

        private InstanceHolder() {
        }
    }
}

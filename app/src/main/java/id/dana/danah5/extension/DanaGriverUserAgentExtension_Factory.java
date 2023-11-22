package id.dana.danah5.extension;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class DanaGriverUserAgentExtension_Factory implements Factory<DanaGriverUserAgentExtension> {
    @Override // javax.inject.Provider
    public final DanaGriverUserAgentExtension get() {
        return newInstance();
    }

    public static DanaGriverUserAgentExtension_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DanaGriverUserAgentExtension newInstance() {
        return new DanaGriverUserAgentExtension();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final DanaGriverUserAgentExtension_Factory INSTANCE = new DanaGriverUserAgentExtension_Factory();

        private InstanceHolder() {
        }
    }
}

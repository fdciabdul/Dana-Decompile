package dagger.internal;

import dagger.MembersInjector;

/* loaded from: classes8.dex */
public final class MembersInjectors {

    /* loaded from: classes8.dex */
    enum NoOpMembersInjector implements MembersInjector<Object> {
        INSTANCE;

        public final void injectMembers(Object obj) {
            Preconditions.getAuthRequestContext(obj, "Cannot inject members into a null reference");
        }
    }

    private MembersInjectors() {
    }
}

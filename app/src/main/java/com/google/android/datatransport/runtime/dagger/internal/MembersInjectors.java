package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.MembersInjector;

/* loaded from: classes7.dex */
public final class MembersInjectors {
    public static <T> MembersInjector<T> noOp() {
        return NoOpMembersInjector.INSTANCE;
    }

    /* loaded from: classes7.dex */
    enum NoOpMembersInjector implements MembersInjector<Object> {
        INSTANCE;

        @Override // com.google.android.datatransport.runtime.dagger.MembersInjector
        public final void injectMembers(Object obj) {
            Preconditions.checkNotNull(obj, "Cannot inject members into a null reference");
        }
    }

    private MembersInjectors() {
    }
}

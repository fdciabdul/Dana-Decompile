package id.dana.data.synccontact.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class ContactSyncConfigMapper_Factory implements Factory<ContactSyncConfigMapper> {
    @Override // javax.inject.Provider
    public final ContactSyncConfigMapper get() {
        return newInstance();
    }

    public static ContactSyncConfigMapper_Factory create() {
        return InstanceHolder.getAuthRequestContext;
    }

    public static ContactSyncConfigMapper newInstance() {
        return new ContactSyncConfigMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final ContactSyncConfigMapper_Factory getAuthRequestContext = new ContactSyncConfigMapper_Factory();

        private InstanceHolder() {
        }
    }
}

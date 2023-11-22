package id.dana.data.content.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class ContentEntityMapper_Factory implements Factory<ContentEntityMapper> {
    @Override // javax.inject.Provider
    public final ContentEntityMapper get() {
        return newInstance();
    }

    public static ContentEntityMapper_Factory create() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static ContentEntityMapper newInstance() {
        return new ContentEntityMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final ContentEntityMapper_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new ContentEntityMapper_Factory();

        private InstanceHolder() {
        }
    }
}

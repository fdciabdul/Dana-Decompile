package id.dana.data.deeplink.repository.source.branch.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class BranchIoDeepLinkEntityMapper_Factory implements Factory<BranchIoDeepLinkEntityMapper> {
    @Override // javax.inject.Provider
    public final BranchIoDeepLinkEntityMapper get() {
        return newInstance();
    }

    public static BranchIoDeepLinkEntityMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static BranchIoDeepLinkEntityMapper newInstance() {
        return new BranchIoDeepLinkEntityMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final BranchIoDeepLinkEntityMapper_Factory PlaceComponentResult = new BranchIoDeepLinkEntityMapper_Factory();

        private InstanceHolder() {
        }
    }
}

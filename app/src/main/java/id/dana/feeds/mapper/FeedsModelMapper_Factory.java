package id.dana.feeds.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class FeedsModelMapper_Factory implements Factory<FeedsModelMapper> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class InstanceHolder {
        private static final FeedsModelMapper_Factory PlaceComponentResult = new FeedsModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedsModelMapper();
    }
}

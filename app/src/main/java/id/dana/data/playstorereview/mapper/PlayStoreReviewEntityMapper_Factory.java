package id.dana.data.playstorereview.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class PlayStoreReviewEntityMapper_Factory implements Factory<PlayStoreReviewEntityMapper> {
    @Override // javax.inject.Provider
    public final PlayStoreReviewEntityMapper get() {
        return newInstance();
    }

    public static PlayStoreReviewEntityMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static PlayStoreReviewEntityMapper newInstance() {
        return new PlayStoreReviewEntityMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final PlayStoreReviewEntityMapper_Factory PlaceComponentResult = new PlayStoreReviewEntityMapper_Factory();

        private InstanceHolder() {
        }
    }
}

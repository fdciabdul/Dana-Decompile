package id.dana.data.feeds.mapper;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class DeleteFeedResultMapper_Factory implements Factory<DeleteFeedResultMapper> {
    @Override // javax.inject.Provider
    public final DeleteFeedResultMapper get() {
        return newInstance();
    }

    public static DeleteFeedResultMapper_Factory create() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static DeleteFeedResultMapper newInstance() {
        return new DeleteFeedResultMapper();
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final DeleteFeedResultMapper_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new DeleteFeedResultMapper_Factory();

        private InstanceHolder() {
        }
    }
}

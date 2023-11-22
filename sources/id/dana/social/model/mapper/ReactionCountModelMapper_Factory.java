package id.dana.social.model.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class ReactionCountModelMapper_Factory implements Factory<ReactionCountModelMapper> {
    public static ReactionCountModelMapper_Factory MyBillsEntityDataFactory() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final ReactionCountModelMapper_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new ReactionCountModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ReactionCountModelMapper();
    }
}

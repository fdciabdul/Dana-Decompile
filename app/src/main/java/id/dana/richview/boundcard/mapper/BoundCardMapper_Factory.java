package id.dana.richview.boundcard.mapper;

import dagger.internal.Factory;

/* loaded from: classes9.dex */
public final class BoundCardMapper_Factory implements Factory<BoundCardMapper> {
    public static BoundCardMapper PlaceComponentResult() {
        return new BoundCardMapper();
    }

    /* loaded from: classes9.dex */
    static final class InstanceHolder {
        private static final BoundCardMapper_Factory MyBillsEntityDataFactory = new BoundCardMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new BoundCardMapper();
    }
}

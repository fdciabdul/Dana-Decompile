package id.dana.nearbyme.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class ShopOpenHourListMapper_Factory implements Factory<ShopOpenHourListMapper> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class InstanceHolder {
        private static final ShopOpenHourListMapper_Factory getAuthRequestContext = new ShopOpenHourListMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ShopOpenHourListMapper();
    }
}

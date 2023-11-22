package id.dana.phototips.mapper;

import dagger.internal.Factory;

/* loaded from: classes9.dex */
public final class PhotoTipsModelMapper_Factory implements Factory<PhotoTipsModelMapper> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class InstanceHolder {
        private static final PhotoTipsModelMapper_Factory PlaceComponentResult = new PhotoTipsModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PhotoTipsModelMapper();
    }
}

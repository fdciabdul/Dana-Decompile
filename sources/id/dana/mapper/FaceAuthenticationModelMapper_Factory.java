package id.dana.mapper;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class FaceAuthenticationModelMapper_Factory implements Factory<FaceAuthenticationModelMapper> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class InstanceHolder {
        private static final FaceAuthenticationModelMapper_Factory PlaceComponentResult = new FaceAuthenticationModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FaceAuthenticationModelMapper();
    }
}

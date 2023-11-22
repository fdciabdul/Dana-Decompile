package id.dana.richview.moreforyou;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class MoreForYouModelMapper_Factory implements Factory<MoreForYouModelMapper> {
    @Override // javax.inject.Provider
    public final MoreForYouModelMapper get() {
        return newInstance();
    }

    public static MoreForYouModelMapper_Factory create() {
        return InstanceHolder.PlaceComponentResult;
    }

    public static MoreForYouModelMapper newInstance() {
        return new MoreForYouModelMapper();
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final MoreForYouModelMapper_Factory PlaceComponentResult = new MoreForYouModelMapper_Factory();

        private InstanceHolder() {
        }
    }
}

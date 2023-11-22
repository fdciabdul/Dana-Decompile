package id.dana.utils;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class MapHelper_Factory implements Factory<MapHelper> {
    private final Provider<Context> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MapHelper(this.PlaceComponentResult.get());
    }
}

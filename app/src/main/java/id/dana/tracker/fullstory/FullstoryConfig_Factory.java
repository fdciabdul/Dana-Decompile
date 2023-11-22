package id.dana.tracker.fullstory;

import dagger.internal.Factory;
import id.dana.tracker.EventConfigProperty;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class FullstoryConfig_Factory implements Factory<FullstoryConfig> {
    private final Provider<EventConfigProperty> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FullstoryConfig(this.PlaceComponentResult.get());
    }
}

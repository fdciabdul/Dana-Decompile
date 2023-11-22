package id.dana.data.foundation.logger.rds;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class RDSTracker_Factory implements Factory<RDSTracker> {
    private final Provider<Context> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new RDSTracker(this.PlaceComponentResult.get());
    }
}

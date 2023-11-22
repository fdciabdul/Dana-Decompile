package androidx.core.location;

import android.location.LocationManager;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Callable;

/* loaded from: classes6.dex */
public final /* synthetic */ class LocationManagerCompat$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ LocationManager MyBillsEntityDataFactory;
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport getAuthRequestContext;

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Boolean valueOf;
        valueOf = Boolean.valueOf(this.MyBillsEntityDataFactory.addGpsStatusListener(this.getAuthRequestContext));
        return valueOf;
    }
}

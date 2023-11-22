package androidx.core.location;

import android.location.Location;
import j$.util.function.Consumer;

/* loaded from: classes6.dex */
public final /* synthetic */ class LocationManagerCompat$Api30Impl$$ExternalSyntheticLambda1 implements Consumer {
    public final /* synthetic */ androidx.core.util.Consumer BuiltInFictitiousFunctionClassFactory;

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        this.BuiltInFictitiousFunctionClassFactory.accept((Location) obj);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.PlaceComponentResult(this, consumer);
    }
}

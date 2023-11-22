package id.dana.utils.measureloadscreen;

import com.google.firebase.perf.metrics.Trace;
import id.dana.utils.measureloadscreen.FirstDrawListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004"}, d2 = {"Lid/dana/utils/measureloadscreen/MeasureLoadAndRenderingScreen$stopTracking$1;", "Lid/dana/utils/measureloadscreen/FirstDrawListener$OnFirstDrawCallback;", "", "getAuthRequestContext", "()V", "BuiltInFictitiousFunctionClassFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MeasureLoadAndRenderingScreen$stopTracking$1 implements FirstDrawListener.OnFirstDrawCallback {
    final /* synthetic */ MeasureLoadAndRenderingScreen MyBillsEntityDataFactory;

    @Override // id.dana.utils.measureloadscreen.FirstDrawListener.OnFirstDrawCallback
    public final void BuiltInFictitiousFunctionClassFactory() {
    }

    public MeasureLoadAndRenderingScreen$stopTracking$1(MeasureLoadAndRenderingScreen measureLoadAndRenderingScreen) {
        this.MyBillsEntityDataFactory = measureLoadAndRenderingScreen;
    }

    @Override // id.dana.utils.measureloadscreen.FirstDrawListener.OnFirstDrawCallback
    public final void getAuthRequestContext() {
        Trace trace = this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
        if (trace != null) {
            trace.stop();
        }
    }
}

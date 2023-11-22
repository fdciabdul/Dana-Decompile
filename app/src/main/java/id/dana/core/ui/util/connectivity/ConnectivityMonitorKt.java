package id.dana.core.ui.util.connectivity;

import android.os.Handler;
import android.os.Looper;
import androidx.view.LiveData;
import androidx.view.MediatorLiveData;
import androidx.view.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Landroidx/lifecycle/LiveData;", "", "p0", "Landroidx/lifecycle/MediatorLiveData;", "MyBillsEntityDataFactory", "(Landroidx/lifecycle/LiveData;J)Landroidx/lifecycle/MediatorLiveData;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConnectivityMonitorKt {
    public static final <T> MediatorLiveData<T> MyBillsEntityDataFactory(final LiveData<T> liveData, final long j) {
        Intrinsics.checkNotNullParameter(liveData, "");
        final MediatorLiveData<T> mediatorLiveData = new MediatorLiveData<>();
        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable runnable = new Runnable() { // from class: id.dana.core.ui.util.connectivity.ConnectivityMonitorKt$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ConnectivityMonitorKt.MyBillsEntityDataFactory(MediatorLiveData.this, liveData);
            }
        };
        mediatorLiveData.getAuthRequestContext(liveData, new Observer() { // from class: id.dana.core.ui.util.connectivity.ConnectivityMonitorKt$$ExternalSyntheticLambda1
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                ConnectivityMonitorKt.BuiltInFictitiousFunctionClassFactory(handler, runnable, j);
            }
        });
        return mediatorLiveData;
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(MediatorLiveData mediatorLiveData, LiveData liveData) {
        Intrinsics.checkNotNullParameter(mediatorLiveData, "");
        Intrinsics.checkNotNullParameter(liveData, "");
        Object obj = liveData.BuiltInFictitiousFunctionClassFactory;
        if (obj == LiveData.MyBillsEntityDataFactory) {
            obj = null;
        }
        mediatorLiveData.PlaceComponentResult((MediatorLiveData) obj);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Handler handler, Runnable runnable, long j) {
        Intrinsics.checkNotNullParameter(handler, "");
        Intrinsics.checkNotNullParameter(runnable, "");
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, j);
    }
}

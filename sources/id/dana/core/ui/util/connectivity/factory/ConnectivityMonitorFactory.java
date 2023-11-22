package id.dana.core.ui.util.connectivity.factory;

import android.content.Context;
import id.dana.core.ui.util.connectivity.ConnectivityMonitor;
import id.dana.core.ui.util.connectivity.ConnectivityWithSignalMonitor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u00020\u0002X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0003\u001a\u00020\u0006X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\t"}, d2 = {"Lid/dana/core/ui/util/connectivity/factory/ConnectivityMonitorFactory;", "", "Lid/dana/core/ui/util/connectivity/ConnectivityMonitor;", "PlaceComponentResult", "Lkotlin/Lazy;", "getAuthRequestContext", "Lid/dana/core/ui/util/connectivity/ConnectivityWithSignalMonitor;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConnectivityMonitorFactory {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Lazy PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Lazy getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Context BuiltInFictitiousFunctionClassFactory;

    public ConnectivityMonitorFactory(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.getAuthRequestContext = LazyKt.lazy(new Function0<ConnectivityMonitor>() { // from class: id.dana.core.ui.util.connectivity.factory.ConnectivityMonitorFactory$connectivityMonitor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConnectivityMonitor invoke() {
                Context context2;
                context2 = ConnectivityMonitorFactory.this.BuiltInFictitiousFunctionClassFactory;
                return new ConnectivityMonitor(context2);
            }
        });
        this.PlaceComponentResult = LazyKt.lazy(new Function0<ConnectivityWithSignalMonitor>() { // from class: id.dana.core.ui.util.connectivity.factory.ConnectivityMonitorFactory$connectivityWithSignalMonitor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConnectivityWithSignalMonitor invoke() {
                Context context2;
                context2 = ConnectivityMonitorFactory.this.BuiltInFictitiousFunctionClassFactory;
                return new ConnectivityWithSignalMonitor(context2);
            }
        });
    }
}

package id.dana;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.view.LiveData;
import id.dana.GpsStatusMonitor$gpsStatusReceiver$2;
import id.dana.utils.LocationUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0013\u0010\r\u001a\u00020\nX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/GpsStatusMonitor;", "Landroidx/lifecycle/LiveData;", "", "", "BuiltInFictitiousFunctionClassFactory", "()V", "getAuthRequestContext", "Landroid/content/Context;", "PlaceComponentResult", "Landroid/content/Context;", "Lid/dana/GpsStatusMonitor$gpsStatusReceiver$2$1;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlin/Lazy;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GpsStatusMonitor extends LiveData<Boolean> {

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Context getAuthRequestContext;

    public GpsStatusMonitor(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.getAuthRequestContext = context;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<GpsStatusMonitor$gpsStatusReceiver$2.AnonymousClass1>() { // from class: id.dana.GpsStatusMonitor$gpsStatusReceiver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.GpsStatusMonitor$gpsStatusReceiver$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final GpsStatusMonitor gpsStatusMonitor = GpsStatusMonitor.this;
                return new BroadcastReceiver() { // from class: id.dana.GpsStatusMonitor$gpsStatusReceiver$2.1
                    @Override // android.content.BroadcastReceiver
                    public final void onReceive(Context context2, Intent intent) {
                        r1.BuiltInFictitiousFunctionClassFactory((GpsStatusMonitor) Boolean.valueOf(LocationUtil.getAuthRequestContext(GpsStatusMonitor.this.getAuthRequestContext)));
                    }
                };
            }
        });
    }

    @Override // androidx.view.LiveData
    public final void BuiltInFictitiousFunctionClassFactory() {
        super.BuiltInFictitiousFunctionClassFactory();
        this.getAuthRequestContext.registerReceiver((GpsStatusMonitor$gpsStatusReceiver$2.AnonymousClass1) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue(), new IntentFilter("android.location.PROVIDERS_CHANGED"));
    }

    @Override // androidx.view.LiveData
    public final void getAuthRequestContext() {
        super.getAuthRequestContext();
        this.getAuthRequestContext.unregisterReceiver((GpsStatusMonitor$gpsStatusReceiver$2.AnonymousClass1) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue());
    }
}

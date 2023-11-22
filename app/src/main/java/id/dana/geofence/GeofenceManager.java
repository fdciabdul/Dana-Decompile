package id.dana.geofence;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import id.dana.geofence.mapper.PoiMapperKt;
import id.dana.geofence.model.PoiModel;
import id.dana.util.MinApiUtils;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0013\u0010\u000b\u001a\u00020\u000eX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000f"}, d2 = {"Lid/dana/geofence/GeofenceManager;", "", "", "Lid/dana/geofence/model/PoiModel;", "p0", "", "MyBillsEntityDataFactory", "(Ljava/util/List;)Z", "Landroid/content/Context;", "Landroid/content/Context;", "Lcom/google/android/gms/location/GeofencingClient;", "PlaceComponentResult", "Lcom/google/android/gms/location/GeofencingClient;", "getAuthRequestContext", "Landroid/app/PendingIntent;", "Lkotlin/Lazy;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GeofenceManager {
    final Context MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GeofencingClient getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult;

    @Inject
    public GeofenceManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.MyBillsEntityDataFactory = context;
        GeofencingClient geofencingClient = LocationServices.getGeofencingClient(context);
        Intrinsics.checkNotNullExpressionValue(geofencingClient, "");
        this.getAuthRequestContext = geofencingClient;
        this.PlaceComponentResult = LazyKt.lazy(new Function0<PendingIntent>() { // from class: id.dana.geofence.GeofenceManager$geofencePendingIntent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PendingIntent invoke() {
                Intent intent = new Intent(GeofenceManager.this.MyBillsEntityDataFactory, GeofenceBroadcastReceiver.class);
                intent.setAction("dana.id.geofence.action.ACTION_GEOFENCE_EVENT");
                return PendingIntent.getBroadcast(GeofenceManager.this.MyBillsEntityDataFactory, 0, intent, MinApiUtils.PlaceComponentResult() ? 167772160 : 134217728);
            }
        });
    }

    public final boolean MyBillsEntityDataFactory(List<PoiModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (p0.isEmpty()) {
            DanaLog.getAuthRequestContext("GEO_FENCE_MANAGER", "Point of interest empty", new PointOfInterestEmptyException());
            return false;
        }
        GeofencingClient geofencingClient = this.getAuthRequestContext;
        GeofencingRequest build = new GeofencingRequest.Builder().setInitialTrigger(5).addGeofences(PoiMapperKt.MyBillsEntityDataFactory(p0)).build();
        Intrinsics.checkNotNullExpressionValue(build, "");
        Object value = this.PlaceComponentResult.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "");
        geofencingClient.addGeofences(build, (PendingIntent) value);
        return true;
    }
}

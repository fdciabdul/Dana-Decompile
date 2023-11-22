package id.dana.geofence;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.geofence.GeoFenceTransitionsJobIntentService;
import id.dana.rum.Rum;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/geofence/GeofenceBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GeofenceBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(intent, "");
        Rum.Companion companion = Rum.getAuthRequestContext;
        Rum.Companion.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult("GeofenceBroadcastReceiver.onReceive");
        if (Intrinsics.areEqual(intent.getAction(), "dana.id.geofence.action.ACTION_GEOFENCE_EVENT")) {
            GeoFenceTransitionsJobIntentService.Companion companion2 = GeoFenceTransitionsJobIntentService.INSTANCE;
            GeoFenceTransitionsJobIntentService.Companion.MyBillsEntityDataFactory(context, intent);
        }
        Rum.Companion companion3 = Rum.getAuthRequestContext;
        Rum.Companion.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory("GeofenceBroadcastReceiver.onReceive");
    }
}

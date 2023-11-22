package id.dana.data.tracker;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.analytics.mixpanel.MixPanelDataTracker;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.domain.tracker.GeocodeTrackerData;
import id.dana.domain.tracker.GeocodeTrackerSource;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Singleton
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/data/tracker/GeocodeTracker;", "", "Lid/dana/domain/tracker/GeocodeTrackerData;", "geocodeTrackerData", "Lorg/json/JSONObject;", "composePlacesApiProperties", "(Lid/dana/domain/tracker/GeocodeTrackerData;)Lorg/json/JSONObject;", "composeProperties", "", "track", "(Lid/dana/domain/tracker/GeocodeTrackerData;)V", "", "event", "(Ljava/lang/String;Lid/dana/domain/tracker/GeocodeTrackerData;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class GeocodeTracker {
    private final Context context;

    @Inject
    public GeocodeTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.context = context;
    }

    private final JSONObject composeProperties(GeocodeTrackerData geocodeTrackerData) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TrackerDataKey.Property.GEOCODER_UUID, geocodeTrackerData.getUUID());
            jSONObject.put(TrackerDataKey.Property.GEOCODER_APP_LAYER_CALLER, geocodeTrackerData.getAppLayerCaller());
            jSONObject.put(TrackerDataKey.Property.GEOCODER_DOMAIN_LAYER_CALLER, geocodeTrackerData.getDomainLayerCaller());
            GeocodeTrackerSource dataSource = geocodeTrackerData.getDataSource();
            if (dataSource != null) {
                jSONObject.put(TrackerDataKey.Property.GEOCODER_SOURCE, dataSource.getSource());
                if (dataSource.getError().length() > 0) {
                    jSONObject.put(TrackerDataKey.Property.GEOCODER_ERROR, dataSource.getError());
                } else {
                    jSONObject.put(TrackerDataKey.Property.GEOCODER_IS_DATA_COMPLETED, !dataSource.isThereAnyDataEmpty());
                }
            }
        } catch (JSONException unused) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.MIXPANEL, DanaLogConstants.ExceptionType.MIXPANEL_MESSAGE_EXCEPTION);
        }
        return jSONObject;
    }

    private final JSONObject composePlacesApiProperties(GeocodeTrackerData geocodeTrackerData) {
        JSONObject jSONObject = new JSONObject();
        try {
            GeocodeTrackerSource dataSource = geocodeTrackerData.getDataSource();
            if (dataSource != null) {
                jSONObject.put("Source", dataSource.getSource());
                if (dataSource.getError().length() > 0) {
                    jSONObject.put(TrackerDataKey.Property.ERROR_REASON, dataSource.getError());
                }
            }
        } catch (JSONException unused) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.MIXPANEL, DanaLogConstants.ExceptionType.MIXPANEL_MESSAGE_EXCEPTION);
        }
        return jSONObject;
    }

    public final void track(GeocodeTrackerData geocodeTrackerData) {
        Intrinsics.checkNotNullParameter(geocodeTrackerData, "");
        MixPanelDataTracker.PlaceComponentResult(this.context, TrackerDataKey.Event.GEOCODE_REVERSE, composeProperties(geocodeTrackerData));
    }

    public final void track(String event, GeocodeTrackerData geocodeTrackerData) {
        Intrinsics.checkNotNullParameter(event, "");
        Intrinsics.checkNotNullParameter(geocodeTrackerData, "");
        MixPanelDataTracker.PlaceComponentResult(this.context, event, composePlacesApiProperties(geocodeTrackerData));
    }
}

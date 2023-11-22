package id.dana.data.tracker;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.analytics.mixpanel.MixPanelDataTracker;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.domain.tracker.HereMixPanelTrackerData;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Singleton
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/tracker/HereApiMixpanelTracker;", "", "Lid/dana/domain/tracker/HereMixPanelTrackerData;", "hereMixPanelTrackerData", "Lorg/json/JSONObject;", "composeProperties", "(Lid/dana/domain/tracker/HereMixPanelTrackerData;)Lorg/json/JSONObject;", "", "track", "(Lid/dana/domain/tracker/HereMixPanelTrackerData;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HereApiMixpanelTracker {
    private final Context context;

    @Inject
    public HereApiMixpanelTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.context = context;
    }

    private final JSONObject composeProperties(HereMixPanelTrackerData hereMixPanelTrackerData) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Source", hereMixPanelTrackerData.getSource());
        jSONObject.put(TrackerDataKey.HEREProperties.USAGE, hereMixPanelTrackerData.getUsage());
        jSONObject.put("Is Success", hereMixPanelTrackerData.isSuccess());
        jSONObject.put("Error Code", hereMixPanelTrackerData.getErrorCode());
        jSONObject.put("Fail Reason", hereMixPanelTrackerData.getFailReason());
        return jSONObject;
    }

    public final void track(HereMixPanelTrackerData hereMixPanelTrackerData) {
        Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
        MixPanelDataTracker.PlaceComponentResult(this.context, TrackerDataKey.Event.HERE_USAGE, composeProperties(hereMixPanelTrackerData));
    }
}

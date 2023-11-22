package id.dana.sync_engine.domain.tracker;

import android.content.Context;
import id.dana.analytics.mixpanel.MixPanelDataTracker;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/sync_engine/domain/tracker/SyncContactMixpanelTracker;", "Lid/dana/sync_engine/domain/tracker/SyncEngineTracker;", "", "p0", "", "", "p1", "", "PlaceComponentResult", "(Ljava/lang/String;Ljava/util/Map;)V", "Landroid/content/Context;", "getAuthRequestContext", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SyncContactMixpanelTracker implements SyncEngineTracker {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public SyncContactMixpanelTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
    }

    @Override // id.dana.sync_engine.domain.tracker.SyncEngineTracker
    public final void PlaceComponentResult(@TrackerDataKey.Event String p0, Map<String, ? extends Object> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, ? extends Object> entry : p1.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            MixPanelDataTracker.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, p0, jSONObject);
        } catch (JSONException unused) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.MIXPANEL, DanaLogConstants.ExceptionType.MIXPANEL_MESSAGE_EXCEPTION);
        }
    }
}

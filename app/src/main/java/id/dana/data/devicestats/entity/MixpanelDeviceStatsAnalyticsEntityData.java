package id.dana.data.devicestats.entity;

import android.content.Context;
import id.dana.analytics.mixpanel.MixPanelDataTracker;
import id.dana.data.devicestats.DeviceStatsAnalyticsEntityData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\b\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/data/devicestats/entity/MixpanelDeviceStatsAnalyticsEntityData;", "Lid/dana/data/devicestats/DeviceStatsAnalyticsEntityData;", "Lorg/json/JSONObject;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lorg/json/JSONObject;)Z", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MixpanelDeviceStatsAnalyticsEntityData implements DeviceStatsAnalyticsEntityData {
    public final Context KClassImpl$Data$declaredNonStaticMembers$2;

    public MixpanelDeviceStatsAnalyticsEntityData(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
    }

    @Override // id.dana.data.devicestats.DeviceStatsAnalyticsEntityData
    public final boolean BuiltInFictitiousFunctionClassFactory(JSONObject p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MixPanelDataTracker.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, "Post-Install App Size", p0);
        return true;
    }
}

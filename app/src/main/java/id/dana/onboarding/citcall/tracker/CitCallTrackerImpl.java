package id.dana.onboarding.citcall.tracker;

import android.content.Context;
import androidx.core.content.ContextCompat;
import id.dana.analytics.mixpanel.MixPanelDataTracker;
import id.dana.analytics.tracker.AnalyticsTrackerFactory;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.tracker.constant.TrackerType;
import id.dana.tracker.mixpanel.ChallengeEvent;
import id.dana.utils.OSUtil;
import id.dana.utils.permission.ManifestPermission;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\r\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\u0007\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0007\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010"}, d2 = {"Lid/dana/onboarding/citcall/tracker/CitCallTrackerImpl;", "Lid/dana/onboarding/citcall/tracker/CitCallTracker;", "", "p0", "Landroid/content/Context;", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Landroid/content/Context;)Z", "", "getAuthRequestContext", "()V", "PlaceComponentResult", "Lid/dana/analytics/tracker/AnalyticsTrackerFactory;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/analytics/tracker/AnalyticsTrackerFactory;", "Landroid/content/Context;", "<init>", "(Lid/dana/analytics/tracker/AnalyticsTrackerFactory;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CitCallTrackerImpl implements CitCallTracker {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final AnalyticsTrackerFactory PlaceComponentResult;

    @Inject
    public CitCallTrackerImpl(AnalyticsTrackerFactory analyticsTrackerFactory, Context context) {
        Intrinsics.checkNotNullParameter(analyticsTrackerFactory, "");
        Intrinsics.checkNotNullParameter(context, "");
        this.PlaceComponentResult = analyticsTrackerFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
    }

    public final void PlaceComponentResult() {
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.MISCALL_INTRODUCTION, new Pair[]{TuplesKt.to("Source", "Registration")});
    }

    public final void getAuthRequestContext() {
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.MISCALL_INTRODUCTION, new Pair[]{TuplesKt.to("Source", "Registration"), TuplesKt.to(ChallengeEvent.Property.OTP_PURPOSE, ChallengeEvent.OTPPurpose.MISCALL_FAILOVER)});
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(TrackerDataKey.Event.USER_PHONE_STATE_PERMISSION, BuiltInFictitiousFunctionClassFactory("android.permission.READ_PHONE_STATE", this.KClassImpl$Data$declaredNonStaticMembers$2));
        jSONObject.put(TrackerDataKey.Event.USER_PHONE_CALL_PERMISSION, BuiltInFictitiousFunctionClassFactory("android.permission.CALL_PHONE", this.KClassImpl$Data$declaredNonStaticMembers$2));
        if (OSUtil.GetContactSyncConfig()) {
            jSONObject.put(TrackerDataKey.Event.USER_PHONE_CALL_LOG_PERMISSION, BuiltInFictitiousFunctionClassFactory(ManifestPermission.READ_CALL_LOG, this.KClassImpl$Data$declaredNonStaticMembers$2));
        }
        MixPanelDataTracker.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, jSONObject);
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(String p0, Context p1) {
        return ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(p1, p0) == 0;
    }
}

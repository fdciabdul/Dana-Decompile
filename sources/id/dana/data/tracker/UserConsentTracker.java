package id.dana.data.tracker;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.analytics.mixpanel.MixPanelDataTracker;
import id.dana.analytics.tracker.TrackerDataKey;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ'\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000b\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/data/tracker/UserConsentTracker;", "", "", "purpose", "", "agree", "", "trackMPUserConsent", "(Ljava/lang/String;Z)V", "trackServiceUserConsent", "type", "trackUserConsent", "(Ljava/lang/String;Ljava/lang/String;Z)V", "Lorg/json/JSONObject;", "properties", "(Lorg/json/JSONObject;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UserConsentTracker {
    private final Context context;

    @Inject
    public UserConsentTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.context = context;
    }

    public static /* synthetic */ void trackServiceUserConsent$default(UserConsentTracker userConsentTracker, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            z = false;
        }
        userConsentTracker.trackServiceUserConsent(str, z);
    }

    public final void trackServiceUserConsent(String purpose, boolean agree) {
        Intrinsics.checkNotNullParameter(purpose, "");
        trackUserConsent("service", purpose, agree);
    }

    public static /* synthetic */ void trackMPUserConsent$default(UserConsentTracker userConsentTracker, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            z = false;
        }
        userConsentTracker.trackMPUserConsent(str, z);
    }

    public final void trackMPUserConsent(String purpose, boolean agree) {
        Intrinsics.checkNotNullParameter(purpose, "");
        trackUserConsent(TrackerDataKey.UserConsentProperties.UserConsentType.MINI_PROGRAM, purpose, agree);
    }

    private final void trackUserConsent(String type, String purpose, boolean agree) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Type", type);
        jSONObject.put("Purpose", purpose);
        jSONObject.put(TrackerDataKey.UserConsentProperties.DO_CONSENT, agree);
        trackUserConsent(jSONObject);
    }

    private final void trackUserConsent(JSONObject properties) {
        MixPanelDataTracker.PlaceComponentResult(this.context, TrackerDataKey.Event.USER_CONSENT, properties);
    }
}

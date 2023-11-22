package id.dana.contract.deeplink.path;

import android.app.Activity;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.pay.PayActivity;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
public class FeaturePayQR {
    public FeaturePayQR(Activity activity, Map<String, String> map) {
        String str = map.get("source") != null ? map.get("source") : "Deeplink";
        activity.startActivity(PayActivity.createPayActivityIntent(activity, Objects.equals(str, "VoiceAssistant") ? TrackerKey.SourceType.VOICE_ASSISTANT : str));
    }
}

package id.dana.data.globalnetwork.source.remote.tracker;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.analytics.mixpanel.MixPanelDataTracker;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\tR\u0017\u0010\u000e\u001a\u00020\r8\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/data/globalnetwork/source/remote/tracker/MiniProgramMixpanelTracker;", "Lid/dana/data/globalnetwork/source/remote/tracker/MiniProgramAnalyticTracker;", "", "state", "appId", "", "track", "(Ljava/lang/String;Ljava/lang/String;)V", "trackBindingSuccess", "(Ljava/lang/String;)V", "trackRequestAgreement", "trackShowAgreement", "trackTradePay", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MiniProgramMixpanelTracker implements MiniProgramAnalyticTracker {
    private static final String BINDING = "BINDING";
    private static final String REQUEST = "REQUEST";
    private static final String SHOW = "SHOW";
    private static final String TRADE_PAY = "TRADE_PAY";
    private final Context context;

    @Inject
    public MiniProgramMixpanelTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.context = context;
    }

    @JvmName(name = "getContext")
    public final Context getContext() {
        return this.context;
    }

    @Override // id.dana.data.globalnetwork.source.remote.tracker.MiniProgramAnalyticTracker
    public final void trackRequestAgreement(String appId) {
        track(REQUEST, appId);
    }

    @Override // id.dana.data.globalnetwork.source.remote.tracker.MiniProgramAnalyticTracker
    public final void trackShowAgreement(String appId) {
        track(SHOW, appId);
    }

    @Override // id.dana.data.globalnetwork.source.remote.tracker.MiniProgramAnalyticTracker
    public final void trackBindingSuccess(String appId) {
        track("BINDING", appId);
    }

    @Override // id.dana.data.globalnetwork.source.remote.tracker.MiniProgramAnalyticTracker
    public final void trackTradePay(String appId) {
        track("TRADE_PAY", appId);
    }

    private final void track(String state, String appId) {
        String str;
        try {
            switch (state.hashCode()) {
                case -754181363:
                    if (state.equals("TRADE_PAY")) {
                        str = TrackerDataKey.Event.MINIPROGRAM_TRADE_PAY;
                        break;
                    } else {
                        return;
                    }
                case 2544381:
                    if (state.equals(SHOW)) {
                        str = TrackerDataKey.Event.MINIPROGRAM_SHOW_AGREEMENT;
                        break;
                    } else {
                        return;
                    }
                case 609761893:
                    if (state.equals("BINDING")) {
                        str = TrackerDataKey.Event.MINIPROGRAM_BINDING_SUCCESS;
                        break;
                    } else {
                        return;
                    }
                case 1813675631:
                    if (state.equals(REQUEST)) {
                        str = TrackerDataKey.Event.MINIPROGRAM_REQUEST_AGREEMENT;
                        break;
                    } else {
                        return;
                    }
                default:
                    return;
            }
            MixPanelDataTracker.PlaceComponentResult(this.context, str, new JSONObject().put("App ID", appId));
        } catch (JSONException unused) {
            DanaLog.BuiltInFictitiousFunctionClassFactory("Mixpanel", DanaLogConstants.ExceptionType.MIXPANEL_MESSAGE_EXCEPTION);
        }
    }
}

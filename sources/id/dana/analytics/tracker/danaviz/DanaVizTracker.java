package id.dana.analytics.tracker.danaviz;

import com.alipay.iap.android.wallet.foundation.deeplink.DeeplinkService;
import id.dana.cashier.OneklikAnnotations;
import id.dana.danah5.faceverificationenablement.DefaultFaceAuthenticationManager;
import id.dana.promoquest.handler.nativepage.NativePageType;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/analytics/tracker/danaviz/DanaVizTracker;", "", "Lid/dana/analytics/tracker/danaviz/DanaVizTracker$Source;", "source", "", "setSource", "(Lid/dana/analytics/tracker/danaviz/DanaVizTracker$Source;)V", "Source"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface DanaVizTracker {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f"}, d2 = {"Lid/dana/analytics/tracker/danaviz/DanaVizTracker$Source;", "", "<init>", "(Ljava/lang/String;I)V", OneklikAnnotations.ONEKLIK_SCENARIO, "LOGIN", DefaultFaceAuthenticationManager.SOURCE_REGISTRATION, "DANA_PROTECTION", "SMART_PAY", DeeplinkService.Scene.TOP_UP, DefaultFaceAuthenticationManager.SOURCE_TRANSFER_ACCOUNT, NativePageType.SEND_MONEY, "GROUP_SEND"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public enum Source {
        CASHIER,
        LOGIN,
        REGISTRATION,
        DANA_PROTECTION,
        SMART_PAY,
        TOP_UP,
        TRANSFER_ACCOUNT,
        SEND_MONEY,
        GROUP_SEND
    }

    void setSource(Source source);
}

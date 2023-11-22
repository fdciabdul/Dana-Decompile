package id.dana.social.deeplink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import id.dana.animation.HomeTabActivity;
import id.dana.contract.deeplink.path.FeatureParams;
import id.dana.feeds.ui.tracker.FeedsSourceType;
import id.dana.social.v2.FeedsActivity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ:\u0010\t\u001a\u00020\b2\r\u0010\u0004\u001a\t\u0018\u00010\u0002¢\u0006\u0002\b\u00032\u0019\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\b\u0003H\u0087\u0002¢\u0006\u0004\b\t\u0010\nJ+\u0010\f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/social/deeplink/FeatureFriendship;", "", "Landroid/app/Activity;", "Lorg/jetbrains/annotations/NotNull;", "p0", "", "", "p1", "", "PlaceComponentResult", "(Landroid/app/Activity;Ljava/util/Map;)V", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Ljava/util/Map;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeatureFriendship {
    public static final FeatureFriendship INSTANCE = new FeatureFriendship();

    private FeatureFriendship() {
    }

    @JvmStatic
    public static final void PlaceComponentResult(Activity p0, Map<String, String> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        String str = p1.get(FeatureParams.FEED_MAINTENANCE);
        if (Boolean.parseBoolean(str != null ? StringsKt.trim((CharSequence) str).toString() : null)) {
            p1.put("target", "maintenance");
        }
        String str2 = p1.get("target");
        if (str2 != null) {
            int hashCode = str2.hashCode();
            if (hashCode == -600094315) {
                if (str2.equals("friends")) {
                    Activity activity = p0;
                    if (Boolean.parseBoolean(p1.get("feed_revamp"))) {
                        FeedsActivity.Companion companion = FeedsActivity.INSTANCE;
                        FeedsActivity.Companion.getAuthRequestContext(activity, p1.get("bizOrderId"), FeedsSourceType.FEED_DEEPLINK);
                        return;
                    }
                    BuiltInFictitiousFunctionClassFactory(activity, p1);
                    return;
                }
                return;
            }
            if (hashCode != 100344454) {
                if (hashCode != 317649683 || !str2.equals("maintenance")) {
                    return;
                }
            } else if (!str2.equals("inbox")) {
                return;
            }
            BuiltInFictitiousFunctionClassFactory(p0, p1);
        }
    }

    private static void BuiltInFictitiousFunctionClassFactory(Context p0, Map<String, String> p1) {
        Intent intent = new Intent(p0, HomeTabActivity.class);
        intent.putExtra("target", p1.get("target"));
        String str = p1.get("Source");
        if (str == null) {
            str = FeedsSourceType.FEED_DEEPLINK;
        }
        intent.putExtra("Source", str);
        intent.putExtra("bizOrderId", p1.get("bizOrderId"));
        intent.setFlags(536870912);
        p0.startActivity(intent);
    }
}

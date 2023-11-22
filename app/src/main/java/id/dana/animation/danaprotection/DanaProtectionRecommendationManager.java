package id.dana.animation.danaprotection;

import android.app.Activity;
import androidx.core.content.ContextCompat;
import id.dana.utils.permission.ManifestPermission;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/home/danaprotection/DanaProtectionRecommendationManager;", "", "Landroid/app/Activity;", "p0", "", "getAuthRequestContext", "(Landroid/app/Activity;)Z", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DanaProtectionRecommendationManager {
    public static boolean getAuthRequestContext(Activity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Activity activity = p0;
        return ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(activity, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(activity, ManifestPermission.ACCESS_COARSE_LOCATION) == 0;
    }
}

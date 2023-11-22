package id.dana.utils.android;

import android.net.Uri;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/utils/android/UriUtils;", "", "", "p0", "", "p1", "Landroid/net/Uri;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/util/Map;)Landroid/net/Uri;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UriUtils {
    public static final UriUtils INSTANCE = new UriUtils();

    private UriUtils() {
    }

    @JvmStatic
    public static final Uri BuiltInFictitiousFunctionClassFactory(String p0, Map<String, String> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Uri.Builder buildUpon = Uri.parse(p0).buildUpon();
        for (Map.Entry<String, String> entry : p1.entrySet()) {
            buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        Uri build = buildUpon.build();
        Intrinsics.checkNotNullExpressionValue(build, "");
        return build;
    }
}

package id.dana.util.permission;

import android.content.Context;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class Permission {
    private static final Set<String> KClassImpl$Data$declaredNonStaticMembers$2 = new HashSet();

    /* loaded from: classes9.dex */
    public static class Builder {
    }

    /* loaded from: classes9.dex */
    public interface PermissionListener {
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str) {
        return Build.VERSION.SDK_INT < 23 || ActivityCompat.KClassImpl$Data$declaredNonStaticMembers$2(context, str) == 0;
    }

    /* loaded from: classes9.dex */
    public static class Report {
        private final int PlaceComponentResult;
        private final String getAuthRequestContext;

        public boolean equals(Object obj) {
            String str;
            return this == obj || ((obj instanceof Report) && (str = this.getAuthRequestContext) != null && str.equals(((Report) obj).getAuthRequestContext));
        }

        public int hashCode() {
            return (this.getAuthRequestContext.hashCode() * 31) + this.PlaceComponentResult;
        }
    }
}

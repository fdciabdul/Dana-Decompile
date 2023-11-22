package id.dana.danah5.chrome;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\"\u0010\t\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/danah5/chrome/CustomTabEngine;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "priority", "copy", "(Ljava/lang/String;I)Lid/dana/danah5/chrome/CustomTabEngine;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getPackageName", "I", "getPriority", "setPriority", "(I)V", "<init>", "(Ljava/lang/String;I)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CustomTabEngine {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int UNKNOWN_PRIORITY = 10;
    private final String packageName;
    private int priority;

    public static /* synthetic */ CustomTabEngine copy$default(CustomTabEngine customTabEngine, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = customTabEngine.packageName;
        }
        if ((i2 & 2) != 0) {
            i = customTabEngine.priority;
        }
        return customTabEngine.copy(str, i);
    }

    /* renamed from: component1  reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component2  reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    public final CustomTabEngine copy(String packageName, int priority) {
        Intrinsics.checkNotNullParameter(packageName, "");
        return new CustomTabEngine(packageName, priority);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CustomTabEngine(packageName=");
        sb.append(this.packageName);
        sb.append(", priority=");
        sb.append(this.priority);
        sb.append(')');
        return sb.toString();
    }

    public CustomTabEngine(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        this.packageName = str;
        this.priority = i;
    }

    public /* synthetic */ CustomTabEngine(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 10 : i);
    }

    @JvmName(name = "getPackageName")
    public final String getPackageName() {
        return this.packageName;
    }

    @JvmName(name = "getPriority")
    public final int getPriority() {
        return this.priority;
    }

    @JvmName(name = "setPriority")
    public final void setPriority(int i) {
        this.priority = i;
    }

    public final boolean equals(Object other) {
        return this == other || ((other instanceof CustomTabEngine) && Intrinsics.areEqual(this.packageName, ((CustomTabEngine) other).packageName));
    }

    public final int hashCode() {
        return this.packageName.hashCode();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/danah5/chrome/CustomTabEngine$Companion;", "", "", "UNKNOWN_PRIORITY", "I", "", "Lid/dana/danah5/chrome/CustomTabEngine;", "getChromeApps", "()[Lid/dana/danah5/chrome/CustomTabEngine;", "chromeApps", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "getChromeApps")
        public final CustomTabEngine[] getChromeApps() {
            return new CustomTabEngine[]{new CustomTabEngine("com.android.chrome", 0), new CustomTabEngine("com.brave.browser", 0), new CustomTabEngine("com.brave.browser_nightly", 0), new CustomTabEngine("com.chrome.beta", 1), new CustomTabEngine("com.brave.browser_beta", 2), new CustomTabEngine("com.chrome.dev", 3)};
        }
    }
}

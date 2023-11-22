package id.dana.rum.os;

import android.os.Build;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/rum/os/OSUtils;", "", "", "MyBillsEntityDataFactory", "()I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OSUtils {
    public static final OSUtils INSTANCE = new OSUtils();

    private OSUtils() {
    }

    public static int MyBillsEntityDataFactory() {
        return Build.VERSION.SDK_INT;
    }
}

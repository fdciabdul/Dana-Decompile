package id.dana.danah5.easteregg;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/danah5/easteregg/FirebaseInfoHolder;", "", "", "fcmToken", "Ljava/lang/String;", "getFcmToken", "()Ljava/lang/String;", "setFcmToken", "(Ljava/lang/String;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class FirebaseInfoHolder {
    public static final FirebaseInfoHolder INSTANCE = new FirebaseInfoHolder();
    private static String fcmToken;

    private FirebaseInfoHolder() {
    }

    @JvmName(name = "getFcmToken")
    public final String getFcmToken() {
        return fcmToken;
    }

    @JvmName(name = "setFcmToken")
    public final void setFcmToken(String str) {
        fcmToken = str;
    }
}

package id.dana.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

/* loaded from: classes5.dex */
public class PhoneCall {
    private PhoneCall() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Activity activity, String str, boolean z) {
        if (z) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("tel:");
                sb.append(str);
                activity.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(sb.toString())));
            } catch (SecurityException unused) {
            }
        }
    }
}

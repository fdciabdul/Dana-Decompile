package fsstub;

import android.os.Build;
import com.fullstory.instrumentation.CurrentPlatform;
import com.fullstory.instrumentation.InstrumentInjectorBridge;
import com.fullstory.util.Log;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class b {
    public static InstrumentInjectorBridge a() {
        if (b() && c()) {
            return d();
        }
        return null;
    }

    private static boolean b() {
        StringBuilder sb;
        int i;
        if (Build.VERSION.SDK_INT != CurrentPlatform.SDK_INT_FIXED) {
            sb = new StringBuilder();
            sb.append("Not supported on this preview API version: ");
            sb.append(Build.VERSION.SDK_INT);
            sb.append(" preview ");
            i = Build.VERSION.PREVIEW_SDK_INT;
        } else {
            if (Build.VERSION.SDK_INT < 24) {
                sb = new StringBuilder();
            } else if (Build.VERSION.SDK_INT <= 34) {
                return true;
            } else {
                sb = new StringBuilder();
            }
            sb.append("Not supported on this API version: ");
            i = Build.VERSION.SDK_INT;
        }
        sb.append(i);
        Log.logAlways(sb.toString());
        return false;
    }

    private static boolean c() {
        if (ByteOrder.nativeOrder() != ByteOrder.LITTLE_ENDIAN) {
            Log.logAlways("Not supported on big endian devices");
            return false;
        }
        return true;
    }

    private static InstrumentInjectorBridge d() {
        try {
            return (InstrumentInjectorBridge) Class.forName("com.fullstory.instrumentation.InstrumentInjectorBridgeImpl").newInstance();
        } catch (Throwable th) {
            Log.e("Failed to load fs from dex", th);
            return null;
        }
    }
}

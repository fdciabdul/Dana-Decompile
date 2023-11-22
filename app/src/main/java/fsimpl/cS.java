package fsimpl;

import com.fullstory.instrumentation.Bootstrap;
import com.fullstory.util.Log;

/* loaded from: classes.dex */
public class cS {
    public static void a(String str, Throwable th) {
        Log.e(str, th);
        Bootstrap.fail();
    }
}

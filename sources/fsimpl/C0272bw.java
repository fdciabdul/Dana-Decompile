package fsimpl;

import com.fullstory.rust.RustInterface;
import com.fullstory.util.Log;
import okhttp3.OkHttpClient;

/* renamed from: fsimpl.bw  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0272bw {
    public static void a(RustInterface rustInterface, Object obj) {
        if (C0256bg.b()) {
            try {
                OkHttpClient.Builder builder = (OkHttpClient.Builder) obj;
                builder.addInterceptor(new C0273bx(rustInterface, false));
                builder.addNetworkInterceptor(new C0273bx(rustInterface, true));
            } catch (Throwable th) {
                Log.e("Exception adding network interceptor to OkHttpClient.Builder", th);
            }
        }
    }
}

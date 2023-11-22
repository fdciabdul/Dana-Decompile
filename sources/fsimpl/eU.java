package fsimpl;

import com.fullstory.rust.RustInterface;
import java.net.HttpURLConnection;

/* loaded from: classes.dex */
public class eU {
    public static long a(long j) {
        double nanoTime = System.nanoTime() - j;
        Double.isNaN(nanoTime);
        return Math.round(nanoTime / 1000000.0d);
    }

    public static void a(RustInterface rustInterface, HttpURLConnection httpURLConnection, long j, long j2, int i) {
        if (C0256bg.d()) {
            rustInterface.a(new C0342em(httpURLConnection.getURL().toString(), httpURLConnection.getRequestMethod(), a(j2), i, j, httpURLConnection.getContentLengthLong(), 1));
        }
    }
}

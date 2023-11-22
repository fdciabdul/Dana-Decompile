package fsimpl;

import com.fullstory.rust.RustInterface;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* renamed from: fsimpl.bv */
/* loaded from: classes.dex */
public class C0271bv {
    public static URLConnection a(RustInterface rustInterface, URLConnection uRLConnection) {
        if (C0256bg.c() && !(uRLConnection instanceof C0267br) && !(uRLConnection instanceof C0266bq)) {
            if (uRLConnection instanceof HttpsURLConnection) {
                return new C0267br((HttpsURLConnection) uRLConnection, new C0268bs(rustInterface));
            }
            if (uRLConnection instanceof HttpURLConnection) {
                return new C0266bq((HttpURLConnection) uRLConnection, new C0268bs(rustInterface));
            }
        }
        return uRLConnection;
    }
}

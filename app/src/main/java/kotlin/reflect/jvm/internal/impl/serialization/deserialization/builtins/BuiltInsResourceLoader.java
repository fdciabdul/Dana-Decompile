package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class BuiltInsResourceLoader {
    public final InputStream loadResource(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader == null) {
            return ClassLoader.getSystemResourceAsStream(str);
        }
        URL resource = classLoader.getResource(str);
        if (resource == null) {
            return null;
        }
        URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(resource.openConnection()));
        uRLConnection.setUseCaches(false);
        return uRLConnection.getInputStream();
    }
}

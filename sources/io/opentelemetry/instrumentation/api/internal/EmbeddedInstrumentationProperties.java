package io.opentelemetry.instrumentation.api.internal;

import j$.util.Map;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Function;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public final class EmbeddedInstrumentationProperties {
    private static final ClassLoader DEFAULT_LOADER;
    private static volatile ClassLoader loader;
    private static final Logger logger = Logger.getLogger(EmbeddedInstrumentationProperties.class.getName());
    private static final Map<String, String> versions;

    static {
        ClassLoader classLoader = EmbeddedInstrumentationProperties.class.getClassLoader();
        if (classLoader == null) {
            classLoader = new BootstrapProxy();
        }
        DEFAULT_LOADER = classLoader;
        loader = classLoader;
        versions = new ConcurrentHashMap();
    }

    public static void setPropertiesLoader(ClassLoader classLoader) {
        if (loader != DEFAULT_LOADER) {
            logger.warning("Embedded properties loader has already been set up, further setPropertiesLoader() calls are ignored");
        } else {
            loader = classLoader;
        }
    }

    @Nullable
    public static String findVersion(String str) {
        return (String) Map.EL.BuiltInFictitiousFunctionClassFactory((java.util.Map) versions, (Object) str, new Function() { // from class: io.opentelemetry.instrumentation.api.internal.EmbeddedInstrumentationProperties$$ExternalSyntheticLambda0
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                String loadVersion;
                loadVersion = EmbeddedInstrumentationProperties.loadVersion((String) obj);
                return loadVersion;
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String loadVersion(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("META-INF/io/opentelemetry/instrumentation/");
        sb.append(str);
        sb.append(".properties");
        String obj = sb.toString();
        try {
            InputStream resourceAsStream = loader.getResourceAsStream(obj);
            try {
                if (resourceAsStream == null) {
                    logger.log(Level.FINE, "Did not find embedded instrumentation properties file {0}", obj);
                    if (resourceAsStream != null) {
                        resourceAsStream.close();
                    }
                    return null;
                }
                Properties properties = new Properties();
                properties.load(resourceAsStream);
                String property = properties.getProperty("version");
                if (resourceAsStream != null) {
                    resourceAsStream.close();
                }
                return property;
            } finally {
            }
        } catch (IOException e) {
            Logger logger2 = logger;
            Level level = Level.FINE;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to load embedded instrumentation properties file ");
            sb2.append(obj);
            logger2.log(level, sb2.toString(), (Throwable) e);
            return null;
        }
    }

    /* loaded from: classes6.dex */
    static final class BootstrapProxy extends ClassLoader {
        BootstrapProxy() {
            super(null);
        }
    }

    private EmbeddedInstrumentationProperties() {
    }
}

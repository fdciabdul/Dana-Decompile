package io.opentelemetry.api;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterBuilder;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.trace.TracerBuilder;
import io.opentelemetry.api.trace.TracerProvider;
import io.opentelemetry.context.propagation.ContextPropagators;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public final class GlobalOpenTelemetry {
    @Nullable
    private static volatile ObfuscatedOpenTelemetry globalOpenTelemetry;
    private static final Logger logger = Logger.getLogger(GlobalOpenTelemetry.class.getName());
    private static final Object mutex = new Object();
    @Nullable
    private static Throwable setGlobalCaller;

    private GlobalOpenTelemetry() {
    }

    public static OpenTelemetry get() {
        ObfuscatedOpenTelemetry obfuscatedOpenTelemetry = globalOpenTelemetry;
        if (obfuscatedOpenTelemetry == null) {
            synchronized (mutex) {
                ObfuscatedOpenTelemetry obfuscatedOpenTelemetry2 = globalOpenTelemetry;
                if (obfuscatedOpenTelemetry2 == null) {
                    OpenTelemetry maybeAutoConfigureAndSetGlobal = maybeAutoConfigureAndSetGlobal();
                    if (maybeAutoConfigureAndSetGlobal != null) {
                        return maybeAutoConfigureAndSetGlobal;
                    }
                    set(OpenTelemetry.CC.noop());
                    return OpenTelemetry.CC.noop();
                }
                return obfuscatedOpenTelemetry2;
            }
        }
        return obfuscatedOpenTelemetry;
    }

    public static void set(OpenTelemetry openTelemetry) {
        synchronized (mutex) {
            if (globalOpenTelemetry != null) {
                throw new IllegalStateException("GlobalOpenTelemetry.set has already been called. GlobalOpenTelemetry.set must be called only once before any calls to GlobalOpenTelemetry.get. If you are using the OpenTelemetrySdk, use OpenTelemetrySdkBuilder.buildAndRegisterGlobal instead. Previous invocation set to cause of this exception.", setGlobalCaller);
            }
            globalOpenTelemetry = new ObfuscatedOpenTelemetry(openTelemetry);
            setGlobalCaller = new Throwable();
        }
    }

    public static TracerProvider getTracerProvider() {
        return get().getTracerProvider();
    }

    public static Tracer getTracer(String str) {
        return get().getTracer(str);
    }

    public static Tracer getTracer(String str, String str2) {
        return get().getTracer(str, str2);
    }

    public static TracerBuilder tracerBuilder(String str) {
        return get().tracerBuilder(str);
    }

    public static MeterProvider getMeterProvider() {
        return get().getMeterProvider();
    }

    public static Meter getMeter(String str) {
        return get().getMeter(str);
    }

    public static MeterBuilder meterBuilder(String str) {
        return get().meterBuilder(str);
    }

    public static void resetForTest() {
        globalOpenTelemetry = null;
    }

    public static ContextPropagators getPropagators() {
        return get().getPropagators();
    }

    @Nullable
    private static OpenTelemetry maybeAutoConfigureAndSetGlobal() {
        try {
            Class<?> cls = Class.forName("io.opentelemetry.sdk.autoconfigure.AutoConfiguredOpenTelemetrySdk");
            try {
                return (OpenTelemetry) cls.getMethod("getOpenTelemetrySdk", new Class[0]).invoke(cls.getMethod("initialize", new Class[0]).invoke(null, new Object[0]), new Object[0]);
            } catch (IllegalAccessException e) {
                e = e;
                throw new IllegalStateException("OpenTelemetrySdkAutoConfiguration detected on classpath but could not invoke initialize method. This is a bug in OpenTelemetry.", e);
            } catch (NoSuchMethodException e2) {
                e = e2;
                throw new IllegalStateException("OpenTelemetrySdkAutoConfiguration detected on classpath but could not invoke initialize method. This is a bug in OpenTelemetry.", e);
            } catch (InvocationTargetException e3) {
                logger.log(Level.SEVERE, "Error automatically configuring OpenTelemetry SDK. OpenTelemetry will not be enabled.", e3.getTargetException());
                return null;
            }
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class ObfuscatedOpenTelemetry implements OpenTelemetry {
        private final OpenTelemetry delegate;

        @Override // io.opentelemetry.api.OpenTelemetry
        public /* synthetic */ Meter getMeter(String str) {
            Meter meter;
            meter = getMeterProvider().get(str);
            return meter;
        }

        @Override // io.opentelemetry.api.OpenTelemetry
        public /* synthetic */ Tracer getTracer(String str) {
            Tracer tracer;
            tracer = getTracerProvider().get(str);
            return tracer;
        }

        @Override // io.opentelemetry.api.OpenTelemetry
        public /* synthetic */ Tracer getTracer(String str, String str2) {
            Tracer tracer;
            tracer = getTracerProvider().get(str, str2);
            return tracer;
        }

        @Override // io.opentelemetry.api.OpenTelemetry
        public /* synthetic */ MeterBuilder meterBuilder(String str) {
            MeterBuilder meterBuilder;
            meterBuilder = getMeterProvider().meterBuilder(str);
            return meterBuilder;
        }

        ObfuscatedOpenTelemetry(OpenTelemetry openTelemetry) {
            this.delegate = openTelemetry;
        }

        @Override // io.opentelemetry.api.OpenTelemetry
        public TracerProvider getTracerProvider() {
            return this.delegate.getTracerProvider();
        }

        @Override // io.opentelemetry.api.OpenTelemetry
        public MeterProvider getMeterProvider() {
            return this.delegate.getMeterProvider();
        }

        @Override // io.opentelemetry.api.OpenTelemetry
        public ContextPropagators getPropagators() {
            return this.delegate.getPropagators();
        }

        @Override // io.opentelemetry.api.OpenTelemetry
        public TracerBuilder tracerBuilder(String str) {
            return this.delegate.tracerBuilder(str);
        }
    }
}

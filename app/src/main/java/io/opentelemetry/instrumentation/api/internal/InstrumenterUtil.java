package io.opentelemetry.instrumentation.api.internal;

import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.Instrumenter;
import j$.time.Instant;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public final class InstrumenterUtil {
    private static final Logger logger = Logger.getLogger(InstrumenterUtil.class.getName());
    private static final Method startAndEndMethod;

    static {
        Method method = null;
        try {
            method = Instrumenter.class.getDeclaredMethod("startAndEnd", Context.class, Object.class, Object.class, Throwable.class, Instant.class, Instant.class);
            method.setAccessible(true);
        } catch (NoSuchMethodException e) {
            logger.log(Level.WARNING, "Could not get Instrumenter#startAndEnd() method with reflection", (Throwable) e);
        }
        startAndEndMethod = method;
    }

    public static <REQUEST, RESPONSE> Context startAndEnd(Instrumenter<REQUEST, RESPONSE> instrumenter, Context context, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th, Instant instant, Instant instant2) {
        Method method = startAndEndMethod;
        if (method == null) {
            return context;
        }
        try {
            return (Context) method.invoke(instrumenter, context, request, response, th, instant, instant2);
        } catch (IllegalAccessException | InvocationTargetException e) {
            logger.log(Level.WARNING, "Error occurred when calling Instrumenter#startAndEnd()", e);
            return context;
        }
    }

    private InstrumenterUtil() {
    }
}

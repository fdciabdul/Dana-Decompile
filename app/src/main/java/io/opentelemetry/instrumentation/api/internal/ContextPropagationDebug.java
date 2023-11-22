package io.opentelemetry.instrumentation.api.internal;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.ContextKey;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public final class ContextPropagationDebug {
    private final List<Propagation> locations = new CopyOnWriteArrayList();
    private final Context sourceContext;
    private Context wrappedContext;
    private static final Logger logger = Logger.getLogger(ContextPropagationDebug.class.getName());
    private static final ContextKey<ContextPropagationDebug> THREAD_PROPAGATION_LOCATIONS = ContextKey.CC.named("thread-propagation-locations");
    private static final boolean THREAD_PROPAGATION_DEBUGGER = ConfigPropertiesUtil.getBoolean("otel.javaagent.experimental.thread-propagation-debugger.enabled", ConfigPropertiesUtil.getBoolean("otel.javaagent.debug", false));
    private static final boolean FAIL_ON_CONTEXT_LEAK = ConfigPropertiesUtil.getBoolean("otel.javaagent.testing.fail-on-context-leak", false);

    private ContextPropagationDebug(Context context) {
        this.sourceContext = context;
    }

    public static boolean isThreadPropagationDebuggerEnabled() {
        return THREAD_PROPAGATION_DEBUGGER;
    }

    public static Context appendLocations(Context context, StackTraceElement[] stackTraceElementArr, Object obj) {
        ContextPropagationDebug propagations = getPropagations(context);
        if (propagations == null) {
            propagations = new ContextPropagationDebug(context);
            context = context.with(THREAD_PROPAGATION_LOCATIONS, propagations);
            propagations.wrappedContext = context;
        }
        propagations.locations.add(0, new Propagation(obj.getClass().getName(), stackTraceElementArr));
        return context;
    }

    public static void debugContextLeakIfEnabled() {
        Context current;
        if (isThreadPropagationDebuggerEnabled() && (current = Context.CC.current()) != Context.CC.root()) {
            Logger logger2 = logger;
            logger2.severe("Unexpected non-root current context found when extracting remote context!");
            Span fromContextOrNull = Span.CC.fromContextOrNull(current);
            if (fromContextOrNull != null) {
                logger2.log(Level.SEVERE, "It contains this span: {0}", fromContextOrNull);
            }
            debugContextPropagation(current);
            if (FAIL_ON_CONTEXT_LEAK) {
                throw new IllegalStateException("Context leak detected");
            }
        }
    }

    public static Context unwrap(Context context) {
        ContextPropagationDebug propagations;
        return (context == null || !isThreadPropagationDebuggerEnabled() || (propagations = getPropagations(context)) == null || propagations.wrappedContext != context) ? context : propagations.sourceContext;
    }

    @Nullable
    private static ContextPropagationDebug getPropagations(Context context) {
        return (ContextPropagationDebug) context.get(THREAD_PROPAGATION_LOCATIONS);
    }

    private static void debugContextPropagation(Context context) {
        ContextPropagationDebug propagations = getPropagations(context);
        if (propagations != null) {
            List<Propagation> list = propagations.locations;
            StringBuilder sb = new StringBuilder();
            Iterator<Propagation> it = list.iterator();
            while (it.hasNext()) {
                Propagation next = it.next();
                sb.append("\ncarrier of type: ");
                sb.append(next.carrierClassName);
                for (StackTraceElement stackTraceElement : next.location) {
                    sb.append("\n    ");
                    sb.append(stackTraceElement);
                }
                if (it.hasNext()) {
                    sb.append("\nwhich was propagated from:");
                }
            }
            logger.log(Level.SEVERE, "a context leak was detected. it was propagated from: {0}", sb);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class Propagation {
        public final String carrierClassName;
        public final StackTraceElement[] location;

        public Propagation(String str, StackTraceElement[] stackTraceElementArr) {
            this.carrierClassName = str;
            this.location = stackTraceElementArr;
        }
    }
}

package io.opentelemetry.instrumentation.api.internal;

import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.instrumentation.api.internal.SupportabilityMetrics;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.concurrent.ConcurrentMap;
import j$.util.function.BiConsumer;
import j$.util.function.Consumer;
import j$.util.function.Function;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/* loaded from: classes6.dex */
public final class SupportabilityMetrics {
    private static final SupportabilityMetrics INSTANCE;
    private static final Logger logger;
    private final boolean agentDebugEnabled;
    private final Consumer<String> reporter;
    private final ConcurrentMap<String, KindCounters> suppressionCounters = new ConcurrentHashMap();
    private final ConcurrentMap<String, AtomicLong> counters = new ConcurrentHashMap();

    static {
        final Logger logger2 = Logger.getLogger(SupportabilityMetrics.class.getName());
        logger = logger2;
        boolean z = ConfigPropertiesUtil.getBoolean("otel.javaagent.debug", false);
        Objects.requireNonNull(logger2);
        INSTANCE = new SupportabilityMetrics(z, new Consumer() { // from class: io.opentelemetry.instrumentation.api.internal.SupportabilityMetrics$$ExternalSyntheticLambda3
            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
                logger2.fine((String) obj);
            }

            @Override // j$.util.function.Consumer
            public final /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.PlaceComponentResult(this, consumer);
            }
        }).start();
    }

    public static SupportabilityMetrics instance() {
        return INSTANCE;
    }

    SupportabilityMetrics(boolean z, Consumer<String> consumer) {
        this.agentDebugEnabled = z;
        this.reporter = consumer;
    }

    public final void recordSuppressedSpan(SpanKind spanKind, String str) {
        if (this.agentDebugEnabled) {
            ((KindCounters) ConcurrentMap.EL.MyBillsEntityDataFactory(this.suppressionCounters, str, new Function() { // from class: io.opentelemetry.instrumentation.api.internal.SupportabilityMetrics$$ExternalSyntheticLambda4
                @Override // j$.util.function.Function
                /* renamed from: andThen */
                public final /* synthetic */ Function mo3169andThen(Function function) {
                    return Function.CC.getAuthRequestContext(this, function);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    return SupportabilityMetrics.lambda$recordSuppressedSpan$0((String) obj);
                }

                @Override // j$.util.function.Function
                public final /* synthetic */ Function compose(Function function) {
                    return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
                }
            })).increment(spanKind);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ KindCounters lambda$recordSuppressedSpan$0(String str) {
        return new KindCounters(null);
    }

    public final void incrementCounter(String str) {
        if (this.agentDebugEnabled) {
            ((AtomicLong) ConcurrentMap.EL.MyBillsEntityDataFactory(this.counters, str, new Function() { // from class: io.opentelemetry.instrumentation.api.internal.SupportabilityMetrics$$ExternalSyntheticLambda0
                @Override // j$.util.function.Function
                /* renamed from: andThen */
                public final /* synthetic */ Function mo3169andThen(Function function) {
                    return Function.CC.getAuthRequestContext(this, function);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    return SupportabilityMetrics.lambda$incrementCounter$1((String) obj);
                }

                @Override // j$.util.function.Function
                public final /* synthetic */ Function compose(Function function) {
                    return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
                }
            })).incrementAndGet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ AtomicLong lambda$incrementCounter$1(String str) {
        return new AtomicLong();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void report() {
        ConcurrentMap.EL.KClassImpl$Data$declaredNonStaticMembers$2(this.suppressionCounters, new BiConsumer() { // from class: io.opentelemetry.instrumentation.api.internal.SupportabilityMetrics$$ExternalSyntheticLambda1
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                SupportabilityMetrics.this.m3152x65a17bea((String) obj, (SupportabilityMetrics.KindCounters) obj2);
            }

            @Override // j$.util.function.BiConsumer
            public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
            }
        });
        ConcurrentMap.EL.KClassImpl$Data$declaredNonStaticMembers$2(this.counters, new BiConsumer() { // from class: io.opentelemetry.instrumentation.api.internal.SupportabilityMetrics$$ExternalSyntheticLambda2
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                SupportabilityMetrics.this.m3153x56f30b6b((String) obj, (AtomicLong) obj2);
            }

            @Override // j$.util.function.BiConsumer
            public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$report$2$io-opentelemetry-instrumentation-api-internal-SupportabilityMetrics  reason: not valid java name */
    public final /* synthetic */ void m3152x65a17bea(String str, KindCounters kindCounters) {
        for (SpanKind spanKind : SpanKind.values()) {
            long andReset = kindCounters.getAndReset(spanKind);
            if (andReset > 0) {
                Consumer<String> consumer = this.reporter;
                StringBuilder sb = new StringBuilder();
                sb.append("Suppressed Spans by '");
                sb.append(str);
                sb.append("' (");
                sb.append(spanKind);
                sb.append(") : ");
                sb.append(andReset);
                consumer.accept(sb.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$report$3$io-opentelemetry-instrumentation-api-internal-SupportabilityMetrics  reason: not valid java name */
    public final /* synthetic */ void m3153x56f30b6b(String str, AtomicLong atomicLong) {
        long andSet = atomicLong.getAndSet(0L);
        if (andSet > 0) {
            Consumer<String> consumer = this.reporter;
            StringBuilder sb = new StringBuilder();
            sb.append("Counter '");
            sb.append(str);
            sb.append("' : ");
            sb.append(andSet);
            consumer.accept(sb.toString());
        }
    }

    private SupportabilityMetrics start() {
        if (this.agentDebugEnabled) {
            Executors.newScheduledThreadPool(1, new ThreadFactory() { // from class: io.opentelemetry.instrumentation.api.internal.SupportabilityMetrics$$ExternalSyntheticLambda5
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    return SupportabilityMetrics.lambda$start$4(runnable);
                }
            }).scheduleAtFixedRate(new Runnable() { // from class: io.opentelemetry.instrumentation.api.internal.SupportabilityMetrics$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    SupportabilityMetrics.this.report();
                }
            }, 5L, 5L, TimeUnit.SECONDS);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Thread lambda$start$4(Runnable runnable) {
        Thread thread = new Thread(runnable, "supportability_metrics_reporter");
        thread.setDaemon(true);
        thread.setContextClassLoader(null);
        return thread;
    }

    /* loaded from: classes9.dex */
    public static final class CounterNames {
        public static final String SQL_STATEMENT_SANITIZER_CACHE_MISS = "SqlStatementSanitizer cache miss";

        private CounterNames() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class KindCounters {
        private final AtomicLong client;
        private final AtomicLong consumer;
        private final AtomicLong internal;
        private final AtomicLong producer;
        private final AtomicLong server;

        private KindCounters() {
            this.server = new AtomicLong();
            this.client = new AtomicLong();
            this.internal = new AtomicLong();
            this.consumer = new AtomicLong();
            this.producer = new AtomicLong();
        }

        /* synthetic */ KindCounters(AnonymousClass1 anonymousClass1) {
            this();
        }

        void increment(SpanKind spanKind) {
            int i = AnonymousClass1.$SwitchMap$io$opentelemetry$api$trace$SpanKind[spanKind.ordinal()];
            if (i == 1) {
                this.internal.incrementAndGet();
            } else if (i == 2) {
                this.server.incrementAndGet();
            } else if (i == 3) {
                this.client.incrementAndGet();
            } else if (i == 4) {
                this.producer.incrementAndGet();
            } else if (i == 5) {
                this.consumer.incrementAndGet();
            }
        }

        long getAndReset(SpanKind spanKind) {
            int i = AnonymousClass1.$SwitchMap$io$opentelemetry$api$trace$SpanKind[spanKind.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return 0L;
                            }
                            return this.consumer.getAndSet(0L);
                        }
                        return this.producer.getAndSet(0L);
                    }
                    return this.client.getAndSet(0L);
                }
                return this.server.getAndSet(0L);
            }
            return this.internal.getAndSet(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.opentelemetry.instrumentation.api.internal.SupportabilityMetrics$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$opentelemetry$api$trace$SpanKind;

        static {
            int[] iArr = new int[SpanKind.values().length];
            $SwitchMap$io$opentelemetry$api$trace$SpanKind = iArr;
            try {
                iArr[SpanKind.INTERNAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$trace$SpanKind[SpanKind.SERVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$trace$SpanKind[SpanKind.CLIENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$trace$SpanKind[SpanKind.PRODUCER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$trace$SpanKind[SpanKind.CONSUMER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}

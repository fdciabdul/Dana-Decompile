package com.splunk.rum;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.griver.base.preload.GriverOnPreloadExtension;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.splunk.rum.AppStartupTimer;
import com.splunk.rum.ConnectionUtil;
import com.splunk.rum.DanaExporter;
import com.splunk.rum.DiskToZipkinExporter;
import com.splunk.rum.FileSender;
import com.splunk.rum.NetworkMonitor;
import com.splunk.rum.RumInitializer;
import com.splunk.rum.ThrottlingExporter;
import id.dana.domain.foundation.logger.PerformanceConstant;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Context;
import io.opentelemetry.exporter.logging.LoggingSpanExporter;
import io.opentelemetry.exporter.zipkin.ZipkinSpanExporter;
import io.opentelemetry.rum.internal.GlobalAttributesSpanAppender;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.resources.ResourceBuilder;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.SdkTracerProviderBuilder;
import io.opentelemetry.sdk.trace.SpanLimits;
import io.opentelemetry.sdk.trace.SpanProcessor;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import j$.time.Duration;
import j$.util.Collection;
import j$.util.Comparator;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.Supplier;
import j$.util.stream.Collectors;
import j$.util.stream.Stream;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import zipkin2.reporter.okhttp3.OkHttpSender;

/* loaded from: classes.dex */
public class SplunkRum {
    static final AttributeKey<String> BuiltInFictitiousFunctionClassFactory;
    static final AttributeKey<Double> DatabaseTableConfigUtil;
    static final AttributeKey<Double> GetContactSyncConfig;
    static final AttributeKey<String> KClassImpl$Data$declaredNonStaticMembers$2;
    private static SplunkRum MyBillsEntityDataFactory;
    static final AttributeKey<String> NetworkUserEntityData$$ExternalSyntheticLambda0;
    static final AttributeKey<String> NetworkUserEntityData$$ExternalSyntheticLambda1;
    static final AttributeKey<String> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private static final AppStartupTimer NetworkUserEntityData$$ExternalSyntheticLambda7;
    static final AttributeKey<String> NetworkUserEntityData$$ExternalSyntheticLambda8;
    static final AttributeKey<Double> PlaceComponentResult;
    static final AttributeKey<String> getAuthRequestContext;
    static final AttributeKey<String> getErrorConfigVersion;
    static final AttributeKey<String> initRecordTimeStamp;
    public static final AttributeKey<String> isLayoutRequested;
    static final AttributeKey<String> lookAheadTest;
    static final AttributeKey<String> moveToNextValue;
    static final AttributeKey<Long> newProxyInstance;
    static final AttributeKey<Long> scheduleImpl;
    private final OpenTelemetrySdk NetworkUserEntityData$$ExternalSyntheticLambda3;
    private final SessionId NetworkUserEntityData$$ExternalSyntheticLambda5;
    private final GlobalAttributesSpanAppender PrepareContext;

    static {
        AppStartupTimer appStartupTimer = new AppStartupTimer();
        NetworkUserEntityData$$ExternalSyntheticLambda7 = appStartupTimer;
        BuiltInFictitiousFunctionClassFactory = AttributeKey.CC.stringKey("component");
        NetworkUserEntityData$$ExternalSyntheticLambda1 = AttributeKey.CC.stringKey("screen.name");
        lookAheadTest = AttributeKey.CC.stringKey("last.screen.name");
        getErrorConfigVersion = AttributeKey.CC.stringKey("error.type");
        moveToNextValue = AttributeKey.CC.stringKey("error.message");
        isLayoutRequested = AttributeKey.CC.stringKey("workflow.name");
        NetworkUserEntityData$$ExternalSyntheticLambda8 = AttributeKey.CC.stringKey("start.type");
        GetContactSyncConfig = AttributeKey.CC.doubleKey("location.lat");
        DatabaseTableConfigUtil = AttributeKey.CC.doubleKey("location.long");
        newProxyInstance = AttributeKey.CC.longKey("storage.free");
        scheduleImpl = AttributeKey.CC.longKey("heap.free");
        PlaceComponentResult = AttributeKey.CC.doubleKey("battery.percent");
        initRecordTimeStamp = AttributeKey.CC.stringKey("link.traceId");
        NetworkUserEntityData$$ExternalSyntheticLambda0 = AttributeKey.CC.stringKey("link.spanId");
        getAuthRequestContext = AttributeKey.CC.stringKey(GriverOnPreloadExtension.PARAMS_APP);
        NetworkUserEntityData$$ExternalSyntheticLambda2 = AttributeKey.CC.stringKey("splunk.rum.version");
        KClassImpl$Data$declaredNonStaticMembers$2 = AttributeKey.CC.stringKey("dana.traceId");
        new Handler(Looper.getMainLooper()).post(new AppStartupTimer.StartFromBackgroundRunnable(appStartupTimer));
    }

    public SplunkRum(OpenTelemetrySdk openTelemetrySdk, SessionId sessionId, GlobalAttributesSpanAppender globalAttributesSpanAppender) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = openTelemetrySdk;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = sessionId;
        this.PrepareContext = globalAttributesSpanAppender;
    }

    public static SplunkRumBuilder getAuthRequestContext() {
        return new SplunkRumBuilder();
    }

    public static SplunkRum BuiltInFictitiousFunctionClassFactory(SplunkRumBuilder splunkRumBuilder, Application application) {
        long j;
        MemorySpanBuffer defaultMemorySpanBuffer;
        SpanExporter throttlingExporter;
        SessionId sessionId;
        ArrayList arrayList;
        String str;
        SessionId sessionId2;
        VisibleScreenTracker visibleScreenTracker;
        SlowRenderingDetector slowRenderingDetectorImpl;
        Application.ActivityLifecycleCallbacks activityCallbacks;
        Span span;
        String str2;
        long j2;
        final SpanStorage defaultSpanStorage;
        if (MyBillsEntityDataFactory != null) {
            InstrumentInjector.log_w("SplunkRum", "Singleton SplunkRum instance has already been initialized.");
            return MyBillsEntityDataFactory;
        }
        if (splunkRumBuilder.BuiltInFictitiousFunctionClassFactory() && splunkRumBuilder.lookAheadTest) {
            InstrumentInjector.log_d("SplunkRum", "No op returned");
            MyBillsEntityDataFactory = NoOpSplunkRum.MyBillsEntityDataFactory;
            str = "SplunkRum";
        } else {
            final RumInitializer rumInitializer = new RumInitializer(splunkRumBuilder, application, NetworkUserEntityData$$ExternalSyntheticLambda7);
            Looper mainLooper = Looper.getMainLooper();
            String PlaceComponentResult2 = rumInitializer.PlaceComponentResult();
            VisibleScreenTracker visibleScreenTracker2 = new VisibleScreenTracker();
            RumInitializer.AnchoredClock anchoredClock = rumInitializer.PlaceComponentResult;
            long nanoTime = anchoredClock.getAuthRequestContext + (anchoredClock.MyBillsEntityDataFactory.nanoTime() - anchoredClock.BuiltInFictitiousFunctionClassFactory);
            ArrayList arrayList2 = new ArrayList();
            ConnectionUtil MyBillsEntityDataFactory2 = ConnectionUtil.Factory.MyBillsEntityDataFactory(rumInitializer.getAuthRequestContext);
            List<RumInitializer.InitializationEvent> list = rumInitializer.BuiltInFictitiousFunctionClassFactory;
            RumInitializer.AnchoredClock anchoredClock2 = rumInitializer.PlaceComponentResult;
            long nanoTime2 = anchoredClock2.getAuthRequestContext + (anchoredClock2.MyBillsEntityDataFactory.nanoTime() - anchoredClock2.BuiltInFictitiousFunctionClassFactory);
            byte b = 0;
            list.add(new RumInitializer.InitializationEvent("connectionUtilInitialized", nanoTime2, b));
            if (rumInitializer.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                ZipkinSpanExporter.baseLogger.setLevel(Level.SEVERE);
                List<RumInitializer.InitializationEvent> list2 = rumInitializer.BuiltInFictitiousFunctionClassFactory;
                RumInitializer.AnchoredClock anchoredClock3 = rumInitializer.PlaceComponentResult;
                j = nanoTime;
                list2.add(new RumInitializer.InitializationEvent("logger setup complete", anchoredClock3.getAuthRequestContext + (anchoredClock3.MyBillsEntityDataFactory.nanoTime() - anchoredClock3.BuiltInFictitiousFunctionClassFactory), b));
            } else {
                j = nanoTime;
            }
            if (rumInitializer.MyBillsEntityDataFactory.moveToNextValue) {
                if (rumInitializer.MyBillsEntityDataFactory.getAuthRequestContext()) {
                    defaultSpanStorage = StartTypeAwareSpanStorage.getAuthRequestContext(visibleScreenTracker2, new FileUtils(), rumInitializer.getAuthRequestContext.getApplicationContext().getFilesDir());
                } else {
                    defaultSpanStorage = new DefaultSpanStorage(new FileUtils(), rumInitializer.getAuthRequestContext.getApplicationContext().getFilesDir());
                }
                OkHttpSender okHttpSender = new OkHttpSender(OkHttpSender.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(rumInitializer.MyBillsEntityDataFactory()));
                BandwidthTracker bandwidthTracker = new BandwidthTracker();
                FileSender.Builder BuiltInFictitiousFunctionClassFactory2 = FileSender.BuiltInFictitiousFunctionClassFactory();
                BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory = okHttpSender;
                BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2 = bandwidthTracker;
                FileSender fileSender = new FileSender(BuiltInFictitiousFunctionClassFactory2, b);
                DiskToZipkinExporter.Builder authRequestContext = DiskToZipkinExporter.getAuthRequestContext();
                authRequestContext.BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory2;
                authRequestContext.getAuthRequestContext = fileSender;
                authRequestContext.PlaceComponentResult = bandwidthTracker;
                authRequestContext.MyBillsEntityDataFactory = defaultSpanStorage;
                final DiskToZipkinExporter diskToZipkinExporter = new DiskToZipkinExporter(authRequestContext);
                diskToZipkinExporter.scheduleImpl.scheduleAtFixedRate(new Runnable() { // from class: com.splunk.rum.DiskToZipkinExporter$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        double d;
                        DiskToZipkinExporter diskToZipkinExporter2 = DiskToZipkinExporter.this;
                        try {
                            if (!diskToZipkinExporter2.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2().PlaceComponentResult()) {
                                InstrumentInjector.log_i("SplunkRum", "Network offline, leaving spans on disk for for eventual export.");
                                return;
                            }
                            Iterator it = ((List) diskToZipkinExporter2.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2(Comparator.CC.comparing(new Function() { // from class: com.splunk.rum.DiskToZipkinExporter$$ExternalSyntheticLambda0
                                @Override // j$.util.function.Function
                                /* renamed from: andThen */
                                public final /* synthetic */ Function mo3169andThen(Function function) {
                                    return Function.CC.getAuthRequestContext(this, function);
                                }

                                @Override // j$.util.function.Function
                                public final Object apply(Object obj) {
                                    return ((File) obj).getName();
                                }

                                @Override // j$.util.function.Function
                                public final /* synthetic */ Function compose(Function function) {
                                    return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
                                }
                            })).BuiltInFictitiousFunctionClassFactory(Collectors.MyBillsEntityDataFactory())).iterator();
                            boolean z = false;
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                File file = (File) it.next();
                                BandwidthTracker bandwidthTracker2 = diskToZipkinExporter2.BuiltInFictitiousFunctionClassFactory;
                                if (bandwidthTracker2.MyBillsEntityDataFactory.size() < 2) {
                                    d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                                } else {
                                    double longValue = ((Long) Collection.EL.getAuthRequestContext(bandwidthTracker2.MyBillsEntityDataFactory).getAuthRequestContext(1L).MyBillsEntityDataFactory((Stream) 0L, (BiFunction<Stream, ? super T, Stream>) new BiFunction() { // from class: com.splunk.rum.BandwidthTracker$$ExternalSyntheticLambda0
                                        @Override // j$.util.function.BiFunction
                                        public final /* synthetic */ BiFunction andThen(Function function) {
                                            return BiFunction.CC.MyBillsEntityDataFactory(this, function);
                                        }

                                        @Override // j$.util.function.BiFunction
                                        public final Object apply(Object obj, Object obj2) {
                                            return Long.valueOf(((Long) obj).longValue() + ((Long) obj2).longValue());
                                        }
                                    }, (BinaryOperator<Stream>) new BandwidthTracker$$ExternalSyntheticLambda1())).longValue();
                                    double longValue2 = bandwidthTracker2.BuiltInFictitiousFunctionClassFactory.getLast().longValue() - bandwidthTracker2.BuiltInFictitiousFunctionClassFactory.getFirst().longValue();
                                    Double.isNaN(longValue2);
                                    Double.isNaN(longValue);
                                    d = longValue / (longValue2 / 1000.0d);
                                }
                                if (d > diskToZipkinExporter2.PlaceComponentResult) {
                                    InstrumentInjector.log_i("SplunkRum", String.format("Export rate %.2f exceeds limit of %.2f, backing off", Double.valueOf(d), Double.valueOf(diskToZipkinExporter2.PlaceComponentResult)));
                                    break;
                                }
                                boolean authRequestContext2 = diskToZipkinExporter2.getAuthRequestContext.getAuthRequestContext(file);
                                z |= authRequestContext2;
                                if (!authRequestContext2) {
                                    break;
                                }
                            }
                            if (z) {
                                return;
                            }
                            diskToZipkinExporter2.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(Collections.emptyList());
                        } catch (Exception e) {
                            InstrumentInjector.log_w("SplunkRum", "Error processing on-disk files", e);
                        }
                    }
                }, 5L, 5L, TimeUnit.SECONDS);
                throttlingExporter = new RumInitializer.LazyInitSpanExporter(new Supplier() { // from class: com.splunk.rum.RumInitializer$$ExternalSyntheticLambda0
                    @Override // j$.util.function.Supplier
                    public final Object get() {
                        RumInitializer rumInitializer2 = RumInitializer.this;
                        return ZipkinWriteToDiskExporterFactory.KClassImpl$Data$declaredNonStaticMembers$2(rumInitializer2.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1, defaultSpanStorage);
                    }
                });
            } else {
                if (rumInitializer.MyBillsEntityDataFactory.getAuthRequestContext()) {
                    defaultMemorySpanBuffer = new StartTypeAwareMemorySpanBuffer(visibleScreenTracker2);
                } else {
                    defaultMemorySpanBuffer = new DefaultMemorySpanBuffer();
                }
                final String MyBillsEntityDataFactory3 = rumInitializer.MyBillsEntityDataFactory();
                ThrottlingExporter.Builder KClassImpl$Data$declaredNonStaticMembers$22 = ThrottlingExporter.KClassImpl$Data$declaredNonStaticMembers$2(new MemoryBufferingExporter(MyBillsEntityDataFactory2, new RumInitializer.LazyInitSpanExporter(new Supplier() { // from class: com.splunk.rum.RumInitializer$$ExternalSyntheticLambda1
                    @Override // j$.util.function.Supplier
                    public final Object get() {
                        SpanExporter build;
                        build = ZipkinSpanExporter.builder().setEncoder(new CustomZipkinEncoder()).setEndpoint(MyBillsEntityDataFactory3).setLocalIpAddressSupplier(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0002: INVOKE (r0v1 'build' io.opentelemetry.sdk.trace.export.SpanExporter) = 
                              (wrap: io.opentelemetry.exporter.zipkin.ZipkinSpanExporterBuilder : 0x0016: INVOKE 
                              (wrap: io.opentelemetry.exporter.zipkin.ZipkinSpanExporterBuilder : 0x000d: INVOKE 
                              (wrap: io.opentelemetry.exporter.zipkin.ZipkinSpanExporterBuilder : 0x0009: INVOKE 
                              (wrap: io.opentelemetry.exporter.zipkin.ZipkinSpanExporterBuilder : 0x0000: INVOKE  type: STATIC call: io.opentelemetry.exporter.zipkin.ZipkinSpanExporter.builder():io.opentelemetry.exporter.zipkin.ZipkinSpanExporterBuilder A[MD:():io.opentelemetry.exporter.zipkin.ZipkinSpanExporterBuilder (m), WRAPPED] (LINE:477))
                              (wrap: com.splunk.rum.CustomZipkinEncoder : 0x0006: CONSTRUCTOR  A[MD:():void (m), WRAPPED] call: com.splunk.rum.CustomZipkinEncoder.<init>():void type: CONSTRUCTOR)
                             type: VIRTUAL call: io.opentelemetry.exporter.zipkin.ZipkinSpanExporterBuilder.setEncoder(zipkin2.codec.BytesEncoder):io.opentelemetry.exporter.zipkin.ZipkinSpanExporterBuilder A[MD:(zipkin2.codec.BytesEncoder<zipkin2.Span>):io.opentelemetry.exporter.zipkin.ZipkinSpanExporterBuilder (m), WRAPPED] (LINE:478))
                              (wrap: java.lang.String : 0x0000: IGET (r1v0 'this' com.splunk.rum.RumInitializer$$ExternalSyntheticLambda1 A[IMMUTABLE_TYPE, THIS]) A[WRAPPED] com.splunk.rum.RumInitializer$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2 java.lang.String)
                             type: VIRTUAL call: io.opentelemetry.exporter.zipkin.ZipkinSpanExporterBuilder.setEndpoint(java.lang.String):io.opentelemetry.exporter.zipkin.ZipkinSpanExporterBuilder A[MD:(java.lang.String):io.opentelemetry.exporter.zipkin.ZipkinSpanExporterBuilder (m), WRAPPED] (LINE:479))
                              (wrap: j$.util.function.Supplier<java.net.InetAddress> : 0x0013: CONSTRUCTOR  A[MD:():void (m), WRAPPED] call: com.splunk.rum.RumInitializer$$ExternalSyntheticLambda3.<init>():void type: CONSTRUCTOR)
                             type: VIRTUAL call: io.opentelemetry.exporter.zipkin.ZipkinSpanExporterBuilder.setLocalIpAddressSupplier(j$.util.function.Supplier):io.opentelemetry.exporter.zipkin.ZipkinSpanExporterBuilder A[MD:(j$.util.function.Supplier<java.net.InetAddress>):io.opentelemetry.exporter.zipkin.ZipkinSpanExporterBuilder (m), WRAPPED] (LINE:481))
                             type: VIRTUAL call: io.opentelemetry.exporter.zipkin.ZipkinSpanExporterBuilder.build():io.opentelemetry.exporter.zipkin.ZipkinSpanExporter A[MD:():io.opentelemetry.exporter.zipkin.ZipkinSpanExporter (m), WRAPPED] (LINE:482) in method: com.splunk.rum.RumInitializer$$ExternalSyntheticLambda1.get():java.lang.Object, file: classes.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                            	at java.base/java.util.ArrayList.forEach(Unknown Source)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.splunk.rum.RumInitializer$$ExternalSyntheticLambda3, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:307)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:718)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1105)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:96)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:840)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                            	... 15 more
                            */
                        /*
                            this = this;
                            java.lang.String r0 = r1
                            io.opentelemetry.sdk.trace.export.SpanExporter r0 = com.splunk.rum.RumInitializer.BuiltInFictitiousFunctionClassFactory(r0)
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.splunk.rum.RumInitializer$$ExternalSyntheticLambda1.get():java.lang.Object");
                    }
                }), defaultMemorySpanBuffer));
                final AttributeKey<String> attributeKey = BuiltInFictitiousFunctionClassFactory;
                KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult = new Function() { // from class: com.splunk.rum.ThrottlingExporter$Builder$$ExternalSyntheticLambda1
                    @Override // j$.util.function.Function
                    /* renamed from: andThen */
                    public final /* synthetic */ Function mo3169andThen(Function function) {
                        return Function.CC.getAuthRequestContext(this, function);
                    }

                    @Override // j$.util.function.Function
                    public final Object apply(Object obj) {
                        return ThrottlingExporter.Builder.MyBillsEntityDataFactory(AttributeKey.this, (SpanData) obj);
                    }

                    @Override // j$.util.function.Function
                    public final /* synthetic */ Function compose(Function function) {
                        return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
                    }
                };
                KClassImpl$Data$declaredNonStaticMembers$22.KClassImpl$Data$declaredNonStaticMembers$2 = 100;
                KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = Duration.ofSeconds(30L);
                throttlingExporter = new ThrottlingExporter(KClassImpl$Data$declaredNonStaticMembers$22, b);
            }
            SpanExporter apply = rumInitializer.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda4.getAuthRequestContext().apply(new SplunkSpanDataModifier(throttlingExporter, rumInitializer.MyBillsEntityDataFactory.initRecordTimeStamp));
            List<RumInitializer.InitializationEvent> list3 = rumInitializer.BuiltInFictitiousFunctionClassFactory;
            RumInitializer.AnchoredClock anchoredClock4 = rumInitializer.PlaceComponentResult;
            list3.add(new RumInitializer.InitializationEvent("zipkin exporter initialized", anchoredClock4.getAuthRequestContext + (anchoredClock4.MyBillsEntityDataFactory.nanoTime() - anchoredClock4.BuiltInFictitiousFunctionClassFactory), (byte) 0));
            List<RumInitializer.InitializationEvent> list4 = rumInitializer.BuiltInFictitiousFunctionClassFactory;
            RumInitializer.AnchoredClock anchoredClock5 = rumInitializer.PlaceComponentResult;
            list4.add(new RumInitializer.InitializationEvent("exporterInitialized", anchoredClock5.getAuthRequestContext + (anchoredClock5.MyBillsEntityDataFactory.nanoTime() - anchoredClock5.BuiltInFictitiousFunctionClassFactory), (byte) 0));
            SessionIdTimeoutHandler sessionIdTimeoutHandler = new SessionIdTimeoutHandler();
            SessionId sessionId3 = new SessionId(sessionIdTimeoutHandler);
            arrayList2.add(sessionIdTimeoutHandler);
            List<RumInitializer.InitializationEvent> list5 = rumInitializer.BuiltInFictitiousFunctionClassFactory;
            RumInitializer.AnchoredClock anchoredClock6 = rumInitializer.PlaceComponentResult;
            list5.add(new RumInitializer.InitializationEvent("sessionIdInitialized", anchoredClock6.getAuthRequestContext + (anchoredClock6.MyBillsEntityDataFactory.nanoTime() - anchoredClock6.BuiltInFictitiousFunctionClassFactory), (byte) 0));
            GlobalAttributesSpanAppender create = GlobalAttributesSpanAppender.create(rumInitializer.MyBillsEntityDataFactory.getErrorConfigVersion);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(create);
            if (rumInitializer.MyBillsEntityDataFactory.DatabaseTableConfigUtil != null) {
                DanaExporter.ResultCallback resultCallback = rumInitializer.MyBillsEntityDataFactory.DatabaseTableConfigUtil;
                final DanaExporter authRequestContext2 = DanaExporter.getAuthRequestContext();
                authRequestContext2.getAuthRequestContext = resultCallback;
                arrayList3.add(SimpleSpanProcessor.create(new RumInitializer.LazyInitSpanExporter(new Supplier() { // from class: com.splunk.rum.RumInitializer$$ExternalSyntheticLambda4
                    @Override // j$.util.function.Supplier
                    public final Object get() {
                        return RumInitializer.PlaceComponentResult(DanaExporter.this);
                    }
                })));
            }
            Clock clock = Clock.CC.getDefault();
            boolean z = rumInitializer.MyBillsEntityDataFactory.FragmentBottomSheetPaymentSettingBinding;
            BatchSpanProcessor build = BatchSpanProcessor.builder(apply).build();
            List<RumInitializer.InitializationEvent> list6 = rumInitializer.BuiltInFictitiousFunctionClassFactory;
            RumInitializer.AnchoredClock anchoredClock7 = rumInitializer.PlaceComponentResult;
            list6.add(new RumInitializer.InitializationEvent("batchSpanProcessorInitialized", anchoredClock7.getAuthRequestContext + (anchoredClock7.MyBillsEntityDataFactory.nanoTime() - anchoredClock7.BuiltInFictitiousFunctionClassFactory), (byte) 0));
            String str3 = (String) Objects.requireNonNull(rumInitializer.MyBillsEntityDataFactory.getAuthRequestContext);
            RumAttributeAppender rumAttributeAppender = new RumAttributeAppender(sessionId3, visibleScreenTracker2, MyBillsEntityDataFactory2);
            List<RumInitializer.InitializationEvent> list7 = rumInitializer.BuiltInFictitiousFunctionClassFactory;
            RumInitializer.AnchoredClock anchoredClock8 = rumInitializer.PlaceComponentResult;
            list7.add(new RumInitializer.InitializationEvent("attributeAppenderInitialized", anchoredClock8.getAuthRequestContext + (anchoredClock8.MyBillsEntityDataFactory.nanoTime() - anchoredClock8.BuiltInFictitiousFunctionClassFactory), (byte) 0));
            ResourceBuilder put = Resource.getDefault().toBuilder().put((AttributeKey<AttributeKey<String>>) getAuthRequestContext, (AttributeKey<String>) str3).put((AttributeKey<AttributeKey<String>>) ResourceAttributes.SERVICE_NAME, (AttributeKey<String>) str3);
            if (rumInitializer.MyBillsEntityDataFactory.scheduleImpl != null) {
                put.put((AttributeKey<AttributeKey<String>>) ResourceAttributes.DEPLOYMENT_ENVIRONMENT, (AttributeKey<String>) rumInitializer.MyBillsEntityDataFactory.scheduleImpl);
            }
            Resource build2 = put.put((AttributeKey<AttributeKey<String>>) NetworkUserEntityData$$ExternalSyntheticLambda2, (AttributeKey<String>) PlaceComponentResult2).put((AttributeKey<AttributeKey<String>>) ResourceAttributes.DEVICE_MODEL_NAME, (AttributeKey<String>) Build.MODEL).put((AttributeKey<AttributeKey<String>>) ResourceAttributes.DEVICE_MODEL_IDENTIFIER, (AttributeKey<String>) Build.MODEL).put((AttributeKey<AttributeKey<String>>) ResourceAttributes.OS_NAME, (AttributeKey<String>) "Android").put((AttributeKey<AttributeKey<String>>) ResourceAttributes.OS_TYPE, (AttributeKey<String>) ResourceAttributes.OsTypeValues.LINUX).put((AttributeKey<AttributeKey<String>>) ResourceAttributes.OS_VERSION, (AttributeKey<String>) Build.VERSION.RELEASE).build();
            List<RumInitializer.InitializationEvent> list8 = rumInitializer.BuiltInFictitiousFunctionClassFactory;
            RumInitializer.AnchoredClock anchoredClock9 = rumInitializer.PlaceComponentResult;
            list8.add(new RumInitializer.InitializationEvent("resourceInitialized", anchoredClock9.getAuthRequestContext + (anchoredClock9.MyBillsEntityDataFactory.nanoTime() - anchoredClock9.BuiltInFictitiousFunctionClassFactory), (byte) 0));
            SdkTracerProviderBuilder resource = SdkTracerProvider.builder().setClock(clock).addSpanProcessor(rumAttributeAppender).setSpanLimits(SpanLimits.builder().setMaxAttributeValueLength(32768).build()).setResource(build2);
            if (z) {
                resource.addSpanProcessor(build);
            }
            List<RumInitializer.InitializationEvent> list9 = rumInitializer.BuiltInFictitiousFunctionClassFactory;
            RumInitializer.AnchoredClock anchoredClock10 = rumInitializer.PlaceComponentResult;
            list9.add(new RumInitializer.InitializationEvent("tracerProviderBuilderInitialized", anchoredClock10.getAuthRequestContext + (anchoredClock10.MyBillsEntityDataFactory.nanoTime() - anchoredClock10.BuiltInFictitiousFunctionClassFactory), (byte) 0));
            if (rumInitializer.MyBillsEntityDataFactory.newProxyInstance) {
                sessionId = sessionId3;
                resource.setSampler(new SessionIdRatioBasedSampler(rumInitializer.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8, sessionId));
            } else {
                sessionId = sessionId3;
            }
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                resource.addSpanProcessor((SpanProcessor) it.next());
            }
            if (rumInitializer.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                SplunkRumBuilder splunkRumBuilder2 = rumInitializer.MyBillsEntityDataFactory;
                resource.addSpanProcessor(SimpleSpanProcessor.create(splunkRumBuilder2.NetworkUserEntityData$$ExternalSyntheticLambda4.getAuthRequestContext().apply(LoggingSpanExporter.create())));
                List<RumInitializer.InitializationEvent> list10 = rumInitializer.BuiltInFictitiousFunctionClassFactory;
                RumInitializer.AnchoredClock anchoredClock11 = rumInitializer.PlaceComponentResult;
                list10.add(new RumInitializer.InitializationEvent("debugSpanExporterInitialized", anchoredClock11.getAuthRequestContext + (anchoredClock11.MyBillsEntityDataFactory.nanoTime() - anchoredClock11.BuiltInFictitiousFunctionClassFactory), (byte) 0));
            }
            SdkTracerProvider build3 = resource.build();
            List<RumInitializer.InitializationEvent> list11 = rumInitializer.BuiltInFictitiousFunctionClassFactory;
            RumInitializer.AnchoredClock anchoredClock12 = rumInitializer.PlaceComponentResult;
            list11.add(new RumInitializer.InitializationEvent("tracerProviderInitialized", anchoredClock12.getAuthRequestContext + (anchoredClock12.MyBillsEntityDataFactory.nanoTime() - anchoredClock12.BuiltInFictitiousFunctionClassFactory), (byte) 0));
            OpenTelemetrySdk build4 = OpenTelemetrySdk.builder().setTracerProvider(build3).build();
            List<RumInitializer.InitializationEvent> list12 = rumInitializer.BuiltInFictitiousFunctionClassFactory;
            RumInitializer.AnchoredClock anchoredClock13 = rumInitializer.PlaceComponentResult;
            list12.add(new RumInitializer.InitializationEvent("openTelemetrySdkInitialized", anchoredClock13.getAuthRequestContext + (anchoredClock13.MyBillsEntityDataFactory.nanoTime() - anchoredClock13.BuiltInFictitiousFunctionClassFactory), (byte) 0));
            if (rumInitializer.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory) {
                AnrWatcher anrWatcher = new AnrWatcher(new Handler(mainLooper), mainLooper.getThread(), new Supplier() { // from class: com.splunk.rum.RumInitializer$$ExternalSyntheticLambda2
                    @Override // j$.util.function.Supplier
                    public final Object get() {
                        return SplunkRum.MyBillsEntityDataFactory();
                    }
                });
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
                AppStateListener appStateListener = new AppStateListener(newScheduledThreadPool.scheduleAtFixedRate(anrWatcher, 1L, 1L, TimeUnit.SECONDS), newScheduledThreadPool, anrWatcher) { // from class: com.splunk.rum.RumInitializer.1
                    final /* synthetic */ ScheduledExecutorService KClassImpl$Data$declaredNonStaticMembers$2;
                    private ScheduledFuture<?> MyBillsEntityDataFactory;
                    final /* synthetic */ AnrWatcher PlaceComponentResult;
                    final /* synthetic */ ScheduledFuture getAuthRequestContext;

                    {
                        this.getAuthRequestContext = r2;
                        this.KClassImpl$Data$declaredNonStaticMembers$2 = newScheduledThreadPool;
                        this.PlaceComponentResult = anrWatcher;
                        this.MyBillsEntityDataFactory = r2;
                    }

                    @Override // com.splunk.rum.AppStateListener
                    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                        if (this.MyBillsEntityDataFactory == null) {
                            this.MyBillsEntityDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleAtFixedRate(this.PlaceComponentResult, 1L, 1L, TimeUnit.SECONDS);
                        }
                    }

                    @Override // com.splunk.rum.AppStateListener
                    public final void getAuthRequestContext() {
                        ScheduledFuture<?> scheduledFuture = this.MyBillsEntityDataFactory;
                        if (scheduledFuture != null) {
                            scheduledFuture.cancel(true);
                            this.MyBillsEntityDataFactory = null;
                        }
                    }
                };
                arrayList = arrayList2;
                arrayList.add(appStateListener);
                List<RumInitializer.InitializationEvent> list13 = rumInitializer.BuiltInFictitiousFunctionClassFactory;
                RumInitializer.AnchoredClock anchoredClock14 = rumInitializer.PlaceComponentResult;
                list13.add(new RumInitializer.InitializationEvent("anrMonitorInitialized", anchoredClock14.getAuthRequestContext + (anchoredClock14.MyBillsEntityDataFactory.nanoTime() - anchoredClock14.BuiltInFictitiousFunctionClassFactory), (byte) 0));
            } else {
                arrayList = arrayList2;
            }
            str = "SplunkRum";
            Tracer tracer = build4.getTracer(str);
            sessionId.MyBillsEntityDataFactory = new SessionIdChangeTracer(tracer);
            if (rumInitializer.MyBillsEntityDataFactory.GetContactSyncConfig) {
                NetworkMonitor networkMonitor = new NetworkMonitor(MyBillsEntityDataFactory2);
                networkMonitor.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = new NetworkMonitor.TracingConnectionStateListener(tracer, networkMonitor.BuiltInFictitiousFunctionClassFactory);
                arrayList.add(networkMonitor);
                List<RumInitializer.InitializationEvent> list14 = rumInitializer.BuiltInFictitiousFunctionClassFactory;
                RumInitializer.AnchoredClock anchoredClock15 = rumInitializer.PlaceComponentResult;
                sessionId2 = sessionId;
                visibleScreenTracker = visibleScreenTracker2;
                list14.add(new RumInitializer.InitializationEvent("networkMonitorInitialized", anchoredClock15.getAuthRequestContext + (anchoredClock15.MyBillsEntityDataFactory.nanoTime() - anchoredClock15.BuiltInFictitiousFunctionClassFactory), (byte) 0));
            } else {
                sessionId2 = sessionId;
                visibleScreenTracker = visibleScreenTracker2;
            }
            rumInitializer.getAuthRequestContext.registerActivityLifecycleCallbacks(new AppStateWatcher(arrayList));
            if (!rumInitializer.MyBillsEntityDataFactory.PrepareContext) {
                InstrumentInjector.log_w(str, "Slow/frozen rendering detection has been disabled by user.");
                slowRenderingDetectorImpl = NoOpSlowRenderingDetector.INSTANCE;
            } else if (Build.VERSION.SDK_INT < 24) {
                InstrumentInjector.log_w(str, "Slow/frozen rendering detection is not supported on platforms older than Android N (SDK version 24).");
                slowRenderingDetectorImpl = NoOpSlowRenderingDetector.INSTANCE;
            } else {
                List<RumInitializer.InitializationEvent> list15 = rumInitializer.BuiltInFictitiousFunctionClassFactory;
                RumInitializer.AnchoredClock anchoredClock16 = rumInitializer.PlaceComponentResult;
                list15.add(new RumInitializer.InitializationEvent("slowRenderingDetectorInitialized", anchoredClock16.getAuthRequestContext + (anchoredClock16.MyBillsEntityDataFactory.nanoTime() - anchoredClock16.BuiltInFictitiousFunctionClassFactory), (byte) 0));
                slowRenderingDetectorImpl = new SlowRenderingDetectorImpl(tracer, rumInitializer.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda7);
            }
            slowRenderingDetectorImpl.start(rumInitializer.getAuthRequestContext);
            if (Build.VERSION.SDK_INT < 29) {
                activityCallbacks = new Pre29ActivityCallbacks(tracer, visibleScreenTracker, rumInitializer.KClassImpl$Data$declaredNonStaticMembers$2);
            } else {
                activityCallbacks = new ActivityCallbacks(tracer, visibleScreenTracker, rumInitializer.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            rumInitializer.getAuthRequestContext.registerActivityLifecycleCallbacks(activityCallbacks);
            List<RumInitializer.InitializationEvent> list16 = rumInitializer.BuiltInFictitiousFunctionClassFactory;
            RumInitializer.AnchoredClock anchoredClock17 = rumInitializer.PlaceComponentResult;
            list16.add(new RumInitializer.InitializationEvent("activityLifecycleCallbacksInitialized", anchoredClock17.getAuthRequestContext + (anchoredClock17.MyBillsEntityDataFactory.nanoTime() - anchoredClock17.BuiltInFictitiousFunctionClassFactory), (byte) 0));
            if (rumInitializer.MyBillsEntityDataFactory.MyBillsEntityDataFactory) {
                CrashReporter.BuiltInFictitiousFunctionClassFactory(tracer, build4.getSdkTracerProvider(), RuntimeDetails.BuiltInFictitiousFunctionClassFactory(rumInitializer.getAuthRequestContext.getApplicationContext()));
                List<RumInitializer.InitializationEvent> list17 = rumInitializer.BuiltInFictitiousFunctionClassFactory;
                RumInitializer.AnchoredClock anchoredClock18 = rumInitializer.PlaceComponentResult;
                list17.add(new RumInitializer.InitializationEvent("crashReportingInitialized", anchoredClock18.getAuthRequestContext + (anchoredClock18.MyBillsEntityDataFactory.nanoTime() - anchoredClock18.BuiltInFictitiousFunctionClassFactory), (byte) 0));
            }
            List<RumInitializer.InitializationEvent> list18 = rumInitializer.BuiltInFictitiousFunctionClassFactory;
            AppStartupTimer appStartupTimer = rumInitializer.KClassImpl$Data$declaredNonStaticMembers$2;
            if (appStartupTimer.PlaceComponentResult != null) {
                span = appStartupTimer.PlaceComponentResult;
            } else {
                Span startSpan = tracer.spanBuilder(TrackId.Stub_AppStart).setStartTimestamp(appStartupTimer.getAuthRequestContext, TimeUnit.NANOSECONDS).setAttribute((AttributeKey<AttributeKey<String>>) BuiltInFictitiousFunctionClassFactory, (AttributeKey<String>) "appstart").setAttribute((AttributeKey<AttributeKey<String>>) NetworkUserEntityData$$ExternalSyntheticLambda8, (AttributeKey<String>) PerformanceConstant.COLD_START_PREFIX).startSpan();
                appStartupTimer.PlaceComponentResult = startSpan;
                span = startSpan;
            }
            final Span startSpan2 = tracer.spanBuilder("SplunkRum.initialize").setParent(Context.CC.current().with(span)).setStartTimestamp(j, TimeUnit.NANOSECONDS).setAttribute((AttributeKey<AttributeKey<String>>) BuiltInFictitiousFunctionClassFactory, (AttributeKey<String>) "appstart").startSpan();
            StringBuilder sb = new StringBuilder();
            sb.append("[debug:");
            sb.append(rumInitializer.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0);
            sb.append(",crashReporting:");
            sb.append(rumInitializer.MyBillsEntityDataFactory.MyBillsEntityDataFactory);
            sb.append(",anrReporting:");
            sb.append(rumInitializer.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory);
            sb.append(",slowRenderingDetector:");
            sb.append(rumInitializer.MyBillsEntityDataFactory.PrepareContext);
            sb.append(",networkMonitor:");
            sb.append(rumInitializer.MyBillsEntityDataFactory.GetContactSyncConfig);
            sb.append("]");
            startSpan2.setAttribute("config_settings", sb.toString());
            for (RumInitializer.InitializationEvent initializationEvent : list18) {
                str2 = initializationEvent.MyBillsEntityDataFactory;
                j2 = initializationEvent.KClassImpl$Data$declaredNonStaticMembers$2;
                startSpan2.addEvent(str2, j2, TimeUnit.NANOSECONDS);
            }
            RumInitializer.AnchoredClock anchoredClock19 = rumInitializer.PlaceComponentResult;
            final long nanoTime3 = anchoredClock19.getAuthRequestContext + (anchoredClock19.MyBillsEntityDataFactory.nanoTime() - anchoredClock19.BuiltInFictitiousFunctionClassFactory);
            rumInitializer.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = new Runnable() { // from class: com.splunk.rum.RumInitializer$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    Span.this.end(nanoTime3, TimeUnit.NANOSECONDS);
                }
            };
            MyBillsEntityDataFactory = new SplunkRum(build4, sessionId2, create);
        }
        if (splunkRumBuilder.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Splunk RUM monitoring initialized with session ID: ");
            sb2.append(MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda5);
            InstrumentInjector.log_i(str, sb2.toString());
        }
        return MyBillsEntityDataFactory;
    }

    public static SplunkRum MyBillsEntityDataFactory() {
        SplunkRum splunkRum = MyBillsEntityDataFactory;
        if (splunkRum == null) {
            InstrumentInjector.log_d("SplunkRum", "SplunkRum not initialized. Returning no-op implementation");
            return NoOpSplunkRum.MyBillsEntityDataFactory;
        }
        return splunkRum;
    }

    public OpenTelemetry PlaceComponentResult() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda3;
    }

    public String KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda5.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(Throwable th, Attributes attributes) {
        BuiltInFictitiousFunctionClassFactory().spanBuilder(th.getClass().getSimpleName()).setAllAttributes(attributes).setAttribute((AttributeKey<AttributeKey<String>>) BuiltInFictitiousFunctionClassFactory, (AttributeKey<String>) "error").startSpan().recordException(th).end();
    }

    public Tracer BuiltInFictitiousFunctionClassFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda3.getTracer("SplunkRum");
    }

    public static String BuiltInFictitiousFunctionClassFactory(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb.append(stackTraceElement);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(Consumer<AttributesBuilder> consumer) {
        this.PrepareContext.update(consumer);
    }

    public void getAuthRequestContext(WebView webView) {
        webView.addJavascriptInterface(new NativeRumSessionId(this), "SplunkRumNative");
    }
}

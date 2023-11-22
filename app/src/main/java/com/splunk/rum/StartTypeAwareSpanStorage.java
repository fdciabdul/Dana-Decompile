package com.splunk.rum;

import com.fullstory.instrumentation.InstrumentInjector;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.stream.Stream;
import java.io.File;
import java.util.Objects;
import java.util.UUID;

/* loaded from: classes.dex */
public class StartTypeAwareSpanStorage implements SpanStorage {
    private final File BuiltInFictitiousFunctionClassFactory;
    private final VisibleScreenTracker KClassImpl$Data$declaredNonStaticMembers$2;
    final File MyBillsEntityDataFactory;
    private final String PlaceComponentResult = UUID.randomUUID().toString();
    final FileUtils getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StartTypeAwareSpanStorage getAuthRequestContext(VisibleScreenTracker visibleScreenTracker, FileUtils fileUtils, File file) {
        StartTypeAwareSpanStorage startTypeAwareSpanStorage = new StartTypeAwareSpanStorage(visibleScreenTracker, fileUtils, file);
        startTypeAwareSpanStorage.PlaceComponentResult();
        return startTypeAwareSpanStorage;
    }

    private StartTypeAwareSpanStorage(VisibleScreenTracker visibleScreenTracker, FileUtils fileUtils, File file) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = visibleScreenTracker;
        this.getAuthRequestContext = fileUtils;
        this.BuiltInFictitiousFunctionClassFactory = file;
        this.MyBillsEntityDataFactory = FileUtils.BuiltInFictitiousFunctionClassFactory(file);
    }

    @Override // com.splunk.rum.SpanStorage
    public final long BuiltInFictitiousFunctionClassFactory() {
        final FileUtils fileUtils = this.getAuthRequestContext;
        return ((Long) fileUtils.lookAheadTest(this.MyBillsEntityDataFactory).MyBillsEntityDataFactory((Stream<File>) 0L, (BiFunction<Stream<File>, ? super File, Stream<File>>) new BiFunction() { // from class: com.splunk.rum.FileUtils$$ExternalSyntheticLambda6
            @Override // j$.util.function.BiFunction
            public final /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction.CC.MyBillsEntityDataFactory(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Long.valueOf(((Long) obj).longValue() + FileUtils.KClassImpl$Data$declaredNonStaticMembers$2((File) obj2));
            }
        }, (BinaryOperator<Stream<File>>) new BandwidthTracker$$ExternalSyntheticLambda1())).longValue();
    }

    @Override // com.splunk.rum.SpanStorage
    public final Stream<File> MyBillsEntityDataFactory() {
        return this.getAuthRequestContext.lookAheadTest(this.MyBillsEntityDataFactory);
    }

    @Override // com.splunk.rum.SpanStorage
    public final Stream<File> getAuthRequestContext() {
        if (lookAheadTest()) {
            this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0(scheduleImpl()).PlaceComponentResult(new Consumer() { // from class: com.splunk.rum.StartTypeAwareSpanStorage$$ExternalSyntheticLambda1
                @Override // j$.util.function.Consumer
                public final /* synthetic */ Consumer andThen(Consumer consumer) {
                    return Consumer.CC.PlaceComponentResult(this, consumer);
                }

                @Override // j$.util.function.Consumer
                public final void accept(Object obj) {
                    File file = (File) obj;
                    boolean renameTo = file.renameTo(new File(StartTypeAwareSpanStorage.this.MyBillsEntityDataFactory, file.getName()));
                    StringBuilder sb = new StringBuilder();
                    sb.append("Moved background span ");
                    sb.append(file.getPath());
                    sb.append(" success ? ");
                    sb.append(renameTo);
                    sb.append(" for eventual send");
                    InstrumentInjector.log_d("SplunkRum", sb.toString());
                }
            });
            PlaceComponentResult();
        }
        return this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0(this.MyBillsEntityDataFactory);
    }

    private boolean lookAheadTest() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult() == null || this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult().equals("unknown")) {
            VisibleScreenTracker visibleScreenTracker = this.KClassImpl$Data$declaredNonStaticMembers$2;
            String str = visibleScreenTracker.getAuthRequestContext.get();
            if (str == null) {
                str = visibleScreenTracker.MyBillsEntityDataFactory.get();
            }
            if (str == null) {
                return false;
            }
        }
        return true;
    }

    private File scheduleImpl() {
        File file = this.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append("background/");
        sb.append(this.PlaceComponentResult);
        return new File(file, sb.toString());
    }

    private void PlaceComponentResult() {
        FileUtils.getErrorConfigVersion(new File(this.MyBillsEntityDataFactory, "background/")).getAuthRequestContext(new Predicate() { // from class: com.splunk.rum.StartTypeAwareSpanStorage$$ExternalSyntheticLambda2
            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate and(Predicate predicate) {
                return Predicate.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate negate() {
                return Predicate.CC.PlaceComponentResult(this);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate or(Predicate predicate) {
                return Predicate.CC.BuiltInFictitiousFunctionClassFactory(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final boolean test(Object obj) {
                return StartTypeAwareSpanStorage.this.PlaceComponentResult((File) obj);
            }
        }).PlaceComponentResult(new Consumer() { // from class: com.splunk.rum.StartTypeAwareSpanStorage$$ExternalSyntheticLambda3
            @Override // j$.util.function.Consumer
            public final /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.PlaceComponentResult(this, consumer);
            }

            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
                StartTypeAwareSpanStorage startTypeAwareSpanStorage = StartTypeAwareSpanStorage.this;
                File file = (File) obj;
                StringBuilder sb = new StringBuilder();
                sb.append("Cleaning up ");
                sb.append(file.getPath());
                InstrumentInjector.log_d("SplunkRum", sb.toString());
                Stream<File> lookAheadTest = startTypeAwareSpanStorage.getAuthRequestContext.lookAheadTest(file);
                final FileUtils fileUtils = startTypeAwareSpanStorage.getAuthRequestContext;
                Objects.requireNonNull(fileUtils);
                lookAheadTest.PlaceComponentResult(new Consumer() { // from class: com.splunk.rum.StartTypeAwareSpanStorage$$ExternalSyntheticLambda0
                    @Override // j$.util.function.Consumer
                    public final void accept(Object obj2) {
                        FileUtils.initRecordTimeStamp((File) obj2);
                    }

                    @Override // j$.util.function.Consumer
                    public final /* synthetic */ Consumer andThen(Consumer consumer) {
                        return Consumer.CC.PlaceComponentResult(this, consumer);
                    }
                });
                FileUtils fileUtils2 = startTypeAwareSpanStorage.getAuthRequestContext;
                FileUtils.initRecordTimeStamp(file);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean PlaceComponentResult(File file) {
        String path = file.getPath();
        return !path.substring(path.lastIndexOf("/") + 1).equals(this.PlaceComponentResult);
    }

    @Override // com.splunk.rum.SpanStorage
    public final File KClassImpl$Data$declaredNonStaticMembers$2() {
        File file;
        if (!lookAheadTest()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Creating background span ");
            sb.append(this.PlaceComponentResult);
            InstrumentInjector.log_d("SplunkRum", sb.toString());
            file = scheduleImpl();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Creating foreground span ");
            sb2.append(this.PlaceComponentResult);
            InstrumentInjector.log_d("SplunkRum", sb2.toString());
            file = this.MyBillsEntityDataFactory;
        }
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Error creating path ");
        sb3.append(file);
        sb3.append(" for span buffer, defaulting to parent");
        InstrumentInjector.log_e("SplunkRum", sb3.toString());
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}

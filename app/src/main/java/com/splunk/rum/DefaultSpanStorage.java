package com.splunk.rum;

import com.fullstory.instrumentation.InstrumentInjector;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;
import j$.util.stream.Stream;
import java.io.File;

/* loaded from: classes.dex */
public class DefaultSpanStorage implements SpanStorage {
    private final FileUtils MyBillsEntityDataFactory;
    private final File getAuthRequestContext;

    public DefaultSpanStorage(FileUtils fileUtils, File file) {
        this.MyBillsEntityDataFactory = fileUtils;
        this.getAuthRequestContext = file;
    }

    @Override // com.splunk.rum.SpanStorage
    public final File KClassImpl$Data$declaredNonStaticMembers$2() {
        File BuiltInFictitiousFunctionClassFactory = FileUtils.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext);
        if (BuiltInFictitiousFunctionClassFactory.exists() || BuiltInFictitiousFunctionClassFactory.mkdirs()) {
            return BuiltInFictitiousFunctionClassFactory;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Error creating path ");
        sb.append(BuiltInFictitiousFunctionClassFactory);
        sb.append(" for span buffer, defaulting to parent");
        InstrumentInjector.log_e("SplunkRum", sb.toString());
        return this.getAuthRequestContext;
    }

    @Override // com.splunk.rum.SpanStorage
    public final Stream<File> MyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0(KClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // com.splunk.rum.SpanStorage
    public final long BuiltInFictitiousFunctionClassFactory() {
        final FileUtils fileUtils = this.MyBillsEntityDataFactory;
        return ((Long) FileUtils.scheduleImpl(KClassImpl$Data$declaredNonStaticMembers$2()).MyBillsEntityDataFactory((Stream<File>) 0L, (BiFunction<Stream<File>, ? super File, Stream<File>>) new BiFunction() { // from class: com.splunk.rum.FileUtils$$ExternalSyntheticLambda0
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
    public final Stream<File> getAuthRequestContext() {
        return this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0(KClassImpl$Data$declaredNonStaticMembers$2());
    }
}

package com.splunk.rum;

import com.alipay.mobile.verifyidentity.business.securitycommon.widget.ConvertUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import j$.util.Comparator;
import j$.util.function.ToLongFunction;
import j$.util.stream.Collectors;
import j$.util.stream.Stream;
import java.io.File;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public class DeviceSpanStorageLimiter {
    private final SpanStorage KClassImpl$Data$declaredNonStaticMembers$2;
    private final int MyBillsEntityDataFactory;
    private final FileUtils PlaceComponentResult;

    public /* synthetic */ DeviceSpanStorageLimiter(Builder builder, byte b) {
        this(builder);
    }

    private DeviceSpanStorageLimiter(Builder builder) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (SpanStorage) Objects.requireNonNull(builder.PlaceComponentResult);
        this.MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory;
        this.PlaceComponentResult = builder.BuiltInFictitiousFunctionClassFactory;
    }

    public static Builder getAuthRequestContext() {
        return new Builder();
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        public SpanStorage PlaceComponentResult;
        int MyBillsEntityDataFactory = 25;
        FileUtils BuiltInFictitiousFunctionClassFactory = new FileUtils();

        Builder() {
        }
    }

    private boolean getAuthRequestContext(long j) {
        return j < (((long) this.MyBillsEntityDataFactory) * ConvertUtils.KB) * ConvertUtils.KB;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        long BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
        if (!getAuthRequestContext(BuiltInFictitiousFunctionClassFactory)) {
            Stream<File> MyBillsEntityDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
            final FileUtils fileUtils = this.PlaceComponentResult;
            Objects.requireNonNull(fileUtils);
            for (File file : (List) MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(Comparator.CC.getAuthRequestContext(new ToLongFunction() { // from class: com.splunk.rum.DeviceSpanStorageLimiter$$ExternalSyntheticLambda0
                @Override // j$.util.function.ToLongFunction
                public final long KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
                    return FileUtils.PlaceComponentResult((File) obj);
                }
            })).BuiltInFictitiousFunctionClassFactory(Collectors.MyBillsEntityDataFactory())) {
                StringBuilder sb = new StringBuilder();
                sb.append("Too much data buffered, dropping file ");
                sb.append(file);
                InstrumentInjector.log_w("SplunkRum", sb.toString());
                long KClassImpl$Data$declaredNonStaticMembers$2 = FileUtils.KClassImpl$Data$declaredNonStaticMembers$2(file);
                FileUtils.initRecordTimeStamp(file);
                BuiltInFictitiousFunctionClassFactory -= KClassImpl$Data$declaredNonStaticMembers$2;
                if (getAuthRequestContext(BuiltInFictitiousFunctionClassFactory)) {
                    break;
                }
            }
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2().getFreeSpace() > (((long) this.MyBillsEntityDataFactory) * ConvertUtils.KB) * ConvertUtils.KB;
    }
}

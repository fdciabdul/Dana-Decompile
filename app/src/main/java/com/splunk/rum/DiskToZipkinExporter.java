package com.splunk.rum;

import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class DiskToZipkinExporter {
    final BandwidthTracker BuiltInFictitiousFunctionClassFactory;
    final SpanStorage KClassImpl$Data$declaredNonStaticMembers$2;
    final ConnectionUtil MyBillsEntityDataFactory;
    final double PlaceComponentResult;
    final FileSender getAuthRequestContext;
    private final FileUtils getErrorConfigVersion;
    final ScheduledExecutorService scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DiskToZipkinExporter(Builder builder) {
        this.scheduleImpl = builder.scheduleImpl;
        this.MyBillsEntityDataFactory = (ConnectionUtil) Objects.requireNonNull(builder.BuiltInFictitiousFunctionClassFactory);
        this.getAuthRequestContext = (FileSender) Objects.requireNonNull(builder.getAuthRequestContext);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (SpanStorage) Objects.requireNonNull(builder.MyBillsEntityDataFactory);
        this.getErrorConfigVersion = builder.NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.BuiltInFictitiousFunctionClassFactory = (BandwidthTracker) Objects.requireNonNull(builder.PlaceComponentResult);
        this.PlaceComponentResult = builder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Builder getAuthRequestContext() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Builder {
        ConnectionUtil BuiltInFictitiousFunctionClassFactory;
        SpanStorage MyBillsEntityDataFactory;
        BandwidthTracker PlaceComponentResult;
        FileSender getAuthRequestContext;
        private ScheduledExecutorService scheduleImpl = Executors.newSingleThreadScheduledExecutor();
        private FileUtils NetworkUserEntityData$$ExternalSyntheticLambda0 = new FileUtils();
        private double KClassImpl$Data$declaredNonStaticMembers$2 = 15360.0d;

        Builder() {
        }
    }
}

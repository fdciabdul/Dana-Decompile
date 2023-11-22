package com.splunk.rum;

import com.splunk.rum.DeviceSpanStorageLimiter;
import com.splunk.rum.ZipkinToDiskSender;
import io.opentelemetry.exporter.zipkin.ZipkinSpanExporter;
import j$.util.function.Supplier;
import java.net.InetAddress;

/* loaded from: classes3.dex */
class ZipkinWriteToDiskExporterFactory {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ InetAddress MyBillsEntityDataFactory() {
        return null;
    }

    private ZipkinWriteToDiskExporterFactory() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZipkinSpanExporter KClassImpl$Data$declaredNonStaticMembers$2(int i, SpanStorage spanStorage) {
        FileUtils fileUtils = new FileUtils();
        DeviceSpanStorageLimiter.Builder authRequestContext = DeviceSpanStorageLimiter.getAuthRequestContext();
        authRequestContext.BuiltInFictitiousFunctionClassFactory = fileUtils;
        authRequestContext.PlaceComponentResult = spanStorage;
        authRequestContext.MyBillsEntityDataFactory = i;
        byte b = 0;
        DeviceSpanStorageLimiter deviceSpanStorageLimiter = new DeviceSpanStorageLimiter(authRequestContext, b);
        ZipkinToDiskSender.Builder PlaceComponentResult = ZipkinToDiskSender.PlaceComponentResult();
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = spanStorage;
        PlaceComponentResult.PlaceComponentResult = fileUtils;
        PlaceComponentResult.MyBillsEntityDataFactory = deviceSpanStorageLimiter;
        return ZipkinSpanExporter.builder().setEncoder(new CustomZipkinEncoder()).setSender(new ZipkinToDiskSender(PlaceComponentResult, b)).setLocalIpAddressSupplier(new Supplier() { // from class: com.splunk.rum.ZipkinWriteToDiskExporterFactory$$ExternalSyntheticLambda0
            @Override // j$.util.function.Supplier
            public final Object get() {
                return ZipkinWriteToDiskExporterFactory.MyBillsEntityDataFactory();
            }
        }).build();
    }
}

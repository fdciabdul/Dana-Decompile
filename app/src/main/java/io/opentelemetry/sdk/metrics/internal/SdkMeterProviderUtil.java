package io.opentelemetry.sdk.metrics.internal;

import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.metrics.ViewBuilder;
import io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter;
import io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor;
import io.opentelemetry.sdk.metrics.internal.view.StringPredicates;
import j$.util.function.Predicate;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes9.dex */
public final class SdkMeterProviderUtil {
    private SdkMeterProviderUtil() {
    }

    public static void setExemplarFilter(SdkMeterProviderBuilder sdkMeterProviderBuilder, ExemplarFilter exemplarFilter) {
        try {
            Method declaredMethod = SdkMeterProviderBuilder.class.getDeclaredMethod("setExemplarFilter", ExemplarFilter.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(sdkMeterProviderBuilder, exemplarFilter);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new IllegalStateException("Error calling setExemplarFilter on SdkMeterProviderBuilder", e);
        }
    }

    public static void appendFilteredBaggageAttributes(ViewBuilder viewBuilder, Predicate<String> predicate) {
        addAttributesProcessor(viewBuilder, AttributesProcessor.appendBaggageByKeyName(predicate));
    }

    public static void appendAllBaggageAttributes(ViewBuilder viewBuilder) {
        appendFilteredBaggageAttributes(viewBuilder, StringPredicates.ALL);
    }

    private static void addAttributesProcessor(ViewBuilder viewBuilder, AttributesProcessor attributesProcessor) {
        try {
            Method declaredMethod = ViewBuilder.class.getDeclaredMethod("addAttributesProcessor", AttributesProcessor.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(viewBuilder, attributesProcessor);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new IllegalStateException("Error adding AttributesProcessor to ViewBuilder", e);
        }
    }

    public static void resetForTest(SdkMeterProvider sdkMeterProvider) {
        try {
            Method declaredMethod = SdkMeterProvider.class.getDeclaredMethod("resetForTest", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(sdkMeterProvider, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new IllegalStateException("Error calling resetForTest on SdkMeterProvider", e);
        }
    }
}

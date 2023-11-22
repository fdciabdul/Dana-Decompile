package com.google.firebase.perf.ktx;

import com.google.firebase.ktx.Firebase;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.HttpMetric;
import com.google.firebase.perf.metrics.Trace;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a2\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0019\u0010\u0004\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001¢\u0006\u0002\b\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a8\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0007*\u00020\b2\u0019\u0010\u0004\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001¢\u0006\u0002\b\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\t\"\u0014\u0010\u000b\u001a\u00020\n8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"\u0015\u0010\u0011\u001a\u00020\u000e*\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {"Lcom/google/firebase/perf/metrics/HttpMetric;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "trace", "(Lcom/google/firebase/perf/metrics/HttpMetric;Lkotlin/jvm/functions/Function1;)V", "T", "Lcom/google/firebase/perf/metrics/Trace;", "(Lcom/google/firebase/perf/metrics/Trace;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "", "LIBRARY_NAME", "Ljava/lang/String;", "Lcom/google/firebase/ktx/Firebase;", "Lcom/google/firebase/perf/FirebasePerformance;", "getPerformance", "(Lcom/google/firebase/ktx/Firebase;)Lcom/google/firebase/perf/FirebasePerformance;", "performance"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class PerformanceKt {
    public static final String LIBRARY_NAME = "fire-perf-ktx";

    @JvmName(name = "getPerformance")
    public static final FirebasePerformance getPerformance(Firebase firebase2) {
        Intrinsics.checkNotNullParameter(firebase2, "");
        FirebasePerformance firebasePerformance = FirebasePerformance.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebasePerformance, "");
        return firebasePerformance;
    }

    public static final void trace(HttpMetric httpMetric, Function1<? super HttpMetric, Unit> function1) {
        Intrinsics.checkNotNullParameter(httpMetric, "");
        Intrinsics.checkNotNullParameter(function1, "");
        httpMetric.start();
        try {
            function1.invoke(httpMetric);
        } finally {
            InlineMarker.finallyStart(1);
            httpMetric.stop();
            InlineMarker.finallyEnd(1);
        }
    }

    public static final <T> T trace(Trace trace, Function1<? super Trace, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(trace, "");
        Intrinsics.checkNotNullParameter(function1, "");
        trace.start();
        try {
            return function1.invoke(trace);
        } finally {
            InlineMarker.finallyStart(1);
            trace.stop();
            InlineMarker.finallyEnd(1);
        }
    }
}

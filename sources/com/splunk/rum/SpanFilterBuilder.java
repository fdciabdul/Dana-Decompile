package com.splunk.rum;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import j$.util.function.Function;
import j$.util.function.Predicate;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class SpanFilterBuilder {
    private Predicate<String> BuiltInFictitiousFunctionClassFactory = new Predicate() { // from class: com.splunk.rum.SpanFilterBuilder$$ExternalSyntheticLambda5
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
            String str = (String) obj;
            return SpanFilterBuilder.PlaceComponentResult();
        }
    };
    private final Map<AttributeKey<?>, Predicate<?>> PlaceComponentResult = new HashMap();
    private final Map<AttributeKey<?>, Function<?, ?>> MyBillsEntityDataFactory = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean MyBillsEntityDataFactory() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean PlaceComponentResult() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Predicate MyBillsEntityDataFactory(Predicate predicate, Predicate predicate2) {
        return predicate2 != null ? predicate2.or(predicate) : predicate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object BuiltInFictitiousFunctionClassFactory(Predicate predicate, Object obj) {
        if (predicate.test(obj)) {
            return null;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Function KClassImpl$Data$declaredNonStaticMembers$2(Function function, Function function2) {
        return function2 != null ? function2.mo3169andThen(function) : function;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Function<SpanExporter, SpanExporter> getAuthRequestContext() {
        final Predicate<String> predicate = this.BuiltInFictitiousFunctionClassFactory;
        final HashMap hashMap = new HashMap(this.PlaceComponentResult);
        final HashMap hashMap2 = new HashMap(this.MyBillsEntityDataFactory);
        return new Function() { // from class: com.splunk.rum.SpanFilterBuilder$$ExternalSyntheticLambda3
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return SpanFilterBuilder.BuiltInFictitiousFunctionClassFactory(Predicate.this, hashMap, hashMap2, (SpanExporter) obj);
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ SpanExporter BuiltInFictitiousFunctionClassFactory(Predicate predicate, Map map, Map map2, SpanExporter spanExporter) {
        return new SpanDataModifier(spanExporter, predicate, map, map2);
    }
}

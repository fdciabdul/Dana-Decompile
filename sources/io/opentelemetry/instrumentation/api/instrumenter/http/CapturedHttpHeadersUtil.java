package io.opentelemetry.instrumentation.api.instrumenter.http;

import io.opentelemetry.api.common.AttributeKey;
import j$.util.Collection;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.concurrent.ConcurrentMap;
import j$.util.function.Function;
import j$.util.stream.Collectors;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class CapturedHttpHeadersUtil {
    private static final ConcurrentMap<String, AttributeKey<List<String>>> requestKeysCache = new ConcurrentHashMap();
    private static final ConcurrentMap<String, AttributeKey<List<String>>> responseKeysCache = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> lowercase(List<String> list) {
        return Collections.unmodifiableList((List) Collection.EL.getAuthRequestContext(list).KClassImpl$Data$declaredNonStaticMembers$2(new Function() { // from class: io.opentelemetry.instrumentation.api.instrumenter.http.CapturedHttpHeadersUtil$$ExternalSyntheticLambda2
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                String lowerCase;
                lowerCase = ((String) obj).toLowerCase(Locale.ROOT);
                return lowerCase;
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        }).BuiltInFictitiousFunctionClassFactory(Collectors.MyBillsEntityDataFactory()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AttributeKey<List<String>> requestAttributeKey(String str) {
        return (AttributeKey) ConcurrentMap.EL.MyBillsEntityDataFactory(requestKeysCache, str, new Function() { // from class: io.opentelemetry.instrumentation.api.instrumenter.http.CapturedHttpHeadersUtil$$ExternalSyntheticLambda1
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                AttributeKey createKey;
                createKey = CapturedHttpHeadersUtil.createKey("request", (String) obj);
                return createKey;
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AttributeKey<List<String>> responseAttributeKey(String str) {
        return (AttributeKey) ConcurrentMap.EL.MyBillsEntityDataFactory(responseKeysCache, str, new Function() { // from class: io.opentelemetry.instrumentation.api.instrumenter.http.CapturedHttpHeadersUtil$$ExternalSyntheticLambda0
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                AttributeKey createKey;
                createKey = CapturedHttpHeadersUtil.createKey("response", (String) obj);
                return createKey;
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AttributeKey<List<String>> createKey(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("http.");
        sb.append(str);
        sb.append(".header.");
        sb.append(str2.replace('-', '_'));
        return AttributeKey.CC.stringArrayKey(sb.toString());
    }

    private CapturedHttpHeadersUtil() {
    }
}

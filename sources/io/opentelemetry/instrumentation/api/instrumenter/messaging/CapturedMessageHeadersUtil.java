package io.opentelemetry.instrumentation.api.instrumenter.messaging;

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
/* loaded from: classes9.dex */
public final class CapturedMessageHeadersUtil {
    private static final ConcurrentMap<String, AttributeKey<List<String>>> attributeKeysCache = new ConcurrentHashMap();

    public static List<String> lowercase(List<String> list) {
        return Collections.unmodifiableList((List) Collection.EL.getAuthRequestContext(list).KClassImpl$Data$declaredNonStaticMembers$2(new Function() { // from class: io.opentelemetry.instrumentation.api.instrumenter.messaging.CapturedMessageHeadersUtil$$ExternalSyntheticLambda0
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

    public static AttributeKey<List<String>> attributeKey(String str) {
        return (AttributeKey) ConcurrentMap.EL.MyBillsEntityDataFactory(attributeKeysCache, str, new Function() { // from class: io.opentelemetry.instrumentation.api.instrumenter.messaging.CapturedMessageHeadersUtil$$ExternalSyntheticLambda1
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                AttributeKey createKey;
                createKey = CapturedMessageHeadersUtil.createKey((String) obj);
                return createKey;
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        });
    }

    public static AttributeKey<List<String>> createKey(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("messaging.header.");
        sb.append(str.replace('-', '_'));
        return AttributeKey.CC.stringArrayKey(sb.toString());
    }

    private CapturedMessageHeadersUtil() {
    }
}

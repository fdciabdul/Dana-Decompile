package io.opentelemetry.sdk.internal;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import j$.util.function.Predicate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public final class AttributeUtil {
    private AttributeUtil() {
    }

    public static Attributes applyAttributesLimit(Attributes attributes, int i, final int i2) {
        if ((attributes.isEmpty() || attributes.size() <= i) && (i2 == Integer.MAX_VALUE || allMatch(attributes.asMap().values(), new Predicate() { // from class: io.opentelemetry.sdk.internal.AttributeUtil$$ExternalSyntheticLambda0
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
                boolean isValidLength;
                isValidLength = AttributeUtil.isValidLength(obj, i2);
                return isValidLength;
            }
        }))) {
            return attributes;
        }
        AttributesBuilder builder = Attributes.CC.builder();
        int i3 = 0;
        for (Map.Entry<AttributeKey<?>, Object> entry : attributes.asMap().entrySet()) {
            if (i3 >= i) {
                break;
            }
            builder.put((AttributeKey<AttributeKey<?>>) entry.getKey(), (AttributeKey<?>) applyAttributeLengthLimit(entry.getValue(), i2));
            i3++;
        }
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isValidLength(Object obj, final int i) {
        if (obj instanceof List) {
            return allMatch((List) obj, new Predicate() { // from class: io.opentelemetry.sdk.internal.AttributeUtil$$ExternalSyntheticLambda1
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
                public final boolean test(Object obj2) {
                    boolean isValidLength;
                    isValidLength = AttributeUtil.isValidLength(obj2, i);
                    return isValidLength;
                }
            });
        }
        return !(obj instanceof String) || ((String) obj).length() < i;
    }

    private static <T> boolean allMatch(Iterable<T> iterable, Predicate<T> predicate) {
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            if (!predicate.test(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static Object applyAttributeLengthLimit(Object obj, int i) {
        if (i == Integer.MAX_VALUE) {
            return obj;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(applyAttributeLengthLimit(it.next(), i));
            }
            return arrayList;
        } else if (obj instanceof String) {
            String str = (String) obj;
            return str.length() < i ? obj : str.substring(0, i);
        } else {
            return obj;
        }
    }
}

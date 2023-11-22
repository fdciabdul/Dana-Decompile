package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/coroutines/CoroutineContext$Element;", "E", "Lkotlin/coroutines/CoroutineContext$Key;", "key", "getPolymorphicElement", "(Lkotlin/coroutines/CoroutineContext$Element;Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "minusPolymorphicKey", "(Lkotlin/coroutines/CoroutineContext$Element;Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class CoroutineContextImplKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <E extends CoroutineContext.Element> E getPolymorphicElement(CoroutineContext.Element element, CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter(element, "");
        Intrinsics.checkNotNullParameter(key, "");
        if (key instanceof AbstractCoroutineContextKey) {
            AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
            if (abstractCoroutineContextKey.isSubKey$kotlin_stdlib(element.getKey())) {
                E e = (E) abstractCoroutineContextKey.tryCast$kotlin_stdlib(element);
                if (e instanceof CoroutineContext.Element) {
                    return e;
                }
                return null;
            }
            return null;
        } else if (element.getKey() != key) {
            return null;
        } else {
            return element;
        }
    }

    public static final CoroutineContext minusPolymorphicKey(CoroutineContext.Element element, CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(element, "");
        Intrinsics.checkNotNullParameter(key, "");
        if (key instanceof AbstractCoroutineContextKey) {
            AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
            boolean isSubKey$kotlin_stdlib = abstractCoroutineContextKey.isSubKey$kotlin_stdlib(element.getKey());
            Object obj = element;
            if (isSubKey$kotlin_stdlib) {
                CoroutineContext.Element tryCast$kotlin_stdlib = abstractCoroutineContextKey.tryCast$kotlin_stdlib(element);
                obj = element;
                if (tryCast$kotlin_stdlib != null) {
                    obj = EmptyCoroutineContext.INSTANCE;
                }
            }
            return (CoroutineContext) obj;
        }
        CoroutineContext.Key<?> key2 = element.getKey();
        Object obj2 = element;
        if (key2 == key) {
            obj2 = EmptyCoroutineContext.INSTANCE;
        }
        return (CoroutineContext) obj2;
    }
}

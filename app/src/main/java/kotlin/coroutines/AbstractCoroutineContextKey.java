package kotlin.coroutines;

import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00028\u00002\b\u0012\u0004\u0012\u00028\u00010\u0004B2\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u001b\u0010\u000e\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0001¢\u0006\u0002\b\r\u0012\u0006\u0012\u0004\u0018\u00018\u00010\f¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u0004\u0018\u00018\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\n\u0010\u000bR)\u0010\u000e\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0001¢\u0006\u0002\b\r\u0012\u0006\u0012\u0004\u0018\u00018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlin/coroutines/CoroutineContext$Element;", DiskFormatter.B, "E", "Lkotlin/coroutines/CoroutineContext$Key;", "key", "", "isSubKey$kotlin_stdlib", "(Lkotlin/coroutines/CoroutineContext$Key;)Z", LottieParams.KEY_ELEMENT_ID, "tryCast$kotlin_stdlib", "(Lkotlin/coroutines/CoroutineContext$Element;)Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "safeCast", "Lkotlin/jvm/functions/Function1;", "topmostKey", "Lkotlin/coroutines/CoroutineContext$Key;", "baseKey", "<init>", "(Lkotlin/coroutines/CoroutineContext$Key;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class AbstractCoroutineContextKey<B extends CoroutineContext.Element, E extends B> implements CoroutineContext.Key<E> {
    private final Function1<CoroutineContext.Element, E> safeCast;
    private final CoroutineContext.Key<?> topmostKey;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.functions.Function1<? super kotlin.coroutines.CoroutineContext$Element, ? extends E extends B>, java.lang.Object, kotlin.jvm.functions.Function1<kotlin.coroutines.CoroutineContext$Element, E extends B>] */
    public AbstractCoroutineContextKey(CoroutineContext.Key<B> key, Function1<? super CoroutineContext.Element, ? extends E> function1) {
        Intrinsics.checkNotNullParameter(key, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.safeCast = function1;
        this.topmostKey = key instanceof AbstractCoroutineContextKey ? (CoroutineContext.Key<B>) ((AbstractCoroutineContextKey) key).topmostKey : key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/CoroutineContext$Element;)TE; */
    public final CoroutineContext.Element tryCast$kotlin_stdlib(CoroutineContext.Element element) {
        Intrinsics.checkNotNullParameter(element, "");
        return (CoroutineContext.Element) this.safeCast.invoke(element);
    }

    public final boolean isSubKey$kotlin_stdlib(CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "");
        return key == this || this.topmostKey == key;
    }
}

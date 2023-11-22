package kotlinx.coroutines.internal;

import com.alibaba.griver.beehive.lottie.player.LottieParams;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0081@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0016\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\f\u001a\u00028\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0013\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u0088\u0001\u0014\u0092\u0001\u0004\u0018\u00010\u0002ø\u0001\u0001\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019"}, d2 = {"Lkotlinx/coroutines/internal/InlineList;", "E", "", "other", "", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "equals", "", "hashCode-impl", "(Ljava/lang/Object;)I", "hashCode", LottieParams.KEY_ELEMENT_ID, "plus-FjFbRPM", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "plus", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "toString", "holder", "Ljava/lang/Object;", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* loaded from: classes6.dex */
public final class InlineList<E> {
    private final Object holder;

    /* renamed from: constructor-impl  reason: not valid java name */
    public static <E> Object m4653constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4655equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof InlineList) && Intrinsics.areEqual(obj, ((InlineList) obj2).getHolder());
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4656hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4658toStringimpl(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("InlineList(holder=");
        sb.append(obj);
        sb.append(')');
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        return m4655equalsimpl(this.holder, obj);
    }

    public final int hashCode() {
        return m4656hashCodeimpl(this.holder);
    }

    public final String toString() {
        return m4658toStringimpl(this.holder);
    }

    /* renamed from: unbox-impl  reason: not valid java name and from getter */
    public final /* synthetic */ Object getHolder() {
        return this.holder;
    }

    /* renamed from: constructor-impl$default  reason: not valid java name */
    public static /* synthetic */ Object m4654constructorimpl$default(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return m4653constructorimpl(obj);
    }

    /* renamed from: plus-FjFbRPM  reason: not valid java name */
    public static final Object m4657plusFjFbRPM(Object obj, E e) {
        if (!DebugKt.getASSERTIONS_ENABLED() || (!(e instanceof List)) == true) {
            if (obj == null) {
                return m4653constructorimpl(e);
            }
            if (obj instanceof ArrayList) {
                if (obj != null) {
                    ((ArrayList) obj).add(e);
                    return m4653constructorimpl(obj);
                }
                throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            }
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(obj);
            arrayList.add(e);
            return m4653constructorimpl(arrayList);
        }
        throw new AssertionError();
    }
}

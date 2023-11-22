package kotlin.collections;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\u001a1\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\t\u0010\n\u001a#\u0010\u000b\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a.\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u0001H\u0086\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u0013\u001a\u00020\u0012*\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0086\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0086\b¢\u0006\u0004\b\u0016\u0010\u0017"}, d2 = {"T", "", "reference", "", GriverMonitorConstants.KEY_SIZE, "arrayOfNulls", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "toIndex", "", "copyOfRangeToIndexCheck", "(II)V", "contentDeepHashCode", "([Ljava/lang/Object;)I", "orEmpty", "([Ljava/lang/Object;)[Ljava/lang/Object;", "", "Ljava/nio/charset/Charset;", "charset", "", "toString", "([BLjava/nio/charset/Charset;)Ljava/lang/String;", "", "toTypedArray", "(Ljava/util/Collection;)[Ljava/lang/Object;"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/collections/ArraysKt")
/* loaded from: classes.dex */
class ArraysKt__ArraysJVMKt {
    private static final String toString(byte[] bArr, Charset charset) {
        Intrinsics.checkNotNullParameter(bArr, "");
        Intrinsics.checkNotNullParameter(charset, "");
        return new String(bArr, charset);
    }

    public static final /* synthetic */ <T> T[] toTypedArray(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "");
        Intrinsics.reifiedOperationMarker(0, "T?");
        Object[] array = collection.toArray(new Object[0]);
        if (array != null) {
            return (T[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final <T> T[] arrayOfNulls(T[] tArr, int i) {
        Intrinsics.checkNotNullParameter(tArr, "");
        Object newInstance = Array.newInstance(tArr.getClass().getComponentType(), i);
        if (newInstance != null) {
            return (T[]) ((Object[]) newInstance);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
    }

    public static final void copyOfRangeToIndexCheck(int i, int i2) {
        if (i <= i2) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("toIndex (");
        sb.append(i);
        sb.append(") is greater than size (");
        sb.append(i2);
        sb.append(").");
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public static final <T> int contentDeepHashCode(T[] tArr) {
        return Arrays.deepHashCode(tArr);
    }

    public static final /* synthetic */ <T> T[] orEmpty(T[] tArr) {
        if (tArr == null) {
            Intrinsics.reifiedOperationMarker(0, "T?");
            return (T[]) new Object[0];
        }
        return tArr;
    }
}

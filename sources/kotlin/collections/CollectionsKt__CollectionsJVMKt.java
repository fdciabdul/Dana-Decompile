package kotlin.collections;

import com.alibaba.griver.beehive.lottie.player.LottieParams;
import id.dana.data.profilemenu.MyProfileMenuAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.builders.ListBuilder;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0001\u001a\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0001\u0010\u0002\u001a)\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001aH\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u00032\u0006\u0010\n\u001a\u00020\t2\u001f\u0010\u000e\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\b\rH\u0080\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a@\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u00032\u001f\u0010\u000e\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\b\rH\u0080\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0011\u001a\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0080\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0080\b¢\u0006\u0004\b\u0016\u0010\u0014\u001a$\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00192\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0080\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a6\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019\"\u0004\b\u0000\u0010\u001d2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00172\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0080\b¢\u0006\u0004\b\u001b\u0010\u001f\u001a\u001b\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003H\u0000¢\u0006\u0004\b \u0010!\u001a#\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b \u0010\"\u001a!\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u001d2\u0006\u0010#\u001a\u00028\u0000¢\u0006\u0004\b$\u0010%\u001a3\u0010'\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001a0\u0019\"\u0004\b\u0000\u0010\u001d*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00192\u0006\u0010&\u001a\u00020\u0000H\u0000¢\u0006\u0004\b'\u0010(\u001a#\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u001d*\b\u0012\u0004\u0012\u00028\u00000)¢\u0006\u0004\b*\u0010+\u001a+\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u001d*\b\u0012\u0004\u0012\u00028\u00000)2\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b*\u0010.\u001a&\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u001d*\b\u0012\u0004\u0012\u00028\u00000/H\u0086\b¢\u0006\u0004\b0\u00101\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {"", "brittleContainsOptimizationEnabled", "()Z", "E", "", "builder", "", "build", "(Ljava/util/List;)Ljava/util/List;", "", "capacity", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "builderAction", "buildListInternal", "(ILkotlin/jvm/functions/Function1;)Ljava/util/List;", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "count", "checkCountOverflow", "(I)I", "index", "checkIndexOverflow", "", MyProfileMenuAction.COLLECTION, "", "", "copyToArrayImpl", "(Ljava/util/Collection;)[Ljava/lang/Object;", "T", "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "createListBuilder", "()Ljava/util/List;", "(I)Ljava/util/List;", LottieParams.KEY_ELEMENT_ID, "listOf", "(Ljava/lang/Object;)Ljava/util/List;", "isVarargs", "copyToArrayOfAny", "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "", "shuffled", "(Ljava/lang/Iterable;)Ljava/util/List;", "Ljava/util/Random;", "random", "(Ljava/lang/Iterable;Ljava/util/Random;)Ljava/util/List;", "Ljava/util/Enumeration;", "toList", "(Ljava/util/Enumeration;)Ljava/util/List;"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes.dex */
public class CollectionsKt__CollectionsJVMKt {
    public static final <T> List<T> listOf(T t) {
        List<T> singletonList = Collections.singletonList(t);
        Intrinsics.checkNotNullExpressionValue(singletonList, "");
        return singletonList;
    }

    private static final <E> List<E> buildListInternal(Function1<? super List<E>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        List createListBuilder = CollectionsKt.createListBuilder();
        function1.invoke(createListBuilder);
        return CollectionsKt.build(createListBuilder);
    }

    private static final <E> List<E> buildListInternal(int i, Function1<? super List<E>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        List createListBuilder = CollectionsKt.createListBuilder(i);
        function1.invoke(createListBuilder);
        return CollectionsKt.build(createListBuilder);
    }

    public static final <E> List<E> createListBuilder() {
        return new ListBuilder();
    }

    public static final <E> List<E> createListBuilder(int i) {
        return new ListBuilder(i);
    }

    public static final <E> List<E> build(List<E> list) {
        Intrinsics.checkNotNullParameter(list, "");
        return ((ListBuilder) list).build();
    }

    private static final <T> List<T> toList(Enumeration<T> enumeration) {
        Intrinsics.checkNotNullParameter(enumeration, "");
        ArrayList list = Collections.list(enumeration);
        Intrinsics.checkNotNullExpressionValue(list, "");
        return list;
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "");
        List<T> mutableList = CollectionsKt.toMutableList(iterable);
        Collections.shuffle(mutableList);
        return mutableList;
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> iterable, Random random) {
        Intrinsics.checkNotNullParameter(iterable, "");
        Intrinsics.checkNotNullParameter(random, "");
        List<T> mutableList = CollectionsKt.toMutableList(iterable);
        Collections.shuffle(mutableList, random);
        return mutableList;
    }

    private static final Object[] copyToArrayImpl(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "");
        return CollectionToArray.toArray(collection);
    }

    private static final <T> T[] copyToArrayImpl(Collection<?> collection, T[] tArr) {
        Intrinsics.checkNotNullParameter(collection, "");
        Intrinsics.checkNotNullParameter(tArr, "");
        return (T[]) CollectionToArray.toArray(collection, tArr);
    }

    public static final <T> Object[] copyToArrayOfAny(T[] tArr, boolean z) {
        Intrinsics.checkNotNullParameter(tArr, "");
        if (z && Intrinsics.areEqual(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        Intrinsics.checkNotNullExpressionValue(copyOf, "");
        return copyOf;
    }

    private static final int checkIndexOverflow(int i) {
        if (i < 0) {
            if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                CollectionsKt.throwIndexOverflow();
            } else {
                throw new ArithmeticException("Index overflow has happened.");
            }
        }
        return i;
    }

    private static final int checkCountOverflow(int i) {
        if (i < 0) {
            if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                CollectionsKt.throwCountOverflow();
            } else {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
        return i;
    }

    public static final boolean brittleContainsOptimizationEnabled() {
        return CollectionSystemProperties.brittleContainsOptimizationEnabled;
    }
}

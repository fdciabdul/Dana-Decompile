package kotlin.collections;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aL\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012#\u0010\u0007\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001aL\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012#\u0010\u0007\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\n\u001a&\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\rj\b\u0012\u0004\u0012\u00028\u0000`\u000e\"\u0004\b\u0000\u0010\u0000H\u0086\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a7\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\rj\b\u0012\u0004\u0012\u00028\u0000`\u000e\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0011\"\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0013\u001aU\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0015\u001a\u00020\u00012\u001f\u0010\u0018\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0003¢\u0006\u0002\b\u0017H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u0019\u0010\n\u001aM\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00142\u001f\u0010\u0018\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0003¢\u0006\u0002\b\u0017H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0019\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000H\u0086\b¢\u0006\u0004\b\u001d\u0010\u001c\u001a-\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0011\"\u00028\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a'\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u0000*\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b!\u0010\"\u001a5\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u0000*\u00020\u001f2\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\u0011\"\u0004\u0018\u00018\u0000¢\u0006\u0004\b!\u0010\u001e\u001a\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000H\u0086\b¢\u0006\u0004\b#\u0010\u001c\u001a-\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0011\"\u00028\u0000¢\u0006\u0004\b#\u0010\u001e\u001a'\u0010&\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0001H\u0002¢\u0006\u0004\b&\u0010'\u001a\u000f\u0010(\u001a\u00020\u0016H\u0000¢\u0006\u0004\b(\u0010)\u001a\u000f\u0010*\u001a\u00020\u0016H\u0000¢\u0006\u0004\b*\u0010)\u001a'\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000+\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0011H\u0000¢\u0006\u0004\b,\u0010-\u001aU\u00101\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010 \u001a\u00028\u00002\u001a\u00100\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000.j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`/2\b\b\u0002\u0010$\u001a\u00020\u00012\b\b\u0002\u0010%\u001a\u00020\u0001¢\u0006\u0004\b1\u00102\u001aE\u00101\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2\b\b\u0002\u0010$\u001a\u00020\u00012\b\b\u0002\u0010%\u001a\u00020\u00012\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0004\b1\u00104\u001aG\u00101\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u000005*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\b2\b\u0010 \u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010$\u001a\u00020\u00012\b\b\u0002\u0010%\u001a\u00020\u0001¢\u0006\u0004\b1\u00106\u001ai\u0010:\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u00107*\b\u0012\u0004\u0012\u00028\u000105*\b\u0012\u0004\u0012\u00028\u00000\b2\b\u00108\u001a\u0004\u0018\u00018\u00012\b\b\u0002\u0010$\u001a\u00020\u00012\b\b\u0002\u0010%\u001a\u00020\u00012\u0016\b\u0004\u00109\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001a5\u0010>\u001a\u00020=\"\u000b\b\u0000\u0010\u0000\u0018\u0001¢\u0006\u0002\b<*\b\u0012\u0004\u0012\u00028\u00000+2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000+H\u0086\b¢\u0006\u0004\b>\u0010?\u001a=\u0010D\u001a\u00028\u0001\"\u0010\b\u0000\u0010@*\u0006\u0012\u0002\b\u00030+*\u00028\u0001\"\u0004\b\u0001\u0010A*\u00028\u00002\f\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00010BH\u0086\bø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001a \u0010F\u001a\u00020=\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000+H\u0086\b¢\u0006\u0004\bF\u0010G\u001a>\u0010H\u001a\u00020=\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010+H\u0086\b\u0082\u0002\u0019\n\u0017\b\u0000\u0012\r\u0010ÿÿÿÿÿÿÿÿÿ\u0001\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0004\bH\u0010G\u001a%\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\bH\u0000¢\u0006\u0004\bI\u0010J\u001a(\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000+\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010+H\u0086\b¢\u0006\u0004\bK\u0010L\u001a(\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bH\u0086\b¢\u0006\u0004\bK\u0010J\u001a+\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000M2\u0006\u0010O\u001a\u00020N¢\u0006\u0004\bP\u0010Q\"\u0019\u0010U\u001a\u00020R*\u0006\u0012\u0002\b\u00030+8G¢\u0006\u0006\u001a\u0004\bS\u0010T\"!\u0010X\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b8G¢\u0006\u0006\u001a\u0004\bV\u0010W\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {"T", "", GriverMonitorConstants.KEY_SIZE, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", IAPSyncCommand.COMMAND_INIT, "", "List", "(ILkotlin/jvm/functions/Function1;)Ljava/util/List;", "", "MutableList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "arrayListOf", "()Ljava/util/ArrayList;", "", "elements", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "E", "capacity", "", "Lkotlin/ExtensionFunctionType;", "builderAction", "buildList", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "emptyList", "()Ljava/util/List;", "listOf", "([Ljava/lang/Object;)Ljava/util/List;", "", LottieParams.KEY_ELEMENT_ID, "listOfNotNull", "(Ljava/lang/Object;)Ljava/util/List;", "mutableListOf", "fromIndex", "toIndex", "rangeCheck$CollectionsKt__CollectionsKt", "(III)V", "throwCountOverflow", "()V", "throwIndexOverflow", "", "asCollection", "([Ljava/lang/Object;)Ljava/util/Collection;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "binarySearch", "(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;II)I", "comparison", "(Ljava/util/List;IILkotlin/jvm/functions/Function1;)I", "", "(Ljava/util/List;Ljava/lang/Comparable;II)I", DiskFormatter.KB, "key", "selector", "binarySearchBy", "(Ljava/util/List;Ljava/lang/Comparable;IILkotlin/jvm/functions/Function1;)I", "Lkotlin/internal/OnlyInputTypes;", "", "containsAll", "(Ljava/util/Collection;Ljava/util/Collection;)Z", "C", "R", "Lkotlin/Function0;", "defaultValue", "ifEmpty", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "(Ljava/util/Collection;)Z", "isNullOrEmpty", "optimizeReadOnlyList", "(Ljava/util/List;)Ljava/util/List;", "orEmpty", "(Ljava/util/Collection;)Ljava/util/Collection;", "", "Lkotlin/random/Random;", "random", "shuffled", "(Ljava/lang/Iterable;Lkotlin/random/Random;)Ljava/util/List;", "Lkotlin/ranges/IntRange;", "getIndices", "(Ljava/util/Collection;)Lkotlin/ranges/IntRange;", "indices", "getLastIndex", "(Ljava/util/List;)I", "lastIndex"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes.dex */
public class CollectionsKt__CollectionsKt extends CollectionsKt__CollectionsJVMKt {
    public static final <T> Collection<T> asCollection(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "");
        return new ArrayAsCollection(tArr, false);
    }

    public static final <T> List<T> emptyList() {
        return EmptyList.INSTANCE;
    }

    public static final <T> List<T> listOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "");
        return tArr.length > 0 ? ArraysKt.asList(tArr) : CollectionsKt.emptyList();
    }

    private static final <T> List<T> listOf() {
        return CollectionsKt.emptyList();
    }

    private static final <T> List<T> mutableListOf() {
        return new ArrayList();
    }

    private static final <T> ArrayList<T> arrayListOf() {
        return new ArrayList<>();
    }

    public static final <T> List<T> mutableListOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new ArrayAsCollection(tArr, true));
    }

    public static final <T> ArrayList<T> arrayListOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "");
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new ArrayAsCollection(tArr, true));
    }

    public static final <T> List<T> listOfNotNull(T t) {
        return t != null ? CollectionsKt.listOf(t) : CollectionsKt.emptyList();
    }

    public static final <T> List<T> listOfNotNull(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "");
        return ArraysKt.filterNotNull(tArr);
    }

    private static final <T> List<T> List(int i, Function1<? super Integer, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(function1.invoke(Integer.valueOf(i2)));
        }
        return arrayList;
    }

    private static final <T> List<T> MutableList(int i, Function1<? super Integer, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(function1.invoke(Integer.valueOf(i2)));
        }
        return arrayList;
    }

    private static final <E> List<E> buildList(Function1<? super List<E>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        List createListBuilder = CollectionsKt.createListBuilder();
        function1.invoke(createListBuilder);
        return CollectionsKt.build(createListBuilder);
    }

    private static final <E> List<E> buildList(int i, Function1<? super List<E>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        List createListBuilder = CollectionsKt.createListBuilder(i);
        function1.invoke(createListBuilder);
        return CollectionsKt.build(createListBuilder);
    }

    @JvmName(name = "getIndices")
    public static final IntRange getIndices(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "");
        return new IntRange(0, collection.size() - 1);
    }

    @JvmName(name = "getLastIndex")
    public static final <T> int getLastIndex(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "");
        return list.size() - 1;
    }

    private static final <T> boolean isNotEmpty(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "");
        return !collection.isEmpty();
    }

    private static final <T> boolean isNullOrEmpty(Collection<? extends T> collection) {
        return collection == null || collection.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Collection<T> orEmpty(Collection<? extends T> collection) {
        return collection == 0 ? CollectionsKt.emptyList() : collection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> List<T> orEmpty(List<? extends T> list) {
        return list == 0 ? CollectionsKt.emptyList() : list;
    }

    /* JADX WARN: Incorrect types in method signature: <C::Ljava/util/Collection<*>;:TR;R:Ljava/lang/Object;>(TC;Lkotlin/jvm/functions/Function0<+TR;>;)TR; */
    private static final Object ifEmpty(Collection collection, Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        return collection.isEmpty() ? function0.invoke() : collection;
    }

    private static final <T> boolean containsAll(Collection<? extends T> collection, Collection<? extends T> collection2) {
        Intrinsics.checkNotNullParameter(collection, "");
        Intrinsics.checkNotNullParameter(collection2, "");
        return collection.containsAll(collection2);
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> iterable, Random random) {
        Intrinsics.checkNotNullParameter(iterable, "");
        Intrinsics.checkNotNullParameter(random, "");
        List<T> mutableList = CollectionsKt.toMutableList(iterable);
        CollectionsKt.shuffle(mutableList, random);
        return mutableList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> optimizeReadOnlyList(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "");
        int size = list.size();
        if (size != 0) {
            return size == 1 ? CollectionsKt.listOf(list.get(0)) : list;
        }
        return CollectionsKt.emptyList();
    }

    public static /* synthetic */ int binarySearch$default(List list, Comparable comparable, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = list.size();
        }
        return CollectionsKt.binarySearch(list, comparable, i, i2);
    }

    public static final <T extends Comparable<? super T>> int binarySearch(List<? extends T> list, T t, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "");
        rangeCheck$CollectionsKt__CollectionsKt(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int compareValues = ComparisonsKt.compareValues(list.get(i4), t);
            if (compareValues < 0) {
                i = i4 + 1;
            } else if (compareValues <= 0) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    public static /* synthetic */ int binarySearch$default(List list, Object obj, Comparator comparator, int i, int i2, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = list.size();
        }
        return CollectionsKt.binarySearch(list, obj, comparator, i, i2);
    }

    public static final <T> int binarySearch(List<? extends T> list, T t, Comparator<? super T> comparator, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(comparator, "");
        rangeCheck$CollectionsKt__CollectionsKt(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int compare = comparator.compare((T) list.get(i4), t);
            if (compare < 0) {
                i = i4 + 1;
            } else if (compare <= 0) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    public static /* synthetic */ int binarySearchBy$default(List list, Comparable comparable, int i, int i2, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = list.size();
        }
        return CollectionsKt.binarySearch(list, i, i2, new CollectionsKt__CollectionsKt$binarySearchBy$1(function1, comparable));
    }

    public static final <T, K extends Comparable<? super K>> int binarySearchBy(List<? extends T> list, K k, int i, int i2, Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(function1, "");
        return CollectionsKt.binarySearch(list, i, i2, new CollectionsKt__CollectionsKt$binarySearchBy$1(function1, k));
    }

    public static /* synthetic */ int binarySearch$default(List list, int i, int i2, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = list.size();
        }
        return CollectionsKt.binarySearch(list, i, i2, function1);
    }

    public static final <T> int binarySearch(List<? extends T> list, int i, int i2, Function1<? super T, Integer> function1) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(function1, "");
        rangeCheck$CollectionsKt__CollectionsKt(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int intValue = function1.invoke((T) list.get(i4)).intValue();
            if (intValue < 0) {
                i = i4 + 1;
            } else if (intValue <= 0) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    private static final void rangeCheck$CollectionsKt__CollectionsKt(int i, int i2, int i3) {
        if (i2 > i3) {
            StringBuilder sb = new StringBuilder();
            sb.append("fromIndex (");
            sb.append(i2);
            sb.append(") is greater than toIndex (");
            sb.append(i3);
            sb.append(").");
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 < 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("fromIndex (");
            sb2.append(i2);
            sb2.append(") is less than zero.");
            throw new IndexOutOfBoundsException(sb2.toString());
        } else if (i3 <= i) {
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("toIndex (");
            sb3.append(i3);
            sb3.append(") is greater than size (");
            sb3.append(i);
            sb3.append(").");
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public static final void throwIndexOverflow() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static final void throwCountOverflow() {
        throw new ArithmeticException("Count overflow has happened.");
    }
}

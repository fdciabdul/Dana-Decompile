package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¸\u0006\u0005"}, d2 = {"Lkotlin/collections/CollectionsKt__IterablesKt$Iterable$1;", "", "", "iterator", "()Ljava/util/Iterator;", "kotlin/collections/CollectionsKt__IterablesKt$Iterable$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ArraysKt___ArraysKt$asIterable$$inlined$Iterable$1<T> implements Iterable<T>, KMappedMarker {
    final /* synthetic */ Object[] $this_asIterable$inlined;

    public ArraysKt___ArraysKt$asIterable$$inlined$Iterable$1(Object[] objArr) {
        this.$this_asIterable$inlined = objArr;
    }

    @Override // java.lang.Iterable
    public final Iterator<T> iterator() {
        return ArrayIteratorKt.iterator(this.$this_asIterable$inlined);
    }
}

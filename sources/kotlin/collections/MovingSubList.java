package kotlin.collections;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u0015\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\t\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00058WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014"}, d2 = {"Lkotlin/collections/MovingSubList;", "E", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "index", "get", "(I)Ljava/lang/Object;", "fromIndex", "toIndex", "", "move", "(II)V", "_size", "I", "", "list", "Ljava/util/List;", "getSize", "()I", GriverMonitorConstants.KEY_SIZE, "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MovingSubList<E> extends AbstractList<E> implements RandomAccess {
    private int _size;
    private int fromIndex;
    private final List<E> list;

    /* JADX WARN: Multi-variable type inference failed */
    public MovingSubList(List<? extends E> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.list = list;
    }

    public final void move(int fromIndex, int toIndex) {
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, this.list.size());
        this.fromIndex = fromIndex;
        this._size = toIndex - fromIndex;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final E get(int index) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, this._size);
        return this.list.get(this.fromIndex + index);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    @JvmName(name = "getSize")
    /* renamed from: getSize  reason: from getter */
    public final int get_size() {
        return this._size;
    }
}

package kotlin.collections;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\b\u0012\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00038WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lkotlin/collections/ReversedListReadOnly;", "T", "Lkotlin/collections/AbstractList;", "", "index", "get", "(I)Ljava/lang/Object;", "", "delegate", "Ljava/util/List;", "getSize", "()I", GriverMonitorConstants.KEY_SIZE, "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public class ReversedListReadOnly<T> extends AbstractList<T> {
    private final List<T> delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public ReversedListReadOnly(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.delegate = list;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    @JvmName(name = "getSize")
    /* renamed from: getSize */
    public int get_size() {
        return this.delegate.size();
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int index) {
        int reverseElementIndex$CollectionsKt__ReversedViewsKt;
        List<T> list = this.delegate;
        reverseElementIndex$CollectionsKt__ReversedViewsKt = CollectionsKt__ReversedViewsKt.reverseElementIndex$CollectionsKt__ReversedViewsKt(this, index);
        return list.get(reverseElementIndex$CollectionsKt__ReversedViewsKt);
    }
}

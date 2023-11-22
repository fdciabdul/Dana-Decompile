package kotlin.collections.unsigned;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u001b\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0002ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0018\u001a\u00020\n8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!"}, d2 = {"Lkotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$2;", "Lkotlin/collections/AbstractList;", "Lkotlin/ULong;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", LottieParams.KEY_ELEMENT_ID, "", "contains-VKZWuLQ", "(J)Z", "contains", "", "index", "get-s-VKNKU", "(I)J", "get", "indexOf-VKZWuLQ", "(J)I", "indexOf", "isEmpty", "()Z", "lastIndexOf-VKZWuLQ", "lastIndexOf", "getSize", "()I", GriverMonitorConstants.KEY_SIZE}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UArraysKt___UArraysJvmKt$asList$2 extends AbstractList<ULong> implements RandomAccess {
    final /* synthetic */ long[] $this_asList;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UArraysKt___UArraysJvmKt$asList$2(long[] jArr) {
        this.$this_asList = jArr;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof ULong) {
            return m3662containsVKZWuLQ(((ULong) obj).getData());
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return ULong.m3345boximpl(m3663getsVKNKU(i));
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof ULong) {
            return m3664indexOfVKZWuLQ(((ULong) obj).getData());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj instanceof ULong) {
            return m3665lastIndexOfVKZWuLQ(((ULong) obj).getData());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    @JvmName(name = "getSize")
    /* renamed from: getSize */
    public final int get_size() {
        return ULongArray.m3411getSizeimpl(this.$this_asList);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return ULongArray.m3413isEmptyimpl(this.$this_asList);
    }

    /* renamed from: contains-VKZWuLQ  reason: not valid java name */
    public final boolean m3662containsVKZWuLQ(long element) {
        return ULongArray.m3406containsVKZWuLQ(this.$this_asList, element);
    }

    /* renamed from: get-s-VKNKU  reason: not valid java name */
    public final long m3663getsVKNKU(int index) {
        return ULongArray.m3410getsVKNKU(this.$this_asList, index);
    }

    /* renamed from: indexOf-VKZWuLQ  reason: not valid java name */
    public final int m3664indexOfVKZWuLQ(long element) {
        return ArraysKt.indexOf(this.$this_asList, element);
    }

    /* renamed from: lastIndexOf-VKZWuLQ  reason: not valid java name */
    public final int m3665lastIndexOfVKZWuLQ(long element) {
        return ArraysKt.lastIndexOf(this.$this_asList, element);
    }
}

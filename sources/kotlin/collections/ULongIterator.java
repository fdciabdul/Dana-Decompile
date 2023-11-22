package kotlin.collections;

import com.ap.zoloz.hummer.biz.HummerConstants;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.markers.KMappedMarker;

@Deprecated(level = DeprecationLevel.ERROR, message = "This class is not going to be stabilized and is to be removed soon.")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0005\u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\u0002H&ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0004ø\u0001\u0001\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019"}, d2 = {"Lkotlin/collections/ULongIterator;", "", "Lkotlin/ULong;", "next-s-VKNKU", "()J", HummerConstants.HUMMER_NEXT, "nextULong-s-VKNKU", "nextULong", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ULongIterator implements Iterator<ULong>, KMappedMarker, j$.util.Iterator {
    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.getAuthRequestContext(this, consumer);
    }

    @Override // java.util.Iterator
    public /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super ULong> consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
    }

    /* renamed from: nextULong-s-VKNKU */
    public abstract long mo3420nextULongsVKNKU();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public /* synthetic */ ULong next() {
        return ULong.m3345boximpl(m3640nextsVKNKU());
    }

    /* renamed from: next-s-VKNKU  reason: not valid java name */
    public final long m3640nextsVKNKU() {
        return mo3420nextULongsVKNKU();
    }
}

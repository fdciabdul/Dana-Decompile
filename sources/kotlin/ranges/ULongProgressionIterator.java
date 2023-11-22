package kotlin.ranges;

import com.ap.zoloz.hummer.biz.HummerConstants;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.collections.ULongIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\"\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0010ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\b\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\u00058\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000eø\u0001\u0000¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0017\u0010\r\u001a\u00020\u00058\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\r\u0010\n\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019"}, d2 = {"Lkotlin/ranges/ULongProgressionIterator;", "Lkotlin/collections/ULongIterator;", "", "hasNext", "()Z", "Lkotlin/ULong;", "nextULong-s-VKNKU", "()J", "nextULong", "finalElement", "J", "Z", HummerConstants.HUMMER_NEXT, "step", "first", "last", "", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
final class ULongProgressionIterator extends ULongIterator {
    private final long finalElement;
    private boolean hasNext;
    private long next;
    private final long step;

    public /* synthetic */ ULongProgressionIterator(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    private ULongProgressionIterator(long j, long j2, long j3) {
        this.finalElement = j2;
        int ulongCompare = UnsignedKt.ulongCompare(j, j2);
        this.hasNext = j3 <= 0 ? ulongCompare >= 0 : ulongCompare <= 0;
        this.step = ULong.m3351constructorimpl(j3);
        this.next = this.hasNext ? j : j2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.ULongIterator
    /* renamed from: nextULong-s-VKNKU */
    public final long mo3420nextULongsVKNKU() {
        long j = this.next;
        if (j == this.finalElement) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.next = ULong.m3351constructorimpl(this.step + j);
        }
        return j;
    }
}

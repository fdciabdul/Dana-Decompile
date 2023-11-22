package kotlin.text;

import com.ap.zoloz.hummer.biz.HummerConstants;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u000b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u000b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R\"\u0010\u001d\u001a\u00020\u000b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011"}, d2 = {"Lkotlin/text/DelimitedRangesSequence$iterator$1;", "", "Lkotlin/ranges/IntRange;", "", "calcNext", "()V", "", "hasNext", "()Z", HummerConstants.HUMMER_NEXT, "()Lkotlin/ranges/IntRange;", "", "counter", "I", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "Lkotlin/ranges/IntRange;", "getNextItem", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DelimitedRangesSequence$iterator$1 implements Iterator<IntRange>, KMappedMarker, j$.util.Iterator {
    private int counter;
    private int currentStartIndex;
    private IntRange nextItem;
    private int nextSearchIndex;
    private int nextState = -1;
    final /* synthetic */ DelimitedRangesSequence this$0;

    @Override // j$.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.getAuthRequestContext(this, consumer);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super IntRange> consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DelimitedRangesSequence$iterator$1(DelimitedRangesSequence delimitedRangesSequence) {
        int i;
        CharSequence charSequence;
        this.this$0 = delimitedRangesSequence;
        i = delimitedRangesSequence.startIndex;
        charSequence = delimitedRangesSequence.input;
        int coerceIn = RangesKt.coerceIn(i, 0, charSequence.length());
        this.currentStartIndex = coerceIn;
        this.nextSearchIndex = coerceIn;
    }

    @JvmName(name = "getNextState")
    public final int getNextState() {
        return this.nextState;
    }

    @JvmName(name = "setNextState")
    public final void setNextState(int i) {
        this.nextState = i;
    }

    @JvmName(name = "getCurrentStartIndex")
    public final int getCurrentStartIndex() {
        return this.currentStartIndex;
    }

    @JvmName(name = "setCurrentStartIndex")
    public final void setCurrentStartIndex(int i) {
        this.currentStartIndex = i;
    }

    @JvmName(name = "getNextSearchIndex")
    public final int getNextSearchIndex() {
        return this.nextSearchIndex;
    }

    @JvmName(name = "setNextSearchIndex")
    public final void setNextSearchIndex(int i) {
        this.nextSearchIndex = i;
    }

    @JvmName(name = "getNextItem")
    public final IntRange getNextItem() {
        return this.nextItem;
    }

    @JvmName(name = "setNextItem")
    public final void setNextItem(IntRange intRange) {
        this.nextItem = intRange;
    }

    @JvmName(name = "getCounter")
    public final int getCounter() {
        return this.counter;
    }

    @JvmName(name = "setCounter")
    public final void setCounter(int i) {
        this.counter = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
    
        if (r0 < r4) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void calcNext() {
        /*
            r6 = this;
            int r0 = r6.nextSearchIndex
            r1 = 0
            if (r0 >= 0) goto Lb
            r6.nextState = r1
            r0 = 0
            r6.nextItem = r0
            return
        Lb:
            kotlin.text.DelimitedRangesSequence r0 = r6.this$0
            int r0 = kotlin.text.DelimitedRangesSequence.access$getLimit$p(r0)
            r2 = -1
            r3 = 1
            if (r0 <= 0) goto L22
            int r0 = r6.counter
            int r0 = r0 + r3
            r6.counter = r0
            kotlin.text.DelimitedRangesSequence r4 = r6.this$0
            int r4 = kotlin.text.DelimitedRangesSequence.access$getLimit$p(r4)
            if (r0 >= r4) goto L30
        L22:
            int r0 = r6.nextSearchIndex
            kotlin.text.DelimitedRangesSequence r4 = r6.this$0
            java.lang.CharSequence r4 = kotlin.text.DelimitedRangesSequence.access$getInput$p(r4)
            int r4 = r4.length()
            if (r0 <= r4) goto L46
        L30:
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r1 = r6.currentStartIndex
            kotlin.text.DelimitedRangesSequence r4 = r6.this$0
            java.lang.CharSequence r4 = kotlin.text.DelimitedRangesSequence.access$getInput$p(r4)
            int r4 = kotlin.text.StringsKt.getLastIndex(r4)
            r0.<init>(r1, r4)
            r6.nextItem = r0
            r6.nextSearchIndex = r2
            goto L9b
        L46:
            kotlin.text.DelimitedRangesSequence r0 = r6.this$0
            kotlin.jvm.functions.Function2 r0 = kotlin.text.DelimitedRangesSequence.access$getGetNextMatch$p(r0)
            kotlin.text.DelimitedRangesSequence r4 = r6.this$0
            java.lang.CharSequence r4 = kotlin.text.DelimitedRangesSequence.access$getInput$p(r4)
            int r5 = r6.nextSearchIndex
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r0 = r0.invoke(r4, r5)
            kotlin.Pair r0 = (kotlin.Pair) r0
            if (r0 != 0) goto L76
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r1 = r6.currentStartIndex
            kotlin.text.DelimitedRangesSequence r4 = r6.this$0
            java.lang.CharSequence r4 = kotlin.text.DelimitedRangesSequence.access$getInput$p(r4)
            int r4 = kotlin.text.StringsKt.getLastIndex(r4)
            r0.<init>(r1, r4)
            r6.nextItem = r0
            r6.nextSearchIndex = r2
            goto L9b
        L76:
            java.lang.Object r2 = r0.component1()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.component2()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r4 = r6.currentStartIndex
            kotlin.ranges.IntRange r4 = kotlin.ranges.RangesKt.until(r4, r2)
            r6.nextItem = r4
            int r2 = r2 + r0
            r6.currentStartIndex = r2
            if (r0 != 0) goto L98
            r1 = 1
        L98:
            int r2 = r2 + r1
            r6.nextSearchIndex = r2
        L9b:
            r6.nextState = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.DelimitedRangesSequence$iterator$1.calcNext():void");
    }

    @Override // java.util.Iterator
    public final IntRange next() {
        if (this.nextState == -1) {
            calcNext();
        }
        if (this.nextState == 0) {
            throw new NoSuchElementException();
        }
        IntRange intRange = this.nextItem;
        if (intRange == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.ranges.IntRange");
        }
        this.nextItem = null;
        this.nextState = -1;
        return intRange;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.nextState == -1) {
            calcNext();
        }
        return this.nextState == 1;
    }
}

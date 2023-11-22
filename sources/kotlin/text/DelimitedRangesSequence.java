package kotlin.text;

import id.dana.data.here.model.HereUrlConstant;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BU\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u00124\u0010\f\u001a0\u0012\u0004\u0012\u00020\u0007\u0012\u000b\u0012\t\u0018\u00010\b¢\u0006\u0002\b\t\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0018\u00010\u0006¢\u0006\u0002\b\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005RB\u0010\f\u001a0\u0012\u0004\u0012\u00020\u0007\u0012\u000b\u0012\t\u0018\u00010\b¢\u0006\u0002\b\t\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0018\u00010\u0006¢\u0006\u0002\b\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011"}, d2 = {"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "", "iterator", "()Ljava/util/Iterator;", "Lkotlin/Function2;", "", "", "Lkotlin/ParameterName;", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "getNextMatch", "Lkotlin/jvm/functions/Function2;", "input", "Ljava/lang/CharSequence;", HereUrlConstant.LIMIT, "I", "startIndex", "<init>", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DelimitedRangesSequence implements Sequence<IntRange> {
    private final Function2<CharSequence, Integer, Pair<Integer, Integer>> getNextMatch;
    private final CharSequence input;
    private final int limit;
    private final int startIndex;

    /* JADX WARN: Multi-variable type inference failed */
    public DelimitedRangesSequence(CharSequence charSequence, int i, int i2, Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>> function2) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(function2, "");
        this.input = charSequence;
        this.startIndex = i;
        this.limit = i2;
        this.getNextMatch = function2;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator<IntRange> iterator() {
        return new DelimitedRangesSequence$iterator$1(this);
    }
}

package kotlin.sequences;

import id.dana.analytics.tracker.TrackerKey;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\u001aR\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u000021\b\b\u0010\u0007\u001a+\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0001¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001aR\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u000021\b\b\u0010\u0007\u001a+\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0001¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001aM\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\u0010\u000e\u001a+\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0001¢\u0006\u0002\b\u0006ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\n\u001aM\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u00002/\u0010\u000e\u001a+\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0001¢\u0006\u0002\b\u0006ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\r\"\u0018\u0010\u0013\u001a\u00060\u0011j\u0002`\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014\"\u0018\u0010\u0015\u001a\u00060\u0011j\u0002`\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014\"\u0018\u0010\u0016\u001a\u00060\u0011j\u0002`\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014\"\u0018\u0010\u0017\u001a\u00060\u0011j\u0002`\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014\"\u0018\u0010\u0018\u001a\u00060\u0011j\u0002`\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014\"\u0018\u0010\u0019\u001a\u00060\u0011j\u0002`\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014*\u001c\u0010\u001a\u001a\u0004\b\u0000\u0010\u0000\"\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0002*\f\b\u0002\u0010\u001b\"\u00020\u00112\u00020\u0011\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"T", "Lkotlin/Function2;", "Lkotlin/sequences/SequenceScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "builderAction", "", "buildIterator", "(Lkotlin/jvm/functions/Function2;)Ljava/util/Iterator;", "Lkotlin/sequences/Sequence;", "buildSequence", "(Lkotlin/jvm/functions/Function2;)Lkotlin/sequences/Sequence;", "block", "iterator", "sequence", "", "Lkotlin/sequences/State;", "State_Done", "I", "State_Failed", "State_ManyNotReady", "State_ManyReady", "State_NotReady", "State_Ready", "SequenceBuilder", TrackerKey.Property.STATE}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes.dex */
public class SequencesKt__SequenceBuilderKt {
    private static final int State_Done = 4;
    private static final int State_Failed = 5;
    private static final int State_ManyNotReady = 1;
    private static final int State_ManyReady = 2;
    private static final int State_NotReady = 0;
    private static final int State_Ready = 3;

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use SequenceScope class instead.", replaceWith = @ReplaceWith(expression = "SequenceScope<T>", imports = {}))
    public static /* synthetic */ void SequenceBuilder$annotations() {
    }

    public static final <T> Sequence<T> sequence(final Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, "");
        return new Sequence<T>() { // from class: kotlin.sequences.SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public final Iterator<T> iterator() {
                return SequencesKt.iterator(Function2.this);
            }
        };
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'sequence { }' function instead.", replaceWith = @ReplaceWith(expression = "sequence(builderAction)", imports = {}))
    private static final <T> Sequence<T> buildSequence(final Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, "");
        return new Sequence<T>() { // from class: kotlin.sequences.SequencesKt__SequenceBuilderKt$buildSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public final Iterator<T> iterator() {
                return SequencesKt.iterator(Function2.this);
            }
        };
    }

    public static final <T> Iterator<T> iterator(Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, "");
        SequenceBuilderIterator sequenceBuilderIterator = new SequenceBuilderIterator();
        sequenceBuilderIterator.setNextStep(IntrinsicsKt.createCoroutineUnintercepted(function2, sequenceBuilderIterator, sequenceBuilderIterator));
        return sequenceBuilderIterator;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'iterator { }' function instead.", replaceWith = @ReplaceWith(expression = "iterator(builderAction)", imports = {}))
    private static final <T> Iterator<T> buildIterator(Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, "");
        return SequencesKt.iterator(function2);
    }
}

package kotlin.time;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.TimeSource;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a:\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\b\u0010\t\u001a2\u0010\u0004\u001a\u00020\u0003*\u00020\n2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0004\u0010\u000b\u001a>\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0006*\u00020\n2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\b\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {"Lkotlin/Function0;", "", "block", "Lkotlin/time/Duration;", "measureTime", "(Lkotlin/jvm/functions/Function0;)J", "T", "Lkotlin/time/TimedValue;", "measureTimedValue", "(Lkotlin/jvm/functions/Function0;)Lkotlin/time/TimedValue;", "Lkotlin/time/TimeSource;", "(Lkotlin/time/TimeSource;Lkotlin/jvm/functions/Function0;)J", "(Lkotlin/time/TimeSource;Lkotlin/jvm/functions/Function0;)Lkotlin/time/TimedValue;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class MeasureTimeKt {
    public static final long measureTime(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        TimeMark markNow = TimeSource.Monotonic.INSTANCE.markNow();
        function0.invoke();
        return markNow.mo4483elapsedNowUwyO8pc();
    }

    public static final long measureTime(TimeSource timeSource, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(timeSource, "");
        Intrinsics.checkNotNullParameter(function0, "");
        TimeMark markNow = timeSource.markNow();
        function0.invoke();
        return markNow.mo4483elapsedNowUwyO8pc();
    }

    public static final <T> TimedValue<T> measureTimedValue(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        return new TimedValue<>(function0.invoke(), TimeSource.Monotonic.INSTANCE.markNow().mo4483elapsedNowUwyO8pc(), null);
    }

    public static final <T> TimedValue<T> measureTimedValue(TimeSource timeSource, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(timeSource, "");
        Intrinsics.checkNotNullParameter(function0, "");
        return new TimedValue<>(function0.invoke(), timeSource.markNow().mo4483elapsedNowUwyO8pc(), null);
    }
}

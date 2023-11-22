package kotlin.time;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlin/time/TimeMark;", "other", "", "compareTo", "(Lkotlin/time/TimeMark;Lkotlin/time/TimeMark;)I", "Lkotlin/time/Duration;", "minus", "(Lkotlin/time/TimeMark;Lkotlin/time/TimeMark;)J"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TimeSourceKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Subtracting one TimeMark from another is not a well defined operation because these time marks could have been obtained from the different time sources.")
    private static final long minus(TimeMark timeMark, TimeMark timeMark2) {
        Intrinsics.checkNotNullParameter(timeMark, "");
        Intrinsics.checkNotNullParameter(timeMark2, "");
        throw new Error("Operation is disallowed.");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Comparing one TimeMark to another is not a well defined operation because these time marks could have been obtained from the different time sources.")
    private static final int compareTo(TimeMark timeMark, TimeMark timeMark2) {
        Intrinsics.checkNotNullParameter(timeMark, "");
        Intrinsics.checkNotNullParameter(timeMark2, "");
        throw new Error("Operation is disallowed.");
    }
}

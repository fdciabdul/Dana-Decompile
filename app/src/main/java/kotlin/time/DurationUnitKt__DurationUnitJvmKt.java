package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\b\u001a'\u0010\t\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\b\u001a\u0011\u0010\u000b\u001a\u00020\u0002*\u00020\n¢\u0006\u0004\b\u000b\u0010\f\u001a\u0011\u0010\r\u001a\u00020\n*\u00020\u0002¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"", "value", "Lkotlin/time/DurationUnit;", "sourceUnit", "targetUnit", "convertDurationUnit", "(DLkotlin/time/DurationUnit;Lkotlin/time/DurationUnit;)D", "", "(JLkotlin/time/DurationUnit;Lkotlin/time/DurationUnit;)J", "convertDurationUnitOverflow", "Ljava/util/concurrent/TimeUnit;", "toDurationUnit", "(Ljava/util/concurrent/TimeUnit;)Lkotlin/time/DurationUnit;", "toTimeUnit", "(Lkotlin/time/DurationUnit;)Ljava/util/concurrent/TimeUnit;"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/time/DurationUnitKt")
/* loaded from: classes3.dex */
class DurationUnitKt__DurationUnitJvmKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            iArr[TimeUnit.MICROSECONDS.ordinal()] = 2;
            iArr[TimeUnit.MILLISECONDS.ordinal()] = 3;
            iArr[TimeUnit.SECONDS.ordinal()] = 4;
            iArr[TimeUnit.MINUTES.ordinal()] = 5;
            iArr[TimeUnit.HOURS.ordinal()] = 6;
            iArr[TimeUnit.DAYS.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final TimeUnit toTimeUnit(DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "");
        return durationUnit.getTimeUnit();
    }

    public static final DurationUnit toDurationUnit(TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "");
        switch (WhenMappings.$EnumSwitchMapping$0[timeUnit.ordinal()]) {
            case 1:
                return DurationUnit.NANOSECONDS;
            case 2:
                return DurationUnit.MICROSECONDS;
            case 3:
                return DurationUnit.MILLISECONDS;
            case 4:
                return DurationUnit.SECONDS;
            case 5:
                return DurationUnit.MINUTES;
            case 6:
                return DurationUnit.HOURS;
            case 7:
                return DurationUnit.DAYS;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final double convertDurationUnit(double d, DurationUnit durationUnit, DurationUnit durationUnit2) {
        Intrinsics.checkNotNullParameter(durationUnit, "");
        Intrinsics.checkNotNullParameter(durationUnit2, "");
        long convert = durationUnit2.getTimeUnit().convert(1L, durationUnit.getTimeUnit());
        if (convert > 0) {
            double d2 = convert;
            Double.isNaN(d2);
            return d * d2;
        }
        double convert2 = durationUnit.getTimeUnit().convert(1L, durationUnit2.getTimeUnit());
        Double.isNaN(convert2);
        return d / convert2;
    }

    public static final long convertDurationUnitOverflow(long j, DurationUnit durationUnit, DurationUnit durationUnit2) {
        Intrinsics.checkNotNullParameter(durationUnit, "");
        Intrinsics.checkNotNullParameter(durationUnit2, "");
        return durationUnit2.getTimeUnit().convert(j, durationUnit.getTimeUnit());
    }

    public static final long convertDurationUnit(long j, DurationUnit durationUnit, DurationUnit durationUnit2) {
        Intrinsics.checkNotNullParameter(durationUnit, "");
        Intrinsics.checkNotNullParameter(durationUnit2, "");
        return durationUnit2.getTimeUnit().convert(j, durationUnit.getTimeUnit());
    }
}

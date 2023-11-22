package kotlin.time;

import id.dana.data.config.source.amcs.result.OTCAcceptExpiryTimeConfigResult;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b%\u001a\"\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\t\u001a\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\t\u001a\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\t\u001a\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\t\u001a\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0011\u0010\t\u001a\"\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0017\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a0\u0010\u001e\u001a\u00020\u0002*\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00022\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00140\u001bH\u0082\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a0\u0010 \u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00022\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00140\u001bH\u0082\b¢\u0006\u0004\b \u0010!\u001a\u001f\u0010&\u001a\u00020\u0004*\u00020\"2\u0006\u0010#\u001a\u00020\u0004H\u0086\nø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a\u001f\u0010&\u001a\u00020\u0004*\u00020\u00022\u0006\u0010#\u001a\u00020\u0004H\u0086\nø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a\u001c\u0010+\u001a\u00020\u0004*\u00020\"2\u0006\u0010*\u001a\u00020)ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a\u001c\u0010+\u001a\u00020\u0004*\u00020\u00022\u0006\u0010*\u001a\u00020)ø\u0001\u0000¢\u0006\u0004\b+\u0010-\u001a\u001c\u0010+\u001a\u00020\u0004*\u00020\u00002\u0006\u0010*\u001a\u00020)ø\u0001\u0000¢\u0006\u0004\b+\u0010.\"\u0014\u0010/\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b/\u00100\"\u0014\u00101\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b1\u00100\"\u0014\u00102\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u00100\"\u0014\u00103\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b3\u00104\"!\u00109\u001a\u00020\u0004*\u00020\"8GX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b7\u00108\u001a\u0004\b5\u00106\"!\u00109\u001a\u00020\u0004*\u00020\u00028GX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b7\u0010;\u001a\u0004\b5\u0010:\"!\u00109\u001a\u00020\u0004*\u00020\u00008GX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b7\u0010<\u001a\u0004\b5\u0010\t\"!\u0010?\u001a\u00020\u0004*\u00020\"8GX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b>\u00108\u001a\u0004\b=\u00106\"!\u0010?\u001a\u00020\u0004*\u00020\u00028GX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b>\u0010;\u001a\u0004\b=\u0010:\"!\u0010?\u001a\u00020\u0004*\u00020\u00008GX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b>\u0010<\u001a\u0004\b=\u0010\t\"!\u0010B\u001a\u00020\u0004*\u00020\"8GX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bA\u00108\u001a\u0004\b@\u00106\"!\u0010B\u001a\u00020\u0004*\u00020\u00028GX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bA\u0010;\u001a\u0004\b@\u0010:\"!\u0010B\u001a\u00020\u0004*\u00020\u00008GX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bA\u0010<\u001a\u0004\b@\u0010\t\"!\u0010E\u001a\u00020\u0004*\u00020\"8GX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bD\u00108\u001a\u0004\bC\u00106\"!\u0010E\u001a\u00020\u0004*\u00020\u00028GX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bD\u0010;\u001a\u0004\bC\u0010:\"!\u0010E\u001a\u00020\u0004*\u00020\u00008GX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bD\u0010<\u001a\u0004\bC\u0010\t\"!\u0010H\u001a\u00020\u0004*\u00020\"8GX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bG\u00108\u001a\u0004\bF\u00106\"!\u0010H\u001a\u00020\u0004*\u00020\u00028GX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bG\u0010;\u001a\u0004\bF\u0010:\"!\u0010H\u001a\u00020\u0004*\u00020\u00008GX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bG\u0010<\u001a\u0004\bF\u0010\t\"!\u0010K\u001a\u00020\u0004*\u00020\"8GX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bJ\u00108\u001a\u0004\bI\u00106\"!\u0010K\u001a\u00020\u0004*\u00020\u00028GX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bJ\u0010;\u001a\u0004\bI\u0010:\"!\u0010K\u001a\u00020\u0004*\u00020\u00008GX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bJ\u0010<\u001a\u0004\bI\u0010\t\"!\u0010N\u001a\u00020\u0004*\u00020\"8GX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bM\u00108\u001a\u0004\bL\u00106\"!\u0010N\u001a\u00020\u0004*\u00020\u00028GX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bM\u0010;\u001a\u0004\bL\u0010:\"!\u0010N\u001a\u00020\u0004*\u00020\u00008GX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bM\u0010<\u001a\u0004\bL\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"", "normalValue", "", "unitDiscriminator", "Lkotlin/time/Duration;", "durationOf", "(JI)J", "normalMillis", "durationOfMillis", "(J)J", "millis", "durationOfMillisNormalized", "normalNanos", "durationOfNanos", "nanos", "durationOfNanosNormalized", "millisToNanos", "nanosToMillis", "", "value", "", "strictIso", "parseDuration", "(Ljava/lang/String;Z)J", "parseOverLongIsoComponent", "(Ljava/lang/String;)J", "startIndex", "Lkotlin/Function1;", "", "predicate", "skipWhile", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;)I", "substringWhile", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;)Ljava/lang/String;", "", "duration", "times-kIfJnKk", "(DJ)J", "times", "times-mvk6XK0", "(IJ)J", "Lkotlin/time/DurationUnit;", OTCAcceptExpiryTimeConfigResult.JsonKey.UNIT, "toDuration", "(DLkotlin/time/DurationUnit;)J", "(ILkotlin/time/DurationUnit;)J", "(JLkotlin/time/DurationUnit;)J", "MAX_MILLIS", "J", "MAX_NANOS", "MAX_NANOS_IN_MILLIS", "NANOS_IN_MILLIS", "I", "getDays", "(D)J", "getDays$annotations", "(D)V", "days", "(I)J", "(I)V", "(J)V", "getHours", "getHours$annotations", "hours", "getMicroseconds", "getMicroseconds$annotations", "microseconds", "getMilliseconds", "getMilliseconds$annotations", "milliseconds", "getMinutes", "getMinutes$annotations", "minutes", "getNanoseconds", "getNanoseconds$annotations", "nanoseconds", "getSeconds", "getSeconds$annotations", "seconds"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DurationKt {
    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final int NANOS_IN_MILLIS = 1000000;

    @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static /* synthetic */ void getDays$annotations(double d) {
    }

    @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static /* synthetic */ void getDays$annotations(int i) {
    }

    @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static /* synthetic */ void getDays$annotations(long j) {
    }

    @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static /* synthetic */ void getHours$annotations(double d) {
    }

    @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static /* synthetic */ void getHours$annotations(int i) {
    }

    @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static /* synthetic */ void getHours$annotations(long j) {
    }

    @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static /* synthetic */ void getMicroseconds$annotations(double d) {
    }

    @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static /* synthetic */ void getMicroseconds$annotations(int i) {
    }

    @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static /* synthetic */ void getMicroseconds$annotations(long j) {
    }

    @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static /* synthetic */ void getMilliseconds$annotations(double d) {
    }

    @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static /* synthetic */ void getMilliseconds$annotations(int i) {
    }

    @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static /* synthetic */ void getMilliseconds$annotations(long j) {
    }

    @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static /* synthetic */ void getMinutes$annotations(double d) {
    }

    @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static /* synthetic */ void getMinutes$annotations(int i) {
    }

    @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static /* synthetic */ void getMinutes$annotations(long j) {
    }

    @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static /* synthetic */ void getNanoseconds$annotations(double d) {
    }

    @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static /* synthetic */ void getNanoseconds$annotations(int i) {
    }

    @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static /* synthetic */ void getNanoseconds$annotations(long j) {
    }

    @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static /* synthetic */ void getSeconds$annotations(double d) {
    }

    @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static /* synthetic */ void getSeconds$annotations(int i) {
    }

    @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static /* synthetic */ void getSeconds$annotations(long j) {
    }

    public static final long millisToNanos(long j) {
        return j * 1000000;
    }

    public static final long toDuration(int i, DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "");
        if (durationUnit.compareTo(DurationUnit.SECONDS) <= 0) {
            return durationOfNanos(DurationUnitKt.convertDurationUnitOverflow(i, durationUnit, DurationUnit.NANOSECONDS));
        }
        return toDuration(i, durationUnit);
    }

    public static final long toDuration(long j, DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "");
        long convertDurationUnitOverflow = DurationUnitKt.convertDurationUnitOverflow(MAX_NANOS, DurationUnit.NANOSECONDS, durationUnit);
        boolean z = false;
        if ((-convertDurationUnitOverflow) <= j && j <= convertDurationUnitOverflow) {
            z = true;
        }
        if (z) {
            return durationOfNanos(DurationUnitKt.convertDurationUnitOverflow(j, durationUnit, DurationUnit.NANOSECONDS));
        }
        return durationOfMillis(RangesKt.coerceIn(DurationUnitKt.convertDurationUnit(j, durationUnit, DurationUnit.MILLISECONDS), -4611686018427387903L, (long) MAX_MILLIS));
    }

    public static final long toDuration(double d, DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "");
        double convertDurationUnit = DurationUnitKt.convertDurationUnit(d, durationUnit, DurationUnit.NANOSECONDS);
        if ((!Double.isNaN(convertDurationUnit)) == false) {
            throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
        }
        long roundToLong = MathKt.roundToLong(convertDurationUnit);
        if (-4611686018426999999L <= roundToLong && roundToLong < 4611686018427000000L) {
            return durationOfNanos(roundToLong);
        }
        return durationOfMillisNormalized(MathKt.roundToLong(DurationUnitKt.convertDurationUnit(d, durationUnit, DurationUnit.MILLISECONDS)));
    }

    @JvmName(name = "getNanoseconds")
    public static final long getNanoseconds(int i) {
        return toDuration(i, DurationUnit.NANOSECONDS);
    }

    @JvmName(name = "getNanoseconds")
    public static final long getNanoseconds(long j) {
        return toDuration(j, DurationUnit.NANOSECONDS);
    }

    @JvmName(name = "getNanoseconds")
    public static final long getNanoseconds(double d) {
        return toDuration(d, DurationUnit.NANOSECONDS);
    }

    @JvmName(name = "getMicroseconds")
    public static final long getMicroseconds(int i) {
        return toDuration(i, DurationUnit.MICROSECONDS);
    }

    @JvmName(name = "getMicroseconds")
    public static final long getMicroseconds(long j) {
        return toDuration(j, DurationUnit.MICROSECONDS);
    }

    @JvmName(name = "getMicroseconds")
    public static final long getMicroseconds(double d) {
        return toDuration(d, DurationUnit.MICROSECONDS);
    }

    @JvmName(name = "getMilliseconds")
    public static final long getMilliseconds(int i) {
        return toDuration(i, DurationUnit.MILLISECONDS);
    }

    @JvmName(name = "getMilliseconds")
    public static final long getMilliseconds(long j) {
        return toDuration(j, DurationUnit.MILLISECONDS);
    }

    @JvmName(name = "getMilliseconds")
    public static final long getMilliseconds(double d) {
        return toDuration(d, DurationUnit.MILLISECONDS);
    }

    @JvmName(name = "getSeconds")
    public static final long getSeconds(int i) {
        return toDuration(i, DurationUnit.SECONDS);
    }

    @JvmName(name = "getSeconds")
    public static final long getSeconds(long j) {
        return toDuration(j, DurationUnit.SECONDS);
    }

    @JvmName(name = "getSeconds")
    public static final long getSeconds(double d) {
        return toDuration(d, DurationUnit.SECONDS);
    }

    @JvmName(name = "getMinutes")
    public static final long getMinutes(int i) {
        return toDuration(i, DurationUnit.MINUTES);
    }

    @JvmName(name = "getMinutes")
    public static final long getMinutes(long j) {
        return toDuration(j, DurationUnit.MINUTES);
    }

    @JvmName(name = "getMinutes")
    public static final long getMinutes(double d) {
        return toDuration(d, DurationUnit.MINUTES);
    }

    @JvmName(name = "getHours")
    public static final long getHours(int i) {
        return toDuration(i, DurationUnit.HOURS);
    }

    @JvmName(name = "getHours")
    public static final long getHours(long j) {
        return toDuration(j, DurationUnit.HOURS);
    }

    @JvmName(name = "getHours")
    public static final long getHours(double d) {
        return toDuration(d, DurationUnit.HOURS);
    }

    @JvmName(name = "getDays")
    public static final long getDays(int i) {
        return toDuration(i, DurationUnit.DAYS);
    }

    @JvmName(name = "getDays")
    public static final long getDays(long j) {
        return toDuration(j, DurationUnit.DAYS);
    }

    @JvmName(name = "getDays")
    public static final long getDays(double d) {
        return toDuration(d, DurationUnit.DAYS);
    }

    /* renamed from: times-mvk6XK0 */
    private static final long m4616timesmvk6XK0(int i, long j) {
        return Duration.m4528timesUwyO8pc(j, i);
    }

    /* renamed from: times-kIfJnKk */
    private static final long m4615timeskIfJnKk(double d, long j) {
        return Duration.m4527timesUwyO8pc(j, d);
    }

    public static final long parseDuration(String str, boolean z) {
        int length = str.length();
        if (length == 0) {
            throw new IllegalArgumentException("The string is empty");
        }
        long m4592getZEROUwyO8pc = Duration.INSTANCE.m4592getZEROUwyO8pc();
        char charAt = str.charAt(0);
        int i = (charAt == '+' || charAt == '-') ? 1 : 0;
        boolean z2 = i > 0;
        Object obj = null;
        int i2 = 2;
        boolean z3 = z2 && StringsKt.startsWith$default((CharSequence) str, '-', false, 2, (Object) null);
        if (length <= i) {
            throw new IllegalArgumentException("No components");
        }
        char c = '0';
        if (str.charAt(i) == 'P') {
            int i3 = i + 1;
            if (i3 == length) {
                throw new IllegalArgumentException();
            }
            DurationUnit durationUnit = null;
            boolean z4 = false;
            while (i3 < length) {
                if (str.charAt(i3) != 'T') {
                    int i4 = i3;
                    while (i4 < str.length()) {
                        char charAt2 = str.charAt(i4);
                        if (!((c <= charAt2 && charAt2 < ':') || StringsKt.contains$default((CharSequence) "+-.", charAt2, false, i2, obj))) {
                            break;
                        }
                        i4++;
                        c = '0';
                    }
                    String substring = str.substring(i3, i4);
                    Intrinsics.checkNotNullExpressionValue(substring, "");
                    String str2 = substring;
                    if (str2.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length2 = i3 + substring.length();
                    String str3 = str;
                    if (length2 < 0 || length2 > StringsKt.getLastIndex(str3)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Missing unit for value ");
                        sb.append(substring);
                        throw new IllegalArgumentException(sb.toString());
                    }
                    char charAt3 = str3.charAt(length2);
                    i3 = length2 + 1;
                    DurationUnit durationUnitByIsoChar = DurationUnitKt.durationUnitByIsoChar(charAt3, z4);
                    if (durationUnit != null && durationUnit.compareTo(durationUnitByIsoChar) <= 0) {
                        throw new IllegalArgumentException("Unexpected order of duration components");
                    }
                    int indexOf$default = StringsKt.indexOf$default((CharSequence) str2, '.', 0, false, 6, (Object) null);
                    if (durationUnitByIsoChar == DurationUnit.SECONDS && indexOf$default > 0) {
                        String substring2 = substring.substring(0, indexOf$default);
                        Intrinsics.checkNotNullExpressionValue(substring2, "");
                        long m4526plusLRDsOJo = Duration.m4526plusLRDsOJo(m4592getZEROUwyO8pc, toDuration(parseOverLongIsoComponent(substring2), durationUnitByIsoChar));
                        String substring3 = substring.substring(indexOf$default);
                        Intrinsics.checkNotNullExpressionValue(substring3, "");
                        m4592getZEROUwyO8pc = Duration.m4526plusLRDsOJo(m4526plusLRDsOJo, toDuration(Double.parseDouble(substring3), durationUnitByIsoChar));
                    } else {
                        m4592getZEROUwyO8pc = Duration.m4526plusLRDsOJo(m4592getZEROUwyO8pc, toDuration(parseOverLongIsoComponent(substring), durationUnitByIsoChar));
                    }
                    durationUnit = durationUnitByIsoChar;
                    c = '0';
                    obj = null;
                    i2 = 2;
                } else if (z4 || (i3 = i3 + 1) == length) {
                    throw new IllegalArgumentException();
                } else {
                    z4 = true;
                }
            }
        } else if (z) {
            throw new IllegalArgumentException();
        } else {
            String str4 = "";
            if (StringsKt.regionMatches(str, i, "Infinity", 0, Math.max(length - i, 8), true)) {
                m4592getZEROUwyO8pc = Duration.INSTANCE.m4590getINFINITEUwyO8pc();
            } else {
                boolean z5 = !z2;
                if (z2) {
                    if (str.charAt(1) == '(' && StringsKt.last(str) == ')') {
                        length--;
                        if (2 == length) {
                            throw new IllegalArgumentException("No components");
                        }
                        z5 = true;
                        i = 2;
                    } else {
                        z5 = false;
                        i = 1;
                    }
                }
                boolean z6 = false;
                DurationUnit durationUnit2 = null;
                while (i < length) {
                    if (z6 && z5) {
                        while (i < str.length()) {
                            if (!(str.charAt(i) == ' ')) {
                                break;
                            }
                            i++;
                        }
                    }
                    int i5 = i;
                    while (i5 < str.length()) {
                        char charAt4 = str.charAt(i5);
                        if (!(('0' <= charAt4 && charAt4 < ':') || charAt4 == '.')) {
                            break;
                        }
                        i5++;
                    }
                    String substring4 = str.substring(i, i5);
                    String str5 = str4;
                    Intrinsics.checkNotNullExpressionValue(substring4, str5);
                    String str6 = substring4;
                    if (str6.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length3 = i + substring4.length();
                    int i6 = length3;
                    while (i6 < str.length()) {
                        char charAt5 = str.charAt(i6);
                        if (!('a' <= charAt5 && charAt5 < '{')) {
                            break;
                        }
                        i6++;
                    }
                    String substring5 = str.substring(length3, i6);
                    Intrinsics.checkNotNullExpressionValue(substring5, str5);
                    i = length3 + substring5.length();
                    DurationUnit durationUnitByShortName = DurationUnitKt.durationUnitByShortName(substring5);
                    if (durationUnit2 != null && durationUnit2.compareTo(durationUnitByShortName) <= 0) {
                        throw new IllegalArgumentException("Unexpected order of duration components");
                    }
                    int indexOf$default2 = StringsKt.indexOf$default((CharSequence) str6, '.', 0, false, 6, (Object) null);
                    if (indexOf$default2 > 0) {
                        String substring6 = substring4.substring(0, indexOf$default2);
                        Intrinsics.checkNotNullExpressionValue(substring6, str5);
                        long m4526plusLRDsOJo2 = Duration.m4526plusLRDsOJo(m4592getZEROUwyO8pc, toDuration(Long.parseLong(substring6), durationUnitByShortName));
                        String substring7 = substring4.substring(indexOf$default2);
                        Intrinsics.checkNotNullExpressionValue(substring7, str5);
                        m4592getZEROUwyO8pc = Duration.m4526plusLRDsOJo(m4526plusLRDsOJo2, toDuration(Double.parseDouble(substring7), durationUnitByShortName));
                        if (i < length) {
                            throw new IllegalArgumentException("Fractional component must be last");
                        }
                    } else {
                        m4592getZEROUwyO8pc = Duration.m4526plusLRDsOJo(m4592getZEROUwyO8pc, toDuration(Long.parseLong(substring4), durationUnitByShortName));
                    }
                    str4 = str5;
                    durationUnit2 = durationUnitByShortName;
                    z6 = true;
                }
            }
        }
        return z3 ? Duration.m4542unaryMinusUwyO8pc(m4592getZEROUwyO8pc) : m4592getZEROUwyO8pc;
    }

    private static final long parseOverLongIsoComponent(String str) {
        boolean z;
        int length = str.length();
        int i = (length <= 0 || !StringsKt.contains$default((CharSequence) "+-", str.charAt(0), false, 2, (Object) null)) ? 0 : 1;
        if (length - i > 16) {
            Iterator<Integer> it = new IntRange(i, StringsKt.getLastIndex(str)).iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                char charAt = str.charAt(((IntIterator) it).nextInt());
                if (!('0' <= charAt && charAt < ':')) {
                    z = false;
                    break;
                }
            }
            if (z) {
                if (str.charAt(0) == '-') {
                    return Long.MIN_VALUE;
                }
                return LongCompanionObject.MAX_VALUE;
            }
        }
        if (StringsKt.startsWith$default(str, "+", false, 2, (Object) null)) {
            str = StringsKt.drop(str, 1);
        }
        return Long.parseLong(str);
    }

    private static final int skipWhile(String str, int i, Function1<? super Character, Boolean> function1) {
        while (i < str.length() && function1.invoke(Character.valueOf(str.charAt(i))).booleanValue()) {
            i++;
        }
        return i;
    }

    public static final long nanosToMillis(long j) {
        return j / 1000000;
    }

    public static final long durationOfNanos(long j) {
        return Duration.m4490constructorimpl(j << 1);
    }

    public static final long durationOfMillis(long j) {
        return Duration.m4490constructorimpl((j << 1) + 1);
    }

    public static final long durationOf(long j, int i) {
        return Duration.m4490constructorimpl((j << 1) + i);
    }

    public static final long durationOfNanosNormalized(long j) {
        boolean z = false;
        if (-4611686018426999999L <= j && j < 4611686018427000000L) {
            z = true;
        }
        if (z) {
            return durationOfNanos(j);
        }
        return durationOfMillis(nanosToMillis(j));
    }

    public static final long durationOfMillisNormalized(long j) {
        boolean z = false;
        if (-4611686018426L <= j && j < 4611686018427L) {
            z = true;
        }
        if (z) {
            return durationOfNanos(millisToNanos(j));
        }
        return durationOfMillis(RangesKt.coerceIn(j, -4611686018427387903L, (long) MAX_MILLIS));
    }

    private static final String substringWhile(String str, int i, Function1<? super Character, Boolean> function1) {
        int i2 = i;
        while (i2 < str.length() && function1.invoke(Character.valueOf(str.charAt(i2))).booleanValue()) {
            i2++;
        }
        String substring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "");
        return substring;
    }
}

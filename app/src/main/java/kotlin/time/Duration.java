package kotlin.time;

import com.alipay.mobile.embedview.mapbiz.core.H5MapRenderOptimizer;
import com.google.common.primitives.Longs;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.config.source.amcs.result.OTCAcceptExpiryTimeConfigResult;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.math.MathKt;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\bA\b\u0087@\u0018\u0000 ¥\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002¥\u0001B\u0016\b\u0000\u0012\u0007\u0010\u0098\u0001\u001a\u00020\u0002ø\u0001\u0001¢\u0006\u0005\b¤\u0001\u0010TJ\"\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\tH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0012J\u001b\u0010\u0011\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0019\u001a\u00020\u00162\b\u0010\b\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001c\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001f\u001a\u00020\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010!\u001a\u00020\u0016H\u0002¢\u0006\u0004\b \u0010\u001eJ\u000f\u0010#\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\"\u0010\u001eJ\r\u0010%\u001a\u00020\u0016¢\u0006\u0004\b$\u0010\u001eJ\r\u0010'\u001a\u00020\u0016¢\u0006\u0004\b&\u0010\u001eJ\r\u0010)\u001a\u00020\u0016¢\u0006\u0004\b(\u0010\u001eJ\u001b\u0010,\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0001¢\u0006\u0004\b*\u0010+J\u001b\u0010.\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0001¢\u0006\u0004\b-\u0010+J\u001b\u00100\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0010J\u001b\u00100\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\tH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0012J§\u0001\u0010=\u001a\u00028\u0000\"\u0004\b\u0000\u001012\u007f\u0010:\u001a{\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(6\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(7\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(8\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(9\u0012\u0004\u0012\u00028\u000002H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b;\u0010<J\u0090\u0001\u0010=\u001a\u00028\u0000\"\u0004\b\u0000\u001012h\u0010:\u001ad\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(6\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(7\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(8\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(9\u0012\u0004\u0012\u00028\u00000>H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b;\u0010?Jy\u0010=\u001a\u00028\u0000\"\u0004\b\u0000\u001012Q\u0010:\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(7\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(8\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(9\u0012\u0004\u0012\u00028\u00000@H\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b;\u0010AJb\u0010=\u001a\u00028\u0000\"\u0004\b\u0000\u001012:\u0010:\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(8\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(9\u0012\u0004\u0012\u00028\u00000BH\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b;\u0010CJ\u0015\u0010H\u001a\u00020\r2\u0006\u0010E\u001a\u00020D¢\u0006\u0004\bF\u0010GJ\u0015\u0010K\u001a\u00020\t2\u0006\u0010E\u001a\u00020D¢\u0006\u0004\bI\u0010JJ\r\u0010O\u001a\u00020L¢\u0006\u0004\bM\u0010NJ\u0015\u0010R\u001a\u00020\u00022\u0006\u0010E\u001a\u00020D¢\u0006\u0004\bP\u0010QJ\u000f\u0010U\u001a\u00020\u0002H\u0007¢\u0006\u0004\bS\u0010TJ\u000f\u0010W\u001a\u00020\u0002H\u0007¢\u0006\u0004\bV\u0010TJ\u000f\u0010Y\u001a\u00020LH\u0016¢\u0006\u0004\bX\u0010NJ\u001f\u0010Y\u001a\u00020L2\u0006\u0010E\u001a\u00020D2\b\b\u0002\u0010Z\u001a\u00020\t¢\u0006\u0004\bX\u0010[J\u0013\u0010]\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\\\u0010TJ?\u0010g\u001a\u00020d*\u00060^j\u0002`_2\u0006\u0010`\u001a\u00020\t2\u0006\u0010a\u001a\u00020\t2\u0006\u0010b\u001a\u00020\t2\u0006\u0010E\u001a\u00020L2\u0006\u0010c\u001a\u00020\u0016H\u0002¢\u0006\u0004\be\u0010fR\u0014\u0010i\u001a\u00020\u00008Gø\u0001\u0000¢\u0006\u0006\u001a\u0004\bh\u0010TR\u001a\u0010m\u001a\u00020\t8AX\u0080\u0004¢\u0006\f\u0012\u0004\bk\u0010l\u001a\u0004\bj\u0010\u001bR\u001a\u0010q\u001a\u00020\r8GX\u0087\u0004¢\u0006\f\u0012\u0004\bp\u0010l\u001a\u0004\bn\u0010oR\u001a\u0010t\u001a\u00020\r8GX\u0087\u0004¢\u0006\f\u0012\u0004\bs\u0010l\u001a\u0004\br\u0010oR\u001a\u0010w\u001a\u00020\r8GX\u0087\u0004¢\u0006\f\u0012\u0004\bv\u0010l\u001a\u0004\bu\u0010oR\u001a\u0010z\u001a\u00020\r8GX\u0087\u0004¢\u0006\f\u0012\u0004\by\u0010l\u001a\u0004\bx\u0010oR\u001a\u0010}\u001a\u00020\r8GX\u0087\u0004¢\u0006\f\u0012\u0004\b|\u0010l\u001a\u0004\b{\u0010oR\u001b\u0010\u0080\u0001\u001a\u00020\r8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u007f\u0010l\u001a\u0004\b~\u0010oR\u001d\u0010\u0083\u0001\u001a\u00020\r8GX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u0082\u0001\u0010l\u001a\u0005\b\u0081\u0001\u0010oR\u0013\u0010\u0085\u0001\u001a\u00020\u00028G¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010TR\u0013\u0010\u0087\u0001\u001a\u00020\u00028G¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010TR\u0013\u0010\u0089\u0001\u001a\u00020\u00028G¢\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010TR\u0013\u0010\u008b\u0001\u001a\u00020\u00028G¢\u0006\u0007\u001a\u0005\b\u008a\u0001\u0010TR\u0013\u0010\u008d\u0001\u001a\u00020\u00028G¢\u0006\u0007\u001a\u0005\b\u008c\u0001\u0010TR\u0013\u0010\u008f\u0001\u001a\u00020\u00028G¢\u0006\u0007\u001a\u0005\b\u008e\u0001\u0010TR\u0013\u0010\u0091\u0001\u001a\u00020\u00028G¢\u0006\u0007\u001a\u0005\b\u0090\u0001\u0010TR\u001d\u0010\u0094\u0001\u001a\u00020\t8AX\u0080\u0004¢\u0006\u000e\u0012\u0005\b\u0093\u0001\u0010l\u001a\u0005\b\u0092\u0001\u0010\u001bR\u001d\u0010\u0097\u0001\u001a\u00020\t8AX\u0080\u0004¢\u0006\u000e\u0012\u0005\b\u0096\u0001\u0010l\u001a\u0005\b\u0095\u0001\u0010\u001bR\u0017\u0010\u0098\u0001\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001d\u0010\u009c\u0001\u001a\u00020\t8AX\u0080\u0004¢\u0006\u000e\u0012\u0005\b\u009b\u0001\u0010l\u001a\u0005\b\u009a\u0001\u0010\u001bR\u0017\u0010\u009f\u0001\u001a\u00020D8CX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0017\u0010¡\u0001\u001a\u00020\t8Ã\u0002X\u0082\u0004¢\u0006\u0007\u001a\u0005\b \u0001\u0010\u001bR\u0016\u0010£\u0001\u001a\u00020\u00028CX\u0082\u0004¢\u0006\u0007\u001a\u0005\b¢\u0001\u0010T\u0088\u0001\u0098\u0001\u0092\u0001\u00020\u0002ø\u0001\u0001\u0082\u0002\u000f\n\u0002\b!\n\u0002\b\u0019\n\u0005\b\u009920\u0001"}, d2 = {"Lkotlin/time/Duration;", "", "", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "addValuesMixedRanges", "other", "", "compareTo-LRDsOJo", "(JJ)I", "compareTo", "", H5MapRenderOptimizer.KEY_SCALE, "div-UwyO8pc", "(JD)J", "div", "(JI)J", "div-LRDsOJo", "(JJ)D", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "equals", "hashCode-impl", "(J)I", "hashCode", "isFinite-impl", "(J)Z", "isFinite", "isInMillis-impl", "isInMillis", "isInNanos-impl", "isInNanos", "isInfinite-impl", "isInfinite", "isNegative-impl", "isNegative", "isPositive-impl", "isPositive", "minus-LRDsOJo", "(JJ)J", "minus", "plus-LRDsOJo", "plus", "times-UwyO8pc", "times", "T", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "action", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "toComponents", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Lkotlin/time/DurationUnit;", OTCAcceptExpiryTimeConfigResult.JsonKey.UNIT, "toDouble-impl", "(JLkotlin/time/DurationUnit;)D", "toDouble", "toInt-impl", "(JLkotlin/time/DurationUnit;)I", "toInt", "", "toIsoString-impl", "(J)Ljava/lang/String;", "toIsoString", "toLong-impl", "(JLkotlin/time/DurationUnit;)J", "toLong", "toLongMilliseconds-impl", "(J)J", "toLongMilliseconds", "toLongNanoseconds-impl", "toLongNanoseconds", "toString-impl", "toString", "decimals", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "unaryMinus-UwyO8pc", "unaryMinus", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "appendFractional", "getAbsoluteValue-UwyO8pc", "absoluteValue", "getHoursComponent-impl", "getHoursComponent$annotations", "()V", "hoursComponent", "getInDays-impl", "(J)D", "getInDays$annotations", "inDays", "getInHours-impl", "getInHours$annotations", "inHours", "getInMicroseconds-impl", "getInMicroseconds$annotations", "inMicroseconds", "getInMilliseconds-impl", "getInMilliseconds$annotations", "inMilliseconds", "getInMinutes-impl", "getInMinutes$annotations", "inMinutes", "getInNanoseconds-impl", "getInNanoseconds$annotations", "inNanoseconds", "getInSeconds-impl", "getInSeconds$annotations", "inSeconds", "getInWholeDays-impl", "inWholeDays", "getInWholeHours-impl", "inWholeHours", "getInWholeMicroseconds-impl", "inWholeMicroseconds", "getInWholeMilliseconds-impl", "inWholeMilliseconds", "getInWholeMinutes-impl", "inWholeMinutes", "getInWholeNanoseconds-impl", "inWholeNanoseconds", "getInWholeSeconds-impl", "inWholeSeconds", "getMinutesComponent-impl", "getMinutesComponent$annotations", "minutesComponent", "getNanosecondsComponent-impl", "getNanosecondsComponent$annotations", "nanosecondsComponent", "rawValue", "J", "getSecondsComponent-impl", "getSecondsComponent$annotations", "secondsComponent", "getStorageUnit-impl", "(J)Lkotlin/time/DurationUnit;", "storageUnit", "getUnitDiscriminator-impl", "unitDiscriminator", "getValue-impl", "value", "constructor-impl", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* loaded from: classes3.dex */
public final class Duration implements Comparable<Duration> {
    private final long rawValue;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long ZERO = m4490constructorimpl(0);
    private static final long INFINITE = DurationKt.access$durationOfMillis(DurationKt.MAX_MILLIS);
    private static final long NEG_INFINITE = DurationKt.access$durationOfMillis(-4611686018427387903L);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Duration m4488boximpl(long j) {
        return new Duration(j);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4494equalsimpl(long j, Object obj) {
        return (obj instanceof Duration) && j == ((Duration) obj).getRawValue();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4495equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    @Deprecated(message = "Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.DAYS)", imports = {}))
    public static /* synthetic */ void getInDays$annotations() {
    }

    @Deprecated(message = "Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.HOURS)", imports = {}))
    public static /* synthetic */ void getInHours$annotations() {
    }

    @Deprecated(message = "Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MICROSECONDS)", imports = {}))
    public static /* synthetic */ void getInMicroseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MILLISECONDS)", imports = {}))
    public static /* synthetic */ void getInMilliseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MINUTES)", imports = {}))
    public static /* synthetic */ void getInMinutes$annotations() {
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.NANOSECONDS)", imports = {}))
    public static /* synthetic */ void getInNanoseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.SECONDS)", imports = {}))
    public static /* synthetic */ void getInSeconds$annotations() {
    }

    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    @JvmName(name = "getUnitDiscriminator-impl")
    /* renamed from: getUnitDiscriminator-impl  reason: not valid java name */
    private static final int m4516getUnitDiscriminatorimpl(long j) {
        return ((int) j) & 1;
    }

    @JvmName(name = "getValue-impl")
    /* renamed from: getValue-impl  reason: not valid java name */
    private static final long m4517getValueimpl(long j) {
        return j >> 1;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4518hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: isInMillis-impl  reason: not valid java name */
    private static final boolean m4520isInMillisimpl(long j) {
        return (((int) j) & 1) == 1;
    }

    /* renamed from: isInNanos-impl  reason: not valid java name */
    private static final boolean m4521isInNanosimpl(long j) {
        return (((int) j) & 1) == 0;
    }

    /* renamed from: isNegative-impl  reason: not valid java name */
    public static final boolean m4523isNegativeimpl(long j) {
        return j < 0;
    }

    /* renamed from: isPositive-impl  reason: not valid java name */
    public static final boolean m4524isPositiveimpl(long j) {
        return j > 0;
    }

    public final boolean equals(Object obj) {
        return m4494equalsimpl(this.rawValue, obj);
    }

    public final int hashCode() {
        return m4518hashCodeimpl(this.rawValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name and from getter */
    public final /* synthetic */ long getRawValue() {
        return this.rawValue;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Duration duration) {
        return m4543compareToLRDsOJo(duration.getRawValue());
    }

    private /* synthetic */ Duration(long j) {
        this.rawValue = j;
    }

    @JvmName(name = "getStorageUnit-impl")
    /* renamed from: getStorageUnit-impl  reason: not valid java name */
    private static final DurationUnit m4515getStorageUnitimpl(long j) {
        return m4521isInNanosimpl(j) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m4490constructorimpl(long j) {
        if (DurationJvmKt.getDurationAssertionsEnabled()) {
            boolean z = false;
            if (m4521isInNanosimpl(j)) {
                long m4517getValueimpl = m4517getValueimpl(j);
                if (-4611686018426999999L <= m4517getValueimpl && m4517getValueimpl < 4611686018427000000L) {
                    z = true;
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(m4517getValueimpl(j));
                    sb.append(" ns is out of nanoseconds range");
                    throw new AssertionError(sb.toString());
                }
            } else {
                long m4517getValueimpl2 = m4517getValueimpl(j);
                if (!(-4611686018427387903L <= m4517getValueimpl2 && m4517getValueimpl2 < Longs.MAX_POWER_OF_TWO)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(m4517getValueimpl(j));
                    sb2.append(" ms is out of milliseconds range");
                    throw new AssertionError(sb2.toString());
                }
                long m4517getValueimpl3 = m4517getValueimpl(j);
                if (-4611686018426L <= m4517getValueimpl3 && m4517getValueimpl3 < 4611686018427L) {
                    z = true;
                }
                if (z) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(m4517getValueimpl(j));
                    sb3.append(" ms is denormalized");
                    throw new AssertionError(sb3.toString());
                }
            }
        }
        return j;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b'\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bA\u0010BJ%\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000eJ\u001a\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000bJ\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u000bJ\u001a\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u000eJ\u001a\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0010J\u001a\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u000bJ\u001a\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u000eJ\u001a\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0010J\u001a\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u000bJ\u001a\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u000eJ\u001a\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0010J\u001a\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u000bJ\u001a\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u000eJ\u001a\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0010J\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u001bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010 \u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u001bø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u001dJ\u001a\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u001bø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u001bø\u0001\u0000¢\u0006\u0004\b$\u0010\"J\u001a\u0010'\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010\u000bJ\u001a\u0010'\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010\u000eJ\u001a\u0010'\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0010R\u001d\u0010(\u001a\u00020\t8\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001d\u0010,\u001a\u00020\t8\u0001X\u0081\u0004ø\u0001\u0000¢\u0006\f\n\u0004\b,\u0010)\u001a\u0004\b-\u0010+R\u001d\u0010.\u001a\u00020\t8\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\f\n\u0004\b.\u0010)\u001a\u0004\b/\u0010+R\u001f\u0010\f\u001a\u00020\t*\u00020\u00028Ç\u0002ø\u0001\u0000¢\u0006\f\u0012\u0004\b1\u00102\u001a\u0004\b0\u0010\u000bR\u001f\u0010\f\u001a\u00020\t*\u00020\r8Ç\u0002ø\u0001\u0000¢\u0006\f\u0012\u0004\b1\u00103\u001a\u0004\b0\u0010\u000eR\u001f\u0010\f\u001a\u00020\t*\u00020\u000f8Ç\u0002ø\u0001\u0000¢\u0006\f\u0012\u0004\b1\u00104\u001a\u0004\b0\u0010\u0010R\u001f\u0010\u0012\u001a\u00020\t*\u00020\u00028Ç\u0002ø\u0001\u0000¢\u0006\f\u0012\u0004\b6\u00102\u001a\u0004\b5\u0010\u000bR\u001f\u0010\u0012\u001a\u00020\t*\u00020\r8Ç\u0002ø\u0001\u0000¢\u0006\f\u0012\u0004\b6\u00103\u001a\u0004\b5\u0010\u000eR\u001f\u0010\u0012\u001a\u00020\t*\u00020\u000f8Ç\u0002ø\u0001\u0000¢\u0006\f\u0012\u0004\b6\u00104\u001a\u0004\b5\u0010\u0010R\u001f\u0010\u0014\u001a\u00020\t*\u00020\u00028Ç\u0002ø\u0001\u0000¢\u0006\f\u0012\u0004\b8\u00102\u001a\u0004\b7\u0010\u000bR\u001f\u0010\u0014\u001a\u00020\t*\u00020\r8Ç\u0002ø\u0001\u0000¢\u0006\f\u0012\u0004\b8\u00103\u001a\u0004\b7\u0010\u000eR\u001f\u0010\u0014\u001a\u00020\t*\u00020\u000f8Ç\u0002ø\u0001\u0000¢\u0006\f\u0012\u0004\b8\u00104\u001a\u0004\b7\u0010\u0010R\u001f\u0010\u0016\u001a\u00020\t*\u00020\u00028Ç\u0002ø\u0001\u0000¢\u0006\f\u0012\u0004\b:\u00102\u001a\u0004\b9\u0010\u000bR\u001f\u0010\u0016\u001a\u00020\t*\u00020\r8Ç\u0002ø\u0001\u0000¢\u0006\f\u0012\u0004\b:\u00103\u001a\u0004\b9\u0010\u000eR\u001f\u0010\u0016\u001a\u00020\t*\u00020\u000f8Ç\u0002ø\u0001\u0000¢\u0006\f\u0012\u0004\b:\u00104\u001a\u0004\b9\u0010\u0010R\u001f\u0010\u0018\u001a\u00020\t*\u00020\u00028Ç\u0002ø\u0001\u0000¢\u0006\f\u0012\u0004\b<\u00102\u001a\u0004\b;\u0010\u000bR\u001f\u0010\u0018\u001a\u00020\t*\u00020\r8Ç\u0002ø\u0001\u0000¢\u0006\f\u0012\u0004\b<\u00103\u001a\u0004\b;\u0010\u000eR\u001f\u0010\u0018\u001a\u00020\t*\u00020\u000f8Ç\u0002ø\u0001\u0000¢\u0006\f\u0012\u0004\b<\u00104\u001a\u0004\b;\u0010\u0010R\u001f\u0010\u001a\u001a\u00020\t*\u00020\u00028Ç\u0002ø\u0001\u0000¢\u0006\f\u0012\u0004\b>\u00102\u001a\u0004\b=\u0010\u000bR\u001f\u0010\u001a\u001a\u00020\t*\u00020\r8Ç\u0002ø\u0001\u0000¢\u0006\f\u0012\u0004\b>\u00103\u001a\u0004\b=\u0010\u000eR\u001f\u0010\u001a\u001a\u00020\t*\u00020\u000f8Ç\u0002ø\u0001\u0000¢\u0006\f\u0012\u0004\b>\u00104\u001a\u0004\b=\u0010\u0010R\u001f\u0010'\u001a\u00020\t*\u00020\u00028Ç\u0002ø\u0001\u0000¢\u0006\f\u0012\u0004\b@\u00102\u001a\u0004\b?\u0010\u000bR\u001f\u0010'\u001a\u00020\t*\u00020\r8Ç\u0002ø\u0001\u0000¢\u0006\f\u0012\u0004\b@\u00103\u001a\u0004\b?\u0010\u000eR\u001f\u0010'\u001a\u00020\t*\u00020\u000f8Ç\u0002ø\u0001\u0000¢\u0006\f\u0012\u0004\b@\u00104\u001a\u0004\b?\u0010\u0010\u0082\u0002\u0004\n\u0002\b!"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "", "value", "Lkotlin/time/DurationUnit;", "sourceUnit", "targetUnit", "convert", "(DLkotlin/time/DurationUnit;Lkotlin/time/DurationUnit;)D", "Lkotlin/time/Duration;", "days-UwyO8pc", "(D)J", "days", "", "(I)J", "", "(J)J", "hours-UwyO8pc", "hours", "microseconds-UwyO8pc", "microseconds", "milliseconds-UwyO8pc", "milliseconds", "minutes-UwyO8pc", "minutes", "nanoseconds-UwyO8pc", "nanoseconds", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parse", "parseIsoString-UwyO8pc", "parseIsoString", "parseIsoStringOrNull-FghU774", "(Ljava/lang/String;)Lkotlin/time/Duration;", "parseIsoStringOrNull", "parseOrNull-FghU774", "parseOrNull", "seconds-UwyO8pc", "seconds", "INFINITE", "J", "getINFINITE-UwyO8pc", "()J", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "ZERO", "getZERO-UwyO8pc", "getDays-UwyO8pc", "getDays-UwyO8pc$annotations", "(D)V", "(I)V", "(J)V", "getHours-UwyO8pc", "getHours-UwyO8pc$annotations", "getMicroseconds-UwyO8pc", "getMicroseconds-UwyO8pc$annotations", "getMilliseconds-UwyO8pc", "getMilliseconds-UwyO8pc$annotations", "getMinutes-UwyO8pc", "getMinutes-UwyO8pc$annotations", "getNanoseconds-UwyO8pc", "getNanoseconds-UwyO8pc$annotations", "getSeconds-UwyO8pc", "getSeconds-UwyO8pc$annotations", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getDays-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m4548getDaysUwyO8pc$annotations(double d) {
        }

        /* renamed from: getDays-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m4549getDaysUwyO8pc$annotations(int i) {
        }

        /* renamed from: getDays-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m4550getDaysUwyO8pc$annotations(long j) {
        }

        /* renamed from: getHours-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m4554getHoursUwyO8pc$annotations(double d) {
        }

        /* renamed from: getHours-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m4555getHoursUwyO8pc$annotations(int i) {
        }

        /* renamed from: getHours-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m4556getHoursUwyO8pc$annotations(long j) {
        }

        /* renamed from: getMicroseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m4560getMicrosecondsUwyO8pc$annotations(double d) {
        }

        /* renamed from: getMicroseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m4561getMicrosecondsUwyO8pc$annotations(int i) {
        }

        /* renamed from: getMicroseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m4562getMicrosecondsUwyO8pc$annotations(long j) {
        }

        /* renamed from: getMilliseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m4566getMillisecondsUwyO8pc$annotations(double d) {
        }

        /* renamed from: getMilliseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m4567getMillisecondsUwyO8pc$annotations(int i) {
        }

        /* renamed from: getMilliseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m4568getMillisecondsUwyO8pc$annotations(long j) {
        }

        /* renamed from: getMinutes-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m4572getMinutesUwyO8pc$annotations(double d) {
        }

        /* renamed from: getMinutes-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m4573getMinutesUwyO8pc$annotations(int i) {
        }

        /* renamed from: getMinutes-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m4574getMinutesUwyO8pc$annotations(long j) {
        }

        /* renamed from: getNanoseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m4578getNanosecondsUwyO8pc$annotations(double d) {
        }

        /* renamed from: getNanoseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m4579getNanosecondsUwyO8pc$annotations(int i) {
        }

        /* renamed from: getNanoseconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m4580getNanosecondsUwyO8pc$annotations(long j) {
        }

        /* renamed from: getSeconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m4584getSecondsUwyO8pc$annotations(double d) {
        }

        /* renamed from: getSeconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m4585getSecondsUwyO8pc$annotations(int i) {
        }

        /* renamed from: getSeconds-UwyO8pc$annotations  reason: not valid java name */
        public static /* synthetic */ void m4586getSecondsUwyO8pc$annotations(long j) {
        }

        private Companion() {
        }

        @JvmName(name = "getZERO-UwyO8pc")
        /* renamed from: getZERO-UwyO8pc  reason: not valid java name */
        public final long m4592getZEROUwyO8pc() {
            return Duration.ZERO;
        }

        @JvmName(name = "getINFINITE-UwyO8pc")
        /* renamed from: getINFINITE-UwyO8pc  reason: not valid java name */
        public final long m4590getINFINITEUwyO8pc() {
            return Duration.INFINITE;
        }

        @JvmName(name = "getNEG_INFINITE-UwyO8pc$kotlin_stdlib")
        /* renamed from: getNEG_INFINITE-UwyO8pc$kotlin_stdlib  reason: not valid java name */
        public final long m4591getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return Duration.NEG_INFINITE;
        }

        public final double convert(double value, DurationUnit sourceUnit, DurationUnit targetUnit) {
            Intrinsics.checkNotNullParameter(sourceUnit, "");
            Intrinsics.checkNotNullParameter(targetUnit, "");
            return DurationUnitKt.convertDurationUnit(value, sourceUnit, targetUnit);
        }

        @JvmName(name = "getNanoseconds-UwyO8pc")
        /* renamed from: getNanoseconds-UwyO8pc  reason: not valid java name */
        private final long m4576getNanosecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.NANOSECONDS);
        }

        @JvmName(name = "getNanoseconds-UwyO8pc")
        /* renamed from: getNanoseconds-UwyO8pc  reason: not valid java name */
        private final long m4577getNanosecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.NANOSECONDS);
        }

        @JvmName(name = "getNanoseconds-UwyO8pc")
        /* renamed from: getNanoseconds-UwyO8pc  reason: not valid java name */
        private final long m4575getNanosecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.NANOSECONDS);
        }

        @JvmName(name = "getMicroseconds-UwyO8pc")
        /* renamed from: getMicroseconds-UwyO8pc  reason: not valid java name */
        private final long m4558getMicrosecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.MICROSECONDS);
        }

        @JvmName(name = "getMicroseconds-UwyO8pc")
        /* renamed from: getMicroseconds-UwyO8pc  reason: not valid java name */
        private final long m4559getMicrosecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.MICROSECONDS);
        }

        @JvmName(name = "getMicroseconds-UwyO8pc")
        /* renamed from: getMicroseconds-UwyO8pc  reason: not valid java name */
        private final long m4557getMicrosecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.MICROSECONDS);
        }

        @JvmName(name = "getMilliseconds-UwyO8pc")
        /* renamed from: getMilliseconds-UwyO8pc  reason: not valid java name */
        private final long m4564getMillisecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.MILLISECONDS);
        }

        @JvmName(name = "getMilliseconds-UwyO8pc")
        /* renamed from: getMilliseconds-UwyO8pc  reason: not valid java name */
        private final long m4565getMillisecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.MILLISECONDS);
        }

        @JvmName(name = "getMilliseconds-UwyO8pc")
        /* renamed from: getMilliseconds-UwyO8pc  reason: not valid java name */
        private final long m4563getMillisecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.MILLISECONDS);
        }

        @JvmName(name = "getSeconds-UwyO8pc")
        /* renamed from: getSeconds-UwyO8pc  reason: not valid java name */
        private final long m4582getSecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.SECONDS);
        }

        @JvmName(name = "getSeconds-UwyO8pc")
        /* renamed from: getSeconds-UwyO8pc  reason: not valid java name */
        private final long m4583getSecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.SECONDS);
        }

        @JvmName(name = "getSeconds-UwyO8pc")
        /* renamed from: getSeconds-UwyO8pc  reason: not valid java name */
        private final long m4581getSecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.SECONDS);
        }

        @JvmName(name = "getMinutes-UwyO8pc")
        /* renamed from: getMinutes-UwyO8pc  reason: not valid java name */
        private final long m4570getMinutesUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.MINUTES);
        }

        @JvmName(name = "getMinutes-UwyO8pc")
        /* renamed from: getMinutes-UwyO8pc  reason: not valid java name */
        private final long m4571getMinutesUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.MINUTES);
        }

        @JvmName(name = "getMinutes-UwyO8pc")
        /* renamed from: getMinutes-UwyO8pc  reason: not valid java name */
        private final long m4569getMinutesUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.MINUTES);
        }

        @JvmName(name = "getHours-UwyO8pc")
        /* renamed from: getHours-UwyO8pc  reason: not valid java name */
        private final long m4552getHoursUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.HOURS);
        }

        @JvmName(name = "getHours-UwyO8pc")
        /* renamed from: getHours-UwyO8pc  reason: not valid java name */
        private final long m4553getHoursUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.HOURS);
        }

        @JvmName(name = "getHours-UwyO8pc")
        /* renamed from: getHours-UwyO8pc  reason: not valid java name */
        private final long m4551getHoursUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.HOURS);
        }

        @JvmName(name = "getDays-UwyO8pc")
        /* renamed from: getDays-UwyO8pc  reason: not valid java name */
        private final long m4546getDaysUwyO8pc(int i) {
            return DurationKt.toDuration(i, DurationUnit.DAYS);
        }

        @JvmName(name = "getDays-UwyO8pc")
        /* renamed from: getDays-UwyO8pc  reason: not valid java name */
        private final long m4547getDaysUwyO8pc(long j) {
            return DurationKt.toDuration(j, DurationUnit.DAYS);
        }

        @JvmName(name = "getDays-UwyO8pc")
        /* renamed from: getDays-UwyO8pc  reason: not valid java name */
        private final long m4545getDaysUwyO8pc(double d) {
            return DurationKt.toDuration(d, DurationUnit.DAYS);
        }

        @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        /* renamed from: nanoseconds-UwyO8pc  reason: not valid java name */
        public final long m4606nanosecondsUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.NANOSECONDS);
        }

        @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        /* renamed from: nanoseconds-UwyO8pc  reason: not valid java name */
        public final long m4607nanosecondsUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.NANOSECONDS);
        }

        @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        /* renamed from: nanoseconds-UwyO8pc  reason: not valid java name */
        public final long m4605nanosecondsUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.NANOSECONDS);
        }

        @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        /* renamed from: microseconds-UwyO8pc  reason: not valid java name */
        public final long m4597microsecondsUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.MICROSECONDS);
        }

        @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        /* renamed from: microseconds-UwyO8pc  reason: not valid java name */
        public final long m4598microsecondsUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.MICROSECONDS);
        }

        @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        /* renamed from: microseconds-UwyO8pc  reason: not valid java name */
        public final long m4596microsecondsUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.MICROSECONDS);
        }

        @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        /* renamed from: milliseconds-UwyO8pc  reason: not valid java name */
        public final long m4600millisecondsUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.MILLISECONDS);
        }

        @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        /* renamed from: milliseconds-UwyO8pc  reason: not valid java name */
        public final long m4601millisecondsUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.MILLISECONDS);
        }

        @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        /* renamed from: milliseconds-UwyO8pc  reason: not valid java name */
        public final long m4599millisecondsUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.MILLISECONDS);
        }

        @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        /* renamed from: seconds-UwyO8pc  reason: not valid java name */
        public final long m4613secondsUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.SECONDS);
        }

        @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        /* renamed from: seconds-UwyO8pc  reason: not valid java name */
        public final long m4614secondsUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.SECONDS);
        }

        @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        /* renamed from: seconds-UwyO8pc  reason: not valid java name */
        public final long m4612secondsUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.SECONDS);
        }

        @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        /* renamed from: minutes-UwyO8pc  reason: not valid java name */
        public final long m4603minutesUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.MINUTES);
        }

        @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        /* renamed from: minutes-UwyO8pc  reason: not valid java name */
        public final long m4604minutesUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.MINUTES);
        }

        @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        /* renamed from: minutes-UwyO8pc  reason: not valid java name */
        public final long m4602minutesUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.MINUTES);
        }

        @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        /* renamed from: hours-UwyO8pc  reason: not valid java name */
        public final long m4594hoursUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.HOURS);
        }

        @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        /* renamed from: hours-UwyO8pc  reason: not valid java name */
        public final long m4595hoursUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.HOURS);
        }

        @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        /* renamed from: hours-UwyO8pc  reason: not valid java name */
        public final long m4593hoursUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.HOURS);
        }

        @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        /* renamed from: days-UwyO8pc  reason: not valid java name */
        public final long m4588daysUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.DAYS);
        }

        @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        /* renamed from: days-UwyO8pc  reason: not valid java name */
        public final long m4589daysUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.DAYS);
        }

        @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        /* renamed from: days-UwyO8pc  reason: not valid java name */
        public final long m4587daysUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.DAYS);
        }

        /* renamed from: parse-UwyO8pc  reason: not valid java name */
        public final long m4608parseUwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, "");
            try {
                return DurationKt.access$parseDuration(value, false);
            } catch (IllegalArgumentException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid duration string format: '");
                sb.append(value);
                sb.append("'.");
                throw new IllegalArgumentException(sb.toString(), e);
            }
        }

        /* renamed from: parseIsoString-UwyO8pc  reason: not valid java name */
        public final long m4609parseIsoStringUwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, "");
            try {
                return DurationKt.access$parseDuration(value, true);
            } catch (IllegalArgumentException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid ISO duration string format: '");
                sb.append(value);
                sb.append("'.");
                throw new IllegalArgumentException(sb.toString(), e);
            }
        }

        /* renamed from: parseOrNull-FghU774  reason: not valid java name */
        public final Duration m4611parseOrNullFghU774(String value) {
            Intrinsics.checkNotNullParameter(value, "");
            try {
                return Duration.m4488boximpl(DurationKt.access$parseDuration(value, false));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        /* renamed from: parseIsoStringOrNull-FghU774  reason: not valid java name */
        public final Duration m4610parseIsoStringOrNullFghU774(String value) {
            Intrinsics.checkNotNullParameter(value, "");
            try {
                return Duration.m4488boximpl(DurationKt.access$parseDuration(value, true));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    /* renamed from: unaryMinus-UwyO8pc  reason: not valid java name */
    public static final long m4542unaryMinusUwyO8pc(long j) {
        return DurationKt.access$durationOf(-m4517getValueimpl(j), ((int) j) & 1);
    }

    /* renamed from: plus-LRDsOJo  reason: not valid java name */
    public static final long m4526plusLRDsOJo(long j, long j2) {
        if (m4522isInfiniteimpl(j)) {
            if (m4519isFiniteimpl(j2) || (j2 ^ j) >= 0) {
                return j;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        } else if (m4522isInfiniteimpl(j2)) {
            return j2;
        } else {
            if ((((int) j) & 1) == (((int) j2) & 1)) {
                long m4517getValueimpl = m4517getValueimpl(j) + m4517getValueimpl(j2);
                if (m4521isInNanosimpl(j)) {
                    return DurationKt.access$durationOfNanosNormalized(m4517getValueimpl);
                }
                return DurationKt.access$durationOfMillisNormalized(m4517getValueimpl);
            } else if (m4520isInMillisimpl(j)) {
                return m4486addValuesMixedRangesUwyO8pc(j, m4517getValueimpl(j), m4517getValueimpl(j2));
            } else {
                return m4486addValuesMixedRangesUwyO8pc(j, m4517getValueimpl(j2), m4517getValueimpl(j));
            }
        }
    }

    /* renamed from: addValuesMixedRanges-UwyO8pc  reason: not valid java name */
    private static final long m4486addValuesMixedRangesUwyO8pc(long j, long j2, long j3) {
        long access$nanosToMillis = DurationKt.access$nanosToMillis(j3);
        long j4 = j2 + access$nanosToMillis;
        boolean z = false;
        if (-4611686018426L <= j4 && j4 < 4611686018427L) {
            z = true;
        }
        if (z) {
            return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(j4) + (j3 - DurationKt.access$millisToNanos(access$nanosToMillis)));
        }
        return DurationKt.access$durationOfMillis(RangesKt.coerceIn(j4, -4611686018427387903L, (long) DurationKt.MAX_MILLIS));
    }

    /* renamed from: minus-LRDsOJo  reason: not valid java name */
    public static final long m4525minusLRDsOJo(long j, long j2) {
        return m4526plusLRDsOJo(j, m4542unaryMinusUwyO8pc(j2));
    }

    /* renamed from: times-UwyO8pc  reason: not valid java name */
    public static final long m4528timesUwyO8pc(long j, int i) {
        if (m4522isInfiniteimpl(j)) {
            if (i != 0) {
                return i <= 0 ? m4542unaryMinusUwyO8pc(j) : j;
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        } else if (i == 0) {
            return ZERO;
        } else {
            long m4517getValueimpl = m4517getValueimpl(j);
            long j2 = i;
            long j3 = m4517getValueimpl * j2;
            if (!m4521isInNanosimpl(j)) {
                if (j3 / j2 == m4517getValueimpl) {
                    return DurationKt.access$durationOfMillis(RangesKt.coerceIn(j3, new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS)));
                }
                return MathKt.getSign(m4517getValueimpl) * MathKt.getSign(i) > 0 ? INFINITE : NEG_INFINITE;
            }
            boolean z = false;
            if (m4517getValueimpl <= 2147483647L && -2147483647L <= m4517getValueimpl) {
                z = true;
            }
            if (z) {
                return DurationKt.access$durationOfNanos(j3);
            }
            if (j3 / j2 == m4517getValueimpl) {
                return DurationKt.access$durationOfNanosNormalized(j3);
            }
            long access$nanosToMillis = DurationKt.access$nanosToMillis(m4517getValueimpl);
            long j4 = access$nanosToMillis * j2;
            long access$nanosToMillis2 = DurationKt.access$nanosToMillis((m4517getValueimpl - DurationKt.access$millisToNanos(access$nanosToMillis)) * j2) + j4;
            if (j4 / j2 != access$nanosToMillis || (access$nanosToMillis2 ^ j4) < 0) {
                return MathKt.getSign(m4517getValueimpl) * MathKt.getSign(i) > 0 ? INFINITE : NEG_INFINITE;
            }
            return DurationKt.access$durationOfMillis(RangesKt.coerceIn(access$nanosToMillis2, new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS)));
        }
    }

    /* renamed from: times-UwyO8pc  reason: not valid java name */
    public static final long m4527timesUwyO8pc(long j, double d) {
        int roundToInt = MathKt.roundToInt(d);
        if (((double) roundToInt) == d) {
            return m4528timesUwyO8pc(j, roundToInt);
        }
        DurationUnit m4515getStorageUnitimpl = m4515getStorageUnitimpl(j);
        return DurationKt.toDuration(m4533toDoubleimpl(j, m4515getStorageUnitimpl) * d, m4515getStorageUnitimpl);
    }

    /* renamed from: div-UwyO8pc  reason: not valid java name */
    public static final long m4493divUwyO8pc(long j, int i) {
        if (i == 0) {
            if (m4524isPositiveimpl(j)) {
                return INFINITE;
            }
            if (m4523isNegativeimpl(j)) {
                return NEG_INFINITE;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        } else if (m4521isInNanosimpl(j)) {
            return DurationKt.access$durationOfNanos(m4517getValueimpl(j) / i);
        } else {
            if (m4522isInfiniteimpl(j)) {
                return m4528timesUwyO8pc(j, MathKt.getSign(i));
            }
            long j2 = i;
            long m4517getValueimpl = m4517getValueimpl(j) / j2;
            boolean z = false;
            if (-4611686018426L <= m4517getValueimpl && m4517getValueimpl < 4611686018427L) {
                z = true;
            }
            if (z) {
                return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(m4517getValueimpl) + (DurationKt.access$millisToNanos(m4517getValueimpl(j) - (m4517getValueimpl * j2)) / j2));
            }
            return DurationKt.access$durationOfMillis(m4517getValueimpl);
        }
    }

    /* renamed from: div-UwyO8pc  reason: not valid java name */
    public static final long m4492divUwyO8pc(long j, double d) {
        int roundToInt = MathKt.roundToInt(d);
        if ((((double) roundToInt) == d) && roundToInt != 0) {
            return m4493divUwyO8pc(j, roundToInt);
        }
        DurationUnit m4515getStorageUnitimpl = m4515getStorageUnitimpl(j);
        return DurationKt.toDuration(m4533toDoubleimpl(j, m4515getStorageUnitimpl) / d, m4515getStorageUnitimpl);
    }

    /* renamed from: div-LRDsOJo  reason: not valid java name */
    public static final double m4491divLRDsOJo(long j, long j2) {
        DurationUnit durationUnit = (DurationUnit) ComparisonsKt.maxOf(m4515getStorageUnitimpl(j), m4515getStorageUnitimpl(j2));
        return m4533toDoubleimpl(j, durationUnit) / m4533toDoubleimpl(j2, durationUnit);
    }

    /* renamed from: isInfinite-impl  reason: not valid java name */
    public static final boolean m4522isInfiniteimpl(long j) {
        return j == INFINITE || j == NEG_INFINITE;
    }

    /* renamed from: isFinite-impl  reason: not valid java name */
    public static final boolean m4519isFiniteimpl(long j) {
        return !m4522isInfiniteimpl(j);
    }

    @JvmName(name = "getAbsoluteValue-UwyO8pc")
    /* renamed from: getAbsoluteValue-UwyO8pc  reason: not valid java name */
    public static final long m4496getAbsoluteValueUwyO8pc(long j) {
        return m4523isNegativeimpl(j) ? m4542unaryMinusUwyO8pc(j) : j;
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public final int m4543compareToLRDsOJo(long j) {
        return m4489compareToLRDsOJo(this.rawValue, j);
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public static int m4489compareToLRDsOJo(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return Intrinsics.compare(j, j2);
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        return m4523isNegativeimpl(j) ? -i : i;
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m4532toComponentsimpl(long j, Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> function5) {
        Intrinsics.checkNotNullParameter(function5, "");
        return function5.invoke(Long.valueOf(m4505getInWholeDaysimpl(j)), Integer.valueOf(m4497getHoursComponentimpl(j)), Integer.valueOf(m4512getMinutesComponentimpl(j)), Integer.valueOf(m4514getSecondsComponentimpl(j)), Integer.valueOf(m4513getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m4531toComponentsimpl(long j, Function4<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> function4) {
        Intrinsics.checkNotNullParameter(function4, "");
        return function4.invoke(Long.valueOf(m4506getInWholeHoursimpl(j)), Integer.valueOf(m4512getMinutesComponentimpl(j)), Integer.valueOf(m4514getSecondsComponentimpl(j)), Integer.valueOf(m4513getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m4530toComponentsimpl(long j, Function3<? super Long, ? super Integer, ? super Integer, ? extends T> function3) {
        Intrinsics.checkNotNullParameter(function3, "");
        return function3.invoke(Long.valueOf(m4509getInWholeMinutesimpl(j)), Integer.valueOf(m4514getSecondsComponentimpl(j)), Integer.valueOf(m4513getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m4529toComponentsimpl(long j, Function2<? super Long, ? super Integer, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(function2, "");
        return function2.invoke(Long.valueOf(m4511getInWholeSecondsimpl(j)), Integer.valueOf(m4513getNanosecondsComponentimpl(j)));
    }

    @JvmName(name = "getHoursComponent-impl")
    /* renamed from: getHoursComponent-impl  reason: not valid java name */
    public static final int m4497getHoursComponentimpl(long j) {
        if (m4522isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m4506getInWholeHoursimpl(j) % 24);
    }

    @JvmName(name = "getMinutesComponent-impl")
    /* renamed from: getMinutesComponent-impl  reason: not valid java name */
    public static final int m4512getMinutesComponentimpl(long j) {
        if (m4522isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m4509getInWholeMinutesimpl(j) % 60);
    }

    @JvmName(name = "getSecondsComponent-impl")
    /* renamed from: getSecondsComponent-impl  reason: not valid java name */
    public static final int m4514getSecondsComponentimpl(long j) {
        if (m4522isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m4511getInWholeSecondsimpl(j) % 60);
    }

    @JvmName(name = "getNanosecondsComponent-impl")
    /* renamed from: getNanosecondsComponent-impl  reason: not valid java name */
    public static final int m4513getNanosecondsComponentimpl(long j) {
        if (m4522isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m4520isInMillisimpl(j) ? DurationKt.access$millisToNanos(m4517getValueimpl(j) % 1000) : m4517getValueimpl(j) % 1000000000);
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m4533toDoubleimpl(long j, DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "");
        if (j == INFINITE) {
            return Double.POSITIVE_INFINITY;
        }
        if (j == NEG_INFINITE) {
            return Double.NEGATIVE_INFINITY;
        }
        return DurationUnitKt.convertDurationUnit(m4517getValueimpl(j), m4515getStorageUnitimpl(j), durationUnit);
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m4536toLongimpl(long j, DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "");
        if (j == INFINITE) {
            return LongCompanionObject.MAX_VALUE;
        }
        if (j == NEG_INFINITE) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt.convertDurationUnit(m4517getValueimpl(j), m4515getStorageUnitimpl(j), durationUnit);
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m4534toIntimpl(long j, DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "");
        return (int) RangesKt.coerceIn(m4536toLongimpl(j, durationUnit), -2147483648L, 2147483647L);
    }

    @JvmName(name = "getInDays-impl")
    /* renamed from: getInDays-impl  reason: not valid java name */
    public static final double m4498getInDaysimpl(long j) {
        return m4533toDoubleimpl(j, DurationUnit.DAYS);
    }

    @JvmName(name = "getInHours-impl")
    /* renamed from: getInHours-impl  reason: not valid java name */
    public static final double m4499getInHoursimpl(long j) {
        return m4533toDoubleimpl(j, DurationUnit.HOURS);
    }

    @JvmName(name = "getInMinutes-impl")
    /* renamed from: getInMinutes-impl  reason: not valid java name */
    public static final double m4502getInMinutesimpl(long j) {
        return m4533toDoubleimpl(j, DurationUnit.MINUTES);
    }

    @JvmName(name = "getInSeconds-impl")
    /* renamed from: getInSeconds-impl  reason: not valid java name */
    public static final double m4504getInSecondsimpl(long j) {
        return m4533toDoubleimpl(j, DurationUnit.SECONDS);
    }

    @JvmName(name = "getInMilliseconds-impl")
    /* renamed from: getInMilliseconds-impl  reason: not valid java name */
    public static final double m4501getInMillisecondsimpl(long j) {
        return m4533toDoubleimpl(j, DurationUnit.MILLISECONDS);
    }

    @JvmName(name = "getInMicroseconds-impl")
    /* renamed from: getInMicroseconds-impl  reason: not valid java name */
    public static final double m4500getInMicrosecondsimpl(long j) {
        return m4533toDoubleimpl(j, DurationUnit.MICROSECONDS);
    }

    @JvmName(name = "getInNanoseconds-impl")
    /* renamed from: getInNanoseconds-impl  reason: not valid java name */
    public static final double m4503getInNanosecondsimpl(long j) {
        return m4533toDoubleimpl(j, DurationUnit.NANOSECONDS);
    }

    @JvmName(name = "getInWholeDays-impl")
    /* renamed from: getInWholeDays-impl  reason: not valid java name */
    public static final long m4505getInWholeDaysimpl(long j) {
        return m4536toLongimpl(j, DurationUnit.DAYS);
    }

    @JvmName(name = "getInWholeHours-impl")
    /* renamed from: getInWholeHours-impl  reason: not valid java name */
    public static final long m4506getInWholeHoursimpl(long j) {
        return m4536toLongimpl(j, DurationUnit.HOURS);
    }

    @JvmName(name = "getInWholeMinutes-impl")
    /* renamed from: getInWholeMinutes-impl  reason: not valid java name */
    public static final long m4509getInWholeMinutesimpl(long j) {
        return m4536toLongimpl(j, DurationUnit.MINUTES);
    }

    @JvmName(name = "getInWholeSeconds-impl")
    /* renamed from: getInWholeSeconds-impl  reason: not valid java name */
    public static final long m4511getInWholeSecondsimpl(long j) {
        return m4536toLongimpl(j, DurationUnit.SECONDS);
    }

    @JvmName(name = "getInWholeMilliseconds-impl")
    /* renamed from: getInWholeMilliseconds-impl  reason: not valid java name */
    public static final long m4508getInWholeMillisecondsimpl(long j) {
        return (m4520isInMillisimpl(j) && m4519isFiniteimpl(j)) ? m4517getValueimpl(j) : m4536toLongimpl(j, DurationUnit.MILLISECONDS);
    }

    @JvmName(name = "getInWholeMicroseconds-impl")
    /* renamed from: getInWholeMicroseconds-impl  reason: not valid java name */
    public static final long m4507getInWholeMicrosecondsimpl(long j) {
        return m4536toLongimpl(j, DurationUnit.MICROSECONDS);
    }

    @JvmName(name = "getInWholeNanoseconds-impl")
    /* renamed from: getInWholeNanoseconds-impl  reason: not valid java name */
    public static final long m4510getInWholeNanosecondsimpl(long j) {
        long m4517getValueimpl = m4517getValueimpl(j);
        if (m4521isInNanosimpl(j)) {
            return m4517getValueimpl;
        }
        if (m4517getValueimpl > 9223372036854L) {
            return LongCompanionObject.MAX_VALUE;
        }
        if (m4517getValueimpl < -9223372036854L) {
            return Long.MIN_VALUE;
        }
        return DurationKt.access$millisToNanos(m4517getValueimpl);
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeNanoseconds", imports = {}))
    /* renamed from: toLongNanoseconds-impl  reason: not valid java name */
    public static final long m4538toLongNanosecondsimpl(long j) {
        return m4510getInWholeNanosecondsimpl(j);
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeMilliseconds", imports = {}))
    /* renamed from: toLongMilliseconds-impl  reason: not valid java name */
    public static final long m4537toLongMillisecondsimpl(long j) {
        return m4508getInWholeMillisecondsimpl(j);
    }

    public final String toString() {
        return m4539toStringimpl(this.rawValue);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4539toStringimpl(long j) {
        if (j == 0) {
            return "0s";
        }
        if (j == INFINITE) {
            return "Infinity";
        }
        if (j == NEG_INFINITE) {
            return "-Infinity";
        }
        boolean m4523isNegativeimpl = m4523isNegativeimpl(j);
        StringBuilder sb = new StringBuilder();
        if (m4523isNegativeimpl) {
            sb.append('-');
        }
        long m4496getAbsoluteValueUwyO8pc = m4496getAbsoluteValueUwyO8pc(j);
        long m4505getInWholeDaysimpl = m4505getInWholeDaysimpl(m4496getAbsoluteValueUwyO8pc);
        int m4497getHoursComponentimpl = m4497getHoursComponentimpl(m4496getAbsoluteValueUwyO8pc);
        int m4512getMinutesComponentimpl = m4512getMinutesComponentimpl(m4496getAbsoluteValueUwyO8pc);
        int m4514getSecondsComponentimpl = m4514getSecondsComponentimpl(m4496getAbsoluteValueUwyO8pc);
        int m4513getNanosecondsComponentimpl = m4513getNanosecondsComponentimpl(m4496getAbsoluteValueUwyO8pc);
        int i = 0;
        boolean z = m4505getInWholeDaysimpl != 0;
        boolean z2 = m4497getHoursComponentimpl != 0;
        boolean z3 = m4512getMinutesComponentimpl != 0;
        boolean z4 = (m4514getSecondsComponentimpl == 0 && m4513getNanosecondsComponentimpl == 0) ? false : true;
        if (z) {
            sb.append(m4505getInWholeDaysimpl);
            sb.append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            if (i > 0) {
                sb.append(InputCardNumberView.DIVIDER);
            }
            sb.append(m4497getHoursComponentimpl);
            sb.append('h');
            i++;
        }
        if (z3 || (z4 && (z2 || z))) {
            if (i > 0) {
                sb.append(InputCardNumberView.DIVIDER);
            }
            sb.append(m4512getMinutesComponentimpl);
            sb.append('m');
            i++;
        }
        int i2 = i;
        if (z4) {
            if (i2 > 0) {
                sb.append(InputCardNumberView.DIVIDER);
            }
            if (m4514getSecondsComponentimpl != 0 || z || z2 || z3) {
                m4487appendFractionalimpl(j, sb, m4514getSecondsComponentimpl, m4513getNanosecondsComponentimpl, 9, "s", false);
            } else if (m4513getNanosecondsComponentimpl >= 1000000) {
                m4487appendFractionalimpl(j, sb, m4513getNanosecondsComponentimpl / DurationKt.NANOS_IN_MILLIS, m4513getNanosecondsComponentimpl % DurationKt.NANOS_IN_MILLIS, 6, "ms", false);
            } else if (m4513getNanosecondsComponentimpl >= 1000) {
                m4487appendFractionalimpl(j, sb, m4513getNanosecondsComponentimpl / 1000, m4513getNanosecondsComponentimpl % 1000, 3, "us", false);
            } else {
                sb.append(m4513getNanosecondsComponentimpl);
                sb.append("ns");
            }
            i2++;
        }
        if (m4523isNegativeimpl && i2 > 1) {
            sb.insert(1, '(').append(')');
        }
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    /* renamed from: appendFractional-impl  reason: not valid java name */
    private static final void m4487appendFractionalimpl(long j, StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        sb.append(i);
        if (i2 != 0) {
            sb.append('.');
            String padStart = StringsKt.padStart(String.valueOf(i2), i3, '0');
            int length = padStart.length() - 1;
            int i4 = -1;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    if (padStart.charAt(length) != '0') {
                        i4 = length;
                        break;
                    } else if (i5 < 0) {
                        break;
                    } else {
                        length = i5;
                    }
                }
            }
            int i6 = i4 + 1;
            if (!z && i6 < 3) {
                sb.append((CharSequence) padStart, 0, i6);
                Intrinsics.checkNotNullExpressionValue(sb, "");
            } else {
                sb.append((CharSequence) padStart, 0, ((i6 + 2) / 3) * 3);
                Intrinsics.checkNotNullExpressionValue(sb, "");
            }
        }
        sb.append(str);
    }

    /* renamed from: toString-impl$default  reason: not valid java name */
    public static /* synthetic */ String m4541toStringimpl$default(long j, DurationUnit durationUnit, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m4540toStringimpl(j, durationUnit, i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static final String m4540toStringimpl(long j, DurationUnit durationUnit, int i) {
        Intrinsics.checkNotNullParameter(durationUnit, "");
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("decimals must be not negative, but was ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString().toString());
        }
        double m4533toDoubleimpl = m4533toDoubleimpl(j, durationUnit);
        if (Double.isInfinite(m4533toDoubleimpl)) {
            return String.valueOf(m4533toDoubleimpl);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(DurationJvmKt.formatToExactDecimals(m4533toDoubleimpl, RangesKt.coerceAtMost(i, 12)));
        sb2.append(DurationUnitKt.shortName(durationUnit));
        return sb2.toString();
    }

    /* renamed from: toIsoString-impl  reason: not valid java name */
    public static final String m4535toIsoStringimpl(long j) {
        StringBuilder sb = new StringBuilder();
        if (m4523isNegativeimpl(j)) {
            sb.append('-');
        }
        sb.append("PT");
        long m4496getAbsoluteValueUwyO8pc = m4496getAbsoluteValueUwyO8pc(j);
        long m4506getInWholeHoursimpl = m4506getInWholeHoursimpl(m4496getAbsoluteValueUwyO8pc);
        int m4512getMinutesComponentimpl = m4512getMinutesComponentimpl(m4496getAbsoluteValueUwyO8pc);
        int m4514getSecondsComponentimpl = m4514getSecondsComponentimpl(m4496getAbsoluteValueUwyO8pc);
        int m4513getNanosecondsComponentimpl = m4513getNanosecondsComponentimpl(m4496getAbsoluteValueUwyO8pc);
        if (m4522isInfiniteimpl(j)) {
            m4506getInWholeHoursimpl = 9999999999999L;
        }
        boolean z = false;
        boolean z2 = m4506getInWholeHoursimpl != 0;
        boolean z3 = (m4514getSecondsComponentimpl == 0 && m4513getNanosecondsComponentimpl == 0) ? false : true;
        if (m4512getMinutesComponentimpl != 0 || (z3 && z2)) {
            z = true;
        }
        if (z2) {
            sb.append(m4506getInWholeHoursimpl);
            sb.append('H');
        }
        if (z) {
            sb.append(m4512getMinutesComponentimpl);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            m4487appendFractionalimpl(j, sb, m4514getSecondsComponentimpl, m4513getNanosecondsComponentimpl, 9, "S", true);
        }
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }
}

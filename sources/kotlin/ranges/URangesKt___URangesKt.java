package kotlin.ranges;

import com.alibaba.griver.beehive.lottie.player.LottieParams;
import id.dana.data.foundation.logger.log.LoginTrackingConstants;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;
import kotlin.ranges.UIntProgression;
import kotlin.ranges.ULongProgression;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\u001a\u001c\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001c\u0010\u0004\u001a\u00020\b*\u00020\b2\u0006\u0010\u0001\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\u0004\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0003\u001a\u001c\u0010\u0010\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0007\u001a\u001c\u0010\u0010\u001a\u00020\b*\u00020\b2\u0006\u0010\u000e\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\n\u001a\u001c\u0010\u0010\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\r\u001a$\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a$\u0010\u0016\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\"\u0010\u0016\u001a\u00020\u0005*\u00020\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a$\u0010\u0016\u001a\u00020\b*\u00020\b2\u0006\u0010\u0001\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\"\u0010\u0016\u001a\u00020\b*\u00020\b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u0019ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a$\u0010\u0016\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010(\u001a\u00020%*\u00020#2\u0006\u0010$\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a!\u0010(\u001a\u00020%*\u00020#2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0086\nø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a\u001f\u0010(\u001a\u00020%*\u00020#2\u0006\u0010$\u001a\u00020\bH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a\u001f\u0010(\u001a\u00020%*\u00020#2\u0006\u0010$\u001a\u00020\u000bH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a\u001f\u0010(\u001a\u00020%*\u0002002\u0006\u0010$\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a\u001f\u0010(\u001a\u00020%*\u0002002\u0006\u0010$\u001a\u00020\u0005H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a!\u0010(\u001a\u00020%*\u0002002\b\u0010)\u001a\u0004\u0018\u00010\bH\u0086\nø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a\u001f\u0010(\u001a\u00020%*\u0002002\u0006\u0010$\u001a\u00020\u000bH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b7\u00108\u001a\u001f\u0010=\u001a\u00020:*\u00020\u00002\u0006\u00109\u001a\u00020\u0000H\u0086\u0004ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a\u001f\u0010=\u001a\u00020:*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0086\u0004ø\u0001\u0000¢\u0006\u0004\b>\u0010?\u001a\u001f\u0010=\u001a\u00020@*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0086\u0004ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u001a\u001f\u0010=\u001a\u00020:*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0086\u0004ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001a\u0017\u0010E\u001a\u00020\u0005*\u00020#H\u0086\bø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a\u001c\u0010E\u001a\u00020\u0005*\u00020#2\u0006\u0010E\u001a\u00020Gø\u0001\u0000¢\u0006\u0004\bE\u0010H\u001a\u0017\u0010E\u001a\u00020\b*\u000200H\u0086\bø\u0001\u0000¢\u0006\u0004\bE\u0010I\u001a\u001c\u0010E\u001a\u00020\b*\u0002002\u0006\u0010E\u001a\u00020Gø\u0001\u0000¢\u0006\u0004\bE\u0010J\u001a\u0019\u0010K\u001a\u0004\u0018\u00010\u0005*\u00020#H\u0086\bø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001a\u001e\u0010K\u001a\u0004\u0018\u00010\u0005*\u00020#2\u0006\u0010E\u001a\u00020Gø\u0001\u0000¢\u0006\u0004\bK\u0010M\u001a\u0019\u0010K\u001a\u0004\u0018\u00010\b*\u000200H\u0086\bø\u0001\u0000¢\u0006\u0004\bK\u0010N\u001a\u001e\u0010K\u001a\u0004\u0018\u00010\b*\u0002002\u0006\u0010E\u001a\u00020Gø\u0001\u0000¢\u0006\u0004\bK\u0010O\u001a\u0011\u0010P\u001a\u00020:*\u00020:¢\u0006\u0004\bP\u0010Q\u001a\u0011\u0010P\u001a\u00020@*\u00020@¢\u0006\u0004\bP\u0010R\u001a\u001c\u0010T\u001a\u00020:*\u00020:2\u0006\u0010T\u001a\u00020SH\u0086\u0004¢\u0006\u0004\bT\u0010U\u001a\u001c\u0010T\u001a\u00020@*\u00020@2\u0006\u0010T\u001a\u00020VH\u0086\u0004¢\u0006\u0004\bT\u0010W\u001a\u001f\u0010Z\u001a\u00020#*\u00020\u00002\u0006\u00109\u001a\u00020\u0000H\u0086\u0004ø\u0001\u0000¢\u0006\u0004\bX\u0010Y\u001a\u001f\u0010Z\u001a\u00020#*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0086\u0004ø\u0001\u0000¢\u0006\u0004\b[\u0010\\\u001a\u001f\u0010Z\u001a\u000200*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0086\u0004ø\u0001\u0000¢\u0006\u0004\b]\u0010^\u001a\u001f\u0010Z\u001a\u00020#*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0086\u0004ø\u0001\u0000¢\u0006\u0004\b_\u0010`\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlin/UByte;", "minimumValue", "coerceAtLeast-Kr8caGY", "(BB)B", "coerceAtLeast", "Lkotlin/UInt;", "coerceAtLeast-J1ME1BU", "(II)I", "Lkotlin/ULong;", "coerceAtLeast-eb3DHEI", "(JJ)J", "Lkotlin/UShort;", "coerceAtLeast-5PvTz6A", "(SS)S", "maximumValue", "coerceAtMost-Kr8caGY", "coerceAtMost", "coerceAtMost-J1ME1BU", "coerceAtMost-eb3DHEI", "coerceAtMost-5PvTz6A", "coerceIn-b33U2AM", "(BBB)B", "coerceIn", "coerceIn-WZ9TVnA", "(III)I", "Lkotlin/ranges/ClosedRange;", "range", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "coerceIn-VKSA0NQ", "(SSS)S", "Lkotlin/ranges/UIntRange;", "value", "", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "contains", LottieParams.KEY_ELEMENT_ID, "contains-biwQdVI", "(Lkotlin/ranges/UIntRange;Lkotlin/UInt;)Z", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "Lkotlin/ranges/ULongRange;", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-GYNo2lE", "(Lkotlin/ranges/ULongRange;Lkotlin/ULong;)Z", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", LoginTrackingConstants.LoginParam.TO, "Lkotlin/ranges/UIntProgression;", "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ULongProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", "random", "(Lkotlin/ranges/UIntRange;)I", "Lkotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;)J", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "randomOrNull", "(Lkotlin/ranges/UIntRange;)Lkotlin/UInt;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)Lkotlin/UInt;", "(Lkotlin/ranges/ULongRange;)Lkotlin/ULong;", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)Lkotlin/ULong;", "reversed", "(Lkotlin/ranges/UIntProgression;)Lkotlin/ranges/UIntProgression;", "(Lkotlin/ranges/ULongProgression;)Lkotlin/ranges/ULongProgression;", "", "step", "(Lkotlin/ranges/UIntProgression;I)Lkotlin/ranges/UIntProgression;", "", "(Lkotlin/ranges/ULongProgression;J)Lkotlin/ranges/ULongProgression;", "until-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "until", "until-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "until-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "until-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/ranges/URangesKt")
/* loaded from: classes9.dex */
class URangesKt___URangesKt {
    private static final int random(UIntRange uIntRange) {
        Intrinsics.checkNotNullParameter(uIntRange, "");
        return URangesKt.random(uIntRange, Random.INSTANCE);
    }

    private static final long random(ULongRange uLongRange) {
        Intrinsics.checkNotNullParameter(uLongRange, "");
        return URangesKt.random(uLongRange, Random.INSTANCE);
    }

    public static final int random(UIntRange uIntRange, Random random) {
        Intrinsics.checkNotNullParameter(uIntRange, "");
        Intrinsics.checkNotNullParameter(random, "");
        try {
            return URandomKt.nextUInt(random, uIntRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static final long random(ULongRange uLongRange, Random random) {
        Intrinsics.checkNotNullParameter(uLongRange, "");
        Intrinsics.checkNotNullParameter(random, "");
        try {
            return URandomKt.nextULong(random, uLongRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    private static final UInt randomOrNull(UIntRange uIntRange) {
        Intrinsics.checkNotNullParameter(uIntRange, "");
        return URangesKt.randomOrNull(uIntRange, Random.INSTANCE);
    }

    private static final ULong randomOrNull(ULongRange uLongRange) {
        Intrinsics.checkNotNullParameter(uLongRange, "");
        return URangesKt.randomOrNull(uLongRange, Random.INSTANCE);
    }

    public static final UInt randomOrNull(UIntRange uIntRange, Random random) {
        Intrinsics.checkNotNullParameter(uIntRange, "");
        Intrinsics.checkNotNullParameter(random, "");
        if (uIntRange.isEmpty()) {
            return null;
        }
        return UInt.m3267boximpl(URandomKt.nextUInt(random, uIntRange));
    }

    public static final ULong randomOrNull(ULongRange uLongRange, Random random) {
        Intrinsics.checkNotNullParameter(uLongRange, "");
        Intrinsics.checkNotNullParameter(random, "");
        if (uLongRange.isEmpty()) {
            return null;
        }
        return ULong.m3345boximpl(URandomKt.nextULong(random, uLongRange));
    }

    /* renamed from: contains-biwQdVI  reason: not valid java name */
    private static final boolean m4415containsbiwQdVI(UIntRange uIntRange, UInt uInt) {
        Intrinsics.checkNotNullParameter(uIntRange, "");
        return uInt != null && uIntRange.m4387containsWZ4Q5Ns(uInt.getData());
    }

    /* renamed from: contains-GYNo2lE  reason: not valid java name */
    private static final boolean m4411containsGYNo2lE(ULongRange uLongRange, ULong uLong) {
        Intrinsics.checkNotNullParameter(uLongRange, "");
        return uLong != null && uLongRange.m4393containsVKZWuLQ(uLong.getData());
    }

    /* renamed from: contains-68kG9v0  reason: not valid java name */
    public static final boolean m4410contains68kG9v0(UIntRange uIntRange, byte b) {
        Intrinsics.checkNotNullParameter(uIntRange, "");
        return uIntRange.m4387containsWZ4Q5Ns(UInt.m3273constructorimpl(b & 255));
    }

    /* renamed from: contains-ULb-yJY  reason: not valid java name */
    public static final boolean m4413containsULbyJY(ULongRange uLongRange, byte b) {
        Intrinsics.checkNotNullParameter(uLongRange, "");
        return uLongRange.m4393containsVKZWuLQ(ULong.m3351constructorimpl(b & 255));
    }

    /* renamed from: contains-Gab390E  reason: not valid java name */
    public static final boolean m4412containsGab390E(ULongRange uLongRange, int i) {
        Intrinsics.checkNotNullParameter(uLongRange, "");
        return uLongRange.m4393containsVKZWuLQ(ULong.m3351constructorimpl(i & 4294967295L));
    }

    /* renamed from: contains-fz5IDCE  reason: not valid java name */
    public static final boolean m4416containsfz5IDCE(UIntRange uIntRange, long j) {
        Intrinsics.checkNotNullParameter(uIntRange, "");
        return ULong.m3351constructorimpl(j >>> 32) == 0 && uIntRange.m4387containsWZ4Q5Ns(UInt.m3273constructorimpl((int) j));
    }

    /* renamed from: contains-ZsK3CEQ  reason: not valid java name */
    public static final boolean m4414containsZsK3CEQ(UIntRange uIntRange, short s) {
        Intrinsics.checkNotNullParameter(uIntRange, "");
        return uIntRange.m4387containsWZ4Q5Ns(UInt.m3273constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: contains-uhHAxoY  reason: not valid java name */
    public static final boolean m4417containsuhHAxoY(ULongRange uLongRange, short s) {
        Intrinsics.checkNotNullParameter(uLongRange, "");
        return uLongRange.m4393containsVKZWuLQ(ULong.m3351constructorimpl(s & 65535));
    }

    /* renamed from: downTo-Kr8caGY  reason: not valid java name */
    public static final UIntProgression m4420downToKr8caGY(byte b, byte b2) {
        return UIntProgression.INSTANCE.m4386fromClosedRangeNkh28Cs(UInt.m3273constructorimpl(b & 255), UInt.m3273constructorimpl(b2 & 255), -1);
    }

    /* renamed from: downTo-J1ME1BU  reason: not valid java name */
    public static final UIntProgression m4419downToJ1ME1BU(int i, int i2) {
        return UIntProgression.INSTANCE.m4386fromClosedRangeNkh28Cs(i, i2, -1);
    }

    /* renamed from: downTo-eb3DHEI  reason: not valid java name */
    public static final ULongProgression m4421downToeb3DHEI(long j, long j2) {
        return ULongProgression.INSTANCE.m4392fromClosedRange7ftBX0g(j, j2, -1L);
    }

    /* renamed from: downTo-5PvTz6A  reason: not valid java name */
    public static final UIntProgression m4418downTo5PvTz6A(short s, short s2) {
        return UIntProgression.INSTANCE.m4386fromClosedRangeNkh28Cs(UInt.m3273constructorimpl(s & UShort.MAX_VALUE), UInt.m3273constructorimpl(s2 & UShort.MAX_VALUE), -1);
    }

    public static final UIntProgression reversed(UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "");
        return UIntProgression.INSTANCE.m4386fromClosedRangeNkh28Cs(uIntProgression.getLast(), uIntProgression.getFirst(), -uIntProgression.getStep());
    }

    public static final ULongProgression reversed(ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "");
        return ULongProgression.INSTANCE.m4392fromClosedRange7ftBX0g(uLongProgression.getLast(), uLongProgression.getFirst(), -uLongProgression.getStep());
    }

    public static final UIntProgression step(UIntProgression uIntProgression, int i) {
        Intrinsics.checkNotNullParameter(uIntProgression, "");
        RangesKt.checkStepIsPositive(i > 0, Integer.valueOf(i));
        UIntProgression.Companion companion = UIntProgression.INSTANCE;
        int first = uIntProgression.getFirst();
        int last = uIntProgression.getLast();
        if (uIntProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.m4386fromClosedRangeNkh28Cs(first, last, i);
    }

    public static final ULongProgression step(ULongProgression uLongProgression, long j) {
        Intrinsics.checkNotNullParameter(uLongProgression, "");
        RangesKt.checkStepIsPositive(j > 0, Long.valueOf(j));
        ULongProgression.Companion companion = ULongProgression.INSTANCE;
        long first = uLongProgression.getFirst();
        long last = uLongProgression.getLast();
        if (uLongProgression.getStep() <= 0) {
            j = -j;
        }
        return companion.m4392fromClosedRange7ftBX0g(first, last, j);
    }

    /* renamed from: until-Kr8caGY  reason: not valid java name */
    public static final UIntRange m4424untilKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b2 & 255, 0) <= 0 ? UIntRange.INSTANCE.getEMPTY() : new UIntRange(UInt.m3273constructorimpl(b & 255), UInt.m3273constructorimpl(UInt.m3273constructorimpl(r3) - 1), null);
    }

    /* renamed from: until-J1ME1BU  reason: not valid java name */
    public static final UIntRange m4423untilJ1ME1BU(int i, int i2) {
        return UnsignedKt.uintCompare(i2, 0) <= 0 ? UIntRange.INSTANCE.getEMPTY() : new UIntRange(i, UInt.m3273constructorimpl(i2 - 1), null);
    }

    /* renamed from: until-eb3DHEI  reason: not valid java name */
    public static final ULongRange m4425untileb3DHEI(long j, long j2) {
        return UnsignedKt.ulongCompare(j2, 0L) <= 0 ? ULongRange.INSTANCE.getEMPTY() : new ULongRange(j, ULong.m3351constructorimpl(j2 - ULong.m3351constructorimpl(1L)), null);
    }

    /* renamed from: until-5PvTz6A  reason: not valid java name */
    public static final UIntRange m4422until5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s2 & UShort.MAX_VALUE, 0) <= 0 ? UIntRange.INSTANCE.getEMPTY() : new UIntRange(UInt.m3273constructorimpl(s & UShort.MAX_VALUE), UInt.m3273constructorimpl(UInt.m3273constructorimpl(r3) - 1), null);
    }

    /* renamed from: coerceAtLeast-J1ME1BU  reason: not valid java name */
    public static final int m4397coerceAtLeastJ1ME1BU(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2) < 0 ? i2 : i;
    }

    /* renamed from: coerceAtLeast-eb3DHEI  reason: not valid java name */
    public static final long m4399coerceAtLeasteb3DHEI(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2) < 0 ? j2 : j;
    }

    /* renamed from: coerceAtLeast-Kr8caGY  reason: not valid java name */
    public static final byte m4398coerceAtLeastKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b & 255, b2 & 255) < 0 ? b2 : b;
    }

    /* renamed from: coerceAtLeast-5PvTz6A  reason: not valid java name */
    public static final short m4396coerceAtLeast5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) < 0 ? s2 : s;
    }

    /* renamed from: coerceAtMost-J1ME1BU  reason: not valid java name */
    public static final int m4401coerceAtMostJ1ME1BU(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2) > 0 ? i2 : i;
    }

    /* renamed from: coerceAtMost-eb3DHEI  reason: not valid java name */
    public static final long m4403coerceAtMosteb3DHEI(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2) > 0 ? j2 : j;
    }

    /* renamed from: coerceAtMost-Kr8caGY  reason: not valid java name */
    public static final byte m4402coerceAtMostKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b & 255, b2 & 255) > 0 ? b2 : b;
    }

    /* renamed from: coerceAtMost-5PvTz6A  reason: not valid java name */
    public static final short m4400coerceAtMost5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) > 0 ? s2 : s;
    }

    /* renamed from: coerceIn-WZ9TVnA  reason: not valid java name */
    public static final int m4406coerceInWZ9TVnA(int i, int i2, int i3) {
        if (UnsignedKt.uintCompare(i2, i3) <= 0) {
            return UnsignedKt.uintCompare(i, i2) < 0 ? i2 : UnsignedKt.uintCompare(i, i3) > 0 ? i3 : i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot coerce value to an empty range: maximum ");
        sb.append((Object) UInt.m3318toStringimpl(i3));
        sb.append(" is less than minimum ");
        sb.append((Object) UInt.m3318toStringimpl(i2));
        sb.append('.');
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: coerceIn-sambcqE  reason: not valid java name */
    public static final long m4408coerceInsambcqE(long j, long j2, long j3) {
        if (UnsignedKt.ulongCompare(j2, j3) <= 0) {
            return UnsignedKt.ulongCompare(j, j2) < 0 ? j2 : UnsignedKt.ulongCompare(j, j3) > 0 ? j3 : j;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot coerce value to an empty range: maximum ");
        sb.append((Object) ULong.m3396toStringimpl(j3));
        sb.append(" is less than minimum ");
        sb.append((Object) ULong.m3396toStringimpl(j2));
        sb.append('.');
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: coerceIn-b33U2AM  reason: not valid java name */
    public static final byte m4407coerceInb33U2AM(byte b, byte b2, byte b3) {
        int i = b2 & 255;
        int i2 = b3 & 255;
        if (Intrinsics.compare(i, i2) <= 0) {
            int i3 = b & 255;
            return Intrinsics.compare(i3, i) < 0 ? b2 : Intrinsics.compare(i3, i2) > 0 ? b3 : b;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot coerce value to an empty range: maximum ");
        sb.append((Object) UByte.m3240toStringimpl(b3));
        sb.append(" is less than minimum ");
        sb.append((Object) UByte.m3240toStringimpl(b2));
        sb.append('.');
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: coerceIn-VKSA0NQ  reason: not valid java name */
    public static final short m4405coerceInVKSA0NQ(short s, short s2, short s3) {
        int i = s2 & UShort.MAX_VALUE;
        int i2 = s3 & UShort.MAX_VALUE;
        if (Intrinsics.compare(i, i2) <= 0) {
            int i3 = 65535 & s;
            return Intrinsics.compare(i3, i) < 0 ? s2 : Intrinsics.compare(i3, i2) > 0 ? s3 : s;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot coerce value to an empty range: maximum ");
        sb.append((Object) UShort.m3500toStringimpl(s3));
        sb.append(" is less than minimum ");
        sb.append((Object) UShort.m3500toStringimpl(s2));
        sb.append('.');
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: coerceIn-wuiCnnA  reason: not valid java name */
    public static final int m4409coerceInwuiCnnA(int i, ClosedRange<UInt> closedRange) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((UInt) RangesKt.coerceIn(UInt.m3267boximpl(i), (ClosedFloatingPointRange<UInt>) closedRange)).getData();
        }
        if (!closedRange.isEmpty()) {
            return UnsignedKt.uintCompare(i, closedRange.getStart().getData()) < 0 ? closedRange.getStart().getData() : UnsignedKt.uintCompare(i, closedRange.getEndInclusive().getData()) > 0 ? closedRange.getEndInclusive().getData() : i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot coerce value to an empty range: ");
        sb.append(closedRange);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: coerceIn-JPwROB0  reason: not valid java name */
    public static final long m4404coerceInJPwROB0(long j, ClosedRange<ULong> closedRange) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((ULong) RangesKt.coerceIn(ULong.m3345boximpl(j), (ClosedFloatingPointRange<ULong>) closedRange)).getData();
        }
        if (!closedRange.isEmpty()) {
            return UnsignedKt.ulongCompare(j, closedRange.getStart().getData()) < 0 ? closedRange.getStart().getData() : UnsignedKt.ulongCompare(j, closedRange.getEndInclusive().getData()) > 0 ? closedRange.getEndInclusive().getData() : j;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot coerce value to an empty range: ");
        sb.append(closedRange);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString());
    }
}

package kotlin.time;

import com.alipay.mobile.rome.syncsdk.transport.connection.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0004H\u0000¢\u0006\u0004\b\b\u0010\u000b"}, d2 = {"", "isoChar", "", "isTimeComponent", "Lkotlin/time/DurationUnit;", "durationUnitByIsoChar", "(CZ)Lkotlin/time/DurationUnit;", "", "shortName", "durationUnitByShortName", "(Ljava/lang/String;)Lkotlin/time/DurationUnit;", "(Lkotlin/time/DurationUnit;)Ljava/lang/String;"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/time/DurationUnitKt")
/* loaded from: classes3.dex */
class DurationUnitKt__DurationUnitKt extends DurationUnitKt__DurationUnitJvmKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DurationUnit.values().length];
            iArr[DurationUnit.NANOSECONDS.ordinal()] = 1;
            iArr[DurationUnit.MICROSECONDS.ordinal()] = 2;
            iArr[DurationUnit.MILLISECONDS.ordinal()] = 3;
            iArr[DurationUnit.SECONDS.ordinal()] = 4;
            iArr[DurationUnit.MINUTES.ordinal()] = 5;
            iArr[DurationUnit.HOURS.ordinal()] = 6;
            iArr[DurationUnit.DAYS.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String shortName(DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "");
        switch (WhenMappings.$EnumSwitchMapping$0[durationUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "us";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return "m";
            case 6:
                return "h";
            case 7:
                return d.f7256a;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown unit: ");
                sb.append(durationUnit);
                throw new IllegalStateException(sb.toString().toString());
        }
    }

    public static final DurationUnit durationUnitByShortName(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        int hashCode = str.hashCode();
        if (hashCode != 100) {
            if (hashCode != 104) {
                if (hashCode != 109) {
                    if (hashCode != 115) {
                        if (hashCode != 3494) {
                            if (hashCode != 3525) {
                                if (hashCode == 3742 && str.equals("us")) {
                                    return DurationUnit.MICROSECONDS;
                                }
                            } else if (str.equals("ns")) {
                                return DurationUnit.NANOSECONDS;
                            }
                        } else if (str.equals("ms")) {
                            return DurationUnit.MILLISECONDS;
                        }
                    } else if (str.equals("s")) {
                        return DurationUnit.SECONDS;
                    }
                } else if (str.equals("m")) {
                    return DurationUnit.MINUTES;
                }
            } else if (str.equals("h")) {
                return DurationUnit.HOURS;
            }
        } else if (str.equals(d.f7256a)) {
            return DurationUnit.DAYS;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown duration unit short name: ");
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    public static final DurationUnit durationUnitByIsoChar(char c, boolean z) {
        if (!z) {
            if (c == 'D') {
                return DurationUnit.DAYS;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid or unsupported duration ISO non-time unit: ");
            sb.append(c);
            throw new IllegalArgumentException(sb.toString());
        } else if (c == 'H') {
            return DurationUnit.HOURS;
        } else {
            if (c == 'M') {
                return DurationUnit.MINUTES;
            }
            if (c == 'S') {
                return DurationUnit.SECONDS;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid duration ISO time unit: ");
            sb2.append(c);
            throw new IllegalArgumentException(sb2.toString());
        }
    }
}

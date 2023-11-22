package j$.time.temporal;

import android.media.AudioTrack;
import android.os.SystemClock;
import android.widget.ExpandableListView;
import com.alibaba.griver.beehive.lottie.player.TimeUtils;
import j$.time.Duration;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.Typography;
import o.A;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'DAYS' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class ChronoUnit implements TemporalUnit {
    private static int $10 = 0;
    private static int $11 = 1;
    private static final /* synthetic */ ChronoUnit[] $VALUES;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    public static final ChronoUnit CENTURIES;
    public static final ChronoUnit DAYS;
    public static final ChronoUnit DECADES;
    public static final ChronoUnit ERAS;
    public static final ChronoUnit FOREVER;
    public static final ChronoUnit HALF_DAYS;
    public static final ChronoUnit HOURS;
    private static int KClassImpl$Data$declaredNonStaticMembers$2;
    public static final ChronoUnit MICROS;
    public static final ChronoUnit MILLENNIA;
    public static final ChronoUnit MILLIS;
    public static final ChronoUnit MINUTES;
    public static final ChronoUnit MONTHS;
    public static final ChronoUnit NANOS;
    public static final ChronoUnit SECONDS;
    public static final ChronoUnit WEEKS;
    public static final ChronoUnit YEARS;
    private static int getAuthRequestContext;
    private final String name;

    static {
        getAuthRequestContext();
        Duration.ofNanos(1L);
        ChronoUnit chronoUnit = new ChronoUnit("NANOS", 0, "Nanos");
        NANOS = chronoUnit;
        Duration.ofNanos(1000L);
        ChronoUnit chronoUnit2 = new ChronoUnit("MICROS", 1, "Micros");
        MICROS = chronoUnit2;
        Duration.ofNanos(1000000L);
        ChronoUnit chronoUnit3 = new ChronoUnit("MILLIS", 2, "Millis");
        MILLIS = chronoUnit3;
        Duration.ofSeconds(1L);
        ChronoUnit chronoUnit4 = new ChronoUnit("SECONDS", 3, "Seconds");
        SECONDS = chronoUnit4;
        Duration.ofSeconds(60L);
        ChronoUnit chronoUnit5 = new ChronoUnit("MINUTES", 4, "Minutes");
        MINUTES = chronoUnit5;
        Duration.ofSeconds(3600L);
        ChronoUnit chronoUnit6 = new ChronoUnit("HOURS", 5, "Hours");
        HOURS = chronoUnit6;
        Duration.ofSeconds(43200L);
        ChronoUnit chronoUnit7 = new ChronoUnit("HALF_DAYS", 6, "HalfDays");
        HALF_DAYS = chronoUnit7;
        Duration.ofSeconds(TimeUtils.DAY_TO_SECOND);
        Object[] objArr = new Object[1];
        a(new char[]{15, 65504, 65533, 21}, 202 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 5 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), false, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 1, objArr);
        ChronoUnit chronoUnit8 = new ChronoUnit("DAYS", 7, ((String) objArr[0]).intern());
        DAYS = chronoUnit8;
        Duration.ofSeconds(604800L);
        ChronoUnit chronoUnit9 = new ChronoUnit("WEEKS", 8, "Weeks");
        WEEKS = chronoUnit9;
        Duration.ofSeconds(2629746L);
        ChronoUnit chronoUnit10 = new ChronoUnit("MONTHS", 9, "Months");
        MONTHS = chronoUnit10;
        Duration.ofSeconds(31556952L);
        ChronoUnit chronoUnit11 = new ChronoUnit("YEARS", 10, "Years");
        YEARS = chronoUnit11;
        Duration.ofSeconds(315569520L);
        ChronoUnit chronoUnit12 = new ChronoUnit("DECADES", 11, "Decades");
        DECADES = chronoUnit12;
        Duration.ofSeconds(3155695200L);
        ChronoUnit chronoUnit13 = new ChronoUnit("CENTURIES", 12, "Centuries");
        CENTURIES = chronoUnit13;
        Duration.ofSeconds(31556952000L);
        ChronoUnit chronoUnit14 = new ChronoUnit("MILLENNIA", 13, "Millennia");
        MILLENNIA = chronoUnit14;
        Duration.ofSeconds(31556952000000000L);
        ChronoUnit chronoUnit15 = new ChronoUnit("ERAS", 14, "Eras");
        ERAS = chronoUnit15;
        Duration.ofSeconds(LongCompanionObject.MAX_VALUE, 999999999L);
        ChronoUnit chronoUnit16 = new ChronoUnit("FOREVER", 15, "Forever");
        FOREVER = chronoUnit16;
        $VALUES = new ChronoUnit[]{chronoUnit, chronoUnit2, chronoUnit3, chronoUnit4, chronoUnit5, chronoUnit6, chronoUnit7, chronoUnit8, chronoUnit9, chronoUnit10, chronoUnit11, chronoUnit12, chronoUnit13, chronoUnit14, chronoUnit15, chronoUnit16};
        int i = BuiltInFictitiousFunctionClassFactory + 67;
        getAuthRequestContext = i % 128;
        if ((i % 2 != 0 ? '@' : 'M') != '@') {
            return;
        }
        int i2 = 30 / 0;
    }

    private ChronoUnit(String str, int i, String str2) {
        try {
            this.name = str2;
        } catch (Exception e) {
            throw e;
        }
    }

    static void getAuthRequestContext() {
        KClassImpl$Data$declaredNonStaticMembers$2 = 269894723;
    }

    public static ChronoUnit valueOf(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 113;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        ChronoUnit chronoUnit = (ChronoUnit) Enum.valueOf(ChronoUnit.class, str);
        try {
            int i3 = BuiltInFictitiousFunctionClassFactory + 73;
            getAuthRequestContext = i3 % 128;
            if (!(i3 % 2 == 0)) {
                Object obj = null;
                obj.hashCode();
                return chronoUnit;
            }
            return chronoUnit;
        } catch (Exception e) {
            throw e;
        }
    }

    public static ChronoUnit[] values() {
        ChronoUnit[] chronoUnitArr;
        try {
            int i = getAuthRequestContext + 73;
            try {
                BuiltInFictitiousFunctionClassFactory = i % 128;
                if ((i % 2 == 0 ? (char) 15 : 'O') != 'O') {
                    chronoUnitArr = (ChronoUnit[]) $VALUES.clone();
                    Object obj = null;
                    obj.hashCode();
                } else {
                    chronoUnitArr = (ChronoUnit[]) $VALUES.clone();
                }
                int i2 = BuiltInFictitiousFunctionClassFactory + 97;
                getAuthRequestContext = i2 % 128;
                int i3 = i2 % 2;
                return chronoUnitArr;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // j$.time.temporal.TemporalUnit
    public final Temporal addTo(Temporal temporal, long j) {
        int i = getAuthRequestContext + 111;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            Temporal plus = temporal.plus(j, this);
            int i3 = getAuthRequestContext + 47;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if ((i3 % 2 == 0 ? Typography.dollar : (char) 22) != 22) {
                int i4 = 63 / 0;
                return plus;
            }
            return plus;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // j$.time.temporal.TemporalUnit
    public final long between(Temporal temporal, Temporal temporal2) {
        int i = getAuthRequestContext + 7;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        long until = temporal.until(temporal2, this);
        try {
            int i3 = getAuthRequestContext + 81;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if (!(i3 % 2 == 0)) {
                return until;
            }
            Object obj = null;
            obj.hashCode();
            return until;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // j$.time.temporal.TemporalUnit
    public final boolean isDateBased() {
        int i = getAuthRequestContext + 105;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        if (!(compareTo(DAYS) >= 0)) {
            return false;
        }
        int i3 = BuiltInFictitiousFunctionClassFactory + 97;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return this != FOREVER;
    }

    @Override // j$.time.temporal.TemporalUnit
    public final boolean isTimeBased() {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 99;
            getAuthRequestContext = i % 128;
            if (!(i % 2 == 0)) {
                int compareTo = compareTo(DAYS);
                Object[] objArr = null;
                int length = objArr.length;
                if (!(compareTo < 0)) {
                    return false;
                }
            } else {
                try {
                    if (compareTo(DAYS) >= 0) {
                        return false;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
            int i2 = getAuthRequestContext + 81;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            int i3 = i2 % 2;
            return true;
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // java.lang.Enum
    public final String toString() {
        int i = getAuthRequestContext + 7;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        String str = this.name;
        int i3 = getAuthRequestContext + 115;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return str;
        }
        int i4 = 44 / 0;
        return str;
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        try {
            int i4 = $11 + 75;
            $10 = i4 % 128;
            int i5 = i4 % 2;
            while (true) {
                if (a2.MyBillsEntityDataFactory >= i2) {
                    break;
                }
                int i6 = $10 + 1;
                $11 = i6 % 128;
                int i7 = i6 % 2;
                a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
                int i8 = a2.MyBillsEntityDataFactory;
                cArr2[i8] = (char) (cArr2[i8] - ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ (-5694784870793460699L))));
                a2.MyBillsEntityDataFactory++;
            }
            if (i3 > 0) {
                int i9 = $10 + 9;
                $11 = i9 % 128;
                int i10 = i9 % 2;
                try {
                    a2.BuiltInFictitiousFunctionClassFactory = i3;
                    char[] cArr3 = new char[i2];
                    System.arraycopy(cArr2, 0, cArr3, 0, i2);
                    System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
                    System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
                } catch (Exception e) {
                    throw e;
                }
            }
            if ((z ? '1' : '\t') != '\t') {
                char[] cArr4 = new char[i2];
                a2.MyBillsEntityDataFactory = 0;
                int i11 = $10 + 83;
                $11 = i11 % 128;
                while (true) {
                    int i12 = i11 % 2;
                    if (!(a2.MyBillsEntityDataFactory < i2)) {
                        break;
                    }
                    cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                    a2.MyBillsEntityDataFactory++;
                    i11 = $11 + 7;
                    $10 = i11 % 128;
                }
                cArr2 = cArr4;
            }
            objArr[0] = new String(cArr2);
        } catch (Exception e2) {
            throw e2;
        }
    }
}

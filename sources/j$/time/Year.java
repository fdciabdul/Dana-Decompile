package j$.time;

import j$.lang.Iterable;
import j$.time.chrono.AbstractChronology;
import j$.time.chrono.Era;
import j$.time.chrono.IsoChronology;
import j$.time.format.DateTimeFormatterBuilder;
import j$.time.format.ResolverStyle;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.UnsupportedTemporalTypeException;
import j$.time.temporal.ValueRange;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Locale;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes9.dex */
public final class Year implements Temporal, TemporalAdjuster, Comparable, Serializable {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final long serialVersionUID = -23038383694477807L;
    private final int year;

    /* renamed from: j$.time.Year$1 */
    /* loaded from: classes9.dex */
    public abstract /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[ChronoUnit.YEARS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ChronoUnit.DECADES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ChronoUnit.CENTURIES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ChronoUnit.MILLENNIA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[ChronoUnit.ERAS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[ChronoField.values().length];
            MyBillsEntityDataFactory = iArr2;
            try {
                iArr2[ChronoField.YEAR_OF_ERA.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                MyBillsEntityDataFactory[ChronoField.ERA.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private Year(int i) {
        this.year = i;
    }

    public static Year of(int i) {
        ChronoField.YEAR.checkValidValue(i);
        return new Year(i);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 11, this);
    }

    @Override // j$.time.temporal.TemporalAdjuster
    public final Temporal adjustInto(Temporal temporal) {
        if (((AbstractChronology) Era.CC.BuiltInFictitiousFunctionClassFactory(temporal)).equals(IsoChronology.INSTANCE)) {
            return temporal.with(this.year, ChronoField.YEAR);
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.year - ((Year) obj).year;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Year) && this.year == ((Year) obj).year;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int get(TemporalField temporalField) {
        return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long getLong(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            int i = AnonymousClass1.MyBillsEntityDataFactory[((ChronoField) temporalField).ordinal()];
            if (i == 1) {
                int i2 = this.year;
                if (i2 <= 0) {
                    i2 = 1 - i2;
                }
                return i2;
            } else if (i != 2) {
                if (i == 3) {
                    return this.year <= 0 ? 0 : 1;
                }
                throw new UnsupportedTemporalTypeException(DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory("Unsupported field: ", temporalField));
            } else {
                return this.year;
            }
        }
        return temporalField.getFrom(this);
    }

    public final int hashCode() {
        return this.year;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.YEAR || temporalField == ChronoField.YEAR_OF_ERA || temporalField == ChronoField.ERA : temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // j$.time.temporal.Temporal
    public final Temporal minus(long j, ChronoUnit chronoUnit) {
        return j == Long.MIN_VALUE ? plus(LongCompanionObject.MAX_VALUE, (TemporalUnit) chronoUnit).plus(1L, (TemporalUnit) chronoUnit) : plus(-j, (TemporalUnit) chronoUnit);
    }

    @Override // j$.time.temporal.Temporal
    public final Year plus(long j, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            int i = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[((ChronoUnit) temporalUnit).ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                ChronoField chronoField = ChronoField.ERA;
                                return with(Iterable.CC.BuiltInFictitiousFunctionClassFactory(getLong(chronoField), j), (TemporalField) chronoField);
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append("Unsupported unit: ");
                            sb.append(temporalUnit);
                            throw new UnsupportedTemporalTypeException(sb.toString());
                        }
                        return plusYears(Iterable.CC.getAuthRequestContext(j, 1000L));
                    }
                    return plusYears(Iterable.CC.getAuthRequestContext(j, 100L));
                }
                return plusYears(Iterable.CC.getAuthRequestContext(j, 10L));
            }
            return plusYears(j);
        }
        return (Year) temporalUnit.addTo(this, j);
    }

    public final Year plusYears(long j) {
        return j == 0 ? this : of(ChronoField.YEAR.checkValidIntValue(this.year + j));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object query(TemporalQuery temporalQuery) {
        return temporalQuery == Temporal.CC.getAuthRequestContext() ? IsoChronology.INSTANCE : temporalQuery == Temporal.CC.MyBillsEntityDataFactory() ? ChronoUnit.YEARS : Temporal.CC.BuiltInFictitiousFunctionClassFactory(this, temporalQuery);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final ValueRange range(TemporalField temporalField) {
        if (temporalField == ChronoField.YEAR_OF_ERA) {
            return ValueRange.of(1L, this.year <= 0 ? 1000000000L : 999999999L);
        }
        return Temporal.CC.MyBillsEntityDataFactory(this, temporalField);
    }

    public final String toString() {
        return Integer.toString(this.year);
    }

    @Override // j$.time.temporal.Temporal
    public final long until(Temporal temporal, TemporalUnit temporalUnit) {
        Year of;
        if (temporal instanceof Year) {
            of = (Year) temporal;
        } else if (temporal == null) {
            throw new NullPointerException("temporal");
        } else {
            try {
                if (!IsoChronology.INSTANCE.equals(Era.CC.BuiltInFictitiousFunctionClassFactory(temporal))) {
                    temporal = LocalDate.from(temporal);
                }
                of = of(temporal.get(ChronoField.YEAR));
            } catch (DateTimeException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to obtain Year from TemporalAccessor: ");
                sb.append(temporal);
                sb.append(" of type ");
                sb.append(temporal.getClass().getName());
                throw new DateTimeException(sb.toString(), e);
            }
        }
        if (temporalUnit instanceof ChronoUnit) {
            long j = of.year - this.year;
            int i = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[((ChronoUnit) temporalUnit).ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                ChronoField chronoField = ChronoField.ERA;
                                return of.getLong(chronoField) - getLong(chronoField);
                            }
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Unsupported unit: ");
                            sb2.append(temporalUnit);
                            throw new UnsupportedTemporalTypeException(sb2.toString());
                        }
                        return j / 1000;
                    }
                    return j / 100;
                }
                return j / 10;
            }
            return j;
        }
        return temporalUnit.between(this, of);
    }

    @Override // j$.time.temporal.Temporal
    public final Year with(long j, TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) temporalField;
            chronoField.checkValidValue(j);
            int i = AnonymousClass1.MyBillsEntityDataFactory[chronoField.ordinal()];
            if (i == 1) {
                if (this.year <= 0) {
                    j = 1 - j;
                }
                return of((int) j);
            } else if (i != 2) {
                if (i == 3) {
                    return getLong(ChronoField.ERA) == j ? this : of(1 - this.year);
                }
                throw new UnsupportedTemporalTypeException(DayOfWeek$$ExternalSyntheticOutline0.MyBillsEntityDataFactory("Unsupported field: ", temporalField));
            } else {
                return of((int) j);
            }
        }
        return (Year) temporalField.adjustInto(this, j);
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: with */
    public final Temporal mo3168with(LocalDate localDate) {
        return (Year) Era.CC.getAuthRequestContext(localDate, this);
    }

    public final void writeExternal(DataOutput dataOutput) {
        dataOutput.writeInt(this.year);
    }

    static {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.MyBillsEntityDataFactory(ChronoField.YEAR, 4, 10, 5);
        dateTimeFormatterBuilder.BuiltInFictitiousFunctionClassFactory(Locale.getDefault(), ResolverStyle.SMART, null);
    }
}

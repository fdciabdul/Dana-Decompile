package j$.time.format;

import j$.lang.Iterable;
import j$.time.DateTimeException;
import j$.time.DayOfWeek;
import j$.time.DayOfWeek$$ExternalSyntheticOutline0;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.Chronology;
import j$.time.chrono.Era;
import j$.time.chrono.IsoChronology;
import j$.time.format.DateTimeFormatterBuilder;
import j$.time.format.DateTimeTextProvider;
import j$.time.temporal.ChronoField;
import j$.time.temporal.IsoFields;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.ValueRange;
import j$.time.temporal.WeekFields;
import j$.time.zone.ZoneRulesProvider;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Consumer;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormatSymbols;
import java.text.ParsePosition;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.jvm.internal.CharCompanionObject;

/* loaded from: classes6.dex */
public final class DateTimeFormatterBuilder {
    public static final /* synthetic */ int BuiltInFictitiousFunctionClassFactory = 0;
    static final DateTimeFormatter$$ExternalSyntheticLambda0 KClassImpl$Data$declaredNonStaticMembers$2 = new TemporalQuery() { // from class: j$.time.format.DateTimeFormatter$$ExternalSyntheticLambda0
        @Override // j$.time.temporal.TemporalQuery
        public final Object KClassImpl$Data$declaredNonStaticMembers$2(TemporalAccessor temporalAccessor) {
            int i = DateTimeFormatterBuilder.BuiltInFictitiousFunctionClassFactory;
            ZoneId zoneId = (ZoneId) temporalAccessor.query(Temporal.CC.moveToNextValue());
            if (zoneId == null || (zoneId instanceof ZoneOffset)) {
                return null;
            }
            return zoneId;
        }
    };
    static final HashMap getAuthRequestContext;
    char MyBillsEntityDataFactory;
    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    DateTimeFormatterBuilder PlaceComponentResult;
    private final ArrayList getErrorConfigVersion;
    final DateTimeFormatterBuilder lookAheadTest;
    int moveToNextValue;
    int scheduleImpl;

    /* renamed from: j$.time.format.DateTimeFormatterBuilder$3 */
    /* loaded from: classes6.dex */
    public abstract /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[SignStyle$EnumUnboxingLocalUtility.KClassImpl$Data$declaredNonStaticMembers$2(5).length];
            getAuthRequestContext = iArr;
            try {
                iArr[SignStyle$EnumUnboxingLocalUtility.getAuthRequestContext(5)] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getAuthRequestContext[SignStyle$EnumUnboxingLocalUtility.getAuthRequestContext(2)] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                getAuthRequestContext[SignStyle$EnumUnboxingLocalUtility.getAuthRequestContext(1)] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                getAuthRequestContext[SignStyle$EnumUnboxingLocalUtility.getAuthRequestContext(4)] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class CharLiteralPrinterParser implements DateTimePrinterParser {
        private final char MyBillsEntityDataFactory;

        public CharLiteralPrinterParser(char c) {
            this.MyBillsEntityDataFactory = c;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public final boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            sb.append(this.MyBillsEntityDataFactory);
            return true;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public final int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            if (i == charSequence.length()) {
                return i ^ (-1);
            }
            char charAt = charSequence.charAt(i);
            return (charAt == this.MyBillsEntityDataFactory || (!dateTimeParseContext.KClassImpl$Data$declaredNonStaticMembers$2() && (Character.toUpperCase(charAt) == Character.toUpperCase(this.MyBillsEntityDataFactory) || Character.toLowerCase(charAt) == Character.toLowerCase(this.MyBillsEntityDataFactory)))) ? i + 1 : i ^ (-1);
        }

        public final String toString() {
            if (this.MyBillsEntityDataFactory == '\'') {
                return "''";
            }
            StringBuilder PlaceComponentResult = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("'");
            PlaceComponentResult.append(this.MyBillsEntityDataFactory);
            PlaceComponentResult.append("'");
            return PlaceComponentResult.toString();
        }
    }

    /* loaded from: classes6.dex */
    public interface DateTimePrinterParser {
        boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb);

        int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i);
    }

    /* loaded from: classes6.dex */
    public final class OffsetIdPrinterParser implements DateTimePrinterParser {
        private final String KClassImpl$Data$declaredNonStaticMembers$2;
        private final int getAuthRequestContext;
        static final String[] MyBillsEntityDataFactory = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};
        static final OffsetIdPrinterParser BuiltInFictitiousFunctionClassFactory = new OffsetIdPrinterParser("+HH:MM:ss", "Z");
        static final OffsetIdPrinterParser PlaceComponentResult = new OffsetIdPrinterParser("+HH:MM:ss", "0");

        public OffsetIdPrinterParser(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("pattern");
            }
            int i = 0;
            while (true) {
                String[] strArr = MyBillsEntityDataFactory;
                if (i >= 9) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid zone offset pattern: ");
                    sb.append(str);
                    throw new IllegalArgumentException(sb.toString());
                } else if (strArr[i].equals(str)) {
                    this.getAuthRequestContext = i;
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
                    return;
                } else {
                    i++;
                }
            }
        }

        private boolean getAuthRequestContext(int[] iArr, int i, CharSequence charSequence, boolean z) {
            int i2;
            int i3 = this.getAuthRequestContext;
            if ((i3 + 3) / 2 < i) {
                return false;
            }
            int i4 = iArr[0];
            if (i3 % 2 == 0 && i > 1) {
                int i5 = i4 + 1;
                if (i5 > charSequence.length() || charSequence.charAt(i4) != ':') {
                    return z;
                }
                i4 = i5;
            }
            if (i4 + 2 > charSequence.length()) {
                return z;
            }
            int i6 = i4 + 1;
            char charAt = charSequence.charAt(i4);
            char charAt2 = charSequence.charAt(i6);
            if (charAt < '0' || charAt > '9' || charAt2 < '0' || charAt2 > '9' || (i2 = (charAt2 - '0') + ((charAt - '0') * 10)) < 0 || i2 > 59) {
                return z;
            }
            iArr[i] = i2;
            iArr[0] = i6 + 1;
            return false;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public final boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long PlaceComponentResult2 = dateTimePrintContext.PlaceComponentResult(ChronoField.OFFSET_SECONDS);
            if (PlaceComponentResult2 == null) {
                return false;
            }
            int BuiltInFictitiousFunctionClassFactory2 = Iterable.CC.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult2.longValue());
            if (BuiltInFictitiousFunctionClassFactory2 != 0) {
                int abs = Math.abs((BuiltInFictitiousFunctionClassFactory2 / 3600) % 100);
                int abs2 = Math.abs((BuiltInFictitiousFunctionClassFactory2 / 60) % 60);
                int abs3 = Math.abs(BuiltInFictitiousFunctionClassFactory2 % 60);
                int length = sb.length();
                sb.append(BuiltInFictitiousFunctionClassFactory2 < 0 ? "-" : "+");
                sb.append((char) ((abs / 10) + 48));
                sb.append((char) ((abs % 10) + 48));
                int i = this.getAuthRequestContext;
                if (i >= 3 || (i > 0 && abs2 > 0)) {
                    sb.append(i % 2 == 0 ? ":" : "");
                    sb.append((char) ((abs2 / 10) + 48));
                    sb.append((char) ((abs2 % 10) + 48));
                    abs += abs2;
                    int i2 = this.getAuthRequestContext;
                    if (i2 >= 7 || (i2 >= 5 && abs3 > 0)) {
                        sb.append(i2 % 2 == 0 ? ":" : "");
                        sb.append((char) ((abs3 / 10) + 48));
                        sb.append((char) ((abs3 % 10) + 48));
                        abs += abs3;
                    }
                }
                if (abs != 0) {
                    return true;
                }
                sb.setLength(length);
            }
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:49:0x0031, code lost:
        
            if (r18.getAuthRequestContext(r19, r20, r17.KClassImpl$Data$declaredNonStaticMembers$2, 0, r9) == false) goto L50;
         */
        /* JADX WARN: Removed duplicated region for block: B:70:0x006d  */
        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final int parse(j$.time.format.DateTimeParseContext r18, java.lang.CharSequence r19, int r20) {
            /*
                r17 = this;
                r0 = r17
                r7 = r19
                r8 = r20
                int r1 = r19.length()
                java.lang.String r2 = r0.KClassImpl$Data$declaredNonStaticMembers$2
                int r9 = r2.length()
                r10 = 0
                r12 = -1
                if (r9 != 0) goto L1e
                if (r8 != r1) goto L33
                j$.time.temporal.ChronoField r1 = j$.time.temporal.ChronoField.OFFSET_SECONDS
                r2 = r1
                r6 = r8
                r3 = r10
                goto L99
            L1e:
                if (r8 != r1) goto L23
                r1 = r8 ^ (-1)
                return r1
            L23:
                java.lang.String r4 = r0.KClassImpl$Data$declaredNonStaticMembers$2
                r5 = 0
                r1 = r18
                r2 = r19
                r3 = r20
                r6 = r9
                boolean r1 = r1.getAuthRequestContext(r2, r3, r4, r5, r6)
                if (r1 != 0) goto L92
            L33:
                char r1 = r19.charAt(r20)
                r2 = 43
                r3 = 45
                if (r1 == r2) goto L3f
                if (r1 != r3) goto L8c
            L3f:
                r2 = 1
                if (r1 != r3) goto L44
                r1 = -1
                goto L45
            L44:
                r1 = 1
            L45:
                r3 = 4
                int[] r3 = new int[r3]
                int r4 = r8 + 1
                r5 = 0
                r3[r5] = r4
                boolean r4 = r0.getAuthRequestContext(r3, r2, r7, r2)
                r6 = 2
                r13 = 3
                if (r4 != 0) goto L6a
                int r4 = r0.getAuthRequestContext
                if (r4 < r13) goto L5b
                r4 = 1
                goto L5c
            L5b:
                r4 = 0
            L5c:
                boolean r4 = r0.getAuthRequestContext(r3, r6, r7, r4)
                if (r4 != 0) goto L6a
                boolean r4 = r0.getAuthRequestContext(r3, r13, r7, r5)
                if (r4 != 0) goto L6a
                r4 = 0
                goto L6b
            L6a:
                r4 = 1
            L6b:
                if (r4 != 0) goto L8c
                long r9 = (long) r1
                r1 = r3[r2]
                long r1 = (long) r1
                r4 = r3[r6]
                long r6 = (long) r4
                r4 = r3[r13]
                long r11 = (long) r4
                j$.time.temporal.ChronoField r4 = j$.time.temporal.ChronoField.OFFSET_SECONDS
                r3 = r3[r5]
                r13 = 60
                long r6 = r6 * r13
                r13 = 3600(0xe10, double:1.7786E-320)
                long r1 = r1 * r13
                long r6 = r6 + r1
                long r6 = r6 + r11
                long r6 = r6 * r9
                r2 = r4
                r15 = r6
                r6 = r3
                r3 = r15
                goto L99
            L8c:
                if (r9 != 0) goto L8f
                goto L92
            L8f:
                r1 = r8 ^ (-1)
                return r1
            L92:
                j$.time.temporal.ChronoField r1 = j$.time.temporal.ChronoField.OFFSET_SECONDS
                int r2 = r8 + r9
                r6 = r2
                r3 = r10
                r2 = r1
            L99:
                r1 = r18
                r5 = r20
                int r1 = r1.KClassImpl$Data$declaredNonStaticMembers$2(r2, r3, r5, r6)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.time.format.DateTimeFormatterBuilder.OffsetIdPrinterParser.parse(j$.time.format.DateTimeParseContext, java.lang.CharSequence, int):int");
        }

        public final String toString() {
            String replace = this.KClassImpl$Data$declaredNonStaticMembers$2.replace("'", "''");
            StringBuilder PlaceComponentResult2 = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("Offset(");
            PlaceComponentResult2.append(MyBillsEntityDataFactory[this.getAuthRequestContext]);
            PlaceComponentResult2.append(",'");
            PlaceComponentResult2.append(replace);
            PlaceComponentResult2.append("')");
            return PlaceComponentResult2.toString();
        }
    }

    /* loaded from: classes6.dex */
    public final class PadPrinterParserDecorator implements DateTimePrinterParser {
        private final int KClassImpl$Data$declaredNonStaticMembers$2;
        private final char PlaceComponentResult;
        private final DateTimePrinterParser getAuthRequestContext;

        PadPrinterParserDecorator(DateTimePrinterParser dateTimePrinterParser, int i, char c) {
            this.getAuthRequestContext = dateTimePrinterParser;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.PlaceComponentResult = c;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public final boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            int length = sb.length();
            if (this.getAuthRequestContext.format(dateTimePrintContext, sb)) {
                int length2 = sb.length() - length;
                if (length2 <= this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    for (int i = 0; i < this.KClassImpl$Data$declaredNonStaticMembers$2 - length2; i++) {
                        sb.insert(length, this.PlaceComponentResult);
                    }
                    return true;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Cannot print as output of ");
                sb2.append(length2);
                sb2.append(" characters exceeds pad width of ");
                sb2.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
                throw new DateTimeException(sb2.toString());
            }
            return false;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public final int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            boolean MyBillsEntityDataFactory = dateTimeParseContext.MyBillsEntityDataFactory();
            if (i <= charSequence.length()) {
                if (i == charSequence.length()) {
                    return i ^ (-1);
                }
                int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2 + i;
                if (i2 > charSequence.length()) {
                    if (MyBillsEntityDataFactory) {
                        return i ^ (-1);
                    }
                    i2 = charSequence.length();
                }
                int i3 = i;
                while (i3 < i2 && dateTimeParseContext.BuiltInFictitiousFunctionClassFactory(charSequence.charAt(i3), this.PlaceComponentResult)) {
                    i3++;
                }
                int parse = this.getAuthRequestContext.parse(dateTimeParseContext, charSequence.subSequence(0, i2), i3);
                return (parse == i2 || !MyBillsEntityDataFactory) ? parse : (i + i3) ^ (-1);
            }
            throw new IndexOutOfBoundsException();
        }

        public final String toString() {
            String obj;
            StringBuilder PlaceComponentResult = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("Pad(");
            PlaceComponentResult.append(this.getAuthRequestContext);
            PlaceComponentResult.append(",");
            PlaceComponentResult.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            if (this.PlaceComponentResult == ' ') {
                obj = ")";
            } else {
                StringBuilder PlaceComponentResult2 = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult(",'");
                PlaceComponentResult2.append(this.PlaceComponentResult);
                PlaceComponentResult2.append("')");
                obj = PlaceComponentResult2.toString();
            }
            PlaceComponentResult.append(obj);
            return PlaceComponentResult.toString();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [j$.time.format.DateTimeFormatter$$ExternalSyntheticLambda0] */
    static {
        HashMap hashMap = new HashMap();
        getAuthRequestContext = hashMap;
        hashMap.put('G', ChronoField.ERA);
        hashMap.put('y', ChronoField.YEAR_OF_ERA);
        hashMap.put('u', ChronoField.YEAR);
        TemporalField temporalField = IsoFields.BuiltInFictitiousFunctionClassFactory;
        hashMap.put('Q', temporalField);
        hashMap.put('q', temporalField);
        ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
        hashMap.put('M', chronoField);
        hashMap.put('L', chronoField);
        hashMap.put('D', ChronoField.DAY_OF_YEAR);
        hashMap.put('d', ChronoField.DAY_OF_MONTH);
        hashMap.put('F', ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        ChronoField chronoField2 = ChronoField.DAY_OF_WEEK;
        hashMap.put('E', chronoField2);
        hashMap.put('c', chronoField2);
        hashMap.put('e', chronoField2);
        hashMap.put('a', ChronoField.AMPM_OF_DAY);
        hashMap.put('H', ChronoField.HOUR_OF_DAY);
        hashMap.put('k', ChronoField.CLOCK_HOUR_OF_DAY);
        hashMap.put('K', ChronoField.HOUR_OF_AMPM);
        hashMap.put('h', ChronoField.CLOCK_HOUR_OF_AMPM);
        hashMap.put('m', ChronoField.MINUTE_OF_HOUR);
        hashMap.put('s', ChronoField.SECOND_OF_MINUTE);
        ChronoField chronoField3 = ChronoField.NANO_OF_SECOND;
        hashMap.put('S', chronoField3);
        hashMap.put('A', ChronoField.MILLI_OF_DAY);
        hashMap.put('n', chronoField3);
        hashMap.put('N', ChronoField.NANO_OF_DAY);
    }

    public DateTimeFormatterBuilder() {
        this.PlaceComponentResult = this;
        this.getErrorConfigVersion = new ArrayList();
        this.moveToNextValue = -1;
        this.lookAheadTest = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    }

    public DateTimeFormatterBuilder(DateTimeFormatterBuilder dateTimeFormatterBuilder) {
        this.PlaceComponentResult = this;
        this.getErrorConfigVersion = new ArrayList();
        this.moveToNextValue = -1;
        this.lookAheadTest = dateTimeFormatterBuilder;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
    }

    public final int BuiltInFictitiousFunctionClassFactory(DateTimePrinterParser dateTimePrinterParser) {
        if (dateTimePrinterParser != null) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder = this.PlaceComponentResult;
            int i = dateTimeFormatterBuilder.scheduleImpl;
            if (i > 0) {
                PadPrinterParserDecorator padPrinterParserDecorator = new PadPrinterParserDecorator(dateTimePrinterParser, i, dateTimeFormatterBuilder.MyBillsEntityDataFactory);
                dateTimeFormatterBuilder.scheduleImpl = 0;
                dateTimeFormatterBuilder.MyBillsEntityDataFactory = (char) 0;
                dateTimePrinterParser = padPrinterParserDecorator;
            }
            dateTimeFormatterBuilder.getErrorConfigVersion.add(dateTimePrinterParser);
            this.PlaceComponentResult.moveToNextValue = -1;
            return r5.getErrorConfigVersion.size() - 1;
        }
        throw new NullPointerException("pp");
    }

    public final DateTimeFormatter BuiltInFictitiousFunctionClassFactory(Locale locale, ResolverStyle resolverStyle, IsoChronology isoChronology) {
        if (locale != null) {
            while (this.PlaceComponentResult.lookAheadTest != null) {
                getAuthRequestContext();
            }
            CompositePrinterParser compositePrinterParser = new CompositePrinterParser(this.getErrorConfigVersion, false);
            DecimalStyle decimalStyle = DecimalStyle.getAuthRequestContext;
            return new DateTimeFormatter(compositePrinterParser, locale, resolverStyle, isoChronology);
        }
        throw new NullPointerException("locale");
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(NumberPrinterParser numberPrinterParser) {
        NumberPrinterParser KClassImpl$Data$declaredNonStaticMembers$22;
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.PlaceComponentResult;
        int i = dateTimeFormatterBuilder.moveToNextValue;
        if (i < 0) {
            dateTimeFormatterBuilder.moveToNextValue = BuiltInFictitiousFunctionClassFactory(numberPrinterParser);
            return;
        }
        NumberPrinterParser numberPrinterParser2 = (NumberPrinterParser) dateTimeFormatterBuilder.getErrorConfigVersion.get(i);
        if (numberPrinterParser.MyBillsEntityDataFactory == numberPrinterParser.KClassImpl$Data$declaredNonStaticMembers$2 && numberPrinterParser.NetworkUserEntityData$$ExternalSyntheticLambda0 == 4) {
            KClassImpl$Data$declaredNonStaticMembers$22 = numberPrinterParser2.BuiltInFictitiousFunctionClassFactory(numberPrinterParser.KClassImpl$Data$declaredNonStaticMembers$2);
            BuiltInFictitiousFunctionClassFactory(numberPrinterParser.KClassImpl$Data$declaredNonStaticMembers$2());
            this.PlaceComponentResult.moveToNextValue = i;
        } else {
            KClassImpl$Data$declaredNonStaticMembers$22 = numberPrinterParser2.KClassImpl$Data$declaredNonStaticMembers$2();
            this.PlaceComponentResult.moveToNextValue = BuiltInFictitiousFunctionClassFactory(numberPrinterParser);
        }
        this.PlaceComponentResult.getErrorConfigVersion.set(i, KClassImpl$Data$declaredNonStaticMembers$22);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(ChronoField chronoField, HashMap hashMap) {
        if (chronoField == null) {
            throw new NullPointerException("field");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(hashMap);
        TextStyle textStyle = TextStyle.FULL;
        final DateTimeTextProvider.LocaleStore localeStore = new DateTimeTextProvider.LocaleStore(Collections.singletonMap(textStyle, linkedHashMap));
        BuiltInFictitiousFunctionClassFactory(new TextPrinterParser(chronoField, textStyle, new DateTimeTextProvider() { // from class: j$.time.format.DateTimeFormatterBuilder.1
            @Override // j$.time.format.DateTimeTextProvider
            public final String BuiltInFictitiousFunctionClassFactory(TemporalField temporalField, long j, TextStyle textStyle2, Locale locale) {
                return localeStore.getAuthRequestContext(j, textStyle2);
            }

            @Override // j$.time.format.DateTimeTextProvider
            public final Iterator PlaceComponentResult(TemporalField temporalField, TextStyle textStyle2, Locale locale) {
                List list = (List) localeStore.KClassImpl$Data$declaredNonStaticMembers$2.get(textStyle2);
                if (list != null) {
                    return list.iterator();
                }
                return null;
            }
        }));
    }

    public final DateTimeFormatterBuilder MyBillsEntityDataFactory(TemporalField temporalField, int i, int i2, int i3) {
        if (i == i2 && i3 == 4) {
            MyBillsEntityDataFactory(temporalField, i2);
            return this;
        } else if (temporalField != null) {
            if (i3 != 0) {
                if (i <= 0 || i > 19) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("The minimum width must be from 1 to 19 inclusive but was ");
                    sb.append(i);
                    throw new IllegalArgumentException(sb.toString());
                } else if (i2 <= 0 || i2 > 19) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("The maximum width must be from 1 to 19 inclusive but was ");
                    sb2.append(i2);
                    throw new IllegalArgumentException(sb2.toString());
                } else if (i2 >= i) {
                    KClassImpl$Data$declaredNonStaticMembers$2(new NumberPrinterParser(temporalField, i, i2, i3));
                    return this;
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("The maximum width must exceed or equal the minimum width but ");
                    sb3.append(i2);
                    sb3.append(" < ");
                    sb3.append(i);
                    throw new IllegalArgumentException(sb3.toString());
                }
            }
            throw new NullPointerException("signStyle");
        } else {
            throw new NullPointerException("field");
        }
    }

    public final void MyBillsEntityDataFactory(TemporalField temporalField, int i) {
        if (temporalField == null) {
            throw new NullPointerException("field");
        }
        if (i > 0 && i <= 19) {
            KClassImpl$Data$declaredNonStaticMembers$2(new NumberPrinterParser(temporalField, i, i, 4));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The width must be from 1 to 19 inclusive but was ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public final void PlaceComponentResult(String str) {
        if (str == null) {
            throw new NullPointerException("literal");
        }
        if (str.length() > 0) {
            BuiltInFictitiousFunctionClassFactory(str.length() == 1 ? new CharLiteralPrinterParser(str.charAt(0)) : new StringLiteralPrinterParser(0, str));
        }
    }

    public final void getAuthRequestContext() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.PlaceComponentResult;
        if (dateTimeFormatterBuilder.lookAheadTest == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        if (dateTimeFormatterBuilder.getErrorConfigVersion.size() <= 0) {
            this.PlaceComponentResult = this.PlaceComponentResult.lookAheadTest;
            return;
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.PlaceComponentResult;
        CompositePrinterParser compositePrinterParser = new CompositePrinterParser(dateTimeFormatterBuilder2.getErrorConfigVersion, dateTimeFormatterBuilder2.NetworkUserEntityData$$ExternalSyntheticLambda0);
        this.PlaceComponentResult = this.PlaceComponentResult.lookAheadTest;
        BuiltInFictitiousFunctionClassFactory(compositePrinterParser);
    }

    /* loaded from: classes6.dex */
    public final class CompositePrinterParser implements DateTimePrinterParser {
        final boolean KClassImpl$Data$declaredNonStaticMembers$2;
        final DateTimePrinterParser[] getAuthRequestContext;

        CompositePrinterParser(ArrayList arrayList, boolean z) {
            this((DateTimePrinterParser[]) arrayList.toArray(new DateTimePrinterParser[arrayList.size()]), z);
        }

        public CompositePrinterParser(DateTimePrinterParser[] dateTimePrinterParserArr, boolean z) {
            this.getAuthRequestContext = dateTimePrinterParserArr;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.getAuthRequestContext != null) {
                sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2 ? "[" : "(");
                for (DateTimePrinterParser dateTimePrinterParser : this.getAuthRequestContext) {
                    sb.append(dateTimePrinterParser);
                }
                sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2 ? "]" : ")");
            }
            return sb.toString();
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public final boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            int length = sb.length();
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                dateTimePrintContext.MyBillsEntityDataFactory++;
            }
            try {
                for (DateTimePrinterParser dateTimePrinterParser : this.getAuthRequestContext) {
                    if (!dateTimePrinterParser.format(dateTimePrintContext, sb)) {
                        sb.setLength(length);
                        return true;
                    }
                }
                if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    dateTimePrintContext.MyBillsEntityDataFactory--;
                }
                return true;
            } finally {
                if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    dateTimePrintContext.MyBillsEntityDataFactory--;
                }
            }
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public final int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            if (!this.KClassImpl$Data$declaredNonStaticMembers$2) {
                for (DateTimePrinterParser dateTimePrinterParser : this.getAuthRequestContext) {
                    i = dateTimePrinterParser.parse(dateTimeParseContext, charSequence, i);
                    if (i < 0) {
                        break;
                    }
                }
                return i;
            }
            ArrayList arrayList = dateTimeParseContext.MyBillsEntityDataFactory;
            ArrayList arrayList2 = dateTimeParseContext.MyBillsEntityDataFactory;
            Parsed parsed = (Parsed) arrayList2.get(arrayList2.size() - 1);
            Parsed parsed2 = new Parsed();
            parsed2.PlaceComponentResult.putAll(parsed.PlaceComponentResult);
            parsed2.getErrorConfigVersion = parsed.getErrorConfigVersion;
            parsed2.BuiltInFictitiousFunctionClassFactory = parsed.BuiltInFictitiousFunctionClassFactory;
            arrayList.add(parsed2);
            int i2 = i;
            for (DateTimePrinterParser dateTimePrinterParser2 : this.getAuthRequestContext) {
                i2 = dateTimePrinterParser2.parse(dateTimeParseContext, charSequence, i2);
                if (i2 < 0) {
                    dateTimeParseContext.getAuthRequestContext(false);
                    return i;
                }
            }
            dateTimeParseContext.getAuthRequestContext(true);
            return i2;
        }
    }

    /* loaded from: classes6.dex */
    public final class FractionPrinterParser implements DateTimePrinterParser {
        private final boolean BuiltInFictitiousFunctionClassFactory;
        private final int KClassImpl$Data$declaredNonStaticMembers$2;
        private final TemporalField MyBillsEntityDataFactory;
        private final int getAuthRequestContext;

        public FractionPrinterParser(ChronoField chronoField, int i, int i2, boolean z) {
            if (chronoField == null) {
                throw new NullPointerException("field");
            }
            if (!chronoField.range().isFixed()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Field must have a fixed set of values: ");
                sb.append(chronoField);
                throw new IllegalArgumentException(sb.toString());
            } else if (i < 0 || i > 9) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Minimum width must be from 0 to 9 inclusive but was ");
                sb2.append(i);
                throw new IllegalArgumentException(sb2.toString());
            } else if (i2 <= 0 || i2 > 9) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Maximum width must be from 1 to 9 inclusive but was ");
                sb3.append(i2);
                throw new IllegalArgumentException(sb3.toString());
            } else if (i2 >= i) {
                this.MyBillsEntityDataFactory = chronoField;
                this.getAuthRequestContext = i;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
                this.BuiltInFictitiousFunctionClassFactory = z;
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Maximum width must exceed or equal the minimum width but ");
                sb4.append(i2);
                sb4.append(" < ");
                sb4.append(i);
                throw new IllegalArgumentException(sb4.toString());
            }
        }

        public final String toString() {
            String str = this.BuiltInFictitiousFunctionClassFactory ? ",DecimalPoint" : "";
            StringBuilder PlaceComponentResult = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("Fraction(");
            PlaceComponentResult.append(this.MyBillsEntityDataFactory);
            PlaceComponentResult.append(",");
            PlaceComponentResult.append(this.getAuthRequestContext);
            PlaceComponentResult.append(",");
            PlaceComponentResult.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            PlaceComponentResult.append(str);
            PlaceComponentResult.append(")");
            return PlaceComponentResult.toString();
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public final boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long PlaceComponentResult = dateTimePrintContext.PlaceComponentResult(this.MyBillsEntityDataFactory);
            if (PlaceComponentResult == null) {
                return false;
            }
            DecimalStyle decimalStyle = dateTimePrintContext.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
            long longValue = PlaceComponentResult.longValue();
            ValueRange range = this.MyBillsEntityDataFactory.range();
            range.checkValidValue(longValue, this.MyBillsEntityDataFactory);
            BigDecimal valueOf = BigDecimal.valueOf(range.getMinimum());
            BigDecimal divide = BigDecimal.valueOf(longValue).subtract(valueOf).divide(BigDecimal.valueOf(range.getMaximum()).subtract(valueOf).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
            BigDecimal stripTrailingZeros = divide.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : divide.stripTrailingZeros();
            if (stripTrailingZeros.scale() != 0) {
                String substring = stripTrailingZeros.setScale(Math.min(Math.max(stripTrailingZeros.scale(), this.getAuthRequestContext), this.KClassImpl$Data$declaredNonStaticMembers$2), RoundingMode.FLOOR).toPlainString().substring(2);
                if (this.BuiltInFictitiousFunctionClassFactory) {
                    sb.append('.');
                }
                sb.append(substring);
                return true;
            } else if (this.getAuthRequestContext > 0) {
                if (this.BuiltInFictitiousFunctionClassFactory) {
                    sb.append('.');
                }
                for (int i = 0; i < this.getAuthRequestContext; i++) {
                    sb.append('0');
                }
                return true;
            } else {
                return true;
            }
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public final int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            int i2;
            int i3 = dateTimeParseContext.MyBillsEntityDataFactory() ? this.getAuthRequestContext : 0;
            int i4 = dateTimeParseContext.MyBillsEntityDataFactory() ? this.KClassImpl$Data$declaredNonStaticMembers$2 : 9;
            int length = charSequence.length();
            if (i == length) {
                return i3 > 0 ? i ^ (-1) : i;
            }
            if (this.BuiltInFictitiousFunctionClassFactory) {
                char charAt = charSequence.charAt(i);
                DecimalStyle decimalStyle = dateTimeParseContext.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
                if (charAt != '.') {
                    return i3 > 0 ? i ^ (-1) : i;
                }
                i++;
            }
            int i5 = i;
            int i6 = i3 + i5;
            if (i6 > length) {
                return i5 ^ (-1);
            }
            int min = Math.min(i4 + i5, length);
            int i7 = i5;
            int i8 = 0;
            while (true) {
                if (i7 >= min) {
                    i2 = i7;
                    break;
                }
                int i9 = i7 + 1;
                char charAt2 = charSequence.charAt(i7);
                DecimalStyle decimalStyle2 = dateTimeParseContext.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
                int KClassImpl$Data$declaredNonStaticMembers$2 = DecimalStyle.KClassImpl$Data$declaredNonStaticMembers$2(charAt2);
                if (KClassImpl$Data$declaredNonStaticMembers$2 >= 0) {
                    i8 = (i8 * 10) + KClassImpl$Data$declaredNonStaticMembers$2;
                    i7 = i9;
                } else if (i9 < i6) {
                    return i5 ^ (-1);
                } else {
                    i2 = i9 - 1;
                }
            }
            BigDecimal movePointLeft = new BigDecimal(i8).movePointLeft(i2 - i5);
            ValueRange range = this.MyBillsEntityDataFactory.range();
            BigDecimal valueOf = BigDecimal.valueOf(range.getMinimum());
            return dateTimeParseContext.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, movePointLeft.multiply(BigDecimal.valueOf(range.getMaximum()).subtract(valueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(valueOf).longValueExact(), i5, i2);
        }
    }

    /* loaded from: classes6.dex */
    final class InstantPrinterParser implements DateTimePrinterParser {
        public final String toString() {
            return "Instant()";
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public final boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long PlaceComponentResult = dateTimePrintContext.PlaceComponentResult(ChronoField.INSTANT_SECONDS);
            TemporalAccessor temporalAccessor = dateTimePrintContext.PlaceComponentResult;
            ChronoField chronoField = ChronoField.NANO_OF_SECOND;
            Long valueOf = temporalAccessor.isSupported(chronoField) ? Long.valueOf(dateTimePrintContext.PlaceComponentResult.getLong(chronoField)) : null;
            int i = 0;
            if (PlaceComponentResult == null) {
                return false;
            }
            long longValue = PlaceComponentResult.longValue();
            int checkValidIntValue = chronoField.checkValidIntValue(valueOf != null ? valueOf.longValue() : 0L);
            if (longValue >= -62167219200L) {
                long j = (longValue - 315569520000L) + 62167219200L;
                long PlaceComponentResult2 = Iterable.CC.PlaceComponentResult(j, 315569520000L) + 1;
                LocalDateTime ofEpochSecond = LocalDateTime.ofEpochSecond(Iterable.CC.KClassImpl$Data$declaredNonStaticMembers$2(j, 315569520000L) - 62167219200L, 0, ZoneOffset.UTC);
                if (PlaceComponentResult2 > 0) {
                    sb.append('+');
                    sb.append(PlaceComponentResult2);
                }
                sb.append(ofEpochSecond);
                if (ofEpochSecond.getSecond() == 0) {
                    sb.append(":00");
                }
            } else {
                long j2 = longValue + 62167219200L;
                long j3 = j2 / 315569520000L;
                long j4 = j2 % 315569520000L;
                LocalDateTime ofEpochSecond2 = LocalDateTime.ofEpochSecond(j4 - 62167219200L, 0, ZoneOffset.UTC);
                int length = sb.length();
                sb.append(ofEpochSecond2);
                if (ofEpochSecond2.getSecond() == 0) {
                    sb.append(":00");
                }
                if (j3 < 0) {
                    if (ofEpochSecond2.getYear() == -10000) {
                        sb.replace(length, length + 2, Long.toString(j3 - 1));
                    } else if (j4 == 0) {
                        sb.insert(length, j3);
                    } else {
                        sb.insert(length + 1, Math.abs(j3));
                    }
                }
            }
            if (checkValidIntValue > 0) {
                sb.append('.');
                int i2 = 100000000;
                while (true) {
                    if (checkValidIntValue <= 0 && i % 3 == 0 && i >= -2) {
                        break;
                    }
                    int i3 = checkValidIntValue / i2;
                    sb.append((char) (i3 + 48));
                    checkValidIntValue -= i3 * i2;
                    i2 /= 10;
                    i++;
                }
            }
            sb.append('Z');
            return true;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public final int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            int i2;
            int i3;
            DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.MyBillsEntityDataFactory;
            if (dateTimeFormatter != null) {
                CompositePrinterParser compositePrinterParser = dateTimeFormatter.moveToNextValue;
                int i4 = 0;
                if (compositePrinterParser.KClassImpl$Data$declaredNonStaticMembers$2) {
                    compositePrinterParser = new CompositePrinterParser(compositePrinterParser.getAuthRequestContext, false);
                }
                dateTimeFormatterBuilder.BuiltInFictitiousFunctionClassFactory(compositePrinterParser);
                dateTimeFormatterBuilder.BuiltInFictitiousFunctionClassFactory(new CharLiteralPrinterParser('T'));
                ChronoField chronoField = ChronoField.HOUR_OF_DAY;
                dateTimeFormatterBuilder.MyBillsEntityDataFactory(chronoField, 2);
                dateTimeFormatterBuilder.BuiltInFictitiousFunctionClassFactory(new CharLiteralPrinterParser(':'));
                ChronoField chronoField2 = ChronoField.MINUTE_OF_HOUR;
                dateTimeFormatterBuilder.MyBillsEntityDataFactory(chronoField2, 2);
                dateTimeFormatterBuilder.BuiltInFictitiousFunctionClassFactory(new CharLiteralPrinterParser(':'));
                ChronoField chronoField3 = ChronoField.SECOND_OF_MINUTE;
                dateTimeFormatterBuilder.MyBillsEntityDataFactory(chronoField3, 2);
                ChronoField chronoField4 = ChronoField.NANO_OF_SECOND;
                dateTimeFormatterBuilder.BuiltInFictitiousFunctionClassFactory(new FractionPrinterParser(chronoField4, 0, 9, true));
                dateTimeFormatterBuilder.BuiltInFictitiousFunctionClassFactory(new CharLiteralPrinterParser('Z'));
                CompositePrinterParser compositePrinterParser2 = dateTimeFormatterBuilder.BuiltInFictitiousFunctionClassFactory(Locale.getDefault(), ResolverStyle.SMART, null).moveToNextValue;
                if (compositePrinterParser2.KClassImpl$Data$declaredNonStaticMembers$2) {
                    compositePrinterParser2 = new CompositePrinterParser(compositePrinterParser2.getAuthRequestContext, false);
                }
                DateTimeParseContext dateTimeParseContext2 = new DateTimeParseContext(dateTimeParseContext.BuiltInFictitiousFunctionClassFactory);
                dateTimeParseContext2.KClassImpl$Data$declaredNonStaticMembers$2 = dateTimeParseContext.KClassImpl$Data$declaredNonStaticMembers$2;
                dateTimeParseContext2.PlaceComponentResult = dateTimeParseContext.PlaceComponentResult;
                int parse = compositePrinterParser2.parse(dateTimeParseContext2, charSequence, i);
                if (parse < 0) {
                    return parse;
                }
                ChronoField chronoField5 = ChronoField.YEAR;
                ArrayList arrayList = dateTimeParseContext2.MyBillsEntityDataFactory;
                long longValue = ((Long) ((Parsed) arrayList.get(arrayList.size() - 1)).PlaceComponentResult.get(chronoField5)).longValue();
                ChronoField chronoField6 = ChronoField.MONTH_OF_YEAR;
                ArrayList arrayList2 = dateTimeParseContext2.MyBillsEntityDataFactory;
                int intValue = ((Long) ((Parsed) arrayList2.get(arrayList2.size() - 1)).PlaceComponentResult.get(chronoField6)).intValue();
                ChronoField chronoField7 = ChronoField.DAY_OF_MONTH;
                ArrayList arrayList3 = dateTimeParseContext2.MyBillsEntityDataFactory;
                int intValue2 = ((Long) ((Parsed) arrayList3.get(arrayList3.size() - 1)).PlaceComponentResult.get(chronoField7)).intValue();
                ArrayList arrayList4 = dateTimeParseContext2.MyBillsEntityDataFactory;
                int intValue3 = ((Long) ((Parsed) arrayList4.get(arrayList4.size() - 1)).PlaceComponentResult.get(chronoField)).intValue();
                ArrayList arrayList5 = dateTimeParseContext2.MyBillsEntityDataFactory;
                int intValue4 = ((Long) ((Parsed) arrayList5.get(arrayList5.size() - 1)).PlaceComponentResult.get(chronoField2)).intValue();
                ArrayList arrayList6 = dateTimeParseContext2.MyBillsEntityDataFactory;
                Long l = (Long) ((Parsed) arrayList6.get(arrayList6.size() - 1)).PlaceComponentResult.get(chronoField3);
                ArrayList arrayList7 = dateTimeParseContext2.MyBillsEntityDataFactory;
                Long l2 = (Long) ((Parsed) arrayList7.get(arrayList7.size() - 1)).PlaceComponentResult.get(chronoField4);
                int intValue5 = l != null ? l.intValue() : 0;
                int intValue6 = l2 != null ? l2.intValue() : 0;
                if (intValue3 == 24 && intValue4 == 0 && intValue5 == 0 && intValue6 == 0) {
                    i3 = intValue5;
                    i4 = 1;
                    i2 = 0;
                } else if (intValue3 == 23 && intValue4 == 59 && intValue5 == 60) {
                    ArrayList arrayList8 = dateTimeParseContext.MyBillsEntityDataFactory;
                    Parsed parsed = (Parsed) arrayList8.get(arrayList8.size() - 1);
                    i2 = intValue3;
                    i3 = 59;
                } else {
                    i2 = intValue3;
                    i3 = intValue5;
                }
                try {
                    return dateTimeParseContext.KClassImpl$Data$declaredNonStaticMembers$2(chronoField4, intValue6, i, dateTimeParseContext.KClassImpl$Data$declaredNonStaticMembers$2(ChronoField.INSTANT_SECONDS, Iterable.CC.getAuthRequestContext(longValue / 10000, 315569520000L) + Era.CC.getAuthRequestContext(LocalDateTime.of(((int) longValue) % 10000, intValue, intValue2, i2, intValue4, i3).plusDays(i4), ZoneOffset.UTC), i, parse));
                } catch (RuntimeException unused) {
                    return i ^ (-1);
                }
            }
            throw new NullPointerException("formatter");
        }
    }

    /* loaded from: classes6.dex */
    public class NumberPrinterParser implements DateTimePrinterParser {
        static final long[] getAuthRequestContext = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L};
        final TemporalField BuiltInFictitiousFunctionClassFactory;
        final int KClassImpl$Data$declaredNonStaticMembers$2;
        final int MyBillsEntityDataFactory;
        private final int NetworkUserEntityData$$ExternalSyntheticLambda0;
        final int PlaceComponentResult;

        public NumberPrinterParser(TemporalField temporalField, int i, int i2, int i3) {
            this.BuiltInFictitiousFunctionClassFactory = temporalField;
            this.MyBillsEntityDataFactory = i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i3;
            this.PlaceComponentResult = 0;
        }

        protected NumberPrinterParser(TemporalField temporalField, int i, int i2, int i3, int i4) {
            this.BuiltInFictitiousFunctionClassFactory = temporalField;
            this.MyBillsEntityDataFactory = i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i3;
            this.PlaceComponentResult = i4;
        }

        int BuiltInFictitiousFunctionClassFactory(DateTimeParseContext dateTimeParseContext, long j, int i, int i2) {
            return dateTimeParseContext.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, j, i, i2);
        }

        NumberPrinterParser BuiltInFictitiousFunctionClassFactory(int i) {
            return new NumberPrinterParser(this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.PlaceComponentResult + i);
        }

        NumberPrinterParser KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.PlaceComponentResult == -1 ? this : new NumberPrinterParser(this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda0, -1);
        }

        long MyBillsEntityDataFactory(DateTimePrintContext dateTimePrintContext, long j) {
            return j;
        }

        boolean getAuthRequestContext(DateTimeParseContext dateTimeParseContext) {
            int i = this.PlaceComponentResult;
            return i == -1 || (i > 0 && this.MyBillsEntityDataFactory == this.KClassImpl$Data$declaredNonStaticMembers$2 && this.NetworkUserEntityData$$ExternalSyntheticLambda0 == 4);
        }

        public String toString() {
            StringBuilder PlaceComponentResult;
            int i = this.MyBillsEntityDataFactory;
            if (i == 1 && this.KClassImpl$Data$declaredNonStaticMembers$2 == 19 && this.NetworkUserEntityData$$ExternalSyntheticLambda0 == 1) {
                PlaceComponentResult = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("Value(");
                PlaceComponentResult.append(this.BuiltInFictitiousFunctionClassFactory);
            } else if (i == this.KClassImpl$Data$declaredNonStaticMembers$2 && this.NetworkUserEntityData$$ExternalSyntheticLambda0 == 4) {
                PlaceComponentResult = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("Value(");
                PlaceComponentResult.append(this.BuiltInFictitiousFunctionClassFactory);
                PlaceComponentResult.append(",");
                PlaceComponentResult.append(this.MyBillsEntityDataFactory);
            } else {
                PlaceComponentResult = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("Value(");
                PlaceComponentResult.append(this.BuiltInFictitiousFunctionClassFactory);
                PlaceComponentResult.append(",");
                PlaceComponentResult.append(this.MyBillsEntityDataFactory);
                PlaceComponentResult.append(",");
                PlaceComponentResult.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
                PlaceComponentResult.append(",");
                PlaceComponentResult.append(SignStyle$EnumUnboxingLocalUtility.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
            }
            PlaceComponentResult.append(")");
            return PlaceComponentResult.toString();
        }

        /* JADX WARN: Removed duplicated region for block: B:80:0x0094 A[LOOP:0: B:78:0x008b->B:80:0x0094, LOOP_END] */
        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean format(j$.time.format.DateTimePrintContext r13, java.lang.StringBuilder r14) {
            /*
                r12 = this;
                j$.time.temporal.TemporalField r0 = r12.BuiltInFictitiousFunctionClassFactory
                java.lang.Long r0 = r13.PlaceComponentResult(r0)
                r1 = 0
                if (r0 != 0) goto La
                return r1
            La:
                long r2 = r0.longValue()
                long r2 = r12.MyBillsEntityDataFactory(r13, r2)
                j$.time.format.DateTimeFormatter r13 = r13.BuiltInFictitiousFunctionClassFactory
                j$.time.format.DecimalStyle r13 = r13.BuiltInFictitiousFunctionClassFactory
                r4 = -9223372036854775808
                int r13 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r13 != 0) goto L1f
                java.lang.String r13 = "9223372036854775808"
                goto L27
            L1f:
                long r4 = java.lang.Math.abs(r2)
                java.lang.String r13 = java.lang.Long.toString(r4)
            L27:
                int r0 = r13.length()
                int r4 = r12.KClassImpl$Data$declaredNonStaticMembers$2
                java.lang.String r5 = " cannot be printed as the value "
                java.lang.String r6 = "Field "
                if (r0 > r4) goto La0
                int[] r0 = j$.time.format.DateTimeFormatterBuilder.AnonymousClass3.getAuthRequestContext
                int r4 = r12.NetworkUserEntityData$$ExternalSyntheticLambda0
                int r4 = j$.time.format.SignStyle$EnumUnboxingLocalUtility.getAuthRequestContext(r4)
                r7 = 0
                r9 = 2
                r10 = 1
                int r11 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
                if (r11 < 0) goto L5b
                r0 = r0[r4]
                if (r0 == r10) goto L4a
                if (r0 == r9) goto L58
                goto L8b
            L4a:
                int r0 = r12.MyBillsEntityDataFactory
                r4 = 19
                if (r0 >= r4) goto L8b
                long[] r4 = j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser.getAuthRequestContext
                r5 = r4[r0]
                int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r0 < 0) goto L8b
            L58:
                r0 = 43
                goto L88
            L5b:
                r0 = r0[r4]
                if (r0 == r10) goto L86
                if (r0 == r9) goto L86
                r4 = 3
                if (r0 == r4) goto L86
                r4 = 4
                if (r0 == r4) goto L68
                goto L8b
            L68:
                java.lang.StringBuilder r13 = j$.time.DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult(r6)
                j$.time.temporal.TemporalField r14 = r12.BuiltInFictitiousFunctionClassFactory
                r13.append(r14)
                r13.append(r5)
                r13.append(r2)
                java.lang.String r14 = " cannot be negative according to the SignStyle"
                r13.append(r14)
                j$.time.DateTimeException r14 = new j$.time.DateTimeException
                java.lang.String r13 = r13.toString()
                r14.<init>(r13)
                throw r14
            L86:
                r0 = 45
            L88:
                r14.append(r0)
            L8b:
                int r0 = r12.MyBillsEntityDataFactory
                int r2 = r13.length()
                int r0 = r0 - r2
                if (r1 >= r0) goto L9c
                r0 = 48
                r14.append(r0)
                int r1 = r1 + 1
                goto L8b
            L9c:
                r14.append(r13)
                return r10
            La0:
                java.lang.StringBuilder r13 = j$.time.DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult(r6)
                j$.time.temporal.TemporalField r14 = r12.BuiltInFictitiousFunctionClassFactory
                r13.append(r14)
                r13.append(r5)
                r13.append(r2)
                java.lang.String r14 = " exceeds the maximum print width of "
                r13.append(r14)
                int r14 = r12.KClassImpl$Data$declaredNonStaticMembers$2
                r13.append(r14)
                j$.time.DateTimeException r14 = new j$.time.DateTimeException
                java.lang.String r13 = r13.toString()
                r14.<init>(r13)
                goto Lc4
            Lc3:
                throw r14
            Lc4:
                goto Lc3
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser.format(j$.time.format.DateTimePrintContext, java.lang.StringBuilder):boolean");
        }

        /* JADX WARN: Removed duplicated region for block: B:269:0x017b  */
        /* JADX WARN: Removed duplicated region for block: B:274:0x0198  */
        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final int parse(j$.time.format.DateTimeParseContext r21, java.lang.CharSequence r22, int r23) {
            /*
                Method dump skipped, instructions count: 417
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser.parse(j$.time.format.DateTimeParseContext, java.lang.CharSequence, int):int");
        }
    }

    /* loaded from: classes9.dex */
    public class PrefixTree {
        protected PrefixTree BuiltInFictitiousFunctionClassFactory;
        protected char KClassImpl$Data$declaredNonStaticMembers$2;
        protected PrefixTree MyBillsEntityDataFactory;
        protected String PlaceComponentResult;
        protected String getAuthRequestContext;

        /* loaded from: classes9.dex */
        public final class CI extends PrefixTree {
            /* JADX WARN: Illegal instructions before constructor call */
            /* JADX WARN: Type inference failed for: r0v0, types: [j$.time.format.DateTimeFormatterBuilder$PrefixTree, java.lang.String] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            CI() {
                /*
                    r3 = this;
                    r0 = 0
                    java.lang.String r1 = ""
                    r2 = 0
                    r3.<init>(r1, r0, r0, r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: j$.time.format.DateTimeFormatterBuilder.PrefixTree.CI.<init>():void");
            }

            private CI(String str, String str2, PrefixTree prefixTree) {
                super(str, str2, prefixTree, (byte) 0);
            }

            @Override // j$.time.format.DateTimeFormatterBuilder.PrefixTree
            protected final boolean MyBillsEntityDataFactory(char c, char c2) {
                return DateTimeParseContext.KClassImpl$Data$declaredNonStaticMembers$2(c, c2);
            }

            @Override // j$.time.format.DateTimeFormatterBuilder.PrefixTree
            protected final boolean MyBillsEntityDataFactory(CharSequence charSequence, int i, int i2) {
                int length = this.getAuthRequestContext.length();
                if (length > i2 - i) {
                    return false;
                }
                int i3 = 0;
                while (length > 0) {
                    if (!DateTimeParseContext.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.charAt(i3), charSequence.charAt(i))) {
                        return false;
                    }
                    i++;
                    length--;
                    i3++;
                }
                return true;
            }

            @Override // j$.time.format.DateTimeFormatterBuilder.PrefixTree
            protected final PrefixTree PlaceComponentResult(String str, String str2, PrefixTree prefixTree) {
                return new CI(str, str2, prefixTree);
            }
        }

        private PrefixTree(String str, String str2, PrefixTree prefixTree) {
            this.getAuthRequestContext = str;
            this.PlaceComponentResult = str2;
            this.MyBillsEntityDataFactory = prefixTree;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str.length() == 0 ? CharCompanionObject.MAX_VALUE : this.getAuthRequestContext.charAt(0);
        }

        /* synthetic */ PrefixTree(String str, String str2, PrefixTree prefixTree, byte b) {
            this(str, str2, prefixTree);
        }

        public static PrefixTree MyBillsEntityDataFactory(DateTimeParseContext dateTimeParseContext) {
            return dateTimeParseContext.KClassImpl$Data$declaredNonStaticMembers$2() ? new PrefixTree("", null, null) : new CI();
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x001b, code lost:
        
            if (r2 != r1) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0027, code lost:
        
            if (MyBillsEntityDataFactory(r0.KClassImpl$Data$declaredNonStaticMembers$2, r5.charAt(r2)) == false) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0029, code lost:
        
            r6.setIndex(r2);
            r5 = r0.BuiltInFictitiousFunctionClassFactory(r5, r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0030, code lost:
        
            if (r5 == null) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0032, code lost:
        
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0033, code lost:
        
            r0 = r0.BuiltInFictitiousFunctionClassFactory;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0035, code lost:
        
            if (r0 != null) goto L41;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.String BuiltInFictitiousFunctionClassFactory(java.lang.CharSequence r5, java.text.ParsePosition r6) {
            /*
                r4 = this;
                int r0 = r6.getIndex()
                int r1 = r5.length()
                boolean r2 = r4.MyBillsEntityDataFactory(r5, r0, r1)
                if (r2 != 0) goto L10
                r5 = 0
                return r5
            L10:
                java.lang.String r2 = r4.getAuthRequestContext
                int r2 = r2.length()
                int r2 = r2 + r0
                j$.time.format.DateTimeFormatterBuilder$PrefixTree r0 = r4.MyBillsEntityDataFactory
                if (r0 == 0) goto L37
                if (r2 == r1) goto L37
            L1d:
                char r1 = r0.KClassImpl$Data$declaredNonStaticMembers$2
                char r3 = r5.charAt(r2)
                boolean r1 = r4.MyBillsEntityDataFactory(r1, r3)
                if (r1 == 0) goto L33
                r6.setIndex(r2)
                java.lang.String r5 = r0.BuiltInFictitiousFunctionClassFactory(r5, r6)
                if (r5 == 0) goto L37
                return r5
            L33:
                j$.time.format.DateTimeFormatterBuilder$PrefixTree r0 = r0.BuiltInFictitiousFunctionClassFactory
                if (r0 != 0) goto L1d
            L37:
                r6.setIndex(r2)
                java.lang.String r5 = r4.PlaceComponentResult
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.time.format.DateTimeFormatterBuilder.PrefixTree.BuiltInFictitiousFunctionClassFactory(java.lang.CharSequence, java.text.ParsePosition):java.lang.String");
        }

        protected boolean MyBillsEntityDataFactory(char c, char c2) {
            return c == c2;
        }

        protected boolean MyBillsEntityDataFactory(CharSequence charSequence, int i, int i2) {
            if (charSequence instanceof String) {
                return ((String) charSequence).startsWith(this.getAuthRequestContext, i);
            }
            int length = this.getAuthRequestContext.length();
            if (length > i2 - i) {
                return false;
            }
            int i3 = 0;
            while (length > 0) {
                if (!MyBillsEntityDataFactory(this.getAuthRequestContext.charAt(i3), charSequence.charAt(i))) {
                    return false;
                }
                i++;
                length--;
                i3++;
            }
            return true;
        }

        protected PrefixTree PlaceComponentResult(String str, String str2, PrefixTree prefixTree) {
            return new PrefixTree(str, str2, prefixTree);
        }

        final boolean getAuthRequestContext(String str, String str2) {
            PrefixTree prefixTree;
            PrefixTree prefixTree2 = this;
            while (true) {
                int i = 0;
                while (i < str.length() && i < prefixTree2.getAuthRequestContext.length() && prefixTree2.MyBillsEntityDataFactory(str.charAt(i), prefixTree2.getAuthRequestContext.charAt(i))) {
                    i++;
                }
                if (i != prefixTree2.getAuthRequestContext.length()) {
                    PrefixTree PlaceComponentResult = prefixTree2.PlaceComponentResult(prefixTree2.getAuthRequestContext.substring(i), prefixTree2.PlaceComponentResult, prefixTree2.MyBillsEntityDataFactory);
                    prefixTree2.getAuthRequestContext = str.substring(0, i);
                    prefixTree2.MyBillsEntityDataFactory = PlaceComponentResult;
                    if (i < str.length()) {
                        prefixTree2.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = prefixTree2.PlaceComponentResult(str.substring(i), str2, null);
                        prefixTree2.PlaceComponentResult = null;
                    } else {
                        prefixTree2.PlaceComponentResult = str2;
                    }
                    return true;
                } else if (i >= str.length()) {
                    prefixTree2.PlaceComponentResult = str2;
                    return true;
                } else {
                    str = str.substring(i);
                    prefixTree = prefixTree2.MyBillsEntityDataFactory;
                    while (prefixTree != null) {
                        if (prefixTree2.MyBillsEntityDataFactory(prefixTree.KClassImpl$Data$declaredNonStaticMembers$2, str.charAt(0))) {
                            break;
                        }
                        prefixTree = prefixTree.BuiltInFictitiousFunctionClassFactory;
                    }
                    PrefixTree PlaceComponentResult2 = prefixTree2.PlaceComponentResult(str, str2, null);
                    PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory = prefixTree2.MyBillsEntityDataFactory;
                    prefixTree2.MyBillsEntityDataFactory = PlaceComponentResult2;
                    return true;
                }
                prefixTree2 = prefixTree;
            }
        }

        public static PrefixTree PlaceComponentResult(HashSet hashSet, DateTimeParseContext dateTimeParseContext) {
            PrefixTree prefixTree = dateTimeParseContext.KClassImpl$Data$declaredNonStaticMembers$2() ? new PrefixTree("", null, null) : new CI();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                prefixTree.getAuthRequestContext(str, str);
            }
            return prefixTree;
        }
    }

    /* loaded from: classes6.dex */
    public final class ReducedPrinterParser extends NumberPrinterParser {
        static final LocalDate getErrorConfigVersion = LocalDate.of(2000, 1, 1);
        private final ChronoLocalDate NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final int scheduleImpl;

        private ReducedPrinterParser(TemporalField temporalField, int i, int i2, int i3, ChronoLocalDate chronoLocalDate, int i4) {
            super(temporalField, i, i2, 4, i4);
            this.scheduleImpl = i3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = chronoLocalDate;
        }

        public ReducedPrinterParser(TemporalField temporalField, LocalDate localDate) {
            this(temporalField, 2, 2, 0, localDate, 0);
        }

        /* synthetic */ ReducedPrinterParser(TemporalField temporalField, LocalDate localDate, byte b) {
            this(temporalField, 2, 2, 0, localDate, 0);
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        final NumberPrinterParser BuiltInFictitiousFunctionClassFactory(int i) {
            return new ReducedPrinterParser(this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.PlaceComponentResult + i);
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        final NumberPrinterParser KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.PlaceComponentResult == -1 ? this : new ReducedPrinterParser(this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda0, -1);
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        final boolean getAuthRequestContext(DateTimeParseContext dateTimeParseContext) {
            if (dateTimeParseContext.MyBillsEntityDataFactory()) {
                return super.getAuthRequestContext(dateTimeParseContext);
            }
            return false;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        public final String toString() {
            StringBuilder PlaceComponentResult = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("ReducedValue(");
            PlaceComponentResult.append(this.BuiltInFictitiousFunctionClassFactory);
            PlaceComponentResult.append(",");
            PlaceComponentResult.append(this.MyBillsEntityDataFactory);
            PlaceComponentResult.append(",");
            PlaceComponentResult.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            PlaceComponentResult.append(",");
            Object obj = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (obj == null) {
                obj = Integer.valueOf(this.scheduleImpl);
            }
            PlaceComponentResult.append(obj);
            PlaceComponentResult.append(")");
            return PlaceComponentResult.toString();
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        final long MyBillsEntityDataFactory(DateTimePrintContext dateTimePrintContext, long j) {
            long abs = Math.abs(j);
            int i = this.scheduleImpl;
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
                i = Era.CC.BuiltInFictitiousFunctionClassFactory(dateTimePrintContext.PlaceComponentResult).date(this.NetworkUserEntityData$$ExternalSyntheticLambda0).get(this.BuiltInFictitiousFunctionClassFactory);
            }
            long j2 = i;
            if (j >= j2) {
                long j3 = NumberPrinterParser.getAuthRequestContext[this.MyBillsEntityDataFactory];
                if (j < j2 + j3) {
                    return abs % j3;
                }
            }
            return abs % NumberPrinterParser.getAuthRequestContext[this.KClassImpl$Data$declaredNonStaticMembers$2];
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        public final int BuiltInFictitiousFunctionClassFactory(final DateTimeParseContext dateTimeParseContext, final long j, final int i, final int i2) {
            int i3 = this.scheduleImpl;
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
                i3 = dateTimeParseContext.BuiltInFictitiousFunctionClassFactory().date(this.NetworkUserEntityData$$ExternalSyntheticLambda0).get(this.BuiltInFictitiousFunctionClassFactory);
                Consumer consumer = new Consumer() { // from class: j$.time.format.DateTimeFormatterBuilder$ReducedPrinterParser$$ExternalSyntheticLambda0
                    @Override // j$.util.function.Consumer
                    public final void accept(Object obj) {
                        Chronology chronology = (Chronology) obj;
                        DateTimeFormatterBuilder.ReducedPrinterParser.this.BuiltInFictitiousFunctionClassFactory(dateTimeParseContext, j, i, i2);
                    }

                    @Override // j$.util.function.Consumer
                    public final /* synthetic */ Consumer andThen(Consumer consumer2) {
                        return Consumer.CC.PlaceComponentResult(this, consumer2);
                    }
                };
                if (dateTimeParseContext.getAuthRequestContext == null) {
                    dateTimeParseContext.getAuthRequestContext = new ArrayList();
                }
                dateTimeParseContext.getAuthRequestContext.add(consumer);
            }
            int i4 = this.MyBillsEntityDataFactory;
            if (i2 - i == i4 && j >= 0) {
                long j2 = NumberPrinterParser.getAuthRequestContext[i4];
                long j3 = i3;
                long j4 = j3 - (j3 % j2);
                j = i3 > 0 ? j4 + j : j4 - j;
                if (j < j3) {
                    j += j2;
                }
            }
            return dateTimeParseContext.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, j, i, i2);
        }
    }

    /* loaded from: classes6.dex */
    enum SettingsParser implements DateTimePrinterParser {
        SENSITIVE,
        INSENSITIVE,
        STRICT,
        LENIENT;

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public final boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            return true;
        }

        @Override // java.lang.Enum
        public final String toString() {
            int ordinal = ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        if (ordinal == 3) {
                            return "ParseStrict(false)";
                        }
                        throw new IllegalStateException("Unreachable");
                    }
                    return "ParseStrict(true)";
                }
                return "ParseCaseSensitive(false)";
            }
            return "ParseCaseSensitive(true)";
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public final int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            int ordinal = ordinal();
            if (ordinal == 0) {
                dateTimeParseContext.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            } else if (ordinal == 1) {
                dateTimeParseContext.KClassImpl$Data$declaredNonStaticMembers$2 = false;
            } else if (ordinal == 2) {
                dateTimeParseContext.PlaceComponentResult = true;
            } else if (ordinal == 3) {
                dateTimeParseContext.PlaceComponentResult = false;
            }
            return i;
        }
    }

    /* loaded from: classes6.dex */
    public final class StringLiteralPrinterParser implements DateTimePrinterParser {
        private final Object MyBillsEntityDataFactory;
        public final /* synthetic */ int getAuthRequestContext;

        public /* synthetic */ StringLiteralPrinterParser(int i, Object obj) {
            this.getAuthRequestContext = i;
            this.MyBillsEntityDataFactory = obj;
        }

        public final String toString() {
            if (this.getAuthRequestContext != 0) {
                StringBuilder PlaceComponentResult = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("LocalizedOffset(");
                PlaceComponentResult.append((TextStyle) this.MyBillsEntityDataFactory);
                PlaceComponentResult.append(")");
                return PlaceComponentResult.toString();
            }
            String replace = ((String) this.MyBillsEntityDataFactory).replace("'", "''");
            StringBuilder sb = new StringBuilder();
            sb.append("'");
            sb.append(replace);
            sb.append("'");
            return sb.toString();
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public final boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            if (this.getAuthRequestContext == 0) {
                sb.append((String) this.MyBillsEntityDataFactory);
                return true;
            }
            Long PlaceComponentResult = dateTimePrintContext.PlaceComponentResult(ChronoField.OFFSET_SECONDS);
            if (PlaceComponentResult == null) {
                return false;
            }
            sb.append("GMT");
            int BuiltInFictitiousFunctionClassFactory = Iterable.CC.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult.longValue());
            if (BuiltInFictitiousFunctionClassFactory != 0) {
                int abs = Math.abs((BuiltInFictitiousFunctionClassFactory / 3600) % 100);
                int abs2 = Math.abs((BuiltInFictitiousFunctionClassFactory / 60) % 60);
                int abs3 = Math.abs(BuiltInFictitiousFunctionClassFactory % 60);
                sb.append(BuiltInFictitiousFunctionClassFactory < 0 ? "-" : "+");
                if (((TextStyle) this.MyBillsEntityDataFactory) == TextStyle.FULL) {
                    sb.append((char) ((abs / 10) + 48));
                    sb.append((char) ((abs % 10) + 48));
                    sb.append(':');
                    sb.append((char) ((abs2 / 10) + 48));
                    sb.append((char) ((abs2 % 10) + 48));
                    if (abs3 == 0) {
                        return true;
                    }
                } else {
                    if (abs >= 10) {
                        sb.append((char) ((abs / 10) + 48));
                    }
                    sb.append((char) ((abs % 10) + 48));
                    if (abs2 == 0 && abs3 == 0) {
                        return true;
                    }
                    sb.append(':');
                    sb.append((char) ((abs2 / 10) + 48));
                    sb.append((char) ((abs2 % 10) + 48));
                    if (abs3 == 0) {
                        return true;
                    }
                }
                sb.append(':');
                sb.append((char) ((abs3 / 10) + 48));
                sb.append((char) ((abs3 % 10) + 48));
                return true;
            }
            return true;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public final int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            TemporalField temporalField;
            long j;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7 = -1;
            if (this.getAuthRequestContext == 0) {
                if (i > charSequence.length() || i < 0) {
                    throw new IndexOutOfBoundsException();
                }
                String str = (String) this.MyBillsEntityDataFactory;
                return !dateTimeParseContext.getAuthRequestContext(charSequence, i, str, 0, str.length()) ? i ^ (-1) : ((String) this.MyBillsEntityDataFactory).length() + i;
            }
            int length = charSequence.length() + i;
            if (dateTimeParseContext.getAuthRequestContext(charSequence, i, "GMT", 0, 3)) {
                int i8 = i + 3;
                if (i8 != length) {
                    char charAt = charSequence.charAt(i8);
                    if (charAt != '+') {
                        i3 = charAt == '-' ? -1 : 1;
                    }
                    int i9 = i8 + 1;
                    int i10 = 0;
                    if (((TextStyle) this.MyBillsEntityDataFactory) == TextStyle.FULL) {
                        int i11 = i9 + 1;
                        char charAt2 = charSequence.charAt(i9);
                        int i12 = (charAt2 < '0' || charAt2 > '9') ? -1 : charAt2 - '0';
                        int i13 = i11 + 1;
                        char charAt3 = charSequence.charAt(i11);
                        int i14 = (charAt3 < '0' || charAt3 > '9') ? -1 : charAt3 - '0';
                        if (i12 >= 0 && i14 >= 0) {
                            int i15 = i13 + 1;
                            if (charSequence.charAt(i13) == ':') {
                                i4 = (i12 * 10) + i14;
                                int i16 = i15 + 1;
                                char charAt4 = charSequence.charAt(i15);
                                int i17 = (charAt4 < '0' || charAt4 > '9') ? -1 : charAt4 - '0';
                                i5 = i16 + 1;
                                char charAt5 = charSequence.charAt(i16);
                                int i18 = (charAt5 < '0' || charAt5 > '9') ? -1 : charAt5 - '0';
                                if (i17 >= 0 && i18 >= 0) {
                                    int i19 = i5 + 2;
                                    if (i19 < length && charSequence.charAt(i5) == ':') {
                                        char charAt6 = charSequence.charAt(i5 + 1);
                                        int i20 = (charAt6 < '0' || charAt6 > '9') ? -1 : charAt6 - '0';
                                        char charAt7 = charSequence.charAt(i19);
                                        if (charAt7 >= '0' && charAt7 <= '9') {
                                            i7 = charAt7 - '0';
                                        }
                                        if (i20 >= 0 && i7 >= 0) {
                                            i5 += 3;
                                            i10 = (i20 * 10) + i7;
                                        }
                                    }
                                    int i21 = i10;
                                    i10 = i18 + (i17 * 10);
                                    i6 = i21;
                                    long j2 = ((i10 * 60) + (i4 * 3600) + i6) * i3;
                                    temporalField = ChronoField.OFFSET_SECONDS;
                                    j = j2;
                                    i2 = i5;
                                }
                            }
                        }
                    } else {
                        int i22 = i9 + 1;
                        char charAt8 = charSequence.charAt(i9);
                        i4 = (charAt8 < '0' || charAt8 > '9') ? -1 : charAt8 - '0';
                        if (i4 >= 0) {
                            if (i22 < length) {
                                char charAt9 = charSequence.charAt(i22);
                                int i23 = (charAt9 < '0' || charAt9 > '9') ? -1 : charAt9 - '0';
                                if (i23 >= 0) {
                                    i4 = (i4 * 10) + i23;
                                    i22++;
                                }
                                int i24 = i22 + 2;
                                if (i24 < length && charSequence.charAt(i22) == ':' && i24 < length && charSequence.charAt(i22) == ':') {
                                    char charAt10 = charSequence.charAt(i22 + 1);
                                    int i25 = (charAt10 < '0' || charAt10 > '9') ? -1 : charAt10 - '0';
                                    char charAt11 = charSequence.charAt(i24);
                                    int i26 = (charAt11 < '0' || charAt11 > '9') ? -1 : charAt11 - '0';
                                    if (i25 >= 0 && i26 >= 0) {
                                        int i27 = i22 + 3;
                                        int i28 = i27 + 2;
                                        if (i28 < length && charSequence.charAt(i27) == ':') {
                                            char charAt12 = charSequence.charAt(i27 + 1);
                                            int i29 = (charAt12 < '0' || charAt12 > '9') ? -1 : charAt12 - '0';
                                            char charAt13 = charSequence.charAt(i28);
                                            if (charAt13 >= '0' && charAt13 <= '9') {
                                                i7 = charAt13 - '0';
                                            }
                                            if (i29 >= 0 && i7 >= 0) {
                                                i27 += 3;
                                                i10 = (i29 * 10) + i7;
                                            }
                                        }
                                        int i30 = i26 + (i25 * 10);
                                        i5 = i27;
                                        i6 = i10;
                                        i10 = i30;
                                        long j22 = ((i10 * 60) + (i4 * 3600) + i6) * i3;
                                        temporalField = ChronoField.OFFSET_SECONDS;
                                        j = j22;
                                        i2 = i5;
                                    }
                                }
                            }
                            i5 = i22;
                            i6 = 0;
                            long j222 = ((i10 * 60) + (i4 * 3600) + i6) * i3;
                            temporalField = ChronoField.OFFSET_SECONDS;
                            j = j222;
                            i2 = i5;
                        }
                    }
                    return dateTimeParseContext.KClassImpl$Data$declaredNonStaticMembers$2(temporalField, j, i, i2);
                }
                temporalField = ChronoField.OFFSET_SECONDS;
                j = 0;
                i2 = i8;
                return dateTimeParseContext.KClassImpl$Data$declaredNonStaticMembers$2(temporalField, j, i, i2);
            }
            return i ^ (-1);
        }
    }

    /* loaded from: classes6.dex */
    public final class TextPrinterParser implements DateTimePrinterParser {
        private volatile NumberPrinterParser BuiltInFictitiousFunctionClassFactory;
        private final DateTimeTextProvider KClassImpl$Data$declaredNonStaticMembers$2;
        private final TextStyle MyBillsEntityDataFactory;
        private final TemporalField getAuthRequestContext;

        public TextPrinterParser(TemporalField temporalField, TextStyle textStyle, DateTimeTextProvider dateTimeTextProvider) {
            this.getAuthRequestContext = temporalField;
            this.MyBillsEntityDataFactory = textStyle;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = dateTimeTextProvider;
        }

        public final String toString() {
            StringBuilder PlaceComponentResult;
            Object obj;
            if (this.MyBillsEntityDataFactory == TextStyle.FULL) {
                PlaceComponentResult = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("Text(");
                obj = this.getAuthRequestContext;
            } else {
                PlaceComponentResult = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("Text(");
                PlaceComponentResult.append(this.getAuthRequestContext);
                PlaceComponentResult.append(",");
                obj = this.MyBillsEntityDataFactory;
            }
            PlaceComponentResult.append(obj);
            PlaceComponentResult.append(")");
            return PlaceComponentResult.toString();
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public final boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            String BuiltInFictitiousFunctionClassFactory;
            IsoChronology isoChronology;
            Long PlaceComponentResult = dateTimePrintContext.PlaceComponentResult(this.getAuthRequestContext);
            if (PlaceComponentResult == null) {
                return false;
            }
            Chronology chronology = (Chronology) dateTimePrintContext.PlaceComponentResult.query(Temporal.CC.getAuthRequestContext());
            if (chronology == null || chronology == (isoChronology = IsoChronology.INSTANCE)) {
                BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, PlaceComponentResult.longValue(), this.MyBillsEntityDataFactory, dateTimePrintContext.BuiltInFictitiousFunctionClassFactory.scheduleImpl);
            } else {
                DateTimeTextProvider dateTimeTextProvider = this.KClassImpl$Data$declaredNonStaticMembers$2;
                TemporalField temporalField = this.getAuthRequestContext;
                BuiltInFictitiousFunctionClassFactory = (chronology == isoChronology || !(temporalField instanceof ChronoField)) ? dateTimeTextProvider.BuiltInFictitiousFunctionClassFactory(temporalField, PlaceComponentResult.longValue(), this.MyBillsEntityDataFactory, dateTimePrintContext.BuiltInFictitiousFunctionClassFactory.scheduleImpl) : null;
            }
            if (BuiltInFictitiousFunctionClassFactory != null) {
                sb.append(BuiltInFictitiousFunctionClassFactory);
                return true;
            }
            if (this.BuiltInFictitiousFunctionClassFactory == null) {
                this.BuiltInFictitiousFunctionClassFactory = new NumberPrinterParser(this.getAuthRequestContext, 1, 19, 1);
            }
            return this.BuiltInFictitiousFunctionClassFactory.format(dateTimePrintContext, sb);
        }

        /* JADX WARN: Code restructure failed: missing block: B:60:0x003c, code lost:
        
            if (r1 != null) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x0042, code lost:
        
            if (r1.hasNext() == false) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0044, code lost:
        
            r0 = (java.util.Map.Entry) r1.next();
            r2 = (java.lang.String) r0.getKey();
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x005d, code lost:
        
            if (r11.getAuthRequestContext(r2, 0, r12, r13, r2.length()) == false) goto L81;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x0077, code lost:
        
            return r11.KClassImpl$Data$declaredNonStaticMembers$2(r10.getAuthRequestContext, ((java.lang.Long) r0.getValue()).longValue(), r13, r2.length() + r13);
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x007c, code lost:
        
            if (r11.MyBillsEntityDataFactory() == false) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0080, code lost:
        
            return r13 ^ (-1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x0083, code lost:
        
            if (r10.BuiltInFictitiousFunctionClassFactory != null) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x0085, code lost:
        
            r10.BuiltInFictitiousFunctionClassFactory = new j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser(r10.getAuthRequestContext, 1, 19, 1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x0097, code lost:
        
            return r10.BuiltInFictitiousFunctionClassFactory.parse(r11, r12, r13);
         */
        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final int parse(j$.time.format.DateTimeParseContext r11, java.lang.CharSequence r12, int r13) {
            /*
                r10 = this;
                int r0 = r12.length()
                if (r13 < 0) goto L98
                if (r13 > r0) goto L98
                boolean r0 = r11.MyBillsEntityDataFactory()
                r1 = 0
                if (r0 == 0) goto L12
                j$.time.format.TextStyle r0 = r10.MyBillsEntityDataFactory
                goto L13
            L12:
                r0 = r1
            L13:
                j$.time.chrono.Chronology r2 = r11.BuiltInFictitiousFunctionClassFactory()
                if (r2 == 0) goto L30
                j$.time.chrono.IsoChronology r3 = j$.time.chrono.IsoChronology.INSTANCE
                if (r2 == r3) goto L30
                j$.time.format.DateTimeTextProvider r4 = r10.KClassImpl$Data$declaredNonStaticMembers$2
                j$.time.temporal.TemporalField r5 = r10.getAuthRequestContext
                j$.time.format.DateTimeFormatter r6 = r11.BuiltInFictitiousFunctionClassFactory
                java.util.Locale r6 = r6.scheduleImpl
                if (r2 == r3) goto L2b
                boolean r2 = r5 instanceof j$.time.temporal.ChronoField
                if (r2 != 0) goto L3c
            L2b:
                java.util.Iterator r1 = r4.PlaceComponentResult(r5, r0, r6)
                goto L3c
            L30:
                j$.time.format.DateTimeTextProvider r1 = r10.KClassImpl$Data$declaredNonStaticMembers$2
                j$.time.temporal.TemporalField r2 = r10.getAuthRequestContext
                j$.time.format.DateTimeFormatter r3 = r11.BuiltInFictitiousFunctionClassFactory
                java.util.Locale r3 = r3.scheduleImpl
                java.util.Iterator r1 = r1.PlaceComponentResult(r2, r0, r3)
            L3c:
                if (r1 == 0) goto L81
            L3e:
                boolean r0 = r1.hasNext()
                if (r0 == 0) goto L78
                java.lang.Object r0 = r1.next()
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                java.lang.Object r2 = r0.getKey()
                java.lang.String r2 = (java.lang.String) r2
                r5 = 0
                int r8 = r2.length()
                r3 = r11
                r4 = r2
                r6 = r12
                r7 = r13
                boolean r3 = r3.getAuthRequestContext(r4, r5, r6, r7, r8)
                if (r3 == 0) goto L3e
                j$.time.temporal.TemporalField r5 = r10.getAuthRequestContext
                java.lang.Object r12 = r0.getValue()
                java.lang.Long r12 = (java.lang.Long) r12
                long r6 = r12.longValue()
                int r12 = r2.length()
                int r9 = r12 + r13
                r4 = r11
                r8 = r13
                int r11 = r4.KClassImpl$Data$declaredNonStaticMembers$2(r5, r6, r8, r9)
                return r11
            L78:
                boolean r0 = r11.MyBillsEntityDataFactory()
                if (r0 == 0) goto L81
                r11 = r13 ^ (-1)
                return r11
            L81:
                j$.time.format.DateTimeFormatterBuilder$NumberPrinterParser r0 = r10.BuiltInFictitiousFunctionClassFactory
                if (r0 != 0) goto L91
                j$.time.format.DateTimeFormatterBuilder$NumberPrinterParser r0 = new j$.time.format.DateTimeFormatterBuilder$NumberPrinterParser
                j$.time.temporal.TemporalField r1 = r10.getAuthRequestContext
                r2 = 19
                r3 = 1
                r0.<init>(r1, r3, r2, r3)
                r10.BuiltInFictitiousFunctionClassFactory = r0
            L91:
                j$.time.format.DateTimeFormatterBuilder$NumberPrinterParser r0 = r10.BuiltInFictitiousFunctionClassFactory
                int r11 = r0.parse(r11, r12, r13)
                return r11
            L98:
                java.lang.IndexOutOfBoundsException r11 = new java.lang.IndexOutOfBoundsException
                r11.<init>()
                goto L9f
            L9e:
                throw r11
            L9f:
                goto L9e
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.time.format.DateTimeFormatterBuilder.TextPrinterParser.parse(j$.time.format.DateTimeParseContext, java.lang.CharSequence, int):int");
        }
    }

    /* loaded from: classes6.dex */
    public final class WeekBasedFieldPrinterParser implements DateTimePrinterParser {
        private char BuiltInFictitiousFunctionClassFactory;
        private int PlaceComponentResult;

        public WeekBasedFieldPrinterParser(char c, int i) {
            this.BuiltInFictitiousFunctionClassFactory = c;
            this.PlaceComponentResult = i;
        }

        private NumberPrinterParser getAuthRequestContext(Locale locale) {
            TemporalField weekOfMonth;
            TemporalUnit temporalUnit = WeekFields.WEEK_BASED_YEARS;
            if (locale != null) {
                WeekFields of = WeekFields.of(DayOfWeek.SUNDAY.plus(r12.getFirstDayOfWeek() - 1), Calendar.getInstance(new Locale(locale.getLanguage(), locale.getCountry())).getMinimalDaysInFirstWeek());
                char c = this.BuiltInFictitiousFunctionClassFactory;
                if (c == 'W') {
                    weekOfMonth = of.weekOfMonth();
                } else if (c == 'Y') {
                    TemporalField weekBasedYear = of.weekBasedYear();
                    int i = this.PlaceComponentResult;
                    if (i == 2) {
                        return new ReducedPrinterParser(weekBasedYear, ReducedPrinterParser.getErrorConfigVersion, (byte) 0);
                    }
                    return new NumberPrinterParser(weekBasedYear, i, 19, i < 4 ? 1 : 5, -1);
                } else if (c == 'c' || c == 'e') {
                    weekOfMonth = of.dayOfWeek();
                } else if (c != 'w') {
                    throw new IllegalStateException("unreachable");
                } else {
                    weekOfMonth = of.weekOfWeekBasedYear();
                }
                return new NumberPrinterParser(weekOfMonth, this.PlaceComponentResult == 2 ? 2 : 1, 2, 4);
            }
            throw new NullPointerException("locale");
        }

        public final String toString() {
            String str;
            String MyBillsEntityDataFactory;
            StringBuilder sb = new StringBuilder(30);
            sb.append("Localized(");
            char c = this.BuiltInFictitiousFunctionClassFactory;
            if (c == 'Y') {
                int i = this.PlaceComponentResult;
                if (i == 1) {
                    MyBillsEntityDataFactory = "WeekBasedYear";
                } else if (i == 2) {
                    MyBillsEntityDataFactory = "ReducedValue(WeekBasedYear,2,2,2000-01-01)";
                } else {
                    sb.append("WeekBasedYear,");
                    sb.append(this.PlaceComponentResult);
                    sb.append(",");
                    sb.append(19);
                    sb.append(",");
                    MyBillsEntityDataFactory = SignStyle$EnumUnboxingLocalUtility.MyBillsEntityDataFactory(this.PlaceComponentResult >= 4 ? 5 : 1);
                }
                sb.append(MyBillsEntityDataFactory);
            } else {
                if (c == 'W') {
                    str = "WeekOfMonth";
                } else if (c == 'c' || c == 'e') {
                    str = "DayOfWeek";
                } else {
                    if (c == 'w') {
                        str = "WeekOfWeekBasedYear";
                    }
                    sb.append(",");
                    sb.append(this.PlaceComponentResult);
                }
                sb.append(str);
                sb.append(",");
                sb.append(this.PlaceComponentResult);
            }
            sb.append(")");
            return sb.toString();
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public final boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            return getAuthRequestContext(dateTimePrintContext.BuiltInFictitiousFunctionClassFactory.scheduleImpl).format(dateTimePrintContext, sb);
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public final int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            return getAuthRequestContext(dateTimeParseContext.BuiltInFictitiousFunctionClassFactory.scheduleImpl).parse(dateTimeParseContext, charSequence, i);
        }
    }

    /* loaded from: classes6.dex */
    public class ZoneIdPrinterParser implements DateTimePrinterParser {
        private static volatile AbstractMap.SimpleImmutableEntry BuiltInFictitiousFunctionClassFactory;
        private static volatile AbstractMap.SimpleImmutableEntry PlaceComponentResult;
        private final String MyBillsEntityDataFactory;
        private final TemporalQuery getAuthRequestContext;

        public ZoneIdPrinterParser(TemporalQuery temporalQuery, String str) {
            this.getAuthRequestContext = temporalQuery;
            this.MyBillsEntityDataFactory = str;
        }

        protected PrefixTree PlaceComponentResult(DateTimeParseContext dateTimeParseContext) {
            HashSet PlaceComponentResult2 = ZoneRulesProvider.PlaceComponentResult();
            int size = PlaceComponentResult2.size();
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry = dateTimeParseContext.KClassImpl$Data$declaredNonStaticMembers$2() ? BuiltInFictitiousFunctionClassFactory : PlaceComponentResult;
            if (simpleImmutableEntry == null || ((Integer) simpleImmutableEntry.getKey()).intValue() != size) {
                synchronized (this) {
                    simpleImmutableEntry = dateTimeParseContext.KClassImpl$Data$declaredNonStaticMembers$2() ? BuiltInFictitiousFunctionClassFactory : PlaceComponentResult;
                    if (simpleImmutableEntry == null || ((Integer) simpleImmutableEntry.getKey()).intValue() != size) {
                        simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(Integer.valueOf(size), PrefixTree.PlaceComponentResult(PlaceComponentResult2, dateTimeParseContext));
                        if (dateTimeParseContext.KClassImpl$Data$declaredNonStaticMembers$2()) {
                            BuiltInFictitiousFunctionClassFactory = simpleImmutableEntry;
                        } else {
                            PlaceComponentResult = simpleImmutableEntry;
                        }
                    }
                }
            }
            return (PrefixTree) simpleImmutableEntry.getValue();
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            ZoneId zoneId = (ZoneId) dateTimePrintContext.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext);
            if (zoneId == null) {
                return false;
            }
            sb.append(zoneId.getId());
            return true;
        }

        public final String toString() {
            return this.MyBillsEntityDataFactory;
        }

        private static int MyBillsEntityDataFactory(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i, int i2, OffsetIdPrinterParser offsetIdPrinterParser) {
            String upperCase = charSequence.toString().substring(i, i2).toUpperCase();
            if (i2 >= charSequence.length() || charSequence.charAt(i2) == '0' || dateTimeParseContext.BuiltInFictitiousFunctionClassFactory(charSequence.charAt(i2), 'Z')) {
                ZoneId of = ZoneId.of(upperCase);
                if (of != null) {
                    ((Parsed) dateTimeParseContext.MyBillsEntityDataFactory.get(r4.size() - 1)).getErrorConfigVersion = of;
                    return i2;
                }
                throw new NullPointerException("zone");
            }
            DateTimeParseContext dateTimeParseContext2 = new DateTimeParseContext(dateTimeParseContext.BuiltInFictitiousFunctionClassFactory);
            dateTimeParseContext2.KClassImpl$Data$declaredNonStaticMembers$2 = dateTimeParseContext.KClassImpl$Data$declaredNonStaticMembers$2;
            dateTimeParseContext2.PlaceComponentResult = dateTimeParseContext.PlaceComponentResult;
            int parse = offsetIdPrinterParser.parse(dateTimeParseContext2, charSequence, i2);
            try {
                if (parse < 0) {
                    if (offsetIdPrinterParser == OffsetIdPrinterParser.BuiltInFictitiousFunctionClassFactory) {
                        return i ^ (-1);
                    }
                    ZoneId of2 = ZoneId.of(upperCase);
                    if (of2 != null) {
                        ((Parsed) dateTimeParseContext.MyBillsEntityDataFactory.get(r4.size() - 1)).getErrorConfigVersion = of2;
                        return i2;
                    }
                    throw new NullPointerException("zone");
                }
                ZoneId ofOffset = ZoneId.ofOffset(upperCase, ZoneOffset.ofTotalSeconds((int) ((Long) ((Parsed) dateTimeParseContext2.MyBillsEntityDataFactory.get(r8.size() - 1)).PlaceComponentResult.get(ChronoField.OFFSET_SECONDS)).longValue()));
                if (ofOffset != null) {
                    ((Parsed) dateTimeParseContext.MyBillsEntityDataFactory.get(r4.size() - 1)).getErrorConfigVersion = ofOffset;
                    return parse;
                }
                throw new NullPointerException("zone");
            } catch (DateTimeException unused) {
                return i ^ (-1);
            }
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public final int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            int i2;
            int length = charSequence.length();
            if (i <= length) {
                if (i == length) {
                    return i ^ (-1);
                }
                char charAt = charSequence.charAt(i);
                if (charAt == '+' || charAt == '-') {
                    return MyBillsEntityDataFactory(dateTimeParseContext, charSequence, i, i, OffsetIdPrinterParser.BuiltInFictitiousFunctionClassFactory);
                }
                int i3 = i + 2;
                if (length >= i3) {
                    char charAt2 = charSequence.charAt(i + 1);
                    if (dateTimeParseContext.BuiltInFictitiousFunctionClassFactory(charAt, 'U') && dateTimeParseContext.BuiltInFictitiousFunctionClassFactory(charAt2, 'T')) {
                        int i4 = i + 3;
                        return (length < i4 || !dateTimeParseContext.BuiltInFictitiousFunctionClassFactory(charSequence.charAt(i3), 'C')) ? MyBillsEntityDataFactory(dateTimeParseContext, charSequence, i, i3, OffsetIdPrinterParser.PlaceComponentResult) : MyBillsEntityDataFactory(dateTimeParseContext, charSequence, i, i4, OffsetIdPrinterParser.PlaceComponentResult);
                    } else if (dateTimeParseContext.BuiltInFictitiousFunctionClassFactory(charAt, 'G') && length >= (i2 = i + 3) && dateTimeParseContext.BuiltInFictitiousFunctionClassFactory(charAt2, 'M') && dateTimeParseContext.BuiltInFictitiousFunctionClassFactory(charSequence.charAt(i3), 'T')) {
                        return MyBillsEntityDataFactory(dateTimeParseContext, charSequence, i, i2, OffsetIdPrinterParser.PlaceComponentResult);
                    }
                }
                PrefixTree PlaceComponentResult2 = PlaceComponentResult(dateTimeParseContext);
                ParsePosition parsePosition = new ParsePosition(i);
                String BuiltInFictitiousFunctionClassFactory2 = PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory(charSequence, parsePosition);
                if (BuiltInFictitiousFunctionClassFactory2 != null) {
                    ZoneId of = ZoneId.of(BuiltInFictitiousFunctionClassFactory2);
                    if (of != null) {
                        ((Parsed) dateTimeParseContext.MyBillsEntityDataFactory.get(r7.size() - 1)).getErrorConfigVersion = of;
                        return parsePosition.getIndex();
                    }
                    throw new NullPointerException("zone");
                } else if (dateTimeParseContext.BuiltInFictitiousFunctionClassFactory(charAt, 'Z')) {
                    ZoneOffset zoneOffset = ZoneOffset.UTC;
                    if (zoneOffset != null) {
                        ((Parsed) dateTimeParseContext.MyBillsEntityDataFactory.get(r7.size() - 1)).getErrorConfigVersion = zoneOffset;
                        return i + 1;
                    }
                    throw new NullPointerException("zone");
                } else {
                    return i ^ (-1);
                }
            }
            throw new IndexOutOfBoundsException();
        }
    }

    /* loaded from: classes6.dex */
    public final class ZoneTextPrinterParser extends ZoneIdPrinterParser {
        private static final ConcurrentHashMap KClassImpl$Data$declaredNonStaticMembers$2 = new ConcurrentHashMap();
        private final TextStyle BuiltInFictitiousFunctionClassFactory;
        private final HashMap PlaceComponentResult;
        private final HashMap getAuthRequestContext;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public ZoneTextPrinterParser(j$.time.format.TextStyle r4) {
            /*
                r3 = this;
                j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda0 r0 = j$.time.temporal.Temporal.CC.getErrorConfigVersion()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "ZoneText("
                r1.append(r2)
                r1.append(r4)
                java.lang.String r2 = ")"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r3.<init>(r0, r1)
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                r3.PlaceComponentResult = r0
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                r3.getAuthRequestContext = r0
                if (r4 == 0) goto L30
                r3.BuiltInFictitiousFunctionClassFactory = r4
                return
            L30:
                java.lang.NullPointerException r4 = new java.lang.NullPointerException
                java.lang.String r0 = "textStyle"
                r4.<init>(r0)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.time.format.DateTimeFormatterBuilder.ZoneTextPrinterParser.<init>(j$.time.format.TextStyle):void");
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.ZoneIdPrinterParser, j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public final boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            String[] strArr;
            ZoneId zoneId = (ZoneId) dateTimePrintContext.KClassImpl$Data$declaredNonStaticMembers$2(Temporal.CC.moveToNextValue());
            if (zoneId == null) {
                return false;
            }
            String id2 = zoneId.getId();
            if (!(zoneId instanceof ZoneOffset)) {
                TemporalAccessor temporalAccessor = dateTimePrintContext.PlaceComponentResult;
                char c = temporalAccessor.isSupported(ChronoField.INSTANT_SECONDS) ? zoneId.getRules().isDaylightSavings(Instant.from(temporalAccessor)) ? (char) 1 : (char) 0 : (char) 2;
                Locale locale = dateTimePrintContext.BuiltInFictitiousFunctionClassFactory.scheduleImpl;
                String str = null;
                Map map = null;
                if (this.BuiltInFictitiousFunctionClassFactory != TextStyle.NARROW) {
                    ConcurrentHashMap concurrentHashMap = KClassImpl$Data$declaredNonStaticMembers$2;
                    SoftReference softReference = (SoftReference) concurrentHashMap.get(id2);
                    if (softReference == null || (map = (Map) softReference.get()) == null || (strArr = (String[]) map.get(locale)) == null) {
                        TimeZone timeZone = TimeZone.getTimeZone(id2);
                        String[] strArr2 = {id2, timeZone.getDisplayName(false, 1, locale), timeZone.getDisplayName(false, 0, locale), timeZone.getDisplayName(true, 1, locale), timeZone.getDisplayName(true, 0, locale), id2, id2};
                        if (map == null) {
                            map = new ConcurrentHashMap();
                        }
                        map.put(locale, strArr2);
                        concurrentHashMap.put(id2, new SoftReference(map));
                        strArr = strArr2;
                    }
                    int zoneNameStyleIndex = this.BuiltInFictitiousFunctionClassFactory.zoneNameStyleIndex();
                    str = c != 0 ? c != 1 ? strArr[zoneNameStyleIndex + 5] : strArr[zoneNameStyleIndex + 3] : strArr[zoneNameStyleIndex + 1];
                }
                if (str != null) {
                    id2 = str;
                }
            }
            sb.append(id2);
            return true;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.ZoneIdPrinterParser
        protected final PrefixTree PlaceComponentResult(DateTimeParseContext dateTimeParseContext) {
            PrefixTree MyBillsEntityDataFactory;
            if (this.BuiltInFictitiousFunctionClassFactory == TextStyle.NARROW) {
                return super.PlaceComponentResult(dateTimeParseContext);
            }
            Locale locale = dateTimeParseContext.BuiltInFictitiousFunctionClassFactory.scheduleImpl;
            boolean KClassImpl$Data$declaredNonStaticMembers$22 = dateTimeParseContext.KClassImpl$Data$declaredNonStaticMembers$2();
            HashSet PlaceComponentResult = ZoneRulesProvider.PlaceComponentResult();
            int size = PlaceComponentResult.size();
            HashMap hashMap = KClassImpl$Data$declaredNonStaticMembers$22 ? this.PlaceComponentResult : this.getAuthRequestContext;
            Map.Entry entry = (Map.Entry) hashMap.get(locale);
            if (entry == null || ((Integer) entry.getKey()).intValue() != size || (MyBillsEntityDataFactory = (PrefixTree) ((SoftReference) entry.getValue()).get()) == null) {
                MyBillsEntityDataFactory = PrefixTree.MyBillsEntityDataFactory(dateTimeParseContext);
                for (String[] strArr : DateFormatSymbols.getInstance(locale).getZoneStrings()) {
                    String str = strArr[0];
                    if (PlaceComponentResult.contains(str)) {
                        MyBillsEntityDataFactory.getAuthRequestContext(str, str);
                        String MyBillsEntityDataFactory2 = ZoneName.MyBillsEntityDataFactory(str, locale);
                        for (int i = this.BuiltInFictitiousFunctionClassFactory == TextStyle.FULL ? 1 : 2; i < strArr.length; i += 2) {
                            MyBillsEntityDataFactory.getAuthRequestContext(strArr[i], MyBillsEntityDataFactory2);
                        }
                    }
                }
                hashMap.put(locale, new AbstractMap.SimpleImmutableEntry(Integer.valueOf(size), new SoftReference(MyBillsEntityDataFactory)));
            }
            return MyBillsEntityDataFactory;
        }
    }
}

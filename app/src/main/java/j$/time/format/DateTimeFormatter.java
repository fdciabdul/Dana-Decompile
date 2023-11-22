package j$.time.format;

import id.dana.cashier.view.InputCardNumberView;
import j$.time.DateTimeException;
import j$.time.ZoneId;
import j$.time.chrono.Chronology;
import j$.time.chrono.IsoChronology;
import j$.time.format.DateTimeFormatterBuilder;
import j$.time.temporal.ChronoField;
import j$.time.temporal.IsoFields;
import j$.time.temporal.TemporalAccessor;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes6.dex */
public final class DateTimeFormatter {
    public static final DateTimeFormatter MyBillsEntityDataFactory;
    public static final DateTimeFormatter PlaceComponentResult;
    public static final DateTimeFormatter getAuthRequestContext;
    final DecimalStyle BuiltInFictitiousFunctionClassFactory;
    final Chronology KClassImpl$Data$declaredNonStaticMembers$2;
    private final Set NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final ResolverStyle getErrorConfigVersion;
    final ZoneId lookAheadTest;
    final DateTimeFormatterBuilder.CompositePrinterParser moveToNextValue;
    final Locale scheduleImpl;

    public DateTimeFormatter(DateTimeFormatterBuilder.CompositePrinterParser compositePrinterParser, Locale locale, ResolverStyle resolverStyle, IsoChronology isoChronology) {
        DecimalStyle decimalStyle = DecimalStyle.getAuthRequestContext;
        this.moveToNextValue = compositePrinterParser;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        if (locale == null) {
            throw new NullPointerException("locale");
        }
        this.scheduleImpl = locale;
        this.BuiltInFictitiousFunctionClassFactory = decimalStyle;
        if (resolverStyle == null) {
            throw new NullPointerException("resolverStyle");
        }
        this.getErrorConfigVersion = resolverStyle;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = isoChronology;
        this.lookAheadTest = null;
    }

    public final String MyBillsEntityDataFactory(TemporalAccessor temporalAccessor) {
        StringBuilder sb = new StringBuilder(32);
        if (temporalAccessor != null) {
            try {
                this.moveToNextValue.format(new DateTimePrintContext(temporalAccessor, this), sb);
                return sb.toString();
            } catch (IOException e) {
                throw new DateTimeException(e.getMessage(), e);
            }
        }
        throw new NullPointerException("temporal");
    }

    public final String toString() {
        String obj = this.moveToNextValue.toString();
        return !obj.startsWith("[") ? obj.substring(1, obj.length() - 1) : obj;
    }

    static {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        ChronoField chronoField = ChronoField.YEAR;
        dateTimeFormatterBuilder.MyBillsEntityDataFactory(chronoField, 4, 10, 5);
        dateTimeFormatterBuilder.BuiltInFictitiousFunctionClassFactory(new DateTimeFormatterBuilder.CharLiteralPrinterParser('-'));
        ChronoField chronoField2 = ChronoField.MONTH_OF_YEAR;
        dateTimeFormatterBuilder.MyBillsEntityDataFactory(chronoField2, 2);
        dateTimeFormatterBuilder.BuiltInFictitiousFunctionClassFactory(new DateTimeFormatterBuilder.CharLiteralPrinterParser('-'));
        ChronoField chronoField3 = ChronoField.DAY_OF_MONTH;
        dateTimeFormatterBuilder.MyBillsEntityDataFactory(chronoField3, 2);
        ResolverStyle resolverStyle = ResolverStyle.STRICT;
        IsoChronology isoChronology = IsoChronology.INSTANCE;
        DateTimeFormatter BuiltInFictitiousFunctionClassFactory = dateTimeFormatterBuilder.BuiltInFictitiousFunctionClassFactory(Locale.getDefault(), resolverStyle, isoChronology);
        MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
        DateTimeFormatterBuilder dateTimeFormatterBuilder2 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder2.BuiltInFictitiousFunctionClassFactory(DateTimeFormatterBuilder.SettingsParser.INSENSITIVE);
        DateTimeFormatterBuilder.CompositePrinterParser compositePrinterParser = BuiltInFictitiousFunctionClassFactory.moveToNextValue;
        if (compositePrinterParser.KClassImpl$Data$declaredNonStaticMembers$2) {
            compositePrinterParser = new DateTimeFormatterBuilder.CompositePrinterParser(compositePrinterParser.getAuthRequestContext, false);
        }
        dateTimeFormatterBuilder2.BuiltInFictitiousFunctionClassFactory(compositePrinterParser);
        dateTimeFormatterBuilder2.BuiltInFictitiousFunctionClassFactory(DateTimeFormatterBuilder.OffsetIdPrinterParser.BuiltInFictitiousFunctionClassFactory);
        dateTimeFormatterBuilder2.BuiltInFictitiousFunctionClassFactory(Locale.getDefault(), resolverStyle, isoChronology);
        DateTimeFormatterBuilder dateTimeFormatterBuilder3 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder3.BuiltInFictitiousFunctionClassFactory(DateTimeFormatterBuilder.SettingsParser.INSENSITIVE);
        DateTimeFormatterBuilder.CompositePrinterParser compositePrinterParser2 = BuiltInFictitiousFunctionClassFactory.moveToNextValue;
        if (compositePrinterParser2.KClassImpl$Data$declaredNonStaticMembers$2) {
            compositePrinterParser2 = new DateTimeFormatterBuilder.CompositePrinterParser(compositePrinterParser2.getAuthRequestContext, false);
        }
        dateTimeFormatterBuilder3.BuiltInFictitiousFunctionClassFactory(compositePrinterParser2);
        DateTimeFormatterBuilder dateTimeFormatterBuilder4 = dateTimeFormatterBuilder3.PlaceComponentResult;
        dateTimeFormatterBuilder4.moveToNextValue = -1;
        dateTimeFormatterBuilder3.PlaceComponentResult = new DateTimeFormatterBuilder(dateTimeFormatterBuilder4);
        dateTimeFormatterBuilder3.BuiltInFictitiousFunctionClassFactory(DateTimeFormatterBuilder.OffsetIdPrinterParser.BuiltInFictitiousFunctionClassFactory);
        dateTimeFormatterBuilder3.BuiltInFictitiousFunctionClassFactory(Locale.getDefault(), resolverStyle, isoChronology);
        DateTimeFormatterBuilder dateTimeFormatterBuilder5 = new DateTimeFormatterBuilder();
        ChronoField chronoField4 = ChronoField.HOUR_OF_DAY;
        dateTimeFormatterBuilder5.MyBillsEntityDataFactory(chronoField4, 2);
        dateTimeFormatterBuilder5.BuiltInFictitiousFunctionClassFactory(new DateTimeFormatterBuilder.CharLiteralPrinterParser(':'));
        ChronoField chronoField5 = ChronoField.MINUTE_OF_HOUR;
        dateTimeFormatterBuilder5.MyBillsEntityDataFactory(chronoField5, 2);
        DateTimeFormatterBuilder dateTimeFormatterBuilder6 = dateTimeFormatterBuilder5.PlaceComponentResult;
        dateTimeFormatterBuilder6.moveToNextValue = -1;
        dateTimeFormatterBuilder5.PlaceComponentResult = new DateTimeFormatterBuilder(dateTimeFormatterBuilder6);
        dateTimeFormatterBuilder5.BuiltInFictitiousFunctionClassFactory(new DateTimeFormatterBuilder.CharLiteralPrinterParser(':'));
        ChronoField chronoField6 = ChronoField.SECOND_OF_MINUTE;
        dateTimeFormatterBuilder5.MyBillsEntityDataFactory(chronoField6, 2);
        DateTimeFormatterBuilder dateTimeFormatterBuilder7 = dateTimeFormatterBuilder5.PlaceComponentResult;
        dateTimeFormatterBuilder7.moveToNextValue = -1;
        dateTimeFormatterBuilder5.PlaceComponentResult = new DateTimeFormatterBuilder(dateTimeFormatterBuilder7);
        dateTimeFormatterBuilder5.BuiltInFictitiousFunctionClassFactory(new DateTimeFormatterBuilder.FractionPrinterParser(ChronoField.NANO_OF_SECOND, 0, 9, true));
        DateTimeFormatter BuiltInFictitiousFunctionClassFactory2 = dateTimeFormatterBuilder5.BuiltInFictitiousFunctionClassFactory(Locale.getDefault(), resolverStyle, null);
        DateTimeFormatterBuilder dateTimeFormatterBuilder8 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder8.BuiltInFictitiousFunctionClassFactory(DateTimeFormatterBuilder.SettingsParser.INSENSITIVE);
        DateTimeFormatterBuilder.CompositePrinterParser compositePrinterParser3 = BuiltInFictitiousFunctionClassFactory2.moveToNextValue;
        if (compositePrinterParser3.KClassImpl$Data$declaredNonStaticMembers$2) {
            compositePrinterParser3 = new DateTimeFormatterBuilder.CompositePrinterParser(compositePrinterParser3.getAuthRequestContext, false);
        }
        dateTimeFormatterBuilder8.BuiltInFictitiousFunctionClassFactory(compositePrinterParser3);
        dateTimeFormatterBuilder8.BuiltInFictitiousFunctionClassFactory(DateTimeFormatterBuilder.OffsetIdPrinterParser.BuiltInFictitiousFunctionClassFactory);
        dateTimeFormatterBuilder8.BuiltInFictitiousFunctionClassFactory(Locale.getDefault(), resolverStyle, null);
        DateTimeFormatterBuilder dateTimeFormatterBuilder9 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder9.BuiltInFictitiousFunctionClassFactory(DateTimeFormatterBuilder.SettingsParser.INSENSITIVE);
        DateTimeFormatterBuilder.CompositePrinterParser compositePrinterParser4 = BuiltInFictitiousFunctionClassFactory2.moveToNextValue;
        if (compositePrinterParser4.KClassImpl$Data$declaredNonStaticMembers$2) {
            compositePrinterParser4 = new DateTimeFormatterBuilder.CompositePrinterParser(compositePrinterParser4.getAuthRequestContext, false);
        }
        dateTimeFormatterBuilder9.BuiltInFictitiousFunctionClassFactory(compositePrinterParser4);
        DateTimeFormatterBuilder dateTimeFormatterBuilder10 = dateTimeFormatterBuilder9.PlaceComponentResult;
        dateTimeFormatterBuilder10.moveToNextValue = -1;
        dateTimeFormatterBuilder9.PlaceComponentResult = new DateTimeFormatterBuilder(dateTimeFormatterBuilder10);
        dateTimeFormatterBuilder9.BuiltInFictitiousFunctionClassFactory(DateTimeFormatterBuilder.OffsetIdPrinterParser.BuiltInFictitiousFunctionClassFactory);
        dateTimeFormatterBuilder9.BuiltInFictitiousFunctionClassFactory(Locale.getDefault(), resolverStyle, null);
        DateTimeFormatterBuilder dateTimeFormatterBuilder11 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder11.BuiltInFictitiousFunctionClassFactory(DateTimeFormatterBuilder.SettingsParser.INSENSITIVE);
        DateTimeFormatterBuilder.CompositePrinterParser compositePrinterParser5 = BuiltInFictitiousFunctionClassFactory.moveToNextValue;
        if (compositePrinterParser5.KClassImpl$Data$declaredNonStaticMembers$2) {
            compositePrinterParser5 = new DateTimeFormatterBuilder.CompositePrinterParser(compositePrinterParser5.getAuthRequestContext, false);
        }
        dateTimeFormatterBuilder11.BuiltInFictitiousFunctionClassFactory(compositePrinterParser5);
        dateTimeFormatterBuilder11.BuiltInFictitiousFunctionClassFactory(new DateTimeFormatterBuilder.CharLiteralPrinterParser('T'));
        DateTimeFormatterBuilder.CompositePrinterParser compositePrinterParser6 = BuiltInFictitiousFunctionClassFactory2.moveToNextValue;
        if (compositePrinterParser6.KClassImpl$Data$declaredNonStaticMembers$2) {
            compositePrinterParser6 = new DateTimeFormatterBuilder.CompositePrinterParser(compositePrinterParser6.getAuthRequestContext, false);
        }
        dateTimeFormatterBuilder11.BuiltInFictitiousFunctionClassFactory(compositePrinterParser6);
        DateTimeFormatter BuiltInFictitiousFunctionClassFactory3 = dateTimeFormatterBuilder11.BuiltInFictitiousFunctionClassFactory(Locale.getDefault(), resolverStyle, isoChronology);
        DateTimeFormatterBuilder dateTimeFormatterBuilder12 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder12.BuiltInFictitiousFunctionClassFactory(DateTimeFormatterBuilder.SettingsParser.INSENSITIVE);
        DateTimeFormatterBuilder.CompositePrinterParser compositePrinterParser7 = BuiltInFictitiousFunctionClassFactory3.moveToNextValue;
        if (compositePrinterParser7.KClassImpl$Data$declaredNonStaticMembers$2) {
            compositePrinterParser7 = new DateTimeFormatterBuilder.CompositePrinterParser(compositePrinterParser7.getAuthRequestContext, false);
        }
        dateTimeFormatterBuilder12.BuiltInFictitiousFunctionClassFactory(compositePrinterParser7);
        dateTimeFormatterBuilder12.BuiltInFictitiousFunctionClassFactory(DateTimeFormatterBuilder.OffsetIdPrinterParser.BuiltInFictitiousFunctionClassFactory);
        DateTimeFormatter BuiltInFictitiousFunctionClassFactory4 = dateTimeFormatterBuilder12.BuiltInFictitiousFunctionClassFactory(Locale.getDefault(), resolverStyle, isoChronology);
        DateTimeFormatterBuilder dateTimeFormatterBuilder13 = new DateTimeFormatterBuilder();
        DateTimeFormatterBuilder.CompositePrinterParser compositePrinterParser8 = BuiltInFictitiousFunctionClassFactory4.moveToNextValue;
        if (compositePrinterParser8.KClassImpl$Data$declaredNonStaticMembers$2) {
            compositePrinterParser8 = new DateTimeFormatterBuilder.CompositePrinterParser(compositePrinterParser8.getAuthRequestContext, false);
        }
        dateTimeFormatterBuilder13.BuiltInFictitiousFunctionClassFactory(compositePrinterParser8);
        DateTimeFormatterBuilder dateTimeFormatterBuilder14 = dateTimeFormatterBuilder13.PlaceComponentResult;
        dateTimeFormatterBuilder14.moveToNextValue = -1;
        dateTimeFormatterBuilder13.PlaceComponentResult = new DateTimeFormatterBuilder(dateTimeFormatterBuilder14);
        dateTimeFormatterBuilder13.BuiltInFictitiousFunctionClassFactory(new DateTimeFormatterBuilder.CharLiteralPrinterParser('['));
        dateTimeFormatterBuilder13.BuiltInFictitiousFunctionClassFactory(DateTimeFormatterBuilder.SettingsParser.SENSITIVE);
        dateTimeFormatterBuilder13.BuiltInFictitiousFunctionClassFactory(new DateTimeFormatterBuilder.ZoneIdPrinterParser(DateTimeFormatterBuilder.KClassImpl$Data$declaredNonStaticMembers$2, "ZoneRegionId()"));
        dateTimeFormatterBuilder13.BuiltInFictitiousFunctionClassFactory(new DateTimeFormatterBuilder.CharLiteralPrinterParser(']'));
        dateTimeFormatterBuilder13.BuiltInFictitiousFunctionClassFactory(Locale.getDefault(), resolverStyle, isoChronology);
        DateTimeFormatterBuilder dateTimeFormatterBuilder15 = new DateTimeFormatterBuilder();
        DateTimeFormatterBuilder.CompositePrinterParser compositePrinterParser9 = BuiltInFictitiousFunctionClassFactory3.moveToNextValue;
        if (compositePrinterParser9.KClassImpl$Data$declaredNonStaticMembers$2) {
            compositePrinterParser9 = new DateTimeFormatterBuilder.CompositePrinterParser(compositePrinterParser9.getAuthRequestContext, false);
        }
        dateTimeFormatterBuilder15.BuiltInFictitiousFunctionClassFactory(compositePrinterParser9);
        DateTimeFormatterBuilder dateTimeFormatterBuilder16 = dateTimeFormatterBuilder15.PlaceComponentResult;
        dateTimeFormatterBuilder16.moveToNextValue = -1;
        dateTimeFormatterBuilder15.PlaceComponentResult = new DateTimeFormatterBuilder(dateTimeFormatterBuilder16);
        dateTimeFormatterBuilder15.BuiltInFictitiousFunctionClassFactory(DateTimeFormatterBuilder.OffsetIdPrinterParser.BuiltInFictitiousFunctionClassFactory);
        DateTimeFormatterBuilder dateTimeFormatterBuilder17 = dateTimeFormatterBuilder15.PlaceComponentResult;
        dateTimeFormatterBuilder17.moveToNextValue = -1;
        dateTimeFormatterBuilder15.PlaceComponentResult = new DateTimeFormatterBuilder(dateTimeFormatterBuilder17);
        dateTimeFormatterBuilder15.BuiltInFictitiousFunctionClassFactory(new DateTimeFormatterBuilder.CharLiteralPrinterParser('['));
        dateTimeFormatterBuilder15.BuiltInFictitiousFunctionClassFactory(DateTimeFormatterBuilder.SettingsParser.SENSITIVE);
        dateTimeFormatterBuilder15.BuiltInFictitiousFunctionClassFactory(new DateTimeFormatterBuilder.ZoneIdPrinterParser(DateTimeFormatterBuilder.KClassImpl$Data$declaredNonStaticMembers$2, "ZoneRegionId()"));
        dateTimeFormatterBuilder15.BuiltInFictitiousFunctionClassFactory(new DateTimeFormatterBuilder.CharLiteralPrinterParser(']'));
        PlaceComponentResult = dateTimeFormatterBuilder15.BuiltInFictitiousFunctionClassFactory(Locale.getDefault(), resolverStyle, isoChronology);
        DateTimeFormatterBuilder dateTimeFormatterBuilder18 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder18.BuiltInFictitiousFunctionClassFactory(DateTimeFormatterBuilder.SettingsParser.INSENSITIVE);
        dateTimeFormatterBuilder18.MyBillsEntityDataFactory(chronoField, 4, 10, 5);
        dateTimeFormatterBuilder18.BuiltInFictitiousFunctionClassFactory(new DateTimeFormatterBuilder.CharLiteralPrinterParser('-'));
        dateTimeFormatterBuilder18.MyBillsEntityDataFactory(ChronoField.DAY_OF_YEAR, 3);
        DateTimeFormatterBuilder dateTimeFormatterBuilder19 = dateTimeFormatterBuilder18.PlaceComponentResult;
        dateTimeFormatterBuilder19.moveToNextValue = -1;
        dateTimeFormatterBuilder18.PlaceComponentResult = new DateTimeFormatterBuilder(dateTimeFormatterBuilder19);
        dateTimeFormatterBuilder18.BuiltInFictitiousFunctionClassFactory(DateTimeFormatterBuilder.OffsetIdPrinterParser.BuiltInFictitiousFunctionClassFactory);
        dateTimeFormatterBuilder18.BuiltInFictitiousFunctionClassFactory(Locale.getDefault(), resolverStyle, isoChronology);
        DateTimeFormatterBuilder dateTimeFormatterBuilder20 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder20.BuiltInFictitiousFunctionClassFactory(DateTimeFormatterBuilder.SettingsParser.INSENSITIVE);
        dateTimeFormatterBuilder20.MyBillsEntityDataFactory(IsoFields.MyBillsEntityDataFactory, 4, 10, 5);
        dateTimeFormatterBuilder20.PlaceComponentResult("-W");
        dateTimeFormatterBuilder20.MyBillsEntityDataFactory(IsoFields.KClassImpl$Data$declaredNonStaticMembers$2, 2);
        dateTimeFormatterBuilder20.BuiltInFictitiousFunctionClassFactory(new DateTimeFormatterBuilder.CharLiteralPrinterParser('-'));
        ChronoField chronoField7 = ChronoField.DAY_OF_WEEK;
        dateTimeFormatterBuilder20.MyBillsEntityDataFactory(chronoField7, 1);
        DateTimeFormatterBuilder dateTimeFormatterBuilder21 = dateTimeFormatterBuilder20.PlaceComponentResult;
        dateTimeFormatterBuilder21.moveToNextValue = -1;
        dateTimeFormatterBuilder20.PlaceComponentResult = new DateTimeFormatterBuilder(dateTimeFormatterBuilder21);
        dateTimeFormatterBuilder20.BuiltInFictitiousFunctionClassFactory(DateTimeFormatterBuilder.OffsetIdPrinterParser.BuiltInFictitiousFunctionClassFactory);
        dateTimeFormatterBuilder20.BuiltInFictitiousFunctionClassFactory(Locale.getDefault(), resolverStyle, isoChronology);
        DateTimeFormatterBuilder dateTimeFormatterBuilder22 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder22.BuiltInFictitiousFunctionClassFactory(DateTimeFormatterBuilder.SettingsParser.INSENSITIVE);
        dateTimeFormatterBuilder22.BuiltInFictitiousFunctionClassFactory(new DateTimeFormatterBuilder.InstantPrinterParser());
        getAuthRequestContext = dateTimeFormatterBuilder22.BuiltInFictitiousFunctionClassFactory(Locale.getDefault(), resolverStyle, null);
        DateTimeFormatterBuilder dateTimeFormatterBuilder23 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder23.BuiltInFictitiousFunctionClassFactory(DateTimeFormatterBuilder.SettingsParser.INSENSITIVE);
        dateTimeFormatterBuilder23.MyBillsEntityDataFactory(chronoField, 4);
        dateTimeFormatterBuilder23.MyBillsEntityDataFactory(chronoField2, 2);
        dateTimeFormatterBuilder23.MyBillsEntityDataFactory(chronoField3, 2);
        DateTimeFormatterBuilder dateTimeFormatterBuilder24 = dateTimeFormatterBuilder23.PlaceComponentResult;
        dateTimeFormatterBuilder24.moveToNextValue = -1;
        dateTimeFormatterBuilder23.PlaceComponentResult = new DateTimeFormatterBuilder(dateTimeFormatterBuilder24);
        dateTimeFormatterBuilder23.BuiltInFictitiousFunctionClassFactory(new DateTimeFormatterBuilder.OffsetIdPrinterParser("+HHMMss", "Z"));
        dateTimeFormatterBuilder23.BuiltInFictitiousFunctionClassFactory(Locale.getDefault(), resolverStyle, isoChronology);
        HashMap hashMap = new HashMap();
        hashMap.put(1L, "Mon");
        hashMap.put(2L, "Tue");
        hashMap.put(3L, "Wed");
        hashMap.put(4L, "Thu");
        hashMap.put(5L, "Fri");
        hashMap.put(6L, "Sat");
        hashMap.put(7L, "Sun");
        HashMap hashMap2 = new HashMap();
        hashMap2.put(1L, "Jan");
        hashMap2.put(2L, "Feb");
        hashMap2.put(3L, "Mar");
        hashMap2.put(4L, "Apr");
        hashMap2.put(5L, "May");
        hashMap2.put(6L, "Jun");
        hashMap2.put(7L, "Jul");
        hashMap2.put(8L, "Aug");
        hashMap2.put(9L, "Sep");
        hashMap2.put(10L, "Oct");
        hashMap2.put(11L, "Nov");
        hashMap2.put(12L, "Dec");
        DateTimeFormatterBuilder dateTimeFormatterBuilder25 = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder25.BuiltInFictitiousFunctionClassFactory(DateTimeFormatterBuilder.SettingsParser.INSENSITIVE);
        dateTimeFormatterBuilder25.BuiltInFictitiousFunctionClassFactory(DateTimeFormatterBuilder.SettingsParser.LENIENT);
        DateTimeFormatterBuilder dateTimeFormatterBuilder26 = dateTimeFormatterBuilder25.PlaceComponentResult;
        dateTimeFormatterBuilder26.moveToNextValue = -1;
        dateTimeFormatterBuilder25.PlaceComponentResult = new DateTimeFormatterBuilder(dateTimeFormatterBuilder26);
        dateTimeFormatterBuilder25.KClassImpl$Data$declaredNonStaticMembers$2(chronoField7, hashMap);
        dateTimeFormatterBuilder25.PlaceComponentResult(", ");
        dateTimeFormatterBuilder25.getAuthRequestContext();
        dateTimeFormatterBuilder25.MyBillsEntityDataFactory(chronoField3, 1, 2, 4);
        dateTimeFormatterBuilder25.BuiltInFictitiousFunctionClassFactory(new DateTimeFormatterBuilder.CharLiteralPrinterParser(InputCardNumberView.DIVIDER));
        dateTimeFormatterBuilder25.KClassImpl$Data$declaredNonStaticMembers$2(chronoField2, hashMap2);
        dateTimeFormatterBuilder25.BuiltInFictitiousFunctionClassFactory(new DateTimeFormatterBuilder.CharLiteralPrinterParser(InputCardNumberView.DIVIDER));
        dateTimeFormatterBuilder25.MyBillsEntityDataFactory(chronoField, 4);
        dateTimeFormatterBuilder25.BuiltInFictitiousFunctionClassFactory(new DateTimeFormatterBuilder.CharLiteralPrinterParser(InputCardNumberView.DIVIDER));
        dateTimeFormatterBuilder25.MyBillsEntityDataFactory(chronoField4, 2);
        dateTimeFormatterBuilder25.BuiltInFictitiousFunctionClassFactory(new DateTimeFormatterBuilder.CharLiteralPrinterParser(':'));
        dateTimeFormatterBuilder25.MyBillsEntityDataFactory(chronoField5, 2);
        DateTimeFormatterBuilder dateTimeFormatterBuilder27 = dateTimeFormatterBuilder25.PlaceComponentResult;
        dateTimeFormatterBuilder27.moveToNextValue = -1;
        dateTimeFormatterBuilder25.PlaceComponentResult = new DateTimeFormatterBuilder(dateTimeFormatterBuilder27);
        dateTimeFormatterBuilder25.BuiltInFictitiousFunctionClassFactory(new DateTimeFormatterBuilder.CharLiteralPrinterParser(':'));
        dateTimeFormatterBuilder25.MyBillsEntityDataFactory(chronoField6, 2);
        dateTimeFormatterBuilder25.getAuthRequestContext();
        dateTimeFormatterBuilder25.BuiltInFictitiousFunctionClassFactory(new DateTimeFormatterBuilder.CharLiteralPrinterParser(InputCardNumberView.DIVIDER));
        dateTimeFormatterBuilder25.BuiltInFictitiousFunctionClassFactory(new DateTimeFormatterBuilder.OffsetIdPrinterParser("+HHMM", "GMT"));
        dateTimeFormatterBuilder25.BuiltInFictitiousFunctionClassFactory(Locale.getDefault(), ResolverStyle.SMART, isoChronology);
    }

    /* JADX WARN: Code restructure failed: missing block: B:385:0x00eb, code lost:
    
        if (r3 == 1) goto L457;
     */
    /* JADX WARN: Removed duplicated region for block: B:453:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:492:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:564:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:607:0x02c8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:622:0x0406 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:623:0x0203 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static j$.time.format.DateTimeFormatter MyBillsEntityDataFactory(java.lang.String r16) {
        /*
            Method dump skipped, instructions count: 1198
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.DateTimeFormatter.MyBillsEntityDataFactory(java.lang.String):j$.time.format.DateTimeFormatter");
    }

    /* JADX WARN: Removed duplicated region for block: B:273:0x01d4 A[Catch: RuntimeException -> 0x03f9, DateTimeParseException -> 0x0441, TryCatch #2 {DateTimeParseException -> 0x0441, RuntimeException -> 0x03f9, blocks: (B:200:0x000e, B:202:0x0015, B:204:0x0026, B:207:0x0032, B:209:0x0038, B:211:0x0042, B:213:0x005e, B:214:0x0062, B:216:0x0066, B:217:0x006f, B:222:0x0091, B:223:0x009b, B:225:0x00a1, B:227:0x00b7, B:229:0x00bb, B:231:0x00c1, B:234:0x00d2, B:232:0x00c8, B:235:0x00d7, B:236:0x00eb, B:237:0x00ec, B:239:0x00f0, B:250:0x0129, B:240:0x0103, B:242:0x0107, B:243:0x010d, B:245:0x0111, B:246:0x0119, B:247:0x0120, B:248:0x0121, B:253:0x0131, B:254:0x0145, B:255:0x014c, B:256:0x014d, B:258:0x0158, B:260:0x0162, B:262:0x0178, B:264:0x018d, B:269:0x01bb, B:270:0x01c5, B:271:0x01c8, B:273:0x01d4, B:302:0x027c, B:304:0x0280, B:305:0x0283, B:307:0x0287, B:309:0x028e, B:311:0x0296, B:312:0x02a1, B:314:0x02a5, B:316:0x02a9, B:321:0x02b4, B:322:0x02c0, B:324:0x02c4, B:326:0x02ce, B:328:0x02d8, B:330:0x02e2, B:332:0x02ec, B:333:0x0312, B:334:0x0331, B:336:0x0335, B:338:0x0339, B:340:0x033d, B:344:0x0368, B:341:0x0348, B:343:0x0354, B:345:0x0377, B:281:0x0200, B:284:0x0209, B:287:0x0212, B:289:0x0219, B:265:0x019a, B:266:0x01a5, B:268:0x01af, B:290:0x0238, B:292:0x023e, B:294:0x0246, B:295:0x0250, B:297:0x0256, B:299:0x0266, B:301:0x026c, B:347:0x0380, B:349:0x0388, B:351:0x03a5, B:353:0x03ab, B:354:0x03ce, B:355:0x03cf, B:356:0x03f2, B:350:0x03a1, B:205:0x002d, B:357:0x03f3, B:358:0x03f8), top: B:372:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0280 A[Catch: RuntimeException -> 0x03f9, DateTimeParseException -> 0x0441, TryCatch #2 {DateTimeParseException -> 0x0441, RuntimeException -> 0x03f9, blocks: (B:200:0x000e, B:202:0x0015, B:204:0x0026, B:207:0x0032, B:209:0x0038, B:211:0x0042, B:213:0x005e, B:214:0x0062, B:216:0x0066, B:217:0x006f, B:222:0x0091, B:223:0x009b, B:225:0x00a1, B:227:0x00b7, B:229:0x00bb, B:231:0x00c1, B:234:0x00d2, B:232:0x00c8, B:235:0x00d7, B:236:0x00eb, B:237:0x00ec, B:239:0x00f0, B:250:0x0129, B:240:0x0103, B:242:0x0107, B:243:0x010d, B:245:0x0111, B:246:0x0119, B:247:0x0120, B:248:0x0121, B:253:0x0131, B:254:0x0145, B:255:0x014c, B:256:0x014d, B:258:0x0158, B:260:0x0162, B:262:0x0178, B:264:0x018d, B:269:0x01bb, B:270:0x01c5, B:271:0x01c8, B:273:0x01d4, B:302:0x027c, B:304:0x0280, B:305:0x0283, B:307:0x0287, B:309:0x028e, B:311:0x0296, B:312:0x02a1, B:314:0x02a5, B:316:0x02a9, B:321:0x02b4, B:322:0x02c0, B:324:0x02c4, B:326:0x02ce, B:328:0x02d8, B:330:0x02e2, B:332:0x02ec, B:333:0x0312, B:334:0x0331, B:336:0x0335, B:338:0x0339, B:340:0x033d, B:344:0x0368, B:341:0x0348, B:343:0x0354, B:345:0x0377, B:281:0x0200, B:284:0x0209, B:287:0x0212, B:289:0x0219, B:265:0x019a, B:266:0x01a5, B:268:0x01af, B:290:0x0238, B:292:0x023e, B:294:0x0246, B:295:0x0250, B:297:0x0256, B:299:0x0266, B:301:0x026c, B:347:0x0380, B:349:0x0388, B:351:0x03a5, B:353:0x03ab, B:354:0x03ce, B:355:0x03cf, B:356:0x03f2, B:350:0x03a1, B:205:0x002d, B:357:0x03f3, B:358:0x03f8), top: B:372:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0287 A[Catch: RuntimeException -> 0x03f9, DateTimeParseException -> 0x0441, TryCatch #2 {DateTimeParseException -> 0x0441, RuntimeException -> 0x03f9, blocks: (B:200:0x000e, B:202:0x0015, B:204:0x0026, B:207:0x0032, B:209:0x0038, B:211:0x0042, B:213:0x005e, B:214:0x0062, B:216:0x0066, B:217:0x006f, B:222:0x0091, B:223:0x009b, B:225:0x00a1, B:227:0x00b7, B:229:0x00bb, B:231:0x00c1, B:234:0x00d2, B:232:0x00c8, B:235:0x00d7, B:236:0x00eb, B:237:0x00ec, B:239:0x00f0, B:250:0x0129, B:240:0x0103, B:242:0x0107, B:243:0x010d, B:245:0x0111, B:246:0x0119, B:247:0x0120, B:248:0x0121, B:253:0x0131, B:254:0x0145, B:255:0x014c, B:256:0x014d, B:258:0x0158, B:260:0x0162, B:262:0x0178, B:264:0x018d, B:269:0x01bb, B:270:0x01c5, B:271:0x01c8, B:273:0x01d4, B:302:0x027c, B:304:0x0280, B:305:0x0283, B:307:0x0287, B:309:0x028e, B:311:0x0296, B:312:0x02a1, B:314:0x02a5, B:316:0x02a9, B:321:0x02b4, B:322:0x02c0, B:324:0x02c4, B:326:0x02ce, B:328:0x02d8, B:330:0x02e2, B:332:0x02ec, B:333:0x0312, B:334:0x0331, B:336:0x0335, B:338:0x0339, B:340:0x033d, B:344:0x0368, B:341:0x0348, B:343:0x0354, B:345:0x0377, B:281:0x0200, B:284:0x0209, B:287:0x0212, B:289:0x0219, B:265:0x019a, B:266:0x01a5, B:268:0x01af, B:290:0x0238, B:292:0x023e, B:294:0x0246, B:295:0x0250, B:297:0x0256, B:299:0x0266, B:301:0x026c, B:347:0x0380, B:349:0x0388, B:351:0x03a5, B:353:0x03ab, B:354:0x03ce, B:355:0x03cf, B:356:0x03f2, B:350:0x03a1, B:205:0x002d, B:357:0x03f3, B:358:0x03f8), top: B:372:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x02b4 A[Catch: RuntimeException -> 0x03f9, DateTimeParseException -> 0x0441, TryCatch #2 {DateTimeParseException -> 0x0441, RuntimeException -> 0x03f9, blocks: (B:200:0x000e, B:202:0x0015, B:204:0x0026, B:207:0x0032, B:209:0x0038, B:211:0x0042, B:213:0x005e, B:214:0x0062, B:216:0x0066, B:217:0x006f, B:222:0x0091, B:223:0x009b, B:225:0x00a1, B:227:0x00b7, B:229:0x00bb, B:231:0x00c1, B:234:0x00d2, B:232:0x00c8, B:235:0x00d7, B:236:0x00eb, B:237:0x00ec, B:239:0x00f0, B:250:0x0129, B:240:0x0103, B:242:0x0107, B:243:0x010d, B:245:0x0111, B:246:0x0119, B:247:0x0120, B:248:0x0121, B:253:0x0131, B:254:0x0145, B:255:0x014c, B:256:0x014d, B:258:0x0158, B:260:0x0162, B:262:0x0178, B:264:0x018d, B:269:0x01bb, B:270:0x01c5, B:271:0x01c8, B:273:0x01d4, B:302:0x027c, B:304:0x0280, B:305:0x0283, B:307:0x0287, B:309:0x028e, B:311:0x0296, B:312:0x02a1, B:314:0x02a5, B:316:0x02a9, B:321:0x02b4, B:322:0x02c0, B:324:0x02c4, B:326:0x02ce, B:328:0x02d8, B:330:0x02e2, B:332:0x02ec, B:333:0x0312, B:334:0x0331, B:336:0x0335, B:338:0x0339, B:340:0x033d, B:344:0x0368, B:341:0x0348, B:343:0x0354, B:345:0x0377, B:281:0x0200, B:284:0x0209, B:287:0x0212, B:289:0x0219, B:265:0x019a, B:266:0x01a5, B:268:0x01af, B:290:0x0238, B:292:0x023e, B:294:0x0246, B:295:0x0250, B:297:0x0256, B:299:0x0266, B:301:0x026c, B:347:0x0380, B:349:0x0388, B:351:0x03a5, B:353:0x03ab, B:354:0x03ce, B:355:0x03cf, B:356:0x03f2, B:350:0x03a1, B:205:0x002d, B:357:0x03f3, B:358:0x03f8), top: B:372:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:332:0x02ec A[Catch: RuntimeException -> 0x03f9, DateTimeParseException -> 0x0441, TryCatch #2 {DateTimeParseException -> 0x0441, RuntimeException -> 0x03f9, blocks: (B:200:0x000e, B:202:0x0015, B:204:0x0026, B:207:0x0032, B:209:0x0038, B:211:0x0042, B:213:0x005e, B:214:0x0062, B:216:0x0066, B:217:0x006f, B:222:0x0091, B:223:0x009b, B:225:0x00a1, B:227:0x00b7, B:229:0x00bb, B:231:0x00c1, B:234:0x00d2, B:232:0x00c8, B:235:0x00d7, B:236:0x00eb, B:237:0x00ec, B:239:0x00f0, B:250:0x0129, B:240:0x0103, B:242:0x0107, B:243:0x010d, B:245:0x0111, B:246:0x0119, B:247:0x0120, B:248:0x0121, B:253:0x0131, B:254:0x0145, B:255:0x014c, B:256:0x014d, B:258:0x0158, B:260:0x0162, B:262:0x0178, B:264:0x018d, B:269:0x01bb, B:270:0x01c5, B:271:0x01c8, B:273:0x01d4, B:302:0x027c, B:304:0x0280, B:305:0x0283, B:307:0x0287, B:309:0x028e, B:311:0x0296, B:312:0x02a1, B:314:0x02a5, B:316:0x02a9, B:321:0x02b4, B:322:0x02c0, B:324:0x02c4, B:326:0x02ce, B:328:0x02d8, B:330:0x02e2, B:332:0x02ec, B:333:0x0312, B:334:0x0331, B:336:0x0335, B:338:0x0339, B:340:0x033d, B:344:0x0368, B:341:0x0348, B:343:0x0354, B:345:0x0377, B:281:0x0200, B:284:0x0209, B:287:0x0212, B:289:0x0219, B:265:0x019a, B:266:0x01a5, B:268:0x01af, B:290:0x0238, B:292:0x023e, B:294:0x0246, B:295:0x0250, B:297:0x0256, B:299:0x0266, B:301:0x026c, B:347:0x0380, B:349:0x0388, B:351:0x03a5, B:353:0x03ab, B:354:0x03ce, B:355:0x03cf, B:356:0x03f2, B:350:0x03a1, B:205:0x002d, B:357:0x03f3, B:358:0x03f8), top: B:372:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0312 A[Catch: RuntimeException -> 0x03f9, DateTimeParseException -> 0x0441, TryCatch #2 {DateTimeParseException -> 0x0441, RuntimeException -> 0x03f9, blocks: (B:200:0x000e, B:202:0x0015, B:204:0x0026, B:207:0x0032, B:209:0x0038, B:211:0x0042, B:213:0x005e, B:214:0x0062, B:216:0x0066, B:217:0x006f, B:222:0x0091, B:223:0x009b, B:225:0x00a1, B:227:0x00b7, B:229:0x00bb, B:231:0x00c1, B:234:0x00d2, B:232:0x00c8, B:235:0x00d7, B:236:0x00eb, B:237:0x00ec, B:239:0x00f0, B:250:0x0129, B:240:0x0103, B:242:0x0107, B:243:0x010d, B:245:0x0111, B:246:0x0119, B:247:0x0120, B:248:0x0121, B:253:0x0131, B:254:0x0145, B:255:0x014c, B:256:0x014d, B:258:0x0158, B:260:0x0162, B:262:0x0178, B:264:0x018d, B:269:0x01bb, B:270:0x01c5, B:271:0x01c8, B:273:0x01d4, B:302:0x027c, B:304:0x0280, B:305:0x0283, B:307:0x0287, B:309:0x028e, B:311:0x0296, B:312:0x02a1, B:314:0x02a5, B:316:0x02a9, B:321:0x02b4, B:322:0x02c0, B:324:0x02c4, B:326:0x02ce, B:328:0x02d8, B:330:0x02e2, B:332:0x02ec, B:333:0x0312, B:334:0x0331, B:336:0x0335, B:338:0x0339, B:340:0x033d, B:344:0x0368, B:341:0x0348, B:343:0x0354, B:345:0x0377, B:281:0x0200, B:284:0x0209, B:287:0x0212, B:289:0x0219, B:265:0x019a, B:266:0x01a5, B:268:0x01af, B:290:0x0238, B:292:0x023e, B:294:0x0246, B:295:0x0250, B:297:0x0256, B:299:0x0266, B:301:0x026c, B:347:0x0380, B:349:0x0388, B:351:0x03a5, B:353:0x03ab, B:354:0x03ce, B:355:0x03cf, B:356:0x03f2, B:350:0x03a1, B:205:0x002d, B:357:0x03f3, B:358:0x03f8), top: B:372:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:340:0x033d A[Catch: RuntimeException -> 0x03f9, DateTimeParseException -> 0x0441, TryCatch #2 {DateTimeParseException -> 0x0441, RuntimeException -> 0x03f9, blocks: (B:200:0x000e, B:202:0x0015, B:204:0x0026, B:207:0x0032, B:209:0x0038, B:211:0x0042, B:213:0x005e, B:214:0x0062, B:216:0x0066, B:217:0x006f, B:222:0x0091, B:223:0x009b, B:225:0x00a1, B:227:0x00b7, B:229:0x00bb, B:231:0x00c1, B:234:0x00d2, B:232:0x00c8, B:235:0x00d7, B:236:0x00eb, B:237:0x00ec, B:239:0x00f0, B:250:0x0129, B:240:0x0103, B:242:0x0107, B:243:0x010d, B:245:0x0111, B:246:0x0119, B:247:0x0120, B:248:0x0121, B:253:0x0131, B:254:0x0145, B:255:0x014c, B:256:0x014d, B:258:0x0158, B:260:0x0162, B:262:0x0178, B:264:0x018d, B:269:0x01bb, B:270:0x01c5, B:271:0x01c8, B:273:0x01d4, B:302:0x027c, B:304:0x0280, B:305:0x0283, B:307:0x0287, B:309:0x028e, B:311:0x0296, B:312:0x02a1, B:314:0x02a5, B:316:0x02a9, B:321:0x02b4, B:322:0x02c0, B:324:0x02c4, B:326:0x02ce, B:328:0x02d8, B:330:0x02e2, B:332:0x02ec, B:333:0x0312, B:334:0x0331, B:336:0x0335, B:338:0x0339, B:340:0x033d, B:344:0x0368, B:341:0x0348, B:343:0x0354, B:345:0x0377, B:281:0x0200, B:284:0x0209, B:287:0x0212, B:289:0x0219, B:265:0x019a, B:266:0x01a5, B:268:0x01af, B:290:0x0238, B:292:0x023e, B:294:0x0246, B:295:0x0250, B:297:0x0256, B:299:0x0266, B:301:0x026c, B:347:0x0380, B:349:0x0388, B:351:0x03a5, B:353:0x03ab, B:354:0x03ce, B:355:0x03cf, B:356:0x03f2, B:350:0x03a1, B:205:0x002d, B:357:0x03f3, B:358:0x03f8), top: B:372:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0348 A[Catch: RuntimeException -> 0x03f9, DateTimeParseException -> 0x0441, TryCatch #2 {DateTimeParseException -> 0x0441, RuntimeException -> 0x03f9, blocks: (B:200:0x000e, B:202:0x0015, B:204:0x0026, B:207:0x0032, B:209:0x0038, B:211:0x0042, B:213:0x005e, B:214:0x0062, B:216:0x0066, B:217:0x006f, B:222:0x0091, B:223:0x009b, B:225:0x00a1, B:227:0x00b7, B:229:0x00bb, B:231:0x00c1, B:234:0x00d2, B:232:0x00c8, B:235:0x00d7, B:236:0x00eb, B:237:0x00ec, B:239:0x00f0, B:250:0x0129, B:240:0x0103, B:242:0x0107, B:243:0x010d, B:245:0x0111, B:246:0x0119, B:247:0x0120, B:248:0x0121, B:253:0x0131, B:254:0x0145, B:255:0x014c, B:256:0x014d, B:258:0x0158, B:260:0x0162, B:262:0x0178, B:264:0x018d, B:269:0x01bb, B:270:0x01c5, B:271:0x01c8, B:273:0x01d4, B:302:0x027c, B:304:0x0280, B:305:0x0283, B:307:0x0287, B:309:0x028e, B:311:0x0296, B:312:0x02a1, B:314:0x02a5, B:316:0x02a9, B:321:0x02b4, B:322:0x02c0, B:324:0x02c4, B:326:0x02ce, B:328:0x02d8, B:330:0x02e2, B:332:0x02ec, B:333:0x0312, B:334:0x0331, B:336:0x0335, B:338:0x0339, B:340:0x033d, B:344:0x0368, B:341:0x0348, B:343:0x0354, B:345:0x0377, B:281:0x0200, B:284:0x0209, B:287:0x0212, B:289:0x0219, B:265:0x019a, B:266:0x01a5, B:268:0x01af, B:290:0x0238, B:292:0x023e, B:294:0x0246, B:295:0x0250, B:297:0x0256, B:299:0x0266, B:301:0x026c, B:347:0x0380, B:349:0x0388, B:351:0x03a5, B:353:0x03ab, B:354:0x03ce, B:355:0x03cf, B:356:0x03f2, B:350:0x03a1, B:205:0x002d, B:357:0x03f3, B:358:0x03f8), top: B:372:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object MyBillsEntityDataFactory(java.lang.CharSequence r29, j$.time.LocalDateTime$$ExternalSyntheticLambda6 r30) {
        /*
            Method dump skipped, instructions count: 1100
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.DateTimeFormatter.MyBillsEntityDataFactory(java.lang.CharSequence, j$.time.LocalDateTime$$ExternalSyntheticLambda6):java.lang.Object");
    }
}

package id.dana.utils;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Build;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import j$.time.LocalDateTime;
import j$.time.format.DateTimeFormatter;
import j$.util.DesugarTimeZone;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class DateTimeUtil {
    public final Context PlaceComponentResult;

    @Inject
    public DateTimeUtil(Context context) {
        this.PlaceComponentResult = context;
    }

    public static String PlaceComponentResult(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return LocalDateTime.now().format(DateTimeFormatter.MyBillsEntityDataFactory(str));
        }
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date());
    }

    public static String MyBillsEntityDataFactory(Date date, String str, Locale locale) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(str, locale).format(date);
    }

    public static Date getAuthRequestContext(String str, String str2, Locale locale) throws ParseException {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return new SimpleDateFormat(str2, locale).parse(str);
    }

    public static long PlaceComponentResult(Date date) {
        long j;
        if (date == null) {
            return -1L;
        }
        Date date2 = new Date();
        if (date != null) {
            j = TimeUnit.DAYS.convert(date.getTime() - date2.getTime(), TimeUnit.MILLISECONDS);
        } else {
            j = -1;
        }
        if (j != 0 || getAuthRequestContext(date, new Date()) > 0) {
            return j;
        }
        return -1L;
    }

    public static long MyBillsEntityDataFactory(Date date, Date date2) {
        if (date != null) {
            return Math.round((((float) (date.getTime() - date2.getTime())) * 1.0f) / ((float) TimeUnit.MILLISECONDS.convert(1L, TimeUnit.DAYS)));
        }
        return -1L;
    }

    public static long PlaceComponentResult(long j, long j2) {
        if (j < 0 || j2 < 0) {
            return -1L;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j2);
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        return (int) (Math.abs(calendar.getTimeInMillis() - calendar2.getTimeInMillis()) / 86400000);
    }

    public static long PlaceComponentResult(Date date, Date date2) {
        return TimeUnit.HOURS.convert(date.getTime() - date2.getTime(), TimeUnit.MILLISECONDS);
    }

    public static long getAuthRequestContext(Date date, Date date2) {
        if (date == null || date2 == null) {
            return -1L;
        }
        return TimeUnit.SECONDS.convert(date.getTime() - date2.getTime(), TimeUnit.MILLISECONDS);
    }

    public static int MyBillsEntityDataFactory(Date date) {
        long convert = TimeUnit.HOURS.convert(date.getTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        if (convert <= 0) {
            return -1;
        }
        return (int) convert;
    }

    public static boolean PlaceComponentResult(int i) {
        return Calendar.getInstance().get(1) < i;
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(int i) {
        return Calendar.getInstance().get(1) == i;
    }

    public static boolean MyBillsEntityDataFactory(int i) {
        return Calendar.getInstance().get(2) == i;
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return String.valueOf(calendar.get(1));
    }

    public static int lookAheadTest(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(1);
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return Calendar.getInstance().get(2) < i;
    }

    public static int getAuthRequestContext() {
        return Calendar.getInstance().get(5);
    }

    public static String PlaceComponentResult() {
        return Calendar.getInstance().getDisplayName(7, 2, Locale.US);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MarkMethodsForInline
        java.lang.IndexOutOfBoundsException: Index: 0
        	at java.base/java.util.Collections$EmptyList.get(Unknown Source)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    public static java.lang.String KClassImpl$Data$declaredNonStaticMembers$2(long r3) {
        /*
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r1 = id.dana.utils.LocaleUtil.KClassImpl$Data$declaredNonStaticMembers$2()
            java.lang.String r2 = "MMMM"
            r0.<init>(r2, r1)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r3 = r0.format(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.utils.DateTimeUtil.KClassImpl$Data$declaredNonStaticMembers$2(long):java.lang.String");
    }

    public static String getAuthRequestContext(int i) {
        return (i < 0 || i > 11) ? "" : new DateFormatSymbols().getMonths()[i];
    }

    public static int moveToNextValue() {
        return Calendar.getInstance().get(1);
    }

    public static long BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(KClassImpl$Data$declaredNonStaticMembers$2(1, i, i2));
        calendar.set(5, calendar.getActualMinimum(5));
        return calendar.getTimeInMillis();
    }

    public static long MyBillsEntityDataFactory(int i, int i2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(KClassImpl$Data$declaredNonStaticMembers$2(3, i, i2));
        return calendar.getTimeInMillis();
    }

    public static long KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(KClassImpl$Data$declaredNonStaticMembers$2(1, i, i2));
        calendar.set(5, calendar.getActualMaximum(5));
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        return calendar.getTimeInMillis();
    }

    private static Date KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("/");
        sb.append(i2);
        sb.append("/");
        sb.append(i3);
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(sb.toString());
        } catch (ParseException unused) {
            return new Date();
        }
    }

    public static int BuiltInFictitiousFunctionClassFactory(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return calendar.get(5);
    }

    public static DatePickerDialog getAuthRequestContext(Context context, DatePickerDialog.OnDateSetListener onDateSetListener) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, onDateSetListener, calendar.get(1), calendar.get(2), calendar.get(5));
        datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
        return datePickerDialog;
    }

    public static String MyBillsEntityDataFactory() {
        Locale authRequestContext = LocaleUtil.getAuthRequestContext();
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", authRequestContext).format(new Date(new Date().getTime()));
    }

    public static String BuiltInFictitiousFunctionClassFactory(String str, Locale locale, long j) {
        return new SimpleDateFormat(str, locale).format(new Date(j));
    }

    public static String BuiltInFictitiousFunctionClassFactory(Date date) {
        Locale authRequestContext = LocaleUtil.getAuthRequestContext();
        return new SimpleDateFormat("HH:mm", authRequestContext).format(new Date(date.getTime()));
    }

    public static String MyBillsEntityDataFactory(Context context, Long l) {
        return l == null ? "" : BuiltInFictitiousFunctionClassFactory(context, (int) MyBillsEntityDataFactory(new Date(), new Date(l.longValue())), new Date(l.longValue()), Boolean.TRUE);
    }

    public static String getAuthRequestContext(Date date) {
        Locale locale;
        locale = Locale.getDefault();
        return new SimpleDateFormat("dd MMMM", locale).format(new Date(date.getTime()));
    }

    public static String MyBillsEntityDataFactory(Date date, String str) {
        Locale locale;
        locale = Locale.getDefault();
        return new SimpleDateFormat(str, locale).format(new Date(date.getTime()));
    }

    public static long BuiltInFictitiousFunctionClassFactory() {
        return System.currentTimeMillis();
    }

    public static long lookAheadTest() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, 2);
        if (calendar.get(2) > Calendar.getInstance().get(2)) {
            return KClassImpl$Data$declaredNonStaticMembers$2(Calendar.getInstance().get(2) + 1, Calendar.getInstance().get(1));
        }
        return calendar.getTime().getTime();
    }

    private static Calendar NetworkUserEntityData$$ExternalSyntheticLambda0(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar;
    }

    public static long BuiltInFictitiousFunctionClassFactory(Date date, Date date2) {
        Calendar NetworkUserEntityData$$ExternalSyntheticLambda0 = NetworkUserEntityData$$ExternalSyntheticLambda0(date);
        Calendar NetworkUserEntityData$$ExternalSyntheticLambda02 = NetworkUserEntityData$$ExternalSyntheticLambda0(date2);
        long j = 0;
        while (NetworkUserEntityData$$ExternalSyntheticLambda0.before(NetworkUserEntityData$$ExternalSyntheticLambda02)) {
            NetworkUserEntityData$$ExternalSyntheticLambda0.add(5, 1);
            j++;
        }
        return j;
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(String str, String str2, Locale locale) {
        return new SimpleDateFormat(str2, locale).parse(PlaceComponentResult(str2)).getTime() > new SimpleDateFormat(str2, locale).parse(str).getTime();
    }

    public static String scheduleImpl() {
        Calendar calendar = Calendar.getInstance(DesugarTimeZone.BuiltInFictitiousFunctionClassFactory("UTC"));
        StringBuilder sb = new StringBuilder();
        sb.append(calendar.getTimeInMillis());
        return sb.toString();
    }

    public static Date MyBillsEntityDataFactory(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return calendar.getTime();
    }

    public static List<String> KClassImpl$Data$declaredNonStaticMembers$2(long j, Integer num, String str, Boolean bool) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int i = bool.booleanValue() ? -1 : 1;
        for (int i2 = 0; i2 < num.intValue(); i2++) {
            arrayList.add(Long.valueOf(calendar.getTimeInMillis()));
            calendar.add(2, i);
        }
        Collections.sort(arrayList);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList2.add(new SimpleDateFormat(str, Locale.getDefault()).format(new Date(((Long) arrayList.get(i3)).longValue())));
        }
        return arrayList2;
    }

    public static long PlaceComponentResult(String str, String str2, Locale locale) throws ParseException {
        return new SimpleDateFormat(str2, locale).parse(str).getTime();
    }

    public static String BuiltInFictitiousFunctionClassFactory(Context context, int i, Date date, Boolean bool) {
        String string;
        boolean z;
        Locale locale;
        if (i == 0) {
            string = context.getString(id.dana.R.string.feed_section_today);
        } else if (i != 1) {
            locale = Locale.getDefault();
            string = new SimpleDateFormat("dd MMMM", locale).format(new Date(date.getTime()));
            if (bool.booleanValue()) {
                z = true;
                if (!scheduleImpl(date) || z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(string);
                    sb.append(" ");
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    sb.append(String.valueOf(calendar.get(1)));
                    return sb.toString();
                }
                return string;
            }
        } else {
            string = context.getString(id.dana.R.string.feed_section_yesterday);
        }
        z = false;
        if (scheduleImpl(date)) {
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(string);
        sb2.append(" ");
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date);
        sb2.append(String.valueOf(calendar2.get(1)));
        return sb2.toString();
    }

    public static String MyBillsEntityDataFactory(String str, String str2, Locale locale, String str3) {
        try {
            return new SimpleDateFormat(str2, locale).format(new SimpleDateFormat(str, locale).parse(str3));
        } catch (ParseException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.UNKNOWN_EXCEPTION, e.getMessage());
            return null;
        }
    }

    private static boolean scheduleImpl(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(1) < Calendar.getInstance().get(1);
    }

    public static boolean MyBillsEntityDataFactory(String str, String str2, Locale locale) {
        return System.currentTimeMillis() > new SimpleDateFormat(str2, locale).parse(str).getTime();
    }
}

package id.dana.data.util;

import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import id.dana.statement.view.StatementDateView;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.temporal.ChronoUnit;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b3\u00104J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0011\u0010\u0007J%\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001c\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002H\u0007¢\u0006\u0004\b \u0010!J\u001f\u0010\"\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\"\u0010!J\u001f\u0010$\u001a\u00020#2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\bH\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020\u0002H\u0007¢\u0006\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u00102"}, d2 = {"Lid/dana/data/util/DateTimeUtil;", "", "", "timestamp", "countDaysFromTimestampByDay", "(J)J", "getCurrentActiveTime", "()J", "Ljava/util/Locale;", "locale", "Ljava/util/Calendar;", "getCurrentDate", "(Ljava/util/Locale;)Ljava/util/Calendar;", "", "getCurrentMonth", "()Ljava/lang/String;", "getCurrentSplitDateFormat", "getCurrentTimeMillis", MaintenanceBroadcastResult.KEY_DATE, "formatPattern", "getDateTimeInMillis", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Locale;)J", "timemilis", "getDateTimeString", "(Ljava/lang/String;Ljava/util/Locale;J)Ljava/lang/String;", "Ljava/util/Date;", "firstDate", "secondDate", "getDifferenceInDays", "(Ljava/util/Date;Ljava/util/Date;)J", "current", "past", "getDifferenceInHours", "(JJ)J", "getDifferenceInMinutes", "Ljava/text/SimpleDateFormat;", "getFormatter", "(Ljava/lang/String;Ljava/util/Locale;)Ljava/text/SimpleDateFormat;", "indoLocale", "()Ljava/util/Locale;", "time", "", "isPastToday", "(J)Z", "", "GMT_7", "I", "MILLIS_TO_ONE_DAY", "J", "SPLIT_DATE_FORMAT", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DateTimeUtil {
    private static final int GMT_7 = 7;
    public static final DateTimeUtil INSTANCE = new DateTimeUtil();
    private static final long MILLIS_TO_ONE_DAY = 86400000;
    private static final String SPLIT_DATE_FORMAT = "MMM dd, hh:mm a";

    private DateTimeUtil() {
    }

    private final Locale indoLocale() {
        return new Locale("in", "ID");
    }

    @JvmStatic
    public static final boolean isPastToday(long time) {
        return System.currentTimeMillis() - time > 86400000;
    }

    public final String getCurrentSplitDateFormat() {
        return getDateTimeString(SPLIT_DATE_FORMAT, indoLocale(), new Date().getTime());
    }

    public final String getDateTimeString(String formatPattern, Locale locale, long timemilis) {
        Intrinsics.checkNotNullParameter(formatPattern, "");
        Intrinsics.checkNotNullParameter(locale, "");
        String format = getFormatter(formatPattern, locale).format(new Date(timemilis));
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }

    @JvmStatic
    public static final long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    @JvmStatic
    public static final long getDifferenceInHours(long current, long past) {
        long convert = TimeUnit.HOURS.convert(current - past, TimeUnit.MILLISECONDS);
        if (convert < 0) {
            return 0L;
        }
        return convert;
    }

    @JvmStatic
    public static final long getDifferenceInMinutes(long current, long past) {
        long convert = TimeUnit.MINUTES.convert(current - past, TimeUnit.MILLISECONDS);
        if (convert < 0) {
            return 0L;
        }
        return convert;
    }

    public final long getDifferenceInDays(Date firstDate, Date secondDate) {
        if (firstDate == null || secondDate == null) {
            return -1L;
        }
        return MathKt.roundToLong((((float) (firstDate.getTime() - secondDate.getTime())) * 1.0f) / ((float) TimeUnit.MILLISECONDS.convert(1L, TimeUnit.DAYS)));
    }

    public final long countDaysFromTimestampByDay(long timestamp) {
        ZoneOffset ofHours = ZoneOffset.ofHours(7);
        return ChronoUnit.DAYS.between(Instant.ofEpochMilli(timestamp).atZone(ZoneId.ofOffset("", ofHours)).toLocalDate(), LocalDate.now(ZoneId.ofOffset("", ofHours)));
    }

    public final long getCurrentActiveTime() {
        Calendar currentDate = getCurrentDate(indoLocale());
        return (currentDate.get(11) * 3600) + (currentDate.get(12) * 60) + currentDate.get(13);
    }

    private final Calendar getCurrentDate(Locale locale) {
        Calendar calendar = Calendar.getInstance(locale);
        Intrinsics.checkNotNullExpressionValue(calendar, "");
        return calendar;
    }

    public final long getDateTimeInMillis(String date, String formatPattern, Locale locale) {
        Intrinsics.checkNotNullParameter(date, "");
        Intrinsics.checkNotNullParameter(formatPattern, "");
        Intrinsics.checkNotNullParameter(locale, "");
        Date parse = getFormatter(formatPattern, locale).parse(date);
        if (parse != null) {
            return parse.getTime();
        }
        return 0L;
    }

    public final String getCurrentMonth() {
        String format = new SimpleDateFormat(StatementDateView.FULL_MONTH, Locale.getDefault()).format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }

    private final SimpleDateFormat getFormatter(String formatPattern, Locale locale) {
        return new SimpleDateFormat(formatPattern, locale);
    }
}

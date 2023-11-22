package id.dana.domain.util;

import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b'\u0010(J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0011\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0018\u0010\u0015J\u001d\u0010\u0019\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\r¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\rH\u0007¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\rH\u0002¢\u0006\u0004\b#\u0010$J\u0011\u0010%\u001a\u00020\u0002*\u00020\r¢\u0006\u0004\b%\u0010&"}, d2 = {"Lid/dana/domain/util/DateTimeUtils;", "", "Ljava/util/Calendar;", "startDate", "endDate", "", "calculateDaysBetween", "(Ljava/util/Calendar;Ljava/util/Calendar;)I", "", MaintenanceBroadcastResult.KEY_DATE, "formatPattern", "Ljava/util/Locale;", "locale", "", "convertDateToTimeMillis", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Locale;)J", "dateFormat", "getDateTimeInMillis", "currentTime", "lastTimeShown", "getDeltaDay", "(JJ)J", "firstTimeMillis", "secondTimeMillis", "getDifference24HoursTimePeriod", "getMonthFromTimeMillis", "(JLjava/util/Locale;)I", "time", "", "isPastToday", "(J)Z", "lastTImeShown", "isSameDay", "(JJ)Z", "seconds", "secondsToDay", "(J)J", "convertToCalendar", "(J)Ljava/util/Calendar;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DateTimeUtils {
    public static final DateTimeUtils INSTANCE = new DateTimeUtils();

    private DateTimeUtils() {
    }

    private final long getDeltaDay(long currentTime, long lastTimeShown) {
        return secondsToDay(currentTime) - secondsToDay(lastTimeShown);
    }

    private final long secondsToDay(long seconds) {
        return TimeUnit.DAYS.convert(seconds, TimeUnit.SECONDS);
    }

    @JvmStatic
    public static final boolean isSameDay(long currentTime, long lastTImeShown) {
        return INSTANCE.getDeltaDay(currentTime, lastTImeShown) == 0;
    }

    @JvmStatic
    public static final long getDifference24HoursTimePeriod(long firstTimeMillis, long secondTimeMillis) {
        if (firstTimeMillis <= 0 || secondTimeMillis <= 0) {
            return -1L;
        }
        return TimeUnit.DAYS.convert(Math.abs(firstTimeMillis - secondTimeMillis), TimeUnit.MILLISECONDS);
    }

    public final long convertDateToTimeMillis(String date, String formatPattern, Locale locale) {
        Intrinsics.checkNotNullParameter(date, "");
        Intrinsics.checkNotNullParameter(formatPattern, "");
        Intrinsics.checkNotNullParameter(locale, "");
        Date parse = new SimpleDateFormat(formatPattern, locale).parse(date);
        if (parse != null) {
            return parse.getTime();
        }
        return 0L;
    }

    public final int getMonthFromTimeMillis(long date, Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "");
        String format = new SimpleDateFormat("MM", locale).format(Long.valueOf(date));
        Intrinsics.checkNotNullExpressionValue(format, "");
        return Integer.parseInt(format);
    }

    public final long getDateTimeInMillis(String date, String dateFormat, Locale locale) {
        Intrinsics.checkNotNullParameter(date, "");
        Intrinsics.checkNotNullParameter(dateFormat, "");
        Intrinsics.checkNotNullParameter(locale, "");
        Date parse = new SimpleDateFormat(dateFormat, locale).parse(date);
        if (parse != null) {
            return parse.getTime();
        }
        return 0L;
    }

    public final boolean isPastToday(long time) {
        return System.currentTimeMillis() - time > TimeUnit.DAYS.toMillis(1L);
    }

    public final int calculateDaysBetween(Calendar startDate, Calendar endDate) {
        Intrinsics.checkNotNullParameter(startDate, "");
        Intrinsics.checkNotNullParameter(endDate, "");
        long j = 0;
        while (startDate.before(endDate)) {
            startDate.add(5, 1);
            j++;
        }
        return (int) j;
    }

    public final Calendar convertToCalendar(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        Intrinsics.checkNotNullExpressionValue(calendar, "");
        return calendar;
    }
}

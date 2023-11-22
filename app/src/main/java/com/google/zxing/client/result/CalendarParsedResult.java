package com.google.zxing.client.result;

import com.alibaba.griver.base.common.utils.FileCache;
import id.dana.data.uploadfiles.UploadFilesEntityRepository;
import j$.util.DesugarTimeZone;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes7.dex */
public final class CalendarParsedResult extends ParsedResult {
    private final String[] attendees;
    private final String description;
    private final long end;
    private final boolean endAllDay;
    private final double latitude;
    private final String location;
    private final double longitude;
    private final String organizer;
    private final long start;
    private final boolean startAllDay;
    private final String summary;
    private static final Pattern RFC2445_DURATION = Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");
    private static final long[] RFC2445_DURATION_FIELD_UNITS = {FileCache.EXPIRE_TIME, 86400000, 3600000, 60000, 1000};
    private static final Pattern DATE_TIME = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");

    public CalendarParsedResult(String str, String str2, String str3, String str4, String str5, String str6, String[] strArr, String str7, double d, double d2) {
        super(ParsedResultType.CALENDAR);
        this.summary = str;
        try {
            long parseDate = parseDate(str2);
            this.start = parseDate;
            if (str3 == null) {
                long parseDurationMS = parseDurationMS(str4);
                this.end = parseDurationMS < 0 ? -1L : parseDate + parseDurationMS;
            } else {
                try {
                    this.end = parseDate(str3);
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e.toString());
                }
            }
            this.startAllDay = str2.length() == 8;
            this.endAllDay = str3 != null && str3.length() == 8;
            this.location = str5;
            this.organizer = str6;
            this.attendees = strArr;
            this.description = str7;
            this.latitude = d;
            this.longitude = d2;
        } catch (ParseException e2) {
            throw new IllegalArgumentException(e2.toString());
        }
    }

    public final String getSummary() {
        return this.summary;
    }

    @Deprecated
    public final Date getStart() {
        return new Date(this.start);
    }

    public final long getStartTimestamp() {
        return this.start;
    }

    public final boolean isStartAllDay() {
        return this.startAllDay;
    }

    @Deprecated
    public final Date getEnd() {
        if (this.end < 0) {
            return null;
        }
        return new Date(this.end);
    }

    public final long getEndTimestamp() {
        return this.end;
    }

    public final boolean isEndAllDay() {
        return this.endAllDay;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getOrganizer() {
        return this.organizer;
    }

    public final String[] getAttendees() {
        return this.attendees;
    }

    public final String getDescription() {
        return this.description;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public final String getDisplayResult() {
        StringBuilder sb = new StringBuilder(100);
        maybeAppend(this.summary, sb);
        maybeAppend(format(this.startAllDay, this.start), sb);
        maybeAppend(format(this.endAllDay, this.end), sb);
        maybeAppend(this.location, sb);
        maybeAppend(this.organizer, sb);
        maybeAppend(this.attendees, sb);
        maybeAppend(this.description, sb);
        return sb.toString();
    }

    private static long parseDate(String str) throws ParseException {
        if (!DATE_TIME.matcher(str).matches()) {
            throw new ParseException(str, 0);
        }
        if (str.length() == 8) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(UploadFilesEntityRepository.GROUP_ID_FORMAT, Locale.ENGLISH);
            simpleDateFormat.setTimeZone(DesugarTimeZone.BuiltInFictitiousFunctionClassFactory("GMT"));
            return simpleDateFormat.parse(str).getTime();
        } else if (str.length() == 16 && str.charAt(15) == 'Z') {
            long parseDateTimeString = parseDateTimeString(str.substring(0, 15));
            long j = parseDateTimeString + r5.get(15);
            new GregorianCalendar().setTime(new Date(j));
            return j + r5.get(16);
        } else {
            return parseDateTimeString(str);
        }
    }

    private static String format(boolean z, long j) {
        DateFormat dateTimeInstance;
        if (j < 0) {
            return null;
        }
        if (z) {
            dateTimeInstance = DateFormat.getDateInstance(2);
        } else {
            dateTimeInstance = DateFormat.getDateTimeInstance(2, 2);
        }
        return dateTimeInstance.format(Long.valueOf(j));
    }

    private static long parseDurationMS(CharSequence charSequence) {
        if (charSequence == null) {
            return -1L;
        }
        Matcher matcher = RFC2445_DURATION.matcher(charSequence);
        if (!matcher.matches()) {
            return -1L;
        }
        long j = 0;
        int i = 0;
        while (true) {
            long[] jArr = RFC2445_DURATION_FIELD_UNITS;
            if (i >= jArr.length) {
                return j;
            }
            int i2 = i + 1;
            if (matcher.group(i2) != null) {
                j += jArr[i] * Integer.parseInt(r5);
            }
            i = i2;
        }
    }

    private static long parseDateTimeString(String str) throws ParseException {
        return new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH).parse(str).getTime();
    }
}

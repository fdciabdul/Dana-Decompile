package j$.time.format;

import j$.time.temporal.ChronoField;
import j$.time.temporal.TemporalField;
import j$.util.concurrent.ConcurrentHashMap;
import java.text.DateFormatSymbols;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class DateTimeTextProvider {
    public static final /* synthetic */ int PlaceComponentResult = 0;
    private static final ConcurrentHashMap getAuthRequestContext = new ConcurrentHashMap(16, 0.75f, 2);
    private static final Comparator KClassImpl$Data$declaredNonStaticMembers$2 = new Comparator() { // from class: j$.time.format.DateTimeTextProvider.1
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ((String) ((Map.Entry) obj2).getKey()).length() - ((String) ((Map.Entry) obj).getKey()).length();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public final class LocaleStore {
        final HashMap KClassImpl$Data$declaredNonStaticMembers$2;
        private final Map PlaceComponentResult;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LocaleStore(Map map) {
            this.PlaceComponentResult = map;
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : map.entrySet()) {
                HashMap hashMap2 = new HashMap();
                for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                    String str = (String) entry2.getValue();
                    String str2 = (String) entry2.getValue();
                    Long l = (Long) entry2.getKey();
                    int i = DateTimeTextProvider.PlaceComponentResult;
                    hashMap2.put(str, new AbstractMap.SimpleImmutableEntry(str2, l));
                }
                ArrayList arrayList2 = new ArrayList(hashMap2.values());
                Collections.sort(arrayList2, DateTimeTextProvider.KClassImpl$Data$declaredNonStaticMembers$2);
                hashMap.put((TextStyle) entry.getKey(), arrayList2);
                arrayList.addAll(arrayList2);
                hashMap.put(null, arrayList);
            }
            Collections.sort(arrayList, DateTimeTextProvider.KClassImpl$Data$declaredNonStaticMembers$2);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = hashMap;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final String getAuthRequestContext(long j, TextStyle textStyle) {
            Map map = (Map) this.PlaceComponentResult.get(textStyle);
            if (map != null) {
                return (String) map.get(Long.valueOf(j));
            }
            return null;
        }
    }

    public String BuiltInFictitiousFunctionClassFactory(TemporalField temporalField, long j, TextStyle textStyle, Locale locale) {
        Object PlaceComponentResult2 = PlaceComponentResult(temporalField, locale);
        if (PlaceComponentResult2 instanceof LocaleStore) {
            return ((LocaleStore) PlaceComponentResult2).getAuthRequestContext(j, textStyle);
        }
        return null;
    }

    private static Object PlaceComponentResult(TemporalField temporalField, Locale locale) {
        Object obj;
        AbstractMap.SimpleImmutableEntry simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(temporalField, locale);
        V v = getAuthRequestContext.get(simpleImmutableEntry);
        if (v == 0) {
            HashMap hashMap = new HashMap();
            if (temporalField == ChronoField.ERA) {
                DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
                HashMap hashMap2 = new HashMap();
                HashMap hashMap3 = new HashMap();
                String[] eras = dateFormatSymbols.getEras();
                for (int i = 0; i < eras.length; i++) {
                    if (!eras[i].isEmpty()) {
                        long j = i;
                        hashMap2.put(Long.valueOf(j), eras[i]);
                        Long valueOf = Long.valueOf(j);
                        String str = eras[i];
                        hashMap3.put(valueOf, str.substring(0, Character.charCount(str.codePointAt(0))));
                    }
                }
                if (!hashMap2.isEmpty()) {
                    hashMap.put(TextStyle.FULL, hashMap2);
                    hashMap.put(TextStyle.SHORT, hashMap2);
                    hashMap.put(TextStyle.NARROW, hashMap3);
                }
                obj = new LocaleStore(hashMap);
            } else if (temporalField == ChronoField.MONTH_OF_YEAR) {
                DateFormatSymbols dateFormatSymbols2 = DateFormatSymbols.getInstance(locale);
                HashMap hashMap4 = new HashMap();
                HashMap hashMap5 = new HashMap();
                String[] months = dateFormatSymbols2.getMonths();
                for (int i2 = 0; i2 < months.length; i2++) {
                    if (!months[i2].isEmpty()) {
                        long j2 = i2 + 1;
                        hashMap4.put(Long.valueOf(j2), months[i2]);
                        Long valueOf2 = Long.valueOf(j2);
                        String str2 = months[i2];
                        hashMap5.put(valueOf2, str2.substring(0, Character.charCount(str2.codePointAt(0))));
                    }
                }
                if (!hashMap4.isEmpty()) {
                    hashMap.put(TextStyle.FULL, hashMap4);
                    hashMap.put(TextStyle.NARROW, hashMap5);
                }
                HashMap hashMap6 = new HashMap();
                String[] shortMonths = dateFormatSymbols2.getShortMonths();
                for (int i3 = 0; i3 < shortMonths.length; i3++) {
                    if (!shortMonths[i3].isEmpty()) {
                        hashMap6.put(Long.valueOf(i3 + 1), shortMonths[i3]);
                    }
                }
                if (!hashMap6.isEmpty()) {
                    hashMap.put(TextStyle.SHORT, hashMap6);
                }
                obj = new LocaleStore(hashMap);
            } else if (temporalField == ChronoField.DAY_OF_WEEK) {
                DateFormatSymbols dateFormatSymbols3 = DateFormatSymbols.getInstance(locale);
                HashMap hashMap7 = new HashMap();
                String[] weekdays = dateFormatSymbols3.getWeekdays();
                hashMap7.put(1L, weekdays[2]);
                hashMap7.put(2L, weekdays[3]);
                hashMap7.put(3L, weekdays[4]);
                hashMap7.put(4L, weekdays[5]);
                hashMap7.put(5L, weekdays[6]);
                hashMap7.put(6L, weekdays[7]);
                hashMap7.put(7L, weekdays[1]);
                hashMap.put(TextStyle.FULL, hashMap7);
                HashMap hashMap8 = new HashMap();
                String str3 = weekdays[2];
                hashMap8.put(1L, str3.substring(0, Character.charCount(str3.codePointAt(0))));
                String str4 = weekdays[3];
                hashMap8.put(2L, str4.substring(0, Character.charCount(str4.codePointAt(0))));
                String str5 = weekdays[4];
                hashMap8.put(3L, str5.substring(0, Character.charCount(str5.codePointAt(0))));
                String str6 = weekdays[5];
                hashMap8.put(4L, str6.substring(0, Character.charCount(str6.codePointAt(0))));
                String str7 = weekdays[6];
                hashMap8.put(5L, str7.substring(0, Character.charCount(str7.codePointAt(0))));
                String str8 = weekdays[7];
                hashMap8.put(6L, str8.substring(0, Character.charCount(str8.codePointAt(0))));
                String str9 = weekdays[1];
                hashMap8.put(7L, str9.substring(0, Character.charCount(str9.codePointAt(0))));
                hashMap.put(TextStyle.NARROW, hashMap8);
                HashMap hashMap9 = new HashMap();
                String[] shortWeekdays = dateFormatSymbols3.getShortWeekdays();
                hashMap9.put(1L, shortWeekdays[2]);
                hashMap9.put(2L, shortWeekdays[3]);
                hashMap9.put(3L, shortWeekdays[4]);
                hashMap9.put(4L, shortWeekdays[5]);
                hashMap9.put(5L, shortWeekdays[6]);
                hashMap9.put(6L, shortWeekdays[7]);
                hashMap9.put(7L, shortWeekdays[1]);
                hashMap.put(TextStyle.SHORT, hashMap9);
                obj = new LocaleStore(hashMap);
            } else if (temporalField == ChronoField.AMPM_OF_DAY) {
                DateFormatSymbols dateFormatSymbols4 = DateFormatSymbols.getInstance(locale);
                HashMap hashMap10 = new HashMap();
                HashMap hashMap11 = new HashMap();
                String[] amPmStrings = dateFormatSymbols4.getAmPmStrings();
                for (int i4 = 0; i4 < amPmStrings.length; i4++) {
                    if (!amPmStrings[i4].isEmpty()) {
                        long j3 = i4;
                        hashMap10.put(Long.valueOf(j3), amPmStrings[i4]);
                        Long valueOf3 = Long.valueOf(j3);
                        String str10 = amPmStrings[i4];
                        hashMap11.put(valueOf3, str10.substring(0, Character.charCount(str10.codePointAt(0))));
                    }
                }
                if (!hashMap10.isEmpty()) {
                    hashMap.put(TextStyle.FULL, hashMap10);
                    hashMap.put(TextStyle.SHORT, hashMap10);
                    hashMap.put(TextStyle.NARROW, hashMap11);
                }
                obj = new LocaleStore(hashMap);
            } else {
                obj = "";
            }
            ConcurrentHashMap concurrentHashMap = getAuthRequestContext;
            concurrentHashMap.putIfAbsent(simpleImmutableEntry, obj);
            return concurrentHashMap.get(simpleImmutableEntry);
        }
        return v;
    }

    public Iterator PlaceComponentResult(TemporalField temporalField, TextStyle textStyle, Locale locale) {
        List list;
        Object PlaceComponentResult2 = PlaceComponentResult(temporalField, locale);
        if (!(PlaceComponentResult2 instanceof LocaleStore) || (list = (List) ((LocaleStore) PlaceComponentResult2).KClassImpl$Data$declaredNonStaticMembers$2.get(textStyle)) == null) {
            return null;
        }
        return list.iterator();
    }
}

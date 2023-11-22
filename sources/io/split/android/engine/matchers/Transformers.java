package io.split.android.engine.matchers;

import com.google.common.collect.Sets;
import id.dana.sendmoney.summary.SummaryActivity;
import j$.util.DesugarTimeZone;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

/* loaded from: classes6.dex */
public class Transformers {
    private static Set<String> MyBillsEntityDataFactory = Sets.newHashSet(SummaryActivity.CHECKED, "false");
    private static TimeZone BuiltInFictitiousFunctionClassFactory = DesugarTimeZone.BuiltInFictitiousFunctionClassFactory("UTC");

    public static Long MyBillsEntityDataFactory(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).longValue());
        }
        if (obj instanceof Long) {
            return (Long) obj;
        }
        return null;
    }

    public static Boolean PlaceComponentResult(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (MyBillsEntityDataFactory.contains(str.toLowerCase(Locale.ROOT))) {
                return Boolean.valueOf(Boolean.parseBoolean(str));
            }
        }
        return null;
    }

    public static Set<String> MyBillsEntityDataFactory(Collection collection) {
        HashSet hashSet = new HashSet(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().toString());
        }
        return hashSet;
    }

    public static Long KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
        Calendar calendar;
        Long MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(obj);
        if (MyBillsEntityDataFactory2 == null) {
            calendar = null;
        } else {
            calendar = Calendar.getInstance();
            calendar.setTimeZone(BuiltInFictitiousFunctionClassFactory);
            calendar.setTimeInMillis(MyBillsEntityDataFactory2.longValue());
        }
        if (calendar == null) {
            return null;
        }
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return Long.valueOf(calendar.getTimeInMillis());
    }

    public static Long BuiltInFictitiousFunctionClassFactory(Object obj) {
        Calendar calendar;
        Long MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(obj);
        if (MyBillsEntityDataFactory2 == null) {
            calendar = null;
        } else {
            calendar = Calendar.getInstance();
            calendar.setTimeZone(BuiltInFictitiousFunctionClassFactory);
            calendar.setTimeInMillis(MyBillsEntityDataFactory2.longValue());
        }
        if (calendar == null) {
            return null;
        }
        calendar.set(13, 0);
        calendar.set(14, 0);
        return Long.valueOf(calendar.getTimeInMillis());
    }
}

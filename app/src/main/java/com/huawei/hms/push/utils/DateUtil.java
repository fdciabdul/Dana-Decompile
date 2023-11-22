package com.huawei.hms.push.utils;

import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes8.dex */
public class DateUtil {
    public static long PlaceComponentResult(String str) throws ParseException, StringIndexOutOfBoundsException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.BuiltInFictitiousFunctionClassFactory("UTC"));
        String substring = str.substring(0, str.indexOf("."));
        String substring2 = str.substring(str.indexOf("."));
        StringBuilder sb = new StringBuilder();
        sb.append(substring2.substring(0, 4));
        sb.append("Z");
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(substring);
        sb2.append(obj);
        return simpleDateFormat.parse(sb2.toString()).getTime();
    }
}

package com.huawei.hms.hatool;

import android.util.Pair;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes8.dex */
public abstract class u0 {
    public static String BuiltInFictitiousFunctionClassFactory(String str, String str2, String str3) {
        if ("_default_config_tag".equals(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("_default_config_tag#");
            sb.append(str3);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("-");
        sb2.append(str2);
        sb2.append("#");
        sb2.append(str3);
        return sb2.toString();
    }

    public static long MyBillsEntityDataFactory(String str, long j) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
            return simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(j))).getTime();
        } catch (ParseException unused) {
            y.moveToNextValue("hmsSdk/stringUtil", "getMillisOfDate(): Time conversion Exception !");
            return 0L;
        }
    }

    public static Pair<String, String> MyBillsEntityDataFactory(String str) {
        String str2;
        String str3;
        if ("_default_config_tag".equals(str)) {
            return new Pair<>(str, "");
        }
        String[] split = str.split("-");
        if (split.length > 2) {
            str3 = split[split.length - 1];
            str2 = str.substring(0, (str.length() - str3.length()) - 1);
        } else {
            str2 = split[0];
            str3 = split[1];
        }
        return new Pair<>(str2, str3);
    }

    public static Set<String> PlaceComponentResult(Set<String> set) {
        if (set == null || set.size() == 0) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (String str : set) {
            if ("_default_config_tag".equals(str)) {
                hashSet.add("_default_config_tag");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("-");
                sb.append("oper");
                String obj = sb.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append("-");
                sb2.append("maint");
                String obj2 = sb2.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append("-");
                sb3.append("diffprivacy");
                String obj3 = sb3.toString();
                hashSet.add(obj);
                hashSet.add(obj2);
                hashSet.add(obj3);
            }
        }
        return hashSet;
    }

    public static String getAuthRequestContext(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "alltype" : "diffprivacy" : "preins" : "maint" : "oper";
    }

    public static String getAuthRequestContext(String str, String str2) {
        if ("_default_config_tag".equals(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("-");
        sb.append(str2);
        return sb.toString();
    }
}

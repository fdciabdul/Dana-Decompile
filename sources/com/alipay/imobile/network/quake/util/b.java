package com.alipay.imobile.network.quake.util;

import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f7077a = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static boolean a(String str) {
        return f7077a.matcher(str).matches();
    }
}

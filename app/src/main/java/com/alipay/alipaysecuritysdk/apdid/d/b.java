package com.alipay.alipaysecuritysdk.apdid.d;

import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    Context f6856a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.f6856a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] strArr = {"2017-01-27 2017-01-28", "2017-11-10 2017-11-11", "2017-12-11 2017-12-12"};
        int random = (int) (Math.random() * 24.0d * 60.0d * 60.0d);
        for (int i = 0; i < 3; i++) {
            try {
                String[] split = strArr[i].split(" ");
                if (split != null && split.length == 2) {
                    Date date = new Date();
                    StringBuilder sb = new StringBuilder();
                    sb.append(split[0]);
                    sb.append(" 00:00:00");
                    Date parse = simpleDateFormat.parse(sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(split[1]);
                    sb2.append(" 23:59:59");
                    Date parse2 = simpleDateFormat.parse(sb2.toString());
                    simpleDateFormat.format(parse);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(parse2);
                    calendar.add(13, random * 1);
                    Date time = calendar.getTime();
                    simpleDateFormat.format(time);
                    if (date.after(parse) && date.before(time)) {
                        simpleDateFormat.format(date);
                        return true;
                    }
                    simpleDateFormat.format(date);
                }
            } catch (Throwable th) {
                com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-apdid", "Unexpected error happened while judge whether now is in rush hour.", th);
            }
        }
        return false;
    }
}

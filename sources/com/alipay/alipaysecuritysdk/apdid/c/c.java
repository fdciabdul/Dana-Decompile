package com.alipay.alipaysecuritysdk.apdid.c;

import com.huawei.hms.framework.common.ContainerUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* loaded from: classes3.dex */
public final class c {
    public static boolean a(List<String> list) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setLenient(false);
        int random = (int) (Math.random() * 24.0d * 60.0d * 60.0d);
        try {
            for (String str : list) {
                if (str != null) {
                    String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
                    if (split.length == 2) {
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
                        simpleDateFormat.format(parse2);
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(parse2);
                        calendar.add(13, random);
                        Date time = calendar.getTime();
                        simpleDateFormat.format(time);
                        if (date.after(parse) && date.before(time)) {
                            return true;
                        }
                    } else {
                        continue;
                    }
                }
            }
        } catch (Throwable th) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", "unexpected error happened while judge whether now is in rush hour.", th);
        }
        return false;
    }
}

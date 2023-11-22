package com.huawei.hms.common.internal;

import com.huawei.hms.utils.StringUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import kotlin.time.DurationKt;

/* loaded from: classes7.dex */
public class TransactionIdCreater {
    private static final int API_SIZE = 6;
    private static final int APPID_SIZE = 9;
    private static final char FILL_BYTE = '0';

    public static String getId(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.addByteForNum(str, 9, FILL_BYTE));
        sb.append(StringUtil.addByteForNum(str2, 6, FILL_BYTE));
        sb.append(new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.ENGLISH).format(new Date()));
        sb.append(String.format(Locale.ENGLISH, "%06d", Integer.valueOf(new Random().nextInt(DurationKt.NANOS_IN_MILLIS))));
        return sb.toString();
    }
}

package com.xiaomi.push;

import com.alibaba.griver.image.framework.api.APImageFormat;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes8.dex */
public class g {
    private static final HashMap<String, String> MyBillsEntityDataFactory;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        MyBillsEntityDataFactory = hashMap;
        hashMap.put("FFD8FF", APImageFormat.SUFFIX_JPG);
        hashMap.put("89504E47", APImageFormat.SUFFIX_PNG);
        hashMap.put("47494638", APImageFormat.SUFFIX_GIF);
        hashMap.put("474946", APImageFormat.SUFFIX_GIF);
        hashMap.put("424D", "bmp");
    }

    public static long KClassImpl$Data$declaredNonStaticMembers$2(File file) {
        long j = 0;
        try {
            File[] listFiles = file.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                j += listFiles[i].isDirectory() ? KClassImpl$Data$declaredNonStaticMembers$2(listFiles[i]) : listFiles[i].length();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
        }
        return j;
    }
}

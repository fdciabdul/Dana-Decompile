package com.xiaomi.push.service;

import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes8.dex */
public class aj {
    private static final Pattern getAuthRequestContext = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");
    private static long PlaceComponentResult = 0;
    private static ThreadPoolExecutor KClassImpl$Data$declaredNonStaticMembers$2 = new ThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static void BuiltInFictitiousFunctionClassFactory() {
        String MyBillsEntityDataFactory = MyBillsEntityDataFactory("/proc/self/net/tcp");
        if (!TextUtils.isEmpty(MyBillsEntityDataFactory)) {
            StringBuilder sb = new StringBuilder();
            sb.append("dump tcp for uid = ");
            sb.append(Process.myUid());
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(MyBillsEntityDataFactory);
        }
        String MyBillsEntityDataFactory2 = MyBillsEntityDataFactory("/proc/self/net/tcp6");
        if (TextUtils.isEmpty(MyBillsEntityDataFactory2)) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("dump tcp6 for uid = ");
        sb2.append(Process.myUid());
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(MyBillsEntityDataFactory2);
    }

    private static String MyBillsEntityDataFactory(String str) {
        BufferedReader bufferedReader;
        File file = new File(str);
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        String obj = sb.toString();
                        com.xiaomi.push.h.MyBillsEntityDataFactory(bufferedReader);
                        return obj;
                    }
                    sb.append("\n");
                    sb.append(readLine);
                }
            } catch (Exception unused) {
                com.xiaomi.push.h.MyBillsEntityDataFactory(bufferedReader);
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                com.xiaomi.push.h.MyBillsEntityDataFactory(bufferedReader2);
                throw th;
            }
        } catch (Exception unused2) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}

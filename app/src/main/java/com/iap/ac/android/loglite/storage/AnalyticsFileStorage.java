package com.iap.ac.android.loglite.storage;

import android.app.Application;
import android.text.TextUtils;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.appender.MdapFileLogAppender;
import com.alipay.iap.android.aplog.core.layout.mas.MasLog;
import com.iap.ac.android.loglite.config.LogStrategyInfo;
import com.iap.ac.android.loglite.core.AnalyticsContext;
import com.iap.ac.android.loglite.utils.FileUtil;
import com.iap.ac.android.loglite.utils.LoggerWrapper;
import com.iap.ac.android.loglite.utils.LoggingUtil;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class AnalyticsFileStorage implements AnalyticsStorage {
    public static final String g;

    /* renamed from: a  reason: collision with root package name */
    public Application f7595a;
    public String f;
    public boolean e = true;
    public Map<String, File> b = new HashMap();
    public Map<String, File> c = new HashMap();
    public final Map<String, Integer> d = new HashMap();

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("loglite");
        sb.append(File.separatorChar);
        sb.append("upload");
        g = sb.toString();
    }

    public AnalyticsFileStorage(Application application, String str) {
        this.f7595a = application;
        this.f = str;
    }

    public abstract File a(String str, String str2);

    public File a(Map<String, File> map, String str, String str2, String str3) {
        String productId = AnalyticsContext.getInstance().getProductId();
        StringBuilder sb = new StringBuilder();
        sb.append(productId);
        sb.append(str3);
        sb.append("_");
        sb.append(str2);
        sb.append("_");
        sb.append(str);
        String obj = sb.toString();
        File file = map.get(obj);
        if (file == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f7595a.getFilesDir());
            String str4 = File.separator;
            sb2.append(str4);
            sb2.append("loglite");
            sb2.append(str4);
            sb2.append(productId);
            File file2 = new File(sb2.toString(), str3);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str3);
            sb3.append("_");
            sb3.append(str2);
            sb3.append("$=$");
            sb3.append(str);
            File file3 = new File(file2, sb3.toString());
            map.put(obj, file3);
            return file3;
        }
        return file;
    }

    public void b() {
        this.d.clear();
    }

    public final File c() {
        return new File(this.f7595a.getFilesDir(), g);
    }

    public void d() {
        AnalyticsContext analyticsContext = AnalyticsContext.getInstance();
        String productId = AnalyticsContext.getInstance().getProductId();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7595a.getFilesDir());
        String str = File.separator;
        sb.append(str);
        sb.append("loglite");
        sb.append(str);
        sb.append(productId);
        File[] listFiles = new File(sb.toString(), this.f).listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                try {
                    String name = file.getName();
                    File c = c();
                    if (!c.exists()) {
                        c.mkdirs();
                    }
                    FileUtil.moveFile(file, new File(c, LoggingUtil.getMdapStyleName(name)));
                } catch (IOException e) {
                    LoggerWrapper.w("AnalyticsFileStorage", e);
                }
            }
        }
        analyticsContext.uploadLog(c());
        b();
    }

    public void a(String str, String str2, String str3) {
        File a2 = a(str2, str3);
        if (this.e) {
            String productId = AnalyticsContext.getInstance().getProductId();
            StringBuilder sb = new StringBuilder();
            sb.append(this.f7595a.getFilesDir());
            String str4 = File.separator;
            sb.append(str4);
            sb.append("loglite");
            sb.append(str4);
            sb.append(productId);
            File[] listFiles = new File(sb.toString(), this.f).listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    String name = file.getName();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str3);
                    if (name.contains(sb2.toString())) {
                        String readFile = FileUtil.readFile(file);
                        if (!TextUtils.isEmpty(readFile)) {
                            int length = readFile.split(LoggerFactory.LOG_SPLITER).length;
                            String str5 = TextUtils.isEmpty(str3) ? "defaultWriteCountBizType" : str3;
                            this.d.put(str5, Integer.valueOf(a(str5) + length));
                        }
                    }
                }
            }
            this.e = false;
        }
        AnalyticsContext analyticsContext = AnalyticsContext.getInstance();
        try {
            LogStrategyInfo a3 = analyticsContext.getConfigurationManager().a(str3);
            if (!(a3 != null && a3.maxLogCount == 1) && analyticsContext.isNeedEncryptLog()) {
                String encrypt = analyticsContext.getLogEncryptClient().encrypt(str);
                if (!TextUtils.isEmpty(encrypt)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(MdapFileLogAppender.ENCRYPT_SIGN);
                    sb3.append(encrypt);
                    sb3.append(MasLog.Constant.GAP);
                    str = sb3.toString();
                }
            }
            FileUtil.writeFile(str, a2);
            String str6 = TextUtils.isEmpty(str3) ? "defaultWriteCountBizType" : str3;
            this.d.put(str6, Integer.valueOf(a(str6) + 1));
        } catch (Exception e) {
            LoggerWrapper.w("AnalyticsFileStorage", e);
        }
        if (analyticsContext.getConfigurationManager().a(this.f, a(str3), str3)) {
            AnalyticsContext analyticsContext2 = AnalyticsContext.getInstance();
            String productId2 = AnalyticsContext.getInstance().getProductId();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(this.f7595a.getFilesDir());
            String str7 = File.separator;
            sb4.append(str7);
            sb4.append("loglite");
            sb4.append(str7);
            sb4.append(productId2);
            File[] listFiles2 = new File(sb4.toString(), this.f).listFiles();
            if (listFiles2 != null && listFiles2.length > 0) {
                for (File file2 : listFiles2) {
                    try {
                        String name2 = file2.getName();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str3);
                        if (name2.contains(sb5.toString())) {
                            String name3 = file2.getName();
                            File c = c();
                            if (!c.exists()) {
                                c.mkdirs();
                            }
                            FileUtil.moveFile(file2, new File(c, LoggingUtil.getMdapStyleName(name3)));
                        }
                    } catch (IOException e2) {
                        LoggerWrapper.w("AnalyticsFileStorage", e2);
                    }
                }
            }
            analyticsContext2.uploadLog(c());
            if (TextUtils.isEmpty(str3)) {
                str3 = "defaultWriteCountBizType";
            }
            this.d.put(str3, 0);
        }
    }

    public final int a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "defaultWriteCountBizType";
        }
        if (this.d.get(str) == null) {
            return 0;
        }
        return this.d.get(str).intValue();
    }
}

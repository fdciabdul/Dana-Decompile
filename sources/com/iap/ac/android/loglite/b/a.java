package com.iap.ac.android.loglite.b;

import android.app.Application;
import android.text.TextUtils;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.iap.ac.android.loglite.config.ConfigurationManager;
import com.iap.ac.android.loglite.core.AnalyticsContext;
import com.iap.ac.android.loglite.utils.FileUtil;
import com.iap.ac.android.loglite.utils.LoggerWrapper;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class a extends c {
    public Map<String, Integer> i;
    public Map<String, File> j;

    /* renamed from: com.iap.ac.android.loglite.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0139a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f7581a;

        public RunnableC0139a(String str) {
            this.f7581a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.f = this.f7581a;
            aVar.d();
        }
    }

    public a(Application application, String str) {
        super(application, null);
        this.i = new HashMap();
        this.j = new HashMap();
    }

    @Override // com.iap.ac.android.loglite.storage.AsyncFileStorage, com.iap.ac.android.loglite.storage.AnalyticsStorage
    public void a() {
        Iterator<String> it = this.i.keySet().iterator();
        while (it.hasNext()) {
            this.h.execute(new RunnableC0139a(it.next()));
        }
    }

    @Override // com.iap.ac.android.loglite.storage.AnalyticsFileStorage
    public void b() {
        this.i.put(this.f, 0);
    }

    @Override // com.iap.ac.android.loglite.b.c, com.iap.ac.android.loglite.storage.AnalyticsFileStorage
    public File a(String str, String str2) {
        return a(this.j, str, str2, this.f);
    }

    @Override // com.iap.ac.android.loglite.storage.AnalyticsFileStorage
    public void a(String str, String str2, String str3) {
        File a2 = a(this.j, str2, str3, this.f);
        if (!this.i.containsKey(this.f)) {
            String productId = AnalyticsContext.getInstance().getProductId();
            StringBuilder sb = new StringBuilder();
            sb.append(this.f7595a.getFilesDir());
            String str4 = File.separator;
            sb.append(str4);
            sb.append("loglite");
            sb.append(str4);
            sb.append(productId);
            File[] listFiles = new File(sb.toString(), this.f).listFiles();
            int i = 0;
            if (listFiles != null && listFiles.length > 0) {
                int length = listFiles.length;
                int i2 = 0;
                while (i < length) {
                    String readFile = FileUtil.readFile(listFiles[i]);
                    if (!TextUtils.isEmpty(readFile)) {
                        i2 += readFile.split(LoggerFactory.LOG_SPLITER).length;
                    }
                    i++;
                }
                i = i2;
            }
            this.i.put(this.f, Integer.valueOf(i));
        }
        try {
            FileUtil.writeFile(str, a2);
            this.i.put(this.f, Integer.valueOf(this.i.get(this.f).intValue() + 1));
        } catch (Exception e) {
            LoggerWrapper.w("AntEventFileStorage", e);
        }
        ConfigurationManager configurationManager = AnalyticsContext.getInstance().getConfigurationManager();
        String str5 = this.f;
        if (configurationManager.a(str5, this.i.get(str5).intValue(), str3)) {
            d();
        }
    }
}

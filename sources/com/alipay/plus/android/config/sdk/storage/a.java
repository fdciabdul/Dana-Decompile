package com.alipay.plus.android.config.sdk.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.plus.android.config.sdk.a.e;
import com.alipay.plus.android.config.sdk.retry.DistributionNodesConfig;
import com.alipay.plus.android.config.sdk.utils.ConfigUtils;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7386a = e.a("ConfigStorage");
    private ISecurityEncryptor b;
    private Context c;
    private String d;
    private SharedPreferences e;

    public a(Context context, String str) {
        this.c = context;
        str = TextUtils.isEmpty(str) ? "default" : str;
        this.d = String.format("aplus_config_%s.contents", str);
        this.e = this.c.getSharedPreferences(String.format("aplus_config_%s.prefs", str), 0);
    }

    private static String a(InputStream inputStream) {
        Throwable th;
        InputStreamReader inputStreamReader;
        String str = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream);
        } catch (Throwable th2) {
            th = th2;
            inputStreamReader = null;
        }
        try {
            char[] cArr = new char[1024];
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read == -1) {
                    break;
                }
                sb.append(cArr, 0, read);
            }
            str = sb.toString();
        } catch (Throwable th3) {
            th = th3;
            try {
                LoggerWrapper.e(f7386a, "readInputStream", th);
                return str;
            } finally {
                a(inputStreamReader);
                a((Closeable) inputStream);
            }
        }
        return str;
    }

    private static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public String a() {
        try {
            FileInputStream openFileInput = this.c.openFileInput(this.d);
            if (openFileInput == null) {
                return null;
            }
            String a2 = a((InputStream) openFileInput);
            ISecurityEncryptor iSecurityEncryptor = this.b;
            if (iSecurityEncryptor != null) {
                a2 = iSecurityEncryptor.decrypt(a2);
            }
            LoggerWrapper.i(f7386a, String.format("** loadConfig Success! bytes = %s.", String.valueOf(a2 != null ? a2.getBytes().length : 0)));
            return a2;
        } catch (Throwable th) {
            LoggerWrapper.w(f7386a, String.format("** loadConfig Failed! Take it easy, cache file not exists. message = %s.", th.getMessage()));
            return null;
        }
    }

    public void a(long j) {
        SharedPreferences sharedPreferences = this.e;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("lastRefreshTime", j).apply();
        }
    }

    public void a(DistributionNodesConfig distributionNodesConfig) {
        if (this.e == null) {
            LoggerWrapper.e(f7386a, "mSharedPreferences is null, cannot save backupConfigs!");
            return;
        }
        this.e.edit().putString("cdnConfigs", ConfigUtils.toJSONString(distributionNodesConfig)).apply();
    }

    public boolean a(String str) {
        ISecurityEncryptor iSecurityEncryptor = this.b;
        if (iSecurityEncryptor != null) {
            str = iSecurityEncryptor.encrypt(str);
        }
        try {
            FileOutputStream openFileOutput = this.c.openFileOutput(this.d, 0);
            if (openFileOutput == null) {
                a(openFileOutput);
                return false;
            }
            byte[] bytes = str != null ? str.getBytes() : new byte[0];
            openFileOutput.write(bytes);
            LoggerWrapper.i(f7386a, String.format("** saveConfig Success! bytes = %s.", String.valueOf(bytes.length)));
            a(openFileOutput);
            return true;
        } catch (Throwable th) {
            try {
                LoggerWrapper.e(f7386a, "saveConfig Error!", th);
                return false;
            } finally {
                a((Closeable) null);
            }
        }
    }

    public DistributionNodesConfig b() {
        SharedPreferences sharedPreferences = this.e;
        if (sharedPreferences == null) {
            LoggerWrapper.e(f7386a, "mSharedPreferences is null! loaded backupConfigs is null!");
            return null;
        }
        try {
            String string = sharedPreferences.getString("cdnConfigs", null);
            if (string == null) {
                return null;
            }
            try {
                return (DistributionNodesConfig) JSON.parseObject(string, DistributionNodesConfig.class);
            } catch (Throwable th) {
                String str = f7386a;
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot parse backupConfigs. error = ");
                sb.append(th.getMessage());
                LoggerWrapper.e(str, sb.toString());
                return null;
            }
        } catch (Throwable th2) {
            String str2 = f7386a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("get backupConfigs failed! error = ");
            sb2.append(th2.getMessage());
            LoggerWrapper.e(str2, sb2.toString());
            return null;
        }
    }

    public void b(DistributionNodesConfig distributionNodesConfig) {
        if (this.e == null) {
            LoggerWrapper.e(f7386a, "mSharedPreferences is null, cannot save backupConfigs!");
            return;
        }
        this.e.edit().putString("distributionNodes", ConfigUtils.toJSONString(distributionNodesConfig)).apply();
    }

    public void b(String str) {
        if (this.e == null) {
            return;
        }
        String str2 = f7386a;
        StringBuilder sb = new StringBuilder();
        sb.append("saveReMergeFactors: ");
        sb.append(str);
        LoggerWrapper.i(str2, sb.toString());
        this.e.edit().putString("cachedMergeFactors", str).apply();
    }

    public DistributionNodesConfig c() {
        SharedPreferences sharedPreferences = this.e;
        if (sharedPreferences == null) {
            LoggerWrapper.e(f7386a, "mSharedPreferences is null! loaded backupConfigs is null!");
            return null;
        }
        try {
            String string = sharedPreferences.getString("distributionNodes", null);
            if (string == null) {
                return null;
            }
            try {
                return (DistributionNodesConfig) JSON.parseObject(string, DistributionNodesConfig.class);
            } catch (Throwable th) {
                String str = f7386a;
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot parse backupConfigs. error = ");
                sb.append(th.getMessage());
                LoggerWrapper.e(str, sb.toString());
                return null;
            }
        } catch (Throwable th2) {
            String str2 = f7386a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("get backupConfigs failed! error = ");
            sb2.append(th2.getMessage());
            LoggerWrapper.e(str2, sb2.toString());
            return null;
        }
    }

    public String d() {
        SharedPreferences sharedPreferences = this.e;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString("cachedMergeFactors", null);
    }

    public long e() {
        SharedPreferences sharedPreferences = this.e;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("lastRefreshTime", 0L);
        }
        return 0L;
    }
}

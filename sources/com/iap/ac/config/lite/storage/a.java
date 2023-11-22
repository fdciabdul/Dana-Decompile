package com.iap.ac.config.lite.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.config.lite.d.e;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes3.dex */
public class a {
    private static final String f = e.b("ConfigStorage");

    /* renamed from: a  reason: collision with root package name */
    private ISecurityEncryptor f7651a;
    private Context b;
    private String c;
    private SharedPreferences d;
    private String e;

    public a(Context context, String str, String str2) {
        String obj;
        this.b = context;
        str = TextUtils.isEmpty(str) ? "default" : str;
        if (TextUtils.isEmpty(str2)) {
            obj = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("_");
            sb.append(str2);
            obj = sb.toString();
        }
        this.c = String.format("aplus_config_lite_%s%s.contents", str, obj);
        this.e = String.format("aplus_config_lite_%s%s.cdn.contents", str, obj);
        this.d = this.b.getSharedPreferences(String.format("aplus_config_lite_%s%s.prefs", str, obj), 0);
    }

    private static String a(InputStream inputStream) {
        Throwable th;
        InputStreamReader inputStreamReader;
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
                if (read != -1) {
                    sb.append(cArr, 0, read);
                } else {
                    return sb.toString();
                }
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                ACLog.e(f, "readInputStream", th);
                return null;
            } finally {
                a(inputStreamReader);
                a((Closeable) inputStream);
            }
        }
    }

    public void b() {
        SharedPreferences sharedPreferences = this.d;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("lastRefreshTime", 0L).apply();
        }
    }

    public boolean c(String str) {
        ISecurityEncryptor iSecurityEncryptor = this.f7651a;
        if (iSecurityEncryptor != null) {
            str = iSecurityEncryptor.encrypt(str);
        }
        try {
            FileOutputStream openFileOutput = this.b.openFileOutput(this.c, 0);
            if (openFileOutput == null) {
                a(openFileOutput);
                return false;
            }
            byte[] bytes = str != null ? str.getBytes() : new byte[0];
            openFileOutput.write(bytes);
            ACLog.i(f, String.format("** saveConfig Success! bytes = %s.", String.valueOf(bytes.length)));
            a(openFileOutput);
            return true;
        } catch (Throwable th) {
            try {
                ACLog.e(f, "saveConfig Error!", th);
                return false;
            } finally {
                a((Closeable) null);
            }
        }
    }

    public String d() {
        return e.a(this.b, this.e);
    }

    public void e(String str) {
        if (this.d == null) {
            return;
        }
        String str2 = f;
        StringBuilder sb = new StringBuilder();
        sb.append("saveReMergeFactors: ");
        sb.append(str);
        ACLog.i(str2, sb.toString());
        this.d.edit().putString("cachedMergeFactors", str).apply();
    }

    public long f() {
        SharedPreferences sharedPreferences = this.d;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("lastRefreshTime", 0L);
        }
        return 0L;
    }

    public String g() {
        SharedPreferences sharedPreferences = this.d;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString("cachedMergeFactors", null);
    }

    public String h() {
        SharedPreferences sharedPreferences = this.d;
        return sharedPreferences != null ? sharedPreferences.getString("mixAttribute", "") : "";
    }

    public String i() {
        try {
            FileInputStream openFileInput = this.b.openFileInput(this.c);
            if (openFileInput == null) {
                return null;
            }
            String a2 = a((InputStream) openFileInput);
            ISecurityEncryptor iSecurityEncryptor = this.f7651a;
            if (iSecurityEncryptor != null) {
                a2 = iSecurityEncryptor.decrypt(a2);
            }
            ACLog.i(f, String.format("** loadConfig Success! bytes = %s.", String.valueOf(a2 != null ? a2.getBytes().length : 0)));
            return a2;
        } catch (Throwable th) {
            ACLog.w(f, String.format("** loadConfig Failed! Take it easy, cache file not exists. message = %s.", th.getMessage()));
            return null;
        }
    }

    public void d(String str) {
        SharedPreferences sharedPreferences = this.d;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("mixAttribute", str).apply();
        }
    }

    public void b(String str) {
        SharedPreferences sharedPreferences = this.d;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("lastModified", str).apply();
        }
    }

    public String e() {
        SharedPreferences sharedPreferences = this.d;
        return sharedPreferences != null ? sharedPreferences.getString("lastModified", "") : "";
    }

    public a(Context context) {
        this.b = context;
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

    public void a(long j) {
        SharedPreferences sharedPreferences = this.d;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("lastRefreshTime", j).apply();
        }
    }

    public void a() {
        SharedPreferences sharedPreferences = this.d;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("lastModified", "").apply();
        }
    }

    public void a(String str) {
        e.a(this.b, this.e, str);
    }

    public boolean c() {
        try {
            for (String str : this.b.fileList()) {
                if (str.startsWith("aplus_config_lite") && str.endsWith(".contents")) {
                    ACLog.i(f, String.format("** delete cache file %s", str));
                    this.b.deleteFile(str);
                }
            }
            return true;
        } catch (Throwable th) {
            ACLog.e(f, "deleteConfig Error!", th);
            return false;
        }
    }
}

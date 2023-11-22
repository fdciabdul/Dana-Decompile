package com.huawei.hms.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.text.TextUtils;
import android.util.AndroidException;
import com.huawei.hms.support.log.HMSLog;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/* loaded from: classes8.dex */
public class PackageManagerHelper {

    /* renamed from: a  reason: collision with root package name */
    public final PackageManager f7518a;

    /* loaded from: classes8.dex */
    public enum PackageStates {
        ENABLED,
        DISABLED,
        NOT_INSTALLED,
        SPOOF
    }

    public PackageManagerHelper(Context context) {
        this.f7518a = context.getPackageManager();
    }

    public final byte[] a(String str) {
        try {
            PackageInfo packageInfo = this.f7518a.getPackageInfo(str, 64);
            if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                return packageInfo.signatures[0].toByteArray();
            }
        } catch (AndroidException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to get application signature certificate fingerprint.");
            sb.append(e.getMessage());
            HMSLog.e("PackageManagerHelper", sb.toString());
        } catch (RuntimeException e2) {
            HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint.", e2);
        }
        HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint.");
        return new byte[0];
    }

    public String getApplicationName(String str) {
        try {
            return this.f7518a.getApplicationLabel(this.f7518a.getApplicationInfo(str, 128)).toString();
        } catch (AndroidException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to get application name for ");
            sb.append(str);
            HMSLog.e("PackageManagerHelper", sb.toString());
            return null;
        }
    }

    public long getPackageFirstInstallTime(String str) {
        try {
            PackageInfo packageInfo = this.f7518a.getPackageInfo(str, 128);
            if (packageInfo != null) {
                return packageInfo.firstInstallTime;
            }
            return 0L;
        } catch (AndroidException | RuntimeException unused) {
            return 0L;
        }
    }

    public String getPackageSignature(String str) {
        byte[] a2 = a(str);
        if (a2 == null || a2.length == 0) {
            return null;
        }
        return HEX.encodeHexString(SHA256.digest(a2), true);
    }

    public PackageStates getPackageStates(String str) {
        if (TextUtils.isEmpty(str)) {
            return PackageStates.NOT_INSTALLED;
        }
        try {
            if (this.f7518a.getApplicationInfo(str, 128).enabled) {
                return PackageStates.ENABLED;
            }
            return PackageStates.DISABLED;
        } catch (AndroidException unused) {
            return PackageStates.NOT_INSTALLED;
        }
    }

    public int getPackageVersionCode(String str) {
        try {
            PackageInfo packageInfo = this.f7518a.getPackageInfo(str, 16);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (AndroidException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("get PackageVersionCode failed ");
            sb.append(e);
            HMSLog.e("PackageManagerHelper", sb.toString());
            return 0;
        } catch (RuntimeException e2) {
            HMSLog.e("PackageManagerHelper", "get PackageVersionCode failed", e2);
            return 0;
        }
    }

    public String getPackageVersionName(String str) {
        try {
            PackageInfo packageInfo = this.f7518a.getPackageInfo(str, 16);
            return (packageInfo == null || packageInfo.versionName == null) ? "" : packageInfo.versionName;
        } catch (AndroidException unused) {
            return "";
        } catch (RuntimeException e) {
            HMSLog.e("PackageManagerHelper", "get getPackageVersionName failed", e);
            return "";
        }
    }

    public boolean hasProvider(String str, String str2) {
        try {
            PackageInfo packageInfo = this.f7518a.getPackageInfo(str, 8);
            if (packageInfo != null && packageInfo.providers != null) {
                for (ProviderInfo providerInfo : packageInfo.providers) {
                    if (str2.equals(providerInfo.authority)) {
                        return true;
                    }
                }
            }
        } catch (AndroidException | RuntimeException unused) {
        }
        return false;
    }

    public boolean isPackageFreshInstall(String str) {
        try {
            PackageInfo packageInfo = this.f7518a.getPackageInfo(str, 128);
            if (packageInfo != null) {
                return packageInfo.firstInstallTime == packageInfo.lastUpdateTime;
            }
            return false;
        } catch (AndroidException | RuntimeException unused) {
            return false;
        }
    }

    public boolean verifyPackageArchive(String str, String str2, String str3) {
        PackageInfo packageArchiveInfo = this.f7518a.getPackageArchiveInfo(str, 64);
        if (packageArchiveInfo == null || packageArchiveInfo.signatures.length <= 0 || !str2.equals(packageArchiveInfo.packageName)) {
            return false;
        }
        InputStream inputStream = null;
        try {
            try {
                inputStream = IOUtils.toInputStream(packageArchiveInfo.signatures[0].toByteArray());
                return str3.equalsIgnoreCase(HEX.encodeHexString(SHA256.digest(CertificateFactory.getInstance("X.509").generateCertificate(inputStream).getEncoded()), true));
            } catch (IOException | CertificateException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to get application signature certificate fingerprint.");
                sb.append(e.getMessage());
                HMSLog.e("PackageManagerHelper", sb.toString());
                return false;
            }
        } finally {
            IOUtils.closeQuietly((InputStream) null);
        }
    }
}

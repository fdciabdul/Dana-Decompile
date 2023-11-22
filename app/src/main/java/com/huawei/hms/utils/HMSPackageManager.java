package com.huawei.hms.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.common.PackageConstants;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class HMSPackageManager {
    public static HMSPackageManager l;
    public static final Object m = new Object();
    public static final Object n = new Object();

    /* renamed from: o  reason: collision with root package name */
    public static final Object f7514o = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Context f7515a;
    public final PackageManagerHelper b;
    public String c;
    public String d;
    public int e;
    public String f;
    public String g;
    public String h;
    public int i;
    public int j;
    public long k;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.i("HMSPackageManager", "enter asyncOnceCheckMDMState");
            Iterator<ResolveInfo> it = HMSPackageManager.this.f7515a.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128).iterator();
            while (it.hasNext()) {
                if ("com.huawei.hwid".equals(it.next().serviceInfo.applicationInfo.packageName)) {
                    HMSPackageManager.this.c();
                }
            }
            HMSLog.i("HMSPackageManager", "quit asyncOnceCheckMDMState");
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        public String f7517a;
        public String b;
        public String c;
        public String d;
        public String e;
        public Long f;

        public b(String str, String str2, String str3, String str4, String str5, long j) {
            this.f7517a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f = Long.valueOf(j);
        }

        @Override // java.lang.Comparable
        /* renamed from: a  reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            if (TextUtils.equals(this.e, bVar.e)) {
                return this.f.compareTo(bVar.f);
            }
            return this.e.compareTo(bVar.e);
        }
    }

    public HMSPackageManager(Context context) {
        this.f7515a = context;
        this.b = new PackageManagerHelper(context);
    }

    public static HMSPackageManager getInstance(Context context) {
        synchronized (m) {
            if (l == null) {
                if (context.getApplicationContext() != null) {
                    l = new HMSPackageManager(context.getApplicationContext());
                } else {
                    l = new HMSPackageManager(context);
                }
                l.j();
                l.a();
            }
        }
        return l;
    }

    public final int c() {
        synchronized (f7514o) {
            HMSLog.i("HMSPackageManager", "enter checkHmsIsSpoof");
            if (!(this.j == 3 || this.k != this.b.getPackageFirstInstallTime("com.huawei.hwid"))) {
                StringBuilder sb = new StringBuilder();
                sb.append("quit checkHmsIsSpoof cached state: ");
                sb.append(a(this.j));
                HMSLog.i("HMSPackageManager", sb.toString());
                return this.j;
            }
            this.j = b() ? 2 : 1;
            this.k = this.b.getPackageFirstInstallTime("com.huawei.hwid");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("quit checkHmsIsSpoof state: ");
            sb2.append(a(this.j));
            HMSLog.i("HMSPackageManager", sb2.toString());
            return this.j;
        }
    }

    public final void d() {
        synchronized (n) {
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = 0;
        }
    }

    public final void e() {
        synchronized (n) {
            this.c = null;
            this.d = null;
            this.e = 0;
        }
    }

    public final Pair<String, String> f() {
        List<ResolveInfo> queryIntentServices = this.f7515a.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
        if (queryIntentServices.size() == 0) {
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentServices) {
            String str = resolveInfo.serviceInfo.applicationInfo.packageName;
            Bundle bundle = resolveInfo.serviceInfo.metaData;
            if (bundle == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("skip package ");
                sb.append(str);
                sb.append(" for metadata is null");
                HMSLog.e("HMSPackageManager", sb.toString());
            } else if (!bundle.containsKey("hms_app_signer")) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("skip package ");
                sb2.append(str);
                sb2.append(" for no signer");
                HMSLog.e("HMSPackageManager", sb2.toString());
            } else if (!bundle.containsKey("hms_app_cert_chain")) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("skip package ");
                sb3.append(str);
                sb3.append(" for no cert chain");
                HMSLog.e("HMSPackageManager", sb3.toString());
            } else {
                String packageSignature = this.b.getPackageSignature(str);
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append(ContainerUtils.FIELD_DELIMITER);
                sb4.append(packageSignature);
                if (!a(sb4.toString(), bundle.getString("hms_app_signer"), bundle.getString("hms_app_cert_chain"))) {
                    HMSLog.e("HMSPackageManager", "checkSigner failed");
                } else {
                    return new Pair<>(str, packageSignature);
                }
            }
        }
        return null;
    }

    public final Pair<String, String> g() {
        Pair<String, String> f = f();
        if (f != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("aidlService pkgName: ");
            sb.append((String) f.first);
            HMSLog.i("HMSPackageManager", sb.toString());
            this.h = "com.huawei.hms.core.aidlservice";
            return f;
        }
        ArrayList<b> h = h();
        if (h == null) {
            HMSLog.e("HMSPackageManager", "PackagePriorityInfo list is null");
            return null;
        }
        Iterator<b> it = h.iterator();
        while (it.hasNext()) {
            b next = it.next();
            String str = next.f7517a;
            String str2 = next.b;
            String str3 = next.c;
            String str4 = next.d;
            String packageSignature = this.b.getPackageSignature(str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(ContainerUtils.FIELD_DELIMITER);
            sb2.append(packageSignature);
            sb2.append(ContainerUtils.FIELD_DELIMITER);
            sb2.append(str2);
            if (a(sb2.toString(), str3, str4)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("result: ");
                sb3.append(str);
                sb3.append(", ");
                sb3.append(str2);
                sb3.append(", ");
                sb3.append(next.f);
                HMSLog.i("HMSPackageManager", sb3.toString());
                this.h = PackageConstants.GENERAL_SERVICES_ACTION;
                b(str2);
                return new Pair<>(str, packageSignature);
            }
        }
        return null;
    }

    public String getHMSFingerprint() {
        String str = this.d;
        return str == null ? "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05" : str;
    }

    public String getHMSPackageName() {
        HMSLog.i("HMSPackageManager", "Enter getHMSPackageName");
        refresh();
        String str = this.c;
        if (str != null) {
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.b.getPackageStates(str))) {
                HMSLog.i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
                i();
            }
            String str2 = this.c;
            if (str2 != null) {
                return str2;
            }
        }
        if (!PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.b.getPackageStates("com.huawei.hwid"))) {
            this.b.getPackageSignature("com.huawei.hwid");
        }
        return "com.huawei.hwid";
    }

    public String getHMSPackageNameForMultiService() {
        HMSLog.i("HMSPackageManager", "Enter getHMSPackageNameForMultiService");
        refreshForMultiService();
        String str = this.f;
        if (str != null) {
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.b.getPackageStates(str))) {
                HMSLog.i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
                j();
            }
            String str2 = this.f;
            return str2 != null ? str2 : "com.huawei.hwid";
        }
        return "com.huawei.hwid";
    }

    public PackageManagerHelper.PackageStates getHMSPackageStates() {
        synchronized (m) {
            refresh();
            PackageManagerHelper.PackageStates packageStates = this.b.getPackageStates(this.c);
            if (packageStates == PackageManagerHelper.PackageStates.NOT_INSTALLED) {
                e();
                return PackageManagerHelper.PackageStates.NOT_INSTALLED;
            }
            boolean z = true;
            if ("com.huawei.hwid".equals(this.c) && c() == 1) {
                return PackageManagerHelper.PackageStates.SPOOF;
            }
            if (packageStates != PackageManagerHelper.PackageStates.ENABLED || this.d.equals(this.b.getPackageSignature(this.c))) {
                z = false;
            }
            if (z) {
                return PackageManagerHelper.PackageStates.NOT_INSTALLED;
            }
            return packageStates;
        }
    }

    public PackageManagerHelper.PackageStates getHMSPackageStatesForMultiService() {
        synchronized (m) {
            refreshForMultiService();
            PackageManagerHelper.PackageStates packageStates = this.b.getPackageStates(this.f);
            if (packageStates == PackageManagerHelper.PackageStates.NOT_INSTALLED) {
                d();
                return PackageManagerHelper.PackageStates.NOT_INSTALLED;
            }
            boolean z = true;
            if ("com.huawei.hwid".equals(this.f) && c() == 1) {
                return PackageManagerHelper.PackageStates.SPOOF;
            }
            if (packageStates != PackageManagerHelper.PackageStates.ENABLED || this.g.equals(this.b.getPackageSignature(this.f))) {
                z = false;
            }
            if (z) {
                return PackageManagerHelper.PackageStates.NOT_INSTALLED;
            }
            return packageStates;
        }
    }

    public int getHmsMultiServiceVersion() {
        return this.b.getPackageVersionCode(getHMSPackageNameForMultiService());
    }

    public int getHmsVersionCode() {
        return this.b.getPackageVersionCode(getHMSPackageName());
    }

    public String getInnerServiceAction() {
        return PackageConstants.INTERNAL_SERVICES_ACTION;
    }

    public String getServiceAction() {
        return !TextUtils.isEmpty(this.h) ? this.h : "com.huawei.hms.core.aidlservice";
    }

    public final ArrayList<b> h() {
        List<ResolveInfo> queryIntentServices = this.f7515a.getPackageManager().queryIntentServices(new Intent(PackageConstants.GENERAL_SERVICES_ACTION), 128);
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            ArrayList<b> arrayList = new ArrayList<>();
            for (ResolveInfo resolveInfo : queryIntentServices) {
                String str = resolveInfo.serviceInfo.applicationInfo.packageName;
                long packageFirstInstallTime = this.b.getPackageFirstInstallTime(str);
                Bundle bundle = resolveInfo.serviceInfo.metaData;
                if (bundle == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("package ");
                    sb.append(str);
                    sb.append(" get metaData is null");
                    HMSLog.e("HMSPackageManager", sb.toString());
                } else {
                    String a2 = a(bundle, "hms_app_checker_config");
                    String a3 = a(a2);
                    if (TextUtils.isEmpty(a3)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("get priority fail. hmsCheckerCfg: ");
                        sb2.append(a2);
                        HMSLog.i("HMSPackageManager", sb2.toString());
                    } else {
                        String a4 = a(bundle, "hms_app_signer_v2");
                        if (TextUtils.isEmpty(a4)) {
                            HMSLog.i("HMSPackageManager", "get signerV2 fail.");
                        } else {
                            String a5 = a(bundle, "hms_app_cert_chain");
                            if (TextUtils.isEmpty(a5)) {
                                HMSLog.i("HMSPackageManager", "get certChain fail.");
                            } else {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("add: ");
                                sb3.append(str);
                                sb3.append(", ");
                                sb3.append(a2);
                                sb3.append(", ");
                                sb3.append(packageFirstInstallTime);
                                HMSLog.i("HMSPackageManager", sb3.toString());
                                arrayList.add(new b(str, a2, a4, a5, a3, packageFirstInstallTime));
                            }
                        }
                    }
                }
            }
            Collections.sort(arrayList);
            return arrayList;
        }
        HMSLog.e("HMSPackageManager", "resolveInfoList is null or empty");
        return null;
    }

    public boolean hmsVerHigherThan(int i) {
        if (this.e >= i || !k()) {
            return true;
        }
        int packageVersionCode = this.b.getPackageVersionCode(getHMSPackageName());
        this.e = packageVersionCode;
        return packageVersionCode >= i;
    }

    public final void i() {
        synchronized (n) {
            Pair<String, String> f = f();
            if (f == null) {
                HMSLog.e("HMSPackageManager", "<initHmsPackageInfo> Failed to find HMS apk");
                e();
                return;
            }
            this.c = (String) f.first;
            this.d = (String) f.second;
            this.e = this.b.getPackageVersionCode(getHMSPackageName());
            StringBuilder sb = new StringBuilder();
            sb.append("<initHmsPackageInfo> Succeed to find HMS apk: ");
            sb.append(this.c);
            sb.append(" version: ");
            sb.append(this.e);
            HMSLog.i("HMSPackageManager", sb.toString());
        }
    }

    public boolean isApkNeedUpdate(int i) {
        int hmsVersionCode = getHmsVersionCode();
        StringBuilder sb = new StringBuilder();
        sb.append("current versionCode:");
        sb.append(hmsVersionCode);
        sb.append(", target version requirements: ");
        sb.append(i);
        HMSLog.i("HMSPackageManager", sb.toString());
        return hmsVersionCode < i;
    }

    public boolean isApkUpdateNecessary(int i) {
        int hmsVersionCode = getHmsVersionCode();
        StringBuilder sb = new StringBuilder();
        sb.append("current versionCode:");
        sb.append(hmsVersionCode);
        sb.append(", minimum version requirements: ");
        sb.append(i);
        HMSLog.i("HMSPackageManager", sb.toString());
        return k() && hmsVersionCode < i;
    }

    public final void j() {
        synchronized (n) {
            Pair<String, String> g = g();
            if (g == null) {
                HMSLog.e("HMSPackageManager", "<initHmsPackageInfoForMultiService> Failed to find HMS apk");
                d();
                return;
            }
            this.f = (String) g.first;
            this.g = (String) g.second;
            this.i = this.b.getPackageVersionCode(getHMSPackageNameForMultiService());
            StringBuilder sb = new StringBuilder();
            sb.append("<initHmsPackageInfoForMultiService> Succeed to find HMS apk: ");
            sb.append(this.f);
            sb.append(" version: ");
            sb.append(this.i);
            HMSLog.i("HMSPackageManager", sb.toString());
        }
    }

    public final boolean k() {
        PackageManager packageManager = this.f7515a.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to get 'PackageManager' instance.");
            return true;
        }
        try {
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.");
        } catch (RuntimeException e) {
            HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.", e);
        }
        if (!TextUtils.isEmpty(this.h) && (this.h.equals(PackageConstants.GENERAL_SERVICES_ACTION) || this.h.equals(PackageConstants.INTERNAL_SERVICES_ACTION))) {
            StringBuilder sb = new StringBuilder();
            sb.append("action = ");
            sb.append(this.h);
            sb.append(" exist");
            HMSLog.i("HMSPackageManager", sb.toString());
            return false;
        }
        ApplicationInfo applicationInfo = packageManager.getPackageInfo(getHMSPackageName(), 128).applicationInfo;
        if (applicationInfo != null && applicationInfo.metaData != null && applicationInfo.metaData.containsKey("com.huawei.hms.kit.api_level:hmscore") && (getHmsVersionCode() >= 50000000 || getHmsVersionCode() <= 19999999)) {
            HMSLog.i("HMSPackageManager", "MinApkVersion is disabled.");
            return false;
        }
        return true;
    }

    public void refresh() {
        if (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.d)) {
            i();
        }
    }

    public void refreshForMultiService() {
        if (TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.g)) {
            j();
        }
    }

    public void resetMultiServiceState() {
        d();
    }

    public final String a(Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("no ");
            sb.append(str);
            sb.append(" in metaData");
            HMSLog.e("HMSPackageManager", sb.toString());
            return null;
        }
        return bundle.getString(str);
    }

    public final void b(String str) {
        if (TextUtils.isEmpty(a(str))) {
        }
    }

    public final String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("priority=");
        if (indexOf == -1) {
            HMSLog.e("HMSPackageManager", "get indexOfIdentifier -1");
            return null;
        }
        int indexOf2 = str.indexOf(",", indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        return str.substring(indexOf, indexOf2);
    }

    public final boolean b() {
        String hmsPath = ReadApkFileUtil.getHmsPath(this.f7515a);
        if (hmsPath == null) {
            HMSLog.i("HMSPackageManager", "hmsPath is null!");
            return false;
        } else if (!ReadApkFileUtil.isCertFound(hmsPath)) {
            HMSLog.i("HMSPackageManager", "NO huawer.cer in HMS!");
            return false;
        } else if (!ReadApkFileUtil.checkSignature()) {
            HMSLog.i("HMSPackageManager", "checkSignature fail!");
            return false;
        } else if (ReadApkFileUtil.verifyApkHash(hmsPath)) {
            return true;
        } else {
            HMSLog.i("HMSPackageManager", "verifyApkHash fail!");
            return false;
        }
    }

    public final boolean a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            List<X509Certificate> b2 = com.huawei.hms.device.a.b(str3);
            if (b2.size() == 0) {
                HMSLog.e("HMSPackageManager", "certChain is empty");
                return false;
            } else if (!com.huawei.hms.device.a.a(com.huawei.hms.device.a.a(this.f7515a), b2)) {
                HMSLog.e("HMSPackageManager", "failed to verify cert chain");
                return false;
            } else {
                X509Certificate x509Certificate = b2.get(b2.size() - 1);
                if (!com.huawei.hms.device.a.a(x509Certificate, "Huawei CBG HMS")) {
                    HMSLog.e("HMSPackageManager", "CN is invalid");
                    return false;
                } else if (!com.huawei.hms.device.a.b(x509Certificate, "Huawei CBG Cloud Security Signer")) {
                    HMSLog.e("HMSPackageManager", "OU is invalid");
                    return false;
                } else if (com.huawei.hms.device.a.a(x509Certificate, str, str2)) {
                    return true;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("signature is invalid: ");
                    sb.append(str);
                    HMSLog.e("HMSPackageManager", sb.toString());
                    return false;
                }
            }
        }
        HMSLog.e("HMSPackageManager", "args is invalid");
        return false;
    }

    public final void a() {
        new Thread(new a(), "Thread-asyncOnceCheckMDMState").start();
    }

    public static String a(int i) {
        if (i == 1) {
            return "SPOOFED";
        }
        if (i == 2) {
            return "SUCCESS";
        }
        if (i == 3) {
            return "UNCHECKED";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("invalid checkMDM state: ");
        sb.append(i);
        HMSLog.e("HMSPackageManager", sb.toString());
        return "";
    }
}

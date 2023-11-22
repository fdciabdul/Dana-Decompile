package com.alipay.imobile.network.quake.ext.proxy;

import android.content.Context;
import android.content.SharedPreferences;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.imobile.network.quake.Quake;
import com.alipay.mobile.rome.syncsdk.transport.connection.d;
import com.alipay.mobile.rome.syncsdk.transport.connection.f;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.push.e;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.ut.device.UTDevice;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.here.model.HereUrlConstant;
import id.dana.sendmoney.summary.SummaryActivity;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class a {
    private static a i;

    /* renamed from: a  reason: collision with root package name */
    private final Context f7046a;
    private String c;
    private String d;
    private String f;
    public static final byte[] PlaceComponentResult = {108, -22, 67, 3, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int MyBillsEntityDataFactory = 39;
    private final Object b = new Object();
    private final AtomicBoolean e = new AtomicBoolean(false);
    public String[] g = {"0", "1", "2", "3", "4", "5", "6", "7", "8", PrepareException.ERROR_OFFLINE_APP, "a", "b", "c", d.f7256a, e.PlaceComponentResult, f.f7258a, "g", "h", i.MyBillsEntityDataFactory, "j", "k", "l", "m", "n", "o", BranchLinkConstant.PayloadKey.PROMO_CODE, HereUrlConstant.QUERY, BranchLinkConstant.PayloadKey.REFERRAL, "s", SecurityConstants.KEY_TEXT, "u", SecurityConstants.KEY_VALUE, "w", "x", "y", "z", "A", DiskFormatter.B, "C", SummaryActivity.DAYS, "E", LogConstants.RESULT_FALSE, DiskFormatter.GB, SummaryActivity.HOURS, "I", "J", DiskFormatter.KB, "L", DiskFormatter.MB, "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private final SimpleDateFormat h = new SimpleDateFormat("yyMMddHHmmssSSS");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alipay.imobile.network.quake.ext.proxy.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0061a implements Runnable {
        RunnableC0061a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.e.set(true);
            LoggerWrapper.v(Quake.TAG, "generateUtDid...");
            a aVar = a.this;
            aVar.c = UTDevice.getUtdid(aVar.f7046a);
            LoggerWrapper.v(Quake.TAG, "generateUtDid finish");
            a.this.e.set(false);
            synchronized (a.this.b) {
                a.this.b.notifyAll();
            }
        }
    }

    private a(Context context) {
        this.f7046a = context.getApplicationContext();
    }

    private boolean a(byte b) {
        return (b >= 48 && b <= 57) || (b >= 97 && b <= 122) || (b >= 65 && b <= 90);
    }

    private String d() {
        Random random = new Random(System.currentTimeMillis());
        int length = this.g.length;
        String str = "";
        for (int i2 = 0; i2 < 10; i2++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(this.g[random.nextInt(length)]);
            str = sb.toString();
        }
        return str;
    }

    private void e() {
        try {
            if (Class.forName("com.ut.device.UTDevice") == null) {
                return;
            }
            new Thread(new RunnableC0061a(), "generateUtDid").start();
        } catch (ClassNotFoundException e) {
            LoggerWrapper.d(Quake.TAG, e.getMessage());
        }
    }

    private void f() {
        this.f = g();
        this.d = h();
        e();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:1|2|3|(3:5|6|(6:8|9|10|11|12|(5:14|15|(5:49|50|51|53|54)(1:19)|20|(6:22|(4:24|(1:26)|27|(1:29))|30|(4:32|(1:34)|35|(1:37))|38|39)(6:41|(1:43)|44|(1:46)|47|48))(6:61|9|10|11|12|(0)(0)))(5:64|10|11|12|(0)(0)))|66|63|15|(1:17)|49|50|51|53|54|20|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b3, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b5, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b6, code lost:
    
        r8 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b7, code lost:
    
        com.alipay.iap.android.common.log.LoggerWrapper.d(com.alipay.imobile.network.quake.Quake.TAG, "", r0);
        r0 = "";
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0051 A[Catch: Exception -> 0x0082, TryCatch #2 {Exception -> 0x0082, blocks: (B:11:0x004c, B:13:0x0051, B:14:0x0078), top: B:65:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0078 A[Catch: Exception -> 0x0082, TRY_LEAVE, TryCatch #2 {Exception -> 0x0082, blocks: (B:11:0x004c, B:13:0x0051, B:14:0x0078), top: B:65:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x017c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0078 -> B:15:0x007c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String g() {
        /*
            Method dump skipped, instructions count: 448
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.ext.proxy.a.g():java.lang.String");
    }

    private String h() {
        Context context = this.f7046a;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7046a.getPackageName());
        sb.append(".quake.config");
        SharedPreferences sharedPreferences = context.getSharedPreferences(sb.toString(), 0);
        String string = sharedPreferences.getString("clientKey", "");
        if ("".equals(string)) {
            String d = d();
            sharedPreferences.edit().putString("clientKey", d).apply();
            return d;
        }
        return string;
    }

    private boolean c(String str) {
        return !a(str) && str.matches("[[a-z][A-Z][0-9]]{15}\\|[[a-z][A-Z][0-9]]{15}");
    }

    public String b() {
        if (this.e.get()) {
            synchronized (this.b) {
                try {
                    this.b.wait();
                } catch (InterruptedException e) {
                    LoggerWrapper.e(Quake.TAG, "", e);
                }
            }
        }
        String str = this.c;
        if (str == null || "".equals(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(this.d);
            return sb.toString();
        }
        return this.c;
    }

    public static a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (i == null) {
                a aVar2 = new a(context);
                i = aVar2;
                aVar2.f();
            }
            aVar = i;
        }
        return aVar;
    }

    public String c() {
        return this.h.format(Long.valueOf(System.currentTimeMillis()));
    }

    private String d(String str) {
        if (!b(str)) {
            str = c();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("123456789012345");
        return e(sb.toString().substring(0, 15));
    }

    public String a() {
        return this.f;
    }

    private boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    private String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(d(str));
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append(d(str2));
        return sb.toString();
    }

    private boolean b(String str) {
        if (a(str)) {
            return false;
        }
        String trim = str.trim();
        return (trim.equalsIgnoreCase("unknown") || trim.equalsIgnoreCase("null") || trim.matches("[0]+") || trim.length() <= 5) ? false : true;
    }

    private String e(String str) {
        if (a(str)) {
            return str;
        }
        byte[] bytes = str.getBytes();
        for (int i2 = 0; i2 < bytes.length; i2++) {
            if (!a(bytes[i2])) {
                bytes[i2] = TarHeader.LF_NORMAL;
            }
        }
        return new String(bytes);
    }
}

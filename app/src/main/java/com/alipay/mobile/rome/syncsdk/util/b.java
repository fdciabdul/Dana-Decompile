package com.alipay.mobile.rome.syncsdk.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.telephony.TelephonyManager;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.here.model.HereUrlConstant;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.Random;

/* loaded from: classes3.dex */
public final class b {
    private static final String d = "b";
    private static b g;
    private static final String[] h = {"0", "1", "2", "3", "4", "5", "6", "7", "8", PrepareException.ERROR_OFFLINE_APP, "a", "b", "c", com.alipay.mobile.rome.syncsdk.transport.connection.d.f7256a, com.huawei.hms.push.e.PlaceComponentResult, com.alipay.mobile.rome.syncsdk.transport.connection.f.f7258a, "g", "h", com.huawei.hms.opendevice.i.MyBillsEntityDataFactory, "j", "k", "l", "m", "n", "o", BranchLinkConstant.PayloadKey.PROMO_CODE, HereUrlConstant.QUERY, BranchLinkConstant.PayloadKey.REFERRAL, "s", SecurityConstants.KEY_TEXT, "u", SecurityConstants.KEY_VALUE, "w", "x", "y", "z", "A", DiskFormatter.B, "C", SummaryActivity.DAYS, "E", LogConstants.RESULT_FALSE, DiskFormatter.GB, SummaryActivity.HOURS, "I", "J", DiskFormatter.KB, "L", DiskFormatter.MB, "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    /* renamed from: a  reason: collision with root package name */
    volatile String f7264a = "000000000000000";
    volatile String b = "000000000000000";
    volatile String c = "0000000000";
    private volatile String e;
    private volatile int f;

    private b() {
    }

    public static b a(Context context) {
        b bVar;
        String str;
        String str2;
        synchronized (b.class) {
            if (g == null) {
                b bVar2 = new b();
                g = bVar2;
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                    bVar2.e = packageInfo.versionName;
                    bVar2.f = packageInfo.versionCode;
                } catch (Exception e) {
                    String str3 = d;
                    StringBuilder sb = new StringBuilder("init: [ Exception ");
                    sb.append(e);
                    sb.append(" ]");
                    c.d(str3, sb.toString());
                }
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    String deviceId = telephonyManager.getDeviceId();
                    if (deviceId != null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(deviceId);
                        sb2.append("000000000000000");
                        str = sb2.toString().substring(0, 15);
                    } else {
                        str = "000000000000000";
                    }
                    bVar2.f7264a = str;
                    String subscriberId = telephonyManager.getSubscriberId();
                    if (subscriberId != null) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(subscriberId);
                        sb3.append("000000000000000");
                        str2 = sb3.toString().substring(0, 15);
                    } else {
                        str2 = "000000000000000";
                    }
                    bVar2.b = str2;
                } catch (Exception e2) {
                    String str4 = d;
                    StringBuilder sb4 = new StringBuilder("init: [ Exception ");
                    sb4.append(e2);
                    sb4.append(" ]");
                    c.d(str4, sb4.toString());
                }
                bVar2.c = a();
            }
            bVar = g;
        }
        return bVar;
    }

    private static String a() {
        Random random = new Random(System.currentTimeMillis());
        int length = h.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(h[random.nextInt(length)]);
        }
        return sb.toString();
    }
}

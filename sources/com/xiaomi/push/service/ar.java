package com.xiaomi.push.service;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes8.dex */
public class ar {
    public static final a<String, String, String> BuiltInFictitiousFunctionClassFactory;
    public static final a<String, String, String> KClassImpl$Data$declaredNonStaticMembers$2;
    public static final a<String, String, String> MyBillsEntityDataFactory;
    public static final a<String, String, String> PlaceComponentResult;
    public static final a<String, String, String> getAuthRequestContext;
    private static final String[] moveToNextValue = {"com.mi.globalbrowser", "com.android.browser"};
    private static String lookAheadTest = null;

    /* loaded from: classes8.dex */
    public static class a<F, S, T> {
        S BuiltInFictitiousFunctionClassFactory;
        T MyBillsEntityDataFactory;
        F getAuthRequestContext;

        private a(F f, S s, T t) {
            this.getAuthRequestContext = f;
            this.BuiltInFictitiousFunctionClassFactory = s;
            this.MyBillsEntityDataFactory = t;
        }

        /* synthetic */ a(Object obj, Object obj2, Object obj3, byte b) {
            this(obj, obj2, obj3);
        }
    }

    static {
        String str = "canSound";
        byte b = 0;
        getAuthRequestContext = new a<>("setSound", str, str, b);
        String str2 = "canVibrate";
        PlaceComponentResult = new a<>("setVibrate", str2, str2, b);
        String str3 = "canLights";
        BuiltInFictitiousFunctionClassFactory = new a<>("setLights", str3, str3, b);
        String str4 = "canShowOnKeyguard";
        KClassImpl$Data$declaredNonStaticMembers$2 = new a<>("setShowOnKeyguard", str4, str4, b);
        MyBillsEntityDataFactory = new a<>("setFloat", "canFloat", "canShowFloat", b);
    }

    public static String BuiltInFictitiousFunctionClassFactory(Notification notification) {
        CharSequence charSequence;
        if (notification.extras != null) {
            charSequence = notification.extras.getCharSequence("android.title");
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("android.title.big");
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customTitle");
            }
        } else {
            charSequence = null;
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void BuiltInFictitiousFunctionClassFactory(Notification notification, int i) {
        try {
            if (notification.extras != null) {
                notification.extras.putInt("miui.messageCount", i);
            }
            Object PlaceComponentResult2 = com.xiaomi.push.z.PlaceComponentResult(notification, "extraNotification");
            if (PlaceComponentResult2 != null) {
                com.xiaomi.push.z.getAuthRequestContext(PlaceComponentResult2, "setMessageCount", Integer.valueOf(i));
            }
        } catch (Exception unused) {
        }
    }

    private static Bundle KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str, String str2, String str3, Bundle bundle) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("call notification provider failed!");
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("package", str2);
        if (!TextUtils.isEmpty(str3)) {
            bundle2.putString("channel_id", str3);
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        return context.getContentResolver().call(Uri.parse("content://statusbar.notification"), str, (String) null, bundle2);
    }

    private static <T> T KClassImpl$Data$declaredNonStaticMembers$2(Object obj, String str, T t) {
        Object obj2 = null;
        try {
            if (obj instanceof Notification) {
                obj2 = MyBillsEntityDataFactory((Notification) obj, str);
            } else if (obj instanceof Map) {
                obj2 = ((Map) obj).get(str);
            } else if (obj instanceof Bundle) {
                obj2 = ((Bundle) obj).get(str);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("not support get value from classType:");
                sb.append(obj);
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            }
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("get value error ");
            sb2.append(e);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
        }
        return obj2 != null ? (T) obj2 : t;
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(Notification notification) {
        Object PlaceComponentResult2;
        try {
            r0 = notification.extras != null ? notification.extras.getString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE) : null;
            return (!TextUtils.isEmpty(r0) || (PlaceComponentResult2 = com.xiaomi.push.z.PlaceComponentResult(notification, "extraNotification")) == null) ? r0 : (String) com.xiaomi.push.z.getAuthRequestContext(PlaceComponentResult2, "getTargetPkg", new Object[0]);
        } catch (Exception unused) {
            return r0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void KClassImpl$Data$declaredNonStaticMembers$2(Notification notification, int i, int i2) {
        if (notification != null) {
            if (notification.extras == null) {
                notification.extras = new Bundle();
            }
            notification.extras.putInt("is_priority", i);
            notification.extras.putInt("mipush_class", i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void KClassImpl$Data$declaredNonStaticMembers$2(Notification notification, String str) {
        try {
            if (notification.extras != null) {
                notification.extras.putString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, str);
            }
            Object PlaceComponentResult2 = com.xiaomi.push.z.PlaceComponentResult(notification, "extraNotification");
            if (PlaceComponentResult2 != null) {
                com.xiaomi.push.z.getAuthRequestContext(PlaceComponentResult2, "setTargetPkg", str);
            }
        } catch (Exception unused) {
        }
    }

    private static int MyBillsEntityDataFactory(ContentResolver contentResolver) {
        try {
            return Settings.Global.getInt(contentResolver, "user_aggregate", 0);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("get user aggregate failed, ");
            sb.append(e);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int MyBillsEntityDataFactory(Context context, String str) {
        return com.xiaomi.channel.commonutils.android.a.PlaceComponentResult(context, str);
    }

    public static int MyBillsEntityDataFactory(Context context, String str, String str2, a<String, String, String> aVar) {
        if (aVar != null) {
            try {
                Bundle KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(context, aVar.BuiltInFictitiousFunctionClassFactory, str, str2, null);
                if (KClassImpl$Data$declaredNonStaticMembers$22 == null || !KClassImpl$Data$declaredNonStaticMembers$22.containsKey(aVar.MyBillsEntityDataFactory)) {
                    return -1;
                }
                return KClassImpl$Data$declaredNonStaticMembers$22.getBoolean(aVar.MyBillsEntityDataFactory) ? 1 : 0;
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    private static <T> T MyBillsEntityDataFactory(Notification notification, String str) {
        if (notification.extras != null) {
            try {
                return (T) notification.extras.get(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public static void MyBillsEntityDataFactory(Notification notification, boolean z) {
        try {
            if (notification.extras != null) {
                notification.extras.putBoolean("miui.enableKeyguard", z);
            }
            Object PlaceComponentResult2 = com.xiaomi.push.z.PlaceComponentResult(notification, "extraNotification");
            if (PlaceComponentResult2 != null) {
                com.xiaomi.push.z.getAuthRequestContext(PlaceComponentResult2, "setEnableKeyguard", Boolean.valueOf(z));
            }
        } catch (Exception unused) {
        }
    }

    public static void MyBillsEntityDataFactory(Map<String, String> map, Bundle bundle, String str) {
        if (map == null || bundle == null || TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("cp map to b fail:");
            sb.append(str);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        } else if (TextUtils.isEmpty(map.get(str))) {
            bundle.remove(str);
        } else {
            bundle.putString(str, map.get(str));
        }
    }

    public static boolean MyBillsEntityDataFactory(Context context, String str, String str2, a<String, String, String> aVar, boolean z) {
        if (aVar != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putBoolean(aVar.MyBillsEntityDataFactory, z);
                KClassImpl$Data$declaredNonStaticMembers$2(context, aVar.getAuthRequestContext, str, str2, bundle);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static Notification.Action[] MyBillsEntityDataFactory(Notification notification) {
        Parcelable[] parcelableArray;
        if (notification.actions != null) {
            return notification.actions;
        }
        if (notification.extras == null || (parcelableArray = notification.extras.getParcelableArray("mipush.customActions")) == null) {
            return null;
        }
        return (Notification.Action[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Notification.Action[].class);
    }

    public static String PlaceComponentResult(Notification notification) {
        CharSequence charSequence;
        if (notification.extras != null) {
            charSequence = notification.extras.getCharSequence("android.text");
            if (TextUtils.isEmpty(charSequence) && Build.VERSION.SDK_INT >= 21) {
                charSequence = notification.extras.getCharSequence("android.bigText");
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customContent");
            }
        } else {
            charSequence = null;
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void PlaceComponentResult(Context context, Intent intent) {
        String str;
        int i = -1;
        while (true) {
            str = i < 0 ? lookAheadTest : moveToNextValue[i];
            if (!TextUtils.isEmpty(str)) {
                intent.setPackage(str);
                try {
                    if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                        break;
                    }
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("not found xm browser:");
                    sb.append(e);
                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
                }
            }
            i++;
            if (i >= moveToNextValue.length) {
                str = null;
                break;
            }
        }
        intent.setPackage(str);
        lookAheadTest = str;
    }

    public static boolean PlaceComponentResult(Notification.Builder builder, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setGroupAlertBehavior(z ? 2 : 1);
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory("not support setGroupAlertBehavior");
        return false;
    }

    public static String getAuthRequestContext(Object obj) {
        return (String) KClassImpl$Data$declaredNonStaticMembers$2(obj, "msg_busi_type", "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getAuthRequestContext(Notification notification, boolean z) {
        try {
            if (notification.extras != null) {
                notification.extras.putBoolean("miui.enableFloat", z);
            }
            Object PlaceComponentResult2 = com.xiaomi.push.z.PlaceComponentResult(notification, "extraNotification");
            if (PlaceComponentResult2 != null) {
                com.xiaomi.push.z.getAuthRequestContext(PlaceComponentResult2, "setEnableFloat", Boolean.valueOf(z));
            }
        } catch (Exception unused) {
        }
    }

    public static boolean getAuthRequestContext(ContentResolver contentResolver) {
        int MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(contentResolver);
        return MyBillsEntityDataFactory2 == 1 || MyBillsEntityDataFactory2 == 2;
    }

    public static boolean getAuthRequestContext(Map<String, String> map) {
        return Boolean.parseBoolean((String) KClassImpl$Data$declaredNonStaticMembers$2(map, "not_suppress", SummaryActivity.CHECKED));
    }
}

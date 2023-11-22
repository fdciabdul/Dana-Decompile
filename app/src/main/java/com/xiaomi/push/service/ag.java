package com.xiaomi.push.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.alipay.mobile.zebra.data.BoxData;
import com.google.common.base.Ascii;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.push.di;
import com.xiaomi.push.dq;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class ag {
    private static volatile al BuiltInFictitiousFunctionClassFactory;
    public static long MyBillsEntityDataFactory;
    public static final byte[] getAuthRequestContext = {4, -20, -33, -123, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4, -6, -23, 43, -55, -8, -4, -5, -2, -6, -27, 3, -14, -7, Ascii.GS, -45, 0, -17};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static final LinkedList<Pair<Integer, dq>> PlaceComponentResult = new LinkedList<>();
    private static ExecutorService moveToNextValue = Executors.newCachedThreadPool();

    /* loaded from: classes8.dex */
    public static class b {
        Notification KClassImpl$Data$declaredNonStaticMembers$2;
        long getAuthRequestContext = 0;
    }

    /* loaded from: classes8.dex */
    public static class c {
        public String KClassImpl$Data$declaredNonStaticMembers$2;
        public long BuiltInFictitiousFunctionClassFactory = 0;
        public boolean PlaceComponentResult = false;
    }

    private static int BuiltInFictitiousFunctionClassFactory(Map<String, String> map) {
        String str = map == null ? null : map.get(TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT);
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String BuiltInFictitiousFunctionClassFactory(dq dqVar) {
        di m308a;
        if ("com.xiaomi.xmsf".equals(dqVar.f229b) && (m308a = dqVar.m308a()) != null && m308a.m278a() != null) {
            String str = m308a.m278a().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return dqVar.f229b;
    }

    public static void BuiltInFictitiousFunctionClassFactory(Context context, String str, int i) {
        MyBillsEntityDataFactory(context, str, i, -1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x004e, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0050, code lost:
    
        r1 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0071, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String[] BuiltInFictitiousFunctionClassFactory(android.content.Context r3, com.xiaomi.push.di r4) {
        /*
            java.lang.String r0 = r4.m285c()
            java.lang.String r1 = r4.d()
            java.util.Map r4 = r4.m278a()
            if (r4 == 0) goto L74
            android.content.res.Resources r2 = r3.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.content.res.Resources r3 = r3.getResources()
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            float r3 = r3.density
            float r2 = (float) r2
            float r2 = r2 / r3
            r3 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r3
            java.lang.Float r3 = java.lang.Float.valueOf(r2)
            int r3 = r3.intValue()
            r2 = 320(0x140, float:4.48E-43)
            if (r3 > r2) goto L52
            java.lang.String r3 = "title_short"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L42
            r0 = r3
        L42:
            java.lang.String r3 = "description_short"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L74
        L50:
            r1 = r3
            goto L74
        L52:
            r2 = 360(0x168, float:5.04E-43)
            if (r3 <= r2) goto L74
            java.lang.String r3 = "title_long"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L65
            r0 = r3
        L65:
            java.lang.String r3 = "description_long"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L74
            goto L50
        L74:
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]
            r4 = 0
            r3[r4] = r0
            r4 = 1
            r3[r4] = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ag.BuiltInFictitiousFunctionClassFactory(android.content.Context, com.xiaomi.push.di):java.lang.String[]");
    }

    private static int KClassImpl$Data$declaredNonStaticMembers$2(Map<String, String> map) {
        if (map != null) {
            String str = map.get("notification_priority");
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("priority=");
                sb.append(str);
                com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory(sb.toString());
                return Integer.parseInt(str);
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("parsing notification priority error: ");
                sb2.append(e);
                com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb2.toString());
                return 0;
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.content.Intent KClassImpl$Data$declaredNonStaticMembers$2(android.content.Context r3, java.lang.String r4, java.util.Map<java.lang.String, java.lang.String> r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ag.KClassImpl$Data$declaredNonStaticMembers$2(android.content.Context, java.lang.String, java.util.Map, java.lang.String, java.lang.String, java.lang.String, java.lang.String):android.content.Intent");
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        aq PlaceComponentResult2 = aq.PlaceComponentResult(context, str);
        List<StatusBarNotification> MyBillsEntityDataFactory2 = PlaceComponentResult2.MyBillsEntityDataFactory();
        if (com.xiaomi.channel.commonutils.android.k.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory2)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (StatusBarNotification statusBarNotification : MyBillsEntityDataFactory2) {
            Notification notification = statusBarNotification.getNotification();
            if (notification != null && !TextUtils.isEmpty(String.valueOf(statusBarNotification.getId()))) {
                int id2 = statusBarNotification.getId();
                String BuiltInFictitiousFunctionClassFactory2 = ar.BuiltInFictitiousFunctionClassFactory(notification);
                String PlaceComponentResult3 = ar.PlaceComponentResult(notification);
                if (!TextUtils.isEmpty(BuiltInFictitiousFunctionClassFactory2) && !TextUtils.isEmpty(PlaceComponentResult3) && KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory2, str2) && KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult3, str3)) {
                    linkedList.add(statusBarNotification);
                    PlaceComponentResult2.getAuthRequestContext(id2);
                }
            }
        }
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(di diVar) {
        if (diVar != null) {
            String m277a = diVar.m277a();
            return !TextUtils.isEmpty(m277a) && m277a.length() == 22 && "satuigmo".indexOf(m277a.charAt(0)) >= 0;
        }
        return false;
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(dq dqVar) {
        di m308a = dqVar.m308a();
        return KClassImpl$Data$declaredNonStaticMembers$2(m308a) && m308a.f141b == 0 && !PlaceComponentResult(dqVar);
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        return TextUtils.isEmpty(str) || str2.contains(str);
    }

    private static Bitmap MyBillsEntityDataFactory(Context context, String str, boolean z) {
        Future submit = moveToNextValue.submit(new a(str, context, z));
        try {
            try {
                Bitmap bitmap = (Bitmap) submit.get(180L, TimeUnit.SECONDS);
                return bitmap == null ? bitmap : bitmap;
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
                submit.cancel(true);
                return null;
            }
        } finally {
            submit.cancel(true);
        }
    }

    public static void MyBillsEntityDataFactory(Context context, String str, int i) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i).commit();
    }

    public static void MyBillsEntityDataFactory(Context context, String str, int i, int i2) {
        int hashCode;
        if (context == null || TextUtils.isEmpty(str) || i < -1) {
            return;
        }
        aq PlaceComponentResult2 = aq.PlaceComponentResult(context, str);
        List<StatusBarNotification> MyBillsEntityDataFactory2 = PlaceComponentResult2.MyBillsEntityDataFactory();
        if (com.xiaomi.channel.commonutils.android.k.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory2)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        boolean z = false;
        if (i == -1) {
            hashCode = 0;
            z = true;
        } else {
            hashCode = ((str.hashCode() / 10) * 10) + i;
        }
        for (StatusBarNotification statusBarNotification : MyBillsEntityDataFactory2) {
            if (!TextUtils.isEmpty(String.valueOf(statusBarNotification.getId()))) {
                int id2 = statusBarNotification.getId();
                if (z) {
                    linkedList.add(statusBarNotification);
                    PlaceComponentResult2.getAuthRequestContext(id2);
                } else if (hashCode == id2) {
                    d.BuiltInFictitiousFunctionClassFactory(context, statusBarNotification, i2);
                    linkedList.add(statusBarNotification);
                    PlaceComponentResult2.getAuthRequestContext(id2);
                    return;
                }
            }
        }
    }

    private static boolean MyBillsEntityDataFactory() {
        return com.xiaomi.channel.commonutils.android.a.getAuthRequestContext();
    }

    public static boolean MyBillsEntityDataFactory(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    public static Bitmap PlaceComponentResult(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight > 0 ? intrinsicHeight : 1, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private static RemoteViews PlaceComponentResult(Context context, dq dqVar) {
        di m308a = dqVar.m308a();
        String BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(dqVar);
        if (m308a != null && m308a.m278a() != null) {
            Map<String, String> m278a = m308a.m278a();
            String str = m278a.get("layout_name");
            String str2 = m278a.get("layout_value");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(BuiltInFictitiousFunctionClassFactory2);
                    int identifier = resourcesForApplication.getIdentifier(str, BoxData.ATTR_LAYOUT, BuiltInFictitiousFunctionClassFactory2);
                    if (identifier == 0) {
                        return null;
                    }
                    RemoteViews remoteViews = new RemoteViews(BuiltInFictitiousFunctionClassFactory2, identifier);
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (jSONObject.has("text")) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("text");
                            Iterator<String> keys = jSONObject2.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                String string = jSONObject2.getString(next);
                                int identifier2 = resourcesForApplication.getIdentifier(next, "id", BuiltInFictitiousFunctionClassFactory2);
                                if (identifier2 > 0) {
                                    remoteViews.setTextViewText(identifier2, string);
                                }
                            }
                        }
                        if (jSONObject.has("image")) {
                            JSONObject jSONObject3 = jSONObject.getJSONObject("image");
                            Iterator<String> keys2 = jSONObject3.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                String string2 = jSONObject3.getString(next2);
                                int identifier3 = resourcesForApplication.getIdentifier(next2, "id", BuiltInFictitiousFunctionClassFactory2);
                                int identifier4 = resourcesForApplication.getIdentifier(string2, "drawable", BuiltInFictitiousFunctionClassFactory2);
                                if (identifier3 > 0) {
                                    remoteViews.setImageViewResource(identifier3, identifier4);
                                }
                            }
                        }
                        if (jSONObject.has("time")) {
                            JSONObject jSONObject4 = jSONObject.getJSONObject("time");
                            Iterator<String> keys3 = jSONObject4.keys();
                            while (keys3.hasNext()) {
                                String next3 = keys3.next();
                                String string3 = jSONObject4.getString(next3);
                                if (string3.length() == 0) {
                                    string3 = "yy-MM-dd hh:mm";
                                }
                                int identifier5 = resourcesForApplication.getIdentifier(next3, "id", BuiltInFictitiousFunctionClassFactory2);
                                if (identifier5 > 0) {
                                    remoteViews.setTextViewText(identifier5, new SimpleDateFormat(string3).format(new Date(System.currentTimeMillis())));
                                }
                            }
                        }
                        return remoteViews;
                    } catch (JSONException e) {
                        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
                        return null;
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e2);
                }
            }
        }
        return null;
    }

    public static boolean PlaceComponentResult(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    public static boolean PlaceComponentResult(Context context, String str, boolean z) {
        return com.xiaomi.channel.commonutils.android.f.BuiltInFictitiousFunctionClassFactory() && !z && MyBillsEntityDataFactory();
    }

    public static boolean PlaceComponentResult(dq dqVar) {
        di m308a = dqVar.m308a();
        return KClassImpl$Data$declaredNonStaticMembers$2(m308a) && m308a.l();
    }

    private static boolean PlaceComponentResult(Map<String, String> map) {
        if (map == null) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("meta extra is null");
            return false;
        }
        return "6".equals(map.get("notification_style_type"));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002b -> B:23:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 5
            int r8 = r8 + 18
            int r6 = r6 + 4
            int r7 = r7 * 6
            int r7 = 103 - r7
            byte[] r0 = com.xiaomi.push.service.ag.getAuthRequestContext
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L38
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r6 = r6 + 1
            if (r3 != r8) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L38:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r8 + (-8)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ag.a(short, short, short, java.lang.Object[]):void");
    }

    private static int getAuthRequestContext(Map<String, String> map) {
        if (map != null) {
            String str = map.get("channel_importance");
            if (TextUtils.isEmpty(str)) {
                return 3;
            }
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("importance=");
                sb.append(str);
                com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory(sb.toString());
                return Integer.parseInt(str);
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("parsing channel importance error: ");
                sb2.append(e);
                com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb2.toString());
                return 3;
            }
        }
        return 3;
    }

    private static PendingIntent getAuthRequestContext(Context context, String str, dq dqVar, byte[] bArr, int i, int i2) {
        Map<String, String> m278a = dqVar.m308a().m278a();
        if (m278a == null) {
            return null;
        }
        boolean authRequestContext = getAuthRequestContext(context, dqVar, str);
        if (authRequestContext) {
            return PlaceComponentResult(context, dqVar, str, bArr, i, i2, authRequestContext);
        }
        Intent authRequestContext2 = getAuthRequestContext(context, str, m278a, i2);
        if (authRequestContext2 != null) {
            return PendingIntent.getActivity(context, 0, authRequestContext2, Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728);
        }
        return null;
    }

    private static Intent getAuthRequestContext(Context context, String str, Map<String, String> map, int i) {
        if (PlaceComponentResult(map)) {
            return KClassImpl$Data$declaredNonStaticMembers$2(context, str, map, String.format("cust_btn_%s_ne", Integer.valueOf(i)), String.format("cust_btn_%s_iu", Integer.valueOf(i)), String.format("cust_btn_%s_ic", Integer.valueOf(i)), String.format("cust_btn_%s_wu", Integer.valueOf(i)));
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return KClassImpl$Data$declaredNonStaticMembers$2(context, str, map, "notification_colorful_button_notify_effect", "notification_colorful_button_intent_uri", "notification_colorful_button_intent_class", "notification_colorful_button_web_uri");
                }
                return KClassImpl$Data$declaredNonStaticMembers$2(context, str, map, "notification_style_button_right_notify_effect", "notification_style_button_right_intent_uri", "notification_style_button_right_intent_class", "notification_style_button_right_web_uri");
            }
            return KClassImpl$Data$declaredNonStaticMembers$2(context, str, map, "notification_style_button_mid_notify_effect", "notification_style_button_mid_intent_uri", "notification_style_button_mid_intent_class", "notification_style_button_mid_web_uri");
        }
        return KClassImpl$Data$declaredNonStaticMembers$2(context, str, map, "notification_style_button_left_notify_effect", "notification_style_button_left_intent_uri", "notification_style_button_left_intent_class", "notification_style_button_left_web_uri");
    }

    public static String getAuthRequestContext(Map<String, String> map, int i) {
        String format = i == 0 ? "notify_effect" : PlaceComponentResult(map) ? String.format("cust_btn_%s_ne", Integer.valueOf(i)) : i == 1 ? "notification_style_button_left_notify_effect" : i == 2 ? "notification_style_button_mid_notify_effect" : i == 3 ? "notification_style_button_right_notify_effect" : i == 4 ? "notification_colorful_button_notify_effect" : null;
        if (map == null || format == null) {
            return null;
        }
        return map.get(format);
    }

    public static void getAuthRequestContext(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    public static boolean getAuthRequestContext(dq dqVar) {
        di m308a = dqVar.m308a();
        return KClassImpl$Data$declaredNonStaticMembers$2(m308a) && m308a.f141b == 1 && !PlaceComponentResult(dqVar);
    }

    /* loaded from: classes8.dex */
    public static class a implements Callable<Bitmap> {
        private String MyBillsEntityDataFactory;
        private Context PlaceComponentResult;
        private boolean getAuthRequestContext;

        public a(String str, Context context, boolean z) {
            this.PlaceComponentResult = context;
            this.MyBillsEntityDataFactory = str;
            this.getAuthRequestContext = z;
        }

        @Override // java.util.concurrent.Callable
        public /* synthetic */ Bitmap call() {
            if (TextUtils.isEmpty(this.MyBillsEntityDataFactory)) {
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("Failed get online picture/icon resource cause picUrl is empty");
                return null;
            } else if (this.MyBillsEntityDataFactory.startsWith(SemanticAttributes.FaasTriggerValues.HTTP)) {
                return ap.MyBillsEntityDataFactory(this.PlaceComponentResult, this.MyBillsEntityDataFactory, this.getAuthRequestContext).BuiltInFictitiousFunctionClassFactory;
            } else {
                Bitmap KClassImpl$Data$declaredNonStaticMembers$2 = ap.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, this.MyBillsEntityDataFactory);
                if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("Failed get online picture/icon resource");
                    return KClassImpl$Data$declaredNonStaticMembers$2;
                }
                return KClassImpl$Data$declaredNonStaticMembers$2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.app.PendingIntent PlaceComponentResult(android.content.Context r16, com.xiaomi.push.dq r17, java.lang.String r18, byte[] r19, int r20, int r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ag.PlaceComponentResult(android.content.Context, com.xiaomi.push.dq, java.lang.String, byte[], int, int, boolean):android.app.PendingIntent");
    }

    /* JADX WARN: Code restructure failed: missing block: B:435:0x034f, code lost:
    
        if (r4 <= 0) goto L438;
     */
    /* JADX WARN: Code restructure failed: missing block: B:537:0x05cd, code lost:
    
        if (((android.content.pm.ApplicationInfo) r2.getMethod((java.lang.String) r3[0], null).invoke(r30, null)).targetSdkVersion >= 26) goto L545;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:409:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:440:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:456:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:457:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:461:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:463:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:464:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:467:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:473:0x040f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:476:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:477:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:479:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:482:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:483:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:485:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:488:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:507:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:512:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:525:0x054f  */
    /* JADX WARN: Removed duplicated region for block: B:528:0x0559  */
    /* JADX WARN: Removed duplicated region for block: B:575:0x06ae  */
    /* JADX WARN: Removed duplicated region for block: B:579:0x06c9  */
    /* JADX WARN: Removed duplicated region for block: B:584:0x06e3  */
    /* JADX WARN: Removed duplicated region for block: B:587:0x06ea  */
    /* JADX WARN: Removed duplicated region for block: B:592:0x0712  */
    /* JADX WARN: Removed duplicated region for block: B:598:0x072f  */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.xiaomi.push.service.ag.b BuiltInFictitiousFunctionClassFactory(android.content.Context r30, com.xiaomi.push.dq r31, byte[] r32, android.widget.RemoteViews r33, android.app.PendingIntent r34, int r35) {
        /*
            Method dump skipped, instructions count: 1986
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ag.BuiltInFictitiousFunctionClassFactory(android.content.Context, com.xiaomi.push.dq, byte[], android.widget.RemoteViews, android.app.PendingIntent, int):com.xiaomi.push.service.ag$b");
    }

    /* JADX WARN: Removed duplicated region for block: B:269:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0262 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:439:0x048e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.xiaomi.push.service.ag.c PlaceComponentResult(android.content.Context r19, com.xiaomi.push.dq r20, byte[] r21) {
        /*
            Method dump skipped, instructions count: 1187
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ag.PlaceComponentResult(android.content.Context, com.xiaomi.push.dq, byte[]):com.xiaomi.push.service.ag$c");
    }

    private static void getAuthRequestContext(Context context, Intent intent, dq dqVar, di diVar, String str, int i) {
        ComponentName PlaceComponentResult2;
        if (dqVar == null || diVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        String authRequestContext = getAuthRequestContext(diVar.m278a(), i);
        if (TextUtils.isEmpty(authRequestContext)) {
            return;
        }
        if (bd.NetworkUserEntityData$$ExternalSyntheticLambda2.equals(authRequestContext) || bd.isLayoutRequested.equals(authRequestContext) || bd.newProxyInstance.equals(authRequestContext)) {
            intent.putExtra("messageId", str);
            intent.putExtra("local_paid", dqVar.f225a);
            if (!TextUtils.isEmpty(dqVar.f229b)) {
                intent.putExtra(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, dqVar.f229b);
            }
            Map<String, String> m278a = diVar.m278a();
            intent.putExtra("job_key", m278a != null ? m278a.get("jobkey") : null);
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append("_");
            sb.append("target_component");
            String obj = sb.toString();
            Intent BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(context, dqVar.f229b, diVar.m278a(), i);
            intent.putExtra(obj, (BuiltInFictitiousFunctionClassFactory2 == null || (PlaceComponentResult2 = l.PlaceComponentResult(context, BuiltInFictitiousFunctionClassFactory2)) == null) ? 0 : PlaceComponentResult2.hashCode());
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(Context context, String str) {
        MyBillsEntityDataFactory(context, str, -1, -1);
    }

    private static boolean getAuthRequestContext(Context context, dq dqVar, String str) {
        if (dqVar != null && dqVar.m308a() != null && dqVar.m308a().m278a() != null && !TextUtils.isEmpty(str)) {
            return Boolean.parseBoolean(dqVar.m308a().m278a().get("use_clicked_activity")) && l.BuiltInFictitiousFunctionClassFactory(context, new ComponentName(str, "com.xiaomi.mipush.sdk.NotificationClickedActivity"));
        }
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("should clicked activity params are null.");
        return false;
    }

    private static int MyBillsEntityDataFactory(Context context, String str) {
        int identifier = str.equals(context.getPackageName()) ? context.getResources().getIdentifier("mipush_notification", "drawable", str) : 0;
        int identifier2 = str.equals(context.getPackageName()) ? context.getResources().getIdentifier("mipush_small_notification", "drawable", str) : 0;
        if (identifier <= 0) {
            if (identifier2 > 0) {
                identifier = identifier2;
            } else {
                try {
                    byte b2 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2 - 1);
                    byte b3 = (byte) (-b2);
                    Object[] objArr = new Object[1];
                    a(b2, b3, b3, objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    byte b4 = (byte) (-getAuthRequestContext[4]);
                    byte b5 = (byte) KClassImpl$Data$declaredNonStaticMembers$2;
                    Object[] objArr2 = new Object[1];
                    a(b4, b5, b5, objArr2);
                    identifier = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).icon;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            }
        }
        if (identifier == 0) {
            try {
                byte b6 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2 - 1);
                byte b7 = (byte) (-b6);
                Object[] objArr3 = new Object[1];
                a(b6, b7, b7, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                byte b8 = (byte) (-getAuthRequestContext[4]);
                byte b9 = (byte) KClassImpl$Data$declaredNonStaticMembers$2;
                Object[] objArr4 = new Object[1];
                a(b8, b9, b9, objArr4);
                return ((ApplicationInfo) cls2.getMethod((String) objArr4[0], null).invoke(context, null)).logo;
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th2;
            }
        }
        return identifier;
    }

    /* JADX WARN: Removed duplicated region for block: B:171:0x0142  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.Intent BuiltInFictitiousFunctionClassFactory(android.content.Context r5, java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7, int r8) {
        /*
            Method dump skipped, instructions count: 434
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ag.BuiltInFictitiousFunctionClassFactory(android.content.Context, java.lang.String, java.util.Map, int):android.content.Intent");
    }

    private static void MyBillsEntityDataFactory(Context context, String str, com.xiaomi.push.ay ayVar, Map<String, String> map) {
        boolean z = false;
        if (!com.xiaomi.channel.commonutils.android.f.PlaceComponentResult(context)) {
            String str2 = map != null ? map.get("fcm_icon_uri") : null;
            String str3 = map != null ? map.get("fcm_icon_color") : null;
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                int identifier = str.equals(context.getPackageName()) ? context.getResources().getIdentifier(str2, "drawable", str) : 0;
                if (identifier > 0) {
                    z = true;
                    ayVar.setSmallIcon(identifier);
                    ayVar.MyBillsEntityDataFactory(str3);
                }
            }
        }
        if (z) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            ayVar.setSmallIcon(Icon.createWithResource(str, ar.MyBillsEntityDataFactory(context, str)));
        } else {
            ayVar.setSmallIcon(MyBillsEntityDataFactory(context, str));
        }
    }
}

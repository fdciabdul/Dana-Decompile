package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.xiaomi.channel.commonutils.android.Region;
import com.xiaomi.mipush.sdk.a;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.Cdo;
import com.xiaomi.push.bg;
import com.xiaomi.push.cz;
import com.xiaomi.push.di;
import com.xiaomi.push.dj;
import com.xiaomi.push.dt;
import com.xiaomi.push.du;
import com.xiaomi.push.dy;
import com.xiaomi.push.ea;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.aw;
import com.xiaomi.push.service.bd;
import id.dana.domain.featureconfig.model.UgcConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o.A;

/* loaded from: classes8.dex */
public abstract class MiPushClient {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 269894796;
    private static long KClassImpl$Data$declaredNonStaticMembers$2 = System.currentTimeMillis();
    protected static volatile Region MyBillsEntityDataFactory = null;
    private static Context PlaceComponentResult = null;
    private static int getAuthRequestContext = 0;
    private static int getErrorConfigVersion = 1;

    /* renamed from: com.xiaomi.mipush.sdk.MiPushClient$1 */
    /* loaded from: classes8.dex */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ String BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ ICallbackResult PlaceComponentResult;
        final /* synthetic */ String getAuthRequestContext;

        @Override // java.lang.Runnable
        public final void run() {
            String str;
            if (MiPushClient.MyBillsEntityDataFactory != null) {
                str = MiPushClient.MyBillsEntityDataFactory.name();
                MiPushClient.MyBillsEntityDataFactory = null;
            } else {
                str = "";
            }
            MiPushClient.PlaceComponentResult(MiPushClient.MyBillsEntityDataFactory(), this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, str);
        }
    }

    /* loaded from: classes8.dex */
    public static class CodeResult {
        private long KClassImpl$Data$declaredNonStaticMembers$2 = -1;
    }

    /* loaded from: classes8.dex */
    public interface ICallbackResult<R> {
    }

    @Deprecated
    /* loaded from: classes8.dex */
    public static abstract class MiPushClientCallback {
        String getAuthRequestContext;
    }

    /* loaded from: classes8.dex */
    public static class TokenResult {
        String BuiltInFictitiousFunctionClassFactory = null;
        long PlaceComponentResult = -1;
    }

    /* loaded from: classes8.dex */
    public interface UPSRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    /* loaded from: classes8.dex */
    public interface UPSTurnCallBack extends ICallbackResult<CodeResult> {
    }

    /* loaded from: classes8.dex */
    public interface UPSUnRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    static {
        Object obj = null;
        int i = getErrorConfigVersion + 81;
        getAuthRequestContext = i % 128;
        if ((i % 2 != 0 ? (char) 6 : 'E') != 'E') {
            obj.hashCode();
        }
    }

    private static boolean A(Context context) {
        boolean z;
        if (!(Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1L)) > RangedBeacon.DEFAULT_MAX_TRACKING_AGE)) {
            z = false;
        } else {
            int i = getAuthRequestContext + 43;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
            z = true;
        }
        int i3 = getAuthRequestContext + 65;
        getErrorConfigVersion = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return z;
        }
        Object obj = null;
        obj.hashCode();
        return z;
    }

    private static void BuiltInFictitiousFunctionClassFactory() {
        com.xiaomi.push.o.PlaceComponentResult(PlaceComponentResult).MyBillsEntityDataFactory(new w(PlaceComponentResult), UgcConfig.DEFAULT_UGC_INTERVAL, 5);
        int i = getErrorConfigVersion + 19;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
    }

    public static void BuiltInFictitiousFunctionClassFactory(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            StringBuilder sb = new StringBuilder();
            sb.append("alias_");
            sb.append(str);
            edit.putLong(sb.toString(), System.currentTimeMillis()).commit();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0058, code lost:
    
        if ((com.xiaomi.mipush.sdk.PushMessageHelper.getAuthRequestContext(r13) == 0 ? 14 : 6) != 6) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0060, code lost:
    
        if (1 == com.xiaomi.mipush.sdk.PushMessageHelper.getAuthRequestContext(r13)) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0064, code lost:
    
        r14 = com.xiaomi.push.bg.COMMAND_SET_ALIAS;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x00c3, code lost:
    
        if (java.lang.Math.abs(r9 - r11) < 3600000) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x00d1, code lost:
    
        if ((java.lang.Math.abs(r9 / r11) >= 3600000) != true) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x00d9, code lost:
    
        if (1 == com.xiaomi.mipush.sdk.PushMessageHelper.getAuthRequestContext(r13)) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x00db, code lost:
    
        r15 = '@';
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x00de, code lost:
    
        r15 = 'X';
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x00e0, code lost:
    
        if (r15 == '@') goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x00e2, code lost:
    
        com.xiaomi.mipush.sdk.PushMessageHandler.a(r13, null, r14, 0, null, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x00eb, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x00ec, code lost:
    
        r14 = com.xiaomi.mipush.sdk.MiPushClient.getErrorConfigVersion + 111;
        com.xiaomi.mipush.sdk.MiPushClient.getAuthRequestContext = r14 % 128;
        r14 = r14 % 2;
        r14 = com.xiaomi.push.bg.COMMAND_SET_ACCOUNT;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void BuiltInFictitiousFunctionClassFactory(android.content.Context r13, java.lang.String r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MiPushClient.BuiltInFictitiousFunctionClassFactory(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static boolean DatabaseTableConfigUtil(Context context) {
        boolean PlaceComponentResult2;
        int i = getAuthRequestContext + 99;
        getErrorConfigVersion = i % 128;
        Object[] objArr = null;
        if ((i % 2 == 0 ? 'G' : '+') != 'G') {
            try {
                PlaceComponentResult2 = d.MyBillsEntityDataFactory(context).PlaceComponentResult(c.ASSEMBLE_PUSH_FTOS);
            } catch (Exception e) {
                throw e;
            }
        } else {
            PlaceComponentResult2 = d.MyBillsEntityDataFactory(context).PlaceComponentResult(c.ASSEMBLE_PUSH_FTOS);
            int length = objArr.length;
        }
        int i2 = getAuthRequestContext + 67;
        getErrorConfigVersion = i2 % 128;
        if ((i2 % 2 == 0 ? (char) 16 : 'Z') != 'Z') {
            objArr.hashCode();
            return PlaceComponentResult2;
        }
        return PlaceComponentResult2;
    }

    public static void FragmentBottomSheetPaymentSettingBinding(Context context) {
        int i = getErrorConfigVersion + 49;
        getAuthRequestContext = i % 128;
        if ((i % 2 != 0 ? (char) 28 : '-') != '-') {
            int i2 = 40 / 0;
            if (ag.BuiltInFictitiousFunctionClassFactory(context).KClassImpl$Data$declaredNonStaticMembers$2("syncAssembleFTOSPushToken")) {
                return;
            }
        } else if (ag.BuiltInFictitiousFunctionClassFactory(context).KClassImpl$Data$declaredNonStaticMembers$2("syncAssembleFTOSPushToken")) {
            return;
        }
        ag.BuiltInFictitiousFunctionClassFactory(context).BuiltInFictitiousFunctionClassFactory(null, am.UPLOAD_FTOS_TOKEN, c.ASSEMBLE_PUSH_FTOS);
        try {
            int i3 = getErrorConfigVersion + 87;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static boolean GetContactSyncConfig(Context context) {
        try {
            int i = getAuthRequestContext + 19;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
            MyBillsEntityDataFactory((Object) context, HummerConstants.CONTEXT);
            boolean PlaceComponentResult2 = d.MyBillsEntityDataFactory(context).PlaceComponentResult(c.ASSEMBLE_PUSH_HUAWEI);
            int i3 = getAuthRequestContext + 49;
            getErrorConfigVersion = i3 % 128;
            int i4 = i3 % 2;
            return PlaceComponentResult2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            StringBuilder sb = new StringBuilder();
            sb.append("account_");
            sb.append(str);
            edit.remove(sb.toString()).commit();
        }
    }

    static /* synthetic */ Context MyBillsEntityDataFactory() {
        try {
            int i = getAuthRequestContext + 7;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
            Context context = PlaceComponentResult;
            int i3 = getErrorConfigVersion + 121;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return context;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void MyBillsEntityDataFactory(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            StringBuilder sb = new StringBuilder();
            sb.append("topic_");
            sb.append(str);
            edit.putLong(sb.toString(), System.currentTimeMillis()).commit();
        }
    }

    private static void MyBillsEntityDataFactory(Object obj, String str) {
        int i = getErrorConfigVersion + 111;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        if (obj == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("param ");
            sb.append(str);
            sb.append(" is not nullable");
            throw new IllegalArgumentException(sb.toString());
        }
        try {
            int i3 = getErrorConfigVersion + 115;
            try {
                getAuthRequestContext = i3 % 128;
                if (i3 % 2 == 0) {
                    return;
                }
                int i4 = 23 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0071 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0063 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> NetworkUserEntityData$$ExternalSyntheticLambda0(android.content.Context r7) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.lang.String r2 = "mipush_extra"
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r2, r1)
            java.util.Map r7 = r7.getAll()
            java.util.Set r7 = r7.keySet()
            java.util.Iterator r7 = r7.iterator()
        L18:
            boolean r2 = r7.hasNext()
            r3 = 1
            if (r2 == 0) goto L21
            r2 = 0
            goto L22
        L21:
            r2 = 1
        L22:
            if (r2 == r3) goto L8c
            int r2 = com.xiaomi.mipush.sdk.MiPushClient.getErrorConfigVersion
            int r2 = r2 + 35
            int r4 = r2 % 128
            com.xiaomi.mipush.sdk.MiPushClient.getAuthRequestContext = r4
            int r2 = r2 % 2
            r4 = 0
            java.lang.String r5 = "topic_"
            if (r2 == 0) goto L43
            java.lang.Object r2 = r7.next()
            java.lang.String r2 = (java.lang.String) r2
            boolean r5 = r2.startsWith(r5)
            int r6 = r4.length     // Catch: java.lang.Throwable -> L41
            if (r5 == 0) goto L18
            goto L55
        L41:
            r7 = move-exception
            throw r7
        L43:
            java.lang.Object r2 = r7.next()
            java.lang.String r2 = (java.lang.String) r2
            boolean r5 = r2.startsWith(r5)
            if (r5 == 0) goto L51
            r5 = 0
            goto L52
        L51:
            r5 = 1
        L52:
            if (r5 == 0) goto L55
            goto L18
        L55:
            int r5 = com.xiaomi.mipush.sdk.MiPushClient.getErrorConfigVersion
            int r5 = r5 + 65
            int r6 = r5 % 128
            com.xiaomi.mipush.sdk.MiPushClient.getAuthRequestContext = r6
            int r5 = r5 % 2
            java.lang.String r6 = "**ALL**"
            if (r5 == 0) goto L71
            boolean r5 = r2.contains(r6)
            int r4 = r4.length     // Catch: java.lang.Throwable -> L6f
            if (r5 != 0) goto L6b
            goto L6c
        L6b:
            r3 = 0
        L6c:
            if (r3 == 0) goto L18
            goto L77
        L6f:
            r7 = move-exception
            throw r7
        L71:
            boolean r3 = r2.contains(r6)
            if (r3 != 0) goto L18
        L77:
            r3 = 6
            java.lang.String r2 = r2.substring(r3)
            r0.add(r2)
            int r2 = com.xiaomi.mipush.sdk.MiPushClient.getErrorConfigVersion     // Catch: java.lang.Exception -> L8a
            int r2 = r2 + 23
            int r3 = r2 % 128
            com.xiaomi.mipush.sdk.MiPushClient.getAuthRequestContext = r3     // Catch: java.lang.Exception -> L8a
            int r2 = r2 % 2
            goto L18
        L8a:
            r7 = move-exception
            throw r7
        L8c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MiPushClient.NetworkUserEntityData$$ExternalSyntheticLambda0(android.content.Context):java.util.List");
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda0(Context context, String str) {
        int i = getAuthRequestContext + 63;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        try {
            if (ag.BuiltInFictitiousFunctionClassFactory(context).KClassImpl$Data$declaredNonStaticMembers$2("setUserAccount")) {
                return;
            }
            if ((!TextUtils.isEmpty(str) ? 'V' : (char) 24) == 'V') {
                int i3 = getAuthRequestContext + 123;
                getErrorConfigVersion = i3 % 128;
                if ((i3 % 2 == 0 ? 'P' : '=') != 'P') {
                    BuiltInFictitiousFunctionClassFactory(context, bg.COMMAND_SET_ACCOUNT.f83a, str);
                } else {
                    BuiltInFictitiousFunctionClassFactory(context, bg.COMMAND_SET_ACCOUNT.f83a, str);
                    Object[] objArr = null;
                    int length = objArr.length;
                }
            }
            int i4 = getAuthRequestContext + 107;
            getErrorConfigVersion = i4 % 128;
            int i5 = i4 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static boolean NetworkUserEntityData$$ExternalSyntheticLambda1(Context context) {
        int i = getAuthRequestContext + 3;
        getErrorConfigVersion = i % 128;
        if (i % 2 != 0) {
            try {
                MyBillsEntityDataFactory((Object) context, HummerConstants.CONTEXT);
                return d.MyBillsEntityDataFactory(context).PlaceComponentResult(c.ASSEMBLE_PUSH_COS);
            } catch (Exception e) {
                throw e;
            }
        }
        MyBillsEntityDataFactory((Object) context, HummerConstants.CONTEXT);
        boolean PlaceComponentResult2 = d.MyBillsEntityDataFactory(context).PlaceComponentResult(c.ASSEMBLE_PUSH_COS);
        Object obj = null;
        obj.hashCode();
        return PlaceComponentResult2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x00b0, code lost:
    
        r0.putBoolean("req_hosts", true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x00b6, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0031, code lost:
    
        if (android.text.TextUtils.isEmpty(r1) != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0046, code lost:
    
        if (android.text.TextUtils.isEmpty(r1) != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0048, code lost:
    
        r0.putString("user_region", r9);
        r8 = whenAvailable(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0053, code lost:
    
        if (android.text.TextUtils.isEmpty(r8) != false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0057, code lost:
    
        r1 = com.xiaomi.mipush.sdk.MiPushClient.getErrorConfigVersion + 55;
        com.xiaomi.mipush.sdk.MiPushClient.getAuthRequestContext = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0068, code lost:
    
        if (com.xiaomi.channel.commonutils.android.Region.Europe.name().equals(r8) != false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x006e, code lost:
    
        if (r8.equals(r9) != false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0076, code lost:
    
        if ("Singapore".equals(r8) == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0078, code lost:
    
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x007a, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x007b, code lost:
    
        if (r8 == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0088, code lost:
    
        if (com.xiaomi.channel.commonutils.android.Region.Global.name().equals(r9) != false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x008b, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x008c, code lost:
    
        throw r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x008d, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x008e, code lost:
    
        throw r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0093, code lost:
    
        if (r9.equals(r1) != false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0095, code lost:
    
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0097, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0098, code lost:
    
        if (r8 == true) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x009a, code lost:
    
        r8 = com.xiaomi.mipush.sdk.MiPushClient.getErrorConfigVersion + 71;
        com.xiaomi.mipush.sdk.MiPushClient.getAuthRequestContext = r8 % 128;
        r8 = r8 % 2;
        r0.putString("user_region", r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x00a7, code lost:
    
        if (r8 == 0) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x00a9, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x00aa, code lost:
    
        r8.hashCode();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda1(android.content.Context r8, java.lang.String r9) {
        /*
            int r0 = com.xiaomi.mipush.sdk.MiPushClient.getAuthRequestContext
            int r0 = r0 + 75
            int r1 = r0 % 128
            com.xiaomi.mipush.sdk.MiPushClient.getErrorConfigVersion = r1
            int r0 = r0 % 2
            r1 = 22
            r2 = 55
            if (r0 != 0) goto L13
            r0 = 22
            goto L15
        L13:
            r0 = 55
        L15:
            java.lang.String r3 = ""
            java.lang.String r4 = "mipush_region"
            r5 = 1
            java.lang.String r6 = "user_region"
            r7 = 0
            if (r0 == r1) goto L34
            android.content.Context r0 = com.xiaomi.mipush.sdk.MiPushClient.PlaceComponentResult
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r4, r7)
            java.lang.String r1 = r0.getString(r6, r3)
            android.content.SharedPreferences$Editor r0 = r0.edit()
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 == 0) goto L8f
            goto L48
        L34:
            android.content.Context r0 = com.xiaomi.mipush.sdk.MiPushClient.PlaceComponentResult
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r4, r7)
            java.lang.String r1 = r0.getString(r6, r3)
            android.content.SharedPreferences$Editor r0 = r0.edit()
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 == 0) goto L8f
        L48:
            r0.putString(r6, r9)     // Catch: java.lang.Exception -> L8d
            java.lang.String r8 = whenAvailable(r8)     // Catch: java.lang.Exception -> L8d
            boolean r1 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Exception -> L8d
            if (r1 != 0) goto Lb0
            int r1 = com.xiaomi.mipush.sdk.MiPushClient.getErrorConfigVersion     // Catch: java.lang.Exception -> L8b
            int r1 = r1 + r2
            int r2 = r1 % 128
            com.xiaomi.mipush.sdk.MiPushClient.getAuthRequestContext = r2
            int r1 = r1 % 2
            com.xiaomi.channel.commonutils.android.Region r1 = com.xiaomi.channel.commonutils.android.Region.Europe
            java.lang.String r1 = r1.name()
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto Lb0
            boolean r1 = r8.equals(r9)
            if (r1 != 0) goto Lb6
            java.lang.String r1 = "Singapore"
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L7a
            r8 = 0
            goto L7b
        L7a:
            r8 = 1
        L7b:
            if (r8 == 0) goto L7e
            goto Lb0
        L7e:
            com.xiaomi.channel.commonutils.android.Region r8 = com.xiaomi.channel.commonutils.android.Region.Global
            java.lang.String r8 = r8.name()
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto Lb6
            goto Lb0
        L8b:
            r8 = move-exception
            throw r8
        L8d:
            r8 = move-exception
            throw r8
        L8f:
            boolean r8 = r9.equals(r1)
            if (r8 != 0) goto L97
            r8 = 0
            goto L98
        L97:
            r8 = 1
        L98:
            if (r8 == r5) goto Lb6
            int r8 = com.xiaomi.mipush.sdk.MiPushClient.getErrorConfigVersion
            int r8 = r8 + 71
            int r1 = r8 % 128
            com.xiaomi.mipush.sdk.MiPushClient.getAuthRequestContext = r1
            int r8 = r8 % 2
            r0.putString(r6, r9)
            if (r8 == 0) goto Lb0
            r8 = 0
            r8.hashCode()     // Catch: java.lang.Throwable -> Lae
            goto Lb0
        Lae:
            r8 = move-exception
            throw r8
        Lb0:
            java.lang.String r8 = "req_hosts"
            r0.putBoolean(r8, r5)
            goto Lb7
        Lb6:
            r5 = 0
        Lb7:
            r0.apply()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "current register region: "
            r8.append(r0)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(r8)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MiPushClient.NetworkUserEntityData$$ExternalSyntheticLambda1(android.content.Context, java.lang.String):boolean");
    }

    private static long NetworkUserEntityData$$ExternalSyntheticLambda2(Context context, String str) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            StringBuilder sb = new StringBuilder();
            sb.append("account_");
            sb.append(str);
            long j = sharedPreferences.getLong(sb.toString(), -1L);
            int i = getErrorConfigVersion + 1;
            getAuthRequestContext = i % 128;
            if (!(i % 2 != 0)) {
                return j;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return j;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda2(Context context) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("accept_time");
            com.xiaomi.channel.commonutils.android.h.MyBillsEntityDataFactory(edit);
        }
    }

    private static void NetworkUserEntityData$$ExternalSyntheticLambda3(Context context) {
        int i = getErrorConfigVersion + 97;
        getAuthRequestContext = i % 128;
        if (i % 2 != 0) {
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_pull_notification", System.currentTimeMillis());
        com.xiaomi.channel.commonutils.android.h.MyBillsEntityDataFactory(edit);
        try {
            int i2 = getAuthRequestContext + 125;
            getErrorConfigVersion = i2 % 128;
            if ((i2 % 2 == 0 ? '!' : (char) 16) != '!') {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda4(Context context) {
        try {
            int i = getErrorConfigVersion + 63;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            if (ag.BuiltInFictitiousFunctionClassFactory(context).KClassImpl$Data$declaredNonStaticMembers$2("syncAssembleFCMPushToken")) {
                return;
            }
            try {
                ag.BuiltInFictitiousFunctionClassFactory(context).BuiltInFictitiousFunctionClassFactory(null, am.UPLOAD_FCM_TOKEN, c.ASSEMBLE_PUSH_FCM);
                int i3 = getErrorConfigVersion + 57;
                getAuthRequestContext = i3 % 128;
                if ((i3 % 2 != 0 ? (char) 20 : '1') != 20) {
                    return;
                }
                int i4 = 89 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda5(Context context) {
        int i = getErrorConfigVersion + 115;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        if (ag.BuiltInFictitiousFunctionClassFactory(context).KClassImpl$Data$declaredNonStaticMembers$2("syncAssemblePushToken")) {
            int i3 = getAuthRequestContext + 37;
            getErrorConfigVersion = i3 % 128;
            int i4 = i3 % 2;
            return;
        }
        try {
            ag.BuiltInFictitiousFunctionClassFactory(context).BuiltInFictitiousFunctionClassFactory(null, am.UPLOAD_HUAWEI_TOKEN, c.ASSEMBLE_PUSH_HUAWEI);
        } catch (Exception e) {
            throw e;
        }
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda7(Context context) {
        synchronized (MiPushClient.class) {
            Iterator<String> it = moveToNextValue(context).iterator();
            while (it.hasNext()) {
                lookAheadTest(context, it.next());
            }
        }
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda8(Context context) {
        synchronized (MiPushClient.class) {
            Iterator<String> it = lookAheadTest(context).iterator();
            while (it.hasNext()) {
                KClassImpl$Data$declaredNonStaticMembers$2(context, it.next());
            }
        }
    }

    public static long PlaceComponentResult(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        StringBuilder sb = new StringBuilder();
        sb.append("alias_");
        sb.append(str);
        long j = sharedPreferences.getLong(sb.toString(), -1L);
        int i = getAuthRequestContext + 15;
        getErrorConfigVersion = i % 128;
        if (i % 2 == 0) {
            Object obj = null;
            obj.hashCode();
            return j;
        }
        return j;
    }

    static /* synthetic */ void PlaceComponentResult(Context context, String str, String str2, String str3, ICallbackResult iCallbackResult, String str4) {
        int i = getErrorConfigVersion + 69;
        getAuthRequestContext = i % 128;
        boolean z = i % 2 == 0;
        getAuthRequestContext(context, str, str2, str3, iCallbackResult, str4);
        if (z) {
            return;
        }
        int i2 = 21 / 0;
    }

    public static void PrepareContext(Context context) {
        int i = getAuthRequestContext + 17;
        getErrorConfigVersion = i % 128;
        Object obj = null;
        if ((i % 2 == 0 ? '[' : 'a') != 'a') {
            try {
                boolean KClassImpl$Data$declaredNonStaticMembers$22 = ag.BuiltInFictitiousFunctionClassFactory(context).KClassImpl$Data$declaredNonStaticMembers$2("syncAssembleCOSPushToken");
                obj.hashCode();
                if (KClassImpl$Data$declaredNonStaticMembers$22) {
                    return;
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            try {
                if (ag.BuiltInFictitiousFunctionClassFactory(context).KClassImpl$Data$declaredNonStaticMembers$2("syncAssembleCOSPushToken")) {
                    return;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        ag.BuiltInFictitiousFunctionClassFactory(context).BuiltInFictitiousFunctionClassFactory(null, am.UPLOAD_COS_TOKEN, c.ASSEMBLE_PUSH_COS);
        int i2 = getAuthRequestContext + 115;
        getErrorConfigVersion = i2 % 128;
        if (i2 % 2 == 0) {
            int i3 = 80 / 0;
        }
    }

    private static void SubSequence(Context context) {
        int i = getAuthRequestContext + 97;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_reg_request", System.currentTimeMillis());
        com.xiaomi.channel.commonutils.android.h.MyBillsEntityDataFactory(edit);
        try {
            int i3 = getErrorConfigVersion + 9;
            getAuthRequestContext = i3 % 128;
            if ((i3 % 2 != 0 ? 'A' : (char) 1) != 'A') {
                return;
            }
            int i4 = 64 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void getAuthRequestContext(Context context) {
        try {
            int i = getErrorConfigVersion + 123;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.clear();
            edit.commit();
            int i3 = getAuthRequestContext + 25;
            getErrorConfigVersion = i3 % 128;
            if ((i3 % 2 == 0 ? ';' : '4') != '4') {
                int i4 = 40 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void getAuthRequestContext(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            StringBuilder sb = new StringBuilder();
            sb.append("account_");
            sb.append(str);
            edit.putLong(sb.toString(), System.currentTimeMillis()).commit();
        }
    }

    public static void getAuthRequestContext(Context context, String str, String str2) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(",");
            sb.append(str2);
            edit.putString("accept_time", sb.toString());
            com.xiaomi.channel.commonutils.android.h.MyBillsEntityDataFactory(edit);
        }
    }

    private static void getCallingPid(Context context) {
        if (("syncing".equals(x.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult).MyBillsEntityDataFactory(am.DISABLE_PUSH)) ? (char) 3 : 'R') != 'R') {
            PlaceComponentResult(PlaceComponentResult);
        }
        if ("syncing".equals(x.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult).MyBillsEntityDataFactory(am.ENABLE_PUSH))) {
            KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult);
        }
        if (("syncing".equals(x.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult).MyBillsEntityDataFactory(am.UPLOAD_HUAWEI_TOKEN)) ? ':' : '\'') == ':') {
            NetworkUserEntityData$$ExternalSyntheticLambda5(PlaceComponentResult);
        }
        if ("syncing".equals(x.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult).MyBillsEntityDataFactory(am.UPLOAD_FCM_TOKEN))) {
            int i = getErrorConfigVersion + 37;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            NetworkUserEntityData$$ExternalSyntheticLambda4(PlaceComponentResult);
        }
        try {
            if ("syncing".equals(x.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult).MyBillsEntityDataFactory(am.UPLOAD_COS_TOKEN))) {
                PrepareContext(context);
                int i3 = getErrorConfigVersion + 79;
                getAuthRequestContext = i3 % 128;
                int i4 = i3 % 2;
            }
            if ("syncing".equals(x.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult).MyBillsEntityDataFactory(am.UPLOAD_FTOS_TOKEN)) ? false : true) {
                return;
            }
            int i5 = getErrorConfigVersion + 11;
            getAuthRequestContext = i5 % 128;
            int i6 = i5 % 2;
            FragmentBottomSheetPaymentSettingBinding(context);
            int i7 = getAuthRequestContext + 85;
            getErrorConfigVersion = i7 % 128;
            int i8 = i7 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void getErrorConfigVersion(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            StringBuilder sb = new StringBuilder();
            sb.append("topic_");
            sb.append(str);
            edit.remove(sb.toString()).commit();
        }
    }

    public static boolean getErrorConfigVersion(Context context) {
        int i = getErrorConfigVersion + 17;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            MyBillsEntityDataFactory((Object) context, HummerConstants.CONTEXT);
            boolean PlaceComponentResult2 = d.MyBillsEntityDataFactory(context).PlaceComponentResult(c.ASSEMBLE_PUSH_FCM);
            try {
                int i3 = getAuthRequestContext + 91;
                getErrorConfigVersion = i3 % 128;
                int i4 = i3 % 2;
                return PlaceComponentResult2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void getSupportButtonTintMode(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        for (String str : moveToNextValue(context)) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("alias_");
                sb.append(str);
                edit.remove(sb.toString());
            } catch (Exception e) {
                throw e;
            }
        }
        for (String str2 : lookAheadTest(context)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("account_");
            sb2.append(str2);
            edit.remove(sb2.toString());
            int i = getErrorConfigVersion + 85;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
        }
        try {
            for (String str3 : NetworkUserEntityData$$ExternalSyntheticLambda0(context)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("topic_");
                sb3.append(str3);
                edit.remove(sb3.toString());
            }
            edit.remove("accept_time");
            edit.commit();
            int i3 = getAuthRequestContext + 11;
            getErrorConfigVersion = i3 % 128;
            if (!(i3 % 2 == 0)) {
                return;
            }
            int i4 = 38 / 0;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static long initRecordTimeStamp(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        StringBuilder sb = new StringBuilder();
        sb.append("topic_");
        sb.append(str);
        long j = sharedPreferences.getLong(sb.toString(), -1L);
        int i = getErrorConfigVersion + 99;
        getAuthRequestContext = i % 128;
        if ((i % 2 != 0 ? (char) 25 : '4') != '4') {
            int i2 = 50 / 0;
            return j;
        }
        return j;
    }

    public static boolean isLayoutRequested(Context context) {
        int i = getAuthRequestContext + 59;
        getErrorConfigVersion = i % 128;
        boolean z = i % 2 != 0;
        boolean authRequestContext = ag.BuiltInFictitiousFunctionClassFactory(context).getAuthRequestContext();
        if (!z) {
            int i2 = 74 / 0;
        }
        return authRequestContext;
    }

    public static List<String> lookAheadTest(Context context) {
        String next;
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = context.getSharedPreferences("mipush_extra", 0).getAll().keySet().iterator();
        try {
            int i = getErrorConfigVersion + 25;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            while (it.hasNext()) {
                try {
                    int i3 = getAuthRequestContext + 61;
                    getErrorConfigVersion = i3 % 128;
                    if (!(i3 % 2 != 0)) {
                        next = it.next();
                        boolean startsWith = next.startsWith("account_");
                        Object[] objArr = null;
                        int length = objArr.length;
                        if (!(startsWith ? false : true)) {
                            arrayList.add(next.substring(8));
                        }
                    } else {
                        next = it.next();
                        if (next.startsWith("account_")) {
                            arrayList.add(next.substring(8));
                        }
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
            return arrayList;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static void lookAheadTest(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            StringBuilder sb = new StringBuilder();
            sb.append("alias_");
            sb.append(str);
            edit.remove(sb.toString()).commit();
        }
    }

    public static List<String> moveToNextValue(Context context) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = context.getSharedPreferences("mipush_extra", 0).getAll().keySet().iterator();
        while (true) {
            if (!(it.hasNext())) {
                int i = getErrorConfigVersion + 59;
                getAuthRequestContext = i % 128;
                int i2 = i % 2;
                return arrayList;
            }
            String next = it.next();
            if (!(next.startsWith("alias_") ? false : true)) {
                try {
                    int i3 = getErrorConfigVersion + 59;
                    getAuthRequestContext = i3 % 128;
                    arrayList.add(next.substring(i3 % 2 != 0 ? 55 : 6));
                } catch (Exception e) {
                    throw e;
                }
            }
        }
    }

    public static void newProxyInstance(Context context) {
        synchronized (MiPushClient.class) {
            Iterator<String> it = NetworkUserEntityData$$ExternalSyntheticLambda0(context).iterator();
            while (it.hasNext()) {
                getErrorConfigVersion(context, it.next());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x002f, code lost:
    
        if (java.lang.Math.abs(java.lang.System.currentTimeMillis() - r10.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1)) > 300000) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0032, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0047, code lost:
    
        if (java.lang.Math.abs(r10.getSharedPreferences("mipush_extra", 1).getLong("last_pull_notification", -1) ^ java.lang.System.currentTimeMillis()) > 300000) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0049, code lost:
    
        r10 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean readMicros(android.content.Context r10) {
        /*
            int r0 = com.xiaomi.mipush.sdk.MiPushClient.getErrorConfigVersion
            int r0 = r0 + 67
            int r1 = r0 % 128
            com.xiaomi.mipush.sdk.MiPushClient.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            r3 = 300000(0x493e0, double:1.482197E-318)
            r5 = -1
            java.lang.String r7 = "last_pull_notification"
            java.lang.String r8 = "mipush_extra"
            if (r0 == 0) goto L34
            android.content.SharedPreferences r10 = r10.getSharedPreferences(r8, r1)
            long r8 = java.lang.System.currentTimeMillis()
            long r5 = r10.getLong(r7, r5)
            long r8 = r8 - r5
            long r5 = java.lang.Math.abs(r8)
            int r10 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r10 <= 0) goto L32
            goto L49
        L32:
            r10 = 0
            goto L4a
        L34:
            android.content.SharedPreferences r10 = r10.getSharedPreferences(r8, r2)     // Catch: java.lang.Exception -> L62
            long r8 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L60
            long r5 = r10.getLong(r7, r5)     // Catch: java.lang.Exception -> L60
            long r5 = r5 ^ r8
            long r5 = java.lang.Math.abs(r5)     // Catch: java.lang.Exception -> L60
            int r10 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r10 <= 0) goto L32
        L49:
            r10 = 1
        L4a:
            int r0 = com.xiaomi.mipush.sdk.MiPushClient.getErrorConfigVersion     // Catch: java.lang.Exception -> L60
            int r0 = r0 + 67
            int r3 = r0 % 128
            com.xiaomi.mipush.sdk.MiPushClient.getAuthRequestContext = r3     // Catch: java.lang.Exception -> L60
            int r0 = r0 % 2
            if (r0 == 0) goto L57
            goto L58
        L57:
            r1 = 1
        L58:
            if (r1 == r2) goto L5f
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L5d
            return r10
        L5d:
            r10 = move-exception
            throw r10
        L5f:
            return r10
        L60:
            r10 = move-exception
            throw r10
        L62:
            r10 = move-exception
            goto L65
        L64:
            throw r10
        L65:
            goto L64
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MiPushClient.readMicros(android.content.Context):boolean");
    }

    public static String scheduleImpl(Context context) {
        int i = getAuthRequestContext + 81;
        getErrorConfigVersion = i % 128;
        return context.getSharedPreferences("mipush_extra", (i % 2 == 0 ? 'Q' : '1') != 'Q' ? 0 : 1).getString("accept_time", "00:00-23:59");
    }

    public static void scheduleImpl(Context context, String str) {
        if (ag.BuiltInFictitiousFunctionClassFactory(context).KClassImpl$Data$declaredNonStaticMembers$2("setAlias")) {
            return;
        }
        if (!(!TextUtils.isEmpty(str))) {
            return;
        }
        int i = getErrorConfigVersion + 83;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            BuiltInFictitiousFunctionClassFactory(context, bg.COMMAND_SET_ALIAS.f83a, str);
            int i3 = getAuthRequestContext + 3;
            getErrorConfigVersion = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void MyBillsEntityDataFactory(Context context) {
        Intent KClassImpl$Data$declaredNonStaticMembers$22;
        int i = getErrorConfigVersion + 25;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            if (ag.BuiltInFictitiousFunctionClassFactory(context).KClassImpl$Data$declaredNonStaticMembers$2("clearLocalNotificationType")) {
                try {
                    int i3 = getAuthRequestContext + 101;
                    getErrorConfigVersion = i3 % 128;
                    if (i3 % 2 == 0) {
                        int i4 = 92 / 0;
                        return;
                    }
                    return;
                } catch (Exception e) {
                    throw e;
                }
            }
            ag BuiltInFictitiousFunctionClassFactory2 = ag.BuiltInFictitiousFunctionClassFactory(context);
            if (BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext()) {
                if ("com.xiaomi.xmsf".equals(BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName()) ? false : true) {
                    KClassImpl$Data$declaredNonStaticMembers$22 = BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory();
                    KClassImpl$Data$declaredNonStaticMembers$22.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
                    KClassImpl$Data$declaredNonStaticMembers$22.putExtra(bd.PlaceComponentResult, BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName());
                    KClassImpl$Data$declaredNonStaticMembers$22.putExtra(bd.lookAheadTest, com.xiaomi.push.ac.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName()));
                    BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22);
                }
            }
            KClassImpl$Data$declaredNonStaticMembers$22 = BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$22.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
            KClassImpl$Data$declaredNonStaticMembers$22.putExtra(bd.PlaceComponentResult, BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName());
            KClassImpl$Data$declaredNonStaticMembers$22.putExtra(bd.lookAheadTest, com.xiaomi.push.ac.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName()));
            BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22);
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0020, code lost:
    
        if (com.xiaomi.mipush.sdk.ag.BuiltInFictitiousFunctionClassFactory(r4).KClassImpl$Data$declaredNonStaticMembers$2("clearNotification") != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x002d, code lost:
    
        if (com.xiaomi.mipush.sdk.ag.BuiltInFictitiousFunctionClassFactory(r4).KClassImpl$Data$declaredNonStaticMembers$2("clearNotification") != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x002f, code lost:
    
        r4 = com.xiaomi.mipush.sdk.MiPushClient.getErrorConfigVersion + 11;
        com.xiaomi.mipush.sdk.MiPushClient.getAuthRequestContext = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0039, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x003a, code lost:
    
        com.xiaomi.mipush.sdk.ag.BuiltInFictitiousFunctionClassFactory(r4).KClassImpl$Data$declaredNonStaticMembers$2(-1, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0042, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void BuiltInFictitiousFunctionClassFactory(android.content.Context r4) {
        /*
            int r0 = com.xiaomi.mipush.sdk.MiPushClient.getErrorConfigVersion
            int r0 = r0 + 5
            int r1 = r0 % 128
            com.xiaomi.mipush.sdk.MiPushClient.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            java.lang.String r3 = "clearNotification"
            if (r0 == r1) goto L25
            com.xiaomi.mipush.sdk.ag r0 = com.xiaomi.mipush.sdk.ag.BuiltInFictitiousFunctionClassFactory(r4)
            boolean r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2(r3)
            r1 = 53
            int r1 = r1 / r2
            if (r0 == 0) goto L3a
            goto L2f
        L23:
            r4 = move-exception
            throw r4
        L25:
            com.xiaomi.mipush.sdk.ag r0 = com.xiaomi.mipush.sdk.ag.BuiltInFictitiousFunctionClassFactory(r4)
            boolean r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2(r3)
            if (r0 == 0) goto L3a
        L2f:
            int r4 = com.xiaomi.mipush.sdk.MiPushClient.getErrorConfigVersion
            int r4 = r4 + 11
            int r0 = r4 % 128
            com.xiaomi.mipush.sdk.MiPushClient.getAuthRequestContext = r0
            int r4 = r4 % 2
            return
        L3a:
            com.xiaomi.mipush.sdk.ag r4 = com.xiaomi.mipush.sdk.ag.BuiltInFictitiousFunctionClassFactory(r4)
            r0 = -1
            r4.KClassImpl$Data$declaredNonStaticMembers$2(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MiPushClient.BuiltInFictitiousFunctionClassFactory(android.content.Context):void");
    }

    public static void BuiltInFictitiousFunctionClassFactory(Context context, int i) {
        int i2 = getErrorConfigVersion + 41;
        getAuthRequestContext = i2 % 128;
        if ((i2 % 2 == 0 ? '4' : ')') != '4') {
            try {
                try {
                    boolean KClassImpl$Data$declaredNonStaticMembers$22 = ag.BuiltInFictitiousFunctionClassFactory(context).KClassImpl$Data$declaredNonStaticMembers$2("clearNotification");
                    Object obj = null;
                    obj.hashCode();
                    if (KClassImpl$Data$declaredNonStaticMembers$22) {
                        return;
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else if (ag.BuiltInFictitiousFunctionClassFactory(context).KClassImpl$Data$declaredNonStaticMembers$2("clearNotification")) {
            return;
        }
        ag.BuiltInFictitiousFunctionClassFactory(context).KClassImpl$Data$declaredNonStaticMembers$2(i, 0);
        int i3 = getErrorConfigVersion + 111;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
    }

    public static void PlaceComponentResult(Context context, String str, String str2) {
        Intent KClassImpl$Data$declaredNonStaticMembers$22;
        int i = getErrorConfigVersion + 7;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            if (ag.BuiltInFictitiousFunctionClassFactory(context).KClassImpl$Data$declaredNonStaticMembers$2("clearNotification")) {
                int i3 = getErrorConfigVersion + 125;
                getAuthRequestContext = i3 % 128;
                if (i3 % 2 != 0) {
                    int i4 = 50 / 0;
                    return;
                }
                return;
            }
            ag BuiltInFictitiousFunctionClassFactory2 = ag.BuiltInFictitiousFunctionClassFactory(context);
            if (BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext()) {
                if (!("com.xiaomi.xmsf".equals(BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName()))) {
                    int i5 = getErrorConfigVersion + 37;
                    getAuthRequestContext = i5 % 128;
                    int i6 = i5 % 2;
                    try {
                        KClassImpl$Data$declaredNonStaticMembers$22 = BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory();
                        KClassImpl$Data$declaredNonStaticMembers$22.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
                        KClassImpl$Data$declaredNonStaticMembers$22.putExtra(bd.PlaceComponentResult, BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName());
                        KClassImpl$Data$declaredNonStaticMembers$22.putExtra(bd.getErrorConfigVersion, str);
                        KClassImpl$Data$declaredNonStaticMembers$22.putExtra(bd.moveToNextValue, str2);
                        BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22);
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
            KClassImpl$Data$declaredNonStaticMembers$22 = BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$22.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
            KClassImpl$Data$declaredNonStaticMembers$22.putExtra(bd.PlaceComponentResult, BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName());
            KClassImpl$Data$declaredNonStaticMembers$22.putExtra(bd.getErrorConfigVersion, str);
            KClassImpl$Data$declaredNonStaticMembers$22.putExtra(bd.moveToNextValue, str2);
            BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22);
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static void PlaceComponentResult(Context context) {
        int i = getAuthRequestContext + 47;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        if (ag.BuiltInFictitiousFunctionClassFactory(context).KClassImpl$Data$declaredNonStaticMembers$2("disablePush")) {
            return;
        }
        try {
            ag.BuiltInFictitiousFunctionClassFactory(context).getAuthRequestContext(true, (String) null);
            int i3 = getAuthRequestContext + 83;
            getErrorConfigVersion = i3 % 128;
            if (i3 % 2 == 0) {
                int i4 = 60 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        try {
            int i = getErrorConfigVersion + 19;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            if (ag.BuiltInFictitiousFunctionClassFactory(context).KClassImpl$Data$declaredNonStaticMembers$2("enablePush")) {
                return;
            }
            Object obj = null;
            ag.BuiltInFictitiousFunctionClassFactory(context).getAuthRequestContext(false, (String) null);
            int i3 = getErrorConfigVersion + 45;
            getAuthRequestContext = i3 % 128;
            if ((i3 % 2 != 0 ? 'B' : 'L') != 'B') {
                return;
            }
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    private static String whenAvailable(Context context) {
        if ((a.PlaceComponentResult(context).KClassImpl$Data$declaredNonStaticMembers$2() ? '_' : (char) 4) != 4) {
            try {
                int i = getAuthRequestContext + 61;
                getErrorConfigVersion = i % 128;
                int i2 = i % 2;
                String str = a.PlaceComponentResult(context).BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp;
                int i3 = getAuthRequestContext + 81;
                getErrorConfigVersion = i3 % 128;
                int i4 = i3 % 2;
                return str;
            } catch (Exception e) {
                throw e;
            }
        }
        return null;
    }

    public static String initRecordTimeStamp(Context context) {
        int i = getErrorConfigVersion + 95;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        Object[] objArr = null;
        if (!(!a.PlaceComponentResult(context).KClassImpl$Data$declaredNonStaticMembers$2())) {
            int i3 = getErrorConfigVersion + 83;
            getAuthRequestContext = i3 % 128;
            if (!(i3 % 2 == 0)) {
                try {
                    String str = a.PlaceComponentResult(context).BuiltInFictitiousFunctionClassFactory.lookAheadTest;
                    int length = objArr.length;
                    return str;
                } catch (Exception e) {
                    throw e;
                }
            }
            return a.PlaceComponentResult(context).BuiltInFictitiousFunctionClassFactory.lookAheadTest;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:188:0x00bf, code lost:
    
        if (r0.getAuthRequestContext() != false) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x012c, code lost:
    
        if ((1 == com.xiaomi.mipush.sdk.PushMessageHelper.getAuthRequestContext(com.xiaomi.mipush.sdk.MiPushClient.PlaceComponentResult)) != true) goto L215;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x03db, code lost:
    
        if (r0 != null) goto L257;
     */
    /* JADX WARN: Removed duplicated region for block: B:250:0x03c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void getAuthRequestContext(android.content.Context r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, com.xiaomi.mipush.sdk.MiPushClient.ICallbackResult r33, java.lang.String r34) {
        /*
            Method dump skipped, instructions count: 1019
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MiPushClient.getAuthRequestContext(android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.xiaomi.mipush.sdk.MiPushClient$ICallbackResult, java.lang.String):void");
    }

    public static void PlaceComponentResult(Context context, dj djVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("re-register reason: ");
        sb.append(djVar);
        com.xiaomi.channel.commonutils.logger.b.moveToNextValue(sb.toString());
        String KClassImpl$Data$declaredNonStaticMembers$22 = com.xiaomi.push.ad.KClassImpl$Data$declaredNonStaticMembers$2(6);
        String str = a.PlaceComponentResult(context).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
        String str2 = a.PlaceComponentResult(context).BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
        a.PlaceComponentResult(context).BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        getSupportButtonTintMode(context);
        BuiltInFictitiousFunctionClassFactory(context);
        a.PlaceComponentResult(context).getAuthRequestContext(Constants.MyBillsEntityDataFactory());
        a.PlaceComponentResult(context).BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(str, str2, KClassImpl$Data$declaredNonStaticMembers$22);
        du duVar = new du();
        duVar.a(aw.getAuthRequestContext());
        duVar.b(str);
        duVar.e(str2);
        duVar.f(KClassImpl$Data$declaredNonStaticMembers$22);
        duVar.d(context.getPackageName());
        duVar.c(com.xiaomi.channel.commonutils.android.a.BuiltInFictitiousFunctionClassFactory(context, context.getPackageName()));
        duVar.b(com.xiaomi.channel.commonutils.android.a.KClassImpl$Data$declaredNonStaticMembers$2(context, context.getPackageName()));
        duVar.h(BuildConfig.VERSION_NAME);
        duVar.a(BuildConfig.VERSION_CODE);
        duVar.a(djVar);
        int KClassImpl$Data$declaredNonStaticMembers$23 = com.xiaomi.channel.commonutils.android.c.KClassImpl$Data$declaredNonStaticMembers$2();
        if ((KClassImpl$Data$declaredNonStaticMembers$23 >= 0 ? (char) 1 : (char) 18) != 18) {
            int i = getErrorConfigVersion + 81;
            getAuthRequestContext = i % 128;
            boolean z = i % 2 != 0;
            duVar.c(KClassImpl$Data$declaredNonStaticMembers$23);
            if (z) {
                int i2 = 6 / 0;
            }
            int i3 = getErrorConfigVersion + 13;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
        }
        ag.BuiltInFictitiousFunctionClassFactory(context).MyBillsEntityDataFactory(duVar, false, false);
        int i5 = getAuthRequestContext + 33;
        getErrorConfigVersion = i5 % 128;
        int i6 = i5 % 2;
    }

    public static void getAuthRequestContext(Context context, String str, di diVar, String str2, String str3) {
        dt dtVar = new dt();
        if (!(TextUtils.isEmpty(str3))) {
            dtVar.b(str3);
            dtVar.c("bar:click");
            dtVar.a(str);
            dtVar.a(false);
            ag.BuiltInFictitiousFunctionClassFactory(context).BuiltInFictitiousFunctionClassFactory(dtVar, cz.Notification, false, true, diVar, true, str2, str3, true);
            return;
        }
        int i = getErrorConfigVersion + 93;
        getAuthRequestContext = i % 128;
        char c = i % 2 != 0 ? JSONLexer.EOI : (char) 19;
        com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2("do not report clicked message");
        if (c == 26) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        try {
            int i2 = getAuthRequestContext + 99;
            try {
                getErrorConfigVersion = i2 % 128;
                int i3 = i2 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(Context context, String str, di diVar, String str2) {
        dt dtVar = new dt();
        if (!(!TextUtils.isEmpty(str2))) {
            if (!a.PlaceComponentResult(context).BuiltInFictitiousFunctionClassFactory()) {
                com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2("do not report clicked message");
                try {
                    int i = getErrorConfigVersion + 101;
                    getAuthRequestContext = i % 128;
                    if (i % 2 != 0) {
                        int i2 = 12 / 0;
                        return;
                    }
                    return;
                } catch (Exception e) {
                    throw e;
                }
            }
            str2 = a.PlaceComponentResult(context).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
            int i3 = getAuthRequestContext + 9;
            getErrorConfigVersion = i3 % 128;
            int i4 = i3 % 2;
        }
        dtVar.b(str2);
        dtVar.c("bar:click");
        dtVar.a(str);
        dtVar.a(false);
        ag BuiltInFictitiousFunctionClassFactory2 = ag.BuiltInFictitiousFunctionClassFactory(context);
        BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory(dtVar, cz.Notification, false, true, diVar, true, BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName(), a.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, true);
        int i5 = getErrorConfigVersion + 21;
        getAuthRequestContext = i5 % 128;
        int i6 = i5 % 2;
    }

    private static void PlaceComponentResult(Context context, String str, ArrayList<String> arrayList, String str2) {
        try {
            int i = getErrorConfigVersion + 33;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            try {
                Object obj = null;
                if (TextUtils.isEmpty(a.PlaceComponentResult(context).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory)) {
                    int i3 = getErrorConfigVersion + 13;
                    getAuthRequestContext = i3 % 128;
                    if ((i3 % 2 == 0 ? (char) 14 : (char) 2) != 14) {
                        obj.hashCode();
                        return;
                    }
                    return;
                }
                Cdo cdo = new Cdo();
                String MyBillsEntityDataFactory2 = aw.MyBillsEntityDataFactory();
                cdo.a(MyBillsEntityDataFactory2);
                cdo.b(a.PlaceComponentResult(context).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
                cdo.c(str);
                Iterator<String> it = arrayList.iterator();
                while (true) {
                    if (!(it.hasNext())) {
                        cdo.e(null);
                        cdo.d(context.getPackageName());
                        StringBuilder sb = new StringBuilder();
                        sb.append("cmd:");
                        sb.append(str);
                        sb.append(", ");
                        sb.append(MyBillsEntityDataFactory2);
                        com.xiaomi.channel.commonutils.logger.b.moveToNextValue(sb.toString());
                        ag BuiltInFictitiousFunctionClassFactory2 = ag.BuiltInFictitiousFunctionClassFactory(context);
                        cz czVar = cz.Command;
                        BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory(cdo, czVar, true ^ czVar.equals(cz.Registration), true, null, true, BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName(), a.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, true);
                        int i4 = getErrorConfigVersion + 61;
                        getAuthRequestContext = i4 % 128;
                        int i5 = i4 % 2;
                        return;
                    }
                    cdo.m299a(it.next());
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static void moveToNextValue(Context context, String str) {
        try {
            int i = getAuthRequestContext + 41;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
            if (ag.BuiltInFictitiousFunctionClassFactory(context).KClassImpl$Data$declaredNonStaticMembers$2("subscribe")) {
                return;
            }
            if (!TextUtils.isEmpty(a.PlaceComponentResult(context).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory)) {
                if (!(TextUtils.isEmpty(str))) {
                    if (Math.abs(System.currentTimeMillis() - initRecordTimeStamp(context, str)) > 86400000) {
                        dy dyVar = new dy();
                        String MyBillsEntityDataFactory2 = aw.MyBillsEntityDataFactory();
                        dyVar.a(MyBillsEntityDataFactory2);
                        dyVar.b(a.PlaceComponentResult(context).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
                        dyVar.c(str);
                        dyVar.d(context.getPackageName());
                        dyVar.e(null);
                        StringBuilder sb = new StringBuilder();
                        sb.append("cmd:");
                        sb.append(bg.COMMAND_SUBSCRIBE_TOPIC);
                        sb.append(", ");
                        sb.append(MyBillsEntityDataFactory2);
                        com.xiaomi.channel.commonutils.logger.b.moveToNextValue(sb.toString());
                        ag BuiltInFictitiousFunctionClassFactory2 = ag.BuiltInFictitiousFunctionClassFactory(context);
                        BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory(dyVar, cz.Subscription, !r5.equals(cz.Registration), true, null, true, BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName(), a.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, true);
                        return;
                    } else if (1 == PushMessageHelper.getAuthRequestContext(context)) {
                        int i3 = getErrorConfigVersion + 21;
                        getAuthRequestContext = i3 % 128;
                        if (i3 % 2 != 0) {
                            PushMessageHandler.a(context, null, 1L, null, str);
                            return;
                        } else {
                            PushMessageHandler.a(context, null, 0L, null, str);
                            return;
                        }
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str);
                        PushMessageHelper.KClassImpl$Data$declaredNonStaticMembers$2(context, PushMessageHelper.BuiltInFictitiousFunctionClassFactory(bg.COMMAND_SUBSCRIBE_TOPIC.f83a, arrayList, 0L, null, null));
                    }
                }
            }
            int i4 = getAuthRequestContext + 23;
            getErrorConfigVersion = i4 % 128;
            if ((i4 % 2 == 0 ? 'S' : 'J') != 'S') {
                return;
            }
            int i5 = 53 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void NetworkUserEntityData$$ExternalSyntheticLambda6(Context context) {
        if (ag.BuiltInFictitiousFunctionClassFactory(context).KClassImpl$Data$declaredNonStaticMembers$2("unregisterPush")) {
            return;
        }
        g.getAuthRequestContext(context);
        at MyBillsEntityDataFactory2 = at.MyBillsEntityDataFactory(context);
        synchronized (MyBillsEntityDataFactory2) {
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.clear();
        }
        if (a.PlaceComponentResult(context).BuiltInFictitiousFunctionClassFactory()) {
            ea eaVar = new ea();
            eaVar.a(aw.MyBillsEntityDataFactory());
            eaVar.b(a.PlaceComponentResult(context).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
            eaVar.c(a.PlaceComponentResult(context).BuiltInFictitiousFunctionClassFactory.lookAheadTest);
            eaVar.e(a.PlaceComponentResult(context).BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory);
            eaVar.d(context.getPackageName());
            ag.BuiltInFictitiousFunctionClassFactory(context).PlaceComponentResult(eaVar);
            PushMessageHandler.a();
            PushMessageHandler.b();
            a.C0157a c0157a = a.PlaceComponentResult(context).BuiltInFictitiousFunctionClassFactory;
            c0157a.getAuthRequestContext = false;
            a.BuiltInFictitiousFunctionClassFactory(c0157a.PlaceComponentResult).edit().putBoolean("valid", c0157a.getAuthRequestContext).commit();
            MyBillsEntityDataFactory(context);
            BuiltInFictitiousFunctionClassFactory(context);
            getAuthRequestContext(context);
        }
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        char[] cArr2;
        A a2 = new A();
        char[] cArr3 = new char[i2];
        try {
            a2.MyBillsEntityDataFactory = 0;
            while (a2.MyBillsEntityDataFactory < i2) {
                int i4 = $10 + 53;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                cArr3[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
                int i6 = a2.MyBillsEntityDataFactory;
                cArr3[i6] = (char) (cArr3[i6] - ((int) (BuiltInFictitiousFunctionClassFactory ^ (-5694784870793460699L))));
                a2.MyBillsEntityDataFactory++;
            }
            if (i3 > 0) {
                try {
                    int i7 = $11 + 105;
                    $10 = i7 % 128;
                    int i8 = i7 % 2;
                    a2.BuiltInFictitiousFunctionClassFactory = i3;
                    char[] cArr4 = new char[i2];
                    System.arraycopy(cArr3, 0, cArr4, 0, i2);
                    System.arraycopy(cArr4, 0, cArr3, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
                    System.arraycopy(cArr4, a2.BuiltInFictitiousFunctionClassFactory, cArr3, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
                    int i9 = $10 + 57;
                    $11 = i9 % 128;
                    int i10 = i9 % 2;
                } catch (Exception e) {
                    throw e;
                }
            }
            if ((z ? '*' : '/') == '*') {
                int i11 = $10 + 17;
                $11 = i11 % 128;
                if ((i11 % 2 == 0 ? '?' : 'b') != 'b') {
                    cArr2 = new char[i2];
                    a2.MyBillsEntityDataFactory = 0;
                } else {
                    cArr2 = new char[i2];
                    a2.MyBillsEntityDataFactory = 0;
                }
                while (true) {
                    if (a2.MyBillsEntityDataFactory >= i2) {
                        break;
                    }
                    cArr2[a2.MyBillsEntityDataFactory] = cArr3[(i2 - a2.MyBillsEntityDataFactory) - 1];
                    a2.MyBillsEntityDataFactory++;
                }
                int i12 = $11 + 97;
                $10 = i12 % 128;
                int i13 = i12 % 2;
                cArr3 = cArr2;
            }
            objArr[0] = new String(cArr3);
        } catch (Exception e2) {
            throw e2;
        }
    }
}

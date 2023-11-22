package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.griver.beehive.lottie.player.TimeUtils;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.mipush.sdk.a;
import com.xiaomi.mipush.sdk.ag;
import com.xiaomi.push.av;
import com.xiaomi.push.aw;
import com.xiaomi.push.bg;
import com.xiaomi.push.cz;
import com.xiaomi.push.df;
import com.xiaomi.push.dh;
import com.xiaomi.push.di;
import com.xiaomi.push.dj;
import com.xiaomi.push.dl;
import com.xiaomi.push.dm;
import com.xiaomi.push.dp;
import com.xiaomi.push.dq;
import com.xiaomi.push.dr;
import com.xiaomi.push.ds;
import com.xiaomi.push.dt;
import com.xiaomi.push.dv;
import com.xiaomi.push.dx;
import com.xiaomi.push.dz;
import com.xiaomi.push.eb;
import com.xiaomi.push.ed;
import com.xiaomi.push.ee;
import com.xiaomi.push.ef;
import com.xiaomi.push.ej;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.au;
import com.xiaomi.push.service.bd;
import com.xiaomi.push.service.bj;
import id.dana.data.deeplink.DeepLinkPayloadManager;
import j$.util.DesugarTimeZone;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;
import kotlin.text.Typography;
import o.whenAvailable;

/* loaded from: classes8.dex */
public class ae {
    private static int $10 = 0;
    private static int $11 = 1;
    private static ae KClassImpl$Data$declaredNonStaticMembers$2 = null;
    private static Object MyBillsEntityDataFactory = null;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private static char[] PlaceComponentResult;
    private static Queue<String> getAuthRequestContext;
    private static long getErrorConfigVersion;
    private static int moveToNextValue;
    private Context BuiltInFictitiousFunctionClassFactory;

    static {
        getAuthRequestContext();
        MyBillsEntityDataFactory = new Object();
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 117;
        moveToNextValue = i % 128;
        int i2 = i % 2;
    }

    private ae(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            this.BuiltInFictitiousFunctionClassFactory = applicationContext;
            if (applicationContext == null) {
                this.BuiltInFictitiousFunctionClassFactory = context;
                int i = moveToNextValue + 111;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                int i2 = i % 2;
            }
            int i3 = moveToNextValue + 103;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0035, code lost:
    
        if (java.lang.Math.abs(r0.getLong("last_reinitialize", 1) * r6) > 1800000) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0051, code lost:
    
        if (java.lang.Math.abs(r6 - r0.getLong("last_reinitialize", 0)) > 1800000) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0053, code lost:
    
        com.xiaomi.mipush.sdk.MiPushClient.PlaceComponentResult(r10.BuiltInFictitiousFunctionClassFactory, com.xiaomi.push.dj.PackageUnregistered);
        r0.edit().putLong("last_reinitialize", r6).commit();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0066, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0067, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void BuiltInFictitiousFunctionClassFactory() {
        /*
            r10 = this;
            int r0 = com.xiaomi.mipush.sdk.ae.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 5
            int r1 = r0 % 128
            com.xiaomi.mipush.sdk.ae.moveToNextValue = r1
            int r0 = r0 % 2
            r1 = 95
            if (r0 == 0) goto L11
            r0 = 85
            goto L13
        L11:
            r0 = 95
        L13:
            r2 = 1800000(0x1b7740, double:8.89318E-318)
            java.lang.String r4 = "mipush_extra"
            java.lang.String r5 = "last_reinitialize"
            if (r0 == r1) goto L38
            android.content.Context r0 = r10.BuiltInFictitiousFunctionClassFactory
            r1 = 1
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r4, r1)
            long r6 = java.lang.System.currentTimeMillis()
            r8 = 1
            long r8 = r0.getLong(r5, r8)
            long r8 = r8 * r6
            long r8 = java.lang.Math.abs(r8)
            int r1 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r1 <= 0) goto L68
            goto L53
        L38:
            android.content.Context r0 = r10.BuiltInFictitiousFunctionClassFactory
            r1 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r4, r1)
            long r6 = java.lang.System.currentTimeMillis()
            r8 = 0
            long r8 = r0.getLong(r5, r8)
            long r8 = r6 - r8
            long r8 = java.lang.Math.abs(r8)
            int r1 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r1 <= 0) goto L68
        L53:
            android.content.Context r1 = r10.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L66
            com.xiaomi.push.dj r2 = com.xiaomi.push.dj.PackageUnregistered     // Catch: java.lang.Exception -> L66
            com.xiaomi.mipush.sdk.MiPushClient.PlaceComponentResult(r1, r2)     // Catch: java.lang.Exception -> L66
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch: java.lang.Exception -> L66
            android.content.SharedPreferences$Editor r0 = r0.putLong(r5, r6)     // Catch: java.lang.Exception -> L66
            r0.commit()     // Catch: java.lang.Exception -> L66
            goto L68
        L66:
            r0 = move-exception
            throw r0
        L68:
            int r0 = com.xiaomi.mipush.sdk.ae.moveToNextValue
            int r0 = r0 + 53
            int r1 = r0 % 128
            com.xiaomi.mipush.sdk.ae.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1
            int r0 = r0 % 2
            r1 = 99
            if (r0 != 0) goto L79
            r0 = 99
            goto L7b
        L79:
            r0 = 13
        L7b:
            if (r0 == r1) goto L7e
            return
        L7e:
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L83
            return
        L83:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.ae.BuiltInFictitiousFunctionClassFactory():void");
    }

    private void BuiltInFictitiousFunctionClassFactory(dm dmVar) {
        long j;
        c cVar;
        StringBuilder sb = new StringBuilder();
        sb.append("ASSEMBLE_PUSH : ");
        sb.append(dmVar.toString());
        com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory(sb.toString());
        String a2 = dmVar.a();
        Map<String, String> m292a = dmVar.m292a();
        if (m292a != null) {
            int i = moveToNextValue + 21;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            int i2 = i % 2;
            String str = m292a.get("RegInfo");
            if (!TextUtils.isEmpty(str)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("brand:");
                sb2.append(y.FCM.name());
                if (!(!str.contains(sb2.toString()))) {
                    int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 107;
                    moveToNextValue = i3 % 128;
                    char c = i3 % 2 == 0 ? '8' : (char) 1;
                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("ASSEMBLE_PUSH : receive fcm token sync ack");
                    if (c != '8') {
                        g.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, c.ASSEMBLE_PUSH_FCM, str);
                        j = dmVar.f182a;
                        cVar = c.ASSEMBLE_PUSH_FCM;
                        int i4 = 0 / 0;
                    } else {
                        g.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, c.ASSEMBLE_PUSH_FCM, str);
                        j = dmVar.f182a;
                        cVar = c.ASSEMBLE_PUSH_FCM;
                    }
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("brand:");
                    sb3.append(y.HUAWEI.name());
                    if (str.contains(sb3.toString())) {
                        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("ASSEMBLE_PUSH : receive hw token sync ack");
                        g.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, c.ASSEMBLE_PUSH_HUAWEI, str);
                        j = dmVar.f182a;
                        cVar = c.ASSEMBLE_PUSH_HUAWEI;
                    } else {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("brand:");
                        sb4.append(y.OPPO.name());
                        if (str.contains(sb4.toString())) {
                            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("ASSEMBLE_PUSH : receive COS token sync ack");
                            g.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, c.ASSEMBLE_PUSH_COS, str);
                            j = dmVar.f182a;
                            cVar = c.ASSEMBLE_PUSH_COS;
                        } else {
                            StringBuilder sb5 = new StringBuilder();
                            try {
                                sb5.append("brand:");
                                sb5.append(y.VIVO.name());
                                if (str.contains(sb5.toString())) {
                                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("ASSEMBLE_PUSH : receive FTOS token sync ack");
                                    g.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, c.ASSEMBLE_PUSH_FTOS, str);
                                    j = dmVar.f182a;
                                    cVar = c.ASSEMBLE_PUSH_FTOS;
                                }
                            } catch (Exception e) {
                                throw e;
                            }
                        }
                    }
                }
                getAuthRequestContext(a2, j, cVar);
                return;
            }
        }
        int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 111;
        moveToNextValue = i5 % 128;
        int i6 = i5 % 2;
    }

    private PushMessageHandler.a KClassImpl$Data$declaredNonStaticMembers$2(dq dqVar) {
        String str;
        ef KClassImpl$Data$declaredNonStaticMembers$22;
        String str2 = null;
        try {
            KClassImpl$Data$declaredNonStaticMembers$22 = aa.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, dqVar);
        } catch (o e) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
            str = "message arrived: receive a message but decrypt failed. report when click.";
        } catch (ej e2) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e2);
            str = "message arrived: receive a message which action string is not valid. is the reg expired?";
        }
        if (KClassImpl$Data$declaredNonStaticMembers$22 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("message arrived: receiving an un-recognized message. ");
            sb.append(dqVar.f222a);
            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString());
            int i = moveToNextValue + 103;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            if (i % 2 == 0) {
                int i2 = 89 / 0;
                return null;
            }
            return null;
        }
        cz a2 = dqVar.a();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("message arrived: processing an arrived message, action=");
        sb2.append(a2);
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
        try {
            if (af.KClassImpl$Data$declaredNonStaticMembers$2[a2.ordinal()] != 1) {
                int i3 = moveToNextValue + 47;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                if (i3 % 2 == 0) {
                    int i4 = 76 / 0;
                }
                int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 15;
                moveToNextValue = i5 % 128;
                if (i5 % 2 != 0) {
                    str2.hashCode();
                    return null;
                }
                return null;
            }
            if (dqVar.m316b()) {
                dx dxVar = (dx) KClassImpl$Data$declaredNonStaticMembers$22;
                dh a3 = dxVar.a();
                if (a3 != null) {
                    if (!(dqVar.f223a == null)) {
                        if (!(dqVar.f223a.m278a() == null)) {
                            str2 = dqVar.f223a.f139a.get("jobkey");
                            int i6 = moveToNextValue + 59;
                            NetworkUserEntityData$$ExternalSyntheticLambda0 = i6 % 128;
                            int i7 = i6 % 2;
                        }
                    }
                    MiPushMessage KClassImpl$Data$declaredNonStaticMembers$23 = PushMessageHelper.KClassImpl$Data$declaredNonStaticMembers$2(dxVar, dqVar.m308a(), false);
                    KClassImpl$Data$declaredNonStaticMembers$23.setArrivedMessage(true);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("message arrived: receive a message, msgid=");
                    sb3.append(a3.m269a());
                    sb3.append(", jobkey=");
                    sb3.append(str2);
                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb3.toString());
                    return KClassImpl$Data$declaredNonStaticMembers$23;
                }
                str = "message arrived: receive an empty message without push content, drop it";
            } else {
                str = "message arrived: receiving an un-encrypt message(SendMessage).";
            }
            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(str);
            return null;
        } catch (Exception e3) {
            throw e3;
        }
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str) {
        synchronized (MyBillsEntityDataFactory) {
            a.PlaceComponentResult(context);
            SharedPreferences BuiltInFictitiousFunctionClassFactory = a.BuiltInFictitiousFunctionClassFactory(context);
            if (getAuthRequestContext == null) {
                String[] split = BuiltInFictitiousFunctionClassFactory.getString("pref_msg_ids", "").split(",");
                getAuthRequestContext = new LinkedList();
                for (String str2 : split) {
                    getAuthRequestContext.add(str2);
                }
            }
            if (getAuthRequestContext.contains(str)) {
                return true;
            }
            getAuthRequestContext.add(str);
            if (getAuthRequestContext.size() > 25) {
                getAuthRequestContext.poll();
            }
            String PlaceComponentResult2 = com.xiaomi.push.ad.PlaceComponentResult(getAuthRequestContext, ",");
            SharedPreferences.Editor edit = BuiltInFictitiousFunctionClassFactory.edit();
            edit.putString("pref_msg_ids", PlaceComponentResult2);
            com.xiaomi.channel.commonutils.android.h.MyBillsEntityDataFactory(edit);
            return false;
        }
    }

    private static Intent MyBillsEntityDataFactory(Context context, String str, Map<String, String> map, int i) {
        int i2 = moveToNextValue + 109;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        int i3 = i2 % 2;
        Intent BuiltInFictitiousFunctionClassFactory = com.xiaomi.push.service.ag.BuiltInFictitiousFunctionClassFactory(context, str, map, i);
        try {
            int i4 = moveToNextValue + 73;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
                int i5 = i4 % 2;
                return BuiltInFictitiousFunctionClassFactory;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0015, code lost:
    
        if (com.xiaomi.mipush.sdk.ae.KClassImpl$Data$declaredNonStaticMembers$2 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x001d, code lost:
    
        if (com.xiaomi.mipush.sdk.ae.KClassImpl$Data$declaredNonStaticMembers$2 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x001f, code lost:
    
        com.xiaomi.mipush.sdk.ae.KClassImpl$Data$declaredNonStaticMembers$2 = new com.xiaomi.mipush.sdk.ae(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.xiaomi.mipush.sdk.ae MyBillsEntityDataFactory(android.content.Context r3) {
        /*
            int r0 = com.xiaomi.mipush.sdk.ae.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 117
            int r1 = r0 % 128
            com.xiaomi.mipush.sdk.ae.moveToNextValue = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == r1) goto L18
            com.xiaomi.mipush.sdk.ae r0 = com.xiaomi.mipush.sdk.ae.KClassImpl$Data$declaredNonStaticMembers$2
            if (r0 != 0) goto L26
            goto L1f
        L18:
            com.xiaomi.mipush.sdk.ae r0 = com.xiaomi.mipush.sdk.ae.KClassImpl$Data$declaredNonStaticMembers$2
            r1 = 61
            int r1 = r1 / r2
            if (r0 != 0) goto L26
        L1f:
            com.xiaomi.mipush.sdk.ae r0 = new com.xiaomi.mipush.sdk.ae
            r0.<init>(r3)
            com.xiaomi.mipush.sdk.ae.KClassImpl$Data$declaredNonStaticMembers$2 = r0
        L26:
            com.xiaomi.mipush.sdk.ae r3 = com.xiaomi.mipush.sdk.ae.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = com.xiaomi.mipush.sdk.ae.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 3
            int r1 = r0 % 128
            com.xiaomi.mipush.sdk.ae.moveToNextValue = r1
            int r0 = r0 % 2
            return r3
        L33:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.ae.MyBillsEntityDataFactory(android.content.Context):com.xiaomi.mipush.sdk.ae");
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x006c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean PlaceComponentResult(com.xiaomi.push.dq r5) {
        /*
            com.xiaomi.push.di r0 = r5.m308a()
            r1 = 88
            if (r0 != 0) goto Lb
            r0 = 88
            goto Ld
        Lb:
            r0 = 23
        Ld:
            r2 = 0
            if (r0 == r1) goto L19
            com.xiaomi.push.di r5 = r5.m308a()
            java.util.Map r5 = r5.m278a()
            goto L2e
        L19:
            int r5 = com.xiaomi.mipush.sdk.ae.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r5 = r5 + 39
            int r0 = r5 % 128
            com.xiaomi.mipush.sdk.ae.moveToNextValue = r0
            int r5 = r5 % 2
            int r5 = com.xiaomi.mipush.sdk.ae.moveToNextValue
            int r5 = r5 + 125
            int r0 = r5 % 128
            com.xiaomi.mipush.sdk.ae.NetworkUserEntityData$$ExternalSyntheticLambda0 = r0
            int r5 = r5 % 2
            r5 = r2
        L2e:
            r0 = 50
            if (r5 != 0) goto L35
            r1 = 8
            goto L37
        L35:
            r1 = 50
        L37:
            r3 = 0
            if (r1 == r0) goto L3b
            return r3
        L3b:
            java.lang.String r0 = "push_server_action"
            java.lang.Object r5 = r5.get(r0)     // Catch: java.lang.Exception -> L6e
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> L6e
            java.lang.String r0 = "hybrid_message"
            boolean r0 = android.text.TextUtils.equals(r5, r0)     // Catch: java.lang.Exception -> L6e
            r1 = 1
            if (r0 != 0) goto L4e
            r0 = 1
            goto L4f
        L4e:
            r0 = 0
        L4f:
            if (r0 == r1) goto L52
            goto L6d
        L52:
            int r0 = com.xiaomi.mipush.sdk.ae.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 81
            int r4 = r0 % 128
            com.xiaomi.mipush.sdk.ae.moveToNextValue = r4
            int r0 = r0 % 2
            java.lang.String r4 = "platform_message"
            boolean r5 = android.text.TextUtils.equals(r5, r4)
            if (r0 == 0) goto L6a
            int r0 = r2.length     // Catch: java.lang.Throwable -> L68
            if (r5 != 0) goto L6d
            goto L6c
        L68:
            r5 = move-exception
            throw r5
        L6a:
            if (r5 != 0) goto L6d
        L6c:
            return r3
        L6d:
            return r1
        L6e:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.ae.PlaceComponentResult(com.xiaomi.push.dq):boolean");
    }

    private static List<String> getAuthRequestContext(TimeZone timeZone, TimeZone timeZone2, List<String> list) {
        try {
            int i = moveToNextValue + 111;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            int i2 = i % 2;
            if ((timeZone.equals(timeZone2) ? (char) 19 : Typography.dollar) != '$') {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 105;
                moveToNextValue = i3 % 128;
                if ((i3 % 2 != 0 ? ';' : (char) 19) == ';') {
                    int i4 = 35 / 0;
                }
                return list;
            }
            long rawOffset = ((timeZone.getRawOffset() - timeZone2.getRawOffset()) / 1000) / 60;
            long parseLong = Long.parseLong(list.get(0).split(":")[0]);
            long parseLong2 = Long.parseLong(list.get(0).split(":")[1]);
            long parseLong3 = Long.parseLong(list.get(1).split(":")[0]);
            long parseLong4 = Long.parseLong(list.get(1).split(":")[1]);
            long j = ((((parseLong * 60) + parseLong2) - rawOffset) + TimeUtils.DAY_TO_MIN) % TimeUtils.DAY_TO_MIN;
            long j2 = ((((parseLong3 * 60) + parseLong4) - rawOffset) + TimeUtils.DAY_TO_MIN) % TimeUtils.DAY_TO_MIN;
            ArrayList arrayList = new ArrayList();
            arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j / 60), Long.valueOf(j % 60)));
            arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)));
            return arrayList;
        } catch (Exception e) {
            throw e;
        }
    }

    static void getAuthRequestContext() {
        PlaceComponentResult = new char[]{62255, 1184, 7170, 5579, 11584, 9533, 16008, 13935, 20439, 18351, 24332};
        getErrorConfigVersion = -5742245108198800176L;
    }

    private void getAuthRequestContext(String str, long j, c cVar) {
        am authRequestContext = j.getAuthRequestContext(cVar);
        if (authRequestContext == null) {
            return;
        }
        if (j == 0) {
            synchronized (x.class) {
                if (x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).getAuthRequestContext(str)) {
                    x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory(str);
                    if ("syncing".equals(x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).MyBillsEntityDataFactory(authRequestContext))) {
                        x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).getAuthRequestContext(authRequestContext, "synced");
                    }
                }
            }
        } else if (!"syncing".equals(x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).MyBillsEntityDataFactory(authRequestContext))) {
            x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory(str);
        } else {
            synchronized (x.class) {
                if (x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).getAuthRequestContext(str)) {
                    if (x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).MyBillsEntityDataFactory(str) < 10) {
                        x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).KClassImpl$Data$declaredNonStaticMembers$2(str);
                        ag.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory(str, authRequestContext, cVar);
                    } else {
                        x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory(str);
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private PushMessageHandler.a MyBillsEntityDataFactory(dq dqVar, boolean z, byte[] bArr, String str, int i, Intent intent) {
        ArrayList arrayList;
        String str2;
        long j;
        String str3;
        String c;
        String str4;
        List list;
        long j2;
        String str5;
        Class<x> cls;
        MiPushMessage miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        r5 = null;
        ArrayList arrayList2 = null;
        miPushMessage = null;
        miPushMessage = null;
        try {
            ef KClassImpl$Data$declaredNonStaticMembers$22 = aa.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, dqVar);
            if (KClassImpl$Data$declaredNonStaticMembers$22 == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("receiving an un-recognized message. ");
                sb.append(dqVar.f222a);
                com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString());
                n.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, dqVar, z);
                return null;
            }
            cz a2 = dqVar.a();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("processing a message, action=");
            sb2.append(a2);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
            boolean z2 = true;
            switch (af.KClassImpl$Data$declaredNonStaticMembers$2[a2.ordinal()]) {
                case 1:
                    if (!dqVar.m316b()) {
                        com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2("receiving an un-encrypt message(SendMessage).");
                        return null;
                    } else if (a.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory).getAuthRequestContext() && !z) {
                        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("receive a message in pause state. drop it");
                        return null;
                    } else {
                        dx dxVar = (dx) KClassImpl$Data$declaredNonStaticMembers$22;
                        dh a3 = dxVar.a();
                        if (a3 == null) {
                            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2("receive an empty message without push content, drop it");
                            n.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, dqVar, z);
                            return null;
                        }
                        int intExtra = intent.getIntExtra("notification_click_button", 0);
                        if (z) {
                            if (com.xiaomi.push.service.ag.PlaceComponentResult(dqVar)) {
                                MiPushClient.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, a3.m269a(), dqVar.m308a(), dqVar.f229b, a3.b());
                            } else {
                                di diVar = dqVar.m308a() != null ? new di(dqVar.m308a()) : new di();
                                if (diVar.m278a() == null) {
                                    diVar.a(new HashMap());
                                }
                                diVar.m278a().put("notification_click_button", String.valueOf(intExtra));
                                MiPushClient.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, a3.m269a(), diVar, a3.b());
                            }
                        }
                        if (!z) {
                            if (!TextUtils.isEmpty(dxVar.d()) && MiPushClient.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, dxVar.d()) < 0) {
                                MiPushClient.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, dxVar.d());
                            } else if (!TextUtils.isEmpty(dxVar.c()) && MiPushClient.initRecordTimeStamp(this.BuiltInFictitiousFunctionClassFactory, dxVar.c()) < 0) {
                                MiPushClient.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, dxVar.c());
                            }
                        }
                        String str6 = (dqVar.f223a == null || dqVar.f223a.m278a() == null) ? null : dqVar.f223a.f139a.get("jobkey");
                        String m269a = TextUtils.isEmpty(str6) ? a3.m269a() : str6;
                        if (z || !KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, m269a)) {
                            MiPushMessage KClassImpl$Data$declaredNonStaticMembers$23 = PushMessageHelper.KClassImpl$Data$declaredNonStaticMembers$2(dxVar, dqVar.m308a(), z);
                            if (KClassImpl$Data$declaredNonStaticMembers$23.getPassThrough() == 0 && !z && com.xiaomi.push.service.ag.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$23.getExtra())) {
                                com.xiaomi.push.service.ag.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, dqVar, bArr);
                                return null;
                            }
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("receive a message, msgid=");
                            sb3.append(a3.m269a());
                            sb3.append(", jobkey=");
                            sb3.append(m269a);
                            sb3.append(", btn=");
                            sb3.append(intExtra);
                            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb3.toString());
                            String authRequestContext = com.xiaomi.push.service.ag.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$23.getExtra(), intExtra);
                            if (z && KClassImpl$Data$declaredNonStaticMembers$23.getExtra() != null && !TextUtils.isEmpty(authRequestContext)) {
                                Map<String, String> extra = KClassImpl$Data$declaredNonStaticMembers$23.getExtra();
                                if (intExtra != 0 && dqVar.m308a() != null) {
                                    ag.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).KClassImpl$Data$declaredNonStaticMembers$2(dqVar.m308a().c(), intExtra);
                                }
                                if (com.xiaomi.push.service.ag.PlaceComponentResult(dqVar)) {
                                    Intent MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, dqVar.f229b, extra, intExtra);
                                    MyBillsEntityDataFactory2.putExtra("eventMessageType", i);
                                    MyBillsEntityDataFactory2.putExtra("messageId", str);
                                    MyBillsEntityDataFactory2.putExtra("jobkey", str6);
                                    if (MyBillsEntityDataFactory2 == null) {
                                        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("Getting Intent fail from ignore reg message. ");
                                        return null;
                                    }
                                    String c2 = a3.c();
                                    if (!TextUtils.isEmpty(c2)) {
                                        MyBillsEntityDataFactory2.putExtra("payload", c2);
                                    }
                                    this.BuiltInFictitiousFunctionClassFactory.startActivity(MyBillsEntityDataFactory2);
                                    n.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory).getAuthRequestContext(dqVar, 0, true);
                                } else {
                                    Context context = this.BuiltInFictitiousFunctionClassFactory;
                                    Intent MyBillsEntityDataFactory3 = MyBillsEntityDataFactory(context, context.getPackageName(), extra, intExtra);
                                    if (MyBillsEntityDataFactory3 != null) {
                                        if (!authRequestContext.equals(bd.newProxyInstance)) {
                                            MyBillsEntityDataFactory3.putExtra("key_message", KClassImpl$Data$declaredNonStaticMembers$23);
                                            MyBillsEntityDataFactory3.putExtra("eventMessageType", i);
                                            MyBillsEntityDataFactory3.putExtra("messageId", str);
                                            MyBillsEntityDataFactory3.putExtra("jobkey", str6);
                                        }
                                        this.BuiltInFictitiousFunctionClassFactory.startActivity(MyBillsEntityDataFactory3);
                                        n.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory).getAuthRequestContext(dqVar, 0, true);
                                        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("start activity succ");
                                        authRequestContext.equals(bd.newProxyInstance);
                                    }
                                }
                                return null;
                            }
                            miPushMessage = KClassImpl$Data$declaredNonStaticMembers$23;
                        } else {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("drop a duplicate message, key=");
                            sb4.append(m269a);
                            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb4.toString());
                        }
                        if (dqVar.m308a() == null && !z) {
                            KClassImpl$Data$declaredNonStaticMembers$2(dxVar, dqVar);
                        }
                        return miPushMessage;
                    }
                case 2:
                    dv dvVar = (dv) KClassImpl$Data$declaredNonStaticMembers$22;
                    String str7 = a.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory).MyBillsEntityDataFactory;
                    if (TextUtils.isEmpty(str7) || !TextUtils.equals(str7, dvVar.m337a())) {
                        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("bad Registration result:");
                        return null;
                    }
                    long j3 = ag.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).PlaceComponentResult;
                    if (j3 > 0 && SystemClock.elapsedRealtime() - j3 > DeepLinkPayloadManager.RESET_PAYLOAD_BACKUP_DELAY) {
                        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("The received registration result has expired.");
                        aw.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory);
                        av.PlaceComponentResult();
                        return null;
                    }
                    a.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory).MyBillsEntityDataFactory = null;
                    if (dvVar.f285a == 0) {
                        a PlaceComponentResult2 = a.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory);
                        String str8 = dvVar.f295e;
                        String str9 = dvVar.f296f;
                        String str10 = dvVar.f302l;
                        a.C0157a c0157a = PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory;
                        c0157a.lookAheadTest = str8;
                        c0157a.getErrorConfigVersion = str9;
                        c0157a.scheduleImpl = com.xiaomi.channel.commonutils.android.c.getErrorConfigVersion(c0157a.PlaceComponentResult);
                        Context context2 = c0157a.PlaceComponentResult;
                        c0157a.NetworkUserEntityData$$ExternalSyntheticLambda0 = com.xiaomi.channel.commonutils.android.a.BuiltInFictitiousFunctionClassFactory(context2, context2.getPackageName());
                        c0157a.getAuthRequestContext = true;
                        c0157a.initRecordTimeStamp = str10;
                        SharedPreferences.Editor edit = c0157a.PlaceComponentResult.getSharedPreferences("mipush", 0).edit();
                        edit.putString("regId", str8);
                        edit.putString("regSec", str9);
                        edit.putString("devId", c0157a.scheduleImpl);
                        Context context3 = c0157a.PlaceComponentResult;
                        edit.putString("vName", com.xiaomi.channel.commonutils.android.a.BuiltInFictitiousFunctionClassFactory(context3, context3.getPackageName()));
                        edit.putBoolean("valid", true);
                        edit.putString("appRegion", str10);
                        edit.commit();
                        FCMPushHelper.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory);
                    }
                    if (TextUtils.isEmpty(dvVar.f295e)) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList();
                        arrayList.add(dvVar.f295e);
                    }
                    MiPushCommandMessage BuiltInFictitiousFunctionClassFactory = PushMessageHelper.BuiltInFictitiousFunctionClassFactory(bg.COMMAND_REGISTER.f83a, arrayList, dvVar.f285a, dvVar.f294d, null);
                    ag BuiltInFictitiousFunctionClassFactory2 = ag.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory);
                    ArrayList<ag.a> arrayList3 = ag.BuiltInFictitiousFunctionClassFactory;
                    synchronized (arrayList3) {
                        try {
                            Object[] objArr = new Object[1];
                            ag.a((byte) (ag.getAuthRequestContext[12] - 1), (byte) (-ag.getAuthRequestContext[29]), ag.getAuthRequestContext[13], objArr);
                            Class<?> cls2 = Class.forName((String) objArr[0]);
                            Object[] objArr2 = new Object[1];
                            ag.a((short) 27, ag.getAuthRequestContext[53], ag.getAuthRequestContext[25], objArr2);
                            if (cls2.getMethod((String) objArr2[0], null).invoke(null, null) != Looper.getMainLooper().getThread()) {
                                z2 = false;
                            }
                            Iterator<ag.a> it = arrayList3.iterator();
                            while (it.hasNext()) {
                                ag.a next = it.next();
                                BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory(next.MyBillsEntityDataFactory, next.KClassImpl$Data$declaredNonStaticMembers$2, next.getAuthRequestContext, false, null, true, BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName(), a.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, true);
                                if (!z2) {
                                    try {
                                        Thread.sleep(100L);
                                    } catch (InterruptedException unused) {
                                    }
                                }
                            }
                            ag.BuiltInFictitiousFunctionClassFactory.clear();
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause != null) {
                                throw cause;
                            }
                            throw th;
                        }
                    }
                    return BuiltInFictitiousFunctionClassFactory;
                case 3:
                    if (!dqVar.m316b()) {
                        com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2("receiving an un-encrypt message(UnRegistration).");
                        return null;
                    }
                    if (((eb) KClassImpl$Data$declaredNonStaticMembers$22).f361a == 0) {
                        a.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
                        MiPushClient.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory);
                    }
                    PushMessageHandler.a();
                    return miPushMessage;
                case 4:
                    dz dzVar = (dz) KClassImpl$Data$declaredNonStaticMembers$22;
                    if (dzVar.f336a == 0) {
                        MiPushClient.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, dzVar.b());
                    }
                    if (!TextUtils.isEmpty(dzVar.b())) {
                        arrayList2 = new ArrayList();
                        arrayList2.add(dzVar.b());
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("resp-cmd:");
                    sb5.append(bg.COMMAND_SUBSCRIBE_TOPIC);
                    sb5.append(", ");
                    sb5.append(dzVar.a());
                    com.xiaomi.channel.commonutils.logger.b.moveToNextValue(sb5.toString());
                    str2 = bg.COMMAND_SUBSCRIBE_TOPIC.f83a;
                    j = dzVar.f336a;
                    str3 = dzVar.f342d;
                    c = dzVar.c();
                    str4 = str2;
                    list = arrayList2;
                    j2 = j;
                    str5 = str3;
                    return PushMessageHelper.BuiltInFictitiousFunctionClassFactory(str4, list, j2, str5, c);
                case 5:
                    ed edVar = (ed) KClassImpl$Data$declaredNonStaticMembers$22;
                    if (edVar.f381a == 0) {
                        MiPushClient.getErrorConfigVersion(this.BuiltInFictitiousFunctionClassFactory, edVar.b());
                    }
                    if (!TextUtils.isEmpty(edVar.b())) {
                        arrayList2 = new ArrayList();
                        arrayList2.add(edVar.b());
                    }
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("resp-cmd:");
                    sb6.append(bg.COMMAND_UNSUBSCRIBE_TOPIC);
                    sb6.append(", ");
                    sb6.append(edVar.a());
                    com.xiaomi.channel.commonutils.logger.b.moveToNextValue(sb6.toString());
                    str2 = bg.COMMAND_UNSUBSCRIBE_TOPIC.f83a;
                    j = edVar.f381a;
                    str3 = edVar.f387d;
                    c = edVar.c();
                    str4 = str2;
                    list = arrayList2;
                    j2 = j;
                    str5 = str3;
                    return PushMessageHelper.BuiltInFictitiousFunctionClassFactory(str4, list, j2, str5, c);
                case 6:
                    dp dpVar = (dp) KClassImpl$Data$declaredNonStaticMembers$22;
                    String b = dpVar.b();
                    List m302a = dpVar.m302a();
                    List list2 = m302a;
                    if (dpVar.f210a == 0) {
                        if (TextUtils.equals(b, bg.COMMAND_SET_ACCEPT_TIME.f83a) && m302a != null && m302a.size() > 1) {
                            MiPushClient.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, m302a.get(0), m302a.get(1));
                            if ("00:00".equals(m302a.get(0)) && "00:00".equals(m302a.get(1))) {
                                a.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory).KClassImpl$Data$declaredNonStaticMembers$2(true);
                            } else {
                                a.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory).KClassImpl$Data$declaredNonStaticMembers$2(false);
                            }
                            list2 = getAuthRequestContext(DesugarTimeZone.BuiltInFictitiousFunctionClassFactory("GMT+08"), TimeZone.getDefault(), m302a);
                        } else if (TextUtils.equals(b, bg.COMMAND_SET_ALIAS.f83a) && m302a != null && m302a.size() > 0) {
                            MiPushClient.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, m302a.get(0));
                            list2 = m302a;
                        } else if (TextUtils.equals(b, bg.COMMAND_UNSET_ALIAS.f83a) && m302a != null && m302a.size() > 0) {
                            MiPushClient.lookAheadTest(this.BuiltInFictitiousFunctionClassFactory, m302a.get(0));
                            list2 = m302a;
                        } else if (TextUtils.equals(b, bg.COMMAND_SET_ACCOUNT.f83a) && m302a != null && m302a.size() > 0) {
                            MiPushClient.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, m302a.get(0));
                            list2 = m302a;
                        } else if (!TextUtils.equals(b, bg.COMMAND_UNSET_ACCOUNT.f83a) || m302a == null || m302a.size() <= 0) {
                            list2 = m302a;
                            if (TextUtils.equals(b, bg.COMMAND_CHK_VDEVID.f83a)) {
                                return null;
                            }
                        } else {
                            MiPushClient.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, m302a.get(0));
                            list2 = m302a;
                        }
                    }
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("resp-cmd:");
                    sb7.append(b);
                    sb7.append(", ");
                    sb7.append(dpVar.a());
                    com.xiaomi.channel.commonutils.logger.b.moveToNextValue(sb7.toString());
                    long j4 = dpVar.f210a;
                    String str11 = dpVar.f218d;
                    c = dpVar.c();
                    str4 = b;
                    list = list2;
                    j2 = j4;
                    str5 = str11;
                    return PushMessageHelper.BuiltInFictitiousFunctionClassFactory(str4, list, j2, str5, c);
                case 7:
                    if (KClassImpl$Data$declaredNonStaticMembers$22 instanceof dm) {
                        dm dmVar = (dm) KClassImpl$Data$declaredNonStaticMembers$22;
                        String a4 = dmVar.a();
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append("resp-type:");
                        sb8.append(dmVar.b());
                        sb8.append(", code:");
                        sb8.append(dmVar.f182a);
                        sb8.append(", ");
                        sb8.append(a4);
                        com.xiaomi.channel.commonutils.logger.b.moveToNextValue(sb8.toString());
                        if (df.DisablePushMessage.f104a.equalsIgnoreCase(dmVar.f189d)) {
                            if (dmVar.f182a == 0) {
                                cls = x.class;
                                synchronized (cls) {
                                    if (x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).getAuthRequestContext(a4)) {
                                        x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory(a4);
                                        if ("syncing".equals(x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).MyBillsEntityDataFactory(am.DISABLE_PUSH))) {
                                            x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).getAuthRequestContext(am.DISABLE_PUSH, "synced");
                                            MiPushClient.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory);
                                            MiPushClient.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory);
                                            PushMessageHandler.a();
                                            ag BuiltInFictitiousFunctionClassFactory3 = ag.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory);
                                            Intent KClassImpl$Data$declaredNonStaticMembers$24 = (!BuiltInFictitiousFunctionClassFactory3.getAuthRequestContext() || "com.xiaomi.xmsf".equals(BuiltInFictitiousFunctionClassFactory3.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName())) ? BuiltInFictitiousFunctionClassFactory3.KClassImpl$Data$declaredNonStaticMembers$2() : BuiltInFictitiousFunctionClassFactory3.MyBillsEntityDataFactory();
                                            KClassImpl$Data$declaredNonStaticMembers$24.setAction("com.xiaomi.mipush.DISABLE_PUSH");
                                            BuiltInFictitiousFunctionClassFactory3.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$24);
                                        }
                                    }
                                }
                            } else {
                                if ("syncing".equals(x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).MyBillsEntityDataFactory(am.DISABLE_PUSH))) {
                                    cls = x.class;
                                    synchronized (cls) {
                                        if (x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).getAuthRequestContext(a4)) {
                                            if (x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).MyBillsEntityDataFactory(a4) < 10) {
                                                x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).KClassImpl$Data$declaredNonStaticMembers$2(a4);
                                                ag.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).getAuthRequestContext(true, a4);
                                            } else {
                                                x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory(a4);
                                            }
                                        }
                                    }
                                }
                                x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory(a4);
                            }
                        } else if (df.EnablePushMessage.f104a.equalsIgnoreCase(dmVar.f189d)) {
                            if (dmVar.f182a == 0) {
                                cls = x.class;
                                synchronized (cls) {
                                    if (x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).getAuthRequestContext(a4)) {
                                        x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory(a4);
                                        if ("syncing".equals(x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).MyBillsEntityDataFactory(am.ENABLE_PUSH))) {
                                            x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).getAuthRequestContext(am.ENABLE_PUSH, "synced");
                                        }
                                    }
                                }
                            } else {
                                if ("syncing".equals(x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).MyBillsEntityDataFactory(am.ENABLE_PUSH))) {
                                    cls = x.class;
                                    synchronized (cls) {
                                        if (x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).getAuthRequestContext(a4)) {
                                            if (x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).MyBillsEntityDataFactory(a4) < 10) {
                                                x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).KClassImpl$Data$declaredNonStaticMembers$2(a4);
                                                ag.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).getAuthRequestContext(false, a4);
                                            } else {
                                                x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory(a4);
                                            }
                                        }
                                    }
                                }
                                x.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory(a4);
                            }
                        } else if (df.ThirdPartyRegUpdate.f104a.equalsIgnoreCase(dmVar.f189d)) {
                            BuiltInFictitiousFunctionClassFactory(dmVar);
                        }
                    } else if (KClassImpl$Data$declaredNonStaticMembers$22 instanceof dt) {
                        dt dtVar = (dt) KClassImpl$Data$declaredNonStaticMembers$22;
                        if ("registration id expired".equalsIgnoreCase(dtVar.f246d)) {
                            List<String> moveToNextValue2 = MiPushClient.moveToNextValue(this.BuiltInFictitiousFunctionClassFactory);
                            List<String> NetworkUserEntityData$$ExternalSyntheticLambda02 = MiPushClient.NetworkUserEntityData$$ExternalSyntheticLambda0(this.BuiltInFictitiousFunctionClassFactory);
                            List<String> lookAheadTest = MiPushClient.lookAheadTest(this.BuiltInFictitiousFunctionClassFactory);
                            String scheduleImpl = MiPushClient.scheduleImpl(this.BuiltInFictitiousFunctionClassFactory);
                            StringBuilder sb9 = new StringBuilder();
                            sb9.append("resp-type:");
                            sb9.append(dtVar.f246d);
                            sb9.append(", ");
                            sb9.append(dtVar.m323a());
                            com.xiaomi.channel.commonutils.logger.b.moveToNextValue(sb9.toString());
                            MiPushClient.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, dj.RegIdExpired);
                            for (String str12 : moveToNextValue2) {
                                MiPushClient.lookAheadTest(this.BuiltInFictitiousFunctionClassFactory, str12);
                                MiPushClient.scheduleImpl(this.BuiltInFictitiousFunctionClassFactory, str12);
                            }
                            for (String str13 : NetworkUserEntityData$$ExternalSyntheticLambda02) {
                                MiPushClient.getErrorConfigVersion(this.BuiltInFictitiousFunctionClassFactory, str13);
                                MiPushClient.moveToNextValue(this.BuiltInFictitiousFunctionClassFactory, str13);
                            }
                            for (String str14 : lookAheadTest) {
                                MiPushClient.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, str14);
                                MiPushClient.NetworkUserEntityData$$ExternalSyntheticLambda0(this.BuiltInFictitiousFunctionClassFactory, str14);
                            }
                            String[] split = scheduleImpl.split(",");
                            if (split.length == 2) {
                                MiPushClient.NetworkUserEntityData$$ExternalSyntheticLambda2(this.BuiltInFictitiousFunctionClassFactory);
                                MiPushClient.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, split[0], split[1]);
                            }
                        } else if (!df.ClientInfoUpdateOk.f104a.equalsIgnoreCase(dtVar.f246d)) {
                            try {
                                if (df.NormalClientConfigUpdate.f104a.equalsIgnoreCase(dtVar.f246d)) {
                                    ds dsVar = new ds();
                                    ee.BuiltInFictitiousFunctionClassFactory(dsVar, dtVar.m329a());
                                    au.getAuthRequestContext(at.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), dsVar);
                                } else if (df.CustomClientConfigUpdate.f104a.equalsIgnoreCase(dtVar.f246d)) {
                                    dr drVar = new dr();
                                    ee.BuiltInFictitiousFunctionClassFactory(drVar, dtVar.m329a());
                                    au.KClassImpl$Data$declaredNonStaticMembers$2(at.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), drVar);
                                } else if (df.SyncInfoResult.f104a.equalsIgnoreCase(dtVar.f246d)) {
                                    an.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, dtVar);
                                } else if (df.CancelPushMessage.f104a.equals(dtVar.f246d)) {
                                    StringBuilder sb10 = new StringBuilder();
                                    sb10.append("resp-type:");
                                    sb10.append(dtVar.f246d);
                                    sb10.append(", ");
                                    sb10.append(dtVar.m323a());
                                    com.xiaomi.channel.commonutils.logger.b.moveToNextValue(sb10.toString());
                                    if (dtVar.m324a() != null) {
                                        int i2 = -2;
                                        if (dtVar.m324a().containsKey(bd.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                                            String str15 = dtVar.m324a().get(bd.NetworkUserEntityData$$ExternalSyntheticLambda1);
                                            if (!TextUtils.isEmpty(str15)) {
                                                try {
                                                    i2 = Integer.parseInt(str15);
                                                } catch (NumberFormatException unused2) {
                                                }
                                            }
                                        }
                                        if (i2 >= -1) {
                                            MiPushClient.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, i2);
                                        } else {
                                            MiPushClient.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, dtVar.m324a().containsKey(bd.DatabaseTableConfigUtil) ? dtVar.m324a().get(bd.DatabaseTableConfigUtil) : "", dtVar.m324a().containsKey(bd.initRecordTimeStamp) ? dtVar.m324a().get(bd.initRecordTimeStamp) : "");
                                        }
                                    }
                                    KClassImpl$Data$declaredNonStaticMembers$2(dtVar);
                                } else {
                                    try {
                                        if (df.HybridRegisterResult.f104a.equals(dtVar.f246d)) {
                                            dv dvVar2 = new dv();
                                            ee.BuiltInFictitiousFunctionClassFactory(dvVar2, dtVar.m329a());
                                            MiPushClient4Hybrid.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, dvVar2);
                                        } else if (df.HybridUnregisterResult.f104a.equals(dtVar.f246d)) {
                                            eb ebVar = new eb();
                                            ee.BuiltInFictitiousFunctionClassFactory(ebVar, dtVar.m329a());
                                            MiPushClient4Hybrid.BuiltInFictitiousFunctionClassFactory(ebVar);
                                        } else if (com.xiaomi.push.service.i.getAuthRequestContext(dtVar)) {
                                            com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory("receive notification handle by cpra");
                                        }
                                    } catch (ej e) {
                                        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
                                    }
                                }
                            } catch (ej unused3) {
                            }
                        } else if (dtVar.m324a() != null) {
                            Map<String, String> m324a = dtVar.m324a();
                            Object[] objArr3 = new Object[1];
                            a(TextUtils.getOffsetBefore("", 0), MotionEvent.axisFromString("") + 12, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16), objArr3);
                            if (m324a.containsKey(((String) objArr3[0]).intern())) {
                                Map<String, String> m324a2 = dtVar.m324a();
                                Object[] objArr4 = new Object[1];
                                a(ExpandableListView.getPackedPositionType(0L), 11 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (Process.getGidForName("") + 1), objArr4);
                                String str16 = m324a2.get(((String) objArr4[0]).intern());
                                a PlaceComponentResult3 = a.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory);
                                SharedPreferences.Editor edit2 = a.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult3.getAuthRequestContext).edit();
                                edit2.putString("vName", str16);
                                edit2.commit();
                                PlaceComponentResult3.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = str16;
                            }
                        }
                    }
                    return miPushMessage;
                default:
                    return miPushMessage;
            }
        } catch (o e2) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e2);
            getAuthRequestContext(dqVar);
            n.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, dqVar, z);
            return null;
        } catch (ej e3) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e3);
            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2("receive a message which action string is not valid. is the reg expired?");
            n.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, dqVar, z);
            return null;
        }
    }

    private void getAuthRequestContext(dq dqVar) {
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("receive a message but decrypt failed. report now.");
        dt dtVar = new dt(dqVar.m308a().f137a, false);
        dtVar.c(df.DecryptMessageFail.f104a);
        dtVar.b(dqVar.m309a());
        dtVar.d(dqVar.f229b);
        dtVar.f241a = new HashMap();
        dtVar.f241a.put("regid", MiPushClient.initRecordTimeStamp(this.BuiltInFictitiousFunctionClassFactory));
        ag BuiltInFictitiousFunctionClassFactory = ag.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(dtVar, cz.Notification, false, true, null, true, BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName(), a.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, true);
        int i = moveToNextValue + 13;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if (i % 2 != 0) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(dt dtVar) {
        dm dmVar = new dm();
        dmVar.c(df.CancelPushMessageACK.f104a);
        dmVar.a(dtVar.m323a());
        dmVar.a(dtVar.a());
        dmVar.b(dtVar.b());
        dmVar.e(dtVar.c());
        dmVar.a(0L);
        dmVar.d("success clear push message.");
        ag.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory(dmVar, cz.Notification, false, true, null, false, this.BuiltInFictitiousFunctionClassFactory.getPackageName(), a.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, false);
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 123;
        moveToNextValue = i % 128;
        if ((i % 2 != 0 ? 'V' : '\'') != 'V') {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(dx dxVar, dq dqVar) {
        int i = moveToNextValue + 59;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        di m308a = dqVar.m308a();
        Object[] objArr = null;
        if ((m308a != null ? (char) 5 : 'Y') != 'Y') {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 89;
            moveToNextValue = i3 % 128;
            if (i3 % 2 != 0) {
                m308a = bj.PlaceComponentResult(m308a.m276a());
                objArr.hashCode();
            } else {
                m308a = bj.PlaceComponentResult(m308a.m276a());
            }
        }
        di diVar = m308a;
        dl dlVar = new dl();
        dlVar.b(dxVar.b());
        dlVar.a(dxVar.m345a());
        dlVar.a(dxVar.a().a());
        if (!TextUtils.isEmpty(dxVar.c())) {
            dlVar.c(dxVar.c());
        }
        if (!TextUtils.isEmpty(dxVar.d())) {
            dlVar.d(dxVar.d());
        }
        try {
            try {
                dlVar.a(ee.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, dqVar));
                ag BuiltInFictitiousFunctionClassFactory = ag.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory);
                BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(dlVar, cz.AckMessage, !r7.equals(cz.Registration), true, diVar, true, BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName(), a.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, true);
                int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 121;
                moveToNextValue = i4 % 128;
                if (i4 % 2 != 0) {
                    int length = objArr.length;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0026, code lost:
    
        if ((r0 != null ? '2' : ':') != '2') goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x002f, code lost:
    
        if (r0 != null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0031, code lost:
    
        r0 = com.xiaomi.push.service.bj.PlaceComponentResult(r0.m276a());
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0039, code lost:
    
        r6 = r0;
        r2 = new com.xiaomi.push.dl();
        r2.b(r12.m309a());
        r2.a(r6.m277a());
        r2.a(r6.m275a());
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x005c, code lost:
    
        if (android.text.TextUtils.isEmpty(r6.m282b()) != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x005e, code lost:
    
        r2.c(r6.m282b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0065, code lost:
    
        r0 = com.xiaomi.mipush.sdk.ae.moveToNextValue + 31;
        com.xiaomi.mipush.sdk.ae.NetworkUserEntityData$$ExternalSyntheticLambda0 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0070, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0071, code lost:
    
        throw r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0072, code lost:
    
        r2.a(com.xiaomi.push.ee.getAuthRequestContext(r11.BuiltInFictitiousFunctionClassFactory, r12));
        r1 = com.xiaomi.mipush.sdk.ag.BuiltInFictitiousFunctionClassFactory(r11.BuiltInFictitiousFunctionClassFactory);
        r1.BuiltInFictitiousFunctionClassFactory(r2, com.xiaomi.push.cz.AckMessage, false, true, r6, true, r1.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName(), com.xiaomi.mipush.sdk.a.PlaceComponentResult(r1.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x009a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void BuiltInFictitiousFunctionClassFactory(com.xiaomi.push.dq r12) {
        /*
            r11 = this;
            int r0 = com.xiaomi.mipush.sdk.ae.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> L9b
            int r0 = r0 + 115
            int r1 = r0 % 128
            com.xiaomi.mipush.sdk.ae.moveToNextValue = r1     // Catch: java.lang.Exception -> L9b
            int r0 = r0 % 2
            r1 = 84
            if (r0 == 0) goto L11
            r0 = 49
            goto L13
        L11:
            r0 = 84
        L13:
            if (r0 == r1) goto L2b
            com.xiaomi.push.di r0 = r12.m308a()
            r1 = 28
            int r1 = r1 / 0
            r1 = 50
            if (r0 == 0) goto L24
            r2 = 50
            goto L26
        L24:
            r2 = 58
        L26:
            if (r2 == r1) goto L31
            goto L39
        L29:
            r12 = move-exception
            throw r12
        L2b:
            com.xiaomi.push.di r0 = r12.m308a()     // Catch: java.lang.Exception -> L9b
            if (r0 == 0) goto L39
        L31:
            com.xiaomi.push.di r0 = r0.m276a()
            com.xiaomi.push.di r0 = com.xiaomi.push.service.bj.PlaceComponentResult(r0)
        L39:
            r6 = r0
            com.xiaomi.push.dl r2 = new com.xiaomi.push.dl
            r2.<init>()
            java.lang.String r0 = r12.m309a()
            r2.b(r0)
            java.lang.String r0 = r6.m277a()
            r2.a(r0)
            long r0 = r6.m275a()
            r2.a(r0)
            java.lang.String r0 = r6.m282b()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L72
            java.lang.String r0 = r6.m282b()     // Catch: java.lang.Exception -> L70
            r2.c(r0)     // Catch: java.lang.Exception -> L70
            int r0 = com.xiaomi.mipush.sdk.ae.moveToNextValue
            int r0 = r0 + 31
            int r1 = r0 % 128
            com.xiaomi.mipush.sdk.ae.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1
            int r0 = r0 % 2
            goto L72
        L70:
            r12 = move-exception
            throw r12
        L72:
            android.content.Context r0 = r11.BuiltInFictitiousFunctionClassFactory
            short r12 = com.xiaomi.push.ee.getAuthRequestContext(r0, r12)
            r2.a(r12)
            android.content.Context r12 = r11.BuiltInFictitiousFunctionClassFactory
            com.xiaomi.mipush.sdk.ag r1 = com.xiaomi.mipush.sdk.ag.BuiltInFictitiousFunctionClassFactory(r12)
            com.xiaomi.push.cz r3 = com.xiaomi.push.cz.AckMessage
            android.content.Context r12 = r1.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String r8 = r12.getPackageName()
            android.content.Context r12 = r1.KClassImpl$Data$declaredNonStaticMembers$2
            com.xiaomi.mipush.sdk.a r12 = com.xiaomi.mipush.sdk.a.PlaceComponentResult(r12)
            com.xiaomi.mipush.sdk.a$a r12 = r12.BuiltInFictitiousFunctionClassFactory
            java.lang.String r9 = r12.MyBillsEntityDataFactory
            r4 = 0
            r5 = 1
            r7 = 1
            r10 = 1
            r1.BuiltInFictitiousFunctionClassFactory(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        L9b:
            r12 = move-exception
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.ae.BuiltInFictitiousFunctionClassFactory(com.xiaomi.push.dq):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:243:0x0084, code lost:
    
        if (r1.getAuthRequestContext() == false) goto L253;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x0093, code lost:
    
        if ((!r1.getAuthRequestContext()) != false) goto L253;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x0095, code lost:
    
        if (r7 != false) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x0097, code lost:
    
        r14.a("mrt", r3);
        r14.a("mat", java.lang.Long.toString(java.lang.System.currentTimeMillis()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x00ab, code lost:
    
        if (PlaceComponentResult(r13) != false) goto L258;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x00ad, code lost:
    
        r2 = com.xiaomi.mipush.sdk.ae.moveToNextValue + 117;
        com.xiaomi.mipush.sdk.ae.NetworkUserEntityData$$ExternalSyntheticLambda0 = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x00b6, code lost:
    
        BuiltInFictitiousFunctionClassFactory(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x00ba, code lost:
    
        com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory("this is a mina's message, ack later");
        r14.a("__hybrid_message_ts", java.lang.String.valueOf(r14.m275a()));
        r14.a("__hybrid_device_status", java.lang.String.valueOf((int) com.xiaomi.push.ee.getAuthRequestContext(r18.BuiltInFictitiousFunctionClassFactory, r13)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x00ff, code lost:
    
        if (com.xiaomi.push.service.ag.PlaceComponentResult(r13) != false) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x0109, code lost:
    
        if (com.xiaomi.push.service.ag.PlaceComponentResult(r13) != false) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x010b, code lost:
    
        r0 = new java.lang.Object[2];
        r0[0] = r13.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x0115, code lost:
    
        if (r14 == null) goto L279;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x0117, code lost:
    
        r15 = 'D';
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x0119, code lost:
    
        if (r15 == 'D') goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x011c, code lost:
    
        r9 = r14.m277a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x0120, code lost:
    
        r0[1] = r9;
        r0 = java.lang.String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x0129, code lost:
    
        r0 = new java.lang.Object[2];
        r0[0] = r13.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x0131, code lost:
    
        if (r14 == null) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x0133, code lost:
    
        r9 = r14.m277a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x0139, code lost:
    
        r1 = com.xiaomi.mipush.sdk.ae.moveToNextValue + 11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x013d, code lost:
    
        com.xiaomi.mipush.sdk.ae.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x013f, code lost:
    
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x0141, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x0143, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x0144, code lost:
    
        r0[1] = r9;
        r0 = java.lang.String.format("drop an un-encrypted messages. %1$s, %2$s", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x0193, code lost:
    
        if (r2 != null) goto L325;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.xiaomi.mipush.sdk.PushMessageHandler.a PlaceComponentResult(android.content.Intent r19) {
        /*
            Method dump skipped, instructions count: 879
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.ae.PlaceComponentResult(android.content.Intent):com.xiaomi.mipush.sdk.PushMessageHandler$a");
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if (whenavailable.BuiltInFictitiousFunctionClassFactory >= i2) {
                break;
            }
            int i3 = $10 + 35;
            $11 = i3 % 128;
            int i4 = i3 % 2;
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (PlaceComponentResult[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ getErrorConfigVersion))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        char[] cArr = new char[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i2) {
            try {
                int i5 = $10 + 17;
                $11 = i5 % 128;
                if (!(i5 % 2 == 0)) {
                    cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                    whenavailable.BuiltInFictitiousFunctionClassFactory++;
                } else {
                    cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                    whenavailable.BuiltInFictitiousFunctionClassFactory >>>= 1;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        String str = new String(cArr);
        int i6 = $10 + 41;
        $11 = i6 % 128;
        int i7 = i6 % 2;
        objArr[0] = str;
    }
}

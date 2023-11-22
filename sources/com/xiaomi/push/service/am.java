package com.xiaomi.push.service;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.push.di;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes8.dex */
public class am {
    private static final boolean KClassImpl$Data$declaredNonStaticMembers$2 = Log.isLoggable("NCHelper", 3);

    private static NotificationChannel BuiltInFictitiousFunctionClassFactory(String str, NotificationChannel notificationChannel) {
        NotificationChannel notificationChannel2 = new NotificationChannel(str, notificationChannel.getName(), notificationChannel.getImportance());
        notificationChannel2.setDescription(notificationChannel.getDescription());
        notificationChannel2.enableVibration(notificationChannel.shouldVibrate());
        notificationChannel2.enableLights(notificationChannel.shouldShowLights());
        notificationChannel2.setSound(notificationChannel.getSound(), notificationChannel.getAudioAttributes());
        notificationChannel2.setLockscreenVisibility(notificationChannel.getLockscreenVisibility());
        return notificationChannel2;
    }

    public static void MyBillsEntityDataFactory(di diVar) {
        if (diVar == null || diVar.f139a == null || !diVar.f139a.containsKey("REMOVE_CHANNEL_MARK")) {
            return;
        }
        diVar.f135a = 0;
        diVar.f139a.remove("channel_id");
        diVar.f139a.remove("channel_importance");
        diVar.f139a.remove("channel_name");
        diVar.f139a.remove("channel_description");
        diVar.f139a.remove("channel_perm");
        StringBuilder sb = new StringBuilder();
        sb.append("delete channel info by:");
        sb.append(diVar.f139a.get("REMOVE_CHANNEL_MARK"));
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        diVar.f139a.remove("REMOVE_CHANNEL_MARK");
    }

    private static int KClassImpl$Data$declaredNonStaticMembers$2(NotificationChannel notificationChannel) {
        int i = 0;
        try {
            i = ((Integer) com.xiaomi.push.z.MyBillsEntityDataFactory(notificationChannel, "getUserLockedFields", new Object[0])).intValue();
            if (KClassImpl$Data$declaredNonStaticMembers$2) {
                StringBuilder sb = new StringBuilder();
                sb.append("isUserLockedChannel:");
                sb.append(i);
                sb.append(" ");
                sb.append(notificationChannel);
                com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory("NCHelper", sb.toString());
            }
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("is user locked error");
            sb2.append(e);
            com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory("NCHelper", sb2.toString());
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x02e8  */
    /* JADX WARN: Type inference failed for: r14v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String PlaceComponentResult(com.xiaomi.push.service.aq r17, java.lang.String r18, java.lang.CharSequence r19, java.lang.String r20, int r21, int r22, java.lang.String r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 779
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.am.PlaceComponentResult(com.xiaomi.push.service.aq, java.lang.String, java.lang.CharSequence, java.lang.String, int, int, java.lang.String, java.lang.String):java.lang.String");
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str) {
        if (!com.xiaomi.channel.commonutils.android.f.PlaceComponentResult(context) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            aq PlaceComponentResult = aq.PlaceComponentResult(context, str);
            Set<String> keySet = context.getSharedPreferences("mipush_channel_copy_sp", 0).getAll().keySet();
            ArrayList arrayList = new ArrayList();
            for (String str2 : keySet) {
                if (PlaceComponentResult.PlaceComponentResult(str2)) {
                    arrayList.add(str2);
                    if (KClassImpl$Data$declaredNonStaticMembers$2) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("delete channel copy record:");
                        sb.append(str2);
                        com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory("NCHelper", sb.toString());
                    }
                }
            }
            if (KClassImpl$Data$declaredNonStaticMembers$2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("deleteCopiedChannelRecord:");
                sb2.append(arrayList);
                com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory("NCHelper", sb2.toString());
            }
            if (!arrayList.isEmpty()) {
                SharedPreferences.Editor edit = context.getSharedPreferences("mipush_channel_copy_sp", 0).edit();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    edit.remove((String) it.next());
                }
                edit.apply();
            }
        } catch (Exception unused) {
        }
        e.PlaceComponentResult(context, str);
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(NotificationChannel notificationChannel, NotificationChannel notificationChannel2) {
        boolean z;
        if (notificationChannel2 != null) {
            boolean z2 = true;
            if (TextUtils.equals(notificationChannel.getName(), notificationChannel2.getName())) {
                z = false;
            } else {
                if (KClassImpl$Data$declaredNonStaticMembers$2) {
                    com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory("NCHelper", "appHack channelConfigLowerCompare:getName");
                }
                z = true;
            }
            if (!TextUtils.equals(notificationChannel.getDescription(), notificationChannel2.getDescription())) {
                if (KClassImpl$Data$declaredNonStaticMembers$2) {
                    com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory("NCHelper", "appHack channelConfigLowerCompare:getDescription");
                }
                z = true;
            }
            if (notificationChannel.getImportance() != notificationChannel2.getImportance()) {
                notificationChannel.setImportance(Math.min(notificationChannel.getImportance(), notificationChannel2.getImportance()));
                if (KClassImpl$Data$declaredNonStaticMembers$2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("appHack channelConfigLowerCompare:getImportance  ");
                    sb.append(notificationChannel.getImportance());
                    sb.append(" ");
                    sb.append(notificationChannel2.getImportance());
                    com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory("NCHelper", sb.toString());
                }
                z = true;
            }
            if (notificationChannel.shouldVibrate() != notificationChannel2.shouldVibrate()) {
                notificationChannel.enableVibration(false);
                if (KClassImpl$Data$declaredNonStaticMembers$2) {
                    com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory("NCHelper", "appHack channelConfigLowerCompare:enableVibration");
                }
                z = true;
            }
            if (notificationChannel.shouldShowLights() != notificationChannel2.shouldShowLights()) {
                notificationChannel.enableLights(false);
                if (KClassImpl$Data$declaredNonStaticMembers$2) {
                    com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory("NCHelper", "appHack channelConfigLowerCompare:enableLights");
                }
                z = true;
            }
            if ((notificationChannel.getSound() != null) != (notificationChannel2.getSound() != null)) {
                notificationChannel.setSound(null, null);
                if (KClassImpl$Data$declaredNonStaticMembers$2) {
                    com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory("NCHelper", "appHack channelConfigLowerCompare:setSound");
                }
            } else {
                z2 = z;
            }
            if (KClassImpl$Data$declaredNonStaticMembers$2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("appHack channelConfigLowerCompare:isDifferent:");
                sb2.append(z2);
                com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory("NCHelper", sb2.toString());
            }
            return z2;
        }
        return false;
    }

    private static boolean MyBillsEntityDataFactory(Context context, String str) {
        if (KClassImpl$Data$declaredNonStaticMembers$2) {
            StringBuilder sb = new StringBuilder();
            sb.append("checkCopeidChannel:newFullChannelId:");
            sb.append(str);
            sb.append("  ");
            sb.append(context.getSharedPreferences("mipush_channel_copy_sp", 0).getBoolean(str, false));
            com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory("NCHelper", sb.toString());
        }
        return context.getSharedPreferences("mipush_channel_copy_sp", 0).getBoolean(str, false);
    }
}

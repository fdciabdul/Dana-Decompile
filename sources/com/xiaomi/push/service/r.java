package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: classes8.dex */
public class r {
    private static a KClassImpl$Data$declaredNonStaticMembers$2;
    private static q PlaceComponentResult;

    /* loaded from: classes8.dex */
    public interface a {
        void MyBillsEntityDataFactory();
    }

    public static q KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        synchronized (r.class) {
            q qVar = PlaceComponentResult;
            if (qVar != null) {
                return qVar;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
            String string = sharedPreferences.getString("uuid", null);
            String string2 = sharedPreferences.getString("token", null);
            String string3 = sharedPreferences.getString("security", null);
            String string4 = sharedPreferences.getString("app_id", null);
            String string5 = sharedPreferences.getString("app_token", null);
            String string6 = sharedPreferences.getString("package_name", null);
            String string7 = sharedPreferences.getString("device_id", null);
            int i = sharedPreferences.getInt("env_type", 1);
            if (!TextUtils.isEmpty(string7) && com.xiaomi.channel.commonutils.android.c.PlaceComponentResult(string7)) {
                string7 = com.xiaomi.channel.commonutils.android.c.moveToNextValue(context);
                sharedPreferences.edit().putString("device_id", string7).commit();
            }
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                return null;
            }
            String moveToNextValue = com.xiaomi.channel.commonutils.android.c.moveToNextValue(context);
            if (!"com.xiaomi.xmsf".equals(context.getPackageName()) && !TextUtils.isEmpty(moveToNextValue) && !TextUtils.isEmpty(string7) && !string7.equals(moveToNextValue)) {
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("read_phone_state permission changes.");
            }
            q qVar2 = new q(string, string2, string3, string4, string5, string6, i);
            PlaceComponentResult = qVar2;
            return qVar2;
        }
    }

    public static void MyBillsEntityDataFactory(a aVar) {
        KClassImpl$Data$declaredNonStaticMembers$2 = aVar;
    }

    private static boolean PlaceComponentResult(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(36:3|4|(1:119)(1:10)|11|(1:13)|14|(1:16)(1:118)|17|(1:19)(1:117)|20|(1:22)(1:116)|23|24|25|(1:27)(1:112)|28|(1:30)|31|(6:34|35|36|38|39|32)|43|44|(14:49|50|(1:52)(1:110)|53|(1:55)(2:97|(1:99)(2:100|(1:102)(2:103|(1:105)(2:106|(1:108)(1:109)))))|56|(1:58)|59|60|(2:64|(3:66|67|(7:69|(1:71)|72|(1:74)|75|76|77)(1:79)))|(1:89)|90|91|92)|111|50|(0)(0)|53|(0)(0)|56|(0)|59|60|(3:62|64|(0))|(2:87|89)|90|91|92) */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x0216, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x0218, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append("device registration request failed. ");
        r0.append(r0);
        com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(r0.toString());
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0193 A[Catch: all -> 0x038d, TryCatch #4 {, blocks: (B:136:0x0005, B:138:0x0019, B:140:0x0021, B:142:0x002e, B:144:0x003a, B:146:0x0044, B:147:0x0049, B:151:0x0055, B:155:0x0061, B:159:0x006d, B:160:0x0077, B:165:0x0089, B:168:0x0092, B:170:0x00d2, B:171:0x00db, B:172:0x00e8, B:174:0x00ee, B:175:0x00f5, B:178:0x0104, B:179:0x0135, B:181:0x015e, B:184:0x0165, B:186:0x017e, B:190:0x018d, B:192:0x0193, B:206:0x0204, B:209:0x0211, B:213:0x0218, B:215:0x022f, B:217:0x0235, B:236:0x033c, B:237:0x0349, B:239:0x035c, B:238:0x034e, B:241:0x0361, B:243:0x0367, B:244:0x0386, B:193:0x01a5, B:195:0x01b1, B:196:0x01b9, B:198:0x01c5, B:199:0x01cd, B:201:0x01d9, B:202:0x01e1, B:204:0x01ed, B:205:0x01f5, B:163:0x0083, B:219:0x023d, B:221:0x024a, B:223:0x0268, B:224:0x027e, B:226:0x02e7, B:227:0x02ea, B:230:0x0314), top: B:256:0x0005, inners: #0, #1, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x01a5 A[Catch: all -> 0x038d, TryCatch #4 {, blocks: (B:136:0x0005, B:138:0x0019, B:140:0x0021, B:142:0x002e, B:144:0x003a, B:146:0x0044, B:147:0x0049, B:151:0x0055, B:155:0x0061, B:159:0x006d, B:160:0x0077, B:165:0x0089, B:168:0x0092, B:170:0x00d2, B:171:0x00db, B:172:0x00e8, B:174:0x00ee, B:175:0x00f5, B:178:0x0104, B:179:0x0135, B:181:0x015e, B:184:0x0165, B:186:0x017e, B:190:0x018d, B:192:0x0193, B:206:0x0204, B:209:0x0211, B:213:0x0218, B:215:0x022f, B:217:0x0235, B:236:0x033c, B:237:0x0349, B:239:0x035c, B:238:0x034e, B:241:0x0361, B:243:0x0367, B:244:0x0386, B:193:0x01a5, B:195:0x01b1, B:196:0x01b9, B:198:0x01c5, B:199:0x01cd, B:201:0x01d9, B:202:0x01e1, B:204:0x01ed, B:205:0x01f5, B:163:0x0083, B:219:0x023d, B:221:0x024a, B:223:0x0268, B:224:0x027e, B:226:0x02e7, B:227:0x02ea, B:230:0x0314), top: B:256:0x0005, inners: #0, #1, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0361 A[Catch: all -> 0x038d, TryCatch #4 {, blocks: (B:136:0x0005, B:138:0x0019, B:140:0x0021, B:142:0x002e, B:144:0x003a, B:146:0x0044, B:147:0x0049, B:151:0x0055, B:155:0x0061, B:159:0x006d, B:160:0x0077, B:165:0x0089, B:168:0x0092, B:170:0x00d2, B:171:0x00db, B:172:0x00e8, B:174:0x00ee, B:175:0x00f5, B:178:0x0104, B:179:0x0135, B:181:0x015e, B:184:0x0165, B:186:0x017e, B:190:0x018d, B:192:0x0193, B:206:0x0204, B:209:0x0211, B:213:0x0218, B:215:0x022f, B:217:0x0235, B:236:0x033c, B:237:0x0349, B:239:0x035c, B:238:0x034e, B:241:0x0361, B:243:0x0367, B:244:0x0386, B:193:0x01a5, B:195:0x01b1, B:196:0x01b9, B:198:0x01c5, B:199:0x01cd, B:201:0x01d9, B:202:0x01e1, B:204:0x01ed, B:205:0x01f5, B:163:0x0083, B:219:0x023d, B:221:0x024a, B:223:0x0268, B:224:0x027e, B:226:0x02e7, B:227:0x02ea, B:230:0x0314), top: B:256:0x0005, inners: #0, #1, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x023d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.xiaomi.push.service.q MyBillsEntityDataFactory(android.content.Context r17, java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 914
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.r.MyBillsEntityDataFactory(android.content.Context, java.lang.String, java.lang.String, java.lang.String):com.xiaomi.push.service.q");
    }

    public static void MyBillsEntityDataFactory(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        PlaceComponentResult = null;
        a aVar = KClassImpl$Data$declaredNonStaticMembers$2;
        if (aVar != null) {
            aVar.MyBillsEntityDataFactory();
        }
    }
}

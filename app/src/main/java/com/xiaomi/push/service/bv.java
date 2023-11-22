package com.xiaomi.push.service;

import android.content.Context;
import android.util.Log;
import com.xiaomi.push.df;
import com.xiaomi.push.dt;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public class bv implements XMPushService.n {
    private static Context KClassImpl$Data$declaredNonStaticMembers$2;
    private static final boolean getAuthRequestContext = Log.isLoggable("UNDatas", 3);
    private static final Map<Integer, Map<String, List<String>>> PlaceComponentResult = new HashMap();

    public bv(Context context) {
        KClassImpl$Data$declaredNonStaticMembers$2 = context;
    }

    @Override // com.xiaomi.push.service.XMPushService.n
    public final void MyBillsEntityDataFactory() {
        Map<Integer, Map<String, List<String>>> map = PlaceComponentResult;
        if (map.size() > 0) {
            synchronized (map) {
                HashMap hashMap = new HashMap();
                hashMap.putAll(PlaceComponentResult);
                if (hashMap.size() > 0) {
                    for (Integer num : hashMap.keySet()) {
                        Map map2 = (Map) hashMap.get(num);
                        if (map2 != null && map2.size() > 0) {
                            StringBuilder sb = new StringBuilder();
                            Iterator it = map2.keySet().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                String str = (String) it.next();
                                sb.append(str);
                                sb.append(":");
                                List list = (List) map2.get(str);
                                if (!com.xiaomi.channel.commonutils.android.k.BuiltInFictitiousFunctionClassFactory(list)) {
                                    for (int i = 0; i < list.size(); i++) {
                                        if (i != 0) {
                                            sb.append(",");
                                        }
                                        sb.append((String) list.get(i));
                                    }
                                }
                                sb.append(";");
                            }
                            String MyBillsEntityDataFactory = aw.MyBillsEntityDataFactory();
                            String str2 = df.NotificationRemoved.f104a;
                            dt dtVar = new dt();
                            if (str2 != null) {
                                dtVar.c(str2);
                            }
                            if (MyBillsEntityDataFactory != null) {
                                dtVar.a(MyBillsEntityDataFactory);
                            }
                            dtVar.a(false);
                            dtVar.a("removed_reason", String.valueOf(num));
                            dtVar.a("all_delete_msgId_appId", sb.toString());
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("UNDatas upload all removed messages reason: ");
                            sb2.append(num);
                            sb2.append(" allIds: ");
                            sb2.append(sb.toString());
                            com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory(sb2.toString());
                            Context context = KClassImpl$Data$declaredNonStaticMembers$2;
                            if (getAuthRequestContext) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("UNDatas upload message notification:");
                                sb3.append(dtVar);
                                com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory(sb3.toString());
                            }
                            com.xiaomi.push.o PlaceComponentResult2 = com.xiaomi.push.o.PlaceComponentResult(context);
                            PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory.schedule(new bw(dtVar), 0L, TimeUnit.SECONDS);
                        }
                        PlaceComponentResult.remove(num);
                    }
                }
            }
        }
    }
}

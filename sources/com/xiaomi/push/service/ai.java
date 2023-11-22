package com.xiaomi.push.service;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/* loaded from: classes8.dex */
public class ai {
    private static Object BuiltInFictitiousFunctionClassFactory = new Object();
    private static Map<String, Queue<String>> PlaceComponentResult = new HashMap();

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(XMPushService xMPushService, String str, String str2) {
        synchronized (BuiltInFictitiousFunctionClassFactory) {
            SharedPreferences sharedPreferences = xMPushService.getSharedPreferences("push_message_ids", 0);
            Queue<String> queue = PlaceComponentResult.get(str);
            if (queue == null) {
                String[] split = sharedPreferences.getString(str, "").split(",");
                LinkedList linkedList = new LinkedList();
                for (String str3 : split) {
                    linkedList.add(str3);
                }
                PlaceComponentResult.put(str, linkedList);
                queue = linkedList;
            }
            if (queue.contains(str2)) {
                return true;
            }
            queue.add(str2);
            if (queue.size() > 25) {
                queue.poll();
            }
            String PlaceComponentResult2 = com.xiaomi.push.ad.PlaceComponentResult(queue, ",");
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, PlaceComponentResult2);
            edit.commit();
            return false;
        }
    }
}

package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.dt;

/* loaded from: classes8.dex */
public class i {
    private static a BuiltInFictitiousFunctionClassFactory;
    private static b getAuthRequestContext;

    /* loaded from: classes8.dex */
    public interface a {
        boolean getAuthRequestContext();
    }

    /* loaded from: classes8.dex */
    public interface b {
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(b bVar) {
        getAuthRequestContext = bVar;
    }

    public static boolean getAuthRequestContext(dt dtVar) {
        String str;
        Context context;
        if (BuiltInFictitiousFunctionClassFactory == null || dtVar == null) {
            str = "rc params is null, not cpra";
        } else {
            context = com.xiaomi.channel.commonutils.android.j.BuiltInFictitiousFunctionClassFactory;
            if (com.xiaomi.channel.commonutils.android.f.PlaceComponentResult(context)) {
                return BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
            }
            str = "rc app not permission to cpra";
        }
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(str);
        return false;
    }
}

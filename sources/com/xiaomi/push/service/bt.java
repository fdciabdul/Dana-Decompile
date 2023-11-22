package com.xiaomi.push.service;

import com.xiaomi.push.cz;
import com.xiaomi.push.dl;
import com.xiaomi.push.dm;
import com.xiaomi.push.dp;
import com.xiaomi.push.dq;
import com.xiaomi.push.dt;
import com.xiaomi.push.dv;
import com.xiaomi.push.dw;
import com.xiaomi.push.dx;
import com.xiaomi.push.dz;
import com.xiaomi.push.eb;
import com.xiaomi.push.ed;
import com.xiaomi.push.ee;
import com.xiaomi.push.ef;

/* loaded from: classes8.dex */
public class bt {
    public static ef BuiltInFictitiousFunctionClassFactory(dq dqVar) {
        dp dpVar = null;
        if (dqVar.m316b()) {
            return null;
        }
        byte[] m314a = dqVar.m314a();
        cz a2 = dqVar.a();
        boolean z = dqVar.f230b;
        switch (bu.getAuthRequestContext[a2.ordinal()]) {
            case 1:
                dpVar = new dv();
                break;
            case 2:
                dpVar = new eb();
                break;
            case 3:
                dpVar = new dz();
                break;
            case 4:
                dpVar = new ed();
                break;
            case 5:
                dpVar = new dx();
                break;
            case 6:
                dpVar = new dl();
                break;
            case 7:
                dpVar = new dp();
                break;
            case 8:
                dpVar = new dw();
                break;
            case 9:
                if (!z) {
                    dm dmVar = new dm();
                    dmVar.a(true);
                    dpVar = dmVar;
                    break;
                } else {
                    dpVar = new dt();
                    break;
                }
            case 10:
                dpVar = new dp();
                break;
        }
        if (dpVar != null) {
            ee.BuiltInFictitiousFunctionClassFactory(dpVar, m314a);
        }
        return dpVar;
    }
}

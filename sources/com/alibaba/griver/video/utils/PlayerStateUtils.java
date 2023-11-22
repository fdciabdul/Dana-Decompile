package com.alibaba.griver.video.utils;

import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.video.base.PlayerState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class PlayerStateUtils {

    /* renamed from: a  reason: collision with root package name */
    private Map<Integer, List<Integer>> f6786a = new HashMap();
    private volatile int b;

    public PlayerStateUtils(int i) {
        this.b = i;
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(-1);
        arrayList.add(4);
        this.f6786a.put(0, arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(2);
        arrayList2.add(-1);
        arrayList2.add(4);
        this.f6786a.put(1, arrayList2);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(3);
        arrayList3.add(-1);
        arrayList3.add(4);
        this.f6786a.put(2, arrayList3);
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(2);
        arrayList4.add(-1);
        arrayList4.add(4);
        this.f6786a.put(3, arrayList4);
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(4);
        arrayList5.add(1);
        this.f6786a.put(-1, arrayList5);
        ArrayList arrayList6 = new ArrayList();
        arrayList6.add(1);
        arrayList6.add(2);
        this.f6786a.put(4, arrayList6);
    }

    public int getState() {
        return this.b;
    }

    public boolean switchState(int i) {
        int i2 = this.b;
        StringBuilder sb = new StringBuilder();
        sb.append("switchState, oldState=");
        sb.append(PlayerState.state2String(i2));
        sb.append(", newState=");
        sb.append(PlayerState.state2String(i));
        GriverLogger.w("PlayerStateUtils", sb.toString());
        if (i2 == i) {
            GriverLogger.e("PlayerStateUtils", "switchState, switch failed for state not changed");
            return false;
        } else if (!this.f6786a.containsKey(Integer.valueOf(i2))) {
            GriverLogger.e("PlayerStateUtils", "switchState, switch failed for no state in status-map");
            return false;
        } else {
            List<Integer> list = this.f6786a.get(Integer.valueOf(i2));
            if (list != null && list.contains(Integer.valueOf(i))) {
                this.b = i;
                return true;
            }
            GriverLogger.e("PlayerStateUtils", "switchState, switch failed for default");
            return false;
        }
    }
}

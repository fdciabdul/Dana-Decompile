package com.huawei.agconnect.core.a;

import com.huawei.agconnect.AGCInitFinishManager;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes7.dex */
public class a extends AGCInitFinishManager {
    private static final List<AGCInitFinishManager.AGCInitFinishCallback> MyBillsEntityDataFactory = new CopyOnWriteArrayList();

    public static void PlaceComponentResult() {
        for (AGCInitFinishManager.AGCInitFinishCallback aGCInitFinishCallback : MyBillsEntityDataFactory) {
        }
    }
}

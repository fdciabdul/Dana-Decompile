package com.iap.ac.android.biz.b;

import com.iap.ac.android.acs.operation.biz.region.RegionManager;
import com.iap.ac.android.acs.plugin.biz.region.stageinfo.FetchLaunchableGroupsCallback;
import com.iap.ac.android.acs.plugin.biz.region.stageinfo.repository.outter.LaunchableGroup;
import com.iap.ac.android.biz.IAPConnect;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.biz.internal.ACFactory;
import com.iap.ac.android.biz.internal.IOperationManager;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class d implements IOperationManager {

    /* renamed from: a  reason: collision with root package name */
    public static volatile IOperationManager f7542a;

    public static IOperationManager a() {
        if (f7542a == null) {
            synchronized (IAPConnect.class) {
                if (f7542a == null) {
                    f7542a = ACFactory.createIAPOperationManager();
                }
            }
        }
        return f7542a;
    }

    @Override // com.iap.ac.android.biz.internal.IOperationManager
    public void fetchLaunchableGroupsWithCodes(List<String> list, FetchLaunchableGroupsCallback<Map<String, LaunchableGroup>> fetchLaunchableGroupsCallback) {
        if (Utils.checkClassExist(Constants.PACKAGE_NAME_REGION_MANAGER)) {
            RegionManager.getInstance().fetchLaunchableGroupsWithCodes(list, fetchLaunchableGroupsCallback);
        }
    }
}

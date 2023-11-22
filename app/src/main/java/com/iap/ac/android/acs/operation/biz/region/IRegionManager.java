package com.iap.ac.android.acs.operation.biz.region;

import android.content.Context;
import com.iap.ac.android.acs.plugin.biz.region.stageinfo.FetchLaunchableGroupsCallback;
import com.iap.ac.android.acs.plugin.biz.region.stageinfo.repository.outter.LaunchableGroup;
import com.iap.ac.android.biz.common.model.InitConfig;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public interface IRegionManager {
    void fetchLaunchableGroupsWithCodes(List<String> list, FetchLaunchableGroupsCallback<Map<String, LaunchableGroup>> fetchLaunchableGroupsCallback);

    Context getContext();

    InitConfig getInitConfig();

    void initRegion(Context context, InitConfig initConfig);

    boolean isRegionMiniProgram(String str, String str2);

    void logout();
}

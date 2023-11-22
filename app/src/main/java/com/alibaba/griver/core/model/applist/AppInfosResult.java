package com.alibaba.griver.core.model.applist;

import com.alibaba.griver.base.common.rpc.BaseGriverRpcResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class AppInfosResult extends BaseGriverRpcResult implements Serializable {
    private List<AppInfo> appInfos;
    private boolean hasMore;
    private int totalCount;

    public AppInfosResult(int i, List<AppInfo> list) {
        this.totalCount = i;
        this.appInfos = list;
    }

    public AppInfosResult() {
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public List<AppInfo> getAppInfos() {
        return this.appInfos;
    }

    public void setAppInfos(List<AppInfo> list) {
        this.appInfos = list;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public static AppInfosResult convertAppInfos(FetchAppListResult fetchAppListResult) {
        ArrayList arrayList = new ArrayList();
        if (fetchAppListResult.getExceedAppIdList() != null) {
            Iterator<DeployAppInfo> it = fetchAppListResult.getAppInfoList().iterator();
            while (it.hasNext()) {
                arrayList.add(AppInfo.convertAppInfo(it.next()));
            }
        }
        AppInfosResult appInfosResult = new AppInfosResult(fetchAppListResult.getTotalCount(), arrayList);
        appInfosResult.success = fetchAppListResult.success;
        appInfosResult.errorCode = fetchAppListResult.errorCode;
        appInfosResult.errorMessage = fetchAppListResult.errorMessage;
        appInfosResult.extendInfo = fetchAppListResult.extendInfo;
        return appInfosResult;
    }
}

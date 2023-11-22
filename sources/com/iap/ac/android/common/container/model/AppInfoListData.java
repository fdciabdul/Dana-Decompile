package com.iap.ac.android.common.container.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class AppInfoListData implements Serializable {
    public List<AppInfoData> appInfoList;
    public String errorCode;
    public String errorMessage;
    public List<String> exceedAppIdList;
    public int totalCount;
    public boolean success = false;
    public Map<String, String> extendInfo = new HashMap();

    public List<AppInfoData> getAppInfoList() {
        return this.appInfoList;
    }

    public List<String> getExceedAppIdList() {
        return this.exceedAppIdList;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setAppInfoList(List<AppInfoData> list) {
        this.appInfoList = list;
    }

    public void setExceedAppIdList(List<String> list) {
        this.exceedAppIdList = list;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }
}

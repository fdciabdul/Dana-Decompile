package com.iap.ac.android.container.adapter.griver;

import android.text.TextUtils;
import com.alibaba.griver.core.model.applist.AppCategory;
import com.alibaba.griver.core.model.applist.AppInfo;
import com.alibaba.griver.core.model.applist.AppInfosResult;
import com.iap.ac.android.common.container.model.AppInfoData;
import com.iap.ac.android.common.container.model.AppInfoListData;
import com.iap.ac.android.common.container.model.CategoryInfoData;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class DataProcessor {
    /* JADX INFO: Access modifiers changed from: protected */
    public static AppInfoListData convertAppListResult(AppInfosResult appInfosResult) {
        if (appInfosResult == null) {
            return null;
        }
        AppInfoListData appInfoListData = new AppInfoListData();
        appInfoListData.errorCode = appInfosResult.errorCode;
        appInfoListData.errorMessage = appInfosResult.errorMessage;
        appInfoListData.success = appInfosResult.success;
        appInfoListData.setTotalCount(appInfosResult.getTotalCount());
        List<AppInfo> appInfos = appInfosResult.getAppInfos();
        if (appInfos != null && appInfos.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (AppInfo appInfo : appInfos) {
                if (appInfo != null && !TextUtils.isEmpty(appInfo.getIdentifier())) {
                    AppInfoData appInfoData = new AppInfoData();
                    appInfoData.setAppDesc(appInfo.getIntroduction());
                    appInfoData.setAppId(appInfo.getIdentifier());
                    appInfoData.setAppName(appInfo.getName());
                    appInfoData.setAppSlogan(appInfo.getSlogan());
                    appInfoData.setDeployVersion(appInfo.getReleaseVersion());
                    appInfoData.setIconUrl(appInfo.getIconURL());
                    List<AppCategory> categories = appInfo.getCategories();
                    if (categories != null && categories.size() != 0) {
                        ArrayList arrayList2 = new ArrayList();
                        for (AppCategory appCategory : categories) {
                            if (appCategory != null) {
                                CategoryInfoData categoryInfoData = new CategoryInfoData();
                                categoryInfoData.setCategory(appCategory.getName());
                                categoryInfoData.setCategoryId(appCategory.getIdentifier());
                                arrayList2.add(categoryInfoData);
                            }
                        }
                        appInfoData.setCategoryInfos(arrayList2);
                    }
                    arrayList.add(appInfoData);
                }
            }
            appInfoListData.setAppInfoList(arrayList);
        }
        return appInfoListData;
    }
}

package com.alibaba.ariver.resource.api.proxy;

import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import java.util.List;

/* loaded from: classes3.dex */
public interface RVAppInfoManager extends Proxiable {
    String findUrlMappedAppId(String str);

    AppInfoModel getAppInfoModel(AppInfoQuery appInfoQuery);

    AppModel getAppModel(AppInfoQuery appInfoQuery);

    String getAppType(AppModel appModel);

    long getLastUpdateTime(String str);

    void refreshUpdateTime(String str, long j);

    void saveAppModelList(List<AppModel> list);
}

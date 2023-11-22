package com.alibaba.ariver.integration.proxy.impl;

import com.alibaba.ariver.ariverexthub.api.constant.RVEConstant;
import com.alibaba.ariver.ariverexthub.api.instance.RVEExtraHandlerCenter;
import com.alibaba.ariver.engine.api.proxy.RVEFilterCenterProxy;
import com.alibaba.ariver.integration.proxy.filter.RVEFileApiExtraFilter;
import com.alibaba.ariver.integration.proxy.filter.RVENetworkApiExtraFilter;
import com.alibaba.ariver.integration.proxy.filter.RVEStorageApiExtraFilter;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.PermissionConstant;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class RVEFilterCenterProxyImpl implements RVEFilterCenterProxy {
    @Override // com.alibaba.ariver.engine.api.proxy.RVEFilterCenterProxy
    public boolean initFilters() {
        RVLogger.d("RVEApi: RVEFilterCenterProxyImpl", "initFilters");
        HashMap hashMap = new HashMap();
        hashMap.put(Arrays.asList("saveFile", "getFileInfo", "getSavedFileInfo", "removeSavedFile", "getSavedFileList", "fsManage"), new RVEFileApiExtraFilter());
        hashMap.put(Arrays.asList("setAPDataStorage", "getAPDataStorage", "removeAPDataStorage", "clearAPDataStorage", ""), new RVEStorageApiExtraFilter());
        hashMap.put(Arrays.asList(PermissionConstant.UPLOAD_FILE, "downloadFile", "mtop", "getMtopToken"), new RVENetworkApiExtraFilter());
        RVEExtraHandlerCenter.getInstance().registerFilters(RVEConstant.RVEHost.ARIVER_HOST, hashMap);
        return true;
    }
}

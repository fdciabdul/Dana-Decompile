package com.iap.ac.android.acs.operation.biz.region.menu.repository;

import com.iap.ac.android.acs.operation.biz.region.bean.HeartBeatRequest;
import com.iap.ac.android.acs.operation.biz.region.bean.HeartBeatResult;
import com.iap.ac.android.acs.operation.biz.region.bean.MenuExtraInfoVO;
import com.iap.ac.android.acs.operation.biz.region.bean.UploadRecentlyUsedVO;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RPCProxyHost;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class HeartBeatRepository {
    public static final String FETCH_MENU_EXTRA_INFO = "FETCH_MENU_EXTRA_INFO";
    public static final String TAG = "FetchMenuExtraInfoRepository";
    public static final String UPLOAD_RECENTLY_USED = "UPLOAD_RECENTLY_USED";

    public HeartBeatResult heartBeat(String str, Map<String, String> map, List<String> list) {
        try {
            RegionMenuFacade regionMenuFacade = (RegionMenuFacade) RPCProxyHost.getInterfaceProxy(RegionMenuFacade.class, "region_biz");
            HeartBeatRequest heartBeatRequest = new HeartBeatRequest();
            heartBeatRequest.appId = str;
            heartBeatRequest.actionTypeList = new ArrayList();
            heartBeatRequest.actionTypeList.add(UPLOAD_RECENTLY_USED);
            heartBeatRequest.actionTypeList.add(FETCH_MENU_EXTRA_INFO);
            heartBeatRequest.uploadRecentlyUsedVO = new UploadRecentlyUsedVO();
            heartBeatRequest.uploadRecentlyUsedVO.startupParams = map;
            heartBeatRequest.menuExtraInfoVO = new MenuExtraInfoVO();
            heartBeatRequest.menuExtraInfoVO.menuIds = list;
            return regionMenuFacade.heartBeat(heartBeatRequest);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("fetchMenuExtraInfo error:");
            sb.append(th);
            ACLog.e("FetchMenuExtraInfoRepository", sb.toString());
            return null;
        }
    }
}

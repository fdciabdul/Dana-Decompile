package com.iap.ac.android.acs.operation.biz.region.menu.repository;

import android.os.Bundle;
import com.iap.ac.android.acs.operation.biz.region.FacadeRepository;
import com.iap.ac.android.acs.operation.biz.region.bean.RemoveFavoriteRequest;
import com.iap.ac.android.acs.operation.biz.region.bean.RemoveFavoriteResult;
import com.iap.ac.android.common.container.callback.Callback;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RPCProxyHost;

/* loaded from: classes3.dex */
public class RemoveFavoriteRepository extends FacadeRepository {
    public static final String TAG = "FetchMenuExtraInfoRepository";

    public RemoveFavoriteRepository() {
    }

    public RemoveFavoriteResult removeFavorite(String str) {
        try {
            RegionMenuFacade regionMenuFacade = (RegionMenuFacade) RPCProxyHost.getInterfaceProxy(RegionMenuFacade.class, "region_biz");
            RemoveFavoriteRequest removeFavoriteRequest = new RemoveFavoriteRequest();
            removeFavoriteRequest.appId = str;
            return regionMenuFacade.removeFavorite(removeFavoriteRequest);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("removeFavorite error:");
            sb.append(th);
            ACLog.e("FetchMenuExtraInfoRepository", sb.toString());
            handleException(th);
            return null;
        }
    }

    public RemoveFavoriteRepository(Callback<Bundle> callback) {
        this.callback = callback;
    }
}

package com.iap.ac.android.acs.operation.biz.region.menu.repository;

import android.os.Bundle;
import com.iap.ac.android.acs.operation.biz.region.FacadeRepository;
import com.iap.ac.android.acs.operation.biz.region.bean.AddFavoriteRequest;
import com.iap.ac.android.acs.operation.biz.region.bean.AddFavoriteResult;
import com.iap.ac.android.common.container.callback.Callback;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RPCProxyHost;

/* loaded from: classes3.dex */
public class AddFavoriteRepository extends FacadeRepository {
    public static final String TAG = "AddFavoriteRepository";

    public AddFavoriteRepository() {
    }

    public AddFavoriteResult addFavorite(String str) {
        try {
            RegionMenuFacade regionMenuFacade = (RegionMenuFacade) RPCProxyHost.getInterfaceProxy(RegionMenuFacade.class, "region_biz");
            AddFavoriteRequest addFavoriteRequest = new AddFavoriteRequest();
            addFavoriteRequest.appId = str;
            return regionMenuFacade.addFavorite(addFavoriteRequest);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("AddFavorite error:");
            sb.append(th);
            ACLog.e(TAG, sb.toString());
            handleException(th);
            return null;
        }
    }

    public AddFavoriteRepository(Callback<Bundle> callback) {
        this.callback = callback;
    }
}

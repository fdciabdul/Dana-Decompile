package com.iap.ac.android.acs.operation.biz.region.menu.repository;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.iap.ac.android.acs.operation.biz.region.bean.AddFavoriteRequest;
import com.iap.ac.android.acs.operation.biz.region.bean.AddFavoriteResult;
import com.iap.ac.android.acs.operation.biz.region.bean.HeartBeatRequest;
import com.iap.ac.android.acs.operation.biz.region.bean.HeartBeatResult;
import com.iap.ac.android.acs.operation.biz.region.bean.RemoveFavoriteRequest;
import com.iap.ac.android.acs.operation.biz.region.bean.RemoveFavoriteResult;
import com.iap.ac.android.biz.common.rpc.annotation.ACRpcRequest;

/* loaded from: classes3.dex */
public interface RegionMenuFacade {
    public static final String OPERATION_TYPE_ADD_FAVORITE = "eco.region.client.favorite.addFavorite";
    public static final String OPERATION_TYPE_HEART_BEAT = "eco.region.client.miniprogram.heartbeat";
    public static final String OPERATION_TYPE_REMOVE_FAVORITE = "eco.region.client.favorite.removeFavorite";

    @ACRpcRequest
    @OperationType(OPERATION_TYPE_ADD_FAVORITE)
    @SignCheck
    AddFavoriteResult addFavorite(AddFavoriteRequest addFavoriteRequest);

    @ACRpcRequest
    @OperationType(OPERATION_TYPE_HEART_BEAT)
    @SignCheck
    HeartBeatResult heartBeat(HeartBeatRequest heartBeatRequest);

    @ACRpcRequest
    @OperationType(OPERATION_TYPE_REMOVE_FAVORITE)
    @SignCheck
    RemoveFavoriteResult removeFavorite(RemoveFavoriteRequest removeFavoriteRequest);
}

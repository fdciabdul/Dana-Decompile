package com.alibaba.griver.core.model.applist;

import android.text.TextUtils;
import com.alibaba.griver.base.common.account.GriverAccount;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.rpc.BaseGriverRpcRequest;
import com.alibaba.griver.core.vo.FetchAppRequestVO;

/* loaded from: classes3.dex */
public class FetchAppsRequest extends BaseGriverRpcRequest {
    private static final String TAG = "FetchAppsRequest";
    private String category;
    private String orderKey;
    private String orderType;
    private int querySize;
    private int queryStartIndex;
    private String relatedEnv;
    private String userId;

    public FetchAppsRequest(FetchAppRequestVO fetchAppRequestVO) {
        if (fetchAppRequestVO != null) {
            this.queryStartIndex = fetchAppRequestVO.getQueryStartIndex();
            this.querySize = fetchAppRequestVO.getQuerySize();
            this.orderKey = fetchAppRequestVO.getSortDescriptor();
            this.orderType = fetchAppRequestVO.getAscending().booleanValue() ? "ASC" : "DESC";
            this.relatedEnv = fetchAppRequestVO.getRelatedEnv();
            this.userId = fetchAppRequestVO.getUserId();
            this.category = fetchAppRequestVO.getCategory();
        }
    }

    public FetchAppsRequest(int i, int i2) {
        this.queryStartIndex = i;
        this.querySize = i2;
        if (!TextUtils.isEmpty(GriverEnv.getEnvironment())) {
            setRelatedEnv(GriverEnv.getEnvironment());
        }
        try {
            setUserId(GriverAccount.getUserId());
        } catch (Exception e) {
            GriverLogger.e(TAG, "get usedId failed", e);
        }
    }

    public int getQueryStartIndex() {
        return this.queryStartIndex;
    }

    public void setQueryStartIndex(int i) {
        this.queryStartIndex = i;
    }

    public int getQuerySize() {
        return this.querySize;
    }

    public void setQuerySize(int i) {
        this.querySize = i;
    }

    public String getRelatedEnv() {
        return this.relatedEnv;
    }

    public void setRelatedEnv(String str) {
        this.relatedEnv = str;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getOrderKey() {
        return this.orderKey;
    }

    public void setOrderKey(String str) {
        this.orderKey = str;
    }

    public String getOrderType() {
        return this.orderType;
    }

    public void setOrderType(String str) {
        this.orderType = str;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }
}

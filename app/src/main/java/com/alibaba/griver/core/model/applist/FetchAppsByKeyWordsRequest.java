package com.alibaba.griver.core.model.applist;

import android.text.TextUtils;
import com.alibaba.griver.base.common.account.GriverAccount;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.rpc.BaseGriverRpcRequest;

/* loaded from: classes2.dex */
public class FetchAppsByKeyWordsRequest extends BaseGriverRpcRequest {
    private static final String TAG = "FetchAppsByKeyWordsRequest";
    private String category;
    private String keyword;
    private int querySize;
    private int queryStartIndex;
    private String relatedEnv;
    private String userId;

    public FetchAppsByKeyWordsRequest(String str, int i, int i2, String str2) {
        this.keyword = str;
        this.queryStartIndex = i;
        this.querySize = i2;
        this.category = str2;
        if (!TextUtils.isEmpty(GriverEnv.getEnvironment())) {
            setRelatedEnv(GriverEnv.getEnvironment());
        }
        try {
            setUserId(GriverAccount.getUserId());
        } catch (Exception e) {
            GriverLogger.e(TAG, "get usedId failed", e);
        }
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public void setKeyword(String str) {
        this.keyword = str;
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
}

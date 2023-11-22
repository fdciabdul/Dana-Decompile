package com.alipay.plus.android.config.sdk.retry;

import com.alibaba.fastjson.JSON;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes7.dex */
public class DistributionNodesConfig implements Serializable {
    public long configVersion;
    public List<DistributionNode> distributionNodes;

    public DistributionNodesConfig() {
    }

    public DistributionNodesConfig(long j, List<DistributionNode> list) {
        this.configVersion = j;
        this.distributionNodes = list;
    }

    public String toString() {
        return JSON.toJSONString(this);
    }
}

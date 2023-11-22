package com.alipay.plus.android.config.sdk.retry;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.alipay.plus.android.config.sdk.utils.ConfigUtils;
import java.io.Serializable;

/* loaded from: classes7.dex */
public class DistributionNode implements Serializable {
    public String configName;
    public JSONObject extras;
    public Integer rate;
    public a type;
    public String url;

    /* loaded from: classes7.dex */
    public enum a {
        GRAYSCALE,
        MDS,
        ALICLOUD;

        public static boolean isRpcNode(a aVar) {
            if (aVar == null) {
                return false;
            }
            return aVar == MDS || aVar == GRAYSCALE;
        }
    }

    public DistributionNode() {
    }

    public DistributionNode(a aVar, String str, String str2, Integer num) {
        this.type = aVar;
        this.url = str;
        this.configName = str2;
        this.rate = num;
    }

    public boolean isSameNode(DistributionNode distributionNode) {
        if (this == distributionNode) {
            return true;
        }
        return TextUtils.equals(this.url, distributionNode.url) && TextUtils.equals(this.configName, distributionNode.configName);
    }

    public String toString() {
        return ConfigUtils.toJSONString(this);
    }
}

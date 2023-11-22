package id.dana.cashier.data.repository.source.network;

import com.google.gson.annotations.SerializedName;
import id.dana.cashier.data.repository.source.network.result.ConfigCashierResult;
import id.dana.network.base.BaseResultResponse;

/* loaded from: classes4.dex */
public class BaseCashierResponse<T> implements BaseResultResponse<T> {
    @SerializedName("config")
    ConfigCashierResult config;
    @SerializedName("memo")
    String memo;
    @SerializedName("result")
    T result;
    @SerializedName("resultStatus")
    String resultStatus;

    public String getMemo() {
        return this.memo;
    }

    public String getResultStatus() {
        return this.resultStatus;
    }

    public ConfigCashierResult getConfig() {
        return this.config;
    }

    @Override // id.dana.network.base.BaseResultResponse
    public T getResult() {
        return this.result;
    }
}

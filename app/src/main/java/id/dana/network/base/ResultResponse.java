package id.dana.network.base;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class ResultResponse<T> extends BaseApiResponse implements BaseResultResponse<T> {
    @SerializedName("result")
    T result;

    @Override // id.dana.network.base.BaseResultResponse
    public T getResult() {
        return this.result;
    }
}

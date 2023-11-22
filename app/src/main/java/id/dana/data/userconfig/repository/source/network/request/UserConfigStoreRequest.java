package id.dana.data.userconfig.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;

/* loaded from: classes4.dex */
public class UserConfigStoreRequest extends BaseRpcRequest {
    private final String bizType;
    private final String content;

    public UserConfigStoreRequest(String str, String str2) {
        this.bizType = str;
        this.content = str2;
    }

    public String getBizType() {
        return this.bizType;
    }

    public String getContent() {
        return this.content;
    }
}

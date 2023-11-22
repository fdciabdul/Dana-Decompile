package id.dana.data.security.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class GetPublicKeyRpcRequest extends BaseRpcRequest implements Serializable {
    private String publicKeyScene;

    public GetPublicKeyRpcRequest(String str) {
        this.publicKeyScene = str;
    }

    public String getPublicKeyScene() {
        return this.publicKeyScene;
    }
}

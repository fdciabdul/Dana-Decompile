package id.dana.data.qrbarcode.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class DecodeQrRequest extends BaseRpcRequest implements Serializable {
    public String qrCode;
    public String scene;
}

package id.dana.data.qrbarcode.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import java.util.List;

/* loaded from: classes4.dex */
public class GenerateQrResult extends BaseRpcResult {
    public String qrCode;
    public List<QrDetail> qrCodeList;
}

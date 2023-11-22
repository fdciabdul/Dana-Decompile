package id.dana.domain.qrbarcode;

import id.dana.utils.rpc.response.BaseRpcResponse;
import java.util.List;

/* loaded from: classes4.dex */
public class QrUserResult extends BaseRpcResponse {
    private String qrCode;
    private List<String> qrCodeList;

    public String getQrCode() {
        return this.qrCode;
    }

    public void setQrCode(String str) {
        this.qrCode = str;
    }

    public List<String> getQrCodeList() {
        return this.qrCodeList;
    }

    public void setQrCodeList(List<String> list) {
        this.qrCodeList = list;
    }
}

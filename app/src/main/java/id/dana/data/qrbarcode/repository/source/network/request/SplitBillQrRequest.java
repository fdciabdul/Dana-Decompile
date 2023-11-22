package id.dana.data.qrbarcode.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes4.dex */
public class SplitBillQrRequest extends BaseRpcRequest implements Serializable {
    public String comment;
    public List<SplitBillPayerEntity> splitBillPayers;
}

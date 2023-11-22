package id.dana.data.splitbill.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.util.List;

/* loaded from: classes4.dex */
public class GetSplitBillCloseRequest extends BaseRpcRequest {
    public List<String> closePayers;
    public String splitBillId;
}

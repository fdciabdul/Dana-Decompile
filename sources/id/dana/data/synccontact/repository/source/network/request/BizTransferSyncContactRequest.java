package id.dana.data.synccontact.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.domain.sendmoney.model.UserContact;
import java.util.List;

/* loaded from: classes4.dex */
public class BizTransferSyncContactRequest extends BaseRpcRequest {
    public List<String> phoneNumbers;
    public List<UserContact> phoneNumbersWithName;
}

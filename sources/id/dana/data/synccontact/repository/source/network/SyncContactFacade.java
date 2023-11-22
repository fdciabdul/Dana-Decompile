package id.dana.data.synccontact.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.synccontact.repository.source.network.request.BizTransferSyncContactRequest;
import id.dana.data.synccontact.repository.source.network.result.BizTransferSyncContactResult;

/* loaded from: classes4.dex */
public interface SyncContactFacade {
    @OperationType("alipayplus.mobilewallet.biztransfer.contact.sync")
    @SignCheck
    BizTransferSyncContactResult bizSyncContact(BizTransferSyncContactRequest bizTransferSyncContactRequest);
}

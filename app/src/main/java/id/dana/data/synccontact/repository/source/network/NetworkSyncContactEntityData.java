package id.dana.data.synccontact.repository.source.network;

import android.content.Context;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.synccontact.SyncContactEntityData;
import id.dana.data.synccontact.model.ContactEntity;
import id.dana.data.synccontact.repository.source.network.request.BizTransferSyncContactRequest;
import id.dana.data.synccontact.repository.source.network.result.BizTransferSyncContactResult;
import id.dana.domain.sendmoney.model.UserContact;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class NetworkSyncContactEntityData extends SecureBaseNetwork<SyncContactFacade> implements SyncContactEntityData {
    @Inject
    public NetworkSyncContactEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<SyncContactFacade> getFacadeClass() {
        return SyncContactFacade.class;
    }

    @Override // id.dana.data.synccontact.SyncContactEntityData
    public Observable<BizTransferSyncContactResult> syncContact(List<String> list, List<UserContact> list2) {
        final BizTransferSyncContactRequest bizTransferSyncContactRequest = new BizTransferSyncContactRequest();
        bizTransferSyncContactRequest.phoneNumbers = list;
        bizTransferSyncContactRequest.phoneNumbersWithName = list2;
        bizTransferSyncContactRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.synccontact.repository.source.network.NetworkSyncContactEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                BizTransferSyncContactResult bizSyncContact;
                bizSyncContact = ((SyncContactFacade) obj).bizSyncContact(BizTransferSyncContactRequest.this);
                return bizSyncContact;
            }
        });
    }

    @Override // id.dana.data.synccontact.SyncContactEntityData
    public Observable<Boolean> isSyncProcessCompleted() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.synccontact.SyncContactEntityData
    public Observable<Boolean> saveSyncProcessStatusComplete() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.synccontact.SyncContactEntityData
    public Observable<ContactEntity> getLastSyncedContact() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.synccontact.SyncContactEntityData
    public Observable<Boolean> saveLastSyncedContact(ContactEntity contactEntity) {
        throw new UnsupportedOperationException();
    }
}

package com.iap.ac.android.mpm.oauth.collectioncode.source;

import com.iap.ac.android.biz.common.base.BaseNetwork;
import com.iap.ac.android.mpm.base.model.oauth.request.PrepareCollectionCodeAuthRequest;
import com.iap.ac.android.mpm.base.model.oauth.result.PrepareCollectionCodeAuthResult;

/* loaded from: classes3.dex */
public class CollectionCodeAuthEntityData extends BaseNetwork<CollectionCodeAuthFacade> {
    @Override // com.iap.ac.android.biz.common.base.BaseNetwork
    public Class<CollectionCodeAuthFacade> getFacadeClass() {
        return CollectionCodeAuthFacade.class;
    }

    public PrepareCollectionCodeAuthResult prepare(String str, String str2) throws Exception {
        final PrepareCollectionCodeAuthRequest prepareCollectionCodeAuthRequest = new PrepareCollectionCodeAuthRequest();
        prepareCollectionCodeAuthRequest.acquirerAuthUrl = str;
        prepareCollectionCodeAuthRequest.acquirerId = str2;
        return (PrepareCollectionCodeAuthResult) wrapper(new BaseNetwork.FacadeProcessor<CollectionCodeAuthFacade, PrepareCollectionCodeAuthResult>() { // from class: com.iap.ac.android.mpm.oauth.collectioncode.source.CollectionCodeAuthEntityData.1
            @Override // com.iap.ac.android.biz.common.base.BaseNetwork.FacadeProcessor
            public PrepareCollectionCodeAuthResult processFacade(CollectionCodeAuthFacade collectionCodeAuthFacade) {
                return ((CollectionCodeAuthFacade) CollectionCodeAuthEntityData.this.getFacade()).prepare(prepareCollectionCodeAuthRequest);
            }
        });
    }
}

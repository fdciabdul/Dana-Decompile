package id.dana.data.synccontact.repository;

import id.dana.data.config.source.amcs.result.ContactSyncConfigResult;
import id.dana.data.synccontact.mapper.ContactSyncConfigMapper;
import io.reactivex.functions.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class SyncContactEntityRepository$$ExternalSyntheticLambda3 implements Function {
    public final /* synthetic */ ContactSyncConfigMapper f$0;

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return this.f$0.apply((ContactSyncConfigResult) obj);
    }
}

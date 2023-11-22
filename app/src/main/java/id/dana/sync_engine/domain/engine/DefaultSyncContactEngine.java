package id.dana.sync_engine.domain.engine;

import id.dana.sync_engine.domain.engine.SyncContactEngine;
import id.dana.sync_engine.domain.model.SyncContactEngineState;
import id.dana.sync_engine.domain.model.SyncForFeature;
import id.dana.sync_engine.domain.model.UserContact;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lid/dana/sync_engine/domain/engine/DefaultSyncContactEngine;", "", "syncContact", "Lio/reactivex/Observable;", "", "Lid/dana/sync_engine/domain/model/UserContact;", "syncContactEngineState", "Lid/dana/sync_engine/domain/model/SyncContactEngineState;", "syncForFeature", "Lid/dana/sync_engine/domain/model/SyncForFeature;", "enableSyncSocialContact", "", "subscriptionKey", "Lid/dana/sync_engine/domain/engine/SyncContactEngine$SubscriptionKey;", "sync-engine_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface DefaultSyncContactEngine {
    Observable<List<UserContact>> MyBillsEntityDataFactory(SyncContactEngineState syncContactEngineState, SyncForFeature syncForFeature, boolean z, SyncContactEngine.SubscriptionKey subscriptionKey);

    /* renamed from: id.dana.sync_engine.domain.engine.DefaultSyncContactEngine$-CC */
    /* loaded from: classes5.dex */
    public final /* synthetic */ class CC {
    }
}

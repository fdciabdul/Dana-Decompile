package id.dana.sync_engine.data.source.local;

import id.dana.sync_engine.data.entity.SyncContactType;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/* loaded from: classes5.dex */
public final /* synthetic */ class ContactEntityDataLocal$$ExternalSyntheticLambda3 implements ObservableOnSubscribe {
    public final /* synthetic */ ContactEntityDataLocal MyBillsEntityDataFactory;
    public final /* synthetic */ SyncContactType PlaceComponentResult;

    public /* synthetic */ ContactEntityDataLocal$$ExternalSyntheticLambda3(ContactEntityDataLocal contactEntityDataLocal, SyncContactType syncContactType) {
        this.MyBillsEntityDataFactory = contactEntityDataLocal;
        this.PlaceComponentResult = syncContactType;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter observableEmitter) {
        ContactEntityDataLocal.getAuthRequestContext(this.MyBillsEntityDataFactory, this.PlaceComponentResult, observableEmitter);
    }
}

package id.dana.synccontact.worker.syncallcontact;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.HasAccount;
import id.dana.domain.sendmoney.model.UserContact;
import id.dana.domain.synccontact.interactor.CheckSyncProcessCompleteState;
import id.dana.domain.synccontact.interactor.GetContactSyncConfig;
import id.dana.domain.synccontact.interactor.GetLastSyncedContact;
import id.dana.domain.synccontact.interactor.SaveSyncProcessStatusComplete;
import id.dana.domain.synccontact.interactor.SyncContact;
import id.dana.domain.synccontact.model.Contact;
import id.dana.synccontact.SyncContactUtil;
import id.dana.synccontact.mapper.ContactModelMapper;
import id.dana.synccontact.worker.BaseSyncContactWorker;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.SingleEmitter;
import java.util.List;

/* loaded from: classes2.dex */
public class SyncAllContactWorker extends BaseSyncContactWorker {
    private SaveSyncProcessStatusComplete NetworkUserEntityData$$ExternalSyntheticLambda1;
    private CheckSyncProcessCompleteState moveToNextValue;

    public SyncAllContactWorker(Context context, WorkerParameters workerParameters, ContactModelMapper contactModelMapper, SyncContactUtil syncContactUtil) {
        super(context, workerParameters, contactModelMapper, syncContactUtil);
    }

    @Override // id.dana.synccontact.worker.BaseSyncContactWorker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final SingleEmitter<ListenableWorker.Result> singleEmitter) {
        this.moveToNextValue.executeInBackground(new DefaultObserver<Boolean>() { // from class: id.dana.synccontact.worker.syncallcontact.SyncAllContactWorker.1
            {
                SyncAllContactWorker.this = this;
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                if (((Boolean) obj).booleanValue()) {
                    singleEmitter.onSuccess(ListenableWorker.Result.BuiltInFictitiousFunctionClassFactory());
                } else {
                    SyncAllContactWorker.getAuthRequestContext(SyncAllContactWorker.this, singleEmitter);
                }
            }
        });
    }

    @Override // id.dana.synccontact.worker.BaseSyncContactWorker, androidx.work.RxWorker, androidx.work.ListenableWorker
    public void onStopped() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.dispose();
        this.moveToNextValue.dispose();
        super.onStopped();
    }

    static /* synthetic */ void getAuthRequestContext(SyncAllContactWorker syncAllContactWorker, final SingleEmitter singleEmitter) {
        syncAllContactWorker.PlaceComponentResult.executeInBackground(new DefaultObserver<Contact>() { // from class: id.dana.synccontact.worker.syncallcontact.SyncAllContactWorker.2
            {
                SyncAllContactWorker.this = syncAllContactWorker;
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                SyncAllContactWorker.this.lookAheadTest = (Contact) obj;
                SyncAllContactWorker.KClassImpl$Data$declaredNonStaticMembers$2(SyncAllContactWorker.this, singleEmitter);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                SyncAllContactWorker.KClassImpl$Data$declaredNonStaticMembers$2(SyncAllContactWorker.this, singleEmitter);
            }
        });
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SyncAllContactWorker syncAllContactWorker, final SingleEmitter singleEmitter) {
        List<String> KClassImpl$Data$declaredNonStaticMembers$2 = syncAllContactWorker.KClassImpl$Data$declaredNonStaticMembers$2(syncAllContactWorker.KClassImpl$Data$declaredNonStaticMembers$2());
        List<UserContact> MyBillsEntityDataFactory = syncAllContactWorker.MyBillsEntityDataFactory(syncAllContactWorker.KClassImpl$Data$declaredNonStaticMembers$2());
        if (!KClassImpl$Data$declaredNonStaticMembers$2.isEmpty() && !MyBillsEntityDataFactory.isEmpty()) {
            syncAllContactWorker.scheduleImpl.executeInBackground(new DefaultObserver<Boolean>() { // from class: id.dana.synccontact.worker.syncallcontact.SyncAllContactWorker.3
                {
                    SyncAllContactWorker.this = syncAllContactWorker;
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public /* synthetic */ void onNext(Object obj) {
                    if (!((Boolean) obj).booleanValue()) {
                        singleEmitter.onSuccess(ListenableWorker.Result.getAuthRequestContext());
                        return;
                    }
                    SyncAllContactWorker.this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2(SyncAllContactWorker.this.getApplicationContext(), "sync_all_contact_worker", SyncAllContactWorker.class);
                    singleEmitter.onSuccess(ListenableWorker.Result.BuiltInFictitiousFunctionClassFactory());
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public void onError(Throwable th) {
                    super.onError(th);
                    singleEmitter.onSuccess(ListenableWorker.Result.MyBillsEntityDataFactory());
                    StringBuilder sb = new StringBuilder();
                    sb.append(DanaLogConstants.Prefix.CONTACT_SYNC_PREFIX);
                    sb.append(getClass().getName());
                    DanaLog.BuiltInFictitiousFunctionClassFactory(sb.toString(), DanaLogConstants.ExceptionType.CONTACT_SYNC_EXCEPTION, th.toString());
                }
            }, SyncContact.Params.forSyncContact(KClassImpl$Data$declaredNonStaticMembers$2, syncAllContactWorker.getAuthRequestContext.apply(syncAllContactWorker.getErrorConfigVersion), MyBillsEntityDataFactory));
        } else {
            syncAllContactWorker.NetworkUserEntityData$$ExternalSyntheticLambda1.executeInBackground(new DefaultObserver());
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(GetContactSyncConfig getContactSyncConfig, SyncContact syncContact, GetLastSyncedContact getLastSyncedContact, SaveSyncProcessStatusComplete saveSyncProcessStatusComplete, CheckSyncProcessCompleteState checkSyncProcessCompleteState, HasAccount hasAccount) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getContactSyncConfig;
        this.scheduleImpl = syncContact;
        this.PlaceComponentResult = getLastSyncedContact;
        this.MyBillsEntityDataFactory = hasAccount;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = saveSyncProcessStatusComplete;
        this.moveToNextValue = checkSyncProcessCompleteState;
    }
}

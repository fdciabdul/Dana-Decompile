package id.dana.synccontact.worker;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.RxWorker;
import androidx.work.WorkerParameters;
import id.dana.data.util.NumberUtils;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.HasAccount;
import id.dana.domain.sendmoney.model.UserContact;
import id.dana.domain.synccontact.interactor.GetContactSyncConfig;
import id.dana.domain.synccontact.interactor.GetLastSyncedContact;
import id.dana.domain.synccontact.interactor.SyncContact;
import id.dana.domain.synccontact.model.Contact;
import id.dana.domain.synccontact.model.ContactSyncConfig;
import id.dana.sendmoney.contact.provider.ContactModel;
import id.dana.sendmoney.contact.provider.ContactProvider;
import id.dana.synccontact.SyncContactUtil;
import id.dana.synccontact.mapper.ContactModelMapper;
import id.dana.utils.OSUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.permission.PermissionHelper;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class BaseSyncContactWorker extends RxWorker {
    private static final String moveToNextValue = "BaseSyncContactWorker";
    ContactProvider BuiltInFictitiousFunctionClassFactory;
    public GetContactSyncConfig KClassImpl$Data$declaredNonStaticMembers$2;
    public HasAccount MyBillsEntityDataFactory;
    public final SyncContactUtil NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;
    public GetLastSyncedContact PlaceComponentResult;
    public final ContactModelMapper getAuthRequestContext;
    public ContactModel getErrorConfigVersion;
    public Contact lookAheadTest;
    public SyncContact scheduleImpl;

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(SingleEmitter<ListenableWorker.Result> singleEmitter);

    public BaseSyncContactWorker(Context context, WorkerParameters workerParameters, ContactModelMapper contactModelMapper, SyncContactUtil syncContactUtil) {
        super(context, workerParameters);
        this.getAuthRequestContext = contactModelMapper;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = syncContactUtil;
        this.BuiltInFictitiousFunctionClassFactory = new ContactProvider(context.getContentResolver());
    }

    @Override // androidx.work.RxWorker
    public Single<ListenableWorker.Result> createWork() {
        return Single.MyBillsEntityDataFactory(new SingleOnSubscribe() { // from class: id.dana.synccontact.worker.BaseSyncContactWorker$$ExternalSyntheticLambda0
            @Override // io.reactivex.SingleOnSubscribe
            public final void subscribe(final SingleEmitter singleEmitter) {
                final BaseSyncContactWorker baseSyncContactWorker = BaseSyncContactWorker.this;
                if (baseSyncContactWorker.getAuthRequestContext() || baseSyncContactWorker.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2() || baseSyncContactWorker.getRunAttemptCount() > 3) {
                    singleEmitter.onSuccess(ListenableWorker.Result.getAuthRequestContext());
                }
                baseSyncContactWorker.KClassImpl$Data$declaredNonStaticMembers$2.executeInBackground(new DefaultObserver<ContactSyncConfig>() { // from class: id.dana.synccontact.worker.BaseSyncContactWorker.1
                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public /* synthetic */ void onNext(Object obj) {
                        ContactSyncConfig contactSyncConfig = (ContactSyncConfig) obj;
                        if (contactSyncConfig.isSynchronizeContactEnable()) {
                            baseSyncContactWorker.NetworkUserEntityData$$ExternalSyntheticLambda2 = contactSyncConfig.getMaxContactSyncBatchSize();
                            baseSyncContactWorker.KClassImpl$Data$declaredNonStaticMembers$2(singleEmitter);
                            return;
                        }
                        singleEmitter.onSuccess(ListenableWorker.Result.BuiltInFictitiousFunctionClassFactory());
                    }

                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public void onError(Throwable th) {
                        super.onError(th);
                        String str = BaseSyncContactWorker.moveToNextValue;
                        StringBuilder sb = new StringBuilder();
                        sb.append(DanaLogConstants.Prefix.CONTACT_SYNC_PREFIX);
                        sb.append(getClass().getName());
                        sb.append(":onError");
                        DanaLog.BuiltInFictitiousFunctionClassFactory(str, sb.toString(), th);
                        singleEmitter.onSuccess(ListenableWorker.Result.getAuthRequestContext());
                    }
                });
            }
        });
    }

    public final List<String> KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        ArrayList arrayList = new ArrayList();
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (i > 2) {
            i = 2;
        }
        boolean z = true;
        while (z && !getAuthRequestContext()) {
            List<ContactModel> MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(i, str);
            if (!MyBillsEntityDataFactory.isEmpty()) {
                arrayList.addAll(MyBillsEntityDataFactory);
                ContactModel contactModel = MyBillsEntityDataFactory.get(MyBillsEntityDataFactory.size() - 1);
                if (OSUtil.getAuthRequestContext()) {
                    str = contactModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
                } else {
                    str = contactModel.BuiltInFictitiousFunctionClassFactory;
                }
            }
            if (arrayList.size() >= this.NetworkUserEntityData$$ExternalSyntheticLambda2 || MyBillsEntityDataFactory.isEmpty()) {
                z = false;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (size < i2) {
            i2 = arrayList.size();
        }
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList2.add(NumberUtils.getClearPhoneNumber(((ContactModel) arrayList.get(i3)).getErrorConfigVersion));
            if (i3 == i2 - 1) {
                this.getErrorConfigVersion = (ContactModel) arrayList.get(i3);
            }
        }
        return arrayList2;
    }

    public final List<UserContact> MyBillsEntityDataFactory(String str) {
        ArrayList arrayList = new ArrayList();
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (i > 2) {
            i = 2;
        }
        boolean z = true;
        while (z && !getAuthRequestContext()) {
            List<ContactModel> MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(i, str);
            if (!MyBillsEntityDataFactory.isEmpty()) {
                arrayList.addAll(MyBillsEntityDataFactory);
                ContactModel contactModel = MyBillsEntityDataFactory.get(MyBillsEntityDataFactory.size() - 1);
                if (OSUtil.getAuthRequestContext()) {
                    str = contactModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
                } else {
                    str = contactModel.BuiltInFictitiousFunctionClassFactory;
                }
            }
            if (arrayList.size() >= this.NetworkUserEntityData$$ExternalSyntheticLambda2 || MyBillsEntityDataFactory.isEmpty()) {
                z = false;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int min = Math.min(arrayList.size(), this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        for (int i2 = 0; i2 < min; i2++) {
            ContactModel contactModel2 = (ContactModel) arrayList.get(i2);
            if (!TextUtils.isEmpty(contactModel2.getErrorConfigVersion)) {
                String clearPhoneNumber = NumberUtils.getClearPhoneNumber(contactModel2.getErrorConfigVersion);
                if (clearPhoneNumber == null) {
                    clearPhoneNumber = "";
                }
                arrayList2.add(new UserContact(clearPhoneNumber, contactModel2.KClassImpl$Data$declaredNonStaticMembers$2 != null ? contactModel2.KClassImpl$Data$declaredNonStaticMembers$2 : "", null));
                if (i2 == min - 1) {
                    this.getErrorConfigVersion = contactModel2;
                }
            }
        }
        return arrayList2;
    }

    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest == null ? "" : OSUtil.getAuthRequestContext() ? this.lookAheadTest.getLastUpdatedTime() : this.lookAheadTest.getRawId();
    }

    public final boolean getAuthRequestContext() {
        return !PermissionHelper.MyBillsEntityDataFactory(getApplicationContext(), "android.permission.READ_CONTACTS");
    }

    @Override // androidx.work.RxWorker, androidx.work.ListenableWorker
    public void onStopped() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.scheduleImpl.dispose();
        this.PlaceComponentResult.dispose();
        this.MyBillsEntityDataFactory.dispose();
        super.onStopped();
    }
}

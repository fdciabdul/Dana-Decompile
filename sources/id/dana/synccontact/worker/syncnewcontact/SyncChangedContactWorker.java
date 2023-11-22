package id.dana.synccontact.worker.syncnewcontact;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.domain.DefaultObserver;
import id.dana.domain.sendmoney.model.UserContact;
import id.dana.domain.synccontact.interactor.SyncContact;
import id.dana.domain.synccontact.model.Contact;
import id.dana.synccontact.SyncContactUtil;
import id.dana.synccontact.mapper.ContactModelMapper;
import id.dana.synccontact.worker.BaseSyncContactWorker;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.SingleEmitter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public class SyncChangedContactWorker extends BaseSyncContactWorker {
    private static final String moveToNextValue = "SyncChangedContactWorker";

    public SyncChangedContactWorker(Context context, WorkerParameters workerParameters, ContactModelMapper contactModelMapper, SyncContactUtil syncContactUtil) {
        super(context, workerParameters, contactModelMapper, syncContactUtil);
    }

    @Override // id.dana.synccontact.worker.BaseSyncContactWorker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final SingleEmitter<ListenableWorker.Result> singleEmitter) {
        this.PlaceComponentResult.executeInBackground(new DefaultObserver<Contact>() { // from class: id.dana.synccontact.worker.syncnewcontact.SyncChangedContactWorker.1
            {
                SyncChangedContactWorker.this = this;
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                SyncChangedContactWorker.this.lookAheadTest = (Contact) obj;
                String KClassImpl$Data$declaredNonStaticMembers$2 = SyncChangedContactWorker.this.KClassImpl$Data$declaredNonStaticMembers$2();
                if (!TextUtils.isEmpty(KClassImpl$Data$declaredNonStaticMembers$2)) {
                    SyncChangedContactWorker.KClassImpl$Data$declaredNonStaticMembers$2(SyncChangedContactWorker.this, singleEmitter, KClassImpl$Data$declaredNonStaticMembers$2);
                } else {
                    singleEmitter.onSuccess(ListenableWorker.Result.BuiltInFictitiousFunctionClassFactory());
                }
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.CONTACT_SYNC_PREFIX);
                sb.append(getClass().getName());
                DanaLog.BuiltInFictitiousFunctionClassFactory(sb.toString(), DanaLogConstants.ExceptionType.CONTACT_SYNC_EXCEPTION, th.toString());
                singleEmitter.onSuccess(ListenableWorker.Result.getAuthRequestContext());
            }
        });
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SyncChangedContactWorker syncChangedContactWorker, final SingleEmitter singleEmitter, String str) {
        List<String> arrayList;
        List<UserContact> list;
        try {
            arrayList = syncChangedContactWorker.KClassImpl$Data$declaredNonStaticMembers$2(str);
            list = syncChangedContactWorker.MyBillsEntityDataFactory(str);
        } catch (Exception e) {
            arrayList = new ArrayList<>();
            ArrayList arrayList2 = new ArrayList();
            Exception exc = new Exception("CursorWindow error while sync contacts", e);
            Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
            Intrinsics.checkNotNullParameter(exc, "");
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(exc);
            list = arrayList2;
        }
        if (!arrayList.isEmpty() && !list.isEmpty()) {
            syncChangedContactWorker.scheduleImpl.executeInBackground(new DefaultObserver<Boolean>() { // from class: id.dana.synccontact.worker.syncnewcontact.SyncChangedContactWorker.2
                {
                    SyncChangedContactWorker.this = syncChangedContactWorker;
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public /* synthetic */ void onNext(Object obj) {
                    if (!Boolean.TRUE.equals((Boolean) obj)) {
                        singleEmitter.onSuccess(ListenableWorker.Result.getAuthRequestContext());
                        return;
                    }
                    SyncChangedContactWorker.this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2(SyncChangedContactWorker.this.getApplicationContext(), "sync_changed_contact_worker", SyncChangedContactWorker.class);
                    singleEmitter.onSuccess(ListenableWorker.Result.BuiltInFictitiousFunctionClassFactory());
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public void onError(Throwable th) {
                    super.onError(th);
                    singleEmitter.onSuccess(ListenableWorker.Result.MyBillsEntityDataFactory());
                    String str2 = SyncChangedContactWorker.moveToNextValue;
                    StringBuilder sb = new StringBuilder();
                    sb.append(DanaLogConstants.Prefix.CONTACT_SYNC_PREFIX);
                    sb.append(getClass().getName());
                    sb.append(":onError");
                    DanaLog.BuiltInFictitiousFunctionClassFactory(str2, sb.toString(), th);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(DanaLogConstants.Prefix.CONTACT_SYNC_PREFIX);
                    sb2.append(getClass().getName());
                    DanaLog.BuiltInFictitiousFunctionClassFactory(sb2.toString(), DanaLogConstants.ExceptionType.CONTACT_SYNC_EXCEPTION, th.toString());
                }
            }, SyncContact.Params.forSyncContact(arrayList, syncChangedContactWorker.getAuthRequestContext.apply(syncChangedContactWorker.getErrorConfigVersion), list));
            return;
        }
        singleEmitter.onSuccess(ListenableWorker.Result.getAuthRequestContext());
    }
}

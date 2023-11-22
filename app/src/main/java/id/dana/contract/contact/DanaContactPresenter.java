package id.dana.contract.contact;

import android.content.Context;
import android.text.TextUtils;
import dagger.Lazy;
import id.dana.base.BasePresenter;
import id.dana.contract.contact.DanaContactContract;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.CheckContactSyncFeature;
import id.dana.domain.featureconfig.interactor.GetContactInjectionConfig;
import id.dana.domain.recentcontact.interactor.GetDanaContact;
import id.dana.domain.synccontact.interactor.CheckSyncProcessCompleteState;
import id.dana.domain.synccontact.interactor.GetLastSyncedContact;
import id.dana.domain.synccontact.model.Contact;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.richview.contactselector.UserContactMapper;
import id.dana.sendmoney.contact.provider.ContactModel;
import id.dana.sendmoney.contact.provider.ContactProvider;
import id.dana.sync_engine.domain.interactor.GetContactsUseCase;
import id.dana.sync_engine.domain.model.ContactResult;
import id.dana.sync_engine.domain.model.SyncForFeature;
import id.dana.sync_engine.domain.model.SyncType;
import id.dana.sync_engine.domain.model.UserContact;
import id.dana.sync_engine.domain.model.UserType;
import id.dana.sync_engine.exception.SyncEngineException;
import id.dana.synccontact.SyncContactUtil;
import id.dana.synccontact.worker.syncallcontact.SyncAllContactWorker;
import id.dana.synccontact.worker.syncnewcontact.SyncChangedContactWorker;
import id.dana.utils.ErrorUtil;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes4.dex */
public class DanaContactPresenter extends BasePresenter implements DanaContactContract.Presenter {
    Disposable BuiltInFictitiousFunctionClassFactory;
    private final Lazy<UserContactMapper> GetContactSyncConfig;
    public final Lazy<GetContactInjectionConfig> KClassImpl$Data$declaredNonStaticMembers$2;
    final Context MyBillsEntityDataFactory;
    private final Lazy<GetContactsUseCase> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Lazy<GetDanaContact> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Lazy<GetLastSyncedContact> NetworkUserEntityData$$ExternalSyntheticLambda2;
    final Lazy<CheckSyncProcessCompleteState> PlaceComponentResult;
    final Lazy<ContactProvider> getAuthRequestContext;
    private final Lazy<CheckContactSyncFeature> getErrorConfigVersion;
    private final Lazy<SaveShareFeedConsent> initRecordTimeStamp;
    final Lazy<SyncContactUtil> lookAheadTest;
    final Lazy<DanaContactContract.View> moveToNextValue;
    final AtomicBoolean scheduleImpl = new AtomicBoolean(true);

    public static /* synthetic */ Unit NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return null;
    }

    @Inject
    public DanaContactPresenter(Context context, Lazy<DanaContactContract.View> lazy, Lazy<GetDanaContact> lazy2, Lazy<CheckSyncProcessCompleteState> lazy3, Lazy<GetLastSyncedContact> lazy4, Lazy<CheckContactSyncFeature> lazy5, Lazy<SyncContactUtil> lazy6, Lazy<SaveShareFeedConsent> lazy7, Lazy<ContactProvider> lazy8, Lazy<GetContactsUseCase> lazy9, Lazy<UserContactMapper> lazy10, Lazy<GetContactInjectionConfig> lazy11) {
        this.moveToNextValue = lazy;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = lazy2;
        this.MyBillsEntityDataFactory = context;
        this.PlaceComponentResult = lazy3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = lazy4;
        this.getErrorConfigVersion = lazy5;
        this.lookAheadTest = lazy6;
        this.initRecordTimeStamp = lazy7;
        this.getAuthRequestContext = lazy8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy9;
        this.GetContactSyncConfig = lazy10;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy11;
    }

    @Override // id.dana.contract.contact.DanaContactContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.get().execute(new DefaultObserver<List<String>>() { // from class: id.dana.contract.contact.DanaContactPresenter.1
            {
                DanaContactPresenter.this = this;
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                ((DanaContactContract.View) DanaContactPresenter.this.moveToNextValue.get()).onGetDanaUserContactSuccess((List) obj);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                ((DanaContactContract.View) DanaContactPresenter.this.moveToNextValue.get()).onError(ErrorUtil.BuiltInFictitiousFunctionClassFactory(DanaContactPresenter.this.MyBillsEntityDataFactory));
            }
        });
    }

    @Override // id.dana.contract.contact.DanaContactContract.Presenter
    public final void getAuthRequestContext() {
        this.getErrorConfigVersion.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.contract.contact.DanaContactPresenter.2
            {
                DanaContactPresenter.this = this;
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                if (((Boolean) obj).booleanValue()) {
                    ((DanaContactContract.View) DanaContactPresenter.this.moveToNextValue.get()).onEnableContactSyncFeature();
                }
            }
        });
    }

    @Override // id.dana.contract.contact.DanaContactContract.Presenter
    public final void MyBillsEntityDataFactory() {
        Disposable subscribe = Observable.interval(3L, TimeUnit.SECONDS, Schedulers.MyBillsEntityDataFactory()).startWith((Observable<Long>) 0L).subscribe(new Consumer() { // from class: id.dana.contract.contact.DanaContactPresenter$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                final DanaContactPresenter danaContactPresenter = DanaContactPresenter.this;
                Long l = (Long) obj;
                danaContactPresenter.PlaceComponentResult.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.contract.contact.DanaContactPresenter.3
                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public /* synthetic */ void onNext(Object obj2) {
                        Boolean bool = (Boolean) obj2;
                        if (bool.booleanValue()) {
                            danaContactPresenter.BuiltInFictitiousFunctionClassFactory.dispose();
                            DanaContactPresenter.BuiltInFictitiousFunctionClassFactory(danaContactPresenter);
                        } else {
                            DanaContactPresenter.KClassImpl$Data$declaredNonStaticMembers$2(danaContactPresenter);
                        }
                        ((DanaContactContract.View) danaContactPresenter.moveToNextValue.get()).onGetContactSyncState(bool.booleanValue());
                    }
                });
            }
        });
        this.BuiltInFictitiousFunctionClassFactory = subscribe;
        addDisposable(subscribe);
    }

    @Override // id.dana.contract.contact.DanaContactContract.Presenter
    public final void getErrorConfigVersion() {
        final HashMap hashMap = new HashMap();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().execute(GetContactsUseCase.BuiltInFictitiousFunctionClassFactory(), new Function1() { // from class: id.dana.contract.contact.DanaContactPresenter$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                DanaContactPresenter danaContactPresenter = DanaContactPresenter.this;
                Map map = hashMap;
                ContactResult contactResult = (ContactResult) obj;
                if (contactResult instanceof ContactResult.Initial) {
                    for (UserContact userContact : ((ContactResult.Initial) contactResult).KClassImpl$Data$declaredNonStaticMembers$2) {
                        map.put(Long.valueOf(userContact.KClassImpl$Data$declaredNonStaticMembers$2), userContact);
                    }
                } else if (contactResult instanceof ContactResult.Next) {
                    for (UserContact userContact2 : ((ContactResult.Next) contactResult).getAuthRequestContext) {
                        map.put(Long.valueOf(userContact2.KClassImpl$Data$declaredNonStaticMembers$2), userContact2);
                    }
                } else if (contactResult instanceof ContactResult.Update) {
                    for (UserContact userContact3 : ((ContactResult.Update) contactResult).MyBillsEntityDataFactory) {
                        map.put(Long.valueOf(userContact3.KClassImpl$Data$declaredNonStaticMembers$2), userContact3);
                    }
                } else if (contactResult instanceof ContactResult.Finished) {
                    danaContactPresenter.KClassImpl$Data$declaredNonStaticMembers$2(new ArrayList(map.values()));
                } else if (contactResult instanceof ContactResult.Error) {
                    danaContactPresenter.KClassImpl$Data$declaredNonStaticMembers$2(new ArrayList(map.values()));
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.contract.contact.DanaContactContract.Presenter
    public final void PlaceComponentResult() {
        final LinkedHashSet linkedHashSet = new LinkedHashSet();
        final LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        this.moveToNextValue.get().showProgress();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().execute(new GetContactsUseCase.Params(SyncForFeature.SendMoney, UserType.All, SyncType.Server, false, false), new Function1() { // from class: id.dana.contract.contact.DanaContactPresenter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                DanaContactPresenter danaContactPresenter = DanaContactPresenter.this;
                Set<UserContact> set = linkedHashSet;
                Set<UserContact> set2 = linkedHashSet2;
                ContactResult contactResult = (ContactResult) obj;
                if (contactResult instanceof ContactResult.Initial) {
                    set.clear();
                    set.addAll(((ContactResult.Initial) contactResult).KClassImpl$Data$declaredNonStaticMembers$2);
                } else if (contactResult instanceof ContactResult.Next) {
                    ContactResult.Next next = (ContactResult.Next) contactResult;
                    set.addAll(next.getAuthRequestContext);
                    AtomicBoolean atomicBoolean = danaContactPresenter.scheduleImpl;
                    if ((next.getAuthRequestContext.isEmpty() && atomicBoolean.get()) || next.getAuthRequestContext.isEmpty()) {
                        danaContactPresenter.KClassImpl$Data$declaredNonStaticMembers$2(set);
                        danaContactPresenter.moveToNextValue.get().dismissProgress();
                    }
                    if (atomicBoolean.get()) {
                        danaContactPresenter.scheduleImpl.set(false);
                    }
                } else if (contactResult instanceof ContactResult.Update) {
                    set2.addAll(((ContactResult.Update) contactResult).MyBillsEntityDataFactory);
                } else if (contactResult instanceof ContactResult.Finished) {
                    ArrayList arrayList = new ArrayList();
                    for (UserContact userContact : set2) {
                        if (userContact.PlaceComponentResult()) {
                            arrayList.add(userContact.NetworkUserEntityData$$ExternalSyntheticLambda0);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        danaContactPresenter.moveToNextValue.get().onGetDanaUserContactSuccess(arrayList);
                    }
                } else {
                    if (((ContactResult.Error) contactResult).getAuthRequestContext instanceof SyncEngineException.ContactNotFound) {
                        danaContactPresenter.KClassImpl$Data$declaredNonStaticMembers$2(new LinkedHashSet());
                    }
                    danaContactPresenter.moveToNextValue.get().dismissProgress();
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Set<UserContact> set) {
        this.moveToNextValue.get().onGetRecipientSyncContacts(this.GetContactSyncConfig.get().apply(new ArrayList(set)));
    }

    @Override // id.dana.contract.contact.DanaContactContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(NoParams.INSTANCE, new DanaContactPresenter$$ExternalSyntheticLambda2());
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.get().dispose();
        this.getErrorConfigVersion.get().dispose();
        this.PlaceComponentResult.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.get().dispose();
        this.initRecordTimeStamp.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
    }

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(DanaContactPresenter danaContactPresenter) {
        danaContactPresenter.NetworkUserEntityData$$ExternalSyntheticLambda2.get().execute(new DefaultObserver<Contact>() { // from class: id.dana.contract.contact.DanaContactPresenter.4
            {
                DanaContactPresenter.this = danaContactPresenter;
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                List<ContactModel> PlaceComponentResult;
                Contact contact = (Contact) obj;
                DanaContactPresenter danaContactPresenter2 = DanaContactPresenter.this;
                if (contact != null) {
                    ContactProvider contactProvider = danaContactPresenter2.getAuthRequestContext.get();
                    String lastUpdatedTime = contact.getLastUpdatedTime();
                    if (TextUtils.isEmpty(lastUpdatedTime)) {
                        PlaceComponentResult = new ArrayList<>();
                    } else {
                        PlaceComponentResult = contactProvider.PlaceComponentResult(1, lastUpdatedTime);
                    }
                    if (PlaceComponentResult.isEmpty() || danaContactPresenter2.lookAheadTest.get().BuiltInFictitiousFunctionClassFactory(danaContactPresenter2.MyBillsEntityDataFactory)) {
                        return;
                    }
                    danaContactPresenter2.lookAheadTest.get().KClassImpl$Data$declaredNonStaticMembers$2(danaContactPresenter2.MyBillsEntityDataFactory, "sync_changed_contact_worker", SyncChangedContactWorker.class);
                }
            }
        });
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(DanaContactPresenter danaContactPresenter) {
        if (danaContactPresenter.lookAheadTest.get().getAuthRequestContext(danaContactPresenter.MyBillsEntityDataFactory)) {
            return;
        }
        danaContactPresenter.lookAheadTest.get().KClassImpl$Data$declaredNonStaticMembers$2(danaContactPresenter.MyBillsEntityDataFactory, "sync_all_contact_worker", SyncAllContactWorker.class);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(List<UserContact> list) {
        ArrayList arrayList = new ArrayList();
        for (UserContact userContact : list) {
            if (userContact.PlaceComponentResult()) {
                arrayList.add(userContact.NetworkUserEntityData$$ExternalSyntheticLambda0);
            }
        }
        Collections.sort(list, new Comparator() { // from class: id.dana.contract.contact.DanaContactPresenter$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int compare;
                compare = String.CASE_INSENSITIVE_ORDER.compare(!TextUtils.isEmpty(r2.scheduleImpl) ? ((UserContact) obj).scheduleImpl.toLowerCase() : "", TextUtils.isEmpty(r3.scheduleImpl) ? "" : ((UserContact) obj2).scheduleImpl.toLowerCase());
                return compare;
            }
        });
        this.moveToNextValue.get().onGetSyncContacts(list);
        this.moveToNextValue.get().onGetDanaUserContactSuccess(arrayList);
        this.moveToNextValue.get().onGetContactSyncState(true);
    }
}

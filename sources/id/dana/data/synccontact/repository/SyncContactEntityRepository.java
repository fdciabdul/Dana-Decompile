package id.dana.data.synccontact.repository;

import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.config.source.amcs.result.ContactSyncConfigResult;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.recentcontact.repository.RecentContactEntityRepository;
import id.dana.data.synccontact.SyncContactEntityData;
import id.dana.data.synccontact.mapper.ContactEntityMapper;
import id.dana.data.synccontact.mapper.ContactMapper;
import id.dana.data.synccontact.mapper.ContactSyncConfigMapper;
import id.dana.data.synccontact.model.ContactEntity;
import id.dana.data.synccontact.repository.source.SyncContactDataFactory;
import id.dana.data.synccontact.repository.source.network.result.BizTransferSyncContactResult;
import id.dana.domain.sendmoney.model.UserContact;
import id.dana.domain.synccontact.SyncContactRepository;
import id.dana.domain.synccontact.model.Contact;
import id.dana.domain.synccontact.model.ContactSyncConfig;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class SyncContactEntityRepository implements SyncContactRepository {
    private final ConfigEntityDataFactory configEntityDataFactory;
    private final ContactEntityMapper contactEntityMapper;
    private final ContactMapper contactMapper;
    private final ContactSyncConfigMapper contactSyncConfigMapper;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final RecentContactEntityRepository recentContactEntityRepository;
    private final SyncContactDataFactory syncContactDataFactory;

    @Inject
    public SyncContactEntityRepository(ConfigEntityDataFactory configEntityDataFactory, SyncContactDataFactory syncContactDataFactory, RecentContactEntityRepository recentContactEntityRepository, ContactMapper contactMapper, ContactEntityMapper contactEntityMapper, ContactSyncConfigMapper contactSyncConfigMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        this.configEntityDataFactory = configEntityDataFactory;
        this.syncContactDataFactory = syncContactDataFactory;
        this.recentContactEntityRepository = recentContactEntityRepository;
        this.contactMapper = contactMapper;
        this.contactEntityMapper = contactEntityMapper;
        this.contactSyncConfigMapper = contactSyncConfigMapper;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.synccontact.SyncContactRepository
    public Observable<Boolean> syncContact(List<String> list, final Contact contact, List<UserContact> list2) {
        if (!this.holdLoginV1EntityRepository.createAccountData().hasAccount().blockingSingle().booleanValue()) {
            return Observable.just(Boolean.FALSE);
        }
        return this.holdLoginV1EntityRepository.authenticatedRequest(createSyncContactData().syncContact(list, list2)).map(new Function() { // from class: id.dana.data.synccontact.repository.SyncContactEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List list3;
                list3 = ((BizTransferSyncContactResult) obj).registeredUsers;
                return list3;
            }
        }).flatMap(new Function() { // from class: id.dana.data.synccontact.repository.SyncContactEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SyncContactEntityRepository.this.m2067x762b0c60((List) obj);
            }
        }).flatMap(new Function() { // from class: id.dana.data.synccontact.repository.SyncContactEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SyncContactEntityRepository.this.m2068xc3ea8461(contact, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$syncContact$1$id-dana-data-synccontact-repository-SyncContactEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m2067x762b0c60(List list) throws Exception {
        return saveRegisteredNumbers(list, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$syncContact$2$id-dana-data-synccontact-repository-SyncContactEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m2068xc3ea8461(Contact contact, Boolean bool) throws Exception {
        return saveLastSyncedContact(contact);
    }

    @Override // id.dana.domain.synccontact.SyncContactRepository
    public Observable<Boolean> syncOneContact(String str, UserContact userContact) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = null;
        if (str == null) {
            arrayList = null;
        } else {
            arrayList.add(str);
        }
        ArrayList arrayList3 = new ArrayList();
        if (userContact != null) {
            arrayList3.add(userContact);
            arrayList2 = arrayList3;
        }
        return this.holdLoginV1EntityRepository.authenticatedRequest(createSyncContactData().syncContact(arrayList, arrayList2)).map(new Function() { // from class: id.dana.data.synccontact.repository.SyncContactEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List list;
                list = ((BizTransferSyncContactResult) obj).registeredUsers;
                return list;
            }
        }).flatMap(new Function() { // from class: id.dana.data.synccontact.repository.SyncContactEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SyncContactEntityRepository.this.m2069x8296088d((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$syncOneContact$4$id-dana-data-synccontact-repository-SyncContactEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m2069x8296088d(List list) throws Exception {
        return saveRegisteredNumbers(list, true);
    }

    @Override // id.dana.domain.synccontact.SyncContactRepository
    public Observable<Boolean> isSyncProcessCompleted() {
        return createSyncContactPreferences().isSyncProcessCompleted();
    }

    @Override // id.dana.domain.synccontact.SyncContactRepository
    public Observable<Boolean> saveSyncProcessStatusComplete() {
        return createSyncContactPreferences().saveSyncProcessStatusComplete();
    }

    @Override // id.dana.domain.synccontact.SyncContactRepository
    public Observable<Contact> getLastSyncedContact() {
        Observable<ContactEntity> lastSyncedContact = createSyncContactPreferences().getLastSyncedContact();
        final ContactEntityMapper contactEntityMapper = this.contactEntityMapper;
        Objects.requireNonNull(contactEntityMapper);
        return lastSyncedContact.map(new Function() { // from class: id.dana.data.synccontact.repository.SyncContactEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ContactEntityMapper.this.apply((ContactEntity) obj);
            }
        });
    }

    @Override // id.dana.domain.synccontact.SyncContactRepository
    public Observable<ContactSyncConfig> getContactSyncConfig() {
        if (!this.holdLoginV1EntityRepository.createAccountData().hasAccount().blockingSingle().booleanValue()) {
            ContactSyncConfig contactSyncConfig = new ContactSyncConfig();
            contactSyncConfig.setSynchronizeContactEnable(false);
            return Observable.just(contactSyncConfig);
        }
        Observable<ContactSyncConfigResult> contactSyncConfig2 = createSplitConfigEntityData().getContactSyncConfig();
        ContactSyncConfigMapper contactSyncConfigMapper = this.contactSyncConfigMapper;
        Objects.requireNonNull(contactSyncConfigMapper);
        return contactSyncConfig2.map(new SyncContactEntityRepository$$ExternalSyntheticLambda3(contactSyncConfigMapper));
    }

    private ObservableSource<Boolean> saveLastSyncedContact(Contact contact) {
        if (contact != null) {
            createSyncContactPreferences().saveLastSyncedContact(this.contactMapper.apply(contact));
        }
        return Observable.just(Boolean.TRUE);
    }

    private ObservableSource<Boolean> saveRegisteredNumbers(List<String> list, boolean z) {
        if (list.isEmpty() && !z) {
            return Observable.just(Boolean.TRUE);
        }
        if (list.isEmpty() && z) {
            return Observable.just(Boolean.FALSE);
        }
        Observable fromIterable = Observable.fromIterable(list);
        final RecentContactEntityRepository recentContactEntityRepository = this.recentContactEntityRepository;
        Objects.requireNonNull(recentContactEntityRepository);
        return fromIterable.flatMap(new Function() { // from class: id.dana.data.synccontact.repository.SyncContactEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecentContactEntityRepository.this.saveDanaUserContact((String) obj);
            }
        });
    }

    private SyncContactEntityData createSyncContactData() {
        return this.syncContactDataFactory.createData2("network");
    }

    private SyncContactEntityData createSyncContactPreferences() {
        return this.syncContactDataFactory.createData2("local");
    }

    private ConfigEntityData createSplitConfigEntityData() {
        return this.configEntityDataFactory.createData2("split");
    }
}

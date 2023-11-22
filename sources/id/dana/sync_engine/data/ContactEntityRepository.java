package id.dana.sync_engine.data;

import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.config.model.SyncPermissionConfig;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.config.source.amcs.result.ContactSyncConfigResult;
import id.dana.data.config.source.amcs.result.RepeatedBackgroundJobsResult;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.synccontact.mapper.ContactSyncConfigMapper;
import id.dana.data.synccontact.repository.SyncContactEntityRepository$$ExternalSyntheticLambda3;
import id.dana.domain.synccontact.model.ContactSyncConfig;
import id.dana.domain.synccontact.model.RepeatBackgroundJobs;
import id.dana.domain.synccontact.model.SyncContactSplitConfigModel;
import id.dana.sync_engine.data.entity.ContactEntityDataFactory;
import id.dana.sync_engine.data.entity.SyncContactType;
import id.dana.sync_engine.data.source.ContactEntityData;
import id.dana.sync_engine.domain.ContactRepository;
import id.dana.sync_engine.domain.model.SyncPermissionAndChangeConfig;
import id.dana.sync_engine.domain.model.UserContact;
import id.dana.sync_engine.exception.SyncEngineException;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\u0006\u0010\u0005\u001a\u000204\u0012\u0006\u0010\u000b\u001a\u000202\u0012\u0006\u0010\u0019\u001a\u000200\u0012\u0006\u0010\u001b\u001a\u000206\u0012\u0006\u0010\u001c\u001a\u000208¢\u0006\u0004\b:\u0010;J#\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ1\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00030\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n0\u00110\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0010J+\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00062\u0006\u0010\u0005\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00170\u0006H\u0016¢\u0006\u0004\b\r\u0010\u0010J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00062\u0006\u0010\u0005\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0018J3\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00062\u0006\u0010\u0005\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\b\u0010\u001aJE\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00062\u0006\u0010\u0005\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u000f\u0010\u001dJ\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0010J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006H\u0016¢\u0006\u0004\b\b\u0010\u0010J\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00062\u0006\u0010\u0005\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u000f\u0010 J\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0005\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0018J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00062\u0006\u0010\u0005\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u0013\u0010 J\u0017\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u0006H\u0016¢\u0006\u0004\b\"\u0010\u0010J\u0015\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u0006H\u0016¢\u0006\u0004\b$\u0010\u0010J\u000f\u0010%\u001a\u00020\u0014H\u0016¢\u0006\u0004\b%\u0010&J!\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00172\b\u0010\u000b\u001a\u0004\u0018\u00010'H\u0000¢\u0006\u0004\b\r\u0010(J\u0015\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0\u0006H\u0016¢\u0006\u0004\b)\u0010\u0010J\u0015\u0010*\u001a\b\u0012\u0004\u0012\u00020\n0\u0006H\u0016¢\u0006\u0004\b*\u0010\u0010J#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\tJ\u0015\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b+\u0010\u0010J\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\u0006\u0010\u0005\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010,J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\b\u0010-J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\u001fH\u0016¢\u0006\u0004\b\b\u0010.J\u001f\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\u001fH\u0016¢\u0006\u0004\b\u0013\u0010.J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010-J#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\tJ#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\tJ\u001f\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\u001fH\u0016¢\u0006\u0004\b\u0015\u0010.J\u0013\u0010\u000f\u001a\u00020'*\u00020\u0017H\u0000¢\u0006\u0004\b\u000f\u0010/R\u0014\u0010\u0013\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u00101R\u0014\u0010\b\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u00103R\u0014\u0010\u0015\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u00105R\u0014\u0010\u000f\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u00107R\u0014\u0010\r\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u00109"}, d2 = {"Lid/dana/sync_engine/data/ContactEntityRepository;", "Lid/dana/sync_engine/domain/ContactRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "", "Lid/dana/sync_engine/domain/model/UserContact;", "p0", "Lio/reactivex/Observable;", "", "PlaceComponentResult", "(Ljava/util/List;)Lio/reactivex/Observable;", "", "p1", "", "MyBillsEntityDataFactory", "(Ljava/util/List;Z)Lio/reactivex/Observable;", "getAuthRequestContext", "()Lio/reactivex/Observable;", "Lkotlin/Pair;", "Lid/dana/domain/synccontact/model/RepeatBackgroundJobs;", "BuiltInFictitiousFunctionClassFactory", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;I)Lio/reactivex/Observable;", "Lid/dana/domain/synccontact/model/ContactSyncConfig;", "(Ljava/lang/String;)Lio/reactivex/Observable;", "p2", "(Ljava/lang/String;II)Lio/reactivex/Observable;", "p3", "p4", "(Ljava/lang/String;IILjava/lang/Boolean;I)Lio/reactivex/Observable;", "Lid/dana/sync_engine/data/entity/SyncContactType;", "", "(Lid/dana/sync_engine/data/entity/SyncContactType;)Lio/reactivex/Observable;", "Lid/dana/domain/synccontact/model/SyncContactSplitConfigModel;", "lookAheadTest", "Lid/dana/sync_engine/domain/model/SyncPermissionAndChangeConfig;", "scheduleImpl", "moveToNextValue", "()I", "Lid/dana/data/config/source/amcs/result/ContactSyncConfigResult;", "(Lid/dana/domain/synccontact/model/ContactSyncConfig;Lid/dana/data/config/source/amcs/result/ContactSyncConfigResult;)Z", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "NetworkUserEntityData$$ExternalSyntheticLambda2", "(Z)Lio/reactivex/Observable;", "(I)V", "(Lid/dana/sync_engine/data/entity/SyncContactType;J)V", "(Lid/dana/domain/synccontact/model/ContactSyncConfig;)Lid/dana/data/config/source/amcs/result/ContactSyncConfigResult;", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "Lid/dana/sync_engine/data/entity/ContactEntityDataFactory;", "Lid/dana/sync_engine/data/entity/ContactEntityDataFactory;", "Lid/dana/data/synccontact/mapper/ContactSyncConfigMapper;", "Lid/dana/data/synccontact/mapper/ContactSyncConfigMapper;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "<init>", "(Lid/dana/sync_engine/data/entity/ContactEntityDataFactory;Lid/dana/data/config/source/ConfigEntityDataFactory;Lid/dana/data/account/repository/source/AccountEntityDataFactory;Lid/dana/data/synccontact/mapper/ContactSyncConfigMapper;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ContactEntityRepository implements ContactRepository, HoldLoginV1Repository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final ContactSyncConfigMapper getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final AccountEntityDataFactory BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ConfigEntityDataFactory PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final ContactEntityDataFactory KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final HoldLoginV1EntityRepository MyBillsEntityDataFactory;

    @Inject
    public ContactEntityRepository(ContactEntityDataFactory contactEntityDataFactory, ConfigEntityDataFactory configEntityDataFactory, AccountEntityDataFactory accountEntityDataFactory, ContactSyncConfigMapper contactSyncConfigMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(contactEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(configEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(accountEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(contactSyncConfigMapper, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = contactEntityDataFactory;
        this.PlaceComponentResult = configEntityDataFactory;
        this.BuiltInFictitiousFunctionClassFactory = accountEntityDataFactory;
        this.getAuthRequestContext = contactSyncConfigMapper;
        this.MyBillsEntityDataFactory = holdLoginV1EntityRepository;
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final Observable<Integer> KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return this.KClassImpl$Data$declaredNonStaticMembers$2.createData2(p0).PlaceComponentResult();
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final Observable<List<UserContact>> PlaceComponentResult(String p0, int p1, int p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        return this.KClassImpl$Data$declaredNonStaticMembers$2.createData2(p0).KClassImpl$Data$declaredNonStaticMembers$2(p1, p2);
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final Observable<List<UserContact>> getAuthRequestContext(String p0, int p1, int p2, Boolean p3, int p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        return this.KClassImpl$Data$declaredNonStaticMembers$2.createData2(p0).getAuthRequestContext(p1, p2, p3, p4);
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final Observable<UserContact> getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return this.KClassImpl$Data$declaredNonStaticMembers$2.createData2(p0).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final Observable<Unit> PlaceComponentResult(List<UserContact> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return this.KClassImpl$Data$declaredNonStaticMembers$2.createData2("local").getAuthRequestContext(p0);
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final Observable<Long> getAuthRequestContext(List<UserContact> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return this.KClassImpl$Data$declaredNonStaticMembers$2.createData2("local").MyBillsEntityDataFactory(p0);
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final Observable<Unit> BuiltInFictitiousFunctionClassFactory(List<UserContact> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return this.KClassImpl$Data$declaredNonStaticMembers$2.createData2("local").KClassImpl$Data$declaredNonStaticMembers$2(p0);
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final Observable<List<String>> MyBillsEntityDataFactory(List<UserContact> p0, boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<List<String>> MyBillsEntityDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.createData2("network").MyBillsEntityDataFactory(p0, p1);
        Intrinsics.checkNotNullParameter(MyBillsEntityDataFactory, "");
        Observable<List<String>> authenticatedRequest = this.MyBillsEntityDataFactory.authenticatedRequest(MyBillsEntityDataFactory);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        return authenticatedRequest;
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final Observable<Boolean> KClassImpl$Data$declaredNonStaticMembers$2(List<UserContact> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<Boolean> BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.createData2("network").BuiltInFictitiousFunctionClassFactory(p0);
        Intrinsics.checkNotNullParameter(BuiltInFictitiousFunctionClassFactory, "");
        Observable<Boolean> authenticatedRequest = this.MyBillsEntityDataFactory.authenticatedRequest(BuiltInFictitiousFunctionClassFactory);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        return authenticatedRequest;
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final Observable<Long> getAuthRequestContext(SyncContactType p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return this.KClassImpl$Data$declaredNonStaticMembers$2.createData2("local").KClassImpl$Data$declaredNonStaticMembers$2(p0);
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final void PlaceComponentResult(SyncContactType p0, long p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.createData2("local").KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final Observable<Long> BuiltInFictitiousFunctionClassFactory(SyncContactType p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return this.KClassImpl$Data$declaredNonStaticMembers$2.createData2("local").getAuthRequestContext(p0);
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final void BuiltInFictitiousFunctionClassFactory(SyncContactType p0, long p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.createData2("local").BuiltInFictitiousFunctionClassFactory(p0, p1);
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final void KClassImpl$Data$declaredNonStaticMembers$2(SyncContactType p0, long p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.createData2("local").PlaceComponentResult(p0, p1);
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final void PlaceComponentResult(int p0) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.createData2("local").KClassImpl$Data$declaredNonStaticMembers$2(p0);
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final Observable<Integer> PlaceComponentResult() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.createData2("local").MyBillsEntityDataFactory();
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final Observable<Boolean> NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.createData2("local").lookAheadTest();
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final Observable<ContactSyncConfig> MyBillsEntityDataFactory() {
        Observable flatMap = this.BuiltInFictitiousFunctionClassFactory.createData2("local").hasAccount().flatMap(new Function() { // from class: id.dana.sync_engine.data.ContactEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ContactEntityRepository.PlaceComponentResult(ContactEntityRepository.this, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final Observable<Pair<RepeatBackgroundJobs, Boolean>> BuiltInFictitiousFunctionClassFactory() {
        Observable map = MyBillsEntityDataFactory().map(new Function() { // from class: id.dana.sync_engine.data.ContactEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ContactEntityRepository.PlaceComponentResult(ContactEntityRepository.this, (ContactSyncConfig) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    private static boolean MyBillsEntityDataFactory(ContactSyncConfig p0, ContactSyncConfigResult p1) {
        RepeatedBackgroundJobsResult repeatedBackgroundJobs;
        Intrinsics.checkNotNullParameter(p0, "");
        return ((p1 != null && (repeatedBackgroundJobs = p1.getRepeatedBackgroundJobs()) != null && (p0.getRepeatBackgroundJobs().getIntervalTimeInMillis() > repeatedBackgroundJobs.getIntervalTimeInMillis() ? 1 : (p0.getRepeatBackgroundJobs().getIntervalTimeInMillis() == repeatedBackgroundJobs.getIntervalTimeInMillis() ? 0 : -1)) == 0) && p0.getRepeatBackgroundJobs().getRequiredCharging() == p1.getRepeatedBackgroundJobs().isRequiredCharging() && p0.getRepeatBackgroundJobs().getRequiredDeviceIdle() == p1.getRepeatedBackgroundJobs().isRequiredDeviceIdle()) ? false : true;
    }

    private static ContactSyncConfigResult getAuthRequestContext(ContactSyncConfig contactSyncConfig) {
        Intrinsics.checkNotNullParameter(contactSyncConfig, "");
        ContactSyncConfigResult contactSyncConfigResult = new ContactSyncConfigResult();
        contactSyncConfigResult.setSynchronizeContact(contactSyncConfig.isSynchronizeContactEnable());
        contactSyncConfigResult.setIntervalTimeInMillis(contactSyncConfig.getIntervalTimeInMillis());
        contactSyncConfigResult.setMaxContactSyncBatchSize(contactSyncConfig.getMaxContactSyncBatchSize());
        RepeatedBackgroundJobsResult repeatedBackgroundJobsResult = new RepeatedBackgroundJobsResult();
        repeatedBackgroundJobsResult.setEnable(contactSyncConfig.getRepeatBackgroundJobs().getEnable());
        repeatedBackgroundJobsResult.setIntervalTimeInMillis(contactSyncConfig.getRepeatBackgroundJobs().getIntervalTimeInMillis());
        repeatedBackgroundJobsResult.setRequiredCharging(contactSyncConfig.getRepeatBackgroundJobs().getRequiredCharging());
        repeatedBackgroundJobsResult.setRequiredDeviceIdle(contactSyncConfig.getRepeatBackgroundJobs().getRequiredDeviceIdle());
        contactSyncConfigResult.setRepeatedBackgroundJobs(repeatedBackgroundJobsResult);
        return contactSyncConfigResult;
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final Observable<SyncPermissionAndChangeConfig> scheduleImpl() {
        Observable<SyncPermissionAndChangeConfig> zip = Observable.zip(this.PlaceComponentResult.createData2("split").getSyncPermissionScheduler(), this.KClassImpl$Data$declaredNonStaticMembers$2.createData2("local").scheduleImpl(), new BiFunction() { // from class: id.dana.sync_engine.data.ContactEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ContactEntityRepository.BuiltInFictitiousFunctionClassFactory(ContactEntityRepository.this, (SyncPermissionConfig) obj, (Long) obj2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final Observable<Boolean> KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.createData2("local").getAuthRequestContext();
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final Observable<Boolean> getAuthRequestContext(boolean p0) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.createData2("local").BuiltInFictitiousFunctionClassFactory(p0);
        Observable<Boolean> just = Observable.just(Boolean.TRUE);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final Observable<SyncContactSplitConfigModel> lookAheadTest() {
        Observable<SyncContactSplitConfigModel> syncContactWithNameConfig = this.PlaceComponentResult.createData2("split").getSyncContactWithNameConfig();
        Intrinsics.checkNotNullExpressionValue(syncContactWithNameConfig, "");
        return syncContactWithNameConfig;
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final Observable<Boolean> getErrorConfigVersion() {
        Observable map = MyBillsEntityDataFactory().map(new Function() { // from class: id.dana.sync_engine.data.ContactEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ContactEntityRepository.MyBillsEntityDataFactory(ContactEntityRepository.this, (ContactSyncConfig) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final Observable<Unit> getAuthRequestContext() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.createData2("local").BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final Observable<Unit> NetworkUserEntityData$$ExternalSyntheticLambda2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.createData2("local").NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.createData2("local").BuiltInFictitiousFunctionClassFactory(p0);
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final int moveToNextValue() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.createData2("local").getErrorConfigVersion();
    }

    @Override // id.dana.sync_engine.domain.ContactRepository
    public final Observable<List<UserContact>> KClassImpl$Data$declaredNonStaticMembers$2(String p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        return this.KClassImpl$Data$declaredNonStaticMembers$2.createData2("device").getAuthRequestContext(p0, p1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
    
        if (r1 == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ kotlin.Pair PlaceComponentResult(id.dana.sync_engine.data.ContactEntityRepository r7, id.dana.domain.synccontact.model.ContactSyncConfig r8) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            id.dana.sync_engine.data.entity.ContactEntityDataFactory r1 = r7.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String r2 = "local"
            id.dana.sync_engine.data.source.ContactEntityData r1 = r1.createData2(r2)
            id.dana.sync_engine.data.entity.SyncContactType r3 = id.dana.sync_engine.data.entity.SyncContactType.Server
            id.dana.data.config.source.amcs.result.ContactSyncConfigResult r1 = r1.MyBillsEntityDataFactory(r3)
            boolean r3 = MyBillsEntityDataFactory(r8, r1)
            if (r3 == 0) goto L5a
            if (r1 == 0) goto L4b
            id.dana.domain.synccontact.model.RepeatBackgroundJobs r4 = r8.getRepeatBackgroundJobs()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            id.dana.data.config.source.amcs.result.RepeatedBackgroundJobsResult r0 = new id.dana.data.config.source.amcs.result.RepeatedBackgroundJobsResult
            r0.<init>()
            boolean r5 = r4.getEnable()
            r0.setEnable(r5)
            long r5 = r4.getIntervalTimeInMillis()
            r0.setIntervalTimeInMillis(r5)
            boolean r5 = r4.getRequiredCharging()
            r0.setRequiredCharging(r5)
            boolean r4 = r4.getRequiredDeviceIdle()
            r0.setRequiredDeviceIdle(r4)
            r1.setRepeatedBackgroundJobs(r0)
            if (r1 != 0) goto L4f
        L4b:
            id.dana.data.config.source.amcs.result.ContactSyncConfigResult r1 = getAuthRequestContext(r8)
        L4f:
            id.dana.sync_engine.data.entity.ContactEntityDataFactory r7 = r7.KClassImpl$Data$declaredNonStaticMembers$2
            id.dana.sync_engine.data.source.ContactEntityData r7 = r7.createData2(r2)
            id.dana.sync_engine.data.entity.SyncContactType r0 = id.dana.sync_engine.data.entity.SyncContactType.Server
            r7.getAuthRequestContext(r0, r1)
        L5a:
            id.dana.domain.synccontact.model.RepeatBackgroundJobs r7 = r8.getRepeatBackgroundJobs()
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r3)
            kotlin.Pair r7 = kotlin.TuplesKt.to(r7, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sync_engine.data.ContactEntityRepository.PlaceComponentResult(id.dana.sync_engine.data.ContactEntityRepository, id.dana.domain.synccontact.model.ContactSyncConfig):kotlin.Pair");
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(ContactEntityRepository contactEntityRepository, ContactSyncConfigResult contactSyncConfigResult) {
        Intrinsics.checkNotNullParameter(contactEntityRepository, "");
        ContactEntityData createData2 = contactEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2.createData2("local");
        SyncContactType syncContactType = SyncContactType.Local;
        Intrinsics.checkNotNullExpressionValue(contactSyncConfigResult, "");
        createData2.getAuthRequestContext(syncContactType, contactSyncConfigResult);
    }

    public static /* synthetic */ SyncPermissionAndChangeConfig BuiltInFictitiousFunctionClassFactory(ContactEntityRepository contactEntityRepository, SyncPermissionConfig syncPermissionConfig, Long l) {
        Intrinsics.checkNotNullParameter(contactEntityRepository, "");
        Intrinsics.checkNotNullParameter(syncPermissionConfig, "");
        Intrinsics.checkNotNullParameter(l, "");
        boolean z = syncPermissionConfig.getIntervalTimeInMillis() != l.longValue();
        if (z) {
            contactEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2.createData2("local").MyBillsEntityDataFactory(syncPermissionConfig.getIntervalTimeInMillis());
        }
        return new SyncPermissionAndChangeConfig(syncPermissionConfig.getIntervalTimeInMillis(), syncPermissionConfig.getEnable(), z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0032, code lost:
    
        if (r0 == null) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Boolean MyBillsEntityDataFactory(id.dana.sync_engine.data.ContactEntityRepository r4, id.dana.domain.synccontact.model.ContactSyncConfig r5) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            id.dana.sync_engine.data.entity.ContactEntityDataFactory r0 = r4.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String r1 = "local"
            id.dana.sync_engine.data.source.ContactEntityData r0 = r0.createData2(r1)
            id.dana.sync_engine.data.entity.SyncContactType r2 = id.dana.sync_engine.data.entity.SyncContactType.Server
            id.dana.data.config.source.amcs.result.ContactSyncConfigResult r0 = r0.MyBillsEntityDataFactory(r2)
            int r2 = r5.getVersion()
            if (r0 == 0) goto L21
            int r3 = r0.getVersion()
            goto L22
        L21:
            r3 = -1
        L22:
            if (r2 <= r3) goto L26
            r2 = 1
            goto L27
        L26:
            r2 = 0
        L27:
            if (r2 == 0) goto L43
            if (r0 == 0) goto L34
            int r3 = r5.getVersion()
            r0.setVersion(r3)
            if (r0 != 0) goto L38
        L34:
            id.dana.data.config.source.amcs.result.ContactSyncConfigResult r0 = getAuthRequestContext(r5)
        L38:
            id.dana.sync_engine.data.entity.ContactEntityDataFactory r4 = r4.KClassImpl$Data$declaredNonStaticMembers$2
            id.dana.sync_engine.data.source.ContactEntityData r4 = r4.createData2(r1)
            id.dana.sync_engine.data.entity.SyncContactType r5 = id.dana.sync_engine.data.entity.SyncContactType.Server
            r4.getAuthRequestContext(r5, r0)
        L43:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sync_engine.data.ContactEntityRepository.MyBillsEntityDataFactory(id.dana.sync_engine.data.ContactEntityRepository, id.dana.domain.synccontact.model.ContactSyncConfig):java.lang.Boolean");
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(final ContactEntityRepository contactEntityRepository, Boolean bool) {
        Observable error;
        Observable<ContactSyncConfigResult> doOnNext;
        Intrinsics.checkNotNullParameter(contactEntityRepository, "");
        Intrinsics.checkNotNullParameter(bool, "");
        if (bool.booleanValue()) {
            ContactSyncConfigResult MyBillsEntityDataFactory = contactEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2.createData2("local").MyBillsEntityDataFactory(SyncContactType.Local);
            if (MyBillsEntityDataFactory != null) {
                doOnNext = Observable.just(MyBillsEntityDataFactory);
            } else {
                doOnNext = contactEntityRepository.PlaceComponentResult.createData2("split").getContactSyncConfig().doOnNext(new Consumer() { // from class: id.dana.sync_engine.data.ContactEntityRepository$$ExternalSyntheticLambda2
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        ContactEntityRepository.MyBillsEntityDataFactory(ContactEntityRepository.this, (ContactSyncConfigResult) obj);
                    }
                });
            }
            error = doOnNext.map(new SyncContactEntityRepository$$ExternalSyntheticLambda3(contactEntityRepository.getAuthRequestContext));
        } else {
            error = Observable.error(SyncEngineException.UserSessionIsRequired.INSTANCE);
        }
        return error;
    }
}

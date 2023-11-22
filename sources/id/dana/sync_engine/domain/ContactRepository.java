package id.dana.sync_engine.domain;

import id.dana.domain.synccontact.model.ContactSyncConfig;
import id.dana.domain.synccontact.model.RepeatBackgroundJobs;
import id.dana.domain.synccontact.model.SyncContactSplitConfigModel;
import id.dana.sync_engine.data.entity.SyncContactType;
import id.dana.sync_engine.domain.model.SyncPermissionAndChangeConfig;
import id.dana.sync_engine.domain.model.UserContact;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t0\u00100\u0005H&¢\u0006\u0004\b\u0012\u0010\u000fJ+\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00160\u0005H&¢\u0006\u0004\b\f\u0010\u000fJ\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00052\u0006\u0010\u0004\u001a\u00020\u000bH&¢\u0006\u0004\b\u0014\u0010\u0017J3\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0013H&¢\u0006\u0004\b\u0007\u0010\u0019JE\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001b\u001a\u00020\u0013H&¢\u0006\u0004\b\u000e\u0010\u001cJ\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H&¢\u0006\u0004\b\u0014\u0010\u000fJ\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00130\u0005H&¢\u0006\u0004\b\u0007\u0010\u000fJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00052\u0006\u0010\u0004\u001a\u00020\u001dH&¢\u0006\u0004\b\u000e\u0010\u001fJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0004\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\u0017J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00052\u0006\u0010\u0004\u001a\u00020\u001dH&¢\u0006\u0004\b\u0012\u0010\u001fJ\u0017\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u0005H&¢\u0006\u0004\b!\u0010\u000fJ\u0015\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u0005H&¢\u0006\u0004\b#\u0010\u000fJ\u000f\u0010$\u001a\u00020\u0013H&¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H&¢\u0006\u0004\b&\u0010\u000fJ\u0015\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H&¢\u0006\u0004\b'\u0010\u000fJ#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0012\u0010\bJ\u0015\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b(\u0010\u000fJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010\u0004\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010)J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0013H&¢\u0006\u0004\b\u0007\u0010*J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\u001eH&¢\u0006\u0004\b\u0007\u0010+J\u001f\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\u001eH&¢\u0006\u0004\b\u0012\u0010+J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010*J#\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0014\u0010\bJ#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u000e\u0010\bJ\u001f\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\u001eH&¢\u0006\u0004\b\u0014\u0010+ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sync_engine/domain/ContactRepository;", "", "", "Lid/dana/sync_engine/domain/model/UserContact;", "p0", "Lio/reactivex/Observable;", "", "PlaceComponentResult", "(Ljava/util/List;)Lio/reactivex/Observable;", "", "p1", "", "MyBillsEntityDataFactory", "(Ljava/util/List;Z)Lio/reactivex/Observable;", "getAuthRequestContext", "()Lio/reactivex/Observable;", "Lkotlin/Pair;", "Lid/dana/domain/synccontact/model/RepeatBackgroundJobs;", "BuiltInFictitiousFunctionClassFactory", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;I)Lio/reactivex/Observable;", "Lid/dana/domain/synccontact/model/ContactSyncConfig;", "(Ljava/lang/String;)Lio/reactivex/Observable;", "p2", "(Ljava/lang/String;II)Lio/reactivex/Observable;", "p3", "p4", "(Ljava/lang/String;IILjava/lang/Boolean;I)Lio/reactivex/Observable;", "Lid/dana/sync_engine/data/entity/SyncContactType;", "", "(Lid/dana/sync_engine/data/entity/SyncContactType;)Lio/reactivex/Observable;", "Lid/dana/domain/synccontact/model/SyncContactSplitConfigModel;", "lookAheadTest", "Lid/dana/sync_engine/domain/model/SyncPermissionAndChangeConfig;", "scheduleImpl", "moveToNextValue", "()I", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "NetworkUserEntityData$$ExternalSyntheticLambda2", "(Z)Lio/reactivex/Observable;", "(I)V", "(Lid/dana/sync_engine/data/entity/SyncContactType;J)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ContactRepository {
    Observable<Pair<RepeatBackgroundJobs, Boolean>> BuiltInFictitiousFunctionClassFactory();

    Observable<Long> BuiltInFictitiousFunctionClassFactory(SyncContactType p0);

    Observable<Unit> BuiltInFictitiousFunctionClassFactory(List<UserContact> p0);

    void BuiltInFictitiousFunctionClassFactory(SyncContactType p0, long p1);

    Observable<Boolean> KClassImpl$Data$declaredNonStaticMembers$2();

    Observable<Integer> KClassImpl$Data$declaredNonStaticMembers$2(String p0);

    Observable<List<UserContact>> KClassImpl$Data$declaredNonStaticMembers$2(String p0, int p1);

    Observable<Boolean> KClassImpl$Data$declaredNonStaticMembers$2(List<UserContact> p0);

    void KClassImpl$Data$declaredNonStaticMembers$2(int p0);

    void KClassImpl$Data$declaredNonStaticMembers$2(SyncContactType p0, long p1);

    Observable<ContactSyncConfig> MyBillsEntityDataFactory();

    Observable<List<String>> MyBillsEntityDataFactory(List<UserContact> p0, boolean p1);

    Observable<Boolean> NetworkUserEntityData$$ExternalSyntheticLambda0();

    Observable<Unit> NetworkUserEntityData$$ExternalSyntheticLambda2();

    Observable<Integer> PlaceComponentResult();

    Observable<List<UserContact>> PlaceComponentResult(String p0, int p1, int p2);

    Observable<Unit> PlaceComponentResult(List<UserContact> p0);

    void PlaceComponentResult(int p0);

    void PlaceComponentResult(SyncContactType p0, long p1);

    Observable<Unit> getAuthRequestContext();

    Observable<Long> getAuthRequestContext(SyncContactType p0);

    Observable<UserContact> getAuthRequestContext(String p0);

    Observable<List<UserContact>> getAuthRequestContext(String p0, int p1, int p2, Boolean p3, int p4);

    Observable<Long> getAuthRequestContext(List<UserContact> p0);

    Observable<Boolean> getAuthRequestContext(boolean p0);

    Observable<Boolean> getErrorConfigVersion();

    Observable<SyncContactSplitConfigModel> lookAheadTest();

    int moveToNextValue();

    Observable<SyncPermissionAndChangeConfig> scheduleImpl();
}

package id.dana.sync_engine.data.source;

import id.dana.data.config.source.amcs.result.ContactSyncConfigResult;
import id.dana.sync_engine.data.entity.SyncContactType;
import id.dana.sync_engine.domain.model.UserContact;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0010H&¢\u0006\u0004\b\u0007\u0010\u0011J\u0019\u0010\f\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0004\u001a\u00020\u0012H&¢\u0006\u0004\b\f\u0010\u0014J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005H&¢\u0006\u0004\b\u0015\u0010\u000fJ+\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H&¢\u0006\u0004\b\u0016\u0010\u0017J=\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0019\u001a\u00020\u0010H&¢\u0006\u0004\b\u0007\u0010\u001aJ\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H&¢\u0006\u0004\b\u0007\u0010\u000fJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005H&¢\u0006\u0004\b\f\u0010\u000fJ\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00052\u0006\u0010\u0004\u001a\u00020\u0012H&¢\u0006\u0004\b\u0016\u0010\u001cJ\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&¢\u0006\u0004\b\u0016\u0010\u000fJ\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0005H&¢\u0006\u0004\b\u001d\u0010\u000fJ\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00052\u0006\u0010\u0004\u001a\u00020\u0012H&¢\u0006\u0004\b\u0007\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u0010H&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u0005H&¢\u0006\u0004\b \u0010\u000fJ#\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0016\u0010\bJ\u0015\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b!\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u0013H&¢\u0006\u0004\b\u0007\u0010\"J\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010#J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0010H&¢\u0006\u0004\b\u0016\u0010$J\u001f\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u001bH&¢\u0006\u0004\b\u0016\u0010%J\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u001bH&¢\u0006\u0004\b\f\u0010&J\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u001bH&¢\u0006\u0004\b\u000e\u0010%J\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0010H&¢\u0006\u0004\b\u000e\u0010$J#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u000e\u0010\bJ#\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\f\u0010\bJ\u001f\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u001bH&¢\u0006\u0004\b\u0015\u0010%ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sync_engine/data/source/ContactEntityData;", "", "", "Lid/dana/sync_engine/domain/model/UserContact;", "p0", "Lio/reactivex/Observable;", "", "getAuthRequestContext", "(Ljava/util/List;)Lio/reactivex/Observable;", "", "p1", "", "MyBillsEntityDataFactory", "(Ljava/util/List;Z)Lio/reactivex/Observable;", "BuiltInFictitiousFunctionClassFactory", "()Lio/reactivex/Observable;", "", "(Ljava/lang/String;I)Lio/reactivex/Observable;", "Lid/dana/sync_engine/data/entity/SyncContactType;", "Lid/dana/data/config/source/amcs/result/ContactSyncConfigResult;", "(Lid/dana/sync_engine/data/entity/SyncContactType;)Lid/dana/data/config/source/amcs/result/ContactSyncConfigResult;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "(II)Lio/reactivex/Observable;", "p2", "p3", "(IILjava/lang/Boolean;I)Lio/reactivex/Observable;", "", "(Lid/dana/sync_engine/data/entity/SyncContactType;)Lio/reactivex/Observable;", "scheduleImpl", "getErrorConfigVersion", "()I", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "(Lid/dana/sync_engine/data/entity/SyncContactType;Lid/dana/data/config/source/amcs/result/ContactSyncConfigResult;)V", "(Z)V", "(I)V", "(Lid/dana/sync_engine/data/entity/SyncContactType;J)V", "(J)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ContactEntityData {
    Observable<Unit> BuiltInFictitiousFunctionClassFactory();

    Observable<Boolean> BuiltInFictitiousFunctionClassFactory(List<UserContact> p0);

    void BuiltInFictitiousFunctionClassFactory(int p0);

    void BuiltInFictitiousFunctionClassFactory(SyncContactType p0, long p1);

    void BuiltInFictitiousFunctionClassFactory(boolean p0);

    Observable<UserContact> KClassImpl$Data$declaredNonStaticMembers$2();

    Observable<List<UserContact>> KClassImpl$Data$declaredNonStaticMembers$2(int p0, int p1);

    Observable<Long> KClassImpl$Data$declaredNonStaticMembers$2(SyncContactType p0);

    Observable<Unit> KClassImpl$Data$declaredNonStaticMembers$2(List<UserContact> p0);

    void KClassImpl$Data$declaredNonStaticMembers$2(int p0);

    void KClassImpl$Data$declaredNonStaticMembers$2(SyncContactType p0, long p1);

    ContactSyncConfigResult MyBillsEntityDataFactory(SyncContactType p0);

    Observable<Integer> MyBillsEntityDataFactory();

    Observable<Long> MyBillsEntityDataFactory(List<UserContact> p0);

    Observable<List<String>> MyBillsEntityDataFactory(List<UserContact> p0, boolean p1);

    void MyBillsEntityDataFactory(long p0);

    Observable<Unit> NetworkUserEntityData$$ExternalSyntheticLambda0();

    Observable<Integer> PlaceComponentResult();

    void PlaceComponentResult(SyncContactType p0, long p1);

    Observable<Boolean> getAuthRequestContext();

    Observable<List<UserContact>> getAuthRequestContext(int p0, int p1, Boolean p2, int p3);

    Observable<Long> getAuthRequestContext(SyncContactType p0);

    Observable<List<UserContact>> getAuthRequestContext(String p0, int p1);

    Observable<Unit> getAuthRequestContext(List<UserContact> p0);

    void getAuthRequestContext(SyncContactType p0, ContactSyncConfigResult p1);

    int getErrorConfigVersion();

    Observable<Boolean> lookAheadTest();

    Observable<Long> scheduleImpl();
}

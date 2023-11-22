package id.dana.sync_engine.data.source.local;

import com.anggrayudi.storage.extension.PrimitivesExtKt;
import com.google.gson.Gson;
import dagger.Lazy;
import id.dana.data.base.BasePersistence;
import id.dana.data.base.BasePersistenceDao;
import id.dana.data.config.source.amcs.result.ContactSyncConfigResult;
import id.dana.data.recentcontact.repository.source.persistence.dao.UserContactDao;
import id.dana.data.recentcontact.repository.source.persistence.entity.UserContactEntity;
import id.dana.data.storage.PreferenceFacade;
import id.dana.sync_engine.data.entity.SyncContactType;
import id.dana.sync_engine.data.entity.UserContactEntityKt;
import id.dana.sync_engine.data.source.ContactEntityData;
import id.dana.sync_engine.di.SyncEngine;
import id.dana.sync_engine.domain.model.UserContact;
import id.dana.utils.exception.CallableReturnNullError;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B)\b\u0007\u0012\b\b\u0001\u0010\u0005\u001a\u00020.\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020100\u0012\u0006\u0010\u0019\u001a\u00020)¢\u0006\u0004\b2\u00103J#\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ1\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00030\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00062\u0006\u0010\u0005\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\b\u0010\u0012J\u0019\u0010\r\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0005\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\r\u0010\u0015J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0010J+\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00062\u0006\u0010\u0005\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J=\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00062\u0006\u0010\u0005\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\b\u0010\u001bJ\u0019\u0010\b\u001a\f\u0012\b\u0012\u0006*\u00020\n0\n0\u0006H\u0016¢\u0006\u0004\b\b\u0010\u0010J\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006H\u0016¢\u0006\u0004\b\r\u0010\u0010J\u0017\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u001cJ\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00062\u0006\u0010\u0005\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u001eJ\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0010J\u0019\u0010\u001f\u001a\f\u0012\b\u0012\u0006*\u00020\u001d0\u001d0\u0006H\u0016¢\u0006\u0004\b\u001f\u0010\u0010J\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u000f\u0010\u001cJ\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00062\u0006\u0010\u0005\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\b\u0010\u001eJ\u000f\u0010 \u001a\u00020\u0011H\u0016¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\u0006H\u0016¢\u0006\u0004\b\"\u0010\u0010J#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\tJ\u0015\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b#\u0010\u0010J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\b\u0010$J\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010%J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0017\u0010&J\u001f\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u0017\u0010'J\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\r\u0010(J\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u000f\u0010'J\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u000f\u0010&J#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\tJ#\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\r\u0010\tJ\u001f\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u0016\u0010'R\u0014\u0010\u0017\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010*R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020,0+X\u0000¢\u0006\u0006\n\u0004\b\u0016\u0010-R\u0014\u0010\r\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010/"}, d2 = {"Lid/dana/sync_engine/data/source/local/ContactEntityDataLocal;", "Lid/dana/data/base/BasePersistence;", "Lid/dana/sync_engine/data/source/ContactEntityData;", "", "Lid/dana/sync_engine/domain/model/UserContact;", "p0", "Lio/reactivex/Observable;", "", "getAuthRequestContext", "(Ljava/util/List;)Lio/reactivex/Observable;", "", "p1", "", "MyBillsEntityDataFactory", "(Ljava/util/List;Z)Lio/reactivex/Observable;", "BuiltInFictitiousFunctionClassFactory", "()Lio/reactivex/Observable;", "", "(Ljava/lang/String;I)Lio/reactivex/Observable;", "Lid/dana/sync_engine/data/entity/SyncContactType;", "Lid/dana/data/config/source/amcs/result/ContactSyncConfigResult;", "(Lid/dana/sync_engine/data/entity/SyncContactType;)Lid/dana/data/config/source/amcs/result/ContactSyncConfigResult;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "(II)Lio/reactivex/Observable;", "p2", "p3", "(IILjava/lang/Boolean;I)Lio/reactivex/Observable;", "(Lid/dana/sync_engine/data/entity/SyncContactType;)Ljava/lang/String;", "", "(Lid/dana/sync_engine/data/entity/SyncContactType;)Lio/reactivex/Observable;", "scheduleImpl", "getErrorConfigVersion", "()I", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "(Lid/dana/sync_engine/data/entity/SyncContactType;Lid/dana/data/config/source/amcs/result/ContactSyncConfigResult;)V", "(Z)V", "(I)V", "(Lid/dana/sync_engine/data/entity/SyncContactType;J)V", "(J)V", "Lcom/google/gson/Gson;", "Lcom/google/gson/Gson;", "", "", "Ljava/util/Map;", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/storage/PreferenceFacade;", "Ldagger/Lazy;", "Lid/dana/data/base/BasePersistenceDao;", "<init>", "(Lid/dana/data/storage/PreferenceFacade;Ldagger/Lazy;Lcom/google/gson/Gson;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ContactEntityDataLocal extends BasePersistence implements ContactEntityData {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private final PreferenceFacade MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Map<String, Object> getAuthRequestContext;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[SyncContactType.values().length];
            iArr[SyncContactType.Local.ordinal()] = 1;
            iArr[SyncContactType.Server.ordinal()] = 2;
            PlaceComponentResult = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public ContactEntityDataLocal(@SyncEngine PreferenceFacade preferenceFacade, Lazy<BasePersistenceDao> lazy, Gson gson) {
        super(lazy);
        Intrinsics.checkNotNullParameter(preferenceFacade, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(gson, "");
        this.MyBillsEntityDataFactory = preferenceFacade;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gson;
        this.getAuthRequestContext = new LinkedHashMap();
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Integer> PlaceComponentResult() {
        Function0<Integer> function0 = new Function0<Integer>() { // from class: id.dana.sync_engine.data.source.local.ContactEntityDataLocal$getContactSize$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ContactEntityDataLocal.this.getDb().userContactDao().getCountContacts());
            }
        };
        Intrinsics.checkNotNullParameter(function0, "");
        Observable<Integer> fromCallable = Observable.fromCallable(new ContactEntityDataLocal$$ExternalSyntheticLambda4(function0));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<List<UserContact>> KClassImpl$Data$declaredNonStaticMembers$2(final int p0, final int p1) {
        Function0<List<? extends UserContactEntity>> function0 = new Function0<List<? extends UserContactEntity>>() { // from class: id.dana.sync_engine.data.source.local.ContactEntityDataLocal$getContacts$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends UserContactEntity> invoke() {
                return ContactEntityDataLocal.this.getDb().userContactDao().getContacts(p0, p1);
            }
        };
        Intrinsics.checkNotNullParameter(function0, "");
        Observable fromCallable = Observable.fromCallable(new ContactEntityDataLocal$$ExternalSyntheticLambda4(function0));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        Observable<List<UserContact>> map = fromCallable.map(new Function() { // from class: id.dana.sync_engine.data.source.local.ContactEntityDataLocal$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ContactEntityDataLocal.getErrorConfigVersion((List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<List<UserContact>> getAuthRequestContext(final int p0, final int p1, final Boolean p2, final int p3) {
        Function0<List<? extends UserContactEntity>> function0 = new Function0<List<? extends UserContactEntity>>() { // from class: id.dana.sync_engine.data.source.local.ContactEntityDataLocal$getContactsByType$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends UserContactEntity> invoke() {
                UserContactDao userContactDao = ContactEntityDataLocal.this.getDb().userContactDao();
                int i = p0;
                int i2 = p1;
                Boolean bool = p2;
                return userContactDao.getContactsByType(i, i2, bool != null ? Integer.valueOf(PrimitivesExtKt.BuiltInFictitiousFunctionClassFactory(bool)) : null, p3);
            }
        };
        Intrinsics.checkNotNullParameter(function0, "");
        Observable fromCallable = Observable.fromCallable(new ContactEntityDataLocal$$ExternalSyntheticLambda4(function0));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        Observable<List<UserContact>> map = fromCallable.map(new Function() { // from class: id.dana.sync_engine.data.source.local.ContactEntityDataLocal$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ContactEntityDataLocal.PlaceComponentResult((List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<UserContact> KClassImpl$Data$declaredNonStaticMembers$2() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Unit> getAuthRequestContext(List<UserContact> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        long currentTimeMillis = System.currentTimeMillis();
        List<UserContact> list = p0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(UserContactEntityKt.MyBillsEntityDataFactory((UserContact) it.next(), currentTimeMillis, currentTimeMillis));
        }
        Object[] array = arrayList.toArray(new UserContactEntity[0]);
        if (array != null) {
            final UserContactEntity[] userContactEntityArr = (UserContactEntity[]) array;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.sync_engine.data.source.local.ContactEntityDataLocal$addContact$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    UserContactDao userContactDao = ContactEntityDataLocal.this.getDb().userContactDao();
                    UserContactEntity[] userContactEntityArr2 = userContactEntityArr;
                    userContactDao.addContacts((UserContactEntity[]) Arrays.copyOf(userContactEntityArr2, userContactEntityArr2.length));
                }
            };
            Intrinsics.checkNotNullParameter(function0, "");
            Observable<Unit> fromCallable = Observable.fromCallable(new ContactEntityDataLocal$$ExternalSyntheticLambda4(function0));
            Intrinsics.checkNotNullExpressionValue(fromCallable, "");
            return fromCallable;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Long> MyBillsEntityDataFactory(List<UserContact> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final long currentTimeMillis = System.currentTimeMillis();
        List<UserContact> list = p0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(UserContactEntityKt.KClassImpl$Data$declaredNonStaticMembers$2((UserContact) it.next(), currentTimeMillis));
        }
        Object[] array = arrayList.toArray(new UserContactEntity[0]);
        if (array != null) {
            final UserContactEntity[] userContactEntityArr = (UserContactEntity[]) array;
            Function0<Long> function0 = new Function0<Long>() { // from class: id.dana.sync_engine.data.source.local.ContactEntityDataLocal$updateContacts$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Long invoke() {
                    UserContactDao userContactDao = ContactEntityDataLocal.this.getDb().userContactDao();
                    UserContactEntity[] userContactEntityArr2 = userContactEntityArr;
                    userContactDao.updateContacts((UserContactEntity[]) Arrays.copyOf(userContactEntityArr2, userContactEntityArr2.length));
                    return Long.valueOf(currentTimeMillis);
                }
            };
            Intrinsics.checkNotNullParameter(function0, "");
            Observable<Long> fromCallable = Observable.fromCallable(new ContactEntityDataLocal$$ExternalSyntheticLambda4(function0));
            Intrinsics.checkNotNullExpressionValue(fromCallable, "");
            return fromCallable;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Unit> KClassImpl$Data$declaredNonStaticMembers$2(List<UserContact> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        List<UserContact> list = p0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((UserContact) it.next()).KClassImpl$Data$declaredNonStaticMembers$2));
        }
        final ArrayList arrayList2 = arrayList;
        Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.sync_engine.data.source.local.ContactEntityDataLocal$removeContacts$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ContactEntityDataLocal.this.getDb().userContactDao().deleteContacts(arrayList2);
            }
        };
        Intrinsics.checkNotNullParameter(function0, "");
        Observable<Unit> fromCallable = Observable.fromCallable(new ContactEntityDataLocal$$ExternalSyntheticLambda4(function0));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<List<String>> MyBillsEntityDataFactory(List<UserContact> p0, boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        ?? r3 = 0;
        throw new NotImplementedError(r3, 1, r3);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Boolean> BuiltInFictitiousFunctionClassFactory(List<UserContact> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Long> KClassImpl$Data$declaredNonStaticMembers$2(SyncContactType p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<Long> create = Observable.create(new ContactEntityDataLocal$$ExternalSyntheticLambda3(this, p0));
        Intrinsics.checkNotNullExpressionValue(create, "");
        return create;
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final void KClassImpl$Data$declaredNonStaticMembers$2(SyncContactType p0, long p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.saveData(PlaceComponentResult(p0), Long.valueOf(p1));
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Long> getAuthRequestContext(final SyncContactType p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<Long> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.sync_engine.data.source.local.ContactEntityDataLocal$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ContactEntityDataLocal.PlaceComponentResult(ContactEntityDataLocal.this, p0);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final void BuiltInFictitiousFunctionClassFactory(SyncContactType p0, long p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Long l = this.MyBillsEntityDataFactory.getLong(BuiltInFictitiousFunctionClassFactory(p0));
        Intrinsics.checkNotNullExpressionValue(l, "");
        if (l.longValue() <= 0) {
            this.MyBillsEntityDataFactory.saveData(BuiltInFictitiousFunctionClassFactory(p0), Long.valueOf(p1));
        }
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final void PlaceComponentResult(SyncContactType p0, long p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.saveData(BuiltInFictitiousFunctionClassFactory(p0), Long.valueOf(p1));
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Boolean> lookAheadTest() {
        SyncContactType syncContactType = SyncContactType.Local;
        Intrinsics.checkNotNullParameter(syncContactType, "");
        Observable create = Observable.create(new ContactEntityDataLocal$$ExternalSyntheticLambda3(this, syncContactType));
        Intrinsics.checkNotNullExpressionValue(create, "");
        Observable<Boolean> map = create.map(new Function() { // from class: id.dana.sync_engine.data.source.local.ContactEntityDataLocal$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ContactEntityDataLocal.MyBillsEntityDataFactory(ContactEntityDataLocal.this, (Long) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
        this.MyBillsEntityDataFactory.saveData("lastIndexReSyncKey", Integer.valueOf(p0));
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Integer> MyBillsEntityDataFactory() {
        Observable<Integer> just = Observable.just(this.MyBillsEntityDataFactory.getInteger("lastIndexReSyncKey"));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    private static String PlaceComponentResult(SyncContactType p0) {
        int i = WhenMappings.PlaceComponentResult[p0.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return "lastSyncServerKey";
            }
            throw new NoWhenBranchMatchedException();
        }
        return "lastSyncLocalKey";
    }

    private static String BuiltInFictitiousFunctionClassFactory(SyncContactType p0) {
        int i = WhenMappings.PlaceComponentResult[p0.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return "start_count_re_sync_timestamp_server_key";
            }
            throw new NoWhenBranchMatchedException();
        }
        return "start_count_re_sync_timestamp_local_key";
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Boolean> getAuthRequestContext() {
        Observable<Boolean> just = Observable.just(this.MyBillsEntityDataFactory.getBoolean("isSyncPermission", false));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        this.MyBillsEntityDataFactory.saveData("isSyncPermission", Boolean.valueOf(p0));
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Long> scheduleImpl() {
        Observable<Long> just = Observable.just(this.MyBillsEntityDataFactory.getLong("permissionIntervalKey"));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final void MyBillsEntityDataFactory(long p0) {
        this.MyBillsEntityDataFactory.saveData("permissionIntervalKey", Long.valueOf(p0));
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final ContactSyncConfigResult MyBillsEntityDataFactory(SyncContactType p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        int i = WhenMappings.PlaceComponentResult[p0.ordinal()];
        if (i == 1) {
            Object obj = this.getAuthRequestContext.get("contactSyncConfig");
            if (obj instanceof ContactSyncConfigResult) {
                return (ContactSyncConfigResult) obj;
            }
            return null;
        } else if (i == 2) {
            String string = this.MyBillsEntityDataFactory.getString("contactSyncConfig");
            if (string != null) {
                if (!(string.length() > 0)) {
                    string = null;
                }
                if (string != null) {
                    return (ContactSyncConfigResult) this.KClassImpl$Data$declaredNonStaticMembers$2.fromJson(string, ContactSyncConfigResult.class);
                }
                return null;
            }
            return null;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final void getAuthRequestContext(SyncContactType p0, ContactSyncConfigResult p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        int i = WhenMappings.PlaceComponentResult[p0.ordinal()];
        if (i == 1) {
            this.getAuthRequestContext.put("contactSyncConfig", p1);
        } else if (i == 2) {
            this.MyBillsEntityDataFactory.saveData("contactSyncConfig", this.KClassImpl$Data$declaredNonStaticMembers$2.toJson(p1));
        }
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Unit> BuiltInFictitiousFunctionClassFactory() {
        Observable<Unit> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.sync_engine.data.source.local.ContactEntityDataLocal$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ContactEntityDataLocal.KClassImpl$Data$declaredNonStaticMembers$2(ContactEntityDataLocal.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Unit> NetworkUserEntityData$$ExternalSyntheticLambda0() {
        Observable<Unit> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.sync_engine.data.source.local.ContactEntityDataLocal$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ContactEntityDataLocal.BuiltInFictitiousFunctionClassFactory(ContactEntityDataLocal.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final void BuiltInFictitiousFunctionClassFactory(int p0) {
        this.MyBillsEntityDataFactory.saveData("uploadedContact", Integer.valueOf(p0));
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final int getErrorConfigVersion() {
        Integer integer = this.MyBillsEntityDataFactory.getInteger("uploadedContact");
        Intrinsics.checkNotNullExpressionValue(integer, "");
        return integer.intValue();
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<List<UserContact>> getAuthRequestContext(String p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        ?? r3 = 0;
        throw new NotImplementedError(r3, 1, r3);
    }

    public static /* synthetic */ Boolean MyBillsEntityDataFactory(ContactEntityDataLocal contactEntityDataLocal, Long l) {
        boolean z;
        Intrinsics.checkNotNullParameter(contactEntityDataLocal, "");
        Intrinsics.checkNotNullParameter(l, "");
        if (l.longValue() > 0) {
            contactEntityDataLocal.BuiltInFictitiousFunctionClassFactory(SyncContactType.Local, l.longValue());
            Unit unit = Unit.INSTANCE;
            SyncContactType syncContactType = SyncContactType.Local;
            Intrinsics.checkNotNullParameter(syncContactType, "");
            contactEntityDataLocal.MyBillsEntityDataFactory.saveData(PlaceComponentResult(syncContactType), (Long) (-1L));
            Unit unit2 = Unit.INSTANCE;
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public static /* synthetic */ void getAuthRequestContext(ContactEntityDataLocal contactEntityDataLocal, SyncContactType syncContactType, ObservableEmitter observableEmitter) {
        Intrinsics.checkNotNullParameter(contactEntityDataLocal, "");
        Intrinsics.checkNotNullParameter(syncContactType, "");
        Intrinsics.checkNotNullParameter(observableEmitter, "");
        observableEmitter.onNext(contactEntityDataLocal.MyBillsEntityDataFactory.getLong(PlaceComponentResult(syncContactType)));
    }

    public static /* synthetic */ List PlaceComponentResult(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(UserContactEntityKt.PlaceComponentResult((UserContactEntity) it.next()));
        }
        return arrayList;
    }

    public static /* synthetic */ Object BuiltInFictitiousFunctionClassFactory(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        Object invoke = function0.invoke();
        if (invoke != null) {
            return invoke;
        }
        throw new CallableReturnNullError("ContactEntityDataLocal#safeExecuteDatabase");
    }

    public static /* synthetic */ List getErrorConfigVersion(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(UserContactEntityKt.PlaceComponentResult((UserContactEntity) it.next()));
        }
        return arrayList;
    }

    public static /* synthetic */ Unit BuiltInFictitiousFunctionClassFactory(ContactEntityDataLocal contactEntityDataLocal) {
        Intrinsics.checkNotNullParameter(contactEntityDataLocal, "");
        contactEntityDataLocal.MyBillsEntityDataFactory.clearData("lastSyncLocalKey");
        contactEntityDataLocal.MyBillsEntityDataFactory.clearData("lastSyncServerKey");
        contactEntityDataLocal.MyBillsEntityDataFactory.clearData("start_count_re_sync_timestamp_local_key");
        contactEntityDataLocal.MyBillsEntityDataFactory.clearData("start_count_re_sync_timestamp_server_key");
        contactEntityDataLocal.MyBillsEntityDataFactory.clearData("lastIndexReSyncKey");
        contactEntityDataLocal.MyBillsEntityDataFactory.clearData("uploadedContact");
        contactEntityDataLocal.getDb().userContactDao().resetAll();
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Long PlaceComponentResult(ContactEntityDataLocal contactEntityDataLocal, SyncContactType syncContactType) {
        Intrinsics.checkNotNullParameter(contactEntityDataLocal, "");
        Intrinsics.checkNotNullParameter(syncContactType, "");
        Long l = contactEntityDataLocal.MyBillsEntityDataFactory.getLong(BuiltInFictitiousFunctionClassFactory(syncContactType));
        if (l != null) {
            return Long.valueOf(l.longValue());
        }
        throw new CallableReturnNullError("ContactEntityDataLocal#getStartCountReSyncTimeStamp");
    }

    public static /* synthetic */ Unit KClassImpl$Data$declaredNonStaticMembers$2(ContactEntityDataLocal contactEntityDataLocal) {
        Intrinsics.checkNotNullParameter(contactEntityDataLocal, "");
        contactEntityDataLocal.MyBillsEntityDataFactory.clearAllData();
        contactEntityDataLocal.getDb().userContactDao().clearAll();
        return Unit.INSTANCE;
    }
}

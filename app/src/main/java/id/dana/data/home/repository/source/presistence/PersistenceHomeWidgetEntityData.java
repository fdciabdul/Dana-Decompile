package id.dana.data.home.repository.source.presistence;

import dagger.Lazy;
import id.dana.data.base.BasePersistence;
import id.dana.data.base.BasePersistenceDao;
import id.dana.data.home.repository.source.presistence.entity.MoreForYouDaoEntity;
import id.dana.data.home.repository.source.presistence.entity.NewsWidgetActivityDaoEntity;
import id.dana.data.home.repository.source.presistence.entity.PromoBannerAnnouncementDaoEntity;
import id.dana.data.home.repository.source.presistence.entity.PromoBannerContentDaoEntity;
import id.dana.utils.diffalgorithm.MyersDiff;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\b\b\u0000\u0010\u0002*\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00110\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f"}, d2 = {"Lid/dana/data/home/repository/source/presistence/PersistenceHomeWidgetEntityData;", "Lid/dana/data/base/BasePersistence;", "T", "p0", "p1", "", "getAuthRequestContext", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "", "Lkotlin/Function0;", "Lio/reactivex/Observable;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lkotlin/jvm/functions/Function0;)Lio/reactivex/Observable;", "", "Lid/dana/data/home/repository/source/presistence/entity/MoreForYouDaoEntity;", "Ljava/util/List;", "MyBillsEntityDataFactory", "Lid/dana/data/home/repository/source/presistence/entity/NewsWidgetActivityDaoEntity;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/home/repository/source/presistence/entity/PromoBannerAnnouncementDaoEntity;", "PlaceComponentResult", "Lid/dana/data/home/repository/source/presistence/entity/PromoBannerContentDaoEntity;", "Ldagger/Lazy;", "Lid/dana/data/base/BasePersistenceDao;", "<init>", "(Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PersistenceHomeWidgetEntityData extends BasePersistence {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final List<NewsWidgetActivityDaoEntity> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final List<PromoBannerContentDaoEntity> PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final List<PromoBannerAnnouncementDaoEntity> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final List<MoreForYouDaoEntity> MyBillsEntityDataFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public PersistenceHomeWidgetEntityData(Lazy<BasePersistenceDao> lazy) {
        super(lazy);
        Intrinsics.checkNotNullParameter(lazy, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
        this.PlaceComponentResult = new ArrayList();
        this.BuiltInFictitiousFunctionClassFactory = new ArrayList();
        this.MyBillsEntityDataFactory = new ArrayList();
    }

    public static <T> Observable<T> KClassImpl$Data$declaredNonStaticMembers$2(final Function0<? extends T> p0) {
        Observable<T> defer = Observable.defer(new Callable() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$$ExternalSyntheticLambda8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PersistenceHomeWidgetEntityData.PlaceComponentResult(Function0.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> boolean getAuthRequestContext(T r2, T r3) {
        /*
            boolean r0 = r2 instanceof id.dana.data.home.repository.source.presistence.entity.NewsWidgetActivityDaoEntity
            if (r0 == 0) goto L15
            boolean r0 = r3 instanceof id.dana.data.home.repository.source.presistence.entity.NewsWidgetActivityDaoEntity
            if (r0 == 0) goto L15
            id.dana.data.home.repository.source.presistence.entity.NewsWidgetActivityDaoEntity r2 = (id.dana.data.home.repository.source.presistence.entity.NewsWidgetActivityDaoEntity) r2
            java.lang.String r2 = r2.MyBillsEntityDataFactory
            id.dana.data.home.repository.source.presistence.entity.NewsWidgetActivityDaoEntity r3 = (id.dana.data.home.repository.source.presistence.entity.NewsWidgetActivityDaoEntity) r3
            java.lang.String r3 = r3.MyBillsEntityDataFactory
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            goto L67
        L15:
            boolean r0 = r2 instanceof id.dana.data.home.repository.source.presistence.entity.PromoBannerContentDaoEntity
            if (r0 == 0) goto L32
            boolean r0 = r3 instanceof id.dana.data.home.repository.source.presistence.entity.PromoBannerContentDaoEntity
            if (r0 == 0) goto L32
            id.dana.data.home.repository.source.presistence.entity.PromoBannerContentDaoEntity r2 = (id.dana.data.home.repository.source.presistence.entity.PromoBannerContentDaoEntity) r2
            java.lang.String r0 = r2.getAuthRequestContext
            id.dana.data.home.repository.source.presistence.entity.PromoBannerContentDaoEntity r3 = (id.dana.data.home.repository.source.presistence.entity.PromoBannerContentDaoEntity) r3
            java.lang.String r1 = r3.getAuthRequestContext
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L66
            int r2 = r2.initRecordTimeStamp
            int r3 = r3.initRecordTimeStamp
            if (r2 != r3) goto L66
            goto L64
        L32:
            boolean r0 = r2 instanceof id.dana.data.home.repository.source.presistence.entity.PromoBannerAnnouncementDaoEntity
            if (r0 == 0) goto L47
            boolean r0 = r3 instanceof id.dana.data.home.repository.source.presistence.entity.PromoBannerAnnouncementDaoEntity
            if (r0 == 0) goto L47
            id.dana.data.home.repository.source.presistence.entity.PromoBannerAnnouncementDaoEntity r2 = (id.dana.data.home.repository.source.presistence.entity.PromoBannerAnnouncementDaoEntity) r2
            java.lang.String r2 = r2.initRecordTimeStamp
            id.dana.data.home.repository.source.presistence.entity.PromoBannerAnnouncementDaoEntity r3 = (id.dana.data.home.repository.source.presistence.entity.PromoBannerAnnouncementDaoEntity) r3
            java.lang.String r3 = r3.initRecordTimeStamp
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            goto L67
        L47:
            boolean r0 = r2 instanceof id.dana.data.home.repository.source.presistence.entity.MoreForYouDaoEntity
            if (r0 == 0) goto L66
            boolean r0 = r3 instanceof id.dana.data.home.repository.source.presistence.entity.MoreForYouDaoEntity
            if (r0 == 0) goto L66
            id.dana.data.home.repository.source.presistence.entity.MoreForYouDaoEntity r2 = (id.dana.data.home.repository.source.presistence.entity.MoreForYouDaoEntity) r2
            java.lang.String r0 = r2.KClassImpl$Data$declaredNonStaticMembers$2
            id.dana.data.home.repository.source.presistence.entity.MoreForYouDaoEntity r3 = (id.dana.data.home.repository.source.presistence.entity.MoreForYouDaoEntity) r3
            java.lang.String r1 = r3.KClassImpl$Data$declaredNonStaticMembers$2
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L66
            int r2 = r2.lookAheadTest
            int r3 = r3.lookAheadTest
            if (r2 == r3) goto L64
            goto L66
        L64:
            r2 = 1
            goto L67
        L66:
            r2 = 0
        L67:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData.getAuthRequestContext(java.lang.Object, java.lang.Object):boolean");
    }

    public static /* synthetic */ void getAuthRequestContext(PersistenceHomeWidgetEntityData persistenceHomeWidgetEntityData, List list) {
        Intrinsics.checkNotNullParameter(persistenceHomeWidgetEntityData, "");
        persistenceHomeWidgetEntityData.KClassImpl$Data$declaredNonStaticMembers$2.clear();
        List<NewsWidgetActivityDaoEntity> list2 = persistenceHomeWidgetEntityData.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(list, "");
        list2.addAll(list);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(PersistenceHomeWidgetEntityData persistenceHomeWidgetEntityData, List list) {
        Intrinsics.checkNotNullParameter(persistenceHomeWidgetEntityData, "");
        persistenceHomeWidgetEntityData.BuiltInFictitiousFunctionClassFactory.clear();
        List<PromoBannerAnnouncementDaoEntity> list2 = persistenceHomeWidgetEntityData.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(list, "");
        list2.addAll(list);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(PersistenceHomeWidgetEntityData persistenceHomeWidgetEntityData, List list) {
        Intrinsics.checkNotNullParameter(persistenceHomeWidgetEntityData, "");
        persistenceHomeWidgetEntityData.PlaceComponentResult.clear();
        List<PromoBannerContentDaoEntity> list2 = persistenceHomeWidgetEntityData.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(list, "");
        list2.addAll(list);
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(List list) {
        Observable just;
        Intrinsics.checkNotNullParameter(list, "");
        if (list.isEmpty()) {
            just = Observable.error(new NoSuchElementException());
        } else {
            just = Observable.just(list);
        }
        return just;
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(List list) {
        Observable just;
        Intrinsics.checkNotNullParameter(list, "");
        if (list.isEmpty()) {
            just = Observable.error(new NoSuchElementException());
        } else {
            just = Observable.just(list);
        }
        return just;
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(final Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PersistenceHomeWidgetEntityData.MyBillsEntityDataFactory(Function0.this);
            }
        });
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PersistenceHomeWidgetEntityData persistenceHomeWidgetEntityData, List list) {
        Intrinsics.checkNotNullParameter(persistenceHomeWidgetEntityData, "");
        persistenceHomeWidgetEntityData.MyBillsEntityDataFactory.clear();
        List<MoreForYouDaoEntity> list2 = persistenceHomeWidgetEntityData.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(list, "");
        list2.addAll(list);
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(List list) {
        Observable just;
        Intrinsics.checkNotNullParameter(list, "");
        if (list.isEmpty()) {
            just = Observable.error(new NoSuchElementException());
        } else {
            just = Observable.just(list);
        }
        return just;
    }

    public static /* synthetic */ Object MyBillsEntityDataFactory(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        return function0.invoke();
    }

    public static final /* synthetic */ Triple MyBillsEntityDataFactory(final PersistenceHomeWidgetEntityData persistenceHomeWidgetEntityData, final List list, final List list2) {
        final List mutableList = CollectionsKt.toMutableList((Collection) list2);
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        MyersDiff.BuiltInFictitiousFunctionClassFactory(list2.size(), list.size(), new Function2<Integer, Integer, Boolean>() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$doDiff$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Boolean invoke(Integer num, Integer num2) {
                return invoke(num.intValue(), num2.intValue());
            }

            public final Boolean invoke(int i, int i2) {
                boolean authRequestContext;
                authRequestContext = PersistenceHomeWidgetEntityData.getAuthRequestContext(list2.get(i), list.get(i2));
                return Boolean.valueOf(authRequestContext);
            }
        }).PlaceComponentResult(new Function1<MyersDiff.Change, Unit>() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$doDiff$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MyersDiff.Change change) {
                invoke2(change);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MyersDiff.Change change) {
                Intrinsics.checkNotNullParameter(change, "");
                if (change instanceof MyersDiff.Change.Insert) {
                    MyersDiff.Change.Insert insert = (MyersDiff.Change.Insert) change;
                    int i = insert.KClassImpl$Data$declaredNonStaticMembers$2;
                    int i2 = insert.BuiltInFictitiousFunctionClassFactory;
                    while (i < insert.KClassImpl$Data$declaredNonStaticMembers$2 + insert.MyBillsEntityDataFactory) {
                        arrayList.add(list.get(i2));
                        mutableList.add(i, list.get(i2));
                        i++;
                        i2++;
                    }
                } else if (change instanceof MyersDiff.Change.Remove) {
                    MyersDiff.Change.Remove remove = (MyersDiff.Change.Remove) change;
                    int i3 = (remove.MyBillsEntityDataFactory + remove.BuiltInFictitiousFunctionClassFactory) - 1;
                    for (int i4 = remove.BuiltInFictitiousFunctionClassFactory; i4 > 0; i4--) {
                        arrayList2.add(mutableList.get(i3));
                        mutableList.remove(i3);
                        i3--;
                    }
                }
            }
        });
        return new Triple(arrayList, arrayList2, mutableList);
    }
}

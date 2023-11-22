package id.dana.explore.data.userpersonalization;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.explore.data.toggle.ExploreConfigEntityData;
import id.dana.explore.data.toggle.source.ExploreConfigEntityDataFactory;
import id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData;
import id.dana.explore.data.userpersonalization.mapper.PreferenceOptionMapperKt;
import id.dana.explore.data.userpersonalization.source.UserPersonalizationEntityDataFactory;
import id.dana.explore.data.userpersonalization.source.network.request.CreateUserPersonalizationRequest;
import id.dana.explore.data.userpersonalization.source.network.result.PreferenceOptionInfoEntity;
import id.dana.explore.data.userpersonalization.source.network.result.PreferenceOptionListEntity;
import id.dana.explore.data.userpersonalization.source.network.result.UserPreferenceInfoEntity;
import id.dana.explore.data.userpersonalization.source.network.result.UserPreferenceResultEntity;
import id.dana.explore.domain.userpersonalization.UserPersonalizationRepository;
import id.dana.explore.domain.userpersonalization.model.UserPersonalizationModel;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u001a\u0012\u0006\u0010\n\u001a\u00020\u0012\u0012\u0006\u0010\u001e\u001a\u00020\u0014¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0016¢\u0006\u0004\b\u0007\u0010\u000bJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\bJ\u001b\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\t0\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\u000eJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015R\u0013\u0010\f\u001a\u00020\u0017X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0018R\u0013\u0010\u0011\u001a\u00020\u0017X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0018R\u0013\u0010\u000f\u001a\u00020\u0019X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\f\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/explore/data/userpersonalization/UserPersonalizationEntityRepository;", "Lid/dana/explore/domain/userpersonalization/UserPersonalizationRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "", "p0", "Lio/reactivex/Observable;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "p1", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "getAuthRequestContext", "Lid/dana/explore/domain/userpersonalization/model/UserPersonalizationModel;", "()Lio/reactivex/Observable;", "MyBillsEntityDataFactory", "", "PlaceComponentResult", "Lid/dana/explore/data/toggle/source/ExploreConfigEntityDataFactory;", "Lid/dana/explore/data/toggle/source/ExploreConfigEntityDataFactory;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/explore/data/userpersonalization/UserPersonalizationEntityData;", "Lkotlin/Lazy;", "Lid/dana/explore/data/toggle/ExploreConfigEntityData;", "Lid/dana/explore/data/userpersonalization/source/UserPersonalizationEntityDataFactory;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/explore/data/userpersonalization/source/UserPersonalizationEntityDataFactory;", "scheduleImpl", "p2", "<init>", "(Lid/dana/explore/data/userpersonalization/source/UserPersonalizationEntityDataFactory;Lid/dana/explore/data/toggle/source/ExploreConfigEntityDataFactory;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UserPersonalizationEntityRepository implements UserPersonalizationRepository, HoldLoginV1Repository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult;
    private final ExploreConfigEntityDataFactory KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final HoldLoginV1EntityRepository BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final UserPersonalizationEntityDataFactory scheduleImpl;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;

    @Inject
    public UserPersonalizationEntityRepository(UserPersonalizationEntityDataFactory userPersonalizationEntityDataFactory, ExploreConfigEntityDataFactory exploreConfigEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(userPersonalizationEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(exploreConfigEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.scheduleImpl = userPersonalizationEntityDataFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = exploreConfigEntityDataFactory;
        this.BuiltInFictitiousFunctionClassFactory = holdLoginV1EntityRepository;
        this.PlaceComponentResult = LazyKt.lazy(new Function0<UserPersonalizationEntityData>() { // from class: id.dana.explore.data.userpersonalization.UserPersonalizationEntityRepository$networkUserPersonalizationEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UserPersonalizationEntityData invoke() {
                UserPersonalizationEntityDataFactory userPersonalizationEntityDataFactory2;
                userPersonalizationEntityDataFactory2 = UserPersonalizationEntityRepository.this.scheduleImpl;
                return userPersonalizationEntityDataFactory2.createData2("network");
            }
        });
        this.getAuthRequestContext = LazyKt.lazy(new Function0<UserPersonalizationEntityData>() { // from class: id.dana.explore.data.userpersonalization.UserPersonalizationEntityRepository$localUserPersonalizationEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UserPersonalizationEntityData invoke() {
                UserPersonalizationEntityDataFactory userPersonalizationEntityDataFactory2;
                userPersonalizationEntityDataFactory2 = UserPersonalizationEntityRepository.this.scheduleImpl;
                return userPersonalizationEntityDataFactory2.createData2("local");
            }
        });
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<ExploreConfigEntityData>() { // from class: id.dana.explore.data.userpersonalization.UserPersonalizationEntityRepository$splitExploreConfigEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExploreConfigEntityData invoke() {
                ExploreConfigEntityDataFactory exploreConfigEntityDataFactory2;
                exploreConfigEntityDataFactory2 = UserPersonalizationEntityRepository.this.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullParameter("split", "");
                SplitExploreConfigEntityData splitExploreConfigEntityData = exploreConfigEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2.get();
                Intrinsics.checkNotNullExpressionValue(splitExploreConfigEntityData, "");
                return splitExploreConfigEntityData;
            }
        });
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(UserPersonalizationEntityRepository userPersonalizationEntityRepository, String str, List list, BaseRpcResult baseRpcResult) {
        Intrinsics.checkNotNullParameter(userPersonalizationEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        if (baseRpcResult.success) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(list, "");
            ((UserPersonalizationEntityData) userPersonalizationEntityRepository.getAuthRequestContext.getValue()).BuiltInFictitiousFunctionClassFactory(str, list);
        }
    }

    public static /* synthetic */ List PlaceComponentResult(PreferenceOptionListEntity preferenceOptionListEntity) {
        Intrinsics.checkNotNullParameter(preferenceOptionListEntity, "");
        List<PreferenceOptionInfoEntity> preferenceOptions = preferenceOptionListEntity.getPreferenceOptions();
        if (preferenceOptions != null) {
            return PreferenceOptionMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(preferenceOptions);
        }
        return null;
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(final UserPersonalizationEntityRepository userPersonalizationEntityRepository, final String str, List list) {
        Observable just;
        Intrinsics.checkNotNullParameter(userPersonalizationEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        if (!list.isEmpty()) {
            just = Observable.just(Boolean.TRUE);
            Intrinsics.checkNotNullExpressionValue(just, "");
        } else {
            Observable<UserPreferenceResultEntity> MyBillsEntityDataFactory = ((UserPersonalizationEntityData) userPersonalizationEntityRepository.PlaceComponentResult.getValue()).MyBillsEntityDataFactory(str);
            Intrinsics.checkNotNullParameter(MyBillsEntityDataFactory, "");
            Observable authenticatedRequest = userPersonalizationEntityRepository.BuiltInFictitiousFunctionClassFactory.authenticatedRequest(MyBillsEntityDataFactory);
            Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
            just = authenticatedRequest.flatMap(new Function() { // from class: id.dana.explore.data.userpersonalization.UserPersonalizationEntityRepository$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return UserPersonalizationEntityRepository.PlaceComponentResult(UserPersonalizationEntityRepository.this, str, (UserPreferenceResultEntity) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(just, "");
        }
        return just;
    }

    public static /* synthetic */ Boolean getAuthRequestContext(UserPreferenceResultEntity userPreferenceResultEntity) {
        Intrinsics.checkNotNullParameter(userPreferenceResultEntity, "");
        List<UserPreferenceInfoEntity> searchResultList = userPreferenceResultEntity.getSearchResultList();
        return Boolean.valueOf(searchResultList == null || searchResultList.isEmpty());
    }

    public static /* synthetic */ Boolean KClassImpl$Data$declaredNonStaticMembers$2(BaseRpcResult baseRpcResult) {
        Intrinsics.checkNotNullParameter(baseRpcResult, "");
        return Boolean.valueOf(baseRpcResult.success);
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(UserPersonalizationEntityRepository userPersonalizationEntityRepository, String str, UserPreferenceResultEntity userPreferenceResultEntity) {
        ArrayList arrayList;
        Observable<Boolean> BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(userPersonalizationEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(userPreferenceResultEntity, "");
        List<UserPreferenceInfoEntity> searchResultList = userPreferenceResultEntity.getSearchResultList();
        if (searchResultList != null) {
            List<UserPreferenceInfoEntity> list = searchResultList;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                String preferenceId = ((UserPreferenceInfoEntity) it.next()).getPreferenceId();
                if (preferenceId == null) {
                    preferenceId = "";
                }
                arrayList2.add(preferenceId);
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        ArrayList arrayList3 = arrayList;
        if (arrayList3 == null || arrayList3.isEmpty()) {
            BuiltInFictitiousFunctionClassFactory = Observable.just(Boolean.FALSE);
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        } else {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(arrayList, "");
            BuiltInFictitiousFunctionClassFactory = ((UserPersonalizationEntityData) userPersonalizationEntityRepository.getAuthRequestContext.getValue()).BuiltInFictitiousFunctionClassFactory(str, arrayList);
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(UserPersonalizationEntityRepository userPersonalizationEntityRepository, String str, Boolean bool) {
        Observable just;
        Intrinsics.checkNotNullParameter(userPersonalizationEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(bool, "");
        if (!bool.booleanValue()) {
            just = ((UserPersonalizationEntityData) userPersonalizationEntityRepository.PlaceComponentResult.getValue()).MyBillsEntityDataFactory(str).map(new Function() { // from class: id.dana.explore.data.userpersonalization.UserPersonalizationEntityRepository$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return UserPersonalizationEntityRepository.getAuthRequestContext((UserPreferenceResultEntity) obj);
                }
            });
        } else {
            just = Observable.just(Boolean.FALSE);
        }
        return just;
    }

    @Override // id.dana.explore.domain.userpersonalization.UserPersonalizationRepository
    public final Observable<Boolean> KClassImpl$Data$declaredNonStaticMembers$2(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable flatMap = ((UserPersonalizationEntityData) this.getAuthRequestContext.getValue()).MyBillsEntityDataFactory().flatMap(new Function() { // from class: id.dana.explore.data.userpersonalization.UserPersonalizationEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserPersonalizationEntityRepository.PlaceComponentResult(UserPersonalizationEntityRepository.this, p0, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.explore.domain.userpersonalization.UserPersonalizationRepository
    public final Observable<Boolean> KClassImpl$Data$declaredNonStaticMembers$2(final String p0, final List<String> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Observable map = ((UserPersonalizationEntityData) this.PlaceComponentResult.getValue()).BuiltInFictitiousFunctionClassFactory(new CreateUserPersonalizationRequest(p0, p1)).doOnNext(new Consumer() { // from class: id.dana.explore.data.userpersonalization.UserPersonalizationEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UserPersonalizationEntityRepository.BuiltInFictitiousFunctionClassFactory(UserPersonalizationEntityRepository.this, p0, p1, (BaseRpcResult) obj);
            }
        }).map(new Function() { // from class: id.dana.explore.data.userpersonalization.UserPersonalizationEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserPersonalizationEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2((BaseRpcResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.explore.domain.userpersonalization.UserPersonalizationRepository
    public final Observable<Boolean> getAuthRequestContext(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable flatMap = ((UserPersonalizationEntityData) this.getAuthRequestContext.getValue()).BuiltInFictitiousFunctionClassFactory(p0).flatMap(new Function() { // from class: id.dana.explore.data.userpersonalization.UserPersonalizationEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserPersonalizationEntityRepository.MyBillsEntityDataFactory(UserPersonalizationEntityRepository.this, p0, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.explore.domain.userpersonalization.UserPersonalizationRepository
    public final Observable<List<UserPersonalizationModel>> KClassImpl$Data$declaredNonStaticMembers$2() {
        Observable map = ((UserPersonalizationEntityData) this.PlaceComponentResult.getValue()).PlaceComponentResult().map(new Function() { // from class: id.dana.explore.data.userpersonalization.UserPersonalizationEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserPersonalizationEntityRepository.PlaceComponentResult((PreferenceOptionListEntity) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.explore.domain.userpersonalization.UserPersonalizationRepository
    public final Observable<Boolean> MyBillsEntityDataFactory() {
        return ((ExploreConfigEntityData) this.MyBillsEntityDataFactory.getValue()).getErrorConfigVersion();
    }

    @Override // id.dana.explore.domain.userpersonalization.UserPersonalizationRepository
    public final Observable<Unit> PlaceComponentResult() {
        return ((UserPersonalizationEntityData) this.getAuthRequestContext.getValue()).BuiltInFictitiousFunctionClassFactory();
    }
}

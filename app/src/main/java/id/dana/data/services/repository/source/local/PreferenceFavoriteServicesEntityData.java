package id.dana.data.services.repository.source.local;

import id.dana.data.account.AccountEntity;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.services.repository.source.FavoriteServicesEntityData;
import id.dana.data.services.repository.source.model.CategoryHighlightedFeature;
import id.dana.data.services.repository.source.model.ServiceHighlighted;
import id.dana.domain.services.model.ThirdPartyCategoryService;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import j$.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b&\u0010'J'\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\tJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\tJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\tJ%\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0007J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\tJ\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00042\u0006\u0010\u0019\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00160\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\tJ\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00042\u0006\u0010\u0019\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%"}, d2 = {"Lid/dana/data/services/repository/source/local/PreferenceFavoriteServicesEntityData;", "Lid/dana/data/services/repository/source/FavoriteServicesEntityData;", "", "services", "Lio/reactivex/Observable;", "", "mapToListOfString", "(Ljava/util/List;)Lio/reactivex/Observable;", "getPhoneNumber", "()Lio/reactivex/Observable;", "Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "getFavoriteServices", "Lid/dana/domain/services/model/ThirdPartyCategoryService;", "getFavoriteServicesCache", "", "clearCacheFavoriteServices", "saveFavoriteServices", "favoriteServiceCache", "saveFavoriteServiceCache", "(Lid/dana/domain/services/model/ThirdPartyCategoryService;)Lio/reactivex/Observable;", "Lj$/util/Optional;", "Lid/dana/data/services/repository/source/model/CategoryHighlightedFeature;", "getCategoryHighlightedFeature", "data", "saveCategoryHighlightedFeature", "(Lid/dana/data/services/repository/source/model/CategoryHighlightedFeature;)Lio/reactivex/Observable;", "Lid/dana/data/services/repository/source/model/ServiceHighlighted;", "getServiceHighlighted", "saveServiceHighlighted", "(Lid/dana/data/services/repository/source/model/ServiceHighlighted;)Lio/reactivex/Observable;", "Lid/dana/data/services/repository/source/local/FavoriteServicesPreference;", "favoriteServicesPreference", "Lid/dana/data/services/repository/source/local/FavoriteServicesPreference;", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "accountEntityDataFactory", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "<init>", "(Lid/dana/data/services/repository/source/local/FavoriteServicesPreference;Lid/dana/data/account/repository/source/AccountEntityDataFactory;)V"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class PreferenceFavoriteServicesEntityData implements FavoriteServicesEntityData {
    private final AccountEntityDataFactory accountEntityDataFactory;
    private final FavoriteServicesPreference favoriteServicesPreference;

    @Inject
    public PreferenceFavoriteServicesEntityData(FavoriteServicesPreference favoriteServicesPreference, AccountEntityDataFactory accountEntityDataFactory) {
        Intrinsics.checkNotNullParameter(favoriteServicesPreference, "");
        Intrinsics.checkNotNullParameter(accountEntityDataFactory, "");
        this.favoriteServicesPreference = favoriteServicesPreference;
        this.accountEntityDataFactory = accountEntityDataFactory;
    }

    @Override // id.dana.data.services.repository.source.FavoriteServicesEntityData
    public final Observable<List<String>> getFavoriteServices() {
        Observable<List<String>> onErrorResumeNext = getPhoneNumber().flatMap(new Function() { // from class: id.dana.data.services.repository.source.local.PreferenceFavoriteServicesEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2011getFavoriteServices$lambda0;
                m2011getFavoriteServices$lambda0 = PreferenceFavoriteServicesEntityData.m2011getFavoriteServices$lambda0(PreferenceFavoriteServicesEntityData.this, (String) obj);
                return m2011getFavoriteServices$lambda0;
            }
        }).onErrorResumeNext(Observable.just(new ArrayList()));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getFavoriteServices$lambda-0  reason: not valid java name */
    public static final ObservableSource m2011getFavoriteServices$lambda0(PreferenceFavoriteServicesEntityData preferenceFavoriteServicesEntityData, String str) {
        Intrinsics.checkNotNullParameter(preferenceFavoriteServicesEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        return preferenceFavoriteServicesEntityData.mapToListOfString(preferenceFavoriteServicesEntityData.favoriteServicesPreference.getFavoriteServices(str));
    }

    @Override // id.dana.data.services.repository.source.FavoriteServicesEntityData
    public final Observable<ThirdPartyCategoryService> getFavoriteServicesCache() {
        ThirdPartyCategoryService favoriteServicesCache = this.favoriteServicesPreference.getFavoriteServicesCache("");
        if (favoriteServicesCache == null) {
            Observable map = getPhoneNumber().map(new Function() { // from class: id.dana.data.services.repository.source.local.PreferenceFavoriteServicesEntityData$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ThirdPartyCategoryService m2012getFavoriteServicesCache$lambda1;
                    m2012getFavoriteServicesCache$lambda1 = PreferenceFavoriteServicesEntityData.m2012getFavoriteServicesCache$lambda1(PreferenceFavoriteServicesEntityData.this, (String) obj);
                    return m2012getFavoriteServicesCache$lambda1;
                }
            });
            Intrinsics.checkNotNullExpressionValue(map, "");
            return map;
        }
        Observable<ThirdPartyCategoryService> just = Observable.just(favoriteServicesCache);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getFavoriteServicesCache$lambda-1  reason: not valid java name */
    public static final ThirdPartyCategoryService m2012getFavoriteServicesCache$lambda1(PreferenceFavoriteServicesEntityData preferenceFavoriteServicesEntityData, String str) {
        Intrinsics.checkNotNullParameter(preferenceFavoriteServicesEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        return preferenceFavoriteServicesEntityData.favoriteServicesPreference.getFavoriteServicesCache(str);
    }

    @Override // id.dana.data.services.repository.source.FavoriteServicesEntityData
    public final Observable<Boolean> clearCacheFavoriteServices() {
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.favoriteServicesPreference.clearAll()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    private final Observable<List<String>> mapToListOfString(List<?> services) {
        List<?> list = services;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next()));
        }
        Observable<List<String>> just = Observable.just(arrayList);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.services.repository.source.FavoriteServicesEntityData
    public final Observable<Boolean> saveFavoriteServices(final List<String> services) {
        Observable flatMap = getPhoneNumber().flatMap(new Function() { // from class: id.dana.data.services.repository.source.local.PreferenceFavoriteServicesEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2018saveFavoriteServices$lambda3;
                m2018saveFavoriteServices$lambda3 = PreferenceFavoriteServicesEntityData.m2018saveFavoriteServices$lambda3(PreferenceFavoriteServicesEntityData.this, services, (String) obj);
                return m2018saveFavoriteServices$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveFavoriteServices$lambda-3  reason: not valid java name */
    public static final ObservableSource m2018saveFavoriteServices$lambda3(PreferenceFavoriteServicesEntityData preferenceFavoriteServicesEntityData, List list, String str) {
        Intrinsics.checkNotNullParameter(preferenceFavoriteServicesEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        return Observable.just(Boolean.valueOf(preferenceFavoriteServicesEntityData.favoriteServicesPreference.saveFavoriteServices(list, str)));
    }

    @Override // id.dana.data.services.repository.source.FavoriteServicesEntityData
    public final Observable<Boolean> saveFavoriteServiceCache(ThirdPartyCategoryService favoriteServiceCache) {
        Intrinsics.checkNotNullParameter(favoriteServiceCache, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.favoriteServicesPreference.saveFavoriteServiceCache(favoriteServiceCache)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.services.repository.source.FavoriteServicesEntityData
    public final Observable<Optional<CategoryHighlightedFeature>> getCategoryHighlightedFeature() {
        Observable flatMap = getPhoneNumber().flatMap(new Function() { // from class: id.dana.data.services.repository.source.local.PreferenceFavoriteServicesEntityData$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2009getCategoryHighlightedFeature$lambda5;
                m2009getCategoryHighlightedFeature$lambda5 = PreferenceFavoriteServicesEntityData.m2009getCategoryHighlightedFeature$lambda5(PreferenceFavoriteServicesEntityData.this, (String) obj);
                return m2009getCategoryHighlightedFeature$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getCategoryHighlightedFeature$lambda-5  reason: not valid java name */
    public static final ObservableSource m2009getCategoryHighlightedFeature$lambda5(final PreferenceFavoriteServicesEntityData preferenceFavoriteServicesEntityData, final String str) {
        Intrinsics.checkNotNullParameter(preferenceFavoriteServicesEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.services.repository.source.local.PreferenceFavoriteServicesEntityData$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Optional m2010getCategoryHighlightedFeature$lambda5$lambda4;
                m2010getCategoryHighlightedFeature$lambda5$lambda4 = PreferenceFavoriteServicesEntityData.m2010getCategoryHighlightedFeature$lambda5$lambda4(PreferenceFavoriteServicesEntityData.this, str);
                return m2010getCategoryHighlightedFeature$lambda5$lambda4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getCategoryHighlightedFeature$lambda-5$lambda-4  reason: not valid java name */
    public static final Optional m2010getCategoryHighlightedFeature$lambda5$lambda4(PreferenceFavoriteServicesEntityData preferenceFavoriteServicesEntityData, String str) {
        Intrinsics.checkNotNullParameter(preferenceFavoriteServicesEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        return Optional.BuiltInFictitiousFunctionClassFactory(preferenceFavoriteServicesEntityData.favoriteServicesPreference.getCategoryHighlightedFeature(str));
    }

    @Override // id.dana.data.services.repository.source.FavoriteServicesEntityData
    public final Observable<CategoryHighlightedFeature> saveCategoryHighlightedFeature(final CategoryHighlightedFeature data) {
        Intrinsics.checkNotNullParameter(data, "");
        Observable flatMap = getPhoneNumber().flatMap(new Function() { // from class: id.dana.data.services.repository.source.local.PreferenceFavoriteServicesEntityData$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2016saveCategoryHighlightedFeature$lambda8;
                m2016saveCategoryHighlightedFeature$lambda8 = PreferenceFavoriteServicesEntityData.m2016saveCategoryHighlightedFeature$lambda8(PreferenceFavoriteServicesEntityData.this, data, (String) obj);
                return m2016saveCategoryHighlightedFeature$lambda8;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveCategoryHighlightedFeature$lambda-8  reason: not valid java name */
    public static final ObservableSource m2016saveCategoryHighlightedFeature$lambda8(final PreferenceFavoriteServicesEntityData preferenceFavoriteServicesEntityData, final CategoryHighlightedFeature categoryHighlightedFeature, final String str) {
        Intrinsics.checkNotNullParameter(preferenceFavoriteServicesEntityData, "");
        Intrinsics.checkNotNullParameter(categoryHighlightedFeature, "");
        Intrinsics.checkNotNullParameter(str, "");
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.services.repository.source.local.PreferenceFavoriteServicesEntityData$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                CategoryHighlightedFeature m2017saveCategoryHighlightedFeature$lambda8$lambda7;
                m2017saveCategoryHighlightedFeature$lambda8$lambda7 = PreferenceFavoriteServicesEntityData.m2017saveCategoryHighlightedFeature$lambda8$lambda7(PreferenceFavoriteServicesEntityData.this, str, categoryHighlightedFeature);
                return m2017saveCategoryHighlightedFeature$lambda8$lambda7;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveCategoryHighlightedFeature$lambda-8$lambda-7  reason: not valid java name */
    public static final CategoryHighlightedFeature m2017saveCategoryHighlightedFeature$lambda8$lambda7(PreferenceFavoriteServicesEntityData preferenceFavoriteServicesEntityData, String str, CategoryHighlightedFeature categoryHighlightedFeature) {
        Intrinsics.checkNotNullParameter(preferenceFavoriteServicesEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(categoryHighlightedFeature, "");
        preferenceFavoriteServicesEntityData.favoriteServicesPreference.saveCategoryHighlightedFeature(str, categoryHighlightedFeature);
        Unit unit = Unit.INSTANCE;
        return categoryHighlightedFeature;
    }

    @Override // id.dana.data.services.repository.source.FavoriteServicesEntityData
    public final Observable<Optional<ServiceHighlighted>> getServiceHighlighted() {
        Observable flatMap = getPhoneNumber().flatMap(new Function() { // from class: id.dana.data.services.repository.source.local.PreferenceFavoriteServicesEntityData$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2014getServiceHighlighted$lambda10;
                m2014getServiceHighlighted$lambda10 = PreferenceFavoriteServicesEntityData.m2014getServiceHighlighted$lambda10(PreferenceFavoriteServicesEntityData.this, (String) obj);
                return m2014getServiceHighlighted$lambda10;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getServiceHighlighted$lambda-10  reason: not valid java name */
    public static final ObservableSource m2014getServiceHighlighted$lambda10(final PreferenceFavoriteServicesEntityData preferenceFavoriteServicesEntityData, final String str) {
        Intrinsics.checkNotNullParameter(preferenceFavoriteServicesEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.services.repository.source.local.PreferenceFavoriteServicesEntityData$$ExternalSyntheticLambda8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Optional m2015getServiceHighlighted$lambda10$lambda9;
                m2015getServiceHighlighted$lambda10$lambda9 = PreferenceFavoriteServicesEntityData.m2015getServiceHighlighted$lambda10$lambda9(PreferenceFavoriteServicesEntityData.this, str);
                return m2015getServiceHighlighted$lambda10$lambda9;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getServiceHighlighted$lambda-10$lambda-9  reason: not valid java name */
    public static final Optional m2015getServiceHighlighted$lambda10$lambda9(PreferenceFavoriteServicesEntityData preferenceFavoriteServicesEntityData, String str) {
        Intrinsics.checkNotNullParameter(preferenceFavoriteServicesEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        return Optional.BuiltInFictitiousFunctionClassFactory(preferenceFavoriteServicesEntityData.favoriteServicesPreference.getServiceHighlighted(str));
    }

    @Override // id.dana.data.services.repository.source.FavoriteServicesEntityData
    public final Observable<ServiceHighlighted> saveServiceHighlighted(final ServiceHighlighted data) {
        Intrinsics.checkNotNullParameter(data, "");
        Observable flatMap = getPhoneNumber().flatMap(new Function() { // from class: id.dana.data.services.repository.source.local.PreferenceFavoriteServicesEntityData$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2019saveServiceHighlighted$lambda13;
                m2019saveServiceHighlighted$lambda13 = PreferenceFavoriteServicesEntityData.m2019saveServiceHighlighted$lambda13(PreferenceFavoriteServicesEntityData.this, data, (String) obj);
                return m2019saveServiceHighlighted$lambda13;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveServiceHighlighted$lambda-13  reason: not valid java name */
    public static final ObservableSource m2019saveServiceHighlighted$lambda13(final PreferenceFavoriteServicesEntityData preferenceFavoriteServicesEntityData, final ServiceHighlighted serviceHighlighted, final String str) {
        Intrinsics.checkNotNullParameter(preferenceFavoriteServicesEntityData, "");
        Intrinsics.checkNotNullParameter(serviceHighlighted, "");
        Intrinsics.checkNotNullParameter(str, "");
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.services.repository.source.local.PreferenceFavoriteServicesEntityData$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ServiceHighlighted m2020saveServiceHighlighted$lambda13$lambda12;
                m2020saveServiceHighlighted$lambda13$lambda12 = PreferenceFavoriteServicesEntityData.m2020saveServiceHighlighted$lambda13$lambda12(PreferenceFavoriteServicesEntityData.this, str, serviceHighlighted);
                return m2020saveServiceHighlighted$lambda13$lambda12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveServiceHighlighted$lambda-13$lambda-12  reason: not valid java name */
    public static final ServiceHighlighted m2020saveServiceHighlighted$lambda13$lambda12(PreferenceFavoriteServicesEntityData preferenceFavoriteServicesEntityData, String str, ServiceHighlighted serviceHighlighted) {
        Intrinsics.checkNotNullParameter(preferenceFavoriteServicesEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(serviceHighlighted, "");
        preferenceFavoriteServicesEntityData.favoriteServicesPreference.saveServiceHighlighted(str, serviceHighlighted);
        Unit unit = Unit.INSTANCE;
        return serviceHighlighted;
    }

    private final Observable<String> getPhoneNumber() {
        Observable map = createAccountData().getAccount().map(new Function() { // from class: id.dana.data.services.repository.source.local.PreferenceFavoriteServicesEntityData$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String m2013getPhoneNumber$lambda14;
                m2013getPhoneNumber$lambda14 = PreferenceFavoriteServicesEntityData.m2013getPhoneNumber$lambda14((AccountEntity) obj);
                return m2013getPhoneNumber$lambda14;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPhoneNumber$lambda-14  reason: not valid java name */
    public static final String m2013getPhoneNumber$lambda14(AccountEntity accountEntity) {
        Intrinsics.checkNotNullParameter(accountEntity, "");
        return accountEntity.getPhoneNumber();
    }

    private final AccountEntityData createAccountData() {
        AccountEntityData createData2 = this.accountEntityDataFactory.createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        return createData2;
    }
}

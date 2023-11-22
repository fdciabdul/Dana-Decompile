package id.dana.data.services.repository.source.local;

import id.dana.danah5.DanaH5;
import id.dana.data.homeinfo.model.ThirdPartyEntity;
import id.dana.data.services.repository.source.ServicesEntityData;
import id.dana.data.services.repository.source.model.CategoryHighlightedFeature;
import id.dana.data.services.repository.source.model.CategoryServices;
import id.dana.data.services.repository.source.model.DefaultServiceCategory;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Singleton
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0002H\u0016¢\u0006\u0004\b\r\u0010\bJ\u001b\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u001b\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00050\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\bJ\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u000b"}, d2 = {"Lid/dana/data/services/repository/source/local/DefaultServicesEntityData;", "Lid/dana/data/services/repository/source/ServicesEntityData;", "Lio/reactivex/Observable;", "", "", "", "Lid/dana/data/homeinfo/model/ThirdPartyEntity;", "getAllServices", "()Lio/reactivex/Observable;", "category", "getCategories", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/services/repository/source/model/CategoryHighlightedFeature;", "getCategoryHighlightedFeature", "getRawServices", "Lid/dana/data/services/repository/source/model/CategoryServices;", "getSections", DanaH5.SERVICE_KEY, "getService", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DefaultServicesEntityData implements ServicesEntityData {
    @Inject
    public DefaultServicesEntityData() {
    }

    @Override // id.dana.data.services.repository.source.ServicesEntityData
    public final Observable<List<CategoryServices>> getSections() {
        Observable<List<CategoryServices>> just = Observable.just(CategoryServices.INSTANCE.getDefault());
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.services.repository.source.ServicesEntityData
    public final Observable<List<String>> getCategories(final String category) {
        Intrinsics.checkNotNullParameter(category, "");
        Observable<List<String>> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.services.repository.source.local.DefaultServicesEntityData$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List m2003getCategories$lambda0;
                m2003getCategories$lambda0 = DefaultServicesEntityData.m2003getCategories$lambda0(category);
                return m2003getCategories$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getCategories$lambda-0  reason: not valid java name */
    public static final List m2003getCategories$lambda0(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        List<String> list = DefaultServiceCategory.INSTANCE.getDefaultCategory().get(str);
        return list == null ? CollectionsKt.emptyList() : list;
    }

    @Override // id.dana.data.services.repository.source.ServicesEntityData
    public final Observable<List<ThirdPartyEntity>> getRawServices() {
        Observable<List<ThirdPartyEntity>> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.services.repository.source.local.DefaultServicesEntityData$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List m2005getRawServices$lambda1;
                m2005getRawServices$lambda1 = DefaultServicesEntityData.m2005getRawServices$lambda1();
                return m2005getRawServices$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRawServices$lambda-1  reason: not valid java name */
    public static final List m2005getRawServices$lambda1() {
        return SequencesKt.toList(SequencesKt.distinctBy(SequencesKt.filter(SequencesKt.map(MapsKt.asSequence(DefaultServiceCategory.INSTANCE.getDefaultServices()), new Function1<Map.Entry<? extends String, ? extends ThirdPartyEntity>, ThirdPartyEntity>() { // from class: id.dana.data.services.repository.source.local.DefaultServicesEntityData$getRawServices$1$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final ThirdPartyEntity invoke2(Map.Entry<String, ThirdPartyEntity> entry) {
                Intrinsics.checkNotNullParameter(entry, "");
                ThirdPartyEntity value = entry.getValue();
                value.setKey(entry.getKey());
                return value;
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ ThirdPartyEntity invoke(Map.Entry<? extends String, ? extends ThirdPartyEntity> entry) {
                return invoke2((Map.Entry<String, ThirdPartyEntity>) entry);
            }
        }), new Function1<ThirdPartyEntity, Boolean>() { // from class: id.dana.data.services.repository.source.local.DefaultServicesEntityData$getRawServices$1$2
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(ThirdPartyEntity thirdPartyEntity) {
                Intrinsics.checkNotNullParameter(thirdPartyEntity, "");
                return Boolean.valueOf(thirdPartyEntity.getEnable());
            }
        }), new Function1<ThirdPartyEntity, String>() { // from class: id.dana.data.services.repository.source.local.DefaultServicesEntityData$getRawServices$1$3
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(ThirdPartyEntity thirdPartyEntity) {
                Intrinsics.checkNotNullParameter(thirdPartyEntity, "");
                return thirdPartyEntity.getKey();
            }
        }));
    }

    @Override // id.dana.data.services.repository.source.ServicesEntityData
    public final Observable<Map<String, List<ThirdPartyEntity>>> getAllServices() {
        Observable<Map<String, List<ThirdPartyEntity>>> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.services.repository.source.local.DefaultServicesEntityData$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Map m2002getAllServices$lambda6;
                m2002getAllServices$lambda6 = DefaultServicesEntityData.m2002getAllServices$lambda6();
                return m2002getAllServices$lambda6;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAllServices$lambda-6  reason: not valid java name */
    public static final Map m2002getAllServices$lambda6() {
        HashMap<String, List<String>> defaultCategory = DefaultServiceCategory.INSTANCE.getDefaultCategory();
        HashMap<String, ThirdPartyEntity> defaultServices = DefaultServiceCategory.INSTANCE.getDefaultServices();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (CategoryServices categoryServices : CategoryServices.INSTANCE.getDefault()) {
            List<String> list = defaultCategory.get(categoryServices.getCategory());
            ArrayList arrayList = null;
            if (list != null) {
                Intrinsics.checkNotNullExpressionValue(list, "");
                ArrayList arrayList2 = new ArrayList();
                for (String str : list) {
                    ThirdPartyEntity thirdPartyEntity = defaultServices.get(str);
                    if (thirdPartyEntity != null) {
                        thirdPartyEntity.setKey(str);
                    } else {
                        thirdPartyEntity = null;
                    }
                    if (thirdPartyEntity != null) {
                        arrayList2.add(thirdPartyEntity);
                    }
                }
                arrayList = arrayList2;
            }
            if (arrayList != null) {
                String category = categoryServices.getCategory();
                ArrayList arrayList3 = new ArrayList();
                for (Object obj : arrayList) {
                    if (((ThirdPartyEntity) obj).getEnable()) {
                        arrayList3.add(obj);
                    }
                }
                linkedHashMap.put(category, arrayList3);
            }
        }
        return linkedHashMap;
    }

    @Override // id.dana.data.services.repository.source.ServicesEntityData
    public final Observable<ThirdPartyEntity> getService(final String serviceKey) {
        Intrinsics.checkNotNullParameter(serviceKey, "");
        Observable<ThirdPartyEntity> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.services.repository.source.local.DefaultServicesEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ThirdPartyEntity m2006getService$lambda8;
                m2006getService$lambda8 = DefaultServicesEntityData.m2006getService$lambda8(serviceKey);
                return m2006getService$lambda8;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getService$lambda-8  reason: not valid java name */
    public static final ThirdPartyEntity m2006getService$lambda8(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        ThirdPartyEntity thirdPartyEntity = DefaultServiceCategory.INSTANCE.getDefaultServices().get(str);
        if (thirdPartyEntity != null) {
            thirdPartyEntity.setKey(str);
            return thirdPartyEntity;
        }
        return new ThirdPartyEntity(null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, false, null, null, false, null, null, null, null, false, null, null, null, null, null, null, -8193, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getCategoryHighlightedFeature$lambda-9  reason: not valid java name */
    public static final CategoryHighlightedFeature m2004getCategoryHighlightedFeature$lambda9() {
        return new CategoryHighlightedFeature(null, 0, false, 0, 15, null);
    }

    @Override // id.dana.data.services.repository.source.ServicesEntityData
    public final Observable<CategoryHighlightedFeature> getCategoryHighlightedFeature() {
        Observable<CategoryHighlightedFeature> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.services.repository.source.local.DefaultServicesEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                CategoryHighlightedFeature m2004getCategoryHighlightedFeature$lambda9;
                m2004getCategoryHighlightedFeature$lambda9 = DefaultServicesEntityData.m2004getCategoryHighlightedFeature$lambda9();
                return m2004getCategoryHighlightedFeature$lambda9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }
}

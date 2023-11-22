package id.dana.data.saving.repository;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import id.dana.data.saving.model.SavingCategoryEntityKt;
import id.dana.domain.saving.SavingCategoryRepository;
import id.dana.domain.saving.model.SavingCategory;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Singleton
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\f0\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006R\u001b\u0010\u0013\u001a\u00020\u000e8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0016\u001a\u00020\u000e8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/data/saving/repository/SavingCategoryEntityRepository;", "Lid/dana/domain/saving/SavingCategoryRepository;", "Lio/reactivex/Observable;", "", "Lid/dana/domain/saving/model/SavingCategory;", "getSavingCategories", "()Lio/reactivex/Observable;", "", "", UserMetadata.KEYDATA_FILENAME, "getSavingCategoriesByKeys", "([Ljava/lang/String;)Lio/reactivex/Observable;", "", "getSavingCategoriesMap", "Lid/dana/data/saving/repository/SavingCategoryEntityData;", "defaultSavingCategory$delegate", "Lkotlin/Lazy;", "getDefaultSavingCategory", "()Lid/dana/data/saving/repository/SavingCategoryEntityData;", "defaultSavingCategory", "networkConfigSavingCategory$delegate", "getNetworkConfigSavingCategory", "networkConfigSavingCategory", "Lid/dana/data/saving/repository/SavingCategoryEntityDataFactory;", "savingCategoryEntityDataFactory", "Lid/dana/data/saving/repository/SavingCategoryEntityDataFactory;", "<init>", "(Lid/dana/data/saving/repository/SavingCategoryEntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SavingCategoryEntityRepository implements SavingCategoryRepository {

    /* renamed from: defaultSavingCategory$delegate  reason: from kotlin metadata */
    private final Lazy defaultSavingCategory;

    /* renamed from: networkConfigSavingCategory$delegate  reason: from kotlin metadata */
    private final Lazy networkConfigSavingCategory;
    private final SavingCategoryEntityDataFactory savingCategoryEntityDataFactory;

    @Inject
    public SavingCategoryEntityRepository(SavingCategoryEntityDataFactory savingCategoryEntityDataFactory) {
        Intrinsics.checkNotNullParameter(savingCategoryEntityDataFactory, "");
        this.savingCategoryEntityDataFactory = savingCategoryEntityDataFactory;
        this.networkConfigSavingCategory = LazyKt.lazy(new Function0<SavingCategoryEntityData>() { // from class: id.dana.data.saving.repository.SavingCategoryEntityRepository$networkConfigSavingCategory$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SavingCategoryEntityData invoke() {
                SavingCategoryEntityDataFactory savingCategoryEntityDataFactory2;
                savingCategoryEntityDataFactory2 = SavingCategoryEntityRepository.this.savingCategoryEntityDataFactory;
                return savingCategoryEntityDataFactory2.createData2("network");
            }
        });
        this.defaultSavingCategory = LazyKt.lazy(new Function0<SavingCategoryEntityData>() { // from class: id.dana.data.saving.repository.SavingCategoryEntityRepository$defaultSavingCategory$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SavingCategoryEntityData invoke() {
                SavingCategoryEntityDataFactory savingCategoryEntityDataFactory2;
                savingCategoryEntityDataFactory2 = SavingCategoryEntityRepository.this.savingCategoryEntityDataFactory;
                return savingCategoryEntityDataFactory2.createData2("local");
            }
        });
    }

    @JvmName(name = "getNetworkConfigSavingCategory")
    private final SavingCategoryEntityData getNetworkConfigSavingCategory() {
        return (SavingCategoryEntityData) this.networkConfigSavingCategory.getValue();
    }

    @JvmName(name = "getDefaultSavingCategory")
    private final SavingCategoryEntityData getDefaultSavingCategory() {
        return (SavingCategoryEntityData) this.defaultSavingCategory.getValue();
    }

    @Override // id.dana.domain.saving.SavingCategoryRepository
    public final Observable<List<SavingCategory>> getSavingCategories() {
        Observable map = getNetworkConfigSavingCategory().getSavingCategories().onErrorResumeNext(getDefaultSavingCategory().getSavingCategories()).filter(new Predicate() { // from class: id.dana.data.saving.repository.SavingCategoryEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean m1843getSavingCategories$lambda0;
                m1843getSavingCategories$lambda0 = SavingCategoryEntityRepository.m1843getSavingCategories$lambda0((List) obj);
                return m1843getSavingCategories$lambda0;
            }
        }).switchIfEmpty(getDefaultSavingCategory().getSavingCategories()).map(new Function() { // from class: id.dana.data.saving.repository.SavingCategoryEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m1844getSavingCategories$lambda1;
                m1844getSavingCategories$lambda1 = SavingCategoryEntityRepository.m1844getSavingCategories$lambda1((List) obj);
                return m1844getSavingCategories$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSavingCategories$lambda-0  reason: not valid java name */
    public static final boolean m1843getSavingCategories$lambda0(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return !list.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSavingCategories$lambda-1  reason: not valid java name */
    public static final List m1844getSavingCategories$lambda1(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return SavingCategoryEntityKt.toSavingCategories(list);
    }

    @Override // id.dana.domain.saving.SavingCategoryRepository
    public final Observable<Map<String, SavingCategory>> getSavingCategoriesMap() {
        Observable map = getSavingCategories().map(new Function() { // from class: id.dana.data.saving.repository.SavingCategoryEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Map m1846getSavingCategoriesMap$lambda3;
                m1846getSavingCategoriesMap$lambda3 = SavingCategoryEntityRepository.m1846getSavingCategoriesMap$lambda3((List) obj);
                return m1846getSavingCategoriesMap$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSavingCategoriesMap$lambda-3  reason: not valid java name */
    public static final Map m1846getSavingCategoriesMap$lambda3(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        List list2 = list;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
        for (Object obj : list2) {
            linkedHashMap.put(((SavingCategory) obj).getCategoryCode(), obj);
        }
        return linkedHashMap;
    }

    @Override // id.dana.domain.saving.SavingCategoryRepository
    public final Observable<List<SavingCategory>> getSavingCategoriesByKeys(String[] keys) {
        Intrinsics.checkNotNullParameter(keys, "");
        Observable map = getNetworkConfigSavingCategory().getSavingCategoriesByKeys((String[]) Arrays.copyOf(keys, keys.length)).onErrorResumeNext(getDefaultSavingCategory().getSavingCategoriesByKeys((String[]) Arrays.copyOf(keys, keys.length))).map(new Function() { // from class: id.dana.data.saving.repository.SavingCategoryEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m1845getSavingCategoriesByKeys$lambda4;
                m1845getSavingCategoriesByKeys$lambda4 = SavingCategoryEntityRepository.m1845getSavingCategoriesByKeys$lambda4((List) obj);
                return m1845getSavingCategoriesByKeys$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSavingCategoriesByKeys$lambda-4  reason: not valid java name */
    public static final List m1845getSavingCategoriesByKeys$lambda4(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return SavingCategoryEntityKt.toSavingCategories(list);
    }
}

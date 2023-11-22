package id.dana.data.promocenter.repository.source.local;

import id.dana.data.promocenter.repository.PromoCenterEntityData;
import id.dana.data.promocenter.repository.source.local.model.UserCoordinateEntityData;
import id.dana.data.promocenter.repository.source.network.result.PromoCenterAdsQueryResult;
import id.dana.data.promocenter.repository.source.network.result.PromoCenterCategorizedResult;
import id.dana.data.promocenter.repository.source.network.result.PromoCenterCategoryResult;
import id.dana.data.promocenter.repository.source.network.result.PromoCenterFetchResult;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class LocalPromoCenterEntityData implements PromoCenterEntityData {
    private final PromoAdsPreferences promoAdsPreferences;
    private final PromoCategoryPreferences promoCategoryPreferences;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public LocalPromoCenterEntityData(PromoCategoryPreferences promoCategoryPreferences, PromoAdsPreferences promoAdsPreferences) {
        this.promoCategoryPreferences = promoCategoryPreferences;
        this.promoAdsPreferences = promoAdsPreferences;
    }

    @Override // id.dana.data.promocenter.repository.PromoCenterEntityData
    public Observable<PromoCenterCategoryResult> getCategories(int i, int i2) {
        throw new UnsupportedOperationException("Unable to get categories with pagination on local data");
    }

    @Override // id.dana.data.promocenter.repository.PromoCenterEntityData
    public PromoCenterCategoryResult getCachedCategories() {
        return this.promoCategoryPreferences.getCategories();
    }

    @Override // id.dana.data.promocenter.repository.PromoCenterEntityData
    public Observable<Boolean> saveCategories(PromoCenterCategoryResult promoCenterCategoryResult) {
        return Observable.just(Boolean.valueOf(this.promoCategoryPreferences.saveCategories(promoCenterCategoryResult)));
    }

    @Override // id.dana.data.promocenter.repository.PromoCenterEntityData
    public Observable<PromoCenterFetchResult> queryAllPromo(int i, int i2, String str) {
        throw new UnsupportedOperationException("Unable to get promo on local data");
    }

    @Override // id.dana.data.promocenter.repository.PromoCenterEntityData
    public Observable<PromoCenterCategorizedResult> queryCategorizedPromo(List<String> list, int i, int i2, String str, String str2, double d, double d2) {
        throw new UnsupportedOperationException("Unable to get promo on local data");
    }

    @Override // id.dana.data.promocenter.repository.PromoCenterEntityData
    public Observable<PromoCenterAdsQueryResult> getPromoAds(int i, int i2, double d, double d2, int i3) {
        throw new UnsupportedOperationException("Unable to get promo ads on local data");
    }

    @Override // id.dana.data.promocenter.repository.PromoCenterEntityData
    public Observable<UserCoordinateEntityData> getUserLastCoordinate(final String str) {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.promocenter.repository.source.local.LocalPromoCenterEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LocalPromoCenterEntityData.this.m1628xdfadf812(str);
            }
        }).onErrorReturn(new Function() { // from class: id.dana.data.promocenter.repository.source.local.LocalPromoCenterEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return LocalPromoCenterEntityData.lambda$getUserLastCoordinate$1((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getUserLastCoordinate$0$id-dana-data-promocenter-repository-source-local-LocalPromoCenterEntityData  reason: not valid java name */
    public /* synthetic */ UserCoordinateEntityData m1628xdfadf812(String str) throws Exception {
        return this.promoAdsPreferences.getUserLastCoordinate(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ UserCoordinateEntityData lambda$getUserLastCoordinate$1(Throwable th) throws Exception {
        return new UserCoordinateEntityData();
    }

    @Override // id.dana.data.promocenter.repository.PromoCenterEntityData
    public Observable<Boolean> saveUserLastCoordinate(final String str, final UserCoordinateEntityData userCoordinateEntityData) {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.promocenter.repository.source.local.LocalPromoCenterEntityData$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LocalPromoCenterEntityData.this.m1630x421d2455(str, userCoordinateEntityData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$saveUserLastCoordinate$2$id-dana-data-promocenter-repository-source-local-LocalPromoCenterEntityData  reason: not valid java name */
    public /* synthetic */ Boolean m1630x421d2455(String str, UserCoordinateEntityData userCoordinateEntityData) throws Exception {
        return Boolean.valueOf(this.promoAdsPreferences.saveUserLastCoordinate(str, userCoordinateEntityData));
    }

    @Override // id.dana.data.promocenter.repository.PromoCenterEntityData
    public Observable<Integer> getCurrentAdsPageNumber(String str, String str2) {
        return Observable.just(Integer.valueOf(this.promoAdsPreferences.getCurrentAdsPageNumber(str, str2)));
    }

    @Override // id.dana.data.promocenter.repository.PromoCenterEntityData
    public Observable<Boolean> saveCurrentAdsPageNumber(final String str, final int i, final String str2) {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.promocenter.repository.source.local.LocalPromoCenterEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LocalPromoCenterEntityData.this.m1629x75acef0c(str, i, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$saveCurrentAdsPageNumber$3$id-dana-data-promocenter-repository-source-local-LocalPromoCenterEntityData  reason: not valid java name */
    public /* synthetic */ Boolean m1629x75acef0c(String str, int i, String str2) throws Exception {
        this.promoAdsPreferences.saveCurrentAdsPageNumber(str, i, str2);
        return Boolean.TRUE;
    }
}

package id.dana.data.promotion.repository.source.persistence;

import id.dana.data.promotion.repository.source.PromoEntityData;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class PersistencePromoEntityData implements PromoEntityData {
    private final PromoPreference promoPreference;

    @Inject
    public PersistencePromoEntityData(PromoPreference promoPreference) {
        this.promoPreference = promoPreference;
    }

    @Override // id.dana.data.promotion.repository.source.PromoEntityData
    public Completable setFreeTransferCount(final String str, final int i) {
        return Completable.PlaceComponentResult(new Action() { // from class: id.dana.data.promotion.repository.source.persistence.PersistencePromoEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Action
            public final void run() {
                PersistencePromoEntityData.this.m1675xe30573b7(str, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setFreeTransferCount$0$id-dana-data-promotion-repository-source-persistence-PersistencePromoEntityData  reason: not valid java name */
    public /* synthetic */ void m1675xe30573b7(String str, int i) throws Exception {
        this.promoPreference.setFreeTransferCount(str, i);
    }

    @Override // id.dana.data.promotion.repository.source.PromoEntityData
    public Single<Integer> getFreeTransferCountFromLocal(String str) {
        return Single.MyBillsEntityDataFactory(Integer.valueOf(this.promoPreference.getFreeTransferCount(str)));
    }

    @Override // id.dana.data.promotion.repository.source.PromoEntityData
    public Completable decrementFreeTransferCount(final String str) {
        return Completable.PlaceComponentResult(new Action() { // from class: id.dana.data.promotion.repository.source.persistence.PersistencePromoEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Action
            public final void run() {
                PersistencePromoEntityData.this.m1673xd7333a27(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$decrementFreeTransferCount$1$id-dana-data-promotion-repository-source-persistence-PersistencePromoEntityData  reason: not valid java name */
    public /* synthetic */ void m1673xd7333a27(String str) throws Exception {
        this.promoPreference.decrementFreeTransferCount(str);
    }

    @Override // id.dana.data.promotion.repository.source.PromoEntityData
    public Single<Integer> getMonthOfFetchFreeTransfer() {
        return Single.MyBillsEntityDataFactory(Integer.valueOf(this.promoPreference.getMonthOfFetchFreeTransfer()));
    }

    @Override // id.dana.data.promotion.repository.source.PromoEntityData
    public Completable saveMonthOfFetchFreeTransfer(final Integer num) {
        return Completable.PlaceComponentResult(new Action() { // from class: id.dana.data.promotion.repository.source.persistence.PersistencePromoEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Action
            public final void run() {
                PersistencePromoEntityData.this.m1674xbe62cd1a(num);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$saveMonthOfFetchFreeTransfer$2$id-dana-data-promotion-repository-source-persistence-PersistencePromoEntityData  reason: not valid java name */
    public /* synthetic */ void m1674xbe62cd1a(Integer num) throws Exception {
        this.promoPreference.saveMonthOfFetchFreeTransfer(num.intValue());
    }
}

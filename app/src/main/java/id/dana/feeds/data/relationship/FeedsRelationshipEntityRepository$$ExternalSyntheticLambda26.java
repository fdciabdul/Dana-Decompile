package id.dana.feeds.data.relationship;

import id.dana.data.social.repository.source.persistence.entity.FollowerEntity;
import io.reactivex.functions.Function;

/* loaded from: classes5.dex */
public final /* synthetic */ class FeedsRelationshipEntityRepository$$ExternalSyntheticLambda26 implements Function {
    public final /* synthetic */ FeedsRelationshipEntityRepository MyBillsEntityDataFactory;

    public /* synthetic */ FeedsRelationshipEntityRepository$$ExternalSyntheticLambda26(FeedsRelationshipEntityRepository feedsRelationshipEntityRepository) {
        this.MyBillsEntityDataFactory = feedsRelationshipEntityRepository;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return FeedsRelationshipEntityRepository.PlaceComponentResult(this.MyBillsEntityDataFactory, (FollowerEntity) obj);
    }
}

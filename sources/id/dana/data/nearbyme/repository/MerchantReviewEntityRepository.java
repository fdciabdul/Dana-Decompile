package id.dana.data.nearbyme.repository;

import id.dana.data.account.avatar.repository.source.network.NetworkFileUploadEntityData;
import id.dana.data.account.avatar.repository.source.network.result.AvatarEntityResult;
import id.dana.data.account.repository.source.preference.PreferenceAccountEntityData;
import id.dana.data.nearbyme.repository.source.network.NetworkMerchantInfoEntityData;
import id.dana.data.nearbyme.repository.source.network.request.merchantreview.MerchantCreateReviewRequest;
import id.dana.data.nearbyme.repository.source.network.result.merchantreview.MerchantCreateReviewResult;
import id.dana.domain.nearbyme.MerchantReviewRepository;
import id.dana.domain.nearbyme.model.MerchantCreateReview;
import io.reactivex.Observable;
import java.io.File;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0006J\u001b\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/data/nearbyme/repository/MerchantReviewEntityRepository;", "Lid/dana/domain/nearbyme/MerchantReviewRepository;", "Lid/dana/domain/nearbyme/model/MerchantCreateReview;", "review", "", "createMerchantReview", "(Lid/dana/domain/nearbyme/model/MerchantCreateReview;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "merchantCreateReview", "updateMerchantReview", "Ljava/io/File;", "image", "", "uploadImage", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/data/account/avatar/repository/source/network/NetworkFileUploadEntityData;", "networkFileUploadEntityData", "Lid/dana/data/account/avatar/repository/source/network/NetworkFileUploadEntityData;", "Lid/dana/data/nearbyme/repository/source/network/NetworkMerchantInfoEntityData;", "networkMerchantInfoEntityData", "Lid/dana/data/nearbyme/repository/source/network/NetworkMerchantInfoEntityData;", "Lid/dana/data/account/repository/source/preference/PreferenceAccountEntityData;", "preferenceAccountEntityData", "Lid/dana/data/account/repository/source/preference/PreferenceAccountEntityData;", "<init>", "(Lid/dana/data/nearbyme/repository/source/network/NetworkMerchantInfoEntityData;Lid/dana/data/account/repository/source/preference/PreferenceAccountEntityData;Lid/dana/data/account/avatar/repository/source/network/NetworkFileUploadEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MerchantReviewEntityRepository implements MerchantReviewRepository {
    private final NetworkFileUploadEntityData networkFileUploadEntityData;
    private final NetworkMerchantInfoEntityData networkMerchantInfoEntityData;
    private final PreferenceAccountEntityData preferenceAccountEntityData;

    @Inject
    public MerchantReviewEntityRepository(NetworkMerchantInfoEntityData networkMerchantInfoEntityData, PreferenceAccountEntityData preferenceAccountEntityData, NetworkFileUploadEntityData networkFileUploadEntityData) {
        Intrinsics.checkNotNullParameter(networkMerchantInfoEntityData, "");
        Intrinsics.checkNotNullParameter(preferenceAccountEntityData, "");
        Intrinsics.checkNotNullParameter(networkFileUploadEntityData, "");
        this.networkMerchantInfoEntityData = networkMerchantInfoEntityData;
        this.preferenceAccountEntityData = preferenceAccountEntityData;
        this.networkFileUploadEntityData = networkFileUploadEntityData;
    }

    @Override // id.dana.domain.nearbyme.MerchantReviewRepository
    public final Object createMerchantReview(MerchantCreateReview merchantCreateReview, Continuation<? super Unit> continuation) {
        MerchantCreateReviewResult merchantCreateReviewResult = (MerchantCreateReviewResult) this.networkMerchantInfoEntityData.createReview(new MerchantCreateReviewRequest(merchantCreateReview.getReview(), merchantCreateReview.getRating(), merchantCreateReview.getPositiveTags(), merchantCreateReview.getNegativeTags(), merchantCreateReview.getImages(), merchantCreateReview.getShopId(), merchantCreateReview.getShareToFeed(), null, 128, null), continuation);
        return merchantCreateReviewResult == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? merchantCreateReviewResult : Unit.INSTANCE;
    }

    @Override // id.dana.domain.nearbyme.MerchantReviewRepository
    public final Object uploadImage(File file, Continuation<? super String> continuation) {
        AvatarEntityResult blockingFirst;
        NetworkFileUploadEntityData networkFileUploadEntityData = this.networkFileUploadEntityData;
        String uUIDAsString = this.preferenceAccountEntityData.getUUIDAsString();
        if (uUIDAsString == null) {
            uUIDAsString = "";
        }
        Observable<AvatarEntityResult> uploadAvatar = networkFileUploadEntityData.uploadAvatar(file, uUIDAsString);
        String str = (uploadAvatar == null || (blockingFirst = uploadAvatar.blockingFirst()) == null) ? null : blockingFirst.url;
        return str == null ? "" : str;
    }

    @Override // id.dana.domain.nearbyme.MerchantReviewRepository
    public final Object updateMerchantReview(MerchantCreateReview merchantCreateReview, Continuation<? super Unit> continuation) {
        NetworkMerchantInfoEntityData networkMerchantInfoEntityData = this.networkMerchantInfoEntityData;
        String review = merchantCreateReview.getReview();
        int rating = merchantCreateReview.getRating();
        List<String> positiveTags = merchantCreateReview.getPositiveTags();
        List<String> negativeTags = merchantCreateReview.getNegativeTags();
        List<String> images = merchantCreateReview.getImages();
        String shopId = merchantCreateReview.getShopId();
        boolean shareToFeed = merchantCreateReview.getShareToFeed();
        String reviewId = merchantCreateReview.getReviewId();
        if (!(reviewId.length() > 0)) {
            reviewId = null;
        }
        MerchantCreateReviewResult merchantCreateReviewResult = (MerchantCreateReviewResult) networkMerchantInfoEntityData.updateReview(new MerchantCreateReviewRequest(review, rating, positiveTags, negativeTags, images, shopId, shareToFeed, reviewId), continuation);
        return merchantCreateReviewResult == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? merchantCreateReviewResult : Unit.INSTANCE;
    }
}

package id.dana.nearbyme.merchantdetail.mapper;

import id.dana.domain.nearbyme.model.MerchantImage;
import id.dana.domain.nearbyme.model.MerchantReview;
import id.dana.domain.nearbyme.model.MerchantReviewSummary;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewModel;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewSummaryModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyme/merchantdetail/mapper/MerchantAverageRatingMapper;", "", "Lid/dana/domain/nearbyme/model/MerchantReviewSummary;", "p0", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewSummaryModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/nearbyme/model/MerchantReviewSummary;)Lid/dana/nearbyme/merchantdetail/model/MerchantReviewSummaryModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantAverageRatingMapper {
    @Inject
    public MerchantAverageRatingMapper() {
    }

    public static MerchantReviewSummaryModel KClassImpl$Data$declaredNonStaticMembers$2(MerchantReviewSummary p0) {
        MerchantReviewModel merchantReviewModel;
        Intrinsics.checkNotNullParameter(p0, "");
        float rating = p0.getRating();
        int numberOfReviews = p0.getNumberOfReviews();
        MerchantReview userReview = p0.getUserReview();
        if (userReview == null) {
            merchantReviewModel = null;
        } else {
            String userId = userReview.getUserId();
            String userName = userReview.getUserName();
            String avatar = userReview.getAvatar();
            String review = userReview.getReview();
            int rating2 = userReview.getRating();
            long modifyDate = userReview.getModifyDate();
            long createdDate = userReview.getCreatedDate();
            List<MerchantImage> images = userReview.getImages();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(images, 10));
            for (MerchantImage merchantImage : images) {
                arrayList.add(new MerchantImageModel(merchantImage.getUserId(), merchantImage.getUserName(), merchantImage.getAvatar(), merchantImage.getImageUrl(), 0, 16, null));
            }
            merchantReviewModel = new MerchantReviewModel(userId, userName, avatar, review, rating2, modifyDate, createdDate, arrayList, null, null, false, userReview.getPositiveTags(), userReview.getNegativeSentiments(), null, null, null, userReview.getReviewId(), 59136, null);
        }
        return new MerchantReviewSummaryModel(rating, numberOfReviews, merchantReviewModel);
    }
}

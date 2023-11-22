package id.dana.domain.nearbyme;

import id.dana.domain.nearbyme.model.MerchantCreateReview;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0006J\u001b\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rø\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/nearbyme/MerchantReviewRepository;", "", "Lid/dana/domain/nearbyme/model/MerchantCreateReview;", "review", "", "createMerchantReview", "(Lid/dana/domain/nearbyme/model/MerchantCreateReview;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "merchantCreateReview", "updateMerchantReview", "Ljava/io/File;", "image", "", "uploadImage", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface MerchantReviewRepository {
    Object createMerchantReview(MerchantCreateReview merchantCreateReview, Continuation<? super Unit> continuation);

    Object updateMerchantReview(MerchantCreateReview merchantCreateReview, Continuation<? super Unit> continuation);

    Object uploadImage(File file, Continuation<? super String> continuation);
}

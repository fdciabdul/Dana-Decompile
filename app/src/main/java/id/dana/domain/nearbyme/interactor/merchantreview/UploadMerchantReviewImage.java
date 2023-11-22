package id.dana.domain.nearbyme.interactor.merchantreview;

import id.dana.domain.core.usecase.CoroutineWorkerUseCase;
import id.dana.domain.nearbyme.MerchantReviewRepository;
import java.io.File;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/domain/nearbyme/interactor/merchantreview/UploadMerchantReviewImage;", "Lid/dana/domain/core/usecase/CoroutineWorkerUseCase;", "Ljava/io/File;", "", "param", "execute", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/domain/nearbyme/MerchantReviewRepository;", "merchantReviewRepository", "Lid/dana/domain/nearbyme/MerchantReviewRepository;", "<init>", "(Lid/dana/domain/nearbyme/MerchantReviewRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UploadMerchantReviewImage extends CoroutineWorkerUseCase<File, String> {
    private final MerchantReviewRepository merchantReviewRepository;

    @Inject
    public UploadMerchantReviewImage(MerchantReviewRepository merchantReviewRepository) {
        Intrinsics.checkNotNullParameter(merchantReviewRepository, "");
        this.merchantReviewRepository = merchantReviewRepository;
    }

    @Override // id.dana.domain.core.usecase.CoroutineWorkerUseCase
    public final Object execute(File file, Continuation<? super String> continuation) {
        return this.merchantReviewRepository.uploadImage(file, continuation);
    }
}

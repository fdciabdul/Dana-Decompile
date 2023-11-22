package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.data.nearbyme.repository.MerchantReviewEntityRepository;
import id.dana.domain.nearbyme.MerchantReviewRepository;
import id.dana.domain.nearbyme.interactor.merchantreview.CreateMerchantReview;
import id.dana.domain.nearbyme.interactor.merchantreview.UploadMerchantReviewImage;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/di/modules/MerchantReviewModule;", "", "Lid/dana/data/nearbyme/repository/MerchantReviewEntityRepository;", "p0", "Lid/dana/domain/nearbyme/MerchantReviewRepository;", "getAuthRequestContext", "(Lid/dana/data/nearbyme/repository/MerchantReviewEntityRepository;)Lid/dana/domain/nearbyme/MerchantReviewRepository;", "Lid/dana/domain/nearbyme/interactor/merchantreview/CreateMerchantReview;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/nearbyme/MerchantReviewRepository;)Lid/dana/domain/nearbyme/interactor/merchantreview/CreateMerchantReview;", "Lid/dana/domain/nearbyme/interactor/merchantreview/UploadMerchantReviewImage;", "MyBillsEntityDataFactory", "(Lid/dana/domain/nearbyme/MerchantReviewRepository;)Lid/dana/domain/nearbyme/interactor/merchantreview/UploadMerchantReviewImage;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes2.dex */
public final class MerchantReviewModule {
    public static final MerchantReviewModule INSTANCE = new MerchantReviewModule();

    private MerchantReviewModule() {
    }

    @Provides
    @JvmStatic
    public static final MerchantReviewRepository getAuthRequestContext(MerchantReviewEntityRepository p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    @JvmStatic
    public static final CreateMerchantReview KClassImpl$Data$declaredNonStaticMembers$2(MerchantReviewRepository p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return new CreateMerchantReview(p0);
    }

    @Provides
    @JvmStatic
    public static final UploadMerchantReviewImage MyBillsEntityDataFactory(MerchantReviewRepository p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return new UploadMerchantReviewImage(p0);
    }
}

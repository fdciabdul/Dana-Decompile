package id.dana.explore.domain.sku.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.explore.domain.sku.ProductInfoRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B%\b\u0007\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/explore/domain/sku/interactor/GetPrepaidCheckoutUrl;", "Lid/dana/domain/UseCase;", "", "Lid/dana/explore/domain/sku/ProductInfoRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/explore/domain/sku/ProductInfoRepository;", "Lid/dana/utils/concurrent/ThreadExecutor;", "p0", "Lid/dana/domain/PostExecutionThread;", "p1", "p2", "<init>", "(Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/domain/PostExecutionThread;Lid/dana/explore/domain/sku/ProductInfoRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetPrepaidCheckoutUrl extends UseCase<String, String> {
    private final ProductInfoRepository KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.domain.UseCase
    public final /* synthetic */ Observable<String> buildUseCaseObservable(String str) {
        String str2 = str;
        ProductInfoRepository productInfoRepository = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (str2 == null) {
            str2 = "";
        }
        return productInfoRepository.BuiltInFictitiousFunctionClassFactory(str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GetPrepaidCheckoutUrl(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ProductInfoRepository productInfoRepository) {
        super(threadExecutor, postExecutionThread);
        Intrinsics.checkNotNullParameter(productInfoRepository, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = productInfoRepository;
    }
}

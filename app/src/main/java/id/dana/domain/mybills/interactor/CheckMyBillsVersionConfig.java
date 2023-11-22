package id.dana.domain.mybills.interactor;

import id.dana.domain.core.usecase.SingleUseCase;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import io.reactivex.Single;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002*\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ9\u0010\b\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00050\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/domain/mybills/interactor/CheckMyBillsVersionConfig;", "Lid/dana/domain/core/usecase/SingleUseCase;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "params", "Lio/reactivex/Single;", "buildUseCase", "(Ljava/lang/String;)Lio/reactivex/Single;", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "featureConfigRepository", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "<init>", "(Lid/dana/domain/featureconfig/FeatureConfigRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CheckMyBillsVersionConfig extends SingleUseCase<HashMap<String, Object>, String> {
    private final FeatureConfigRepository featureConfigRepository;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [io.reactivex.Scheduler, kotlin.jvm.internal.DefaultConstructorMarker] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CheckMyBillsVersionConfig(id.dana.domain.featureconfig.FeatureConfigRepository r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            r2.featureConfigRepository = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.mybills.interactor.CheckMyBillsVersionConfig.<init>(id.dana.domain.featureconfig.FeatureConfigRepository):void");
    }

    @Override // id.dana.domain.core.usecase.SingleUseCase
    public final Single<HashMap<String, Object>> buildUseCase(String params) {
        Intrinsics.checkNotNullParameter(params, "");
        Single<HashMap<String, Object>> MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory(this.featureConfigRepository.getMultipleValueConfig(params).blockingFirst());
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }
}

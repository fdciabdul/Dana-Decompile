package id.dana.data.services.repository;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.danah5.DanaH5;
import id.dana.data.homeinfo.model.ThirdPartyEntity;
import io.reactivex.functions.Predicate;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", DanaH5.SERVICE_KEY, "Lid/dana/data/homeinfo/model/ThirdPartyEntity;", BridgeDSL.INVOKE, "(Ljava/lang/String;)Lid/dana/data/homeinfo/model/ThirdPartyEntity;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ServicesEntityRepository$getListOfService$1$2 extends Lambda implements Function1<String, ThirdPartyEntity> {
    final /* synthetic */ ServicesEntityRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServicesEntityRepository$getListOfService$1$2(ServicesEntityRepository servicesEntityRepository) {
        super(1);
        this.this$0 = servicesEntityRepository;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ThirdPartyEntity invoke(String str) {
        Object m3179constructorimpl;
        Intrinsics.checkNotNullParameter(str, "");
        ServicesEntityRepository servicesEntityRepository = this.this$0;
        try {
            Result.Companion companion = Result.INSTANCE;
            m3179constructorimpl = Result.m3179constructorimpl(servicesEntityRepository.getServiceFromServiceKey(str).filter(new Predicate() { // from class: id.dana.data.services.repository.ServicesEntityRepository$getListOfService$1$2$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Predicate
                public final boolean test(Object obj) {
                    boolean m2000invoke$lambda1$lambda0;
                    m2000invoke$lambda1$lambda0 = ServicesEntityRepository$getListOfService$1$2.m2000invoke$lambda1$lambda0((ThirdPartyEntity) obj);
                    return m2000invoke$lambda1$lambda0;
                }
            }).blockingFirst());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m3185isFailureimpl(m3179constructorimpl)) {
            m3179constructorimpl = null;
        }
        return (ThirdPartyEntity) m3179constructorimpl;
    }

    /* renamed from: invoke$lambda-1$lambda-0 */
    public static final boolean m2000invoke$lambda1$lambda0(ThirdPartyEntity thirdPartyEntity) {
        Intrinsics.checkNotNullParameter(thirdPartyEntity, "");
        return thirdPartyEntity.getKey() != null;
    }
}

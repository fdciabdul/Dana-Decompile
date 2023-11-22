package id.dana.data.deeplink.repository;

import id.dana.data.deeplink.repository.source.branch.result.DeepLinkPayloadEntity;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class DeepLinkEntityRepository$$ExternalSyntheticLambda1 implements Function {
    public final /* synthetic */ DeepLinkEntityRepository f$0;

    public /* synthetic */ DeepLinkEntityRepository$$ExternalSyntheticLambda1(DeepLinkEntityRepository deepLinkEntityRepository) {
        this.f$0 = deepLinkEntityRepository;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        Observable checkAuthEnable;
        checkAuthEnable = this.f$0.checkAuthEnable((DeepLinkPayloadEntity) obj);
        return checkAuthEnable;
    }
}

package id.dana.data.feeds.repository;

import id.dana.data.feeds.mapper.FeedsResultMapper;
import id.dana.data.feeds.repository.source.network.result.FeedsResult;
import io.reactivex.functions.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class FeedsEntityRepository$$ExternalSyntheticLambda1 implements Function {
    public final /* synthetic */ FeedsResultMapper f$0;

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return this.f$0.apply((FeedsResult) obj);
    }
}

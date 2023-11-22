package id.dana.domain.core.usecase;

import io.reactivex.Single;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0004\u001a\u00028\u0001H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/domain/core/usecase/BlockingUseCase;", "T", "Params", "", "params", "Lio/reactivex/Single;", "buildUseCase", "(Ljava/lang/Object;)Lio/reactivex/Single;", "execute", "(Ljava/lang/Object;)Ljava/lang/Object;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BlockingUseCase<T, Params> {
    public abstract Single<T> buildUseCase(Params params);

    public final T execute(Params params) {
        return buildUseCase(params).r_();
    }
}

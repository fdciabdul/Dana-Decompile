package id.dana.domain.mybills.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.mybills.MyBillsRepository;
import id.dana.domain.mybills.model.BizProductOrder;
import id.dana.domain.mybills.model.BizProductOrderRequest;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/domain/mybills/interactor/GetBizProductOrder;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/mybills/model/BizProductOrder;", "Lid/dana/domain/mybills/interactor/GetBizProductOrder$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/mybills/interactor/GetBizProductOrder$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/mybills/MyBillsRepository;", "myBillsRepository", "Lid/dana/domain/mybills/MyBillsRepository;", "getMyBillsRepository", "()Lid/dana/domain/mybills/MyBillsRepository;", "<init>", "(Lid/dana/domain/mybills/MyBillsRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetBizProductOrder extends BaseUseCase<BizProductOrder, Params> {
    private final MyBillsRepository myBillsRepository;

    @JvmName(name = "getMyBillsRepository")
    public final MyBillsRepository getMyBillsRepository() {
        return this.myBillsRepository;
    }

    @Inject
    public GetBizProductOrder(MyBillsRepository myBillsRepository) {
        Intrinsics.checkNotNullParameter(myBillsRepository, "");
        this.myBillsRepository = myBillsRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<BizProductOrder> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.myBillsRepository.getCreateBizProductOrder(params.getRequest());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/mybills/interactor/GetBizProductOrder$Params;", "", "Lid/dana/domain/mybills/model/BizProductOrderRequest;", "request", "Lid/dana/domain/mybills/model/BizProductOrderRequest;", "getRequest", "()Lid/dana/domain/mybills/model/BizProductOrderRequest;", "<init>", "(Lid/dana/domain/mybills/model/BizProductOrderRequest;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final BizProductOrderRequest request;

        public Params(BizProductOrderRequest bizProductOrderRequest) {
            Intrinsics.checkNotNullParameter(bizProductOrderRequest, "");
            this.request = bizProductOrderRequest;
        }

        @JvmName(name = "getRequest")
        public final BizProductOrderRequest getRequest() {
            return this.request;
        }
    }
}

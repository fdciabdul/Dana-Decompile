package id.dana.domain.electronicmoney.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.electronicmoney.ElectronicmoneyRepository;
import id.dana.domain.electronicmoney.model.response.EmoneyCardInfo;
import io.reactivex.Observable;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/electronicmoney/interactor/InquireBalanceEmoney;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/electronicmoney/model/response/EmoneyCardInfo;", "Lid/dana/domain/electronicmoney/interactor/InquireBalanceEmoney$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/electronicmoney/interactor/InquireBalanceEmoney$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/electronicmoney/ElectronicmoneyRepository;", "electronicmoneyRepository", "Lid/dana/domain/electronicmoney/ElectronicmoneyRepository;", "<init>", "(Lid/dana/domain/electronicmoney/ElectronicmoneyRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class InquireBalanceEmoney extends BaseUseCase<EmoneyCardInfo, Params> {
    private final ElectronicmoneyRepository electronicmoneyRepository;

    @Inject
    public InquireBalanceEmoney(ElectronicmoneyRepository electronicmoneyRepository) {
        Intrinsics.checkNotNullParameter(electronicmoneyRepository, "");
        this.electronicmoneyRepository = electronicmoneyRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<EmoneyCardInfo> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.electronicmoneyRepository.inquireBalance(params.getData());
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\b\u0010\tR%\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/domain/electronicmoney/interactor/InquireBalanceEmoney$Params;", "", "", "", "data", "Ljava/util/Map;", "getData", "()Ljava/util/Map;", "<init>", "(Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Params {
        private final Map<String, String> data;

        public Params(Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "");
            this.data = map;
        }

        @JvmName(name = "getData")
        public final Map<String, String> getData() {
            return this.data;
        }
    }
}

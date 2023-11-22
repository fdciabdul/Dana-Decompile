package id.dana.domain.electronicmoney.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.electronicmoney.ElectronicmoneyRepository;
import id.dana.domain.electronicmoney.model.response.ElectronicMoneyConfig;
import io.reactivex.Observable;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0004\u0012\u00020\u00050\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/domain/electronicmoney/interactor/GetElectronicMoneyConfig;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "", "Lid/dana/domain/electronicmoney/model/response/ElectronicMoneyConfig;", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "Lid/dana/domain/electronicmoney/ElectronicmoneyRepository;", "electronicmoneyRepository", "Lid/dana/domain/electronicmoney/ElectronicmoneyRepository;", "<init>", "(Lid/dana/domain/electronicmoney/ElectronicmoneyRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GetElectronicMoneyConfig extends BaseUseCase<Map<String, ? extends ElectronicMoneyConfig>, NoParams> {
    private final ElectronicmoneyRepository electronicmoneyRepository;

    @Inject
    public GetElectronicMoneyConfig(ElectronicmoneyRepository electronicmoneyRepository) {
        Intrinsics.checkNotNullParameter(electronicmoneyRepository, "");
        this.electronicmoneyRepository = electronicmoneyRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Map<String, ElectronicMoneyConfig>> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.electronicmoneyRepository.getElectronicMoneyConfig();
    }
}

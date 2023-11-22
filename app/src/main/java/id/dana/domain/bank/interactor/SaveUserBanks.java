package id.dana.domain.bank.interactor;

import id.dana.domain.bank.model.UserBank;
import id.dana.domain.bank.repository.UserBankRepository;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/bank/interactor/SaveUserBanks;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "", "Lid/dana/domain/bank/model/UserBank;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Ljava/util/List;)Lio/reactivex/Observable;", "Lid/dana/domain/bank/repository/UserBankRepository;", "userBankRepository", "Lid/dana/domain/bank/repository/UserBankRepository;", "<init>", "(Lid/dana/domain/bank/repository/UserBankRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SaveUserBanks extends BaseUseCase<Boolean, List<? extends UserBank>> {
    private final UserBankRepository userBankRepository;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* bridge */ /* synthetic */ Observable<Boolean> buildUseCase(List<? extends UserBank> list) {
        return buildUseCase2((List<UserBank>) list);
    }

    @Inject
    public SaveUserBanks(UserBankRepository userBankRepository) {
        Intrinsics.checkNotNullParameter(userBankRepository, "");
        this.userBankRepository = userBankRepository;
    }

    /* renamed from: buildUseCase  reason: avoid collision after fix types in other method */
    public final Observable<Boolean> buildUseCase2(List<UserBank> params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.userBankRepository.saveUserBanks(params);
    }
}

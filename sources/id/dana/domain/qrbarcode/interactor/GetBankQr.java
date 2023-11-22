package id.dana.domain.qrbarcode.interactor;

import dagger.Module;
import id.dana.domain.bank.model.UserBank;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.qrbarcode.QrBarcodeRepository;
import id.dana.domain.qrbarcode.QrUserBankResult;
import id.dana.domain.splitbill.model.UserBankGenerateQr;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\u00020\b*\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/domain/qrbarcode/interactor/GetBankQr;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/qrbarcode/QrUserBankResult;", "Lid/dana/domain/bank/model/UserBank;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/bank/model/UserBank;)Lio/reactivex/Observable;", "Lid/dana/domain/splitbill/model/UserBankGenerateQr;", "toUserBankGenerateQr", "(Lid/dana/domain/bank/model/UserBank;)Lid/dana/domain/splitbill/model/UserBankGenerateQr;", "Lid/dana/domain/qrbarcode/QrBarcodeRepository;", "repository", "Lid/dana/domain/qrbarcode/QrBarcodeRepository;", "<init>", "(Lid/dana/domain/qrbarcode/QrBarcodeRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class GetBankQr extends BaseUseCase<QrUserBankResult, UserBank> {
    private final QrBarcodeRepository repository;

    @Inject
    public GetBankQr(QrBarcodeRepository qrBarcodeRepository) {
        Intrinsics.checkNotNullParameter(qrBarcodeRepository, "");
        this.repository = qrBarcodeRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<QrUserBankResult> buildUseCase(UserBank params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<QrUserBankResult> userBankQr = this.repository.getUserBankQr(toUserBankGenerateQr(params));
        Intrinsics.checkNotNullExpressionValue(userBankQr, "");
        return userBankQr;
    }

    private final UserBankGenerateQr toUserBankGenerateQr(UserBank userBank) {
        return new UserBankGenerateQr(userBank.getBankAccountIndexNo(), userBank.getBankAccountHolderName(), userBank.getBankAccountFormattedMaskedNo(), userBank.getWithdrawInstId(), userBank.getWithdrawPayMethod(), userBank.getWithdrawPayOption(), userBank.getWithdrawInstLocalName());
    }
}

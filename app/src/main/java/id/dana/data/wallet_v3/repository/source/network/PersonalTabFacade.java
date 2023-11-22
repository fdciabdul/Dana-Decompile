package id.dana.data.wallet_v3.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.pocket.model.KtpAssetResult;
import id.dana.data.pocket.model.PocketQueryListRequest;
import id.dana.data.pocket.model.PocketQueryListResult;
import id.dana.data.wallet_v3.repository.source.network.request.VerifyPinKtpRequest;
import id.dana.data.wallet_v3.repository.source.network.result.InsuranceResult;
import id.dana.data.wallet_v3.repository.source.network.result.KycStatusResult;
import id.dana.data.wallet_v3.repository.source.network.result.VerifyPinKtpResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/network/PersonalTabFacade;", "", "Lid/dana/data/pocket/model/PocketQueryListRequest;", "request", "Lid/dana/data/pocket/model/PocketQueryListResult;", "Lid/dana/data/wallet_v3/repository/source/network/result/InsuranceResult;", "queryInsuranceAsset", "(Lid/dana/data/pocket/model/PocketQueryListRequest;)Lid/dana/data/pocket/model/PocketQueryListResult;", "Lid/dana/data/pocket/model/KtpAssetResult;", "queryKtpAsset", "(Lid/dana/data/pocket/model/PocketQueryListRequest;)Lid/dana/data/pocket/model/KtpAssetResult;", "Lid/dana/data/wallet_v3/repository/source/network/result/KycStatusResult;", "queryKycInfoAsset", "(Lid/dana/data/pocket/model/PocketQueryListRequest;)Lid/dana/data/wallet_v3/repository/source/network/result/KycStatusResult;", "Lid/dana/data/wallet_v3/repository/source/network/request/VerifyPinKtpRequest;", "Lid/dana/data/wallet_v3/repository/source/network/result/VerifyPinKtpResult;", "verifyPinKtp", "(Lid/dana/data/wallet_v3/repository/source/network/request/VerifyPinKtpRequest;)Lid/dana/data/wallet_v3/repository/source/network/result/VerifyPinKtpResult;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface PersonalTabFacade {
    @OperationType("id.dana.omniprod.user.pocket.list")
    @SignCheck
    PocketQueryListResult<InsuranceResult> queryInsuranceAsset(PocketQueryListRequest request);

    @OperationType("id.dana.omniprod.user.pocket.list")
    @SignCheck
    KtpAssetResult queryKtpAsset(PocketQueryListRequest request);

    @OperationType("id.dana.omniprod.user.pocket.list")
    @SignCheck
    KycStatusResult queryKycInfoAsset(PocketQueryListRequest request);

    @OperationType("alipayplus.mobilewallet.user.password.verify")
    @SignCheck
    VerifyPinKtpResult verifyPinKtp(VerifyPinKtpRequest request);
}

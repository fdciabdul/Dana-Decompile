package id.dana.data.wallet_v3.repository.source.network;

import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.data.pocket.model.KtpAssetResult;
import id.dana.data.pocket.model.PocketQueryListResult;
import id.dana.data.wallet_v3.repository.source.network.result.InsuranceResult;
import id.dana.data.wallet_v3.repository.source.network.result.KycStatusResult;
import id.dana.data.wallet_v3.repository.source.network.result.VerifyPinKtpResult;
import id.dana.domain.pocket.model.AssetStatus;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J6\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&J\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH&J\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH&J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0004H&J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001cÀ\u0006\u0001"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/network/PersonalTabEntityData;", "", "checkKtpPopUp", "Lio/reactivex/Observable;", "", "phoneNumber", "", "getInsuranceAssets", "Lid/dana/data/pocket/model/PocketQueryListResult;", "Lid/dana/data/wallet_v3/repository/source/network/result/InsuranceResult;", "pageNum", "", SecurityConstants.KEY_PAGE_SIZE, "statuses", "", "Lid/dana/domain/pocket/model/AssetStatus;", "getKtpInfo", "Lid/dana/data/pocket/model/KtpAssetResult;", "getUserKYCStatus", "Lid/dana/data/wallet_v3/repository/source/network/result/KycStatusResult;", "isFirstTimeCheck", "saveFirstTimeCheck", "saveKtpPopUpCheck", "ktpIsSaved", "verifyPinKtp", "Lid/dana/data/wallet_v3/repository/source/network/result/VerifyPinKtpResult;", "inputPin", RecordError.KEY_PUB_KEY, "data_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface PersonalTabEntityData {
    Observable<Boolean> checkKtpPopUp(String phoneNumber);

    Observable<PocketQueryListResult<InsuranceResult>> getInsuranceAssets(int pageNum, int r2, List<? extends AssetStatus> statuses);

    Observable<KtpAssetResult> getKtpInfo(int pageNum, int r2);

    Observable<KycStatusResult> getUserKYCStatus(int pageNum, int r2);

    Observable<Boolean> isFirstTimeCheck(String phoneNumber);

    Observable<Boolean> saveFirstTimeCheck(String phoneNumber);

    Observable<Boolean> saveKtpPopUpCheck(String phoneNumber, boolean ktpIsSaved);

    Observable<VerifyPinKtpResult> verifyPinKtp(String inputPin, String r2);

    /* renamed from: id.dana.data.wallet_v3.repository.source.network.PersonalTabEntityData$-CC */
    /* loaded from: classes8.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Observable getUserKYCStatus$default(PersonalTabEntityData personalTabEntityData, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    i = 1;
                }
                if ((i3 & 2) != 0) {
                    i2 = 1;
                }
                return personalTabEntityData.getUserKYCStatus(i, i2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserKYCStatus");
        }

        public static /* synthetic */ Observable getKtpInfo$default(PersonalTabEntityData personalTabEntityData, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    i = 1;
                }
                if ((i3 & 2) != 0) {
                    i2 = 1;
                }
                return personalTabEntityData.getKtpInfo(i, i2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getKtpInfo");
        }

        public static /* synthetic */ Observable getInsuranceAssets$default(PersonalTabEntityData personalTabEntityData, int i, int i2, List list, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    i = 1;
                }
                if ((i3 & 2) != 0) {
                    i2 = 10;
                }
                return personalTabEntityData.getInsuranceAssets(i, i2, list);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInsuranceAssets");
        }
    }
}

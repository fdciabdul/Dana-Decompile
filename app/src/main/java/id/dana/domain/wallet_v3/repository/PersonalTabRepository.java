package id.dana.domain.wallet_v3.repository;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.domain.pocket.model.AssetStatus;
import id.dana.domain.pocket.model.PocketQueryList;
import id.dana.domain.wallet_v3.model.InsuranceAsset;
import id.dana.domain.wallet_v3.model.KtpInfo;
import id.dana.domain.wallet_v3.model.KycInfo;
import id.dana.domain.wallet_v3.model.VerifyPinKtpModel;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J6\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH&J(\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00060\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH&J\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH&J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0014\u001a\u00020\u0004H&J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0014\u001a\u00020\u0004H&J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\u0006\u0010\u0018\u001a\u00020\u0019H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Lid/dana/domain/wallet_v3/repository/PersonalTabRepository;", "", "checkKtpConsultPopUp", "Lio/reactivex/Observable;", "", "getInsuranceAssets", "Lid/dana/domain/pocket/model/PocketQueryList;", "Lid/dana/domain/wallet_v3/model/InsuranceAsset;", "pageNum", "", SecurityConstants.KEY_PAGE_SIZE, "statuses", "", "Lid/dana/domain/pocket/model/AssetStatus;", "getKtpInfo", "Lid/dana/domain/wallet_v3/model/KtpInfo;", "getUserKYCStatus", "Lid/dana/domain/wallet_v3/model/KycInfo;", "isKtpSaved", "saveKtpConsultPopUp", "userSaveKtp", "storeKtpSaved", "verifyPinPersonalKtp", "Lid/dana/domain/wallet_v3/model/VerifyPinKtpModel;", "inputPin", "", "domain_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface PersonalTabRepository {
    Observable<Boolean> checkKtpConsultPopUp();

    Observable<PocketQueryList<InsuranceAsset>> getInsuranceAssets(int pageNum, int pageSize, List<? extends AssetStatus> statuses);

    Observable<PocketQueryList<KtpInfo>> getKtpInfo(int pageNum, int pageSize);

    Observable<KycInfo> getUserKYCStatus(int pageNum, int pageSize);

    Observable<Boolean> isKtpSaved();

    Observable<Boolean> saveKtpConsultPopUp(boolean userSaveKtp);

    Observable<Boolean> storeKtpSaved(boolean userSaveKtp);

    Observable<VerifyPinKtpModel> verifyPinPersonalKtp(String inputPin);

    /* renamed from: id.dana.domain.wallet_v3.repository.PersonalTabRepository$-CC  reason: invalid class name */
    /* loaded from: classes8.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Observable getUserKYCStatus$default(PersonalTabRepository personalTabRepository, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    i = 1;
                }
                if ((i3 & 2) != 0) {
                    i2 = 1;
                }
                return personalTabRepository.getUserKYCStatus(i, i2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserKYCStatus");
        }

        public static /* synthetic */ Observable getKtpInfo$default(PersonalTabRepository personalTabRepository, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    i = 1;
                }
                if ((i3 & 2) != 0) {
                    i2 = 1;
                }
                return personalTabRepository.getKtpInfo(i, i2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getKtpInfo");
        }

        public static /* synthetic */ Observable getInsuranceAssets$default(PersonalTabRepository personalTabRepository, int i, int i2, List list, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    i = 1;
                }
                if ((i3 & 2) != 0) {
                    i2 = 10;
                }
                return personalTabRepository.getInsuranceAssets(i, i2, list);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInsuranceAssets");
        }
    }
}

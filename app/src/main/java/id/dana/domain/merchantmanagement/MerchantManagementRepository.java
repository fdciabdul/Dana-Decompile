package id.dana.domain.merchantmanagement;

import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.domain.merchantmanagement.model.LinkedMerchantInfo;
import id.dana.domain.merchantmanagement.model.UnbindConsultInfo;
import id.dana.domain.merchantmanagement.model.UnbindMerchantParam;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H&J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\n\u001a\u00020\u000bH&J*\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004H&J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Lid/dana/domain/merchantmanagement/MerchantManagementRepository;", "", "checkUnbindEligibility", "Lio/reactivex/Observable;", "", "clientId", "merchantId", "divisionId", "getLinkedMerchants", "Lid/dana/domain/merchantmanagement/model/LinkedMerchantInfo;", ZdocRecordService.PAGE_NUMBER, "", "unbindConsult", "Lid/dana/domain/merchantmanagement/model/UnbindConsultInfo;", "unbindMerchant", "", "unbindMerchantParam", "Lid/dana/domain/merchantmanagement/model/UnbindMerchantParam;", "domain_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface MerchantManagementRepository {
    Observable<String> checkUnbindEligibility(String clientId, String merchantId, String divisionId);

    Observable<LinkedMerchantInfo> getLinkedMerchants(int pageNumber);

    Observable<UnbindConsultInfo> unbindConsult(String clientId, String merchantId, String divisionId);

    Observable<Boolean> unbindMerchant(UnbindMerchantParam unbindMerchantParam);

    /* renamed from: id.dana.domain.merchantmanagement.MerchantManagementRepository$-CC  reason: invalid class name */
    /* loaded from: classes8.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Observable unbindConsult$default(MerchantManagementRepository merchantManagementRepository, String str, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str3 = null;
                }
                return merchantManagementRepository.unbindConsult(str, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unbindConsult");
        }
    }
}

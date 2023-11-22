package id.dana.data.merchantmanagement.mapper;

import com.alipay.iap.android.common.utils.security.RSAHelper;
import id.dana.data.merchantmanagement.model.MerchantInfoDTO;
import id.dana.data.merchantmanagement.repository.source.network.request.UnbindMerchantRequest;
import id.dana.data.merchantmanagement.repository.source.network.result.BoundMerchantResult;
import id.dana.data.merchantmanagement.repository.source.network.result.UnbindConsultResult;
import id.dana.domain.auth.face.result.SecurityContext;
import id.dana.domain.merchantmanagement.model.LinkedMerchant;
import id.dana.domain.merchantmanagement.model.LinkedMerchantInfo;
import id.dana.domain.merchantmanagement.model.UnbindConsultInfo;
import id.dana.domain.merchantmanagement.model.UnbindMerchantParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\b*\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\bH\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u0011\u0010\r\u001a\u00020\f*\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e\u001a\u0011\u0010\u0011\u001a\u00020\u0010*\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/data/merchantmanagement/model/MerchantInfoDTO;", "Lid/dana/domain/merchantmanagement/model/LinkedMerchant;", "toLinkedMerchant", "(Lid/dana/data/merchantmanagement/model/MerchantInfoDTO;)Lid/dana/domain/merchantmanagement/model/LinkedMerchant;", "Lid/dana/data/merchantmanagement/repository/source/network/result/BoundMerchantResult;", "Lid/dana/domain/merchantmanagement/model/LinkedMerchantInfo;", "toLinkedMerchantInfo", "(Lid/dana/data/merchantmanagement/repository/source/network/result/BoundMerchantResult;)Lid/dana/domain/merchantmanagement/model/LinkedMerchantInfo;", "", "toLinkedMerchantList", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/data/merchantmanagement/repository/source/network/result/UnbindConsultResult;", "Lid/dana/domain/merchantmanagement/model/UnbindConsultInfo;", "toUnbindConsultInfo", "(Lid/dana/data/merchantmanagement/repository/source/network/result/UnbindConsultResult;)Lid/dana/domain/merchantmanagement/model/UnbindConsultInfo;", "Lid/dana/domain/merchantmanagement/model/UnbindMerchantParam;", "Lid/dana/data/merchantmanagement/repository/source/network/request/UnbindMerchantRequest;", "toUnbindMerchantRequest", "(Lid/dana/domain/merchantmanagement/model/UnbindMerchantParam;)Lid/dana/data/merchantmanagement/repository/source/network/request/UnbindMerchantRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MerchantManagementMapperKt {
    public static final LinkedMerchantInfo toLinkedMerchantInfo(BoundMerchantResult boundMerchantResult) {
        Intrinsics.checkNotNullParameter(boundMerchantResult, "");
        return new LinkedMerchantInfo(toLinkedMerchantList(boundMerchantResult.getMerchantInfoList()), boundMerchantResult.getTotalPageNumber());
    }

    public static final UnbindConsultInfo toUnbindConsultInfo(UnbindConsultResult unbindConsultResult) {
        Intrinsics.checkNotNullParameter(unbindConsultResult, "");
        boolean z = unbindConsultResult.success;
        SecurityContext securityContext = unbindConsultResult.getSecurityContext();
        return new UnbindConsultInfo(z, securityContext != null ? securityContext.getPubKey() : null, unbindConsultResult.getSecurityId(), null, null, null, 56, null);
    }

    public static final UnbindMerchantRequest toUnbindMerchantRequest(UnbindMerchantParam unbindMerchantParam) {
        Intrinsics.checkNotNullParameter(unbindMerchantParam, "");
        String clientId = unbindMerchantParam.getClientId();
        String merchantId = unbindMerchantParam.getMerchantId();
        String divisionId = unbindMerchantParam.getDivisionId();
        String encrypt = RSAHelper.encrypt(unbindMerchantParam.getPin(), unbindMerchantParam.getPubKey());
        Intrinsics.checkNotNullExpressionValue(encrypt, "");
        return new UnbindMerchantRequest(clientId, merchantId, divisionId, encrypt, unbindMerchantParam.getSecurityId(), unbindMerchantParam.getUnbindEligibilityCheckId(), unbindMerchantParam.getUserBoundId());
    }

    private static final List<LinkedMerchant> toLinkedMerchantList(List<MerchantInfoDTO> list) {
        if (list != null) {
            List<MerchantInfoDTO> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(toLinkedMerchant((MerchantInfoDTO) it.next()));
            }
            return arrayList;
        }
        return new ArrayList();
    }

    private static final LinkedMerchant toLinkedMerchant(MerchantInfoDTO merchantInfoDTO) {
        return new LinkedMerchant(merchantInfoDTO.getMerchantName(), merchantInfoDTO.getMerchantLogo(), merchantInfoDTO.getMerchantPCLogo(), merchantInfoDTO.getMerchantBoundDate(), merchantInfoDTO.getMerchantId(), merchantInfoDTO.getDivisionId(), merchantInfoDTO.getClientId(), merchantInfoDTO.getRegId(), merchantInfoDTO.getUserBoundId());
    }
}

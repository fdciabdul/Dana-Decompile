package id.dana.data.kycamledd.mapper;

import id.dana.data.kycamledd.repository.source.network.request.EddInfoRequest;
import id.dana.data.kycamledd.repository.source.network.request.EddSubmitInfoDTORequest;
import id.dana.domain.kycamledd.model.EddSubmitInfo;
import id.dana.domain.kycamledd.model.EddSubmitInfoDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/domain/kycamledd/model/EddSubmitInfo;", "Lid/dana/data/kycamledd/repository/source/network/request/EddInfoRequest;", "toEddInfoRequest", "(Lid/dana/domain/kycamledd/model/EddSubmitInfo;)Lid/dana/data/kycamledd/repository/source/network/request/EddInfoRequest;", "Lid/dana/domain/kycamledd/model/EddSubmitInfoDTO;", "Lid/dana/data/kycamledd/repository/source/network/request/EddSubmitInfoDTORequest;", "toEddSubmitInfoDTORequest", "(Lid/dana/domain/kycamledd/model/EddSubmitInfoDTO;)Lid/dana/data/kycamledd/repository/source/network/request/EddSubmitInfoDTORequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EddSubmitInfoToEddInfoRequestMapperKt {
    public static final EddInfoRequest toEddInfoRequest(EddSubmitInfo eddSubmitInfo) {
        Intrinsics.checkNotNullParameter(eddSubmitInfo, "");
        String amlOrderId = eddSubmitInfo.getAmlOrderId();
        List<EddSubmitInfoDTO> eddQuestionInfos = eddSubmitInfo.getEddQuestionInfos();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(eddQuestionInfos, 10));
        Iterator<T> it = eddQuestionInfos.iterator();
        while (it.hasNext()) {
            arrayList.add(toEddSubmitInfoDTORequest((EddSubmitInfoDTO) it.next()));
        }
        return new EddInfoRequest(amlOrderId, arrayList);
    }

    public static final EddSubmitInfoDTORequest toEddSubmitInfoDTORequest(EddSubmitInfoDTO eddSubmitInfoDTO) {
        Intrinsics.checkNotNullParameter(eddSubmitInfoDTO, "");
        return new EddSubmitInfoDTORequest(eddSubmitInfoDTO.getQuestionId(), eddSubmitInfoDTO.getAnswerId());
    }
}

package id.dana.kycamledd.mapper;

import id.dana.domain.kycamledd.model.EddSubmitInfo;
import id.dana.domain.kycamledd.model.EddSubmitInfoDTO;
import id.dana.kycamledd.model.EddSubmitInfoDTOModel;
import id.dana.kycamledd.model.EddSubmitInfoModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/kycamledd/model/EddSubmitInfoModel;", "Lid/dana/domain/kycamledd/model/EddSubmitInfo;", "MyBillsEntityDataFactory", "(Lid/dana/kycamledd/model/EddSubmitInfoModel;)Lid/dana/domain/kycamledd/model/EddSubmitInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EddSubmitInfoModelToEddSubmitInfoMapperKt {
    public static final EddSubmitInfo MyBillsEntityDataFactory(EddSubmitInfoModel eddSubmitInfoModel) {
        Intrinsics.checkNotNullParameter(eddSubmitInfoModel, "");
        String str = eddSubmitInfoModel.BuiltInFictitiousFunctionClassFactory;
        List<EddSubmitInfoDTOModel> list = eddSubmitInfoModel.getAuthRequestContext;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (EddSubmitInfoDTOModel eddSubmitInfoDTOModel : list) {
            Intrinsics.checkNotNullParameter(eddSubmitInfoDTOModel, "");
            arrayList.add(new EddSubmitInfoDTO(eddSubmitInfoDTOModel.KClassImpl$Data$declaredNonStaticMembers$2, eddSubmitInfoDTOModel.PlaceComponentResult));
        }
        return new EddSubmitInfo(str, arrayList);
    }
}

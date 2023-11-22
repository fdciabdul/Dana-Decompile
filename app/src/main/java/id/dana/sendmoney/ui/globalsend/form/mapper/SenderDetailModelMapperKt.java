package id.dana.sendmoney.ui.globalsend.form.mapper;

import id.dana.sendmoney.domain.globalsend.model.sender.SenderDetail;
import id.dana.sendmoney.ui.globalsend.form.model.SenderDetailModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/model/SenderDetailModel;", "Lid/dana/sendmoney/domain/globalsend/model/sender/SenderDetail;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/ui/globalsend/form/model/SenderDetailModel;)Lid/dana/sendmoney/domain/globalsend/model/sender/SenderDetail;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class SenderDetailModelMapperKt {
    public static final SenderDetail BuiltInFictitiousFunctionClassFactory(SenderDetailModel senderDetailModel) {
        Intrinsics.checkNotNullParameter(senderDetailModel, "");
        return new SenderDetail(senderDetailModel.getPlaceComponentResult(), senderDetailModel.getAuthRequestContext, senderDetailModel.MyBillsEntityDataFactory, senderDetailModel.BuiltInFictitiousFunctionClassFactory, senderDetailModel.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}

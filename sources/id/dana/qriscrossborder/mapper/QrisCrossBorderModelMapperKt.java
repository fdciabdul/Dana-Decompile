package id.dana.qriscrossborder.mapper;

import id.dana.domain.qriscrossborder.model.QrisCrossBorderContent;
import id.dana.model.QrisCrossBorderContentModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/qriscrossborder/model/QrisCrossBorderContent;", "Lid/dana/model/QrisCrossBorderContentModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/qriscrossborder/model/QrisCrossBorderContent;)Lid/dana/model/QrisCrossBorderContentModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QrisCrossBorderModelMapperKt {
    public static final QrisCrossBorderContentModel KClassImpl$Data$declaredNonStaticMembers$2(QrisCrossBorderContent qrisCrossBorderContent) {
        Intrinsics.checkNotNullParameter(qrisCrossBorderContent, "");
        return new QrisCrossBorderContentModel(qrisCrossBorderContent.getTitle(), qrisCrossBorderContent.getSubtitle(), qrisCrossBorderContent.getButtonTitle(), qrisCrossBorderContent.getImageUrl(), qrisCrossBorderContent.getDescription());
    }
}

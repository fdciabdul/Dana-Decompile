package id.dana.data.config.mapper;

import id.dana.data.config.source.amcs.result.QrisCrossBorderContentResult;
import id.dana.domain.qriscrossborder.model.QrisCrossBorderContent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/config/source/amcs/result/QrisCrossBorderContentResult;", "Lid/dana/domain/qriscrossborder/model/QrisCrossBorderContent;", "toQrisCrossBorderContent", "(Lid/dana/data/config/source/amcs/result/QrisCrossBorderContentResult;)Lid/dana/domain/qriscrossborder/model/QrisCrossBorderContent;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QrisCrossBorderContentResultMapperKt {
    public static final QrisCrossBorderContent toQrisCrossBorderContent(QrisCrossBorderContentResult qrisCrossBorderContentResult) {
        Intrinsics.checkNotNullParameter(qrisCrossBorderContentResult, "");
        return new QrisCrossBorderContent(qrisCrossBorderContentResult.getTitle(), qrisCrossBorderContentResult.getSubtitle(), qrisCrossBorderContentResult.getButtonTitle(), qrisCrossBorderContentResult.getImageUrl(), qrisCrossBorderContentResult.getDescription());
    }
}
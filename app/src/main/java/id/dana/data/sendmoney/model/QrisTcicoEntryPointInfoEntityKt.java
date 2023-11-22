package id.dana.data.sendmoney.model;

import id.dana.domain.sendmoney.model.QrisTcicoEntryPointInfo;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/sendmoney/model/QrisTcicoEntryPointInfoEntity;", "Lid/dana/domain/sendmoney/model/QrisTcicoEntryPointInfo;", "toQrisTcicoEntryPoint", "(Lid/dana/data/sendmoney/model/QrisTcicoEntryPointInfoEntity;)Lid/dana/domain/sendmoney/model/QrisTcicoEntryPointInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QrisTcicoEntryPointInfoEntityKt {
    public static final QrisTcicoEntryPointInfo toQrisTcicoEntryPoint(QrisTcicoEntryPointInfoEntity qrisTcicoEntryPointInfoEntity) {
        if (qrisTcicoEntryPointInfoEntity == null) {
            return new QrisTcicoEntryPointInfo(false, false, null, null, null, 31, null);
        }
        return new QrisTcicoEntryPointInfo(qrisTcicoEntryPointInfoEntity.getVisibleStatus(), qrisTcicoEntryPointInfoEntity.getEnableStatus(), qrisTcicoEntryPointInfoEntity.getInstId(), qrisTcicoEntryPointInfoEntity.getInstName(), qrisTcicoEntryPointInfoEntity.getInstLocalName());
    }
}

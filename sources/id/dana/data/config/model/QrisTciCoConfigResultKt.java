package id.dana.data.config.model;

import id.dana.domain.featureconfig.model.QrisTciCoConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/config/model/QrisTciCoConfigResult;", "Lid/dana/domain/featureconfig/model/QrisTciCoConfig;", "toQrisTciCoConfig", "(Lid/dana/data/config/model/QrisTciCoConfigResult;)Lid/dana/domain/featureconfig/model/QrisTciCoConfig;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QrisTciCoConfigResultKt {
    public static final QrisTciCoConfig toQrisTciCoConfig(QrisTciCoConfigResult qrisTciCoConfigResult) {
        Intrinsics.checkNotNullParameter(qrisTciCoConfigResult, "");
        Boolean requestMoney = qrisTciCoConfigResult.getRequestMoney();
        boolean booleanValue = requestMoney != null ? requestMoney.booleanValue() : false;
        Boolean profile = qrisTciCoConfigResult.getProfile();
        return new QrisTciCoConfig(booleanValue, profile != null ? profile.booleanValue() : false);
    }
}

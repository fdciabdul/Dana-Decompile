package id.dana.data.requestmoney.repository.model;

import id.dana.domain.requestmoney.model.NameCheckConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/requestmoney/repository/model/NameCheckConfigEntity;", "Lid/dana/domain/requestmoney/model/NameCheckConfig;", "toNameCheckConfig", "(Lid/dana/data/requestmoney/repository/model/NameCheckConfigEntity;)Lid/dana/domain/requestmoney/model/NameCheckConfig;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NameCheckConfigEntityKt {
    public static final NameCheckConfig toNameCheckConfig(NameCheckConfigEntity nameCheckConfigEntity) {
        Intrinsics.checkNotNullParameter(nameCheckConfigEntity, "");
        return new NameCheckConfig(nameCheckConfigEntity.getRetryLimit(), nameCheckConfigEntity.getFreezeTime(), nameCheckConfigEntity.getResetTime());
    }
}

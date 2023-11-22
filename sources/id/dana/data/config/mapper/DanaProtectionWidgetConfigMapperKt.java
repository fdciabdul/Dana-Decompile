package id.dana.data.config.mapper;

import id.dana.data.config.model.DanaProtectionWidgetConfigResult;
import id.dana.domain.danaprotection.model.DanaProtectionWidgetConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/config/model/DanaProtectionWidgetConfigResult;", "Lid/dana/domain/danaprotection/model/DanaProtectionWidgetConfig;", "toDanaProtectionWidgetConfig", "(Lid/dana/data/config/model/DanaProtectionWidgetConfigResult;)Lid/dana/domain/danaprotection/model/DanaProtectionWidgetConfig;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanaProtectionWidgetConfigMapperKt {
    public static final DanaProtectionWidgetConfig toDanaProtectionWidgetConfig(DanaProtectionWidgetConfigResult danaProtectionWidgetConfigResult) {
        Intrinsics.checkNotNullParameter(danaProtectionWidgetConfigResult, "");
        return new DanaProtectionWidgetConfig(danaProtectionWidgetConfigResult.isApiToggleEnabled(), danaProtectionWidgetConfigResult.isNewWidgetEnabled(), danaProtectionWidgetConfigResult.getExpiredCacheTimeInMinute());
    }
}

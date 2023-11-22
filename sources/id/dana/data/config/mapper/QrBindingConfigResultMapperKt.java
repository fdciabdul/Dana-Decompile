package id.dana.data.config.mapper;

import id.dana.data.config.model.QrBindingConfigResult;
import id.dana.domain.oauth.model.QrBindingConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/config/model/QrBindingConfigResult;", "Lid/dana/domain/oauth/model/QrBindingConfig;", "toQrBindingConfig", "(Lid/dana/data/config/model/QrBindingConfigResult;)Lid/dana/domain/oauth/model/QrBindingConfig;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QrBindingConfigResultMapperKt {
    public static final QrBindingConfig toQrBindingConfig(QrBindingConfigResult qrBindingConfigResult) {
        Intrinsics.checkNotNullParameter(qrBindingConfigResult, "");
        boolean enable = qrBindingConfigResult.getEnable();
        ArrayList qrIdentifier = qrBindingConfigResult.getQrIdentifier();
        if (qrIdentifier == null) {
            qrIdentifier = new ArrayList();
        }
        List<String> list = qrIdentifier;
        HashMap redirectUrl = qrBindingConfigResult.getRedirectUrl();
        if (redirectUrl == null) {
            redirectUrl = new HashMap();
        }
        Map<String, String> map = redirectUrl;
        Long initialRetryInterval = qrBindingConfigResult.getInitialRetryInterval();
        long longValue = initialRetryInterval != null ? initialRetryInterval.longValue() : 0L;
        Long maxRetryInterval = qrBindingConfigResult.getMaxRetryInterval();
        return new QrBindingConfig(enable, list, map, longValue, maxRetryInterval != null ? maxRetryInterval.longValue() : 0L);
    }
}

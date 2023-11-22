package id.dana.data.model;

import id.dana.domain.featureconfig.model.DiagnosticLogConfig;
import id.dana.rum.model.RumConfigModel;
import id.dana.rum.model.SplunkConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/featureconfig/model/DiagnosticLogConfig;", "Lid/dana/rum/model/RumConfigModel;", "toRumConfigModel", "(Lid/dana/domain/featureconfig/model/DiagnosticLogConfig;)Lid/dana/rum/model/RumConfigModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DiagnosticLogExtKt {
    public static final RumConfigModel toRumConfigModel(DiagnosticLogConfig diagnosticLogConfig) {
        Intrinsics.checkNotNullParameter(diagnosticLogConfig, "");
        return new RumConfigModel(diagnosticLogConfig.getEnabled(), diagnosticLogConfig.getFirebase(), new SplunkConfig(diagnosticLogConfig.getSplunkConfig().getEnabled(), diagnosticLogConfig.getSplunkConfig().getNetworkInstrumentation()));
    }
}

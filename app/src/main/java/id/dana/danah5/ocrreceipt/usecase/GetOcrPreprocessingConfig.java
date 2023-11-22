package id.dana.danah5.ocrreceipt.usecase;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.appcontainer.plugin.ocrreceipt.repository.OcrConfigRepository;
import id.dana.danah5.ocrreceipt.usecase.model.OcrImagePreprocessingConfigModel;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/danah5/ocrreceipt/usecase/GetOcrPreprocessingConfig;", "", "Lio/reactivex/Single;", "Lid/dana/danah5/ocrreceipt/usecase/model/OcrImagePreprocessingConfigModel;", BridgeDSL.INVOKE, "()Lio/reactivex/Single;", "Lid/dana/appcontainer/plugin/ocrreceipt/repository/OcrConfigRepository;", "ocrConfigRepository", "Lid/dana/appcontainer/plugin/ocrreceipt/repository/OcrConfigRepository;", "<init>", "(Lid/dana/appcontainer/plugin/ocrreceipt/repository/OcrConfigRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class GetOcrPreprocessingConfig {
    private final OcrConfigRepository ocrConfigRepository;

    @Inject
    public GetOcrPreprocessingConfig(OcrConfigRepository ocrConfigRepository) {
        Intrinsics.checkNotNullParameter(ocrConfigRepository, "");
        this.ocrConfigRepository = ocrConfigRepository;
    }

    public final Single<OcrImagePreprocessingConfigModel> invoke() {
        return this.ocrConfigRepository.getImagePreprocessingConfig();
    }
}

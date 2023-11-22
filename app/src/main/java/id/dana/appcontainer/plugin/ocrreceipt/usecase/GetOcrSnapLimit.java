package id.dana.appcontainer.plugin.ocrreceipt.usecase;

import id.dana.appcontainer.plugin.ocrreceipt.repository.OcrConfigRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/appcontainer/plugin/ocrreceipt/usecase/GetOcrSnapLimit;", "", "Lid/dana/appcontainer/plugin/ocrreceipt/repository/OcrConfigRepository;", "PlaceComponentResult", "Lid/dana/appcontainer/plugin/ocrreceipt/repository/OcrConfigRepository;", "getAuthRequestContext", "p0", "<init>", "(Lid/dana/appcontainer/plugin/ocrreceipt/repository/OcrConfigRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class GetOcrSnapLimit {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final OcrConfigRepository getAuthRequestContext;

    @Inject
    public GetOcrSnapLimit(OcrConfigRepository ocrConfigRepository) {
        Intrinsics.checkNotNullParameter(ocrConfigRepository, "");
        this.getAuthRequestContext = ocrConfigRepository;
    }
}

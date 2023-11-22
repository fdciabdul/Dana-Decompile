package id.dana.ocr;

import com.otaliastudios.cameraview.PictureResult;
import id.dana.ocr.OCRCameraContract;
import id.dana.ocr.model.OCRRequestModel;
import id.dana.utils.foundation.logger.log.DanaLog;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001b\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004R\u0016\u0010\b\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011"}, d2 = {"Lid/dana/ocr/OCRCameraPresenter;", "Lid/dana/ocr/OCRCameraContract$Presenter;", "", "PlaceComponentResult", "()V", "onDestroy", "Lcom/otaliastudios/cameraview/PictureResult;", "p0", "MyBillsEntityDataFactory", "(Lcom/otaliastudios/cameraview/PictureResult;)V", "BuiltInFictitiousFunctionClassFactory", "", "getAuthRequestContext", "J", "Lid/dana/ocr/model/OCRRequestModel;", "Lid/dana/ocr/model/OCRRequestModel;", "Lid/dana/ocr/OCRCameraContract$View;", "Lid/dana/ocr/OCRCameraContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "<init>", "(Lid/dana/ocr/OCRCameraContract$View;Lid/dana/ocr/model/OCRRequestModel;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class OCRCameraPresenter implements OCRCameraContract.Presenter {
    private static final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final OCRRequestModel PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final OCRCameraContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private long MyBillsEntityDataFactory;

    @Inject
    public OCRCameraPresenter(OCRCameraContract.View view, OCRRequestModel oCRRequestModel) {
        Intrinsics.checkNotNullParameter(view, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.PlaceComponentResult = oCRRequestModel;
    }

    @Override // id.dana.ocr.OCRCameraContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.showProgress();
        DanaLog.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2, "Capturing picture...");
        this.MyBillsEntityDataFactory = System.currentTimeMillis();
        this.KClassImpl$Data$declaredNonStaticMembers$2.capturePicture();
    }

    @Override // id.dana.ocr.OCRCameraContract.Presenter
    public final void MyBillsEntityDataFactory(PictureResult p0) {
        Unit unit;
        Intrinsics.checkNotNullParameter(p0, "");
        long currentTimeMillis = System.currentTimeMillis();
        if (this.MyBillsEntityDataFactory == 0) {
            this.MyBillsEntityDataFactory = currentTimeMillis - 300;
        }
        String str = KClassImpl$Data$declaredNonStaticMembers$2;
        StringBuilder sb = new StringBuilder();
        sb.append("Capture process delay: ");
        sb.append(currentTimeMillis - this.MyBillsEntityDataFactory);
        DanaLog.MyBillsEntityDataFactory(str, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("image rotation ");
        sb2.append(p0.getAuthRequestContext);
        DanaLog.MyBillsEntityDataFactory(str, sb2.toString());
        this.KClassImpl$Data$declaredNonStaticMembers$2.dismissProgress();
        OCRRequestModel oCRRequestModel = this.PlaceComponentResult;
        if (oCRRequestModel != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.openPreviewPage(p0, oCRRequestModel);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onFailure("001");
        }
    }

    @Override // id.dana.ocr.OCRCameraContract.Presenter
    public final void PlaceComponentResult() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.onFailure("002");
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.dismissProgress();
    }

    static {
        Intrinsics.checkNotNullExpressionValue("OCRCameraPresenter", "");
        KClassImpl$Data$declaredNonStaticMembers$2 = "OCRCameraPresenter";
    }
}

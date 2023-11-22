package id.dana.contract.staticqr;

import android.content.Context;
import android.net.Uri;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.contract.staticqr.DecodeQrImageContract;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.scanner.gallery.RxQRDecode;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;

@PerActivity
/* loaded from: classes4.dex */
public class DecodeQrImagePresenter implements DecodeQrImageContract.Presenter {
    private final RxQRDecode BuiltInFictitiousFunctionClassFactory;
    private final DecodeQrImageContract.View MyBillsEntityDataFactory;
    private final Context getAuthRequestContext;

    @Inject
    public DecodeQrImagePresenter(DecodeQrImageContract.View view, RxQRDecode rxQRDecode, Context context) {
        this.MyBillsEntityDataFactory = view;
        this.BuiltInFictitiousFunctionClassFactory = rxQRDecode;
        this.getAuthRequestContext = context;
    }

    @Override // id.dana.contract.staticqr.DecodeQrImageContract.Presenter
    public final void PlaceComponentResult(Uri uri, int i, int i2) {
        this.MyBillsEntityDataFactory.showProgress();
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(uri, i, i2, new DefaultObserver<Result>() { // from class: id.dana.contract.staticqr.DecodeQrImagePresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                Result result = (Result) obj;
                if (result != null) {
                    result.getText();
                    DecodeQrImagePresenter.this.MyBillsEntityDataFactory.dismissProgress();
                    DecodeQrImagePresenter.this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(result.getText());
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.SCAN_QRCODE_PREFIX);
                sb.append(getClass().getName());
                sb.append("decodeFromGallery:decodeFromGalleryResult = false");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.QRCODE_TAG, sb.toString());
                DecodeQrImagePresenter.this.MyBillsEntityDataFactory.dismissProgress();
                DecodeQrImagePresenter.this.MyBillsEntityDataFactory.onError("");
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.SCAN_QRCODE_PREFIX);
                sb.append(getClass().getName());
                sb.append("decodeFromGallery:decodeFromGallery = false");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.QRCODE_TAG, sb.toString());
                String BuiltInFictitiousFunctionClassFactory = DecodeQrImagePresenter.BuiltInFictitiousFunctionClassFactory(DecodeQrImagePresenter.this, th);
                DecodeQrImagePresenter.this.MyBillsEntityDataFactory.onError(BuiltInFictitiousFunctionClassFactory);
                DecodeQrImagePresenter.this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.Source.CAMERA_CARD_GALLERY_PICKER, "", BuiltInFictitiousFunctionClassFactory, th);
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        RxQRDecode rxQRDecode = this.BuiltInFictitiousFunctionClassFactory;
        if (rxQRDecode.BuiltInFictitiousFunctionClassFactory.isDisposed()) {
            return;
        }
        rxQRDecode.BuiltInFictitiousFunctionClassFactory.dispose();
    }

    static /* synthetic */ String BuiltInFictitiousFunctionClassFactory(DecodeQrImagePresenter decodeQrImagePresenter, Throwable th) {
        if (th instanceof NotFoundException) {
            return decodeQrImagePresenter.getAuthRequestContext.getString(R.string.decode_code_gallery_error_desc);
        }
        return decodeQrImagePresenter.getAuthRequestContext.getString(R.string.decode_code_gallery_error);
    }
}

package id.dana.animation;

import android.net.Uri;
import com.google.zxing.Result;
import id.dana.animation.ScanQrLoyaltyContract;
import id.dana.base.AbstractContractKt;
import id.dana.domain.DefaultObserver;
import id.dana.domain.qrbarcode.interactor.GetNativelyDecodedQr;
import id.dana.scanner.gallery.RxQRDecode;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0015\u0012\u0006\u0010\t\u001a\u00020\u0012\u0012\u0006\u0010\n\u001a\u00020\u000f¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/loyalty/ScanQrLoyaltyPresenter;", "Lid/dana/loyalty/ScanQrLoyaltyContract$Presenter;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "Landroid/net/Uri;", "", "p1", "p2", "MyBillsEntityDataFactory", "(Landroid/net/Uri;II)V", "onDestroy", "()V", "Lid/dana/domain/qrbarcode/interactor/GetNativelyDecodedQr;", "Lid/dana/domain/qrbarcode/interactor/GetNativelyDecodedQr;", "getAuthRequestContext", "Lid/dana/scanner/gallery/RxQRDecode;", "Lid/dana/scanner/gallery/RxQRDecode;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/loyalty/ScanQrLoyaltyContract$View;", "PlaceComponentResult", "Lid/dana/loyalty/ScanQrLoyaltyContract$View;", "<init>", "(Lid/dana/loyalty/ScanQrLoyaltyContract$View;Lid/dana/scanner/gallery/RxQRDecode;Lid/dana/domain/qrbarcode/interactor/GetNativelyDecodedQr;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ScanQrLoyaltyPresenter implements ScanQrLoyaltyContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GetNativelyDecodedQr getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final RxQRDecode KClassImpl$Data$declaredNonStaticMembers$2;
    private final ScanQrLoyaltyContract.View PlaceComponentResult;

    @Inject
    public ScanQrLoyaltyPresenter(ScanQrLoyaltyContract.View view, RxQRDecode rxQRDecode, GetNativelyDecodedQr getNativelyDecodedQr) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(rxQRDecode, "");
        Intrinsics.checkNotNullParameter(getNativelyDecodedQr, "");
        this.PlaceComponentResult = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = rxQRDecode;
        this.getAuthRequestContext = getNativelyDecodedQr;
    }

    @Override // id.dana.loyalty.ScanQrLoyaltyContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.MyBillsEntityDataFactory();
        this.getAuthRequestContext.execute(p0, new Function1<HashMap<String, String>, Unit>() { // from class: id.dana.loyalty.ScanQrLoyaltyPresenter$decode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap) {
                invoke2(hashMap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(HashMap<String, String> hashMap) {
                ScanQrLoyaltyContract.View view;
                ScanQrLoyaltyContract.View view2;
                Intrinsics.checkNotNullParameter(hashMap, "");
                view = ScanQrLoyaltyPresenter.this.PlaceComponentResult;
                view.dismissProgress();
                view2 = ScanQrLoyaltyPresenter.this.PlaceComponentResult;
                view2.KClassImpl$Data$declaredNonStaticMembers$2(hashMap);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.loyalty.ScanQrLoyaltyPresenter$decode$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                ScanQrLoyaltyContract.View view;
                ScanQrLoyaltyContract.View view2;
                ScanQrLoyaltyContract.View view3;
                Intrinsics.checkNotNullParameter(th, "");
                view = ScanQrLoyaltyPresenter.this.PlaceComponentResult;
                view.dismissProgress();
                if (th instanceof NumberFormatException) {
                    view3 = ScanQrLoyaltyPresenter.this.PlaceComponentResult;
                    view3.PlaceComponentResult();
                    return;
                }
                view2 = ScanQrLoyaltyPresenter.this.PlaceComponentResult;
                view2.onError(th.getMessage());
            }
        });
    }

    @Override // id.dana.loyalty.ScanQrLoyaltyContract.Presenter
    public final void MyBillsEntityDataFactory(Uri p0, int p1, int p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(p0, p1, p2, new DefaultObserver<Result>() { // from class: id.dana.loyalty.ScanQrLoyaltyPresenter$decodeFromGallery$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                ScanQrLoyaltyContract.View view;
                ScanQrLoyaltyContract.View view2;
                Result result = (Result) obj;
                Intrinsics.checkNotNullParameter(result, "");
                view = ScanQrLoyaltyPresenter.this.PlaceComponentResult;
                view.dismissProgress();
                view2 = ScanQrLoyaltyPresenter.this.PlaceComponentResult;
                String text = result.getText();
                Intrinsics.checkNotNullExpressionValue(text, "");
                view2.PlaceComponentResult(text);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                ScanQrLoyaltyContract.View view;
                ScanQrLoyaltyContract.View view2;
                Intrinsics.checkNotNullParameter(p02, "");
                view = ScanQrLoyaltyPresenter.this.PlaceComponentResult;
                view.dismissProgress();
                view2 = ScanQrLoyaltyPresenter.this.PlaceComponentResult;
                view2.getAuthRequestContext();
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
        RxQRDecode rxQRDecode = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (!rxQRDecode.BuiltInFictitiousFunctionClassFactory.isDisposed()) {
            rxQRDecode.BuiltInFictitiousFunctionClassFactory.dispose();
        }
        this.getAuthRequestContext.dispose();
    }
}

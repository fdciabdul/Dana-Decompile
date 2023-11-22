package id.dana.contract.staticqr;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.base.MultipleClickHandler;
import id.dana.cashier.model.featureTime.FeatureTimeModel;
import id.dana.contract.deeplink.H5ListenerHandler;
import id.dana.contract.staticqr.ScanQrContract;
import id.dana.di.PerActivity;
import id.dana.domain.oauth.model.QrBindingConfig;
import id.dana.domain.qrbarcode.DecodeQrBizType;
import id.dana.model.ScanModel;
import id.dana.scanner.QrExpiredActivity;
import id.dana.scanner.ScannerActivity;
import id.dana.scanner.handler.ScannerActionFactory;
import id.dana.scanner.handler.ScannerActionHandler;
import id.dana.scanner.handler.ScannerViewType;
import id.dana.scanner.handler.h5pages.BaseScannerH5PageHandler;
import id.dana.splitbill.view.SplitBillDetailsActivity;
import id.dana.utils.danah5.DanaH5Listener;
import java.util.List;
import javax.inject.Inject;

@PerActivity
/* loaded from: classes4.dex */
public class ScanQrView implements ScanQrContract.View, H5ListenerHandler {
    DanaH5Listener BuiltInFictitiousFunctionClassFactory;
    String KClassImpl$Data$declaredNonStaticMembers$2;
    ScanQrContract.View MyBillsEntityDataFactory;
    private final Activity PlaceComponentResult;
    private MultipleClickHandler getAuthRequestContext;
    private ScannerActionFactory scheduleImpl;

    @Inject
    public ScanQrView(Activity activity) {
        this.PlaceComponentResult = activity;
        if (activity instanceof BaseActivity) {
            this.getAuthRequestContext = (BaseActivity) activity;
        }
        this.scheduleImpl = new ScannerActionFactory(activity);
    }

    @Override // id.dana.contract.staticqr.ScanQrContract.View
    public final void PlaceComponentResult(ScanModel scanModel) {
        ScanQrContract.View view = this.MyBillsEntityDataFactory;
        if (view != null) {
            view.PlaceComponentResult(scanModel);
        }
        ScanQrContract.View view2 = this.MyBillsEntityDataFactory;
        if ("split_bill".equals(view2 != null ? view2.PlaceComponentResult() : null) && !MyBillsEntityDataFactory(scanModel)) {
            String string = this.PlaceComponentResult.getString(R.string.invalid_qr_code);
            MultipleClickHandler multipleClickHandler = this.getAuthRequestContext;
            if (multipleClickHandler != null) {
                multipleClickHandler.enableClick();
            }
            ScanQrContract.View view3 = this.MyBillsEntityDataFactory;
            if (view3 != null) {
                view3.BuiltInFictitiousFunctionClassFactory(string);
                return;
            }
            return;
        }
        lookAheadTest();
        this.scheduleImpl.MyBillsEntityDataFactory = false;
        ScannerActionFactory scannerActionFactory = this.scheduleImpl;
        DanaH5Listener danaH5Listener = this.BuiltInFictitiousFunctionClassFactory;
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        ScanQrContract.View view4 = this.MyBillsEntityDataFactory;
        String PlaceComponentResult = view4 != null ? view4.PlaceComponentResult() : null;
        ScanQrContract.View view5 = this.MyBillsEntityDataFactory;
        MyBillsEntityDataFactory(scannerActionFactory.MyBillsEntityDataFactory(danaH5Listener, scanModel, str, PlaceComponentResult, view5 != null ? view5.MyBillsEntityDataFactory() : null));
    }

    @Override // id.dana.contract.staticqr.ScanQrContract.View
    public final void BuiltInFictitiousFunctionClassFactory(ScanModel scanModel) {
        ScanQrContract.View view = this.MyBillsEntityDataFactory;
        if (view != null) {
            view.PlaceComponentResult(scanModel);
        }
        lookAheadTest();
        if (DecodeQrBizType.EXTERNAL_TRANSFER_QR.equals(scanModel.getBizType()) || DecodeQrBizType.EXTERNAL_CASH_IN_QR.equals(scanModel.getBizType())) {
            ScannerActionFactory scannerActionFactory = this.scheduleImpl;
            DanaH5Listener danaH5Listener = this.BuiltInFictitiousFunctionClassFactory;
            String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
            ScanQrContract.View view2 = this.MyBillsEntityDataFactory;
            String PlaceComponentResult = view2 != null ? view2.PlaceComponentResult() : null;
            ScanQrContract.View view3 = this.MyBillsEntityDataFactory;
            MyBillsEntityDataFactory(scannerActionFactory.MyBillsEntityDataFactory(danaH5Listener, scanModel, str, PlaceComponentResult, view3 != null ? view3.MyBillsEntityDataFactory() : null));
        } else if (DecodeQrBizType.PROFILE_CODE.equals(scanModel.getBizType())) {
            ScannerActionFactory scannerActionFactory2 = this.scheduleImpl;
            DanaH5Listener danaH5Listener2 = this.BuiltInFictitiousFunctionClassFactory;
            String str2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            ScanQrContract.View view4 = this.MyBillsEntityDataFactory;
            String PlaceComponentResult2 = view4 != null ? view4.PlaceComponentResult() : null;
            ScanQrContract.View view5 = this.MyBillsEntityDataFactory;
            MyBillsEntityDataFactory(scannerActionFactory2.MyBillsEntityDataFactory(danaH5Listener2, scanModel, str2, PlaceComponentResult2, view5 != null ? view5.MyBillsEntityDataFactory() : null));
        } else {
            String string = this.PlaceComponentResult.getString(R.string.invalid_qr_code);
            MultipleClickHandler multipleClickHandler = this.getAuthRequestContext;
            if (multipleClickHandler != null) {
                multipleClickHandler.enableClick();
            }
            ScanQrContract.View view6 = this.MyBillsEntityDataFactory;
            if (view6 != null) {
                view6.BuiltInFictitiousFunctionClassFactory(string);
            }
        }
    }

    @Override // id.dana.contract.staticqr.ScanQrContract.View
    public final void PlaceComponentResult(String str) {
        ScanQrContract.View view = this.MyBillsEntityDataFactory;
        if (view != null) {
            view.PlaceComponentResult(str);
        }
    }

    @Override // id.dana.contract.staticqr.ScanQrContract.View
    public final void getAuthRequestContext() {
        this.PlaceComponentResult.startActivity(SplitBillDetailsActivity.createNonEligibleUserIntent(this.PlaceComponentResult, "Scan QR"));
    }

    @Override // id.dana.contract.staticqr.ScanQrContract.View
    public final String PlaceComponentResult() {
        ScanQrContract.View view = this.MyBillsEntityDataFactory;
        if (view != null) {
            return view.PlaceComponentResult();
        }
        return null;
    }

    @Override // id.dana.contract.staticqr.ScanQrContract.View
    public final void getErrorConfigVersion() {
        ScanQrContract.View view = this.MyBillsEntityDataFactory;
        if (view != null) {
            view.getErrorConfigVersion();
            return;
        }
        this.PlaceComponentResult.startActivity(QrExpiredActivity.createIntent(this.PlaceComponentResult));
    }

    @Override // id.dana.contract.staticqr.ScanQrContract.View
    public final void getAuthRequestContext(ScanModel scanModel, boolean z) {
        ScanQrContract.View view = this.MyBillsEntityDataFactory;
        if (view != null) {
            view.PlaceComponentResult(scanModel);
        }
        ScanQrContract.View view2 = this.MyBillsEntityDataFactory;
        if ("split_bill".equals(view2 != null ? view2.PlaceComponentResult() : null) && !MyBillsEntityDataFactory(scanModel)) {
            String string = this.PlaceComponentResult.getString(R.string.invalid_qr_code);
            MultipleClickHandler multipleClickHandler = this.getAuthRequestContext;
            if (multipleClickHandler != null) {
                multipleClickHandler.enableClick();
            }
            ScanQrContract.View view3 = this.MyBillsEntityDataFactory;
            if (view3 != null) {
                view3.BuiltInFictitiousFunctionClassFactory(string);
                return;
            }
            return;
        }
        lookAheadTest();
        this.scheduleImpl.MyBillsEntityDataFactory = true;
        this.scheduleImpl.getAuthRequestContext = z;
        ScannerActionFactory scannerActionFactory = this.scheduleImpl;
        DanaH5Listener danaH5Listener = this.BuiltInFictitiousFunctionClassFactory;
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        ScanQrContract.View view4 = this.MyBillsEntityDataFactory;
        String PlaceComponentResult = view4 != null ? view4.PlaceComponentResult() : null;
        ScanQrContract.View view5 = this.MyBillsEntityDataFactory;
        MyBillsEntityDataFactory(scannerActionFactory.MyBillsEntityDataFactory(danaH5Listener, scanModel, str, PlaceComponentResult, view5 != null ? view5.MyBillsEntityDataFactory() : null));
    }

    @Override // id.dana.contract.staticqr.ScanQrContract.View
    public final void BuiltInFictitiousFunctionClassFactory(boolean z, String str) {
        if (this.PlaceComponentResult != null) {
            Intent intent = new Intent();
            intent.putExtra("success", z);
            intent.putExtra("code", str);
            this.PlaceComponentResult.setResult(-1, intent);
            this.PlaceComponentResult.finish();
        }
    }

    @Override // id.dana.contract.staticqr.ScanQrContract.View
    public final void PlaceComponentResult(boolean z) {
        ScanQrContract.View view = this.MyBillsEntityDataFactory;
        if (view != null) {
            view.PlaceComponentResult(z);
        }
    }

    @Override // id.dana.contract.staticqr.ScanQrContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(List<String> list) {
        ScanQrContract.View view = this.MyBillsEntityDataFactory;
        if (view != null) {
            view.KClassImpl$Data$declaredNonStaticMembers$2(list);
        }
    }

    @Override // id.dana.contract.staticqr.ScanQrContract.View
    public final void getAuthRequestContext(QrBindingConfig qrBindingConfig) {
        ScanQrContract.View view = this.MyBillsEntityDataFactory;
        if (view != null) {
            view.getAuthRequestContext(qrBindingConfig);
        }
    }

    @Override // id.dana.contract.staticqr.ScanQrContract.View
    public final void MyBillsEntityDataFactory(boolean z) {
        ScanQrContract.View view = this.MyBillsEntityDataFactory;
        if (view != null) {
            view.MyBillsEntityDataFactory(z);
        }
    }

    @Override // id.dana.contract.staticqr.ScanQrContract.View
    public final void moveToNextValue() {
        ScanQrContract.View view = this.MyBillsEntityDataFactory;
        if (view != null) {
            view.moveToNextValue();
        }
    }

    @Override // id.dana.contract.staticqr.ScanQrContract.View
    public final void PlaceComponentResult(String str, String str2, String str3, Throwable th) {
        ScanQrContract.View view = this.MyBillsEntityDataFactory;
        if (view != null) {
            view.PlaceComponentResult(str, str2, str3, th);
        }
    }

    @Override // id.dana.contract.staticqr.ScanQrContract.View
    public final FeatureTimeModel MyBillsEntityDataFactory() {
        ScanQrContract.View view = this.MyBillsEntityDataFactory;
        if (view == null) {
            return null;
        }
        return view.MyBillsEntityDataFactory();
    }

    private void lookAheadTest() {
        if (TextUtils.isEmpty(this.KClassImpl$Data$declaredNonStaticMembers$2)) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ScannerViewType.FRAGMENT;
            if (this.PlaceComponentResult instanceof ScannerActivity) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = ScannerViewType.ACTIVITY;
            }
        }
    }

    private void MyBillsEntityDataFactory(ScannerActionHandler scannerActionHandler) {
        scannerActionHandler.PlaceComponentResult();
        if (scannerActionHandler instanceof BaseScannerH5PageHandler) {
            String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
            ScanQrContract.View view = this.MyBillsEntityDataFactory;
            if (view != null) {
                view.PlaceComponentResult(str);
            }
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
        ScanQrContract.View view = this.MyBillsEntityDataFactory;
        if (view != null) {
            view.showProgress();
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
        ScanQrContract.View view = this.MyBillsEntityDataFactory;
        if (view != null) {
            view.dismissProgress();
        }
    }

    private static boolean MyBillsEntityDataFactory(ScanModel scanModel) {
        return scanModel != null && DecodeQrBizType.PROFILE_CODE.equals(scanModel.getBizType());
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
        MultipleClickHandler multipleClickHandler = this.getAuthRequestContext;
        if (multipleClickHandler != null) {
            multipleClickHandler.enableClick();
        }
        ScanQrContract.View view = this.MyBillsEntityDataFactory;
        if (view != null) {
            view.onError(str);
        }
    }

    @Override // id.dana.contract.staticqr.ScanQrContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        MultipleClickHandler multipleClickHandler = this.getAuthRequestContext;
        if (multipleClickHandler != null) {
            multipleClickHandler.enableClick();
        }
        ScanQrContract.View view = this.MyBillsEntityDataFactory;
        if (view != null) {
            view.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    @Override // id.dana.contract.staticqr.ScanQrContract.View
    public final void BuiltInFictitiousFunctionClassFactory(String str) {
        MultipleClickHandler multipleClickHandler = this.getAuthRequestContext;
        if (multipleClickHandler != null) {
            multipleClickHandler.enableClick();
        }
        ScanQrContract.View view = this.MyBillsEntityDataFactory;
        if (view != null) {
            view.BuiltInFictitiousFunctionClassFactory(str);
        }
    }

    @Override // id.dana.contract.staticqr.ScanQrContract.View
    public final void BuiltInFictitiousFunctionClassFactory() {
        MultipleClickHandler multipleClickHandler = this.getAuthRequestContext;
        if (multipleClickHandler != null) {
            multipleClickHandler.enableClick();
        }
        ScanQrContract.View view = this.MyBillsEntityDataFactory;
        if (view != null) {
            view.BuiltInFictitiousFunctionClassFactory();
        }
    }
}

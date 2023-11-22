package id.dana.contract.shortener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import dagger.Lazy;
import id.dana.R;
import id.dana.base.MultipleClickHandler;
import id.dana.contract.deeplink.H5ListenerHandler;
import id.dana.contract.deeplink.util.SourceParamUtil;
import id.dana.contract.shortener.RestoreUrlContract;
import id.dana.danah5.DanaH5;
import id.dana.di.PerActivity;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.sendmoney_v2.x2l.InvalidLinkActivity;
import id.dana.utils.danah5.DanaH5Listener;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import javax.inject.Inject;

@PerActivity
/* loaded from: classes4.dex */
public class RestoreUrlView implements RestoreUrlContract.View, H5ListenerHandler {
    MultipleClickHandler BuiltInFictitiousFunctionClassFactory;
    private Lazy<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private DanaLoadingDialog MyBillsEntityDataFactory;
    Activity PlaceComponentResult;
    DanaH5Listener getAuthRequestContext;

    @Inject
    public RestoreUrlView(Lazy<Context> lazy) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy;
    }

    @Override // id.dana.contract.shortener.RestoreUrlContract.View
    public final void PlaceComponentResult(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.startsWith(SemanticAttributes.FaasTriggerValues.HTTP)) {
                StringBuilder sb = new StringBuilder();
                sb.append("https://m.dana.id");
                sb.append(str);
                str = sb.toString();
            }
            if (SourceParamUtil.MyBillsEntityDataFactory(str)) {
                str = SourceParamUtil.getAuthRequestContext(str, str2);
            }
            DanaH5.startContainerFullUrl(str, this.getAuthRequestContext);
        }
        MultipleClickHandler multipleClickHandler = this.BuiltInFictitiousFunctionClassFactory;
        if (multipleClickHandler != null) {
            multipleClickHandler.enableClick();
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
        if (this.PlaceComponentResult != null) {
            DanaLoadingDialog danaLoadingDialog = new DanaLoadingDialog(this.PlaceComponentResult);
            this.MyBillsEntityDataFactory = danaLoadingDialog;
            if (danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                return;
            }
            danaLoadingDialog.MyBillsEntityDataFactory.show();
            danaLoadingDialog.getAuthRequestContext.startRefresh();
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
        DanaLoadingDialog danaLoadingDialog = this.MyBillsEntityDataFactory;
        if (danaLoadingDialog != null) {
            danaLoadingDialog.PlaceComponentResult();
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
        Activity activity = this.PlaceComponentResult;
        if (activity != null) {
            activity.startActivity(new Intent(this.PlaceComponentResult, InvalidLinkActivity.class));
        } else {
            Toast.makeText(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get().getString(R.string.link_not_found_toast), 0).show();
        }
        MultipleClickHandler multipleClickHandler = this.BuiltInFictitiousFunctionClassFactory;
        if (multipleClickHandler != null) {
            multipleClickHandler.enableClick();
        }
    }
}

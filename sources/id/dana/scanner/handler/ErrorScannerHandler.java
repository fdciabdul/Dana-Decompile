package id.dana.scanner.handler;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.utils.showcase.Utils;

/* loaded from: classes5.dex */
public class ErrorScannerHandler implements ScannerActionHandler {
    final Context MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ErrorScannerHandler(Context context) {
        this.MyBillsEntityDataFactory = context;
    }

    @Override // id.dana.scanner.handler.ScannerActionHandler
    public final void PlaceComponentResult() {
        if (this.MyBillsEntityDataFactory instanceof BaseActivity) {
            CustomDialog.Builder builder = new CustomDialog.Builder(this.MyBillsEntityDataFactory);
            builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_warning;
            builder.SubSequence = this.MyBillsEntityDataFactory.getString(R.string.app_update_deeplink_fail_title);
            builder.GetContactSyncConfig = this.MyBillsEntityDataFactory.getString(R.string.app_update_deeplink_fail_description);
            String string = this.MyBillsEntityDataFactory.getString(R.string.later);
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.scanner.handler.ErrorScannerHandler$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ErrorScannerHandler.BuiltInFictitiousFunctionClassFactory();
                }
            };
            builder.NetworkUserEntityData$$ExternalSyntheticLambda7 = string;
            builder.NetworkUserEntityData$$ExternalSyntheticLambda8 = onClickListener;
            String string2 = this.MyBillsEntityDataFactory.getString(R.string.update);
            View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: id.dana.scanner.handler.ErrorScannerHandler$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Utils.getAuthRequestContext((Activity) ((BaseActivity) ErrorScannerHandler.this.MyBillsEntityDataFactory));
                }
            };
            builder.NetworkUserEntityData$$ExternalSyntheticLambda6 = string2;
            builder.getSupportButtonTintMode = onClickListener2;
            builder.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory().show();
        }
    }
}

package id.dana.oauth;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseMaterialDialog;
import id.dana.richview.LogoProgressView;

/* loaded from: classes2.dex */
public class MatchPhoneNumberDialog extends BaseMaterialDialog<Builder> {
    @BindView(R.id.btn_cancel)
    Button btnCancel;
    @BindView(R.id.btn_login)
    public Button btnLogin;
    @BindView(R.id.lpv_loading)
    public LogoProgressView lpvLoading;

    public /* synthetic */ MatchPhoneNumberDialog(Context context, DialogInterface.OnDismissListener onDismissListener, Builder builder, byte b) {
        this(context, onDismissListener, builder);
    }

    @Override // id.dana.base.BaseMaterialDialog
    public final /* synthetic */ void getAuthRequestContext(View view, Builder builder) {
        Builder builder2 = builder;
        this.btnCancel.setOnClickListener(builder2.MyBillsEntityDataFactory);
        this.btnLogin.setOnClickListener(builder2.getAuthRequestContext);
    }

    private MatchPhoneNumberDialog(Context context, DialogInterface.OnDismissListener onDismissListener, Builder builder) {
        super(context, onDismissListener, Integer.valueOf((int) R.layout.dialog_dana_id_different), builder);
    }

    /* loaded from: classes2.dex */
    public static class Builder extends BaseMaterialDialog.Cancellation {
        public final Context KClassImpl$Data$declaredNonStaticMembers$2;
        public View.OnClickListener MyBillsEntityDataFactory;
        public final DialogInterface.OnDismissListener PlaceComponentResult;
        public View.OnClickListener getAuthRequestContext;

        public Builder(Context context, DialogInterface.OnDismissListener onDismissListener) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
            getAuthRequestContext(true);
            BuiltInFictitiousFunctionClassFactory(true);
            this.PlaceComponentResult = onDismissListener;
        }
    }
}

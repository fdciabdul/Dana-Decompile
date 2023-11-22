package id.dana.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseMaterialDialog;
import id.dana.base.viewbinding.ViewBindingMaterialDialog;
import id.dana.core.ui.constant.DialogType;
import id.dana.databinding.ViewLoginPopupBinding;

/* loaded from: classes4.dex */
public class LoginInfoDialog extends ViewBindingMaterialDialog<ViewLoginPopupBinding, Builder> {
    private DialogType PlaceComponentResult;

    public /* synthetic */ LoginInfoDialog(Context context, DialogInterface.OnDismissListener onDismissListener, int i, Builder builder, byte b) {
        this(context, onDismissListener, i, builder);
    }

    @Override // id.dana.base.BaseMaterialDialog
    public final /* synthetic */ void getAuthRequestContext(View view, Object obj) {
        View findViewById;
        Builder builder = (Builder) obj;
        this.PlaceComponentResult = builder.NetworkUserEntityData$$ExternalSyntheticLambda2;
        int i = builder.getErrorConfigVersion;
        if (i > 0) {
            ((ViewLoginPopupBinding) this.MyBillsEntityDataFactory).PlaceComponentResult.PlaceComponentResult.setBackground(ContextCompat.PlaceComponentResult(this.MyBillsEntityDataFactory, i));
        }
        if (this.PlaceComponentResult.getIcon() == 0) {
            ((ViewLoginPopupBinding) this.MyBillsEntityDataFactory).PlaceComponentResult.MyBillsEntityDataFactory.setVisibility(8);
        } else {
            AppCompatImageView appCompatImageView = ((ViewLoginPopupBinding) this.MyBillsEntityDataFactory).PlaceComponentResult.MyBillsEntityDataFactory;
            int icon = this.PlaceComponentResult.getIcon();
            if (appCompatImageView instanceof ImageView) {
                InstrumentInjector.Resources_setImageResource(appCompatImageView, icon);
            } else {
                appCompatImageView.setImageResource(icon);
            }
        }
        PlaceComponentResult(((ViewLoginPopupBinding) this.MyBillsEntityDataFactory).PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, builder.PlaceComponentResult);
        PlaceComponentResult(((ViewLoginPopupBinding) this.MyBillsEntityDataFactory).PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, builder.initRecordTimeStamp);
        if (builder.DatabaseTableConfigUtil != 0 && (findViewById = view.findViewById(builder.DatabaseTableConfigUtil)) != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: id.dana.dialog.LoginInfoDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LoginInfoDialog.this.getAuthRequestContext();
                }
            });
        }
        String str = builder.scheduleImpl;
        final View.OnClickListener onClickListener = builder.lookAheadTest;
        MyBillsEntityDataFactory(str, ((ViewLoginPopupBinding) this.MyBillsEntityDataFactory).MyBillsEntityDataFactory);
        ((ViewLoginPopupBinding) this.MyBillsEntityDataFactory).MyBillsEntityDataFactory.setText(str);
        ((ViewLoginPopupBinding) this.MyBillsEntityDataFactory).MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.dialog.LoginInfoDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginInfoDialog loginInfoDialog = LoginInfoDialog.this;
                View.OnClickListener onClickListener2 = onClickListener;
                loginInfoDialog.getAuthRequestContext();
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view2);
                }
            }
        });
        String str2 = builder.NetworkUserEntityData$$ExternalSyntheticLambda0;
        final View.OnClickListener onClickListener2 = builder.moveToNextValue;
        MyBillsEntityDataFactory(str2, ((ViewLoginPopupBinding) this.MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2);
        ((ViewLoginPopupBinding) this.MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2.setText(str2);
        ((ViewLoginPopupBinding) this.MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.dialog.LoginInfoDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LoginInfoDialog loginInfoDialog = LoginInfoDialog.this;
                View.OnClickListener onClickListener3 = onClickListener2;
                loginInfoDialog.getAuthRequestContext();
                if (onClickListener3 != null) {
                    onClickListener3.onClick(view2);
                }
            }
        });
    }

    private LoginInfoDialog(Context context, DialogInterface.OnDismissListener onDismissListener, int i, Builder builder) {
        super(context, onDismissListener, i, builder);
    }

    @Override // id.dana.base.BaseMaterialDialog
    public final void MyBillsEntityDataFactory() {
        if (this.PlaceComponentResult == DialogType.WAITING) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.MyBillsEntityDataFactory, R.anim.res_0x7f010050_kclassimpl_data_declarednonstaticmembers_2);
            loadAnimation.setInterpolator(new LinearInterpolator());
            ((ViewLoginPopupBinding) this.MyBillsEntityDataFactory).PlaceComponentResult.getAuthRequestContext.startAnimation(loadAnimation);
        }
        ((ViewLoginPopupBinding) this.MyBillsEntityDataFactory).PlaceComponentResult.getAuthRequestContext.setVisibility(this.PlaceComponentResult == DialogType.WAITING ? 0 : 4);
        super.MyBillsEntityDataFactory();
        if (((Builder) this.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory) {
            new Handler().postDelayed(new Runnable() { // from class: id.dana.dialog.LoginInfoDialog$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    LoginInfoDialog.this.getAuthRequestContext();
                }
            }, ((Builder) this.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory);
        }
    }

    private static void PlaceComponentResult(TextView textView, String str) {
        if (textView != null) {
            textView.setText(str);
            textView.setVisibility(TextUtils.isEmpty(textView.getText()) ? 8 : 0);
        }
    }

    private void MyBillsEntityDataFactory(String str, Button button) {
        ((ViewLoginPopupBinding) this.MyBillsEntityDataFactory).getAuthRequestContext.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        button.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
    }

    /* loaded from: classes4.dex */
    public static class Builder extends BaseMaterialDialog.Cancellation {
        private int DatabaseTableConfigUtil;
        public Context KClassImpl$Data$declaredNonStaticMembers$2;
        public String NetworkUserEntityData$$ExternalSyntheticLambda0;
        public DialogType NetworkUserEntityData$$ExternalSyntheticLambda2;
        public String PlaceComponentResult;
        public DialogInterface.OnDismissListener getAuthRequestContext;
        public int getErrorConfigVersion;
        public String initRecordTimeStamp;
        public View.OnClickListener lookAheadTest;
        public View.OnClickListener moveToNextValue;
        public String scheduleImpl;
        public int NetworkUserEntityData$$ExternalSyntheticLambda1 = R.layout.view_login_popup;
        public boolean MyBillsEntityDataFactory = true;
        public int BuiltInFictitiousFunctionClassFactory = 3000;

        public Builder(Context context) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        }

        public final Builder BuiltInFictitiousFunctionClassFactory() {
            getAuthRequestContext(false);
            return this;
        }

        public final Builder MyBillsEntityDataFactory() {
            BuiltInFictitiousFunctionClassFactory(false);
            return this;
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingMaterialDialog
    public final /* synthetic */ ViewLoginPopupBinding PlaceComponentResult(View view) {
        return ViewLoginPopupBinding.BuiltInFictitiousFunctionClassFactory(view);
    }
}

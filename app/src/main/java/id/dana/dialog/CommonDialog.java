package id.dana.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseMaterialDialog;
import id.dana.base.viewbinding.ViewBindingMaterialDialog;
import id.dana.core.ui.constant.DialogType;
import id.dana.danah5.easteregg.QuickTap;
import id.dana.databinding.ViewSimplePopupBinding;
import id.dana.dialog.CommonDialog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes2.dex */
public class CommonDialog extends ViewBindingMaterialDialog<ViewSimplePopupBinding, Builder> {
    private DialogType PlaceComponentResult;

    @Override // id.dana.base.BaseMaterialDialog
    public final /* synthetic */ void getAuthRequestContext(final View view, Object obj) {
        View findViewById;
        final Builder builder = (Builder) obj;
        DialogType dialogType = builder.DatabaseTableConfigUtil;
        this.PlaceComponentResult = dialogType;
        if (dialogType.getIcon() == 0) {
            BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory.setVisibility(8);
        } else {
            AppCompatImageView appCompatImageView = BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory;
            int icon = this.PlaceComponentResult.getIcon();
            if (appCompatImageView instanceof ImageView) {
                InstrumentInjector.Resources_setImageResource(appCompatImageView, icon);
            } else {
                appCompatImageView.setImageResource(icon);
            }
        }
        BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2.setText(builder.KClassImpl$Data$declaredNonStaticMembers$2);
        BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory.setText(builder.GetContactSyncConfig);
        if (!TextUtils.isEmpty(builder.lookAheadTest)) {
            KClassImpl$Data$declaredNonStaticMembers$2().positiveButton(null, builder.lookAheadTest, new Function1() { // from class: id.dana.dialog.CommonDialog$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    MaterialDialog materialDialog = (MaterialDialog) obj2;
                    return CommonDialog.getAuthRequestContext(CommonDialog.Builder.this, view);
                }
            });
        }
        if (!TextUtils.isEmpty(builder.moveToNextValue)) {
            KClassImpl$Data$declaredNonStaticMembers$2().negativeButton(null, builder.moveToNextValue, new Function1() { // from class: id.dana.dialog.CommonDialog$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    MaterialDialog materialDialog = (MaterialDialog) obj2;
                    return CommonDialog.BuiltInFictitiousFunctionClassFactory(CommonDialog.Builder.this, view);
                }
            });
        }
        final QuickTap quickTap = builder.initRecordTimeStamp;
        if (quickTap != null) {
            BuiltInFictitiousFunctionClassFactory().PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.dialog.CommonDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QuickTap.this.process();
                }
            });
        }
        if (builder.NetworkUserEntityData$$ExternalSyntheticLambda2 != 0 && (findViewById = view.findViewById(builder.NetworkUserEntityData$$ExternalSyntheticLambda2)) != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: id.dana.dialog.CommonDialog$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CommonDialog.this.getAuthRequestContext();
                }
            });
        }
        BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory.setVisibility(TextUtils.isEmpty(BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory.getText()) ? 8 : 0);
    }

    public CommonDialog(Context context, DialogInterface.OnDismissListener onDismissListener, int i, Builder builder) {
        super(context, onDismissListener, i, builder);
    }

    public static /* synthetic */ Unit getAuthRequestContext(Builder builder, View view) {
        if (builder.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            builder.NetworkUserEntityData$$ExternalSyntheticLambda0.onClick(view);
            return null;
        }
        return null;
    }

    public static /* synthetic */ Unit BuiltInFictitiousFunctionClassFactory(Builder builder, View view) {
        if (builder.getErrorConfigVersion != null) {
            builder.getErrorConfigVersion.onClick(view);
            return null;
        }
        return null;
    }

    @Override // id.dana.base.BaseMaterialDialog
    public final void MyBillsEntityDataFactory() {
        if (this.PlaceComponentResult == DialogType.WAITING) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.MyBillsEntityDataFactory, R.anim.res_0x7f010050_kclassimpl_data_declarednonstaticmembers_2);
            loadAnimation.setInterpolator(new LinearInterpolator());
            BuiltInFictitiousFunctionClassFactory().getAuthRequestContext.startAnimation(loadAnimation);
        }
        BuiltInFictitiousFunctionClassFactory().getAuthRequestContext.setVisibility(this.PlaceComponentResult == DialogType.WAITING ? 0 : 4);
        super.MyBillsEntityDataFactory();
        if (!((Builder) this.KClassImpl$Data$declaredNonStaticMembers$2).PlaceComponentResult || ((Builder) this.KClassImpl$Data$declaredNonStaticMembers$2).getAuthRequestContext <= 0) {
            return;
        }
        new Handler().postDelayed(new CommonDialog$$ExternalSyntheticLambda0(this), ((Builder) this.KClassImpl$Data$declaredNonStaticMembers$2).getAuthRequestContext);
    }

    /* loaded from: classes2.dex */
    public static class Builder extends BaseMaterialDialog.Cancellation {
        public Context BuiltInFictitiousFunctionClassFactory;
        public DialogType DatabaseTableConfigUtil;
        public String GetContactSyncConfig;
        public String KClassImpl$Data$declaredNonStaticMembers$2;
        public DialogInterface.OnDismissListener MyBillsEntityDataFactory;
        public View.OnClickListener NetworkUserEntityData$$ExternalSyntheticLambda0;
        private int NetworkUserEntityData$$ExternalSyntheticLambda2;
        public View.OnClickListener getErrorConfigVersion;
        private QuickTap initRecordTimeStamp;
        public String lookAheadTest;
        public String moveToNextValue;
        public int scheduleImpl = R.layout.view_simple_popup;
        public boolean PlaceComponentResult = true;
        public int getAuthRequestContext = 3000;

        public Builder(Context context) {
            this.BuiltInFictitiousFunctionClassFactory = context;
        }

        public final Builder KClassImpl$Data$declaredNonStaticMembers$2() {
            getAuthRequestContext(false);
            return this;
        }

        public final Builder PlaceComponentResult(boolean z) {
            BuiltInFictitiousFunctionClassFactory(z);
            return this;
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingMaterialDialog
    public final /* synthetic */ ViewSimplePopupBinding PlaceComponentResult(View view) {
        return ViewSimplePopupBinding.BuiltInFictitiousFunctionClassFactory(view);
    }
}

package id.dana.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseMaterialDialog;
import id.dana.base.viewbinding.ViewBindingMaterialDialog;
import id.dana.core.ui.glide.ShimmerImageAttacherFactory;
import id.dana.databinding.DialogWithImageBinding;
import id.dana.utils.ImageOss;

/* loaded from: classes2.dex */
public class DialogWithImage extends ViewBindingMaterialDialog<DialogWithImageBinding, Builder> {
    public /* synthetic */ DialogWithImage(Context context, DialogInterface.OnDismissListener onDismissListener, Builder builder, byte b) {
        this(context, onDismissListener, builder);
    }

    @Override // id.dana.base.BaseMaterialDialog
    public final /* synthetic */ void getAuthRequestContext(View view, Object obj) {
        Builder builder = (Builder) obj;
        if (builder.MyBillsEntityDataFactory <= 0) {
            if (!TextUtils.isEmpty(builder.KClassImpl$Data$declaredNonStaticMembers$2)) {
                ImageOss.MyBillsEntityDataFactory(builder.KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory().PlaceComponentResult, new ImageOss.EventListener() { // from class: id.dana.dialog.DialogWithImage$$ExternalSyntheticLambda1
                    @Override // id.dana.utils.ImageOss.EventListener
                    public final void PlaceComponentResult(String str, ImageView imageView) {
                        new ShimmerImageAttacherFactory().KClassImpl$Data$declaredNonStaticMembers$2(DialogWithImage.this.MyBillsEntityDataFactory, imageView, str, 0);
                    }
                });
            } else {
                BuiltInFictitiousFunctionClassFactory().PlaceComponentResult.setVisibility(8);
            }
        } else {
            AppCompatImageView appCompatImageView = BuiltInFictitiousFunctionClassFactory().PlaceComponentResult;
            int i = builder.MyBillsEntityDataFactory;
            if (appCompatImageView instanceof ImageView) {
                InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
            } else {
                appCompatImageView.setImageResource(i);
            }
        }
        BuiltInFictitiousFunctionClassFactory().getErrorConfigVersion.setText(builder.moveToNextValue);
        BuiltInFictitiousFunctionClassFactory().NetworkUserEntityData$$ExternalSyntheticLambda0.setText(builder.PlaceComponentResult);
        String str = builder.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Button button = BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory;
        if (!TextUtils.isEmpty(str)) {
            button.setVisibility(0);
            button.setText(str);
        } else {
            button.setVisibility(8);
        }
        final DialogInterface.OnClickListener onClickListener = builder.BuiltInFictitiousFunctionClassFactory;
        final int i2 = -1;
        BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.dialog.DialogWithImage$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DialogWithImage dialogWithImage = DialogWithImage.this;
                DialogInterface.OnClickListener onClickListener2 = onClickListener;
                int i3 = i2;
                dialogWithImage.getAuthRequestContext();
                if (onClickListener2 != null) {
                    onClickListener2.onClick(dialogWithImage.KClassImpl$Data$declaredNonStaticMembers$2(), i3);
                }
            }
        });
        String str2 = builder.getAuthRequestContext;
        Button button2 = BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory;
        if (!TextUtils.isEmpty(str2)) {
            button2.setVisibility(0);
            button2.setText(str2);
        } else {
            button2.setVisibility(8);
        }
        final DialogInterface.OnClickListener onClickListener2 = builder.BuiltInFictitiousFunctionClassFactory;
        final int i3 = -2;
        BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.dialog.DialogWithImage$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DialogWithImage dialogWithImage = DialogWithImage.this;
                DialogInterface.OnClickListener onClickListener22 = onClickListener2;
                int i32 = i3;
                dialogWithImage.getAuthRequestContext();
                if (onClickListener22 != null) {
                    onClickListener22.onClick(dialogWithImage.KClassImpl$Data$declaredNonStaticMembers$2(), i32);
                }
            }
        });
    }

    private DialogWithImage(Context context, DialogInterface.OnDismissListener onDismissListener, Builder builder) {
        super(context, onDismissListener, R.layout.dialog_with_image, builder);
    }

    public static DialogWithImage BuiltInFictitiousFunctionClassFactory(Context context, DialogInterface.OnClickListener onClickListener) {
        Builder KClassImpl$Data$declaredNonStaticMembers$2 = new Builder().MyBillsEntityDataFactory(false).KClassImpl$Data$declaredNonStaticMembers$2(false);
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = R.drawable.BuiltInFictitiousFunctionClassFactory_res_0x7f0807f3;
        KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = context.getString(R.string.res_0x7f130491_challenge_pin_dialog_title);
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = context.getString(R.string.res_0x7f130490_challenge_pin_dialog_message);
        KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0 = context.getString(R.string.res_0x7f13048f_challenge_pin_dialog_button_positive);
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = context.getString(R.string.res_0x7f13048e_challenge_pin_dialog_button_negative);
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = onClickListener;
        return new DialogWithImage(context, KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest, KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
    }

    /* loaded from: classes2.dex */
    public static class Builder extends BaseMaterialDialog.Cancellation {
        public DialogInterface.OnClickListener BuiltInFictitiousFunctionClassFactory;
        public String KClassImpl$Data$declaredNonStaticMembers$2;
        public int MyBillsEntityDataFactory;
        public DialogInterface.OnDismissListener lookAheadTest;
        public String PlaceComponentResult = "";
        public String getAuthRequestContext = "";
        public String NetworkUserEntityData$$ExternalSyntheticLambda0 = "";
        public String moveToNextValue = "";

        public final Builder KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
            BuiltInFictitiousFunctionClassFactory(z);
            return this;
        }

        public final Builder MyBillsEntityDataFactory(boolean z) {
            getAuthRequestContext(z);
            return this;
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingMaterialDialog
    public final /* bridge */ /* synthetic */ DialogWithImageBinding PlaceComponentResult(View view) {
        return DialogWithImageBinding.PlaceComponentResult(view);
    }
}

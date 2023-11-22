package id.dana.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import butterknife.BindView;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseMaterialDialog;
import id.dana.dialog.DialogPermission;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public class DialogPermission extends BaseMaterialDialog<Builder> {
    @BindView(R.id.btn_check_permission)
    Button btnCheckPermission;
    @BindView(R.id.btn_check_permission_horizontal)
    Button btnCheckPermissionHorizontal;
    @BindView(R.id.btn_horizontal_group)
    Group btnHorizontalGroup;
    @BindView(R.id.btn_not_now)
    Button btnNotNow;
    @BindView(R.id.btn_not_now_horizontal)
    Button btnNotNowHorizontal;
    @BindView(R.id.btn_vertical_group)
    Group btnVerticalGroup;
    @BindView(R.id.iv_permission)
    ImageView ivPermission;
    @BindView(R.id.tv_additional_text)
    TextView tvAdditionalText;
    @BindView(R.id.tv_permission_desc)
    TextView tvPermissionDesc;
    @BindView(R.id.tv_permission_title)
    TextView tvPermissionTitle;

    /* loaded from: classes2.dex */
    public interface DialogListener {
        void onDialogDismissed();

        void onNegativeButtonClicked();

        void onPositiveButtonClicked();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PermissionDialogType {
        public static final int HORIZONTAL = 1;
        public static final int VERTICAL = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PermissionType {
        public static final String CONTACT = "contact";
        public static final String LOCATION = "location";
    }

    public /* synthetic */ DialogPermission(Context context, DialogInterface.OnDismissListener onDismissListener, Builder builder, byte b) {
        this(context, onDismissListener, builder);
    }

    @Override // id.dana.base.BaseMaterialDialog
    public final /* synthetic */ void getAuthRequestContext(View view, Builder builder) {
        Builder builder2 = builder;
        String str = builder2.MyBillsEntityDataFactory;
        View.OnClickListener onClickListener = builder2.getAuthRequestContext;
        if (str != null) {
            this.tvAdditionalText.setText(str);
        }
        if (onClickListener != null) {
            this.tvAdditionalText.setOnClickListener(onClickListener);
        }
        this.tvAdditionalText.setVisibility(0);
        String str2 = builder2.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (str2 != null) {
            this.tvPermissionTitle.setText(str2);
            this.tvPermissionTitle.setVisibility(0);
        }
        String str3 = builder2.lookAheadTest;
        final View.OnClickListener onClickListener2 = builder2.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (str3 != null) {
            if (onClickListener2 != null) {
                TextView textView = this.tvPermissionDesc;
                SpannableString spannableString = new SpannableString(str3);
                ClickableSpan clickableSpan = new ClickableSpan() { // from class: id.dana.dialog.DialogPermission.1
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view2) {
                        view2.invalidate();
                        onClickListener2.onClick(view2);
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setUnderlineText(false);
                        Context context = DialogPermission.this.MyBillsEntityDataFactory;
                        textPaint.setColor(-15692055);
                    }
                };
                String string = this.MyBillsEntityDataFactory.getResources().getString(R.string.tnc);
                int indexOf = str3.indexOf(string);
                spannableString.setSpan(clickableSpan, indexOf, string.length() + indexOf, 33);
                textView.setText(spannableString);
                this.tvPermissionDesc.setHighlightColor(0);
                this.tvPermissionDesc.setMovementMethod(LinkMovementMethod.getInstance());
            } else {
                this.tvPermissionDesc.setText(str3);
            }
            this.tvPermissionDesc.setVisibility(0);
        }
        int i = builder2.getErrorConfigVersion;
        if (i != 0) {
            this.tvPermissionDesc.setTextColor(i);
        }
        Typeface typeface = builder2.GetContactSyncConfig;
        if (typeface != null) {
            this.tvPermissionDesc.setTypeface(typeface);
        }
        int i2 = builder2.DatabaseTableConfigUtil;
        if (i2 != 0) {
            this.tvPermissionTitle.setTextColor(i2);
        }
        Typeface typeface2 = builder2.PrepareContext;
        if (typeface2 != null) {
            this.tvPermissionTitle.setTypeface(typeface2);
        }
        this.btnHorizontalGroup.setVisibility(1 == builder2.initRecordTimeStamp ? 0 : 8);
        this.btnVerticalGroup.setVisibility(builder2.initRecordTimeStamp != 0 ? 8 : 0);
        String str4 = builder2.KClassImpl$Data$declaredNonStaticMembers$2;
        final DialogListener dialogListener = builder2.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (str4 != null) {
            this.btnCheckPermission.setText(str4);
            this.btnCheckPermissionHorizontal.setText(str4);
        }
        if (dialogListener != null) {
            this.btnCheckPermission.setOnClickListener(new View.OnClickListener() { // from class: id.dana.dialog.DialogPermission$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DialogPermission.DialogListener.this.onPositiveButtonClicked();
                }
            });
            this.btnCheckPermissionHorizontal.setOnClickListener(new View.OnClickListener() { // from class: id.dana.dialog.DialogPermission$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DialogPermission.DialogListener.this.onPositiveButtonClicked();
                }
            });
        }
        final DialogListener dialogListener2 = builder2.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (dialogListener2 != null) {
            this.btnNotNow.setOnClickListener(new View.OnClickListener() { // from class: id.dana.dialog.DialogPermission$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DialogPermission.DialogListener.this.onNegativeButtonClicked();
                }
            });
            this.btnNotNowHorizontal.setOnClickListener(new View.OnClickListener() { // from class: id.dana.dialog.DialogPermission$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DialogPermission.DialogListener.this.onNegativeButtonClicked();
                }
            });
        }
        String str5 = builder2.PlaceComponentResult;
        if (!TextUtils.isEmpty(str5)) {
            this.btnNotNow.setText(str5);
            this.btnNotNowHorizontal.setText(str5);
        }
        Boolean valueOf = Boolean.valueOf(builder2.newProxyInstance);
        String str6 = builder2.MyBillsEntityDataFactory;
        if (valueOf.booleanValue()) {
            Button button = this.btnCheckPermission;
            Integer valueOf2 = Integer.valueOf((int) R.id.btn_not_now);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) button.getLayoutParams();
            layoutParams.Z = valueOf2.intValue();
            layoutParams.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
            button.requestLayout();
            Button button2 = this.btnNotNow;
            Integer valueOf3 = Integer.valueOf((int) R.id.tv_additional_text);
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) button2.getLayoutParams();
            layoutParams2.Z = valueOf3.intValue();
            layoutParams2.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
            button2.requestLayout();
            if (TextUtils.isEmpty(str6)) {
                this.tvAdditionalText.setVisibility(8);
            }
        }
        InstrumentInjector.Resources_setImageResource(this.ivPermission, builder2.scheduleImpl);
    }

    private DialogPermission(Context context, DialogInterface.OnDismissListener onDismissListener, Builder builder) {
        super(context, onDismissListener, Integer.valueOf((int) R.layout.dialog_permission), builder);
    }

    /* loaded from: classes2.dex */
    public static class Builder extends BaseMaterialDialog.Cancellation {
        public Context BuiltInFictitiousFunctionClassFactory;
        int DatabaseTableConfigUtil;
        Typeface GetContactSyncConfig;
        public String KClassImpl$Data$declaredNonStaticMembers$2;
        public String MyBillsEntityDataFactory;
        public DialogListener NetworkUserEntityData$$ExternalSyntheticLambda0;
        public String NetworkUserEntityData$$ExternalSyntheticLambda1;
        private View.OnClickListener NetworkUserEntityData$$ExternalSyntheticLambda2;
        public String PlaceComponentResult;
        private Typeface PrepareContext;
        public View.OnClickListener getAuthRequestContext;
        int getErrorConfigVersion;
        public int initRecordTimeStamp;
        public String lookAheadTest;
        public DialogInterface.OnDismissListener moveToNextValue;
        private boolean newProxyInstance;
        public int scheduleImpl;

        public Builder(Context context, DialogInterface.OnDismissListener onDismissListener) {
            this.BuiltInFictitiousFunctionClassFactory = context;
            this.moveToNextValue = onDismissListener;
        }

        public final Builder KClassImpl$Data$declaredNonStaticMembers$2() {
            getAuthRequestContext(false);
            return this;
        }

        public final Builder KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
            BuiltInFictitiousFunctionClassFactory(z);
            return this;
        }
    }
}

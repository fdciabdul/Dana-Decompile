package id.dana.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import id.dana.R;
import id.dana.base.BaseMaterialDialog;
import id.dana.component.formcomponent.DanaCheckboxButtonView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.ShimmerImageAttacherFactory;
import id.dana.richview.LogoProgressView;
import id.dana.utils.ImageOss;

/* loaded from: classes2.dex */
public class TwoButtonWithImageDialog extends BaseMaterialDialog<Builder> {
    private int PlaceComponentResult;
    @BindView(R.id.btn_negative)
    public Button btnNegative;
    @BindView(R.id.btn_negative_ghost)
    Button btnNegativeGhost;
    @BindView(R.id.btn_positive)
    public Button btnPositive;
    @BindView(R.id.cb_no_dialog_anymore)
    DanaCheckboxButtonView cbNoDialogAnymore;
    @BindView(R.id.card_view)
    CardView cvLayout;
    private int getAuthRequestContext;
    @BindView(R.id.iv_image)
    ImageView ivImage;
    @BindView(R.id.lpv_loading_dialog)
    LogoProgressView lpvLoading;
    @BindView(R.id.tv_dialog_footer_text)
    TextView tvDialogFooterText;
    @BindView(R.id.tv_description)
    TextView tvMessage;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    /* loaded from: classes3.dex */
    public @interface PositiveButtonType {
        public static final int DEFAULT = 0;
        public static final int DISABLED = 2;
        public static final int SEMI_ROUNDED_WHITE = 1;
    }

    /* synthetic */ TwoButtonWithImageDialog(Context context, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnCancelListener onCancelListener, int i, Builder builder, int i2, int i3, byte b) {
        this(context, onDismissListener, onCancelListener, i, builder, i2, i3);
    }

    @Override // id.dana.base.BaseMaterialDialog
    public final /* synthetic */ void getAuthRequestContext(View view, Builder builder) {
        Builder builder2 = builder;
        if (this.ivImage != null) {
            if (builder2.KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
                if (!TextUtils.isEmpty(builder2.scheduleImpl)) {
                    ImageOss.MyBillsEntityDataFactory(builder2.scheduleImpl, this.ivImage, new ImageOss.EventListener() { // from class: id.dana.dialog.TwoButtonWithImageDialog$$ExternalSyntheticLambda0
                        @Override // id.dana.utils.ImageOss.EventListener
                        public final void PlaceComponentResult(String str, ImageView imageView) {
                            new ShimmerImageAttacherFactory().KClassImpl$Data$declaredNonStaticMembers$2(TwoButtonWithImageDialog.this.MyBillsEntityDataFactory, imageView, str, 0);
                        }
                    });
                } else {
                    this.ivImage.setVisibility(8);
                }
            } else {
                GlideApp.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2().getContext()).PlaceComponentResult(Integer.valueOf(builder2.KClassImpl$Data$declaredNonStaticMembers$2)).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion(builder2.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory(this.ivImage);
            }
            if (this.ivImage.getVisibility() == 0 && !TextUtils.isEmpty(builder2.lookAheadTest)) {
                this.ivImage.setContentDescription(builder2.lookAheadTest);
            }
        }
        if (this.tvMessage != null) {
            if (builder2.getErrorConfigVersion != null) {
                this.tvMessage.setText(builder2.getErrorConfigVersion);
            } else {
                this.tvMessage.setText(builder2.NetworkUserEntityData$$ExternalSyntheticLambda3);
                this.tvMessage.setMovementMethod(LinkMovementMethod.getInstance());
            }
            TextView textView = this.tvMessage;
            textView.setVisibility(TextUtils.isEmpty(textView.getText()) ? 8 : 0);
            if (builder2.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
                this.tvMessage.setContentDescription(builder2.NetworkUserEntityData$$ExternalSyntheticLambda0);
            }
        }
        TextView textView2 = this.tvTitle;
        if (textView2 != null) {
            textView2.setText(builder2.FragmentBottomSheetPaymentSettingBinding);
            TextView textView3 = this.tvTitle;
            textView3.setVisibility(TextUtils.isEmpty(textView3.getText()) ? 8 : 0);
            if (builder2.SubSequence != null) {
                this.tvTitle.setContentDescription(builder2.SubSequence);
            }
        }
        String str = builder2.NetworkUserEntityData$$ExternalSyntheticLambda8;
        boolean z = builder2.getCallingPid;
        final View.OnClickListener onClickListener = builder2.NetworkUserEntityData$$ExternalSyntheticLambda4;
        int i = builder2.NetworkUserEntityData$$ExternalSyntheticLambda5;
        final boolean z2 = builder2.isLayoutRequested;
        this.btnPositive.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        this.btnPositive.setText(str);
        if (z) {
            this.btnPositive.setOnClickListener(new View.OnClickListener() { // from class: id.dana.dialog.TwoButtonWithImageDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TwoButtonWithImageDialog twoButtonWithImageDialog = TwoButtonWithImageDialog.this;
                    View.OnClickListener onClickListener2 = onClickListener;
                    twoButtonWithImageDialog.lpvLoading.setVisibility(0);
                    twoButtonWithImageDialog.lpvLoading.startRefresh();
                    twoButtonWithImageDialog.btnNegative.setVisibility(8);
                    twoButtonWithImageDialog.btnNegativeGhost.setVisibility(8);
                    twoButtonWithImageDialog.btnPositive.setVisibility(8);
                    if (onClickListener2 != null) {
                        onClickListener2.onClick(view2);
                    }
                }
            });
        } else {
            this.btnPositive.setOnClickListener(new View.OnClickListener() { // from class: id.dana.dialog.TwoButtonWithImageDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TwoButtonWithImageDialog twoButtonWithImageDialog = TwoButtonWithImageDialog.this;
                    boolean z3 = z2;
                    View.OnClickListener onClickListener2 = onClickListener;
                    if (z3) {
                        twoButtonWithImageDialog.getAuthRequestContext();
                    }
                    if (onClickListener2 != null) {
                        onClickListener2.onClick(view2);
                    }
                }
            });
        }
        if (i == 1) {
            this.btnPositive.setBackground(ContextCompat.PlaceComponentResult(this.MyBillsEntityDataFactory, (int) R.drawable.btn_semi_rounded_white));
            this.btnPositive.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, R.color.f22762131099721));
        } else if (i == 2) {
            this.btnPositive.setEnabled(false);
        }
        String str2 = builder2.NetworkUserEntityData$$ExternalSyntheticLambda2;
        boolean z3 = builder2.initRecordTimeStamp;
        boolean z4 = builder2.newProxyInstance;
        final View.OnClickListener onClickListener2 = builder2.DatabaseTableConfigUtil;
        if (z3) {
            this.btnNegative.setVisibility(8);
            this.btnNegativeGhost.setVisibility(TextUtils.isEmpty(str2) ? 8 : 0);
            this.btnNegativeGhost.setText(str2);
            this.btnNegativeGhost.setOnClickListener(new View.OnClickListener() { // from class: id.dana.dialog.TwoButtonWithImageDialog$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TwoButtonWithImageDialog twoButtonWithImageDialog = TwoButtonWithImageDialog.this;
                    View.OnClickListener onClickListener3 = onClickListener2;
                    twoButtonWithImageDialog.getAuthRequestContext();
                    if (onClickListener3 != null) {
                        onClickListener3.onClick(view2);
                    }
                }
            });
        } else {
            this.btnNegative.setVisibility(TextUtils.isEmpty(str2) ? 8 : 0);
            this.btnNegative.setText(str2);
            this.btnNegative.setOnClickListener(new View.OnClickListener() { // from class: id.dana.dialog.TwoButtonWithImageDialog$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TwoButtonWithImageDialog twoButtonWithImageDialog = TwoButtonWithImageDialog.this;
                    View.OnClickListener onClickListener3 = onClickListener2;
                    twoButtonWithImageDialog.getAuthRequestContext();
                    if (onClickListener3 != null) {
                        onClickListener3.onClick(view2);
                    }
                }
            });
            this.btnNegative.setBackgroundResource(R.drawable.btn_friendship_rounded_white);
            if (z4) {
                this.btnNegative.setBackgroundResource(R.drawable.btn_friendship_transparent);
            }
        }
        String str3 = builder2.PrepareContext;
        boolean z5 = builder2.initRecordTimeStamp;
        String str4 = builder2.GetContactSyncConfig;
        if (this.btnPositive != null && !TextUtils.isEmpty(str3)) {
            this.btnPositive.setContentDescription(str3);
        }
        if (z5) {
            if (this.btnNegativeGhost != null && !TextUtils.isEmpty(str4)) {
                this.btnNegativeGhost.setContentDescription(str4);
            }
        } else if (this.btnNegative != null && !TextUtils.isEmpty(str4)) {
            this.btnNegative.setContentDescription(str4);
        }
        String str5 = builder2.BuiltInFictitiousFunctionClassFactory;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = builder2.NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (str5.isEmpty()) {
            this.cbNoDialogAnymore.setVisibility(8);
        } else {
            this.cbNoDialogAnymore.setVisibility(0);
            this.cbNoDialogAnymore.setGravity(16);
            this.cbNoDialogAnymore.setTextSize(12.0f);
            this.cbNoDialogAnymore.setText(str5);
            this.cbNoDialogAnymore.setOnCheckedChangeListener(onCheckedChangeListener);
        }
        Spannable spannable = builder2.PlaceComponentResult;
        if (TextUtils.isEmpty(spannable)) {
            this.tvDialogFooterText.setVisibility(8);
        } else {
            this.tvDialogFooterText.setVisibility(0);
            this.tvDialogFooterText.setText(spannable);
            this.tvDialogFooterText.setMovementMethod(LinkMovementMethod.getInstance());
        }
        int i2 = builder2.getAuthRequestContext;
        if (i2 != 0) {
            this.cvLayout.setCardBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, i2));
        }
        int i3 = builder2.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (i3 != 0) {
            this.tvMessage.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, i3));
        }
    }

    private TwoButtonWithImageDialog(Context context, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnCancelListener onCancelListener, int i, Builder builder, int i2, int i3) {
        super(context, onDismissListener, onCancelListener, Integer.valueOf(i), builder);
        this.getAuthRequestContext = i2;
        this.PlaceComponentResult = i3;
        ImageView imageView = this.ivImage;
        if (imageView != null) {
            if (i3 != 0) {
                imageView.getLayoutParams().height = this.PlaceComponentResult;
            }
            if (this.getAuthRequestContext != 0) {
                this.ivImage.getLayoutParams().width = this.getAuthRequestContext;
            }
            this.ivImage.requestLayout();
        }
    }

    /* loaded from: classes2.dex */
    public static class Builder extends BaseMaterialDialog.Cancellation {
        public View.OnClickListener DatabaseTableConfigUtil;
        public String FragmentBottomSheetPaymentSettingBinding;
        public String GetContactSyncConfig;
        public int KClassImpl$Data$declaredNonStaticMembers$2;
        public DialogInterface.OnCancelListener MyBillsEntityDataFactory;
        public String NetworkUserEntityData$$ExternalSyntheticLambda0;
        public int NetworkUserEntityData$$ExternalSyntheticLambda1;
        public String NetworkUserEntityData$$ExternalSyntheticLambda2;
        public Spannable NetworkUserEntityData$$ExternalSyntheticLambda3;
        public View.OnClickListener NetworkUserEntityData$$ExternalSyntheticLambda4;
        public CompoundButton.OnCheckedChangeListener NetworkUserEntityData$$ExternalSyntheticLambda7;
        public String NetworkUserEntityData$$ExternalSyntheticLambda8;
        public String PrepareContext;
        public String SubSequence;
        public int getAuthRequestContext;
        private boolean getCallingPid;
        public String getErrorConfigVersion;
        public int getSupportButtonTintMode;
        public String lookAheadTest;
        public int moveToNextValue;
        private Context readMicros;
        public String scheduleImpl;
        private DialogInterface.OnDismissListener whenAvailable;
        int NetworkUserEntityData$$ExternalSyntheticLambda6 = R.layout.view_two_button_with_image_popup;
        public boolean initRecordTimeStamp = false;
        public boolean newProxyInstance = false;
        public int NetworkUserEntityData$$ExternalSyntheticLambda5 = 0;
        public String BuiltInFictitiousFunctionClassFactory = "";
        public boolean isLayoutRequested = true;
        public Spannable PlaceComponentResult = null;

        public Builder(Context context) {
            this.readMicros = context;
        }

        public final Builder PlaceComponentResult(boolean z) {
            getAuthRequestContext(z);
            return this;
        }

        public final Builder MyBillsEntityDataFactory(boolean z) {
            BuiltInFictitiousFunctionClassFactory(z);
            return this;
        }

        public final TwoButtonWithImageDialog KClassImpl$Data$declaredNonStaticMembers$2() {
            return new TwoButtonWithImageDialog(this.readMicros, this.whenAvailable, this.MyBillsEntityDataFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this, this.getSupportButtonTintMode, this.moveToNextValue, (byte) 0);
        }
    }
}

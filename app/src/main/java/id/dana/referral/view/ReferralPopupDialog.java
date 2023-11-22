package id.dana.referral.view;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseMaterialDialog;
import id.dana.referral.view.ReferralPopupDialog;

/* loaded from: classes5.dex */
public class ReferralPopupDialog extends BaseMaterialDialog<Builder> {
    @BindView(R.id.btn_primary_action)
    Button btnPrimaryAction;
    @BindView(R.id.btn_secondary_action)
    Button btnSecondaryAction;
    @BindView(R.id.cb_dialog_referral)
    CheckBox cbDialogReferral;
    @BindView(R.id.tv_checkbox_description)
    TextView tvCheckboxDescription;
    @BindView(R.id.tv_description)
    TextView tvDescription;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    /* loaded from: classes5.dex */
    public interface ReferralPopupActionListener {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(boolean z);

        void getAuthRequestContext();
    }

    public /* synthetic */ ReferralPopupDialog(Context context, DialogInterface.OnDismissListener onDismissListener, Builder builder, byte b) {
        this(context, onDismissListener, builder);
    }

    @Override // id.dana.base.BaseMaterialDialog
    public final /* synthetic */ void getAuthRequestContext(View view, Builder builder) {
        final Builder builder2 = builder;
        String str = builder2.scheduleImpl;
        if (!TextUtils.isEmpty(str)) {
            this.tvTitle.setText(str);
        }
        String str2 = builder2.KClassImpl$Data$declaredNonStaticMembers$2;
        if (!TextUtils.isEmpty(str2)) {
            this.tvDescription.setText(str2);
        }
        String str3 = builder2.PlaceComponentResult;
        if (!TextUtils.isEmpty(str3)) {
            this.tvCheckboxDescription.setText(str3);
            this.tvCheckboxDescription.setOnClickListener(new View.OnClickListener() { // from class: id.dana.referral.view.ReferralPopupDialog$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ReferralPopupDialog.this.cbDialogReferral.setChecked(!r2.isChecked());
                }
            });
        }
        this.btnPrimaryAction.setOnClickListener(new View.OnClickListener() { // from class: id.dana.referral.view.ReferralPopupDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReferralPopupDialog.getAuthRequestContext(ReferralPopupDialog.Builder.this);
            }
        });
        this.btnSecondaryAction.setOnClickListener(new View.OnClickListener() { // from class: id.dana.referral.view.ReferralPopupDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReferralPopupDialog.MyBillsEntityDataFactory(ReferralPopupDialog.Builder.this);
            }
        });
        this.cbDialogReferral.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.referral.view.ReferralPopupDialog$$ExternalSyntheticLambda2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ReferralPopupDialog.KClassImpl$Data$declaredNonStaticMembers$2(ReferralPopupDialog.Builder.this, z);
            }
        });
    }

    private ReferralPopupDialog(Context context, DialogInterface.OnDismissListener onDismissListener, Builder builder) {
        super(context, onDismissListener, Integer.valueOf((int) R.layout.dialog_referral), builder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void getAuthRequestContext(Builder builder) {
        if (builder.MyBillsEntityDataFactory != null) {
            builder.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void MyBillsEntityDataFactory(Builder builder) {
        if (builder.MyBillsEntityDataFactory != null) {
            builder.MyBillsEntityDataFactory.getAuthRequestContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Builder builder, boolean z) {
        if (builder.MyBillsEntityDataFactory != null) {
            builder.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(z);
        }
    }

    /* loaded from: classes5.dex */
    public static class Builder extends BaseMaterialDialog.Cancellation {
        public Context BuiltInFictitiousFunctionClassFactory;
        public String KClassImpl$Data$declaredNonStaticMembers$2;
        public ReferralPopupActionListener MyBillsEntityDataFactory;
        public String PlaceComponentResult;
        public DialogInterface.OnDismissListener getAuthRequestContext;
        public String scheduleImpl;

        public Builder(Context context) {
            this.BuiltInFictitiousFunctionClassFactory = context;
            getAuthRequestContext(false);
            BuiltInFictitiousFunctionClassFactory(false);
        }
    }
}

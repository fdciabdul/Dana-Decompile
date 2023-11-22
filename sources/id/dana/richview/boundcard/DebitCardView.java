package id.dana.richview.boundcard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import com.fullstory.instrumentation.InstrumentInjector;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerWalletComponent;
import id.dana.di.modules.SavingModule;
import id.dana.domain.payasset.model.CardScheme;
import id.dana.pay.PayCardViewItem;
import id.dana.pay.PayCardViewItemFactory;
import id.dana.richview.boundcard.model.BoundCard;
import id.dana.savings.contract.SavingViewListener;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.ViewUtil;

/* loaded from: classes9.dex */
public class DebitCardView extends BaseRichView {
    private BoundCard BuiltInFictitiousFunctionClassFactory;
    private PayCardViewItem PlaceComponentResult;
    @BindView(R.id.cl_debit_card)
    ConstraintLayout clDebitCard;
    @BindView(R.id.iv_card_logo)
    ImageView ivCardLogo;
    @BindView(R.id.iv_channel)
    ImageView ivChannel;
    @BindView(R.id.iv_expresspay)
    ImageView ivExpressPay;
    @BindView(R.id.ll_debit_card_background)
    LinearLayout llDebitCardBackground;
    @BindView(R.id.tv_title_card)
    TextView tvDebit;
    @BindView(R.id.f4429tv_mask_number)
    TextView tvMaskNumber;
    @BindView(R.id.tv_preferred)
    TextView tvPreferred;
    @BindView(R.id.tv_update_card)
    TextView tvUpdateCard;
    @BindView(R.id.tv_valid_thru)
    TextView tvValidThru;
    @BindView(R.id.tv_valid_thru_label)
    TextView tvValidThruLabel;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_base_debit_card;
    }

    public DebitCardView(Context context) {
        super(context);
    }

    public DebitCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DebitCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public DebitCardView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // id.dana.base.BaseRichView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.BaseRichView
    public void injectComponent(ApplicationComponent applicationComponent) {
        DaggerWalletComponent.Builder authRequestContext = DaggerWalletComponent.getAuthRequestContext();
        authRequestContext.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        authRequestContext.getAuthRequestContext = (SavingModule) Preconditions.getAuthRequestContext(new SavingModule(new SavingViewListener()));
        authRequestContext.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        BuiltInFictitiousFunctionClassFactory();
    }

    public BoundCard getData() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public void setData(BoundCard boundCard) {
        this.BuiltInFictitiousFunctionClassFactory = boundCard;
        BuiltInFictitiousFunctionClassFactory();
    }

    private void BuiltInFictitiousFunctionClassFactory() {
        String str;
        Drawable BuiltInFictitiousFunctionClassFactory;
        if (this.BuiltInFictitiousFunctionClassFactory == null || this.llDebitCardBackground == null) {
            return;
        }
        if (!MyBillsEntityDataFactory()) {
            this.tvValidThru.setText(getContext().getString(R.string.expired));
            this.tvUpdateCard.setVisibility(0);
            this.ivChannel.setVisibility(8);
        } else {
            String str2 = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
            ImageView[] imageViewArr = {this.ivChannel};
            for (int i = 0; i <= 0; i++) {
                ImageView imageView = imageViewArr[0];
                if (PlaceComponentResult(str2) != null) {
                    BuiltInFictitiousFunctionClassFactory = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(getContext(), PlaceComponentResult(str2).intValue());
                    imageView.setImageDrawable(BuiltInFictitiousFunctionClassFactory);
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
            }
            this.tvUpdateCard.setVisibility(8);
            TextView textView = this.tvValidThru;
            Object[] objArr = new Object[2];
            objArr[0] = this.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion;
            BoundCard boundCard = this.BuiltInFictitiousFunctionClassFactory;
            if (boundCard.NetworkUserEntityData$$ExternalSyntheticLambda0.length() >= 2) {
                String str3 = boundCard.NetworkUserEntityData$$ExternalSyntheticLambda0;
                str = str3.substring(str3.length() - 2);
            } else {
                str = boundCard.NetworkUserEntityData$$ExternalSyntheticLambda0;
            }
            objArr[1] = str;
            textView.setText(String.format("%s/%s", objArr));
        }
        this.ivExpressPay.setVisibility(8);
        this.tvPreferred.setVisibility(8);
        BoundCard boundCard2 = this.BuiltInFictitiousFunctionClassFactory;
        if (boundCard2 != null && boundCard2.PlaceComponentResult != null) {
            String str4 = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
            if ("DEBIT_CARD".equals(str4)) {
                this.tvDebit.setText(R.string.debit);
            } else if ("CREDIT_CARD".equals(str4)) {
                this.tvDebit.setText(R.string.credit);
            }
        }
        String str5 = this.BuiltInFictitiousFunctionClassFactory.lookAheadTest;
        String str6 = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
        boolean PlaceComponentResult = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
        if (TextUtils.isEmpty(str5)) {
            str5 = "";
        }
        PayCardViewItem authRequestContext = PayCardViewItemFactory.getAuthRequestContext(str5, str6, PlaceComponentResult);
        this.PlaceComponentResult = authRequestContext;
        InstrumentInjector.Resources_setImageResource(this.ivCardLogo, authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2);
        this.llDebitCardBackground.setBackgroundResource(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
        TextView textView2 = this.tvMaskNumber;
        Object[] objArr2 = new Object[1];
        String str7 = this.BuiltInFictitiousFunctionClassFactory.GetContactSyncConfig;
        objArr2[0] = str7 != null ? str7 : "";
        textView2.setText(String.format("•••• •••• •••• %s", objArr2));
        this.tvPreferred.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), this.PlaceComponentResult.scheduleImpl));
        this.tvPreferred.setVisibility(this.BuiltInFictitiousFunctionClassFactory.scheduleImpl() ? 0 : 8);
        if (this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult() || this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            this.tvPreferred.setVisibility(8);
            this.ivExpressPay.setVisibility(0);
            ImageView imageView2 = this.ivExpressPay;
            PayCardViewItem payCardViewItem = this.PlaceComponentResult;
            int i2 = payCardViewItem.getAuthRequestContext;
            if (i2 == 0) {
                i2 = payCardViewItem.MyBillsEntityDataFactory;
            }
            InstrumentInjector.Resources_setImageResource(imageView2, i2);
        }
        ViewUtil.PlaceComponentResult(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), this.PlaceComponentResult.PlaceComponentResult), this.tvDebit, this.tvMaskNumber, this.tvUpdateCard, this.tvValidThru, this.tvValidThruLabel);
    }

    private boolean MyBillsEntityDataFactory() {
        String str = this.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion;
        String str2 = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        int parseInt = Integer.parseInt(str2);
        return DateTimeUtil.PlaceComponentResult(parseInt) || (DateTimeUtil.BuiltInFictitiousFunctionClassFactory(parseInt) && DateTimeUtil.KClassImpl$Data$declaredNonStaticMembers$2(Integer.parseInt(str)));
    }

    private static Integer PlaceComponentResult(String str) {
        if (str != null) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1934979172:
                    if (str.equals(CardScheme.VISA)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1062451836:
                    if (str.equals(CardScheme.JCB)) {
                        c = 1;
                        break;
                    }
                    break;
                case -1003810246:
                    if (str.equals(CardScheme.AMERICAN_EXPRESS)) {
                        c = 2;
                        break;
                    }
                    break;
                case 70789:
                    if (str.equals(CardScheme.GPN)) {
                        c = 3;
                        break;
                    }
                    break;
                case 425933967:
                    if (str.equals(CardScheme.BCA)) {
                        c = 4;
                        break;
                    }
                    break;
                case 1067049040:
                    if (str.equals(CardScheme.MASTERCARD)) {
                        c = 5;
                        break;
                    }
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c != 3) {
                            if (c != 4) {
                                if (c != 5) {
                                    return null;
                                }
                                return Integer.valueOf((int) R.drawable.mastercard_with_border);
                            }
                            return Integer.valueOf((int) R.drawable.bca_card_with_border);
                        }
                        return Integer.valueOf((int) R.drawable.gpn_with_border);
                    }
                    return Integer.valueOf((int) R.drawable.american_express_with_border);
                }
                return Integer.valueOf((int) R.drawable.jcb_with_border);
            }
            return Integer.valueOf((int) R.drawable.visa_with_border);
        }
        return null;
    }
}

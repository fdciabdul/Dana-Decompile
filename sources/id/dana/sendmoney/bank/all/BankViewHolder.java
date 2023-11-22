package id.dana.sendmoney.bank.all;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import butterknife.BindView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.RecipientSource;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sendmoney.recipient.RecipientIdType;
import id.dana.sendmoney.view.RecipientSelectedListener;
import id.dana.utils.ImageResize;
import id.dana.utils.MaskedTextUtil;
import id.dana.utils.TextUtil;

/* loaded from: classes5.dex */
public class BankViewHolder extends BaseRecyclerViewHolder<RecipientViewModel> {
    final RecipientSelectedListener BuiltInFictitiousFunctionClassFactory;
    RecipientViewModel KClassImpl$Data$declaredNonStaticMembers$2;
    @BindView(R.id.iv_change_icon)
    public AppCompatImageView ivChangeIcon;
    @BindView(R.id.SendMoneyHomePresenter)
    ImageView ivLogo;
    @BindView(R.id.tv_prefix_description)
    TextView tvPrefixDescription;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_description)
    TextView tvViewDescription;
    @BindView(R.id.view_divider_full)
    public View vDividerFull;
    @BindView(R.id.view_divider_with_margin)
    public View vDividerWithMargin;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(RecipientViewModel recipientViewModel) {
        String str;
        RecipientViewModel recipientViewModel2 = recipientViewModel;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recipientViewModel2;
        this.tvTitle.setText(MaskedTextUtil.PlaceComponentResult(TextUtils.isEmpty(recipientViewModel2.getAuthRequestContext) ? recipientViewModel2.NetworkUserEntityData$$ExternalSyntheticLambda0() : recipientViewModel2.getAuthRequestContext));
        this.tvViewDescription.setText(TextUtil.BuiltInFictitiousFunctionClassFactory(TextUtil.MyBillsEntityDataFactory(recipientViewModel2.getErrorConfigVersion)));
        GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(recipientViewModel2.BuiltInFictitiousFunctionClassFactory()).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).getErrorConfigVersion((int) R.drawable.ic_bank_placeholder).PlaceComponentResult((int) R.drawable.ic_bank_placeholder).MyBillsEntityDataFactory(this.ivLogo);
        if (TextUtils.isEmpty(recipientViewModel2.BuiltInFictitiousFunctionClassFactory)) {
            str = getContext().getString(R.string.debit);
        } else {
            str = recipientViewModel2.BuiltInFictitiousFunctionClassFactory;
        }
        this.tvPrefixDescription.setText(str);
    }

    public BankViewHolder(ViewGroup viewGroup, RecipientSelectedListener recipientSelectedListener) {
        super(viewGroup.getContext(), R.layout.item_saved_bank_cards, viewGroup);
        this.BuiltInFictitiousFunctionClassFactory = recipientSelectedListener;
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.bank.all.BankViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankViewHolder bankViewHolder = BankViewHolder.this;
                RecipientModel.Builder builder = new RecipientModel.Builder("bank");
                builder.scheduleImpl = bankViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
                builder.PrepareContext = RecipientIdType.INSTITUTION;
                builder.initRecordTimeStamp = bankViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0();
                builder.isLayoutRequested = bankViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0();
                builder.NetworkUserEntityData$$ExternalSyntheticLambda3 = bankViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.initRecordTimeStamp;
                builder.GetContactSyncConfig = bankViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion;
                builder.getErrorConfigVersion = bankViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
                builder.lookAheadTest = bankViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
                builder.NetworkUserEntityData$$ExternalSyntheticLambda1 = bankViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda2;
                builder.DatabaseTableConfigUtil = bankViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.DatabaseTableConfigUtil;
                builder.PlaceComponentResult = bankViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
                builder.newProxyInstance = RecipientSource.ALL_CONTACTS;
                builder.getAuthRequestContext = bankViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
                builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = bankViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
                builder.FragmentBottomSheetPaymentSettingBinding = bankViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1;
                builder.moveToNextValue = bankViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion();
                bankViewHolder.BuiltInFictitiousFunctionClassFactory.onRecipientSelected(builder.KClassImpl$Data$declaredNonStaticMembers$2());
            }
        });
    }
}

package id.dana.sendmoney_v2.recipient.bank.viewholder;

import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.databinding.ItemSavedBankCardsV2Binding;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.RecipientSource;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sendmoney.recipient.RecipientIdType;
import id.dana.sendmoney.view.RecipientSelectedListener;
import id.dana.sendmoney_v2.recipient.view.RecipientMoreActionListener;
import id.dana.utils.ImageResize;
import id.dana.utils.MaskedTextUtil;
import id.dana.utils.TextUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\u0012\u0006\u0010\u0005\u001a\u00020\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0014"}, d2 = {"Lid/dana/sendmoney_v2/recipient/bank/viewholder/BankViewHolderV2;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/sendmoney/model/RecipientViewModel;", "Lid/dana/databinding/ItemSavedBankCardsV2Binding;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "", "Lid/dana/sendmoney/model/RecipientModel;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Lid/dana/sendmoney/model/RecipientModel;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/model/RecipientViewModel;", "getAuthRequestContext", "Lid/dana/sendmoney_v2/recipient/view/RecipientMoreActionListener;", "PlaceComponentResult", "Lid/dana/sendmoney_v2/recipient/view/RecipientMoreActionListener;", "Lid/dana/sendmoney/view/RecipientSelectedListener;", "Lid/dana/sendmoney/view/RecipientSelectedListener;", "Landroid/view/ViewGroup;", "p1", "p2", "<init>", "(Landroid/view/ViewGroup;Lid/dana/sendmoney/view/RecipientSelectedListener;Lid/dana/sendmoney_v2/recipient/view/RecipientMoreActionListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class BankViewHolderV2 extends ViewBindingRecyclerViewHolder<RecipientViewModel, ItemSavedBankCardsV2Binding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final RecipientSelectedListener MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private RecipientViewModel getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final RecipientMoreActionListener BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(Object obj) {
        RecipientViewModel recipientViewModel = (RecipientViewModel) obj;
        if (recipientViewModel != null) {
            this.getAuthRequestContext = recipientViewModel;
            String str = recipientViewModel.getAuthRequestContext;
            getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setText(MaskedTextUtil.PlaceComponentResult((str == null || str.length() == 0 ? recipientViewModel.NetworkUserEntityData$$ExternalSyntheticLambda0() : recipientViewModel.getAuthRequestContext).toString()));
            String BuiltInFictitiousFunctionClassFactory = TextUtil.BuiltInFictitiousFunctionClassFactory(TextUtil.MyBillsEntityDataFactory(recipientViewModel.getErrorConfigVersion));
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
            getBinding().getAuthRequestContext.setText(BuiltInFictitiousFunctionClassFactory);
            String BuiltInFictitiousFunctionClassFactory2 = recipientViewModel.BuiltInFictitiousFunctionClassFactory();
            if (BuiltInFictitiousFunctionClassFactory2 == null) {
                BuiltInFictitiousFunctionClassFactory2 = "";
            }
            GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).getErrorConfigVersion((int) R.drawable.ic_bank_placeholder).PlaceComponentResult((int) R.drawable.ic_bank_placeholder).MyBillsEntityDataFactory((ImageView) getBinding().KClassImpl$Data$declaredNonStaticMembers$2);
            String str2 = recipientViewModel.BuiltInFictitiousFunctionClassFactory;
            String string = str2 == null || str2.length() == 0 ? getContext().getString(R.string.debit) : recipientViewModel.BuiltInFictitiousFunctionClassFactory.toString();
            Intrinsics.checkNotNullExpressionValue(string, "");
            getBinding().lookAheadTest.setText(string);
            getBinding().PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.recipient.bank.viewholder.BankViewHolderV2$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BankViewHolderV2.getAuthRequestContext(BankViewHolderV2.this);
                }
            });
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public /* synthetic */ ItemSavedBankCardsV2Binding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemSavedBankCardsV2Binding BuiltInFictitiousFunctionClassFactory = ItemSavedBankCardsV2Binding.BuiltInFictitiousFunctionClassFactory(view);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BankViewHolderV2(android.view.ViewGroup r3, id.dana.sendmoney.view.RecipientSelectedListener r4, id.dana.sendmoney_v2.recipient.view.RecipientMoreActionListener r5) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559244(0x7f0d034c, float:1.8743827E38)
            r2.<init>(r1, r0, r3)
            r2.MyBillsEntityDataFactory = r4
            r2.BuiltInFictitiousFunctionClassFactory = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.recipient.bank.viewholder.BankViewHolderV2.<init>(android.view.ViewGroup, id.dana.sendmoney.view.RecipientSelectedListener, id.dana.sendmoney_v2.recipient.view.RecipientMoreActionListener):void");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.recipient.bank.viewholder.BankViewHolderV2$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankViewHolderV2.PlaceComponentResult(BankViewHolderV2.this);
            }
        });
    }

    private final RecipientModel BuiltInFictitiousFunctionClassFactory(String p0) {
        RecipientModel.Builder builder = new RecipientModel.Builder("bank");
        RecipientViewModel recipientViewModel = this.getAuthRequestContext;
        builder.scheduleImpl = recipientViewModel != null ? recipientViewModel.KClassImpl$Data$declaredNonStaticMembers$2() : null;
        builder.PrepareContext = RecipientIdType.INSTITUTION;
        RecipientViewModel recipientViewModel2 = this.getAuthRequestContext;
        builder.initRecordTimeStamp = recipientViewModel2 != null ? recipientViewModel2.NetworkUserEntityData$$ExternalSyntheticLambda0() : null;
        RecipientViewModel recipientViewModel3 = this.getAuthRequestContext;
        builder.isLayoutRequested = recipientViewModel3 != null ? recipientViewModel3.NetworkUserEntityData$$ExternalSyntheticLambda0() : null;
        RecipientViewModel recipientViewModel4 = this.getAuthRequestContext;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda3 = recipientViewModel4 != null ? recipientViewModel4.initRecordTimeStamp : null;
        RecipientViewModel recipientViewModel5 = this.getAuthRequestContext;
        builder.GetContactSyncConfig = recipientViewModel5 != null ? recipientViewModel5.getErrorConfigVersion : null;
        RecipientViewModel recipientViewModel6 = this.getAuthRequestContext;
        builder.getErrorConfigVersion = recipientViewModel6 != null ? recipientViewModel6.BuiltInFictitiousFunctionClassFactory() : null;
        RecipientViewModel recipientViewModel7 = this.getAuthRequestContext;
        builder.lookAheadTest = recipientViewModel7 != null ? recipientViewModel7.BuiltInFictitiousFunctionClassFactory : null;
        RecipientViewModel recipientViewModel8 = this.getAuthRequestContext;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda1 = recipientViewModel8 != null ? recipientViewModel8.NetworkUserEntityData$$ExternalSyntheticLambda2 : null;
        RecipientViewModel recipientViewModel9 = this.getAuthRequestContext;
        builder.DatabaseTableConfigUtil = recipientViewModel9 != null ? recipientViewModel9.DatabaseTableConfigUtil : null;
        RecipientViewModel recipientViewModel10 = this.getAuthRequestContext;
        builder.PlaceComponentResult = recipientViewModel10 != null ? recipientViewModel10.getAuthRequestContext : null;
        builder.newProxyInstance = p0;
        RecipientViewModel recipientViewModel11 = this.getAuthRequestContext;
        builder.getAuthRequestContext = recipientViewModel11 != null ? recipientViewModel11.getAuthRequestContext() : null;
        RecipientViewModel recipientViewModel12 = this.getAuthRequestContext;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = recipientViewModel12 != null ? recipientViewModel12.MyBillsEntityDataFactory() : null;
        RecipientViewModel recipientViewModel13 = this.getAuthRequestContext;
        builder.FragmentBottomSheetPaymentSettingBinding = recipientViewModel13 != null ? recipientViewModel13.NetworkUserEntityData$$ExternalSyntheticLambda1 : 0;
        RecipientViewModel recipientViewModel14 = this.getAuthRequestContext;
        builder.moveToNextValue = recipientViewModel14 != null ? recipientViewModel14.getErrorConfigVersion() : false;
        return builder.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ void PlaceComponentResult(BankViewHolderV2 bankViewHolderV2) {
        Intrinsics.checkNotNullParameter(bankViewHolderV2, "");
        RecipientModel BuiltInFictitiousFunctionClassFactory = bankViewHolderV2.BuiltInFictitiousFunctionClassFactory(RecipientSource.ALL_CONTACTS);
        RecipientSelectedListener recipientSelectedListener = bankViewHolderV2.MyBillsEntityDataFactory;
        if (recipientSelectedListener != null) {
            recipientSelectedListener.onRecipientSelected(BuiltInFictitiousFunctionClassFactory);
        }
    }

    public static /* synthetic */ void getAuthRequestContext(BankViewHolderV2 bankViewHolderV2) {
        Intrinsics.checkNotNullParameter(bankViewHolderV2, "");
        RecipientModel BuiltInFictitiousFunctionClassFactory = bankViewHolderV2.BuiltInFictitiousFunctionClassFactory(RecipientSource.RECENT);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            RecipientViewModel recipientViewModel = bankViewHolderV2.getAuthRequestContext;
            if (recipientViewModel != null) {
                BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = recipientViewModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
            }
            RecipientMoreActionListener recipientMoreActionListener = bankViewHolderV2.BuiltInFictitiousFunctionClassFactory;
            if (recipientMoreActionListener != null) {
                recipientMoreActionListener.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory);
            }
        }
    }
}

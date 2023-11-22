package id.dana.sendmoney_v2.contact.all;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.util.NumberUtil;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sendmoney.view.BaseRecipientListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/sendmoney_v2/contact/all/SendWithNewNumberSmartFrictionViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/sendmoney/model/RecipientViewModel;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "Landroid/view/ViewGroup;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/ViewGroup;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/view/BaseRecipientListener;", "getAuthRequestContext", "Lid/dana/sendmoney/view/BaseRecipientListener;", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/model/RecipientViewModel;", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/sendmoney/view/BaseRecipientListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendWithNewNumberSmartFrictionViewHolder extends BaseRecyclerViewHolder<RecipientViewModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private RecipientViewModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final ViewGroup MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final BaseRecipientListener PlaceComponentResult;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(RecipientViewModel recipientViewModel) {
        RecipientViewModel recipientViewModel2 = recipientViewModel;
        Intrinsics.checkNotNullParameter(recipientViewModel2, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recipientViewModel2;
        TextView textView = (TextView) this.itemView.findViewById(R.id.access$createConstructor);
        NumberUtil numberUtil = NumberUtil.INSTANCE;
        String str = recipientViewModel2.getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(str, "");
        textView.setText(NumberUtil.DatabaseTableConfigUtil(str));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendWithNewNumberSmartFrictionViewHolder(ViewGroup viewGroup, BaseRecipientListener baseRecipientListener) {
        super(viewGroup.getContext(), R.layout.item_send_new_number_smart_friction, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.MyBillsEntityDataFactory = viewGroup;
        this.PlaceComponentResult = baseRecipientListener;
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener p0) {
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.contact.all.SendWithNewNumberSmartFrictionViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendWithNewNumberSmartFrictionViewHolder.MyBillsEntityDataFactory(SendWithNewNumberSmartFrictionViewHolder.this);
            }
        });
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(SendWithNewNumberSmartFrictionViewHolder sendWithNewNumberSmartFrictionViewHolder) {
        Intrinsics.checkNotNullParameter(sendWithNewNumberSmartFrictionViewHolder, "");
        RecipientModel.Builder builder = new RecipientModel.Builder("contact");
        builder.PrepareContext = "phonenumber";
        builder.scheduleImpl = ((TextView) sendWithNewNumberSmartFrictionViewHolder.itemView.findViewById(R.id.access$createConstructor)).getText().toString();
        builder.GetContactSyncConfig = ((TextView) sendWithNewNumberSmartFrictionViewHolder.itemView.findViewById(R.id.access$createConstructor)).getText().toString();
        builder.newProxyInstance = "Manual Input";
        RecipientModel KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2();
        BaseRecipientListener baseRecipientListener = sendWithNewNumberSmartFrictionViewHolder.PlaceComponentResult;
        if (baseRecipientListener != null) {
            baseRecipientListener.onRecipientSelected(KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }
}

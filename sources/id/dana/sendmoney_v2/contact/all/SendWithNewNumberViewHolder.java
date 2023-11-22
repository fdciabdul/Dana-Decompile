package id.dana.sendmoney_v2.contact.all;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sendmoney.view.BaseRecipientListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/sendmoney_v2/contact/all/SendWithNewNumberViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/sendmoney/model/RecipientViewModel;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "Landroid/view/ViewGroup;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "getAuthRequestContext", "Lid/dana/sendmoney/view/BaseRecipientListener;", "Lid/dana/sendmoney/view/BaseRecipientListener;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/model/RecipientViewModel;", "PlaceComponentResult", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/sendmoney/view/BaseRecipientListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendWithNewNumberViewHolder extends BaseRecyclerViewHolder<RecipientViewModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private RecipientViewModel PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final ViewGroup getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final BaseRecipientListener BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(RecipientViewModel recipientViewModel) {
        RecipientViewModel recipientViewModel2 = recipientViewModel;
        Intrinsics.checkNotNullParameter(recipientViewModel2, "");
        this.PlaceComponentResult = recipientViewModel2;
        ((TextView) this.itemView.findViewById(R.id.access$createConstructor)).setText(recipientViewModel2.getErrorConfigVersion);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendWithNewNumberViewHolder(ViewGroup viewGroup, BaseRecipientListener baseRecipientListener) {
        super(viewGroup.getContext(), R.layout.item_send_new_number_v2, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.getAuthRequestContext = viewGroup;
        this.BuiltInFictitiousFunctionClassFactory = baseRecipientListener;
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener p0) {
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.contact.all.SendWithNewNumberViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendWithNewNumberViewHolder.getAuthRequestContext(SendWithNewNumberViewHolder.this);
            }
        });
    }

    public static /* synthetic */ void getAuthRequestContext(SendWithNewNumberViewHolder sendWithNewNumberViewHolder) {
        Intrinsics.checkNotNullParameter(sendWithNewNumberViewHolder, "");
        RecipientModel.Builder builder = new RecipientModel.Builder("contact");
        builder.PrepareContext = "phonenumber";
        builder.scheduleImpl = ((TextView) sendWithNewNumberViewHolder.itemView.findViewById(R.id.access$createConstructor)).getText().toString();
        builder.GetContactSyncConfig = ((TextView) sendWithNewNumberViewHolder.itemView.findViewById(R.id.access$createConstructor)).getText().toString();
        builder.newProxyInstance = "Manual Input";
        RecipientModel KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2();
        BaseRecipientListener baseRecipientListener = sendWithNewNumberViewHolder.BuiltInFictitiousFunctionClassFactory;
        if (baseRecipientListener != null) {
            baseRecipientListener.onRecipientSelected(KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }
}

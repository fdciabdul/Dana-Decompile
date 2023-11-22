package id.dana.sendmoney_v2.landing.viewholder.recent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.scanner.ScannerActivity;
import id.dana.scanner.TrackerQRScanner;
import id.dana.scanner.handler.ScannerActionFactory;
import id.dana.sendmoney.model.RecentRecipientModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney_v2/landing/viewholder/recent/ScannerTransactionViewHolder;", "Lid/dana/sendmoney_v2/landing/viewholder/recent/TransactionViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ScannerTransactionViewHolder extends TransactionViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScannerTransactionViewHolder(ViewGroup viewGroup) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(RecentRecipientModel recentRecipientModel) {
        if (recentRecipientModel != null) {
            String string = getContext().getString(R.string.scan_code);
            if (string == null) {
                string = "";
            }
            getAuthRequestContext(string);
            TransactionViewHolder.MyBillsEntityDataFactory(this, null, Integer.valueOf((int) R.drawable.ic_send_via_qr), 1);
        }
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(final BaseRecyclerViewHolder.OnItemClickListener p0) {
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.landing.viewholder.recent.ScannerTransactionViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScannerTransactionViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(ScannerTransactionViewHolder.this, p0);
            }
        });
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ScannerTransactionViewHolder scannerTransactionViewHolder, BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        Intrinsics.checkNotNullParameter(scannerTransactionViewHolder, "");
        TrackerQRScanner.PlaceComponentResult("Send Money");
        Context context = scannerTransactionViewHolder.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            Intent intent = new Intent(activity, ScannerActivity.class);
            intent.putExtra("source", "Send Money");
            activity.startActivityForResult(intent, ScannerActionFactory.BuiltInFictitiousFunctionClassFactory);
        }
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(scannerTransactionViewHolder.getBindingAdapterPosition());
        }
    }
}

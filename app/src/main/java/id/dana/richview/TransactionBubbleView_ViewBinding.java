package id.dana.richview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class TransactionBubbleView_ViewBinding implements Unbinder {
    private TransactionBubbleView BuiltInFictitiousFunctionClassFactory;
    private View MyBillsEntityDataFactory;

    public TransactionBubbleView_ViewBinding(final TransactionBubbleView transactionBubbleView, View view) {
        this.BuiltInFictitiousFunctionClassFactory = transactionBubbleView;
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.button_more, "field 'buttonMore' and method 'onMoreButtonClicked'");
        transactionBubbleView.buttonMore = (TextView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.button_more, "field 'buttonMore'", TextView.class);
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.richview.TransactionBubbleView_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                transactionBubbleView.onMoreButtonClicked();
            }
        });
        transactionBubbleView.tvAmount = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4356res_0x7f0a1618_snapshotcontroller_1, "field 'tvAmount'", TextView.class);
        transactionBubbleView.ivIcon = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_icon, "field 'ivIcon'", ImageView.class);
        transactionBubbleView.tvMessage = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_message, "field 'tvMessage'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        TransactionBubbleView transactionBubbleView = this.BuiltInFictitiousFunctionClassFactory;
        if (transactionBubbleView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        transactionBubbleView.buttonMore = null;
        transactionBubbleView.tvAmount = null;
        transactionBubbleView.ivIcon = null;
        transactionBubbleView.tvMessage = null;
        this.MyBillsEntityDataFactory.setOnClickListener(null);
        this.MyBillsEntityDataFactory = null;
    }
}

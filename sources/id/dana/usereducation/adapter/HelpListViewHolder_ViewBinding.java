package id.dana.usereducation.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class HelpListViewHolder_ViewBinding implements Unbinder {
    private HelpListViewHolder MyBillsEntityDataFactory;

    public HelpListViewHolder_ViewBinding(HelpListViewHolder helpListViewHolder, View view) {
        this.MyBillsEntityDataFactory = helpListViewHolder;
        helpListViewHolder.ivIcon = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_icon, "field 'ivIcon'", ImageView.class);
        helpListViewHolder.tvTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.title, "field 'tvTitle'", TextView.class);
        helpListViewHolder.tvDescription = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.description, "field 'tvDescription'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        HelpListViewHolder helpListViewHolder = this.MyBillsEntityDataFactory;
        if (helpListViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        helpListViewHolder.ivIcon = null;
        helpListViewHolder.tvTitle = null;
        helpListViewHolder.tvDescription = null;
    }
}

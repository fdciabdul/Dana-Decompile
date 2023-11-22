package id.dana.feeds.views;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes8.dex */
public class UserFeedsActivity_ViewBinding implements Unbinder {
    private UserFeedsActivity MyBillsEntityDataFactory;

    public UserFeedsActivity_ViewBinding(UserFeedsActivity userFeedsActivity, View view) {
        this.MyBillsEntityDataFactory = userFeedsActivity;
        userFeedsActivity.rcFeeds = (RecyclerView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.feeds_rcview, "field 'rcFeeds'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        UserFeedsActivity userFeedsActivity = this.MyBillsEntityDataFactory;
        if (userFeedsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        userFeedsActivity.rcFeeds = null;
    }
}

package id.dana.richview;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class EmptyState_ViewBinding implements Unbinder {
    private EmptyState MyBillsEntityDataFactory;

    public EmptyState_ViewBinding(EmptyState emptyState, View view) {
        this.MyBillsEntityDataFactory = emptyState;
        emptyState.btnAction = (Button) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_action_emptystate, "field 'btnAction'", Button.class);
        emptyState.ivEmptyState = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_image_emptystate, "field 'ivEmptyState'", ImageView.class);
        emptyState.tvMessage = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_message_emptystate, "field 'tvMessage'", TextView.class);
        emptyState.tvTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_title_emptystate, "field 'tvTitle'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        EmptyState emptyState = this.MyBillsEntityDataFactory;
        if (emptyState == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        emptyState.btnAction = null;
        emptyState.ivEmptyState = null;
        emptyState.tvMessage = null;
        emptyState.tvTitle = null;
    }
}

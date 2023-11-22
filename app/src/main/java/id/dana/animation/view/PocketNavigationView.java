package id.dana.animation.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import butterknife.BindView;
import id.dana.R;

/* loaded from: classes5.dex */
public class PocketNavigationView extends NavigationTabView {
    @BindView(R.id.nav_tab_pocket_notif)
    ImageView tabNotif;

    @Override // id.dana.animation.view.NavigationTabView, id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_pocket_nav_tab;
    }

    public PocketNavigationView(Context context, int i, String str) {
        super(context, i, str);
    }

    public PocketNavigationView(Context context) {
        super(context);
    }

    public PocketNavigationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PocketNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PocketNavigationView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setBadge(boolean z) {
        ImageView imageView = this.tabNotif;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }
}

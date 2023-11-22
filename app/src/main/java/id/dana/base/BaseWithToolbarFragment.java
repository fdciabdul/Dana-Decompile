package id.dana.base;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Optional;
import id.dana.R;

/* loaded from: classes4.dex */
public abstract class BaseWithToolbarFragment extends BaseFragment implements DisposableHandler {
    @BindView(R.id.left_button)
    public TextView leftButton;
    @BindView(R.id.right_button)
    public TextView rightButton;
    @BindView(R.id.rl_toolbar)
    RelativeLayout rlToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.iv_title_image)
    ImageView toolbarImage;
    @BindView(R.id.toolbar_title)
    public TextView toolbarTitle;

    @OnClick({R.id.left_button})
    @Optional
    public void onClickLeftMenuButton(View view) {
    }

    @OnClick({R.id.right_button})
    @Optional
    public void onClickRightMenuButton(View view) {
    }

    public final void MyBillsEntityDataFactory(int i) {
        Toolbar toolbar = this.toolbar;
        if (toolbar == null || i == 0) {
            return;
        }
        toolbar.setNavigationIcon(i);
        this.toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.base.BaseWithToolbarFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseWithToolbarFragment.this.onClickLeftMenuButton(view);
            }
        });
        this.leftButton.setVisibility(8);
    }
}

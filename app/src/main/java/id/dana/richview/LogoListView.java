package id.dana.richview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.google.android.flexbox.FlexboxLayoutManager;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.domain.promotion.CdpContent;
import id.dana.sendmoney.LogoListAdapter;
import java.util.List;

/* loaded from: classes5.dex */
public class LogoListView extends BaseRichView {
    LogoListAdapter logoListAdapter;
    @BindView(R.id.rv_logo)
    RecyclerView rvLogo;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_logo_list;
    }

    public LogoListView(Context context) {
        super(context);
    }

    public LogoListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LogoListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public LogoListView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getContext());
        flexboxLayoutManager.setFlexDirection(0);
        flexboxLayoutManager.setJustifyContent(2);
        this.logoListAdapter = new LogoListAdapter();
        this.rvLogo.setLayoutManager(flexboxLayoutManager);
        this.rvLogo.setAdapter(this.logoListAdapter);
    }

    public void setLogo(List<CdpContent> list) {
        this.logoListAdapter.setItems(list);
    }
}

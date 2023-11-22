package id.dana.richview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.google.android.flexbox.FlexboxLayoutManager;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.usereducation.adapter.HelpListAdapter;

/* loaded from: classes3.dex */
public class HelpListView extends BaseRichView {
    @BindView(R.id.rv_help_list)
    RecyclerView rvHelpList;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_help_list;
    }

    public HelpListView(Context context) {
        super(context);
    }

    public HelpListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HelpListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public HelpListView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getContext());
        flexboxLayoutManager.setFlexDirection(0);
        flexboxLayoutManager.setJustifyContent(2);
        this.rvHelpList.setLayoutManager(flexboxLayoutManager);
    }

    public void setAdapter(HelpListAdapter helpListAdapter) {
        this.rvHelpList.setAdapter(helpListAdapter);
    }
}

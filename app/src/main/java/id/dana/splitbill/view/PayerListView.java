package id.dana.splitbill.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.splitbill.adapter.PayerListAdapter;
import id.dana.splitbill.model.PayerModel;
import java.util.List;

/* loaded from: classes5.dex */
public class PayerListView extends BaseRichView {
    private OnItemClickListener BuiltInFictitiousFunctionClassFactory;
    private RecyclerView PlaceComponentResult;
    private PayerListAdapter getAuthRequestContext;
    @BindView(R.id.tv_close_payer)
    TextView tvClosePayer;

    /* loaded from: classes5.dex */
    public interface OnItemClickListener {
        void PlaceComponentResult();
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_split_bill_payer;
    }

    public PayerListView(Context context) {
        super(context);
    }

    public PayerListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PayerListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnClickListener(OnItemClickListener onItemClickListener) {
        this.BuiltInFictitiousFunctionClassFactory = onItemClickListener;
    }

    public void setClosePayerEnabled(boolean z) {
        this.tvClosePayer.setVisibility(z ? 0 : 8);
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        this.getAuthRequestContext = new PayerListAdapter();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_payer);
        this.PlaceComponentResult = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.PlaceComponentResult.setFocusable(false);
        this.PlaceComponentResult.setAdapter(this.getAuthRequestContext);
        this.tvClosePayer.setOnClickListener(new View.OnClickListener() { // from class: id.dana.splitbill.view.PayerListView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PayerListView.this.m2972lambda$setup$0$iddanasplitbillviewPayerListView(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setup$0$id-dana-splitbill-view-PayerListView  reason: not valid java name */
    public /* synthetic */ void m2972lambda$setup$0$iddanasplitbillviewPayerListView(View view) {
        this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
    }

    public void setItems(List<PayerModel> list, boolean z) {
        this.getAuthRequestContext.setItems(list);
        this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory = z;
    }
}

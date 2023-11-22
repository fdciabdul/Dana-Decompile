package id.dana.splitbill.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.data.util.NumberUtils;
import id.dana.splitbill.adapter.ClosePayerAdapter;
import id.dana.splitbill.adapter.ClosePayerViewHolder;
import id.dana.splitbill.model.PayerModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class ClosePayerView extends BaseRichView {
    private OnDataChangedListener KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private ClosePayerAdapter PlaceComponentResult;
    @BindView(R.id.cb_close_all_payer)
    CheckBox cbCloseAllPayer;
    private boolean getAuthRequestContext;
    RecyclerView rvClosePayer;
    @BindView(R.id.tv_remaining_bill_value)
    TextView tvRemainingBillValue;
    @BindView(R.id.tv_unpaid_bill_count)
    TextView tvUnpaidBillCount;

    /* loaded from: classes5.dex */
    public interface OnDataChangedListener {
        void getAuthRequestContext(boolean z);
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_close_payer;
    }

    public ClosePayerView(Context context) {
        super(context);
    }

    public ClosePayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ClosePayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnDataChangedListener(OnDataChangedListener onDataChangedListener) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = onDataChangedListener;
    }

    public void setItems(List<PayerModel> list) {
        this.PlaceComponentResult.setItems(list);
    }

    public void setRemainingBill(String str) {
        this.tvRemainingBillValue.setText(str);
    }

    public void setUnpaidBillCount(int i) {
        this.tvUnpaidBillCount.setText(String.format(getContext().getString(R.string.unpaid_bill_count), String.valueOf(i)));
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        this.PlaceComponentResult = new ClosePayerAdapter(new ClosePayerViewHolder.OnCheckedListener() { // from class: id.dana.splitbill.view.ClosePayerView$$ExternalSyntheticLambda0
            @Override // id.dana.splitbill.adapter.ClosePayerViewHolder.OnCheckedListener
            public final void PlaceComponentResult() {
                ClosePayerView.m2970$r8$lambda$4jQPY77O2XCuVAVQl3nLNcupU(ClosePayerView.this);
            }
        }, new ClosePayerAdapter.OnAllCheckBoxEventFinishedListener() { // from class: id.dana.splitbill.view.ClosePayerView$$ExternalSyntheticLambda1
            @Override // id.dana.splitbill.adapter.ClosePayerAdapter.OnAllCheckBoxEventFinishedListener
            public final void BuiltInFictitiousFunctionClassFactory() {
                ClosePayerView.this.MyBillsEntityDataFactory = false;
            }
        });
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_close_payer);
        this.rvClosePayer = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rvClosePayer.setFocusable(false);
        this.rvClosePayer.setAdapter(this.PlaceComponentResult);
        this.rvClosePayer.setHasFixedSize(true);
        this.cbCloseAllPayer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.splitbill.view.ClosePayerView$$ExternalSyntheticLambda2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ClosePayerView.this.m2971lambda$setup$0$iddanasplitbillviewClosePayerView(compoundButton, z);
            }
        });
    }

    public List<String> getClosedPayers() {
        ArrayList arrayList = new ArrayList();
        Iterator<PayerModel> it = this.PlaceComponentResult.getAuthRequestContext().iterator();
        while (it.hasNext()) {
            arrayList.add(NumberUtils.getCleanSpaceAndDash(it.next().PlaceComponentResult));
        }
        return arrayList;
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        return this.PlaceComponentResult.getAuthRequestContext().size() == this.PlaceComponentResult.getItems().size();
    }

    private boolean PlaceComponentResult() {
        return this.PlaceComponentResult.getAuthRequestContext().size() == 0;
    }

    /* renamed from: $r8$lambda$4jQPY77O2-XCuVAV-Ql3nLNcupU  reason: not valid java name */
    public static /* synthetic */ void m2970$r8$lambda$4jQPY77O2XCuVAVQl3nLNcupU(ClosePayerView closePayerView) {
        if (closePayerView.MyBillsEntityDataFactory) {
            return;
        }
        closePayerView.getAuthRequestContext = true;
        closePayerView.cbCloseAllPayer.setChecked(closePayerView.BuiltInFictitiousFunctionClassFactory());
        closePayerView.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(closePayerView.PlaceComponentResult());
        closePayerView.getAuthRequestContext = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setup$0$id-dana-splitbill-view-ClosePayerView  reason: not valid java name */
    public /* synthetic */ void m2971lambda$setup$0$iddanasplitbillviewClosePayerView(CompoundButton compoundButton, boolean z) {
        this.MyBillsEntityDataFactory = true;
        if (!this.getAuthRequestContext) {
            ClosePayerAdapter closePayerAdapter = this.PlaceComponentResult;
            Iterator<PayerModel> it = closePayerAdapter.getItems().iterator();
            while (it.hasNext()) {
                it.next().scheduleImpl = z;
            }
            closePayerAdapter.notifyDataSetChanged();
        } else {
            this.cbCloseAllPayer.setChecked(BuiltInFictitiousFunctionClassFactory());
            this.MyBillsEntityDataFactory = false;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(PlaceComponentResult());
    }
}

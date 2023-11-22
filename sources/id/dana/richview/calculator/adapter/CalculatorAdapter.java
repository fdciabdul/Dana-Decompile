package id.dana.richview.calculator.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.richview.calculator.CalculatorPadItemListener;
import id.dana.richview.calculator.model.CalculatorItemModel;

/* loaded from: classes5.dex */
public class CalculatorAdapter extends BaseRecyclerViewAdapter<CalculatorViewHolder, CalculatorItemModel> {
    private CalculatorPadItemListener BuiltInFictitiousFunctionClassFactory;
    private int getAuthRequestContext;

    /* loaded from: classes9.dex */
    public class CalculatorViewHolder_ViewBinding implements Unbinder {
        private CalculatorViewHolder getAuthRequestContext;

        public CalculatorViewHolder_ViewBinding(CalculatorViewHolder calculatorViewHolder, View view) {
            this.getAuthRequestContext = calculatorViewHolder;
            calculatorViewHolder.ivOperand = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_opreand, "field 'ivOperand'", ImageView.class);
            calculatorViewHolder.ivOperandNumber = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_operand_number, "field 'ivOperandNumber'", ImageView.class);
            calculatorViewHolder.rlNumberOperand = (RelativeLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.rl_number_operand, "field 'rlNumberOperand'", RelativeLayout.class);
            calculatorViewHolder.rlOperand = (RelativeLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.rl_operand, "field 'rlOperand'", RelativeLayout.class);
            calculatorViewHolder.tvNumberLeft = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_number_left, "field 'tvNumberLeft'", TextView.class);
            calculatorViewHolder.tvNumberMiddle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_number_middle, "field 'tvNumberMiddle'", TextView.class);
            calculatorViewHolder.tvNumberRight = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_number_right, "field 'tvNumberRight'", TextView.class);
            calculatorViewHolder.llItemCalculator = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ll_item_calculator, "field 'llItemCalculator'", LinearLayout.class);
        }

        @Override // butterknife.Unbinder
        public final void getAuthRequestContext() {
            CalculatorViewHolder calculatorViewHolder = this.getAuthRequestContext;
            if (calculatorViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.getAuthRequestContext = null;
            calculatorViewHolder.ivOperand = null;
            calculatorViewHolder.ivOperandNumber = null;
            calculatorViewHolder.rlNumberOperand = null;
            calculatorViewHolder.rlOperand = null;
            calculatorViewHolder.tvNumberLeft = null;
            calculatorViewHolder.tvNumberMiddle = null;
            calculatorViewHolder.tvNumberRight = null;
            calculatorViewHolder.llItemCalculator = null;
        }
    }

    public CalculatorAdapter(CalculatorPadItemListener calculatorPadItemListener, int i) {
        this.BuiltInFictitiousFunctionClassFactory = calculatorPadItemListener;
        this.getAuthRequestContext = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes5.dex */
    public static class CalculatorViewHolder extends BaseRecyclerViewHolder<CalculatorItemModel> {
        CalculatorPadItemListener BuiltInFictitiousFunctionClassFactory;
        private Context KClassImpl$Data$declaredNonStaticMembers$2;
        CalculatorItemModel PlaceComponentResult;
        @BindView(R.id.iv_opreand)
        ImageView ivOperand;
        @BindView(R.id.iv_operand_number)
        ImageView ivOperandNumber;
        @BindView(R.id.ll_item_calculator)
        LinearLayout llItemCalculator;
        @BindView(R.id.rl_number_operand)
        RelativeLayout rlNumberOperand;
        @BindView(R.id.rl_operand)
        RelativeLayout rlOperand;
        @BindView(R.id.tv_number_left)
        TextView tvNumberLeft;
        @BindView(R.id.tv_number_middle)
        TextView tvNumberMiddle;
        @BindView(R.id.tv_number_right)
        TextView tvNumberRight;

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x00dc, code lost:
        
            if (r7.equals(id.dana.richview.calculator.OperandType.DIVIDER) != false) goto L22;
         */
        @Override // id.dana.base.BaseRecyclerViewHolder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public /* synthetic */ void bindData(id.dana.richview.calculator.model.CalculatorItemModel r7) {
            /*
                Method dump skipped, instructions count: 500
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.calculator.adapter.CalculatorAdapter.CalculatorViewHolder.bindData(java.lang.Object):void");
        }

        CalculatorViewHolder(Context context, ViewGroup viewGroup, CalculatorPadItemListener calculatorPadItemListener, int i) {
            super(context, R.layout.view_item_calculator, viewGroup);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
            this.BuiltInFictitiousFunctionClassFactory = calculatorPadItemListener;
            this.llItemCalculator.setPadding(0, 0, 0, (int) getContext().getResources().getDimension(i));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ boolean MyBillsEntityDataFactory() {
            this.BuiltInFictitiousFunctionClassFactory.onClearAll();
            return true;
        }

        private boolean BuiltInFictitiousFunctionClassFactory() {
            return this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.get(2).equals("99");
        }

        private void PlaceComponentResult(String str, String str2, String str3, String str4) {
            this.tvNumberLeft.setContentDescription(str);
            this.tvNumberMiddle.setContentDescription(str2);
            this.tvNumberRight.setContentDescription(str3);
            this.rlOperand.setContentDescription(str4);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new CalculatorViewHolder(viewGroup.getContext(), viewGroup, this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext);
    }
}

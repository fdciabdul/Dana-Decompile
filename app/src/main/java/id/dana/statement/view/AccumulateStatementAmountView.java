package id.dana.statement.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.domain.statement.StatementType;
import id.dana.statement.StatementMenuListener;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\b¢\u0006\u0004\b!\u0010\"B+\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010 \u001a\u00020\b\u0012\u0006\u0010#\u001a\u00020\b¢\u0006\u0004\b!\u0010$J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\u0007J\u0015\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0012\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0004R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/statement/view/AccumulateStatementAmountView;", "Lid/dana/base/BaseRichView;", "", "disableClickOptionStatementMenu", "()V", "", "getActiveTabMenu", "()Ljava/lang/String;", "", "getLayout", "()I", "getTotalExpense", "getTotalIncome", "type", "selectTransactionHistory", "(Ljava/lang/String;)V", "amount", "setTotalExpense", "setTotalIncome", "setup", "Lid/dana/statement/StatementMenuListener;", "MyBillsEntityDataFactory", "Lid/dana/statement/StatementMenuListener;", "getStatementMenuListener", "()Lid/dana/statement/StatementMenuListener;", "setStatementMenuListener", "(Lid/dana/statement/StatementMenuListener;)V", "statementMenuListener", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AccumulateStatementAmountView extends BaseRichView {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private StatementMenuListener statementMenuListener;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AccumulateStatementAmountView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AccumulateStatementAmountView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_accumulate_statement_amount;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccumulateStatementAmountView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ AccumulateStatementAmountView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccumulateStatementAmountView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @JvmName(name = "getStatementMenuListener")
    public final StatementMenuListener getStatementMenuListener() {
        return this.statementMenuListener;
    }

    @JvmName(name = "setStatementMenuListener")
    public final void setStatementMenuListener(StatementMenuListener statementMenuListener) {
        this.statementMenuListener = statementMenuListener;
    }

    public final void selectTransactionHistory(String type) {
        Intrinsics.checkNotNullParameter(type, "");
        if (!Intrinsics.areEqual(type, "income")) {
            if (Intrinsics.areEqual(type, "expense")) {
                if (!((ConstraintLayout) _$_findCachedViewById(R.id.cl_accumulate_expense)).isActivated()) {
                    ((ImageView) _$_findCachedViewById(R.id.iv_pointer_expense)).setVisibility(0);
                    ((ImageView) _$_findCachedViewById(R.id.res_0x7f0a0bde_r8_lambda_qmd_ir_afovxaesfbnmn85qfjbe)).setVisibility(8);
                    ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a03f6_cachebuilderspec_accessdurationparser);
                    constraintLayout.setActivated(false);
                    constraintLayout.setClickable(true);
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(R.id.cl_accumulate_expense);
                    constraintLayout2.setActivated(true);
                    constraintLayout2.setClickable(false);
                }
                StatementMenuListener statementMenuListener = this.statementMenuListener;
                if (statementMenuListener != null) {
                    statementMenuListener.BuiltInFictitiousFunctionClassFactory();
                    return;
                }
                return;
            }
            return;
        }
        if (!((ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a03f6_cachebuilderspec_accessdurationparser)).isActivated()) {
            ((ImageView) _$_findCachedViewById(R.id.res_0x7f0a0bde_r8_lambda_qmd_ir_afovxaesfbnmn85qfjbe)).setVisibility(0);
            ((ImageView) _$_findCachedViewById(R.id.iv_pointer_expense)).setVisibility(8);
            ConstraintLayout constraintLayout3 = (ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a03f6_cachebuilderspec_accessdurationparser);
            constraintLayout3.setActivated(true);
            constraintLayout3.setClickable(false);
            ConstraintLayout constraintLayout4 = (ConstraintLayout) _$_findCachedViewById(R.id.cl_accumulate_expense);
            constraintLayout4.setActivated(false);
            constraintLayout4.setClickable(true);
        }
        StatementMenuListener statementMenuListener2 = this.statementMenuListener;
        if (statementMenuListener2 != null) {
            statementMenuListener2.getAuthRequestContext();
        }
    }

    public final String getActiveTabMenu() {
        return ((ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a03f6_cachebuilderspec_accessdurationparser)).isActivated() ? StatementType.INCOME.name() : StatementType.EXPENSE.name();
    }

    public final void disableClickOptionStatementMenu() {
        ((ImageView) _$_findCachedViewById(R.id.res_0x7f0a0bde_r8_lambda_qmd_ir_afovxaesfbnmn85qfjbe)).setVisibility(8);
        ((ImageView) _$_findCachedViewById(R.id.iv_pointer_expense)).setVisibility(8);
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a03f6_cachebuilderspec_accessdurationparser);
        constraintLayout.setActivated(false);
        constraintLayout.setClickable(false);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(R.id.cl_accumulate_expense);
        constraintLayout2.setActivated(false);
        constraintLayout2.setClickable(false);
    }

    public final void setTotalIncome(String amount) {
        ((TextView) _$_findCachedViewById(R.id.tv_income_amount)).setText(amount);
    }

    public final void setTotalExpense(String amount) {
        ((TextView) _$_findCachedViewById(R.id.tv_expense_amount)).setText(amount);
    }

    public final String getTotalIncome() {
        CharSequence text = ((TextView) _$_findCachedViewById(R.id.tv_income_amount)).getText();
        if (text != null) {
            return (String) text;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final String getTotalExpense() {
        CharSequence text = ((TextView) _$_findCachedViewById(R.id.tv_expense_amount)).getText();
        if (text != null) {
            return (String) text;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    /* renamed from: $r8$lambda$7mvJh-bzCw_xTKCJDG-U-FoKqX0  reason: not valid java name */
    public static /* synthetic */ void m2982$r8$lambda$7mvJhbzCw_xTKCJDGUFoKqX0(AccumulateStatementAmountView accumulateStatementAmountView, View view) {
        Intrinsics.checkNotNullParameter(accumulateStatementAmountView, "");
        accumulateStatementAmountView.selectTransactionHistory("income");
    }

    public static /* synthetic */ void $r8$lambda$mt2zMjgabZwIxOgcOqYyjJNYNy8(AccumulateStatementAmountView accumulateStatementAmountView, View view) {
        Intrinsics.checkNotNullParameter(accumulateStatementAmountView, "");
        accumulateStatementAmountView.selectTransactionHistory("expense");
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        ((ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a03f6_cachebuilderspec_accessdurationparser)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.statement.view.AccumulateStatementAmountView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccumulateStatementAmountView.m2982$r8$lambda$7mvJhbzCw_xTKCJDGUFoKqX0(AccumulateStatementAmountView.this, view);
            }
        });
        ((ConstraintLayout) _$_findCachedViewById(R.id.cl_accumulate_expense)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.statement.view.AccumulateStatementAmountView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccumulateStatementAmountView.$r8$lambda$mt2zMjgabZwIxOgcOqYyjJNYNy8(AccumulateStatementAmountView.this, view);
            }
        });
    }
}

package id.dana.statement.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.common.DividerItemDecoration;
import id.dana.statement.adapter.TransactionStatementAdapter;
import id.dana.statement.model.UserStatementModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015B+\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/statement/view/TransactionStatementView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "Lid/dana/statement/model/UserStatementModel;", "userStatement", "", "setStatementTransaction", "(Lid/dana/statement/model/UserStatementModel;)V", "setup", "()V", "Lid/dana/statement/adapter/TransactionStatementAdapter;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/statement/adapter/TransactionStatementAdapter;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransactionStatementView extends BaseRichView {
    private TransactionStatementAdapter BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TransactionStatementView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TransactionStatementView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_statement_transaction;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransactionStatementView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ TransactionStatementView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransactionStatementView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public final void setStatementTransaction(UserStatementModel userStatement) {
        TransactionStatementAdapter transactionStatementAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (transactionStatementAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            transactionStatementAdapter = null;
        }
        transactionStatementAdapter.setItems(userStatement != null ? userStatement.MyBillsEntityDataFactory : null);
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        this.BuiltInFictitiousFunctionClassFactory = new TransactionStatementAdapter();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rv_statement_transaction);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), R.dimen.MyBillsEntityDataFactory_res_0x7f07005f));
        recyclerView.setHasFixedSize(true);
        TransactionStatementAdapter transactionStatementAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (transactionStatementAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            transactionStatementAdapter = null;
        }
        recyclerView.setAdapter(transactionStatementAdapter);
    }
}

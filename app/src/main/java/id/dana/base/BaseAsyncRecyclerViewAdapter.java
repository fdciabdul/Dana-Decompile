package id.dana.base;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseAsyncRecyclerViewHolder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes4.dex */
public abstract class BaseAsyncRecyclerViewAdapter<V extends BaseAsyncRecyclerViewHolder<T>, T> extends RecyclerView.Adapter<V> {
    final RecyclerView BuiltInFictitiousFunctionClassFactory;
    public BaseAsyncRecyclerViewHolder.OnItemClickListener KClassImpl$Data$declaredNonStaticMembers$2;
    public List<T> MyBillsEntityDataFactory = new ArrayList();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        final BaseAsyncRecyclerViewHolder baseAsyncRecyclerViewHolder = (BaseAsyncRecyclerViewHolder) viewHolder;
        ((BaseAsyncView) baseAsyncRecyclerViewHolder.itemView).bindWhenInflated(new Function1() { // from class: id.dana.base.BaseAsyncRecyclerViewAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                BaseAsyncRecyclerViewAdapter baseAsyncRecyclerViewAdapter = BaseAsyncRecyclerViewAdapter.this;
                BaseAsyncRecyclerViewHolder baseAsyncRecyclerViewHolder2 = baseAsyncRecyclerViewHolder;
                int i2 = i;
                BaseAsyncView baseAsyncView = (BaseAsyncView) obj;
                ViewGroup.LayoutParams layoutParams = baseAsyncRecyclerViewAdapter.BuiltInFictitiousFunctionClassFactory.getLayoutParams();
                layoutParams.width = baseAsyncRecyclerViewAdapter.BuiltInFictitiousFunctionClassFactory.getWidth();
                layoutParams.height = -2;
                baseAsyncRecyclerViewAdapter.BuiltInFictitiousFunctionClassFactory.setLayoutParams(layoutParams);
                baseAsyncRecyclerViewHolder2.MyBillsEntityDataFactory(baseAsyncRecyclerViewAdapter.KClassImpl$Data$declaredNonStaticMembers$2(i2));
                return Unit.INSTANCE;
            }
        });
        BaseAsyncRecyclerViewHolder.OnItemClickListener onItemClickListener = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (onItemClickListener != null) {
            baseAsyncRecyclerViewHolder.itemView.setOnClickListener(new BaseAsyncRecyclerViewHolder$$ExternalSyntheticLambda0(baseAsyncRecyclerViewHolder, onItemClickListener));
        }
    }

    public BaseAsyncRecyclerViewAdapter(RecyclerView recyclerView) {
        this.BuiltInFictitiousFunctionClassFactory = recyclerView;
    }

    public void getAuthRequestContext(List<T> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.MyBillsEntityDataFactory = list;
        notifyDataSetChanged();
    }

    public final T KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        if (i >= 0) {
            List<T> list = this.MyBillsEntityDataFactory;
            if (i < (list == null ? 0 : list.size())) {
                return this.MyBillsEntityDataFactory.get(i);
            }
            return null;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getGetAuthRequestContext() {
        List<T> list = this.MyBillsEntityDataFactory;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}

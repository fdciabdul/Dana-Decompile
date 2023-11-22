package id.dana.base;

import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewHolder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseRecyclerViewAdapter<V extends BaseRecyclerViewHolder<T>, T> extends RecyclerView.Adapter<V> {
    private List<T> items = new ArrayList();
    private BaseRecyclerViewHolder.OnItemClickListener onItemClickListener;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((BaseRecyclerViewAdapter<V, T>) ((BaseRecyclerViewHolder) viewHolder), i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        onViewRecycled((BaseRecyclerViewAdapter<V, T>) ((BaseRecyclerViewHolder) viewHolder));
    }

    public void onBindViewHolder(V v, int i) {
        v.bindData(getItem(i));
        v.setOnItemClickListener(getOnItemClickListener());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getItemsSize();
    }

    public void onViewRecycled(V v) {
        v.dispose();
    }

    public T getItem(int i) {
        if (i < 0 || i >= getItemsSize()) {
            return null;
        }
        return this.items.get(i);
    }

    public BaseRecyclerViewHolder.OnItemClickListener getOnItemClickListener() {
        return this.onItemClickListener;
    }

    private int getItemsSize() {
        List<T> list = this.items;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void removeItem(int i) {
        List<T> list = this.items;
        if (list == null || i < 0 || list.size() <= i) {
            return;
        }
        this.items.remove(i);
        notifyItemRemoved(i);
    }

    public void removeItemEquals(T t) {
        List<T> list = this.items;
        if (list == null || list.isEmpty() || t == null) {
            return;
        }
        Iterator<T> it = this.items.iterator();
        while (it.hasNext()) {
            if (t.equals(it.next())) {
                it.remove();
            }
        }
        notifyDataSetChanged();
    }

    public void removeAllItems() {
        List<T> list = this.items;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.items.clear();
        notifyDataSetChanged();
    }

    public void appendItems(List<T> list) {
        if (list == null) {
            return;
        }
        List<T> list2 = this.items;
        if (list2 == null) {
            setItems(list);
        } else {
            list2.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void appendItem(T t) {
        List<T> list;
        if (t == null || (list = this.items) == null) {
            return;
        }
        list.add(t);
        notifyItemChanged(this.items.size());
    }

    public void appendItem(int i, T t) {
        List<T> list;
        if (t == null || i < 0 || (list = this.items) == null) {
            return;
        }
        list.add(i, t);
        notifyItemChanged(this.items.size());
    }

    public void prependItem(T t) {
        if (t == null) {
            return;
        }
        if (this.items == null) {
            this.items = new ArrayList();
        }
        this.items.add(0, t);
        notifyItemInserted(0);
    }

    public void prependItems(List<T> list) {
        addItemsAt(0, list);
    }

    public void addItemsAt(int i, List<T> list) {
        if (list == null || i < 0) {
            return;
        }
        List<T> list2 = this.items;
        if (list2 == null) {
            setItems(list);
        } else {
            list2.addAll(i, list);
        }
        notifyItemInserted(i);
    }

    public List<T> getItems() {
        return this.items;
    }

    public void setItems(List<T> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.items = list;
        notifyDataSetChanged();
    }
}

package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

/* loaded from: classes3.dex */
public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    public final AsyncListDiffer<T> BuiltInFictitiousFunctionClassFactory;
    private final AsyncListDiffer.ListListener<T> PlaceComponentResult;

    public ListAdapter(DiffUtil.ItemCallback<T> itemCallback) {
        AsyncListDiffer.ListListener<T> listListener = new AsyncListDiffer.ListListener<T>() { // from class: androidx.recyclerview.widget.ListAdapter.1
        };
        this.PlaceComponentResult = listListener;
        AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>(new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(itemCallback).PlaceComponentResult());
        this.BuiltInFictitiousFunctionClassFactory = asyncListDiffer;
        asyncListDiffer.KClassImpl$Data$declaredNonStaticMembers$2.add(listListener);
    }

    public ListAdapter(AsyncDifferConfig<T> asyncDifferConfig) {
        AsyncListDiffer.ListListener<T> listListener = new AsyncListDiffer.ListListener<T>() { // from class: androidx.recyclerview.widget.ListAdapter.1
        };
        this.PlaceComponentResult = listListener;
        AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>(new AdapterListUpdateCallback(this), asyncDifferConfig);
        this.BuiltInFictitiousFunctionClassFactory = asyncListDiffer;
        asyncListDiffer.KClassImpl$Data$declaredNonStaticMembers$2.add(listListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPlaceComponentResult() {
        return this.BuiltInFictitiousFunctionClassFactory.moveToNextValue.size();
    }
}

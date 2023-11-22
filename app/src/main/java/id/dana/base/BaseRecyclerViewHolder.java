package id.dana.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/* loaded from: classes4.dex */
public abstract class BaseRecyclerViewHolder<T> extends RecyclerView.ViewHolder implements DisposableHandler {
    private final Context context;
    private CompositeDisposable disposables;
    private final View view;

    /* loaded from: classes4.dex */
    public interface OnItemClickListener {
        void onItemClick(int i);
    }

    public void bindData(T t) {
    }

    public BaseRecyclerViewHolder(Context context, int i, ViewGroup viewGroup) {
        this(context, LayoutInflater.from(context).inflate(i, viewGroup, false));
    }

    public BaseRecyclerViewHolder(Context context, View view) {
        super(view);
        ButterKnife.BuiltInFictitiousFunctionClassFactory(this, view);
        this.context = context;
        this.view = view;
    }

    public void setOnItemClickListener(final OnItemClickListener onItemClickListener) {
        View view = this.view;
        if (view == null || onItemClickListener == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: id.dana.base.BaseRecyclerViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseRecyclerViewHolder.this.m430x5048267f(onItemClickListener, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setOnItemClickListener$0$id-dana-base-BaseRecyclerViewHolder  reason: not valid java name */
    public /* synthetic */ void m430x5048267f(OnItemClickListener onItemClickListener, View view) {
        if (getAbsoluteAdapterPosition() >= 0) {
            onItemClickListener.onItemClick(getAbsoluteAdapterPosition());
        }
    }

    public Context getContext() {
        return this.context;
    }

    public void addDisposable(Disposable disposable) {
        if (this.disposables == null) {
            this.disposables = new CompositeDisposable();
        }
        this.disposables.getAuthRequestContext(disposable);
    }

    public void dispose() {
        CompositeDisposable compositeDisposable = this.disposables;
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            return;
        }
        this.disposables.dispose();
    }
}

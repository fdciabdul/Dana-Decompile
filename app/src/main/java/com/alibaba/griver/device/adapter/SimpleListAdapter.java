package com.alibaba.griver.device.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.griver.device.R;
import java.util.List;

/* loaded from: classes6.dex */
public class SimpleListAdapter extends RecyclerView.Adapter<SimpleViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f6505a;
    private List<String> b;
    private OnItemClickListener c;

    /* loaded from: classes6.dex */
    public interface OnItemClickListener {
        void onItemClick(int i);
    }

    public SimpleListAdapter(Context context, List<String> list) {
        this.f6505a = context;
        this.b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SimpleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new SimpleViewHolder(LayoutInflater.from(this.f6505a).inflate(R.layout.griver_device_item_simple_text, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SimpleViewHolder simpleViewHolder, int i) {
        simpleViewHolder.a(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.c = onItemClickListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class SimpleViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private TextView f6506a;

        public SimpleViewHolder(View view) {
            super(view);
            this.f6506a = (TextView) view.findViewById(R.id.tv_content);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(final int i) {
            this.f6506a.setText((CharSequence) SimpleListAdapter.this.b.get(i));
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.device.adapter.SimpleListAdapter.SimpleViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SimpleListAdapter.this.c != null) {
                        SimpleListAdapter.this.c.onItemClick(i);
                    }
                }
            });
        }
    }
}

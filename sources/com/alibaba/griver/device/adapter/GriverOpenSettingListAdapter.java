package com.alibaba.griver.device.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.griver.device.R;
import com.alibaba.griver.device.model.OpenSettingItem;
import java.util.List;

/* loaded from: classes6.dex */
public class GriverOpenSettingListAdapter extends RecyclerView.Adapter<OpenSettingViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f6503a;
    private List<OpenSettingItem> b;
    private OnSettingChangeListener c;

    /* loaded from: classes6.dex */
    public interface OnSettingChangeListener {
        void onChange(int i, boolean z);
    }

    public GriverOpenSettingListAdapter(Context context, List<OpenSettingItem> list) {
        this.f6503a = context;
        this.b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public OpenSettingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new OpenSettingViewHolder(LayoutInflater.from(this.f6503a).inflate(R.layout.griver_device_item_open_setting, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(OpenSettingViewHolder openSettingViewHolder, int i) {
        openSettingViewHolder.bindData(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    public void setOnSettingChangeListener(OnSettingChangeListener onSettingChangeListener) {
        this.c = onSettingChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class OpenSettingViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private TextView f6504a;
        private Switch b;

        public OpenSettingViewHolder(View view) {
            super(view);
            this.f6504a = (TextView) view.findViewById(R.id.tv_griver_setting_title);
            this.b = (Switch) view.findViewById(R.id.switch_griver_setting);
        }

        public void bindData(final int i) {
            final OpenSettingItem openSettingItem = (OpenSettingItem) GriverOpenSettingListAdapter.this.b.get(i);
            this.f6504a.setText(openSettingItem.displayName);
            this.b.setChecked(openSettingItem.enabled);
            this.b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.alibaba.griver.device.adapter.GriverOpenSettingListAdapter.OpenSettingViewHolder.1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    openSettingItem.enabled = z;
                    if (GriverOpenSettingListAdapter.this.c != null) {
                        GriverOpenSettingListAdapter.this.c.onChange(i, z);
                    }
                }
            });
        }
    }
}

package com.alibaba.griver.core.jsapi.share.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.griver.api.ui.share.BaseShareItem;
import com.alibaba.griver.base.common.adapter.ImageListener;
import com.alibaba.griver.base.common.utils.ImageUtils;
import com.alibaba.griver.core.R;
import com.alibaba.griver.ui.ant.api.OnItemClickListener;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.List;

/* loaded from: classes6.dex */
public class ShareRecyclerAdapter extends RecyclerView.Adapter<ShareViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f6418a;
    private List<BaseShareItem> b;
    private OnItemClickListener c;

    public ShareRecyclerAdapter(Context context, List<BaseShareItem> list) {
        this.f6418a = context;
        this.b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ShareViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ShareViewHolder(LayoutInflater.from(this.f6418a).inflate(R.layout.griver_core_layout_share_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ShareViewHolder shareViewHolder, int i) {
        shareViewHolder.a(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPlaceComponentResult() {
        return this.b.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.c = onItemClickListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ShareViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private TextView f6419a;
        private ImageView b;

        public ShareViewHolder(View view) {
            super(view);
            this.f6419a = (TextView) view.findViewById(R.id.tv_title);
            this.b = (ImageView) view.findViewById(R.id.iv_channel);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(final int i) {
            BaseShareItem baseShareItem = (BaseShareItem) ShareRecyclerAdapter.this.b.get(i);
            this.f6419a.setText(baseShareItem.channelName);
            if (baseShareItem.iconDrawable != 0) {
                this.b.setImageDrawable(InstrumentInjector.Resources_getDrawable(ShareRecyclerAdapter.this.f6418a.getResources(), baseShareItem.iconDrawable));
            } else {
                ImageUtils.loadImage(baseShareItem.iconUrl, new ImageListener() { // from class: com.alibaba.griver.core.jsapi.share.ui.ShareRecyclerAdapter.ShareViewHolder.1
                    @Override // com.alibaba.griver.base.common.adapter.ImageListener
                    public void onImage(Bitmap bitmap) {
                        ShareViewHolder.this.b.setImageBitmap(bitmap);
                    }
                });
            }
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.core.jsapi.share.ui.ShareRecyclerAdapter.ShareViewHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ShareRecyclerAdapter.this.c != null) {
                        ShareRecyclerAdapter.this.c.onClick(view, i);
                    }
                }
            });
        }
    }
}

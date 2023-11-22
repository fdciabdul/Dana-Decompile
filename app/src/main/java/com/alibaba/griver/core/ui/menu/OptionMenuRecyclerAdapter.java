package com.alibaba.griver.core.ui.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.api.common.menu.GRVMPMoreMenuItem;
import com.alibaba.griver.api.common.menu.GriverMenuItem;
import com.alibaba.griver.base.common.utils.ImageUtils;
import com.alibaba.griver.core.R;
import com.alibaba.griver.ui.ant.api.OnItemClickListener;
import com.alibaba.griver.ui.reddot.OnStateChangeListener;
import com.alibaba.griver.ui.reddot.RedDotDrawable;
import com.alibaba.griver.ui.reddot.RedDotManager;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.List;

/* loaded from: classes6.dex */
public class OptionMenuRecyclerAdapter extends RecyclerView.Adapter<OptionMenuViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f6470a;
    private List<GriverMenuItem> b;
    private OnItemClickListener c;
    private String d;

    public OptionMenuRecyclerAdapter(Context context, String str, List<GriverMenuItem> list) {
        this.f6470a = context.getApplicationContext();
        this.b = list;
        this.d = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public OptionMenuViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new OptionMenuViewHolder(LayoutInflater.from(this.f6470a).inflate(R.layout.griver_core_item_option_menu, viewGroup, false), this.d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(OptionMenuViewHolder optionMenuViewHolder, int i) {
        optionMenuViewHolder.a(i);
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
    public class OptionMenuViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private TextView f6471a;
        private ImageView b;
        private LinearLayout c;
        private String d;

        public OptionMenuViewHolder(View view, String str) {
            super(view);
            this.f6471a = (TextView) view.findViewById(R.id.tv_title);
            this.b = (ImageView) view.findViewById(R.id.iv_icon);
            this.c = (LinearLayout) view.findViewById(R.id.content_layout);
            RedDotDrawable.wrap(this.b, view.getContext().getResources().getDimensionPixelOffset(R.dimen.griver_AU_REDDOTSIZE5), view.getContext().getResources().getDimensionPixelOffset(R.dimen.griver_AU_REDDOT_DX), view.getContext().getResources().getDimensionPixelOffset(R.dimen.griver_AU_REDDOT_DY), -65536);
            this.d = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(final int i) {
            GriverMenuItem griverMenuItem = (GriverMenuItem) OptionMenuRecyclerAdapter.this.b.get(i);
            this.f6471a.setText(griverMenuItem.name);
            if (!TextUtils.isEmpty(griverMenuItem.iconUrl)) {
                Drawable drawable = null;
                try {
                    drawable = InstrumentInjector.Resources_getDrawable(OptionMenuRecyclerAdapter.this.f6470a.getResources(), griverMenuItem.iconDrawable);
                } catch (Resources.NotFoundException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("OptionMenuViewHolder#bind, error: ");
                    sb.append(e);
                    RVLogger.d("OptionMenuViewHolder", sb.toString());
                }
                ImageUtils.loadImage(this.b, drawable, griverMenuItem.iconUrl);
            } else {
                this.b.setImageDrawable(InstrumentInjector.Resources_getDrawable(OptionMenuRecyclerAdapter.this.f6470a.getResources(), griverMenuItem.iconDrawable));
            }
            this.c.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.core.ui.menu.OptionMenuRecyclerAdapter.OptionMenuViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (OptionMenuRecyclerAdapter.this.c != null) {
                        OptionMenuRecyclerAdapter.this.c.onClick(view, i);
                    }
                }
            });
            if (griverMenuItem instanceof GRVMPMoreMenuItem) {
                GRVMPMoreMenuItem gRVMPMoreMenuItem = (GRVMPMoreMenuItem) griverMenuItem;
                if (gRVMPMoreMenuItem.isShowBadge()) {
                    RedDotManager.getInstance().setStateDidChangeHandler(gRVMPMoreMenuItem.uniqueKey, new OnStateChangeListener() { // from class: com.alibaba.griver.core.ui.menu.OptionMenuRecyclerAdapter.OptionMenuViewHolder.2
                        @Override // com.alibaba.griver.ui.reddot.OnStateChangeListener
                        public void onStateChange(String str, boolean z) {
                            if (OptionMenuViewHolder.this.b != null) {
                                RedDotDrawable.showRedPoint(OptionMenuViewHolder.this.b, z);
                            }
                        }
                    });
                    RedDotDrawable.showRedPoint(this.b, gRVMPMoreMenuItem.showBadge);
                }
            }
        }
    }
}

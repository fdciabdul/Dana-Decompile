package com.alibaba.griver.core.jsapi.actionsheet;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.core.R;
import com.alibaba.griver.core.jsapi.actionsheet.ActionSheetItem;
import java.util.List;

/* loaded from: classes2.dex */
public class ActionSheetRecyclerAdapter extends RecyclerView.Adapter<ActionSheetViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f6411a;
    private List<ActionSheetItem> b;
    private OnItemClickListener c;

    /* loaded from: classes6.dex */
    interface OnItemClickListener {
        void onClick(int i);
    }

    public ActionSheetRecyclerAdapter(Context context, List<ActionSheetItem> list) {
        this.f6411a = context;
        this.b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ActionSheetViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ActionSheetViewHolder(LayoutInflater.from(this.f6411a).inflate(R.layout.griver_core_layout_actionsheet_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ActionSheetViewHolder actionSheetViewHolder, int i) {
        actionSheetViewHolder.a(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPlaceComponentResult() {
        return this.b.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ActionSheetViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private TextView f6412a;
        private TextView b;
        private TextView c;

        public ActionSheetViewHolder(View view) {
            super(view);
            this.f6412a = (TextView) view.findViewById(R.id.tv_content);
            this.b = (TextView) view.findViewById(R.id.tv_badge);
            this.c = (TextView) view.findViewById(R.id.tv_badge_point);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(final int i) {
            ActionSheetItem actionSheetItem = (ActionSheetItem) ActionSheetRecyclerAdapter.this.b.get(i);
            this.f6412a.setText(actionSheetItem.content);
            ActionSheetItem.BadgeInfo badgeInfo = actionSheetItem.badgeInfo;
            if (badgeInfo != null) {
                if (TextUtils.equals(ActionSheetItem.BadgeInfo.TYPE_MORE, badgeInfo.type)) {
                    b();
                    this.b.setText("...");
                } else if (TextUtils.equals("none", badgeInfo.type)) {
                    c();
                } else if (TextUtils.equals(ActionSheetItem.BadgeInfo.TYPE_NUM, badgeInfo.type)) {
                    try {
                        int parseInt = Integer.parseInt(badgeInfo.text);
                        if (parseInt <= 0) {
                            c();
                        } else if (parseInt >= 100) {
                            b();
                            this.b.setText("...");
                        } else {
                            b();
                            this.b.setText(badgeInfo.text);
                        }
                    } catch (Exception e) {
                        GriverLogger.e("ActionSheetRecyclerAdapter", "wrong number text", e);
                    }
                } else if (TextUtils.equals("text", badgeInfo.type)) {
                    this.b.setText(badgeInfo.text);
                    b();
                } else if (TextUtils.equals("point", badgeInfo.type)) {
                    a();
                }
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.core.jsapi.actionsheet.ActionSheetRecyclerAdapter.ActionSheetViewHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ActionSheetRecyclerAdapter.this.c != null) {
                            ActionSheetRecyclerAdapter.this.c.onClick(i);
                        }
                    }
                });
            }
            c();
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.core.jsapi.actionsheet.ActionSheetRecyclerAdapter.ActionSheetViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ActionSheetRecyclerAdapter.this.c != null) {
                        ActionSheetRecyclerAdapter.this.c.onClick(i);
                    }
                }
            });
        }

        private void a() {
            this.c.setVisibility(0);
            this.b.setVisibility(8);
        }

        private void b() {
            this.c.setVisibility(8);
            this.b.setVisibility(0);
        }

        private void c() {
            this.c.setVisibility(8);
            this.b.setVisibility(8);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.c = onItemClickListener;
    }
}

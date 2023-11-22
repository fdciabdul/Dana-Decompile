package com.alipay.mobile.beehive.poiselect.adapter;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.alibaba.ariver.kernel.common.utils.StringUtils;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.map.R;
import com.alibaba.griver.ui.ant.AUImageView;
import com.alibaba.griver.ui.ant.text.AUTextView;
import com.alipay.mobile.map.model.geocode.PoiItem;
import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* loaded from: classes6.dex */
public class PoiListAdapter extends BaseAdapter {
    private static BigDecimal f = new BigDecimal(1000);

    /* renamed from: a  reason: collision with root package name */
    private Context f7118a;
    private List<PoiItem> b;
    private int c = -1;
    private boolean d;
    private String e;
    private boolean g;
    private boolean h;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public PoiListAdapter(Context context, List<PoiItem> list, boolean z) {
        this.f7118a = context;
        this.b = list;
        this.d = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f7118a).inflate(R.layout.griver_map_list_item_location, viewGroup, false);
        }
        if (view.getTag() == null) {
            view.setTag(new ViewHolder((AUTextView) view.findViewById(R.id.poiselect_title), (AUTextView) view.findViewById(R.id.poiselect_addr), (AUImageView) view.findViewById(R.id.poiselect_selection_mark), (AUTextView) view.findViewById(R.id.poiselect_distance), (AUImageView) view.findViewById(R.id.action_phone), (AUImageView) view.findViewById(R.id.action_goto)));
        }
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        PoiItem poiItem = (PoiItem) getItem(i);
        if (!StringUtils.isEmpty(poiItem.getTitle())) {
            viewHolder.name.setText(a(poiItem.getTitle()));
            viewHolder.name.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        if (StringUtils.isEmpty(poiItem.getSnippet())) {
            viewHolder.addr.setVisibility(8);
        } else {
            viewHolder.addr.setVisibility(0);
            viewHolder.addr.setText(a(poiItem.getSnippet()));
        }
        if (!this.h || poiItem.getDistance() < 0) {
            viewHolder.distance.setVisibility(8);
        } else {
            viewHolder.distance.setVisibility(0);
            viewHolder.distance.setText((poiItem.getDistance() < 0 || poiItem.getDistance() >= 1000) ? String.format("%.1fkm", Float.valueOf(new BigDecimal(poiItem.getDistance()).divide(f, 2, 6).floatValue())) : String.format("%dm", Integer.valueOf(poiItem.getDistance())));
        }
        if (this.d) {
            if (i == this.c) {
                if (!this.g) {
                    viewHolder.selectionIcon.setVisibility(0);
                }
                viewHolder.name.setTextColor(this.f7118a.getResources().getColor(R.color.griver_AU_COLOR_LINK));
                viewHolder.addr.setTextColor(this.f7118a.getResources().getColor(R.color.griver_AU_COLOR_LINK));
                viewHolder.distance.setTextColor(this.f7118a.getResources().getColor(R.color.griver_AU_COLOR_LINK));
            } else {
                viewHolder.selectionIcon.setVisibility(8);
                viewHolder.name.setTextColor(this.f7118a.getResources().getColor(R.color.griver_map_poi_title_color));
                viewHolder.addr.setTextColor(this.f7118a.getResources().getColor(R.color.griver_map_poi_desc_color));
                viewHolder.distance.setTextColor(this.f7118a.getResources().getColor(R.color.griver_map_poi_desc_color));
            }
        }
        return view;
    }

    public void setSelection(int i) {
        this.c = i;
    }

    public int getSelection() {
        return this.c;
    }

    public String getKeyword() {
        return this.e;
    }

    private SpannableString a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        if (TextUtils.isEmpty(this.e)) {
            return spannableString;
        }
        try {
            Matcher matcher = Pattern.compile(this.e).matcher(str);
            while (matcher.find()) {
                spannableString.setSpan(new ForegroundColorSpan(this.f7118a.getResources().getColor(R.color.griver_AU_COLOR_LINK)), matcher.start(), matcher.end(), 33);
            }
        } catch (PatternSyntaxException e) {
            GriverLogger.e("poiselect", "", e);
        }
        return spannableString;
    }

    public void setKeyword(String str) {
        this.e = str;
    }

    public void setShowPoiActions(boolean z) {
        this.g = z;
    }

    public void setShowPoiDistance(boolean z) {
        this.h = z;
    }

    /* loaded from: classes6.dex */
    static class ViewHolder {
        AUTextView addr;
        AUTextView distance;
        AUImageView gotoIcon;
        AUTextView name;
        AUImageView phoneIcon;
        AUImageView selectionIcon;

        public ViewHolder(AUTextView aUTextView, AUTextView aUTextView2, AUImageView aUImageView, AUTextView aUTextView3, AUImageView aUImageView2, AUImageView aUImageView3) {
            this.name = aUTextView;
            this.addr = aUTextView2;
            this.distance = aUTextView3;
            this.selectionIcon = aUImageView;
            this.phoneIcon = aUImageView2;
            this.gotoIcon = aUImageView3;
        }
    }
}

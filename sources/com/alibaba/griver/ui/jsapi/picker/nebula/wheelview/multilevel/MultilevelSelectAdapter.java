package com.alibaba.griver.ui.jsapi.picker.nebula.wheelview.multilevel;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.ui.R;
import com.alibaba.griver.ui.ant.text.AUTextView;

/* loaded from: classes6.dex */
public class MultilevelSelectAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f6713a;
    private JSONArray b;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public MultilevelSelectAdapter(JSONArray jSONArray, Activity activity) {
        this.b = jSONArray;
        this.f6713a = activity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.getJSONObject(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f6713a).inflate(R.layout.griver_ui_single_item, viewGroup, false);
        }
        ((AUTextView) view.findViewById(R.id.griver_item_text)).setText(((JSONObject) getItem(i)).getString("name"));
        return view;
    }
}

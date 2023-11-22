package com.alipay.mobile.embedview.mapbiz.core.controller;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.griver.map.R;
import com.alibaba.griver.ui.ant.text.AUIconView;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.model.AdapterMarker;
import com.alipay.mobile.embedview.mapbiz.data.CustomCallout;
import com.alipay.mobile.embedview.mapbiz.data.Marker;
import com.alipay.mobile.embedview.mapbiz.data.RichTextInfo;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import java.util.List;

/* loaded from: classes6.dex */
public class InfoWindowAdapter extends H5MapController implements AdapterAMap.AdapterInfoWindowAdapter {
    @Override // com.alipay.mobile.apmap.AdapterAMap.AdapterInfoWindowAdapter
    public View getInfoContents(AdapterMarker adapterMarker) {
        return null;
    }

    public InfoWindowAdapter(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
    }

    private View a(AdapterMarker adapterMarker) {
        Context context;
        View inflate;
        View view = null;
        if (this.mMapContainer.is2dMapSdk() && this.mMapContainer.configController.isMapInfoWindow2DUseNull()) {
            return null;
        }
        try {
            context = this.mMapContainer.getContext();
            inflate = LayoutInflater.from(context).inflate(R.layout.griver_map_default_callout_layout, (ViewGroup) null);
        } catch (Throwable th) {
            th = th;
        }
        try {
            TextView textView = new TextView(context);
            textView.setText(adapterMarker.getTitle());
            textView.setTextColor(-16777216);
            TextView textView2 = new TextView(context);
            textView2.setTextColor(-16777216);
            textView2.setText(adapterMarker.getSnippet());
            ((LinearLayout) inflate).setOrientation(1);
            if (TextUtils.isEmpty(adapterMarker.getTitle()) && TextUtils.isEmpty(adapterMarker.getSnippet())) {
                return null;
            }
            if (!TextUtils.isEmpty(adapterMarker.getTitle())) {
                ((LinearLayout) inflate).addView(textView);
            }
            if (TextUtils.isEmpty(adapterMarker.getSnippet())) {
                return inflate;
            }
            ((LinearLayout) inflate).addView(textView2);
            return inflate;
        } catch (Throwable th2) {
            th = th2;
            view = inflate;
            this.mMapContainer.reportController.reportException("InfoWindowAdapter#getDefaultWindow", th.getMessage());
            return view;
        }
    }

    @Override // com.alipay.mobile.apmap.AdapterAMap.AdapterInfoWindowAdapter
    public View getInfoWindow(AdapterMarker adapterMarker) {
        View layoutCustomCallout;
        Context context = this.mMapContainer.getContext();
        if (context == null) {
            return null;
        }
        if (adapterMarker.getObject() == null) {
            return a(adapterMarker);
        }
        CustomCallout customCallout = ((Marker) adapterMarker.getObject()).customCallout;
        if (customCallout == null) {
            return a(adapterMarker);
        }
        if (customCallout.layout == null || (layoutCustomCallout = this.mMapContainer.layoutController.layoutCustomCallout(context, adapterMarker, customCallout)) == null) {
            LayoutInflater from = LayoutInflater.from(context);
            int i = customCallout.type;
            if (i == 0 || i == 1) {
                View inflate = from.inflate(R.layout.griver_map_custom_callout_layout, (ViewGroup) null);
                if (i == 1) {
                    a(context, inflate, customCallout.time, customCallout.descList);
                } else {
                    a(inflate, customCallout.time, customCallout.descList);
                }
                return inflate;
            } else if (i == 3) {
                View inflate2 = from.inflate(R.layout.griver_map_custom_callout_title_style_layout, (ViewGroup) null);
                TextView textView = (TextView) inflate2.findViewById(R.id.custom_callout_desc);
                SpannableStringBuilder richTextInfoString = RichTextInfo.getRichTextInfoString(customCallout.descList);
                if (TextUtils.isEmpty(richTextInfoString)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(richTextInfoString);
                }
                ((TextView) inflate2.findViewById(R.id.custom_callout_sub_desc)).setText(RichTextInfo.getRichTextInfoString(customCallout.subDescList));
                return inflate2;
            } else {
                View inflate3 = from.inflate(R.layout.griver_map_custom_callout_white_style_layout, (ViewGroup) null);
                ((TextView) inflate3.findViewById(R.id.custom_callout_desc)).setText(RichTextInfo.getRichTextInfoString(customCallout.descList));
                return inflate3;
            }
        }
        return layoutCustomCallout;
    }

    private void a(View view, String str, List<RichTextInfo> list) {
        View findViewById = view.findViewById(R.id.custom_callout_left_layout);
        View findViewById2 = view.findViewById(R.id.custom_callout_split_line);
        TextView textView = (TextView) view.findViewById(R.id.custom_callout_left_value);
        TextView textView2 = (TextView) view.findViewById(R.id.custom_callout_right_desc);
        textView.setText(str);
        textView2.setText(RichTextInfo.getRichTextInfoString(list));
        if (TextUtils.isEmpty(str)) {
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            return;
        }
        findViewById.setVisibility(0);
        findViewById2.setVisibility(0);
    }

    private void a(Context context, View view, String str, List<RichTextInfo> list) {
        view.findViewById(R.id.custom_callout_container).setBackgroundResource(R.drawable.griver_map_white_bg);
        TextView textView = (TextView) view.findViewById(R.id.custom_callout_left_value);
        TextView textView2 = (TextView) view.findViewById(R.id.custom_callout_right_desc);
        TextView textView3 = (TextView) view.findViewById(R.id.custom_callout_left_value_unit);
        ((AUIconView) view.findViewById(R.id.custom_callout_right_arrow)).setIconfontColor(context.getResources().getColor(R.color.griver_map_custom_callout_white_style_arrow_color));
        textView.setTextColor(context.getResources().getColor(R.color.griver_map_custom_callout_white_style_time_color));
        textView3.setTextColor(context.getResources().getColor(R.color.griver_map_custom_callout_white_style_time_unit_color));
        textView.setText(str);
        textView2.setText(RichTextInfo.getRichTextInfoString(list));
        View findViewById = view.findViewById(R.id.custom_callout_left_layout);
        View findViewById2 = view.findViewById(R.id.custom_callout_split_line);
        findViewById2.setBackgroundColor(context.getResources().getColor(R.color.griver_map_custom_callout_white_style_split_color));
        if (TextUtils.isEmpty(str)) {
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            return;
        }
        findViewById.setVisibility(0);
        findViewById2.setVisibility(0);
    }
}

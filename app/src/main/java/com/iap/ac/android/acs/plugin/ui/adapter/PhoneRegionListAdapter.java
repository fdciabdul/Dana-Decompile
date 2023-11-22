package com.iap.ac.android.acs.plugin.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.iap.ac.android.acs.plugin.R;
import com.iap.ac.android.acs.plugin.a.a;
import com.iap.ac.android.acs.plugin.ui.utils.UIUtils;
import com.iap.ac.android.biz.common.model.multilanguage.queryregioncode.MobilePhoneRegion;
import com.iap.ac.android.biz.common.model.multilanguage.queryregioncode.RegionsGroupByInitial;
import com.iap.ac.android.common.log.ACLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes8.dex */
public class PhoneRegionListAdapter extends BaseAdapter {
    public static final String REGION_FORMAT_RULE = "%s-%s";
    public List<MobilePhoneRegion> mBackupPhoneRegionList;
    public Context mContext;
    public boolean mIsFilter;
    public List<MobilePhoneRegion> mPhoneRegionList;
    public HashMap<Integer, String> mSectionPositionMap;

    /* loaded from: classes8.dex */
    public static class ViewHolder {
        public View divider;
        public TextView letterText;
        public TextView phonePrefixView;
        public TextView regionText;

        public ViewHolder() {
        }
    }

    public PhoneRegionListAdapter(Context context, List<RegionsGroupByInitial> list) {
        this.mContext = context;
        convertData(list);
        this.mBackupPhoneRegionList = this.mPhoneRegionList;
    }

    private void convertData(List<RegionsGroupByInitial> list) {
        this.mPhoneRegionList = new ArrayList();
        this.mSectionPositionMap = new HashMap<>();
        int i = 0;
        for (RegionsGroupByInitial regionsGroupByInitial : list) {
            if (regionsGroupByInitial == null) {
                ACLog.e("IAPConnectPlugin", "PhoneRegionListAdapter#convertData, ACCDNPhoneRegionCodeList is null");
            } else {
                List<MobilePhoneRegion> list2 = regionsGroupByInitial.mobilePhoneRegions;
                if (list2 != null && !list2.isEmpty()) {
                    this.mPhoneRegionList.addAll(regionsGroupByInitial.mobilePhoneRegions);
                    this.mSectionPositionMap.put(Integer.valueOf(i), regionsGroupByInitial.regionInitial);
                    i += regionsGroupByInitial.mobilePhoneRegions.size();
                } else {
                    ACLog.e("IAPConnectPlugin", "PhoneRegionListAdapter#convertData, phoneRegionCodeList in ACCDNPhoneRegionCodeList is null");
                }
            }
        }
    }

    private String getFormattedRegion(MobilePhoneRegion mobilePhoneRegion) {
        return String.format(REGION_FORMAT_RULE, mobilePhoneRegion.regionCode, mobilePhoneRegion.regionName);
    }

    private boolean isHideDivider(int i) {
        if (this.mIsFilter || i == this.mPhoneRegionList.size() - 1) {
            return false;
        }
        return this.mSectionPositionMap.containsKey(Integer.valueOf(i + 1));
    }

    private boolean isShowLetter(int i) {
        if (this.mIsFilter) {
            return false;
        }
        return this.mSectionPositionMap.containsKey(Integer.valueOf(i));
    }

    private void showDivider(int i, View view) {
        if (isHideDivider(i)) {
            view.setVisibility(8);
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!this.mIsFilter && i == this.mPhoneRegionList.size() - 1) {
            layoutParams.height = 1;
        } else {
            layoutParams.height = UIUtils.dp2px(this.mContext, 1);
        }
        view.setVisibility(0);
        view.setLayoutParams(layoutParams);
    }

    private void showLetter(int i, TextView textView) {
        if (isShowLetter(i)) {
            textView.setVisibility(0);
            textView.setText(this.mSectionPositionMap.get(Integer.valueOf(i)));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.iap.ac.android.acs.plugin.ui.adapter.PhoneRegionListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ACLog.d("IAPConnectPlugin", "PhoneRegionListAdapter#showLetter, letter click, do nothing");
                }
            });
            return;
        }
        textView.setVisibility(8);
    }

    public void filter(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder();
        sb.append("PhoneRegionListAdapter#filter, filter string: ");
        sb.append((Object) charSequence);
        ACLog.d("IAPConnectPlugin", sb.toString());
        if (charSequence != null && !TextUtils.isEmpty(charSequence.toString()) && !TextUtils.isEmpty(charSequence.toString().trim())) {
            Pattern compile = Pattern.compile(charSequence.toString().trim().toUpperCase(Locale.ROOT));
            ArrayList arrayList = new ArrayList();
            for (MobilePhoneRegion mobilePhoneRegion : this.mBackupPhoneRegionList) {
                if (mobilePhoneRegion == null) {
                    ACLog.e("IAPConnectPlugin", "PhoneRegionListAdapter#filter, region model is null");
                } else if (TextUtils.isEmpty(mobilePhoneRegion.regionName)) {
                    StringBuilder a2 = a.a("PhoneRegionListAdapter#filter, region name is empty, region: ");
                    a2.append(mobilePhoneRegion.regionCode);
                    a2.append(", regionName: ");
                    a2.append(mobilePhoneRegion.regionName);
                    a2.append(", mobilePhoneRegionCode: ");
                    a2.append(mobilePhoneRegion.mobilePhoneRegionCode);
                    ACLog.e("IAPConnectPlugin", a2.toString());
                } else if (compile.matcher(getFormattedRegion(mobilePhoneRegion)).find()) {
                    arrayList.add(mobilePhoneRegion);
                }
            }
            this.mPhoneRegionList = arrayList;
            this.mIsFilter = true;
        } else {
            this.mPhoneRegionList = this.mBackupPhoneRegionList;
            this.mIsFilter = false;
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mPhoneRegionList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.mPhoneRegionList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.acplugin_layout_phone_region_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.letterText = (TextView) view.findViewById(R.id.letter_text);
            viewHolder.regionText = (TextView) view.findViewById(R.id.region_text);
            viewHolder.phonePrefixView = (TextView) view.findViewById(R.id.phone_prefix_text);
            viewHolder.divider = view.findViewById(R.id.divider);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        showLetter(i, viewHolder.letterText);
        showDivider(i, viewHolder.divider);
        MobilePhoneRegion mobilePhoneRegion = this.mPhoneRegionList.get(i);
        viewHolder.regionText.setText(getFormattedRegion(mobilePhoneRegion));
        viewHolder.phonePrefixView.setText(mobilePhoneRegion.mobilePhoneRegionCode);
        return view;
    }
}

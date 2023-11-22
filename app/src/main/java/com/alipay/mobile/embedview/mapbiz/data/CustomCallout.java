package com.alipay.mobile.embedview.mapbiz.data;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes2.dex */
public class CustomCallout implements Serializable {
    public boolean canShowOnTap;
    public List<RichTextInfo> descList;
    public Layout layout;
    public LayoutFrame layoutBubble;
    public List<RichTextInfo> subDescList;
    public String time;
    public int type;
    public int isShow = 0;
    @JSONField(serialize = false)
    public boolean canShowOnLoad = true;

    public boolean equals(Object obj) {
        List<RichTextInfo> list;
        if (this == obj) {
            return true;
        }
        if (obj instanceof CustomCallout) {
            CustomCallout customCallout = (CustomCallout) obj;
            boolean z = this.type == customCallout.type && this.isShow == customCallout.isShow && TextUtils.equals(this.time, customCallout.time);
            if (z) {
                try {
                    list = this.descList;
                } catch (Exception unused) {
                }
                if ((list != null && customCallout.descList == null) || (list == null && customCallout.descList != null)) {
                    return false;
                }
                if (list != null && customCallout.descList != null && (list.size() != customCallout.descList.size() || !this.descList.equals(customCallout.descList))) {
                    return false;
                }
                List<RichTextInfo> list2 = this.subDescList;
                if ((list2 != null && customCallout.subDescList == null) || (list2 == null && customCallout.subDescList != null)) {
                    return false;
                }
                if (list2 != null && customCallout.subDescList != null) {
                    if (list2.size() != customCallout.subDescList.size()) {
                        return false;
                    }
                    if (!this.subDescList.equals(customCallout.subDescList)) {
                        return false;
                    }
                }
            }
            return z;
        }
        return false;
    }

    public boolean hasDescription() {
        if (this.layout != null) {
            return true;
        }
        SpannableStringBuilder richTextInfoString = RichTextInfo.getRichTextInfoString(this.descList);
        if (richTextInfoString == null || richTextInfoString.length() == 0) {
            SpannableStringBuilder richTextInfoString2 = RichTextInfo.getRichTextInfoString(this.subDescList);
            return (richTextInfoString2 == null || richTextInfoString2.length() == 0) ? false : true;
        }
        return true;
    }

    public int hashCode() {
        return super.hashCode();
    }
}

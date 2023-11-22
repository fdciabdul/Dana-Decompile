package com.alipay.mobile.embedview.mapbiz.data;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class RichTextInfo implements Serializable {
    public String desc;
    public String descColor;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RichTextInfo) {
            RichTextInfo richTextInfo = (RichTextInfo) obj;
            return TextUtils.equals(this.desc, richTextInfo.desc) && TextUtils.equals(this.descColor, richTextInfo.descColor);
        }
        return false;
    }

    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.desc);
        sb.append(this.descColor);
        return sb.toString().hashCode();
    }

    public static SpannableStringBuilder getRichTextInfoString(List<RichTextInfo> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        if (list != null && !list.isEmpty()) {
            StringBuilder sb = new StringBuilder("");
            ArrayList<StringInfo> arrayList = new ArrayList();
            int i = 0;
            for (RichTextInfo richTextInfo : list) {
                if (richTextInfo != null && !TextUtils.isEmpty(richTextInfo.desc)) {
                    sb.append(richTextInfo.desc);
                    int length = richTextInfo.desc.length() + i;
                    arrayList.add(StringInfo.initStringInfo(i, length, richTextInfo.descColor));
                    i = length;
                }
            }
            spannableStringBuilder.append((CharSequence) sb.toString());
            for (StringInfo stringInfo : arrayList) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(stringInfo.color), stringInfo.start, stringInfo.end, 33);
            }
        }
        return spannableStringBuilder;
    }
}

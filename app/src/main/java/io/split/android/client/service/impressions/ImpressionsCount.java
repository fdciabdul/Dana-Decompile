package io.split.android.client.service.impressions;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes6.dex */
public class ImpressionsCount {
    private static final String FIELD_PER_FEATURE_COUNTS = "pf";
    @SerializedName(FIELD_PER_FEATURE_COUNTS)
    public final List<ImpressionsCountPerFeature> perFeature;

    public ImpressionsCount(List<ImpressionsCountPerFeature> list) {
        this.perFeature = list;
    }

    public int hashCode() {
        return this.perFeature.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ArrayList<ImpressionsCountPerFeature> arrayList = new ArrayList(((ImpressionsCount) obj).perFeature);
        ArrayList<ImpressionsCountPerFeature> arrayList2 = new ArrayList(this.perFeature);
        if (arrayList.size() != arrayList2.size()) {
            return false;
        }
        HashMap hashMap = new HashMap();
        for (ImpressionsCountPerFeature impressionsCountPerFeature : arrayList) {
            hashMap.put(impressionsCountPerFeature.feature, impressionsCountPerFeature);
        }
        for (ImpressionsCountPerFeature impressionsCountPerFeature2 : arrayList2) {
            ImpressionsCountPerFeature impressionsCountPerFeature3 = (ImpressionsCountPerFeature) hashMap.get(impressionsCountPerFeature2.feature);
            if (impressionsCountPerFeature3 == null || impressionsCountPerFeature2.count != impressionsCountPerFeature3.count || impressionsCountPerFeature2.timeframe != impressionsCountPerFeature3.timeframe) {
                return false;
            }
        }
        return true;
    }
}

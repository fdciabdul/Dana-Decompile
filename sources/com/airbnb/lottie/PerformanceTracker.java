package com.airbnb.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import com.airbnb.lottie.utils.MeanCalculator;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class PerformanceTracker {
    public boolean PlaceComponentResult = false;
    public final Set<FrameListener> KClassImpl$Data$declaredNonStaticMembers$2 = new ArraySet();
    public final Map<String, MeanCalculator> getAuthRequestContext = new HashMap();
    private final Comparator<Pair<String, Float>> MyBillsEntityDataFactory = new Comparator<Pair<String, Float>>() { // from class: com.airbnb.lottie.PerformanceTracker.1
        @Override // java.util.Comparator
        public /* synthetic */ int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float floatValue = pair.PlaceComponentResult.floatValue();
            float floatValue2 = pair2.PlaceComponentResult.floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    };

    /* loaded from: classes3.dex */
    public interface FrameListener {
    }
}

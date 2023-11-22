package com.alibaba.griver.lottie;

import android.os.Build;
import android.util.ArraySet;
import androidx.core.util.Pair;
import com.alibaba.griver.lottie.utils.MeanCalculator;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class PerformanceTracker {
    private boolean enabled = false;
    private final Comparator<Pair<String, Float>> floatComparator;
    private final Set<FrameListener> frameListeners;
    private final Map<String, MeanCalculator> layerRenderTimes;

    /* loaded from: classes6.dex */
    public interface FrameListener {
        void onFrameRendered(float f);
    }

    public PerformanceTracker() {
        this.frameListeners = Build.VERSION.SDK_INT < 23 ? new HashSet<>() : new ArraySet<>();
        this.layerRenderTimes = new HashMap();
        this.floatComparator = new Comparator<Pair<String, Float>>() { // from class: com.alibaba.griver.lottie.PerformanceTracker.1
            @Override // java.util.Comparator
            public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
                float floatValue = pair.PlaceComponentResult.floatValue();
                float floatValue2 = pair2.PlaceComponentResult.floatValue();
                if (floatValue2 > floatValue) {
                    return 1;
                }
                return floatValue > floatValue2 ? -1 : 0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public void recordRenderTime(String str, float f) {
        if (this.enabled) {
            MeanCalculator meanCalculator = this.layerRenderTimes.get(str);
            if (meanCalculator == null) {
                meanCalculator = new MeanCalculator();
                this.layerRenderTimes.put(str, meanCalculator);
            }
            meanCalculator.add(f);
            if (str.equals("__container")) {
                Iterator<FrameListener> it = this.frameListeners.iterator();
                while (it.hasNext()) {
                    it.next().onFrameRendered(f);
                }
            }
        }
    }

    public void addFrameListener(FrameListener frameListener) {
        this.frameListeners.add(frameListener);
    }

    public void removeFrameListener(FrameListener frameListener) {
        this.frameListeners.remove(frameListener);
    }

    public void clearRenderTimes() {
        this.layerRenderTimes.clear();
    }

    public void logRenderTimes() {
        if (this.enabled) {
            List<Pair<String, Float>> sortedRenderTimes = getSortedRenderTimes();
            InstrumentInjector.log_d(L.TAG, "Render times:");
            for (int i = 0; i < sortedRenderTimes.size(); i++) {
                Pair<String, Float> pair = sortedRenderTimes.get(i);
                InstrumentInjector.log_d(L.TAG, String.format("\t\t%30s:%.2f", pair.getAuthRequestContext, pair.PlaceComponentResult));
            }
        }
    }

    public List<Pair<String, Float>> getSortedRenderTimes() {
        if (!this.enabled) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.layerRenderTimes.size());
        for (Map.Entry<String, MeanCalculator> entry : this.layerRenderTimes.entrySet()) {
            arrayList.add(new Pair(entry.getKey(), Float.valueOf(entry.getValue().getMean())));
        }
        Collections.sort(arrayList, this.floatComparator);
        return arrayList;
    }
}

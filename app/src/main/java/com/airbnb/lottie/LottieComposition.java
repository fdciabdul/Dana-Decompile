package com.airbnb.lottie;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class LottieComposition {
    public Map<String, Font> BuiltInFictitiousFunctionClassFactory;
    public float DatabaseTableConfigUtil;
    public Rect KClassImpl$Data$declaredNonStaticMembers$2;
    public float MyBillsEntityDataFactory;
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    public Map<String, List<Layer>> NetworkUserEntityData$$ExternalSyntheticLambda2;
    public float PlaceComponentResult;
    public SparseArrayCompat<FontCharacter> getAuthRequestContext;
    public List<Layer> getErrorConfigVersion;
    public LongSparseArray<Layer> lookAheadTest;
    public Map<String, LottieImageAsset> moveToNextValue;
    public List<Marker> scheduleImpl;
    public final PerformanceTracker NetworkUserEntityData$$ExternalSyntheticLambda1 = new PerformanceTracker();
    public final HashSet<String> initRecordTimeStamp = new HashSet<>();
    public int GetContactSyncConfig = 0;

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public final Marker KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        int size = this.scheduleImpl.size();
        for (int i = 0; i < size; i++) {
            Marker marker = this.scheduleImpl.get(i);
            if (marker.BuiltInFictitiousFunctionClassFactory(str)) {
                return marker;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<Layer> it = this.getErrorConfigVersion.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getAuthRequestContext("\t"));
        }
        return sb.toString();
    }

    @Deprecated
    /* loaded from: classes6.dex */
    public static class Factory {
        private Factory() {
        }

        /* loaded from: classes6.dex */
        static final class ListenerAdapter implements LottieListener<LottieComposition>, Cancellable {
            private boolean BuiltInFictitiousFunctionClassFactory;
            private final OnCompositionLoadedListener getAuthRequestContext;

            @Override // com.airbnb.lottie.LottieListener
            public final /* bridge */ /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(LottieComposition lottieComposition) {
                boolean z = this.BuiltInFictitiousFunctionClassFactory;
            }
        }
    }
}

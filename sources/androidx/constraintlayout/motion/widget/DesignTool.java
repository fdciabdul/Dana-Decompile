package androidx.constraintlayout.motion.widget;

import android.util.Pair;
import com.alibaba.griver.ui.ant.api.AUAttrsConstant;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class DesignTool implements ProxyInterface {
    static final HashMap<Pair<Integer, Integer>, String> BuiltInFictitiousFunctionClassFactory;
    static final HashMap<String, String> MyBillsEntityDataFactory;
    private final MotionLayout scheduleImpl;
    private String getAuthRequestContext = null;
    private String PlaceComponentResult = null;
    private int moveToNextValue = -1;
    private int KClassImpl$Data$declaredNonStaticMembers$2 = -1;

    public DesignTool(MotionLayout motionLayout) {
        this.scheduleImpl = motionLayout;
    }

    static {
        HashMap<Pair<Integer, Integer>, String> hashMap = new HashMap<>();
        BuiltInFictitiousFunctionClassFactory = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        MyBillsEntityDataFactory = hashMap2;
        hashMap.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        hashMap.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        hashMap.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        hashMap.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        hashMap.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        hashMap.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        hashMap.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        hashMap.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        hashMap.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        hashMap.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        hashMap.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        hashMap.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        hashMap.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        hashMap2.put("layout_constraintBottom_toBottomOf", AUAttrsConstant.VIEW_MARGIN_BOTTOM);
        hashMap2.put("layout_constraintBottom_toTopOf", AUAttrsConstant.VIEW_MARGIN_BOTTOM);
        hashMap2.put("layout_constraintTop_toBottomOf", AUAttrsConstant.VIEW_MARGIN_TOP);
        hashMap2.put("layout_constraintTop_toTopOf", AUAttrsConstant.VIEW_MARGIN_TOP);
        hashMap2.put("layout_constraintStart_toStartOf", "layout_marginStart");
        hashMap2.put("layout_constraintStart_toEndOf", "layout_marginStart");
        hashMap2.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        hashMap2.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        hashMap2.put("layout_constraintLeft_toLeftOf", AUAttrsConstant.VIEW_MARGIN_LEFT);
        hashMap2.put("layout_constraintLeft_toRightOf", AUAttrsConstant.VIEW_MARGIN_LEFT);
        hashMap2.put("layout_constraintRight_toRightOf", AUAttrsConstant.VIEW_MARGIN_RIGHT);
        hashMap2.put("layout_constraintRight_toLeftOf", AUAttrsConstant.VIEW_MARGIN_RIGHT);
    }
}

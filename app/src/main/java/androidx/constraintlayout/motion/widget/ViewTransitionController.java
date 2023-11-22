package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.SharedValues;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ViewTransitionController {
    HashSet<View> BuiltInFictitiousFunctionClassFactory;
    ArrayList<ViewTransition.Animate> KClassImpl$Data$declaredNonStaticMembers$2;
    final MotionLayout getAuthRequestContext;
    ArrayList<ViewTransition> moveToNextValue = new ArrayList<>();
    String PlaceComponentResult = "ViewTransitionController";
    ArrayList<ViewTransition.Animate> MyBillsEntityDataFactory = new ArrayList<>();

    public ViewTransitionController(MotionLayout motionLayout) {
        this.getAuthRequestContext = motionLayout;
    }

    public final boolean getAuthRequestContext(int i) {
        Iterator<ViewTransition> it = this.moveToNextValue.iterator();
        while (it.hasNext()) {
            ViewTransition next = it.next();
            if (next.KClassImpl$Data$declaredNonStaticMembers$2 == i) {
                return next.MyBillsEntityDataFactory();
            }
        }
        return false;
    }

    public final boolean MyBillsEntityDataFactory(int i, MotionController motionController) {
        Iterator<ViewTransition> it = this.moveToNextValue.iterator();
        while (it.hasNext()) {
            ViewTransition next = it.next();
            if (next.KClassImpl$Data$declaredNonStaticMembers$2 == i) {
                ArrayList<Key> arrayList = next.moveToNextValue.PlaceComponentResult.get(-1);
                if (arrayList != null) {
                    motionController.NetworkUserEntityData$$ExternalSyntheticLambda1.addAll(arrayList);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    public final void PlaceComponentResult(final ViewTransition viewTransition, final boolean z) {
        final int i = viewTransition.scheduleImpl;
        final int i2 = viewTransition.lookAheadTest;
        ConstraintLayout.getSharedValues().getAuthRequestContext(viewTransition.scheduleImpl, new SharedValues.SharedValuesListener() { // from class: androidx.constraintlayout.motion.widget.ViewTransitionController.1
            {
                ViewTransitionController.this = this;
            }
        });
    }
}

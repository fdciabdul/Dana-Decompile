package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.state.WidgetFrame;

/* loaded from: classes6.dex */
public class MotionWidget implements TypedValues {
    Motion KClassImpl$Data$declaredNonStaticMembers$2;
    PropertySet MyBillsEntityDataFactory;
    public WidgetFrame PlaceComponentResult;

    /* loaded from: classes6.dex */
    public static class Motion {
        public int KClassImpl$Data$declaredNonStaticMembers$2 = -1;
        public int MyBillsEntityDataFactory = 0;
        public String NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
        public int getAuthRequestContext = -1;
        public int PlaceComponentResult = 0;
        public float BuiltInFictitiousFunctionClassFactory = Float.NaN;
        public int NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
        public float getErrorConfigVersion = Float.NaN;
        public float NetworkUserEntityData$$ExternalSyntheticLambda1 = Float.NaN;
        public int initRecordTimeStamp = -1;
        public String lookAheadTest = null;
        public int moveToNextValue = -3;
        public int scheduleImpl = -1;
    }

    /* loaded from: classes6.dex */
    public static class PropertySet {
        public int PlaceComponentResult = 4;
        public int getAuthRequestContext = 0;
        public float MyBillsEntityDataFactory = 1.0f;
        public float KClassImpl$Data$declaredNonStaticMembers$2 = Float.NaN;
    }

    public MotionWidget() {
        this.PlaceComponentResult = new WidgetFrame();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new Motion();
        this.MyBillsEntityDataFactory = new PropertySet();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.PlaceComponentResult.PlaceComponentResult);
        sb.append(", ");
        sb.append(this.PlaceComponentResult.initRecordTimeStamp);
        sb.append(", ");
        sb.append(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", ");
        sb.append(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
        return sb.toString();
    }

    public MotionWidget(WidgetFrame widgetFrame) {
        this.PlaceComponentResult = new WidgetFrame();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new Motion();
        this.MyBillsEntityDataFactory = new PropertySet();
        this.PlaceComponentResult = widgetFrame;
    }
}

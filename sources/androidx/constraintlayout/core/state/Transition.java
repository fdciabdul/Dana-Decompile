package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.Motion;
import androidx.constraintlayout.core.motion.MotionPaths;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class Transition implements TypedValues {
    HashMap<Integer, HashMap<String, KeyPosition>> KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap<>();
    private HashMap<String, WidgetState> moveToNextValue = new HashMap<>();
    TypedBundle getAuthRequestContext = new TypedBundle();
    private int MyBillsEntityDataFactory = 0;
    private String PlaceComponentResult = null;
    private Easing getErrorConfigVersion = null;
    private int BuiltInFictitiousFunctionClassFactory = 0;
    private int scheduleImpl = 400;
    private float lookAheadTest = 0.0f;

    /* loaded from: classes6.dex */
    static class KeyPosition {
    }

    /* loaded from: classes6.dex */
    static class WidgetState {
        Motion PlaceComponentResult;
        KeyCache scheduleImpl = new KeyCache();
        int lookAheadTest = -1;
        int NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
        WidgetFrame moveToNextValue = new WidgetFrame();
        WidgetFrame MyBillsEntityDataFactory = new WidgetFrame();
        WidgetFrame KClassImpl$Data$declaredNonStaticMembers$2 = new WidgetFrame();
        MotionWidget getErrorConfigVersion = new MotionWidget(this.moveToNextValue);
        MotionWidget getAuthRequestContext = new MotionWidget(this.MyBillsEntityDataFactory);
        MotionWidget BuiltInFictitiousFunctionClassFactory = new MotionWidget(this.KClassImpl$Data$declaredNonStaticMembers$2);

        public WidgetState() {
            Motion motion = new Motion(this.getErrorConfigVersion);
            this.PlaceComponentResult = motion;
            MotionWidget motionWidget = this.getErrorConfigVersion;
            motion.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda7 = 0.0f;
            motion.scheduleImpl.newProxyInstance = 0.0f;
            MotionPaths motionPaths = motion.scheduleImpl;
            float f = motionWidget.PlaceComponentResult.PlaceComponentResult;
            float f2 = motionWidget.PlaceComponentResult.initRecordTimeStamp;
            float f3 = motionWidget.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0 - motionWidget.PlaceComponentResult.PlaceComponentResult;
            float f4 = motionWidget.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory - motionWidget.PlaceComponentResult.initRecordTimeStamp;
            motionPaths.isLayoutRequested = f;
            motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda8 = f2;
            motionPaths.PrepareContext = f3;
            motionPaths.KClassImpl$Data$declaredNonStaticMembers$2 = f4;
            motion.scheduleImpl.MyBillsEntityDataFactory(motionWidget);
            motion.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(motionWidget);
            Motion motion2 = this.PlaceComponentResult;
            MotionWidget motionWidget2 = this.getAuthRequestContext;
            motion2.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda7 = 1.0f;
            motion2.PlaceComponentResult.newProxyInstance = 1.0f;
            MotionPaths motionPaths2 = motion2.PlaceComponentResult;
            float f5 = motion2.moveToNextValue.PlaceComponentResult.PlaceComponentResult;
            float f6 = motion2.moveToNextValue.PlaceComponentResult.initRecordTimeStamp;
            MotionWidget motionWidget3 = motion2.moveToNextValue;
            float f7 = motionWidget3.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0 - motionWidget3.PlaceComponentResult.PlaceComponentResult;
            MotionWidget motionWidget4 = motion2.moveToNextValue;
            float f8 = motionWidget4.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory - motionWidget4.PlaceComponentResult.initRecordTimeStamp;
            motionPaths2.isLayoutRequested = f5;
            motionPaths2.NetworkUserEntityData$$ExternalSyntheticLambda8 = f6;
            motionPaths2.PrepareContext = f7;
            motionPaths2.KClassImpl$Data$declaredNonStaticMembers$2 = f8;
            MotionPaths motionPaths3 = motion2.PlaceComponentResult;
            float f9 = motionWidget2.PlaceComponentResult.PlaceComponentResult;
            float f10 = motionWidget2.PlaceComponentResult.initRecordTimeStamp;
            float f11 = motionWidget2.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0 - motionWidget2.PlaceComponentResult.PlaceComponentResult;
            float f12 = motionWidget2.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory - motionWidget2.PlaceComponentResult.initRecordTimeStamp;
            motionPaths3.isLayoutRequested = f9;
            motionPaths3.NetworkUserEntityData$$ExternalSyntheticLambda8 = f10;
            motionPaths3.PrepareContext = f11;
            motionPaths3.KClassImpl$Data$declaredNonStaticMembers$2 = f12;
            motion2.PlaceComponentResult.MyBillsEntityDataFactory(motionWidget2);
            motion2.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(motionWidget2);
        }
    }
}

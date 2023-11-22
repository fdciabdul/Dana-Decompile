package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;

/* loaded from: classes6.dex */
public abstract class MotionKey implements TypedValues {
    public static int MyBillsEntityDataFactory = -1;
    int BuiltInFictitiousFunctionClassFactory;
    String KClassImpl$Data$declaredNonStaticMembers$2;
    public int PlaceComponentResult;
    public HashMap<String, CustomVariable> getAuthRequestContext;
    public int lookAheadTest;

    @Override // 
    /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
    public abstract MotionKey clone();

    public MotionKey() {
        int i = MyBillsEntityDataFactory;
        this.PlaceComponentResult = i;
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
    }

    public MotionKey PlaceComponentResult(MotionKey motionKey) {
        this.PlaceComponentResult = motionKey.PlaceComponentResult;
        this.BuiltInFictitiousFunctionClassFactory = motionKey.BuiltInFictitiousFunctionClassFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = motionKey.KClassImpl$Data$declaredNonStaticMembers$2;
        this.lookAheadTest = motionKey.lookAheadTest;
        return this;
    }
}

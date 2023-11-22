package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes3.dex */
public abstract class Key {
    public static int PlaceComponentResult = -1;
    public int BuiltInFictitiousFunctionClassFactory;
    int KClassImpl$Data$declaredNonStaticMembers$2;
    HashMap<String, ConstraintAttribute> MyBillsEntityDataFactory;
    String getAuthRequestContext;
    protected int scheduleImpl;

    @Override // 
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
    public abstract Key clone();

    public void MyBillsEntityDataFactory(HashMap<String, Integer> hashMap) {
    }

    public abstract void PlaceComponentResult(HashMap<String, ViewSpline> hashMap);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void PlaceComponentResult(HashSet<String> hashSet);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void getAuthRequestContext(Context context, AttributeSet attributeSet);

    public Key() {
        int i = PlaceComponentResult;
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.getAuthRequestContext = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean BuiltInFictitiousFunctionClassFactory(String str) {
        String str2 = this.getAuthRequestContext;
        if (str2 == null || str == null) {
            return false;
        }
        return str.matches(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean MyBillsEntityDataFactory(Object obj) {
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(obj.toString());
    }

    public Key KClassImpl$Data$declaredNonStaticMembers$2(Key key) {
        this.BuiltInFictitiousFunctionClassFactory = key.BuiltInFictitiousFunctionClassFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = key.KClassImpl$Data$declaredNonStaticMembers$2;
        this.getAuthRequestContext = key.getAuthRequestContext;
        this.scheduleImpl = key.scheduleImpl;
        this.MyBillsEntityDataFactory = key.MyBillsEntityDataFactory;
        return this;
    }
}

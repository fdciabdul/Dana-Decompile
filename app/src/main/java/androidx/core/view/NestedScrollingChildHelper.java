package androidx.core.view;

import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public class NestedScrollingChildHelper {
    private ViewParent BuiltInFictitiousFunctionClassFactory;
    public final View KClassImpl$Data$declaredNonStaticMembers$2;
    private int[] MyBillsEntityDataFactory;
    public boolean PlaceComponentResult;
    public ViewParent getAuthRequestContext;

    public NestedScrollingChildHelper(View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.PlaceComponentResult;
    }

    public final boolean getAuthRequestContext() {
        return getAuthRequestContext(0);
    }

    public final boolean PlaceComponentResult(int i) {
        return MyBillsEntityDataFactory(i, 0);
    }

    public final boolean MyBillsEntityDataFactory(int i, int i2) {
        if (getAuthRequestContext(i2)) {
            return true;
        }
        if (MyBillsEntityDataFactory()) {
            View view = this.KClassImpl$Data$declaredNonStaticMembers$2;
            for (ViewParent parent = this.KClassImpl$Data$declaredNonStaticMembers$2.getParent(); parent != null; parent = parent.getParent()) {
                if (ViewParentCompat.MyBillsEntityDataFactory(parent, view, this.KClassImpl$Data$declaredNonStaticMembers$2, i, i2)) {
                    if (i2 == 0) {
                        this.getAuthRequestContext = parent;
                    } else if (i2 == 1) {
                        this.BuiltInFictitiousFunctionClassFactory = parent;
                    }
                    ViewParentCompat.PlaceComponentResult(parent, view, this.KClassImpl$Data$declaredNonStaticMembers$2, i, i2);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
            return false;
        }
        return false;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(int i, int i2, int i3, int i4, int[] iArr) {
        return getAuthRequestContext(i, i2, i3, i4, iArr, 0, null);
    }

    public final boolean MyBillsEntityDataFactory(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getAuthRequestContext(i, i2, i3, i4, iArr, i5, null);
    }

    public final boolean getAuthRequestContext(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        ViewParent viewParent;
        int i6;
        int i7;
        int[] iArr3;
        if (MyBillsEntityDataFactory()) {
            if (i5 == 0) {
                viewParent = this.getAuthRequestContext;
            } else {
                viewParent = i5 != 1 ? null : this.BuiltInFictitiousFunctionClassFactory;
            }
            if (viewParent == null) {
                return false;
            }
            if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
                if (iArr != null) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.getLocationInWindow(iArr);
                    i6 = iArr[0];
                    i7 = iArr[1];
                } else {
                    i6 = 0;
                    i7 = 0;
                }
                if (iArr2 == null) {
                    if (this.MyBillsEntityDataFactory == null) {
                        this.MyBillsEntityDataFactory = new int[2];
                    }
                    int[] iArr4 = this.MyBillsEntityDataFactory;
                    iArr4[0] = 0;
                    iArr4[1] = 0;
                    iArr3 = iArr4;
                } else {
                    iArr3 = iArr2;
                }
                ViewParentCompat.KClassImpl$Data$declaredNonStaticMembers$2(viewParent, this.KClassImpl$Data$declaredNonStaticMembers$2, i, i2, i3, i4, i5, iArr3);
                if (iArr != null) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.getLocationInWindow(iArr);
                    iArr[0] = iArr[0] - i6;
                    iArr[1] = iArr[1] - i7;
                }
                return true;
            } else if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
        }
        return false;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2, int[] iArr, int[] iArr2) {
        return getAuthRequestContext(i, i2, iArr, iArr2, 0);
    }

    public final boolean getAuthRequestContext(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent viewParent;
        int i4;
        int i5;
        if (MyBillsEntityDataFactory()) {
            if (i3 == 0) {
                viewParent = this.getAuthRequestContext;
            } else {
                viewParent = i3 != 1 ? null : this.BuiltInFictitiousFunctionClassFactory;
            }
            ViewParent viewParent2 = viewParent;
            if (viewParent2 == null) {
                return false;
            }
            if (i != 0 || i2 != 0) {
                if (iArr2 != null) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.getLocationInWindow(iArr2);
                    i4 = iArr2[0];
                    i5 = iArr2[1];
                } else {
                    i4 = 0;
                    i5 = 0;
                }
                if (iArr == null) {
                    if (this.MyBillsEntityDataFactory == null) {
                        this.MyBillsEntityDataFactory = new int[2];
                    }
                    iArr = this.MyBillsEntityDataFactory;
                }
                iArr[0] = 0;
                iArr[1] = 0;
                ViewParentCompat.PlaceComponentResult(viewParent2, this.KClassImpl$Data$declaredNonStaticMembers$2, i, i2, iArr, i3);
                if (iArr2 != null) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.getLocationInWindow(iArr2);
                    iArr2[0] = iArr2[0] - i4;
                    iArr2[1] = iArr2[1] - i5;
                }
                if (iArr[0] != 0 || iArr[1] != 0) {
                    return true;
                }
            } else if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
        }
        return false;
    }

    public final boolean PlaceComponentResult(float f, float f2, boolean z) {
        ViewParent viewParent;
        if (!MyBillsEntityDataFactory() || (viewParent = this.getAuthRequestContext) == null) {
            return false;
        }
        return ViewParentCompat.MyBillsEntityDataFactory(viewParent, this.KClassImpl$Data$declaredNonStaticMembers$2, f, f2, z);
    }

    public final boolean getAuthRequestContext(float f, float f2) {
        ViewParent viewParent;
        if (!MyBillsEntityDataFactory() || (viewParent = this.getAuthRequestContext) == null) {
            return false;
        }
        return ViewParentCompat.PlaceComponentResult(viewParent, this.KClassImpl$Data$declaredNonStaticMembers$2, f, f2);
    }

    public final boolean getAuthRequestContext(int i) {
        ViewParent viewParent;
        if (i == 0) {
            viewParent = this.getAuthRequestContext;
        } else {
            viewParent = i != 1 ? null : this.BuiltInFictitiousFunctionClassFactory;
        }
        return viewParent != null;
    }

    public final void MyBillsEntityDataFactory(int i) {
        ViewParent viewParent;
        if (i == 0) {
            viewParent = this.getAuthRequestContext;
        } else {
            viewParent = i != 1 ? null : this.BuiltInFictitiousFunctionClassFactory;
        }
        if (viewParent != null) {
            ViewParentCompat.BuiltInFictitiousFunctionClassFactory(viewParent, this.KClassImpl$Data$declaredNonStaticMembers$2, i);
            if (i == 0) {
                this.getAuthRequestContext = null;
            } else if (i == 1) {
                this.BuiltInFictitiousFunctionClassFactory = null;
            }
        }
    }
}

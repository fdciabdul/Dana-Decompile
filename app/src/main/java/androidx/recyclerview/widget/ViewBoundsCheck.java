package androidx.recyclerview.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
class ViewBoundsCheck {
    final Callback BuiltInFictitiousFunctionClassFactory;
    BoundFlags KClassImpl$Data$declaredNonStaticMembers$2 = new BoundFlags();

    /* loaded from: classes.dex */
    interface Callback {
        int KClassImpl$Data$declaredNonStaticMembers$2(View view);

        int MyBillsEntityDataFactory();

        View MyBillsEntityDataFactory(int i);

        int getAuthRequestContext();

        int getAuthRequestContext(View view);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ViewBounds {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewBoundsCheck(Callback callback) {
        this.BuiltInFictitiousFunctionClassFactory = callback;
    }

    /* loaded from: classes3.dex */
    static class BoundFlags {
        int BuiltInFictitiousFunctionClassFactory;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory;
        int PlaceComponentResult;
        int getAuthRequestContext = 0;

        BoundFlags() {
        }

        final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            int i = this.getAuthRequestContext;
            int i2 = 2;
            if ((i & 7) != 0) {
                int i3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                int i4 = this.BuiltInFictitiousFunctionClassFactory;
                if ((i & ((i3 > i4 ? 1 : i3 == i4 ? 2 : 4) << 0)) == 0) {
                    return false;
                }
            }
            int i5 = this.getAuthRequestContext;
            if ((i5 & 112) != 0) {
                int i6 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                int i7 = this.MyBillsEntityDataFactory;
                if ((i5 & ((i6 > i7 ? 1 : i6 == i7 ? 2 : 4) << 4)) == 0) {
                    return false;
                }
            }
            int i8 = this.getAuthRequestContext;
            if ((i8 & 1792) != 0) {
                int i9 = this.PlaceComponentResult;
                int i10 = this.BuiltInFictitiousFunctionClassFactory;
                if ((i8 & ((i9 > i10 ? 1 : i9 == i10 ? 2 : 4) << 8)) == 0) {
                    return false;
                }
            }
            int i11 = this.getAuthRequestContext;
            if ((i11 & 28672) != 0) {
                int i12 = this.PlaceComponentResult;
                int i13 = this.MyBillsEntityDataFactory;
                if (i12 > i13) {
                    i2 = 1;
                } else if (i12 != i13) {
                    i2 = 4;
                }
                if ((i11 & (i2 << 12)) == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final View KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2, int i3, int i4) {
        int MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
        int authRequestContext = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View MyBillsEntityDataFactory2 = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(i);
            int authRequestContext2 = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(MyBillsEntityDataFactory2);
            int KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2);
            BoundFlags boundFlags = this.KClassImpl$Data$declaredNonStaticMembers$2;
            boundFlags.BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory;
            boundFlags.MyBillsEntityDataFactory = authRequestContext;
            boundFlags.KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext2;
            boundFlags.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2;
            if (i3 != 0) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = 0;
                this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext |= i3;
                if (this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    return MyBillsEntityDataFactory2;
                }
            }
            if (i4 != 0) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = 0;
                this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext |= i4;
                if (this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    view = MyBillsEntityDataFactory2;
                }
            }
            i += i5;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean getAuthRequestContext(View view) {
        BoundFlags boundFlags = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
        int authRequestContext = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
        int authRequestContext2 = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(view);
        int KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(view);
        boundFlags.BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory;
        boundFlags.MyBillsEntityDataFactory = authRequestContext;
        boundFlags.KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext2;
        boundFlags.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2;
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = 0;
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext |= 24579;
        return this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
    }
}

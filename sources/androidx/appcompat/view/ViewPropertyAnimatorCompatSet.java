package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ViewPropertyAnimatorCompatSet {
    ViewPropertyAnimatorListener BuiltInFictitiousFunctionClassFactory;
    private Interpolator KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private long getAuthRequestContext = -1;
    private final ViewPropertyAnimatorListenerAdapter scheduleImpl = new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.view.ViewPropertyAnimatorCompatSet.1
        private boolean MyBillsEntityDataFactory = false;
        private int getAuthRequestContext = 0;

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void MyBillsEntityDataFactory(View view) {
            if (this.MyBillsEntityDataFactory) {
                return;
            }
            this.MyBillsEntityDataFactory = true;
            if (ViewPropertyAnimatorCompatSet.this.BuiltInFictitiousFunctionClassFactory != null) {
                ViewPropertyAnimatorCompatSet.this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(null);
            }
        }

        void getAuthRequestContext() {
            this.getAuthRequestContext = 0;
            this.MyBillsEntityDataFactory = false;
            ViewPropertyAnimatorCompatSet.this.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void getAuthRequestContext(View view) {
            int i = this.getAuthRequestContext + 1;
            this.getAuthRequestContext = i;
            if (i == ViewPropertyAnimatorCompatSet.this.PlaceComponentResult.size()) {
                if (ViewPropertyAnimatorCompatSet.this.BuiltInFictitiousFunctionClassFactory != null) {
                    ViewPropertyAnimatorCompatSet.this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(null);
                }
                getAuthRequestContext();
            }
        }
    };
    final ArrayList<ViewPropertyAnimatorCompat> PlaceComponentResult = new ArrayList<>();

    public ViewPropertyAnimatorCompatSet PlaceComponentResult(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.MyBillsEntityDataFactory) {
            this.PlaceComponentResult.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet KClassImpl$Data$declaredNonStaticMembers$2(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.PlaceComponentResult.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.PlaceComponentResult(viewPropertyAnimatorCompat.getAuthRequestContext());
        this.PlaceComponentResult.add(viewPropertyAnimatorCompat2);
        return this;
    }

    public void MyBillsEntityDataFactory() {
        if (this.MyBillsEntityDataFactory) {
            return;
        }
        Iterator<ViewPropertyAnimatorCompat> it = this.PlaceComponentResult.iterator();
        while (it.hasNext()) {
            ViewPropertyAnimatorCompat next = it.next();
            long j = this.getAuthRequestContext;
            if (j >= 0) {
                next.KClassImpl$Data$declaredNonStaticMembers$2(j);
            }
            Interpolator interpolator = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (interpolator != null) {
                next.MyBillsEntityDataFactory(interpolator);
            }
            if (this.BuiltInFictitiousFunctionClassFactory != null) {
                next.KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl);
            }
            next.PlaceComponentResult();
        }
        this.MyBillsEntityDataFactory = true;
    }

    void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.MyBillsEntityDataFactory = false;
    }

    public void BuiltInFictitiousFunctionClassFactory() {
        if (this.MyBillsEntityDataFactory) {
            Iterator<ViewPropertyAnimatorCompat> it = this.PlaceComponentResult.iterator();
            while (it.hasNext()) {
                it.next().BuiltInFictitiousFunctionClassFactory();
            }
            this.MyBillsEntityDataFactory = false;
        }
    }

    public ViewPropertyAnimatorCompatSet BuiltInFictitiousFunctionClassFactory(long j) {
        if (!this.MyBillsEntityDataFactory) {
            this.getAuthRequestContext = j;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet PlaceComponentResult(Interpolator interpolator) {
        if (!this.MyBillsEntityDataFactory) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = interpolator;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet KClassImpl$Data$declaredNonStaticMembers$2(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.MyBillsEntityDataFactory) {
            this.BuiltInFictitiousFunctionClassFactory = viewPropertyAnimatorListener;
        }
        return this;
    }
}

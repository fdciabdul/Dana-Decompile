package id.dana.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import id.dana.nearbyme.merchantreview.MyReviewView;

/* loaded from: classes4.dex */
public final class ItemMyReviewBinding implements ViewBinding {
    private final MyReviewView BuiltInFictitiousFunctionClassFactory;
    public final MyReviewView MyBillsEntityDataFactory;

    private ItemMyReviewBinding(MyReviewView myReviewView, MyReviewView myReviewView2) {
        this.BuiltInFictitiousFunctionClassFactory = myReviewView;
        this.MyBillsEntityDataFactory = myReviewView2;
    }

    public static ItemMyReviewBinding BuiltInFictitiousFunctionClassFactory(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        MyReviewView myReviewView = (MyReviewView) view;
        return new ItemMyReviewBinding(myReviewView, myReviewView);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}

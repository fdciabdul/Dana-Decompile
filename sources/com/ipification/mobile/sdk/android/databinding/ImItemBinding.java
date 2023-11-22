package com.ipification.mobile.sdk.android.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes3.dex */
public final class ImItemBinding implements ViewBinding {
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final ImageView getAuthRequestContext;

    public ImItemBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.getAuthRequestContext = imageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}

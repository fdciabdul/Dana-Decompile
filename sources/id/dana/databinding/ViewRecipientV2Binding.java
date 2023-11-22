package id.dana.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewRecipientV2Binding implements ViewBinding {
    public final RecyclerView BuiltInFictitiousFunctionClassFactory;
    public final LayoutEnterNewRecipientBinding KClassImpl$Data$declaredNonStaticMembers$2;
    public final SendMoneyRecipientSectionBinding MyBillsEntityDataFactory;
    public final CoordinatorLayout PlaceComponentResult;
    public final ExtendedFloatingActionButton getAuthRequestContext;
    public final Group lookAheadTest;
    private final ConstraintLayout scheduleImpl;

    private ViewRecipientV2Binding(ConstraintLayout constraintLayout, CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, LayoutEnterNewRecipientBinding layoutEnterNewRecipientBinding, SendMoneyRecipientSectionBinding sendMoneyRecipientSectionBinding, RecyclerView recyclerView, Group group) {
        this.scheduleImpl = constraintLayout;
        this.PlaceComponentResult = coordinatorLayout;
        this.getAuthRequestContext = extendedFloatingActionButton;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = layoutEnterNewRecipientBinding;
        this.MyBillsEntityDataFactory = sendMoneyRecipientSectionBinding;
        this.BuiltInFictitiousFunctionClassFactory = recyclerView;
        this.lookAheadTest = group;
    }

    public static ViewRecipientV2Binding MyBillsEntityDataFactory(View view) {
        int i = R.id.clRecipientContent;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.clRecipientContent);
        if (coordinatorLayout != null) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.fabBackToTop);
            if (extendedFloatingActionButton != null) {
                View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.layoutEnterNewRecipient);
                if (BuiltInFictitiousFunctionClassFactory != null) {
                    LayoutEnterNewRecipientBinding BuiltInFictitiousFunctionClassFactory2 = LayoutEnterNewRecipientBinding.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory);
                    View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.layoutSectionSendMoney);
                    if (BuiltInFictitiousFunctionClassFactory3 != null) {
                        SendMoneyRecipientSectionBinding BuiltInFictitiousFunctionClassFactory4 = SendMoneyRecipientSectionBinding.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory3);
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rvRecipient);
                        if (recyclerView != null) {
                            Group group = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.viewGroupRecipientContent);
                            if (group != null) {
                                return new ViewRecipientV2Binding((ConstraintLayout) view, coordinatorLayout, extendedFloatingActionButton, BuiltInFictitiousFunctionClassFactory2, BuiltInFictitiousFunctionClassFactory4, recyclerView, group);
                            }
                            i = R.id.viewGroupRecipientContent;
                        } else {
                            i = R.id.rvRecipient;
                        }
                    } else {
                        i = R.id.layoutSectionSendMoney;
                    }
                } else {
                    i = R.id.layoutEnterNewRecipient;
                }
            } else {
                i = R.id.fabBackToTop;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}

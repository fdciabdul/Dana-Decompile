package id.dana.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import id.dana.richview.EmptyStateView;

/* loaded from: classes4.dex */
public final class ItemRecipientContactNoPermissionBinding implements ViewBinding {
    public final EmptyStateView BuiltInFictitiousFunctionClassFactory;
    private final EmptyStateView getAuthRequestContext;

    private ItemRecipientContactNoPermissionBinding(EmptyStateView emptyStateView, EmptyStateView emptyStateView2) {
        this.getAuthRequestContext = emptyStateView;
        this.BuiltInFictitiousFunctionClassFactory = emptyStateView2;
    }

    public static ItemRecipientContactNoPermissionBinding PlaceComponentResult(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        EmptyStateView emptyStateView = (EmptyStateView) view;
        return new ItemRecipientContactNoPermissionBinding(emptyStateView, emptyStateView);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}

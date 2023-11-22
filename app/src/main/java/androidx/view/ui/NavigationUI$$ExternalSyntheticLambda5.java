package androidx.view.ui;

import android.view.MenuItem;
import androidx.view.NavController;
import com.google.android.material.navigation.NavigationBarView;

/* loaded from: classes6.dex */
public final /* synthetic */ class NavigationUI$$ExternalSyntheticLambda5 implements NavigationBarView.OnItemSelectedListener {
    public final /* synthetic */ NavController MyBillsEntityDataFactory;
    public final /* synthetic */ boolean getAuthRequestContext;

    @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
    public final boolean onNavigationItemSelected(MenuItem menuItem) {
        boolean authRequestContext;
        authRequestContext = NavigationUI.getAuthRequestContext(this.MyBillsEntityDataFactory, this.getAuthRequestContext, menuItem);
        return authRequestContext;
    }
}

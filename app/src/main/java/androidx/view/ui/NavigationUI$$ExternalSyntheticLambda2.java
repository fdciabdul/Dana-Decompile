package androidx.view.ui;

import android.view.MenuItem;
import androidx.view.NavController;
import com.google.android.material.navigation.NavigationBarView;

/* loaded from: classes6.dex */
public final /* synthetic */ class NavigationUI$$ExternalSyntheticLambda2 implements NavigationBarView.OnItemSelectedListener {
    public final /* synthetic */ NavController PlaceComponentResult;

    @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
    public final boolean onNavigationItemSelected(MenuItem menuItem) {
        boolean PlaceComponentResult;
        PlaceComponentResult = NavigationUI.PlaceComponentResult(this.PlaceComponentResult, menuItem);
        return PlaceComponentResult;
    }
}

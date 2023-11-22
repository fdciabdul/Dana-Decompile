package androidx.view.ui;

import android.graphics.drawable.Drawable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\r"}, d2 = {"Landroidx/navigation/ui/ActionBarOnDestinationChangedListener;", "Landroidx/navigation/ui/AbstractAppBarOnDestinationChangedListener;", "Landroid/graphics/drawable/Drawable;", "p0", "", "p1", "", "getAuthRequestContext", "(Landroid/graphics/drawable/Drawable;I)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/CharSequence;)V", "Landroidx/appcompat/app/AppCompatActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "PlaceComponentResult"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ActionBarOnDestinationChangedListener extends AbstractAppBarOnDestinationChangedListener {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final AppCompatActivity PlaceComponentResult;

    @Override // androidx.view.ui.AbstractAppBarOnDestinationChangedListener
    protected final void KClassImpl$Data$declaredNonStaticMembers$2(CharSequence p0) {
        ActionBar supportActionBar = this.PlaceComponentResult.getSupportActionBar();
        if (supportActionBar == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Activity ");
            sb.append(this.PlaceComponentResult);
            sb.append(" does not have an ActionBar set via setSupportActionBar()");
            throw new IllegalStateException(sb.toString().toString());
        }
        Intrinsics.checkNotNullExpressionValue(supportActionBar, "");
        supportActionBar.BuiltInFictitiousFunctionClassFactory(p0);
    }

    @Override // androidx.view.ui.AbstractAppBarOnDestinationChangedListener
    protected final void getAuthRequestContext(Drawable p0, int p1) {
        ActionBar supportActionBar = this.PlaceComponentResult.getSupportActionBar();
        if (supportActionBar == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Activity ");
            sb.append(this.PlaceComponentResult);
            sb.append(" does not have an ActionBar set via setSupportActionBar()");
            throw new IllegalStateException(sb.toString().toString());
        }
        Intrinsics.checkNotNullExpressionValue(supportActionBar, "");
        supportActionBar.KClassImpl$Data$declaredNonStaticMembers$2(p0 != null);
        ActionBarDrawerToggle.Delegate drawerToggleDelegate = this.PlaceComponentResult.getDrawerToggleDelegate();
        if (drawerToggleDelegate == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Activity ");
            sb2.append(this.PlaceComponentResult);
            sb2.append(" does not have an DrawerToggleDelegate set");
            throw new IllegalStateException(sb2.toString().toString());
        }
        Intrinsics.checkNotNullExpressionValue(drawerToggleDelegate, "");
        drawerToggleDelegate.BuiltInFictitiousFunctionClassFactory(p0, p1);
    }
}

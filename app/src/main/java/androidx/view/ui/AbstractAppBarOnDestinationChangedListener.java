package androidx.view.ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.customview.widget.Openable;
import androidx.view.FloatingWindow;
import androidx.view.NavController;
import androidx.view.NavDestination;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\b \u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\fH$¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u000fH$¢\u0006\u0004\b\t\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\r\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0019R \u0010\u0015\u001a\u000e\u0012\b\u0012\u0006*\u00020\u001b0\u001b\u0018\u00010\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001cR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\f0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001e"}, d2 = {"Landroidx/navigation/ui/AbstractAppBarOnDestinationChangedListener;", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "Landroidx/navigation/NavController;", "p0", "Landroidx/navigation/NavDestination;", "p1", "Landroid/os/Bundle;", "p2", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/navigation/NavController;Landroidx/navigation/NavDestination;Landroid/os/Bundle;)V", "Landroid/graphics/drawable/Drawable;", "", "getAuthRequestContext", "(Landroid/graphics/drawable/Drawable;I)V", "", "(Ljava/lang/CharSequence;)V", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "MyBillsEntityDataFactory", "Landroidx/appcompat/graphics/drawable/DrawerArrowDrawable;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/appcompat/graphics/drawable/DrawerArrowDrawable;", "PlaceComponentResult", "Landroid/content/Context;", "Landroid/content/Context;", "Ljava/lang/ref/WeakReference;", "Landroidx/customview/widget/Openable;", "Ljava/lang/ref/WeakReference;", "", "Ljava/util/Set;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class AbstractAppBarOnDestinationChangedListener implements NavController.OnDestinationChangedListener {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private DrawerArrowDrawable PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private ValueAnimator MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final WeakReference<Openable> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Context getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Set<Integer> KClassImpl$Data$declaredNonStaticMembers$2;

    protected abstract void KClassImpl$Data$declaredNonStaticMembers$2(CharSequence p0);

    protected abstract void getAuthRequestContext(Drawable p0, int p1);

    @Override // androidx.navigation.NavController.OnDestinationChangedListener
    public void KClassImpl$Data$declaredNonStaticMembers$2(NavController p0, NavDestination p1, Bundle p2) {
        Pair pair;
        int i;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (p1 instanceof FloatingWindow) {
            return;
        }
        WeakReference<Openable> weakReference = this.BuiltInFictitiousFunctionClassFactory;
        Openable openable = weakReference != null ? weakReference.get() : null;
        if (this.BuiltInFictitiousFunctionClassFactory != null && openable == null) {
            AbstractAppBarOnDestinationChangedListener abstractAppBarOnDestinationChangedListener = this;
            Intrinsics.checkNotNullParameter(abstractAppBarOnDestinationChangedListener, "");
            p0.newProxyInstance.remove(abstractAppBarOnDestinationChangedListener);
            return;
        }
        CharSequence charSequence = p1.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (charSequence != null) {
            StringBuffer stringBuffer = new StringBuffer();
            Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(charSequence);
            while (matcher.find()) {
                String group = matcher.group(1);
                if (p2 != null && p2.containsKey(group)) {
                    matcher.appendReplacement(stringBuffer, "");
                    stringBuffer.append(String.valueOf(p2.get(group)));
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Could not find \"");
                    sb.append(group);
                    sb.append("\" in ");
                    sb.append(p2);
                    sb.append(" to fill label \"");
                    sb.append((Object) charSequence);
                    sb.append(Typography.quote);
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            matcher.appendTail(stringBuffer);
            KClassImpl$Data$declaredNonStaticMembers$2(stringBuffer);
        }
        boolean MyBillsEntityDataFactory = NavigationUI.MyBillsEntityDataFactory(p1, this.KClassImpl$Data$declaredNonStaticMembers$2);
        if (openable == null && MyBillsEntityDataFactory) {
            getAuthRequestContext(null, 0);
            return;
        }
        boolean z = openable != null && MyBillsEntityDataFactory;
        DrawerArrowDrawable drawerArrowDrawable = this.PlaceComponentResult;
        if (drawerArrowDrawable == null || (pair = TuplesKt.to(drawerArrowDrawable, Boolean.TRUE)) == null) {
            DrawerArrowDrawable drawerArrowDrawable2 = new DrawerArrowDrawable(this.getAuthRequestContext);
            this.PlaceComponentResult = drawerArrowDrawable2;
            pair = TuplesKt.to(drawerArrowDrawable2, Boolean.FALSE);
        }
        DrawerArrowDrawable drawerArrowDrawable3 = (DrawerArrowDrawable) pair.component1();
        boolean booleanValue = ((Boolean) pair.component2()).booleanValue();
        DrawerArrowDrawable drawerArrowDrawable4 = drawerArrowDrawable3;
        if (z) {
            i = R.string.nav_app_bar_open_drawer_description;
        } else {
            i = R.string.nav_app_bar_navigate_up_description;
        }
        getAuthRequestContext(drawerArrowDrawable4, i);
        float f = z ? 0.0f : 1.0f;
        if (!booleanValue) {
            drawerArrowDrawable3.setProgress(f);
            return;
        }
        float f2 = drawerArrowDrawable3.getAuthRequestContext;
        ValueAnimator valueAnimator = this.MyBillsEntityDataFactory;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(drawerArrowDrawable3, "progress", f2, f);
        this.MyBillsEntityDataFactory = ofFloat;
        if (ofFloat == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.animation.ObjectAnimator");
        }
        ofFloat.start();
    }
}

package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class FragmentHostCallback<E> extends FragmentContainer {
    private final int BuiltInFictitiousFunctionClassFactory;
    final Activity KClassImpl$Data$declaredNonStaticMembers$2;
    final Context MyBillsEntityDataFactory;
    final FragmentManager PlaceComponentResult;
    public final Handler getAuthRequestContext;

    public void BuiltInFictitiousFunctionClassFactory(String str, PrintWriter printWriter, String[] strArr) {
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2() {
    }

    @Override // androidx.fragment.app.FragmentContainer
    public boolean MyBillsEntityDataFactory() {
        return true;
    }

    public boolean MyBillsEntityDataFactory(String str) {
        return false;
    }

    public abstract E PlaceComponentResult();

    @Override // androidx.fragment.app.FragmentContainer
    public View getAuthRequestContext(int i) {
        return null;
    }

    public FragmentHostCallback(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler());
    }

    private FragmentHostCallback(Activity activity, Context context, Handler handler) {
        this.PlaceComponentResult = new FragmentManagerImpl();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = activity;
        this.MyBillsEntityDataFactory = (Context) Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(context, "context == null");
        this.getAuthRequestContext = (Handler) Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(handler, "handler == null");
        this.BuiltInFictitiousFunctionClassFactory = 0;
    }

    public LayoutInflater BuiltInFictitiousFunctionClassFactory() {
        return LayoutInflater.from(this.MyBillsEntityDataFactory);
    }

    public final void getAuthRequestContext(Fragment fragment, Intent intent, int i, Bundle bundle) {
        ContextCompat.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory, intent, bundle);
    }

    public final Activity getAuthRequestContext() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final Context scheduleImpl() {
        return this.MyBillsEntityDataFactory;
    }

    public final Handler lookAheadTest() {
        return this.getAuthRequestContext;
    }
}

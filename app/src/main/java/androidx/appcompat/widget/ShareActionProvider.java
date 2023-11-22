package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.ActionProvider;

/* loaded from: classes6.dex */
public class ShareActionProvider extends ActionProvider {
    private final ShareMenuItemOnMenuItemClickListener KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    String PlaceComponentResult;
    final Context getAuthRequestContext;

    /* loaded from: classes6.dex */
    public interface OnShareTargetSelectedListener {
    }

    /* loaded from: classes6.dex */
    class ShareActivityChooserModelPolicy implements ActivityChooserModel.OnChooseActivityListener {
    }

    @Override // androidx.core.view.ActionProvider
    public boolean MyBillsEntityDataFactory() {
        return true;
    }

    public ShareActionProvider(Context context) {
        super(context);
        this.MyBillsEntityDataFactory = 4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ShareMenuItemOnMenuItemClickListener();
        this.PlaceComponentResult = "share_history.xml";
        this.getAuthRequestContext = context;
    }

    @Override // androidx.core.view.ActionProvider
    public View getAuthRequestContext() {
        Drawable BuiltInFictitiousFunctionClassFactory;
        ActivityChooserView activityChooserView = new ActivityChooserView(this.getAuthRequestContext);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(ActivityChooserModel.getAuthRequestContext(this.getAuthRequestContext, this.PlaceComponentResult));
        }
        TypedValue typedValue = new TypedValue();
        this.getAuthRequestContext.getTheme().resolveAttribute(R.attr.DatabaseTableConfigUtil, typedValue, true);
        BuiltInFictitiousFunctionClassFactory = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, typedValue.resourceId);
        activityChooserView.setExpandActivityOverflowButtonDrawable(BuiltInFictitiousFunctionClassFactory);
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(R.string.NetworkUserEntityData$$ExternalSyntheticLambda7);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(R.string.NetworkUserEntityData$$ExternalSyntheticLambda8);
        return activityChooserView;
    }

    @Override // androidx.core.view.ActionProvider
    public void MyBillsEntityDataFactory(SubMenu subMenu) {
        subMenu.clear();
        ActivityChooserModel authRequestContext = ActivityChooserModel.getAuthRequestContext(this.getAuthRequestContext, this.PlaceComponentResult);
        PackageManager packageManager = this.getAuthRequestContext.getPackageManager();
        int PlaceComponentResult = authRequestContext.PlaceComponentResult();
        int min = Math.min(PlaceComponentResult, this.MyBillsEntityDataFactory);
        for (int i = 0; i < min; i++) {
            ResolveInfo MyBillsEntityDataFactory = authRequestContext.MyBillsEntityDataFactory(i);
            subMenu.add(0, i, i, MyBillsEntityDataFactory.loadLabel(packageManager)).setIcon(MyBillsEntityDataFactory.loadIcon(packageManager)).setOnMenuItemClickListener(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        if (min < PlaceComponentResult) {
            SubMenu addSubMenu = subMenu.addSubMenu(0, min, min, this.getAuthRequestContext.getString(R.string.PlaceComponentResult));
            for (int i2 = 0; i2 < PlaceComponentResult; i2++) {
                ResolveInfo MyBillsEntityDataFactory2 = authRequestContext.MyBillsEntityDataFactory(i2);
                addSubMenu.add(0, i2, i2, MyBillsEntityDataFactory2.loadLabel(packageManager)).setIcon(MyBillsEntityDataFactory2.loadIcon(packageManager)).setOnMenuItemClickListener(this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }
    }

    /* loaded from: classes6.dex */
    class ShareMenuItemOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        ShareMenuItemOnMenuItemClickListener() {
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            Intent BuiltInFictitiousFunctionClassFactory = ActivityChooserModel.getAuthRequestContext(ShareActionProvider.this.getAuthRequestContext, ShareActionProvider.this.PlaceComponentResult).BuiltInFictitiousFunctionClassFactory(menuItem.getItemId());
            if (BuiltInFictitiousFunctionClassFactory != null) {
                String action = BuiltInFictitiousFunctionClassFactory.getAction();
                if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                    ShareActionProvider.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
                }
                ShareActionProvider.this.getAuthRequestContext.startActivity(BuiltInFictitiousFunctionClassFactory);
                return true;
            }
            return true;
        }
    }

    static void getAuthRequestContext(Intent intent) {
        if (Build.VERSION.SDK_INT >= 21) {
            intent.addFlags(134742016);
        } else {
            intent.addFlags(524288);
        }
    }
}

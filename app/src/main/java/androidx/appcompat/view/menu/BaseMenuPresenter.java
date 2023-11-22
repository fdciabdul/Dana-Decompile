package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class BaseMenuPresenter implements MenuPresenter {
    protected LayoutInflater BuiltInFictitiousFunctionClassFactory;
    public MenuPresenter.Callback KClassImpl$Data$declaredNonStaticMembers$2;
    public int MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    public MenuBuilder PlaceComponentResult;
    protected Context getAuthRequestContext;
    protected LayoutInflater getErrorConfigVersion;
    private int lookAheadTest;
    protected Context moveToNextValue;
    public MenuView scheduleImpl;

    public boolean PlaceComponentResult(MenuItemImpl menuItemImpl) {
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    public abstract void getAuthRequestContext(MenuItemImpl menuItemImpl, MenuView.ItemView itemView);

    public BaseMenuPresenter(Context context, int i, int i2) {
        this.moveToNextValue = context;
        this.getErrorConfigVersion = LayoutInflater.from(context);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
        this.lookAheadTest = i2;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.getAuthRequestContext = context;
        this.BuiltInFictitiousFunctionClassFactory = LayoutInflater.from(context);
        this.PlaceComponentResult = menuBuilder;
    }

    public MenuView PlaceComponentResult(ViewGroup viewGroup) {
        if (this.scheduleImpl == null) {
            MenuView menuView = (MenuView) this.getErrorConfigVersion.inflate(this.NetworkUserEntityData$$ExternalSyntheticLambda0, viewGroup, false);
            this.scheduleImpl = menuView;
            menuView.initialize(this.PlaceComponentResult);
            updateMenuView(true);
        }
        return this.scheduleImpl;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.scheduleImpl;
        if (viewGroup == null) {
            return;
        }
        MenuBuilder menuBuilder = this.PlaceComponentResult;
        int i = 0;
        if (menuBuilder != null) {
            menuBuilder.flagActionItems();
            ArrayList<MenuItemImpl> visibleItems = this.PlaceComponentResult.getVisibleItems();
            int size = visibleItems.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                MenuItemImpl menuItemImpl = visibleItems.get(i3);
                if (PlaceComponentResult(menuItemImpl)) {
                    View childAt = viewGroup.getChildAt(i2);
                    MenuItemImpl itemData = childAt instanceof MenuView.ItemView ? ((MenuView.ItemView) childAt).getItemData() : null;
                    View PlaceComponentResult = PlaceComponentResult(menuItemImpl, childAt, viewGroup);
                    if (menuItemImpl != itemData) {
                        PlaceComponentResult.setPressed(false);
                        PlaceComponentResult.jumpDrawablesToCurrentState();
                    }
                    if (PlaceComponentResult != childAt) {
                        ViewGroup viewGroup2 = (ViewGroup) PlaceComponentResult.getParent();
                        if (viewGroup2 != null) {
                            viewGroup2.removeView(PlaceComponentResult);
                        }
                        ((ViewGroup) this.scheduleImpl).addView(PlaceComponentResult, i2);
                    }
                    i2++;
                }
            }
            i = i2;
        }
        while (i < viewGroup.getChildCount()) {
            if (!BuiltInFictitiousFunctionClassFactory(viewGroup, i)) {
                i++;
            }
        }
    }

    public boolean BuiltInFictitiousFunctionClassFactory(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = callback;
    }

    public View PlaceComponentResult(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        MenuView.ItemView itemView;
        if (view instanceof MenuView.ItemView) {
            itemView = (MenuView.ItemView) view;
        } else {
            itemView = (MenuView.ItemView) this.getErrorConfigVersion.inflate(this.lookAheadTest, viewGroup, false);
        }
        getAuthRequestContext(menuItemImpl, itemView);
        return (View) itemView;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.Callback callback = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (callback != null) {
            callback.MyBillsEntityDataFactory(menuBuilder, z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.appcompat.view.menu.MenuBuilder] */
    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        MenuPresenter.Callback callback = this.KClassImpl$Data$declaredNonStaticMembers$2;
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        if (callback != null) {
            if (subMenuBuilder == null) {
                subMenuBuilder2 = this.PlaceComponentResult;
            }
            return callback.getAuthRequestContext(subMenuBuilder2);
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.MyBillsEntityDataFactory;
    }
}

package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ListMenuPresenter implements MenuPresenter, AdapterView.OnItemClickListener {
    int BuiltInFictitiousFunctionClassFactory;
    int KClassImpl$Data$declaredNonStaticMembers$2;
    public LayoutInflater MyBillsEntityDataFactory;
    MenuBuilder NetworkUserEntityData$$ExternalSyntheticLambda0;
    public MenuAdapter PlaceComponentResult;
    Context getAuthRequestContext;
    public ExpandedMenuView getErrorConfigVersion;
    int lookAheadTest;
    private MenuPresenter.Callback moveToNextValue;
    private int scheduleImpl;

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

    public ListMenuPresenter(Context context, int i) {
        this(i);
        this.getAuthRequestContext = context;
        this.MyBillsEntityDataFactory = LayoutInflater.from(context);
    }

    private ListMenuPresenter(int i) {
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.lookAheadTest = 0;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        if (this.lookAheadTest != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.lookAheadTest);
            this.getAuthRequestContext = contextThemeWrapper;
            this.MyBillsEntityDataFactory = LayoutInflater.from(contextThemeWrapper);
        } else if (this.getAuthRequestContext != null) {
            this.getAuthRequestContext = context;
            if (this.MyBillsEntityDataFactory == null) {
                this.MyBillsEntityDataFactory = LayoutInflater.from(context);
            }
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = menuBuilder;
        MenuAdapter menuAdapter = this.PlaceComponentResult;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        MenuAdapter menuAdapter = this.PlaceComponentResult;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.moveToNextValue = callback;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            MenuDialogHelper menuDialogHelper = new MenuDialogHelper(subMenuBuilder);
            MenuBuilder menuBuilder = menuDialogHelper.PlaceComponentResult;
            AlertDialog.Builder builder = new AlertDialog.Builder(menuBuilder.getContext());
            ListMenuPresenter listMenuPresenter = new ListMenuPresenter(builder.getContext(), R.layout.NetworkUserEntityData$$ExternalSyntheticLambda2);
            menuDialogHelper.BuiltInFictitiousFunctionClassFactory = listMenuPresenter;
            listMenuPresenter.setCallback(menuDialogHelper);
            menuDialogHelper.PlaceComponentResult.addMenuPresenter(menuDialogHelper.BuiltInFictitiousFunctionClassFactory);
            ListMenuPresenter listMenuPresenter2 = menuDialogHelper.BuiltInFictitiousFunctionClassFactory;
            if (listMenuPresenter2.PlaceComponentResult == null) {
                listMenuPresenter2.PlaceComponentResult = new MenuAdapter();
            }
            builder.setAdapter(listMenuPresenter2.PlaceComponentResult, menuDialogHelper);
            View headerView = menuBuilder.getHeaderView();
            if (headerView != null) {
                builder.setCustomTitle(headerView);
            } else {
                builder.setIcon(menuBuilder.getHeaderIcon()).setTitle(menuBuilder.getHeaderTitle());
            }
            builder.setOnKeyListener(menuDialogHelper);
            AlertDialog create = builder.create();
            menuDialogHelper.MyBillsEntityDataFactory = create;
            create.setOnDismissListener(menuDialogHelper);
            WindowManager.LayoutParams attributes = menuDialogHelper.MyBillsEntityDataFactory.getWindow().getAttributes();
            attributes.type = 1003;
            attributes.flags |= AntDetector.SCENE_ID_LOGIN_REGIST;
            menuDialogHelper.MyBillsEntityDataFactory.show();
            MenuPresenter.Callback callback = this.moveToNextValue;
            if (callback != null) {
                callback.getAuthRequestContext(subMenuBuilder);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.Callback callback = this.moveToNextValue;
        if (callback != null) {
            callback.MyBillsEntityDataFactory(menuBuilder, z);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.performItemAction(this.PlaceComponentResult.getItem(i), this, 0);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.scheduleImpl;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        if (this.getErrorConfigVersion == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.getErrorConfigVersion;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        SparseArray<Parcelable> sparseParcelableArray = ((Bundle) parcelable).getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.getErrorConfigVersion.restoreHierarchyState(sparseParcelableArray);
        }
    }

    /* loaded from: classes.dex */
    public class MenuAdapter extends BaseAdapter {
        private int KClassImpl$Data$declaredNonStaticMembers$2 = -1;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        public MenuAdapter() {
            MyBillsEntityDataFactory();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = ListMenuPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0.getNonActionItems().size() - ListMenuPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
            return this.KClassImpl$Data$declaredNonStaticMembers$2 < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
        public final MenuItemImpl getItem(int i) {
            ArrayList<MenuItemImpl> nonActionItems = ListMenuPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0.getNonActionItems();
            int i2 = i + ListMenuPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
            int i3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return nonActionItems.get(i2);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = ListMenuPresenter.this.MyBillsEntityDataFactory.inflate(ListMenuPresenter.this.BuiltInFictitiousFunctionClassFactory, viewGroup, false);
            }
            ((MenuView.ItemView) view).initialize(getItem(i), 0);
            return view;
        }

        private void MyBillsEntityDataFactory() {
            MenuItemImpl expandedItem = ListMenuPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<MenuItemImpl> nonActionItems = ListMenuPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0.getNonActionItems();
                int size = nonActionItems.size();
                for (int i = 0; i < size; i++) {
                    if (nonActionItems.get(i) == expandedItem) {
                        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
                        return;
                    }
                }
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            MyBillsEntityDataFactory();
            super.notifyDataSetChanged();
        }
    }
}

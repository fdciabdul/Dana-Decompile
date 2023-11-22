package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MenuAdapter extends BaseAdapter {
    public MenuBuilder BuiltInFictitiousFunctionClassFactory;
    private final int KClassImpl$Data$declaredNonStaticMembers$2;
    boolean MyBillsEntityDataFactory;
    private int PlaceComponentResult = -1;
    private final LayoutInflater getAuthRequestContext;
    private final boolean lookAheadTest;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public MenuAdapter(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z, int i) {
        this.lookAheadTest = z;
        this.getAuthRequestContext = layoutInflater;
        this.BuiltInFictitiousFunctionClassFactory = menuBuilder;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<MenuItemImpl> nonActionItems = this.lookAheadTest ? this.BuiltInFictitiousFunctionClassFactory.getNonActionItems() : this.BuiltInFictitiousFunctionClassFactory.getVisibleItems();
        if (this.PlaceComponentResult < 0) {
            return nonActionItems.size();
        }
        return nonActionItems.size() - 1;
    }

    @Override // android.widget.Adapter
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
    public final MenuItemImpl getItem(int i) {
        ArrayList<MenuItemImpl> nonActionItems = this.lookAheadTest ? this.BuiltInFictitiousFunctionClassFactory.getNonActionItems() : this.BuiltInFictitiousFunctionClassFactory.getVisibleItems();
        int i2 = this.PlaceComponentResult;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return nonActionItems.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.getAuthRequestContext.inflate(this.KClassImpl$Data$declaredNonStaticMembers$2, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.BuiltInFictitiousFunctionClassFactory.isGroupDividerEnabled() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        MenuView.ItemView itemView = (MenuView.ItemView) view;
        if (this.MyBillsEntityDataFactory) {
            listMenuItemView.setForceShowIcon(true);
        }
        itemView.initialize(getItem(i), 0);
        return view;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        MenuItemImpl expandedItem = this.BuiltInFictitiousFunctionClassFactory.getExpandedItem();
        if (expandedItem != null) {
            ArrayList<MenuItemImpl> nonActionItems = this.BuiltInFictitiousFunctionClassFactory.getNonActionItems();
            int size = nonActionItems.size();
            for (int i = 0; i < size; i++) {
                if (nonActionItems.get(i) == expandedItem) {
                    this.PlaceComponentResult = i;
                    return;
                }
            }
        }
        this.PlaceComponentResult = -1;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        KClassImpl$Data$declaredNonStaticMembers$2();
        super.notifyDataSetChanged();
    }
}

package com.alibaba.griver.core.ui.menu;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.griver.api.common.menu.GRVBaseAppFavoriteMenuItem;
import com.alibaba.griver.api.common.menu.GRVMPMoreMenuItemPriority;
import com.alibaba.griver.core.R;
import com.iap.ac.android.acs.operation.biz.region.bean.MenuExtraInfo;
import id.dana.tracker.mixpanel.RegistrationEvent;

/* loaded from: classes3.dex */
public class GRVAppFavoriteMenuItem extends GRVBaseAppFavoriteMenuItem {
    public boolean showTitle;
    public Status status;
    public int titleStatus;

    @Override // com.alibaba.griver.api.common.menu.GRVBaseAppFavoriteMenuItem
    public int getAppFavoriteStatus() {
        return this.status.getValue();
    }

    @Override // com.alibaba.griver.api.common.menu.GRVBaseAppFavoriteMenuItem
    public int getAppTitleFavoriteStatus() {
        return this.titleStatus;
    }

    /* loaded from: classes3.dex */
    public enum Status {
        GRVAppFavoriteStatusUnKnow(-1),
        GRVAppFavoriteStatusUncollected(0),
        GRVAppFavoriteStatusCollected(1);

        int value;

        Status(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }

        public final Status parseValue(int i) {
            Status status = GRVAppFavoriteStatusUnKnow;
            if (i != -1) {
                if (i != 0) {
                    return i != 1 ? status : GRVAppFavoriteStatusCollected;
                }
                return GRVAppFavoriteStatusUncollected;
            }
            return status;
        }
    }

    public GRVAppFavoriteMenuItem() {
        this.identifier = MenuExtraInfo.MENU_ID_COLLECT;
        this.status = Status.GRVAppFavoriteStatusUnKnow;
        this.priority = GRVMPMoreMenuItemPriority.GRVMPMoreMenuItemPriorityHigh;
        a(this.status);
        this.row = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alibaba.griver.core.ui.menu.GRVAppFavoriteMenuItem$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$griver$core$ui$menu$GRVAppFavoriteMenuItem$Status;

        static {
            int[] iArr = new int[Status.values().length];
            $SwitchMap$com$alibaba$griver$core$ui$menu$GRVAppFavoriteMenuItem$Status = iArr;
            try {
                iArr[Status.GRVAppFavoriteStatusUnKnow.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$griver$core$ui$menu$GRVAppFavoriteMenuItem$Status[Status.GRVAppFavoriteStatusCollected.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$griver$core$ui$menu$GRVAppFavoriteMenuItem$Status[Status.GRVAppFavoriteStatusUncollected.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void a(Status status) {
        this.status = status;
        int i = AnonymousClass1.$SwitchMap$com$alibaba$griver$core$ui$menu$GRVAppFavoriteMenuItem$Status[status.ordinal()];
        if (i == 1) {
            this.name = RegistrationEvent.ProfilePhotoSource.NO_ANSWER;
            this.iconDrawable = R.drawable.griver_core_menu_favorites_error;
        } else if (i == 2) {
            if (this.itemInfos != null && this.itemInfos.containsKey("HIGHLIGHT")) {
                this.name = this.itemInfos.get("HIGHLIGHT").iconName;
                this.iconUrl = this.itemInfos.get("HIGHLIGHT").iconUrl;
            } else {
                this.name = "Remove\nfrom Favorites";
            }
            this.iconDrawable = R.drawable.griver_core_menu_favorites_remove;
        } else if (i == 3) {
            if (this.itemInfos != null && this.itemInfos.containsKey("DEFAULT")) {
                this.name = this.itemInfos.get("DEFAULT").iconName;
                this.iconUrl = this.itemInfos.get("DEFAULT").iconUrl;
            } else {
                this.name = "Add to\nFavorites";
            }
            this.iconDrawable = R.drawable.griver_core_menu_favorites_add;
        }
    }

    @Override // com.alibaba.griver.api.common.menu.GRVMPMoreMenuItem
    public void notifyDataSetChanged() {
        a(this.status);
        super.notifyDataSetChanged();
    }

    @Override // com.alibaba.griver.api.common.menu.GRVBaseAppFavoriteMenuItem
    public boolean canShowTitle() {
        return this.status != Status.GRVAppFavoriteStatusUnKnow && this.showTitle;
    }

    @Override // com.alibaba.griver.api.common.menu.GriverMenuItem
    public boolean canShow(Page page) {
        return this.status != Status.GRVAppFavoriteStatusUnKnow && this.show;
    }
}

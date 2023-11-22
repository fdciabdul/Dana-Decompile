package id.dana.base;

import com.zhuinden.simplestack.Backstack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u000e\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005\u0012\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000b"}, d2 = {"Lid/dana/base/OnActivityNavigationManagerWithMenu;", "Lid/dana/base/NavigationManager;", "", "PlaceComponentResult", "()V", "Lid/dana/base/KeyBaseActivity;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/base/KeyBaseActivity;", "Lid/dana/base/KeyBaseActivity;", "MyBillsEntityDataFactory", "Lid/dana/base/MenuItemButtonListener;", "Lid/dana/base/MenuItemButtonListener;", "Lid/dana/base/MenuItemFacade;", "Lid/dana/base/MenuItemFacade;", "getAuthRequestContext", "Lcom/zhuinden/simplestack/Backstack;", "p0", "p1", "p2", "<init>", "(Lcom/zhuinden/simplestack/Backstack;Lid/dana/base/KeyBaseActivity;Lid/dana/base/MenuItemFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class OnActivityNavigationManagerWithMenu extends NavigationManager {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public MenuItemButtonListener PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final MenuItemFacade KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final KeyBaseActivity<?, ?> MyBillsEntityDataFactory;
    public MenuItemButtonListener getAuthRequestContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnActivityNavigationManagerWithMenu(Backstack backstack, KeyBaseActivity<?, ?> keyBaseActivity, MenuItemFacade menuItemFacade) {
        super(backstack);
        Intrinsics.checkNotNullParameter(backstack, "");
        Intrinsics.checkNotNullParameter(keyBaseActivity, "");
        Intrinsics.checkNotNullParameter(menuItemFacade, "");
        this.MyBillsEntityDataFactory = keyBaseActivity;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = menuItemFacade;
    }

    public final KeyBaseActivity<?, ?> KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }

    public final void PlaceComponentResult() {
        this.MyBillsEntityDataFactory.finish();
    }
}

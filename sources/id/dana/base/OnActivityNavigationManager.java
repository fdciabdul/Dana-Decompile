package id.dana.base;

import com.zhuinden.simplestack.Backstack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/base/OnActivityNavigationManager;", "Lid/dana/base/NavigationManager;", "Lid/dana/base/SingleBaseActivity;", "getAuthRequestContext", "Lid/dana/base/SingleBaseActivity;", "MyBillsEntityDataFactory", "Lcom/zhuinden/simplestack/Backstack;", "p0", "p1", "<init>", "(Lcom/zhuinden/simplestack/Backstack;Lid/dana/base/SingleBaseActivity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class OnActivityNavigationManager extends NavigationManager {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final SingleBaseActivity<?> MyBillsEntityDataFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnActivityNavigationManager(Backstack backstack, SingleBaseActivity<?> singleBaseActivity) {
        super(backstack);
        Intrinsics.checkNotNullParameter(backstack, "");
        Intrinsics.checkNotNullParameter(singleBaseActivity, "");
        this.MyBillsEntityDataFactory = singleBaseActivity;
    }
}

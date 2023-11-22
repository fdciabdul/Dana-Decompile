package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/Menu;", "", "Landroid/view/MenuItem;", "MyBillsEntityDataFactory", "(Landroid/view/Menu;)Ljava/util/Iterator;"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class MenuKt {
    public static final Iterator<MenuItem> MyBillsEntityDataFactory(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "");
        return new MenuKt$iterator$1(menu);
    }
}

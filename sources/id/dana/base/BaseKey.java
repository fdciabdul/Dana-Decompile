package id.dana.base;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import id.dana.base.Key;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H$¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004"}, d2 = {"Lid/dana/base/BaseKey;", "Lid/dana/base/Key;", "Landroidx/fragment/app/Fragment;", "MyBillsEntityDataFactory", "()Landroidx/fragment/app/Fragment;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseKey implements Key {
    protected abstract Fragment MyBillsEntityDataFactory();

    public final Fragment KClassImpl$Data$declaredNonStaticMembers$2() {
        String str;
        Fragment MyBillsEntityDataFactory = MyBillsEntityDataFactory();
        Bundle arguments = MyBillsEntityDataFactory.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        str = Key.Companion.getAuthRequestContext;
        arguments.putParcelable(str, this);
        MyBillsEntityDataFactory.setArguments(arguments);
        return MyBillsEntityDataFactory;
    }
}

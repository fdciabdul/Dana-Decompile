package id.dana.mybills.utils;

import android.content.Context;
import id.dana.mybills.R;
import id.dana.mybills.ui.constant.RecurringType;
import id.dana.mybills.ui.model.DropdownOptionsModel;
import id.dana.mybills.ui.model.MoneyViewModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\b"}, d2 = {"Lid/dana/mybills/utils/AddNewBillsUtils;", "", "Landroid/content/Context;", "p0", "Ljava/util/ArrayList;", "Lid/dana/mybills/ui/model/DropdownOptionsModel;", "Lkotlin/collections/ArrayList;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;)Ljava/util/ArrayList;", "MyBillsEntityDataFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class AddNewBillsUtils {
    public static final AddNewBillsUtils INSTANCE = new AddNewBillsUtils();

    private AddNewBillsUtils() {
    }

    public static ArrayList<DropdownOptionsModel> MyBillsEntityDataFactory(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ArrayList<DropdownOptionsModel> arrayList = new ArrayList<>();
        String str = null;
        MoneyViewModel moneyViewModel = null;
        int i = 10;
        DefaultConstructorMarker defaultConstructorMarker = null;
        arrayList.add(new DropdownOptionsModel(p0.getString(R.string.my_bills_recurring_manual), str, RecurringType.REMINDER, moneyViewModel, Integer.valueOf(R.drawable.ic_mybills_reminder), i, defaultConstructorMarker));
        arrayList.add(new DropdownOptionsModel(p0.getString(R.string.my_bills_recurring_automatic), str, RecurringType.AUTO_DEDUCTION, moneyViewModel, Integer.valueOf(R.drawable.ic_mybills_auto_deduction), i, defaultConstructorMarker));
        return arrayList;
    }

    public static ArrayList<DropdownOptionsModel> BuiltInFictitiousFunctionClassFactory(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ArrayList<DropdownOptionsModel> arrayList = new ArrayList<>();
        String str = null;
        MoneyViewModel moneyViewModel = null;
        Integer num = null;
        int i = 26;
        DefaultConstructorMarker defaultConstructorMarker = null;
        arrayList.add(new DropdownOptionsModel(p0.getString(R.string.my_bills_postpaid), str, "ELECTRICITY_POST", moneyViewModel, num, i, defaultConstructorMarker));
        arrayList.add(new DropdownOptionsModel(p0.getString(R.string.my_bills_prepaid), str, "ELECTRICITY", moneyViewModel, num, i, defaultConstructorMarker));
        return arrayList;
    }
}

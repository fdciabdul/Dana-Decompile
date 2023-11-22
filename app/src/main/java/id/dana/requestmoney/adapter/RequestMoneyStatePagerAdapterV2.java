package id.dana.requestmoney.adapter;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment;
import id.dana.requestmoney.bank.RequestMoneyAddBankQrCardFragment;
import id.dana.requestmoney.bank.RequestMoneyBankQrCardFragment;
import id.dana.requestmoney.model.UserBankModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0005\u001a\u00020\u0019\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0010\u001b\u001a\u00020\u0011¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0015\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/requestmoney/adapter/RequestMoneyStatePagerAdapterV2;", "Lid/dana/requestmoney/adapter/BaseFragmentPagerStateAdapterV2;", "", "getCount", "()I", "p0", "Landroidx/fragment/app/Fragment;", "getAuthRequestContext", "(I)Landroidx/fragment/app/Fragment;", "", "getItemPosition", "(Ljava/lang/Object;)I", "", "BuiltInFictitiousFunctionClassFactory", "()Z", "MyBillsEntityDataFactory", "(I)Z", "", "Ljava/lang/String;", "", "Lid/dana/requestmoney/model/UserBankModel;", "PlaceComponentResult", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "Landroidx/fragment/app/FragmentManager;", "p1", "p2", "<init>", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RequestMoneyStatePagerAdapterV2 extends BaseFragmentPagerStateAdapterV2 {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public int PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public List<UserBankModel> KClassImpl$Data$declaredNonStaticMembers$2;
    private String getAuthRequestContext;

    private static boolean MyBillsEntityDataFactory(int p0) {
        return p0 == 0;
    }

    public /* synthetic */ RequestMoneyStatePagerAdapterV2(FragmentManager fragmentManager, ArrayList arrayList, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentManager, (i & 2) != 0 ? new ArrayList() : arrayList, str);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private RequestMoneyStatePagerAdapterV2(androidx.fragment.app.FragmentManager r4, java.util.List<id.dana.requestmoney.model.UserBankModel> r5, java.lang.String r6) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment r0 = new id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment
            r0.<init>()
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.String r2 = "source"
            r1.putString(r2, r6)
            r0.setArguments(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r0)
            r3.<init>(r4, r0)
            r3.KClassImpl$Data$declaredNonStaticMembers$2 = r5
            r3.getAuthRequestContext = r6
            r4 = -1
            r3.PlaceComponentResult = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.requestmoney.adapter.RequestMoneyStatePagerAdapterV2.<init>(androidx.fragment.app.FragmentManager, java.util.List, java.lang.String):void");
    }

    @Override // id.dana.requestmoney.adapter.BaseFragmentPagerStateAdapterV2, androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return BuiltInFictitiousFunctionClassFactory() ? this.KClassImpl$Data$declaredNonStaticMembers$2.size() + 2 : this.KClassImpl$Data$declaredNonStaticMembers$2.size() + 1;
    }

    @Override // id.dana.requestmoney.adapter.BaseFragmentPagerStateAdapterV2, androidx.fragment.app.FragmentStatePagerAdapter
    public final Fragment getAuthRequestContext(int p0) {
        if (MyBillsEntityDataFactory(p0)) {
            RequestMoneyBalanceQrCardFragment requestMoneyBalanceQrCardFragment = new RequestMoneyBalanceQrCardFragment();
            Bundle bundle = new Bundle();
            bundle.putString("source", this.getAuthRequestContext);
            requestMoneyBalanceQrCardFragment.setArguments(bundle);
            return requestMoneyBalanceQrCardFragment;
        } else if (BuiltInFictitiousFunctionClassFactory() && BuiltInFictitiousFunctionClassFactory(p0)) {
            return new RequestMoneyAddBankQrCardFragment();
        } else {
            RequestMoneyBankQrCardFragment.Companion companion = RequestMoneyBankQrCardFragment.INSTANCE;
            return RequestMoneyBankQrCardFragment.Companion.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get(p0 - 1));
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getItemPosition(Object p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if ((p0 instanceof RequestMoneyAddBankQrCardFragment) || (p0 instanceof RequestMoneyBankQrCardFragment)) {
            return -2;
        }
        return super.getItemPosition(p0);
    }

    private final boolean BuiltInFictitiousFunctionClassFactory(int p0) {
        return p0 == getCount() - 1;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.size() < this.PlaceComponentResult;
    }
}

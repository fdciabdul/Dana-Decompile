package com.ipification.mobile.sdk.im.util;

import android.content.pm.PackageManager;
import androidx.fragment.app.Fragment;
import com.ipification.mobile.sdk.im.data.IMInfo;
import com.ipification.mobile.sdk.im.ui.fragment.IMListFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/ipification/mobile/sdk/im/util/VerificationExtensionKt;", "", "<init>", "()V", "Factory"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class VerificationExtensionKt {

    /* renamed from: Factory  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\bJ#\u0010\u000e\u001a\u00020\r2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lcom/ipification/mobile/sdk/im/util/VerificationExtensionKt$Factory;", "", "", "Lcom/ipification/mobile/sdk/im/data/IMInfo;", "p0", "Landroid/content/pm/PackageManager;", "p1", "getAuthRequestContext", "(Ljava/util/List;Landroid/content/pm/PackageManager;)Ljava/util/List;", "Landroidx/fragment/app/Fragment;", "PlaceComponentResult", "(Ljava/util/List;)Landroidx/fragment/app/Fragment;", "BuiltInFictitiousFunctionClassFactory", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;Landroid/content/pm/PackageManager;)Z", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: com.ipification.mobile.sdk.im.util.VerificationExtensionKt$Factory  reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static boolean KClassImpl$Data$declaredNonStaticMembers$2(List<IMInfo> p0, PackageManager p1) {
            Intrinsics.checkParameterIsNotNull(p0, "");
            Intrinsics.checkParameterIsNotNull(p1, "");
            return BuiltInFictitiousFunctionClassFactory(p0, p1).isEmpty() ^ true;
        }

        public static Fragment PlaceComponentResult(List<IMInfo> p0) {
            Intrinsics.checkParameterIsNotNull(p0, "");
            IMListFragment.Companion companion = IMListFragment.INSTANCE;
            return IMListFragment.Companion.MyBillsEntityDataFactory(p0);
        }

        public static List<IMInfo> BuiltInFictitiousFunctionClassFactory(List<IMInfo> p0, PackageManager p1) {
            ArrayList arrayList = new ArrayList();
            for (IMInfo iMInfo : p0) {
                if (VerificationExtensionKtKt.MyBillsEntityDataFactory(p1, iMInfo.PlaceComponentResult) || (iMInfo.KClassImpl$Data$declaredNonStaticMembers$2 != null && VerificationExtensionKtKt.MyBillsEntityDataFactory(p1, iMInfo.KClassImpl$Data$declaredNonStaticMembers$2))) {
                    arrayList.add(iMInfo);
                }
            }
            return arrayList;
        }

        public static List<IMInfo> getAuthRequestContext(List<IMInfo> p0, PackageManager p1) {
            Intrinsics.checkParameterIsNotNull(p0, "");
            Intrinsics.checkParameterIsNotNull(p1, "");
            ArrayList arrayList = new ArrayList();
            for (IMInfo iMInfo : p0) {
                if (VerificationExtensionKtKt.MyBillsEntityDataFactory(p1, iMInfo.PlaceComponentResult)) {
                    iMInfo.getAuthRequestContext = true;
                }
                if (iMInfo.KClassImpl$Data$declaredNonStaticMembers$2 != null && VerificationExtensionKtKt.MyBillsEntityDataFactory(p1, iMInfo.KClassImpl$Data$declaredNonStaticMembers$2)) {
                    String str = iMInfo.KClassImpl$Data$declaredNonStaticMembers$2;
                    Intrinsics.checkParameterIsNotNull(str, "");
                    iMInfo.PlaceComponentResult = str;
                    iMInfo.getAuthRequestContext = true;
                }
                arrayList.add(iMInfo);
            }
            return arrayList;
        }
    }
}

package androidx.view;

import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.viewmodel.CreationExtras;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u0007¢\u0006\u0004\b\u0011\u0010\nJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Landroidx/navigation/NavControllerViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/navigation/NavViewModelStoreProvider;", "", "p0", "Landroidx/lifecycle/ViewModelStore;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Landroidx/lifecycle/ViewModelStore;", "", "onCleared", "()V", "toString", "()Ljava/lang/String;", "", "PlaceComponentResult", "Ljava/util/Map;", "MyBillsEntityDataFactory", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NavControllerViewModel extends ViewModel implements NavViewModelStoreProvider {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final Map<String, ViewModelStore> MyBillsEntityDataFactory = new LinkedHashMap();
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {TarHeader.LF_DIR, 93, -14, -126, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int BuiltInFictitiousFunctionClassFactory = 125;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ViewModelProvider.Factory MyBillsEntityDataFactory = new ViewModelProvider.Factory() { // from class: androidx.navigation.NavControllerViewModel$Companion$FACTORY$1
        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final /* synthetic */ ViewModel MyBillsEntityDataFactory(Class cls, CreationExtras creationExtras) {
            return ViewModelProvider.Factory.CC.BuiltInFictitiousFunctionClassFactory(this, cls, creationExtras);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final <T extends ViewModel> T BuiltInFictitiousFunctionClassFactory(Class<T> p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new NavControllerViewModel();
        }
    };

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 15
            int r6 = r6 + 4
            byte[] r0 = androidx.view.NavControllerViewModel.KClassImpl$Data$declaredNonStaticMembers$2
            int r7 = 106 - r7
            int r8 = r8 * 3
            int r8 = r8 + 16
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r4 = r7
            r3 = 0
            r7 = r6
            goto L2c
        L17:
            r3 = 0
            r5 = r7
            r7 = r6
            r6 = r5
        L1b:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            int r3 = r3 + 1
            r4 = r0[r7]
        L2c:
            int r4 = -r4
            int r6 = r6 + r4
            int r6 = r6 + 2
            int r7 = r7 + 1
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.view.NavControllerViewModel.a(byte, int, short, java.lang.Object[]):void");
    }

    @Override // androidx.view.ViewModel
    public final void onCleared() {
        Iterator<ViewModelStore> it = this.MyBillsEntityDataFactory.values().iterator();
        while (it.hasNext()) {
            it.next().PlaceComponentResult();
        }
        this.MyBillsEntityDataFactory.clear();
    }

    @Override // androidx.view.NavViewModelStoreProvider
    public final ViewModelStore KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ViewModelStore viewModelStore = this.MyBillsEntityDataFactory.get(p0);
        if (viewModelStore == null) {
            ViewModelStore viewModelStore2 = new ViewModelStore();
            this.MyBillsEntityDataFactory.put(p0, viewModelStore2);
            return viewModelStore2;
        }
        return viewModelStore;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NavControllerViewModel{");
        try {
            Object[] objArr = {this};
            byte b = KClassImpl$Data$declaredNonStaticMembers$2[5];
            byte b2 = (byte) (b - 1);
            Object[] objArr2 = new Object[1];
            a(b, b2, b2, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
            byte b4 = KClassImpl$Data$declaredNonStaticMembers$2[5];
            Object[] objArr3 = new Object[1];
            a(b3, b4, (byte) (b4 - 1), objArr3);
            sb.append(Integer.toHexString(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue()));
            sb.append("} ViewModelStores (");
            Iterator<String> it = this.MyBillsEntityDataFactory.keySet().iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                if (it.hasNext()) {
                    sb.append(", ");
                }
            }
            sb.append(')');
            String obj = sb.toString();
            Intrinsics.checkNotNullExpressionValue(obj, "");
            return obj;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\b"}, d2 = {"Landroidx/navigation/NavControllerViewModel$Companion;", "", "Landroidx/lifecycle/ViewModelStore;", "p0", "Landroidx/navigation/NavControllerViewModel;", "MyBillsEntityDataFactory", "(Landroidx/lifecycle/ViewModelStore;)Landroidx/navigation/NavControllerViewModel;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "PlaceComponentResult", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static NavControllerViewModel MyBillsEntityDataFactory(ViewModelStore p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return (NavControllerViewModel) new ViewModelProvider(p0, NavControllerViewModel.MyBillsEntityDataFactory, null, 4, null).MyBillsEntityDataFactory(NavControllerViewModel.class);
        }
    }
}

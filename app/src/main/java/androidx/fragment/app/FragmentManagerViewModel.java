package androidx.fragment.app;

import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.viewmodel.CreationExtras;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class FragmentManagerViewModel extends ViewModel {
    public static final byte[] lookAheadTest = {116, -27, -60, 115, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int moveToNextValue = 8;
    private static final ViewModelProvider.Factory scheduleImpl = new ViewModelProvider.Factory() { // from class: androidx.fragment.app.FragmentManagerViewModel.1
        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final /* synthetic */ ViewModel MyBillsEntityDataFactory(Class cls, CreationExtras creationExtras) {
            return ViewModelProvider.Factory.CC.BuiltInFictitiousFunctionClassFactory(this, cls, creationExtras);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final <T extends ViewModel> T BuiltInFictitiousFunctionClassFactory(Class<T> cls) {
            return new FragmentManagerViewModel(true);
        }
    };
    final boolean MyBillsEntityDataFactory;
    final HashMap<String, Fragment> BuiltInFictitiousFunctionClassFactory = new HashMap<>();
    final HashMap<String, FragmentManagerViewModel> PlaceComponentResult = new HashMap<>();
    final HashMap<String, ViewModelStore> getAuthRequestContext = new HashMap<>();
    private boolean getErrorConfigVersion = false;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0028 -> B:23:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 + 4
            int r9 = 106 - r9
            int r8 = r8 * 2
            int r8 = 16 - r8
            byte[] r0 = androidx.fragment.app.FragmentManagerViewModel.lookAheadTest
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L31
        L16:
            r3 = 0
        L17:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            int r7 = r7 + 1
            r1[r3] = r5
            if (r4 != r8) goto L28
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L28:
            r3 = r0[r7]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L31:
            int r10 = r10 + r8
            int r8 = r10 + 2
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManagerViewModel.a(int, short, byte, java.lang.Object[]):void");
    }

    public static FragmentManagerViewModel KClassImpl$Data$declaredNonStaticMembers$2(ViewModelStore viewModelStore) {
        return (FragmentManagerViewModel) new ViewModelProvider(viewModelStore, scheduleImpl).MyBillsEntityDataFactory(FragmentManagerViewModel.class);
    }

    public FragmentManagerViewModel(boolean z) {
        this.MyBillsEntityDataFactory = z;
    }

    @Override // androidx.view.ViewModel
    public final void onCleared() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("onCleared called for ");
            sb.append(this);
            InstrumentInjector.log_d(FragmentManager.TAG, sb.toString());
        }
        this.getErrorConfigVersion = true;
    }

    public final boolean PlaceComponentResult() {
        return this.getErrorConfigVersion;
    }

    public final void MyBillsEntityDataFactory(Fragment fragment) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            if (FragmentManager.isLoggingEnabled(2)) {
                InstrumentInjector.log_v(FragmentManager.TAG, "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.BuiltInFictitiousFunctionClassFactory.containsKey(fragment.mWho)) {
        } else {
            this.BuiltInFictitiousFunctionClassFactory.put(fragment.mWho, fragment);
            if (FragmentManager.isLoggingEnabled(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Updating retained Fragments: Added ");
                sb.append(fragment);
                InstrumentInjector.log_v(FragmentManager.TAG, sb.toString());
            }
        }
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Fragment fragment) {
        if (this.BuiltInFictitiousFunctionClassFactory.containsKey(fragment.mWho)) {
            if (this.MyBillsEntityDataFactory) {
                return this.getErrorConfigVersion;
            }
            return !this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
        return true;
    }

    public final void BuiltInFictitiousFunctionClassFactory(Fragment fragment) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            if (FragmentManager.isLoggingEnabled(2)) {
                InstrumentInjector.log_v(FragmentManager.TAG, "Ignoring removeRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        if ((this.BuiltInFictitiousFunctionClassFactory.remove(fragment.mWho) != null) && FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Updating retained Fragments: Removed ");
            sb.append(fragment);
            InstrumentInjector.log_v(FragmentManager.TAG, sb.toString());
        }
    }

    public final void PlaceComponentResult(Fragment fragment) {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Clearing non-config state for ");
            sb.append(fragment);
            InstrumentInjector.log_d(FragmentManager.TAG, sb.toString());
        }
        MyBillsEntityDataFactory(fragment.mWho);
    }

    public final void MyBillsEntityDataFactory(String str) {
        FragmentManagerViewModel fragmentManagerViewModel = this.PlaceComponentResult.get(str);
        if (fragmentManagerViewModel != null) {
            fragmentManagerViewModel.onCleared();
            this.PlaceComponentResult.remove(str);
        }
        ViewModelStore viewModelStore = this.getAuthRequestContext.get(str);
        if (viewModelStore != null) {
            viewModelStore.PlaceComponentResult();
            this.getAuthRequestContext.remove(str);
        }
    }

    @Deprecated
    public final void MyBillsEntityDataFactory(FragmentManagerNonConfig fragmentManagerNonConfig) {
        this.BuiltInFictitiousFunctionClassFactory.clear();
        this.PlaceComponentResult.clear();
        this.getAuthRequestContext.clear();
        if (fragmentManagerNonConfig != null) {
            Collection<Fragment> collection = fragmentManagerNonConfig.getAuthRequestContext;
            if (collection != null) {
                for (Fragment fragment : collection) {
                    if (fragment != null) {
                        this.BuiltInFictitiousFunctionClassFactory.put(fragment.mWho, fragment);
                    }
                }
            }
            Map<String, FragmentManagerNonConfig> map = fragmentManagerNonConfig.PlaceComponentResult;
            if (map != null) {
                for (Map.Entry<String, FragmentManagerNonConfig> entry : map.entrySet()) {
                    FragmentManagerViewModel fragmentManagerViewModel = new FragmentManagerViewModel(this.MyBillsEntityDataFactory);
                    fragmentManagerViewModel.MyBillsEntityDataFactory(entry.getValue());
                    this.PlaceComponentResult.put(entry.getKey(), fragmentManagerViewModel);
                }
            }
            Map<String, ViewModelStore> map2 = fragmentManagerNonConfig.BuiltInFictitiousFunctionClassFactory;
            if (map2 != null) {
                this.getAuthRequestContext.putAll(map2);
            }
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    }

    @Deprecated
    public final FragmentManagerNonConfig MyBillsEntityDataFactory() {
        if (this.BuiltInFictitiousFunctionClassFactory.isEmpty() && this.PlaceComponentResult.isEmpty() && this.getAuthRequestContext.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, FragmentManagerViewModel> entry : this.PlaceComponentResult.entrySet()) {
            FragmentManagerNonConfig MyBillsEntityDataFactory = entry.getValue().MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory != null) {
                hashMap.put(entry.getKey(), MyBillsEntityDataFactory);
            }
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        if (this.BuiltInFictitiousFunctionClassFactory.isEmpty() && hashMap.isEmpty() && this.getAuthRequestContext.isEmpty()) {
            return null;
        }
        return new FragmentManagerNonConfig(new ArrayList(this.BuiltInFictitiousFunctionClassFactory.values()), hashMap, new HashMap(this.getAuthRequestContext));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) obj;
        return this.BuiltInFictitiousFunctionClassFactory.equals(fragmentManagerViewModel.BuiltInFictitiousFunctionClassFactory) && this.PlaceComponentResult.equals(fragmentManagerViewModel.PlaceComponentResult) && this.getAuthRequestContext.equals(fragmentManagerViewModel.getAuthRequestContext);
    }

    public final int hashCode() {
        return (((this.BuiltInFictitiousFunctionClassFactory.hashCode() * 31) + this.PlaceComponentResult.hashCode()) * 31) + this.getAuthRequestContext.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        try {
            Object[] objArr = {this};
            byte b = (byte) (moveToNextValue | 6);
            byte b2 = (byte) (lookAheadTest[5] + 1);
            Object[] objArr2 = new Object[1];
            a(b, b2, b2, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b3 = lookAheadTest[5];
            Object[] objArr3 = new Object[1];
            a(b3, (byte) (b3 + 1), (byte) (-lookAheadTest[5]), objArr3);
            sb.append(Integer.toHexString(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue()));
            sb.append("} Fragments (");
            Iterator<Fragment> it = this.BuiltInFictitiousFunctionClassFactory.values().iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                if (it.hasNext()) {
                    sb.append(", ");
                }
            }
            sb.append(") Child Non Config (");
            Iterator<String> it2 = this.PlaceComponentResult.keySet().iterator();
            while (it2.hasNext()) {
                sb.append(it2.next());
                if (it2.hasNext()) {
                    sb.append(", ");
                }
            }
            sb.append(") ViewModelStores (");
            Iterator<String> it3 = this.getAuthRequestContext.keySet().iterator();
            while (it3.hasNext()) {
                sb.append(it3.next());
                if (it3.hasNext()) {
                    sb.append(", ");
                }
            }
            sb.append(')');
            return sb.toString();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}

package androidx.fragment.app;

import android.view.ViewGroup;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class FragmentStore {
    FragmentManagerViewModel BuiltInFictitiousFunctionClassFactory;
    final ArrayList<Fragment> PlaceComponentResult = new ArrayList<>();
    final HashMap<String, FragmentStateManager> KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap<>();
    final HashMap<String, FragmentState> MyBillsEntityDataFactory = new HashMap<>();

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Fragment fragment) {
        if (this.PlaceComponentResult.contains(fragment)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment already added: ");
            sb.append(fragment);
            throw new IllegalStateException(sb.toString());
        }
        synchronized (this.PlaceComponentResult) {
            this.PlaceComponentResult.add(fragment);
        }
        fragment.mAdded = true;
    }

    public final ArrayList<String> MyBillsEntityDataFactory() {
        synchronized (this.PlaceComponentResult) {
            if (this.PlaceComponentResult.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.PlaceComponentResult.size());
            Iterator<Fragment> it = this.PlaceComponentResult.iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                arrayList.add(next.mWho);
                if (FragmentManager.isLoggingEnabled(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("saveAllState: adding fragment (");
                    sb.append(next.mWho);
                    sb.append("): ");
                    sb.append(next);
                    InstrumentInjector.log_v(FragmentManager.TAG, sb.toString());
                }
            }
            return arrayList;
        }
    }

    public final List<FragmentStateManager> KClassImpl$Data$declaredNonStaticMembers$2() {
        ArrayList arrayList = new ArrayList();
        for (FragmentStateManager fragmentStateManager : this.KClassImpl$Data$declaredNonStaticMembers$2.values()) {
            if (fragmentStateManager != null) {
                arrayList.add(fragmentStateManager);
            }
        }
        return arrayList;
    }

    public final List<Fragment> getAuthRequestContext() {
        ArrayList arrayList;
        if (this.PlaceComponentResult.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.PlaceComponentResult) {
            arrayList = new ArrayList(this.PlaceComponentResult);
        }
        return arrayList;
    }

    public final List<Fragment> PlaceComponentResult() {
        ArrayList arrayList = new ArrayList();
        for (FragmentStateManager fragmentStateManager : this.KClassImpl$Data$declaredNonStaticMembers$2.values()) {
            if (fragmentStateManager != null) {
                arrayList.add(fragmentStateManager.PlaceComponentResult);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.get(str) != null;
    }

    public final Fragment BuiltInFictitiousFunctionClassFactory(String str) {
        Fragment findFragmentByWho;
        for (FragmentStateManager fragmentStateManager : this.KClassImpl$Data$declaredNonStaticMembers$2.values()) {
            if (fragmentStateManager != null && (findFragmentByWho = fragmentStateManager.PlaceComponentResult.findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    public final int PlaceComponentResult(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.PlaceComponentResult.indexOf(fragment);
        for (int i = indexOf - 1; i >= 0; i--) {
            Fragment fragment2 = this.PlaceComponentResult.get(i);
            if (fragment2.mContainer == viewGroup && fragment2.mView != null) {
                return viewGroup.indexOfChild(fragment2.mView) + 1;
            }
        }
        while (true) {
            indexOf++;
            if (indexOf >= this.PlaceComponentResult.size()) {
                return -1;
            }
            Fragment fragment3 = this.PlaceComponentResult.get(indexOf);
            if (fragment3.mContainer == viewGroup && fragment3.mView != null) {
                return viewGroup.indexOfChild(fragment3.mView);
            }
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(FragmentStateManager fragmentStateManager) {
        Fragment fragment = fragmentStateManager.PlaceComponentResult;
        if (KClassImpl$Data$declaredNonStaticMembers$2(fragment.mWho)) {
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.put(fragment.mWho, fragmentStateManager);
        if (fragment.mRetainInstanceChangedWhileDetached) {
            if (fragment.mRetainInstance) {
                this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(fragment);
            } else {
                this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(fragment);
            }
            fragment.mRetainInstanceChangedWhileDetached = false;
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Added fragment to active set ");
            sb.append(fragment);
            InstrumentInjector.log_v(FragmentManager.TAG, sb.toString());
        }
    }

    public final void MyBillsEntityDataFactory(FragmentStateManager fragmentStateManager) {
        Fragment fragment = fragmentStateManager.PlaceComponentResult;
        if (fragment.mRetainInstance) {
            this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(fragment);
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.put(fragment.mWho, null) != null && FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Removed fragment from active set ");
            sb.append(fragment);
            InstrumentInjector.log_v(FragmentManager.TAG, sb.toString());
        }
    }
}

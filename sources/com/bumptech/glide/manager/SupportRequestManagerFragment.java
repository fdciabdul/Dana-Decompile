package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class SupportRequestManagerFragment extends Fragment {
    RequestManager KClassImpl$Data$declaredNonStaticMembers$2;
    final ActivityFragmentLifecycle MyBillsEntityDataFactory;
    final RequestManagerTreeNode NetworkUserEntityData$$ExternalSyntheticLambda0;
    Fragment PlaceComponentResult;
    private SupportRequestManagerFragment lookAheadTest;
    private final Set<SupportRequestManagerFragment> scheduleImpl;

    public SupportRequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    private SupportRequestManagerFragment(ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new SupportFragmentRequestManagerTreeNode();
        this.scheduleImpl = new HashSet();
        this.MyBillsEntityDataFactory = activityFragmentLifecycle;
    }

    final Set<SupportRequestManagerFragment> BuiltInFictitiousFunctionClassFactory() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.lookAheadTest;
        if (supportRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (equals(supportRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.scheduleImpl);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment supportRequestManagerFragment2 : this.lookAheadTest.BuiltInFictitiousFunctionClassFactory()) {
            Fragment parentFragment = supportRequestManagerFragment2.getParentFragment();
            if (parentFragment == null) {
                parentFragment = supportRequestManagerFragment2.PlaceComponentResult;
            }
            if (PlaceComponentResult(parentFragment)) {
                hashSet.add(supportRequestManagerFragment2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public static FragmentManager BuiltInFictitiousFunctionClassFactory(Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        Fragment fragment = this;
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager == null) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                InstrumentInjector.log_w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
                return;
            }
            return;
        }
        try {
            PlaceComponentResult(getContext(), fragmentManager);
        } catch (IllegalStateException e) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                InstrumentInjector.log_w("SupportRMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.PlaceComponentResult = null;
        SupportRequestManagerFragment supportRequestManagerFragment = this.lookAheadTest;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.scheduleImpl.remove(this);
            this.lookAheadTest = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.MyBillsEntityDataFactory.getAuthRequestContext();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.MyBillsEntityDataFactory.PlaceComponentResult();
        SupportRequestManagerFragment supportRequestManagerFragment = this.lookAheadTest;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.scheduleImpl.remove(this);
            this.lookAheadTest = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.PlaceComponentResult;
        }
        sb.append(parentFragment);
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class SupportFragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        SupportFragmentRequestManagerTreeNode() {
            SupportRequestManagerFragment.this = r1;
        }

        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        public final Set<RequestManager> MyBillsEntityDataFactory() {
            Set<SupportRequestManagerFragment> BuiltInFictitiousFunctionClassFactory = SupportRequestManagerFragment.this.BuiltInFictitiousFunctionClassFactory();
            HashSet hashSet = new HashSet(BuiltInFictitiousFunctionClassFactory.size());
            for (SupportRequestManagerFragment supportRequestManagerFragment : BuiltInFictitiousFunctionClassFactory) {
                if (supportRequestManagerFragment.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    hashSet.add(supportRequestManagerFragment.KClassImpl$Data$declaredNonStaticMembers$2);
                }
            }
            return hashSet;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append("{fragment=");
            sb.append(SupportRequestManagerFragment.this);
            sb.append("}");
            return sb.toString();
        }
    }

    private boolean PlaceComponentResult(Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.PlaceComponentResult;
        }
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    public final void PlaceComponentResult(Context context, FragmentManager fragmentManager) {
        SupportRequestManagerFragment supportRequestManagerFragment = this.lookAheadTest;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.scheduleImpl.remove(this);
            this.lookAheadTest = null;
        }
        SupportRequestManagerFragment authRequestContext = Glide.BuiltInFictitiousFunctionClassFactory(context).scheduleImpl.getAuthRequestContext(fragmentManager, (Fragment) null);
        this.lookAheadTest = authRequestContext;
        if (equals(authRequestContext)) {
            return;
        }
        this.lookAheadTest.scheduleImpl.add(this);
    }
}

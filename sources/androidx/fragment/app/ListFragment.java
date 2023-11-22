package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

/* loaded from: classes6.dex */
public class ListFragment extends Fragment {
    CharSequence KClassImpl$Data$declaredNonStaticMembers$2;
    ListAdapter MyBillsEntityDataFactory;
    TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    View PlaceComponentResult;
    View getErrorConfigVersion;
    boolean lookAheadTest;
    ListView moveToNextValue;
    View scheduleImpl;
    private final Handler GetContactSyncConfig = new Handler();
    private final Runnable initRecordTimeStamp = new Runnable() { // from class: androidx.fragment.app.ListFragment.1
        @Override // java.lang.Runnable
        public void run() {
            ListFragment.this.moveToNextValue.focusableViewAvailable(ListFragment.this.moveToNextValue);
        }
    };
    private final AdapterView.OnItemClickListener NetworkUserEntityData$$ExternalSyntheticLambda2 = new AdapterView.OnItemClickListener() { // from class: androidx.fragment.app.ListFragment.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ListView listView = (ListView) adapterView;
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context requireContext = requireContext();
        FrameLayout frameLayout = new FrameLayout(requireContext);
        LinearLayout linearLayout = new LinearLayout(requireContext);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(requireContext, null, 16842874), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(requireContext);
        frameLayout2.setId(16711683);
        TextView textView = new TextView(requireContext);
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(requireContext);
        listView.setId(16908298);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        MyBillsEntityDataFactory();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.GetContactSyncConfig.removeCallbacks(this.initRecordTimeStamp);
        this.moveToNextValue = null;
        this.lookAheadTest = false;
        this.scheduleImpl = null;
        this.getErrorConfigVersion = null;
        this.PlaceComponentResult = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        super.onDestroyView();
    }

    private void BuiltInFictitiousFunctionClassFactory(boolean z, boolean z2) {
        MyBillsEntityDataFactory();
        View view = this.getErrorConfigVersion;
        if (view == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        if (this.lookAheadTest == z) {
            return;
        }
        this.lookAheadTest = z;
        if (z) {
            if (z2) {
                view.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
                this.scheduleImpl.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
            } else {
                view.clearAnimation();
                this.scheduleImpl.clearAnimation();
            }
            this.getErrorConfigVersion.setVisibility(8);
            this.scheduleImpl.setVisibility(0);
            return;
        }
        if (z2) {
            view.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
            this.scheduleImpl.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
        } else {
            view.clearAnimation();
            this.scheduleImpl.clearAnimation();
        }
        this.getErrorConfigVersion.setVisibility(0);
        this.scheduleImpl.setVisibility(8);
    }

    private void MyBillsEntityDataFactory() {
        if (this.moveToNextValue != null) {
            return;
        }
        View view = getView();
        if (view == null) {
            throw new IllegalStateException("Content view not yet created");
        }
        if (view instanceof ListView) {
            this.moveToNextValue = (ListView) view;
        } else {
            TextView textView = (TextView) view.findViewById(16711681);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView;
            if (textView == null) {
                this.PlaceComponentResult = view.findViewById(16908292);
            } else {
                textView.setVisibility(8);
            }
            this.getErrorConfigVersion = view.findViewById(16711682);
            this.scheduleImpl = view.findViewById(16711683);
            View findViewById = view.findViewById(16908298);
            if (!(findViewById instanceof ListView)) {
                if (findViewById == null) {
                    throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                }
                throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
            }
            ListView listView = (ListView) findViewById;
            this.moveToNextValue = listView;
            View view2 = this.PlaceComponentResult;
            if (view2 != null) {
                listView.setEmptyView(view2);
            } else {
                CharSequence charSequence = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (charSequence != null) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.setText(charSequence);
                    this.moveToNextValue.setEmptyView(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                }
            }
        }
        this.lookAheadTest = true;
        this.moveToNextValue.setOnItemClickListener(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        ListAdapter listAdapter = this.MyBillsEntityDataFactory;
        if (listAdapter != null) {
            this.MyBillsEntityDataFactory = null;
            boolean z = 0 != 0;
            this.MyBillsEntityDataFactory = listAdapter;
            ListView listView2 = this.moveToNextValue;
            if (listView2 != null) {
                listView2.setAdapter(listAdapter);
                if (!this.lookAheadTest && !z) {
                    BuiltInFictitiousFunctionClassFactory(true, requireView().getWindowToken() != null);
                }
            }
        } else if (this.getErrorConfigVersion != null) {
            BuiltInFictitiousFunctionClassFactory(false, false);
        }
        this.GetContactSyncConfig.post(this.initRecordTimeStamp);
    }
}

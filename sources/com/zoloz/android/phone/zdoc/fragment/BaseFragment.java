package com.zoloz.android.phone.zdoc.fragment;

import androidx.fragment.app.Fragment;

/* loaded from: classes8.dex */
public class BaseFragment extends Fragment {
    public boolean onBackPressed() {
        return false;
    }

    public void onRestart() {
    }

    public void runOnUiThread(Runnable runnable) {
        getActivity().runOnUiThread(runnable);
    }
}

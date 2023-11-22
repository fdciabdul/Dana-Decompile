package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
class SharedPreferencesLoader {
    final Executor KClassImpl$Data$declaredNonStaticMembers$2 = Executors.newSingleThreadExecutor();

    /* loaded from: classes.dex */
    interface OnPrefsLoadedListener {
        void KClassImpl$Data$declaredNonStaticMembers$2(SharedPreferences sharedPreferences);
    }

    /* loaded from: classes.dex */
    static class LoadSharedPreferences implements Callable<SharedPreferences> {
        private final Context KClassImpl$Data$declaredNonStaticMembers$2;
        private final OnPrefsLoadedListener MyBillsEntityDataFactory;
        private final String PlaceComponentResult;

        public LoadSharedPreferences(Context context, String str, OnPrefsLoadedListener onPrefsLoadedListener) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
            this.PlaceComponentResult = str;
            this.MyBillsEntityDataFactory = onPrefsLoadedListener;
        }

        @Override // java.util.concurrent.Callable
        public /* synthetic */ SharedPreferences call() throws Exception {
            SharedPreferences sharedPreferences = this.KClassImpl$Data$declaredNonStaticMembers$2.getSharedPreferences(this.PlaceComponentResult, 0);
            OnPrefsLoadedListener onPrefsLoadedListener = this.MyBillsEntityDataFactory;
            if (onPrefsLoadedListener != null) {
                onPrefsLoadedListener.KClassImpl$Data$declaredNonStaticMembers$2(sharedPreferences);
            }
            return sharedPreferences;
        }
    }
}

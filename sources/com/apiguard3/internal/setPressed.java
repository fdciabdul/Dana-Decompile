package com.apiguard3.internal;

import android.content.Context;
import java.io.File;

/* loaded from: classes7.dex */
public final class setPressed {
    private static int getSharedInstance = 1;
    private static int values;

    /* loaded from: classes7.dex */
    public interface AGState {
        void AGState(String str);

        String APIGuard(String str);

        void getSharedInstance(String str);

        String[] getSharedInstance();
    }

    /* loaded from: classes7.dex */
    public interface valueOf {
        void APIGuard();

        void APIGuard(Throwable th);
    }

    /* loaded from: classes7.dex */
    public interface values {
        void AGState(Context context, String[] strArr, String str, File file, setFilterTouchesWhenObscured setfiltertoucheswhenobscured);
    }

    public static void valueOf(Context context, String str) {
        values = (getSharedInstance + 91) % 128;
        AGState(context, str, null, null);
        getSharedInstance = (values + 27) % 128;
    }

    public static void getSharedInstance(Context context, String str, valueOf valueof) {
        values = (getSharedInstance + 45) % 128;
        AGState(context, str, null, valueof);
        getSharedInstance = (values + 65) % 128;
    }

    private static void AGState(Context context, String str, String str2, valueOf valueof) {
        new setFilterTouchesWhenObscured().valueOf(context, str, str2, valueof);
        getSharedInstance = (values + 25) % 128;
    }

    public static boolean values(CharSequence charSequence) {
        if (!(charSequence == null)) {
            values = (getSharedInstance + 63) % 128;
            if (!(charSequence.length() == 0)) {
                values = (getSharedInstance + 85) % 128;
                return false;
            }
        }
        return true;
    }
}

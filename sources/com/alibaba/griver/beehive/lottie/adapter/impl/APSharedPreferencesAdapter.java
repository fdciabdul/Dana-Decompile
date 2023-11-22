package com.alibaba.griver.beehive.lottie.adapter.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes6.dex */
public class APSharedPreferencesAdapter {
    private SharedPreferences.Editor edit = null;
    private String mGroup;
    private int mMode;
    private SharedPreferences mSP;
    private Context sContext;

    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public APSharedPreferencesAdapter(Context context, String str, int i) {
        this.sContext = null;
        this.mGroup = "alipay_default_sp";
        this.mMode = 0;
        if (context != null) {
            this.sContext = context.getApplicationContext();
        }
        this.mGroup = str;
        this.mMode = i;
    }

    private void createEditIfNot() {
        if (this.sContext == null || this.edit != null) {
            return;
        }
        synchronized (this) {
            if (this.edit == null) {
                this.edit = this.sContext.getSharedPreferences(getGroup(), this.mMode).edit();
            }
        }
    }

    private void createSPIfNot() {
        if (this.sContext == null || this.mSP != null) {
            return;
        }
        synchronized (this) {
            if (this.mSP == null) {
                this.mSP = this.sContext.getSharedPreferences(getGroup(), this.mMode);
            }
        }
    }

    public boolean getBoolean(String str, boolean z) {
        return getBoolean(getGroup(), str, z);
    }

    public String getString(String str, String str2) {
        return getString(getGroup(), str, str2);
    }

    public int getInt(String str, int i) {
        return getInt(getGroup(), str, i);
    }

    public long getLong(String str, long j) {
        return getLong(getGroup(), str, j);
    }

    public float getFloat(String str, float f) {
        return getFloat(getGroup(), str, f);
    }

    public boolean putInt(String str, int i) {
        return putInt(getGroup(), str, i);
    }

    public boolean putBoolean(String str, boolean z) {
        return putBoolean(getGroup(), str, z);
    }

    public boolean putString(String str, String str2) {
        return putString(getGroup(), str, str2);
    }

    public boolean putLong(String str, long j) {
        return putLong(getGroup(), str, j);
    }

    public boolean putFloat(String str, float f) {
        return putFloat(getGroup(), str, f);
    }

    public boolean contains(String str) {
        return contains(getGroup(), str);
    }

    public boolean commit() {
        createEditIfNot();
        SharedPreferences.Editor editor = this.edit;
        if (editor != null) {
            return editor.commit();
        }
        return false;
    }

    public void apply() {
        createEditIfNot();
        SharedPreferences.Editor editor = this.edit;
        if (editor != null) {
            editor.apply();
        }
    }

    public boolean remove(String str) {
        createEditIfNot();
        if (this.edit == null || TextUtils.isEmpty(str)) {
            return false;
        }
        this.edit.remove(str);
        return true;
    }

    public boolean clear() {
        createEditIfNot();
        SharedPreferences.Editor editor = this.edit;
        if (editor != null) {
            editor.clear();
            return true;
        }
        return false;
    }

    public Map<String, ?> getAll() {
        Context context = this.sContext;
        if (context != null) {
            if (this.mMode == 0) {
                createSPIfNot();
                return this.mSP.getAll();
            }
            return context.getSharedPreferences(getGroup(), this.mMode).getAll();
        }
        return null;
    }

    private boolean contains(String str, String str2) {
        Context context = this.sContext;
        if (context != null) {
            int i = this.mMode;
            if (i == 0) {
                createSPIfNot();
                return this.mSP.contains(str2);
            }
            return context.getSharedPreferences(str, i).contains(str2);
        }
        return false;
    }

    private boolean getBoolean(String str, String str2, boolean z) {
        Context context = this.sContext;
        if (context != null) {
            int i = this.mMode;
            if (i == 0) {
                createSPIfNot();
                return this.mSP.getBoolean(str2, z);
            }
            return context.getSharedPreferences(str, i).getBoolean(str2, z);
        }
        return z;
    }

    private String getString(String str, String str2, String str3) {
        Context context = this.sContext;
        if (context != null) {
            int i = this.mMode;
            if (i == 0) {
                createSPIfNot();
                return this.mSP.getString(str2, str3);
            }
            return context.getSharedPreferences(str, i).getString(str2, str3);
        }
        return str3;
    }

    private int getInt(String str, String str2, int i) {
        Context context = this.sContext;
        if (context != null) {
            int i2 = this.mMode;
            if (i2 == 0) {
                createSPIfNot();
                return this.mSP.getInt(str2, i);
            }
            return context.getSharedPreferences(str, i2).getInt(str2, i);
        }
        return i;
    }

    private long getLong(String str, String str2, long j) {
        Context context = this.sContext;
        if (context != null) {
            int i = this.mMode;
            if (i == 0) {
                createSPIfNot();
                return this.mSP.getLong(str2, j);
            }
            return context.getSharedPreferences(str, i).getLong(str2, j);
        }
        return j;
    }

    private float getFloat(String str, String str2, float f) {
        Context context = this.sContext;
        if (context != null) {
            int i = this.mMode;
            if (i == 0) {
                createSPIfNot();
                return this.mSP.getFloat(str2, f);
            }
            return context.getSharedPreferences(str, i).getFloat(str2, f);
        }
        return f;
    }

    private boolean putInt(String str, String str2, int i) {
        createEditIfNot();
        SharedPreferences.Editor editor = this.edit;
        if (editor != null) {
            editor.putInt(str2, i);
            return true;
        }
        return false;
    }

    private boolean putBoolean(String str, String str2, boolean z) {
        createEditIfNot();
        SharedPreferences.Editor editor = this.edit;
        if (editor != null) {
            editor.putBoolean(str2, z);
            return true;
        }
        return false;
    }

    private boolean putString(String str, String str2, String str3) {
        createEditIfNot();
        SharedPreferences.Editor editor = this.edit;
        if (editor != null) {
            editor.putString(str2, str3);
            return true;
        }
        return false;
    }

    private boolean putLong(String str, String str2, long j) {
        createEditIfNot();
        SharedPreferences.Editor editor = this.edit;
        if (editor != null) {
            editor.putLong(str2, j);
            return true;
        }
        return false;
    }

    private boolean putFloat(String str, String str2, float f) {
        createEditIfNot();
        SharedPreferences.Editor editor = this.edit;
        if (editor != null) {
            editor.putFloat(str2, f);
            return true;
        }
        return false;
    }

    private String getGroup() {
        return this.mGroup;
    }
}

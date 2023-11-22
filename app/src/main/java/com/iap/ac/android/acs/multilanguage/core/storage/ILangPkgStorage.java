package com.iap.ac.android.acs.multilanguage.core.storage;

import android.content.Context;

/* loaded from: classes3.dex */
public interface ILangPkgStorage {
    String getFromStorage(Context context, String str);

    boolean isFileExist(Context context, String str);

    boolean removeFromStorage(Context context, String str);

    boolean saveToStorage(Context context, String str, String str2);
}

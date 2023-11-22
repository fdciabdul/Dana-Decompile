package com.iap.ac.android.common.data;

/* loaded from: classes3.dex */
public interface IDataStorage {
    boolean clear();

    boolean delete(String str);

    String get(String str);

    boolean save(String str, String str2);
}

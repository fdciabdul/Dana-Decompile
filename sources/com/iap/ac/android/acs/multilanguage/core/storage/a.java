package com.iap.ac.android.acs.multilanguage.core.storage;

import android.content.Context;
import com.iap.ac.android.acs.multilanguage.utils.FileUtils;
import com.iap.ac.android.acs.multilanguage.utils.LanguagePackageUtil;
import com.iap.ac.android.common.log.ACLog;
import java.io.File;

/* loaded from: classes3.dex */
public class a implements ILangPkgStorage {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7531a = LanguagePackageUtil.logTag("LangPkgFileStorage");

    private static String a(Context context) {
        return new File(context.getApplicationContext().getFilesDir(), "language_package").getAbsolutePath();
    }

    @Override // com.iap.ac.android.acs.multilanguage.core.storage.ILangPkgStorage
    public String getFromStorage(Context context, String str) {
        try {
            return FileUtils.readStringFromFile(a(context), a(str));
        } catch (Exception e) {
            String str2 = f7531a;
            StringBuilder sb = new StringBuilder();
            sb.append("getFromStorage() failed, error: ");
            sb.append(e);
            ACLog.e(str2, sb.toString());
            return null;
        }
    }

    @Override // com.iap.ac.android.acs.multilanguage.core.storage.ILangPkgStorage
    public boolean isFileExist(Context context, String str) {
        try {
            return FileUtils.isFileExists(a(context), a(str));
        } catch (Exception e) {
            String str2 = f7531a;
            StringBuilder sb = new StringBuilder();
            sb.append("isFileExist() failed, error: ");
            sb.append(e);
            ACLog.e(str2, sb.toString());
            return false;
        }
    }

    @Override // com.iap.ac.android.acs.multilanguage.core.storage.ILangPkgStorage
    public boolean removeFromStorage(Context context, String str) {
        try {
            return FileUtils.deleteFile(a(context), a(str));
        } catch (Exception e) {
            String str2 = f7531a;
            StringBuilder sb = new StringBuilder();
            sb.append("isFileExist() failed, error: ");
            sb.append(e);
            ACLog.e(str2, sb.toString());
            return false;
        }
    }

    @Override // com.iap.ac.android.acs.multilanguage.core.storage.ILangPkgStorage
    public boolean saveToStorage(Context context, String str, String str2) {
        try {
            FileUtils.writeStringToFile(a(context), a(str), str2);
            return true;
        } catch (Exception e) {
            String str3 = f7531a;
            StringBuilder sb = new StringBuilder();
            sb.append("saveToStorage() failed, error: ");
            sb.append(e);
            ACLog.e(str3, sb.toString());
            return false;
        }
    }

    private static String a(String str) {
        if (str.contains(".json")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".json");
        return sb.toString();
    }
}

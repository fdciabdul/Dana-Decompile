package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.os.AsyncTask;
import java.io.InputStream;

/* loaded from: classes8.dex */
public class d extends AsyncTask<Context, Integer, Boolean> {
    private static final String getAuthRequestContext = "d";

    @Override // android.os.AsyncTask
    protected /* synthetic */ Boolean doInBackground(Context[] contextArr) {
        return PlaceComponentResult(contextArr);
    }

    @Override // android.os.AsyncTask
    protected /* synthetic */ void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            g.KClassImpl$Data$declaredNonStaticMembers$2(getAuthRequestContext, "onPostExecute: upate done");
        } else {
            g.getAuthRequestContext(getAuthRequestContext, "onPostExecute: upate failed");
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        g.PlaceComponentResult();
    }

    @Override // android.os.AsyncTask
    protected /* synthetic */ void onProgressUpdate(Integer[] numArr) {
        g.KClassImpl$Data$declaredNonStaticMembers$2(getAuthRequestContext, "onProgressUpdate");
    }

    private static Boolean PlaceComponentResult(Context... contextArr) {
        InputStream inputStream;
        try {
            inputStream = BksUtil.PlaceComponentResult(contextArr[0]);
        } catch (Exception e) {
            String str = getAuthRequestContext;
            StringBuilder sb = new StringBuilder();
            sb.append("doInBackground: exception : ");
            sb.append(e.getMessage());
            g.getAuthRequestContext(str, sb.toString());
            inputStream = null;
        }
        g.PlaceComponentResult();
        if (inputStream != null) {
            f.BuiltInFictitiousFunctionClassFactory(inputStream);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}

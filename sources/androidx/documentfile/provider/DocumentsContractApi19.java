package androidx.documentfile.provider;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes3.dex */
class DocumentsContractApi19 {
    public static String KClassImpl$Data$declaredNonStaticMembers$2(Context context, Uri uri) {
        return PlaceComponentResult(context, uri, "_display_name", (String) null);
    }

    private static String lookAheadTest(Context context, Uri uri) {
        return PlaceComponentResult(context, uri, "mime_type", (String) null);
    }

    public static String PlaceComponentResult(Context context, Uri uri) {
        String lookAheadTest = lookAheadTest(context, uri);
        if ("vnd.android.document/directory".equals(lookAheadTest)) {
            return null;
        }
        return lookAheadTest;
    }

    public static boolean getErrorConfigVersion(Context context, Uri uri) {
        return "vnd.android.document/directory".equals(lookAheadTest(context, uri));
    }

    public static boolean moveToNextValue(Context context, Uri uri) {
        String lookAheadTest = lookAheadTest(context, uri);
        return ("vnd.android.document/directory".equals(lookAheadTest) || TextUtils.isEmpty(lookAheadTest)) ? false : true;
    }

    public static long NetworkUserEntityData$$ExternalSyntheticLambda0(Context context, Uri uri) {
        return getAuthRequestContext(context, uri, "_size", 0L);
    }

    public static boolean MyBillsEntityDataFactory(Context context, Uri uri) {
        return context.checkCallingOrSelfUriPermission(uri, 1) == 0 && !TextUtils.isEmpty(lookAheadTest(context, uri));
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        String lookAheadTest = lookAheadTest(context, uri);
        int PlaceComponentResult = PlaceComponentResult(context, uri, "flags", 0);
        if (TextUtils.isEmpty(lookAheadTest)) {
            return false;
        }
        if ((PlaceComponentResult & 4) != 0) {
            return true;
        }
        if (!"vnd.android.document/directory".equals(lookAheadTest) || (PlaceComponentResult & 8) == 0) {
            return (TextUtils.isEmpty(lookAheadTest) || (PlaceComponentResult & 2) == 0) ? false : true;
        }
        return true;
    }

    public static boolean getAuthRequestContext(Context context, Uri uri) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"document_id"}, null, null, null);
            return cursor.getCount() > 0;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed query: ");
            sb.append(e);
            InstrumentInjector.log_w("DocumentFile", sb.toString());
            return false;
        } finally {
            getAuthRequestContext(cursor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String PlaceComponentResult(Context context, Uri uri, String str, String str2) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
            return (!cursor.moveToFirst() || cursor.isNull(0)) ? str2 : cursor.getString(0);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed query: ");
            sb.append(e);
            InstrumentInjector.log_w("DocumentFile", sb.toString());
            return str2;
        } finally {
            getAuthRequestContext(cursor);
        }
    }

    private static int PlaceComponentResult(Context context, Uri uri, String str, int i) {
        return (int) getAuthRequestContext(context, uri, str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long getAuthRequestContext(Context context, Uri uri, String str, long j) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
            return (!cursor.moveToFirst() || cursor.isNull(0)) ? j : cursor.getLong(0);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed query: ");
            sb.append(e);
            InstrumentInjector.log_w("DocumentFile", sb.toString());
            return j;
        } finally {
            getAuthRequestContext(cursor);
        }
    }

    private static void getAuthRequestContext(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    private DocumentsContractApi19() {
    }
}

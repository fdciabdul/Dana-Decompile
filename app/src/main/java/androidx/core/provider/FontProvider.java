package androidx.core.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.j256.ormlite.field.FieldType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FontProvider {
    private static final Comparator<byte[]> MyBillsEntityDataFactory = new Comparator() { // from class: androidx.core.provider.FontProvider$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return FontProvider.getAuthRequestContext((byte[]) obj, (byte[]) obj2);
        }
    };

    private FontProvider() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FontsContractCompat.FontFamilyResult BuiltInFictitiousFunctionClassFactory(Context context, FontRequest fontRequest, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        List<List<byte[]>> KClassImpl$Data$declaredNonStaticMembers$2;
        PackageManager packageManager = context.getPackageManager();
        Resources resources = context.getResources();
        String str = fontRequest.getAuthRequestContext;
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(str, 0);
        if (resolveContentProvider == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("No package found for authority: ");
            sb.append(str);
            throw new PackageManager.NameNotFoundException(sb.toString());
        } else if (!resolveContentProvider.packageName.equals(fontRequest.BuiltInFictitiousFunctionClassFactory)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Found content provider ");
            sb2.append(str);
            sb2.append(", but package was not ");
            sb2.append(fontRequest.BuiltInFictitiousFunctionClassFactory);
            throw new PackageManager.NameNotFoundException(sb2.toString());
        } else {
            Signature[] signatureArr = packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures;
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            Collections.sort(arrayList, MyBillsEntityDataFactory);
            if (fontRequest.PlaceComponentResult == null) {
                KClassImpl$Data$declaredNonStaticMembers$2 = FontResourcesParserCompat.KClassImpl$Data$declaredNonStaticMembers$2(resources, fontRequest.KClassImpl$Data$declaredNonStaticMembers$2);
            } else {
                KClassImpl$Data$declaredNonStaticMembers$2 = fontRequest.PlaceComponentResult;
            }
            int i = 0;
            while (true) {
                if (i >= KClassImpl$Data$declaredNonStaticMembers$2.size()) {
                    resolveContentProvider = null;
                    break;
                }
                ArrayList arrayList2 = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.get(i));
                Collections.sort(arrayList2, MyBillsEntityDataFactory);
                if (PlaceComponentResult(arrayList, arrayList2)) {
                    break;
                }
                i++;
            }
            if (resolveContentProvider == null) {
                return FontsContractCompat.FontFamilyResult.getAuthRequestContext(1, null);
            }
            return FontsContractCompat.FontFamilyResult.getAuthRequestContext(0, MyBillsEntityDataFactory(context, fontRequest, resolveContentProvider.authority, cancellationSignal));
        }
    }

    private static FontsContractCompat.FontInfo[] MyBillsEntityDataFactory(Context context, FontRequest fontRequest, String str, CancellationSignal cancellationSignal) {
        Cursor query;
        int i;
        Uri withAppendedId;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        Cursor cursor = null;
        try {
            String[] strArr = {FieldType.FOREIGN_ID_FIELD_SUFFIX, "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
            ContentResolver contentResolver = context.getContentResolver();
            if (Build.VERSION.SDK_INT > 16) {
                query = Api16Impl.BuiltInFictitiousFunctionClassFactory(contentResolver, build, strArr, "query = ?", new String[]{fontRequest.lookAheadTest}, null, cancellationSignal);
            } else {
                query = contentResolver.query(build, strArr, "query = ?", new String[]{fontRequest.lookAheadTest}, null);
            }
            cursor = query;
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                arrayList = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex(FieldType.FOREIGN_ID_FIELD_SUFFIX);
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    int i2 = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                    int i3 = columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0;
                    if (columnIndex3 == -1) {
                        i = i3;
                        withAppendedId = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                    } else {
                        i = i3;
                        withAppendedId = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                    }
                    arrayList.add(FontsContractCompat.FontInfo.KClassImpl$Data$declaredNonStaticMembers$2(withAppendedId, i, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, i2));
                }
            }
            return (FontsContractCompat.FontInfo[]) arrayList.toArray(new FontsContractCompat.FontInfo[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int getAuthRequestContext(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            byte b2 = bArr2[i];
            if (b != b2) {
                return b - b2;
            }
        }
        return 0;
    }

    private static boolean PlaceComponentResult(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api16Impl {
        private Api16Impl() {
        }

        static Cursor BuiltInFictitiousFunctionClassFactory(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, Object obj) {
            return contentResolver.query(uri, strArr, str, strArr2, str2, (CancellationSignal) obj);
        }
    }
}

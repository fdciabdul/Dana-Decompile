package com.anggrayudi.storage.extension;

import android.database.Cursor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u001b\u0010\t\u001a\u0004\u0018\u00010\u0007*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Ljava/io/InputStream;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/io/InputStream;)V", "Ljava/io/OutputStream;", "(Ljava/io/OutputStream;)V", "Landroid/database/Cursor;", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class IOUtils {
    public static final void KClassImpl$Data$declaredNonStaticMembers$2(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static final void KClassImpl$Data$declaredNonStaticMembers$2(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static final String BuiltInFictitiousFunctionClassFactory(Cursor cursor, String str) {
        Intrinsics.checkNotNullParameter(cursor, "");
        Intrinsics.checkNotNullParameter(str, "");
        try {
            return cursor.getString(cursor.getColumnIndexOrThrow(str));
        } catch (Exception unused) {
            return null;
        }
    }
}

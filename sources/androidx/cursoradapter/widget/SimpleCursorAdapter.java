package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes6.dex */
public class SimpleCursorAdapter extends ResourceCursorAdapter {
    private CursorToStringConverter DatabaseTableConfigUtil;
    private ViewBinder GetContactSyncConfig;
    private int NetworkUserEntityData$$ExternalSyntheticLambda1;
    protected int[] NetworkUserEntityData$$ExternalSyntheticLambda2;
    protected int[] getAuthRequestContext;
    String[] initRecordTimeStamp;

    /* loaded from: classes6.dex */
    public interface CursorToStringConverter {
        CharSequence KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* loaded from: classes6.dex */
    public interface ViewBinder {
        boolean PlaceComponentResult();
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public final void MyBillsEntityDataFactory(View view, Cursor cursor) {
        boolean z;
        ViewBinder viewBinder = this.GetContactSyncConfig;
        int[] iArr = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        int length = iArr.length;
        int[] iArr2 = this.getAuthRequestContext;
        for (int i = 0; i < length; i++) {
            View findViewById = view.findViewById(iArr[i]);
            if (findViewById != null) {
                if (viewBinder != null) {
                    int i2 = iArr2[i];
                    z = viewBinder.PlaceComponentResult();
                } else {
                    z = false;
                }
                if (z) {
                    continue;
                } else {
                    String string = cursor.getString(iArr2[i]);
                    if (string == null) {
                        string = "";
                    }
                    if (!(findViewById instanceof TextView)) {
                        if (findViewById instanceof ImageView) {
                            ImageView imageView = (ImageView) findViewById;
                            try {
                                InstrumentInjector.Resources_setImageResource(imageView, Integer.parseInt(string));
                            } catch (NumberFormatException unused) {
                                imageView.setImageURI(Uri.parse(string));
                            }
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append(findViewById.getClass().getName());
                            sb.append(" is not a ");
                            sb.append(" view that can be bounds by this SimpleCursorAdapter");
                            throw new IllegalStateException(sb.toString());
                        }
                    } else {
                        ((TextView) findViewById).setText(string);
                    }
                }
            }
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public final CharSequence BuiltInFictitiousFunctionClassFactory(Cursor cursor) {
        CursorToStringConverter cursorToStringConverter = this.DatabaseTableConfigUtil;
        if (cursorToStringConverter != null) {
            return cursorToStringConverter.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (i >= 0) {
            return cursor.getString(i);
        }
        return super.BuiltInFictitiousFunctionClassFactory(cursor);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public final Cursor KClassImpl$Data$declaredNonStaticMembers$2(Cursor cursor) {
        String[] strArr = this.initRecordTimeStamp;
        if (cursor != null) {
            int length = strArr.length;
            int[] iArr = this.getAuthRequestContext;
            if (iArr == null || iArr.length != length) {
                this.getAuthRequestContext = new int[length];
            }
            for (int i = 0; i < length; i++) {
                this.getAuthRequestContext[i] = cursor.getColumnIndexOrThrow(strArr[i]);
            }
        } else {
            this.getAuthRequestContext = null;
        }
        return super.KClassImpl$Data$declaredNonStaticMembers$2(cursor);
    }
}

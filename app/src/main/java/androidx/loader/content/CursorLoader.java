package androidx.loader.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.content.ContentResolverCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.os.OperationCanceledException;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class CursorLoader extends AsyncTaskLoader<Cursor> {
    String[] BuiltInFictitiousFunctionClassFactory;
    String KClassImpl$Data$declaredNonStaticMembers$2;
    Cursor MyBillsEntityDataFactory;
    final Loader<Cursor>.ForceLoadContentObserver PlaceComponentResult;
    CancellationSignal getAuthRequestContext;
    String getErrorConfigVersion;
    String[] lookAheadTest;
    Uri scheduleImpl;

    @Override // androidx.loader.content.AsyncTaskLoader
    public /* synthetic */ void onCanceled(Cursor cursor) {
        Cursor cursor2 = cursor;
        if (cursor2 == null || cursor2.isClosed()) {
            return;
        }
        cursor2.close();
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    /* renamed from: PlaceComponentResult  reason: merged with bridge method [inline-methods] */
    public final Cursor loadInBackground() {
        synchronized (this) {
            if (isLoadInBackgroundCanceled()) {
                throw new OperationCanceledException();
            }
            this.getAuthRequestContext = new CancellationSignal();
        }
        try {
            Cursor BuiltInFictitiousFunctionClassFactory = ContentResolverCompat.BuiltInFictitiousFunctionClassFactory(getContext().getContentResolver(), this.scheduleImpl, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, this.lookAheadTest, this.getErrorConfigVersion, this.getAuthRequestContext);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                try {
                    BuiltInFictitiousFunctionClassFactory.getCount();
                    BuiltInFictitiousFunctionClassFactory.registerContentObserver(this.PlaceComponentResult);
                } catch (RuntimeException e) {
                    BuiltInFictitiousFunctionClassFactory.close();
                    throw e;
                }
            }
            synchronized (this) {
                this.getAuthRequestContext = null;
            }
            return BuiltInFictitiousFunctionClassFactory;
        } catch (Throwable th) {
            synchronized (this) {
                this.getAuthRequestContext = null;
                throw th;
            }
        }
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public void cancelLoadInBackground() {
        super.cancelLoadInBackground();
        synchronized (this) {
            CancellationSignal cancellationSignal = this.getAuthRequestContext;
            if (cancellationSignal != null) {
                cancellationSignal.PlaceComponentResult();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.loader.content.Loader
    /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
    public void deliverResult(Cursor cursor) {
        if (isReset()) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        Cursor cursor2 = this.MyBillsEntityDataFactory;
        this.MyBillsEntityDataFactory = cursor;
        if (isStarted()) {
            super.deliverResult(cursor);
        }
        if (cursor2 == null || cursor2 == cursor || cursor2.isClosed()) {
            return;
        }
        cursor2.close();
    }

    public CursorLoader(Context context, Uri uri) {
        super(context);
        this.PlaceComponentResult = new Loader.ForceLoadContentObserver();
        this.scheduleImpl = uri;
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.lookAheadTest = null;
        this.getErrorConfigVersion = null;
    }

    @Override // androidx.loader.content.Loader
    protected void onStartLoading() {
        Cursor cursor = this.MyBillsEntityDataFactory;
        if (cursor != null) {
            deliverResult(cursor);
        }
        if (takeContentChanged() || this.MyBillsEntityDataFactory == null) {
            forceLoad();
        }
    }

    @Override // androidx.loader.content.Loader
    protected void onStopLoading() {
        cancelLoad();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.loader.content.Loader
    public void onReset() {
        super.onReset();
        onStopLoading();
        Cursor cursor = this.MyBillsEntityDataFactory;
        if (cursor != null && !cursor.isClosed()) {
            this.MyBillsEntityDataFactory.close();
        }
        this.MyBillsEntityDataFactory = null;
    }

    @Override // androidx.loader.content.AsyncTaskLoader, androidx.loader.content.Loader
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.scheduleImpl);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.BuiltInFictitiousFunctionClassFactory));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.KClassImpl$Data$declaredNonStaticMembers$2);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.lookAheadTest));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.getErrorConfigVersion);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.MyBillsEntityDataFactory);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.mContentChanged);
    }
}

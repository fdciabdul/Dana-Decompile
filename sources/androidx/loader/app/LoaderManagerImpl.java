package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.DebugUtils;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.view.LifecycleOwner;
import androidx.view.LiveData;
import androidx.view.MutableLiveData;
import androidx.view.Observer;
import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.viewmodel.CreationExtras;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class LoaderManagerImpl extends LoaderManager {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {44, -51, -23, -10, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int MyBillsEntityDataFactory = 21;
    static boolean PlaceComponentResult = false;
    private final LoaderViewModel BuiltInFictitiousFunctionClassFactory;
    private final LifecycleOwner getAuthRequestContext;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = 106 - r7
            byte[] r0 = androidx.loader.app.LoaderManagerImpl.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 * 15
            int r8 = 18 - r8
            int r6 = r6 * 3
            int r6 = r6 + 16
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L34
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r8 = r8 + 1
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L34:
            int r7 = r7 + r8
            int r7 = r7 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.loader.app.LoaderManagerImpl.a(int, int, int, java.lang.Object[]):void");
    }

    /* loaded from: classes.dex */
    public static class LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {
        final Loader<D> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private LifecycleOwner NetworkUserEntityData$$ExternalSyntheticLambda2;
        LoaderObserver<D> lookAheadTest;
        public static final byte[] initRecordTimeStamp = {59, -103, 22, 57, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
        public static final int NetworkUserEntityData$$ExternalSyntheticLambda1 = 159;
        final int scheduleImpl = 0;
        final Bundle PlaceComponentResult = null;
        private Loader<D> DatabaseTableConfigUtil = null;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0026). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(short r5, byte r6, int r7, java.lang.Object[] r8) {
            /*
                int r7 = r7 + 105
                byte[] r0 = androidx.loader.app.LoaderManagerImpl.LoaderInfo.initRecordTimeStamp
                int r5 = r5 * 4
                int r5 = 16 - r5
                int r6 = r6 * 15
                int r6 = r6 + 4
                byte[] r1 = new byte[r5]
                r2 = 0
                if (r0 != 0) goto L14
                r4 = r6
                r3 = 0
                goto L26
            L14:
                r3 = 0
            L15:
                byte r4 = (byte) r7
                r1[r3] = r4
                int r3 = r3 + 1
                if (r3 != r5) goto L24
                java.lang.String r5 = new java.lang.String
                r5.<init>(r1, r2)
                r8[r2] = r5
                return
            L24:
                r4 = r0[r6]
            L26:
                int r6 = r6 + 1
                int r7 = r7 + r4
                int r7 = r7 + 2
                goto L15
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.loader.app.LoaderManagerImpl.LoaderInfo.a(short, byte, int, java.lang.Object[]):void");
        }

        LoaderInfo(int i, Bundle bundle, Loader<D> loader) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = loader;
            loader.registerListener(0, this);
        }

        @Override // androidx.view.LiveData
        public final void BuiltInFictitiousFunctionClassFactory() {
            if (LoaderManagerImpl.PlaceComponentResult) {
                StringBuilder sb = new StringBuilder();
                sb.append("  Starting: ");
                sb.append(this);
                InstrumentInjector.log_v("LoaderManager", sb.toString());
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.startLoading();
        }

        @Override // androidx.view.LiveData
        public final void getAuthRequestContext() {
            if (LoaderManagerImpl.PlaceComponentResult) {
                StringBuilder sb = new StringBuilder();
                sb.append("  Stopping: ");
                sb.append(this);
                InstrumentInjector.log_v("LoaderManager", sb.toString());
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.stopLoading();
        }

        final Loader<D> KClassImpl$Data$declaredNonStaticMembers$2(LifecycleOwner lifecycleOwner, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            LoaderObserver<D> loaderObserver = new LoaderObserver<>(this.NetworkUserEntityData$$ExternalSyntheticLambda0, loaderCallbacks);
            PlaceComponentResult(lifecycleOwner, loaderObserver);
            LoaderObserver<D> loaderObserver2 = this.lookAheadTest;
            if (loaderObserver2 != null) {
                super.BuiltInFictitiousFunctionClassFactory((Observer) loaderObserver2);
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
                this.lookAheadTest = null;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = lifecycleOwner;
            this.lookAheadTest = loaderObserver;
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }

        final void KClassImpl$Data$declaredNonStaticMembers$2() {
            LifecycleOwner lifecycleOwner = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            LoaderObserver<D> loaderObserver = this.lookAheadTest;
            if (lifecycleOwner == null || loaderObserver == null) {
                return;
            }
            super.BuiltInFictitiousFunctionClassFactory((Observer) loaderObserver);
            PlaceComponentResult(lifecycleOwner, loaderObserver);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.view.LiveData
        public final void BuiltInFictitiousFunctionClassFactory(Observer<? super D> observer) {
            super.BuiltInFictitiousFunctionClassFactory((Observer) observer);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
            this.lookAheadTest = null;
        }

        final Loader<D> PlaceComponentResult() {
            if (LoaderManagerImpl.PlaceComponentResult) {
                StringBuilder sb = new StringBuilder();
                sb.append("  Destroying: ");
                sb.append(this);
                InstrumentInjector.log_v("LoaderManager", sb.toString());
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.cancelLoad();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.abandon();
            LoaderObserver<D> loaderObserver = this.lookAheadTest;
            if (loaderObserver != null) {
                super.BuiltInFictitiousFunctionClassFactory((Observer) loaderObserver);
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
                this.lookAheadTest = null;
                if (loaderObserver.BuiltInFictitiousFunctionClassFactory) {
                    if (LoaderManagerImpl.PlaceComponentResult) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("  Resetting: ");
                        sb2.append(loaderObserver.MyBillsEntityDataFactory);
                        InstrumentInjector.log_v("LoaderManager", sb2.toString());
                    }
                    loaderObserver.getAuthRequestContext.onLoaderReset(loaderObserver.MyBillsEntityDataFactory);
                }
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.unregisterListener(this);
            if (loaderObserver != null) {
                loaderObserver.MyBillsEntityDataFactory();
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.reset();
            return this.DatabaseTableConfigUtil;
        }

        @Override // androidx.loader.content.Loader.OnLoadCompleteListener
        public final void KClassImpl$Data$declaredNonStaticMembers$2(Loader<D> loader, D d) {
            if (LoaderManagerImpl.PlaceComponentResult) {
                StringBuilder sb = new StringBuilder();
                sb.append("onLoadComplete: ");
                sb.append(this);
                InstrumentInjector.log_v("LoaderManager", sb.toString());
            }
            if (Looper.myLooper() != Looper.getMainLooper()) {
                if (LoaderManagerImpl.PlaceComponentResult) {
                    InstrumentInjector.log_w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
                }
                BuiltInFictitiousFunctionClassFactory((LoaderInfo<D>) d);
                return;
            }
            super.PlaceComponentResult((LoaderInfo<D>) d);
            Loader<D> loader2 = this.DatabaseTableConfigUtil;
            if (loader2 != null) {
                loader2.reset();
                this.DatabaseTableConfigUtil = null;
            }
        }

        @Override // androidx.view.MutableLiveData, androidx.view.LiveData
        public final void PlaceComponentResult(D d) {
            super.PlaceComponentResult((LoaderInfo<D>) d);
            Loader<D> loader = this.DatabaseTableConfigUtil;
            if (loader != null) {
                loader.reset();
                this.DatabaseTableConfigUtil = null;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            try {
                Object[] objArr = {this};
                byte b = (byte) (initRecordTimeStamp[5] + 1);
                byte b2 = (byte) (-initRecordTimeStamp[5]);
                Object[] objArr2 = new Object[1];
                a(b, b2, b2, objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b3 = (byte) (initRecordTimeStamp[5] + 1);
                byte b4 = b3;
                Object[] objArr3 = new Object[1];
                a(b3, b4, b4, objArr3);
                sb.append(Integer.toHexString(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue()));
                sb.append(" #");
                sb.append(this.scheduleImpl);
                sb.append(" : ");
                DebugUtils.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, sb);
                sb.append("}}");
                return sb.toString();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class LoaderObserver<D> implements Observer<D> {
        boolean BuiltInFictitiousFunctionClassFactory = false;
        final Loader<D> MyBillsEntityDataFactory;
        final LoaderManager.LoaderCallbacks<D> getAuthRequestContext;

        LoaderObserver(Loader<D> loader, LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            this.MyBillsEntityDataFactory = loader;
            this.getAuthRequestContext = loaderCallbacks;
        }

        @Override // androidx.view.Observer
        public void onChanged(D d) {
            if (LoaderManagerImpl.PlaceComponentResult) {
                StringBuilder sb = new StringBuilder();
                sb.append("  onLoadFinished in ");
                sb.append(this.MyBillsEntityDataFactory);
                sb.append(": ");
                sb.append(this.MyBillsEntityDataFactory.dataToString(d));
                InstrumentInjector.log_v("LoaderManager", sb.toString());
            }
            this.getAuthRequestContext.onLoadFinished(this.MyBillsEntityDataFactory, d);
            this.BuiltInFictitiousFunctionClassFactory = true;
        }

        final boolean MyBillsEntityDataFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        public String toString() {
            return this.getAuthRequestContext.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class LoaderViewModel extends ViewModel {
        private static final ViewModelProvider.Factory BuiltInFictitiousFunctionClassFactory = new ViewModelProvider.Factory() { // from class: androidx.loader.app.LoaderManagerImpl.LoaderViewModel.1
            @Override // androidx.lifecycle.ViewModelProvider.Factory
            public final /* synthetic */ ViewModel MyBillsEntityDataFactory(Class cls, CreationExtras creationExtras) {
                return ViewModelProvider.Factory.CC.BuiltInFictitiousFunctionClassFactory(this, cls, creationExtras);
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            public final <T extends ViewModel> T BuiltInFictitiousFunctionClassFactory(Class<T> cls) {
                return new LoaderViewModel();
            }
        };
        SparseArrayCompat<LoaderInfo> getAuthRequestContext = new SparseArrayCompat<>();
        boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;

        LoaderViewModel() {
        }

        static LoaderViewModel getAuthRequestContext(ViewModelStore viewModelStore) {
            return (LoaderViewModel) new ViewModelProvider(viewModelStore, BuiltInFictitiousFunctionClassFactory).MyBillsEntityDataFactory(LoaderViewModel.class);
        }

        final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Override // androidx.view.ViewModel
        public void onCleared() {
            super.onCleared();
            int MyBillsEntityDataFactory = this.getAuthRequestContext.MyBillsEntityDataFactory();
            for (int i = 0; i < MyBillsEntityDataFactory; i++) {
                this.getAuthRequestContext.lookAheadTest(i).PlaceComponentResult();
            }
            this.getAuthRequestContext.PlaceComponentResult();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoaderManagerImpl(LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        this.getAuthRequestContext = lifecycleOwner;
        this.BuiltInFictitiousFunctionClassFactory = LoaderViewModel.getAuthRequestContext(viewModelStore);
    }

    private <D> Loader<D> PlaceComponentResult(LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        try {
            this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            Loader<D> onCreateLoader = loaderCallbacks.onCreateLoader(0, null);
            if (onCreateLoader == null) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
            }
            if (onCreateLoader.getClass().isMemberClass() && !Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                StringBuilder sb = new StringBuilder();
                sb.append("Object returned from onCreateLoader must not be a non-static inner member class: ");
                sb.append(onCreateLoader);
                throw new IllegalArgumentException(sb.toString());
            }
            LoaderInfo loaderInfo = new LoaderInfo(0, null, onCreateLoader);
            if (PlaceComponentResult) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("  Created new loader ");
                sb2.append(loaderInfo);
                InstrumentInjector.log_v("LoaderManager", sb2.toString());
            }
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.PlaceComponentResult(0, loaderInfo);
            this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = false;
            return loaderInfo.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, loaderCallbacks);
        } catch (Throwable th) {
            this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = false;
            throw th;
        }
    }

    @Override // androidx.loader.app.LoaderManager
    public final <D> Loader<D> getAuthRequestContext(LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        LoaderInfo BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(0);
        if (PlaceComponentResult) {
            StringBuilder sb = new StringBuilder();
            sb.append("initLoader in ");
            sb.append(this);
            sb.append(": args=");
            sb.append((Object) null);
            InstrumentInjector.log_v("LoaderManager", sb.toString());
        }
        if (BuiltInFictitiousFunctionClassFactory == null) {
            return PlaceComponentResult(loaderCallbacks);
        }
        if (PlaceComponentResult) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("  Re-using existing loader ");
            sb2.append(BuiltInFictitiousFunctionClassFactory);
            InstrumentInjector.log_v("LoaderManager", sb2.toString());
        }
        return BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, loaderCallbacks);
    }

    @Override // androidx.loader.app.LoaderManager
    public final void PlaceComponentResult() {
        LoaderViewModel loaderViewModel = this.BuiltInFictitiousFunctionClassFactory;
        int MyBillsEntityDataFactory2 = loaderViewModel.getAuthRequestContext.MyBillsEntityDataFactory();
        for (int i = 0; i < MyBillsEntityDataFactory2; i++) {
            loaderViewModel.getAuthRequestContext.lookAheadTest(i).KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        try {
            Object[] objArr = {this};
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
            byte b2 = b;
            Object[] objArr2 = new Object[1];
            a(b, b2, b2, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
            byte b4 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
            Object[] objArr3 = new Object[1];
            a(b3, b4, b4, objArr3);
            sb.append(Integer.toHexString(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue()));
            sb.append(" in ");
            DebugUtils.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, sb);
            sb.append("}}");
            return sb.toString();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    @Override // androidx.loader.app.LoaderManager
    @Deprecated
    public final void MyBillsEntityDataFactory(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        LoaderViewModel loaderViewModel = this.BuiltInFictitiousFunctionClassFactory;
        if (loaderViewModel.getAuthRequestContext.MyBillsEntityDataFactory() > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("    ");
            String obj = sb.toString();
            for (int i = 0; i < loaderViewModel.getAuthRequestContext.MyBillsEntityDataFactory(); i++) {
                LoaderInfo lookAheadTest = loaderViewModel.getAuthRequestContext.lookAheadTest(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(loaderViewModel.getAuthRequestContext.PlaceComponentResult(i));
                printWriter.print(": ");
                printWriter.println(lookAheadTest.toString());
                printWriter.print(obj);
                printWriter.print("mId=");
                printWriter.print(lookAheadTest.scheduleImpl);
                printWriter.print(" mArgs=");
                printWriter.println(lookAheadTest.PlaceComponentResult);
                printWriter.print(obj);
                printWriter.print("mLoader=");
                printWriter.println(lookAheadTest.NetworkUserEntityData$$ExternalSyntheticLambda0);
                Loader<D> loader = lookAheadTest.NetworkUserEntityData$$ExternalSyntheticLambda0;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(obj);
                sb2.append("  ");
                loader.dump(sb2.toString(), fileDescriptor, printWriter, strArr);
                if (lookAheadTest.lookAheadTest != null) {
                    printWriter.print(obj);
                    printWriter.print("mCallbacks=");
                    printWriter.println(lookAheadTest.lookAheadTest);
                    LoaderObserver<D> loaderObserver = lookAheadTest.lookAheadTest;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(obj);
                    sb3.append("  ");
                    printWriter.print(sb3.toString());
                    printWriter.print("mDeliveredData=");
                    printWriter.println(loaderObserver.BuiltInFictitiousFunctionClassFactory);
                }
                printWriter.print(obj);
                printWriter.print("mData=");
                Loader<D> loader2 = lookAheadTest.NetworkUserEntityData$$ExternalSyntheticLambda0;
                Object obj2 = lookAheadTest.BuiltInFictitiousFunctionClassFactory;
                if (obj2 == LiveData.MyBillsEntityDataFactory) {
                    obj2 = null;
                }
                printWriter.println(loader2.dataToString(obj2));
                printWriter.print(obj);
                printWriter.print("mStarted=");
                printWriter.println(lookAheadTest.MyBillsEntityDataFactory());
            }
        }
    }
}

package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;

/* loaded from: classes3.dex */
public final class InputContentInfoCompat {
    private final InputContentInfoCompatImpl MyBillsEntityDataFactory;

    /* loaded from: classes3.dex */
    interface InputContentInfoCompatImpl {
        void BuiltInFictitiousFunctionClassFactory();

        Uri KClassImpl$Data$declaredNonStaticMembers$2();

        ClipDescription MyBillsEntityDataFactory();

        Uri PlaceComponentResult();

        Object getAuthRequestContext();
    }

    /* loaded from: classes3.dex */
    static final class InputContentInfoCompatBaseImpl implements InputContentInfoCompatImpl {
        private final ClipDescription MyBillsEntityDataFactory;
        private final Uri PlaceComponentResult;
        private final Uri getAuthRequestContext;

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public final void BuiltInFictitiousFunctionClassFactory() {
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public final Object getAuthRequestContext() {
            return null;
        }

        InputContentInfoCompatBaseImpl(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.PlaceComponentResult = uri;
            this.MyBillsEntityDataFactory = clipDescription;
            this.getAuthRequestContext = uri2;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public final Uri KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.PlaceComponentResult;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public final ClipDescription MyBillsEntityDataFactory() {
            return this.MyBillsEntityDataFactory;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public final Uri PlaceComponentResult() {
            return this.getAuthRequestContext;
        }
    }

    /* loaded from: classes3.dex */
    static final class InputContentInfoCompatApi25Impl implements InputContentInfoCompatImpl {
        final InputContentInfo PlaceComponentResult;

        InputContentInfoCompatApi25Impl(Object obj) {
            this.PlaceComponentResult = (InputContentInfo) obj;
        }

        InputContentInfoCompatApi25Impl(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.PlaceComponentResult = new InputContentInfo(uri, clipDescription, uri2);
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public final Uri KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.PlaceComponentResult.getContentUri();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public final ClipDescription MyBillsEntityDataFactory() {
            return this.PlaceComponentResult.getDescription();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public final Uri PlaceComponentResult() {
            return this.PlaceComponentResult.getLinkUri();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public final Object getAuthRequestContext() {
            return this.PlaceComponentResult;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public final void BuiltInFictitiousFunctionClassFactory() {
            this.PlaceComponentResult.requestPermission();
        }
    }

    public InputContentInfoCompat(Uri uri, ClipDescription clipDescription, Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.MyBillsEntityDataFactory = new InputContentInfoCompatApi25Impl(uri, clipDescription, uri2);
        } else {
            this.MyBillsEntityDataFactory = new InputContentInfoCompatBaseImpl(uri, clipDescription, uri2);
        }
    }

    private InputContentInfoCompat(InputContentInfoCompatImpl inputContentInfoCompatImpl) {
        this.MyBillsEntityDataFactory = inputContentInfoCompatImpl;
    }

    public final Uri MyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public final ClipDescription PlaceComponentResult() {
        return this.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
    }

    public final Uri getAuthRequestContext() {
        return this.MyBillsEntityDataFactory.PlaceComponentResult();
    }

    public static InputContentInfoCompat PlaceComponentResult(Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new InputContentInfoCompat(new InputContentInfoCompatApi25Impl(obj));
        }
        return null;
    }

    public final Object BuiltInFictitiousFunctionClassFactory() {
        return this.MyBillsEntityDataFactory.getAuthRequestContext();
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
    }
}

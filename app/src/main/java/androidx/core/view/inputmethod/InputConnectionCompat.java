package androidx.core.view.inputmethod;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes.dex */
public final class InputConnectionCompat {

    /* loaded from: classes3.dex */
    public interface OnCommitContentListener {
        boolean KClassImpl$Data$declaredNonStaticMembers$2(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    static boolean getAuthRequestContext(String str, Bundle bundle, OnCommitContentListener onCommitContentListener) {
        boolean z;
        ResultReceiver resultReceiver;
        ?? r0 = 0;
        r0 = 0;
        if (bundle == null) {
            return false;
        }
        if (TextUtils.equals("androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", str)) {
            z = false;
        } else if (!TextUtils.equals("android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", str)) {
            return false;
        } else {
            z = true;
        }
        try {
            resultReceiver = (ResultReceiver) bundle.getParcelable(z ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER");
        } catch (Throwable th) {
            th = th;
            resultReceiver = 0;
        }
        try {
            Uri uri = (Uri) bundle.getParcelable(z ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI");
            ClipDescription clipDescription = (ClipDescription) bundle.getParcelable(z ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION");
            Uri uri2 = (Uri) bundle.getParcelable(z ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI");
            int i = bundle.getInt(z ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS");
            Bundle bundle2 = (Bundle) bundle.getParcelable(z ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS");
            if (uri != null && clipDescription != null) {
                r0 = onCommitContentListener.KClassImpl$Data$declaredNonStaticMembers$2(new InputContentInfoCompat(uri, clipDescription, uri2), i, bundle2);
            }
            if (resultReceiver != 0) {
                resultReceiver.send(r0, null);
            }
            return r0;
        } catch (Throwable th2) {
            th = th2;
            if (resultReceiver != 0) {
                resultReceiver.send(0, null);
            }
            throw th;
        }
    }

    @Deprecated
    public static InputConnection BuiltInFictitiousFunctionClassFactory(InputConnection inputConnection, EditorInfo editorInfo, final OnCommitContentListener onCommitContentListener) {
        ObjectsCompat.getAuthRequestContext(inputConnection, "inputConnection must be non-null");
        ObjectsCompat.getAuthRequestContext(editorInfo, "editorInfo must be non-null");
        ObjectsCompat.getAuthRequestContext(onCommitContentListener, "onCommitContentListener must be non-null");
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 25) {
            return new InputConnectionWrapper(inputConnection, z) { // from class: androidx.core.view.inputmethod.InputConnectionCompat.1
                @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
                public boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
                    if (onCommitContentListener.KClassImpl$Data$declaredNonStaticMembers$2(InputContentInfoCompat.PlaceComponentResult(inputContentInfo), i, bundle)) {
                        return true;
                    }
                    return super.commitContent(inputContentInfo, i, bundle);
                }
            };
        }
        return EditorInfoCompat.MyBillsEntityDataFactory(editorInfo).length == 0 ? inputConnection : new InputConnectionWrapper(inputConnection, z) { // from class: androidx.core.view.inputmethod.InputConnectionCompat.2
            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean performPrivateCommand(String str, Bundle bundle) {
                if (InputConnectionCompat.getAuthRequestContext(str, bundle, onCommitContentListener)) {
                    return true;
                }
                return super.performPrivateCommand(str, bundle);
            }
        };
    }

    public static InputConnection PlaceComponentResult(View view, InputConnection inputConnection, EditorInfo editorInfo) {
        return BuiltInFictitiousFunctionClassFactory(inputConnection, editorInfo, BuiltInFictitiousFunctionClassFactory(view));
    }

    private static OnCommitContentListener BuiltInFictitiousFunctionClassFactory(final View view) {
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(view);
        return new OnCommitContentListener() { // from class: androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0
            @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
            public final boolean KClassImpl$Data$declaredNonStaticMembers$2(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
                return InputConnectionCompat.MyBillsEntityDataFactory(view, inputContentInfoCompat, i, bundle);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean MyBillsEntityDataFactory(View view, InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 25 && (i & 1) != 0) {
            try {
                inputContentInfoCompat.KClassImpl$Data$declaredNonStaticMembers$2();
                InputContentInfo inputContentInfo = (InputContentInfo) inputContentInfoCompat.BuiltInFictitiousFunctionClassFactory();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo);
            } catch (Exception e) {
                InstrumentInjector.log_w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e);
                return false;
            }
        }
        return ViewCompat.getAuthRequestContext(view, new ContentInfoCompat.Builder(new ClipData(inputContentInfoCompat.PlaceComponentResult(), new ClipData.Item(inputContentInfoCompat.MyBillsEntityDataFactory())), 2).KClassImpl$Data$declaredNonStaticMembers$2(inputContentInfoCompat.getAuthRequestContext()).PlaceComponentResult(bundle).KClassImpl$Data$declaredNonStaticMembers$2()) == null;
    }

    @Deprecated
    public InputConnectionCompat() {
    }

    /* loaded from: classes6.dex */
    static class Api25Impl {
        private Api25Impl() {
        }
    }
}

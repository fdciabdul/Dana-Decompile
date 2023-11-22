package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.util.Preconditions;

/* loaded from: classes.dex */
final class AppCompatTextClassifierHelper {
    private TextClassifier BuiltInFictitiousFunctionClassFactory;
    private TextView getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatTextClassifierHelper(TextView textView) {
        this.getAuthRequestContext = (TextView) Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(textView);
    }

    public final void MyBillsEntityDataFactory(TextClassifier textClassifier) {
        this.BuiltInFictitiousFunctionClassFactory = textClassifier;
    }

    public final TextClassifier MyBillsEntityDataFactory() {
        TextClassifier textClassifier = this.BuiltInFictitiousFunctionClassFactory;
        return textClassifier == null ? Api26Impl.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext) : textClassifier;
    }

    /* loaded from: classes.dex */
    static final class Api26Impl {
        private Api26Impl() {
        }

        static TextClassifier KClassImpl$Data$declaredNonStaticMembers$2(TextView textView) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
            if (textClassificationManager != null) {
                return textClassificationManager.getTextClassifier();
            }
            return TextClassifier.NO_OP;
        }
    }
}

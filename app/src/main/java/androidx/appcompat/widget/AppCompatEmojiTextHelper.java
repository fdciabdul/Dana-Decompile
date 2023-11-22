package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.emoji2.viewsintegration.EmojiTextViewHelper;

/* loaded from: classes.dex */
class AppCompatEmojiTextHelper {
    private final EmojiTextViewHelper MyBillsEntityDataFactory;
    private final TextView getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatEmojiTextHelper(TextView textView) {
        this.getAuthRequestContext = textView;
        this.MyBillsEntityDataFactory = new EmojiTextViewHelper(textView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getAuthRequestContext(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.getAuthRequestContext.getContext().obtainStyledAttributes(attributeSet, R.styleable.V, i, 0);
        try {
            boolean z = obtainStyledAttributes.hasValue(R.styleable.QrExpiredActivity) ? obtainStyledAttributes.getBoolean(R.styleable.QrExpiredActivity, true) : true;
            obtainStyledAttributes.recycle();
            MyBillsEntityDataFactory(z);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void MyBillsEntityDataFactory(boolean z) {
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(z);
    }

    public boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InputFilter[] BuiltInFictitiousFunctionClassFactory(InputFilter[] inputFilterArr) {
        return this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(inputFilterArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getAuthRequestContext(boolean z) {
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(z);
    }

    public TransformationMethod getAuthRequestContext(TransformationMethod transformationMethod) {
        return this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(transformationMethod);
    }
}

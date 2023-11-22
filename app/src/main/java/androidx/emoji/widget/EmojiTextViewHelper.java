package androidx.emoji.widget;

import android.os.Build;
import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.widget.TextView;
import androidx.core.util.Preconditions;

/* loaded from: classes3.dex */
public final class EmojiTextViewHelper {
    final HelperInternal PlaceComponentResult;

    public EmojiTextViewHelper(TextView textView) {
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(textView, "textView cannot be null");
        this.PlaceComponentResult = Build.VERSION.SDK_INT >= 19 ? new HelperInternal19(textView) : new HelperInternal();
    }

    /* loaded from: classes3.dex */
    static class HelperInternal {
        /* JADX INFO: Access modifiers changed from: package-private */
        public void KClassImpl$Data$declaredNonStaticMembers$2() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void MyBillsEntityDataFactory(boolean z) {
        }

        TransformationMethod PlaceComponentResult(TransformationMethod transformationMethod) {
            return transformationMethod;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public InputFilter[] PlaceComponentResult(InputFilter[] inputFilterArr) {
            return inputFilterArr;
        }

        HelperInternal() {
        }
    }

    /* loaded from: classes3.dex */
    static class HelperInternal19 extends HelperInternal {
        private final EmojiInputFilter PlaceComponentResult;
        private final TextView getAuthRequestContext;

        HelperInternal19(TextView textView) {
            this.getAuthRequestContext = textView;
            this.PlaceComponentResult = new EmojiInputFilter(textView);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.emoji.widget.EmojiTextViewHelper.HelperInternal
        public void KClassImpl$Data$declaredNonStaticMembers$2() {
            TransformationMethod transformationMethod = this.getAuthRequestContext.getTransformationMethod();
            if (transformationMethod == null || (transformationMethod instanceof PasswordTransformationMethod)) {
                return;
            }
            this.getAuthRequestContext.setTransformationMethod(PlaceComponentResult(transformationMethod));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.emoji.widget.EmojiTextViewHelper.HelperInternal
        public InputFilter[] PlaceComponentResult(InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter instanceof EmojiInputFilter) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.PlaceComponentResult;
            return inputFilterArr2;
        }

        @Override // androidx.emoji.widget.EmojiTextViewHelper.HelperInternal
        TransformationMethod PlaceComponentResult(TransformationMethod transformationMethod) {
            return transformationMethod instanceof EmojiTransformationMethod ? transformationMethod : new EmojiTransformationMethod(transformationMethod);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.emoji.widget.EmojiTextViewHelper.HelperInternal
        public void MyBillsEntityDataFactory(boolean z) {
            if (z) {
                KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }
    }
}

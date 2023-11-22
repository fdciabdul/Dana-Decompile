package androidx.emoji2.viewsintegration;

import android.os.Build;
import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: classes.dex */
public final class EmojiTextViewHelper {
    public final HelperInternal KClassImpl$Data$declaredNonStaticMembers$2;

    public EmojiTextViewHelper(TextView textView) {
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(textView, "textView cannot be null");
        if (Build.VERSION.SDK_INT < 19) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new HelperInternal();
        } else {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new SkippingHelper19(textView);
        }
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult();
    }

    /* loaded from: classes.dex */
    public static class HelperInternal {
        void BuiltInFictitiousFunctionClassFactory() {
        }

        public void BuiltInFictitiousFunctionClassFactory(boolean z) {
        }

        public void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        }

        public TransformationMethod MyBillsEntityDataFactory(TransformationMethod transformationMethod) {
            return transformationMethod;
        }

        public boolean PlaceComponentResult() {
            return false;
        }

        public InputFilter[] getAuthRequestContext(InputFilter[] inputFilterArr) {
            return inputFilterArr;
        }

        HelperInternal() {
        }
    }

    /* loaded from: classes.dex */
    static class SkippingHelper19 extends HelperInternal {
        private final HelperInternal19 PlaceComponentResult;

        SkippingHelper19(TextView textView) {
            this.PlaceComponentResult = new HelperInternal19(textView);
        }

        private boolean MyBillsEntityDataFactory() {
            return !EmojiCompat.getAuthRequestContext();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void BuiltInFictitiousFunctionClassFactory() {
            if (MyBillsEntityDataFactory()) {
                return;
            }
            this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public InputFilter[] getAuthRequestContext(InputFilter[] inputFilterArr) {
            return MyBillsEntityDataFactory() ? inputFilterArr : this.PlaceComponentResult.getAuthRequestContext(inputFilterArr);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public TransformationMethod MyBillsEntityDataFactory(TransformationMethod transformationMethod) {
            return MyBillsEntityDataFactory() ? transformationMethod : this.PlaceComponentResult.MyBillsEntityDataFactory(transformationMethod);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
            if (MyBillsEntityDataFactory()) {
                return;
            }
            this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(z);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public void BuiltInFictitiousFunctionClassFactory(boolean z) {
            if (MyBillsEntityDataFactory()) {
                this.PlaceComponentResult.getAuthRequestContext(z);
            } else {
                this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(z);
            }
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public boolean PlaceComponentResult() {
            return this.PlaceComponentResult.PlaceComponentResult();
        }
    }

    /* loaded from: classes.dex */
    static class HelperInternal19 extends HelperInternal {
        private final TextView BuiltInFictitiousFunctionClassFactory;
        private final EmojiInputFilter KClassImpl$Data$declaredNonStaticMembers$2;
        private boolean PlaceComponentResult = true;

        HelperInternal19(TextView textView) {
            this.BuiltInFictitiousFunctionClassFactory = textView;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new EmojiInputFilter(textView);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void BuiltInFictitiousFunctionClassFactory() {
            this.BuiltInFictitiousFunctionClassFactory.setTransformationMethod(MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.getTransformationMethod()));
        }

        private void MyBillsEntityDataFactory() {
            this.BuiltInFictitiousFunctionClassFactory.setFilters(getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.getFilters()));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public InputFilter[] getAuthRequestContext(InputFilter[] inputFilterArr) {
            if (!this.PlaceComponentResult) {
                return BuiltInFictitiousFunctionClassFactory(inputFilterArr);
            }
            return KClassImpl$Data$declaredNonStaticMembers$2(inputFilterArr);
        }

        private InputFilter[] KClassImpl$Data$declaredNonStaticMembers$2(InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.KClassImpl$Data$declaredNonStaticMembers$2;
            return inputFilterArr2;
        }

        private InputFilter[] BuiltInFictitiousFunctionClassFactory(InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> MyBillsEntityDataFactory = MyBillsEntityDataFactory(inputFilterArr);
            if (MyBillsEntityDataFactory.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - MyBillsEntityDataFactory.size()];
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (MyBillsEntityDataFactory.indexOfKey(i2) < 0) {
                    inputFilterArr2[i] = inputFilterArr[i2];
                    i++;
                }
            }
            return inputFilterArr2;
        }

        private SparseArray<InputFilter> MyBillsEntityDataFactory(InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArray = new SparseArray<>(1);
            for (int i = 0; i < inputFilterArr.length; i++) {
                InputFilter inputFilter = inputFilterArr[i];
                if (inputFilter instanceof EmojiInputFilter) {
                    sparseArray.put(i, inputFilter);
                }
            }
            return sparseArray;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public TransformationMethod MyBillsEntityDataFactory(TransformationMethod transformationMethod) {
            if (this.PlaceComponentResult) {
                return PlaceComponentResult(transformationMethod);
            }
            return KClassImpl$Data$declaredNonStaticMembers$2(transformationMethod);
        }

        private TransformationMethod KClassImpl$Data$declaredNonStaticMembers$2(TransformationMethod transformationMethod) {
            return transformationMethod instanceof EmojiTransformationMethod ? ((EmojiTransformationMethod) transformationMethod).KClassImpl$Data$declaredNonStaticMembers$2 : transformationMethod;
        }

        private TransformationMethod PlaceComponentResult(TransformationMethod transformationMethod) {
            return ((transformationMethod instanceof EmojiTransformationMethod) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new EmojiTransformationMethod(transformationMethod);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
            if (z) {
                BuiltInFictitiousFunctionClassFactory();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public void BuiltInFictitiousFunctionClassFactory(boolean z) {
            this.PlaceComponentResult = z;
            BuiltInFictitiousFunctionClassFactory();
            MyBillsEntityDataFactory();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public boolean PlaceComponentResult() {
            return this.PlaceComponentResult;
        }

        void getAuthRequestContext(boolean z) {
            this.PlaceComponentResult = z;
        }
    }
}

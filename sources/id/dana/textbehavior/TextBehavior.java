package id.dana.textbehavior;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import id.dana.textbehavior.manipulate.Manipulator;
import id.dana.textbehavior.validate.Validator;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class TextBehavior {
    /* synthetic */ TextBehavior(EditTextBehaviorBuilder editTextBehaviorBuilder, byte b) {
        this(editTextBehaviorBuilder);
    }

    /* synthetic */ TextBehavior(TextViewBehaviorBuilder textViewBehaviorBuilder, byte b) {
        this(textViewBehaviorBuilder);
    }

    private TextBehavior(TextViewBehaviorBuilder textViewBehaviorBuilder) {
        TextView authRequestContext = textViewBehaviorBuilder.getAuthRequestContext();
        final List<Validator> list = textViewBehaviorBuilder.BuiltInFictitiousFunctionClassFactory;
        final OnValidatedListener onValidatedListener = textViewBehaviorBuilder.MyBillsEntityDataFactory;
        if (list == null || list.size() <= 0) {
            return;
        }
        authRequestContext.addTextChangedListener(new TextWatcher() { // from class: id.dana.textbehavior.TextBehavior.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ArrayList arrayList = new ArrayList();
                String charSequence2 = charSequence.toString();
                for (Validator validator : list) {
                    if (!validator.MyBillsEntityDataFactory(charSequence2)) {
                        arrayList.add(new InvalidReason(validator));
                    }
                }
                if (onValidatedListener != null) {
                    if (arrayList.size() > 0) {
                        onValidatedListener.MyBillsEntityDataFactory(charSequence2, arrayList);
                    } else {
                        onValidatedListener.getAuthRequestContext(charSequence2);
                    }
                }
            }
        });
    }

    private TextBehavior(EditTextBehaviorBuilder editTextBehaviorBuilder) {
        EditText editText = editTextBehaviorBuilder.KClassImpl$Data$declaredNonStaticMembers$2;
        final List<Validator> list = editTextBehaviorBuilder.BuiltInFictitiousFunctionClassFactory;
        final OnValidatedListener onValidatedListener = editTextBehaviorBuilder.MyBillsEntityDataFactory;
        if (list != null && list.size() > 0) {
            editText.addTextChangedListener(new TextWatcher() { // from class: id.dana.textbehavior.TextBehavior.1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    ArrayList arrayList = new ArrayList();
                    String charSequence2 = charSequence.toString();
                    for (Validator validator : list) {
                        if (!validator.MyBillsEntityDataFactory(charSequence2)) {
                            arrayList.add(new InvalidReason(validator));
                        }
                    }
                    if (onValidatedListener != null) {
                        if (arrayList.size() > 0) {
                            onValidatedListener.MyBillsEntityDataFactory(charSequence2, arrayList);
                        } else {
                            onValidatedListener.getAuthRequestContext(charSequence2);
                        }
                    }
                }
            });
        }
        final EditText editText2 = editTextBehaviorBuilder.KClassImpl$Data$declaredNonStaticMembers$2;
        final Manipulator manipulator = editTextBehaviorBuilder.getAuthRequestContext;
        if (manipulator != null) {
            editText2.addTextChangedListener(new TextWatcher() { // from class: id.dana.textbehavior.TextBehavior.2
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    manipulator.BuiltInFictitiousFunctionClassFactory(editText2, i);
                }
            });
        }
    }

    /* loaded from: classes5.dex */
    public static class Builder {
        public static EditTextBehaviorBuilder PlaceComponentResult(EditText editText) {
            return new EditTextBehaviorBuilder(editText, (byte) 0);
        }
    }

    /* loaded from: classes5.dex */
    public static class EditTextBehaviorBuilder extends TextViewBehaviorBuilder {
        EditText KClassImpl$Data$declaredNonStaticMembers$2;
        public Manipulator getAuthRequestContext;

        /* synthetic */ EditTextBehaviorBuilder(EditText editText, byte b) {
            this(editText);
        }

        private EditTextBehaviorBuilder(EditText editText) {
            super(editText, (byte) 0);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = editText;
        }

        @Override // id.dana.textbehavior.TextBehavior.TextViewBehaviorBuilder
        public final TextBehavior KClassImpl$Data$declaredNonStaticMembers$2() {
            return new TextBehavior(this, (byte) 0);
        }

        @Override // id.dana.textbehavior.TextBehavior.TextViewBehaviorBuilder
        public final /* bridge */ /* synthetic */ TextView getAuthRequestContext() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    /* loaded from: classes5.dex */
    public static class TextViewBehaviorBuilder {
        public List<Validator> BuiltInFictitiousFunctionClassFactory;
        private TextView KClassImpl$Data$declaredNonStaticMembers$2;
        public OnValidatedListener MyBillsEntityDataFactory;

        /* synthetic */ TextViewBehaviorBuilder(TextView textView, byte b) {
            this(textView);
        }

        private TextViewBehaviorBuilder(TextView textView) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
        }

        public TextView getAuthRequestContext() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        public TextBehavior KClassImpl$Data$declaredNonStaticMembers$2() {
            return new TextBehavior(this, (byte) 0);
        }
    }
}

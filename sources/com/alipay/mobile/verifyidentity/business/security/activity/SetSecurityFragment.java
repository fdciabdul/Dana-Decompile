package com.alipay.mobile.verifyidentity.business.security.activity;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.mobile.verifyidentity.base.adapter.ListViewAdapter;
import com.alipay.mobile.verifyidentity.base.adapter.ViewHolder;
import com.alipay.mobile.verifyidentity.business.security.R;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.QuestionItem;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.SinglePicker;
import com.google.common.base.Ascii;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes7.dex */
public class SetSecurityFragment extends Fragment {
    private ArrayList<List<QuestionItem>> adapterList;
    private String[] answerId;
    String bottomDialogItemContent;
    int bottomDialogItemPosition;
    private String from_title;
    InputFilter inputFilter = new InputFilter() { // from class: com.alipay.mobile.verifyidentity.business.security.activity.SetSecurityFragment.1
        Pattern emoji = Pattern.compile("[🀀-🏿]|[🐀-\u1f7ff]|[☀-⟿]", 66);

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if (this.emoji.matcher(charSequence).find()) {
                return "";
            }
            return null;
        }
    };
    boolean isChooseBottomDialogItem = false;
    private ListView listView;
    public CommitCallBack mCommitCallBack;
    private int mCurrentPosition;
    private int page_number;
    private int page_size;
    private QuestionItem[] questionItemArr;
    private SecuritySetQuestionAdapter securitySetQuestionAdapter;
    private TextView tv_center;
    private TextView tv_confirm;
    private View viewGroup;
    public static final byte[] $$a = {Ascii.FS, 71, 97, TarHeader.LF_DIR, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 100;
    public static final byte[] getAuthRequestContext = {Ascii.RS, 119, -63, 113, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int BuiltInFictitiousFunctionClassFactory = 12;

    /* loaded from: classes7.dex */
    public interface CommitCallBack {
        void commit(String[] strArr, QuestionItem[] questionItemArr, int i, int i2);
    }

    private static void a(short s, byte b, byte b2, Object[] objArr) {
        int i = b2 + 105;
        byte[] bArr = getAuthRequestContext;
        int i2 = 16 - (b * 4);
        int i3 = (s * 15) + 4;
        byte[] bArr2 = new byte[i2];
        int i4 = -1;
        int i5 = i2 - 1;
        if (bArr == null) {
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = -1;
            i = i + (-i3) + 2;
            i3++;
            i5 = i5;
        }
        while (true) {
            int i6 = i4 + 1;
            bArr2[i6] = (byte) i;
            if (i6 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b3 = bArr[i3];
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = i6;
            i = i + (-b3) + 2;
            i3++;
            i5 = i5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 2
            int r6 = 42 - r6
            int r8 = r8 * 2
            int r8 = 75 - r8
            byte[] r0 = com.alipay.mobile.verifyidentity.business.security.activity.SetSecurityFragment.$$a
            int r7 = r7 * 4
            int r7 = r7 + 4
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L17
            r4 = r8
            r3 = 0
            r8 = r6
            goto L30
        L17:
            r3 = 0
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L1c:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r7) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r4 = r0[r8]
            r5 = r8
            r8 = r7
            r7 = r5
        L30:
            int r7 = r7 + 1
            int r6 = r6 + r4
            int r6 = r6 + (-7)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.verifyidentity.business.security.activity.SetSecurityFragment.b(int, byte, int, java.lang.Object[]):void");
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        try {
            byte b = getAuthRequestContext[5];
            Object[] objArr = new Object[1];
            a(b, (byte) (b - 1), getAuthRequestContext[5], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (getAuthRequestContext[5] - 1);
            byte b3 = b2;
            Object[] objArr2 = new Object[1];
            a(b2, b3, b3, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - ((Process.getThreadPriority(0) + 20) >> 6), (Process.myPid() >> 22) + 4, (char) ((-16777216) - Color.rgb(0, 0, 0)));
                    byte b4 = (byte) ($$a[35] - 1);
                    byte b5 = b4;
                    Object[] objArr4 = new Object[1];
                    b(b4, b5, b5, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r1 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetAfter("", 0), 35 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {2017884633, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 912, 18 - Drawable.resolveOpacity(0, 0), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj3);
                            }
                            ((Method) obj3).invoke(invoke, objArr6);
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
                super.onCreate(bundle);
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        } catch (Throwable th4) {
            Throwable cause4 = th4.getCause();
            if (cause4 == null) {
                throw th4;
            }
            throw cause4;
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.viewGroup == null) {
            this.viewGroup = layoutInflater.inflate(R.layout.fragment_set_security, viewGroup, false);
            init();
        }
        return this.viewGroup;
    }

    private void init() {
        initView();
        initData();
    }

    private void initView() {
        this.listView = (ListView) this.viewGroup.findViewById(R.id.listView);
        this.tv_center = (TextView) this.viewGroup.findViewById(R.id.tv_center);
        TextView textView = (TextView) this.viewGroup.findViewById(R.id.tv_confirm);
        this.tv_confirm = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.security.activity.SetSecurityFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!SetSecurityFragment.this.isSeleteAll() || SetSecurityFragment.this.mCommitCallBack == null) {
                    return;
                }
                SetSecurityFragment.this.mCommitCallBack.commit(SetSecurityFragment.this.answerId, SetSecurityFragment.this.questionItemArr, SetSecurityFragment.this.page_size, SetSecurityFragment.this.page_number);
            }
        });
    }

    private void initData() {
        Bundle arguments = getArguments();
        this.page_size = arguments.getInt(SecurityConstants.KEY_PAGE_SIZE);
        this.page_number = arguments.getInt("pageNum");
        this.from_title = arguments.getString("form_title");
        ArrayList<List<QuestionItem>> arrayList = (ArrayList) arguments.getSerializable(SecurityConstants.KEY_SET_SECURITY_BUNDLE);
        this.adapterList = arrayList;
        this.questionItemArr = new QuestionItem[arrayList.size()];
        this.answerId = new String[this.adapterList.size()];
        SecuritySetQuestionAdapter securitySetQuestionAdapter = new SecuritySetQuestionAdapter(getActivity(), this.adapterList, R.layout.security_setquestion_item);
        this.securitySetQuestionAdapter = securitySetQuestionAdapter;
        this.listView.setAdapter((ListAdapter) securitySetQuestionAdapter);
        if (this.page_size != this.page_number) {
            this.tv_confirm.setText(R.string.set_security_next);
        } else {
            this.tv_confirm.setText(R.string.set_security_confirm);
        }
        if (TextUtils.isEmpty(this.from_title)) {
            return;
        }
        this.tv_center.setText(this.from_title);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class SecuritySetQuestionAdapter extends ListViewAdapter<List<QuestionItem>> {
        public SecuritySetQuestionAdapter(Context context, ArrayList<List<QuestionItem>> arrayList, int i) {
            super(context, arrayList, i);
        }

        @Override // com.alipay.mobile.verifyidentity.base.adapter.ListViewAdapter
        public void convert(final ViewHolder viewHolder, final List<QuestionItem> list, final int i) {
            if (SetSecurityFragment.this.questionItemArr[i] == null) {
                TextView textView = (TextView) viewHolder.getView(R.id.tv_question);
                StringBuilder sb = new StringBuilder();
                sb.append(SetSecurityFragment.this.getResources().getString(R.string.security_choose_question));
                sb.append(" ");
                sb.append(i + 1);
                textView.setText(sb.toString());
            }
            viewHolder.getView(R.id.rl_title).setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.security.activity.SetSecurityFragment.SecuritySetQuestionAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SetSecurityFragment.this.mCurrentPosition = i;
                    SetSecurityFragment.this.showQuestionDialog(list, viewHolder);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showQuestionDialog(final List<QuestionItem> list, final ViewHolder viewHolder) {
        SinglePicker singlePicker = new SinglePicker(getActivity(), list);
        singlePicker.setCanceledOnTouchOutside(false);
        singlePicker.setSelectedIndex(0);
        singlePicker.setCycleDisable(true);
        singlePicker.setDividerColor(getResources().getColor(R.color.pick_line));
        singlePicker.setDividerRatio(0.0f);
        singlePicker.setTextPadding(15);
        singlePicker.setLineSpaceMultiplier(3.0f);
        singlePicker.setTopLineColor(getResources().getColor(R.color.pick_line));
        singlePicker.setCancelTextColor(getResources().getColor(R.color.pick_cancle));
        singlePicker.setSubmitTextColor(getResources().getColor(R.color.theme_color));
        singlePicker.setTextColor(getResources().getColor(R.color.pick_black));
        singlePicker.setOnItemPickListener(new SinglePicker.OnItemPickListener<QuestionItem>() { // from class: com.alipay.mobile.verifyidentity.business.security.activity.SetSecurityFragment.3
            @Override // com.alipay.mobile.verifyidentity.business.securitycommon.widget.SinglePicker.OnItemPickListener
            public void onItemPicked(int i, QuestionItem questionItem) {
                SetSecurityFragment.this.bottomDialogItemContent = questionItem.getContent();
                SetSecurityFragment.this.bottomDialogItemPosition = i;
                SetSecurityFragment setSecurityFragment = SetSecurityFragment.this;
                setSecurityFragment.setListAdapterAfterClickBottomQuestion(setSecurityFragment.bottomDialogItemContent, SetSecurityFragment.this.bottomDialogItemPosition, viewHolder, list, SetSecurityFragment.this.mCurrentPosition);
            }
        });
        singlePicker.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAnswerDialog(final List<QuestionItem.QuestionsOptions> list, final ViewHolder viewHolder) {
        SinglePicker singlePicker = new SinglePicker(getActivity(), list);
        singlePicker.setCanceledOnTouchOutside(false);
        singlePicker.setSelectedIndex(0);
        singlePicker.setCycleDisable(true);
        singlePicker.setDividerColor(getResources().getColor(R.color.pick_line));
        singlePicker.setDividerRatio(0.0f);
        singlePicker.setTextPadding(15);
        singlePicker.setLineSpaceMultiplier(3.0f);
        singlePicker.setTopLineColor(getResources().getColor(R.color.pick_line));
        singlePicker.setCancelTextColor(getResources().getColor(R.color.pick_cancle));
        singlePicker.setSubmitTextColor(getResources().getColor(R.color.theme_color));
        singlePicker.setTextColor(getResources().getColor(R.color.pick_black));
        singlePicker.setOnItemPickListener(new SinglePicker.OnItemPickListener<QuestionItem.QuestionsOptions>() { // from class: com.alipay.mobile.verifyidentity.business.security.activity.SetSecurityFragment.4
            @Override // com.alipay.mobile.verifyidentity.business.securitycommon.widget.SinglePicker.OnItemPickListener
            public void onItemPicked(int i, QuestionItem.QuestionsOptions questionsOptions) {
                SetSecurityFragment.this.bottomDialogItemContent = questionsOptions.getValue();
                SetSecurityFragment.this.bottomDialogItemPosition = i;
                SetSecurityFragment setSecurityFragment = SetSecurityFragment.this;
                setSecurityFragment.setListAdapterAfterClickBottomAnswer(setSecurityFragment.bottomDialogItemContent, SetSecurityFragment.this.bottomDialogItemPosition, viewHolder, list);
            }
        });
        singlePicker.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListAdapterAfterClickBottomQuestion(String str, final int i, final ViewHolder viewHolder, final List<QuestionItem> list, final int i2) {
        viewHolder.getView(R.id.rl_edit).setVisibility(0);
        final EditText editText = (EditText) viewHolder.getView(R.id.editText);
        editText.setFilters(new InputFilter[]{this.inputFilter, new InputFilter.LengthFilter(100)});
        ((TextView) viewHolder.getView(R.id.tv_question)).setText(str);
        viewHolder.getView(R.id.iv_red_point).setVisibility(4);
        QuestionItem questionItem = this.questionItemArr[this.mCurrentPosition];
        if (questionItem != null && !TextUtils.isEmpty(questionItem.getContent()) && !this.questionItemArr[this.mCurrentPosition].getContent().equals(str)) {
            editText.setText("");
            addAnswerId(null);
        }
        addQuestionId(list.get(i));
        String answerDisplayType = list.get(i).getAnswerDisplayType();
        if (answerDisplayType.equalsIgnoreCase(SecurityConstants.KEY_DISPLAY_TYPE_DATE)) {
            editText.setFocusable(false);
            editText.setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.security.activity.SetSecurityFragment.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SetSecurityFragment.this.mCurrentPosition = i2;
                    Calendar calendar = Calendar.getInstance();
                    DatePickerDialog datePickerDialog = new DatePickerDialog(SetSecurityFragment.this.getActivity(), 3, new DatePickerDialog.OnDateSetListener() { // from class: com.alipay.mobile.verifyidentity.business.security.activity.SetSecurityFragment.5.1
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public void onDateSet(DatePicker datePicker, int i3, int i4, int i5) {
                            StringBuilder sb = new StringBuilder();
                            int i6 = i4 + 1;
                            sb.append(i6);
                            String obj = sb.toString();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(i5);
                            String obj2 = sb2.toString();
                            if (i6 < 10) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("0");
                                sb3.append(i6);
                                obj = sb3.toString();
                            }
                            if (i5 < 10) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("0");
                                sb4.append(i5);
                                obj2 = sb4.toString();
                            }
                            EditText editText2 = editText;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(obj);
                            sb5.append("/");
                            sb5.append(obj2);
                            sb5.append("/");
                            sb5.append(i3);
                            editText2.setText(sb5.toString());
                            SetSecurityFragment setSecurityFragment = SetSecurityFragment.this;
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(obj);
                            sb6.append("/");
                            sb6.append(obj2);
                            sb6.append("/");
                            sb6.append(i3);
                            setSecurityFragment.addAnswerId(sb6.toString());
                        }
                    }, calendar.get(1), calendar.get(2), calendar.get(5));
                    DatePicker datePicker = datePickerDialog.getDatePicker();
                    try {
                        Calendar calendar2 = Calendar.getInstance();
                        calendar2.set(1, SecExceptionCode.SEC_ERROR_AVMP);
                        calendar2.set(2, 0);
                        calendar2.set(5, 1);
                        datePicker.setMinDate(calendar2.getTimeInMillis());
                        datePicker.setMaxDate(System.currentTimeMillis());
                    } catch (Exception unused) {
                    }
                    datePickerDialog.show();
                }
            });
        } else if (answerDisplayType.equalsIgnoreCase("TEXT") || answerDisplayType.equalsIgnoreCase(SecurityConstants.KEY_DISPLAY_TYPE_NUMBER)) {
            editText.setOnClickListener(null);
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            editText.requestFocus();
            editText.findFocus();
            if (answerDisplayType.equalsIgnoreCase("TEXT")) {
                editText.setInputType(1);
            } else {
                editText.setInputType(2);
                if (answerDisplayType.equalsIgnoreCase(SecurityConstants.KEY_DISPLAY_TYPE_NUMBER)) {
                    editText.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
                }
            }
            editText.addTextChangedListener(new TextWatcher() { // from class: com.alipay.mobile.verifyidentity.business.security.activity.SetSecurityFragment.6
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (editable.toString().startsWith(" ", 0)) {
                        editable.delete(0, 1);
                    }
                    SetSecurityFragment.this.mCurrentPosition = i2;
                    SetSecurityFragment.this.addAnswerId(editable.toString().trim());
                }
            });
        } else if (answerDisplayType.equalsIgnoreCase(SecurityConstants.KEY_DISPLAY_TYPE_PULL_DOWN) || answerDisplayType.equalsIgnoreCase(SecurityConstants.KEY_DISPLAY_TYPE_PINGPU)) {
            editText.setFocusable(false);
            editText.setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.security.activity.SetSecurityFragment.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SetSecurityFragment.this.mCurrentPosition = i2;
                    SetSecurityFragment.this.showAnswerDialog(((QuestionItem) list.get(i)).getQuestionsOptionsList(), viewHolder);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListAdapterAfterClickBottomAnswer(String str, int i, ViewHolder viewHolder, List<QuestionItem.QuestionsOptions> list) {
        addAnswerId(str);
        ((EditText) viewHolder.getView(R.id.editText)).setText(list.get(i).getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAnswerId(String str) {
        this.answerId[this.mCurrentPosition] = str;
        setTvConfirmState();
    }

    private void addQuestionId(QuestionItem questionItem) {
        this.questionItemArr[this.mCurrentPosition] = questionItem;
        setTvConfirmState();
    }

    private void setTvConfirmState() {
        if (isSeleteAll()) {
            this.tv_confirm.setBackgroundResource(R.drawable.confirm_selected);
        } else {
            this.tv_confirm.setBackgroundResource(R.drawable.confirm_unselected);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSeleteAll() {
        int i = 0;
        while (true) {
            String[] strArr = this.answerId;
            if (i >= strArr.length) {
                int i2 = 0;
                while (true) {
                    QuestionItem[] questionItemArr = this.questionItemArr;
                    if (i2 >= questionItemArr.length) {
                        return true;
                    }
                    if (questionItemArr[i2] == null) {
                        return false;
                    }
                    i2++;
                }
            } else if (TextUtils.isEmpty(strArr[i])) {
                return false;
            } else {
                i++;
            }
        }
    }

    public void setCommitCallBack(CommitCallBack commitCallBack) {
        this.mCommitCallBack = commitCallBack;
    }
}

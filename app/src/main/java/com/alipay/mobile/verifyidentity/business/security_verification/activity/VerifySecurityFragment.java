package com.alipay.mobile.verifyidentity.business.security_verification.activity;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
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
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.mobile.security.bio.api.BioError;
import com.alipay.mobile.verifyidentity.base.adapter.ListViewAdapter;
import com.alipay.mobile.verifyidentity.base.adapter.ViewHolder;
import com.alipay.mobile.verifyidentity.base.message.RequestConstants;
import com.alipay.mobile.verifyidentity.business.security_verification.R;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.QuestionItem;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.MultipleDialog;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.SinglePicker;
import com.alipay.mobile.verifyidentity.framework.engine.VIAction;
import com.alipay.mobile.verifyidentity.framework.engine.VIEngine;
import com.alipay.mobile.verifyidentity.framework.engine.VIResult;
import com.alipay.mobile.verifyidentity.uitools.CustomUi;
import com.google.common.base.Ascii;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes7.dex */
public class VerifySecurityFragment extends Fragment {
    public static final byte[] $$a = {11, -83, -14, 91, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 175;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {8, 17, -121, -18, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int getAuthRequestContext = 26;
    private ArrayList<List<QuestionItem>> adapterList;
    private String[] answerId;
    private TextView change_method;
    private int default_seleted_index;
    private String foot_tip;
    private String from_title;
    private boolean has_others;
    InputFilter inputFilter = new InputFilter() { // from class: com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityFragment.1
        Pattern emoji = Pattern.compile("[🀀-🏿]|[🐀-\u1f7ff]|[☀-⟿]", 66);

        {
            VerifySecurityFragment.this = this;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if (this.emoji.matcher(charSequence).find()) {
                return "";
            }
            return null;
        }
    };
    private ListView listView;
    public CommitCallBack mCommitCallBack;
    private int mCurrentPosition;
    private int page_number;
    private int page_size;
    private QuestionItem[] questionItemArr;
    private SecuritySetQuestionAdapter securitySetQuestionAdapter;
    private TextView tv_center;
    private TextView tv_confirm;
    private String verifyId;
    private View viewGroup;

    /* loaded from: classes7.dex */
    public interface CommitCallBack {
        void commit(String[] strArr, QuestionItem[] questionItemArr, int i, int i2);

        void onVerifyResult(VIResult vIResult);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002a -> B:23:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, byte r8, byte r9, java.lang.Object[] r10) {
        /*
            int r7 = 106 - r7
            int r8 = r8 * 3
            int r8 = r8 + 16
            byte[] r0 = com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityFragment.BuiltInFictitiousFunctionClassFactory
            int r9 = r9 * 15
            int r9 = 18 - r9
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L18
            r7 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L34
        L18:
            r3 = 0
        L19:
            int r9 = r9 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r9]
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L34:
            int r9 = r9 + r8
            int r8 = r9 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityFragment.a(int, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0029 -> B:23:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 2
            int r8 = 42 - r8
            int r6 = r6 * 3
            int r6 = 75 - r6
            byte[] r0 = com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityFragment.$$a
            int r7 = r7 + 4
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L32
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r3 = r3 + 1
            int r7 = r7 + 1
            if (r3 != r8) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r4 = r0[r7]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L32:
            int r8 = -r8
            int r6 = r6 + r8
            int r6 = r6 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityFragment.b(short, short, int, java.lang.Object[]):void");
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        try {
            byte b = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-BuiltInFictitiousFunctionClassFactory[5]);
            Object[] objArr2 = new Object[1];
            a(b3, (byte) (b3 - 1), (byte) (-BuiltInFictitiousFunctionClassFactory[5]), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - Process.getGidForName(""), 4 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16));
                    byte b4 = (byte) ($$a[4] - 1);
                    byte b5 = $$a[35];
                    Object[] objArr4 = new Object[1];
                    b(b4, b5, (byte) (b5 + 1), objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 36 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {96781124, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getPressedStateDuration() >> 16), 19 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
            this.viewGroup = layoutInflater.inflate(R.layout.fragment_verify_security, viewGroup, false);
            init();
        }
        return this.viewGroup;
    }

    private void init() {
        this.verifyId = getArguments().getString("verifyId");
        initView();
        initData();
    }

    private void initView() {
        this.listView = (ListView) this.viewGroup.findViewById(R.id.listView);
        this.tv_center = (TextView) this.viewGroup.findViewById(R.id.tv_center);
        TextView textView = (TextView) this.viewGroup.findViewById(R.id.tv_confirm);
        this.tv_confirm = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityFragment.2
            {
                VerifySecurityFragment.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!VerifySecurityFragment.this.isSeleteAll() || VerifySecurityFragment.this.mCommitCallBack == null) {
                    return;
                }
                VerifySecurityFragment.this.mCommitCallBack.commit(VerifySecurityFragment.this.answerId, VerifySecurityFragment.this.questionItemArr, VerifySecurityFragment.this.page_size, VerifySecurityFragment.this.page_number);
            }
        });
        TextView textView2 = (TextView) this.viewGroup.findViewById(R.id.change_method);
        this.change_method = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityFragment.3
            {
                VerifySecurityFragment.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("verifyType", "1");
                hashMap.put("module", RequestConstants.MENU);
                hashMap.put("verifyId", VerifySecurityFragment.this.verifyId);
                VIEngine.verify(VerifySecurityFragment.this.getActivity(), RequestConstants.VerifyProductVerify, 9000, hashMap, null, new VIEngine.VIListener() { // from class: com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityFragment.3.1
                    @Override // com.alipay.mobile.verifyidentity.framework.engine.VIEngine.VIListener
                    public void onVerifyAction(VIAction vIAction) {
                    }

                    @Override // com.alipay.mobile.verifyidentity.framework.engine.VIEngine.VIListener
                    public void onVerifyResult(VIResult vIResult) {
                    }

                    {
                        AnonymousClass3.this = this;
                    }
                }, null);
            }
        });
        setFontStyle();
    }

    private void setFontStyle() {
        if (CustomUi.getBodyTitleTypeface() != null) {
            this.tv_center.setTypeface(CustomUi.getBodyTitleTypeface());
        }
        if (CustomUi.getContentTypeface() != null) {
            this.tv_confirm.setTypeface(CustomUi.getContentTypeface());
            this.change_method.setTypeface(CustomUi.getContentTypeface());
        }
    }

    private void initData() {
        Bundle arguments = getArguments();
        this.page_size = arguments.getInt(SecurityConstants.KEY_PAGE_SIZE);
        this.page_number = arguments.getInt("pageNum");
        this.from_title = arguments.getString("form_title");
        this.foot_tip = arguments.getString("foot_tip");
        this.default_seleted_index = arguments.getInt(SecurityConstants.KEY_DEFAULT_SELETED_INDEX);
        this.has_others = arguments.getBoolean("HAS_OTHERS");
        ArrayList<List<QuestionItem>> arrayList = (ArrayList) arguments.getSerializable(SecurityConstants.KEY_SET_SECURITY_BUNDLE);
        this.adapterList = arrayList;
        this.questionItemArr = new QuestionItem[arrayList.size()];
        this.answerId = new String[this.adapterList.size()];
        SecuritySetQuestionAdapter securitySetQuestionAdapter = new SecuritySetQuestionAdapter(getActivity(), this.adapterList, R.layout.security_verifyquestion_item);
        this.securitySetQuestionAdapter = securitySetQuestionAdapter;
        this.listView.setAdapter((ListAdapter) securitySetQuestionAdapter);
        if (this.page_size != this.page_number) {
            this.tv_confirm.setText(R.string.verify_security_next);
        } else {
            this.tv_confirm.setText(R.string.verify_security_submit);
        }
        if (!TextUtils.isEmpty(this.from_title)) {
            this.tv_center.setText(this.from_title);
        }
        if (TextUtils.isEmpty(this.foot_tip) || !this.has_others) {
            return;
        }
        this.change_method.setText(this.foot_tip);
        this.change_method.setVisibility(0);
    }

    /* loaded from: classes7.dex */
    public class SecuritySetQuestionAdapter extends ListViewAdapter<List<QuestionItem>> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SecuritySetQuestionAdapter(Context context, ArrayList<List<QuestionItem>> arrayList, int i) {
            super(context, arrayList, i);
            VerifySecurityFragment.this = r1;
        }

        @Override // com.alipay.mobile.verifyidentity.base.adapter.ListViewAdapter
        public void convert(final ViewHolder viewHolder, final List<QuestionItem> list, final int i) {
            if (CustomUi.getContentTypeface() != null) {
                ((TextView) viewHolder.getView(R.id.tv_question)).setTypeface(CustomUi.getContentTypeface());
            }
            if (VerifySecurityFragment.this.questionItemArr[i] == null) {
                ((TextView) viewHolder.getView(R.id.tv_question)).setText(VerifySecurityFragment.this.getResources().getString(R.string.security_choose_question));
            }
            viewHolder.getView(R.id.rl_title).setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityFragment.SecuritySetQuestionAdapter.1
                {
                    SecuritySetQuestionAdapter.this = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    VerifySecurityFragment.this.mCurrentPosition = i;
                    VerifySecurityFragment.this.showQuestionDialog(list, viewHolder);
                }
            });
            if (VerifySecurityFragment.this.default_seleted_index == -1 || VerifySecurityFragment.this.default_seleted_index >= list.size() || VerifySecurityFragment.this.default_seleted_index < 0) {
                return;
            }
            VerifySecurityFragment.this.mCurrentPosition = i;
            VerifySecurityFragment verifySecurityFragment = VerifySecurityFragment.this;
            verifySecurityFragment.setListAdapterAfterClickBottomQuestion(list.get(verifySecurityFragment.default_seleted_index).getContent(), VerifySecurityFragment.this.default_seleted_index, viewHolder, list, VerifySecurityFragment.this.mCurrentPosition);
            if (VerifySecurityFragment.this.default_seleted_index == 0 && list.size() == 1) {
                viewHolder.getView(R.id.iv_choose_icon).setVisibility(4);
                viewHolder.getView(R.id.rl_title).setClickable(false);
                return;
            }
            viewHolder.getView(R.id.iv_choose_icon).setVisibility(0);
            viewHolder.getView(R.id.rl_title).setClickable(true);
        }
    }

    public void showQuestionDialog(final List<QuestionItem> list, final ViewHolder viewHolder) {
        int i;
        SinglePicker singlePicker = new SinglePicker(getActivity(), list);
        singlePicker.setCanceledOnTouchOutside(false);
        int i2 = this.default_seleted_index;
        if (i2 != -1 && i2 < list.size() && (i = this.default_seleted_index) >= 0) {
            singlePicker.setSelectedIndex(i);
        } else {
            singlePicker.setSelectedIndex(0);
        }
        singlePicker.setCycleDisable(true);
        singlePicker.setDividerColor(getResources().getColor(R.color.pick_line));
        singlePicker.setDividerRatio(0.0f);
        singlePicker.setTextPadding(15);
        singlePicker.setLineSpaceMultiplier(3.0f);
        singlePicker.setTopLineColor(getResources().getColor(R.color.pick_line));
        singlePicker.setCancelTextColor(getResources().getColor(R.color.pick_cancle));
        singlePicker.setSubmitTextColor(getResources().getColor(R.color.theme_color));
        singlePicker.setTextColor(getResources().getColor(R.color.pick_black));
        singlePicker.setOnItemPickListener(new SinglePicker.OnItemPickListener<QuestionItem>() { // from class: com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityFragment.4
            {
                VerifySecurityFragment.this = this;
            }

            @Override // com.alipay.mobile.verifyidentity.business.securitycommon.widget.SinglePicker.OnItemPickListener
            public void onItemPicked(int i3, QuestionItem questionItem) {
                VerifySecurityFragment.this.setListAdapterAfterClickBottomQuestion(questionItem.getContent(), i3, viewHolder, list, VerifySecurityFragment.this.mCurrentPosition);
            }
        });
        singlePicker.show();
    }

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
        if (!TextUtils.isEmpty(list.get(i).getPlaceHolder())) {
            editText.setHint(list.get(i).getPlaceHolder());
        }
        final String questionType = list.get(i).getQuestionType();
        if (answerDisplayType.equalsIgnoreCase(SecurityConstants.KEY_DISPLAY_TYPE_DATE)) {
            editText.setFocusable(false);
            editText.setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityFragment.5
                {
                    VerifySecurityFragment.this = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    VerifySecurityFragment.this.mCurrentPosition = i2;
                    Calendar.getInstance();
                    DatePickerDialog datePickerDialog = new DatePickerDialog(VerifySecurityFragment.this.getActivity(), 3, new DatePickerDialog.OnDateSetListener() { // from class: com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityFragment.5.1
                        {
                            AnonymousClass5.this = this;
                        }

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
                            VerifySecurityFragment verifySecurityFragment = VerifySecurityFragment.this;
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(obj);
                            sb6.append("/");
                            sb6.append(obj2);
                            sb6.append("/");
                            sb6.append(i3);
                            verifySecurityFragment.addAnswerId(sb6.toString());
                        }
                    }, BioError.RESULT_NOT_SAME_PERSON, 0, 1);
                    DatePicker datePicker = datePickerDialog.getDatePicker();
                    try {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(1, SecExceptionCode.SEC_ERROR_AVMP);
                        calendar.set(2, 0);
                        calendar.set(5, 1);
                        datePicker.setMinDate(calendar.getTimeInMillis());
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
            editText.addTextChangedListener(new TextWatcher() { // from class: com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityFragment.6
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                }

                {
                    VerifySecurityFragment.this = this;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (editable.toString().startsWith(" ", 0)) {
                        editable.delete(0, 1);
                    }
                    VerifySecurityFragment.this.mCurrentPosition = i2;
                    if (editable.toString().trim().length() > 0) {
                        VerifySecurityFragment.this.addAnswerId(editable.toString().trim());
                    }
                }
            });
        } else if (answerDisplayType.equalsIgnoreCase(SecurityConstants.KEY_DISPLAY_TYPE_PULL_DOWN) || answerDisplayType.equalsIgnoreCase(SecurityConstants.KEY_DISPLAY_TYPE_PINGPU)) {
            editText.setFocusable(false);
            editText.setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityFragment.7
                {
                    VerifySecurityFragment.this = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    VerifySecurityFragment.this.mCurrentPosition = i2;
                    if (questionType.equalsIgnoreCase(SecurityConstants.KEY_QUESTION_TYPE_SINGLE_CHOOSE)) {
                        VerifySecurityFragment.this.showAnswerDialog(((QuestionItem) list.get(i)).getQuestionsOptionsList(), viewHolder);
                    } else if (questionType.equalsIgnoreCase(SecurityConstants.KEY_QUESTION_TYPE_MULTIPLE_CHOICE)) {
                        VerifySecurityFragment.this.showMultipleAnswerDialog(((QuestionItem) list.get(i)).getQuestionsOptionsList(), viewHolder);
                    }
                }
            });
        }
    }

    public void showMultipleAnswerDialog(final List<QuestionItem.QuestionsOptions> list, final ViewHolder viewHolder) {
        MultipleDialog multipleDialog = new MultipleDialog(getActivity(), list);
        multipleDialog.setCanceledOnTouchOutside(false);
        multipleDialog.setTopLineColor(getResources().getColor(R.color.pick_line));
        multipleDialog.setCancelTextColor(getResources().getColor(R.color.pick_cancle));
        multipleDialog.setSubmitTextColor(getResources().getColor(R.color.theme_color));
        multipleDialog.setHalfScreen(true);
        multipleDialog.setmClickCallback(new MultipleDialog.ClickCallback() { // from class: com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityFragment.8
            {
                VerifySecurityFragment.this = this;
            }

            @Override // com.alipay.mobile.verifyidentity.business.securitycommon.widget.MultipleDialog.ClickCallback
            public void onConfim(List<QuestionItem.QuestionsOptions> list2) {
                String str = "";
                String str2 = str;
                for (int i = 0; i < list2.size(); i++) {
                    if (list2.get(i).isSelected()) {
                        if (TextUtils.isEmpty(str2)) {
                            str2 = list2.get(i).getText();
                            str = list2.get(i).getValue();
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str2);
                            sb.append(",");
                            sb.append(list2.get(i).getText());
                            String obj = sb.toString();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str);
                            sb2.append(",");
                            sb2.append(list2.get(i).getValue());
                            str = sb2.toString();
                            str2 = obj;
                        }
                    }
                    ((QuestionItem.QuestionsOptions) list.get(i)).setSelected(list2.get(i).isSelected());
                }
                if (TextUtils.isEmpty(str)) {
                    VerifySecurityFragment.this.setListAdapterAfterClickBottomAnswer("", viewHolder, str2);
                    return;
                }
                VerifySecurityFragment verifySecurityFragment = VerifySecurityFragment.this;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("[");
                sb3.append(str);
                sb3.append("]");
                verifySecurityFragment.setListAdapterAfterClickBottomAnswer(sb3.toString(), viewHolder, str2);
            }
        });
        multipleDialog.show();
    }

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
        singlePicker.setOnItemPickListener(new SinglePicker.OnItemPickListener<QuestionItem.QuestionsOptions>() { // from class: com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityFragment.9
            {
                VerifySecurityFragment.this = this;
            }

            @Override // com.alipay.mobile.verifyidentity.business.securitycommon.widget.SinglePicker.OnItemPickListener
            public void onItemPicked(int i, QuestionItem.QuestionsOptions questionsOptions) {
                VerifySecurityFragment.this.setListAdapterAfterClickBottomAnswer(questionsOptions.getValue(), viewHolder, ((QuestionItem.QuestionsOptions) list.get(i)).getText());
            }
        });
        singlePicker.show();
    }

    public void setListAdapterAfterClickBottomAnswer(String str, ViewHolder viewHolder, String str2) {
        addAnswerId(str);
        ((EditText) viewHolder.getView(R.id.editText)).setText(str2);
    }

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
            this.tv_confirm.setBackgroundResource(R.drawable.verify_confirm_selected);
        } else {
            this.tv_confirm.setBackgroundResource(R.drawable.verify_confirm_unselected);
        }
    }

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

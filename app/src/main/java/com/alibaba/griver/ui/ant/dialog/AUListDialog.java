package com.alibaba.griver.ui.ant.dialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.ui.R;
import com.alibaba.griver.ui.ant.badge.AUBadgeView;
import com.alibaba.griver.ui.ant.listview.AUMaxItemCornerListView;
import com.alibaba.griver.ui.ant.model.IconInfo;
import com.alibaba.griver.ui.ant.model.MessagePopItem;
import com.alibaba.griver.ui.ant.model.PopMenuItem;
import com.alibaba.griver.ui.ant.text.AUIconView;
import com.alibaba.griver.ui.ant.text.AUTextView;
import com.google.common.base.Ascii;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes2.dex */
public class AUListDialog extends AUDialog implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    private float f6676a;
    private float b;
    private Boolean c;
    private final Context d;
    private AUMaxItemCornerListView e;
    private TextView f;
    private ScrollView g;
    private AUTextView h;
    private View i;
    private View j;
    private View k;
    private View l;
    private Button m;
    private Button n;

    /* renamed from: o */
    private OnItemClickListener f6677o;
    private AdapterView.OnItemClickListener p;
    private List<MessagePopItem> q;
    private final LayoutInflater r;
    private String s;
    private String t;
    private ListAdapter u;
    private String v;
    private String w;
    private View.OnClickListener x;
    private View.OnClickListener y;
    public static final byte[] $$a = {2, -87, 98, TarHeader.LF_FIFO, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 89;
    public static final byte[] MyBillsEntityDataFactory = {107, 78, -84, 46, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 165;

    @Deprecated
    /* loaded from: classes6.dex */
    public interface OnItemClickListener {
        void onItemClick(int i);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0029 -> B:23:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void A(byte r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.alibaba.griver.ui.ant.dialog.AUListDialog.$$a
            int r7 = r7 * 3
            int r7 = 42 - r7
            int r8 = r8 + 4
            int r6 = r6 * 3
            int r6 = r6 + 75
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L35
        L19:
            r3 = 0
        L1a:
            int r8 = r8 + 1
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r8
            r8 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L35:
            int r8 = r8 + r6
            int r6 = r8 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.ant.dialog.AUListDialog.A(byte, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0024 -> B:23:0x0028). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void z(int r5, short r6, byte r7, java.lang.Object[] r8) {
        /*
            int r7 = 106 - r7
            byte[] r0 = com.alibaba.griver.ui.ant.dialog.AUListDialog.MyBillsEntityDataFactory
            int r6 = r6 * 15
            int r6 = r6 + 4
            int r5 = r5 * 2
            int r5 = 16 - r5
            byte[] r1 = new byte[r5]
            int r5 = r5 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r4 = r6
            r3 = 0
            goto L28
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r5) goto L24
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L24:
            int r3 = r3 + 1
            r4 = r0[r6]
        L28:
            int r6 = r6 + 1
            int r7 = r7 + r4
            int r7 = r7 + 2
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.ant.dialog.AUListDialog.z(int, short, byte, java.lang.Object[]):void");
    }

    public AUListDialog(Context context, ArrayList<String> arrayList) {
        super(context, R.style.griver_noTitleTransBgDialogStyle);
        this.c = null;
        this.q = new ArrayList();
        this.s = "";
        this.t = "";
        this.d = context;
        this.r = LayoutInflater.from(context);
        if (arrayList != null) {
            this.q.clear();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                this.q.add(new MessagePopItem(it.next()));
            }
        }
    }

    public AUListDialog(Context context, List<MessagePopItem> list) {
        this(context, "", "", list);
    }

    public AUListDialog(Context context, String str, String str2, List<MessagePopItem> list) {
        this(context, str, str2, list, "", (View.OnClickListener) null, "", (View.OnClickListener) null);
    }

    public AUListDialog(Context context, String str, String str2, List<MessagePopItem> list, String str3, View.OnClickListener onClickListener, String str4, View.OnClickListener onClickListener2) {
        super(context, R.style.griver_noTitleTransBgDialogStyle);
        this.c = null;
        this.q = new ArrayList();
        this.s = str;
        this.t = str2;
        this.d = context;
        this.r = LayoutInflater.from(context);
        this.v = str3;
        this.x = onClickListener;
        this.w = str4;
        this.y = onClickListener2;
        if (list == null || list.size() == 0) {
            return;
        }
        this.q.clear();
        this.q.addAll(list);
    }

    @Deprecated
    public AUListDialog(ArrayList<PopMenuItem> arrayList, Context context) {
        this(null, arrayList, context);
    }

    @Deprecated
    public AUListDialog(String str, ArrayList<PopMenuItem> arrayList, Context context) {
        this(str, (String) null, arrayList, context);
    }

    @Deprecated
    public AUListDialog(String str, String str2, ArrayList<PopMenuItem> arrayList, Context context) {
        this(str, str2, arrayList, false, null, null, null, null, context);
    }

    @Deprecated
    public AUListDialog(String str, ArrayList<PopMenuItem> arrayList, boolean z, String str2, View.OnClickListener onClickListener, String str3, View.OnClickListener onClickListener2, Context context) {
        this(str, null, arrayList, z, str2, onClickListener, str3, onClickListener2, context);
    }

    @Deprecated
    public AUListDialog(String str, String str2, ArrayList<PopMenuItem> arrayList, boolean z, String str3, View.OnClickListener onClickListener, String str4, View.OnClickListener onClickListener2, Context context) {
        super(context, R.style.griver_noTitleTransBgDialogStyle);
        this.c = null;
        this.q = new ArrayList();
        this.s = str;
        this.t = str2;
        this.d = context;
        this.r = LayoutInflater.from(context);
        this.v = str3;
        this.x = onClickListener;
        this.w = str4;
        this.y = onClickListener2;
        this.q = a(arrayList);
    }

    private List<MessagePopItem> a(List<PopMenuItem> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (PopMenuItem popMenuItem : list) {
                if (popMenuItem != null) {
                    MessagePopItem messagePopItem = new MessagePopItem();
                    messagePopItem.title = (String) popMenuItem.getName();
                    if (popMenuItem.getResId() != 0) {
                        messagePopItem.icon = new IconInfo(popMenuItem.getResId());
                    } else {
                        messagePopItem.icon = new IconInfo(popMenuItem.getDrawable());
                    }
                    messagePopItem.externParam = popMenuItem.getExternParam();
                    arrayList.add(messagePopItem);
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    @Deprecated
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f6677o = onItemClickListener;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.p = onItemClickListener;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        try {
            byte b = (byte) (MyBillsEntityDataFactory[5] + 1);
            byte b2 = (byte) (-MyBillsEntityDataFactory[5]);
            Object[] objArr = new Object[1];
            z(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (MyBillsEntityDataFactory[5] + 1);
            Object[] objArr2 = new Object[1];
            z(b3, b3, (byte) (-MyBillsEntityDataFactory[5]), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getScrollBarSize() >> 8), 4 - TextUtils.getOffsetBefore("", 0), (char) Color.blue(0));
                    byte b4 = (byte) ($$a[35] - 1);
                    Object[] objArr4 = new Object[1];
                    A(b4, b4, $$a[4], objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 930, TextUtils.lastIndexOf("", '0', 0, 0) + 36, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {90107508, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + 911, TextUtils.lastIndexOf("", '0', 0, 0) + 19, (char) View.resolveSize(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                View inflate = this.r.inflate(R.layout.griver_ui_list_dialog, (ViewGroup) null);
                AUMaxItemCornerListView aUMaxItemCornerListView = (AUMaxItemCornerListView) inflate.findViewById(R.id.dialog_listView);
                this.e = aUMaxItemCornerListView;
                float f = this.b;
                if (f > 0.0f) {
                    aUMaxItemCornerListView.setSingleItemHeight(f);
                }
                float f2 = this.f6676a;
                if (f2 > 0.0f) {
                    this.e.setMaxItems(f2);
                }
                Boolean bool = this.c;
                if (bool != null) {
                    this.e.setScrollbarFadingEnabled(bool.booleanValue());
                }
                this.e.setDivider(new ColorDrawable(this.d.getResources().getColor(R.color.griver_AU_COLOR_DIALOG_DIVIDER_COLOR)));
                this.e.setDividerHeight(this.d.getResources().getDimensionPixelSize(R.dimen.griver_AU_DIVIDER_SPACE1));
                this.e.setHeaderDividersEnabled(false);
                this.e.setFooterDividersEnabled(false);
                this.e.setBackgroundResource(R.drawable.griver_ui_dialog_bg);
                View findViewById = inflate.findViewById(R.id.title_container);
                this.i = findViewById;
                this.f = (TextView) findViewById.findViewById(R.id.title);
                this.g = (ScrollView) this.i.findViewById(R.id.message_content);
                AUTextView aUTextView = (AUTextView) this.i.findViewById(R.id.message);
                this.h = aUTextView;
                aUTextView.setMinLines(0);
                this.l = inflate.findViewById(R.id.head_divider);
                View findViewById2 = inflate.findViewById(R.id.bottom_container);
                this.j = findViewById2;
                this.n = (Button) findViewById2.findViewById(R.id.ensure);
                this.m = (Button) this.j.findViewById(R.id.cancel);
                this.k = inflate.findViewById(R.id.bottom_divider);
                setContentView(inflate);
                a();
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

    private void a() {
        ListAdapter listAdapter = new ListAdapter();
        this.u = listAdapter;
        this.e.setAdapter((android.widget.ListAdapter) listAdapter);
        this.e.setOnItemClickListener(this);
        if (TextUtils.isEmpty(this.w) && TextUtils.isEmpty(this.v)) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
            this.k.setVisibility(0);
            this.e.updateFootState(true);
        }
        if (!TextUtils.isEmpty(this.w)) {
            this.m.setText(this.w);
            this.m.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.ant.dialog.AUListDialog.1
                {
                    AUListDialog.this = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AUListDialog.this.cancel();
                    if (AUListDialog.this.y != null) {
                        AUListDialog.this.y.onClick(AUListDialog.this.m);
                    }
                }
            });
        } else {
            this.m.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.v)) {
            this.n.setText(this.v);
            this.n.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.ant.dialog.AUListDialog.2
                {
                    AUListDialog.this = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AUListDialog.this.dismiss();
                    if (AUListDialog.this.x != null) {
                        AUListDialog.this.x.onClick(AUListDialog.this.n);
                    }
                }
            });
        } else {
            this.n.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.t) && TextUtils.isEmpty(this.s)) {
            this.i.setVisibility(8);
        } else {
            this.i.setVisibility(0);
            this.l.setVisibility(0);
            this.e.updateHeadState(true);
        }
        if (!TextUtils.isEmpty(this.s)) {
            this.f.setText(this.s);
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
            ((LinearLayout.LayoutParams) this.g.getLayoutParams()).topMargin = 0;
        }
        if (!TextUtils.isEmpty(this.t)) {
            this.h.setText(this.t);
            this.h.setVisibility(0);
            return;
        }
        this.h.setVisibility(8);
    }

    @Override // com.alibaba.griver.ui.ant.dialog.AUBasicDialog, android.app.Dialog
    public void show() {
        super.show();
        if (isShowing()) {
            setWindowMaxWidth(this.d.getResources().getDimensionPixelSize(R.dimen.griver_AU_SPACE10));
        }
    }

    @Deprecated
    public void updateData(ArrayList<PopMenuItem> arrayList) {
        if (this.u != null) {
            this.q.clear();
            this.q.addAll(a(arrayList));
            this.u.notifyDataSetChanged();
        }
    }

    /* loaded from: classes6.dex */
    public final class ListAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public final long getItemId(int i) {
            return i;
        }

        private ListAdapter() {
            AUListDialog.this = r1;
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            return AUListDialog.this.q.size();
        }

        @Override // android.widget.Adapter
        public final MessagePopItem getItem(int i) {
            return (MessagePopItem) AUListDialog.this.q.get(i);
        }

        @Override // android.widget.Adapter
        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                AUListDialog aUListDialog = AUListDialog.this;
                view = new ListDialogItem(aUListDialog.getContext());
            }
            ((ListDialogItem) view).setPopItem(getItem(i));
            return view;
        }
    }

    /* loaded from: classes6.dex */
    class ListDialogItem extends BaseMessagePopItemView {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ListDialogItem(Context context) {
            super(context);
            AUListDialog.this = r1;
        }

        @Override // com.alibaba.griver.ui.ant.dialog.BaseMessagePopItemView
        protected void initView(Context context) {
            AUListDialog.this.r.inflate(R.layout.griver_ui_list_item_dialog, (ViewGroup) this, true);
            this.mIconView = (AUIconView) findViewById(R.id.item_icon);
            this.mTitleView = (AUTextView) findViewById(R.id.item_name);
            this.mBadgeView = (AUBadgeView) findViewById(R.id.item_badge);
            setMinimumHeight(getResources().getDimensionPixelSize(R.dimen.griver_AU_SPACE12));
            setGravity(19);
            setMakeTitleMax(true);
        }

        @Override // com.alibaba.griver.ui.ant.dialog.BaseMessagePopItemView
        protected int getHorizonPadding(Context context) {
            return getResources().getDimensionPixelOffset(R.dimen.griver_AU_SPACE6);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        OnItemClickListener onItemClickListener = this.f6677o;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(i);
        }
        AdapterView.OnItemClickListener onItemClickListener2 = this.p;
        if (onItemClickListener2 != null) {
            onItemClickListener2.onItemClick(adapterView, view, i, j);
        }
        dismiss();
    }
}

package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes3.dex */
public class AlertDialog extends AppCompatDialog implements DialogInterface {
    public final AlertController BuiltInFictitiousFunctionClassFactory;

    protected AlertDialog(Context context, int i) {
        super(context, PlaceComponentResult(context, i));
        this.BuiltInFictitiousFunctionClassFactory = new AlertController(getContext(), this, getWindow());
    }

    static int PlaceComponentResult(Context context, int i) {
        if (((i >>> 24) & 255) > 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.PrepareContext, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        AlertController alertController = this.BuiltInFictitiousFunctionClassFactory;
        alertController.E = charSequence;
        TextView textView = alertController.VerifyPinStateManager$executeRiskChallenge$2$2;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.app.AppCompatDialog, androidx.view.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        boolean z;
        View findViewById;
        ListAdapter listAdapter;
        View findViewById2;
        super.onCreate(bundle);
        final AlertController alertController = this.BuiltInFictitiousFunctionClassFactory;
        int i = alertController.GetContactSyncConfig;
        if (i == 0 || alertController.NetworkUserEntityData$$ExternalSyntheticLambda1 != 1) {
            i = alertController.getAuthRequestContext;
        }
        alertController.NetworkUserEntityData$$ExternalSyntheticLambda3.setContentView(i);
        View findViewById3 = alertController.AppCompatEmojiTextHelper.findViewById(R.id.SubSequence);
        View findViewById4 = findViewById3.findViewById(R.id.getNameOrBuilderList);
        View findViewById5 = findViewById3.findViewById(R.id.NetworkUserEntityData$$ExternalSyntheticLambda1);
        View findViewById6 = findViewById3.findViewById(R.id.GetContactSyncConfig);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(R.id.NetworkUserEntityData$$ExternalSyntheticLambda7);
        View view = alertController.D;
        final View view2 = null;
        if (view == null) {
            view = alertController.getOnBoardingScenario != 0 ? LayoutInflater.from(alertController.NetworkUserEntityData$$ExternalSyntheticLambda7).inflate(alertController.getOnBoardingScenario, viewGroup, false) : null;
        }
        boolean z2 = view != null;
        if (!z2 || !AlertController.BuiltInFictitiousFunctionClassFactory(view)) {
            alertController.AppCompatEmojiTextHelper.setFlags(AntDetector.SCENE_ID_LOGIN_REGIST, AntDetector.SCENE_ID_LOGIN_REGIST);
        }
        if (z2) {
            FrameLayout frameLayout = (FrameLayout) alertController.AppCompatEmojiTextHelper.findViewById(R.id.initRecordTimeStamp);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (alertController.F) {
                frameLayout.setPadding(alertController.H, alertController.I, alertController.G, alertController.getValueOfTouchPositionAbsolute);
            }
            if (alertController.readMicros != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById7 = viewGroup.findViewById(R.id.getNameOrBuilderList);
        View findViewById8 = viewGroup.findViewById(R.id.NetworkUserEntityData$$ExternalSyntheticLambda1);
        View findViewById9 = viewGroup.findViewById(R.id.GetContactSyncConfig);
        ViewGroup PlaceComponentResult = AlertController.PlaceComponentResult(findViewById7, findViewById4);
        ViewGroup PlaceComponentResult2 = AlertController.PlaceComponentResult(findViewById8, findViewById5);
        ViewGroup PlaceComponentResult3 = AlertController.PlaceComponentResult(findViewById9, findViewById6);
        NestedScrollView nestedScrollView = (NestedScrollView) alertController.AppCompatEmojiTextHelper.findViewById(R.id.readMicros);
        alertController.BottomSheetCardBindingView$watcherCardNumberView$1 = nestedScrollView;
        nestedScrollView.setFocusable(false);
        alertController.BottomSheetCardBindingView$watcherCardNumberView$1.setNestedScrollingEnabled(false);
        TextView textView = (TextView) PlaceComponentResult2.findViewById(16908299);
        alertController.B = textView;
        if (textView != null) {
            CharSequence charSequence = alertController.getSupportButtonTintMode;
            if (charSequence != null) {
                textView.setText(charSequence);
            } else {
                textView.setVisibility(8);
                alertController.BottomSheetCardBindingView$watcherCardNumberView$1.removeView(alertController.B);
                if (alertController.readMicros != null) {
                    ViewGroup viewGroup2 = (ViewGroup) alertController.BottomSheetCardBindingView$watcherCardNumberView$1.getParent();
                    int indexOfChild = viewGroup2.indexOfChild(alertController.BottomSheetCardBindingView$watcherCardNumberView$1);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(alertController.readMicros, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    PlaceComponentResult2.setVisibility(8);
                }
            }
        }
        Button button = (Button) PlaceComponentResult3.findViewById(16908313);
        alertController.NetworkUserEntityData$$ExternalSyntheticLambda2 = button;
        button.setOnClickListener(alertController.BuiltInFictitiousFunctionClassFactory);
        if (TextUtils.isEmpty(alertController.newProxyInstance) && alertController.PrepareContext == null) {
            alertController.NetworkUserEntityData$$ExternalSyntheticLambda2.setVisibility(8);
            z = false;
        } else {
            alertController.NetworkUserEntityData$$ExternalSyntheticLambda2.setText(alertController.newProxyInstance);
            Drawable drawable = alertController.PrepareContext;
            if (drawable != null) {
                int i2 = alertController.PlaceComponentResult;
                drawable.setBounds(0, 0, i2, i2);
                alertController.NetworkUserEntityData$$ExternalSyntheticLambda2.setCompoundDrawables(alertController.PrepareContext, null, null, null);
            }
            alertController.NetworkUserEntityData$$ExternalSyntheticLambda2.setVisibility(0);
            z = true;
        }
        Button button2 = (Button) PlaceComponentResult3.findViewById(16908314);
        alertController.MyBillsEntityDataFactory = button2;
        button2.setOnClickListener(alertController.BuiltInFictitiousFunctionClassFactory);
        if (TextUtils.isEmpty(alertController.scheduleImpl) && alertController.lookAheadTest == null) {
            alertController.MyBillsEntityDataFactory.setVisibility(8);
        } else {
            alertController.MyBillsEntityDataFactory.setText(alertController.scheduleImpl);
            Drawable drawable2 = alertController.lookAheadTest;
            if (drawable2 != null) {
                int i3 = alertController.PlaceComponentResult;
                drawable2.setBounds(0, 0, i3, i3);
                alertController.MyBillsEntityDataFactory.setCompoundDrawables(alertController.lookAheadTest, null, null, null);
            }
            alertController.MyBillsEntityDataFactory.setVisibility(0);
            z |= true;
        }
        Button button3 = (Button) PlaceComponentResult3.findViewById(16908315);
        alertController.NetworkUserEntityData$$ExternalSyntheticLambda0 = button3;
        button3.setOnClickListener(alertController.BuiltInFictitiousFunctionClassFactory);
        if (TextUtils.isEmpty(alertController.DatabaseTableConfigUtil) && alertController.moveToNextValue == null) {
            alertController.NetworkUserEntityData$$ExternalSyntheticLambda0.setVisibility(8);
        } else {
            alertController.NetworkUserEntityData$$ExternalSyntheticLambda0.setText(alertController.DatabaseTableConfigUtil);
            Drawable drawable3 = alertController.moveToNextValue;
            if (drawable3 != null) {
                int i4 = alertController.PlaceComponentResult;
                drawable3.setBounds(0, 0, i4, i4);
                alertController.NetworkUserEntityData$$ExternalSyntheticLambda0.setCompoundDrawables(alertController.moveToNextValue, null, null, null);
            }
            alertController.NetworkUserEntityData$$ExternalSyntheticLambda0.setVisibility(0);
            z |= true;
        }
        if (AlertController.BuiltInFictitiousFunctionClassFactory(alertController.NetworkUserEntityData$$ExternalSyntheticLambda7)) {
            if (z) {
                AlertController.BuiltInFictitiousFunctionClassFactory(alertController.NetworkUserEntityData$$ExternalSyntheticLambda2);
            } else if (z) {
                AlertController.BuiltInFictitiousFunctionClassFactory(alertController.MyBillsEntityDataFactory);
            } else if (z) {
                AlertController.BuiltInFictitiousFunctionClassFactory(alertController.NetworkUserEntityData$$ExternalSyntheticLambda0);
            }
        }
        if (!(z)) {
            PlaceComponentResult3.setVisibility(8);
        }
        if (alertController.NetworkUserEntityData$$ExternalSyntheticLambda6 != null) {
            PlaceComponentResult.addView(alertController.NetworkUserEntityData$$ExternalSyntheticLambda6, 0, new ViewGroup.LayoutParams(-1, -2));
            alertController.AppCompatEmojiTextHelper.findViewById(R.id.K).setVisibility(8);
        } else {
            alertController.whenAvailable = (ImageView) alertController.AppCompatEmojiTextHelper.findViewById(16908294);
            if ((!TextUtils.isEmpty(alertController.E)) != false && alertController.VerifyPinStateManager$executeRiskChallenge$2$1) {
                TextView textView2 = (TextView) alertController.AppCompatEmojiTextHelper.findViewById(R.id.DatabaseTableConfigUtil);
                alertController.VerifyPinStateManager$executeRiskChallenge$2$2 = textView2;
                textView2.setText(alertController.E);
                int i5 = alertController.NetworkUserEntityData$$ExternalSyntheticLambda4;
                if (i5 != 0) {
                    InstrumentInjector.Resources_setImageResource(alertController.whenAvailable, i5);
                } else {
                    Drawable drawable4 = alertController.FragmentBottomSheetPaymentSettingBinding;
                    if (drawable4 != null) {
                        alertController.whenAvailable.setImageDrawable(drawable4);
                    } else {
                        alertController.VerifyPinStateManager$executeRiskChallenge$2$2.setPadding(alertController.whenAvailable.getPaddingLeft(), alertController.whenAvailable.getPaddingTop(), alertController.whenAvailable.getPaddingRight(), alertController.whenAvailable.getPaddingBottom());
                        alertController.whenAvailable.setVisibility(8);
                    }
                }
            } else {
                alertController.AppCompatEmojiTextHelper.findViewById(R.id.K).setVisibility(8);
                alertController.whenAvailable.setVisibility(8);
                PlaceComponentResult.setVisibility(8);
            }
        }
        boolean z3 = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z4 = (PlaceComponentResult == null || PlaceComponentResult.getVisibility() == 8) ? 0 : 1;
        boolean z5 = (PlaceComponentResult3 == null || PlaceComponentResult3.getVisibility() == 8) ? false : true;
        if (!z5 && PlaceComponentResult2 != null && (findViewById2 = PlaceComponentResult2.findViewById(R.id.H)) != null) {
            findViewById2.setVisibility(0);
        }
        if (z4) {
            NestedScrollView nestedScrollView2 = alertController.BottomSheetCardBindingView$watcherCardNumberView$1;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            View findViewById10 = (alertController.getSupportButtonTintMode == null && alertController.readMicros == null) ? null : PlaceComponentResult.findViewById(R.id.J);
            if (findViewById10 != null) {
                findViewById10.setVisibility(0);
            }
        } else if (PlaceComponentResult2 != null && (findViewById = PlaceComponentResult2.findViewById(R.id.I)) != null) {
            findViewById.setVisibility(0);
        }
        ListView listView = alertController.readMicros;
        if (listView instanceof AlertController.RecycleListView) {
            ((AlertController.RecycleListView) listView).setHasDecor(z4, z5);
        }
        if (!z3) {
            View view3 = alertController.readMicros;
            if (view3 == null) {
                view3 = alertController.BottomSheetCardBindingView$watcherCardNumberView$1;
            }
            if (view3 != null) {
                int i6 = z4 | (z5 ? 2 : 0);
                final View findViewById11 = alertController.AppCompatEmojiTextHelper.findViewById(R.id.getSupportButtonTintMode);
                View findViewById12 = alertController.AppCompatEmojiTextHelper.findViewById(R.id.whenAvailable);
                if (Build.VERSION.SDK_INT >= 23) {
                    ViewCompat.MyBillsEntityDataFactory(view3, i6, 3);
                    if (findViewById11 != null) {
                        PlaceComponentResult2.removeView(findViewById11);
                    }
                    if (findViewById12 != null) {
                        PlaceComponentResult2.removeView(findViewById12);
                    }
                } else {
                    if (findViewById11 != null && (i6 & 1) == 0) {
                        PlaceComponentResult2.removeView(findViewById11);
                        findViewById11 = null;
                    }
                    if (findViewById12 == null || (i6 & 2) != 0) {
                        view2 = findViewById12;
                    } else {
                        PlaceComponentResult2.removeView(findViewById12);
                    }
                    if (findViewById11 != null || view2 != null) {
                        if (alertController.getSupportButtonTintMode != null) {
                            alertController.BottomSheetCardBindingView$watcherCardNumberView$1.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: androidx.appcompat.app.AlertController.2
                                @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                                public final void getAuthRequestContext(NestedScrollView nestedScrollView3, int i7, int i8, int i9, int i10) {
                                    AlertController.PlaceComponentResult(nestedScrollView3, findViewById11, view2);
                                }
                            });
                            alertController.BottomSheetCardBindingView$watcherCardNumberView$1.post(new Runnable() { // from class: androidx.appcompat.app.AlertController.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    AlertController.PlaceComponentResult(alertController.BottomSheetCardBindingView$watcherCardNumberView$1, findViewById11, view2);
                                }
                            });
                        } else {
                            ListView listView2 = alertController.readMicros;
                            if (listView2 != null) {
                                listView2.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: androidx.appcompat.app.AlertController.4
                                    @Override // android.widget.AbsListView.OnScrollListener
                                    public void onScrollStateChanged(AbsListView absListView, int i7) {
                                    }

                                    @Override // android.widget.AbsListView.OnScrollListener
                                    public void onScroll(AbsListView absListView, int i7, int i8, int i9) {
                                        AlertController.PlaceComponentResult(absListView, findViewById11, view2);
                                    }
                                });
                                alertController.readMicros.post(new Runnable() { // from class: androidx.appcompat.app.AlertController.5
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AlertController.PlaceComponentResult(alertController.readMicros, findViewById11, view2);
                                    }
                                });
                            } else {
                                if (findViewById11 != null) {
                                    PlaceComponentResult2.removeView(findViewById11);
                                }
                                if (view2 != null) {
                                    PlaceComponentResult2.removeView(view2);
                                }
                            }
                        }
                    }
                }
            }
        }
        ListView listView3 = alertController.readMicros;
        if (listView3 == null || (listAdapter = alertController.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            return;
        }
        listView3.setAdapter(listAdapter);
        int i7 = alertController.isLayoutRequested;
        if (i7 >= 0) {
            listView3.setItemChecked(i7, true);
            listView3.setSelection(i7);
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private final AlertController.AlertParams P;
        private final int mTheme;

        public Builder(Context context) {
            this(context, AlertDialog.PlaceComponentResult(context, 0));
        }

        public Builder(Context context, int i) {
            this.P = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.PlaceComponentResult(context, i)));
            this.mTheme = i;
        }

        public Context getContext() {
            return this.P.MyBillsEntityDataFactory;
        }

        public Builder setTitle(int i) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.getValueOfTouchPositionAbsolute = alertParams.MyBillsEntityDataFactory.getText(i);
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.P.getValueOfTouchPositionAbsolute = charSequence;
            return this;
        }

        public Builder setCustomTitle(View view) {
            this.P.lookAheadTest = view;
            return this;
        }

        public Builder setMessage(int i) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.PrepareContext = alertParams.MyBillsEntityDataFactory.getText(i);
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.P.PrepareContext = charSequence;
            return this;
        }

        public Builder setIcon(int i) {
            this.P.DatabaseTableConfigUtil = i;
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.P.NetworkUserEntityData$$ExternalSyntheticLambda0 = drawable;
            return this;
        }

        public Builder setIconAttribute(int i) {
            TypedValue typedValue = new TypedValue();
            this.P.MyBillsEntityDataFactory.getTheme().resolveAttribute(i, typedValue, true);
            this.P.DatabaseTableConfigUtil = typedValue.resourceId;
            return this;
        }

        public Builder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.B = alertParams.MyBillsEntityDataFactory.getText(i);
            this.P.VerifyPinStateManager$executeRiskChallenge$2$1 = onClickListener;
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.P.B = charSequence;
            this.P.VerifyPinStateManager$executeRiskChallenge$2$1 = onClickListener;
            return this;
        }

        public Builder setPositiveButtonIcon(Drawable drawable) {
            this.P.A = drawable;
            return this;
        }

        public Builder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.NetworkUserEntityData$$ExternalSyntheticLambda6 = alertParams.MyBillsEntityDataFactory.getText(i);
            this.P.NetworkUserEntityData$$ExternalSyntheticLambda8 = onClickListener;
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.P.NetworkUserEntityData$$ExternalSyntheticLambda6 = charSequence;
            this.P.NetworkUserEntityData$$ExternalSyntheticLambda8 = onClickListener;
            return this;
        }

        public Builder setNegativeButtonIcon(Drawable drawable) {
            this.P.newProxyInstance = drawable;
            return this;
        }

        public Builder setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.NetworkUserEntityData$$ExternalSyntheticLambda5 = alertParams.MyBillsEntityDataFactory.getText(i);
            this.P.NetworkUserEntityData$$ExternalSyntheticLambda3 = onClickListener;
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.P.NetworkUserEntityData$$ExternalSyntheticLambda5 = charSequence;
            this.P.NetworkUserEntityData$$ExternalSyntheticLambda3 = onClickListener;
            return this;
        }

        public Builder setNeutralButtonIcon(Drawable drawable) {
            this.P.NetworkUserEntityData$$ExternalSyntheticLambda4 = drawable;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.P.BuiltInFictitiousFunctionClassFactory = z;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.P.FragmentBottomSheetPaymentSettingBinding = onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.P.getSupportButtonTintMode = onDismissListener;
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.P.whenAvailable = onKeyListener;
            return this;
        }

        public Builder setItems(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.isLayoutRequested = alertParams.MyBillsEntityDataFactory.getResources().getTextArray(i);
            this.P.readMicros = onClickListener;
            return this;
        }

        public Builder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            this.P.isLayoutRequested = charSequenceArr;
            this.P.readMicros = onClickListener;
            return this;
        }

        public Builder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            this.P.getAuthRequestContext = listAdapter;
            this.P.readMicros = onClickListener;
            return this;
        }

        public Builder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            this.P.moveToNextValue = cursor;
            this.P.NetworkUserEntityData$$ExternalSyntheticLambda7 = str;
            this.P.readMicros = onClickListener;
            return this;
        }

        public Builder setMultiChoiceItems(int i, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.isLayoutRequested = alertParams.MyBillsEntityDataFactory.getResources().getTextArray(i);
            this.P.getCallingPid = onMultiChoiceClickListener;
            this.P.PlaceComponentResult = zArr;
            this.P.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.P.isLayoutRequested = charSequenceArr;
            this.P.getCallingPid = onMultiChoiceClickListener;
            this.P.PlaceComponentResult = zArr;
            this.P.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
            return this;
        }

        public Builder setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.P.moveToNextValue = cursor;
            this.P.getCallingPid = onMultiChoiceClickListener;
            this.P.GetContactSyncConfig = str;
            this.P.NetworkUserEntityData$$ExternalSyntheticLambda7 = str2;
            this.P.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
            return this;
        }

        public Builder setSingleChoiceItems(int i, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.isLayoutRequested = alertParams.MyBillsEntityDataFactory.getResources().getTextArray(i);
            this.P.readMicros = onClickListener;
            this.P.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
            this.P.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
            return this;
        }

        public Builder setSingleChoiceItems(Cursor cursor, int i, String str, DialogInterface.OnClickListener onClickListener) {
            this.P.moveToNextValue = cursor;
            this.P.readMicros = onClickListener;
            this.P.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.P.NetworkUserEntityData$$ExternalSyntheticLambda7 = str;
            this.P.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            this.P.isLayoutRequested = charSequenceArr;
            this.P.readMicros = onClickListener;
            this.P.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.P.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            this.P.getAuthRequestContext = listAdapter;
            this.P.readMicros = onClickListener;
            this.P.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.P.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
            return this;
        }

        public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.P.SubSequence = onItemSelectedListener;
            return this;
        }

        public Builder setView(int i) {
            this.P.VerifyPinStateManager$executeRiskChallenge$2$2 = null;
            this.P.E = i;
            this.P.F = false;
            return this;
        }

        public Builder setView(View view) {
            this.P.VerifyPinStateManager$executeRiskChallenge$2$2 = view;
            this.P.E = 0;
            this.P.F = false;
            return this;
        }

        @Deprecated
        public Builder setView(View view, int i, int i2, int i3, int i4) {
            this.P.VerifyPinStateManager$executeRiskChallenge$2$2 = view;
            this.P.E = 0;
            this.P.F = true;
            this.P.D = i;
            this.P.AppCompatEmojiTextHelper = i2;
            this.P.G = i3;
            this.P.getOnBoardingScenario = i4;
            return this;
        }

        @Deprecated
        public Builder setInverseBackgroundForced(boolean z) {
            this.P.scheduleImpl = z;
            return this;
        }

        public Builder setRecycleOnMeasureEnabled(boolean z) {
            this.P.BottomSheetCardBindingView$watcherCardNumberView$1 = z;
            return this;
        }

        public AlertDialog create() {
            int i;
            ListAdapter listAdapter;
            AlertDialog alertDialog = new AlertDialog(this.P.MyBillsEntityDataFactory, this.mTheme);
            final AlertController.AlertParams alertParams = this.P;
            final AlertController alertController = alertDialog.BuiltInFictitiousFunctionClassFactory;
            View view = alertParams.lookAheadTest;
            if (view == null) {
                CharSequence charSequence = alertParams.getValueOfTouchPositionAbsolute;
                if (charSequence != null) {
                    alertController.E = charSequence;
                    TextView textView = alertController.VerifyPinStateManager$executeRiskChallenge$2$2;
                    if (textView != null) {
                        textView.setText(charSequence);
                    }
                }
                Drawable drawable = alertParams.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (drawable != null) {
                    alertController.FragmentBottomSheetPaymentSettingBinding = drawable;
                    alertController.NetworkUserEntityData$$ExternalSyntheticLambda4 = 0;
                    ImageView imageView = alertController.whenAvailable;
                    if (imageView != null) {
                        if (drawable != null) {
                            imageView.setVisibility(0);
                            alertController.whenAvailable.setImageDrawable(drawable);
                        } else {
                            imageView.setVisibility(8);
                        }
                    }
                }
                int i2 = alertParams.DatabaseTableConfigUtil;
                if (i2 != 0) {
                    alertController.MyBillsEntityDataFactory(i2);
                }
                int i3 = alertParams.getErrorConfigVersion;
                if (i3 != 0) {
                    TypedValue typedValue = new TypedValue();
                    alertController.NetworkUserEntityData$$ExternalSyntheticLambda7.getTheme().resolveAttribute(i3, typedValue, true);
                    alertController.MyBillsEntityDataFactory(typedValue.resourceId);
                }
            } else {
                alertController.NetworkUserEntityData$$ExternalSyntheticLambda6 = view;
            }
            CharSequence charSequence2 = alertParams.PrepareContext;
            if (charSequence2 != null) {
                alertController.getSupportButtonTintMode = charSequence2;
                TextView textView2 = alertController.B;
                if (textView2 != null) {
                    textView2.setText(charSequence2);
                }
            }
            CharSequence charSequence3 = alertParams.B;
            if (charSequence3 != null || alertParams.A != null) {
                alertController.KClassImpl$Data$declaredNonStaticMembers$2(-1, charSequence3, alertParams.VerifyPinStateManager$executeRiskChallenge$2$1, alertParams.A);
            }
            CharSequence charSequence4 = alertParams.NetworkUserEntityData$$ExternalSyntheticLambda6;
            if (charSequence4 != null || alertParams.newProxyInstance != null) {
                alertController.KClassImpl$Data$declaredNonStaticMembers$2(-2, charSequence4, alertParams.NetworkUserEntityData$$ExternalSyntheticLambda8, alertParams.newProxyInstance);
            }
            CharSequence charSequence5 = alertParams.NetworkUserEntityData$$ExternalSyntheticLambda5;
            if (charSequence5 != null || alertParams.NetworkUserEntityData$$ExternalSyntheticLambda4 != null) {
                alertController.KClassImpl$Data$declaredNonStaticMembers$2(-3, charSequence5, alertParams.NetworkUserEntityData$$ExternalSyntheticLambda3, alertParams.NetworkUserEntityData$$ExternalSyntheticLambda4);
            }
            if (alertParams.isLayoutRequested != null || alertParams.moveToNextValue != null || alertParams.getAuthRequestContext != null) {
                final AlertController.RecycleListView recycleListView = (AlertController.RecycleListView) alertParams.initRecordTimeStamp.inflate(alertController.getCallingPid, (ViewGroup) null);
                if (alertParams.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                    if (alertParams.moveToNextValue == null) {
                        final Context context = alertParams.MyBillsEntityDataFactory;
                        final int i4 = alertController.A;
                        final CharSequence[] charSequenceArr = alertParams.isLayoutRequested;
                        listAdapter = new ArrayAdapter<CharSequence>(context, i4, charSequenceArr) { // from class: androidx.appcompat.app.AlertController.AlertParams.1
                            @Override // android.widget.ArrayAdapter, android.widget.Adapter
                            public View getView(int i5, View view2, ViewGroup viewGroup) {
                                View view3 = super.getView(i5, view2, viewGroup);
                                if (alertParams.PlaceComponentResult != null && alertParams.PlaceComponentResult[i5]) {
                                    recycleListView.setItemChecked(i5, true);
                                }
                                return view3;
                            }
                        };
                    } else {
                        final Context context2 = alertParams.MyBillsEntityDataFactory;
                        final Cursor cursor = alertParams.moveToNextValue;
                        listAdapter = new CursorAdapter(context2, cursor, recycleListView, alertController) { // from class: androidx.appcompat.app.AlertController.AlertParams.2
                            final /* synthetic */ RecycleListView BuiltInFictitiousFunctionClassFactory;
                            private final int KClassImpl$Data$declaredNonStaticMembers$2;
                            final /* synthetic */ AlertController PlaceComponentResult;
                            private final int getAuthRequestContext;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(context2, cursor, false);
                                AlertParams.this = alertParams;
                                this.BuiltInFictitiousFunctionClassFactory = recycleListView;
                                this.PlaceComponentResult = alertController;
                                Cursor cursor2 = getCursor();
                                this.getAuthRequestContext = cursor2.getColumnIndexOrThrow(alertParams.NetworkUserEntityData$$ExternalSyntheticLambda7);
                                this.KClassImpl$Data$declaredNonStaticMembers$2 = cursor2.getColumnIndexOrThrow(alertParams.GetContactSyncConfig);
                            }

                            @Override // android.widget.CursorAdapter
                            public void bindView(View view2, Context context3, Cursor cursor2) {
                                ((CheckedTextView) view2.findViewById(16908308)).setText(cursor2.getString(this.getAuthRequestContext));
                                this.BuiltInFictitiousFunctionClassFactory.setItemChecked(cursor2.getPosition(), cursor2.getInt(this.KClassImpl$Data$declaredNonStaticMembers$2) == 1);
                            }

                            @Override // android.widget.CursorAdapter
                            public View newView(Context context3, Cursor cursor2, ViewGroup viewGroup) {
                                return AlertParams.this.initRecordTimeStamp.inflate(this.PlaceComponentResult.A, viewGroup, false);
                            }
                        };
                    }
                } else {
                    if (alertParams.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                        i = alertController.C;
                    } else {
                        i = alertController.SubSequence;
                    }
                    if (alertParams.moveToNextValue != null) {
                        listAdapter = new SimpleCursorAdapter(alertParams.MyBillsEntityDataFactory, i, alertParams.moveToNextValue, new String[]{alertParams.NetworkUserEntityData$$ExternalSyntheticLambda7}, new int[]{16908308});
                    } else {
                        listAdapter = alertParams.getAuthRequestContext;
                        if (listAdapter == null) {
                            listAdapter = new AlertController.CheckedItemAdapter(alertParams.MyBillsEntityDataFactory, i, alertParams.isLayoutRequested);
                        }
                    }
                }
                AlertController.AlertParams.OnPrepareListViewListener onPrepareListViewListener = alertParams.C;
                alertController.KClassImpl$Data$declaredNonStaticMembers$2 = listAdapter;
                alertController.isLayoutRequested = alertParams.KClassImpl$Data$declaredNonStaticMembers$2;
                if (alertParams.readMicros != null) {
                    recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.AlertParams.3
                        @Override // android.widget.AdapterView.OnItemClickListener
                        public void onItemClick(AdapterView<?> adapterView, View view2, int i5, long j) {
                            alertParams.readMicros.onClick(alertController.NetworkUserEntityData$$ExternalSyntheticLambda3, i5);
                            if (alertParams.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                                return;
                            }
                            alertController.NetworkUserEntityData$$ExternalSyntheticLambda3.dismiss();
                        }
                    });
                } else if (alertParams.getCallingPid != null) {
                    recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.AlertParams.4
                        @Override // android.widget.AdapterView.OnItemClickListener
                        public void onItemClick(AdapterView<?> adapterView, View view2, int i5, long j) {
                            if (alertParams.PlaceComponentResult != null) {
                                alertParams.PlaceComponentResult[i5] = recycleListView.isItemChecked(i5);
                            }
                            alertParams.getCallingPid.onClick(alertController.NetworkUserEntityData$$ExternalSyntheticLambda3, i5, recycleListView.isItemChecked(i5));
                        }
                    });
                }
                AdapterView.OnItemSelectedListener onItemSelectedListener = alertParams.SubSequence;
                if (onItemSelectedListener != null) {
                    recycleListView.setOnItemSelectedListener(onItemSelectedListener);
                }
                if (alertParams.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                    recycleListView.setChoiceMode(1);
                } else if (alertParams.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                    recycleListView.setChoiceMode(2);
                }
                alertController.readMicros = recycleListView;
            }
            View view2 = alertParams.VerifyPinStateManager$executeRiskChallenge$2$2;
            if (view2 != null) {
                if (alertParams.F) {
                    int i5 = alertParams.D;
                    int i6 = alertParams.AppCompatEmojiTextHelper;
                    int i7 = alertParams.G;
                    int i8 = alertParams.getOnBoardingScenario;
                    alertController.D = view2;
                    alertController.getOnBoardingScenario = 0;
                    alertController.F = true;
                    alertController.H = i5;
                    alertController.I = i6;
                    alertController.G = i7;
                    alertController.getValueOfTouchPositionAbsolute = i8;
                } else {
                    alertController.D = view2;
                    alertController.getOnBoardingScenario = 0;
                    alertController.F = false;
                }
            } else {
                int i9 = alertParams.E;
                if (i9 != 0) {
                    alertController.D = null;
                    alertController.getOnBoardingScenario = i9;
                    alertController.F = false;
                }
            }
            alertDialog.setCancelable(this.P.BuiltInFictitiousFunctionClassFactory);
            if (this.P.BuiltInFictitiousFunctionClassFactory) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.P.FragmentBottomSheetPaymentSettingBinding);
            alertDialog.setOnDismissListener(this.P.getSupportButtonTintMode);
            if (this.P.whenAvailable != null) {
                alertDialog.setOnKeyListener(this.P.whenAvailable);
            }
            return alertDialog;
        }

        public AlertDialog show() {
            AlertDialog create = create();
            create.show();
            return create;
        }
    }
}

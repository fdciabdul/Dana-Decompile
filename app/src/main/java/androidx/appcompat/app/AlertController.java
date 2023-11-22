package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.widget.NestedScrollView;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class AlertController {
    int A;
    final Window AppCompatEmojiTextHelper;
    TextView B;
    NestedScrollView BottomSheetCardBindingView$watcherCardNumberView$1;
    int C;
    View D;
    CharSequence DatabaseTableConfigUtil;
    CharSequence E;
    Drawable FragmentBottomSheetPaymentSettingBinding;
    int G;
    int GetContactSyncConfig;
    int H;
    int I;
    ListAdapter KClassImpl$Data$declaredNonStaticMembers$2;
    Button MyBillsEntityDataFactory;
    Button NetworkUserEntityData$$ExternalSyntheticLambda0;
    Button NetworkUserEntityData$$ExternalSyntheticLambda2;
    final AppCompatDialog NetworkUserEntityData$$ExternalSyntheticLambda3;
    Handler NetworkUserEntityData$$ExternalSyntheticLambda5;
    View NetworkUserEntityData$$ExternalSyntheticLambda6;
    final Context NetworkUserEntityData$$ExternalSyntheticLambda7;
    Message NetworkUserEntityData$$ExternalSyntheticLambda8;
    final int PlaceComponentResult;
    Drawable PrepareContext;
    int SubSequence;
    boolean VerifyPinStateManager$executeRiskChallenge$2$1;
    TextView VerifyPinStateManager$executeRiskChallenge$2$2;
    int getAuthRequestContext;
    int getCallingPid;
    Message getErrorConfigVersion;
    int getOnBoardingScenario;
    CharSequence getSupportButtonTintMode;
    int getValueOfTouchPositionAbsolute;
    Message initRecordTimeStamp;
    Drawable lookAheadTest;
    Drawable moveToNextValue;
    CharSequence newProxyInstance;
    public ListView readMicros;
    CharSequence scheduleImpl;
    ImageView whenAvailable;
    boolean F = false;
    int NetworkUserEntityData$$ExternalSyntheticLambda4 = 0;
    int isLayoutRequested = -1;
    int NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
    final View.OnClickListener BuiltInFictitiousFunctionClassFactory = new View.OnClickListener() { // from class: androidx.appcompat.app.AlertController.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message obtain;
            if (view == AlertController.this.NetworkUserEntityData$$ExternalSyntheticLambda2 && AlertController.this.NetworkUserEntityData$$ExternalSyntheticLambda8 != null) {
                obtain = Message.obtain(AlertController.this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            } else if (view == AlertController.this.MyBillsEntityDataFactory && AlertController.this.getErrorConfigVersion != null) {
                obtain = Message.obtain(AlertController.this.getErrorConfigVersion);
            } else {
                obtain = (view != AlertController.this.NetworkUserEntityData$$ExternalSyntheticLambda0 || AlertController.this.initRecordTimeStamp == null) ? null : Message.obtain(AlertController.this.initRecordTimeStamp);
            }
            if (obtain != null) {
                obtain.sendToTarget();
            }
            AlertController.this.NetworkUserEntityData$$ExternalSyntheticLambda5.obtainMessage(1, AlertController.this.NetworkUserEntityData$$ExternalSyntheticLambda3).sendToTarget();
        }
    };

    /* loaded from: classes3.dex */
    static final class ButtonHandler extends Handler {
        private WeakReference<DialogInterface> BuiltInFictitiousFunctionClassFactory;

        public ButtonHandler(DialogInterface dialogInterface) {
            this.BuiltInFictitiousFunctionClassFactory = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == -3 || i == -2 || i == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.BuiltInFictitiousFunctionClassFactory.get(), message.what);
            } else if (i == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean BuiltInFictitiousFunctionClassFactory(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.NetworkUserEntityData$$ExternalSyntheticLambda1, typedValue, true);
        return typedValue.data != 0;
    }

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = context;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = appCompatDialog;
        this.AppCompatEmojiTextHelper = window;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = new ButtonHandler(appCompatDialog);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.A, R.attr.NetworkUserEntityData$$ExternalSyntheticLambda7, 0);
        this.getAuthRequestContext = obtainStyledAttributes.getResourceId(R.styleable.B, 0);
        this.GetContactSyncConfig = obtainStyledAttributes.getResourceId(R.styleable.getOnBoardingScenario, 0);
        this.getCallingPid = obtainStyledAttributes.getResourceId(R.styleable.getValueOfTouchPositionAbsolute, 0);
        this.A = obtainStyledAttributes.getResourceId(R.styleable.E, 0);
        this.C = obtainStyledAttributes.getResourceId(R.styleable.I, 0);
        this.SubSequence = obtainStyledAttributes.getResourceId(R.styleable.VerifyPinStateManager$executeRiskChallenge$2$2, 0);
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = obtainStyledAttributes.getBoolean(R.styleable.G, true);
        this.PlaceComponentResult = obtainStyledAttributes.getDimensionPixelSize(R.styleable.D, 0);
        obtainStyledAttributes.recycle();
        appCompatDialog.supportRequestWindowFeature(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean BuiltInFictitiousFunctionClassFactory(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            while (childCount > 0) {
                childCount--;
                if (BuiltInFictitiousFunctionClassFactory(viewGroup.getChildAt(childCount))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Drawable drawable) {
        Message obtainMessage = onClickListener != null ? this.NetworkUserEntityData$$ExternalSyntheticLambda5.obtainMessage(i, onClickListener) : null;
        if (i == -3) {
            this.DatabaseTableConfigUtil = charSequence;
            this.initRecordTimeStamp = obtainMessage;
            this.moveToNextValue = drawable;
        } else if (i == -2) {
            this.scheduleImpl = charSequence;
            this.getErrorConfigVersion = obtainMessage;
            this.lookAheadTest = drawable;
        } else if (i == -1) {
            this.newProxyInstance = charSequence;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = obtainMessage;
            this.PrepareContext = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public final void MyBillsEntityDataFactory(int i) {
        this.FragmentBottomSheetPaymentSettingBinding = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = i;
        ImageView imageView = this.whenAvailable;
        if (imageView != null) {
            if (i != 0) {
                imageView.setVisibility(0);
                InstrumentInjector.Resources_setImageResource(this.whenAvailable, this.NetworkUserEntityData$$ExternalSyntheticLambda4);
                return;
            }
            imageView.setVisibility(8);
        }
    }

    public final boolean MyBillsEntityDataFactory(KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.BottomSheetCardBindingView$watcherCardNumberView$1;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.BottomSheetCardBindingView$watcherCardNumberView$1;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ViewGroup PlaceComponentResult(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    static void PlaceComponentResult(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void BuiltInFictitiousFunctionClassFactory(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    /* loaded from: classes3.dex */
    public static class RecycleListView extends ListView {
        private final int KClassImpl$Data$declaredNonStaticMembers$2;
        private final int MyBillsEntityDataFactory;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.getExceptionOrNull);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.TrackerKey$GlobalSearchOpenProperties, -1);
            this.MyBillsEntityDataFactory = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.UnicastProcessor$UnicastQueueSubscription, -1);
        }

        public void setHasDecor(boolean z, boolean z2) {
            if (z2 && z) {
                return;
            }
            setPadding(getPaddingLeft(), z ? getPaddingTop() : this.MyBillsEntityDataFactory, getPaddingRight(), z2 ? getPaddingBottom() : this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    /* loaded from: classes3.dex */
    public static class AlertParams {
        public Drawable A;
        public int AppCompatEmojiTextHelper;
        public CharSequence B;
        public OnPrepareListViewListener C;
        public int D;
        public int E;
        public DialogInterface.OnCancelListener FragmentBottomSheetPaymentSettingBinding;
        public int G;
        public String GetContactSyncConfig;
        public final Context MyBillsEntityDataFactory;
        public Drawable NetworkUserEntityData$$ExternalSyntheticLambda0;
        public boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
        public boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
        public DialogInterface.OnClickListener NetworkUserEntityData$$ExternalSyntheticLambda3;
        public Drawable NetworkUserEntityData$$ExternalSyntheticLambda4;
        public CharSequence NetworkUserEntityData$$ExternalSyntheticLambda5;
        public CharSequence NetworkUserEntityData$$ExternalSyntheticLambda6;
        public String NetworkUserEntityData$$ExternalSyntheticLambda7;
        public DialogInterface.OnClickListener NetworkUserEntityData$$ExternalSyntheticLambda8;
        public boolean[] PlaceComponentResult;
        public CharSequence PrepareContext;
        public AdapterView.OnItemSelectedListener SubSequence;
        public DialogInterface.OnClickListener VerifyPinStateManager$executeRiskChallenge$2$1;
        public View VerifyPinStateManager$executeRiskChallenge$2$2;
        public ListAdapter getAuthRequestContext;
        public DialogInterface.OnMultiChoiceClickListener getCallingPid;
        public int getOnBoardingScenario;
        public DialogInterface.OnDismissListener getSupportButtonTintMode;
        public CharSequence getValueOfTouchPositionAbsolute;
        public final LayoutInflater initRecordTimeStamp;
        public CharSequence[] isLayoutRequested;
        public View lookAheadTest;
        public Cursor moveToNextValue;
        public Drawable newProxyInstance;
        public DialogInterface.OnClickListener readMicros;
        public boolean scheduleImpl;
        public DialogInterface.OnKeyListener whenAvailable;
        public int DatabaseTableConfigUtil = 0;
        public int getErrorConfigVersion = 0;
        public boolean F = false;
        public int KClassImpl$Data$declaredNonStaticMembers$2 = -1;
        public boolean BottomSheetCardBindingView$watcherCardNumberView$1 = true;
        public boolean BuiltInFictitiousFunctionClassFactory = true;

        /* loaded from: classes3.dex */
        public interface OnPrepareListViewListener {
        }

        public AlertParams(Context context) {
            this.MyBillsEntityDataFactory = context;
            this.initRecordTimeStamp = (LayoutInflater) context.getSystemService("layout_inflater");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        public CheckedItemAdapter(Context context, int i, CharSequence[] charSequenceArr) {
            super(context, i, 16908308, charSequenceArr);
        }
    }
}

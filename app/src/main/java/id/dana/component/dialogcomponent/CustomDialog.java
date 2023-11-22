package id.dana.component.dialogcomponent;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import id.dana.component.BaseMaterialDialog;
import id.dana.component.R;
import id.dana.component.extension.ContextExtKt;
import id.dana.component.extension.ViewExtKt;
import id.dana.component.formcomponent.DanaCheckboxButtonView;
import id.dana.component.utils.ImageResize;
import id.dana.component.utils.SizeUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002./B+\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020(\u0012\u0006\u0010\u0006\u001a\u00020)\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b,\u0010-J-\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010!R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010#\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010&"}, d2 = {"Lid/dana/component/dialogcomponent/CustomDialog;", "Lid/dana/component/BaseMaterialDialog;", "Lid/dana/component/dialogcomponent/CustomDialog$Builder;", "Landroid/widget/Button;", "p0", "", "p1", "Landroid/view/View$OnClickListener;", "p2", "", "PlaceComponentResult", "(Landroid/widget/Button;Ljava/lang/CharSequence;Landroid/view/View$OnClickListener;)V", "getAuthRequestContext", "Landroid/widget/Button;", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/component/formcomponent/DanaCheckboxButtonView;", "moveToNextValue", "Lid/dana/component/formcomponent/DanaCheckboxButtonView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getErrorConfigVersion", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/EditText;", "lookAheadTest", "Landroid/widget/EditText;", "Landroid/widget/ImageView;", "scheduleImpl", "Landroid/widget/ImageView;", "DatabaseTableConfigUtil", "Landroid/widget/RelativeLayout;", "GetContactSyncConfig", "Landroid/widget/RelativeLayout;", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Landroid/widget/TextView;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Landroid/widget/TextView;", "PrepareContext", "Landroid/content/Context;", "", "Landroid/content/DialogInterface$OnDismissListener;", "p3", "<init>", "(Landroid/content/Context;ILid/dana/component/dialogcomponent/CustomDialog$Builder;Landroid/content/DialogInterface$OnDismissListener;)V", "Builder", "TextAlignment"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public final class CustomDialog extends BaseMaterialDialog<Builder> {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private ImageView scheduleImpl;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private RelativeLayout lookAheadTest;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Button KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private Button PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private RelativeLayout DatabaseTableConfigUtil;
    private TextView NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private TextView NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private Button BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private ConstraintLayout MyBillsEntityDataFactory;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private RelativeLayout moveToNextValue;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private EditText NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private DanaCheckboxButtonView getAuthRequestContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private ImageView getErrorConfigVersion;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006"}, d2 = {"Lid/dana/component/dialogcomponent/CustomDialog$TextAlignment;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "CENTER", "RIGHT"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes4.dex */
    public enum TextAlignment {
        LEFT,
        CENTER,
        RIGHT
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[TextAlignment.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            iArr[TextAlignment.LEFT.ordinal()] = 1;
            iArr[TextAlignment.RIGHT.ordinal()] = 2;
        }
    }

    public /* synthetic */ CustomDialog(Context context, int i, Builder builder, DialogInterface.OnDismissListener onDismissListener, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i, builder, onDismissListener);
    }

    @Override // id.dana.component.BaseMaterialDialog
    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(View view, Builder builder) {
        View findViewById;
        Builder builder2 = builder;
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(builder2, "");
        this.getErrorConfigVersion = (ImageView) view.findViewById(R.id.res_0x7f0a0ad5_networkuserentitydata_externalsyntheticlambda4);
        this.lookAheadTest = (RelativeLayout) view.findViewById(R.id.rl_custom_icon);
        this.moveToNextValue = (RelativeLayout) view.findViewById(R.id.getValueOfTouchPositionAbsolute_res_0x7f0a109e);
        this.MyBillsEntityDataFactory = (ConstraintLayout) view.findViewById(R.id.cl_action_dialog);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = (TextView) view.findViewById(16908310);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = (TextView) view.findViewById(16908304);
        this.BuiltInFictitiousFunctionClassFactory = (Button) view.findViewById(R.id.getAuthRequestContext);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (Button) view.findViewById(R.id.KClassImpl$Data$declaredNonStaticMembers$2);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = (EditText) view.findViewById(16908297);
        this.scheduleImpl = (ImageView) view.findViewById(R.id.res_0x7f0a0ad6_networkuserentitydata_externalsyntheticlambda3);
        this.PlaceComponentResult = (Button) view.findViewById(R.id.btn_single_space);
        this.DatabaseTableConfigUtil = (RelativeLayout) view.findViewById(R.id.rl_single_space);
        this.getAuthRequestContext = (DanaCheckboxButtonView) view.findViewById(R.id.res_0x7f0a02b6_networkuserentitydata_externalsyntheticlambda0);
        ImageView imageView = this.getErrorConfigVersion;
        if (imageView != null) {
            if (builder2.NetworkUserEntityData$$ExternalSyntheticLambda0 != 0) {
                ViewExtKt.getAuthRequestContext(imageView, builder2.NetworkUserEntityData$$ExternalSyntheticLambda0);
            } else {
                RelativeLayout relativeLayout = this.lookAheadTest;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
            }
        }
        Integer num = builder2.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (num != null) {
            int intValue = num.intValue();
            ImageView imageView2 = this.getErrorConfigVersion;
            if (imageView2 != null) {
                imageView2.getLayoutParams().height = SizeUtil.PlaceComponentResult(intValue);
                imageView2.getLayoutParams().width = SizeUtil.PlaceComponentResult(intValue);
            }
        }
        TextView textView = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (textView != null) {
            if (builder2.GetContactSyncConfig != null) {
                textView.setText(builder2.GetContactSyncConfig);
            } else {
                textView.setVisibility(8);
            }
            Unit unit = Unit.INSTANCE;
        }
        TextAlignment textAlignment = builder2.PrepareContext;
        int i = 4;
        if (textAlignment != null) {
            int i2 = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[textAlignment.ordinal()];
            if (i2 == 1) {
                TextView textView2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                if (textView2 != null) {
                    textView2.setTextAlignment(5);
                }
            } else if (i2 == 2) {
                TextView textView3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                if (textView3 != null) {
                    textView3.setTextAlignment(6);
                }
            } else {
                TextView textView4 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                if (textView4 != null) {
                    textView4.setTextAlignment(4);
                }
            }
            Unit unit2 = Unit.INSTANCE;
        }
        TextView textView5 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (textView5 != null) {
            if (builder2.SubSequence != null) {
                textView5.setText(builder2.SubSequence);
            } else {
                textView5.setVisibility(8);
            }
            Unit unit3 = Unit.INSTANCE;
        }
        EditText editText = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (editText != null) {
            if (builder2.lookAheadTest != null) {
                editText.setHint(builder2.lookAheadTest);
            } else {
                editText.setVisibility(8);
            }
            Unit unit4 = Unit.INSTANCE;
        }
        if (this.moveToNextValue != null && this.scheduleImpl != null) {
            if (builder2.initRecordTimeStamp != null) {
                String str = builder2.initRecordTimeStamp;
                if (!(str == null || str.length() == 0)) {
                    if (builder2.NetworkUserEntityData$$ExternalSyntheticLambda2 == 0) {
                        RequestBuilder<Drawable> authRequestContext = Glide.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult).getAuthRequestContext(builder2.initRecordTimeStamp);
                        ImageView imageView3 = this.scheduleImpl;
                        Intrinsics.checkNotNull(imageView3);
                        authRequestContext.MyBillsEntityDataFactory(imageView3);
                    } else {
                        RequestBuilder MyBillsEntityDataFactory = Glide.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult).getAuthRequestContext(builder2.initRecordTimeStamp).MyBillsEntityDataFactory(builder2.NetworkUserEntityData$$ExternalSyntheticLambda2);
                        ImageView imageView4 = this.scheduleImpl;
                        Intrinsics.checkNotNull(imageView4);
                        MyBillsEntityDataFactory.MyBillsEntityDataFactory(imageView4);
                    }
                }
            } else if (builder2.DatabaseTableConfigUtil == 0) {
                RelativeLayout relativeLayout2 = this.moveToNextValue;
                if (relativeLayout2 != null) {
                    relativeLayout2.setVisibility(8);
                }
            } else if (builder2.DatabaseTableConfigUtil != 0) {
                ImageView imageView5 = this.scheduleImpl;
                if (imageView5 != null) {
                    ViewExtKt.getAuthRequestContext(imageView5, builder2.DatabaseTableConfigUtil);
                }
            } else {
                RelativeLayout relativeLayout3 = this.moveToNextValue;
                if (relativeLayout3 != null) {
                    relativeLayout3.setVisibility(8);
                }
            }
        }
        RelativeLayout relativeLayout4 = this.DatabaseTableConfigUtil;
        if (relativeLayout4 != null) {
            if (builder2.getAuthRequestContext != null) {
                Button button = this.PlaceComponentResult;
                if (button != null) {
                    button.setText(builder2.getAuthRequestContext);
                }
                Button button2 = this.PlaceComponentResult;
                if (button2 != null) {
                    button2.setOnClickListener(builder2.readMicros);
                    Unit unit5 = Unit.INSTANCE;
                }
            } else {
                relativeLayout4.setVisibility(8);
                Unit unit6 = Unit.INSTANCE;
            }
        }
        PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, builder2.NetworkUserEntityData$$ExternalSyntheticLambda7, builder2.NetworkUserEntityData$$ExternalSyntheticLambda8);
        PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, builder2.NetworkUserEntityData$$ExternalSyntheticLambda6, builder2.getSupportButtonTintMode);
        if (builder2.BottomSheetCardBindingView$watcherCardNumberView$1 != 0 && (findViewById = view.findViewById(builder2.BottomSheetCardBindingView$watcherCardNumberView$1)) != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: id.dana.component.dialogcomponent.CustomDialog$setDismissActionTo$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    MaterialDialog materialDialog;
                    CustomDialog customDialog = CustomDialog.this;
                    if (!ContextExtKt.BuiltInFictitiousFunctionClassFactory(customDialog.PlaceComponentResult) || (materialDialog = customDialog.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
                        return;
                    }
                    materialDialog.dismiss();
                }
            });
        }
        if (builder2.BuiltInFictitiousFunctionClassFactory instanceof Activity) {
            Context context = builder2.BuiltInFictitiousFunctionClassFactory;
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
            i = ImageResize.BuiltInFictitiousFunctionClassFactory((Activity) context, 4);
        }
        if (builder2.getC()) {
            if (this.MyBillsEntityDataFactory != null && this.BuiltInFictitiousFunctionClassFactory != null && this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.getAuthRequestContext(this.MyBillsEntityDataFactory);
                constraintSet.BuiltInFictitiousFunctionClassFactory(R.id.getAuthRequestContext, 1, 0, 1);
                constraintSet.BuiltInFictitiousFunctionClassFactory(R.id.getAuthRequestContext, 2, 0, 2);
                constraintSet.BuiltInFictitiousFunctionClassFactory(R.id.getAuthRequestContext, 3, 0, 3);
                constraintSet.BuiltInFictitiousFunctionClassFactory(R.id.KClassImpl$Data$declaredNonStaticMembers$2, 1, 0, 1);
                constraintSet.BuiltInFictitiousFunctionClassFactory(R.id.KClassImpl$Data$declaredNonStaticMembers$2, 2, 0, 2);
                constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(R.id.KClassImpl$Data$declaredNonStaticMembers$2, 3, R.id.getAuthRequestContext, 4, i);
                constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory);
            }
        } else if (this.MyBillsEntityDataFactory != null && this.BuiltInFictitiousFunctionClassFactory != null && this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            ConstraintSet constraintSet2 = new ConstraintSet();
            constraintSet2.getAuthRequestContext(this.MyBillsEntityDataFactory);
            constraintSet2.BuiltInFictitiousFunctionClassFactory(R.id.getAuthRequestContext, 1, 0, 1);
            int i3 = i;
            constraintSet2.KClassImpl$Data$declaredNonStaticMembers$2(R.id.getAuthRequestContext, 2, R.id.KClassImpl$Data$declaredNonStaticMembers$2, 1, i3);
            constraintSet2.BuiltInFictitiousFunctionClassFactory(R.id.getAuthRequestContext, 3, 0, 3);
            constraintSet2.KClassImpl$Data$declaredNonStaticMembers$2(R.id.KClassImpl$Data$declaredNonStaticMembers$2, 1, R.id.getAuthRequestContext, 2, i3);
            constraintSet2.BuiltInFictitiousFunctionClassFactory(R.id.KClassImpl$Data$declaredNonStaticMembers$2, 2, 0, 2);
            constraintSet2.BuiltInFictitiousFunctionClassFactory(R.id.KClassImpl$Data$declaredNonStaticMembers$2, 3, 0, 3);
            constraintSet2.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory);
        }
        DanaCheckboxButtonView danaCheckboxButtonView = this.getAuthRequestContext;
        if (danaCheckboxButtonView != null) {
            danaCheckboxButtonView.setVisibility(builder2.getFragmentBottomSheetPaymentSettingBinding() ? 0 : 8);
            danaCheckboxButtonView.setChecked(builder2.getNetworkUserEntityData$$ExternalSyntheticLambda5());
            danaCheckboxButtonView.setOnCheckedChangeListener(builder2.NetworkUserEntityData$$ExternalSyntheticLambda3);
            Unit unit7 = Unit.INSTANCE;
        }
        view.setContentDescription(builder2.MyBillsEntityDataFactory);
        Button button3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (button3 != null) {
            button3.setContentDescription(builder2.NetworkUserEntityData$$ExternalSyntheticLambda4);
        }
        Button button4 = this.BuiltInFictitiousFunctionClassFactory;
        if (button4 != null) {
            button4.setContentDescription(builder2.newProxyInstance);
        }
        TextView textView6 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (textView6 != null) {
            textView6.setContentDescription(builder2.whenAvailable);
        }
        TextView textView7 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (textView7 != null) {
            textView7.setContentDescription(builder2.isLayoutRequested);
        }
        EditText editText2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (editText2 != null) {
            editText2.setContentDescription(builder2.scheduleImpl);
        }
        Button button5 = this.PlaceComponentResult;
        if (button5 != null) {
            button5.setContentDescription(builder2.PlaceComponentResult);
        }
        DanaCheckboxButtonView danaCheckboxButtonView2 = this.getAuthRequestContext;
        if (danaCheckboxButtonView2 != null) {
            danaCheckboxButtonView2.setContentDescription(builder2.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    private CustomDialog(Context context, int i, Builder builder, DialogInterface.OnDismissListener onDismissListener) {
        super(context, i, builder, onDismissListener);
    }

    private final void PlaceComponentResult(Button p0, CharSequence p1, final View.OnClickListener p2) {
        ConstraintLayout constraintLayout = this.MyBillsEntityDataFactory;
        if (constraintLayout == null || p0 == null || p1 == null) {
            if (p0 != null) {
                p0.setVisibility(8);
                return;
            }
            return;
        }
        Intrinsics.checkNotNull(constraintLayout);
        constraintLayout.setVisibility(0);
        p0.setText(p1);
        p0.setOnClickListener(new View.OnClickListener() { // from class: id.dana.component.dialogcomponent.CustomDialog$showActionDialogButton$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                View BuiltInFictitiousFunctionClassFactory;
                MaterialDialog materialDialog;
                CustomDialog customDialog = CustomDialog.this;
                if (ContextExtKt.BuiltInFictitiousFunctionClassFactory(customDialog.PlaceComponentResult) && (materialDialog = customDialog.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
                    materialDialog.dismiss();
                }
                View.OnClickListener onClickListener = p2;
                if (onClickListener != null) {
                    BuiltInFictitiousFunctionClassFactory = CustomDialog.this.BuiltInFictitiousFunctionClassFactory();
                    onClickListener.onClick(BuiltInFictitiousFunctionClassFactory);
                }
            }
        });
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0015¢\u0006\u0004\bB\u0010CJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\bJ+\u0010\t\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\t\u0010\u000fJ+\u0010\u0003\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u0003\u0010\u000fR\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u0010X\u0080\u0002¢\u0006\u0006\n\u0004\b\t\u0010\u0011R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\nX\u0080\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0014\u0010\t\u001a\u0004\u0018\u00010\u0010X\u0080\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0010X\u0080\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0012\u0010\u0003\u001a\u00020\u0015X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\nX\u0080\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u0012R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u0010X\u0080\u0002¢\u0006\u0006\n\u0004\b\u001f\u0010\u0011R\u0012\u0010\u001f\u001a\u00020 X\u0080\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010!R\u0014\u0010$\u001a\u0004\u0018\u00010 X\u0080\u0002¢\u0006\u0006\n\u0004\b\"\u0010#R\u0012\u0010&\u001a\u00020 X\u0080\u0002¢\u0006\u0006\n\u0004\b%\u0010!R\u0012\u0010%\u001a\u00020 X\u0080\u0002¢\u0006\u0006\n\u0004\b'\u0010!R\u0014\u0010\"\u001a\u0004\u0018\u00010\u0010X\u0080\u0002¢\u0006\u0006\n\u0004\b$\u0010\u0011R\u0014\u0010'\u001a\u0004\u0018\u00010\nX\u0080\u0002¢\u0006\u0006\n\u0004\b&\u0010\u0012R\u0014\u0010)\u001a\u0004\u0018\u00010\u0010X\u0080\u0002¢\u0006\u0006\n\u0004\b(\u0010\u0011R\u0014\u0010+\u001a\u0004\u0018\u00010*X\u0080\u0002¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u0004\u0018\u00010\nX\u0080\u0002¢\u0006\u0006\n\u0004\b-\u0010\u0012R\u0014\u0010(\u001a\u0004\u0018\u00010\u0010X\u0080\u0002¢\u0006\u0006\n\u0004\b.\u0010\u0011R\u0014\u0010.\u001a\u0004\u0018\u00010/X\u0080\u0002¢\u0006\u0006\n\u0004\b)\u00100R\u001a\u00104\u001a\u00020\u00058\u0001X\u0080\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b\u0014\u00103R\u0014\u00108\u001a\u0004\u0018\u000105X\u0081\u0002¢\u0006\u0006\n\u0004\b6\u00107R\u001a\u0010:\u001a\u00020\u00058\u0001X\u0081\u0006¢\u0006\f\n\u0004\b9\u00102\u001a\u0004\b\u0007\u00103R\u0014\u00106\u001a\u0004\u0018\u00010\nX\u0081\u0002¢\u0006\u0006\n\u0004\b4\u0010\u0012R\u0014\u0010;\u001a\u0004\u0018\u00010\u0010X\u0081\u0002¢\u0006\u0006\n\u0004\b;\u0010\u0011R\u0014\u0010<\u001a\u0004\u0018\u00010/X\u0081\u0002¢\u0006\u0006\n\u0004\b8\u00100R\u0012\u0010=\u001a\u00020 X\u0081\u0002¢\u0006\u0006\n\u0004\b:\u0010!R\u0014\u00101\u001a\u0004\u0018\u00010/X\u0081\u0002¢\u0006\u0006\n\u0004\b>\u00100R\u0014\u0010>\u001a\u0004\u0018\u00010\nX\u0081\u0002¢\u0006\u0006\n\u0004\b?\u0010\u0012R\u0014\u0010?\u001a\u0004\u0018\u00010\u0010X\u0081\u0002¢\u0006\u0006\n\u0004\b<\u0010\u0011R\u001a\u00109\u001a\u00020\u00058\u0001X\u0081\u0006¢\u0006\f\n\u0004\b@\u00102\u001a\u0004\b\u001f\u00103R\u0012\u0010A\u001a\u00020 X\u0081\u0002¢\u0006\u0006\n\u0004\b=\u0010!"}, d2 = {"Lid/dana/component/dialogcomponent/CustomDialog$Builder;", "Lid/dana/component/BaseMaterialDialog$Cancellation;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "BuiltInFictitiousFunctionClassFactory", "()Lcom/afollestad/materialdialogs/MaterialDialog;", "", "p0", "PlaceComponentResult", "(Z)Lid/dana/component/dialogcomponent/CustomDialog$Builder;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Lkotlin/Function1;", "Landroid/view/View;", "", "p1", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Lid/dana/component/dialogcomponent/CustomDialog$Builder;", "", "Ljava/lang/String;", "Ljava/lang/CharSequence;", "getAuthRequestContext", "MyBillsEntityDataFactory", "Landroid/content/Context;", "Landroid/content/Context;", "", "moveToNextValue", "J", "Landroid/content/DialogInterface$OnDismissListener;", "scheduleImpl", "Landroid/content/DialogInterface$OnDismissListener;", "getErrorConfigVersion", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "I", "initRecordTimeStamp", "Ljava/lang/Integer;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "NetworkUserEntityData$$ExternalSyntheticLambda2", "DatabaseTableConfigUtil", "GetContactSyncConfig", "newProxyInstance", "isLayoutRequested", "Lid/dana/component/dialogcomponent/CustomDialog$TextAlignment;", "PrepareContext", "Lid/dana/component/dialogcomponent/CustomDialog$TextAlignment;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "readMicros", "Z", "()Z", "FragmentBottomSheetPaymentSettingBinding", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "NetworkUserEntityData$$ExternalSyntheticLambda6", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "NetworkUserEntityData$$ExternalSyntheticLambda3", "C", "NetworkUserEntityData$$ExternalSyntheticLambda5", "NetworkUserEntityData$$ExternalSyntheticLambda4", "getSupportButtonTintMode", "getCallingPid", "SubSequence", "whenAvailable", "VerifyPinStateManager$executeRiskChallenge$2$1", "BottomSheetCardBindingView$watcherCardNumberView$1", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes.dex */
    public static class Builder extends BaseMaterialDialog.Cancellation {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public CharSequence getAuthRequestContext;

        /* renamed from: C  reason: from kotlin metadata */
        private boolean NetworkUserEntityData$$ExternalSyntheticLambda5;

        /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
        public CharSequence GetContactSyncConfig;

        /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
        public CharSequence NetworkUserEntityData$$ExternalSyntheticLambda6;

        /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
        int NetworkUserEntityData$$ExternalSyntheticLambda2;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        String PlaceComponentResult;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
        String scheduleImpl;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
        public String initRecordTimeStamp;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
        public int DatabaseTableConfigUtil;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
        public View.OnClickListener getSupportButtonTintMode;
        public String NetworkUserEntityData$$ExternalSyntheticLambda4;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
        public int getCallingPid;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
        CompoundButton.OnCheckedChangeListener NetworkUserEntityData$$ExternalSyntheticLambda3;
        public CharSequence NetworkUserEntityData$$ExternalSyntheticLambda7;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
        public String newProxyInstance;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public Context BuiltInFictitiousFunctionClassFactory;
        public TextAlignment PrepareContext;

        /* renamed from: SubSequence  reason: from kotlin metadata */
        public View.OnClickListener readMicros;

        /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
        private boolean C;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        String MyBillsEntityDataFactory;

        /* renamed from: getCallingPid  reason: from kotlin metadata */
        int BottomSheetCardBindingView$watcherCardNumberView$1;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        CharSequence lookAheadTest;

        /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
        public String whenAvailable;

        /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
        public Integer NetworkUserEntityData$$ExternalSyntheticLambda1;

        /* renamed from: isLayoutRequested  reason: from kotlin metadata */
        public View.OnClickListener NetworkUserEntityData$$ExternalSyntheticLambda8;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        public int NetworkUserEntityData$$ExternalSyntheticLambda0;
        public long moveToNextValue;

        /* renamed from: newProxyInstance  reason: from kotlin metadata */
        public String isLayoutRequested;

        /* renamed from: readMicros  reason: from kotlin metadata */
        private boolean FragmentBottomSheetPaymentSettingBinding;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        public DialogInterface.OnDismissListener getErrorConfigVersion;

        /* renamed from: whenAvailable  reason: from kotlin metadata */
        public CharSequence SubSequence;

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "");
            this.BuiltInFictitiousFunctionClassFactory = context;
            this.getCallingPid = R.layout.view_custom_dialog;
            this.moveToNextValue = 3000L;
        }

        @JvmName(name = "MyBillsEntityDataFactory")
        /* renamed from: MyBillsEntityDataFactory  reason: from getter */
        public final boolean getFragmentBottomSheetPaymentSettingBinding() {
            return this.FragmentBottomSheetPaymentSettingBinding;
        }

        @JvmName(name = "PlaceComponentResult")
        /* renamed from: PlaceComponentResult  reason: from getter */
        public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda5() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        }

        @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda0")
        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from getter */
        public final boolean getC() {
            return this.C;
        }

        public final Builder BuiltInFictitiousFunctionClassFactory(CharSequence p0, Function1<? super View, Unit> p1) {
            Intrinsics.checkNotNullParameter(p1, "");
            CustomDialog$sam$android_view_View_OnClickListener$0 customDialog$sam$android_view_View_OnClickListener$0 = new CustomDialog$sam$android_view_View_OnClickListener$0(p1);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = p0;
            this.getSupportButtonTintMode = customDialog$sam$android_view_View_OnClickListener$0;
            return this;
        }

        public final Builder KClassImpl$Data$declaredNonStaticMembers$2(CharSequence p0, Function1<? super View, Unit> p1) {
            Intrinsics.checkNotNullParameter(p1, "");
            CustomDialog$sam$android_view_View_OnClickListener$0 customDialog$sam$android_view_View_OnClickListener$0 = new CustomDialog$sam$android_view_View_OnClickListener$0(p1);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = p0;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = customDialog$sam$android_view_View_OnClickListener$0;
            return this;
        }

        public final Builder PlaceComponentResult(boolean p0) {
            BaseMaterialDialog.Cancellation MyBillsEntityDataFactory = super.MyBillsEntityDataFactory(p0);
            if (MyBillsEntityDataFactory != null) {
                return (Builder) MyBillsEntityDataFactory;
            }
            throw new NullPointerException("null cannot be cast to non-null type id.dana.component.dialogcomponent.CustomDialog.Builder");
        }

        public final Builder KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
            BaseMaterialDialog.Cancellation BuiltInFictitiousFunctionClassFactory = super.BuiltInFictitiousFunctionClassFactory(p0);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                return (Builder) BuiltInFictitiousFunctionClassFactory;
            }
            throw new NullPointerException("null cannot be cast to non-null type id.dana.component.dialogcomponent.CustomDialog.Builder");
        }

        public MaterialDialog BuiltInFictitiousFunctionClassFactory() {
            return new CustomDialog(this.BuiltInFictitiousFunctionClassFactory, this.getCallingPid, this, this.getErrorConfigVersion, null).PlaceComponentResult();
        }

        @Override // id.dana.component.BaseMaterialDialog.Cancellation
        public final /* synthetic */ BaseMaterialDialog.Cancellation MyBillsEntityDataFactory(boolean z) {
            BaseMaterialDialog.Cancellation MyBillsEntityDataFactory = super.MyBillsEntityDataFactory(z);
            if (MyBillsEntityDataFactory != null) {
                return (Builder) MyBillsEntityDataFactory;
            }
            throw new NullPointerException("null cannot be cast to non-null type id.dana.component.dialogcomponent.CustomDialog.Builder");
        }

        @Override // id.dana.component.BaseMaterialDialog.Cancellation
        public final /* synthetic */ BaseMaterialDialog.Cancellation BuiltInFictitiousFunctionClassFactory(boolean z) {
            BaseMaterialDialog.Cancellation BuiltInFictitiousFunctionClassFactory = super.BuiltInFictitiousFunctionClassFactory(z);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                return (Builder) BuiltInFictitiousFunctionClassFactory;
            }
            throw new NullPointerException("null cannot be cast to non-null type id.dana.component.dialogcomponent.CustomDialog.Builder");
        }
    }
}

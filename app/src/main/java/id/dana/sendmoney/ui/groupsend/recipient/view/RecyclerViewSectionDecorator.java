package id.dana.sendmoney.ui.groupsend.recipient.view;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public class RecyclerViewSectionDecorator extends RecyclerView.ItemDecoration {
    private final int BuiltInFictitiousFunctionClassFactory;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private final boolean MyBillsEntityDataFactory;
    private final SectionCallback PlaceComponentResult;
    private int getAuthRequestContext;
    private int getErrorConfigVersion;
    private View lookAheadTest;
    private TextView moveToNextValue;

    /* loaded from: classes5.dex */
    public interface SectionCallback {
        boolean KClassImpl$Data$declaredNonStaticMembers$2(int i);

        CharSequence PlaceComponentResult(int i);
    }

    public RecyclerViewSectionDecorator(RecyclerView recyclerView, int i, SectionCallback sectionCallback) {
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() { // from class: id.dana.sendmoney.ui.groupsend.recipient.view.RecyclerViewSectionDecorator.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public final void BuiltInFictitiousFunctionClassFactory(RecyclerView recyclerView2, MotionEvent motionEvent) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public final boolean MyBillsEntityDataFactory(RecyclerView recyclerView2, MotionEvent motionEvent) {
                return motionEvent.getY() <= ((float) RecyclerViewSectionDecorator.this.getErrorConfigVersion);
            }
        });
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.MyBillsEntityDataFactory = true;
        this.PlaceComponentResult = sectionCallback;
        this.getAuthRequestContext = -1;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        View inflate;
        super.onDrawOver(canvas, recyclerView, state);
        if (this.lookAheadTest == null) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                inflate = LayoutInflater.from(recyclerView.getContext()).inflate(R.layout.layout_section_header_group_send, (ViewGroup) recyclerView, false);
            } else {
                inflate = LayoutInflater.from(recyclerView.getContext()).inflate(R.layout.layout_section_header_v1, (ViewGroup) recyclerView, false);
            }
            this.lookAheadTest = inflate;
            this.moveToNextValue = (TextView) inflate.findViewById(R.id.res_0x7f0a18be_otpchallengeuistate_verifyinvalidotp);
            View view = this.lookAheadTest;
            view.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), recyclerView.getPaddingLeft() + recyclerView.getPaddingRight(), view.getLayoutParams().width), ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 0), recyclerView.getPaddingTop() + recyclerView.getPaddingBottom(), view.getLayoutParams().height));
            this.getErrorConfigVersion = view.getMeasuredHeight();
            view.layout(0, 0, view.getMeasuredWidth(), this.getErrorConfigVersion + 5);
            this.lookAheadTest.setBackgroundColor(this.getAuthRequestContext);
            this.moveToNextValue.setBackgroundColor(this.getAuthRequestContext);
        }
        String str = "";
        for (int i = 0; i < recyclerView.getChildCount(); i++) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(recyclerView.getChildAt(i));
            if (this.PlaceComponentResult.PlaceComponentResult(childAdapterPosition) != null) {
                String upperCase = this.PlaceComponentResult.PlaceComponentResult(childAdapterPosition).toString().toUpperCase();
                this.moveToNextValue.setText(upperCase);
                if (upperCase != null && (!str.equals(upperCase) || this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(childAdapterPosition))) {
                    View view2 = this.lookAheadTest;
                    canvas.save();
                    if (this.MyBillsEntityDataFactory) {
                        canvas.translate(0.0f, Math.max(0, r2.getTop() - view2.getHeight()));
                    } else {
                        canvas.translate(0.0f, r2.getTop() - view2.getHeight());
                    }
                    view2.draw(canvas);
                    canvas.restore();
                    str = upperCase;
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        if (this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(recyclerView.getChildAdapterPosition(view))) {
            rect.top = this.BuiltInFictitiousFunctionClassFactory;
        }
    }
}

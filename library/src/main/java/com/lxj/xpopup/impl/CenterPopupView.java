package com.lxj.xpopup.impl;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lxj.xpopup.R;
import com.lxj.xpopup.util.Utils;

/**
 * Description: 在中间显示的Popup
 * Create by dance, at 2018/12/8
 */
public class CenterPopupView extends BasePopupView {
    public CenterPopupView(@NonNull Context context) {
        super(context);
    }

    public CenterPopupView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CenterPopupView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int getPopupLayoutId() {
        return R.layout.xpopup_center_popup_view;
    }


    TextView text;

    @Override
    protected void initPopup() {
        limitWidthHeight();

        text = findViewById(R.id.text);
        text.setText("床前明月光，\n疑是地上霜；\n举头望明月，\n低头思故乡。");

        text.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "aa", Toast.LENGTH_LONG).show();
            }
        });


    }

    /**
     * 限制内容的宽高，Center类型的弹窗宽高都有限制，宽高最大为window的90%
     */
    private void limitWidthHeight() {
        post(new Runnable() {
            @Override
            public void run() {
                int maxHeight = (int) (Utils.getWindowHeight(getContext()) * 0.85f);
                int maxWidth = (int) (Utils.getWindowWidth(getContext()) * 0.8f);
                Utils.limitWidthAndHeight(getPopupContentView(), maxWidth, maxHeight);
            }
        });
    }

}

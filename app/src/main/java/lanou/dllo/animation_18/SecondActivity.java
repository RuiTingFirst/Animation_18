package lanou.dllo.animation_18;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by dllo on 16/10/18.
 */
public class SecondActivity extends Activity implements View.OnClickListener {

    private ImageView frameIV;
    private ImageView propertyIV;
    private Button propertyBtn;
    private Button jumpBtn;
    private AnimationDrawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // 帧动画
        // 1. 在drawable包下创建一个xml文件
        // 2. 将节点改成AnimationDrawable --list
        frameIV = (ImageView) findViewById(R.id.iv_frame);
        drawable = (AnimationDrawable) frameIV.getDrawable();
        drawable.start();


        propertyIV = (ImageView) findViewById(R.id.iv_property);
        propertyIV.setImageResource(R.mipmap.tupian_6);
        propertyBtn = (Button) findViewById(R.id.btn_property);
        jumpBtn = (Button) findViewById(R.id.btn_jump);

        propertyIV.setOnClickListener(this);
        propertyBtn.setOnClickListener(this);
        jumpBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.iv_property:

                // 可以让帧动画停止
                drawable.stop();
                Toast.makeText(this, "点我呀", Toast.LENGTH_SHORT).show();

                break;
            // 属性动画: 真正改变了组件的位置, 或者是各种属性
            case R.id.btn_property:

                // 参数1: 想要执行动画的组件
                // 参数2: 这个组件拥有的属性, 想要设置动画的属性
                // 参数3: 类似数组的值 , [];
                ObjectAnimator ota1 = ObjectAnimator.ofFloat(propertyIV, "alpha", 1.0f, 0.8f, 0.7f, 0.5f, 1.0f);
                ota1.setDuration(2000);
                ota1.start();

                ObjectAnimator ota2 = ObjectAnimator.ofFloat(propertyIV, "rotationY", 20, 40, 60, 80, 100, 120, 160, 180, 200, 240,260);
                ota2.setDuration(2000);
                ota2.start();

                ObjectAnimator ota3 = ObjectAnimator.ofFloat(propertyIV, "rotationX", 20, 40, 60, 80, 100, 120, 160, 180, 200, 240,260);
                ota3.setDuration(2000);
                ota3.start();

//                propertyIV.setTranslationX();
                ObjectAnimator ota4 = ObjectAnimator.ofFloat(propertyIV, "translationX", 0, 100, 120, 150, 180, 210, 240, 270, 300, 330, 360, 380, 400);
                ota4.setDuration(2000);
                ota4.start();

                break;
            case R.id.btn_jump:
                Intent intent  = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
                // activity之间跳转的动画
                // 注意: 跳转动画要写在startActivity后面
                overridePendingTransition(R.anim.activity_in, R.anim.activity_out);

                break;
        }
    }
}

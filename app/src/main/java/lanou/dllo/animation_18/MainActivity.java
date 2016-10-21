package lanou.dllo.animation_18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button alpha;
    private Button rotation;
    private Button translation;
    private Button scalse;
    private ImageView iv;
    private Button set;
    private Button xmlBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alpha = (Button) findViewById(R.id.btn_alphon);
        rotation = (Button) findViewById(R.id.btn_rotation);
        translation = (Button) findViewById(R.id.btn_translation);
        scalse = (Button) findViewById(R.id.btn_scale);
        set = (Button) findViewById(R.id.btn_set);
        xmlBtn = (Button) findViewById(R.id.btn_xml);
        iv = (ImageView) findViewById(R.id.iv_main);

        alpha.setOnClickListener(this);
        rotation.setOnClickListener(this);
        translation.setOnClickListener(this);
        scalse.setOnClickListener(this);
        set.setOnClickListener(this);
        xmlBtn.setOnClickListener(this);
        iv.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            // view 动画(补间动画) : 补间动画并不会改变组件的正在位置, 只是对组件的影像进行了动画的调整
            case R.id.btn_alphon:

                // 透明动画
                AlphaAnimation aa = new AlphaAnimation(0, 1);
                // 动画持续时间
                aa.setDuration(2000);
                // 动画重复的次数, 真正执行次数是重复次数加 1
                aa.setRepeatCount(3);

                // 设置动画执行的模式
                aa.setRepeatMode(Animation.REVERSE);
                // 对应想要开启动画的组件, 开启动画
                iv.startAnimation(aa);


                break;
            case R.id.btn_rotation:

                // 旋转动画
                // 参数1, 2 代表开始的角度到结束动画的角度
                // 参数3, 4, 5, 6 代表旋转的轴点 : 对应参数4, 6 的值是从(0% -- 100%(相对容器尺寸大小))
                RotateAnimation ra = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
                ra.setDuration(2000);
                ra.setRepeatCount(3);
                iv.startAnimation(ra);

                break;
            case R.id.btn_translation:

                // 位移的动画
                // 参数1, 2: 代表动画在x轴开始的点
                // 参数3, 4: 代表动画在x轴结束的点(值是0.3 * 父容器的宽, 也结束组件在x轴移动的距离)
                // 参数5, 6: 代表动画在y轴开始的点
                // 参数7, 8: 代表动画在y轴结束的点(值是0.3 * 父容器的高, 也结束组件在y轴移动的距离)
                TranslateAnimation ta = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0,
                        Animation.RELATIVE_TO_PARENT, 0.3f, Animation.RELATIVE_TO_SELF, 0,
                        Animation.RELATIVE_TO_PARENT, 0.3f);
                ta.setRepeatCount(3);
                ta.setDuration(4000);
                // 让组件停留在动画结束的状态
                ta.setFillAfter(true);
                iv.startAnimation(ta);
                break;
            case R.id.btn_scale:

                // 缩放动画
                ScaleAnimation sa = new ScaleAnimation(0, 3, 0, 3);
                sa.setRepeatCount(3);
                sa.setDuration(3000);
                sa.setRepeatMode(Animation.REVERSE);
                iv.startAnimation(sa);
                break;
            case R.id.btn_set:
                AnimationSet set = new AnimationSet(true);

                RotateAnimation ra1 = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF,
                        0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
                ra1.setDuration(3000);
                ra1.setRepeatCount(3);

                TranslateAnimation ta1 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0,
                        Animation.RELATIVE_TO_PARENT, 0.3f, Animation.RELATIVE_TO_SELF, 0,
                        Animation.RELATIVE_TO_PARENT, 0.3f);
                ta1.setRepeatCount(3);
                ta1.setDuration(3000);
                ta1.setFillAfter(true);

                set.addAnimation(ra1);
                set.addAnimation(ta1);

                iv.startAnimation(set);

                break;
            case R.id.btn_xml:
                // XML实现补间动画
                /**
                 * 1. 在res -> 创建一个包: 包名: anim
                 * 2. 在anim包下创建一个 xml动画文件
                 * 3. 通过AnimationUtils获取到这个xml的动画文件
                 * 4. 开启组件的动画效果
                 */
                Animation animation = AnimationUtils.loadAnimation(this, R.anim.imageanim);
                iv.startAnimation(animation);
                break;
            case R.id.iv_main:

                Toast.makeText(this, "点我呀", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

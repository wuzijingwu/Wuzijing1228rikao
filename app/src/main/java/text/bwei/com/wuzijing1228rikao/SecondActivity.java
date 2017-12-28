package text.bwei.com.wuzijing1228rikao;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private SimpleDraweeView sed;
    private SimpleDraweeView sdv_fresco_gif;
    /**
     * 请求gif图片
     */
    private Button bt_fresco_askImg;
    /**
     * 动画停止
     */
    private Button bt_fresco_stopAnim;
    /**
     * 动画开始
     */
    private Button bt_fresco_startAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_second);
        initView();
        Uri imgUrl = Uri.parse("http://img5.imgtn.bdimg.com/it/u=217223117,1861622754&fm=27&gp=0.jpg");
//                SimpleDraweeView urlImg = (SimpleDraweeView) findViewById(R.id.sdv_image_url);
        sed.setImageURI(imgUrl);

        Uri uri = Uri.parse("http://s15.sinaimg.cn/mw690/0062ywFUgy6Y2pBSx1sde&690");

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(false)
                .setOldController(sdv_fresco_gif.getController())
                .build();

        sdv_fresco_gif.setController(controller);

    }

    private void initView() {
        sed = (SimpleDraweeView) findViewById(R.id.sed);
        sed.setOnClickListener(this);
        sdv_fresco_gif = (SimpleDraweeView) findViewById(R.id.sdv_fresco_gif);
        sdv_fresco_gif.setOnClickListener(this);
//        bt_fresco_askImg = (Button) findViewById(R.id.bt_fresco_askImg);
//        bt_fresco_askImg.setOnClickListener(this);
        bt_fresco_stopAnim = (Button) findViewById(R.id.bt_fresco_stopAnim);
        bt_fresco_stopAnim.setOnClickListener(this);
        bt_fresco_startAnim = (Button) findViewById(R.id.bt_fresco_startAnim);
        bt_fresco_startAnim.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;










            case R.id.bt_fresco_stopAnim:
                Animatable animatable = sdv_fresco_gif.getController().getAnimatable();

                if (animatable != null && animatable.isRunning()) {
                    animatable.stop();
                }

                break;
            case R.id.bt_fresco_startAnim:
                Animatable animatable1 = sdv_fresco_gif.getController().getAnimatable();

                if (animatable1 != null && !animatable1.isRunning()) {
                    animatable1.start();
                }
                break;
        }
    }
}

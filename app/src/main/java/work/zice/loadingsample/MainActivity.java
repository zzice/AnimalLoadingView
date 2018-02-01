package work.zice.loadingsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import work.zice.loadingview.AnimalLoadingView;

/**
 * @desc
 * @date 2018/02/01
 * @author Zice
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.start_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimalLoadingView loadingView = new AnimalLoadingView();
                loadingView.setMsgText("Google大法好");
                loadingView.show(getSupportFragmentManager(),"");
            }
        });
    }
}

package github.tornaco.complexspansample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import github.tornaco.span.ComplexSpan;
import github.tornaco.span.WeiboSpanHandlerProvider;

public class MainActivity extends AppCompatActivity {

    static final String SOURCE_1 = "#Topic# The fox jump over the lazy @dog [smile] " +
            "13288888888 " +
            "http://t.cn/RpaDggX and http://t.cn/RpaDggY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(ComplexSpan.apply(new WeiboSpanHandlerProvider(getApplicationContext(), textView) {
            @Override
            public void onTopicClick(String topic) {
                Toast.makeText(getApplicationContext(), "onTopicClick:" + topic, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onUrlClick(String url) {
                Toast.makeText(getApplicationContext(), "onUrlClick:" + url, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onATClick(String who) {
                Toast.makeText(getApplicationContext(), "onATClick:" + who, Toast.LENGTH_SHORT).show();
            }

            @Override
            public Emoji getFromEmojiString(@NonNull String emojiString) {
                return new Emoji(R.drawable.d_hehe, emojiString);
            }
        }, SOURCE_1));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

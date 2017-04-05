package aleul850.passwordstrengthmeter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //The component is created, along with an attached progressbar and textview
        PasswordStrengthMeter passwordStrengthMeter = (PasswordStrengthMeter) findViewById(R.id.psm);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
        TextView progress = (TextView) findViewById(R.id.progress);
        StrengthAlgorithm strengthAlgorithm = new StrengthAlgorithm();
        passwordStrengthMeter.setStrengthAlgorithm(strengthAlgorithm);
        passwordStrengthMeter.setViews(progressBar, progress);
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

package linkopinghackers.passwordtest;

import android.support.v7.app.AppCompatActivity;
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
}

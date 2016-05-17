package net.infojobs.siestatracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import net.infojobs.siestatracker.domain.ObtainLastSiestaDateInteractor;
import net.infojobs.siestatracker.domain.SiestaDataSource;

public class MainActivity extends AppCompatActivity implements SiestaPresenter.View {

    private TextView lastDateText;

    private SiestaPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lastDateText = ((TextView) findViewById(R.id.last_date_text));

        SiestaDataSource siestaDataSource = new MemorySiestaDataSource();
        ObtainLastSiestaDateInteractor obtainLastSiestaDateInteractor = new ObtainLastSiestaDateInteractor(siestaDataSource);
        presenter = new SiestaPresenter(obtainLastSiestaDateInteractor);

        presenter.initialize(this);
    }

    @Override
    public void showLastSiestaDate(String lastDate) {
        lastDateText.setText(lastDate);
    }
}

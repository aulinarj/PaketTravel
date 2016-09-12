package id.sch.smktelkom_mlg.tugas1.xirpl5005.pakettavel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etEmail, etNomer, kursi;
    Button bPesan;
    TextView hasil, hasilRg, hasilCB, hasilSp, hasilSpT, jumlah;
    CheckBox Makan, Snack, Inap, Guide;
    Spinner asal, tujuan;
    RadioButton rbEko, rbBis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNama = (EditText) findViewById(R.id.editTextNama);
        etEmail = (EditText) findViewById(R.id.editTextEmail);
        etNomer = (EditText) findViewById(R.id.editTextNomer);
        bPesan = (Button) findViewById(R.id.buttonPesan);
        hasil = (TextView) findViewById(R.id.tvHasil1);
        hasilRg = (TextView) findViewById(R.id.textViewRg);
        hasilCB = (TextView) findViewById(R.id.textViewCB);
        hasilSp = (TextView) findViewById(R.id.textViewSpinner);
        hasilSpT = (TextView) findViewById(R.id.textViewSpinnerTujuan);
        jumlah = (TextView) findViewById(R.id.textViewJumlah);
        Makan = (CheckBox) findViewById(R.id.checkBoxMakan);
        Snack = (CheckBox) findViewById(R.id.checkBoxSnack);
        Inap = (CheckBox) findViewById(R.id.checkBoxInap);
        Guide = (CheckBox) findViewById(R.id.checkBoxGuide);
        asal = (Spinner) findViewById(R.id.spinnerAsal);
        tujuan = (Spinner) findViewById(R.id.spinnerTujuan);
        kursi = (EditText) findViewById(R.id.editTextKursi);
        rbEko = (RadioButton) findViewById(R.id.radioButtonEko);
        rbBis = (RadioButton) findViewById(R.id.radioButtonBis);


        bPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClickCB();
                doProcces();
                doClickSp();
                doSpinner();
                dojumlah();

            }

            private void dojumlah() {
                String jenis = null;
                if (rbBis.isChecked()) {
                    jenis = rbBis.getText().toString();
                } else if (rbEko.isChecked()) {
                    jenis = rbEko.getText().toString();

                }
                if (jenis == null) {
                    jumlah.setText("Jenis Travel yang anda pilih : " + jenis);
                } else {
                    jumlah.setText("Belum memilih jenis Travel");
                }

            }

            private void doSpinner() {

                hasilSpT.setText("Tujuan :" + tujuan.getSelectedItem().toString());
            }

            private void doClickSp() {
                hasilSp.setText("Asal : " + asal.getSelectedItem().toString());
            }

            private void doProcces() {
                if (isValid()) {
                String nama = etNama.getText().toString();
                String email = etEmail.getText().toString();
                int tlp = Integer.parseInt(etNomer.getText().toString());

                hasil.setText("Anda sudah memesan Travel " +
                        "\n Atas nama : " + nama
                        + " \nEmail : " + email
                        + "\nNomer Telepon : " + tlp

                );
                }
            }
            private boolean isValid() {
                boolean valid = true;

                String nama = etNama.getText().toString();
                String nomer = etNomer.getText().toString();
                String email = etEmail.getText().toString();

                if (nama.isEmpty()) {
                    etNama.setError("Nama Belum diisi");
                    valid = false;
                } else if (nama.length() < 3) {
                    etNama.setError("Nama minimal 3 karakter");
                    valid = false;
                } else {
                    etNama.setError(null);
                }
                if (nomer.isEmpty()) {
                    etNomer.setError("Nomer HP belum diisi");
                    valid = false;
                } else if (nomer.length() < 7) {
                    etNomer.setError("Nomer HP minimal 7 angka");
                    valid = false;
                } else {
                    etNomer.setError(null);
                }
                if (email.isEmpty()) {
                    etEmail.setError("Email anda belum diisi");
                } else {
                    etEmail.setError(null);
                }
                return valid;
            }

            private void doClickCB() {
                String cb = "Paket tambahan yang anda pilih : ";
                int starlen = cb.length();
                if (Makan.isChecked()) cb += Makan.getText() + "\n";
                if (Snack.isChecked()) cb += Snack.getText() + "\n";
                if (Inap.isChecked()) cb += Inap.getText() + "\n";
                if (Guide.isChecked()) cb += Guide.getText() + "\n";
                if (cb.length() == starlen) cb += "Tidak ada pilihan terpilih";
                hasilCB.setText("" + cb);
            }
        });
    }
}


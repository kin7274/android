package kr.co.company.buttonevent1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends Activity  implements OnClickListener {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button = (Button) findViewById(R.id.button);
		button.setOnClickListener(this);
	}
	
	public void onClick(View v) {
		Toast.makeText(getApplicationContext(), "��ư�� ���������ϴ�", Toast.LENGTH_SHORT).show();
	}
}
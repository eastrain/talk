package easemob.liaoliao.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import easemob.liaoliao.R;

public class EditActivity extends BaseActivity{
	private EditText editText;

	@Override
	public int getLayoutId() {
		return R.layout.activity_edit;
	}

	@Override
	public void initViewId() {
		editText = (EditText) findViewById(R.id.edittext);
	}

	@Override
	public void setUpView() {
		String title = getIntent().getStringExtra("title");
		String data = getIntent().getStringExtra("data");
		if(title != null)
			((TextView)findViewById(R.id.tv_title)).setText(title);
		if(data != null)
			editText.setText(data);
		editText.setSelection(editText.length());
	}


	public void save(View view){
		setResult(RESULT_OK,new Intent().putExtra("data", editText.getText().toString()));
		finish();
	}

	@Override
	public void onClick(View v) {

	}
}
